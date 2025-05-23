package com.tencent.mobileqq.troop.troopgame.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardManager;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGameCardServiceImpl implements ITroopGameCardService {
    static IPatchRedirector $redirector_ = null;
    private static final String GAME_GRADE_LEVEL_ICON_FILE_NAME_PREFIX = "aio_game_grade_";
    private static final int HIGHEST_GRADE_LEVEL = 8;
    private static final int MUTEX_COUNT = 8;
    public static final String TAG = "TroopGameCardServiceImpl";
    private AppRuntime mAppRuntime;
    private final Map<String, Queue<WeakReference<Consumer<Drawable>>>> mDecodeCallbackMap;
    private final Object mutex;

    public TroopGameCardServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDecodeCallbackMap = new HashMap();
            this.mutex = new Object();
        }
    }

    private void addBitmapToCache(String str, Bitmap bitmap) {
        if (bitmap != null) {
            ImageCacheHelper.f98636a.i(str, bitmap, Business.AIO);
        }
    }

    private void addToDecodeCallbackQueue(@NonNull Consumer<Drawable> consumer, String str) {
        boolean z16;
        synchronized (this.mutex) {
            Queue<WeakReference<Consumer<Drawable>>> queue = this.mDecodeCallbackMap.get(str);
            if (queue == null) {
                queue = new ConcurrentLinkedQueue<>();
                this.mDecodeCallbackMap.put(str, queue);
                z16 = true;
            } else {
                z16 = false;
            }
            queue.offer(new WeakReference<>(consumer));
        }
        if (z16) {
            decodeInSubThread(str);
        }
    }

    private void afterDecode(String str, Bitmap bitmap) {
        Queue<WeakReference<Consumer<Drawable>>> remove;
        BitmapDrawable bitmapDrawable;
        Consumer<Drawable> consumer;
        synchronized (this.mutex) {
            remove = this.mDecodeCallbackMap.remove(str);
        }
        if (remove == null) {
            return;
        }
        if (bitmap != null) {
            bitmapDrawable = new BitmapDrawable(bitmap);
        } else {
            bitmapDrawable = null;
        }
        for (WeakReference<Consumer<Drawable>> weakReference : remove) {
            if (weakReference != null) {
                consumer = weakReference.get();
            } else {
                consumer = null;
            }
            if (consumer != null) {
                consumer.accept(bitmapDrawable);
            }
        }
    }

    private static Bitmap decodeBitmapFromFile(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private void decodeInSubThread(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopgame.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopGameCardServiceImpl.this.lambda$decodeInSubThread$0(str);
            }
        }, 80, null, false);
    }

    private static Bitmap getBitmapFromGlobalCache(String str) {
        return ImageCacheHelper.f98636a.f(str);
    }

    private static String getGradeLevelResPathByLevel(int i3) {
        if (i3 <= 0) {
            return null;
        }
        int i16 = i3 / 100000;
        int i17 = (i3 % 100000) / 10000;
        String troopGameCardResDownloadPath = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
        if (TextUtils.isEmpty(troopGameCardResDownloadPath)) {
            QLog.e(TAG, 1, "getGradeLevelRes|resPath is null");
            return null;
        }
        String majorGradeID = getMajorGradeID(i16, i17, troopGameCardResDownloadPath + GAME_GRADE_LEVEL_ICON_FILE_NAME_PREFIX);
        if (TextUtils.isEmpty(majorGradeID)) {
            return null;
        }
        if (i16 != 8) {
            majorGradeID = getSecondGradeLevel(i17, majorGradeID + "_");
            if (TextUtils.isEmpty(majorGradeID)) {
                return null;
            }
        }
        return majorGradeID + ".png";
    }

    private static String getMajorGradeID(int i3, int i16, String str) {
        switch (i3) {
            case 2:
                return str + "1";
            case 3:
                return str + "2";
            case 4:
                return str + "3";
            case 5:
                return str + "4";
            case 6:
                return str + "5";
            case 7:
                return str + "6";
            case 8:
                if (i16 > 5) {
                    return str + "8";
                }
                return str + "7";
            default:
                return null;
        }
    }

    private static String getSecondGradeLevel(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            switch (i3) {
                case 5:
                    return str + "5";
                case 6:
                    return str + "4";
                case 7:
                    return str + "3";
                case 8:
                    return str + "2";
                case 9:
                    return str + "1";
                default:
                    return str + "1";
            }
        }
        return str;
    }

    private TroopGameCardManager getTroopGameCardManager() {
        IManagerFactoryService iManagerFactoryService = (IManagerFactoryService) this.mAppRuntime.getRuntimeService(IManagerFactoryService.class, "");
        if (iManagerFactoryService != null) {
            return (TroopGameCardManager) iManagerFactoryService.getManager(TroopGameCardManager.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeInSubThread$0(String str) {
        Bitmap decodeBitmapFromFile = decodeBitmapFromFile(str);
        addBitmapToCache(str, decodeBitmapFromFile);
        afterDecode(str, decodeBitmapFromFile);
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService
    @Nullable
    public Drawable getDrawableByGameGradeLevel(int i3, @Nullable Consumer<Drawable> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) consumer);
        }
        String gradeLevelResPathByLevel = getGradeLevelResPathByLevel(i3);
        if (gradeLevelResPathByLevel == null) {
            return null;
        }
        Bitmap bitmapFromGlobalCache = getBitmapFromGlobalCache(gradeLevelResPathByLevel);
        if (bitmapFromGlobalCache != null) {
            return new BitmapDrawable(bitmapFromGlobalCache);
        }
        if (consumer == null) {
            return null;
        }
        addToDecodeCallbackQueue(consumer, gradeLevelResPathByLevel);
        return null;
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService
    public void getMemberGradeLevelInfoAsync(String str, ITroopGameCardService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        TroopGameCardManager troopGameCardManager = getTroopGameCardManager();
        if (troopGameCardManager != null) {
            troopGameCardManager.e(str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService
    public boolean isNewCardEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) this.mAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            if (iFeatureRuntimeService == null) {
                return false;
            }
            boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable(ITroopGameCardService.GAME_PROFILE_NEW_SWITCH, false);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "isNewCardEnable isEnable: " + isFeatureSwitchEnable);
            }
            return isFeatureSwitchEnable;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return false;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mDecodeCallbackMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService
    public void saveMemberGradeLevelInfo(MemberGradeLevelInfo memberGradeLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) memberGradeLevelInfo);
            return;
        }
        TroopGameCardManager troopGameCardManager = getTroopGameCardManager();
        if (troopGameCardManager != null) {
            troopGameCardManager.h(memberGradeLevelInfo);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService
    @Nullable
    public MemberGradeLevelInfo tryGetMemberGradeLevelInfo(String str, ITroopGameCardService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MemberGradeLevelInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) aVar);
        }
        TroopGameCardManager troopGameCardManager = getTroopGameCardManager();
        if (troopGameCardManager != null) {
            return troopGameCardManager.i(str, aVar);
        }
        return null;
    }
}

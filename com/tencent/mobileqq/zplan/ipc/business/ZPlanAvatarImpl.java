package com.tencent.mobileqq.zplan.ipc.business;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor;
import com.tencent.mobileqq.zplan.avatar.api.impl.ZPlanAvatarVideoProcessorImpl;
import com.tencent.mobileqq.zplan.friend.ZPlanFriendAvatarUtil;
import com.tencent.mobileqq.zplan.friend.ZPlanFriendImageUtil;
import com.tencent.mobileqq.zplan.ipc.business.a;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.mobileqq.zplan.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import t74.r;

/* loaded from: classes34.dex */
public class ZPlanAvatarImpl implements com.tencent.mobileqq.zplan.ipc.business.a {
    public static final float RECORD_FRAME_TIME = ZPlanFeatureSwitch.f369852a.O2();
    private static final String TAG = "[zplan]CmShowUEAvatarImpl";
    private HashMap<MemeAction, com.tencent.zplan.meme.a> staticAvatarCallbackMap = new HashMap<>();
    private HashMap<MemeAction, com.tencent.zplan.meme.a> dynamicAvatarCallbackMap = new HashMap<>();

    private IZPlanAvatarVideoProcessor createVideoProcessor(QQAppInterface qQAppInterface, IZPlanAvatarVideoProcessor.a aVar) {
        ZPlanAvatarVideoProcessorImpl zPlanAvatarVideoProcessorImpl = new ZPlanAvatarVideoProcessorImpl();
        zPlanAvatarVideoProcessorImpl.init(qQAppInterface);
        zPlanAvatarVideoProcessorImpl.setProcessFinishListener(aVar);
        return zPlanAvatarVideoProcessorImpl;
    }

    private QQAppInterface getAppInterface() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private void handleDynamicAvatar(int i3, final boolean z16, int i16, final a.InterfaceC9181a interfaceC9181a, QQAppInterface qQAppInterface) {
        processAvatarVideo(qQAppInterface, createVideoProcessor(qQAppInterface, new IZPlanAvatarVideoProcessor.a(z16, interfaceC9181a) { // from class: com.tencent.mobileqq.zplan.ipc.business.g

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f333769a;

            @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor.a
            public final void a(boolean z17, int i17, String str) {
                ZPlanAvatarImpl.lambda$handleDynamicAvatar$0(this.f333769a, null, z17, i17, str);
            }
        }), i3, i16);
    }

    private void handleStaticAvatar(String str, int i3, boolean z16, a.InterfaceC9181a interfaceC9181a, QQAppInterface qQAppInterface) {
        ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).getSingleFrameFile(i3, str, new a(qQAppInterface, z16, interfaceC9181a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUserAvatar$3(File file, a.b bVar, String str, Bitmap bitmap) {
        if (file.exists()) {
            if (bVar != null) {
                bVar.onResult(true, file.getAbsolutePath());
            }
            QLog.i("ZPlanSameStyle", 1, "file exists uin: " + str);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            QLog.e("ZPlanSameStyle", 1, e16, new Object[0]);
        }
        QLog.i("ZPlanSameStyle", 1, "create file success: " + str);
        if (bVar != null) {
            if (file.exists()) {
                bVar.onResult(true, file.getAbsolutePath());
            } else {
                bVar.onResult(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleDynamicAvatar$0(boolean z16, a.InterfaceC9181a interfaceC9181a, boolean z17, int i3, String str) {
        QLog.i(TAG, 1, "handleSetAvatar isDynamic: " + z16 + " isSuccess:" + z17 + " actionId:" + i3 + " coverPath:" + str);
        interfaceC9181a.a(z17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$requestSingleRequestResource$5(a.d dVar, String str, int i3, long j3, ZPlanRecordResource zPlanRecordResource) {
        String valueOf;
        Object obj;
        String str2 = "1";
        if (zPlanRecordResource == null) {
            valueOf = "";
            dVar.onResult("", "");
            obj = "0";
        } else {
            dVar.onResult(zPlanRecordResource.getKey(), zPlanRecordResource.getLocalPath());
            valueOf = String.valueOf(zPlanRecordResource.getSource());
            obj = "1";
        }
        if ("{}".equals(str)) {
            str2 = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action_id", String.valueOf(i3));
        hashMap.put("use_avatar_character", str2);
        hashMap.put("is_succ", obj);
        hashMap.put("source", valueOf);
        hashMap.put("time_cost", String.valueOf(System.currentTimeMillis() - j3));
        r.d("0AND0YAG6R40RLM6", "zplan_js_record_end", hashMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$saveUserRoleImage$2(a.e eVar, Boolean bool, String str) {
        eVar.a(bool.booleanValue(), str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setAvatarByUrl$1(String str, a.InterfaceC9181a interfaceC9181a, int i3, boolean z16, int i16, String str2) {
        QLog.i(TAG, 1, "handleSetAvatarByUrl: " + str + " isSuccess:" + z16);
        interfaceC9181a.a(z16, str);
        if (z16) {
            try {
                QLog.i(TAG, 1, "UE4.dressCostume:" + i3);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "handleSetAvatarByUrl: UE4.dressCostume exception", th5);
            }
        }
    }

    private void processAvatarVideo(QQAppInterface qQAppInterface, IZPlanAvatarVideoProcessor iZPlanAvatarVideoProcessor, int i3, int i16) {
        kf3.c cVar = new kf3.c();
        cVar.f412297a = i3;
        cVar.f412298b = i16;
        iZPlanAvatarVideoProcessor.process(cVar);
    }

    private void processAvatarVideoByUrl(IZPlanAvatarVideoProcessor iZPlanAvatarVideoProcessor, String str, String str2) {
        kf3.b bVar = new kf3.b();
        bVar.f412295a = str2;
        bVar.f412296b = str;
        iZPlanAvatarVideoProcessor.process(bVar);
    }

    private void recordDynamicAvatar(String str, int i3, int i16, int i17, a.c cVar) {
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(i3, -1, i16, i17, MODE.GIF, str);
        memeZPlanAction.getConfig().y(ah.f335763c);
        b bVar = new b(memeZPlanAction, i3, cVar);
        this.dynamicAvatarCallbackMap.put(memeZPlanAction, bVar);
        ((IMemeHelper) QRoute.api(IMemeHelper.class)).recordAction(memeZPlanAction, bVar);
    }

    private void recordStaticAvatar(String str, int i3, int i16, int i17, a.c cVar) {
        IMemeHelper iMemeHelper = (IMemeHelper) QRoute.api(IMemeHelper.class);
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(i3, -1, i16, i17, MODE.FRAME, str);
        memeZPlanAction.getConfig().y(ah.f335763c);
        memeZPlanAction.getConfig().C(BusinessConfig.FrameType.JPG);
        memeZPlanAction.setFrameTime(iMemeHelper.adapterToBrickFrameInterval(RECORD_FRAME_TIME));
        c cVar2 = new c(memeZPlanAction, i3, cVar);
        this.staticAvatarCallbackMap.put(memeZPlanAction, cVar2);
        iMemeHelper.recordAction(memeZPlanAction, cVar2);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.business.a
    public void getUserAvatar(final String str, final a.b bVar) {
        File file = new File(BaseApplication.context.getCacheDir(), "cmshow/avatars");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, str + ".png");
        if (file2.exists()) {
            QLog.i("ZPlanSameStyle", 1, "find avatar in disk: ${file.absolutePath}");
            if (bVar != null) {
                bVar.onResult(true, file2.getAbsolutePath());
                return;
            }
            return;
        }
        ZPlanFriendAvatarUtil.f333661d.a(str, new Function1() { // from class: com.tencent.mobileqq.zplan.ipc.business.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$getUserAvatar$4;
                lambda$getUserAvatar$4 = ZPlanAvatarImpl.lambda$getUserAvatar$4(a.b.this, file2, str, (Bitmap) obj);
                return lambda$getUserAvatar$4;
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.ipc.business.a
    public void saveUserRoleImage(String str, final a.e eVar) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "onRemoteInvoke cannot get QQAppInterface");
        } else {
            ZPlanFriendImageUtil.f333664a.e(str, (QQAppInterface) runtime, new Function2() { // from class: com.tencent.mobileqq.zplan.ipc.business.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$saveUserRoleImage$2;
                    lambda$saveUserRoleImage$2 = ZPlanAvatarImpl.lambda$saveUserRoleImage$2(a.e.this, (Boolean) obj, (String) obj2);
                    return lambda$saveUserRoleImage$2;
                }
            });
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).onAvatarChange();
        }
    }

    public void setAvatar(String str, int i3, boolean z16, int i16, a.InterfaceC9181a interfaceC9181a) {
        QQAppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "onRemoteInvoke cannot get QQAppInterface");
        } else if (z16) {
            handleDynamicAvatar(i3, z16, i16, interfaceC9181a, appInterface);
        } else {
            handleStaticAvatar(str, i3, z16, interfaceC9181a, appInterface);
        }
    }

    public void setAvatarByUrl(final String str, String str2, final int i3, final a.InterfaceC9181a interfaceC9181a) {
        QQAppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "onRemoteInvoke cannot get QQAppInterface");
        } else {
            processAvatarVideoByUrl(createVideoProcessor(appInterface, new IZPlanAvatarVideoProcessor.a(str, interfaceC9181a, i3) { // from class: com.tencent.mobileqq.zplan.ipc.business.k

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f333777a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ int f333778b;

                {
                    this.f333778b = i3;
                }

                @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor.a
                public final void a(boolean z16, int i16, String str3) {
                    ZPlanAvatarImpl.lambda$setAvatarByUrl$1(this.f333777a, null, this.f333778b, z16, i16, str3);
                }
            }), str, str2);
        }
    }

    public void requestSingleRequestResource(final int i3, String str, int i16, int i17, String str2, int i18, long j3, final String str3, String str4, final a.d dVar) {
        QLog.i(TAG, 1, "requestSingleRequestResource");
        MODE b16 = com.tencent.mobileqq.zplan.web.c.f336037a.b(str2);
        final long currentTimeMillis = System.currentTimeMillis();
        ((IMemeHelper) QRoute.api(IMemeHelper.class)).recordSingleActionByResourceCenterWithTimeout(i3, str, i16, i17, b16, i18, j3, str3, str4, new Function1(dVar, str3, i3, currentTimeMillis) { // from class: com.tencent.mobileqq.zplan.ipc.business.j

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f333774d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f333775e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ long f333776f;

            {
                this.f333774d = str3;
                this.f333775e = i3;
                this.f333776f = currentTimeMillis;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$requestSingleRequestResource$5;
                lambda$requestSingleRequestResource$5 = ZPlanAvatarImpl.lambda$requestSingleRequestResource$5(null, this.f333774d, this.f333775e, this.f333776f, (ZPlanRecordResource) obj);
                return lambda$requestSingleRequestResource$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements IZPlanAvatarFileManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f333750a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f333751b;

        a(QQAppInterface qQAppInterface, boolean z16, a.InterfaceC9181a interfaceC9181a) {
            this.f333750a = qQAppInterface;
            this.f333751b = z16;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager.a
        public void a(boolean z16, List<String> list, int i3) {
            boolean z17 = false;
            if (z16 && list != null && list.size() > 0) {
                z17 = ProfileCardUtil.h0(this.f333750a, list.get(0), new Intent());
            }
            QLog.i(ZPlanAvatarImpl.TAG, 1, "handleSetAvatar isDynamic: " + this.f333751b + " isSuccess:" + z17);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$getUserAvatar$4(final a.b bVar, final File file, final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            QLog.i("ZPlanSameStyle", 1, "save avatar path = " + file.getAbsolutePath());
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.ipc.business.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanAvatarImpl.lambda$getUserAvatar$3(file, bVar, str, bitmap);
                }
            });
        } else if (bVar != null) {
            bVar.onResult(false, null);
        }
        return Unit.INSTANCE;
    }

    public void recordAction(String str, int i3, boolean z16, int i16, int i17, int i18, a.c cVar) {
        if (z16) {
            recordDynamicAvatar(str, i3, i17, i18, cVar);
        } else {
            recordStaticAvatar(str, i3, i17, i18, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements com.tencent.zplan.meme.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MemeAction f333753d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f333754e;

        b(MemeAction memeAction, int i3, a.c cVar) {
            this.f333753d = memeAction;
            this.f333754e = i3;
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean z16, MemeResult memeResult) {
            ZPlanAvatarImpl.this.dynamicAvatarCallbackMap.remove(this.f333753d);
            QLog.i(ZPlanAvatarImpl.TAG, 1, "recordDynamicAvatar onRecordDone portraitId:" + this.f333754e + " success:" + z16 + " " + memeResult.getRecordPath() + " key: " + memeResult.getRecordKey() + " map size:" + ZPlanAvatarImpl.this.dynamicAvatarCallbackMap.size());
            throw null;
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(MemeAction memeAction, float f16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements com.tencent.zplan.meme.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MemeAction f333756d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f333757e;

        c(MemeAction memeAction, int i3, a.c cVar) {
            this.f333756d = memeAction;
            this.f333757e = i3;
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean z16, MemeResult memeResult) {
            ZPlanAvatarImpl.this.staticAvatarCallbackMap.remove(this.f333756d);
            QLog.i(ZPlanAvatarImpl.TAG, 1, "recordStaticAvatar onRecordDone actionId:" + this.f333757e + " success:" + z16 + " " + memeResult.getRecordPath() + " key: " + memeResult.getRecordKey() + " map size:" + ZPlanAvatarImpl.this.staticAvatarCallbackMap.size());
            throw null;
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(MemeAction memeAction, float f16) {
        }
    }
}

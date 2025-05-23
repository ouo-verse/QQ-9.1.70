package com.tencent.av.utils.api.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.enrique.stackblur.StackBlurManager;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.n;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.w;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.af;
import com.tencent.av.utils.am;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.util.LiuHaiUtils;
import common.config.service.QzoneConfig;
import ew.b;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.slf4j.Marker;
import wy2.c;
import wy2.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class UIToolsApiImpl extends AVCoreUtil implements IUIToolsApi {
    private static final String SHARED_PREF_KEY_HAS_SHOW_SVIP_DIALOG = "has_show_svip_dialog";
    private static final String TAG = "UIToolsApiImpl";
    private Boolean mCanShowAudioShareTips;
    private volatile Boolean mDPCUseSurfaceMode;
    private Boolean mHasShowDialog;
    private Boolean mHasShowPressSpeakerModeFirstGuider;
    private Boolean mHasShowPressSpeakerModeSecondGuider;
    private volatile Boolean mPostRenderUseShader;
    private volatile Boolean mRenderUseSurfaceMode;
    private Boolean sHasRoundedInScreen;
    private static a<String, Drawable> mGaussianAvatarDrawableCache = new a<>(Business.Default, "GaussianAvatarDrawable", 10);
    private static ArrayList<String> mFaceCachedKeys = new ArrayList<>();

    public UIToolsApiImpl() {
        Boolean bool = Boolean.TRUE;
        this.mRenderUseSurfaceMode = bool;
        this.mHasShowPressSpeakerModeFirstGuider = bool;
        this.mHasShowPressSpeakerModeSecondGuider = bool;
        this.sHasRoundedInScreen = null;
    }

    private static void addDrawableToCache(Drawable drawable, String str) {
        synchronized (mFaceCachedKeys) {
            mFaceCachedKeys.add(str);
        }
        synchronized (mGaussianAvatarDrawableCache) {
            mGaussianAvatarDrawableCache.f(str, drawable);
        }
    }

    public static void clearCache(String str) {
        ArrayList arrayList;
        synchronized (mFaceCachedKeys) {
            Iterator<String> it = mFaceCachedKeys.iterator();
            arrayList = null;
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains(str)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                    }
                    arrayList.add(next);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            String str2 = (String) it5.next();
            synchronized (mGaussianAvatarDrawableCache) {
                mGaussianAvatarDrawableCache.g(str2);
            }
        }
    }

    private static Drawable getDrawableFromCache(String str) {
        Drawable e16;
        synchronized (mGaussianAvatarDrawableCache) {
            e16 = mGaussianAvatarDrawableCache.e(str);
        }
        return e16;
    }

    public static String getGaussianBgCacheKey(ew.a aVar) {
        return "qav_gaussian_bg_" + aVar.f397248b + "_" + aVar.f397247a + "_" + aVar.f397251e + "_" + aVar.f397252f;
    }

    private static void handle50Gaussian(BaseApplication baseApplication, ew.a aVar, Bitmap bitmap, b bVar) {
        Drawable bitmapDrawable;
        Bitmap scaleDown = scaleDown(bitmap, aVar);
        if (scaleDown == null) {
            return;
        }
        Bitmap process = new StackBlurManager(scaleDown).process(25);
        if (process == null) {
            QLog.e(TAG, 1, "handle50Gaussian create blur bitmap failed!");
            return;
        }
        if (aVar.f397251e > 0 && aVar.f397252f > 0) {
            bitmapDrawable = new w(process, ba.dp2px(baseApplication.getApplicationContext(), 15.0f), aVar.f397251e, aVar.f397252f);
        } else {
            bitmapDrawable = new BitmapDrawable(baseApplication.getResources(), process);
        }
        if (bVar != null) {
            bVar.D1(aVar, bitmapDrawable);
        }
        addDrawableToCache(bitmapDrawable, getGaussianBgCacheKey(aVar));
    }

    private boolean openMIUIPermissionActivity(Activity activity, String str) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", str);
        boolean startActivityChecked = startActivityChecked(activity, intent);
        if (!startActivityChecked) {
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            startActivityChecked = startActivityChecked(activity, intent);
        }
        if (startActivityChecked) {
            return startActivityChecked;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.RealAppPermissionsEditorActivity");
        return startActivityChecked(activity, intent);
    }

    private boolean startActivityChecked(Activity activity, Intent intent) {
        if (isIntentAvailable(activity, intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e16) {
                QLog.e(TAG, 2, "startActivityChecked: intent=" + intent, e16);
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void avLog(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2);
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int avRalationType2DAVRelationType(int i3) {
        if (i3 == 1) {
            return 3;
        }
        int i16 = 2;
        if (i3 != 2) {
            if (i3 != 3) {
                i16 = 4;
                if (i3 != 4) {
                    if (i3 != 100) {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return i16;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int avRelationType2UinType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 7) {
                    switch (i3) {
                        case 9:
                            return 1011;
                        case 10:
                        case 11:
                            return 1;
                        default:
                            return -1;
                    }
                }
                return 1011;
            }
            return 0;
        }
        return 3000;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean canShowAudioShareTips() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Boolean bool = this.mCanShowAudioShareTips;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).getBoolean("audio_share_pref_key", true));
        this.mCanShowAudioShareTips = valueOf;
        return valueOf.booleanValue();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void cancelSetPermission(Activity activity, AppInterface appInterface) {
        boolean booleanExtra = activity.getIntent().getBooleanExtra("is_video", false);
        String currentAccountUin = appInterface.getCurrentAccountUin();
        SmallScreenUtils.C(currentAccountUin, SmallScreenUtils.k(currentAccountUin, booleanExtra) + 1, booleanExtra);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void clearAudioShareTipsFlag() {
        Boolean bool = this.mCanShowAudioShareTips;
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        this.mCanShowAudioShareTips = Boolean.FALSE;
        ea.i(BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).edit().putBoolean("audio_share_pref_key", false));
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void doScreenShareReport(String str) {
        doScreenShareReport(str, n.e().f().f73035i);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public float dp2px(Context context, float f16) {
        return (f16 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public Bitmap drawBitmapCoverLayer(Bitmap bitmap, String str, boolean z16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
                Canvas canvas = new Canvas(createBitmap);
                if (canvas.getDensity() != bitmap.getDensity()) {
                    canvas.setDensity(bitmap.getDensity());
                }
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                paint.setColor(Color.parseColor(str));
                RectF rectF = new RectF(0.0f, 0.0f, width, height);
                if (z16) {
                    canvas.drawRoundRect(rectF, width / 2, height / 2, paint);
                } else {
                    canvas.drawRect(rectF, paint);
                }
                return createBitmap;
            }
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(e16));
            }
        }
        return bitmap;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean equals(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        if (str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str2 = str2.substring(1);
        }
        return str.equals(str2);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getAudioShareBgResId() {
        return R.drawable.io5;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getAudioShareBtnStartResId() {
        return R.drawable.inm;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getAudioShareBtnStopResId() {
        return R.drawable.inn;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public Bitmap getBitmapFromResourceId(Context context, int i3) {
        try {
            return ((BitmapDrawable) ContextCompat.getDrawable(context, i3)).getBitmap();
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("UITools", 2, "getBitmapFromResourceId", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("UITools", 2, "getBitmapFromResourceId", e17);
            return null;
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public float getMeasureTextWidth(TextView textView) {
        return textView.getPaint().measureText((String) textView.getText());
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getMobileQQLastSyncVersion() {
        return 710;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public Drawable getOvalDrawable(float f16, Context context) {
        int f17 = BaseAIOUtils.f(f16, context.getResources());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#4C000000"));
        gradientDrawable.setSize(f17, f17);
        return gradientDrawable;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public String getPhoneNumberByUinInMainThread(BaseQQAppInterface baseQQAppInterface, String str) {
        IPhoneContactService iPhoneContactService;
        PhoneContact queryPhoneContactByUin;
        BusinessCard b16;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Card r16 = ((FriendsManager) baseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(str);
        if (r16 != null && (b16 = BusinessCardUtils.b(r16.bCardInfo)) != null && !b16.mobilesNum.isEmpty()) {
            str2 = b16.mobilesNum.get(0);
        }
        if (!TextUtils.isEmpty(str2) || (iPhoneContactService = (IPhoneContactService) baseQQAppInterface.getRuntimeService(IPhoneContactService.class, "")) == null) {
            return str2;
        }
        int selfBindState = iPhoneContactService.getSelfBindState();
        return ((selfBindState == 9 || selfBindState == 8 || selfBindState == 4 || selfBindState == 2) && PermissionChecker.h().f() && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(str)) != null) ? queryPhoneContactByUin.mobileNo : str2;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public SharedPreferences getQavSP(AppInterface appInterface) {
        return appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin() + "qav_SP", 0);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public float getScreenBrightness() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (!d.f446756f) {
            c.d().j(layoutParams);
        } else {
            layoutParams.screenBrightness = 0.034f;
        }
        return layoutParams.screenBrightness;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getScreenShareBgResId() {
        return R.drawable.io6;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean gotoSetting(Activity activity) {
        return SmallScreenUtils.t(activity, "miui.intent.action.APP_PERM_EDITOR") || SmallScreenUtils.t(activity, "com.meizu.safe.security.SHOW_APPSEC") || SmallScreenUtils.t(activity, "huawei.intent.action.NOTIFICATIONMANAGER") || SmallScreenUtils.t(activity, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void handleBitmapToGaussianBg(BaseApplication baseApplication, ew.a aVar, Bitmap bitmap, b bVar) {
        Drawable drawableFromCache = getDrawableFromCache(getGaussianBgCacheKey(aVar));
        if (drawableFromCache != null) {
            if (bVar != null) {
                bVar.D1(aVar, drawableFromCache);
            }
        } else {
            if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                return;
            }
            handle50Gaussian(baseApplication, aVar, bitmap, bVar);
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean hasSmartBar() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            return false;
        }
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            String str = Build.DEVICE;
            if (str.equals("mx2")) {
                return true;
            }
            if (!str.equals("mx")) {
                str.equals("m9");
            }
            return false;
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isFeatureSupportRounedScreen(Activity activity) {
        Boolean bool = this.sHasRoundedInScreen;
        if (bool != null) {
            return bool.booleanValue();
        }
        this.sHasRoundedInScreen = new Boolean(false);
        if (!Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            Boolean valueOf = Boolean.valueOf(LiuHaiUtils.hasNotchInScreenByVersion(activity));
            this.sHasRoundedInScreen = valueOf;
            return valueOf.booleanValue();
        }
        try {
            try {
                Class<?> loadClass = activity.getClassLoader().loadClass("android.util.FtFeature");
                Boolean bool2 = (Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 8);
                this.sHasRoundedInScreen = bool2;
                return bool2.booleanValue();
            } catch (ClassNotFoundException unused) {
                QLog.e(TAG, 1, "hasNotchInScreen ClassNotFoundException");
                return this.sHasRoundedInScreen.booleanValue();
            } catch (NoSuchMethodException unused2) {
                QLog.e(TAG, 1, "hasNotchInScreen NoSuchMethodException");
                return this.sHasRoundedInScreen.booleanValue();
            } catch (Exception unused3) {
                QLog.e(TAG, 1, "hasNotchInScreen Exception");
                return this.sHasRoundedInScreen.booleanValue();
            }
        } catch (Throwable unused4) {
            return this.sHasRoundedInScreen.booleanValue();
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isFilterProcessPostRenderUserShader() {
        if (this.mPostRenderUseShader == null) {
            this.mPostRenderUseShader = Boolean.valueOf(af.K());
            QLog.d(TAG, 1, "initUseRBG2I420Switch useRGB2I420Shader = " + this.mPostRenderUseShader);
            if (this.mPostRenderUseShader.booleanValue()) {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.useRGB2I420ShaderCfg.name(), "1");
                QLog.d(TAG, 1, "initUseRBG2I420Switch dpcValue = " + featureValue);
                if (featureValue.equals("0")) {
                    this.mPostRenderUseShader = Boolean.FALSE;
                }
            }
            if (e.e(21) == 1) {
                this.mPostRenderUseShader = Boolean.TRUE;
            } else if (e.e(21) == 0) {
                this.mPostRenderUseShader = Boolean.FALSE;
            }
            QLog.d(TAG, 1, "initUseRBG2I420Switch,after getDebugValue, initial useRGB2I420Shader = " + this.mPostRenderUseShader + ",Build.MODEL = " + DeviceInfoMonitor.getModel());
        }
        return this.mPostRenderUseShader.booleanValue();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isFilterProcessRenderUseSurface() {
        return this.mRenderUseSurfaceMode.booleanValue();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isNeedShowSVIPDialog() {
        if (this.mHasShowDialog == null) {
            this.mHasShowDialog = new Boolean(false);
            this.mHasShowDialog = Boolean.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).getBoolean(SHARED_PREF_KEY_HAS_SHOW_SVIP_DIALOG, true));
        }
        return this.mHasShowDialog.booleanValue();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isSupportSurfaceMode() {
        if (this.mDPCUseSurfaceMode == null) {
            boolean z16 = ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).isSupported() && !(((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(com.tencent.aelight.camera.constants.a.f69009w) || ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isNotSupportFilterBasedSdk());
            if (z16) {
                z16 = am.b(0);
            }
            this.mDPCUseSurfaceMode = Boolean.valueOf(z16);
            QLog.d(TAG, 1, "isSupportSurfaceMode=" + this.mDPCUseSurfaceMode);
        }
        return this.mDPCUseSurfaceMode.booleanValue();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void openPermissionActivity(Activity activity) {
        boolean z16;
        int i3;
        String packageName = activity.getPackageName();
        if (SmallScreenUtils.t(activity, "miui.intent.action.APP_PERM_EDITOR")) {
            z16 = openMIUIPermissionActivity(activity, packageName);
            i3 = 1;
        } else {
            z16 = false;
            i3 = 0;
        }
        if (!z16 && SmallScreenUtils.t(activity, "com.meizu.safe.security.SHOW_APPSEC")) {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
            intent.putExtra("packageName", packageName);
            try {
                activity.startActivity(intent);
                z16 = true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "openPermissionActivity e = " + e16);
                }
                z16 = false;
            }
            i3 = 2;
        }
        if (!z16 && SmallScreenUtils.t(activity, "huawei.intent.action.NOTIFICATIONMANAGER")) {
            Intent intent2 = new Intent();
            intent2.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            intent2.addFlags(268435456);
            try {
                activity.startActivity(intent2);
                z16 = true;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "openPermissionActivity e = " + e17);
                }
                z16 = false;
            }
            i3 = 3;
            if (!z16) {
                try {
                    activity.startActivity(new Intent("huawei.intent.action.NOTIFICATIONMANAGER"));
                    z16 = true;
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "openPermissionActivity e = " + e18);
                    }
                    z16 = false;
                }
            }
        }
        if (!z16) {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            i3 = 4;
            try {
                intent3.setData(Uri.fromParts("package", packageName, null));
                activity.startActivity(intent3);
                z16 = true;
            } catch (Exception e19) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "openPermissionActivity e = " + e19);
                }
                z16 = false;
            }
        }
        if (!z16 && SmallScreenUtils.t(activity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            i3 = 5;
            try {
                activity.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
                z16 = true;
            } catch (Exception e26) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "openPermissionActivity e = " + e26);
                }
                z16 = false;
            }
        }
        if (!z16) {
            Intent intent4 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent4.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            intent4.putExtra("show_right_close_button", false);
            intent4.putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(activity, "https://view.yutu.qq.com/yutu/activity/3857.html", 524288L, intent4, false, -1);
            i3 = 6;
        }
        QLog.w(TAG, 1, "\u8bf7\u6c42\u76f8\u673a\u6743\u9650, which[" + i3 + "], openSuccess[" + z16 + "]");
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void printStacktrace(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null) {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "PrintBacktrace-->can npt het StackTrace");
                return;
            }
            return;
        }
        String str2 = new String();
        for (int i3 = 0; i3 < stackTrace.length; i3++) {
            str2 = str2 + "STE[" + i3 + "]:" + stackTrace[i3].toString() + "\n";
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public float px2dp(Context context, float f16) {
        return (f16 / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void recordHasShowSVIPDialog() {
        this.mHasShowDialog = new Boolean(false);
        ea.i(BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).edit().putBoolean(SHARED_PREF_KEY_HAS_SHOW_SVIP_DIALOG, false));
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void setAccText(View view, String str) {
        if (ba.f77071e) {
            if (QLog.isDevelopLevel()) {
                QLog.i("UITools", 2, "SetAccText: " + str);
            }
            if (view == null) {
                return;
            }
            view.setFocusable(true);
            view.setContentDescription(str);
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void setFilterProcessRenderMode(boolean z16) {
        this.mRenderUseSurfaceMode = Boolean.valueOf(z16);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void setFirstTimeShowUserGuideForFace(AppInterface appInterface) {
        SharedPreferences.Editor edit = getQavSP(appInterface).edit();
        edit.putBoolean("qav_UserGuide_for_voiceSticker", false);
        edit.commit();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void setViewAlpha(View view, float f16) {
        view.setAlpha(f16);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void showCustomDialog(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        gw.a aVar = new gw.a(context, R.style.qZoneInputDialog);
        aVar.setContentView(R.layout.f167474di3);
        aVar.j(str);
        aVar.f(str2);
        aVar.g(i16, onClickListener2);
        aVar.h(i17, onClickListener);
        aVar.setCanceledOnTouchOutside(false);
        aVar.show();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean startRing(AppInterface appInterface, int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        if (!canPlayRing(appInterface)) {
            return false;
        }
        AudioUtil.l(i3, i16, onCompletionListener);
        return true;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int uinType2AVRelationType(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            if (i3 != 1011) {
                if (i3 != 3000) {
                    return 0;
                }
                return 2;
            }
            return 7;
        }
        return 3;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public int uinType2MultiAVType(int i3) {
        if (i3 != 1) {
            if (i3 == 3000) {
                return 1;
            }
            return 0;
        }
        return 10;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void enableLenovoNotch() {
        AVToolBarPart.S = true;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public String getNameMaxMaseaured(Context context, String str, TextView textView, float f16) {
        return com.tencent.mobileqq.text.TextUtils.adjustEllipsizeEndText(textView, str, (int) f16);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isFirstTimeShowUserGuideForFace(AppInterface appInterface) {
        if (e.e(0) == 1) {
            return true;
        }
        return getQavSP(appInterface).getBoolean("qav_UserGuide_for_voiceSticker", true);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void clearPressSpeakerGuiderFlag(boolean z16) {
        if (z16) {
            this.mHasShowPressSpeakerModeFirstGuider = Boolean.TRUE;
        } else {
            this.mHasShowPressSpeakerModeSecondGuider = Boolean.TRUE;
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void clearSpeakerStatus(Context context) {
        if (context != null) {
            SharedPreferences U0 = ea.U0(context);
            SharedPreferences.Editor edit = U0.edit();
            edit.putBoolean("qav_random_speakeron", false);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "qav_random_speakeron:" + U0.getBoolean("qav_random_speakeron", false));
            }
        }
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void doScreenShareReport(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("doScreenShareReport, tag[%s], fromType[%s]", str, Integer.valueOf(i3)));
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean getPressSpeakerGuiderFlag(boolean z16) {
        if (z16) {
            return this.mHasShowPressSpeakerModeFirstGuider.booleanValue();
        }
        return this.mHasShowPressSpeakerModeSecondGuider.booleanValue();
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isEnableShowTips(int i3) {
        if (i3 == 1) {
            if (ba.f77072f == -1) {
                ba.f77072f = BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).getInt("grid_enable_switch", 1);
            }
            return ba.f77072f == 1;
        }
        if (ba.f77073h == -1) {
            ba.f77073h = BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).getInt("slide_enable_switch", 1);
        }
        return ba.f77073h == 1;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void disableShowTips(int i3) {
        String str;
        if (i3 == 1) {
            str = "grid_enable_switch";
        } else {
            str = "slide_enable_switch";
        }
        if (i3 == 1) {
            ba.f77072f = 0;
        } else {
            ba.f77073h = 0;
        }
        ea.i(BaseApplicationImpl.getApplication().getSharedPreferences(TAG, 4).edit().putInt(str, 0));
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public String getTimeDesc(String str) {
        int i3;
        int i16;
        String str2;
        String qqStr = HardCodeUtil.qqStr(R.string.ut_);
        String[] split = str.split(":");
        int i17 = 0;
        if (split.length == 3) {
            i17 = Integer.valueOf(split[0]).intValue();
            i16 = Integer.valueOf(split[1]).intValue();
            i3 = Integer.valueOf(split[2]).intValue();
        } else if (split.length == 2) {
            i16 = Integer.valueOf(split[0]).intValue();
            i3 = Integer.valueOf(split[1]).intValue();
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i17 <= 0 && i16 <= 0 && i3 <= 0) {
            return qqStr + str;
        }
        if (i17 > 0) {
            qqStr = qqStr + i17 + HardCodeUtil.qqStr(R.string.ut8);
        }
        if (i16 > 0) {
            str2 = qqStr + i16 + HardCodeUtil.qqStr(R.string.ut7);
        } else {
            str2 = qqStr;
        }
        if (i3 <= 0) {
            return str2;
        }
        return str2 + i3 + HardCodeUtil.qqStr(R.string.ut6);
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void setScreenBrightness(Activity activity, float f16) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f16;
        window.setAttributes(attributes);
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        QLog.d("QavAvatarHelper", 1, "scaleBitmap " + width + HippyTKDListViewAdapter.X + height + " -> " + i3 + HippyTKDListViewAdapter.X + i16);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    boolean canPlayRing(AppInterface appInterface) {
        String currentAccountUin;
        boolean z16 = false;
        if (appInterface == null) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication);
        if (appInterface.getCurrentAccountUin() != null && (currentAccountUin = appInterface.getCurrentAccountUin()) != null) {
            z16 = defaultSharedPreferences.getBoolean(appInterface.getApp().getString(R.string.cz4) + currentAccountUin, true);
        }
        if (AudioUtil.g() == 0 || !z16 || ad.o(BaseApplicationImpl.sApplication) || ad.l(BaseApplicationImpl.sApplication) || ad.h(BaseApplicationImpl.sApplication)) {
            return z16;
        }
        return true;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public Bitmap captureFrameBySelf(int i3, int i16, int i17) {
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glGenFramebuffers(1, r9, 0);
        GLES20.glBindFramebuffer(36160, r9[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 36197, i3, 0);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, r9, 0);
        int[] iArr = {0};
        allocate.position(0);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        Matrix matrix = new Matrix();
        matrix.postRotate(0.0f);
        matrix.postScale(1.0f, -1.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, i16, i17, matrix, true);
        createBitmap.recycle();
        return createBitmap2;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public boolean isVIPPayProcessExist(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if ("com.tencent.mobileqq:tool".equals(it.next().processName)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public Bitmap takeScreenShot(Activity activity) {
        View decorView;
        if (activity == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return null;
        }
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache(true);
        Bitmap drawingCache = decorView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight());
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public void setAccText(View view, String str, int i3) {
        if (!ba.f77071e || view == null) {
            return;
        }
        if (i3 == 2) {
            str = str.replace(view.getResources().getString(R.string.d97), HardCodeUtil.qqStr(R.string.ut9));
        }
        if (QLog.isColorLevel()) {
            QLog.i("UITools", 2, "SetAccText with avType:" + str + " avType:" + i3);
        }
        view.setFocusable(true);
        view.setContentDescription(str);
    }

    private boolean isIntentAvailable(Context context, Intent intent) {
        ActivityInfo resolveActivityInfo;
        return (context == null || intent == null || (resolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 65536)) == null || !resolveActivityInfo.exported) ? false : true;
    }

    private static Bitmap scaleDown(Bitmap bitmap, ew.a aVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        Bitmap bitmap2 = bitmap;
        Bitmap bitmap3 = null;
        if (bitmap2 == null) {
            return null;
        }
        int i19 = 0;
        boolean z16 = bitmap.getWidth() > 140 && bitmap.getHeight() > 140;
        if (z16) {
            bitmap2 = scaleBitmap(bitmap2, 140, 140);
        }
        if (bitmap2 == null) {
            return null;
        }
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        float f16 = screenWidth / screenHeight;
        float f17 = width;
        float f18 = height;
        float f19 = f17 / f18;
        int i26 = aVar.f397252f;
        if (i26 > 0 && (i18 = aVar.f397251e) > 0) {
            f16 = i18 / i26;
        }
        if (f16 < f19) {
            i17 = Math.min((int) (f18 * f16), width);
            i16 = height;
            i3 = 0;
            i19 = (width - i17) / 2;
        } else {
            int min = Math.min((int) (f17 / f16), height);
            i3 = (height - min) / 2;
            i16 = min;
            i17 = width;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavAvatarHelper", 1, "scaleDown origin=" + width + " x " + height + " offset=[" + i19 + "," + i3 + "] fit=" + i17 + " x " + i16 + " screen=" + screenWidth + " x " + screenHeight);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("target w = ");
            sb5.append(aVar.f397251e);
            sb5.append(" h= ");
            sb5.append(aVar.f397252f);
            QLog.d("QavAvatarHelper", 1, sb5.toString());
        }
        if (i17 != 0 && i16 != 0) {
            bitmap3 = Bitmap.createBitmap(bitmap2, i19, i3, i17, i16);
            if (z16) {
                bitmap2.recycle();
            }
            if (aVar.f397252f > 0 && aVar.f397251e > 0) {
                Matrix matrix = new Matrix();
                matrix.postScale(aVar.f397251e / i17, aVar.f397252f / i16);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap3.getHeight(), matrix, true);
                bitmap3.recycle();
                return createBitmap;
            }
        }
        return bitmap3;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public Bitmap doBlur(Bitmap bitmap, Context context, int i3, boolean z16) {
        Bitmap createScaledBitmap;
        int[] iArr;
        int i16 = i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("blur", 2, "width = " + bitmap.getWidth() + " # height = " + bitmap.getHeight());
        }
        if (z16) {
            int height = (bitmap.getHeight() * getScreenWidth(context)) / getScreenHeight(context);
            int width = (bitmap.getWidth() - height) / 2;
            if (width < 0) {
                width = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, width, 0, height, bitmap.getHeight());
            createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2, false);
            createBitmap.recycle();
        } else {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("blur", 2, "isMutable = " + createScaledBitmap.isMutable());
        }
        if (i16 < 1) {
            return null;
        }
        int width2 = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int i17 = width2 * height2;
        int[] iArr2 = new int[i17];
        createScaledBitmap.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
        int i18 = width2 - 1;
        int i19 = height2;
        int i26 = i19 - 1;
        int i27 = i16 + i16 + 1;
        int[] iArr3 = new int[i17];
        int[] iArr4 = new int[i17];
        int[] iArr5 = new int[i17];
        int[] iArr6 = new int[Math.max(width2, i19)];
        int i28 = (i27 + 1) >> 1;
        int i29 = i28 * i28;
        int i36 = i29 * 256;
        int[] iArr7 = new int[i36];
        for (int i37 = 0; i37 < i36; i37++) {
            iArr7[i37] = i37 / i29;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i27, 3);
        int i38 = i16 + 1;
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        while (i39 < i19) {
            Bitmap bitmap2 = createScaledBitmap;
            int i48 = -i16;
            int i49 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            while (i48 <= i16) {
                int i69 = i26;
                int i75 = i19;
                int i76 = iArr2[Math.min(i18, Math.max(i48, 0)) + i46];
                int[] iArr9 = iArr8[i48 + i16];
                iArr9[0] = (i76 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr9[1] = (i76 & 65280) >> 8;
                iArr9[2] = i76 & 255;
                int abs = i38 - Math.abs(i48);
                int i77 = iArr9[0];
                i49 += i77 * abs;
                int i78 = iArr9[1];
                i56 += i78 * abs;
                int i79 = iArr9[2];
                i57 += abs * i79;
                if (i48 > 0) {
                    i66 += i77;
                    i67 += i78;
                    i68 += i79;
                } else {
                    i58 += i77;
                    i59 += i78;
                    i65 += i79;
                }
                i48++;
                i19 = i75;
                i26 = i69;
            }
            int i85 = i26;
            int i86 = i19;
            int i87 = i16;
            int i88 = 0;
            while (i88 < width2) {
                iArr3[i46] = iArr7[i49];
                iArr4[i46] = iArr7[i56];
                iArr5[i46] = iArr7[i57];
                int i89 = i49 - i58;
                int i95 = i56 - i59;
                int i96 = i57 - i65;
                int[] iArr10 = iArr8[((i87 - i16) + i27) % i27];
                int i97 = i58 - iArr10[0];
                int i98 = i59 - iArr10[1];
                int i99 = i65 - iArr10[2];
                if (i39 == 0) {
                    iArr = iArr7;
                    iArr6[i88] = Math.min(i88 + i16 + 1, i18);
                } else {
                    iArr = iArr7;
                }
                int i100 = iArr2[i47 + iArr6[i88]];
                int i101 = (i100 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr10[0] = i101;
                int i102 = (i100 & 65280) >> 8;
                iArr10[1] = i102;
                int i103 = i100 & 255;
                iArr10[2] = i103;
                int i104 = i66 + i101;
                int i105 = i67 + i102;
                int i106 = i68 + i103;
                i49 = i89 + i104;
                i56 = i95 + i105;
                i57 = i96 + i106;
                i87 = (i87 + 1) % i27;
                int[] iArr11 = iArr8[i87 % i27];
                int i107 = iArr11[0];
                i58 = i97 + i107;
                int i108 = iArr11[1];
                i59 = i98 + i108;
                int i109 = iArr11[2];
                i65 = i99 + i109;
                i66 = i104 - i107;
                i67 = i105 - i108;
                i68 = i106 - i109;
                i46++;
                i88++;
                iArr7 = iArr;
            }
            i47 += width2;
            i39++;
            createScaledBitmap = bitmap2;
            i19 = i86;
            i26 = i85;
        }
        Bitmap bitmap3 = createScaledBitmap;
        int[] iArr12 = iArr7;
        int i110 = i26;
        int i111 = i19;
        int i112 = 0;
        while (i112 < width2) {
            int i113 = -i16;
            int i114 = i113 * width2;
            int i115 = 0;
            int i116 = 0;
            int i117 = 0;
            int i118 = 0;
            int i119 = 0;
            int i120 = 0;
            int i121 = 0;
            int i122 = 0;
            int i123 = 0;
            while (i113 <= i16) {
                int[] iArr13 = iArr6;
                int max = Math.max(0, i114) + i112;
                int[] iArr14 = iArr8[i113 + i16];
                iArr14[0] = iArr3[max];
                iArr14[1] = iArr4[max];
                iArr14[2] = iArr5[max];
                int abs2 = i38 - Math.abs(i113);
                i115 += iArr3[max] * abs2;
                i116 += iArr4[max] * abs2;
                i117 += iArr5[max] * abs2;
                if (i113 > 0) {
                    i121 += iArr14[0];
                    i122 += iArr14[1];
                    i123 += iArr14[2];
                } else {
                    i118 += iArr14[0];
                    i119 += iArr14[1];
                    i120 += iArr14[2];
                }
                int i124 = i110;
                if (i113 < i124) {
                    i114 += width2;
                }
                i113++;
                i110 = i124;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i125 = i110;
            int i126 = i111;
            int i127 = i112;
            int i128 = i16;
            int i129 = 0;
            while (i129 < i126) {
                iArr2[i127] = (iArr2[i127] & (-16777216)) | (iArr12[i115] << 16) | (iArr12[i116] << 8) | iArr12[i117];
                int i130 = i115 - i118;
                int i131 = i116 - i119;
                int i132 = i117 - i120;
                int[] iArr16 = iArr8[((i128 - i16) + i27) % i27];
                int i133 = i118 - iArr16[0];
                int i134 = i119 - iArr16[1];
                int i135 = i120 - iArr16[2];
                if (i112 == 0) {
                    iArr15[i129] = Math.min(i129 + i38, i125) * width2;
                }
                int i136 = iArr15[i129] + i112;
                int i137 = iArr3[i136];
                iArr16[0] = i137;
                int i138 = iArr4[i136];
                iArr16[1] = i138;
                int i139 = iArr5[i136];
                iArr16[2] = i139;
                int i140 = i121 + i137;
                int i141 = i122 + i138;
                int i142 = i123 + i139;
                i115 = i130 + i140;
                i116 = i131 + i141;
                i117 = i132 + i142;
                i128 = (i128 + 1) % i27;
                int[] iArr17 = iArr8[i128];
                int i143 = iArr17[0];
                i118 = i133 + i143;
                int i144 = iArr17[1];
                i119 = i134 + i144;
                int i145 = iArr17[2];
                i120 = i135 + i145;
                i121 = i140 - i143;
                i122 = i141 - i144;
                i123 = i142 - i145;
                i127 += width2;
                i129++;
                i16 = i3;
            }
            i112++;
            i16 = i3;
            i111 = i126;
            i110 = i125;
            iArr6 = iArr15;
        }
        bitmap3.setPixels(iArr2, 0, width2, 0, 0, width2, i111);
        if (QLog.isColorLevel()) {
            QLog.d("blur", 2, "blur time = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return bitmap3;
    }

    @Override // com.tencent.av.utils.api.IUIToolsApi
    public String formatTime(long j3) {
        if (j3 > 0) {
            long j16 = j3 % 60;
            long j17 = j3 / 60;
            long j18 = j17 / 60;
            long j19 = j17 % 60;
            if (j18 > 0) {
                return String.format(Locale.CHINA, "%02d:%02d:%02d", Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j16));
            }
            return String.format(Locale.CHINA, "%02d:%02d", Long.valueOf(j19), Long.valueOf(j16));
        }
        return QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
    }
}

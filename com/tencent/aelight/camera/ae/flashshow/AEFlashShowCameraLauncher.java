package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.download.LSDownloadMaterialRunnable;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.event.WinkLaunchEvent;
import com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.api.QZoneContant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFlashShowCameraLauncher {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements WinkSchemaPreCheck.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f63682a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f63683b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f63684c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f63685d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f63686e;

        a(Intent intent, String str, Context context, int i3, boolean z16) {
            this.f63682a = intent;
            this.f63683b = str;
            this.f63684c = context;
            this.f63685d = i3;
            this.f63686e = z16;
        }

        @Override // com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck.a
        public void a(Bundle bundle, ConcurrentHashMap<String, String> concurrentHashMap) {
            ms.a.f("AEFlashShowCameraLauncher", "WinkSchemaPreCheck preCheck success.");
            BaseApplication context = BaseApplication.getContext();
            this.f63682a.addFlags(268435456);
            if ("5".equals(this.f63683b)) {
                AEFlashShowCameraLauncher.this.t(context, this.f63682a, bundle);
            } else if ("6".equals(this.f63683b)) {
                this.f63682a.putExtra("KEY_JUMP_TARGET", "6");
                this.f63682a.putExtras(bundle);
                com.tencent.mobileqq.wink.g.f322861a.o(context, this.f63682a, null);
            } else if (!"3".equals(this.f63683b) && !"7".equals(this.f63683b)) {
                if ("4".equals(this.f63683b)) {
                    this.f63682a.putExtras(bundle);
                    com.tencent.mobileqq.wink.g.f322861a.m(context, this.f63682a);
                } else if ("1001".equals(this.f63683b)) {
                    this.f63682a.putExtras(bundle);
                    com.tencent.mobileqq.wink.f.n(context, bundle);
                } else if ("1002".equals(this.f63683b)) {
                    AEFlashShowCameraLauncher.n(context, bundle);
                } else if ("20".equals(this.f63683b)) {
                    AEFlashShowCameraLauncher.this.q(context, bundle);
                } else if ("19".equals(this.f63683b)) {
                    com.tencent.mobileqq.wink.picker.g.f324860a.e(context, bundle);
                } else if ("24".equals(this.f63683b)) {
                    this.f63682a.putExtras(bundle);
                    com.tencent.mobileqq.wink.f.q(context, this.f63682a);
                } else if ("25".equals(this.f63683b)) {
                    this.f63682a.putExtras(bundle);
                    com.tencent.mobileqq.wink.f.s(context, this.f63682a);
                } else {
                    this.f63682a.putExtras(bundle);
                    AEFlashShowCameraLauncher.this.o(this.f63684c, this.f63682a, concurrentHashMap, this.f63685d, this.f63683b);
                }
            } else {
                this.f63682a.putExtras(bundle);
                com.tencent.mobileqq.wink.f.u(context, this.f63682a, "");
            }
            AEFlashShowCameraLauncher.m(true, this.f63686e);
            AEFlashShowCameraLauncher.this.y();
            AEFlashShowCameraLauncher.this.z(bundle);
        }

        @Override // com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck.a
        public void onFailed() {
            ms.a.c("AEFlashShowCameraLauncher", "WinkSchemaPreCheck preCheck failed.");
        }
    }

    AEFlashShowCameraLauncher() {
    }

    private void A(Bundle bundle) {
        if (!bundle.containsKey(AECameraConstants.VIDEO_STORY_FROM_TYPE)) {
            bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.O.b());
        }
        if (!bundle.containsKey("edit_video_type")) {
            bundle.putInt("edit_video_type", 10028);
        }
        if (!bundle.containsKey("ability_flag")) {
            bundle.putInt("ability_flag", 1);
        }
        if (bundle.containsKey("xsj_ref_pgid")) {
            return;
        }
        try {
            HashMap hashMap = (HashMap) bundle.get("key_attrs");
            String str = "";
            if (hashMap != null && !hashMap.isEmpty()) {
                str = (String) hashMap.get("xsj_ref_pgid");
            }
            if (TextUtils.isEmpty(str)) {
                str = (String) WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
            }
            ms.a.f("AEFlashShowCameraLauncher", "prepareCommonParams, refPgId: " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            bundle.putString("xsj_ref_pgid", str);
        } catch (Exception e16) {
            ms.a.d("AEFlashShowCameraLauncher", "prepareCommonParams error ", e16);
        }
    }

    private int B(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean D() {
        Class<?> cls;
        if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(com.tencent.aelight.camera.constants.a.f69009w) || ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isNotSupportFilterBasedSdk()) {
            return false;
        }
        boolean isBeautySupported = AVCoreSystemInfo.isBeautySupported();
        try {
            cls = Class.forName("android.opengl.EGL14");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        return isBeautySupported && cls != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(BaseQQAppInterface baseQQAppInterface, Context context) {
        if (!D()) {
            return false;
        }
        ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, null, false);
        com.tencent.mobileqq.shortvideo.w.e(baseQQAppInterface);
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraResExist();
    }

    public static AEFlashShowCameraLauncher i() {
        return new AEFlashShowCameraLauncher();
    }

    private String j(Bundle bundle) {
        if (bundle == null) {
            return QQWinkConstants.ENTRY_QQ_OTHER;
        }
        String string = bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME);
        ms.a.a("AEFlashShowCameraLauncher", "businessName " + string);
        string.hashCode();
        char c16 = '\uffff';
        switch (string.hashCode()) {
            case 68174803:
                if (string.equals("GUILD")) {
                    c16 = 0;
                    break;
                }
                break;
            case 77564797:
                if (string.equals("QZONE")) {
                    c16 = 1;
                    break;
                }
                break;
            case 861433953:
                if (string.equals("QCIRCLE")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "qq_chanel";
            case 1:
                return QQWinkConstants.ENTRY_QQ_QZONE;
            case 2:
                return QQWinkConstants.ENTRY_QQ_WORLD;
            default:
                return QQWinkConstants.ENTRY_QQ_OTHER;
        }
    }

    private Intent k(Context context, Bundle bundle) {
        if (QLog.isDevelopLevel()) {
            QLog.d("AEFlashShowCameraLauncher", 4, "in getLaunchIntent");
        }
        Intent intent = new Intent(context, (Class<?>) WinkHomeActivity.class);
        int i3 = bundle.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        if (!js.a.f410915o.d(i3) && !js.a.f410914n.d(i3)) {
            if (js.a.K.d(i3) || js.a.L.d(i3)) {
                ms.a.a("AEFlashShowCameraLauncher", "set special launch flags case2");
                intent.setFlags(402653184);
            }
        } else {
            ms.a.a("AEFlashShowCameraLauncher", "set special launch flags case1");
            intent.setFlags(402653184);
        }
        if (!(context instanceof Activity)) {
            ms.a.a("AEFlashShowCameraLauncher", "add special launch flags, context is not Activity");
            intent.addFlags(268435456);
        }
        intent.putExtras(bundle);
        intent.putExtra(AECameraConstants.PARAMS_NEED_SHOW_BANNER, false);
        return intent;
    }

    private String l(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (QzoneConfig.getQFSJumpPhotoList()) {
            return "1";
        }
        return "0";
    }

    public static void m(final boolean z16, boolean z17) {
        ms.a.f("AEFlashShowCameraLauncher", "handleLaunchEvent");
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.AE_RES_BASE_PACKAGE;
        if (iAEResUtil.getAEResStatus(aEResInfo) != 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraLauncher.2
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    BaseQQAppInterface baseQQAppInterface = runtime instanceof BaseQQAppInterface ? (BaseQQAppInterface) runtime : null;
                    if (baseQQAppInterface != null) {
                        hd0.c.c("AEFlashShowCameraLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(z16), Boolean.valueOf(AEFlashShowCameraLauncher.h(baseQQAppInterface, BaseApplication.getContext())));
                    }
                }
            }, 128, null, false);
        }
        if (!z17) {
            ms.a.f("AEFlashShowCameraLauncher", "not from arzplan can download");
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE.agentType);
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY.agentType);
        }
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE.agentType);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_FACE_CLASSIFY.agentType);
    }

    public static void n(Context context, Bundle bundle) {
        Intent intent = new Intent();
        boolean z16 = context instanceof Activity;
        if (!z16) {
            intent.setFlags(268435456);
        }
        int i3 = bundle.getInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 1);
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_class", AEMultiCameraFragment.class.getName());
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.T.b());
        HashMap hashMap = (HashMap) bundle.get("key_attrs");
        if (hashMap != null) {
            if (hashMap.containsKey(QQWinkConstants.AE_MULTI_CAMERA_FROM) && hashMap.get(QQWinkConstants.AE_MULTI_CAMERA_FROM) != null && Objects.equals(hashMap.get(QQWinkConstants.AE_MULTI_CAMERA_FROM), "QZONE")) {
                intent.putExtra(QQWinkConstants.AE_MULTI_CAMERA_FROM, "QZONE");
            }
            if (hashMap.containsKey(QQWinkConstants.AE_CAMERA_RATIO) && hashMap.get(QQWinkConstants.AE_CAMERA_RATIO) != null && Objects.equals(hashMap.get(QQWinkConstants.AE_CAMERA_RATIO), "1")) {
                intent.putExtra(QQWinkConstants.AE_CAMERA_RATIO, "1");
            }
        }
        if (z16) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            context.startActivity(intent);
        }
    }

    private void p(Context context, Bundle bundle, String str, int i3) {
        bundle.putString("AECAMERA_TAB_SELECTED", l(str));
        v(context, bundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        com.tencent.mobileqq.wink.g.f322861a.n(context, intent);
    }

    private void r(Context context, Map<String, String> map) {
        Bundle fillInnerJumpBundle = ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).fillInnerJumpBundle(context, map);
        fillInnerJumpBundle.putBoolean(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE, true);
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).launchLocalPhotoRecommendStandalonePage(context, fillInnerJumpBundle);
    }

    private void s(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, QQWinkActivity.class);
        IQQWinkLaucher.WinkHomePageType winkHomePageType = (IQQWinkLaucher.WinkHomePageType) bundle.get(QQWinkConstants.SPECIFIC_WINK_HOME_CLASS_TYPE);
        String k3 = com.tencent.mobileqq.wink.f.k(winkHomePageType);
        int i3 = bundle.getInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 1);
        QLog.d("AEFlashShowCameraLauncher", 1, "jumpToSpecificWinkHomePage: " + k3 + " type: " + winkHomePageType);
        intent.putExtra("public_fragment_class", k3);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Context context, Intent intent, Bundle bundle) {
        intent.putExtra("KEY_JUMP_TARGET", "5");
        intent.putExtras(bundle);
        if (r93.h.f430993a.g()) {
            com.tencent.mobileqq.wink.g.f322861a.n(context, intent);
        } else {
            com.tencent.mobileqq.wink.g.f322861a.o(context, intent, null);
        }
    }

    private void v(Context context, Bundle bundle, int i3) {
        ms.a.a("AEFlashShowCameraLauncher", "[AE Profiler] launchMultiCameraFromFlash");
        if (bundle.containsKey(QQWinkConstants.SPECIFIC_WINK_HOME_CLASS_TYPE)) {
            s(context, bundle);
            return;
        }
        int i16 = bundle.getInt(QQWinkConstants.EDITOR_ENTRANCE, 0);
        if (i16 != 2 && i16 != 3 && i16 != 4 && i16 != 11 && i16 != 12) {
            w(context, C(bundle), i3);
        } else {
            bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, i16);
            com.tencent.aelight.camera.ae.flashshow.util.s.d(context, bundle);
        }
    }

    private void w(Context context, Bundle bundle, int i3) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (com.tencent.aelight.camera.aioeditor.a.f66321a != 0) {
            com.tencent.aelight.camera.aioeditor.a.f66323c = currentTimeMillis;
            QLog.e(IAIOShortVideoUtil.MONITOR_EVENT_TAG, 1, "TIMESTAMP_START_ACTIVITY ", Long.valueOf(currentTimeMillis));
            bundle.putLong("TIMESTAMP_PRELOAD_PEAK", com.tencent.aelight.camera.aioeditor.a.f66321a);
            bundle.putLong("TIMESTAMP_CLICK_CAMERA", com.tencent.aelight.camera.aioeditor.a.f66322b);
            bundle.putLong("TIMESTAMP_START_ACTIVITY", com.tencent.aelight.camera.aioeditor.a.f66323c);
        }
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, currentTimeMillis);
        bundle.putLong("intent_key_launch_begin_time", currentTimeMillis);
        AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
        if (a16 != null) {
            str = a16.getCurrentAccountUin();
        } else {
            str = "none";
        }
        bundle.putString("intent_key_uid_for_report", str);
        Intent k3 = k(context, bundle);
        if (gq.c.k(bundle)) {
            k3.addFlags(603979776);
        }
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(k3, i3);
            } else {
                context.startActivity(k3);
            }
            tq.b.h().o(IAELaunchRecorder.MILESTONE_START_ACTIVITY);
        } catch (Exception e16) {
            w53.b.d("AEFlashShowCameraLauncher", "open wink error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        ms.a.f("AEFlashShowCameraLauncher", "notifyLaunchEvent ");
        SimpleEventBus.getInstance().dispatchEvent(new WinkLaunchEvent());
    }

    private static Bundle C(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(AECameraConstants.AECAMERA_MODE, 200);
        if (!bundle.containsKey(AECameraConstants.VIDEO_STORY_FROM_TYPE)) {
            bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.O.b());
        }
        bundle.putInt("entrance_type", 120);
        bundle.putInt("edit_video_type", 10028);
        bundle.putInt(AECameraConstants.CAPTURE_INTENT_MODE, 8);
        if (!bundle.getBoolean(PeakConstants.BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO, true)) {
            ms.a.f("AEFlashShowCameraLauncher", "[AdditionalPick] setDataForCircleAECamera---canNotPickVideo set only photo flag for camera");
            bundle.putInt("ability_flag", 2);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, Intent intent, Map<String, String> map, int i3, String str) {
        if (str == null) {
            str = "";
        }
        Bundle extras = intent.getExtras();
        if (!str.equals("15")) {
            if (!str.equals("21")) {
                p(context, extras, str, i3);
                return;
            }
            if (map != null) {
                i3 = B(map.get(QCircleScheme.AttrQQPublish.QZONE_ALBUM_REQUEST_CODE));
            }
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQZonePickerFragmentBySchema(context, intent, i3);
            return;
        }
        if (context instanceof Activity) {
            ((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).jumpToMagicStudioFragmentBySchema((Activity) context, intent, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bundle bundle) {
        if (bundle != null && "QCIRCLE".equals(bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME))) {
            ms.a.f("AEFlashShowCameraLauncher", "preFetchWorldMaterialList");
            ThreadManagerV2.excute(new LSDownloadMaterialRunnable(), 128, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(Context context) {
        QQToast.makeText(context, R.string.y6j, 0).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(final Context context, Bundle bundle, int i3) {
        boolean z16;
        String str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (bundle2.containsKey(QQWinkConstants.SPECIFIC_WINK_HOME_CLASS_TYPE)) {
            s(context, bundle2);
            return;
        }
        ms.a.f("AEFlashShowCameraLauncher", "AERes:launchForResult");
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchAllEssentialBundles();
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        A(bundle2);
        AEResUtil.W(AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType, j(bundle2));
        String l3 = l(bundle2.getString("AECAMERA_TAB_SELECTED"));
        HashMap<String, String> hashMap = (HashMap) bundle2.get("key_attrs");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (hashMap != null && !hashMap.isEmpty()) {
            if (hashMap.containsKey("target")) {
                buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_BUNDULE_INFO);
                buildElementParams.put("xsj_actiontype", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_PAITONGKUAN_EDIT_BUTTON_CLICK);
                l3 = hashMap.get("target");
                z16 = true;
                if (bundle2.getBoolean(QQWinkConstants.IS_BACK_EDIT)) {
                    if (bundle2.getBoolean(QQWinkConstants.IS_FROM_CAPTURE)) {
                        l3 = "0";
                    } else {
                        l3 = "1";
                    }
                }
                if (bundle2.getBoolean(QQWinkConstants.IS_TO_TEMPLATE_TAB)) {
                    bundle2.putBoolean(QQWinkConstants.IS_TO_TEMPLATE_TAB, false);
                    l3 = "2";
                }
                str = l3;
                if (hashMap != null && "1".equals(hashMap.get(QCircleScheme.AttrQQPublish.INNER_JUMP))) {
                    bundle2.putAll(((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).fillInnerJumpBundle(context, hashMap));
                    gq.c.t(bundle2);
                }
                if (hashMap == null && hashMap.containsKey(QCircleScheme.AttrQQPublish.WAIT_UNTIL_RES_READY) && Objects.equals(hashMap.get(QCircleScheme.AttrQQPublish.WAIT_UNTIL_RES_READY), "1")) {
                    WinkSchemaPreCheck.z(str != null ? str : "", j(bundle2), bundle2, hashMap, new a(intent, str, context, i3, false));
                    return;
                }
                boolean z17 = z16;
                boolean isFlashCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady(j(bundle2), !"3".equals(str) || "7".equals(str) || "6".equals(str) || "20".equals(str) || "19".equals(str));
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUNDLE_LFS_READY, Integer.valueOf(isFlashCameraResReady ? 1 : 0));
                if (com.tencent.aelight.camera.ae.report.b.b().c()) {
                    com.tencent.aelight.camera.ae.report.b.b().v("performance#camera_app#bundle_download", com.tencent.aelight.camera.ae.report.d.a(buildElementParams));
                }
                ms.a.f("AEFlashShowCameraLauncher", "cameraResReady: " + isFlashCameraResReady);
                if (!"5".equals(str)) {
                    t(context, intent, bundle2);
                } else if ("16".equals(str)) {
                    intent.putExtra("KEY_JUMP_TARGET", "16");
                    intent.putExtras(bundle2);
                    com.tencent.mobileqq.wink.f.y(context, intent);
                } else if ("1003".equals(str)) {
                    com.tencent.mobileqq.wink.picker.f.f324854a.g(context, bundle2, hashMap);
                } else if ("22".equals(str)) {
                    r(context, hashMap);
                } else if ("24".equals(str)) {
                    intent.putExtras(bundle2);
                    com.tencent.mobileqq.wink.f.q(context, intent);
                } else if ("25".equals(str)) {
                    intent.putExtras(bundle2);
                    com.tencent.mobileqq.wink.f.s(context, intent);
                } else if ("23".equals(str)) {
                    intent.putExtras(bundle2);
                    com.tencent.mobileqq.wink.g.f322861a.i(context, intent);
                } else if ("21".equals(str)) {
                    ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQZonePickerFragmentBySchema(context, intent, hashMap != null ? B(hashMap.get(QCircleScheme.AttrQQPublish.QZONE_ALBUM_REQUEST_CODE)) : i3);
                } else if (isFlashCameraResReady) {
                    ms.a.f("AEFlashShowCameraLauncher", "\u3010Choose\u3011 QIMCameraCaptureActivity, jumpTarget: " + str);
                    if ("6".equals(str)) {
                        intent.putExtra("KEY_JUMP_TARGET", "6");
                        intent.putExtras(bundle2);
                        com.tencent.mobileqq.wink.g.f322861a.o(context, intent, null);
                    } else if (!"3".equals(str) && !"7".equals(str)) {
                        if ("4".equals(str)) {
                            intent.putExtras(bundle2);
                            com.tencent.mobileqq.wink.g.f322861a.m(context, intent);
                        } else if ("1002".equals(str)) {
                            n(context, bundle2);
                        } else if ("12".equals(str)) {
                            com.tencent.mobileqq.wink.g.f322861a.g(context, bundle2);
                        } else if ("20".equals(str)) {
                            q(context, bundle2);
                        } else if ("19".equals(str)) {
                            com.tencent.mobileqq.wink.picker.g.f324860a.e(context, bundle2);
                        } else {
                            intent.putExtras(bundle2);
                            o(context, intent, hashMap, i3, str);
                        }
                    } else {
                        intent.putExtras(bundle2);
                        com.tencent.mobileqq.wink.f.u(context, intent, "");
                    }
                } else {
                    ms.a.f("AEFlashShowCameraLauncher", "\u3010Choose\u3011 CaptureQmcfSoDownloadActivity, jumpTarget: " + str);
                    VideoEnvironment64BitUtils.checkIs64bit();
                    if (z17 && str.equals("0")) {
                        bundle2.putString("AECAMERA_TAB_SELECTED", l(str));
                        v(context, bundle2, i3);
                    } else if (!"3".equals(str) && !"7".equals(str) && !"4".equals(str)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                AEFlashShowCameraLauncher.u(context);
                            }
                        });
                        if ("12".equals(str)) {
                            return;
                        }
                        if ("QZONE".equals(bundle2.getString(QQWinkConstants.ENTRY_BUSINESS_NAME))) {
                            bundle2.putBoolean(QQWinkConstants.KEY_IS_PICKER_FIRST_PAGE, true);
                        }
                        intent.putExtras(bundle2);
                        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0);
                        com.tencent.mobileqq.wink.picker.f.f324854a.h(context, intent);
                    } else {
                        if (hashMap == null) {
                            hashMap = new HashMap<>();
                        }
                        hashMap.put("target", "4");
                        bundle2.putSerializable("key_attrs", hashMap);
                        intent.putExtras(bundle2);
                        com.tencent.mobileqq.wink.g.f322861a.m(context, intent);
                    }
                }
                m(isFlashCameraResReady, false);
                y();
                z(bundle2);
            }
        } else {
            buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_BUNDULE_INFO);
            buildElementParams.put("xsj_actiontype", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_EDIT_BUTTON_CLICK);
        }
        z16 = false;
        if (bundle2.getBoolean(QQWinkConstants.IS_BACK_EDIT)) {
        }
        if (bundle2.getBoolean(QQWinkConstants.IS_TO_TEMPLATE_TAB)) {
        }
        str = l3;
        if (hashMap != null) {
            bundle2.putAll(((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).fillInnerJumpBundle(context, hashMap));
            gq.c.t(bundle2);
        }
        if (hashMap == null) {
        }
        boolean z172 = z16;
        boolean isFlashCameraResReady2 = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady(j(bundle2), !"3".equals(str) || "7".equals(str) || "6".equals(str) || "20".equals(str) || "19".equals(str));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUNDLE_LFS_READY, Integer.valueOf(isFlashCameraResReady2 ? 1 : 0));
        if (com.tencent.aelight.camera.ae.report.b.b().c()) {
        }
        ms.a.f("AEFlashShowCameraLauncher", "cameraResReady: " + isFlashCameraResReady2);
        if (!"5".equals(str)) {
        }
        m(isFlashCameraResReady2, false);
        y();
        z(bundle2);
    }
}

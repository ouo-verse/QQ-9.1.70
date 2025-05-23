package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.image.URLDrawable;
import com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi;
import com.tencent.qqnt.aio.gallery.NTAIOLayerLongShotPreview;
import com.tencent.qqnt.aio.longshot.LongShotNTManager;
import com.tencent.qqnt.aio.robot.screenshot.LongShotManagerForRobot;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ>\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002JF\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016JI\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOScreenShotApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "peerUin", "path", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;", "operationCode", "Lkotlin/Function0;", "", "exitShot", "handleScreenShotAction", "previewShotPic", "editShotPicture", "", "exitOnDismiss", "subBusiness", "handleComplete", "isRobotAIO", "showLongShotGuide", "aioScreenShotOperation", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/tencent/qqnt/aio/adapter/api/IAIOScreenShotApi$OperationCode;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOScreenShotApiImpl implements IAIOScreenShotApi {
    private static final String GUIDE_URL = "https://downv6.qq.com/qqface/mobileQQ_screenshot.gif";
    private static final String TAG = "AIOScreenShotApiImpl";

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f348560a;

        static {
            int[] iArr = new int[IAIOScreenShotApi.OperationCode.values().length];
            try {
                iArr[IAIOScreenShotApi.OperationCode.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IAIOScreenShotApi.OperationCode.EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IAIOScreenShotApi.OperationCode.COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IAIOScreenShotApi.OperationCode.MULTISELCT_SHARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f348560a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ3\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOScreenShotApiImpl$c", "Lmqq/app/QQPermissionCallback;", "", "reqeustCode", "", "", "permissions", "", "reuslts", "", "grant", "(I[Ljava/lang/String;[I)V", "deny", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements QQPermissionCallback {
        final /* synthetic */ Function0<Unit> C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f348561d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOScreenShotApiImpl f348562e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f348563f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f348564h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bitmap f348565i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ IAIOScreenShotApi.OperationCode f348566m;

        c(Activity activity, AIOScreenShotApiImpl aIOScreenShotApiImpl, String str, String str2, Bitmap bitmap, IAIOScreenShotApi.OperationCode operationCode, Function0<Unit> function0) {
            this.f348561d = activity;
            this.f348562e = aIOScreenShotApiImpl;
            this.f348563f = str;
            this.f348564h = str2;
            this.f348565i = bitmap;
            this.f348566m = operationCode;
            this.C = function0;
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int reqeustCode, String[] permissions, int[] reuslts) {
            QLog.i(AIOScreenShotApiImpl.TAG, 1, "permission grant");
            if (!((QBaseActivity) this.f348561d).isFinishing() && !((QBaseActivity) this.f348561d).isDestroyed()) {
                this.f348562e.handleScreenShotAction(this.f348561d, this.f348563f, this.f348564h, this.f348565i, this.f348566m, this.C);
            } else {
                QLog.i(AIOScreenShotApiImpl.TAG, 1, "permission grant, activity finish");
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int reqeustCode, String[] permissions, int[] reuslts) {
            QLog.i(AIOScreenShotApiImpl.TAG, 1, "permission deny");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOScreenShotApiImpl$d", "Lcom/tencent/qqnt/aio/adapter/api/c;", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.qqnt.aio.adapter.api.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f348567a;

        d(Function0<Unit> function0) {
            this.f348567a = function0;
        }

        @Override // com.tencent.qqnt.aio.adapter.api.c
        public void a() {
            this.f348567a.invoke();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOScreenShotApiImpl$e", "Lcom/tencent/qqnt/aio/adapter/api/c;", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.qqnt.aio.adapter.api.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f348568a;

        e(Function0<Unit> function0) {
            this.f348568a = function0;
        }

        @Override // com.tencent.qqnt.aio.adapter.api.c
        public void a() {
            this.f348568a.invoke();
        }
    }

    private final void handleComplete(Activity activity, String peerUin, Bitmap bitmap, String path, Function0<Unit> exitShot, boolean exitOnDismiss, String subBusiness) {
        if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(peerUin)) {
            LongShotManagerForRobot.INSTANCE.a().y(activity, bitmap, path, new d(exitShot), exitOnDismiss, subBusiness);
        } else {
            LongShotNTManager.INSTANCE.a().I(activity, path, new e(exitShot));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleScreenShotAction(Activity activity, String peerUin, String path, Bitmap bitmap, IAIOScreenShotApi.OperationCode operationCode, Function0<Unit> exitShot) {
        int i3 = b.f348560a[operationCode.ordinal()];
        if (i3 == 1) {
            previewShotPic(activity, peerUin, path);
            return;
        }
        if (i3 == 2) {
            editShotPicture(activity, peerUin, path);
        } else if (i3 == 3) {
            handleComplete(activity, peerUin, bitmap, path, exitShot, false, "select_screenshot");
        } else {
            if (i3 != 4) {
                return;
            }
            handleComplete(activity, peerUin, bitmap, path, exitShot, true, "msg_select");
        }
    }

    private final void previewShotPic(Activity activity, String peerUin, String path) {
        Bundle bundle;
        List listOf;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setMediaId(path);
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerItemMediaInfo.setMediaId(path);
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWLayerItemMediaInfo.setMediaId(path);
        rFWPicInfo.setLocalPath(path);
        rFWPicInfo.setUrl(path);
        rFWLayerPicInfo.setBigPicInfo(rFWPicInfo);
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(peerUin)) {
            bundle = new Bundle();
            bundle.putBoolean("key_complete_share_preview", true);
        } else {
            bundle = null;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(rFWLayerItemMediaInfo);
        RFWLayerLaunchUtil.jumpToGallery(activity, null, listOf, 0, QQGalleryActivity.class, NTAIOLayerLongShotPreview.class, bundle, 18004);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi
    public Object aioScreenShotOperation(Activity activity, String str, String str2, Bitmap bitmap, IAIOScreenShotApi.OperationCode operationCode, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        if (LongShotNTManager.INSTANCE.b()) {
            handleScreenShotAction(activity, str, str2, bitmap, operationCode, function0);
            return Unit.INSTANCE;
        }
        String[] strArr = {QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
        boolean z16 = false;
        for (int i3 = 0; i3 < 2; i3++) {
            if (activity.checkSelfPermission(strArr[i3]) != 0) {
                z16 = true;
            }
        }
        if (z16) {
            if (activity instanceof QBaseActivity) {
                ((QBaseActivity) activity).requestPermissions(new c(activity, this, str, str2, bitmap, operationCode, function0), 1, (String[]) Arrays.copyOf(strArr, 2));
            } else {
                PermissionMonitor.requestPermissions(activity, strArr, 1);
            }
            if (operationCode == IAIOScreenShotApi.OperationCode.MULTISELCT_SHARE) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
        handleScreenShotAction(activity, str, str2, bitmap, operationCode, function0);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r0.isInMultiWindow() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void editShotPicture(Activity activity, String peerUin, String path) {
        boolean z16;
        HashMap<String, Object> hashMap;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            QQToast.makeText(activity, R.string.lwl, 0).show();
            return;
        }
        if (hf0.a.b(TAG, 500L)) {
            return;
        }
        if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(peerUin)) {
            hashMap = new HashMap<>();
            hashMap.put("extra_complete_preview_share", Boolean.TRUE);
        } else {
            hashMap = null;
        }
        activity.startActivityForResult(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(activity, path, true, true, true, true, true, false, false, false, 2, 122, 0, false, hashMap), 18003);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi
    public void showLongShotGuide(boolean isRobotAIO) {
        int a16 = com.tencent.mobileqq.utils.x.a(248.0f);
        int i3 = (int) ((a16 * 420.0f) / JsApiEnableDeviceOrientation.CTRL_INDEX);
        BaseApplication baseApplication = BaseApplication.context;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mRequestWidth = a16;
        obtain.mRequestHeight = i3;
        obtain.mLoadingDrawable = ResourcesCompat.getDrawable(baseApplication.getResources(), R.drawable.ljo, baseApplication.getTheme());
        URLDrawable drawable = URLDrawable.getDrawable(GUIDE_URL, obtain);
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(qBaseActivity, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.yrs));
            qQCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.yrr));
            qQCustomDialog.setPreviewImage(drawable, true, 0);
            qQCustomDialog.setPreviewFixDimension(a16, i3);
            qQCustomDialog.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
            qQCustomDialog.setPositiveButton(R.string.yrq, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.x
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    dialogInterface.dismiss();
                }
            });
            qQCustomDialog.setCanceledOnTouchOutside(false);
            if (isRobotAIO) {
                qQCustomDialog.setBackground(R.drawable.qui_toast_and_dialog_background);
            }
            qQCustomDialog.show();
        }
    }
}

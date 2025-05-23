package com.tencent.qqnt.camera.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.nt.adapter.session.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.camera.api.ICameraAPI;
import com.tencent.qqnt.camera.data.CameraReq;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0002J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/camera/api/impl/CameraAPIImpl;", "Lcom/tencent/qqnt/camera/api/ICameraAPI;", "Ldov/com/qq/im/ae/current/SessionWrap;", "sessionWrap", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "startCamera", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "openCamera", SessionDbHelper.SESSION_ID, "innerOpenCamera", "", "isTempAIO", "getFullInputState", "Lkotlin/Function0;", "grantCallback", "requestCameraPermission", "context", "Lcom/tencent/qqnt/camera/data/CameraReq;", "req", "Law3/a;", "callback", "startCameraAndCallback", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "startCameraForOldSessionType", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CameraAPIImpl implements ICameraAPI {
    public static final String INT_STORY_CAPTURE_ABILITY_FLAG = "ability_flag";
    public static final String TAG = "CameraAPIImpl";

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/camera/api/impl/CameraAPIImpl$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f353262a;

        b(Function0<Unit> function0) {
            this.f353262a = function0;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f353262a.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        if (((r9 == null || (r7 = r9.g()) == null || (r7 = r7.r()) == null || (r7 = r7.c()) == null || r7.e() != 8) ? false : true) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void innerOpenCamera(SessionWrap session, Activity activity, com.tencent.aio.api.runtime.a aioContext) {
        js.a aVar;
        Bundle c16 = StoryPublishLauncher.c(session, activity.getClass().getName(), 10000, 100);
        boolean isTempAIO = isTempAIO(session);
        boolean fullInputState = getFullInputState(aioContext);
        boolean b16 = r61.a.b();
        if (b16) {
            aVar = js.a.Q;
        } else {
            aVar = js.a.f410908h;
        }
        int i3 = 200;
        if (!b16 && !fullInputState) {
            i3 = 201;
        }
        c16.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        c16.putInt(AECameraConstants.AECAMERA_MODE, i3);
        if (b16) {
            c16.putInt(PeakConstants.ARG_FORCE_CAMERA, 2);
        }
        if (!isTempAIO && !fullInputState) {
        }
        c16.putInt("ability_flag", 2);
        c16.putInt("qq_sub_business_id", 106);
        c16.putBoolean(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, fullInputState);
        StoryPublishLauncher.d().k(activity, c16, 11);
        ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).print(false);
        ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).endSession();
    }

    private final boolean isTempAIO(SessionWrap session) {
        int i3 = session.f394449f;
        return i3 == 1000 || i3 == 1001 || i3 == 1046 || i3 == 1006 || i3 == 1025 || i3 == 10007 || i3 == 1022 || i3 == 10008;
    }

    private final void openCamera(QQAppInterface app, final SessionWrap sessionWrap, final Activity activity, final com.tencent.aio.api.runtime.a aioContext) {
        if (((ICaptureUtil) QRoute.api(ICaptureUtil.class)).getFreesiaSupportCapture()) {
            requestCameraPermission(activity, new Function0<Unit>() { // from class: com.tencent.qqnt.camera.api.impl.CameraAPIImpl$openCamera$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CameraAPIImpl.this.innerOpenCamera(sessionWrap, activity, aioContext);
                }
            });
        } else if (((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture() && !((ICaptureUtil) QRoute.api(ICaptureUtil.class)).getForceSysCamForTest()) {
            requestCameraPermission(activity, new Function0<Unit>() { // from class: com.tencent.qqnt.camera.api.impl.CameraAPIImpl$openCamera$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CameraAPIImpl.this.innerOpenCamera(sessionWrap, activity, aioContext);
                }
            });
        } else {
            PlusPanelUtils.e(app, activity, QBaseActivity.sTopActivity, 0, 17001, true);
        }
    }

    private final void requestCameraPermission(Activity activity, Function0<Unit> grantCallback) {
        boolean z16 = activity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
        LinkedList linkedList = new LinkedList();
        if (z16) {
            linkedList.add(QQPermissionConstants.Permission.CAMERA);
        }
        if (!z16) {
            grantCallback.invoke();
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_CAMERA, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_CAMERA));
        Object[] array = linkedList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        qQPermission.requestPermissions((String[]) array, 2, new b(grantCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCamera(SessionWrap sessionWrap, Activity activity, com.tencent.aio.api.runtime.a aioContext) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            l61.a.b((BaseQQAppInterface) peekAppRuntime, "0X8005E91", sessionWrap.f394449f);
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            if (qQAppInterface.isUsingCameraOnVideo()) {
                QQToast.makeText(BaseApplication.getContext(), R.string.dkm, 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            } else {
                openCamera(qQAppInterface, sessionWrap, activity, aioContext);
            }
        }
    }

    @Override // com.tencent.qqnt.camera.api.ICameraAPI
    public void startCameraAndCallback(com.tencent.aio.api.runtime.a context, CameraReq req, aw3.a callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong("pre_load_peak_expiration_time", System.currentTimeMillis() + 604800000);
        AIOContact c16 = context.g().r().c();
        c.c(c16.e());
        QLog.d(TAG, 1, "contact.chatType: " + c16.e());
        c.h(c16.j(), c16.e(), new CameraAPIImpl$startCameraAndCallback$1(this, c16, context));
    }

    @Override // com.tencent.qqnt.camera.api.ICameraAPI
    public void startCameraForOldSessionType(AIOContact aioContact, com.tencent.aio.api.runtime.a context, Activity activity) {
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        startCamera(new SessionWrap(aioContact.j(), aioContact.g(), aioContact.e(), aioContact.j()), activity, context);
    }

    private final boolean getFullInputState(com.tencent.aio.api.runtime.a aioContext) {
        j e16;
        k k3 = (aioContext == null || (e16 = aioContext.e()) == null) ? null : e16.k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        e.a aVar = k3 instanceof e.a ? (e.a) k3 : null;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    static /* synthetic */ void startCamera$default(CameraAPIImpl cameraAPIImpl, SessionWrap sessionWrap, Activity activity, com.tencent.aio.api.runtime.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        cameraAPIImpl.startCamera(sessionWrap, activity, aVar);
    }
}

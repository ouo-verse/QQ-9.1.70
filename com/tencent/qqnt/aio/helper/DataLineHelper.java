package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.dataline.activities.LiteActivity;
import com.tencent.aio.api.runtime.emitter.a;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.IWifiPhotoTempApi;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.DataLineHelper$mAction$2;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001/\b\u0007\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b0\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/helper/DataLineHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "j", "", "isClick", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "g", "", "appId", "", "shareAppName", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "onBackEvent", "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "Z", "isOpenFromShare", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "shareResultDlg", "com/tencent/qqnt/aio/helper/DataLineHelper$mAction$2$a", "i", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/aio/helper/DataLineHelper$mAction$2$a;", "mAction", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class DataLineHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.runtime.emitter.a, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isOpenFromShare;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQCustomDialog shareResultDlg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/helper/DataLineHelper$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IWifiPhotoService iWifiPhotoService = (IWifiPhotoService) QRoute.api(IWifiPhotoService.class);
            Activity activity = DataLineHelper.this.activity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                activity = null;
            }
            iWifiPhotoService.enterWifiPhoto(activity, "/wifi_photo/push_apply", 1);
        }
    }

    public DataLineHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DataLineHelper$mAction$2.a>() { // from class: com.tencent.qqnt.aio.helper.DataLineHelper$mAction$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/DataLineHelper$mAction$2$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mvi.base.route.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DataLineHelper f350320d;

                a(DataLineHelper dataLineHelper) {
                    this.f350320d = dataLineHelper;
                }

                @Override // com.tencent.mvi.base.route.a
                public void call(MsgIntent intent) {
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    this.f350320d.j(intent);
                }

                @Override // com.tencent.mvi.base.route.a
                public boolean sticky() {
                    return a.C9235a.a(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(DataLineHelper.this);
            }
        });
        this.mAction = lazy;
    }

    private final void g() {
        Activity activity = this.activity;
        AbsShareMsg absShareMsg = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        Bundle extras = activity.getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity2 = null;
        }
        long longExtra = activity2.getIntent().getLongExtra("req_share_id", 0L);
        if (!this.isOpenFromShare) {
            this.isOpenFromShare = extras.getBoolean(AppConstants.Key.SHARE_FLAG);
        }
        boolean z16 = extras.getBoolean("refuse_show_share_result_dialog", false);
        if (!this.isOpenFromShare || z16) {
            return;
        }
        String string = extras.getString("app_name");
        if (longExtra == 0) {
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(extras);
            if (e16 != null && (e16 instanceof AbsShareMsg)) {
                absShareMsg = (AbsShareMsg) e16;
            }
            if (absShareMsg != null) {
                longExtra = absShareMsg.mSourceAppid;
            }
        }
        n(longExtra, string);
    }

    private final void h() {
        if (!this.isOpenFromShare || m()) {
            return;
        }
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        RouteUtils.startActivity(activity, new Intent(), RouterConstants.UI_ROUTER_SPLASH);
    }

    private final DataLineHelper$mAction$2.a i() {
        return (DataLineHelper$mAction$2.a) this.mAction.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOTitleEvent.Right3IvClickEvent) {
            k();
        }
    }

    private final boolean m() {
        return (SplashActivity.sWeakInstance == null || SplashActivity.sWeakInstance.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Intent intent, QQAppInterface app, long j3, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(app, "$app");
        if (intent.getIntExtra("forward_type", -1) == 11) {
            ReportCenter.f().p(app.getAccount(), "", String.valueOf(j3), "1000", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "0", false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("DataLineHelper", 2, "qbShowShareResultDialog stay");
        }
        if (intent.getBooleanExtra("MigSdkShareNotDone", false)) {
            intent.putExtra("MigSdkShareNotDone", false);
        }
    }

    private final void q(boolean isClick) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
        Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
        linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, DATALINE_PC_UIN);
        if (isClick) {
            com.tencent.mobileqq.aio.utils.b.l("em_bas_export_phone_album", linkedHashMap);
        } else {
            com.tencent.mobileqq.aio.utils.b.q("em_bas_export_phone_album", linkedHashMap);
        }
    }

    private final void r(final com.tencent.aio.api.runtime.a aioContext) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105473", false) || PadUtil.a(aioContext.c().requireContext()) == DeviceType.TABLET || Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, aioContext.g().r().c().j())) {
            return;
        }
        final MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(aioContext.c().requireContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(aioContext.fragme\u2026), QMMKVFile.FILE_COMMON)");
        final String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        final boolean z16 = fromV2.getBoolean(currentUin + "_wifi_photo_aio_bubble", false);
        com.tencent.mvi.base.route.j e16 = aioContext.e();
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        e16.h(new AIOTitleEvent.UpdateRight3IvEvent(false, true, activity.getDrawable(R.drawable.f159649cz), "", new Function1<View, Unit>() { // from class: com.tencent.qqnt.aio.helper.DataLineHelper$showExportAlbum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.setContentDescription("\u5bfc\u51fa\u624b\u673a\u76f8\u518c");
                if (z16) {
                    return;
                }
                com.tencent.mobileqq.widget.tip.a.r(aioContext.c().requireContext()).S(it).k0(1).R(0).o0("\u5bfc\u51fa\u624b\u673a\u76f8\u518c").p0(aioContext.c().requireContext().getColor(R.color.qui_common_text_white)).W(aioContext.c().requireContext().getColor(R.color.qui_common_bg_top_dark)).j0(10.0f, 8.0f, 10.0f, 8.0f).e0(true).T(aioContext.c().requireContext().getDrawable(R.drawable.m96)).b0(5000L).s0();
                fromV2.putBoolean(currentUin + "_wifi_photo_aio_bubble", true);
                fromV2.apply();
            }
        }));
        aioContext.e().f(this, i());
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 58;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.Right3IvClickEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "DataLineHelper";
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        Activity activity = this.activity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        }
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        boolean booleanExtra = intent.getBooleanExtra("isMigSdkShare", false);
        if (!this.isOpenFromShare) {
            return a.C0623a.a(this);
        }
        if (booleanExtra) {
            long longExtra = intent.getLongExtra("req_share_id", 0L);
            if (longExtra > 0) {
                Activity activity3 = this.activity;
                if (activity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    activity2 = activity3;
                }
                ForwardSdkBaseOption.F(activity2, true, "sendToMyComputer", longExtra);
            }
            return a.C0623a.a(this);
        }
        long longExtra2 = intent.getLongExtra(AppConstants.Key.SHARE_RES_ID, 0L);
        if (longExtra2 > 0) {
            Activity activity4 = this.activity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            } else {
                activity2 = activity4;
            }
            ForwardSdkBaseOption.F(activity2, true, "shareToQQ", com.tencent.mobileqq.utils.h.f(longExtra2));
        }
        h();
        return a.C0623a.a(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.helperParam = param;
        FragmentActivity requireActivity = param.a().c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "param.aioContext.fragment.requireActivity()");
        this.activity = requireActivity;
        g();
        r(param.a());
        ((IExportFileService) QRoute.api(IExportFileService.class)).registerAccountCallback();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    private final void k() {
        q(true);
        Activity activity = null;
        if (((IWifiPhotoTempApi) QRoute.api(IWifiPhotoTempApi.class)).isPcLock()) {
            Activity activity2 = this.activity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            } else {
                activity = activity2;
            }
            QQToast.makeText(activity, "QQ\u5728\u7535\u8111\u4e0a\u5df2\u9501\u5b9a\uff0c\u8bf7\u89e3\u9501\u540e\u91cd\u8bd5", 0).show();
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            Activity activity3 = this.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            } else {
                activity = activity3;
            }
            QQToast.makeText(activity, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", 0).show();
            return;
        }
        Activity activity4 = this.activity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity4 = null;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity4, new BusinessConfig(QQPermissionConstants.Business.ID.DATALINE, QQPermissionConstants.Business.SCENE.DATALINE_EXPORT_PHOTO));
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            IWifiPhotoService iWifiPhotoService = (IWifiPhotoService) QRoute.api(IWifiPhotoService.class);
            Activity activity5 = this.activity;
            if (activity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            } else {
                activity = activity5;
            }
            iWifiPhotoService.enterWifiPhoto(activity, "/wifi_photo/push_apply", 1);
            return;
        }
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    private final void n(final long appId, String shareAppName) {
        final Activity activity;
        Activity activity2;
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity3 = null;
        }
        final Intent intent = activity3.getIntent();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        Activity activity4 = this.activity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity4 = null;
        }
        if (activity4.isFinishing()) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.shareResultDlg;
        if (qQCustomDialog != null) {
            if (qQCustomDialog != null) {
                qQCustomDialog.show();
                return;
            }
            return;
        }
        Activity activity5 = this.activity;
        if (activity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity = null;
        } else {
            activity = activity5;
        }
        String string = activity.getString(R.string.hih);
        if (shareAppName != null) {
            string = string + shareAppName;
        }
        String str = string;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.ao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DataLineHelper.o(intent, qQAppInterface, appId, dialogInterface, i3);
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.ap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DataLineHelper.p(intent, qQAppInterface, appId, this, activity, dialogInterface, i3);
            }
        };
        String string2 = qQAppInterface.getApplication().getString(R.string.hik);
        Intrinsics.checkNotNullExpressionValue(string2, "app.application.getStrin\u2026re_aio_dialog_titile_suc)");
        String string3 = qQAppInterface.getApplication().getString(R.string.hii);
        Intrinsics.checkNotNullExpressionValue(string3, "app.application.getStrin\u2026hare_aio_dialog_btn_stay)");
        Activity activity6 = this.activity;
        if (activity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            activity2 = null;
        } else {
            activity2 = activity6;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity2, 232, (String) null, string2, str, string3, onClickListener, onClickListener2);
        this.shareResultDlg = createCustomDialog;
        if (createCustomDialog != null) {
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Intent intent, QQAppInterface app, long j3, DataLineHelper this$0, Context context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (intent.getIntExtra("forward_type", -1) == 11) {
            ReportCenter.f().p(app.getAccount(), "", String.valueOf(j3), "1000", "51", "0", false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("DataLineHelper", 2, "qbShowShareResultDialog back");
        }
        Activity activity = null;
        if (intent.getBooleanExtra("MigSdkShareNotDone", false)) {
            intent.putExtra("MigSdkShareNotDone", false);
            Activity activity2 = this$0.activity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                activity2 = null;
            }
            ForwardSdkBaseOption.F(activity2, true, "sendToMyComputer", j3);
        } else {
            Activity activity3 = this$0.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                activity3 = null;
            }
            ForwardSdkBaseOption.F(activity3, true, "shareToQQ", j3);
        }
        com.tencent.biz.common.util.k.k(context, 0, "", "");
        boolean booleanExtra = intent.getBooleanExtra("show_share_result_dialog_return_thirdapp", true);
        Bundle bundle = new Bundle();
        if (booleanExtra) {
            bundle.putBoolean(SplashActivity.SWITCH_ANIM, false);
        }
        com.tencent.aio.main.businesshelper.b bVar = this$0.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().e().h(new ExternalCommIntent("close_aio", bundle));
        if (booleanExtra) {
            try {
                Activity activity4 = this$0.activity;
                if (activity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    activity4 = null;
                }
                PendingIntent pendingIntent = (PendingIntent) activity4.getIntent().getParcelableExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                if (pendingIntent != null) {
                    Activity activity5 = this$0.activity;
                    if (activity5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        activity5 = null;
                    }
                    if (!activity5.getIntent().getBooleanExtra("share_from_aio", false)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DataLineHelper", 2, "-->finish--send callback using PendingIntent");
                        }
                        try {
                            pendingIntent.send();
                            Activity activity6 = this$0.activity;
                            if (activity6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                                activity6 = null;
                            }
                            activity6.getIntent().removeExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT);
                        } catch (PendingIntent.CanceledException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("DataLineHelper", 2, "failed to send PendingIntent", e16);
                            }
                        }
                    }
                }
                Activity activity7 = this$0.activity;
                if (activity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    activity = activity7;
                }
                activity.moveTaskToBack(true);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(LiteActivity.f32035e1, 2, "qbShowShareResultDialog ", th5);
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}

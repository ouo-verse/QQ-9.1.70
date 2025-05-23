package com.tencent.mobileqq.nearbypro.part.guide;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearbypro.part.guide.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\b\t*\u0001.\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/j;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "", "R9", "", "L9", "M9", "K9", "displayed", "S9", "O9", "Q9", "P9", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "", "action", "", "args", "handleBroadcastMessage", "onPartDestroy", "onBackEvent", "f", "Landroid/view/View;", "mAnchorView", "Lcom/tencent/mobileqq/nearbypro/part/guide/NearbyProGuideDialog;", tl.h.F, "Lcom/tencent/mobileqq/nearbypro/part/guide/NearbyProGuideDialog;", "mGuideDialog", "", "i", "J", "mLastDismissMillisTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mHasLocationPermission", BdhLogUtil.LogTag.Tag_Conn, "mHasCheckedLocationPermission", "D", "mStudyLimit", "com/tencent/mobileqq/nearbypro/part/guide/j$c", "E", "Lcom/tencent/mobileqq/nearbypro/part/guide/j$c;", "mGuideDialogCallback", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class j extends com.tencent.mobileqq.nearbypro.part.e {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mHasCheckedLocationPermission;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mStudyLimit = true;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c mGuideDialogCallback = new c();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAnchorView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NearbyProGuideDialog mGuideDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mLastDismissMillisTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasLocationPermission;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J(\u0010\u0010\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016R\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/nearbypro/part/guide/j$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "deniedPermissions", "", "isShowGuide", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "onDeniedWithoutShowDlg", "a", "Z", "hasClickSetting", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasClickSetting;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(j this$0, b this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = this$0.getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "tryToRequestLocationPermission onDialogShow hasClickSetting true");
            this$1.hasClickSetting = true;
            if (this$0.getContext() != null) {
                PermissionUtil.gotoSettingPage(this$0.getContext());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b this$0, j this$1, DialogInterface dialogInterface) {
            Activity hostActivity;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!this$0.hasClickSetting) {
                ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                String logTag = this$1.getTAG();
                Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
                c16.e(logTag, "tryToRequestLocationPermission onDialogShow hasClickSetting false. finish");
                IPartHost partHost = this$1.getPartHost();
                if (partHost != null && (hostActivity = partHost.getHostActivity()) != null) {
                    hostActivity.finish();
                }
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            View b06;
            super.onAllGranted();
            NearbyProGuideDialog nearbyProGuideDialog = j.this.mGuideDialog;
            if (nearbyProGuideDialog != null && (b06 = nearbyProGuideDialog.b0()) != null) {
                com.tencent.mobileqq.nearbypro.part.guide.b.f253690a.a(b06, true);
            }
            j.this.mHasLocationPermission = true;
            j jVar = j.this;
            jVar.broadcastMessage("has_location_permission", Boolean.valueOf(jVar.mHasLocationPermission));
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = j.this.getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "tryToRequestLocationPermission onAllGranted");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            View b06;
            super.onDenied(permissions, results);
            boolean P9 = j.this.P9();
            NearbyProGuideDialog nearbyProGuideDialog = j.this.mGuideDialog;
            if (nearbyProGuideDialog != null && (b06 = nearbyProGuideDialog.b0()) != null) {
                com.tencent.mobileqq.nearbypro.part.guide.b.f253690a.a(b06, P9);
            }
            if (P9) {
                j.this.mHasLocationPermission = true;
                j jVar = j.this;
                jVar.broadcastMessage("has_location_permission", Boolean.valueOf(jVar.mHasLocationPermission));
            }
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = j.this.getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "tryToRequestLocationPermission onDenied");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            Activity hostActivity;
            super.onDeniedWithoutShowDlg(permissions, results);
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = j.this.getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "tryToRequestLocationPermission onDeniedWithoutShowDlg. finish");
            IPartHost partHost = j.this.getPartHost();
            if (partHost != null && (hostActivity = partHost.getHostActivity()) != null) {
                hostActivity.finish();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            Activity hostActivity;
            super.onDialogShow(dialog, deniedPermissions);
            if (dialog == null) {
                ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                String logTag = j.this.getTAG();
                Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
                c16.e(logTag, "tryToRequestLocationPermission onDialogShow dialog is null. finish");
                IPartHost partHost = j.this.getPartHost();
                if (partHost != null && (hostActivity = partHost.getHostActivity()) != null) {
                    hostActivity.finish();
                    return;
                }
                return;
            }
            final j jVar = j.this;
            dialog.setOnSettingClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.b.c(j.this, this, view);
                }
            });
            final j jVar2 = j.this;
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.l
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    j.b.d(j.b.this, jVar2, dialogInterface);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/nearbypro/part/guide/j$c", "Lcom/tencent/mobileqq/nearbypro/part/guide/c;", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements com.tencent.mobileqq.nearbypro.part.guide.c {
        c() {
        }

        @Override // com.tencent.mobileqq.nearbypro.part.guide.c
        public void a() {
            j.this.O9();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/nearbypro/part/guide/j$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = j.this.getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "onViewAttachedToWindow");
            j.this.R9();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = j.this.getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "onViewDetachedFromWindow");
        }
    }

    private final boolean K9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool("nearby_guide_displayed_flag" + peekAppRuntime.getCurrentAccountUin(), true);
    }

    private final boolean L9() {
        if (NetConnInfoCenter.getServerTimeMillis() - this.mLastDismissMillisTime > 1000) {
            return true;
        }
        return false;
    }

    private final boolean M9() {
        boolean z16;
        boolean z17;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final QQPermission.BasePermissionsListener N9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        this.mLastDismissMillisTime = NetConnInfoCenter.getServerTimeMillis();
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        String logTag = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.e(logTag, "handleDismissed time = " + this.mLastDismissMillisTime);
        NearbyProGuideDialog nearbyProGuideDialog = this.mGuideDialog;
        boolean z16 = false;
        if (nearbyProGuideDialog != null && nearbyProGuideDialog.getMHasClickEnter()) {
            z16 = true;
        }
        if (z16) {
            Q9();
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P9() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        if (qQPermission == null || qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return false;
        }
        return true;
    }

    private final void Q9() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            c16.e(logTag, "tryToRequestLocationPermission");
            qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2, N9());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        boolean z16;
        if (getContext() != null && !this.mStudyLimit) {
            View view = this.mAnchorView;
            boolean z17 = false;
            if (view != null && !view.isAttachedToWindow()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                NearbyProGuideDialog nearbyProGuideDialog = this.mGuideDialog;
                if (nearbyProGuideDialog != null && nearbyProGuideDialog.c0()) {
                    z17 = true;
                }
                if (!z17 && L9()) {
                    if (M9() && K9()) {
                        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
                        String logTag = getTAG();
                        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
                        c16.e(logTag, "check success. return");
                        broadcastMessage("is_guide_limit", Boolean.FALSE);
                        return;
                    }
                    broadcastMessage("is_guide_limit", Boolean.TRUE);
                    if (this.mGuideDialog == null) {
                        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                        View view2 = this.mAnchorView;
                        Intrinsics.checkNotNull(view2);
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        this.mGuideDialog = new NearbyProGuideDialog(new NearbyProGuideContext(lifecycleOwner, view2, context), this.mGuideDialogCallback);
                    }
                    ga2.a c17 = com.tencent.mobileqq.nearbypro.base.j.c();
                    String logTag2 = getTAG();
                    Intrinsics.checkNotNullExpressionValue(logTag2, "logTag");
                    c17.e(logTag2, "tryToShowGuide showWindow");
                    NearbyProGuideDialog nearbyProGuideDialog2 = this.mGuideDialog;
                    Intrinsics.checkNotNull(nearbyProGuideDialog2);
                    nearbyProGuideDialog2.showDialog();
                    S9(true);
                    return;
                }
            }
        }
        ga2.a c18 = com.tencent.mobileqq.nearbypro.base.j.c();
        String logTag3 = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag3, "logTag");
        c18.e(logTag3, "mGuideWindow check condition return");
    }

    private final void S9(boolean displayed) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool("nearby_guide_displayed_flag" + peekAppRuntime.getCurrentAccountUin(), displayed);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        Boolean bool;
        boolean z16;
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "is_study_limit")) {
            if (args instanceof Boolean) {
                bool = (Boolean) args;
            } else {
                bool = null;
            }
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = true;
            }
            this.mStudyLimit = z16;
            R9();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.c0() == true) goto L8;
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onBackEvent() {
        boolean z16;
        NearbyProGuideDialog nearbyProGuideDialog;
        NearbyProGuideDialog nearbyProGuideDialog2 = this.mGuideDialog;
        if (nearbyProGuideDialog2 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && (nearbyProGuideDialog = this.mGuideDialog) != null) {
            nearbyProGuideDialog.dismiss();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        this.mAnchorView = rootView;
        if (rootView != null) {
            rootView.addOnAttachStateChangeListener(new d());
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        NearbyProGuideDialog nearbyProGuideDialog = this.mGuideDialog;
        if (nearbyProGuideDialog != null) {
            nearbyProGuideDialog.dismiss();
        }
        NearbyProGuideDialog nearbyProGuideDialog2 = this.mGuideDialog;
        if (nearbyProGuideDialog2 != null) {
            nearbyProGuideDialog2.onDestroy();
        }
        this.mGuideDialog = null;
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        String logTag = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.e(logTag, "onPartResume tryToShowGuide");
        boolean M9 = M9();
        if (!this.mHasCheckedLocationPermission || this.mHasLocationPermission != M9) {
            this.mHasCheckedLocationPermission = true;
            this.mHasLocationPermission = M9;
            broadcastMessage("has_location_permission", Boolean.valueOf(M9));
        }
        R9();
    }
}

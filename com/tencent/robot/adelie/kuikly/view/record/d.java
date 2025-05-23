package com.tencent.robot.adelie.kuikly.view.record;

import android.app.Activity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J3\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/record/d;", "", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "", "permissions", "Lkotlin/Function0;", "", "grantedCallback", "b", "(Lcom/tencent/mobileqq/qqpermission/QQPermission;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "failedCallback", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f366806a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/adelie/kuikly/view/record/d$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f366807a;

        a(Function0<Unit> function0) {
            this.f366807a = function0;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f366807a.invoke();
        }
    }

    d() {
    }

    private final void b(QQPermission permission, String[] permissions, Function0<Unit> grantedCallback) {
        permission.requestPermissions(permissions, 2, new a(grantedCallback));
    }

    public final void a(@NotNull Activity activity, @NotNull Function0<Unit> grantedCallback, @NotNull Function0<Unit> failedCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(grantedCallback, "grantedCallback");
        Intrinsics.checkNotNullParameter(failedCallback, "failedCallback");
        String[] strArr = {QQPermissionConstants.Permission.RECORD_AUDIO};
        QQPermission permission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_RECORD_AUDIO_PANEL));
        boolean z16 = false;
        if (permission.hasPermission(strArr[0]) == 0) {
            z16 = true;
        }
        if (z16) {
            grantedCallback.invoke();
            return;
        }
        failedCallback.invoke();
        Intrinsics.checkNotNullExpressionValue(permission, "permission");
        b(permission, strArr, grantedCallback);
    }
}

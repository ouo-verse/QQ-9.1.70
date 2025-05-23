package com.tencent.qqnt.pluspanel.processor;

import androidx.fragment.app.Fragment;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J3\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/RobotPttOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function0;", "", "grantedCallback", "b", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "", "permissions", "c", "(Lcom/tencent/mobileqq/qqpermission/QQPermission;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RobotPttOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/pluspanel/processor/RobotPttOnClickProcessor$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f360482a;

        b(Function0<Unit> function0) {
            this.f360482a = function0;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f360482a.invoke();
        }
    }

    private final void b(Fragment fragment, Function0<Unit> grantedCallback) {
        String[] strArr = {QQPermissionConstants.Permission.RECORD_AUDIO};
        QQPermission qqPermission = QQPermissionFactory.getQQPermission(fragment, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_RECORD_AUDIO_PANEL));
        if (qqPermission.hasPermission(strArr[0]) == 0) {
            grantedCallback.invoke();
        } else {
            Intrinsics.checkNotNullExpressionValue(qqPermission, "qqPermission");
            c(qqPermission, strArr, grantedCallback);
        }
    }

    private final void c(QQPermission permission, String[] permissions, Function0<Unit> grantedCallback) {
        permission.requestPermissions(permissions, 2, new b(grantedCallback));
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Fragment c16 = context.c();
        Intrinsics.checkNotNullExpressionValue(c16, "context.fragment");
        b(c16, new Function0<Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.RobotPttOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                com.tencent.aio.api.runtime.a.this.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("RobotPttOnClickProcessor", 1000, false, 0, 12, null));
            }
        });
    }
}

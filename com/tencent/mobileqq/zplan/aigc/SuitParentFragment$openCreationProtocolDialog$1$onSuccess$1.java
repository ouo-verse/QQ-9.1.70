package com.tencent.mobileqq.zplan.aigc;

import android.graphics.Bitmap;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.aigc.view.dialog.AIGCCreateProtocolBottomDialog;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import kj3.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import lj3.AIGCCreationProtocolPopUpWindowModel;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class SuitParentFragment$openCreationProtocolDialog$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ AIGCCreationProtocolPopUpWindowModel $model;
    final /* synthetic */ u45.j $rsp;
    final /* synthetic */ SuitParentFragment this$0;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitParentFragment$openCreationProtocolDialog$1$onSuccess$1$a", "Lkj3/a$b;", "", "errCode", "", "errMsg", "", "onFail", "Lu45/b;", "rsp", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SuitParentFragment f330014a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f330015b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AIGCCreateProtocolBottomDialog f330016c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f330017d;

        a(SuitParentFragment suitParentFragment, long j3, AIGCCreateProtocolBottomDialog aIGCCreateProtocolBottomDialog, Function0<Unit> function0) {
            this.f330014a = suitParentFragment;
            this.f330015b = j3;
            this.f330016c = aIGCCreateProtocolBottomDialog;
            this.f330017d = function0;
        }

        @Override // kj3.a.b
        public void a(u45.b rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.i("AIGCCreationPageEntry", 1, "sendAgreeRequest success.");
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(this.f330014a.Sh(), this.f330015b);
            this.f330016c.dismiss();
            this.f330017d.invoke();
        }

        @Override // kj3.a.b
        public void onFail(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("AIGCCreationPageEntry", 1, "sendAgreeRequest fail. errCode:" + errCode + ", errMsg:" + errMsg);
            QQToast.makeText(this.f330014a.getContext(), 1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitParentFragment$openCreationProtocolDialog$1$onSuccess$1(AIGCCreationProtocolPopUpWindowModel aIGCCreationProtocolPopUpWindowModel, SuitParentFragment suitParentFragment, Bitmap bitmap, u45.j jVar, Function0<Unit> function0) {
        super(0);
        this.$model = aIGCCreationProtocolPopUpWindowModel;
        this.this$0 = suitParentFragment;
        this.$bitmap = bitmap;
        this.$rsp = jVar;
        this.$callback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuitParentFragment this$0, long j3, AIGCCreateProtocolBottomDialog popUpWindow, Function0 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(popUpWindow, "$popUpWindow");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("AIGCCreationPageEntry", 1, "sendAgreeRequest start.");
        kj3.a.f412566a.b(new a(this$0, j3, popUpWindow, callback));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final AIGCCreateProtocolBottomDialog aIGCCreateProtocolBottomDialog = new AIGCCreateProtocolBottomDialog(this.$model);
        aIGCCreateProtocolBottomDialog.Eh(this.this$0.getFeedFrom());
        aIGCCreateProtocolBottomDialog.Fh(this.$bitmap);
        final long j3 = this.$rsp.f438248i;
        final SuitParentFragment suitParentFragment = this.this$0;
        final Function0<Unit> function0 = this.$callback;
        aIGCCreateProtocolBottomDialog.Dh(new AIGCCreateProtocolBottomDialog.b() { // from class: com.tencent.mobileqq.zplan.aigc.bp
            @Override // com.tencent.mobileqq.zplan.aigc.view.dialog.AIGCCreateProtocolBottomDialog.b
            public final void a() {
                SuitParentFragment$openCreationProtocolDialog$1$onSuccess$1.b(SuitParentFragment.this, j3, aIGCCreateProtocolBottomDialog, function0);
            }
        });
        if (this.this$0.getContext() instanceof QBaseActivity) {
            QLog.i("AIGCCreationPageEntry", 1, "show popUpWindow");
            aIGCCreateProtocolBottomDialog.show(this.this$0.requireActivity().getSupportFragmentManager(), "openCreationProtocolDialog");
        } else {
            QLog.e("AIGCCreationPageEntry", 1, "context isn't activity");
        }
    }
}

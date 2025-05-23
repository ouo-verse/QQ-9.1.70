package com.tencent.biz.qrcode.fragment;

import android.view.View;
import com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$b;", "it", "", "invoke", "(Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRDisplayMyCardFragment$initToast$1 extends Lambda implements Function1<QRDisplayMyCardViewModel.NewFriendToastMessage, Unit> {
    final /* synthetic */ QRDisplayMyCardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRDisplayMyCardFragment$initToast$1(QRDisplayMyCardFragment qRDisplayMyCardFragment) {
        super(1);
        this.this$0 = qRDisplayMyCardFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QRDisplayMyCardFragment this$0, View view) {
        Map Gh;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).startActivity(this$0.getContext(), null, 0);
        Gh = this$0.Gh();
        VideoReport.reportEvent("qq_clck", Gh);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QRDisplayMyCardViewModel.NewFriendToastMessage newFriendToastMessage) {
        invoke2(newFriendToastMessage);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r0 = r9.this$0.Eh();
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(@Nullable QRDisplayMyCardViewModel.NewFriendToastMessage newFriendToastMessage) {
        Integer Eh;
        int intValue;
        Map Gh;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("show_add_friend_toast", true) && Eh != null && (intValue = Eh.intValue()) > 0 && newFriendToastMessage != null) {
            final QRDisplayMyCardFragment qRDisplayMyCardFragment = this.this$0;
            QUIBottomToast.INSTANCE.a(qRDisplayMyCardFragment.getActivity(), 0, newFriendToastMessage.getPlainText(), newFriendToastMessage.getClickText(), new View.OnClickListener() { // from class: com.tencent.biz.qrcode.fragment.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QRDisplayMyCardFragment$initToast$1.b(QRDisplayMyCardFragment.this, view);
                }
            }, intValue - ViewUtils.dpToPx(76.0f)).n();
            Gh = qRDisplayMyCardFragment.Gh();
            VideoReport.reportEvent("qq_imp", Gh);
        }
    }
}

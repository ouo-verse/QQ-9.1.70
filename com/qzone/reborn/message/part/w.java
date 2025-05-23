package com.qzone.reborn.message.part;

import android.view.View;
import android.widget.ImageView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\r\u001a\u00020\tR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/message/part/w;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "G9", "J9", "I9", "E9", "", "hasRedDot", "D9", "onInitView", "F9", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mVisitNotifyView", "e", "mVisitRedDotView", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class w extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mVisitNotifyView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mVisitRedDotView;

    private final void D9(boolean hasRedDot) {
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.IS_REDDOT, Integer.valueOf(hasRedDot ? 1 : 2));
        fo.b l3 = new fo.b().l(hashMap);
        ImageView imageView = this.mVisitNotifyView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitNotifyView");
            imageView = null;
        }
        fo.c.o(imageView, "em_qz_visitor", l3);
    }

    private final void E9() {
        PersonalityEnv.JumpToVistorFromUserHome(getContext(), "QzPassiveMessageVisitorBubble");
        ImageView imageView = this.mVisitRedDotView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitRedDotView");
            imageView = null;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(w this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9() {
        if (com.qzone.reborn.util.i.c().d("showVisitNotifyBubble", false)) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getContext());
        ImageView imageView = this.mVisitNotifyView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitNotifyView");
            imageView = null;
        }
        r16.S(imageView).m0(3).o0(com.qzone.util.l.a(R.string.w_z)).R(2).k0(1).s0();
        com.qzone.reborn.util.i.c().l("showVisitNotifyBubble", true);
    }

    private final void J9() {
        boolean F9 = F9();
        if (F9) {
            I9();
        }
        ImageView imageView = this.mVisitRedDotView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitRedDotView");
            imageView = null;
        }
        imageView.setVisibility(F9 ? 0 : 8);
        D9(F9);
    }

    public final boolean F9() {
        return QZoneFeedAlertService.getInstance().getSingleUnreadCount(1027) > 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        G9(rootView);
        J9();
    }

    private final void G9(View rootView) {
        View findViewById = rootView.findViewById(R.id.n7z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026one_message_visit_notify)");
        this.mVisitNotifyView = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162900n80);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ne_message_visit_red_dot)");
        this.mVisitRedDotView = (ImageView) findViewById2;
        ImageView imageView = this.mVisitNotifyView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitNotifyView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.part.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.H9(w.this, view);
            }
        });
    }
}

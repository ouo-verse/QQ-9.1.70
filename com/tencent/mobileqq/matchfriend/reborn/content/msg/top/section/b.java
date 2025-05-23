package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c82.QQStrangerMsgMatchChatData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgBaseSection;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgMatchChatClickEvent;
import com.tencent.mobileqq.matchfriend.reborn.utils.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/section/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/QQStrangerMsgBaseSection;", "Lc82/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "bgIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "subtitleTv", tl.h.F, "matchBtn", "<init>", "()V", "i", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends QQStrangerMsgBaseSection<QQStrangerMsgMatchChatData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView bgIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView subtitleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView matchBtn;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View containerView, View view) {
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgMatchChatClickEvent());
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar, context, "em_kl_instant_chat_card", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(final View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.oko);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.iv_bg)");
        this.bgIv = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.os6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_subtitle)");
        this.subtitleTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f163143oj2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.btn_match)");
        this.matchBtn = (TextView) findViewById3;
        containerView.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.v(containerView, view);
            }
        }, 1, null));
        r.c(containerView, 0.0f, 1, null);
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.e(aVar, context, "em_kl_instant_chat_card", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(QQStrangerMsgMatchChatData data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getRemainMatchTime() > 0) {
            TextView textView = this.subtitleTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleTv");
                textView = null;
            }
            textView.setText("\u4eca\u65e5\u5269\u4f59" + data.getRemainMatchTime() + "\u6b21");
            TextView textView2 = this.matchBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matchBtn");
                textView2 = null;
            }
            textView2.setEnabled(true);
        } else {
            TextView textView3 = this.subtitleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitleTv");
                textView3 = null;
            }
            textView3.setText("\u4eca\u65e5\u6682\u65e0\u5339\u914d\u6b21\u6570");
            TextView textView4 = this.matchBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("matchBtn");
                textView4 = null;
            }
            textView4.setEnabled(false);
        }
        Option obtain = Option.obtain();
        ImageView imageView = this.bgIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bgIv");
            imageView = null;
        }
        Option option = obtain.setTargetView(imageView).setUrl("https://downv6.qq.com/extendfriend/kl_hobby_card_match.png").setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}

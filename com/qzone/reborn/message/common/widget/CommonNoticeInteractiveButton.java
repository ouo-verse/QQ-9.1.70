package com.qzone.reborn.message.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import cl.CommonNoticeInteractiveInfo;
import com.qzone.reborn.message.common.widget.CommonNoticeInteractiveButton;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002>?B\u0011\b\u0016\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:B\u001b\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u00a2\u0006\u0004\b9\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\tH\u0014R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcl/c;", "data", "", "x0", "r0", "w0", "s0", "", "getLayoutId", "interactiveInfo", c.G, "o0", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "q0", "()Landroid/view/ViewGroup;", "rootContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "buttonText", "i", "dividerText", "Lcom/qzone/reborn/widget/QZoneAsyncTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/widget/QZoneAsyncTextView;", "p0", "()Lcom/qzone/reborn/widget/QZoneAsyncTextView;", "rapidReplyText", BdhLogUtil.LogTag.Tag_Conn, "I", "defaultTextColor", "Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$a;", "D", "Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$a;", "getOnInteractListener", "()Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$a;", "setOnInteractListener", "(Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$a;)V", "onInteractListener", "Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$b;", "E", "Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$b;", "getOnRapidInteractListener", "()Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$b;", "setOnRapidInteractListener", "(Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$b;)V", "onRapidInteractListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonNoticeInteractiveButton extends QZoneBaseWidgetView<CommonNoticeInteractiveInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int defaultTextColor;

    /* renamed from: D, reason: from kotlin metadata */
    private a onInteractListener;

    /* renamed from: E, reason: from kotlin metadata */
    private b onRapidInteractListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup rootContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView iconImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView buttonText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView dividerText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final QZoneAsyncTextView rapidReplyText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$a;", "", "Landroid/view/View;", "view", "Lcl/c;", "interactInfo", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
        void a(View view, CommonNoticeInteractiveInfo interactInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/message/common/widget/CommonNoticeInteractiveButton$b;", "", "Landroid/view/View;", "view", "Lcl/c;", "interactInfo", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(View view, CommonNoticeInteractiveInfo interactInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonNoticeInteractiveButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n8_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_notice_button_layout)");
        this.rootContainer = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.n89);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_notice_button_icon)");
        this.iconImageView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.n8b);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_notice_button_text)");
        TextView textView = (TextView) findViewById3;
        this.buttonText = textView;
        View findViewById4 = findViewById(R.id.n88);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_notice_button_divider)");
        this.dividerText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.n8a);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_\u2026_button_rapid_reply_text)");
        this.rapidReplyText = (QZoneAsyncTextView) findViewById5;
        this.defaultTextColor = textView.getCurrentTextColor();
    }

    private final void r0(CommonNoticeInteractiveInfo data) {
        if (data.getActionIconRes() != 0) {
            this.iconImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), data.getActionIconRes(), null));
            com.tencent.mobileqq.qzone.picload.c.a().m(this.iconImageView, getResources().getColor(R.color.qui_common_icon_primary, null));
            this.iconImageView.setVisibility(0);
        } else {
            this.iconImageView.setImageDrawable(null);
            this.iconImageView.setVisibility(8);
        }
    }

    private final void s0(final CommonNoticeInteractiveInfo data) {
        this.buttonText.setClickable(false);
        if (data.getActionType() != 0) {
            this.rootContainer.setOnClickListener(new View.OnClickListener() { // from class: cl.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonNoticeInteractiveButton.u0(CommonNoticeInteractiveButton.this, data, view);
                }
            });
        } else {
            this.rootContainer.setOnClickListener(null);
            this.rootContainer.setClickable(false);
        }
        if (data.getRapidActionType() != 100) {
            this.rapidReplyText.setOnClickListener(new View.OnClickListener() { // from class: cl.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonNoticeInteractiveButton.v0(CommonNoticeInteractiveButton.this, data, view);
                }
            });
        } else {
            this.rapidReplyText.setOnClickListener(null);
            this.rapidReplyText.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(CommonNoticeInteractiveButton this$0, CommonNoticeInteractiveInfo data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        a aVar = this$0.onInteractListener;
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar.a(it, data);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(CommonNoticeInteractiveButton this$0, CommonNoticeInteractiveInfo data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        b bVar = this$0.onRapidInteractListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.a(it, data);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void w0(CommonNoticeInteractiveInfo data) {
        if (data.getActionTextColor() != 0) {
            this.buttonText.setTextColor(ResourcesCompat.getColor(getResources(), data.getActionTextColor(), null));
        } else {
            this.buttonText.setTextColor(this.defaultTextColor);
        }
        this.buttonText.setText(data.getActionText());
        this.rapidReplyText.setText(data.getRapidReplyRichText());
    }

    private final void x0(CommonNoticeInteractiveInfo data) {
        this.iconImageView.setVisibility(0);
        this.dividerText.setVisibility(data.getIsShowRapidReply() ? 0 : 8);
        this.rapidReplyText.setVisibility(data.getIsShowRapidReply() ? 0 : 8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cme;
    }

    /* renamed from: p0, reason: from getter */
    public final QZoneAsyncTextView getRapidReplyText() {
        return this.rapidReplyText;
    }

    /* renamed from: q0, reason: from getter */
    public final ViewGroup getRootContainer() {
        return this.rootContainer;
    }

    public final void setOnInteractListener(a aVar) {
        this.onInteractListener = aVar;
    }

    public final void setOnRapidInteractListener(b bVar) {
        this.onRapidInteractListener = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(CommonNoticeInteractiveInfo interactiveInfo, int pos) {
        if (interactiveInfo != null) {
            this.rootContainer.setVisibility(0);
            x0(interactiveInfo);
            r0(interactiveInfo);
            w0(interactiveInfo);
            s0(interactiveInfo);
            return;
        }
        this.rootContainer.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonNoticeInteractiveButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n8_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_notice_button_layout)");
        this.rootContainer = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.n89);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_notice_button_icon)");
        this.iconImageView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.n8b);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_notice_button_text)");
        TextView textView = (TextView) findViewById3;
        this.buttonText = textView;
        View findViewById4 = findViewById(R.id.n88);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qzone_notice_button_divider)");
        this.dividerText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.n8a);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qzone_\u2026_button_rapid_reply_text)");
        this.rapidReplyText = (QZoneAsyncTextView) findViewById5;
        this.defaultTextColor = textView.getCurrentTextColor();
    }
}

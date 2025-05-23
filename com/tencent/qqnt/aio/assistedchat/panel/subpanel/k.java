package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R6\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/k;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/f;", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "prompt", "", "r", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommend", "", "", "t", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "promptTv", UserInfo.SEX_FEMALE, "recommendTv", "Lkotlin/Function2;", "Landroid/view/View;", "", "G", "Lkotlin/jvm/functions/Function2;", "getImpReportStrategy", "()Lkotlin/jvm/functions/Function2;", "v", "(Lkotlin/jvm/functions/Function2;)V", "impReportStrategy", "Lkotlin/Function1;", "H", "Lkotlin/jvm/functions/Function1;", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "u", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "I", "Ljava/lang/Integer;", "getSubPanelId", "()Ljava/lang/Integer;", "w", "(Ljava/lang/Integer;)V", "subPanelId", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView promptTv;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView recommendTv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Function2<? super View, ? super com.tencent.qqnt.aio.assistedchat.model.c, Boolean> impReportStrategy;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> clickListener;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Integer subPanelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull Context context) {
        super(new LinearLayout(context));
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.tencent.qqnt.aio.utils.l.b(24));
        layoutParams.rightMargin = com.tencent.qqnt.aio.utils.l.b(12);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        textView.setPadding(com.tencent.qqnt.aio.utils.l.b(8), 0, com.tencent.qqnt.aio.utils.l.b(8), 0);
        textView.setGravity(17);
        textView.setTextSize(12.0f);
        this.promptTv = textView;
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 16;
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(16.0f);
        textView2.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        this.recommendTv = textView2;
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        RecyclerView.LayoutParams layoutParams3 = new RecyclerView.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = com.tencent.qqnt.aio.utils.l.b(16);
        ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = com.tencent.qqnt.aio.utils.l.b(16);
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = com.tencent.qqnt.aio.utils.l.b(8);
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setMinimumHeight(com.tencent.qqnt.aio.utils.l.b(56));
        linearLayout.setOrientation(0);
        int b16 = com.tencent.qqnt.aio.utils.l.b(8);
        linearLayout.setPadding(b16, b16, b16, b16);
        linearLayout.setBackground(s(context));
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(k this$0, com.tencent.qqnt.aio.assistedchat.model.c recommend, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recommend, "$recommend");
        Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> function1 = this$0.clickListener;
        if (function1 != null) {
            function1.invoke(recommend);
        }
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        assistedChatPanelDtReporter.a("em_kl_concrete_copy", it, this$0.t(recommend));
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void r(com.tencent.qqnt.aio.assistedchat.model.a prompt) {
        if (prompt != null && com.tencent.qqnt.aio.assistedchat.model.b.c(prompt)) {
            this.promptTv.setVisibility(0);
            this.promptTv.setText(prompt.d());
            this.promptTv.setTextColor(com.tencent.qqnt.aio.assistedchat.model.b.b(prompt));
            TextView textView = this.promptTv;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(com.tencent.qqnt.aio.assistedchat.model.b.a(prompt));
            gradientDrawable.setCornerRadius(com.tencent.qqnt.aio.utils.l.a(6.0f));
            textView.setBackground(gradientDrawable);
            return;
        }
        this.promptTv.setVisibility(8);
    }

    private final Drawable s(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_light_tertiary));
        gradientDrawable.setStroke((int) com.tencent.qqnt.aio.utils.l.a(0.5f), ContextCompat.getColorStateList(context, R.color.qui_common_border_light));
        gradientDrawable.setCornerRadius(com.tencent.qqnt.aio.utils.l.b(8));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_standard_primary));
        gradientDrawable2.setCornerRadius(com.tencent.qqnt.aio.utils.l.b(8));
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private final Map<String, String> t(com.tencent.qqnt.aio.assistedchat.model.c recommend) {
        String str;
        String str2;
        Map<String, String> mapOf;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("relation_content", recommend.a());
        pairArr[1] = TuplesKt.to("recom_trace_id", recommend.e());
        Integer d16 = recommend.d();
        if (d16 != null && d16.intValue() == 1) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[2] = TuplesKt.to("is_new_chat", str);
        Integer num = this.subPanelId;
        if (num == null || (str2 = num.toString()) == null) {
            str2 = "";
        }
        pairArr[3] = TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.f
    public void l(@NotNull e item, int position) {
        RecyclerView.LayoutParams layoutParams;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) item, position);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        ViewGroup.LayoutParams layoutParams2 = this.itemView.getLayoutParams();
        if (layoutParams2 instanceof RecyclerView.LayoutParams) {
            layoutParams = (RecyclerView.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        boolean z16 = false;
        if (layoutParams != null) {
            if (position == 0) {
                i3 = com.tencent.qqnt.aio.utils.l.b(8);
            } else {
                i3 = 0;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i3;
        }
        final com.tencent.qqnt.aio.assistedchat.model.c b16 = item.b();
        if (b16 == null) {
            return;
        }
        this.recommendTv.setText(b16.a());
        r(b16.c());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.q(k.this, b16, view);
            }
        });
        Function2<? super View, ? super com.tencent.qqnt.aio.assistedchat.model.c, Boolean> function2 = this.impReportStrategy;
        if (function2 != null) {
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            if (function2.invoke(itemView, b16).booleanValue()) {
                z16 = true;
            }
        }
        if (z16) {
            AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            assistedChatPanelDtReporter.c("em_kl_concrete_copy", itemView2, t(b16));
        }
    }

    public final void u(@Nullable Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function1);
        } else {
            this.clickListener = function1;
        }
    }

    public final void v(@Nullable Function2<? super View, ? super com.tencent.qqnt.aio.assistedchat.model.c, Boolean> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function2);
        } else {
            this.impReportStrategy = function2;
        }
    }

    public final void w(@Nullable Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) num);
        } else {
            this.subPanelId = num;
        }
    }
}

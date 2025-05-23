package com.tencent.qqnt.aio.assistedchat.panel.topic;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelView;
import com.tencent.qqnt.aio.utils.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AssistedChatTopicPanelVB$bottomBar$2 extends Lambda implements Function0<LinearLayout> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AssistedChatTopicPanelVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatTopicPanelVB$bottomBar$2(AssistedChatTopicPanelVB assistedChatTopicPanelVB) {
        super(0);
        this.this$0 = assistedChatTopicPanelVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) assistedChatTopicPanelVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AssistedChatTopicPanelVB this$0, TextView this_apply, Map reportParams, View view) {
        AssistedChatSubPanelView assistedChatSubPanelView;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        assistedChatSubPanelView = this$0.panelView;
        if (assistedChatSubPanelView != null) {
            AssistedChatSubPanelView.n(assistedChatSubPanelView, false, 1, null);
        }
        AssistedChatPanelDtReporter.f349138a.a("em_kl_refresh", this_apply, reportParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LinearLayout invoke() {
        final Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        LinearLayout linearLayout = new LinearLayout(this.this$0.getMContext());
        final AssistedChatTopicPanelVB assistedChatTopicPanelVB = this.this$0;
        linearLayout.setOrientation(1);
        View view = new View(linearLayout.getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) l.a(0.5f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColorStateList(view.getContext(), R.color.qui_common_border_light));
        view.setBackground(gradientDrawable);
        linearLayout.addView(view);
        final TextView a16 = com.tencent.qqnt.aio.assistedchat.panel.prompt.b.INSTANCE.a(assistedChatTopicPanelVB.getMContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.b(32));
        layoutParams.topMargin = l.b(8);
        layoutParams.bottomMargin = l.b(8);
        layoutParams.leftMargin = l.b(16);
        a16.setLayoutParams(layoutParams);
        a16.setText("\u968f\u673a\u6362");
        Drawable drawable = ContextCompat.getDrawable(a16.getContext(), R.drawable.qui_refresh);
        if (drawable != null) {
            drawable.setBounds(0, 0, l.b(12), l.b(12));
        }
        a16.setCompoundDrawables(drawable, null, null, null);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, "1"));
        a16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.topic.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AssistedChatTopicPanelVB$bottomBar$2.b(AssistedChatTopicPanelVB.this, a16, mapOf, view2);
            }
        });
        AssistedChatPanelDtReporter.f349138a.c("em_kl_refresh", a16, mapOf);
        linearLayout.addView(a16);
        return linearLayout;
    }
}

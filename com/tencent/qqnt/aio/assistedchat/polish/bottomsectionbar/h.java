package com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.assistedchat.polish.mvi.WriteWhilePolishingUIState;
import com.tencent.qqnt.aio.assistedchat.polish.mvi.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0014\u0010\u001d\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020$2\u0006\u0010\f\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020$H\u0016R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010/R\u0016\u00103\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/h;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "Landroid/widget/TextView;", "", "content", "Landroid/widget/ImageView;", "iconView", "", "J", "Lp81/c;", "binding", "Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/processor/a;", "model", "E", "D", "", "", "v", "rightBtn", "G", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/WriteWhilePolishingViewHolder;", "holder", "polishModel", HippyTKDListViewAdapter.X, "polishingModel", "H", "Landroid/text/TextPaint;", "paint", "u", "w", "", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "f", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "d", "i", "", "Ljava/util/List;", "cacheHolder", "Ljava/lang/CharSequence;", "lastShowPolishResult", "e", "I", "lastShowPolishResultSuffixLength", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<WriteWhilePolishingViewHolder> cacheHolder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence lastShowPolishResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastShowPolishResultSuffixLength;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/h$a;", "", "", "ELEM_ID_POLISH", "Ljava/lang/String;", "ELEM_ID_RIGHT_BTN", "KEY_FAIL_REASON", "KEY_STATUS", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.h$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cacheHolder = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(h this$0, RecyclerView.ViewHolder holder, com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a polishModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(polishModel, "$polishModel");
        this$0.x((WriteWhilePolishingViewHolder) holder, polishModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(h this$0, RecyclerView.ViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.j(new AssistedChatMsgIntent.ShowAssistedChatPanelIntent("bottom_bar_polish", 2));
        TextView textView = ((WriteWhilePolishingViewHolder) holder).l().f425720d;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.rightBtn");
        this$0.F(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(h this$0, RecyclerView.ViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.k(a.c.f349404d);
        TextView textView = ((WriteWhilePolishingViewHolder) holder).l().f425720d;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.rightBtn");
        this$0.F(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D(p81.c binding, com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a model) {
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        ConstraintLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        assistedChatPanelDtReporter.a("em_kl_touch_bar", root, v(model));
    }

    private final void E(p81.c binding, com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a model) {
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        ConstraintLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        assistedChatPanelDtReporter.c("em_kl_touch_bar", root, v(model));
    }

    private final void F(TextView rightBtn) {
        AssistedChatPanelDtReporter.b(AssistedChatPanelDtReporter.f349138a, "em_kl_touch_btn", rightBtn, null, 4, null);
    }

    private final void G(TextView rightBtn) {
        if (rightBtn.getVisibility() != 0) {
            return;
        }
        AssistedChatPanelDtReporter.d(AssistedChatPanelDtReporter.f349138a, "em_kl_touch_btn", rightBtn, null, 4, null);
    }

    private final void H(final WriteWhilePolishingViewHolder holder, com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a polishingModel) {
        boolean z16;
        holder.l().getRoot().setOnClickListener(null);
        final ImageView imageView = holder.l().f425718b;
        imageView.setAlpha(1.0f);
        imageView.post(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.d
            @Override // java.lang.Runnable
            public final void run() {
                h.I(h.this, imageView, holder);
            }
        });
        TextView textView = holder.l().f425719c;
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_primary, null));
        if (polishingModel.b().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            holder.l().f425720d.setText(polishingModel.b());
        }
        holder.l().f425720d.setVisibility(0);
        if (polishingModel.c() != 1) {
            w();
            holder.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(h this$0, ImageView this_apply, WriteWhilePolishingViewHolder holder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        TextPaint paint = holder.l().f425719c.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "holder.binding.polishResult.paint");
        this$0.u(this_apply, paint);
    }

    private final void J(final TextView textView, CharSequence charSequence, final ImageView imageView) {
        boolean z16;
        textView.setText(charSequence);
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        textView.post(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.e
            @Override // java.lang.Runnable
            public final void run() {
                h.K(imageView, textView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ImageView iconView, TextView this_setTextAndAdjustIconMarginTop) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int height;
        Intrinsics.checkNotNullParameter(iconView, "$iconView");
        Intrinsics.checkNotNullParameter(this_setTextAndAdjustIconMarginTop, "$this_setTextAndAdjustIconMarginTop");
        ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            Rect rect = new Rect();
            this_setTextAndAdjustIconMarginTop.getLineBounds(0, rect);
            if (!rect.isEmpty() && (height = (rect.height() - iconView.getWidth()) / 2) > 0 && height != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = height;
                iconView.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private final void u(ImageView imageView, TextPaint textPaint) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null && marginLayoutParams.topMargin <= 0) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int height = ((int) ((fontMetrics.bottom - fontMetrics.top) - imageView.getHeight())) / 2;
            if (height > 0 && height != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = height;
                imageView.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private final Map<String, String> v(com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a model) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("relation_content", model.a()), TuplesKt.to("recom_trace_id", model.d()), TuplesKt.to("status", String.valueOf(model.c())), TuplesKt.to(VRReportDefine$ReportParam.FAIL_REASON, ""));
        return mapOf;
    }

    private final void w() {
        this.lastShowPolishResult = null;
        this.lastShowPolishResultSuffixLength = 0;
    }

    private final void x(final WriteWhilePolishingViewHolder holder, final com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a polishModel) {
        com.tencent.qqnt.aio.assistedchat.polish.c cVar = com.tencent.qqnt.aio.assistedchat.polish.c.f349397a;
        Context context = holder.l().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.binding.root.context");
        Pair<CharSequence, Integer> b16 = cVar.b(context, holder.l().f425719c.getWidth(), polishModel.a());
        this.lastShowPolishResult = b16.getFirst();
        this.lastShowPolishResultSuffixLength = b16.getSecond().intValue();
        if (QLog.isDevelopLevel()) {
            String a16 = polishModel.a();
            CharSequence charSequence = this.lastShowPolishResult;
            QLog.i("WriteWhilePolishingAdapter", 1, "[handleSuccessState]polishResult=" + a16 + ", showText=" + ((Object) charSequence) + ", suffixLength=" + this.lastShowPolishResultSuffixLength);
        }
        TextView textView = holder.l().f425719c;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.polishResult");
        CharSequence charSequence2 = this.lastShowPolishResult;
        ImageView imageView = holder.l().f425718b;
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.icon");
        J(textView, charSequence2, imageView);
        holder.l().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.y(h.this, holder, polishModel, view);
            }
        });
        holder.l().f425720d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.z(h.this, holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(h this$0, WriteWhilePolishingViewHolder holder, com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a polishModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(polishModel, "$polishModel");
        this$0.k(a.C9460a.f349402d);
        this$0.D(holder.l(), polishModel);
        this$0.w();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(h this$0, WriteWhilePolishingViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.j(new AssistedChatMsgIntent.ShowAssistedChatPanelIntent("bottom_bar_polish", 2));
        TextView textView = holder.l().f425720d;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.rightBtn");
        this$0.F(textView);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void d(@NotNull MviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof WriteWhilePolishingUIState.StopLoadingAnimation) {
            Iterator<T> it = this.cacheHolder.iterator();
            while (it.hasNext()) {
                ((WriteWhilePolishingViewHolder) it.next()).s();
            }
        } else if (state instanceof WriteWhilePolishingUIState.ClearLastShowInfo) {
            w();
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(@NotNull final RecyclerView.ViewHolder holder, @NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        final com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (!(holder instanceof WriteWhilePolishingViewHolder)) {
            return;
        }
        Object a16 = model.a();
        if (a16 instanceof com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a) {
            aVar = (com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.a) a16;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        H((WriteWhilePolishingViewHolder) holder, aVar);
        boolean z16 = true;
        QLog.i("WriteWhilePolishingAdapter", 1, "[onBindViewHolder] holder=" + holder.hashCode());
        int c16 = aVar.c();
        if (c16 != 1) {
            if (c16 != 2) {
                if (c16 != 3) {
                    if (c16 != 4) {
                        if (c16 == 5) {
                            WriteWhilePolishingViewHolder writeWhilePolishingViewHolder = (WriteWhilePolishingViewHolder) holder;
                            TextView textView = writeWhilePolishingViewHolder.l().f425719c;
                            Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.polishResult");
                            String a17 = aVar.a();
                            ImageView imageView = writeWhilePolishingViewHolder.l().f425718b;
                            Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.icon");
                            J(textView, a17, imageView);
                            writeWhilePolishingViewHolder.l().f425720d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.b
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    h.B(h.this, holder, view);
                                }
                            });
                        }
                    } else {
                        WriteWhilePolishingViewHolder writeWhilePolishingViewHolder2 = (WriteWhilePolishingViewHolder) holder;
                        writeWhilePolishingViewHolder2.l().f425720d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.c
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                h.C(h.this, holder, view);
                            }
                        });
                        TextView textView2 = writeWhilePolishingViewHolder2.l().f425719c;
                        Intrinsics.checkNotNullExpressionValue(textView2, "holder.binding.polishResult");
                        String a18 = aVar.a();
                        ImageView imageView2 = writeWhilePolishingViewHolder2.l().f425718b;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "holder.binding.icon");
                        J(textView2, a18, imageView2);
                        k(a.b.f349403d);
                    }
                } else {
                    WriteWhilePolishingViewHolder writeWhilePolishingViewHolder3 = (WriteWhilePolishingViewHolder) holder;
                    writeWhilePolishingViewHolder3.l().f425720d.setVisibility(4);
                    writeWhilePolishingViewHolder3.l().f425718b.setAlpha(0.4f);
                    TextView textView3 = writeWhilePolishingViewHolder3.l().f425719c;
                    textView3.setTextColor(textView3.getContext().getResources().getColor(R.color.qui_common_text_secondary, null));
                    textView3.setText(aVar.a());
                }
            } else {
                if (QLog.isDevelopLevel()) {
                    QLog.i("WriteWhilePolishingAdapter", 1, "POLISH_STATE_SUCCESS width=" + ((WriteWhilePolishingViewHolder) holder).l().f425719c.getWidth());
                }
                WriteWhilePolishingViewHolder writeWhilePolishingViewHolder4 = (WriteWhilePolishingViewHolder) holder;
                TextView textView4 = writeWhilePolishingViewHolder4.l().f425719c;
                if (textView4.getWidth() > 0) {
                    x(writeWhilePolishingViewHolder4, aVar);
                } else {
                    textView4.post(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.A(h.this, holder, aVar);
                        }
                    });
                }
            }
        } else {
            CharSequence charSequence = this.lastShowPolishResult;
            if (charSequence != null && charSequence.length() != 0) {
                z16 = false;
            }
            if (z16) {
                ((WriteWhilePolishingViewHolder) holder).r(aVar.a(), 0);
            } else {
                CharSequence charSequence2 = this.lastShowPolishResult;
                Intrinsics.checkNotNull(charSequence2);
                ((WriteWhilePolishingViewHolder) holder).r(charSequence2, this.lastShowPolishResultSuffixLength);
            }
            ((WriteWhilePolishingViewHolder) holder).l().f425720d.setVisibility(4);
            w();
        }
        WriteWhilePolishingViewHolder writeWhilePolishingViewHolder5 = (WriteWhilePolishingViewHolder) holder;
        E(writeWhilePolishingViewHolder5.l(), aVar);
        TextView textView5 = writeWhilePolishingViewHolder5.l().f425720d;
        Intrinsics.checkNotNullExpressionValue(textView5, "holder.binding.rightBtn");
        G(textView5);
        this.cacheHolder.add(holder);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    @NotNull
    public RecyclerView.ViewHolder g(@NotNull ViewGroup parent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        com.tencent.aio.api.runtime.a a16 = a();
        if (a16 != null) {
            z16 = AIOUtil.f194084a.b(a16);
        } else {
            z16 = false;
        }
        p81.c g16 = p81.c.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        return new WriteWhilePolishingViewHolder(z16, g16);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void i(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.i(holder);
        if (holder instanceof WriteWhilePolishingViewHolder) {
            ((WriteWhilePolishingViewHolder) holder).s();
            this.cacheHolder.remove(holder);
        }
        QLog.i("WriteWhilePolishingAdapter", 1, "onViewRecycled\uff0c holder=" + holder.hashCode());
    }
}

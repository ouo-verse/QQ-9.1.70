package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0016R#\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/ReplySuggestionTailHolder;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "", "v", "u", "w", HippyTKDListViewAdapter.X, "", "elementId", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Lkotlin/Lazy;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "I", "t", "()Landroid/widget/TextView;", "contentText", "itemView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "J", "a", "ReportRunnable", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ReplySuggestionTailHolder extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int K;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy icon;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentText;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/ReplySuggestionTailHolder$ReportRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "eventId", "Lmqq/util/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Lmqq/util/WeakReference;", "viewRef", "view", "<init>", "(Ljava/lang/String;Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ReportRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String eventId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<View> viewRef;

        public ReportRunnable(@NotNull String eventId, @NotNull View view) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eventId, (Object) view);
            } else {
                this.eventId = eventId;
                this.viewRef = new WeakReference<>(view);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            View view = this.viewRef.get();
            if (view != null) {
                VideoReport.reportEvent(this.eventId, view, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/ReplySuggestionTailHolder$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "DELAY_IMP", "J", "", "ELEM_ID", "Ljava/lang/String;", "EVENT_CLICK", "EVENT_IMP", "GUIDE_TEXT", "TAG", "", "itemHeight", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.ReplySuggestionTailHolder$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            ViewGroup.LayoutParams layoutParams = new FlexboxLayoutManager.LayoutParams(-2, ReplySuggestionTailHolder.K);
            linearLayout.setGravity(16);
            linearLayout.setLayoutParams(layoutParams);
            View imageView = new ImageView(context);
            imageView.setId(R.id.f73313t8);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.tencent.qqnt.aio.utils.l.b(12), com.tencent.qqnt.aio.utils.l.b(12));
            layoutParams2.setMarginStart(com.tencent.qqnt.aio.utils.l.b(9));
            imageView.setLayoutParams(layoutParams2);
            linearLayout.addView(imageView);
            TextView textView = new TextView(context);
            textView.setId(R.id.f73303t7);
            textView.setTextSize(14.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMarginStart(com.tencent.qqnt.aio.utils.l.b(4));
            layoutParams3.setMarginEnd(com.tencent.qqnt.aio.utils.l.b(9));
            textView.setLayoutParams(layoutParams3);
            linearLayout.addView(textView);
            return linearLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            K = com.tencent.qqnt.aio.utils.l.b(36);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplySuggestionTailHolder(@NotNull final View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView, adapter);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(itemView) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.ReplySuggestionTailHolder$icon$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $itemView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$itemView = itemView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) itemView);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (ImageView) this.$itemView.findViewById(R.id.f73313t8) : (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.icon = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(itemView) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.ReplySuggestionTailHolder$contentText$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $itemView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$itemView = itemView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) itemView);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TextView) this.$itemView.findViewById(R.id.f73303t7) : (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.contentText = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
    }

    private final ImageView getIcon() {
        return (ImageView) this.icon.getValue();
    }

    private final TextView t() {
        return (TextView) this.contentText.getValue();
    }

    private final void u() {
        getIcon().setImageDrawable(ContextCompat.getDrawable(getIcon().getContext(), R.drawable.qui_assisted_chat_bottom_bar));
    }

    private final void v() {
        View view = this.itemView;
        view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.j8m));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FlexboxLayoutManager.LayoutParams(-2, com.tencent.qqnt.aio.utils.l.b(36));
        } else {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams ?: FlexboxL\u2026rams.WRAP_CONTENT, 36.px)");
        }
        layoutParams.height = com.tencent.qqnt.aio.utils.l.b(36);
        view.setLayoutParams(layoutParams);
    }

    private final void w() {
        TextView t16 = t();
        t16.setTextColor(ContextCompat.getColorStateList(t16.getContext(), R.color.qui_common_bubble_guest_text_primary));
        SpannableString spannableString = new SpannableString("\u4e0d\u4f1a\u56de\uff1f\u8bd5\u8bd5\u5f00\u542f \u56de\u590d\u5efa\u8bae");
        int length = spannableString.length() - 5;
        int length2 = spannableString.length();
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(t16.getContext(), R.color.qui_common_text_link)), length, length2, 33);
        spannableString.setSpan(new StyleSpan(1), length, length2, 33);
        t16.setText(spannableString);
    }

    private final void x() {
        FragmentActivity fragmentActivity;
        Context context = this.itemView.getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            com.tencent.qqnt.aio.utils.c cVar = com.tencent.qqnt.aio.utils.c.f352293a;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            cVar.a(fragmentActivity, new AssistedChatMsgIntent.OnReplySuggestionTailShow(itemView));
        }
        View findViewById = this.itemView.findViewById(R.id.f73303t7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026_suggestion_tail_content)");
        z("em_kl_reply_suggest_guide", findViewById);
    }

    private final void y(String elementId, View view) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, null);
    }

    private final void z(String elementId, View view) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        ThreadManager.getUIHandler().postDelayed(new ReportRunnable("dt_imp", view), 2000L);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c
    public void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        v();
        w();
        u();
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Context context;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            FragmentActivity fragmentActivity = null;
            if (v3 != null) {
                context = v3.getContext();
            } else {
                context = null;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            if (fragmentActivity != null) {
                if (!AppNetConnInfo.isNetSupport()) {
                    QQToast.makeText(fragmentActivity, 1, fragmentActivity.getString(R.string.cib), 0).show();
                } else {
                    com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, AssistedChatMsgIntent.OnReplySuggestionTailClick.f348987d);
                    View findViewById = this.itemView.findViewById(R.id.f73303t7);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026_suggestion_tail_content)");
                    y("em_kl_reply_suggest_guide", findViewById);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}

package com.tencent.qqnt.markdown.data.quote;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002Jh\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010`\u00112\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/c;", "Lcom/tencent/qqnt/markdown/b;", "Landroid/content/Context;", "context", "", "tipsContent", "", "tipsMaxWidth", "Landroid/view/View;", "c", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "builder", "nodeId", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/markdown/data/b;", "Lkotlin/collections/HashMap;", "data", Node.ATTRS_ATTR, "", "a", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements com.tencent.qqnt.markdown.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.data.quote.c$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/markdown/data/quote/c$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f359401d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.android.androidbypass.span.g f359402e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f359403f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f359404h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f359405i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f359406m;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/markdown/data/quote/c$b$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "rich_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes24.dex */
        public static final class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f359407d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f359408e;

            a(String str, Context context) {
                this.f359407d = str;
                this.f359408e = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) context);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
            
                if (r0 != false) goto L13;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(@Nullable View v3) {
                boolean startsWith$default;
                boolean startsWith$default2;
                EventCollector.getInstance().onViewClickedBefore(v3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                } else {
                    String str = this.f359407d;
                    if (str != null) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
                        if (!startsWith$default) {
                            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(this.f359407d, "https", false, 2, null);
                        }
                        IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
                        Context context = this.f359408e;
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        iAIOJumpAction.openBrowser(context, this.f359407d);
                    }
                }
                EventCollector.getInstance().onViewClicked(v3);
            }
        }

        b(TextView textView, com.tencent.android.androidbypass.span.g gVar, c cVar, Context context, String str, String str2) {
            this.f359401d = textView;
            this.f359402e = gVar;
            this.f359403f = cVar;
            this.f359404h = context;
            this.f359405i = str;
            this.f359406m = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, textView, gVar, cVar, context, str, str2);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            int coerceIn;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            CharSequence text = this.f359401d.getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.SpannableString");
            SpannableString spannableString = (SpannableString) text;
            Layout layout = this.f359401d.getLayout();
            Intrinsics.checkNotNull(layout, "null cannot be cast to non-null type android.text.Layout");
            float spanStart = spannableString.getSpanStart(this);
            float spanEnd = spannableString.getSpanEnd(this);
            int i3 = (int) spanStart;
            float primaryHorizontal = layout.getPrimaryHorizontal(i3);
            float primaryHorizontal2 = layout.getPrimaryHorizontal((int) spanEnd);
            if (primaryHorizontal2 <= primaryHorizontal) {
                primaryHorizontal2 = this.f359402e.a().width() + primaryHorizontal;
            }
            int lineForOffset = layout.getLineForOffset(i3);
            Rect rect = new Rect();
            layout.getLineBounds(lineForOffset, rect);
            float compoundPaddingLeft = ((((primaryHorizontal + primaryHorizontal2) / 2) + this.f359401d.getCompoundPaddingLeft()) - this.f359401d.getScrollX()) - ViewUtils.dpToPx(6.0f);
            int i16 = rect.top;
            c cVar = this.f359403f;
            Context context = this.f359404h;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View c16 = cVar.c(context, this.f359405i, this.f359401d.getMaxWidth());
            int i17 = c16.getLayoutParams().width;
            int i18 = (int) compoundPaddingLeft;
            coerceIn = RangesKt___RangesKt.coerceIn(i18 - (i17 / 2), 0, this.f359401d.getMaxWidth() - i17);
            Context context2 = this.f359404h;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            com.tencent.qqnt.markdown.widget.a aVar = new com.tencent.qqnt.markdown.widget.a(context2, c16);
            TextView textView = this.f359401d;
            String str = this.f359406m;
            Context context3 = this.f359404h;
            aVar.h(-1);
            aVar.e(textView);
            aVar.f(coerceIn, i16);
            aVar.g(i18 - coerceIn);
            aVar.i(new a(str, context3));
            aVar.j();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35244);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View c(Context context, String tipsContent, int tipsMaxWidth) {
        int i3;
        ImageView imageView = new ImageView(context);
        imageView.setId(View.generateViewId());
        int dpToPx = ViewUtils.dpToPx(16.0f);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dpToPx, dpToPx);
        int i16 = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(10.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_chevron_right_text_link));
        TextView textView = new TextView(context);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToLeft = 0;
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ViewUtils.dpToPx(10.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ViewUtils.dpToPx(8.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ViewUtils.dpToPx(8.0f);
        int dpToPx2 = ViewUtils.dpToPx(30.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = dpToPx2;
        textView.setMaxWidth((tipsMaxWidth - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) - dpToPx2);
        textView.setLayoutParams(layoutParams2);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(tipsContent);
        textView.setTextSize(14.0f);
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_link));
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = textView.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = null;
        if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams3 = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.leftMargin;
        } else {
            i3 = 0;
        }
        int i17 = measuredWidth + i3;
        ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams4 = layoutParams5;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
        if (marginLayoutParams2 != null) {
            i16 = marginLayoutParams2.rightMargin;
        }
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(i17 + i16, -2));
        constraintLayout.addView(textView);
        constraintLayout.addView(imageView);
        return constraintLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010a  */
    @Override // com.tencent.qqnt.markdown.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull TextView textView, @NotNull SpannableStringBuilder builder, @NotNull String nodeId, @NotNull HashMap<String, com.tencent.qqnt.markdown.data.b> data, @NotNull HashMap<String, String> attrs) {
        String str;
        com.tencent.qqnt.markdown.data.b bVar;
        String str2;
        boolean isBlank;
        ArrayList<com.tencent.qqnt.markdown.data.e> f16;
        Object orNull;
        com.tencent.qqnt.markdown.data.e eVar;
        ArrayList<com.tencent.qqnt.markdown.data.e> f17;
        Object orNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, textView, builder, nodeId, data, attrs);
            return;
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(nodeId, "nodeId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context = textView.getContext();
        String str3 = attrs.get("index");
        if (str3 == null) {
            str3 = "";
        }
        int intOrDefault$default = RFWStringsKt.toIntOrDefault$default(str3, 0, 0, 2, null);
        com.tencent.qqnt.rich.util.a aVar = com.tencent.qqnt.rich.util.a.f362055a;
        com.tencent.android.androidbypass.span.g gVar = new com.tencent.android.androidbypass.span.g(str3, aVar.a(context.getResources().getColor(R.color.qui_common_text_primary), 0.6f), aVar.a(context.getResources().getColor(R.color.qui_common_icon_tertiary), 0.6f), ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(3.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(2.0f));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str3);
        sb5.append('.');
        com.tencent.qqnt.markdown.data.b bVar2 = data.get(nodeId);
        if (bVar2 != null && (f17 = bVar2.f()) != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(f17, intOrDefault$default - 1);
            com.tencent.qqnt.markdown.data.e eVar2 = (com.tencent.qqnt.markdown.data.e) orNull2;
            if (eVar2 != null) {
                str = eVar2.b();
                sb5.append(str);
                String sb6 = sb5.toString();
                bVar = data.get(nodeId);
                if (bVar != null && (f16 = bVar.f()) != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(f16, intOrDefault$default - 1);
                    eVar = (com.tencent.qqnt.markdown.data.e) orNull;
                    if (eVar != null) {
                        str2 = eVar.a();
                        isBlank = StringsKt__StringsJVMKt.isBlank(builder);
                        if (isBlank) {
                            builder.clear();
                            builder.append((CharSequence) ('[' + str3 + ']'));
                        }
                        builder.setSpan(gVar, 0, builder.length(), 33);
                        builder.setSpan(new b(textView, gVar, this, context, sb6, str2), 0, builder.length(), 33);
                        builder.append("\u200b");
                    }
                }
                str2 = null;
                isBlank = StringsKt__StringsJVMKt.isBlank(builder);
                if (isBlank) {
                }
                builder.setSpan(gVar, 0, builder.length(), 33);
                builder.setSpan(new b(textView, gVar, this, context, sb6, str2), 0, builder.length(), 33);
                builder.append("\u200b");
            }
        }
        str = null;
        sb5.append(str);
        String sb62 = sb5.toString();
        bVar = data.get(nodeId);
        if (bVar != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(f16, intOrDefault$default - 1);
            eVar = (com.tencent.qqnt.markdown.data.e) orNull;
            if (eVar != null) {
            }
        }
        str2 = null;
        isBlank = StringsKt__StringsJVMKt.isBlank(builder);
        if (isBlank) {
        }
        builder.setSpan(gVar, 0, builder.length(), 33);
        builder.setSpan(new b(textView, gVar, this, context, sb62, str2), 0, builder.length(), 33);
        builder.append("\u200b");
    }
}

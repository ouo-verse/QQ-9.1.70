package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aio.widget.textView.view.AioTextView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.menu.CustomMenuLayout;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J \u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/c;", "", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", TtmlNode.TAG_SPAN, "", "url", "", "e", "", "id", "title", "drawableRes", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/component/menu/a;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/e;", "clickableSpan", "Lkotlin/Pair;", "c", "d", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f221652a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/c$a;", "Lrg1/b;", "", "a", "Landroid/content/Context;", "context", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements rg1.b {
        @Override // rg1.b
        public int a() {
            return 14;
        }

        @Override // rg1.b
        public int b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getColor(R.color.qui_common_text_allwhite_primary);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/c$b", "Lrg1/a;", "Landroid/content/Context;", "context", "", "e", "f", "c", "a", "b", "Landroid/view/View;", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements rg1.a {
        b() {
        }

        @Override // rg1.a
        public int a() {
            return ViewUtils.dip2px(80.0f);
        }

        @Override // rg1.a
        public int b() {
            return ViewUtils.dip2px(36.0f);
        }

        @Override // rg1.a
        public int c() {
            return ViewUtils.dip2px(8.0f);
        }

        @Override // rg1.a
        @NotNull
        public View d(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View view = new View(context);
            view.setBackgroundColor(context.getResources().getColor(R.color.f157324c50));
            view.setLayoutParams(new LinearLayout.LayoutParams(cx.a(1.0f), -1));
            return view;
        }

        @Override // rg1.a
        public int e(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getColor(R.color.c4v);
        }

        @Override // rg1.a
        public int f(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getColor(R.color.c4w);
        }
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, String url, View v3) {
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> mapOf2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setLogicParent(v3, view);
        int id5 = v3.getId();
        if (id5 == R.id.f114696u1) {
            ((IGuildAIOLinkSpanUtilsApi) QRoute.api(IGuildAIOLinkSpanUtilsApi.class)).onClick(url, "biz_src_jc_feed", view);
            yl1.b bVar = yl1.b.f450589a;
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 1));
            bVar.e(v3, "em_sgrp_url_float", mapOf2);
        } else if (id5 == R.id.f114686u0) {
            Object systemService = view.getContext().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(null, url));
            QQToast.makeText(v3.getContext(), 2, R.string.f148440zl, 0).show();
            yl1.b bVar2 = yl1.b.f450589a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 2));
            bVar2.e(v3, "em_sgrp_url_float", mapOf);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @NotNull
    public final com.tencent.mobileqq.guild.component.menu.a b(int id5, @NotNull String title, int drawableRes, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = ContextCompat.getDrawable(context, drawableRes);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
        } else {
            drawable = null;
        }
        com.tencent.mobileqq.guild.component.menu.a aVar = new com.tencent.mobileqq.guild.component.menu.a(id5, title, drawable);
        aVar.d(new a());
        return aVar;
    }

    @Nullable
    public final Pair<Integer, Integer> c(@NotNull e eVar, @NotNull ClickableSpan clickableSpan) {
        Spanned spanned;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
        Layout layout = eVar.getLayout();
        if (layout == null) {
            return null;
        }
        CharSequence text = eVar.getText();
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
        } else {
            spanned = null;
        }
        if (spanned == null) {
            return null;
        }
        int spanStart = spanned.getSpanStart(clickableSpan);
        int spanEnd = spanned.getSpanEnd(clickableSpan);
        int lineForOffset = layout.getLineForOffset(spanStart);
        int lineForOffset2 = layout.getLineForOffset(spanEnd);
        layout.getLineTop(lineForOffset);
        int lineBaseline = layout.getLineBaseline(lineForOffset2);
        float primaryHorizontal = layout.getPrimaryHorizontal(spanStart);
        float primaryHorizontal2 = (primaryHorizontal + ((layout.getPrimaryHorizontal(spanEnd) - primaryHorizontal) / 2)) - ViewUtils.dip2px(80.0f);
        int[] iArr = new int[2];
        eVar.getLocationInWindow(iArr);
        return new Pair<>(Integer.valueOf(iArr[0] + ((int) primaryHorizontal2)), Integer.valueOf(iArr[1] + lineBaseline + ViewUtils.dip2px(3.0f)));
    }

    @Nullable
    public final Pair<Integer, Integer> d(@NotNull e eVar, @NotNull ClickableSpan clickableSpan) {
        Spanned spanned;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
        Layout layout = eVar.getLayout();
        if (layout == null) {
            return null;
        }
        CharSequence text = eVar.getText();
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
        } else {
            spanned = null;
        }
        if (spanned == null) {
            return null;
        }
        int[] iArr = new int[2];
        eVar.a(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int spanStart = spanned.getSpanStart(clickableSpan);
        int spanEnd = spanned.getSpanEnd(clickableSpan);
        float primaryHorizontal = layout.getPrimaryHorizontal(spanStart);
        return new Pair<>(Integer.valueOf((int) (i3 + primaryHorizontal + ((layout.getPrimaryHorizontal(spanEnd) - primaryHorizontal) / 2))), Integer.valueOf(i16 + layout.getLineBaseline(layout.getLineForOffset(spanStart))));
    }

    public final void e(@NotNull final View view, @NotNull ClickableSpan span, @NotNull final String url) {
        e b16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(url, "url");
        if (view instanceof TextView) {
            b16 = d.a((TextView) view);
        } else if (view instanceof AioTextView) {
            b16 = d.b((AioTextView) view);
        } else {
            return;
        }
        qg1.a B0 = qg1.a.B0(view.getContext());
        if (B0 == null) {
            return;
        }
        com.tencent.mobileqq.guild.component.menu.b bVar = new com.tencent.mobileqq.guild.component.menu.b();
        c cVar = f221652a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        bVar.a(cVar.b(R.id.f114696u1, "\u6253\u5f00", R.drawable.guild_feed_url_icon_allwhiite, context));
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        bVar.a(cVar.b(R.id.f114686u0, "\u590d\u5236", R.drawable.guild_feed_url_copy_allwhiite, context2));
        CustomMenuLayout e16 = CustomMenuLayout.e(B0, view.getContext(), bVar, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.f(view, url, view2);
            }
        }, new b());
        Pair<Integer, Integer> c16 = c(b16, span);
        Pair<Integer, Integer> d16 = d(b16, span);
        B0.S(view);
        B0.a0(e16);
        B0.E0(ViewUtils.dip2px(8.0f));
        B0.k0(1);
        B0.R(1);
        B0.b0(-1L);
        B0.W(view.getContext().getResources().getColor(R.color.c4v));
        if (c16 != null) {
            B0.F0(c16.component1().intValue(), c16.component2().intValue());
        }
        if (d16 != null) {
            B0.G0(d16.component1().intValue(), d16.component2().intValue());
        }
        B0.s0();
        View contentView = B0.v();
        if (contentView != null) {
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            VideoReport.setLogicParent(contentView, view);
            yl1.b.h(yl1.b.f450589a, contentView, "em_sgrp_url_float", null, 4, null);
        }
    }
}

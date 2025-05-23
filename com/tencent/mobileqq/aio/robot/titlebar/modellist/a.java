package com.tencent.mobileqq.aio.robot.titlebar.modellist;

import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00040\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/a;", "", "", "htmlString", "Lkotlin/Pair;", "", "a", TextComponent.SpanType.HTML, "Landroid/widget/TextView;", "textView", "Lkotlin/Function1;", "", "click", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f193664a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/robot/titlebar/modellist/a$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.robot.titlebar.modellist.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7357a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f193665d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f193666e;

        /* JADX WARN: Multi-variable type inference failed */
        C7357a(Function1<? super String, Unit> function1, String str) {
            this.f193665d = function1;
            this.f193666e = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function1<String, Unit> function1 = this.f193665d;
            if (function1 != null) {
                function1.invoke(this.f193666e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
        }
    }

    a() {
    }

    private final Pair<String, List<Pair<String, String>>> a(String htmlString) {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(htmlString, 0);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            Html.fromH\u2026ML_MODE_LEGACY)\n        }");
        } else {
            fromHtml = Html.fromHtml(htmlString);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            @Suppress(\u2026tml(htmlString)\n        }");
        }
        String obj = fromHtml.toString();
        URLSpan[] urlSpans = (URLSpan[]) fromHtml.getSpans(0, fromHtml.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(urlSpans, "urlSpans");
        ArrayList arrayList = new ArrayList(urlSpans.length);
        for (URLSpan uRLSpan : urlSpans) {
            arrayList.add(new Pair(uRLSpan.getURL(), fromHtml.subSequence(fromHtml.getSpanStart(uRLSpan), fromHtml.getSpanEnd(uRLSpan)).toString()));
        }
        return new Pair<>(obj, arrayList);
    }

    public final void b(@NotNull String html, @Nullable TextView textView, @Nullable Function1<? super String, Unit> click) {
        Object first;
        int indexOf$default;
        Intrinsics.checkNotNullParameter(html, "html");
        Pair<String, List<Pair<String, String>>> a16 = a(html);
        String component1 = a16.component1();
        List<Pair<String, String>> component2 = a16.component2();
        if (!component2.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) component2);
            Pair pair = (Pair) first;
            String str = (String) pair.getFirst();
            String str2 = (String) pair.getSecond();
            SpannableString spannableString = new SpannableString(component1);
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) component1, str2, 0, false, 6, (Object) null);
            int length = str2.length() + indexOf$default;
            C7357a c7357a = new C7357a(click, str);
            int g16 = ie0.a.f().g(BaseApplication.getContext(), R.color.qui_common_text_link, 1000);
            spannableString.setSpan(c7357a, indexOf$default, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(g16), indexOf$default, length, 33);
            if (textView != null) {
                textView.setText(spannableString);
            }
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }
}

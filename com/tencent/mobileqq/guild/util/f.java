package com.tencent.mobileqq.guild.util;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\"\u0010#J+\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u00a2\u0006\u0002\b\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/util/f;", "Lcom/tencent/mobileqq/guild/util/e;", "", "text", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/util/c;", "", "Lkotlin/ExtensionFunctionType;", "method", "a", "Landroid/text/SpannableStringBuilder;", "b", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "builder", "", "c", "I", "getLastIndex", "()I", "setLastIndex", "(I)V", "lastIndex", "", "d", "Z", "isClickable", "()Z", "setClickable", "(Z)V", "<init>", "(Landroid/widget/TextView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder builder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int lastIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isClickable;

    public f(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.builder = new SpannableStringBuilder();
    }

    @Override // com.tencent.mobileqq.guild.util.e
    public void a(@NotNull String text, @Nullable Function1<? super c, Unit> method) {
        Intrinsics.checkNotNullParameter(text, "text");
        int i3 = this.lastIndex;
        this.builder.append((CharSequence) text);
        this.lastIndex += text.length();
        d dVar = new d();
        if (method != null) {
            method.invoke(dVar);
        }
        ClickableSpan onClickSpan = dVar.getOnClickSpan();
        if (onClickSpan != null) {
            this.builder.setSpan(onClickSpan, i3, this.lastIndex, 33);
            this.isClickable = true;
        }
        if (!dVar.getUseUnderLine()) {
            this.builder.setSpan(new NoUnderlineSpan(), i3, this.lastIndex, 17);
        }
        ForegroundColorSpan foregroundColorSpan = dVar.getForegroundColorSpan();
        if (foregroundColorSpan != null) {
            this.builder.setSpan(foregroundColorSpan, i3, this.lastIndex, 33);
        }
        AbsoluteSizeSpan textSizeSpan = dVar.getTextSizeSpan();
        if (textSizeSpan != null) {
            this.builder.setSpan(textSizeSpan, i3, this.lastIndex, 33);
        }
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final SpannableStringBuilder getBuilder() {
        return this.builder;
    }
}

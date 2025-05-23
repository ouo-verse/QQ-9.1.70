package com.tencent.mobileqq.search.quicksearch;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0003\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/quicksearch/c;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "", "toString", "", "d", "I", "getColor", "()I", "color", "<init>", "(I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.quicksearch.c, reason: from toString */
/* loaded from: classes18.dex */
public final class QuickSearchSpan extends CharacterStyle implements UpdateAppearance {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int color;

    public QuickSearchSpan() {
        this(0, 1, null);
    }

    @NotNull
    public String toString() {
        return "QuickSearchSpan(color=" + this.color + ")";
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint tp5) {
        Intrinsics.checkNotNullParameter(tp5, "tp");
        tp5.setColor(this.color);
    }

    public /* synthetic */ QuickSearchSpan(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? HardCodeUtil.sContex.getColor(R.color.qui_common_text_link) : i3);
    }

    public QuickSearchSpan(@ColorInt int i3) {
        this.color = i3;
    }
}

package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchRichTextView;", "Lcom/tencent/richframework/text/rich/RFWAsyncRichTextView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "parserText", "Landroid/text/Spannable;", "text", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class NetSearchRichTextView extends RFWAsyncRichTextView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetSearchRichTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    @NotNull
    public Spannable parserText(@Nullable CharSequence text) {
        if (text instanceof SpannableString) {
            return (Spannable) text;
        }
        Spannable parserText = super.parserText(text);
        Intrinsics.checkNotNullExpressionValue(parserText, "super.parserText(text)");
        return parserText;
    }

    public /* synthetic */ NetSearchRichTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetSearchRichTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

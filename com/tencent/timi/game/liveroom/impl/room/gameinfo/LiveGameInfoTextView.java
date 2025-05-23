package com.tencent.timi.game.liveroom.impl.room.gameinfo;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveGameInfoTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/text/SpannableString;", "e", "", "text", "Landroid/text/style/CharacterStyle;", "style", "f", "", "dataText", "", "setData", "Landroid/text/SpannableStringBuilder;", h.F, "Landroid/text/SpannableStringBuilder;", "contentSpannable", "", "i", "I", "splitTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveGameInfoTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder contentSpannable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int splitTextColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveGameInfoTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final SpannableString e() {
        return f("\u4e28", new ForegroundColorSpan(this.splitTextColor));
    }

    private final SpannableString f(String text, CharacterStyle style) {
        SpannableString spannableString = new SpannableString(text);
        if (style != null) {
            spannableString.setSpan(style, 0, text.length(), 17);
        }
        return spannableString;
    }

    public final void setData(@Nullable List<String> dataText) {
        this.contentSpannable.clear();
        this.contentSpannable.clearSpans();
        if (dataText != null) {
            int i3 = 0;
            for (Object obj : dataText) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                if (i3 > 0) {
                    this.contentSpannable.append((CharSequence) e());
                    this.contentSpannable.append((CharSequence) str);
                } else {
                    this.contentSpannable.append((CharSequence) str);
                }
                i3 = i16;
            }
        }
        setText(this.contentSpannable);
    }

    public /* synthetic */ LiveGameInfoTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveGameInfoTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentSpannable = new SpannableStringBuilder();
        this.splitTextColor = Color.parseColor("#878B99");
    }
}

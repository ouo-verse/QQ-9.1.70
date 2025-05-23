package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\f\u0010\u000eB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\f\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildFeedTextView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "a", "Lwq0/l;", "d", "Lwq0/l;", "guildTextView", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedTextView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private wq0.l guildTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedTextView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context, AttributeSet attrs) {
        wq0.l c16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, w12.a.f444234h2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.GuildFeedTextView)");
        boolean z16 = obtainStyledAttributes.getBoolean(w12.a.f444271l2, false);
        if (obtainStyledAttributes.getBoolean(w12.a.f444262k2, false)) {
            c16 = wq0.j.f446044a.d(context, z16);
        } else {
            c16 = wq0.j.c(wq0.j.f446044a, context, z16, false, 4, null);
        }
        c16.getView().setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        c16.getView().setClickable(false);
        c16.getView().setFocusable(false);
        Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(w12.a.f444280m2, -1.0f));
        if (!Intrinsics.areEqual((Object) valueOf, (Object) Float.valueOf(-1.0f))) {
            c16.c(valueOf.floatValue());
        }
        Float valueOf2 = Float.valueOf(obtainStyledAttributes.getFloat(w12.a.f444318q2, -1.0f));
        if (!Intrinsics.areEqual((Object) valueOf2, (Object) Float.valueOf(-1.0f))) {
            c16.setTextSize(valueOf2.floatValue());
        }
        Float valueOf3 = Float.valueOf(obtainStyledAttributes.getFloat(w12.a.f444244i2, -1.0f));
        if (!Intrinsics.areEqual((Object) valueOf3, (Object) Float.valueOf(-1.0f))) {
            c16.setLetterSpacing(valueOf3.floatValue());
        }
        int i3 = obtainStyledAttributes.getInt(w12.a.f444253j2, -1);
        if (i3 != -1) {
            c16.setMaxLines(i3);
        }
        c16.setTextColor(obtainStyledAttributes.getColor(w12.a.f444298o2, context.getResources().getColor(R.color.qui_common_text_primary)));
        CharSequence text = obtainStyledAttributes.getText(w12.a.f444289n2);
        String str = "";
        if (text == null) {
            text = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(text, "a.getText(R.styleable.Gu\u2026dFeedTextView_text) ?: \"\"");
        }
        String string = obtainStyledAttributes.getString(w12.a.f444308p2);
        if (string != null) {
            str = string;
        }
        Intrinsics.checkNotNullExpressionValue(str, "a.getString(R.styleable.\u2026edTextView_textKey) ?: \"\"");
        c16.f(text, str);
        c16.b(new wq0.i());
        addView(c16.getView());
        this.guildTextView = c16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }
}

package com.tencent.qqnt.chats.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/GuildSummaryLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "summaryIcon", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "f", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "()Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "summaryRedPrefix", h.F, "b", "summaryGrayPrefix", "i", "summaryMsg", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildSummaryLayout extends LinearLayoutCompat {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView summaryIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SingleLineTextView summaryRedPrefix;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SingleLineTextView summaryGrayPrefix;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SingleLineTextView summaryMsg;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSummaryLayout(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) ctx);
    }

    @NotNull
    public final SingleLineTextView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SingleLineTextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.summaryGrayPrefix;
    }

    @NotNull
    public final ImageView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.summaryIcon;
    }

    @NotNull
    public final SingleLineTextView d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SingleLineTextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.summaryMsg;
    }

    @NotNull
    public final SingleLineTextView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SingleLineTextView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.summaryRedPrefix;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSummaryLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) ctx, (Object) attributeSet);
    }

    public /* synthetic */ GuildSummaryLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSummaryLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ctx, attributeSet, Integer.valueOf(i3));
            return;
        }
        View inflate = View.inflate(getContext(), R.layout.f9r, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ild_summary_layout, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f907553b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.summary_icon)");
        this.summaryIcon = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f907753d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.summary_red_prefix)");
        this.summaryRedPrefix = (SingleLineTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f907453a);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.summary_gray_prefix)");
        this.summaryGrayPrefix = (SingleLineTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f907653c);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.summary_msg)");
        this.summaryMsg = (SingleLineTextView) findViewById4;
    }
}

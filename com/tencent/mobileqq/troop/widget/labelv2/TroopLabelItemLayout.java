package com.tencent.mobileqq.troop.widget.labelv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelItemLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "hostContext", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "leftIconIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "a", "()Landroid/widget/TextView;", "contentTv", h.F, "c", "rightIconIv", "<init>", "(Landroid/content/Context;)V", "i", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes19.dex */
public final class TroopLabelItemLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context hostContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView leftIconIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView contentTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView rightIconIv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelItemLayout$a;", "", "", "CORNER_RADIUS", UserInfo.SEX_FEMALE, "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.widget.labelv2.TroopLabelItemLayout$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopLabelItemLayout(@NotNull Context hostContext) {
        super(hostContext);
        Intrinsics.checkNotNullParameter(hostContext, "hostContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hostContext);
            return;
        }
        this.hostContext = hostContext;
        LayoutInflater.from(getContext()).inflate(R.layout.gvi, (ViewGroup) this, true);
        ColorStateList colorStateList = getContext().getColorStateList(R.color.qui_common_fill_standard_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026on_fill_standard_primary)");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(colorStateList);
        gradientDrawable.setCornerRadius(ViewUtils.dip2px(4.0f));
        setBackground(gradientDrawable);
        View findViewById = findViewById(R.id.e7j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.left_icon)");
        this.leftIconIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.k6s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_content)");
        this.contentTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f166793ia2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.right_icon)");
        this.rightIconIv = (ImageView) findViewById3;
    }

    @NotNull
    public final TextView a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contentTv;
    }

    @NotNull
    public final ImageView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.leftIconIv;
    }

    @NotNull
    public final ImageView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rightIconIv;
    }
}

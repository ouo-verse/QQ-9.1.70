package com.tencent.qqnt.chats.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chats.view.api.IRecentAvatarApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nw3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\u001b\u0010\"B+\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b\u001b\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/DefaultRecentAvatarView;", "Landroid/widget/FrameLayout;", "Lnw3/a;", "Landroid/widget/ImageView;", "getAvatarView", "Landroid/view/View;", "getAvatarLayout", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "getAvatarUnread", "", "redPointWidth", "redPointHeight", "", "isNumPoint", "", "setTopRightHole", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "d", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "avatar", "e", "Landroid/widget/ImageView;", h.F, "()Landroid/widget/ImageView;", "bottomRightIcon", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DefaultRecentAvatarView extends FrameLayout implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView avatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView bottomRightIcon;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultRecentAvatarView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // nw3.a
    @NotNull
    public View getAvatarLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this;
    }

    @Override // nw3.a
    @Nullable
    public QUIBadge getAvatarUnread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUIBadge) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // nw3.a
    @NotNull
    public ImageView getAvatarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ImageView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.avatar;
    }

    @NotNull
    public final ImageView h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ImageView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bottomRightIcon;
    }

    @Override // nw3.a
    public void setTopRightHole(float redPointWidth, float redPointHeight, boolean isNumPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(redPointWidth), Float.valueOf(redPointHeight), Boolean.valueOf(isNumPoint));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultRecentAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultRecentAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRecentAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RoundRectImageView roundRectImageView = new RoundRectImageView(getContext(), null, 0, 6, null);
        roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        IRecentAvatarApi iRecentAvatarApi = (IRecentAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRecentAvatarApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int recentAvatarSize = iRecentAvatarApi.getRecentAvatarSize(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(recentAvatarSize, recentAvatarSize);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(roundRectImageView, layoutParams);
        this.avatar = roundRectImageView;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setVisibility(8);
        int dpToPx = ViewUtils.dpToPx(22.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.gravity = 0;
        addView(imageView, layoutParams2);
        this.bottomRightIcon = imageView;
    }
}

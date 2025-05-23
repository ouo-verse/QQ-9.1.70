package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b$\u0010(B#\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010)\u001a\u00020\u0005\u00a2\u0006\u0004\b$\u0010*J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/avatar/NtVasAvatarView;", "Lcom/tencent/mobileqq/vas/avatar/NtAvatarLayout;", "Lcom/tencent/mobileqq/vas/avatar/IVasAvatarView;", "", "uin", "", "faceId", "headSize", "source", "", "startLoadAvatar", "pauseAnim", "resumeAnim", "Landroid/widget/ImageView;", "getAvatarView", "Landroid/view/View;", "getAvatarLayout", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "getAvatarUnread", "", "redPointWidth", "redPointHeight", "", "isNumPoint", "setTopRightHole", "Lcom/tencent/mobileqq/vas/avatar/NtVasAvatar;", "f", "Lcom/tencent/mobileqq/vas/avatar/NtVasAvatar;", "avatar", tl.h.F, "baseAvatar", "i", "Landroid/widget/ImageView;", IndividuationUrlHelper.UrlId.PENDANT_HOME, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NtVasAvatarView extends NtAvatarLayout implements IVasAvatarView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NtVasAvatar avatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NtVasAvatar baseAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView pendant;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtVasAvatarView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatar = new NtVasAvatar(getContext());
        this.baseAvatar = new NtVasAvatar(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.pendant = imageView;
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView, nw3.a
    @Nullable
    public QUIBadge getAvatarUnread() {
        return null;
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView, nw3.a
    @NotNull
    public ImageView getAvatarView() {
        return this.baseAvatar;
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView
    public void startLoadAvatar(@NotNull String uin, int faceId, int headSize, int source) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        j(0, this.baseAvatar, true);
        j(1, this.avatar, true);
        h(uin, faceId, source, h.b(headSize), ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtVasAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatar = new NtVasAvatar(getContext());
        this.baseAvatar = new NtVasAvatar(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.pendant = imageView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtVasAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatar = new NtVasAvatar(getContext());
        this.baseAvatar = new NtVasAvatar(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.pendant = imageView;
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView, nw3.a
    @NotNull
    public View getAvatarLayout() {
        return this;
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView
    public void pauseAnim() {
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView
    public void resumeAnim() {
    }

    @Override // com.tencent.mobileqq.vas.avatar.IVasAvatarView, nw3.a
    public void setTopRightHole(float redPointWidth, float redPointHeight, boolean isNumPoint) {
    }
}

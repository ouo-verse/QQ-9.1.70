package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSexImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/profile/impl/view/ProfileUserInfoView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "b", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "setData", "", "a", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "d", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "roundImageView", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "e", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "avatarTextView", "Lcom/tencent/timi/game/userinfo/api/view/AvatarSexImageView;", "f", "Lcom/tencent/timi/game/userinfo/api/view/AvatarSexImageView;", "sexImageView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ProfileUserInfoView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarRoundImageView roundImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarTextView avatarTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarSexImageView sexImageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileUserInfoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }

    private final void b(Context context) {
        View.inflate(context, R.layout.f169127hw2, this);
        setOrientation(1);
        this.roundImageView = (AvatarRoundImageView) findViewById(R.id.f7842471);
        this.avatarTextView = (AvatarTextView) findViewById(R.id.t0s);
        this.sexImageView = (AvatarSexImageView) findViewById(R.id.f83974l0);
    }

    @NotNull
    public final String a() {
        String str;
        AvatarTextView avatarTextView = this.avatarTextView;
        if (avatarTextView != null) {
            str = avatarTextView.h();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void setData(@NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        AvatarRoundImageView avatarRoundImageView = this.roundImageView;
        if (avatarRoundImageView != null) {
            avatarRoundImageView.setUserId(userId);
        }
        AvatarTextView avatarTextView = this.avatarTextView;
        if (avatarTextView != null) {
            avatarTextView.setUserId(userId);
        }
        AvatarSexImageView avatarSexImageView = this.sexImageView;
        if (avatarSexImageView != null) {
            avatarSexImageView.setUserId(userId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileUserInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileUserInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }
}

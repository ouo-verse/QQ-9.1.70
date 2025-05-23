package com.tencent.state.square.detail;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.view.BaseAvatarAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\rH\u0016J(\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/detail/DetailAvatarAnimator;", "Lcom/tencent/state/view/BaseAvatarAnimator;", "avatarImage", "Landroid/view/View;", "avatarView", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "parentWidth", "", "parentHeight", "detailConfig", "Lcom/tencent/state/square/detail/DetailAnimaConfig;", "(Landroid/view/View;Lcom/tencent/state/square/avatar/ISquareAvatarView;IILcom/tencent/state/square/detail/DetailAnimaConfig;)V", "doAvatarScaleAnim", "", "isScaleToEditor", "", "doAvatarScaleBackEditor", "doAvatarScaleToEditor", "getAvatarLocation", "Lcom/tencent/state/map/Location;", "getEditorAvatarLocation", "onAvatarViewShow", "startDetailScaleTranslation", "startY", "", "endY", "scaleRatio", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailAvatarAnimator extends BaseAvatarAnimator {
    private static final long DETAIL_TIMES = 300;
    private static final String TAG = "DetailAvatarAnimator";
    private final View avatarImage;
    private final ISquareAvatarView avatarView;
    private final DetailAnimaConfig detailConfig;
    private final int parentHeight;
    private final int parentWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailAvatarAnimator(View avatarImage, ISquareAvatarView avatarView, int i3, int i16, DetailAnimaConfig detailConfig) {
        super(avatarView);
        Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(detailConfig, "detailConfig");
        this.avatarImage = avatarImage;
        this.avatarView = avatarView;
        this.parentWidth = i3;
        this.parentHeight = i16;
        this.detailConfig = detailConfig;
    }

    private final void doAvatarScaleBackEditor() {
        float avatarHeight = this.detailConfig.getAvatarHeight();
        float f16 = 2;
        startDetailScaleTranslation(false, (this.parentHeight - ((this.detailConfig.getEditorAvatarSize().getHeight() + avatarHeight) / f16)) - this.detailConfig.getEditorBottomDistance(), (this.parentHeight - avatarHeight) / f16, this.detailConfig.getEditorAvatarSize().getHeight() / avatarHeight);
    }

    private final void doAvatarScaleToEditor() {
        float avatarHeight = this.detailConfig.getAvatarHeight();
        int i3 = this.parentHeight;
        float f16 = 2;
        startDetailScaleTranslation(true, (i3 - avatarHeight) / f16, (i3 - ((this.detailConfig.getEditorAvatarSize().getHeight() + avatarHeight) / f16)) - this.detailConfig.getEditorBottomDistance(), this.detailConfig.getEditorAvatarSize().getHeight() / avatarHeight);
    }

    private final void startDetailScaleTranslation(boolean isScaleToEditor, float startY, float endY, float scaleRatio) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.avatarImage, "translationY", startY, endY);
        SquareBaseKt.getSquareLog().i(TAG, " startY=" + startY + ", endY=" + endY);
        float f16 = isScaleToEditor ? 1.0f : scaleRatio;
        if (!isScaleToEditor) {
            scaleRatio = 1.0f;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.avatarImage, BasicAnimation.KeyPath.SCALE_X, f16, scaleRatio);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.avatarImage, BasicAnimation.KeyPath.SCALE_Y, f16, scaleRatio);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    public final Location getAvatarLocation() {
        int avatarHeight = this.detailConfig.getAvatarHeight();
        int avatarWidth = this.detailConfig.getAvatarWidth();
        return new Location((this.parentWidth - avatarWidth) / 2, (this.parentHeight - avatarHeight) / 2, avatarWidth, avatarHeight, 0, 0, 48, null);
    }

    public final Location getEditorAvatarLocation() {
        return new Location((this.parentWidth - this.detailConfig.getEditorAvatarSize().getWidth()) / 2, (this.parentHeight - this.detailConfig.getEditorAvatarSize().getHeight()) - this.detailConfig.getEditorBottomDistance(), this.detailConfig.getEditorAvatarSize().getWidth(), this.detailConfig.getEditorAvatarSize().getHeight(), 0, 0, 48, null);
    }

    @Override // com.tencent.state.view.BaseAvatarAnimator
    public void onAvatarViewShow() {
        View findViewById = this.avatarImage.findViewById(R.id.f163390pv4);
        if (findViewById != null) {
            ViewExtensionsKt.setVisibility(findViewById, true);
        }
    }

    public final void doAvatarScaleAnim(boolean isScaleToEditor) {
        if (isScaleToEditor) {
            doAvatarScaleToEditor();
        } else {
            doAvatarScaleBackEditor();
        }
    }
}

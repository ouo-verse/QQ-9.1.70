package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.util.ResourceUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0019\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/LimitedTimeRecommendAvatarGroup;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarSize", "addAvatar", "", "avatar", "", "position", "setAvatars", "avatarArray", "", "([Ljava/lang/String;)V", "AvatarURLDrawableListener", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LimitedTimeRecommendAvatarGroup extends RelativeLayout {
    private static final float ICON_OFFSET = 0.6666667f;
    private static final String TAG = "LimitedTimeRecommendAvatarGroup";
    private final int avatarSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/LimitedTimeRecommendAvatarGroup$AvatarURLDrawableListener;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "imageView", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "imageRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "onLoadCanceled", "", "p0", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "p1", "", "onLoadProgressed", "", "onLoadSuccessed", "urlDrawable", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class AvatarURLDrawableListener implements URLDrawable.URLDrawableListener {
        private final WeakReference<ImageView> imageRef;

        public AvatarURLDrawableListener(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.imageRef = new WeakReference<>(imageView);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            ImageView imageView = this.imageRef.get();
            if (imageView != null) {
                imageView.setImageDrawable(urlDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            QLog.e(LimitedTimeRecommendAvatarGroup.TAG, 1, "load avatar failed");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    public LimitedTimeRecommendAvatarGroup(Context context) {
        super(context);
        this.avatarSize = com.tencent.qqnt.base.utils.c.f353052a.b(26);
    }

    public final void setAvatars(String[] avatarArray) {
        Intrinsics.checkNotNullParameter(avatarArray, "avatarArray");
        removeAllViews();
        int length = avatarArray.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            addAvatar(avatarArray[i3], i16);
            i3++;
            i16++;
        }
    }

    public LimitedTimeRecommendAvatarGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avatarSize = com.tencent.qqnt.base.utils.c.f353052a.b(26);
    }

    public LimitedTimeRecommendAvatarGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.avatarSize = com.tencent.qqnt.base.utils.c.f353052a.b(26);
    }

    private final void addAvatar(String avatar, int position) {
        int roundToInt;
        if (avatar == null || avatar.length() == 0) {
            QLog.e(TAG, 1, "addAvatar avatar invalid");
            return;
        }
        MiniAppRoundWithBorderImageView miniAppRoundWithBorderImageView = new MiniAppRoundWithBorderImageView(getContext(), null, 0);
        miniAppRoundWithBorderImageView.setCornerRadiusAndMode(ViewUtils.dip2px(13.0f), 1);
        miniAppRoundWithBorderImageView.setBorderPaint(ResourceUtil.getColor(R.color.qui_common_bg_bottom_light), Paint.Style.STROKE, com.tencent.qqnt.base.utils.c.f353052a.a(2.0f));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int i3 = this.avatarSize;
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i3;
        URLDrawable drawable = URLDrawable.getDrawable(avatar, obtain);
        if (drawable.getStatus() == 1) {
            miniAppRoundWithBorderImageView.setImageDrawable(drawable);
        } else {
            drawable.setURLDrawableListener(new AvatarURLDrawableListener(miniAppRoundWithBorderImageView));
            drawable.startDownload();
        }
        int i16 = this.avatarSize;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i16, i16);
        if (position != 0) {
            roundToInt = MathKt__MathJVMKt.roundToInt(this.avatarSize * ICON_OFFSET * position);
            layoutParams.leftMargin = roundToInt;
        }
        layoutParams.addRule(17);
        addView(miniAppRoundWithBorderImageView, layoutParams);
    }
}

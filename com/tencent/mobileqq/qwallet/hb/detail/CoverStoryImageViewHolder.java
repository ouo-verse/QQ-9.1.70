package com.tencent.mobileqq.qwallet.hb.detail;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\u0014\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryImageViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryBaseViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "storyRes", "", "w", "", "scrollOffset", "intermediateOffset", "totalScrollRange", "t", "u", "Landroid/graphics/drawable/Drawable;", "J", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "K", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "", "L", "I", "lastOffset", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "M", "Landroid/widget/ImageView;", "imageView", "", "N", "Z", "isMiddleMode", "Landroid/view/View;", "itemView", "skinId", "<init>", "(Landroid/view/View;I)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CoverStoryImageViewHolder extends CoverStoryBaseViewHolder {

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final Drawable defaultDrawable;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private HbSkinData.StoryRes storyRes;

    /* renamed from: L, reason: from kotlin metadata */
    private int lastOffset;

    /* renamed from: M, reason: from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: N, reason: from kotlin metadata */
    private final boolean isMiddleMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverStoryImageViewHolder(@NotNull View itemView, int i3) {
        super(itemView, i3);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Drawable drawable = ContextCompat.getDrawable(itemView.getContext(), R.drawable.nvg);
        this.defaultDrawable = drawable;
        ImageView imageView = (ImageView) itemView.findViewById(R.id.xiw);
        this.imageView = imageView;
        this.isMiddleMode = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_HB_DETAIL_IMAGE_MIDDLE_MODE, true);
        imageView.setImageDrawable(drawable);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void t(float scrollOffset, float intermediateOffset, float totalScrollRange) {
        super.t(scrollOffset, intermediateOffset, totalScrollRange);
        int i3 = (int) (scrollOffset - totalScrollRange);
        this.lastOffset = i3;
        this.itemView.scrollTo(0, i3 / 2);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void u() {
        String str;
        super.u();
        if (this.isMiddleMode) {
            ImageView imageView = this.imageView;
            HbSkinData.StoryRes storyRes = this.storyRes;
            if (storyRes != null) {
                str = storyRes.getImgUrl();
            } else {
                str = null;
            }
            Drawable drawable = this.defaultDrawable;
            imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str, drawable, drawable));
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.detail.CoverStoryBaseViewHolder
    public void w(@Nullable HbSkinData hbSkinData, @NotNull HbSkinData.StoryRes storyRes) {
        Intrinsics.checkNotNullParameter(storyRes, "storyRes");
        QLog.i("CoverStoryImageViewHolder", 1, "isMiddleMode: " + this.isMiddleMode);
        if (this.isMiddleMode) {
            this.storyRes = storyRes;
            return;
        }
        ImageView imageView = this.imageView;
        String imgUrl = storyRes.getImgUrl();
        Drawable drawable = this.defaultDrawable;
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(imgUrl, drawable, drawable));
    }
}

package com.tencent.mobileqq.guild.homev2.parts.title.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.bl;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u001cB1\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2CoverLayout;", "Landroid/widget/FrameLayout;", "", "b", "", "statusBarHeight", "extraHeight", "", "from", "g", "url", "f", "c", "e", "Lvp1/bl;", "d", "Lvp1/bl;", "mBinding", "()Lvp1/bl;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2CoverLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bl mBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        int color = this.mBinding.f442504d.getResources().getColor(R.color.qui_common_bg_bottom_light);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildHomeV2CoverLayout", 1, "updateColorMaskColor color:" + Util.toHexString(color));
        }
        this.mBinding.f442504d.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, color}));
    }

    public final void c() {
        String str;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2CoverLayout", 1, "forceReloadCover tag:" + this.mBinding.f442502b.getTag());
        }
        Object tag = this.mBinding.f442502b.getTag();
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        GuildHomeV2CoverTopCenterCropImageView guildHomeV2CoverTopCenterCropImageView = this.mBinding.f442502b;
        Intrinsics.checkNotNullExpressionValue(guildHomeV2CoverTopCenterCropImageView, "mBinding.guildCover");
        v.l(str, guildHomeV2CoverTopCenterCropImageView, null, 4, null);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final bl getMBinding() {
        return this.mBinding;
    }

    public final void e() {
        Logger.f235387a.d().a("GuildHomeV2CoverLayout", 1, "updateColorWhenThemeChange");
        b();
    }

    public final void f(@NotNull String url) {
        boolean isBlank;
        int i3;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.f235387a.d().i("GuildHomeV2CoverLayout", 1, "start updateCoverUrl url:" + url);
        GuildHomeV2CoverTopCenterCropImageView guildHomeV2CoverTopCenterCropImageView = this.mBinding.f442502b;
        Intrinsics.checkNotNullExpressionValue(guildHomeV2CoverTopCenterCropImageView, "mBinding.guildCover");
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        int i16 = 0;
        if (!isBlank) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        guildHomeV2CoverTopCenterCropImageView.setVisibility(i3);
        ImageView imageView = this.mBinding.f442504d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.guildCoverMask");
        isBlank2 = StringsKt__StringsJVMKt.isBlank(url);
        if (!(!isBlank2)) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        if (Intrinsics.areEqual(this.mBinding.f442502b.getTag(), url)) {
            return;
        }
        GuildHomeV2CoverTopCenterCropImageView guildHomeV2CoverTopCenterCropImageView2 = this.mBinding.f442502b;
        Intrinsics.checkNotNullExpressionValue(guildHomeV2CoverTopCenterCropImageView2, "mBinding.guildCover");
        v.l(url, guildHomeV2CoverTopCenterCropImageView2, null, 4, null);
        this.mBinding.f442502b.setTag(url);
    }

    public final void g(int statusBarHeight, int extraHeight, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        float dimension = statusBarHeight + getResources().getDimension(R.dimen.cfe) + getResources().getDimension(R.dimen.cfd) + getResources().getDimension(R.dimen.cfc);
        ViewGroup.LayoutParams layoutParams = this.mBinding.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int i3 = (int) dimension;
        layoutParams.height = extraHeight + i3;
        this.mBinding.getRoot().setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.mBinding.f442504d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.height = i3;
        this.mBinding.f442504d.setLayoutParams(layoutParams2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeV2CoverLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2CoverLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().i("GuildHomeV2CoverLayout", 1, "start init");
        setClipChildren(false);
        bl g16 = bl.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        g(ImmersiveUtils.getStatusBarHeight(context), 0, "init");
        b();
    }
}

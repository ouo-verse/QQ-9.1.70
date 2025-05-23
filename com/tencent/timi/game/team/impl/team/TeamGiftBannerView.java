package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.timi.game.team.impl.team.TeamGiftBannerView;
import com.tencent.timi.game.ui.widget.TopCropImageView;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.aw;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import um4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0017\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/team/impl/team/TeamGiftBannerView;", "Landroid/widget/FrameLayout;", "", "", "f", "", "materialID", "e", "Lcom/tencent/image/URLImageView;", "igv", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "c", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGiftConfig;", "data", "d", "Lnr2/aw;", "Lnr2/aw;", "binding", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGiftConfig;", "mData", "com/tencent/timi/game/team/impl/team/TeamGiftBannerView$b", tl.h.F, "Lcom/tencent/timi/game/team/impl/team/TeamGiftBannerView$b;", "mGiftResListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TeamGiftBannerView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private aw binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable defaultColorDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private YoloRoomOuterClass$YoloGiftConfig mData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mGiftResListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/team/impl/team/TeamGiftBannerView$b", "Lqh2/f;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements qh2.f {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TeamGiftBannerView this$0, QQGiftPanelResource qQGiftPanelResource) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TopCropImageView topCropImageView = this$0.binding.f420923b;
            um4.a aVar = um4.a.f439223a;
            String str = qQGiftPanelResource.f265002b;
            Intrinsics.checkNotNullExpressionValue(str, "panelResource.thumbPath");
            TopCropImageView topCropImageView2 = this$0.binding.f420923b;
            Intrinsics.checkNotNullExpressionValue(topCropImageView2, "binding.giftIcon");
            topCropImageView.setImageDrawable(aVar.a(str, this$0.c(topCropImageView2)));
        }

        @Override // qh2.f
        public void c(int id5, @Nullable final QQGiftPanelResource panelResource) {
            l.h("TeamGiftBannerView_", 1, "onLoadSuccess panelResource:" + panelResource);
            if (panelResource == null) {
                return;
            }
            final TeamGiftBannerView teamGiftBannerView = TeamGiftBannerView.this;
            teamGiftBannerView.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.team.f
                @Override // java.lang.Runnable
                public final void run() {
                    TeamGiftBannerView.b.b(TeamGiftBannerView.this, panelResource);
                }
            });
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
            l.c("TeamGiftBannerView_", 1, "onLoadFail id:" + id5 + ", errorCode:" + errorCode + " httpCode:" + httpCode + ", errorMessage:" + errorMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamGiftBannerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URLDrawable.URLDrawableOptions c(URLImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = this.defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = this.defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    private final void e(int materialID) {
        nh2.c d16 = k.f439239a.d();
        if (d16 == null) {
            l.e("TeamGiftBannerView_", "refreshGiftInfo giftSdk is null");
            return;
        }
        l.h("TeamGiftBannerView_", 1, "refreshGiftInfo getGiftPanelResource  materialID:" + materialID);
        d16.b().e(materialID, this.mGiftResListener);
    }

    private final void f() {
        e(this.mData.gift_material_id.get());
        this.binding.f420924c.setText(this.mData.gift_name.get() + HippyTKDListViewAdapter.X + this.mData.gift_num.get());
        this.binding.f420924c.requestLayout();
    }

    public final void d(@NotNull YoloRoomOuterClass$YoloGiftConfig data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamGiftBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TeamGiftBannerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamGiftBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultColorDrawable = new ColorDrawable(Color.parseColor("#AAD8D8D8"));
        this.mData = new YoloRoomOuterClass$YoloGiftConfig();
        aw g16 = aw.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.mGiftResListener = new b();
    }
}

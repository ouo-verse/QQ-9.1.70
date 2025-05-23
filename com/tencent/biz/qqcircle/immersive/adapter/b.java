package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/b;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/k;", "Lcom/tencent/biz/qqcircle/immersive/adapter/b$b;", "", "u0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "v0", "k0", "holder", com.tencent.luggage.wxa.c8.c.G, "t0", "", "G", "Ljava/lang/String;", "getIntroUrl", "()Ljava/lang/String;", "x0", "(Ljava/lang/String;)V", "introUrl", "H", "getRightsUrl", "y0", "rightsUrl", "I", "getDutyUrl", "w0", "dutyUrl", "<init>", "()V", "J", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends com.tencent.biz.qqcircle.immersive.views.banner.k<C0874b> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String introUrl = "";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String rightsUrl = "";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String dutyUrl = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "picUrl", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "getPicView", "()Landroid/widget/ImageView;", "picView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0874b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final ImageView picView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0874b(@NotNull View itemView, @Nullable ImageView imageView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.picView = imageView;
        }

        public final void l(@NotNull String picUrl) {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            ImageView imageView = this.picView;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl(this.picView.getContext(), picUrl)).setRegionWidth(cx.a(343.0f)).setRegionHeight(cx.a(191.0f)).setLoadingDrawableColor(0).setTargetView(this.picView));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(@Nullable C0874b holder, int pos) {
        if (pos != 0) {
            if (pos != 1) {
                if (holder != null) {
                    holder.l(this.dutyUrl);
                    return;
                }
                return;
            } else {
                if (holder != null) {
                    holder.l(this.rightsUrl);
                    return;
                }
                return;
            }
        }
        if (holder != null) {
            holder.l(this.introUrl);
        }
    }

    public final void u0() {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public C0874b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, cx.a(191.0f), 17));
        imageView.setMaxWidth(cx.a(343.0f));
        frameLayout.addView(imageView);
        return new C0874b(frameLayout, imageView);
    }

    public final void w0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dutyUrl = str;
    }

    public final void x0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.introUrl = str;
    }

    public final void y0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightsUrl = str;
    }
}

package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.view.WinkDownLoadingView;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b+\u0010,J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J9\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/StyleItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "downloadProgressRadius", "downloadProgressStrokeWidth", "downloadBgWidth", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "info", "", "countUsed", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "adapterPos", "onItemClicked", "t", "Landroid/view/View;", "E", "Landroid/view/View;", "view", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "o", "()Landroid/widget/ImageView;", "cover", "G", "p", "downloadIcon", "Lcom/tencent/mobileqq/wink/editor/view/WinkDownLoadingView;", "H", "r", "()Lcom/tencent/mobileqq/wink/editor/view/WinkDownLoadingView;", "progressView", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "loadingIcon", "Landroid/widget/FrameLayout;", "J", "Landroid/widget/FrameLayout;", "cardView", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StyleItem extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy cover;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy downloadIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy progressView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout cardView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StyleItem(@NotNull View view) {
        super(view);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleItem$cover$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view2;
                view2 = StyleItem.this.view;
                return (ImageView) view2.findViewById(R.id.bat);
            }
        });
        this.cover = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleItem$downloadIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view2;
                view2 = StyleItem.this.view;
                return (ImageView) view2.findViewById(R.id.y2f);
            }
        });
        this.downloadIcon = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkDownLoadingView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleItem$progressView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkDownLoadingView invoke() {
                View view2;
                view2 = StyleItem.this.view;
                return (WinkDownLoadingView) view2.findViewById(R.id.g2d);
            }
        });
        this.progressView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.StyleItem$loadingIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view2;
                view2 = StyleItem.this.view;
                return (ImageView) view2.findViewById(R.id.y5f);
            }
        });
        this.loadingIcon = lazy4;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.cardView = (FrameLayout) view;
        s(ViewExKt.d(6), ViewExKt.d(2), ViewExKt.d(16));
    }

    private final ImageView o() {
        Object value = this.cover.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cover>(...)");
        return (ImageView) value;
    }

    private final ImageView p() {
        Object value = this.downloadIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-downloadIcon>(...)");
        return (ImageView) value;
    }

    private final ImageView q() {
        Object value = this.loadingIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingIcon>(...)");
        return (ImageView) value;
    }

    private final WinkDownLoadingView r() {
        Object value = this.progressView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-progressView>(...)");
        return (WinkDownLoadingView) value;
    }

    private final void s(int downloadProgressRadius, int downloadProgressStrokeWidth, int downloadBgWidth) {
        r().setBgCorner(downloadBgWidth / 2.0f);
        r().setMinimumHeight(downloadBgWidth);
        r().setMinimumWidth(downloadBgWidth);
        r().setProgressSizeAndMode(downloadProgressRadius, downloadProgressStrokeWidth, false);
        r().setBgColor(0);
        r().setProgressColor(-1);
        r().b(false);
        r().setProgress(30L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 onItemClicked, StyleItem this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onItemClicked.invoke(Integer.valueOf(this$0.getAdapterPosition()));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e6, code lost:
    
        if (r1 != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(@NotNull MagicAvatarMaterialInfo info, boolean countUsed, @NotNull final Function1<? super Integer, Unit> onItemClicked) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StyleItem.u(Function1.this, this, view);
            }
        });
        boolean z19 = true;
        if (info.getType() == 1) {
            o().setImageDrawable(ContextCompat.getDrawable(this.cardView.getContext(), R.drawable.f162058oq4));
        } else {
            if (info.getLocalPicPath().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                o().setImageDrawable(URLDrawable.getFileDrawable(info.getLocalPicPath(), ViewUtilsKt.d()));
            } else {
                o().setImageDrawable(URLDrawable.getDrawable(info.getMaterialUrl(), ViewUtilsKt.d()));
            }
        }
        p().setVisibility(4);
        q().setVisibility(4);
        r().setVisibility(4);
        if (info.getIsSelected()) {
            FrameLayout frameLayout = this.cardView;
            frameLayout.setBackground(ContextCompat.getDrawable(frameLayout.getContext(), R.drawable.jvy));
            if (info.getGenerateUrl().length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (info.getLocalPicPath().length() != 0) {
                    z19 = false;
                }
                if (!z19) {
                    return;
                }
            }
            if (countUsed) {
                p().setVisibility(0);
                return;
            } else {
                q().setVisibility(0);
                r().setVisibility(0);
                return;
            }
        }
        if (info.getGenerateUrl().length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            if (info.getLocalPicPath().length() != 0) {
                z19 = false;
            }
        }
        p().setVisibility(0);
        FrameLayout frameLayout2 = this.cardView;
        frameLayout2.setBackground(ContextCompat.getDrawable(frameLayout2.getContext(), R.drawable.jvz));
    }
}

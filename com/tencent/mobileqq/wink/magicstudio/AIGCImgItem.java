package com.tencent.mobileqq.wink.magicstudio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.State;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J1\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/AIGCImgItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "p", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "onItemClicked", "v", "Landroid/view/View;", "E", "Landroid/view/View;", "view", "", UserInfo.SEX_FEMALE, "Z", "isSupportMultiSelect", "Lcom/google/android/material/card/MaterialCardView;", "G", "Lcom/google/android/material/card/MaterialCardView;", "cardView", "Landroid/widget/ImageView;", "H", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/ImageView;", "cover", "Landroid/widget/TextView;", "I", "t", "()Landroid/widget/TextView;", "errorTip", "Lorg/libpag/PAGView;", "J", "u", "()Lorg/libpag/PAGView;", "loadingIcon", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "K", "r", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkButton", "<init>", "(Landroid/view/View;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AIGCImgItem extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isSupportMultiSelect;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MaterialCardView cardView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy cover;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy errorTip;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingIcon;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy checkButton;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f323609a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.Success.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f323609a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCImgItem(@NotNull View view, boolean z16) {
        super(view);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.isSupportMultiSelect = z16;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
        this.cardView = (MaterialCardView) view;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicstudio.AIGCImgItem$cover$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view2;
                view2 = AIGCImgItem.this.view;
                return (ImageView) view2.findViewById(R.id.bat);
            }
        });
        this.cover = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.AIGCImgItem$errorTip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view2;
                view2 = AIGCImgItem.this.view;
                return (TextView) view2.findViewById(R.id.error_tip);
            }
        });
        this.errorTip = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PAGView>() { // from class: com.tencent.mobileqq.wink.magicstudio.AIGCImgItem$loadingIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PAGView invoke() {
                View view2;
                view2 = AIGCImgItem.this.view;
                return (PAGView) view2.findViewById(R.id.f166130ys3);
            }
        });
        this.loadingIcon = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QUICheckBox>() { // from class: com.tencent.mobileqq.wink.magicstudio.AIGCImgItem$checkButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUICheckBox invoke() {
                View view2;
                view2 = AIGCImgItem.this.view;
                return (QUICheckBox) view2.findViewById(R.id.f164792ax1);
            }
        });
        this.checkButton = lazy4;
    }

    private final void o() {
        this.cardView.setStrokeWidth(0);
        t().setVisibility(0);
        s().setVisibility(8);
        r().setVisibility(8);
        u().stop();
        u().setVisibility(8);
    }

    private final void p() {
        this.cardView.setStrokeWidth(0);
        t().setVisibility(8);
        s().setVisibility(8);
        r().setVisibility(8);
        u().setVisibility(0);
        String S = MagicStudioDataSource.S(MagicStudioDataSource.f323652a, false, 1, null);
        if (new File(S).exists()) {
            PAGFile Load = PagViewMonitor.Load(S);
            Intrinsics.checkNotNullExpressionValue(Load, "Load(path)");
            u().setScaleMode(3);
            u().setComposition(Load);
            u().setRepeatCount(0);
            u().setProgress(0.1d);
            u().play();
        }
    }

    private final void q(GenerateInfo info) {
        boolean z16;
        try {
            if (info.getAigcImgPath().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                t().setVisibility(8);
                s().setVisibility(0);
                s().setImageBitmap(com.tencent.mobileqq.wink.utils.f.e(info.getAigcImgPath(), null));
                u().setVisibility(8);
                u().stop();
            } else {
                o();
            }
        } catch (Throwable unused) {
        }
        if (info.getIsSelected()) {
            this.cardView.setStrokeWidth(ViewExKt.d(4));
        } else {
            this.cardView.setStrokeWidth(0);
        }
        if (this.isSupportMultiSelect) {
            r().setVisibility(0);
        } else {
            r().setVisibility(8);
        }
        r().setChecked(info.getIsSelected());
    }

    private final QUICheckBox r() {
        Object value = this.checkButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-checkButton>(...)");
        return (QUICheckBox) value;
    }

    private final ImageView s() {
        Object value = this.cover.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cover>(...)");
        return (ImageView) value;
    }

    private final TextView t() {
        Object value = this.errorTip.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-errorTip>(...)");
        return (TextView) value;
    }

    private final PAGView u() {
        Object value = this.loadingIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingIcon>(...)");
        return (PAGView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GenerateInfo info, Function1 onItemClicked, AIGCImgItem this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (info.getAigcImgPath().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            onItemClicked.invoke(Integer.valueOf(this$0.getAdapterPosition()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GenerateInfo info, Function1 onItemClicked, AIGCImgItem this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (info.getAigcImgPath().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            onItemClicked.invoke(Integer.valueOf(this$0.getAdapterPosition()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void v(@NotNull final GenerateInfo info, @NotNull final Function1<? super Integer, Unit> onItemClicked) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCImgItem.w(GenerateInfo.this, onItemClicked, this, view);
            }
        });
        r().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCImgItem.x(GenerateInfo.this, onItemClicked, this, view);
            }
        });
        int i3 = a.f323609a[info.getState().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    q(info);
                    return;
                }
                return;
            }
            o();
            return;
        }
        p();
    }
}

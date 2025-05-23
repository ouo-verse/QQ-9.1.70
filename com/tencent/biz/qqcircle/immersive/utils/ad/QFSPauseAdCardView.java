package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdCardView;", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView;", "", "position", "duration", "", "K0", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "L0", "", "F0", "Landroid/widget/ProgressBar;", "G", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPauseAdCardView extends QFSPauseAdBaseView {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ProgressBar progressBar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdCardView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(QFSPauseAdCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSPauseAdBaseView.a dismissCallback = this$0.getDismissCallback();
        if (dismissCallback != null) {
            dismissCallback.onDismiss(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView
    protected int F0() {
        return R.layout.gck;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView
    public void K0(long position, long duration) {
        super.K0(position, duration);
        if (duration == 0) {
            return;
        }
        this.progressBar.setProgress((int) ((1000 * position) / duration));
    }

    @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView
    public boolean L0(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        boolean L0 = super.L0(gdtAd);
        getNegativeFeedback().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPauseAdCardView.S0(QFSPauseAdCardView.this, view);
            }
        });
        View findViewById = findViewById(R.id.sb6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_card_ad_source_btn)");
        Q0(findViewById, 2.0f);
        Q0(getMediaImage(), 4.0f);
        Q0(getVideoLayout(), 4.0f);
        return L0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QFSPauseAdCardView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.f504125b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_pull_ad_progress_bar)");
        this.progressBar = (ProgressBar) findViewById;
    }
}

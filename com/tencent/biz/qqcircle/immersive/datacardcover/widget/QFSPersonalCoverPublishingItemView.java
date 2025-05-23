package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPublishingItemView;
import com.tencent.biz.qqcircle.immersive.views.QFSRoundProgressView;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import h40.QFSPersonalCoverFeedInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0014J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\fH\u0014R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishingItemView;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBaseItemView;", "Lh40/a;", "coverFeedInfo", "", "l0", "p0", "", "getLayoutId", c.G, "n0", "o0", "", "getLogTag", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivCover", "Lcom/tencent/biz/qqcircle/immersive/views/QFSRoundProgressView;", "e", "Lcom/tencent/biz/qqcircle/immersive/views/QFSRoundProgressView;", "progressView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverPublishingItemView extends QFSPersonalCoverBaseItemView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCover;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QFSRoundProgressView progressView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverPublishingItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        p0();
    }

    private final void l0(final QFSPersonalCoverFeedInfo coverFeedInfo) {
        ImageView imageView = this.ivCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        imageView.post(new Runnable() { // from class: k40.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalCoverPublishingItemView.m0(QFSPersonalCoverFeedInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(QFSPersonalCoverFeedInfo coverFeedInfo, QFSPersonalCoverPublishingItemView this$0) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "$coverFeedInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Option obtain = Option.obtain();
        obtain.setUrl(coverFeedInfo.getCoverUrl());
        ImageView imageView = this$0.ivCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        obtain.setTargetView(imageView);
        obtain.setRequestWidth(this$0.getMeasuredWidth());
        obtain.setRequestHeight(this$0.getMeasuredHeight());
        obtain.setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton));
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverPublishingItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull QFSPersonalCoverFeedInfo coverFeedInfo, int pos) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "coverFeedInfo");
        l0(coverFeedInfo);
        o0(coverFeedInfo);
    }

    public final void o0(@NotNull QFSPersonalCoverFeedInfo coverFeedInfo) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "coverFeedInfo");
        QFSRoundProgressView qFSRoundProgressView = this.progressView;
        if (qFSRoundProgressView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            qFSRoundProgressView = null;
        }
        qFSRoundProgressView.setProgress(coverFeedInfo.getProgress());
    }

    public void p0() {
        View findViewById = findViewById(R.id.duw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_cover)");
        this.ivCover = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f496923d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_progress_view)");
        this.progressView = (QFSRoundProgressView) findViewById2;
    }
}

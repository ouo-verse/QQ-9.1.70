package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/polymerization/QCircleHotEventPolymerizationHeadView;", "Lcom/tencent/biz/qqcircle/widgets/polymerization/QCircleBasePolymerizationHeadView;", "", "getLogTag", "", "getLayoutId", "", "data", com.tencent.luggage.wxa.c8.c.G, "", "bindData", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "d", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "hotEventImg", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "rankTv", "f", "titleTv", h.F, "subtitleTv", "i", "desTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QCircleHotEventPolymerizationHeadView extends QCircleBasePolymerizationHeadView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SquareImageView hotEventImg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView rankTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView subtitleTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView desTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleHotEventPolymerizationHeadView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.lew);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.biz.qqcircle.richframework.widget.SquareImageView");
        this.hotEventImg = (SquareImageView) findViewById;
        View findViewById2 = findViewById(R.id.f70453lh);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.rankTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.jq_);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.titleTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f9063530);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.subtitleTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.ug9);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.desTv = (TextView) findViewById5;
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(@Nullable Object data, int pos) {
        if (!(data instanceof HotEventInfo)) {
            return;
        }
        HotEventInfo hotEventInfo = (HotEventInfo) data;
        this.rankTv.setText(getContext().getString(R.string.f183563ji, Integer.valueOf(hotEventInfo.getRank())));
        this.titleTv.setText(hotEventInfo.getTitle());
        this.subtitleTv.setText(hotEventInfo.getSubTitle());
        this.desTv.setText(hotEventInfo.getDescription());
        Option targetView = new Option().setUrl(hotEventInfo.getCoverUrl()).setFailDrawable(getContext().getResources().getDrawable(R.drawable.onn)).setLoadingDrawable(getContext().getResources().getDrawable(R.drawable.onn)).setTargetView(this.hotEventImg);
        QCircleFeedPicLoader.setViewWidthHeight(targetView, this.hotEventImg);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g3r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QCircleHotEventPolymerizationHeadView";
    }
}

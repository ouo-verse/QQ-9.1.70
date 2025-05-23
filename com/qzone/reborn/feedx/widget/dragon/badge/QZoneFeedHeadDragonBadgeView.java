package com.qzone.reborn.feedx.widget.dragon.badge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.reborn.feedx.widget.dragon.badge.QZoneFeedHeadDragonBadgeView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/badge/QZoneFeedHeadDragonBadgeView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "", "n0", "p0", "", "getLayoutId", "objData", c.G, "o0", "Lcom/qzone/reborn/feedx/widget/dragon/badge/QZoneFeedHeadDragonBadgeView$b;", "listener", "setImageLoadedListener", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "imageIcon", "f", "Lcom/qzone/reborn/feedx/widget/dragon/badge/QZoneFeedHeadDragonBadgeView$b;", "imageLoadedListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedHeadDragonBadgeView extends QZoneBaseWidgetView<FeedResourceInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView imageIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b imageLoadedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/feedx/widget/dragon/badge/QZoneFeedHeadDragonBadgeView$b;", "", "", "E", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void E();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedHeadDragonBadgeView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.f162835mw1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_feed_head_badge_icon)");
        this.imageIcon = (ImageView) findViewById;
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    private final void n0() {
        ViewGroup.LayoutParams layoutParams = this.imageIcon.getLayoutParams();
        layoutParams.width = getData().getResWidthFromUrl();
        layoutParams.height = bh.c.INSTANCE.a();
    }

    private final void p0() {
        String sourceMaterialUrl = getData().getSourceMaterialUrl();
        if (TextUtils.isEmpty(sourceMaterialUrl)) {
            QLog.e("QZoneFeedHeadDragonBadgeView", 4, "[loadDragonPic] resInfo is null");
        } else {
            final Option failedDrawableColor = Option.obtain().setUrl(sourceMaterialUrl).setTargetView(this.imageIcon).setLoadingDrawableId(R.drawable.trans).setFailedDrawableColor(R.drawable.trans);
            com.tencent.mobileqq.qzone.picload.c.a().i(failedDrawableColor, new IPicLoadStateListener() { // from class: qh.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    QZoneFeedHeadDragonBadgeView.q0(Option.this, this, loadState, option);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Option option, QZoneFeedHeadDragonBadgeView this$0, LoadState loadState, Option option2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null) {
            QLog.i("QZoneFeedHeadDragonBadgeView", 4, "[loadDragonPic] loadImage success:" + this$0.dataPosInList);
            b bVar = this$0.imageLoadedListener;
            if (bVar != null) {
                bVar.E();
                return;
            }
            return;
        }
        QLog.e("QZoneFeedHeadDragonBadgeView", 1, "[loadDragonPic] loadImage fail:" + loadState);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129676p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedResourceInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        n0();
        p0();
    }

    public final void setImageLoadedListener(b listener) {
        this.imageLoadedListener = listener;
    }
}

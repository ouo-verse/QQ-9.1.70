package com.qzone.reborn.part.publish.mood.imageai.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.reborn.part.publish.mood.imageai.widget.QZonePublishAiTextLoadingView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.extension.a;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/widget/QZonePublishAiTextLoadingView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "getLayoutId", "objData", c.G, "", "bindData", "n0", "p0", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "loadingImage", "Lr01/c;", "f", "Lr01/c;", "loadingLibraAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishAiTextLoadingView extends QZoneBaseWidgetView<Object> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView loadingImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private r01.c loadingLibraAnim;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePublishAiTextLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n9d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_pic_to_text_loading_view)");
        this.loadingImage = (ImageView) findViewById;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(QZonePublishAiTextLoadingView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        }
        if (z16) {
            if ((option != null ? option.getAnimatable() : null) instanceof r01.c) {
                QLog.d("QZonePublishAiTextLoadingView", 1, " anim load success");
                Animatable animatable = option.getAnimatable();
                Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
                r01.c cVar = (r01.c) animatable;
                this$0.loadingLibraAnim = cVar;
                if (cVar != null) {
                    cVar.setLoopCount(10000);
                    cVar.start();
                    return;
                }
                return;
            }
        }
        QLog.e("QZonePublishAiTextLoadingView", 1, "anim load error:" + loadState);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cnp;
    }

    public final void n0() {
        r01.c cVar = this.loadingLibraAnim;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            if (cVar.isRunning()) {
                QLog.e("QZonePublishAiTextLoadingView", 1, "[showLoadingAnim] anim is running");
                return;
            }
        }
        Option option = Option.obtain().setPreferDecoder(a.class).setNeedShowLoadingDrawable(false).setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/publisher/ai_loading.json.zip").setTargetView(this.loadingImage);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: dm.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                QZonePublishAiTextLoadingView.o0(QZonePublishAiTextLoadingView.this, loadState, option2);
            }
        });
    }

    public final void p0() {
        QLog.i("QZonePublishAiTextLoadingView", 1, "stop loading anim");
        r01.c cVar = this.loadingLibraAnim;
        if (cVar != null) {
            cVar.stop();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
    }
}

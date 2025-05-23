package com.tencent.mobileqq.guild.media.qcircle;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001dR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/k;", "Lj30/d;", "", "getLogTag", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", BdhLogUtil.LogTag.Tag_Conn, "a0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lj30/a;", "controller", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "position", "a", "onItemSelected", "e", "onPaused", "c", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b", "Lcom/tencent/mobileqq/guild/media/qcircle/QCircleBaseView;", "Lcom/tencent/mobileqq/guild/media/qcircle/QCircleBaseView;", "baseView", "Lfeedcloud/FeedCloudMeta$StFeed;", "circleData", "I", "lastPosition", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k implements j30.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QCircleBaseView baseView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed circleData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int lastPosition = -1;

    @Override // j30.d
    public void C(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onViewAttachedToWindow");
    }

    @Override // j30.d
    public void a(@NotNull FeedCloudMeta$StFeed data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onBindData position " + position);
        this.circleData = data;
    }

    @Override // j30.d
    public void a0(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onViewDetachedFromWindow");
    }

    @Override // j30.d
    public void b() {
        QCircleBaseView qCircleBaseView = this.baseView;
        if (qCircleBaseView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
            qCircleBaseView = null;
        }
        qCircleBaseView.o();
    }

    @Override // j30.d
    public void c() {
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onResumed");
        QCircleBaseView qCircleBaseView = this.baseView;
        if (qCircleBaseView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
            qCircleBaseView = null;
        }
        qCircleBaseView.q();
    }

    @Override // j30.d
    @NotNull
    public View d(@NotNull View rootView, @NotNull j30.a controller) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(controller, "controller");
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onInitView");
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        QCircleBaseView qCircleBaseView = new QCircleBaseView(context, null, 2, 0 == true ? 1 : 0);
        this.baseView = qCircleBaseView;
        qCircleBaseView.l(controller);
        QCircleBaseView qCircleBaseView2 = this.baseView;
        if (qCircleBaseView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
            return null;
        }
        return qCircleBaseView2;
    }

    @Override // j30.d
    public void e(int position) {
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onItemUnSelected");
        this.lastPosition = -1;
        QCircleBaseView qCircleBaseView = this.baseView;
        if (qCircleBaseView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
            qCircleBaseView = null;
        }
        qCircleBaseView.n();
    }

    @Override // j30.d
    @NotNull
    public String getLogTag() {
        return "QGMC.QCircle.QCircleInjectItemView";
    }

    @Override // j30.d
    public void onDestroy() {
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        QCircleBaseView qCircleBaseView = this.baseView;
        if (qCircleBaseView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
            qCircleBaseView = null;
        }
        qCircleBaseView.m();
    }

    @Override // j30.d
    public void onItemSelected(int position) {
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onItemSelected " + position);
        if (position == this.lastPosition) {
            return;
        }
        this.lastPosition = position;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.circleData;
        if (feedCloudMeta$StFeed != null) {
            QCircleBaseView qCircleBaseView = this.baseView;
            if (qCircleBaseView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseView");
                qCircleBaseView = null;
            }
            qCircleBaseView.g(feedCloudMeta$StFeed, position);
        }
    }

    @Override // j30.d
    public void onPaused() {
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, "onPaused " + this.lastPosition);
        QCircleBaseView qCircleBaseView = this.baseView;
        if (qCircleBaseView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
            qCircleBaseView = null;
        }
        qCircleBaseView.p();
    }

    @Override // j30.d
    public void onStop() {
        QLog.d("QGMC.QCircle.QCircleInjectItemView", 4, DKHippyEvent.EVENT_STOP);
    }
}

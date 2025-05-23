package com.qzone.reborn.feedx.widget.entrance;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "o0", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "m0", "n0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneFeedxBaseEntranceView extends QZoneBaseWidgetView<Object> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxBaseEntranceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void m0() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public final void n0() {
        getRootView().setBackground(new ColorDrawable(getResources().getColor(R.color.qui_common_fill_light_primary)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxBaseEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void o0() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}

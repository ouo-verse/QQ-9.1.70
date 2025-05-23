package com.tencent.mobileqq.statustitle.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/statustitle/widget/MsgRefreshTipMgr;", "", "MsgRefreshTipView", "TimeOutRunnable", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MsgRefreshTipMgr {

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0010\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/statustitle/widget/MsgRefreshTipMgr$MsgRefreshTipView;", "Landroid/widget/FrameLayout;", "", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "leftTv", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "loadingIv", "f", "rightTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class MsgRefreshTipView extends FrameLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private TextView leftTv;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ImageView loadingIv;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private TextView rightTv;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MsgRefreshTipView(Context context) {
            this(context, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.leftTv = (TextView) findViewById(R.id.f72193q7);
            this.loadingIv = (ImageView) findViewById(R.id.f72203q8);
            this.rightTv = (TextView) findViewById(R.id.f72213q9);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MsgRefreshTipView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MsgRefreshTipView(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            LayoutInflater.from(context).inflate(R.layout.e4n, this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/statustitle/widget/MsgRefreshTipMgr$TimeOutRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", "state", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class TimeOutRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int state;
        final /* synthetic */ MsgRefreshTipMgr this$0;

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (this.state == 2) {
                str = "0X800C0B2";
            } else {
                str = "0X800C0B3";
            }
            String str2 = str;
            ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            throw null;
        }
    }
}

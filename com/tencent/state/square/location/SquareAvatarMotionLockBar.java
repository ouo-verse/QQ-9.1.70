package com.tencent.state.square.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.Square;
import com.tencent.state.square.databinding.VasSquareAvatarMontionLockBinding;
import com.tencent.state.status.PanelStatusTaskInfo;
import com.tencent.state.status.PanelTaskBannerLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/location/SquareAvatarMotionLockBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarMontionLockBinding;", "motionLockListener", "Lcom/tencent/state/square/location/IMotionLockListener;", "taskInfo", "Lcom/tencent/state/status/PanelStatusTaskInfo;", "fillBanner", "", "info", "getUnLockView", "Landroid/view/View;", "setMotionListener", "listener", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarMotionLockBar extends LinearLayout {
    private static final String TAG = "SquareAvatarMotionLockBar";
    private final VasSquareAvatarMontionLockBinding binding;
    private IMotionLockListener motionLockListener;
    private PanelStatusTaskInfo taskInfo;

    public SquareAvatarMotionLockBar(Context context) {
        this(context, null, 0, 6, null);
    }

    public final void fillBanner(PanelStatusTaskInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.taskInfo = info;
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(info.getBannerInfo().getTitle());
        TextView textView2 = this.binding.titleDesc;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleDesc");
        textView2.setText(info.getBannerInfo().getDesc());
        Button button = this.binding.enterUnlockMap;
        Intrinsics.checkNotNullExpressionValue(button, "binding.enterUnlockMap");
        button.setText(info.getBannerInfo().getBtnName());
    }

    public final View getUnLockView() {
        Button button = this.binding.enterUnlockMap;
        Intrinsics.checkNotNullExpressionValue(button, "binding.enterUnlockMap");
        return button;
    }

    public final void setMotionListener(IMotionLockListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.motionLockListener = listener;
    }

    public SquareAvatarMotionLockBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SquareAvatarMotionLockBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarMotionLockBar(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareAvatarMontionLockBinding inflate = VasSquareAvatarMontionLockBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarMontionLo\u2026ater.from(context), this)");
        this.binding = inflate;
        inflate.enterUnlockMap.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.location.SquareAvatarMotionLockBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PanelStatusTaskInfo panelStatusTaskInfo = SquareAvatarMotionLockBar.this.taskInfo;
                if (panelStatusTaskInfo != null) {
                    Square.INSTANCE.getConfig().getRouter().routeLink(context, new EntranceLink(panelStatusTaskInfo.getBannerInfo().getLinkUrl(), panelStatusTaskInfo.getBannerInfo().getLinkType() == PanelTaskBannerLinkType.LINK_TYPE_H5 ? 1 : 2));
                    if (panelStatusTaskInfo.shouldFinishByServer()) {
                        return;
                    }
                    new MotionObserver().requestMotionUnlock(panelStatusTaskInfo.getStatus(), panelStatusTaskInfo.getRichStatus(), new IMotionObserver() { // from class: com.tencent.state.square.location.SquareAvatarMotionLockBar.1.1
                        @Override // com.tencent.state.square.location.IMotionObserver
                        public void notification(PanelStatusTaskInfo taskInfo, boolean success) {
                            IMotionLockListener iMotionLockListener;
                            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                            if (!success || (iMotionLockListener = SquareAvatarMotionLockBar.this.motionLockListener) == null) {
                                return;
                            }
                            iMotionLockListener.onFetchAvatarMotion(taskInfo);
                        }
                    });
                }
            }
        });
    }
}

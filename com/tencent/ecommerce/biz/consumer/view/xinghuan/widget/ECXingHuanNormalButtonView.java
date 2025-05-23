package com.tencent.ecommerce.biz.consumer.view.xinghuan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener;
import com.tencent.ecommerce.repo.consumer.resp.ButtonInfo;
import com.tencent.ecommerce.repo.consumer.resp.JumpInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ph0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b)\u0010*B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b)\u0010-B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b)\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00063"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/widget/ECXingHuanNormalButtonView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "Landroid/content/Context;", "context", "", "e", "Lcom/tencent/ecommerce/repo/consumer/resp/ButtonInfo;", "buttonInfo", "setButtonInfo", "Landroid/view/View;", "getView", "Lph0/a;", "data", "setData", "Lph0/b;", SensorJsPlugin.SENSOR_INTERVAL_UI, "setUi", "update", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "listener", "addEventListener", "removeEventListener", "Landroid/view/ViewGroup;", "getBgView", "Landroid/widget/TextView;", "getTipsView", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "rlBg", "Landroid/widget/TextView;", "tvTips", "", "f", "J", "lastClickTime", h.F, "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "i", "Lcom/tencent/ecommerce/repo/consumer/resp/ButtonInfo;", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanNormalButtonView extends FrameLayout implements IECXingHuanGameButton {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rlBg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IGameEventListener listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ButtonInfo buttonInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList<JumpInfo> jumpInfoArray;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (Math.abs(System.currentTimeMillis() - ECXingHuanNormalButtonView.this.lastClickTime) >= 300) {
                ECXingHuanNormalButtonView.this.lastClickTime = System.currentTimeMillis();
                IGameEventListener iGameEventListener = ECXingHuanNormalButtonView.this.listener;
                if (iGameEventListener != null) {
                    ButtonInfo buttonInfo = ECXingHuanNormalButtonView.this.buttonInfo;
                    iGameEventListener.onClickButton(view, (buttonInfo == null || (jumpInfoArray = buttonInfo.getJumpInfoArray()) == null) ? null : ECGoodsCommonUtils.f101579a.o(jumpInfoArray));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECXingHuanNormalButtonView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void addEventListener(IGameEventListener listener) {
        this.listener = listener;
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public ViewGroup getBgView() {
        RelativeLayout relativeLayout = this.rlBg;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlBg");
        }
        return relativeLayout;
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public TextView getTipsView() {
        TextView textView = this.tvTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
        }
        return textView;
    }

    public final void setButtonInfo(ButtonInfo buttonInfo) {
        this.buttonInfo = buttonInfo;
        TextView textView = this.tvTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
        }
        textView.setText(buttonInfo.getButtonText());
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void setUi(ph0.b ui5) {
        RelativeLayout relativeLayout = this.rlBg;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlBg");
        }
        relativeLayout.setBackgroundDrawable(ui5.getEnableBgDrawable());
        TextView textView = this.tvTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
        }
        textView.setTextColor(ui5.getEnableTextColor());
        textView.setTextSize(0, ui5.getTextSize());
    }

    public ECXingHuanNormalButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void removeEventListener(IGameEventListener listener) {
        this.listener = null;
    }

    public ECXingHuanNormalButtonView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        e(context);
    }

    private final void e(Context context) {
        View.inflate(context, R.layout.cv_, this);
        this.rlBg = (RelativeLayout) findViewById(R.id.o99);
        this.tvTips = (TextView) findViewById(R.id.oeq);
        setOnClickListener(new b());
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public View getView() {
        return this;
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void update() {
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void setData(a data) {
    }
}

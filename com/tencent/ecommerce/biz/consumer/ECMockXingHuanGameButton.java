package com.tencent.ecommerce.biz.consumer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ph0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0000H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECMockXingHuanGameButton;", "Landroid/view/View;", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "a", "Lph0/a;", "data", "", "setData", "Lph0/b;", SensorJsPlugin.SENSOR_INTERVAL_UI, "setUi", "update", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "listener", "addEventListener", "removeEventListener", "Landroid/view/ViewGroup;", "getBgView", "Landroid/widget/TextView;", "getTipsView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ECMockXingHuanGameButton extends View implements IECXingHuanGameButton {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGameEventListener f101589e;

        a(IGameEventListener iGameEventListener) {
            this.f101589e = iGameEventListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IGameEventListener.a.a(this.f101589e, ECMockXingHuanGameButton.this, null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECMockXingHuanGameButton(@NotNull Context context) {
        super(context);
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void addEventListener(@NotNull IGameEventListener listener) {
        setOnClickListener(new a(listener));
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    @Nullable
    public ViewGroup getBgView() {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    @Nullable
    public TextView getTipsView() {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void setUi(@NotNull b ui5) {
        Drawable enableBgDrawable = ui5.getEnableBgDrawable();
        if (enableBgDrawable != null) {
            setBackground(enableBgDrawable);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ECMockXingHuanGameButton getView() {
        return this;
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void update() {
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void removeEventListener(@NotNull IGameEventListener listener) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
    public void setData(@NotNull ph0.a data) {
    }
}

package com.tencent.ecommerce.biz.consumer.xinghuan;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ph0.a;
import ph0.b;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "", "Landroid/view/View;", "getView", "Lph0/a;", "data", "", "setData", "Lph0/b;", SensorJsPlugin.SENSOR_INTERVAL_UI, "setUi", "update", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "listener", "addEventListener", "removeEventListener", "Landroid/view/ViewGroup;", "getBgView", "Landroid/widget/TextView;", "getTipsView", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECXingHuanGameButton {
    void addEventListener(@NotNull IGameEventListener listener);

    @Nullable
    ViewGroup getBgView();

    @Nullable
    TextView getTipsView();

    @NotNull
    View getView();

    void removeEventListener(@NotNull IGameEventListener listener);

    void setData(@NotNull a data);

    void setUi(@NotNull b ui5);

    void update();
}

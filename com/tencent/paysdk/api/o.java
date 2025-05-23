package com.tencent.paysdk.api;

import android.view.View;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J,\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tH&J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\u0004H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/paysdk/api/o;", "", "Lmq3/c;", "jsbridgeHandler", "", "setJsbridgeHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "url", "", "additionalHttpHeaders", DKWebViewController.DKHippyWebviewFunction.LOAD_URL, "exeJs", "Lcom/tencent/paysdk/api/o$a;", "callback", "l", "setBgTransparent", "videoAuthUA", "b", "Landroid/view/View;", "k", QCircleLpReportDc05507.KEY_CLEAR, "a", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public interface o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/paysdk/api/o$a;", "", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public interface a {
    }

    void b(@NotNull String videoAuthUA);

    void clear();

    @NotNull
    View k();

    void l(@Nullable String exeJs, @Nullable a callback);

    void loadUrl(@Nullable String url, @Nullable Map<String, String> additionalHttpHeaders);

    @Nullable
    mq3.c m();

    void setBgTransparent();

    void setJsbridgeHandler(@Nullable mq3.c jsbridgeHandler);
}

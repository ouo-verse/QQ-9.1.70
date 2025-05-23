package kv3;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&\u00a8\u0006\u0012"}, d2 = {"Lkv3/a;", "", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "onMsgReceive", "", "isScreenOn", "onScreenStateChange", "onProcessForeground", "onProcessBackground", "onNetworkConnected", "onGetOfflineMessageFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {
    void onCreate(@NotNull AppRuntime appRuntime);

    void onDestroy();

    void onGetOfflineMessageFinish();

    void onMsgReceive(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList);

    void onNetworkConnected();

    void onProcessBackground();

    void onProcessForeground();

    void onScreenStateChange(boolean isScreenOn);
}

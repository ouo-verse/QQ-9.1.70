package com.tencent.qqnt.aio.predownload.api;

import com.tencent.aio.data.msglist.a;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {"all"})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/api/IAIOPreDownloadService;", "Lmqq/app/api/IRuntimeService;", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onMsgReceive", "", "isScreenOn", "onScreenStateChange", "onProcessForeground", "onProcessBackground", "onNetworkConnected", "onGetOfflineMessageFinish", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface IAIOPreDownloadService extends IRuntimeService {
    void onGetOfflineMessageFinish();

    void onMsgReceive(@NotNull List<? extends a> msgList);

    void onNetworkConnected();

    void onProcessBackground();

    void onProcessForeground();

    void onScreenStateChange(boolean isScreenOn);
}

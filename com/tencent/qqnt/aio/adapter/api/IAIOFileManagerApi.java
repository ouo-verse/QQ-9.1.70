package com.tencent.qqnt.aio.adapter.api;

import android.app.Activity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import cooperation.qzone.panorama.util.PanoramaConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&J.\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH&J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH&J\"\u0010\u001d\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H&J(\u0010\u001f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOFileManagerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "cancelDownloadFile", "", "aioMsgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "cancelSendFile", "downloadFile", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "updateUI", "Lkotlin/Function0;", "fixFileThumbSize", "Lkotlin/Pair;", "", "fileElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElemId", "", "fixFileThumbSizeFromFile", "path", "", "getPicFileDefaultSize", "getTroopFilePathFromTransMgrByFileId", "app", "Lmqq/app/AppRuntime;", "troopUin", "fileUuid", "getVideoFileDefaultSize", "openTroopFileBrowser", PanoramaConfig.KEY_CURRENT_UIN, "reSendFile", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOFileManagerApi extends QRouteApi {
    void cancelDownloadFile(@NotNull AIOMsgItem aioMsgItem);

    void cancelSendFile(@NotNull AIOMsgItem aioMsgItem);

    void downloadFile(@Nullable Activity activity, @NotNull AIOMsgItem aioMsgItem, @NotNull Function0<Unit> updateUI);

    @Nullable
    Pair<Integer, Integer> fixFileThumbSize(@NotNull AIOMsgItem aioMsgItem, @NotNull FileElement fileElement, long fileElemId);

    @Nullable
    Pair<Integer, Integer> fixFileThumbSizeFromFile(@NotNull String path);

    @NotNull
    Pair<Integer, Integer> getPicFileDefaultSize();

    @Nullable
    String getTroopFilePathFromTransMgrByFileId(@NotNull AppRuntime app, @NotNull String troopUin, @NotNull String fileUuid);

    @NotNull
    Pair<Integer, Integer> getVideoFileDefaultSize();

    void openTroopFileBrowser(@Nullable Activity activity, @NotNull String troopUin, @NotNull String currentUin);

    void reSendFile(@Nullable Activity activity, @NotNull AIOMsgItem aioMsgItem, @NotNull Function0<Unit> updateUI);
}

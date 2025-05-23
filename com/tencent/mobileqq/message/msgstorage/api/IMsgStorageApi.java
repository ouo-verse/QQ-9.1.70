package com.tencent.mobileqq.message.msgstorage.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u001e\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H&J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/message/msgstorage/api/IMsgStorageApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addFilePath", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "path", "", "onClearAllMsg", "uin", "onClearHistory", "friendUin", "uinType", "", "onFileDownload", "onFileManagerEntityUpdate", "app", "Lmqq/app/AppRuntime;", "entity", "Lcom/tencent/mobileqq/persistence/Entity;", "onMsgAdd", "messages", "", "onMsgDeleted", "onMsgUploadTaskEnd", "onMultiMsgAdd", "onTroopFileDownloaded", "uuid", "msgstorage-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMsgStorageApi extends QRouteApi {
    void addFilePath(@NotNull MessageRecord mr5, @NotNull String path);

    void onClearAllMsg(@NotNull String uin);

    void onClearHistory(@NotNull String friendUin, int uinType);

    void onFileDownload(@Nullable String path, @Nullable MessageRecord mr5);

    void onFileManagerEntityUpdate(@NotNull AppRuntime app, @NotNull Entity entity);

    void onMsgAdd(@NotNull List<? extends MessageRecord> messages);

    void onMsgDeleted(@NotNull List<? extends MessageRecord> mr5);

    void onMsgUploadTaskEnd(@Nullable MessageRecord mr5);

    void onMultiMsgAdd(@NotNull List<? extends MessageRecord> messages);

    void onTroopFileDownloaded(@NotNull String uuid, @NotNull String path);
}

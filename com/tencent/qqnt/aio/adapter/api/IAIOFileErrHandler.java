package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOFileErrHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onFileErr", "", "info", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "isDownload", "registerFileIdListen", "msgId", "", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "unRegisterFileIdListen", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOFileErrHandler extends QRouteApi {
    boolean onFileErr(@NotNull FileTransNotifyInfo info, boolean isDownload);

    boolean registerFileIdListen(long msgId, @NotNull Contact contact);

    boolean unRegisterFileIdListen(long msgId);
}

package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOFileTransfer;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "sendLocalFile", "", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "path", "", "listener", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOFileTransfer extends QRouteApi {
    void sendLocalFile(@NotNull Contact contact, @NotNull String path, @Nullable IOperateCallback listener);
}

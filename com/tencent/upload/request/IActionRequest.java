package com.tencent.upload.request;

import com.tencent.upload.network.session.IUploadSession;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IActionRequest {
    byte[] encode() throws IOException;

    long endRecord();

    int getCmdId();

    IUploadSession.RequestListener getListener();

    int getRequestId();

    Object getTag();

    int getTaskId();

    boolean needTimeout();

    void setListener(IUploadSession.RequestListener requestListener);

    void setTag(Object obj);

    void setTaskId(int i3);

    void startRecord();
}

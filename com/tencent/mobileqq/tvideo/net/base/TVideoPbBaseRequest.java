package com.tencent.mobileqq.tvideo.net.base;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030\u0002*\u0012\b\u0001\u0010\u0003*\f\u0012\u0004\u0012\u0002H\u0003\u0012\u0002\b\u00030\u00022\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0002\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\tH\u0014J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/base/TVideoPbBaseRequest;", "Request", "Lcom/squareup/wire/Message;", "Response", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "()V", "decode", "T", "buffer", "", "([B)Ljava/lang/Object;", "getRequest", "()Lcom/squareup/wire/Message;", "getRequestByteData", "getResponseAdapter", "Lcom/squareup/wire/ProtoAdapter;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class TVideoPbBaseRequest<Request extends Message<Request, ?>, Response extends Message<Response, ?>> extends TVideoBaseRequest {
    public TVideoPbBaseRequest() {
        super(null, 1, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] buffer) {
        boolean z16;
        if (buffer != null) {
            if (buffer.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    return getResponseAdapter().decode(buffer);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public abstract Request getRequest();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        return getRequest().encode();
    }

    @NotNull
    public abstract ProtoAdapter<Response> getResponseAdapter();
}

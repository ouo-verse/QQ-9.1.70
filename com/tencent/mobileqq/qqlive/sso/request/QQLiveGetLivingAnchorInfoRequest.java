package com.tencent.mobileqq.qqlive.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.ilive.pb.LiveRoomList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveGetLivingAnchorInfoRequest;", "T", "Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveBaseRequest;", "roomIdList", "", "", "(Ljava/util/List;)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getRequestByteData", "getSubCmd", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveGetLivingAnchorInfoRequest<T> extends QQLiveBaseRequest<T> {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<Long> roomIdList;

    public QQLiveGetLivingAnchorInfoRequest(@NotNull List<Long> roomIdList) {
        Intrinsics.checkNotNullParameter(roomIdList, "roomIdList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomIdList);
        } else {
            this.roomIdList = roomIdList;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.ilive.pb.LiveRoomList$GetLivingAnchorInfoRsp, com.tencent.mobileqq.pb.MessageMicro, T] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) convertInputStreamtoByteArray);
        }
        try {
            ?? r06 = (T) new LiveRoomList.GetLivingAnchorInfoRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveGetLivingAnchorInfoRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "trpc.qlive.trpc_switch_room_list.trpc_switch_room_list";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageNano) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        throw new RuntimeException("this request cannot use this method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public byte[] getRequestByteData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LiveRoomList.GetLivingAnchorInfoReq getLivingAnchorInfoReq = new LiveRoomList.GetLivingAnchorInfoReq();
        getLivingAnchorInfoReq.room_id.set(this.roomIdList);
        byte[] byteArray = getLivingAnchorInfoReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "GetLivingAnchorInfo";
    }
}

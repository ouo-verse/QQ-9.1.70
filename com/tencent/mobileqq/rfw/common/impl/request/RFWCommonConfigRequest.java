package com.tencent.mobileqq.rfw.common.impl.request;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudUsersettings$Entry;
import feedcloud.FeedCloudUsersettings$GetUsersettingsReq;
import feedcloud.FeedCloudUsersettings$GetUsersettingsRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/rfw/common/impl/request/RFWCommonConfigRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "appID", "", "visitScene", "(II)V", "mReq", "Lfeedcloud/FeedCloudUsersettings$GetUsersettingsReq;", "decode", "T", WebViewPlugin.KEY_RESPONSE, "", "([B)Ljava/lang/Object;", "getCmdName", "", "getFinalRequestData", "requestByte", "getRequestByteData", "parseResponseHeadInfo", "", "", "bytes", "([B)[Ljava/lang/Object;", "setAttachInfo", "", "attachInfo", "", "Lfeedcloud/FeedCloudUsersettings$Entry;", "rfw-common-config-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class RFWCommonConfigRequest extends VSBaseRequest {
    static IPatchRedirector $redirector_;

    @NotNull
    private final FeedCloudUsersettings$GetUsersettingsReq mReq;

    public RFWCommonConfigRequest(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        FeedCloudUsersettings$GetUsersettingsReq feedCloudUsersettings$GetUsersettingsReq = new FeedCloudUsersettings$GetUsersettingsReq();
        this.mReq = feedCloudUsersettings$GetUsersettingsReq;
        feedCloudUsersettings$GetUsersettingsReq.qua.set(QUA.getQUA3());
        feedCloudUsersettings$GetUsersettingsReq.appID.set(i3);
        feedCloudUsersettings$GetUsersettingsReq.visitScene.set(i16);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudUsersettings$GetUsersettingsRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] responseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) responseData);
        }
        ?? r06 = (T) new FeedCloudUsersettings$GetUsersettingsRsp();
        try {
            r06.mergeFrom(responseData);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "trpc.feedcloud.usersettings.Usersettings.SsoGetUsersettings";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getFinalRequestData(@Nullable byte[] requestByte) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) requestByte);
        }
        if (requestByte == null) {
            return new byte[0];
        }
        return requestByte;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        PBStringField pBStringField = this.mReq.traceid;
        String str = this.mTraceId;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public Object[] parseResponseHeadInfo(@Nullable byte[] bytes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Object[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bytes);
        }
        byte[] a16 = fh.a(bytes);
        Intrinsics.checkNotNullExpressionValue(a16, "getWupBuff(bytes)");
        return new Object[]{0L, "", a16};
    }

    public final void setAttachInfo(@NotNull List<FeedCloudUsersettings$Entry> attachInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) attachInfo);
        } else {
            Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
            this.mReq.attachInfos.set(attachInfo);
        }
    }

    public /* synthetic */ RFWCommonConfigRequest(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 1 : i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}

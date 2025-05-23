package com.tencent.mobileqq.flock.publish.request;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import a55.e;
import a55.f;
import com.google.protobuf.nano.MessageNano;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.b;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J!\u0010\f\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/request/FlockModifyFeedRequest;", "T", "Lcom/tencent/mobileqq/flock/base/FlockBaseRequest;", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "getCmdName", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "requestBizData", "", "getRequestWrapper", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "Ly45/b;", "feed", "Ly45/b;", "getFeed", "()Ly45/b;", "La55/e;", Const.BUNDLE_KEY_REQUEST, "La55/e;", "getRequest", "()La55/e;", "<init>", "(Ly45/b;)V", "Companion", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockModifyFeedRequest<T> extends FlockBaseRequest<T> {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CMD = "QEvent.trpc.qevent.commwriter.ComWriter.ModifyFeed";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private final b feed;

    @NotNull
    private final e request;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/request/FlockModifyFeedRequest$a;", "", "", CheckForwardServlet.KEY_CMD, "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.request.FlockModifyFeedRequest$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48397);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockModifyFeedRequest(@NotNull b feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) feed);
            return;
        }
        this.feed = feed;
        e eVar = new e();
        this.request = eVar;
        eVar.f25558a = feed;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] responseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this, (Object) responseData);
        }
        try {
            return (T) f.c(responseData);
        } catch (Exception e16) {
            QLog.e(FlockBaseRequest.TAG, 1, "exception:", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return CMD;
    }

    @NotNull
    public final b getFeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.feed;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageNano) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.request;
    }

    @NotNull
    public final e getRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.request;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.flock.base.FlockBaseRequest, com.tencent.biz.richframework.network.request.VSBaseRequest
    @Nullable
    public byte[] getRequestWrapper(@Nullable ByteStringMicro requestBizData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) requestBizData);
        }
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(requestBizData));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(FlockBaseRequest.TAG, 1, "getRequestWrapper... exception:", e16);
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("p_skey");
        entry.value.set(getPsKey());
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("domain_id");
        entry2.value.set(PersonalityConfig.SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_CLICK);
        stQWebReq.Extinfo.add(entry2);
        return stQWebReq.toByteArray();
    }
}

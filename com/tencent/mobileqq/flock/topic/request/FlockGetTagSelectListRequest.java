package com.tencent.mobileqq.flock.topic.request;

import b55.c;
import b55.d;
import com.google.protobuf.nano.MessageNano;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0018B\u001b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J!\u0010\t\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nR#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/request/FlockGetTagSelectListRequest;", "T", "Lcom/tencent/mobileqq/flock/base/FlockBaseRequest;", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "getCmdName", "", WebViewPlugin.KEY_RESPONSE, "decode", "([B)Ljava/lang/Object;", "", "attachInfo", "Ljava/util/Map;", "getAttachInfo", "()Ljava/util/Map;", "Lb55/c;", Const.BUNDLE_KEY_REQUEST, "Lb55/c;", "getRequest", "()Lb55/c;", "<init>", "(Ljava/util/Map;)V", "Companion", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockGetTagSelectListRequest<T> extends FlockBaseRequest<T> {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CMD = "QEvent.trpc.qevent.tag.Tag.GetTagSelectList";
    public static final int COUNT = 10;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private final Map<String, String> attachInfo;

    @NotNull
    private final c request;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/request/FlockGetTagSelectListRequest$a;", "", "", CheckForwardServlet.KEY_CMD, "Ljava/lang/String;", "", "COUNT", "I", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.topic.request.FlockGetTagSelectListRequest$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockGetTagSelectListRequest(@NotNull Map<String, String> attachInfo) {
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) attachInfo);
            return;
        }
        this.attachInfo = attachInfo;
        c cVar = new c();
        this.request = cVar;
        cVar.f27965a = 10;
        cVar.f27966b = attachInfo;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] responseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) responseData);
        }
        try {
            return (T) d.c(responseData);
        } catch (Exception e16) {
            QLog.e(FlockBaseRequest.TAG, 1, "exception:", e16);
            return null;
        }
    }

    @NotNull
    public final Map<String, String> getAttachInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.attachInfo;
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
    public final c getRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.request;
    }
}

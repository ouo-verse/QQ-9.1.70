package com.tencent.mobileqq.topicaggregation.request;

import b55.a;
import b55.b;
import com.google.protobuf.nano.MessageNano;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/request/FlockTopicFeedListRequest;", "Lcom/tencent/mobileqq/flock/base/FlockBaseRequest;", "Lb55/b;", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "getCmdName", "T", "", "bytes", "decode", "([B)Ljava/lang/Object;", "", "tagId", "I", "getTagId", "()I", "count", "getCount", "", "attachInfo", "Ljava/util/Map;", "getAttachInfo", "()Ljava/util/Map;", "Lb55/a;", Const.BUNDLE_KEY_REQUEST, "Lb55/a;", "<init>", "(IILjava/util/Map;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FlockTopicFeedListRequest extends FlockBaseRequest<b> {
    static IPatchRedirector $redirector_;

    @Nullable
    private final Map<String, String> attachInfo;
    private final int count;

    @NotNull
    private final a request;
    private final int tagId;

    public /* synthetic */ FlockTopicFeedListRequest(int i3, int i16, Map map, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 6 : i16, (i17 & 4) != 0 ? null : map);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), map, Integer.valueOf(i17), defaultConstructorMarker);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] bytes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bytes);
        }
        try {
            return (T) b.c(bytes);
        } catch (Exception e16) {
            QLog.e(FlockBaseRequest.TAG, 1, "exception:", e16);
            return null;
        }
    }

    @Nullable
    public final Map<String, String> getAttachInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.attachInfo;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "QEvent.trpc.qevent.tag.Tag.GetTagFeedList";
    }

    public final int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.count;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MessageNano) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.request;
    }

    public final int getTagId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.tagId;
    }

    public FlockTopicFeedListRequest(int i3, int i16, @Nullable Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), map);
            return;
        }
        this.tagId = i3;
        this.count = i16;
        this.attachInfo = map;
        a aVar = new a();
        aVar.f27958a = i3;
        aVar.f27959b = i16;
        aVar.f27960c = map;
        this.request = aVar;
    }
}

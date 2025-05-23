package com.tencent.mobileqq.aio.msg.service;

import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\t\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R6\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/u;", "Lcom/tencent/aio/msgservice/i;", "Lcom/tencent/aio/data/AIOSession;", "a", "Lcom/tencent/aio/data/AIOSession;", "()Lcom/tencent/aio/data/AIOSession;", "aioSession", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MultiMsgInfo;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "multiMsgInfos", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "c", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "dstContact", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "setCommentElements", "(Ljava/util/ArrayList;)V", "commentElements", "<init>", "(Lcom/tencent/aio/data/AIOSession;Ljava/util/ArrayList;Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Ljava/util/ArrayList;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class u extends com.tencent.aio.msgservice.i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOSession aioSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MultiMsgInfo> multiMsgInfos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Contact dstContact;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<MsgElement> commentElements;

    public u(@NotNull AIOSession aioSession, @NotNull ArrayList<MultiMsgInfo> multiMsgInfos, @NotNull Contact dstContact, @Nullable ArrayList<MsgElement> arrayList) {
        Intrinsics.checkNotNullParameter(aioSession, "aioSession");
        Intrinsics.checkNotNullParameter(multiMsgInfos, "multiMsgInfos");
        Intrinsics.checkNotNullParameter(dstContact, "dstContact");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aioSession, multiMsgInfos, dstContact, arrayList);
            return;
        }
        this.aioSession = aioSession;
        this.multiMsgInfos = multiMsgInfos;
        this.dstContact = dstContact;
        this.commentElements = arrayList;
    }

    @NotNull
    public final AIOSession a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOSession) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioSession;
    }

    @Nullable
    public final ArrayList<MsgElement> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.commentElements;
    }

    @NotNull
    public final Contact c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Contact) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dstContact;
    }

    @NotNull
    public final ArrayList<MultiMsgInfo> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.multiMsgInfos;
    }
}

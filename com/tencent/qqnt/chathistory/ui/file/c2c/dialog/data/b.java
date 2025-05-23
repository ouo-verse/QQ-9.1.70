package com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0003\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "searchMsgItem", "", "Ljava/lang/String;", "getPeerId", "()Ljava/lang/String;", "peerId", "", "c", "I", "getChatType", "()I", "chatType", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "e", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "fileModel", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;Ljava/lang/String;ILkotlinx/coroutines/CoroutineScope;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchMsgItem searchMsgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileItemModel fileModel;

    public b(@NotNull SearchMsgItem searchMsgItem, @NotNull String peerId, int i3, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(searchMsgItem, "searchMsgItem");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, searchMsgItem, peerId, Integer.valueOf(i3), scope);
            return;
        }
        this.searchMsgItem = searchMsgItem;
        this.peerId = peerId;
        this.chatType = i3;
        this.scope = scope;
        MsgRecord msgRecord = searchMsgItem.msgRecord;
        Intrinsics.checkNotNullExpressionValue(msgRecord, "searchMsgItem.msgRecord");
        this.fileModel = new FileItemModel(msgRecord, peerId, i3, scope);
    }

    @NotNull
    public final FileItemModel a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FileItemModel) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.fileModel;
    }

    @NotNull
    public final SearchMsgItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SearchMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.searchMsgItem;
    }
}

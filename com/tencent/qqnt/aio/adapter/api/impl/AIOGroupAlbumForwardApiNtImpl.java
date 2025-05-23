package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOGroupAlbumForwardApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOGroupAlbumForwardApi;", "()V", "chatHistorySave2GroupAlbum", "", "context", "Landroid/content/Context;", "msgRecordList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "forwardGroupAlbum", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "needShowAIOMenuGroupAlbumEntry", "", "peerUid", "", "needShowChatHistoryGroupAlbumEntry", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOGroupAlbumForwardApiNtImpl implements IAIOGroupAlbumForwardApi {
    static IPatchRedirector $redirector_;

    public AIOGroupAlbumForwardApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chatHistorySave2GroupAlbum$lambda$1(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "chatHistory forward to GroupAlbum is not Supported", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forwardGroupAlbum$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "Forward to GroupAlbum is not Supported", 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public void chatHistorySave2GroupAlbum(@NotNull final Context context, @NotNull List<MsgRecord> msgRecordList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msgRecordList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                AIOGroupAlbumForwardApiNtImpl.chatHistorySave2GroupAlbum$lambda$1(context);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public void forwardGroupAlbum(@NotNull final Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                AIOGroupAlbumForwardApiNtImpl.forwardGroupAlbum$lambda$0(context);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public boolean needShowAIOMenuGroupAlbumEntry(@NotNull String peerUid, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) peerUid, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public boolean needShowChatHistoryGroupAlbumEntry(@NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) peerUid)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return true;
    }
}

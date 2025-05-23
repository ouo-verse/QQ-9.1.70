package com.tencent.mobileqq.message.msgstorage.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/message/msgstorage/api/impl/MsgStorageApiImpl;", "Lcom/tencent/mobileqq/message/msgstorage/api/IMsgStorageApi;", "()V", "addFilePath", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "path", "", "onClearAllMsg", "uin", "onClearHistory", "friendUin", "uinType", "", "onFileDownload", "onFileManagerEntityUpdate", "app", "Lmqq/app/AppRuntime;", "entity", "Lcom/tencent/mobileqq/persistence/Entity;", "onMsgAdd", "messages", "", "onMsgDeleted", "onMsgUploadTaskEnd", "onMultiMsgAdd", "onTroopFileDownloaded", "uuid", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MsgStorageApiImpl implements IMsgStorageApi {
    static IPatchRedirector $redirector_;

    public MsgStorageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void addFilePath(@NotNull MessageRecord mr5, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) mr5, (Object) path);
        } else {
            Intrinsics.checkNotNullParameter(mr5, "mr");
            Intrinsics.checkNotNullParameter(path, "path");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onClearAllMsg(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) uin);
        } else {
            Intrinsics.checkNotNullParameter(uin, "uin");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onClearHistory(@NotNull String friendUin, int uinType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) friendUin, uinType);
        } else {
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onFileDownload(@Nullable String path, @Nullable MessageRecord mr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) path, (Object) mr5);
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onFileManagerEntityUpdate(@NotNull AppRuntime app, @NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) app, (Object) entity);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onMsgAdd(@NotNull List<? extends MessageRecord> messages) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messages);
        } else {
            Intrinsics.checkNotNullParameter(messages, "messages");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onMsgDeleted(@NotNull List<? extends MessageRecord> messages) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) messages);
        } else {
            Intrinsics.checkNotNullParameter(messages, "messages");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onMsgUploadTaskEnd(@Nullable MessageRecord mr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mr5);
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onMultiMsgAdd(@NotNull List<? extends MessageRecord> messages) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messages);
        } else {
            Intrinsics.checkNotNullParameter(messages, "messages");
        }
    }

    @Override // com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi
    public void onTroopFileDownloaded(@NotNull String uuid, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uuid, (Object) path);
        } else {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(path, "path");
        }
    }
}

package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopPbFieldApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J:\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopPbFieldApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopPbFieldApi;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "rptPbValue", "", "writePBRepeatMessageToByteArray", "bytes", "Ljava/lang/Class;", "infoClass", "readPBRepeatMessageFromByteArray", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopPbFieldApiImpl implements ITroopPbFieldApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "TroopPbFieldApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopPbFieldApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.impl.TroopPbFieldApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopPbFieldApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopPbFieldApi
    @Nullable
    public <T extends MessageMicro<T>> PBRepeatMessageField<T> readPBRepeatMessageFromByteArray(@Nullable byte[] bytes, @Nullable Class<T> infoClass) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PBRepeatMessageField) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bytes, (Object) infoClass);
        }
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        CodedInputStreamMicro newInstance = CodedInputStreamMicro.newInstance(bytes);
        PBRepeatMessageField<T> initRepeatMessage = PBField.initRepeatMessage(infoClass);
        while (!newInstance.isAtEnd()) {
            try {
                newInstance.readTag();
                if (initRepeatMessage != null) {
                    initRepeatMessage.readFrom(newInstance);
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return initRepeatMessage;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopPbFieldApi
    @Nullable
    public <T extends MessageMicro<T>> byte[] writePBRepeatMessageToByteArray(@NotNull PBRepeatMessageField<T> rptPbValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rptPbValue);
        }
        Intrinsics.checkNotNullParameter(rptPbValue, "rptPbValue");
        return es2.a.c(rptPbValue);
    }
}

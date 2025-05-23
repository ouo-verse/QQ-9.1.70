package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0001J\u001f\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton;", "Lcom/tencent/mobileqq/activity/history/api/INTChatHistoryMsgForwardApi;", "Landroid/content/Intent;", "data", "", "doChatHistoryMsgForward", "Landroid/content/Context;", "context", "intent", "previewForwardMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "params", "setData", "<init>", "()V", "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class NTChatHistoryMsgForwardSingleton implements INTChatHistoryMsgForwardApi {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final NTChatHistoryMsgForwardSingleton INSTANCE;
    private final /* synthetic */ INTChatHistoryMsgForwardApi $$delegate_0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "forwardType", "chatType", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUid", "<init>", "(IILjava/lang/String;)V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int forwardType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int chatType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String peerUid;

        public a(int i3, int i16, @NotNull String peerUid) {
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), peerUid);
                return;
            }
            this.forwardType = i3;
            this.chatType = i16;
            this.peerUid = peerUid;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.chatType;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.forwardType;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.peerUid;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.forwardType == aVar.forwardType && this.chatType == aVar.chatType && Intrinsics.areEqual(this.peerUid, aVar.peerUid)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.forwardType * 31) + this.chatType) * 31) + this.peerUid.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ForwardParams(forwardType=" + this.forwardType + ", chatType=" + this.chatType + ", peerUid=" + this.peerUid + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new NTChatHistoryMsgForwardSingleton();
        }
    }

    NTChatHistoryMsgForwardSingleton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = (INTChatHistoryMsgForwardApi) QRoute.api(INTChatHistoryMsgForwardApi.class);
        }
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void doChatHistoryMsgForward(@NotNull Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            this.$$delegate_0.doChatHistoryMsgForward(data);
        }
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void previewForwardMsg(@NotNull Context context, @NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.$$delegate_0.previewForwardMsg(context, intent);
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void setData(@NotNull List<MsgRecord> msgRecordList, @NotNull a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgRecordList, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        Intrinsics.checkNotNullParameter(params, "params");
        this.$$delegate_0.setData(msgRecordList, params);
    }
}

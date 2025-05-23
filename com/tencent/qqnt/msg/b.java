package com.tencent.qqnt.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ar;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/msg/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGuildMsgListener;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "bFind", "Lcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;", "freqLimitInfo", "", "onChannelFreqLimitInfoUpdate", "<init>", "()V", "a", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class b implements IKernelGuildMsgListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msg/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
    public void onChannelFreqLimitInfoUpdate(@Nullable Contact peer, boolean bFind, @Nullable FreqLimitInfo freqLimitInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, peer, Boolean.valueOf(bFind), freqLimitInfo);
        } else if (QLog.isColorLevel()) {
            QLog.d("GuildMsgListenerAdapter", 1, "onChannelFreqLimitInfoUpdate");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
    public /* synthetic */ void onFirstViewGroupGuildMapping(ArrayList arrayList) {
        ar.b(this, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
    public /* synthetic */ void onGroupGuildUpdate(GroupGuildNotifyInfo groupGuildNotifyInfo) {
        ar.c(this, groupGuildNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
    public /* synthetic */ void onMsgEventListUpdate(HashMap hashMap) {
        ar.e(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
    public /* synthetic */ void onRecvS2CMsg(ArrayList arrayList) {
        ar.g(this, arrayList);
    }
}

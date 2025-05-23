package com.tencent.qqnt.aio.assistedchat.request;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$AssistedSwitchReq;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$AssistedSwitchRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$Dialog;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$GetPromptListReq;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$GetPromptListRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendReq;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$ReportReq;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u00c5\u0001\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00042S\b\u0002\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018Jk\u0010\"\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022S\b\u0002\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018Jf\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\n2<\b\u0002\u0010\u001f\u001a6\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\b\u0018\u00010$Ji\u0010'\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022Q\u0010\u001f\u001aM\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010&\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/request/a;", "", "", "cmd", "", "reqByte", "Lcom/tencent/qqnt/aio/assistedchat/servlet/a;", "observer", "", "f", "", "chatType", "peerUid", "scene", "content", "reqOffset", "", "Lcom/tencent/qqnt/aio/assistedchat/protocolbuffer/AssistedChatPB$Dialog;", "dialogs", "reqCount", "", "needBinaryData", "promptId", "extData", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "code", "msg", "Lcom/tencent/qqnt/aio/assistedchat/protocolbuffer/AssistedChatPB$RecommendRsp;", "rsp", "callback", "b", "Lcom/tencent/qqnt/aio/assistedchat/protocolbuffer/AssistedChatPB$AssistedSwitchRsp;", "g", "reportEvent", "Lkotlin/Function2;", "d", "Lcom/tencent/qqnt/aio/assistedchat/protocolbuffer/AssistedChatPB$GetPromptListRsp;", "a", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final a f349425a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/assistedchat/request/a$a", "Lcom/tencent/qqnt/aio/assistedchat/servlet/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "code", "", "msg", "rsp", "", "b", "(ILjava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.request.a$a */
    /* loaded from: classes23.dex */
    public static final class C9462a extends com.tencent.qqnt.aio.assistedchat.servlet.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e */
        final /* synthetic */ Function3<Integer, String, AssistedChatPB$GetPromptListRsp, Unit> f349426e;

        /* JADX WARN: Multi-variable type inference failed */
        C9462a(Function3<? super Integer, ? super String, ? super AssistedChatPB$GetPromptListRsp, Unit> function3) {
            this.f349426e = function3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function3);
            }
        }

        @Override // com.tencent.qqnt.aio.assistedchat.servlet.a
        public <T extends MessageMicro<?>> void b(int code, @Nullable String msg2, @Nullable T rsp) {
            AssistedChatPB$GetPromptListRsp assistedChatPB$GetPromptListRsp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(code), msg2, rsp);
                return;
            }
            Function3<Integer, String, AssistedChatPB$GetPromptListRsp, Unit> function3 = this.f349426e;
            if (function3 != null) {
                Integer valueOf = Integer.valueOf(code);
                if (rsp instanceof AssistedChatPB$GetPromptListRsp) {
                    assistedChatPB$GetPromptListRsp = (AssistedChatPB$GetPromptListRsp) rsp;
                } else {
                    assistedChatPB$GetPromptListRsp = null;
                }
                function3.invoke(valueOf, msg2, assistedChatPB$GetPromptListRsp);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/assistedchat/request/a$b", "Lcom/tencent/qqnt/aio/assistedchat/servlet/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "code", "", "msg", "rsp", "", "b", "(ILjava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends com.tencent.qqnt.aio.assistedchat.servlet.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e */
        final /* synthetic */ Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit> f349427e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Integer, ? super String, ? super AssistedChatPB$RecommendRsp, Unit> function3) {
            this.f349427e = function3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function3);
            }
        }

        @Override // com.tencent.qqnt.aio.assistedchat.servlet.a
        public <T extends MessageMicro<?>> void b(int code, @Nullable String msg2, @Nullable T rsp) {
            AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(code), msg2, rsp);
                return;
            }
            Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit> function3 = this.f349427e;
            if (function3 != null) {
                Integer valueOf = Integer.valueOf(code);
                if (rsp instanceof AssistedChatPB$RecommendRsp) {
                    assistedChatPB$RecommendRsp = (AssistedChatPB$RecommendRsp) rsp;
                } else {
                    assistedChatPB$RecommendRsp = null;
                }
                function3.invoke(valueOf, msg2, assistedChatPB$RecommendRsp);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/assistedchat/request/a$c", "Lcom/tencent/qqnt/aio/assistedchat/servlet/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "code", "", "msg", "rsp", "", "b", "(ILjava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends com.tencent.qqnt.aio.assistedchat.servlet.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e */
        final /* synthetic */ Function2<Integer, String, Unit> f349428e;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super Integer, ? super String, Unit> function2) {
            this.f349428e = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.qqnt.aio.assistedchat.servlet.a
        public <T extends MessageMicro<?>> void b(int code, @Nullable String msg2, @Nullable T rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(code), msg2, rsp);
                return;
            }
            Function2<Integer, String, Unit> function2 = this.f349428e;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(code), msg2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/assistedchat/request/a$d", "Lcom/tencent/qqnt/aio/assistedchat/servlet/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "code", "", "msg", "rsp", "", "b", "(ILjava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d extends com.tencent.qqnt.aio.assistedchat.servlet.a {
        static IPatchRedirector $redirector_;

        /* renamed from: e */
        final /* synthetic */ Function3<Integer, String, AssistedChatPB$AssistedSwitchRsp, Unit> f349429e;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function3<? super Integer, ? super String, ? super AssistedChatPB$AssistedSwitchRsp, Unit> function3) {
            this.f349429e = function3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function3);
            }
        }

        @Override // com.tencent.qqnt.aio.assistedchat.servlet.a
        public <T extends MessageMicro<?>> void b(int code, @Nullable String msg2, @Nullable T rsp) {
            AssistedChatPB$AssistedSwitchRsp assistedChatPB$AssistedSwitchRsp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(code), msg2, rsp);
                return;
            }
            Function3<Integer, String, AssistedChatPB$AssistedSwitchRsp, Unit> function3 = this.f349429e;
            if (function3 != null) {
                Integer valueOf = Integer.valueOf(code);
                if (rsp instanceof AssistedChatPB$AssistedSwitchRsp) {
                    assistedChatPB$AssistedSwitchRsp = (AssistedChatPB$AssistedSwitchRsp) rsp;
                } else {
                    assistedChatPB$AssistedSwitchRsp = null;
                }
                function3.invoke(valueOf, msg2, assistedChatPB$AssistedSwitchRsp);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f349425a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(a aVar, int i3, String str, int i16, String str2, int i17, List list, int i18, boolean z16, String str3, byte[] bArr, Function3 function3, int i19, Object obj) {
        String str4;
        int i26;
        List list2;
        int i27;
        boolean z17;
        String str5;
        byte[] bArr2;
        Function3 function32;
        List emptyList;
        if ((i19 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i19 & 16) != 0) {
            i26 = 0;
        } else {
            i26 = i17;
        }
        if ((i19 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        if ((i19 & 64) != 0) {
            i27 = 8;
        } else {
            i27 = i18;
        }
        if ((i19 & 128) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i19 & 256) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i19 & 512) != 0) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        if ((i19 & 1024) != 0) {
            function32 = null;
        } else {
            function32 = function3;
        }
        aVar.b(i3, str, i16, str4, i26, list2, i27, z17, str5, bArr2, function32);
    }

    public static /* synthetic */ void e(a aVar, int i3, String str, int i16, int i17, Function2 function2, int i18, Object obj) {
        if ((i18 & 8) != 0) {
            i17 = 1;
        }
        int i19 = i17;
        if ((i18 & 16) != 0) {
            function2 = null;
        }
        aVar.d(i3, str, i16, i19, function2);
    }

    private final void f(String cmd, byte[] reqByte, com.tencent.qqnt.aio.assistedchat.servlet.a observer) {
        NewIntent newIntent = new NewIntent(BaseApplication.context, com.tencent.qqnt.aio.assistedchat.servlet.c.class);
        newIntent.putExtra("cmd", cmd);
        newIntent.putExtra("reqBody", reqByte);
        newIntent.setObserver(observer);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        peekAppRuntime.startServlet(newIntent);
    }

    public final void a(int chatType, @NotNull String peerUid, @Nullable Function3<? super Integer, ? super String, ? super AssistedChatPB$GetPromptListRsp, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), peerUid, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        QLog.d("AssistedChatRecommendRequest", 1, "getPromptList chatType=" + chatType + " peerUid:" + peerUid);
        AssistedChatPB$GetPromptListReq assistedChatPB$GetPromptListReq = new AssistedChatPB$GetPromptListReq();
        com.tencent.qqnt.aio.assistedchat.request.b a16 = com.tencent.qqnt.aio.assistedchat.request.c.f349432a.a(chatType);
        assistedChatPB$GetPromptListReq.peer_user.setHasFlag(true);
        assistedChatPB$GetPromptListReq.peer_user.biz_type.set(a16.a());
        if (a16.b()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(peerUid);
            if (longOrNull != null) {
                assistedChatPB$GetPromptListReq.peer_user.peer_tiny_id.set(longOrNull.longValue());
            }
        } else {
            assistedChatPB$GetPromptListReq.peer_user.peer_uid.set(peerUid);
        }
        byte[] byteArray = assistedChatPB$GetPromptListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        f("trpc.kuolie.assisted_chat.AssistedChatService.SsoGetPromptList", byteArray, new C9462a(callback));
    }

    public final void b(int chatType, @NotNull String peerUid, int scene, @Nullable String content, int reqOffset, @Nullable List<AssistedChatPB$Dialog> dialogs, int reqCount, boolean needBinaryData, @Nullable String promptId, @NotNull byte[] extData, @Nullable Function3<? super Integer, ? super String, ? super AssistedChatPB$RecommendRsp, Unit> callback) {
        boolean z16;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(chatType), peerUid, Integer.valueOf(scene), content, Integer.valueOf(reqOffset), dialogs, Integer.valueOf(reqCount), Boolean.valueOf(needBinaryData), promptId, extData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(extData, "extData");
        QLog.d("AssistedChatRecommendRequest", 1, "sendGetRecommendListRequest chatType=" + chatType + " peerUid:" + peerUid + " scene=" + scene + " content=" + content + " promptId=" + promptId + " reqOffset=" + reqOffset + " reqCount=" + reqCount + " extData.size=" + extData.length);
        AssistedChatPB$RecommendReq assistedChatPB$RecommendReq = new AssistedChatPB$RecommendReq();
        com.tencent.qqnt.aio.assistedchat.request.b a16 = com.tencent.qqnt.aio.assistedchat.request.c.f349432a.a(chatType);
        assistedChatPB$RecommendReq.biz_type.set(a16.a());
        if (a16.b()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(peerUid);
            if (longOrNull != null) {
                assistedChatPB$RecommendReq.peer_tiny_id.set(longOrNull.longValue());
            }
        } else {
            assistedChatPB$RecommendReq.peer_uid.set(peerUid);
        }
        assistedChatPB$RecommendReq.scene.set(scene);
        if (content != null) {
            assistedChatPB$RecommendReq.content.set(content);
        }
        assistedChatPB$RecommendReq.req_offset.set(reqOffset);
        if (dialogs != null) {
            assistedChatPB$RecommendReq.dialogs.set(dialogs);
        }
        assistedChatPB$RecommendReq.req_count.set(reqCount);
        assistedChatPB$RecommendReq.need_binary_data.set(needBinaryData);
        if (promptId != null && promptId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            assistedChatPB$RecommendReq.prompt_id.set(promptId);
        }
        if (extData.length == 0) {
            z17 = true;
        }
        if (!z17) {
            assistedChatPB$RecommendReq.ext_data.set(ByteStringMicro.copyFrom(extData));
        }
        byte[] byteArray = assistedChatPB$RecommendReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        f("trpc.kuolie.assisted_chat.AssistedChatService.SsoRecommend", byteArray, new b(callback));
    }

    public final void d(int chatType, @NotNull String peerUid, int scene, int reportEvent, @Nullable Function2<? super Integer, ? super String, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(chatType), peerUid, Integer.valueOf(scene), Integer.valueOf(reportEvent), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        QLog.d("AssistedChatRecommendRequest", 1, "sendReportRequest chatType=" + chatType + " peerUid:" + peerUid + " scene:" + scene + " reportEvent:" + reportEvent);
        AssistedChatPB$ReportReq assistedChatPB$ReportReq = new AssistedChatPB$ReportReq();
        com.tencent.qqnt.aio.assistedchat.request.b a16 = com.tencent.qqnt.aio.assistedchat.request.c.f349432a.a(chatType);
        assistedChatPB$ReportReq.peer_user.setHasFlag(true);
        assistedChatPB$ReportReq.peer_user.biz_type.set(a16.a());
        if (a16.b()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(peerUid);
            if (longOrNull != null) {
                assistedChatPB$ReportReq.peer_user.peer_tiny_id.set(longOrNull.longValue());
            }
        } else {
            assistedChatPB$ReportReq.peer_user.peer_uid.set(peerUid);
        }
        assistedChatPB$ReportReq.scene.set(scene);
        assistedChatPB$ReportReq.report_event.set(reportEvent);
        byte[] byteArray = assistedChatPB$ReportReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        f("trpc.kuolie.assisted_chat.AssistedChatService.SsoReport", byteArray, new c(callback));
    }

    public final void g(int chatType, @NotNull String peerUid, @Nullable Function3<? super Integer, ? super String, ? super AssistedChatPB$AssistedSwitchRsp, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chatType), peerUid, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        QLog.d("AssistedChatRecommendRequest", 1, "sendSwitchRequest chatType=" + chatType + " peerUid:" + peerUid);
        AssistedChatPB$AssistedSwitchReq assistedChatPB$AssistedSwitchReq = new AssistedChatPB$AssistedSwitchReq();
        com.tencent.qqnt.aio.assistedchat.request.b a16 = com.tencent.qqnt.aio.assistedchat.request.c.f349432a.a(chatType);
        assistedChatPB$AssistedSwitchReq.peer_user.setHasFlag(true);
        assistedChatPB$AssistedSwitchReq.peer_user.biz_type.set(a16.a());
        if (a16.b()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(peerUid);
            if (longOrNull != null) {
                assistedChatPB$AssistedSwitchReq.peer_user.peer_tiny_id.set(longOrNull.longValue());
            }
        } else {
            assistedChatPB$AssistedSwitchReq.peer_user.peer_uid.set(peerUid);
        }
        byte[] byteArray = assistedChatPB$AssistedSwitchReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        f("trpc.kuolie.assisted_chat.AssistedChatService.SsoAssistedSwitch", byteArray, new d(callback));
    }
}

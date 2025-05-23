package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.text.TextUtils;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.api.AIOTofuMsgIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.msgrepo.TofuAuthenticationAbility;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.DeleteStatus;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LastTofu;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RevealAuthorityReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J<\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00122\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0010j\b\u0012\u0004\u0012\u00020\u0019`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0010j\b\u0012\u0004\u0012\u00020\u001d`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001b\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/TofuAuthenticationAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent$UpdateDisplayTofuIntent;", "intent", "", "v", "Lcom/tencent/mobileqq/aio/api/AIOTofuMsgIntent$AuthenticationIntent;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/msg/service/t;", "tofuAuthorityRsp", "w", "", "rootMsgChatType", "", "rootMsgPeerId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "g", "k", "", "i", "Ljava/util/ArrayList;", "authorityTofuMsgIdList", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/TofuAuthenticationAbility$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "authorityTofuMsgIdNeedDeleteList", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TofuAuthenticationAbility extends g<AIOMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Long> authorityTofuMsgIdList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> authorityTofuMsgIdNeedDeleteList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/TofuAuthenticationAbility$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.TofuAuthenticationAbility$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/TofuAuthenticationAbility$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "rootMsgChatType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "rootMsgPeerId", "", "J", "()J", "msgId", "<init>", "(ILjava/lang/String;J)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int rootMsgChatType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String rootMsgPeerId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        public b(int i3, @NotNull String rootMsgPeerId, long j3) {
            Intrinsics.checkNotNullParameter(rootMsgPeerId, "rootMsgPeerId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), rootMsgPeerId, Long.valueOf(j3));
                return;
            }
            this.rootMsgChatType = i3;
            this.rootMsgPeerId = rootMsgPeerId;
            this.msgId = j3;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.rootMsgChatType;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.rootMsgPeerId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.rootMsgChatType == bVar.rootMsgChatType && Intrinsics.areEqual(this.rootMsgPeerId, bVar.rootMsgPeerId) && this.msgId == bVar.msgId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.rootMsgChatType * 31) + this.rootMsgPeerId.hashCode()) * 31) + androidx.fragment.app.a.a(this.msgId);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "NeedDeleteTofuNtMsg(rootMsgChatType=" + this.rootMsgChatType + ", rootMsgPeerId=" + this.rootMsgPeerId + ", msgId=" + this.msgId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192563a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64282);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[DeleteStatus.values().length];
            try {
                iArr[DeleteStatus.KINVALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeleteStatus.KSTATUSEXIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeleteStatus.KSTATUSUPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeleteStatus.KSTATUSDELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f192563a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64284);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuAuthenticationAbility(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        } else {
            this.authorityTofuMsgIdList = new ArrayList<>();
            this.authorityTofuMsgIdNeedDeleteList = new ArrayList<>();
        }
    }

    private final void s(AIOTofuMsgIntent.AuthenticationIntent intent) {
        ArrayList arrayListOf;
        if (this.authorityTofuMsgIdList.contains(Long.valueOf(intent.d()))) {
            QLog.i("TofuAuthenticationAbility", 1, "handleAuthentication:: has triggered authority:" + intent.d() + ", return");
            return;
        }
        this.authorityTofuMsgIdList.add(Long.valueOf(intent.d()));
        long c16 = intent.c();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new LastTofu(intent.a(), intent.b(), DeleteStatus.KINVALID));
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.e(intent.d(), new RevealAuthorityReq(c16, arrayListOf)), new TofuAuthenticationAbility$handleAuthentication$1(intent, this, null)), zs.b.a(Dispatchers.INSTANCE)), f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(TofuAuthenticationAbility this$0) {
        ArrayList<Long> arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.authorityTofuMsgIdNeedDeleteList.isEmpty()) {
            for (final b bVar : this$0.authorityTofuMsgIdNeedDeleteList) {
                com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    Contact contact = new Contact(bVar.b(), bVar.c(), "");
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(bVar.a()));
                    e16.deleteMsg(contact, arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.w
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            TofuAuthenticationAbility.u(TofuAuthenticationAbility.b.this, i3, str);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(b it, int i3, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        QLog.i("TofuAuthenticationAbility", 1, "onDestory:: delete msgId=" + it.a() + ", result=" + i3 + ", errMsg=" + str);
    }

    private final void v(final AIOTofuMsgIntent.UpdateDisplayTofuIntent intent) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.v
            @Override // java.lang.Runnable
            public final void run() {
                TofuAuthenticationAbility.x(TofuAuthenticationAbility.this, intent);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.tencent.mobileqq.aio.msg.service.t tofuAuthorityRsp) {
        boolean z16;
        int i3;
        ArrayList<LastTofu> arrayList = tofuAuthorityRsp.c().lastTofus;
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            MsgList M = e().M();
            int i16 = 0;
            for (com.tencent.aio.data.msglist.a aVar : M) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.aio.data.msglist.a aVar2 = aVar;
                if ((aVar2 instanceof AIOMsgItem) && !com.tencent.mobileqq.aio.utils.d.s((AIOMsgItem) aVar2) && aVar2.getMsgId() == tofuAuthorityRsp.a()) {
                    AIOMsgItem cloneNewInstance = ((AIOMsgItem) aVar2).cloneNewInstance();
                    if (cloneNewInstance instanceof ah) {
                        Iterator<LastTofu> it = tofuAuthorityRsp.c().lastTofus.iterator();
                        while (it.hasNext()) {
                            LastTofu next = it.next();
                            ah ahVar = (ah) cloneNewInstance;
                            if (next.busiID == ahVar.n2() && TextUtils.equals(next.busiUUID, ahVar.m2())) {
                                ah.a q26 = ahVar.q2();
                                DeleteStatus deleteStatus = next.deleteFlag;
                                if (deleteStatus == null) {
                                    i3 = -1;
                                } else {
                                    i3 = c.f192563a[deleteStatus.ordinal()];
                                }
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        if (i3 == 3 || i3 == 4) {
                                            q26.g(2);
                                        }
                                    } else {
                                        q26.g(1);
                                    }
                                } else {
                                    q26.g(3);
                                }
                                z17 = true;
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    M.set(i16, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                }
                i16 = i17;
            }
            if (z17) {
                BaseMsgRepo.o0(e(), M, "tofu_authentication", null, null, 12, null);
            }
        }
        QLog.i("TofuAuthenticationAbility", 1, "triggerDisplayListUpdate:: match is " + z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(TofuAuthenticationAbility this$0, AIOTofuMsgIntent.UpdateDisplayTofuIntent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        MsgList M = this$0.e().M();
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                if (!com.tencent.mobileqq.aio.utils.d.s(aIOMsgItem) && aIOMsgItem.getMsgRecord().msgType == 23) {
                    ah ahVar = (ah) aVar;
                    if (intent.a() == ahVar.n2() && TextUtils.equals(intent.b(), ahVar.m2())) {
                        AIOMsgItem cloneNewInstance = ahVar.cloneNewInstance();
                        Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.TofuMsgItem");
                        ah ahVar2 = (ah) cloneNewInstance;
                        ah.a q26 = ahVar2.q2();
                        q26.i(true);
                        ahVar2.D2(q26, null);
                        Unit unit = Unit.INSTANCE;
                        M.set(i3, (com.tencent.aio.data.msglist.a) ahVar2);
                        z16 = true;
                    }
                }
            }
            i3 = i16;
        }
        QLog.i("TofuAuthenticationAbility", 1, "triggerDisplayListUpdate:: from AIOTofuMsgIntent.UpdateDisplayTofuIntent, match is " + z16);
        if (z16) {
            BaseMsgRepo.o0(this$0.e(), M, "tofu_authentication", null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(int rootMsgChatType, String rootMsgPeerId, ArrayList<MsgRecord> msgList, com.tencent.mobileqq.aio.msg.service.t tofuAuthorityRsp) {
        boolean z16;
        int i3;
        if (msgList == null) {
            return false;
        }
        boolean z17 = false;
        for (MsgRecord msgRecord : msgList) {
            if (msgRecord.msgType == 23) {
                ah ahVar = new ah(msgRecord);
                ah.a q26 = ahVar.q2();
                if (tofuAuthorityRsp.b() != 0) {
                    q26.g(4);
                    ahVar.D2(q26, null);
                } else {
                    ArrayList<LastTofu> arrayList = tofuAuthorityRsp.c().lastTofus;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        q26.g(5);
                        ahVar.D2(q26, null);
                    } else {
                        Iterator<LastTofu> it = tofuAuthorityRsp.c().lastTofus.iterator();
                        while (it.hasNext()) {
                            LastTofu next = it.next();
                            if (next.busiID == ahVar.n2() && TextUtils.equals(next.busiUUID, ahVar.m2())) {
                                DeleteStatus deleteStatus = next.deleteFlag;
                                if (deleteStatus == null) {
                                    i3 = -1;
                                } else {
                                    i3 = c.f192563a[deleteStatus.ordinal()];
                                }
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        if (i3 == 3 || i3 == 4) {
                                            q26.g(2);
                                            this.authorityTofuMsgIdNeedDeleteList.add(new b(rootMsgChatType, rootMsgPeerId, tofuAuthorityRsp.a()));
                                        }
                                    } else {
                                        q26.g(1);
                                    }
                                } else {
                                    q26.g(3);
                                }
                                ahVar.D2(q26, null);
                                z17 = true;
                            }
                        }
                    }
                }
            }
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOTofuMsgIntent.AuthenticationIntent) {
            s((AIOTofuMsgIntent.AuthenticationIntent) intent);
        } else if (intent instanceof AIOTofuMsgIntent.UpdateDisplayTofuIntent) {
            v((AIOTofuMsgIntent.UpdateDisplayTofuIntent) intent);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.api.AIOTofuMsgIntent.AuthenticationIntent");
        hashSet.add("com.tencent.mobileqq.aio.api.AIOTofuMsgIntent.UpdateDisplayTofuIntent");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.k();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.u
                @Override // java.lang.Runnable
                public final void run() {
                    TofuAuthenticationAbility.t(TofuAuthenticationAbility.this);
                }
            }, 32, null, false);
        }
    }
}

package com.tencent.mobileqq.qqgamepub.nt.api.impl;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\n\u001a\u00020\tJ \u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/impl/GameMallNtApiImpl;", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi;", "", "limitSize", "initMsgSize", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$b;", "listener", "", "getMsgList", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "getContact", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$a;", "getBusinessMsgList", "<init>", "()V", "Companion", "a", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class GameMallNtApiImpl implements IGameMallNtApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQGamePub_QQGameMallMsgApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/impl/GameMallNtApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqgamepub.nt.api.impl.GameMallNtApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqgamepub/nt/api/impl/GameMallNtApiImpl$b", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IGameMallNtApi.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f264656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGameMallNtApi.a f264657b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f264658c;

        b(int i3, IGameMallNtApi.a aVar, long j3) {
            this.f264656a = i3;
            this.f264657b = aVar;
            this.f264658c = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), aVar, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi.b
        public void onSuccess(@NotNull ArrayList<MsgRecord> msgList) {
            QQGameMsgInfo g16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
                return;
            }
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            ArrayList<QQGameMsgInfo> arrayList = new ArrayList<>();
            long currentTimeMillis = System.currentTimeMillis();
            int size = msgList.size();
            if (size > 0) {
                while (true) {
                    size--;
                    if (this.f264656a <= 0 || size < 0) {
                        break;
                    }
                    MsgRecord msgRecord = msgList.get(size);
                    Intrinsics.checkNotNullExpressionValue(msgRecord, "msgList[i]");
                    MsgRecord msgRecord2 = msgRecord;
                    if (Intrinsics.areEqual("3593944551", String.valueOf(msgRecord2.peerUin)) && (g16 = com.tencent.mobileqq.qqgamepub.nt.c.g(msgRecord2)) != null) {
                        arrayList.add(g16);
                    }
                }
            }
            this.f264657b.onSuccess(arrayList);
            QLog.d(GameMallNtApiImpl.TAG, 2, "findMessageFromCacheV2  listSize =" + arrayList.size() + " findMsgCost=" + (currentTimeMillis - this.f264658c));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GameMallNtApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMsgList$lambda$0(IGameMallNtApi.b listener, long j3, int i3, String errMsg, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ArrayList<MsgRecord> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        listener.onSuccess(arrayList2);
        QLog.d(TAG, 2, "getMsgList  result =" + i3 + " errMsg=" + errMsg + " listSize=" + arrayList2.size() + " findMsgCost=" + (System.currentTimeMillis() - j3));
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi
    public void getBusinessMsgList(int limitSize, int initMsgSize, @NotNull IGameMallNtApi.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(limitSize), Integer.valueOf(initMsgSize), listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getMsgList(limitSize, initMsgSize, new b(limitSize, listener, System.currentTimeMillis()));
        }
    }

    @NotNull
    public final Contact getContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Contact) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Contact(103, "u_BWXiWqJtbtbmrr2h5LELQg", "");
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi
    public void getMsgList(int limitSize, int initMsgSize, @NotNull final IGameMallNtApi.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(limitSize), Integer.valueOf(initMsgSize), listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long currentTimeMillis = System.currentTimeMillis();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getMsgs(getContact(), 0L, initMsgSize, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qqgamepub.nt.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GameMallNtApiImpl.getMsgList$lambda$0(IGameMallNtApi.b.this, currentTimeMillis, i3, str, arrayList);
                }
            });
        }
    }
}

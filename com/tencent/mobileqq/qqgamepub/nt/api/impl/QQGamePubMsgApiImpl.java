package com.tencent.mobileqq.qqgamepub.nt.api.impl;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J8\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\fj\b\u0012\u0004\u0012\u00020\u0011`\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0014H\u0016J0\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001fH\u0016J\u001a\u0010$\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00182\b\u0010\t\u001a\u0004\u0018\u00010#H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/impl/QQGamePubMsgApiImpl;", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi;", "Lcom/tencent/qqnt/kernel/api/aa;", "getRecentContactService", "", "fromMsgId", "", "msgSize", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$b;", "listener", "", "getMsgListByMsgId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "limitSize", "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "parseMsgList", "setMsgRead", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$c;", "getUnreadCnt", "initMsgSize", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$a;", "", "from", "getBusinessMsgListByMsgId", "getMsgList", "getBusinessMsgList", "msgId", "deleteMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "addMsgListener", "removeMsgListener", "title", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", SmsPlugin.API_SEND_SMS, "<init>", "()V", "Companion", "a", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQGamePubMsgApiImpl implements IQQGamePubMsgApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "QQGamePub_QQGameMsgApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/nt/api/impl/QQGamePubMsgApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqgamepub.nt.api.impl.QQGamePubMsgApiImpl$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqgamepub/nt/api/impl/QQGamePubMsgApiImpl$b", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IQQGamePubMsgApi$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IQQGamePubMsgApi.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f264660b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IQQGamePubMsgApi.a f264661c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f264662d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f264663e;

        b(int i3, IQQGamePubMsgApi.a aVar, long j3, String str) {
            this.f264660b = i3;
            this.f264661c = aVar;
            this.f264662d = j3;
            this.f264663e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQGamePubMsgApiImpl.this, Integer.valueOf(i3), aVar, Long.valueOf(j3), str);
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.b
        public void onSuccess(@NotNull ArrayList<MsgRecord> msgList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgList);
                return;
            }
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<QQGameMsgInfo> parseMsgList = QQGamePubMsgApiImpl.this.parseMsgList(msgList, this.f264660b);
            this.f264661c.onSuccess(parseMsgList);
            QLog.d(QQGamePubMsgApiImpl.TAG, 2, "getBusinessMsgListByMsgId  listSize =" + parseMsgList.size() + " findMsgCost=" + (currentTimeMillis - this.f264662d) + " from =" + this.f264663e);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQGamePubMsgApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMsg$lambda$4(int i3, String str) {
        QLog.i(TAG, 1, "[deleteMsg] result:" + i3);
    }

    private final void getMsgListByMsgId(long fromMsgId, int msgSize, final IQQGamePubMsgApi.b listener) {
        final long currentTimeMillis = System.currentTimeMillis();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getMsgs(com.tencent.mobileqq.qqgamepub.nt.b.INSTANCE.a(), fromMsgId, msgSize, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qqgamepub.nt.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    QQGamePubMsgApiImpl.getMsgListByMsgId$lambda$3(IQQGamePubMsgApi.b.this, currentTimeMillis, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMsgListByMsgId$lambda$3(IQQGamePubMsgApi.b listener, long j3, int i3, String errMsg, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ArrayList<MsgRecord> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        listener.onSuccess(arrayList2);
        QLog.d(TAG, 1, "getMsgListByMsgId  result =" + i3 + " errMsg=" + errMsg + " listSize=" + arrayList2.size() + " findMsgCost=" + (System.currentTimeMillis() - j3));
    }

    private final aa getRecentContactService() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getRecentContactService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUnreadCnt$lambda$2$lambda$1(IQQGamePubMsgApi.c listener, long j3, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        boolean z16;
        int i16;
        Intrinsics.checkNotNullParameter(listener, "$listener");
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            i16 = (int) ((RecentContactInfo) arrayList.get(0)).unreadCnt;
        } else {
            i16 = 0;
        }
        listener.onSuccess(i16);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (arrayList == null || arrayList.isEmpty()) {
            z17 = true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getUnreadCnt] unreadCnt:");
        sb5.append(i16);
        sb5.append(",cost:");
        sb5.append(currentTimeMillis);
        sb5.append(",found:");
        sb5.append(!z17);
        sb5.append(",errMsg:");
        sb5.append(str);
        QLog.i(TAG, 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<QQGameMsgInfo> parseMsgList(ArrayList<MsgRecord> msgList, int limitSize) {
        ArrayList<QQGameMsgInfo> arrayList = new ArrayList<>();
        int size = msgList.size();
        if (size > 0) {
            int i3 = 0;
            for (int i16 = size - 1; -1 < i16; i16--) {
                MsgRecord msgRecord = msgList.get(i16);
                Intrinsics.checkNotNullExpressionValue(msgRecord, "msgList[i]");
                MsgRecord msgRecord2 = msgRecord;
                if (Intrinsics.areEqual("2747277822", String.valueOf(msgRecord2.peerUin))) {
                    QQGameMsgInfo g16 = com.tencent.mobileqq.qqgamepub.nt.c.g(msgRecord2);
                    if (g16 != null) {
                        if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isInterceptMsg(g16.advId)) {
                            arrayList.add(g16);
                            i3++;
                            if (i3 >= limitSize) {
                                break;
                            }
                        } else {
                            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).deleteMsg(g16.msgId);
                            QLog.d(TAG, 1, "qqGameMsgInfo adid=" + g16.advId + " intercept!!!!");
                        }
                    } else {
                        QLog.d(TAG, 1, "qqGameMsgInfo parseMsgRecord msg error.");
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMsg$lambda$5(IOperateCallback iOperateCallback, int i3, String str) {
        QLog.i(TAG, 4, "send msg result=" + i3 + " errMsg=" + str);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMsgRead$lambda$0(int i3, String str) {
        QLog.i(TAG, 2, "[setMsgRead] result:" + i3 + ", errMsg:" + str);
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void addMsgListener(@NotNull IKernelMsgListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void deleteMsg(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, msgId);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(msgId));
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.deleteMsg(com.tencent.mobileqq.qqgamepub.nt.b.INSTANCE.a(), arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.qqgamepub.nt.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQGamePubMsgApiImpl.deleteMsg$lambda$4(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void getBusinessMsgList(int limitSize, int initMsgSize, @NotNull IQQGamePubMsgApi.a listener, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(limitSize), Integer.valueOf(initMsgSize), listener, from);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(from, "from");
        getBusinessMsgListByMsgId(0L, limitSize, initMsgSize, listener, from);
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void getBusinessMsgListByMsgId(long fromMsgId, int limitSize, int initMsgSize, @NotNull IQQGamePubMsgApi.a listener, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(fromMsgId), Integer.valueOf(limitSize), Integer.valueOf(initMsgSize), listener, from);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.d(TAG, 2, "getBusinessMsgListByMsgId from=", from);
        getMsgListByMsgId(fromMsgId, initMsgSize, new b(limitSize, listener, System.currentTimeMillis(), from));
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void getMsgList(int limitSize, int initMsgSize, @NotNull IQQGamePubMsgApi.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(limitSize), Integer.valueOf(initMsgSize), listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getMsgListByMsgId(0L, initMsgSize, listener);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void getUnreadCnt(@NotNull final IQQGamePubMsgApi.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long currentTimeMillis = System.currentTimeMillis();
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            recentContactService.F0(com.tencent.mobileqq.qqgamepub.nt.b.INSTANCE.a(), new IGetContactsCallback() { // from class: com.tencent.mobileqq.qqgamepub.nt.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    QQGamePubMsgApiImpl.getUnreadCnt$lambda$2$lambda$1(IQQGamePubMsgApi.c.this, currentTimeMillis, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void removeMsgListener(@NotNull IKernelMsgListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.removeMsgListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void sendMsg(@NotNull String title, @Nullable final IOperateCallback listener) {
        ArrayList<MsgElement> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) title, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(title));
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.F(0L, com.tencent.mobileqq.qqgamepub.nt.b.INSTANCE.a(), arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.qqgamepub.nt.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQGamePubMsgApiImpl.sendMsg$lambda$5(IOperateCallback.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi
    public void setMsgRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.setMsgRead(com.tencent.mobileqq.qqgamepub.nt.b.INSTANCE.a(), new IOperateCallback() { // from class: com.tencent.mobileqq.qqgamepub.nt.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQGamePubMsgApiImpl.setMsgRead$lambda$0(i3, str);
                }
            });
        }
    }
}

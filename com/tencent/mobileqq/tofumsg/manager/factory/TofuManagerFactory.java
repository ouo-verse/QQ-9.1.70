package com.tencent.mobileqq.tofumsg.manager.factory;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tofumsg.manager.CommonTofuManager;
import com.tencent.mobileqq.tofumsg.manager.h;
import com.tencent.mobileqq.tofumsg.manager.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014R>\u0010\u001e\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a0\u0019j\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a`\u001b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR7\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u0019j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t`\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/manager/factory/TofuManagerFactory;", "", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lcom/tencent/mobileqq/tofumsg/manager/factory/a;", "iCheckIsFromPushCallback", "", "f", "", "Lsr2/a;", "j", "Lcom/tencent/mobileqq/tofumsg/manager/factory/c;", "iGetManagerCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "channelId", "l", "", "chatType", "peerUid", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "cb", "i", "count", DomainData.DOMAIN_NAME, "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mManagerClassMap", "c", "Lkotlin/Lazy;", "k", "()Ljava/util/HashMap;", "mManagerInstanceMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TofuManagerFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TofuManagerFactory f293297a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/tofumanager/Inject_Tofu_Manager.yml", version = 1)
    @NotNull
    private static HashMap<String, Class<sr2.a>> mManagerClassMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mManagerInstanceMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tofumsg/manager/factory/TofuManagerFactory$a", "Lcom/tencent/mobileqq/tofumsg/manager/factory/a;", "", "isFromPush", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements com.tencent.mobileqq.tofumsg.manager.factory.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f293300a;

        a(c cVar) {
            this.f293300a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.tofumsg.manager.factory.a
        public void onResult(boolean isFromPush) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isFromPush);
            } else if (isFromPush) {
                this.f293300a.a((sr2.a) TofuManagerFactory.f293297a.k().get("push"));
            } else {
                this.f293300a.a((sr2.a) TofuManagerFactory.f293297a.k().get("common"));
            }
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f293297a = new TofuManagerFactory();
        HashMap<String, Class<sr2.a>> hashMap = new HashMap<>();
        mManagerClassMap = hashMap;
        hashMap.put("common", CommonTofuManager.class);
        mManagerClassMap.put("push", h.class);
        mManagerClassMap.put("sogou", i.class);
        lazy = LazyKt__LazyJVMKt.lazy(TofuManagerFactory$mManagerInstanceMap$2.INSTANCE);
        mManagerInstanceMap = lazy;
    }

    TofuManagerFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f(AIOParam aioParam, final com.tencent.mobileqq.tofumsg.manager.factory.a iCheckIsFromPushCallback) {
        n(1, aioParam.r().c().j(), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.factory.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                TofuManagerFactory.g(a.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final com.tencent.mobileqq.tofumsg.manager.factory.a iCheckIsFromPushCallback, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(iCheckIsFromPushCallback, "$iCheckIsFromPushCallback");
        QLog.i("TOFU::TofuManagerFactory", 1, "checkIsFromPush:: getSpecificCountTofuMsgFromNTDb, result=" + i3 + ", errMsg=" + str);
        if (i3 == 0 && arrayList != null) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord msgRecord = (MsgRecord) it.next();
                if (msgRecord.msgType == 23) {
                    Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                    ah ahVar = new ah(msgRecord);
                    ah.a q26 = ahVar.q2();
                    if (q26.b() == 2) {
                        booleanRef.element = true;
                        q26.h(4);
                        ahVar.D2(q26, new IOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.factory.f
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i16, String str2) {
                                TofuManagerFactory.h(Ref.BooleanRef.this, iCheckIsFromPushCallback, i16, str2);
                            }
                        });
                        return;
                    }
                }
            }
            boolean z16 = booleanRef.element;
            if (!z16) {
                QLog.i("TOFU::TofuManagerFactory", 1, "checkIsFromPush:: notify isFromPush=" + z16);
                iCheckIsFromPushCallback.onResult(false);
                return;
            }
            return;
        }
        QLog.i("TOFU::TofuManagerFactory", 1, "checkIsFromPush:: result != 0 || msgList == null, notify isFromPush=false");
        iCheckIsFromPushCallback.onResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.BooleanRef isFromPush, com.tencent.mobileqq.tofumsg.manager.factory.a iCheckIsFromPushCallback, int i3, String str) {
        Intrinsics.checkNotNullParameter(isFromPush, "$isFromPush");
        Intrinsics.checkNotNullParameter(iCheckIsFromPushCallback, "$iCheckIsFromPushCallback");
        QLog.i("TOFU::TofuManagerFactory", 1, "checkIsFromPush:: setPushExtraInfo, result=" + i3 + ", errMsg=" + str + ", notify isFromPush=" + isFromPush.element);
        iCheckIsFromPushCallback.onResult(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, sr2.a> k() {
        return (HashMap) mManagerInstanceMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(IMsgOperateCallback cb5, int i3, int i16, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        ArrayList<MsgRecord> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord msgRecord = (MsgRecord) it.next();
                if (msgRecord != null && msgRecord.msgType == 23 && arrayList2.size() < i3) {
                    arrayList2.add(msgRecord);
                }
            }
        }
        cb5.onResult(i16, str, arrayList2);
    }

    public final void i(int chatType, @NotNull String peerUid, @NotNull IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), peerUid, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        n(chatType, peerUid, 20, cb5);
    }

    @NotNull
    public final Collection<sr2.a> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Collection<sr2.a> values = k().values();
        Intrinsics.checkNotNullExpressionValue(values, "mManagerInstanceMap.values");
        return values;
    }

    @Nullable
    public final sr2.a l(@NotNull String channelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (sr2.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) channelId);
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return k().get(channelId);
    }

    public final void m(@NotNull AIOParam aioParam, @NotNull c iGetManagerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioParam, (Object) iGetManagerCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        Intrinsics.checkNotNullParameter(iGetManagerCallback, "iGetManagerCallback");
        if (aioParam.l().getBoolean("key_tofu_initiative")) {
            iGetManagerCallback.a(k().get("sogou"));
        } else {
            f(aioParam, new a(iGetManagerCallback));
        }
    }

    public final void n(int chatType, @NotNull String peerUid, final int count, @NotNull final IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(chatType), peerUid, Integer.valueOf(count), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("TOFU::TofuManagerFactory", 1, "getSpecificCountTofuMsgFromNTDb:: count=" + count);
        ((IMsgService) QRoute.api(IMsgService.class)).queryMsgsWithFilterEx(0L, 0L, 0L, new QueryMsgsParams(new ChatInfo(chatType, peerUid), new ArrayList(), new ArrayList(), 0L, 0L, 500, false, false), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.factory.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                TofuManagerFactory.o(IMsgOperateCallback.this, count, i3, str, arrayList);
            }
        });
    }
}

package com.tencent.mobileqq.tofumsg.manager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.api.AIOTofuMsgIntent;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.tofumsg.TofuLimitMsgForPush;
import com.tencent.mobileqq.tofumsg.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessClearType;
import com.tencent.qqnt.kernel.nativeinterface.RevealDoufuInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/manager/h;", "Lcom/tencent/mobileqq/tofumsg/manager/f;", "", "friendUin", "", "O", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "aioCreate", "Lcom/tencent/mobileqq/data/NewBeancurdMsg;", "newBeancurdMsg", "f", "i", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;", "a", "Lmqq/app/AppRuntime;", "appRuntime", "", "result", "errMsg", "I", "g", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tofumsg/manager/h$a", "Lcom/tencent/mobileqq/tofumsg/manager/factory/b;", "", "deleteSuc", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements com.tencent.mobileqq.tofumsg.manager.factory.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NewBeancurdMsg f293309b;

        a(NewBeancurdMsg newBeancurdMsg) {
            this.f293309b = newBeancurdMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) newBeancurdMsg);
            }
        }

        @Override // com.tencent.mobileqq.tofumsg.manager.factory.b
        public void onResult(boolean deleteSuc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, deleteSuc);
                return;
            }
            QLog.i(h.this.C(), 1, "moveCachePushTofuToMsgList:: delete specific tofu=" + this.f293309b + " in NT db suc=" + deleteSuc + "; but clear PushTofuIcon by NTSDK self");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tofumsg/manager/h$b", "Lcom/tencent/mobileqq/tofumsg/manager/factory/b;", "", "deleteSuc", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.tofumsg.manager.factory.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NewBeancurdMsg f293311b;

        b(NewBeancurdMsg newBeancurdMsg) {
            this.f293311b = newBeancurdMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) newBeancurdMsg);
            }
        }

        @Override // com.tencent.mobileqq.tofumsg.manager.factory.b
        public void onResult(boolean deleteSuc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, deleteSuc);
                return;
            }
            QLog.i(h.this.C(), 1, "receiveTofu:: delete specific tofu=" + this.f293311b + " in NT db suc=" + deleteSuc + ", but clear PushTofu icon by NTSDK self ");
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void O(String friendUin) {
        if (!((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isRevealEnable()) {
            QLog.i(C(), 1, "clearPushTofuIcon:: switch is false, return!!!");
            return;
        }
        if (!TextUtils.isEmpty(friendUin)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i(C(), 1, "clearPushTofuIcon:: appRuntime is null, return");
                return;
            }
            IKernelLiteBusinessService liteBusinessService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
            if (liteBusinessService != null) {
                String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(friendUin);
                if (!TextUtils.isEmpty(uinFromUid)) {
                    final HashSet<LiteBusinessClearType> hashSet = new HashSet<>();
                    hashSet.add(LiteBusinessClearType.KQZONEREVEAL);
                    liteBusinessService.clearLiteBusiness(uinFromUid, hashSet, new IOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.g
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            h.P(h.this, hashSet, i3, str);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(h this$0, HashSet it, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(this$0.C(), 1, "clearPushTofuIcon:: clearLiteBusiness, type=" + it + ", result=" + i3 + ", errMsg=" + errMsg);
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f
    @NotNull
    public String A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PushTofuManager";
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f
    public void I(@NotNull AppRuntime appRuntime, @NotNull NewBeancurdMsg newBeancurdMsg, int result, @NotNull String errMsg) {
        Long l3;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appRuntime, newBeancurdMsg, Integer.valueOf(result), errMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        super.I(appRuntime, newBeancurdMsg, result, errMsg);
        if (result != 0) {
            QLog.d(C(), 1, "insertTofuMsg2NtDbComplete:: occur error, result=" + result + ", errMsg=" + errMsg + ", return!!!" + newBeancurdMsg);
            return;
        }
        NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo = NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(newBeancurdMsg.pushInfoString);
        if (parseToGetPushInfo != null) {
            z16 = parseToGetPushInfo.checkIsPushTofu();
        }
        if (!z16) {
            QLog.d(C(), 1, "insertTofuMsg2NtDbComplete:: is not PushTofu, return!!!" + newBeancurdMsg);
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(newBeancurdMsg.frienduin);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.d(C(), 1, "insertTofuMsg2NtDbComplete:: convert uin failed, return!!!" + newBeancurdMsg);
            return;
        }
        String str = null;
        try {
            jSONObject = new JSONObject(newBeancurdMsg.extensionInfoStr);
            l3 = Long.valueOf(jSONObject.optLong("busiid"));
        } catch (JSONException e16) {
            e = e16;
            l3 = null;
        }
        try {
            str = jSONObject.optString("busi_uuid");
        } catch (JSONException e17) {
            e = e17;
            QLog.d(C(), 1, "doParse err: ", e);
            if (l3 == null) {
            }
            QLog.d(C(), 1, "insertTofuMsg2NtDbComplete:: illegal businessId | businessUUID, return!!!" + newBeancurdMsg);
        }
        if (l3 == null && str != null) {
            QLog.d(C(), 1, "insertTofuMsg2NtDbComplete:: insertRevealSuc:" + newBeancurdMsg);
            IKernelLiteBusinessService liteBusinessService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
            if (liteBusinessService != null) {
                liteBusinessService.insertRevealSuc(new RevealDoufuInfo(uidFromUin, l3.longValue(), str));
                return;
            }
            return;
        }
        QLog.d(C(), 1, "insertTofuMsg2NtDbComplete:: illegal businessId | businessUUID, return!!!" + newBeancurdMsg);
    }

    @Override // sr2.a
    @NotNull
    public CopyOnWriteArrayList<TofuLimitMsg> a(@NotNull QQAppInterface appInterface, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, (Object) friendUin);
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        CopyOnWriteArrayList<TofuLimitMsg> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.addAll(o.b().e(appInterface, friendUin));
        return copyOnWriteArrayList;
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void aioCreate(@NotNull AIOParam aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioParam);
            return;
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        super.aioCreate(aioParam);
        O(B());
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void f(@NotNull NewBeancurdMsg newBeancurdMsg) {
        HashMap hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        super.f(newBeancurdMsg);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("business_type", String.valueOf(newBeancurdMsg.busiid)));
        com.tencent.mobileqq.aio.utils.b.f194119a.n("ev_bas_message_list_dynamic_reminder_icon", hashMapOf);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(C(), 1, "receiveTofu:: appRuntime is null, return!!!" + newBeancurdMsg);
            return;
        }
        NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo = NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(newBeancurdMsg.pushInfoString);
        if (!parseToGetPushInfo.checkIsPushTofu()) {
            QLog.i(C(), 1, "receiveTofu:: the tofu is not pushTofu, return!!!" + newBeancurdMsg);
            return;
        }
        if (TextUtils.isEmpty(newBeancurdMsg.frienduin)) {
            QLog.i(C(), 1, "receiveTofu:: uin is empty, return!!!" + newBeancurdMsg);
            return;
        }
        String str = newBeancurdMsg.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "newBeancurdMsg.frienduin");
        if (q(str)) {
            TofuLimitMsgForPush create = TofuLimitMsgForPush.create(newBeancurdMsg);
            if (parseToGetPushInfo.isDelete) {
                CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList.add(create.businessMsgId);
                String str2 = create.friendUin;
                Intrinsics.checkNotNullExpressionValue(str2, "pushTofu.friendUin");
                d(str2, copyOnWriteArrayList, new b(newBeancurdMsg));
                return;
            }
            E(newBeancurdMsg, create);
            return;
        }
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.i(C(), 1, "receiveTofu:: appRuntime is not AppInterface, add tofu to cache failed, return!!!" + newBeancurdMsg);
            return;
        }
        p((AppInterface) peekAppRuntime, newBeancurdMsg);
        if (parseToGetPushInfo.isDelete) {
            String str3 = newBeancurdMsg.frienduin;
            Intrinsics.checkNotNullExpressionValue(str3, "newBeancurdMsg.frienduin");
            L(str3, newBeancurdMsg, new ah.b(null, null, Boolean.TRUE));
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                QLog.i(C(), 1, "receiveTofu:: not activity, send AIOTofuMsgIntent.UpdateDisplayTofuIntent failed!!!" + newBeancurdMsg);
                return;
            }
            com.tencent.qqnt.aio.utils.c cVar = com.tencent.qqnt.aio.utils.c.f352293a;
            String str4 = newBeancurdMsg.frienduin;
            Intrinsics.checkNotNullExpressionValue(str4, "newBeancurdMsg.frienduin");
            long parseLong = Long.parseLong(str4);
            long j3 = newBeancurdMsg.busiid;
            String str5 = newBeancurdMsg.busiUuid;
            Intrinsics.checkNotNullExpressionValue(str5, "newBeancurdMsg.busiUuid");
            cVar.b(qBaseActivity, "", new AIOTofuMsgIntent.UpdateDisplayTofuIntent(parseLong, j3, str5));
        }
    }

    @Override // sr2.a
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.tofumsg.manager.f, sr2.a
    public void i(@NotNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        super.i(newBeancurdMsg);
        NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo = NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(newBeancurdMsg.pushInfoString);
        if (!parseToGetPushInfo.checkIsPushTofu()) {
            QLog.i(C(), 1, "moveCachePushTofuToMsgList:: the tofu is not pushTofu, return!!!" + newBeancurdMsg);
            return;
        }
        TofuLimitMsgForPush create = TofuLimitMsgForPush.create(newBeancurdMsg);
        if (parseToGetPushInfo.isDelete) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(create.businessMsgId);
            String str = create.friendUin;
            Intrinsics.checkNotNullExpressionValue(str, "pushTofu.friendUin");
            d(str, copyOnWriteArrayList, new a(newBeancurdMsg));
            return;
        }
        E(newBeancurdMsg, create);
    }
}

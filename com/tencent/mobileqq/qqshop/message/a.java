package com.tencent.mobileqq.qqshop.message;

import android.os.Bundle;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.message.db.f;
import com.tencent.mobileqq.qqshop.proto.QQShopMsgPB$DefaultMsg;
import com.tencent.mobileqq.qqshop.proto.QQShopMsgPB$GetDefaultReq;
import com.tencent.mobileqq.qqshop.proto.QQShopMsgPB$GetDefaultRsp;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pl2.o;
import pl2.p;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0002J\f\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u0011J\f\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u000bR\u0018\u0010 \u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010)\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\"R\u0014\u0010+\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010\"R\u0014\u0010-\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\"\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/a;", "", "", HippyTKDListViewAdapter.X, "w", "y", "", "g", "o", "a", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "needInsertDB", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqshop/message/db/a;", "i", "r", "b", h.F, "p", "f", "cacheMsgData", "t", "v", "Lorg/json/JSONObject;", ReportConstant.COSTREPORT_PREFIX, "", "e", "Lcom/tencent/mobileqq/qqshop/message/db/a;", "lastMsgData", "d", "()Ljava/lang/String;", "accountUin", DomainData.DOMAIN_NAME, "mmkvKeyOrderUnreadCount", "k", "mmkvKeyCoinsUnreadCount", "l", "mmkvKeyDailyUnreadCount", "j", "mmkvKeyCacheMsgData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mmkvKeyLastUnreadDbMsgTime", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274473a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.qqshop.message.db.a lastMsgData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.qqshop.message.db.a cacheMsgData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.message.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8426a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f274476d;

        public C8426a(o oVar) {
            this.f274476d = oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) QQShopMsgPB$GetDefaultRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f274476d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + QQShopMsgPB$GetDefaultRsp.class + " failed.");
                    o oVar2 = this.f274476d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f274476d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqshop/message/a$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qqshop/proto/QQShopMsgPB$GetDefaultRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements o<QQShopMsgPB$GetDefaultRsp> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QQShopMsgPB$GetDefaultRsp rsp) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            List<QQShopMsgPB$DefaultMsg> list = rsp.f274500msg.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.msg.get()");
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (com.tencent.mobileqq.ecshop.utils.b.f203951a.a(((QQShopMsgPB$DefaultMsg) obj).msg_time.get(), NetConnInfoCenter.getServerTime())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            QQShopMsgPB$DefaultMsg qQShopMsgPB$DefaultMsg = (QQShopMsgPB$DefaultMsg) obj;
            if (qQShopMsgPB$DefaultMsg == null) {
                return;
            }
            long j3 = qQShopMsgPB$DefaultMsg.msg_id.get();
            String c16 = f.f274497a.c();
            long j16 = qQShopMsgPB$DefaultMsg.msg_time.get();
            String str = qQShopMsgPB$DefaultMsg.content.get();
            Intrinsics.checkNotNullExpressionValue(str, "defaultMsg.content.get()");
            a.f274473a.t(new com.tencent.mobileqq.qqshop.message.db.a(j3, c16, j16, str));
            QLog.d("QQSHopMessageCache", 4, "success size = " + rsp.f274500msg.size());
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("QQSHopMessageCache", 4, "errCode " + errCode + " errMsg " + errMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30003);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            f274473a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d() {
        return com.tencent.mobileqq.ecshop.utils.a.a().getCurrentAccountUin();
    }

    private final String j() {
        return "qq_shop_cache_msg_data_" + d();
    }

    private final String k() {
        return "qq_shop_coins_unread_count_" + d();
    }

    private final String l() {
        return "qq_shop_daily_unread_count_" + d();
    }

    private final String m() {
        return "qq_shop_last_db_msg_data_" + d();
    }

    private final String n() {
        return "qq_shop_pa_unread_count_" + d();
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.ecshop.utils.e.f203954a.d(l(), 0);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            com.tencent.mobileqq.ecshop.utils.e.g(m());
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.mobileqq.ecshop.utils.e.f203954a.d(n(), 0);
        }
    }

    @Nullable
    public final String e(@NotNull MsgRecord msgRecord) {
        Object obj;
        ArkElement arkElement;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).arkElement != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement == null || (arkElement = msgElement.arkElement) == null) {
            return null;
        }
        return arkElement.getBytesData();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.mobileqq.qqshop.message.db.a f() {
        boolean z16;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.qqshop.message.db.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        com.tencent.mobileqq.qqshop.message.db.a aVar = cacheMsgData;
        if (aVar != null) {
            if (Intrinsics.areEqual(aVar.d(), f.f274497a.c())) {
                return aVar;
            }
            cacheMsgData = null;
        }
        String c16 = com.tencent.mobileqq.ecshop.utils.e.c(j());
        if (c16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                jSONObject = new JSONObject(c16);
            } catch (JSONException e16) {
                QLog.e("QQSHopMessageCache", 1, e16, new Object[0]);
            }
            if (jSONObject != null) {
                cacheMsgData = null;
                return null;
            }
            long optLong = jSONObject.optLong("msgID");
            String c17 = f.f274497a.c();
            long optLong2 = jSONObject.optLong("msgTime");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "cacheMsgObj.toString()");
            com.tencent.mobileqq.qqshop.message.db.a aVar2 = new com.tencent.mobileqq.qqshop.message.db.a(optLong, c17, optLong2, jSONObject2);
            cacheMsgData = aVar2;
            return aVar2;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.ecshop.utils.e.f203954a.a(l());
    }

    @Nullable
    public final com.tencent.mobileqq.qqshop.message.db.a h() {
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) f.f274497a.d(0L, 1));
            return (com.tencent.mobileqq.qqshop.message.db.a) firstOrNull;
        }
        return (com.tencent.mobileqq.qqshop.message.db.a) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    @Nullable
    public final com.tencent.mobileqq.qqshop.message.db.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.qqshop.message.db.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.mobileqq.qqshop.message.db.a aVar = lastMsgData;
        if (aVar == null) {
            return null;
        }
        if (!Intrinsics.areEqual(aVar.d(), f.f274497a.c())) {
            lastMsgData = null;
            return null;
        }
        return lastMsgData;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.ecshop.utils.e.f203954a.a(n());
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqshop.message.db.a f16 = f();
        if (f16 == null) {
            return false;
        }
        return com.tencent.mobileqq.ecshop.utils.b.f203951a.a(f16.c(), NetConnInfoCenter.getServerTime());
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqshop.message.db.a i3 = i();
        if (i3 == null) {
            return false;
        }
        return com.tencent.mobileqq.ecshop.utils.b.f203951a.a(i3.c(), NetConnInfoCenter.getServerTime());
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.ecshop.utils.b.f203951a.a(com.tencent.mobileqq.ecshop.utils.e.f203954a.b(m()), NetConnInfoCenter.getServerTime());
    }

    @Nullable
    public final JSONObject s(@NotNull com.tencent.mobileqq.qqshop.message.db.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (JSONObject) iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar);
        }
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar.a().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(aVar.a());
            jSONObject.put("msgID", aVar.b());
            jSONObject.put("msgTime", aVar.c());
            return jSONObject;
        } catch (JSONException e16) {
            QLog.e("QQSHopMessageCache", 1, e16, new Object[0]);
            return null;
        }
    }

    public final void t(@NotNull com.tencent.mobileqq.qqshop.message.db.a cacheMsgData2) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cacheMsgData2);
            return;
        }
        Intrinsics.checkNotNullParameter(cacheMsgData2, "cacheMsgData");
        JSONObject s16 = s(cacheMsgData2);
        String j3 = j();
        if (s16 == null || (str = s16.toString()) == null) {
            str = "";
        }
        com.tencent.mobileqq.ecshop.utils.e.f(j3, str);
        cacheMsgData = cacheMsgData2;
    }

    public final void u(@Nullable MsgRecord msgRecord, boolean needInsertDB) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, msgRecord, Boolean.valueOf(needInsertDB));
            return;
        }
        if (msgRecord == null) {
            lastMsgData = null;
            return;
        }
        if (!d.f274478a.h(msgRecord)) {
            lastMsgData = null;
            return;
        }
        String e16 = e(msgRecord);
        if (e16 == null || e16.length() == 0) {
            z16 = true;
        }
        if (z16) {
            lastMsgData = null;
            return;
        }
        com.tencent.mobileqq.qqshop.message.db.a aVar = lastMsgData;
        if (aVar != null) {
            j3 = aVar.c();
        } else {
            j3 = 0;
        }
        long j17 = msgRecord.msgTime;
        if (j17 <= j3 && needInsertDB) {
            QLog.d("QQSHopMessageCache", 1, "insert msg but msgTime is same time=" + j17 + " lastMsgTime=" + j3);
            j16 = j3 + 1;
        } else {
            j16 = j17;
        }
        long j18 = msgRecord.msgId;
        f fVar = f.f274497a;
        com.tencent.mobileqq.qqshop.message.db.a aVar2 = new com.tencent.mobileqq.qqshop.message.db.a(j18, fVar.c(), j16, e16);
        lastMsgData = aVar2;
        if (needInsertDB) {
            com.tencent.mobileqq.ecshop.utils.e.f203954a.e(m(), aVar2.c());
            fVar.g(aVar2);
        }
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        boolean z16 = false;
        if (ecshopConfBean != null && ecshopConfBean.forbidPreloadMsg) {
            z16 = true;
        }
        if (z16) {
            QLog.d("QQSHopMessageCache", 4, "return: forbidPreloadMsg");
            return;
        }
        if (p()) {
            QLog.d("QQSHopMessageCache", 4, "return: is cache msg today ");
            return;
        }
        MessageMicro<QQShopMsgPB$GetDefaultReq> messageMicro = new MessageMicro<QQShopMsgPB$GetDefaultReq>() { // from class: com.tencent.mobileqq.qqshop.proto.QQShopMsgPB$GetDefaultReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQShopMsgPB$GetDefaultReq.class);
        };
        b bVar = new b();
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qqshop.adpush.PushService.SsoGetDefault callback: " + bVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qqshop.adpush.PushService.SsoGetDefault");
        newIntent.putExtra("data", fh.b(messageMicro.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new C8426a(bVar));
        waitAppRuntime.startServlet(newIntent);
        QLog.d("QQSHopMessageCache", 4, "updateCacheMsgData request trpc.qqshop.adpush.PushService.SsoGetDefault");
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.ecshop.utils.e eVar = com.tencent.mobileqq.ecshop.utils.e.f203954a;
        eVar.d(k(), eVar.a(k()) + 1);
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.ecshop.utils.e eVar = com.tencent.mobileqq.ecshop.utils.e.f203954a;
        int a16 = eVar.a(l()) + 1;
        eVar.d(l(), a16);
        com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.i().postValue(Integer.valueOf(a16));
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.ecshop.utils.e eVar = com.tencent.mobileqq.ecshop.utils.e.f203954a;
        int a16 = eVar.a(n()) + 1;
        eVar.d(n(), a16);
        com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.j().postValue(Integer.valueOf(a16));
    }
}

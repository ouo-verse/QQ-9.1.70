package b03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.pendant.proto.qcSubmallServer;
import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f27628a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f27629a;

        a(g gVar) {
            this.f27629a = gVar;
        }

        @Override // b03.c.h
        public void a(String str, @Nullable Exception exc) {
            if (exc == null) {
                QLog.e("AvatarPendantProxy", 1, str);
            } else {
                QLog.e("AvatarPendantProxy", 1, exc, new Object[0]);
                str = "crash happened";
            }
            this.f27629a.onError(str);
        }

        @Override // b03.c.h
        public void onSuccess(Object obj) {
            try {
                qcUserinfoServer.CheckItemRsp checkItemRsp = new qcUserinfoServer.CheckItemRsp();
                checkItemRsp.mergeFrom((byte[]) obj);
                if (checkItemRsp.rptItem.get() != null && !checkItemRsp.rptItem.get().isEmpty() && checkItemRsp.rptItem.get().size() > 0) {
                    this.f27629a.a(new b03.d(checkItemRsp.rptItem.get().get(0)));
                } else {
                    this.f27629a.onError("no data");
                }
            } catch (Exception e16) {
                QLog.e("AvatarPendantProxy", 1, e16, new Object[0]);
                this.f27629a.onError("convert error");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27630a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f27631b;

        b(int i3, f fVar) {
            this.f27630a = i3;
            this.f27631b = fVar;
        }

        @Override // b03.c.h
        public void a(String str, @Nullable Exception exc) {
            if (exc == null) {
                QLog.e("AvatarPendantProxy", 1, str);
            } else {
                QLog.e("AvatarPendantProxy", 1, exc, new Object[0]);
                str = "crash happened";
            }
            this.f27631b.onError(str);
        }

        @Override // b03.c.h
        public void onSuccess(Object obj) {
            try {
                qcSubmallServer.GetChiefListReply getChiefListReply = new qcSubmallServer.GetChiefListReply();
                getChiefListReply.mergeFrom((byte[]) obj);
                if (getChiefListReply.ret.get() == 0) {
                    ArrayList arrayList = new ArrayList();
                    for (qcSubmallServer.ModuleData moduleData : getChiefListReply.modData.get()) {
                        b03.b bVar = new b03.b();
                        bVar.f27627d = moduleData.cname.get();
                        String str = "";
                        if (moduleData.extModParams.get() != null && !moduleData.extModParams.get().isEmpty()) {
                            for (qcSubmallServer.MapEntry mapEntry : moduleData.extModParams.get()) {
                                if (mapEntry.key.get().equals("ContextSession")) {
                                    c.f27628a.put(this.f27630a + moduleData.cname.get(), mapEntry.value.get());
                                } else if (mapEntry.key.get().equals("str_ruleid")) {
                                    str = mapEntry.value.get();
                                }
                            }
                        }
                        c.e(bVar, c.i(moduleData.vitem.get(), str), 0, false);
                        arrayList.add(bVar);
                    }
                    this.f27631b.onSuccess(arrayList);
                    return;
                }
                this.f27631b.onError(getChiefListReply.ret.get() + getChiefListReply.errmsg.get());
            } catch (Exception e16) {
                QLog.e("AvatarPendantProxy", 1, e16, new Object[0]);
                this.f27631b.onError("convert error");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: b03.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C0082c implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27632a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27633b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f27634c;

        C0082c(int i3, String str, e eVar) {
            this.f27632a = i3;
            this.f27633b = str;
            this.f27634c = eVar;
        }

        @Override // b03.c.h
        public void a(String str, @Nullable Exception exc) {
            if (exc == null) {
                QLog.e("AvatarPendantProxy", 1, str);
            } else {
                QLog.e("AvatarPendantProxy", 1, exc, new Object[0]);
                str = "crash happened";
            }
            this.f27634c.onError(str);
        }

        @Override // b03.c.h
        public void onSuccess(Object obj) {
            boolean z16;
            try {
                qcSubmallServer.GetMoreListReply getMoreListReply = new qcSubmallServer.GetMoreListReply();
                getMoreListReply.mergeFrom((byte[]) obj);
                if (getMoreListReply.ret.get() == 0) {
                    b03.a aVar = new b03.a();
                    String str = "";
                    if (getMoreListReply.extParams.get() != null && !getMoreListReply.extParams.get().isEmpty()) {
                        for (qcSubmallServer.MapEntry mapEntry : getMoreListReply.extParams.get()) {
                            if (mapEntry.key.get().equals("ContextSession")) {
                                c.f27628a.put(this.f27632a + this.f27633b, mapEntry.value.get());
                            } else if (mapEntry.key.get().equals("str_ruleid")) {
                                str = mapEntry.value.get();
                            }
                        }
                    }
                    List i3 = c.i(getMoreListReply.itemList.get(), str);
                    int i16 = getMoreListReply.nextIndex.get();
                    if (getMoreListReply.isListEnd.get() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    c.e(aVar, i3, i16, z16);
                    this.f27634c.a(aVar);
                    return;
                }
                this.f27634c.onError(getMoreListReply.ret.get() + getMoreListReply.errmsg.get());
            } catch (Exception e16) {
                QLog.e("AvatarPendantProxy", 1, e16, new Object[0]);
                this.f27634c.onError("convert error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f27635d;

        d(h hVar) {
            this.f27635d = hVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                this.f27635d.onSuccess(obj);
            } else {
                this.f27635d.a("request fail", null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void a(b03.a aVar);

        void onError(String str);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        void onError(String str);

        void onSuccess(List<b03.b> list);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface g {
        void a(b03.d dVar);

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface h {
        void a(String str, @Nullable Exception exc);

        void onSuccess(Object obj);
    }

    public static void d(int i3, long j3, g gVar) {
        qcUserinfoServer.LoginInfo loginInfo = new qcUserinfoServer.LoginInfo();
        loginInfo.opplat.set(2);
        loginInfo.qqVer.set(BaseApplication.reportVersionName);
        qcUserinfoServer.ItemBasic itemBasic = new qcUserinfoServer.ItemBasic();
        itemBasic.itemid.set(j3);
        itemBasic.appid.set(i3);
        qcUserinfoServer.CheckItemReq checkItemReq = new qcUserinfoServer.CheckItemReq();
        checkItemReq.stLogin.set(loginInfo);
        checkItemReq.rptItem.set(Collections.singletonList(itemBasic));
        f("trpc.qqva.qc_userinfo_server.QcUserinfoServer.SsoCheckUniItem", checkItemReq, new a(gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(b03.a aVar, List<AvatarPendantItem> list, int i3, boolean z16) {
        aVar.f27624a = list;
        aVar.f27625b = i3;
        aVar.f27626c = z16;
    }

    private static void f(String str, MessageMicro<?> messageMicro, h hVar) {
        try {
            VasUtil.getService().getPbRequest().request(str, new String(messageMicro.toByteArray(), "ISO8859_1"), new d(hVar));
        } catch (UnsupportedEncodingException e16) {
            hVar.a("", e16);
        }
    }

    public static void g(int i3, f fVar) {
        qcSubmallServer.GetChiefListRequest getChiefListRequest = new qcSubmallServer.GetChiefListRequest();
        getChiefListRequest.appid.set(i3);
        qcSubmallServer.LoginInfo loginInfo = new qcSubmallServer.LoginInfo();
        loginInfo.sClientVer.set(BaseApplication.reportVersionName);
        loginInfo.iOpplat.set(2);
        getChiefListRequest.stLogin.set(loginInfo);
        qcSubmallServer.MapEntry mapEntry = new qcSubmallServer.MapEntry();
        mapEntry.key.set("scene");
        mapEntry.value.set("native");
        qcSubmallServer.MapEntry mapEntry2 = new qcSubmallServer.MapEntry();
        mapEntry2.key.set("modsize");
        mapEntry2.value.set("21");
        getChiefListRequest.mParams.set(Arrays.asList(mapEntry, mapEntry2));
        f("trpc.qqva.qc_submall_server.qc_submall_server.SsoGetChiefList", getChiefListRequest, new b(i3, fVar));
    }

    public static void h(int i3, int i16, int i17, String str, e eVar) {
        qcSubmallServer.GetMoreListRequest getMoreListRequest = new qcSubmallServer.GetMoreListRequest();
        getMoreListRequest.appid.set(i3);
        getMoreListRequest.listindex.set(i16);
        getMoreListRequest.pagesize.set(i17);
        getMoreListRequest.modName.set(str);
        qcSubmallServer.LoginInfo loginInfo = new qcSubmallServer.LoginInfo();
        loginInfo.sClientVer.set(BaseApplication.reportVersionName);
        loginInfo.iOpplat.set(2);
        getMoreListRequest.stLogin.set(loginInfo);
        qcSubmallServer.MapEntry mapEntry = new qcSubmallServer.MapEntry();
        mapEntry.key.set("scene");
        mapEntry.value.set("native");
        qcSubmallServer.MapEntry mapEntry2 = new qcSubmallServer.MapEntry();
        mapEntry2.key.set("ContextSession");
        String str2 = f27628a.get(i3 + str);
        PBStringField pBStringField = mapEntry2.value;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField.set(str2);
        getMoreListRequest.mParams.set(Arrays.asList(mapEntry, mapEntry2));
        f("trpc.qqva.qc_submall_server.qc_submall_server.SsoGetMoreList", getMoreListRequest, new C0082c(i3, str, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AvatarPendantItem> i(@NonNull List<qcSubmallServer.SubmallPreviewItem> list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<qcSubmallServer.SubmallPreviewItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new AvatarPendantItem(it.next(), str));
        }
        return arrayList;
    }
}

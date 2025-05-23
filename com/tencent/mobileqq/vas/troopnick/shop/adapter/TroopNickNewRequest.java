package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.pendant.proto.qcSubmallServer;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopNickNewRequest implements com.tencent.mobileqq.vas.troopnick.shop.adapter.b {

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f311061d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private int f311062a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.mobileqq.vas.troopnick.shop.widget.a f311063b;

    /* renamed from: c, reason: collision with root package name */
    private long f311064c;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickNewRequest.c
        public void a(String str, @Nullable Exception exc) {
            if (exc == null) {
                QLog.e("TroopNickNewRequest", 1, str);
            } else {
                QLog.e("TroopNickNewRequest", 1, exc, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickNewRequest.c
        public void onSuccess(Object obj) {
            try {
                qcSubmallServer.GetChiefListReply getChiefListReply = new qcSubmallServer.GetChiefListReply();
                getChiefListReply.mergeFrom((byte[]) obj);
                if (getChiefListReply.ret.get() == 0) {
                    e[] eVarArr = new e[getChiefListReply.modData.size()];
                    for (int i3 = 0; i3 < getChiefListReply.modData.size(); i3++) {
                        qcSubmallServer.ModuleData moduleData = getChiefListReply.modData.get(i3);
                        e eVar = new e();
                        eVar.f311085d = moduleData.cname.get();
                        String str = "";
                        if (moduleData.extModParams.get() != null && !moduleData.extModParams.get().isEmpty()) {
                            for (qcSubmallServer.MapEntry mapEntry : moduleData.extModParams.get()) {
                                if (mapEntry.key.get().equals("ContextSession")) {
                                    TroopNickNewRequest.f311061d.put(TroopNickNewRequest.this.f311062a + moduleData.cname.get(), mapEntry.value.get());
                                } else if (mapEntry.key.get().equals("str_ruleid")) {
                                    str = mapEntry.value.get();
                                }
                            }
                        }
                        TroopNickNewRequest.e(eVar, TroopNickNewRequest.g(moduleData.vitem.get(), str), 0, false);
                        eVarArr[i3] = eVar;
                    }
                    TroopNickNewRequest.this.h(eVarArr);
                }
            } catch (Exception e16) {
                QLog.e("TroopNickNewRequest", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f311067d;

        b(c cVar) {
            this.f311067d = cVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                this.f311067d.onSuccess(obj);
            } else {
                this.f311067d.a("request fail", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void a(String str, @Nullable Exception exc);

        void onSuccess(Object obj);
    }

    public TroopNickNewRequest(int i3, long j3, com.tencent.mobileqq.vas.troopnick.shop.widget.a aVar) {
        this.f311062a = i3;
        this.f311063b = aVar;
        this.f311064c = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(e eVar, List<AvatarPendantItem> list, int i3, boolean z16) {
        eVar.f311082a = list;
        eVar.f311083b = i3;
        eVar.f311084c = z16;
    }

    private void f(String str, MessageMicro<?> messageMicro, c cVar) {
        try {
            VasUtil.getService().getPbRequest().request(str, new String(messageMicro.toByteArray(), "ISO8859_1"), new b(cVar));
        } catch (UnsupportedEncodingException e16) {
            cVar.a("", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AvatarPendantItem> g(@NonNull List<qcSubmallServer.SubmallPreviewItem> list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<qcSubmallServer.SubmallPreviewItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new AvatarPendantItem(it.next(), str));
        }
        return arrayList;
    }

    public void h(final Object obj) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickNewRequest.1
            @Override // java.lang.Runnable
            public void run() {
                TroopNickNewRequest.this.f311063b.E((Object[]) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.b
    public void request() {
        qcSubmallServer.GetChiefListRequest getChiefListRequest = new qcSubmallServer.GetChiefListRequest();
        getChiefListRequest.appid.set(this.f311062a);
        getChiefListRequest.locationtype.set(3);
        getChiefListRequest.lUid.set(this.f311064c);
        qcSubmallServer.LoginInfo loginInfo = new qcSubmallServer.LoginInfo();
        loginInfo.sClientVer.set(BaseApplication.reportVersionName);
        loginInfo.iOpplat.set(2);
        getChiefListRequest.stLogin.set(loginInfo);
        f("trpc.qqva.qc_submall_server.qc_submall_server.SsoGetChiefList", getChiefListRequest, new a());
    }

    @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.b
    public void loadMore() {
    }
}

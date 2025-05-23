package lw0;

import az0.b;
import az0.c;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yv0.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static c f415668e;

    /* renamed from: f, reason: collision with root package name */
    private static List<e<c>> f415669f = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveSsoProxyModule f415670a;

    /* renamed from: c, reason: collision with root package name */
    private long f415672c;

    /* renamed from: b, reason: collision with root package name */
    private boolean f415671b = false;

    /* renamed from: d, reason: collision with root package name */
    private IAegisLogApi f415673d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: lw0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C10750a implements IQQLiveProxySsoObserver {
        C10750a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onFail(int i3, String str) {
            a.this.f415673d.e("ICGameUniteDialog", 1, "getPayGuideConfig errCode: " + i3 + ", errMsg: " + str);
            Iterator it = a.f415669f.iterator();
            while (it.hasNext()) {
                ((e) it.next()).fail(i3, str);
            }
            a.f415669f.clear();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onReceive(byte[] bArr) {
            if (!a.this.f415671b) {
                a.this.f();
            } else {
                a.this.i(bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        f415668e = null;
        f415669f.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(byte[] bArr) {
        try {
            f415668e = c.c(bArr);
            Iterator<e<c>> it = f415669f.iterator();
            while (it.hasNext()) {
                it.next().success(f415668e);
            }
        } catch (InvalidProtocolBufferNanoException e16) {
            this.f415673d.e("ICGameUniteDialog", 1, "sendQQLiveProxyReq onReceive, e: " + e16 + ", isInRoom: " + this.f415671b);
            Iterator<e<c>> it5 = f415669f.iterator();
            while (it5.hasNext()) {
                it5.next().fail(-1, "parse data exception");
            }
        }
        f415669f.clear();
    }

    public void g(int i3, long j3, e<c> eVar) {
        this.f415673d.i("ICGameUniteDialog", 1, "getPayGuideConfig roomType=" + i3 + ",roomId=" + j3);
        this.f415672c = j3;
        c cVar = f415668e;
        if (cVar != null) {
            eVar.success(cVar);
            return;
        }
        f415669f.add(eVar);
        if (f415669f.size() > 1) {
            this.f415673d.e("ICGameUniteDialog", 1, "getPayGuideConfig is requesting...");
            return;
        }
        b bVar = new b();
        bVar.f27367a = j3;
        bVar.f27368b = i3;
        byte[] byteArray = MessageNano.toByteArray(bVar);
        IQQLiveSsoProxyModule iQQLiveSsoProxyModule = this.f415670a;
        if (iQQLiveSsoProxyModule != null && this.f415671b) {
            iQQLiveSsoProxyModule.sendQQLiveProxyReq("trpc.qlive.activity.ActivityPop", "GetActivityPopConf", byteArray, new C10750a());
            return;
        }
        this.f415673d.e("ICGameUniteDialog", 1, "getPayGuideConfig error, ssoProxy: " + this.f415670a + ", isInRoom: " + this.f415671b);
        f();
    }

    public void h() {
        this.f415671b = false;
        f();
    }

    public void j(IQQLiveSsoProxyModule iQQLiveSsoProxyModule) {
        this.f415670a = iQQLiveSsoProxyModule;
        this.f415671b = true;
    }
}

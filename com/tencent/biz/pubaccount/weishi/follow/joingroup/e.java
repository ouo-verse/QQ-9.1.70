package com.tencent.biz.pubaccount.weishi.follow.joingroup;

import UserGrowth.stQQGroupDetailRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.net.g;
import com.tencent.biz.pubaccount.weishi.net.j;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.util.x;
import i10.h;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f80746b;

    /* renamed from: a, reason: collision with root package name */
    private String f80747a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f80748a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f80749b;

        a(b bVar, String str) {
            this.f80748a = bVar;
            this.f80749b = str;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            j jVar;
            b bVar;
            WeakReference weakReference = new WeakReference(this.f80748a);
            if (lVar == null || (jVar = lVar.f80994g) == null || !TextUtils.equals(jVar.C, e.this.f80747a) || (bVar = (b) weakReference.get()) == null || !bVar.c()) {
                return;
            }
            bVar.dismissLoading();
            if (lVar.d()) {
                Object obj = lVar.f80999l;
                if (obj instanceof stQQGroupDetailRsp) {
                    stQQGroupDetailRsp stqqgroupdetailrsp = (stQQGroupDetailRsp) obj;
                    if (stqqgroupdetailrsp.status == 0) {
                        x.j("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response :  msg = " + stqqgroupdetailrsp.f25123msg + ", code = " + stqqgroupdetailrsp.status + "; signature = " + stqqgroupdetailrsp.signature);
                        bVar.b(this.f80749b, stqqgroupdetailrsp.signature);
                        return;
                    }
                }
                x.j("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : response is not instanceof stQQGroupDetailRsp");
                bVar.a();
                return;
            }
            x.j("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : !task.succeeded()");
            bVar.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a();

        void b(String str, String str2);

        boolean c();

        void dismissLoading();

        void showLoading();
    }

    e() {
    }

    public static e b() {
        if (f80746b == null) {
            synchronized (e.class) {
                if (f80746b == null) {
                    f80746b = new e();
                }
            }
        }
        return f80746b;
    }

    private com.tencent.biz.pubaccount.weishi.net.c c(String str, b bVar) {
        return new a(bVar, str);
    }

    public void d(String str, String str2, b bVar) {
        x.j("WSJoinGroupDataProcessor", "requestGroupSign: UserConfig request  groupId = " + str);
        this.f80747a = str;
        if (bVar != null) {
            bVar.showLoading();
        }
        h hVar = new h(str, str2);
        hVar.C = str;
        g.b().g(new l(hVar, null, c(str, bVar), 4014));
    }
}

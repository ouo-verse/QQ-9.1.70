package jz;

import UserGrowth.stBlockRecommPersonRsp;
import UserGrowth.stFollowRsp;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.request.ChangeFollowRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements com.tencent.biz.pubaccount.weishi.net.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            Object obj = lVar.f80999l;
            if (!(obj instanceof stBlockRecommPersonRsp)) {
                x.b("WSUserBusiness", "[actionBlockRecommendPerson] data error: " + lVar.f80999l);
                return;
            }
            stBlockRecommPersonRsp stblockrecommpersonrsp = (stBlockRecommPersonRsp) obj;
            if (stblockrecommpersonrsp != null) {
                x.b("WSUserBusiness", "[actionBlockRecommendPerson] data success resultBean.ret:" + stblockrecommpersonrsp.ret);
            }
        }
    }

    private com.tencent.biz.pubaccount.weishi.net.common.b<stFollowRsp, stFollowRsp> d(String str, int i3) {
        return new b(i3, str);
    }

    public static g e() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i3) {
        FollowEvent followEvent = new FollowEvent();
        followEvent.setPersonId(str);
        if (i3 == 1) {
            followEvent.setIsFollow(1);
        } else {
            followEvent.setIsFollow(2);
        }
        wz.b.b().a(followEvent);
    }

    public void b(String str) {
        x.b("WSUserBusiness", "[actionBlockRecommendPerson] personID : " + str);
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new i10.a(str), null, new a(), 4006));
    }

    public void c(String str, int i3) {
        x.b("WSUserBusiness", "[actionChangeFollow] personID : " + str + "  followStatus:" + i3);
        f(str, i3);
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new ChangeFollowRequest(str, i3)).b(d(str, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stFollowRsp, stFollowRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f411229a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f411230b;

        b(int i3, String str) {
            this.f411229a = i3;
            this.f411230b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
            super.b(jVar);
            if (this.f411229a == 2) {
                g.this.f(this.f411230b, 1);
            } else {
                g.this.f(this.f411230b, 2);
            }
            x.b("WSUserBusiness", "[getServiceListenerWrapper] data error: " + jVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stFollowRsp stfollowrsp) {
            super.d(stfollowrsp);
            int i3 = stfollowrsp.isFollow;
            x.b("WSUserBusiness", "[getServiceListenerWrapper] isFollow : " + i3);
            if (this.f411229a == 1) {
                if (i3 == 1) {
                    ToastUtil.a().b(R.string.f241897t4);
                    return;
                } else {
                    ToastUtil.a().b(R.string.f241877t2);
                    g.this.f(this.f411230b, 2);
                    return;
                }
            }
            if (i3 == 0) {
                ToastUtil.a().b(R.string.f241917t6);
            } else {
                ToastUtil.a().b(R.string.f241927t7);
                g.this.f(this.f411230b, 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stFollowRsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stFollowRsp> gVar, stFollowRsp stfollowrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return stfollowrsp;
        }
    }
}

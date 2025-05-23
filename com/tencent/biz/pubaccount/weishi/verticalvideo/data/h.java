package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private String f82005a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f82006b;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f82007a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f82008b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ jz.c f82009c;

        a(boolean z16, boolean z17, jz.c cVar) {
            this.f82007a = z16;
            this.f82008b = z17;
            this.f82009c = cVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            h.this.d(this.f82007a, this.f82008b, lVar, this.f82009c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final h f82011a = new h();
    }

    h() {
    }

    public static h c() {
        return b.f82011a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z16, boolean z17, l lVar, jz.c<j> cVar) {
        if (!lVar.d()) {
            x.f("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] failed code:" + lVar.f80991d + ", msg:" + lVar.f80990c);
            if (cVar != null) {
                cVar.i(lVar.f80991d, lVar.f80990c, z16, z17);
                return;
            }
            return;
        }
        Object obj = lVar.f80999l;
        if (obj instanceof stFriendFeedRsp) {
            stFriendFeedRsp stfriendfeedrsp = (stFriendFeedRsp) obj;
            boolean z18 = stfriendfeedrsp.isFinished == 1;
            this.f82006b = z18;
            stFriendFeed stfriendfeed = stfriendfeedrsp.friendFeed;
            if (stfriendfeed != null) {
                this.f82005a = stfriendfeed.attachInfo;
                List<j> e16 = i.e(stfriendfeed.friendFeeds, z18);
                x.j("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:" + e16.size() + ", mAttachInfo:" + this.f82005a + ", mIsFinished:" + this.f82006b);
                if (cVar != null) {
                    cVar.d0(e16, false, false, null);
                    return;
                }
                return;
            }
            x.f("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
            if (cVar != null) {
                cVar.i(lVar.f80992e, "stFriendFeed is null!", z16, z17);
                return;
            }
            return;
        }
        x.f("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
        if (cVar != null) {
            cVar.i(lVar.f80992e, lVar.f80990c, z16, z17);
        }
    }

    public void b(boolean z16, boolean z17, jz.c<j> cVar) {
        if (this.f82006b) {
            x.j("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
            return;
        }
        a aVar = new a(z16, z17, cVar);
        x.j("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][fetchData] attachInfo:" + this.f82005a);
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new i10.c(this.f82005a), null, aVar, 4012));
    }

    public void f(String str) {
        this.f82005a = str;
        x.j("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:" + str);
    }

    public void e() {
        this.f82006b = false;
    }
}

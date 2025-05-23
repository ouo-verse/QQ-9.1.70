package k00;

import NS_KING_INTERFACE.stPostFeedDingRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.PostFeedDingRequest;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, f> f411333a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, k00.b> f411334b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f411339a = new e();
    }

    private k00.b d(String str) {
        k00.b bVar = this.f411334b.get(str);
        if (bVar != null) {
            return bVar;
        }
        k00.b bVar2 = new k00.b();
        this.f411334b.put(str, bVar2);
        return bVar2;
    }

    public static e e() {
        return b.f411339a;
    }

    private f f(String str) {
        f fVar = this.f411333a.get(str);
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f();
        this.f411333a.put(str, fVar2);
        return fVar2;
    }

    private void h(String str, String str2, int i3, int i16) {
        LikeRspEvent likeRspEvent = new LikeRspEvent(str, str2, i3);
        likeRspEvent.setRpsStatus(LikeRspEvent.REQUEST_POST_DING_SUCCESS);
        likeRspEvent.setRspIsDing(i16);
        wz.b.b().a(likeRspEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, LikeRspEvent likeRspEvent, int i3) {
        Map<String, f> map;
        f fVar;
        if (!TextUtils.isEmpty(str) && (map = this.f411333a) != null && map.size() > 0 && (fVar = this.f411333a.get(str)) != null) {
            l(fVar.b(), fVar.e(), fVar.d(), fVar.c());
        }
        likeRspEvent.setRpsStatus(LikeRspEvent.REQUEST_POST_DING_FAILED);
        likeRspEvent.setRspIsDing(i3);
    }

    public void g(String str) {
        k00.b bVar;
        f fVar;
        Map<String, f> map = this.f411333a;
        if (map != null && (fVar = map.get(str)) != null) {
            fVar.f();
            this.f411333a.remove(fVar);
        }
        Map<String, k00.b> map2 = this.f411334b;
        if (map2 == null || (bVar = map2.get(str)) == null) {
            return;
        }
        bVar.c();
        this.f411334b.remove(bVar);
    }

    public void j() {
        Map<String, f> map = this.f411333a;
        if (map != null) {
            map.clear();
        }
        Map<String, k00.b> map2 = this.f411334b;
        if (map2 != null) {
            map2.clear();
        }
    }

    private void i(String str, String str2, boolean z16, int i3) {
        int i16;
        if (z16) {
            i16 = 1;
        } else {
            x.i("WSLikeAnimationManger", "\u6b64\u6b21\u662f\u53d6\u6d88\u70b9\u8d5e\uff1a---------------");
            i16 = 2;
        }
        h(str, str2, i3, z16 ? 1 : 0);
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new PostFeedDingRequest(str2, i16)).b(new a(new LikeRspEvent(str, str2, i3), str2, z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l(stSimpleMetaFeed stsimplemetafeed, TextView textView, View view, View view2) {
        if (stsimplemetafeed == null) {
            x.f("WSLikeAnimationManger", "resetLikeSate\uff1ais null");
            return;
        }
        char c16 = stsimplemetafeed.is_ding == 1 ? (char) 1 : (char) 0;
        if (c16 != 0) {
            stsimplemetafeed.ding_count--;
        } else {
            stsimplemetafeed.ding_count++;
        }
        boolean z16 = c16 ^ 1;
        stsimplemetafeed.is_ding = z16 ? 1 : 0;
        if (view != null) {
            view.setSelected(z16);
        }
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (textView != null) {
            int i3 = stsimplemetafeed.ding_count;
            if (i3 > 0) {
                WSNumUtil.d(textView, i3, "0");
            } else {
                textView.setText("\u8d5e");
            }
        }
    }

    private void m(stSimpleMetaFeed stsimplemetafeed, String str, boolean z16, int i3, int i16, TextView textView, View view, View view2) {
        x.i("WSLikeAnimationManger", "doClickLike" + z16);
        if (TextUtils.isEmpty(str)) {
            x.i("WSLikeAnimationManger", "feedId\uff1ais null");
            return;
        }
        if (view != null && view2 != null) {
            f(str).a(stsimplemetafeed, view, view2, textView, i3, z16);
        }
        i(stsimplemetafeed.poster_id, str, z16, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(stSimpleMetaFeed stsimplemetafeed, int i3, TextView textView, View view, View view2, ViewGroup viewGroup, boolean z16) {
        char c16 = stsimplemetafeed.is_ding == 1 ? (char) 1 : (char) 0;
        if (c16 != 0) {
            stsimplemetafeed.ding_count--;
        } else {
            stsimplemetafeed.ding_count++;
        }
        boolean z17 = c16 ^ 1;
        stsimplemetafeed.is_ding = z17 ? 1 : 0;
        m(stsimplemetafeed, stsimplemetafeed.f25129id, z17, stsimplemetafeed.ding_count, i3, textView, view, view2);
        if (!z16 || z17 == 0 || viewGroup == null) {
            return;
        }
        d(stsimplemetafeed.f25129id).d(viewGroup, viewGroup.getMeasuredWidth() / 2, viewGroup.getMeasuredHeight() / 2);
    }

    public void c(stSimpleMetaFeed stsimplemetafeed, int i3, int i16, int i17, TextView textView, View view, View view2, ViewGroup viewGroup, boolean z16) {
        if (stsimplemetafeed == null) {
            x.f("WSLikeAnimationManger", "feed\uff1ais null");
            return;
        }
        String str = stsimplemetafeed.f25129id;
        if (TextUtils.isEmpty(str)) {
            x.f("WSLikeAnimationManger", "feedId\uff1ais null");
            return;
        }
        boolean z17 = stsimplemetafeed.is_ding == 1;
        if (!z17) {
            stsimplemetafeed.ding_count++;
            stsimplemetafeed.is_ding = 1;
        }
        if (z16 && viewGroup != null) {
            d(str).d(viewGroup, i16, i17);
        }
        if (z17) {
            return;
        }
        m(stsimplemetafeed, str, true, stsimplemetafeed.ding_count, i3, textView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stPostFeedDingRsp, stPostFeedDingRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LikeRspEvent f411335a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f411336b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f411337c;

        a(LikeRspEvent likeRspEvent, String str, boolean z16) {
            this.f411335a = likeRspEvent;
            this.f411336b = str;
            this.f411337c = z16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
            super.b(jVar);
            x.i("WSLikeAnimationManger", "\u70b9\u8d5e\u5931\u8d25:" + jVar.toString());
            e.this.k(this.f411336b, this.f411335a, !this.f411337c ? 1 : 0);
            this.f411335a.setFromRsp(true);
            wz.b.b().a(this.f411335a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stPostFeedDingRsp stpostfeeddingrsp) {
            super.d(stpostfeeddingrsp);
            int i3 = stpostfeeddingrsp.is_ding;
            this.f411335a.setRpsStatus(LikeRspEvent.REQUEST_POST_DING_SUCCESS);
            this.f411335a.setRspIsDing(i3);
            this.f411335a.setFromRsp(true);
            if (i3 == 0) {
                x.i("WSLikeAnimationManger", "\u8bf7\u6c42\u540e\u53d8\u6210\uff1a\u6ca1\u6709\u70b9\u8d5e-by\u5fae\u89c6");
            } else {
                x.i("WSLikeAnimationManger", "\u8bf7\u6c42\u540e\u53d8\u6210\uff1a\u5df2\u7ecf\u70b9\u8d5e-by\u5fae\u89c6");
            }
            wz.b.b().a(this.f411335a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stPostFeedDingRsp c(g<stPostFeedDingRsp> gVar, stPostFeedDingRsp stpostfeeddingrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return stpostfeeddingrsp;
        }
    }
}

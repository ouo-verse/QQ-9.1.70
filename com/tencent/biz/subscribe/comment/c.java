package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetCommentListRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoCommentRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoLikeRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoReplyRsp;
import NS_COMM.COMM;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.network.DoCommentRequest;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.network.DoReplyReq;
import com.tencent.biz.subscribe.network.GetCommentListRequest;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f95975e = "c";

    /* renamed from: a, reason: collision with root package name */
    private Handler f95976a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ArrayList<CertifiedAccountMeta$StComment>> f95977b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Integer> f95978c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, j> f95979d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetFeedDetailRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ COMM.StCommonExt f95980a;

        a(COMM.StCommonExt stCommonExt) {
            this.f95980a = stCommonExt;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp) {
            c.this.v(z16, j3, str, certifiedAccountRead$StGetFeedDetailRsp, this.f95980a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements OnTaskListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VSDispatchObserver.OnVSRspCallBack f95982a;

        b(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
            this.f95982a = onVSRspCallBack;
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            long j3;
            String str;
            CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp;
            if (objArr != null && objArr.length == 4) {
                boolean z16 = false;
                Object obj = objArr[0];
                Object obj2 = objArr[1];
                Object obj3 = objArr[2];
                Object obj4 = objArr[3];
                if (obj instanceof Boolean) {
                    z16 = ((Boolean) obj).booleanValue();
                }
                boolean z17 = z16;
                if (obj2 instanceof QFSNumberConstants.Long) {
                    j3 = ((Long) obj2).longValue();
                } else {
                    j3 = 0;
                }
                long j16 = j3;
                if (obj3 instanceof String) {
                    str = obj3.toString();
                } else {
                    str = "";
                }
                String str2 = str;
                if (obj4 instanceof CertifiedAccountRead$StGetFeedDetailRsp) {
                    certifiedAccountRead$StGetFeedDetailRsp = (CertifiedAccountRead$StGetFeedDetailRsp) obj4;
                } else {
                    certifiedAccountRead$StGetFeedDetailRsp = null;
                }
                this.f95982a.onReceive(null, z17, j16, str2, certifiedAccountRead$StGetFeedDetailRsp);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.comment.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0965c implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95984a;

        C0965c(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
            this.f95984a = certifiedAccountMeta$StComment;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoCommentRsp certifiedAccountWrite$StDoCommentRsp) {
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(3, Long.valueOf(j3), str, certifiedAccountWrite$StDoCommentRsp, this.f95984a.f24924id.get(), Integer.valueOf(c.this.hashCode())));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95986a;

        d(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
            this.f95986a = certifiedAccountMeta$StComment;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoCommentRsp certifiedAccountWrite$StDoCommentRsp) {
            CertifiedAccountMeta$StComment certifiedAccountMeta$StComment;
            if (certifiedAccountWrite$StDoCommentRsp != null && (certifiedAccountMeta$StComment = this.f95986a) != null) {
                certifiedAccountWrite$StDoCommentRsp.comment.f24924id.set(certifiedAccountMeta$StComment.f24924id.get());
            }
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(5, Long.valueOf(j3), str, certifiedAccountWrite$StDoCommentRsp, Integer.valueOf(c.this.hashCode())));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoReplyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95988a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StReply f95989b;

        e(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
            this.f95988a = certifiedAccountMeta$StComment;
            this.f95989b = certifiedAccountMeta$StReply;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoReplyRsp certifiedAccountWrite$StDoReplyRsp) {
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(4, Long.valueOf(j3), str, certifiedAccountWrite$StDoReplyRsp, this.f95988a, this.f95989b.f24928id.get(), Integer.valueOf(c.this.hashCode())));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoReplyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StReply f95991a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StComment f95992b;

        f(CertifiedAccountMeta$StReply certifiedAccountMeta$StReply, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
            this.f95991a = certifiedAccountMeta$StReply;
            this.f95992b = certifiedAccountMeta$StComment;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoReplyRsp certifiedAccountWrite$StDoReplyRsp) {
            CertifiedAccountMeta$StReply certifiedAccountMeta$StReply;
            if (certifiedAccountWrite$StDoReplyRsp != null && (certifiedAccountMeta$StReply = this.f95991a) != null) {
                certifiedAccountWrite$StDoReplyRsp.reply.f24928id.set(certifiedAccountMeta$StReply.f24928id.get());
            }
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(6, Long.valueOf(j3), str, certifiedAccountWrite$StDoReplyRsp, this.f95992b, Integer.valueOf(c.this.hashCode())));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoLikeRsp> {
        g() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoLikeRsp certifiedAccountWrite$StDoLikeRsp) {
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(7, Long.valueOf(j3), str, certifiedAccountWrite$StDoLikeRsp));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoLikeRsp> {
        h() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoLikeRsp certifiedAccountWrite$StDoLikeRsp) {
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(7, Long.valueOf(j3), str, certifiedAccountWrite$StDoLikeRsp));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class i implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountRead$StGetCommentListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StFeed f95996a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f95997b;

        i(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, String str) {
            this.f95996a = certifiedAccountMeta$StFeed;
            this.f95997b = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountRead$StGetCommentListRsp certifiedAccountRead$StGetCommentListRsp) {
            boolean z17;
            c.this.A(this.f95996a.f24925id.get(), true);
            if (certifiedAccountRead$StGetCommentListRsp == null) {
                QLog.d(c.f95975e, 1, "getCommentSize: rsp is null");
                return;
            }
            if (c.this.f95977b.get(this.f95996a.f24925id.get()) != null) {
                QLog.d(c.f95975e, 2, "getCommentSize:" + certifiedAccountRead$StGetCommentListRsp.vecComment.size() + ", attachInfo:" + certifiedAccountRead$StGetCommentListRsp.extInfo.attachInfo.get() + "isFinish\uff1a" + certifiedAccountRead$StGetCommentListRsp.isFinish.get());
                ((ArrayList) c.this.f95977b.get(this.f95996a.f24925id.get())).addAll(c.this.p(certifiedAccountRead$StGetCommentListRsp.vecComment.get(), this.f95997b));
            }
            c cVar = c.this;
            String str2 = this.f95996a.f24925id.get();
            COMM.StCommonExt stCommonExt = certifiedAccountRead$StGetCommentListRsp.extInfo;
            if (certifiedAccountRead$StGetCommentListRsp.isFinish.get() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            cVar.z(str2, stCommonExt, z17, true);
            com.tencent.biz.qqstory.base.c.a().dispatch(c.this.u(9, Long.valueOf(j3), str, certifiedAccountRead$StGetCommentListRsp, Integer.valueOf(c.this.hashCode()), this.f95997b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public boolean f95999a;

        /* renamed from: b, reason: collision with root package name */
        public COMM.StCommonExt f96000b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f96001c;

        j() {
        }

        public String toString() {
            return "CommentResponse{hasMore=" + this.f95999a + ", attachInfo='" + this.f96000b.attachInfo.get() + "', hasResponse='" + this.f96001c + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, boolean z16) {
        Map<String, j> map = this.f95979d;
        if (map != null && map.get(str) != null) {
            this.f95979d.get(str).f96001c = z16;
        }
    }

    private String k(COMM.StCommonExt stCommonExt) {
        if (stCommonExt != null && stCommonExt.mapInfo.size() > 0) {
            return stCommonExt.mapInfo.get(0).value.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16, long j3, String str, CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, COMM.StCommonExt stCommonExt) {
        ArrayList<CertifiedAccountMeta$StComment> arrayList;
        if (certifiedAccountRead$StGetFeedDetailRsp != null) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = certifiedAccountRead$StGetFeedDetailRsp.feed;
            String str2 = certifiedAccountMeta$StFeed.f24925id.get();
            z(str2, certifiedAccountRead$StGetFeedDetailRsp.extInfo, true, true);
            if (certifiedAccountMeta$StFeed.vecComment.size() > 0) {
                arrayList = (ArrayList) q((ArrayList) certifiedAccountMeta$StFeed.vecComment.get(), k(stCommonExt), 1);
                this.f95978c.put(str2, Integer.valueOf(certifiedAccountMeta$StFeed.commentCount.get()));
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>(0);
                this.f95978c.put(str2, 0);
            }
            this.f95977b.put(str2, arrayList);
            certifiedAccountRead$StGetFeedDetailRsp.feed.vecComment.set(arrayList);
            if (t(str2) == 0) {
                QZLog.e(f95975e, 1, "\u540e\u53f0\u8fd4\u56de\u8bc4\u8bba\u6570\u4e3a0");
            }
            com.tencent.biz.qqstory.base.c.a().dispatch(new com.tencent.biz.subscribe.comment.d(5, str2, Integer.valueOf(t(str2))));
        }
        com.tencent.biz.qqstory.base.c.a().dispatch(u(2, Long.valueOf(j3), str, certifiedAccountRead$StGetFeedDetailRsp, Integer.valueOf(hashCode()), stCommonExt));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, COMM.StCommonExt stCommonExt, boolean z16, boolean z17) {
        if (this.f95979d.get(str) == null) {
            j jVar = new j();
            jVar.f96000b = stCommonExt;
            jVar.f95999a = z16;
            jVar.f96001c = z17;
            this.f95979d.put(str, jVar);
            QLog.d(f95975e, 1, "getDetailCommentSize: attachInfo:" + stCommonExt.attachInfo.get());
            return;
        }
        this.f95979d.get(str).f95999a = z16;
        this.f95979d.get(str).f96000b = stCommonExt;
    }

    public long f(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        VSNetworkHelper.getInstance().sendRequest(new DoReplyReq(certifiedAccountMeta$StFeed, certifiedAccountMeta$StComment, certifiedAccountMeta$StReply, 1), new e(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply));
        return 0L;
    }

    public void g(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        VSNetworkHelper.getInstance().sendRequest(new DoCommentRequest(certifiedAccountMeta$StFeed, certifiedAccountMeta$StComment, 1), new C0965c(certifiedAccountMeta$StComment));
    }

    public String h(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        if (certifiedAccountMeta$StReply != null && !certifiedAccountMeta$StReply.f24928id.get().startsWith(ISelectMemberActivityConstants.FAKE_ID)) {
            VSNetworkHelper.getInstance().sendRequest(new DoReplyReq(certifiedAccountMeta$StFeed, certifiedAccountMeta$StComment, certifiedAccountMeta$StReply, 0), new f(certifiedAccountMeta$StReply, certifiedAccountMeta$StComment));
            return certifiedAccountMeta$StReply.f24928id.get();
        }
        com.tencent.biz.qqstory.base.c.a().dispatch(u(5, -1L, HardCodeUtil.qqStr(R.string.ksv), null));
        return "";
    }

    public String i(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        if (certifiedAccountMeta$StComment != null && !certifiedAccountMeta$StComment.f24924id.get().startsWith(ISelectMemberActivityConstants.FAKE_ID)) {
            VSNetworkHelper.getInstance().sendRequest(new DoCommentRequest(certifiedAccountMeta$StFeed, certifiedAccountMeta$StComment, 0), new d(certifiedAccountMeta$StComment));
            return certifiedAccountMeta$StComment.f24924id.get();
        }
        com.tencent.biz.qqstory.base.c.a().dispatch(u(5, -1L, HardCodeUtil.qqStr(R.string.ksx), null));
        return "";
    }

    public COMM.StCommonExt j(String str) {
        j jVar;
        COMM.StCommonExt stCommonExt;
        if (!TextUtils.isEmpty(str) && (jVar = this.f95979d.get(str)) != null) {
            if (jVar.f96001c && jVar.f95999a && (stCommonExt = jVar.f96000b) != null) {
                return stCommonExt;
            }
            QLog.i(f95975e, 1, jVar.toString());
        }
        return null;
    }

    public void l(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, COMM.StCommonExt stCommonExt, String str) {
        VSNetworkHelper.getInstance().sendRequest(new GetCommentListRequest(certifiedAccountMeta$StFeed, stCommonExt, 20), new i(certifiedAccountMeta$StFeed, str));
    }

    public void m(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, boolean z16) {
        n(certifiedAccountMeta$StFeed, z16, "");
    }

    public void n(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, boolean z16, String str) {
        if (z16) {
            COMM.StCommonExt j3 = j(certifiedAccountMeta$StFeed.f24925id.get());
            String str2 = f95975e;
            QZLog.i(str2, 1, "getComments loadMore: " + z16 + ", attachInfo:" + j3);
            if (j3 == null) {
                QZLog.e(str2, 1, "getComments loadMore: " + z16 + ", attachInfo is null ");
                return;
            }
            A(certifiedAccountMeta$StFeed.f24925id.get(), false);
            l(certifiedAccountMeta$StFeed, j3, str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
            COMM.Entry entry = new COMM.Entry();
            entry.key.set("commentID");
            entry.value.set(str);
            stCommonExt.mapInfo.add(entry);
            o(certifiedAccountMeta$StFeed, stCommonExt);
            return;
        }
        o(certifiedAccountMeta$StFeed, null);
    }

    public void o(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, COMM.StCommonExt stCommonExt) {
        a aVar = new a(stCommonExt);
        if (stCommonExt == null) {
            String str = certifiedAccountMeta$StFeed.f24925id.get();
            if (PreLoader.exists("1002" + str)) {
                PreLoader.addListener("1002" + str, new b(aVar));
                PreLoader.remove("1002" + str);
                return;
            }
        }
        GetSubscribeFeedDetailRequest getSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(certifiedAccountMeta$StFeed, stCommonExt);
        getSubscribeFeedDetailRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(getSubscribeFeedDetailRequest, aVar);
    }

    public List<CertifiedAccountMeta$StComment> p(List<CertifiedAccountMeta$StComment> list, String str) {
        return q(list, str, 0);
    }

    public List<CertifiedAccountMeta$StComment> q(List<CertifiedAccountMeta$StComment> list, String str, int i3) {
        int size = list.size();
        if (!TextUtils.isEmpty(str) && i3 >= 0 && i3 <= size) {
            ArrayList arrayList = new ArrayList();
            if (i3 > 0) {
                arrayList.addAll(list.subList(0, i3));
            }
            while (i3 < size) {
                CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = list.get(i3);
                if (!certifiedAccountMeta$StComment.f24924id.get().equals(str)) {
                    arrayList.add(certifiedAccountMeta$StComment);
                }
                i3++;
            }
            return arrayList;
        }
        return list;
    }

    public Handler r() {
        if (this.f95976a == null) {
            this.f95976a = new Handler(Looper.getMainLooper());
        }
        return this.f95976a;
    }

    public ArrayList<CertifiedAccountMeta$StComment> s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f95977b.get(str);
    }

    public int t(String str) {
        Integer num = this.f95978c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public com.tencent.biz.subscribe.comment.d u(Object... objArr) {
        return new com.tencent.biz.subscribe.comment.d(6, objArr);
    }

    public long w(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment) {
        VSNetworkHelper.getInstance().sendRequest(new DoLikeRequest(certifiedAccountMeta$StFeed), new g());
        return Long.parseLong(certifiedAccountMeta$StComment.f24924id.get());
    }

    public void x(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply) {
        VSNetworkHelper.getInstance().sendRequest(new DoLikeRequest(certifiedAccountMeta$StFeed), new h());
    }

    public void y() {
        this.f95977b.clear();
        this.f95979d.clear();
        this.f95978c.clear();
    }
}

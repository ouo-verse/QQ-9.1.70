package com.tencent.biz.pubaccount.weishi.comment;

import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import UserGrowth.stCommentJumpText;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.request.PostCommentDingRequest;
import com.tencent.biz.pubaccount.weishi.request.PostCommentReplyRequest;
import com.tencent.biz.pubaccount.weishi.request.PostFeedCommentRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final WsCommentPresenter f80606a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f80607b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, ArrayList<stSimpleMetaComment>> f80608c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Integer> f80609d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, f> f80610e = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                q.this.f80606a.z();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f80612a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f80613b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f80614c;

        b(long j3, stSimpleMetaFeed stsimplemetafeed, boolean z16) {
            this.f80612a = j3;
            this.f80613b = stsimplemetafeed;
            this.f80614c = z16;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(com.tencent.biz.pubaccount.weishi.net.l lVar) {
            stGetFeedCommentListV2Rsp stgetfeedcommentlistv2rsp;
            ArrayList<stSimpleMetaComment> j3;
            long currentTimeMillis = System.currentTimeMillis() - this.f80612a;
            x.i("WsCommentBusiness", "\u8bc4\u8bba\u5217\u8868\u8bf7\u6c42\u8017\u65f6\uff1a" + currentTimeMillis + "\u6beb\u79d2");
            com.tencent.biz.pubaccount.weishi.report.g.d().p(currentTimeMillis, lVar.f80994g, "", false);
            if (!lVar.d()) {
                com.tencent.biz.pubaccount.weishi.report.g.d().r(currentTimeMillis, lVar.f80994g, lVar.f80991d, lVar.f80990c);
            }
            q.this.y(this.f80613b.f25129id, true);
            Object obj = lVar.f80999l;
            if (obj instanceof stQQGetFeedCommentListV2Rsp) {
                stQQGetFeedCommentListV2Rsp stqqgetfeedcommentlistv2rsp = (stQQGetFeedCommentListV2Rsp) obj;
                stgetfeedcommentlistv2rsp = stqqgetfeedcommentlistv2rsp.rsp;
                if (stgetfeedcommentlistv2rsp == null) {
                    x.f("WsCommentBusiness", "stGetFeedCommentListRsp is null!");
                    return;
                }
                ArrayList<stSimpleMetaComment> arrayList = stgetfeedcommentlistv2rsp.comments;
                x.f("WsCommentBusiness", "-------------getCommentSize:" + stgetfeedcommentlistv2rsp.comments.size() + ", attachInfo:" + stgetfeedcommentlistv2rsp.attach_info + "isFinish\uff1a" + stgetfeedcommentlistv2rsp.is_finished);
                if (!this.f80614c) {
                    j3 = q.j(arrayList, stqqgetfeedcommentlistv2rsp.comment_text, 0);
                    q.this.f80609d.put(this.f80613b.f25129id, Integer.valueOf(stgetfeedcommentlistv2rsp.total_comment_num));
                    q.this.f80608c.put(this.f80613b.f25129id, j3);
                    x.f("WsCommentBusiness", "\u4fdd\u5b58\u8bc4\u8bba" + j3.size() + "\u6761");
                } else {
                    ArrayList arrayList2 = (ArrayList) q.this.f80608c.get(this.f80613b.f25129id);
                    j3 = q.j(arrayList, stqqgetfeedcommentlistv2rsp.comment_text, arrayList2 != null ? arrayList2.size() : 0);
                    if (arrayList2 != null) {
                        arrayList2.addAll(j3);
                        q.this.f80608c.put(this.f80613b.f25129id, arrayList2);
                    } else {
                        q.this.f80608c.put(this.f80613b.f25129id, j3);
                    }
                    x.f("WsCommentBusiness", "\u4fdd\u5b58\u8bc4\u8bba" + j3.size() + "\u6761");
                }
                stgetfeedcommentlistv2rsp.comments = j3;
                q.this.w(this.f80613b.f25129id, stgetfeedcommentlistv2rsp.attach_info, stgetfeedcommentlistv2rsp.is_finished, true);
                x.f("WsCommentBusiness", "\u83b7\u53d6\u8bc4\u8bba dispatch responseCommentEvent");
            } else {
                x.f("WsCommentBusiness", "\u83b7\u53d6\u8bc4\u8bba\u5931\u8d25new\uff01");
                com.tencent.biz.pubaccount.weishi.report.g.d().r(currentTimeMillis, lVar.f80994g, -1, "\u6570\u636e\u65e0\u6cd5\u89e3\u6790\u6216\u4e3a\u7a7a");
                stgetfeedcommentlistv2rsp = null;
            }
            com.tencent.biz.qqstory.base.c.a().dispatch(q.this.q(9, Integer.valueOf(lVar.f80992e), lVar.f80990c, stgetfeedcommentlistv2rsp, Integer.valueOf(q.this.hashCode()), Boolean.valueOf(this.f80614c), this.f80613b.f25129id));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends com.tencent.biz.pubaccount.weishi.net.common.b<stPostCommentReplyV2Rsp, stPostCommentReplyV2Rsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaReply f80618a;

        d(stSimpleMetaReply stsimplemetareply) {
            this.f80618a = stsimplemetareply;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            x.f("WsCommentBusiness", "\u6dfb\u52a0\u56de\u590d\u5931\u8d25new\uff01");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stPostCommentReplyV2Rsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stPostCommentReplyV2Rsp> gVar, stPostCommentReplyV2Rsp stpostcommentreplyv2rsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            stSimpleMetaPerson stsimplemetaperson;
            stSimpleMetaReply stsimplemetareply = stpostcommentreplyv2rsp.reply;
            if (stsimplemetareply != null && (stsimplemetaperson = stsimplemetareply.poster) != null) {
                this.f80618a.poster.f25130id = stsimplemetaperson.f25130id;
            }
            return stpostcommentreplyv2rsp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stPostCommentReplyV2Rsp stpostcommentreplyv2rsp) {
            super.d(stpostcommentreplyv2rsp);
            q qVar = q.this;
            stSimpleMetaReply stsimplemetareply = this.f80618a;
            com.tencent.biz.qqstory.base.c.a().dispatch(qVar.q(4, 1000, "", stpostcommentreplyv2rsp, stsimplemetareply, stsimplemetareply.f25131id, Integer.valueOf(q.this.hashCode())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends com.tencent.biz.pubaccount.weishi.net.common.b<stPostCommentDingRsp, stPostCommentDingRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f80620a;

        e(int i3) {
            this.f80620a = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            x.f("WsCommentBusiness", "\u8bc4\u8bba\u70b9\u8d5e\u5931\u8d25new\uff01");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stPostCommentDingRsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stPostCommentDingRsp> gVar, stPostCommentDingRsp stpostcommentdingrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            if (this.f80620a == 1) {
                x.f("WsCommentBusiness", "\u70b9\u8d5e\u6210\u529f,nothing is " + stpostcommentdingrsp.nothing);
            } else {
                x.f("WsCommentBusiness", "\u53d6\u6d88\u70b9\u8d5e\u6210\u529f,nothing is " + stpostcommentdingrsp.nothing);
            }
            return stpostcommentdingrsp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stPostCommentDingRsp stpostcommentdingrsp) {
            super.d(stpostcommentdingrsp);
            com.tencent.biz.qqstory.base.c.a().dispatch(q.this.q(7, 1000, "", stpostcommentdingrsp));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f80622a;

        /* renamed from: b, reason: collision with root package name */
        public String f80623b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f80624c;

        f() {
        }

        public String toString() {
            return "CommentResponse{hasMore=" + this.f80622a + ", attachInfo='" + this.f80623b + "', hasResponse='" + this.f80624c + "'}";
        }
    }

    public q(WsCommentPresenter wsCommentPresenter) {
        this.f80606a = wsCommentPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<stSimpleMetaComment> j(ArrayList<stSimpleMetaComment> arrayList, ArrayList<stCommentJumpText> arrayList2, int i3) {
        if (arrayList.size() == 0) {
            return new ArrayList<>();
        }
        HashMap hashMap = new HashMap();
        int i16 = 0;
        if (arrayList2.size() > 0) {
            for (int i17 = 0; i17 < arrayList2.size(); i17++) {
                stCommentJumpText stcommentjumptext = arrayList2.get(i17);
                stSimpleMetaComment stsimplemetacomment = new stSimpleMetaComment();
                stsimplemetacomment.isTempData = true;
                int i18 = stcommentjumptext.index;
                stsimplemetacomment.wording = stcommentjumptext.text;
                if (i18 >= i3) {
                    hashMap.put(Integer.valueOf(i18), stsimplemetacomment);
                } else {
                    x.i("comment", "oldsize:" + i3 + ", index:" + i18);
                }
                if (i18 == -1) {
                    x.i("comment", stcommentjumptext.index + ",\u5c3e\u90e8\u62c9\u91cf\u5165\u53e3: " + stsimplemetacomment.wording);
                } else {
                    x.i("comment", stcommentjumptext.index + ",\u62c9\u91cf\u5165\u53e3: " + stsimplemetacomment.wording);
                }
            }
        }
        if (arrayList.size() <= 20 && hashMap.containsKey(-1)) {
            hashMap.remove(-1);
            x.f("weishi-comment", "\u8bc4\u8bba\u5c0f\u4e8e\u7b49\u4e8e20\u6761\uff0c\u79fb\u9664\u5c3e\u90e8\u62c9\u91cf\u5165\u53e3");
        }
        int size = arrayList.size() + hashMap.size();
        x.f("weishi-comment", "size1:" + arrayList.size() + ",size2:" + hashMap.size());
        stSimpleMetaComment[] stsimplemetacommentArr = new stSimpleMetaComment[size];
        if (hashMap.containsKey(-1)) {
            stsimplemetacommentArr[size - 1] = (stSimpleMetaComment) hashMap.get(-1);
            size--;
        }
        int i19 = 0;
        while (true) {
            if (i16 >= size) {
                break;
            }
            int i26 = i16 + i3;
            if (hashMap.containsKey(Integer.valueOf(i26))) {
                stsimplemetacommentArr[i16] = (stSimpleMetaComment) hashMap.get(Integer.valueOf(i26));
                i19++;
            } else {
                int i27 = i16 - i19;
                if (i27 < arrayList.size()) {
                    stsimplemetacommentArr[i16] = arrayList.get(i27);
                } else {
                    x.l("weishi-comment", "combineComment end!");
                    break;
                }
            }
            i16++;
        }
        x.f("weishi-comment", "combineComment success");
        return v(stsimplemetacommentArr);
    }

    private void r(stSimpleMetaFeed stsimplemetafeed, String str, int i3) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new PostCommentDingRequest(stsimplemetafeed.f25129id, str, i3)).b(new e(i3));
    }

    private static ArrayList<stSimpleMetaComment> v(stSimpleMetaComment[] stsimplemetacommentArr) {
        List asList = Arrays.asList(stsimplemetacommentArr);
        ArrayList<stSimpleMetaComment> arrayList = new ArrayList<>();
        if (asList.size() > 0) {
            for (int i3 = 0; i3 < asList.size(); i3++) {
                if (asList.get(i3) != null) {
                    arrayList.add((stSimpleMetaComment) asList.get(i3));
                    if (i3 == 0) {
                        x.l("weishi-comment", "end, comment word:" + ((stSimpleMetaComment) asList.get(i3)).wording + ", id:" + ((stSimpleMetaComment) asList.get(i3)).f25128id);
                    }
                } else {
                    x.f("weishi-comment", "comment is null");
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, String str2, boolean z16, boolean z17) {
        if (this.f80610e.get(str) == null) {
            f fVar = new f();
            fVar.f80623b = str2;
            fVar.f80622a = !z16;
            this.f80610e.put(str, fVar);
            return;
        }
        f fVar2 = this.f80610e.get(str);
        if (fVar2 != null) {
            fVar2.f80622a = !z16;
            fVar2.f80623b = str2;
        } else {
            x.f("WsCommentBusiness", "updateResponseState, commentResponse is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(stSimpleMetaComment stsimplemetacomment, stSimpleMetaComment stsimplemetacomment2) {
        stsimplemetacomment.poster.f25130id = stsimplemetacomment2.poster.f25130id;
        stsimplemetacomment.poster_id = stsimplemetacomment2.poster_id;
        stsimplemetacomment.f25128id = stsimplemetacomment2.f25128id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z16) {
        if (this.f80610e.get(str) == null) {
            f fVar = new f();
            fVar.f80624c = z16;
            this.f80610e.put(str, fVar);
        } else {
            f fVar2 = this.f80610e.get(str);
            if (fVar2 != null) {
                fVar2.f80624c = z16;
            } else {
                x.f("WsCommentBusiness", "updateResponseState, commentResponse is null.");
            }
        }
    }

    public long h(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply, ArrayList<String> arrayList) {
        x.f("WsCommentBusiness", "reply.poster_id:" + stsimplemetareply.poster.f25130id + ",reply.receiver_id:" + stsimplemetareply.receiver.f25130id + ",reply.beReplyCommendId:" + stsimplemetareply.beReplyReplyId);
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new PostCommentReplyRequest(stsimplemetafeed, stsimplemetacomment, stsimplemetareply, arrayList)).b(new d(stsimplemetareply));
        return 0L;
    }

    public void i(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, ArrayList<String> arrayList) {
        x.f("WsCommentBusiness", "---\u6dfb\u52a0\u8bc4\u8bba\uff0cwording:" + stsimplemetacomment.wording + "poster_id:" + stsimplemetacomment.poster_id + ",receiver_id:" + stsimplemetacomment.receiver_id);
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new PostFeedCommentRequest(stsimplemetafeed, stsimplemetacomment, arrayList)).b(new c(stsimplemetacomment));
    }

    public String k(String str) {
        f fVar;
        String str2;
        return (TextUtils.isEmpty(str) || (fVar = this.f80610e.get(str)) == null || !fVar.f80624c || !fVar.f80622a || (str2 = fVar.f80623b) == null) ? "" : str2;
    }

    public void l(stSimpleMetaFeed stsimplemetafeed, String str, boolean z16, String str2, String str3) {
        x.i("WsCommentBusiness", "getComments(final stSimpleMetaFeed feed, String attachInfo, final boolean loadMore)");
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new com.tencent.biz.pubaccount.weishi.net.l(new i10.d(str, stsimplemetafeed.f25129id, 1, str2, str3), n(), new b(System.currentTimeMillis(), stsimplemetafeed, z16), 1000));
    }

    public void m(stSimpleMetaFeed stsimplemetafeed, boolean z16, String str, String str2) {
        if (stsimplemetafeed == null) {
            x.f("WsCommentBusiness", "getComments , feed is null ");
            return;
        }
        String k3 = k(stsimplemetafeed.f25129id);
        x.l("WsCommentBusiness", "getComments loadMore: " + z16 + ", attachInfo:" + k3);
        if (z16 && TextUtils.isEmpty(k3)) {
            x.f("WsCommentBusiness", "getComments and loadMore, attachInfo is empty ");
            return;
        }
        if (!z16) {
            x.f("WsCommentBusiness", "first getComments, set attachInfo empty ");
            k3 = "";
        }
        y(stsimplemetafeed.f25129id, false);
        l(stsimplemetafeed, k3, z16, str, str2);
    }

    public Handler n() {
        if (this.f80607b == null) {
            this.f80607b = new a(Looper.getMainLooper());
        }
        return this.f80607b;
    }

    public ArrayList<stSimpleMetaComment> o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f80608c.get(str);
    }

    public int p(String str) {
        Integer num = this.f80609d.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public wz.a q(Object... objArr) {
        return new wz.a(6, objArr);
    }

    public void s(stSimpleMetaFeed stsimplemetafeed, stSimpleComment stsimplecomment) {
        r(stsimplemetafeed, stsimplecomment.f25127id, stsimplecomment.isDing);
    }

    public void t(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment) {
        r(stsimplemetafeed, stsimplemetacomment.f25128id, stsimplemetacomment.isDing);
    }

    public void u() {
        this.f80608c.clear();
        this.f80610e.clear();
        this.f80609d.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends com.tencent.biz.pubaccount.weishi.net.common.b<stPostFeedCommentV2Rsp, stPostFeedCommentV2Rsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaComment f80616a;

        c(stSimpleMetaComment stsimplemetacomment) {
            this.f80616a = stsimplemetacomment;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            x.f("WsCommentBusiness", "\u6dfb\u52a0\u8bc4\u8bba\u5931\u8d25new\uff01");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stPostFeedCommentV2Rsp stpostfeedcommentv2rsp) {
            super.d(stpostfeedcommentv2rsp);
            stSimpleMetaComment stsimplemetacomment = stpostfeedcommentv2rsp.comment;
            q.this.x(this.f80616a, stsimplemetacomment);
            x.l("WsCommentBusiness", "---CommentEvent, addFeedComment\uff01");
            com.tencent.biz.qqstory.base.c.a().dispatch(q.this.q(3, 1000, "", stpostfeedcommentv2rsp, stsimplemetacomment.f25128id, Integer.valueOf(q.this.hashCode())));
            q.this.f80606a.l0(this.f80616a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stPostFeedCommentV2Rsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stPostFeedCommentV2Rsp> gVar, stPostFeedCommentV2Rsp stpostfeedcommentv2rsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return stpostfeedcommentv2rsp;
        }
    }
}

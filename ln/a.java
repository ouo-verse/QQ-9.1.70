package ln;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.comment.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StReply;
import qzonemoment.QZMomentMeta$StUser;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a extends com.qzone.reborn.base.l<QZMomentMeta$StComment> {

    /* renamed from: e, reason: collision with root package name */
    protected QZMFeedCommentInfo f415009e;

    /* renamed from: f, reason: collision with root package name */
    protected QZMomentMeta$StComment f415010f;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private static class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f415012a;

        public b(a aVar) {
            this.f415012a = new WeakReference<>(aVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            a aVar;
            String str2;
            QZMomentMeta$StUser qZMomentMeta$StUser;
            WeakReference<a> weakReference = this.f415012a;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            QZMomentMeta$StComment qZMomentMeta$StComment = aVar.f415010f;
            if (qZMomentMeta$StComment != null && (qZMomentMeta$StUser = qZMomentMeta$StComment.postUser) != null) {
                str2 = qZMomentMeta$StUser.f430367id.get();
            } else {
                str2 = "";
            }
            hashMap.put("zplan_touin", str2);
            return hashMap;
        }
    }

    private void w() {
        if (p() == null || p().getIntent() == null) {
            return;
        }
        Intent intent = p().getIntent();
        if (intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY) instanceof QZMFeedCommentInfo) {
            this.f415009e = (QZMFeedCommentInfo) extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        com.qzone.reborn.qzmoment.comment.d.l().p(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(View view) {
        String str;
        HashMap hashMap = new HashMap();
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f415009e;
        String str2 = "";
        if (qZMFeedCommentInfo == null) {
            str = "";
        } else {
            str = qZMFeedCommentInfo.mFeed.f430362id.get();
        }
        hashMap.put("operated_feed", str);
        QZMFeedCommentInfo qZMFeedCommentInfo2 = this.f415009e;
        if (qZMFeedCommentInfo2 != null) {
            str2 = qZMFeedCommentInfo2.mFeed.poster.f430367id.get();
        }
        hashMap.put("author_id", str2);
        fo.c.o(view, "em_bas_commentspanel_replyarea", new fo.b().l(hashMap).h(new b(this)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        gn.b bVar = (gn.b) q(gn.b.class);
        if (bVar == null) {
            QLog.e("QZMBaseCommentPresenter", 1, "ioc is null");
            return;
        }
        com.qzone.reborn.qzmoment.comment.d.l().p(bVar.d());
        QZMFeedCommentInfo a16 = bVar.a();
        QZMFeedCommentInfo qZMFeedCommentInfo = new QZMFeedCommentInfo();
        qZMFeedCommentInfo.mFeed = a16.mFeed;
        qZMFeedCommentInfo.mComment = this.f415010f;
        com.qzone.reborn.qzmoment.comment.d.l().q(p(), qZMFeedCommentInfo, new C10734a());
    }

    /* compiled from: P */
    /* renamed from: ln.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10734a implements d.InterfaceC0494d {
        C10734a() {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void a(QZMomentMeta$StComment qZMomentMeta$StComment) {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void b(QZMomentMeta$StReply qZMomentMeta$StReply) {
        }
    }
}

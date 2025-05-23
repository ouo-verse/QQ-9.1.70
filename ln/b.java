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
public abstract class b extends com.qzone.reborn.base.l<com.qzone.reborn.qzmoment.comment.f> {

    /* renamed from: e, reason: collision with root package name */
    protected QZMFeedCommentInfo f415013e;

    /* renamed from: f, reason: collision with root package name */
    protected QZMomentMeta$StReply f415014f;

    /* renamed from: h, reason: collision with root package name */
    protected QZMomentMeta$StComment f415015h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: ln.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10735b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f415017a;

        public C10735b(b bVar) {
            this.f415017a = new WeakReference<>(bVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            b bVar;
            String str2;
            QZMomentMeta$StUser qZMomentMeta$StUser;
            WeakReference<b> weakReference = this.f415017a;
            if (weakReference == null || (bVar = weakReference.get()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            QZMomentMeta$StReply qZMomentMeta$StReply = bVar.f415014f;
            if (qZMomentMeta$StReply != null && (qZMomentMeta$StUser = qZMomentMeta$StReply.postUser) != null) {
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
            this.f415013e = (QZMFeedCommentInfo) extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY);
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
        String str2;
        QZMomentMeta$StUser qZMomentMeta$StUser;
        HashMap hashMap = new HashMap();
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f415013e;
        String str3 = "";
        if (qZMFeedCommentInfo == null) {
            str = "";
        } else {
            str = qZMFeedCommentInfo.mFeed.f430362id.get();
        }
        hashMap.put("operated_feed", str);
        QZMFeedCommentInfo qZMFeedCommentInfo2 = this.f415013e;
        if (qZMFeedCommentInfo2 == null) {
            str2 = "";
        } else {
            str2 = qZMFeedCommentInfo2.mFeed.poster.f430367id.get();
        }
        hashMap.put("author_id", str2);
        QZMomentMeta$StReply qZMomentMeta$StReply = this.f415014f;
        if (qZMomentMeta$StReply != null && (qZMomentMeta$StUser = qZMomentMeta$StReply.postUser) != null) {
            str3 = qZMomentMeta$StUser.f430367id.get();
        }
        hashMap.put("zplan_touin", str3);
        fo.c.o(view, "em_bas_commentspanel_replyarea", new fo.b().l(hashMap).h(new C10735b(this)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        gn.b bVar = (gn.b) q(gn.b.class);
        if (bVar == null) {
            QLog.e("QZMBaseReplyPresenter", 1, "ioc is null");
            return;
        }
        com.qzone.reborn.qzmoment.comment.d.l().p(bVar.d());
        QZMFeedCommentInfo a16 = bVar.a();
        QZMFeedCommentInfo qZMFeedCommentInfo = new QZMFeedCommentInfo();
        qZMFeedCommentInfo.mFeed = a16.mFeed;
        qZMFeedCommentInfo.mComment = this.f415015h;
        qZMFeedCommentInfo.mReply = this.f415014f;
        com.qzone.reborn.qzmoment.comment.d.l().q(p(), qZMFeedCommentInfo, new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements d.InterfaceC0494d {
        a() {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void a(QZMomentMeta$StComment qZMomentMeta$StComment) {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void b(QZMomentMeta$StReply qZMomentMeta$StReply) {
        }
    }
}

package ln;

import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qzonemoment.QZMomentMeta$StReply;
import qzonemoment.QZMomentMeta$StUser;

/* compiled from: P */
/* loaded from: classes38.dex */
public class s extends b {
    private QZoneAsyncTextView C;
    private i D;
    private long E;

    /* renamed from: i, reason: collision with root package name */
    private QZoneNickNameView f415039i;

    /* renamed from: m, reason: collision with root package name */
    private QZoneUserAvatarView f415040m;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            s.this.B(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    private void A() {
        ho.h.b(p(), this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        if (this.D == null) {
            this.D = new i(p());
        }
        gn.b bVar = (gn.b) q(gn.b.class);
        if (bVar == null || bVar.a() == null) {
            return;
        }
        QZMFeedCommentInfo a16 = bVar.a();
        QZMFeedCommentInfo qZMFeedCommentInfo = new QZMFeedCommentInfo();
        qZMFeedCommentInfo.mFeed = a16.mFeed;
        qZMFeedCommentInfo.mComment = this.f415015h;
        qZMFeedCommentInfo.mReply = this.f415014f;
        qZMFeedCommentInfo.mIsGuest = a16.mIsGuest;
        bVar.b(qZMFeedCommentInfo);
        this.D.p(bVar);
        this.D.q(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void G(QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (this.C == null || qZMomentMeta$StReply == null) {
            return;
        }
        String str = qZMomentMeta$StReply.content.get();
        QZMomentMeta$StUser qZMomentMeta$StUser = qZMomentMeta$StReply.targetUser;
        if (qZMomentMeta$StUser != null && !TextUtils.isEmpty(qZMomentMeta$StUser.nick.get())) {
            str = "\u56de\u590d " + qZMomentMeta$StReply.targetUser.nick.get() + MsgSummary.STR_COLON + str;
        }
        this.C.setText(str);
    }

    private void H(QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (this.f415040m == null || qZMomentMeta$StReply == null || qZMomentMeta$StReply.postUser.get() == null) {
            return;
        }
        String str = qZMomentMeta$StReply.postUser.f430367id.get();
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZMReplyContentPresenter", 1, "uin is empty");
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            this.E = parseLong;
            this.f415040m.setUser(parseLong);
        } catch (Exception e16) {
            QLog.e("QZMReplyContentPresenter", 1, "parse uin exception " + e16);
        }
    }

    private void J(QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (this.f415039i == null || qZMomentMeta$StReply == null || qZMomentMeta$StReply.postUser.get() == null) {
            return;
        }
        this.f415039i.setRichText(qZMomentMeta$StReply.postUser.nick.get());
        this.f415039i.setMaxLine(1);
    }

    @Override // ln.b, com.tencent.biz.richframework.part.adapter.section.Section
    protected void onInitView(View view) {
        super.onInitView(view);
        this.f415039i = (QZoneNickNameView) view.findViewById(R.id.f162778ml1);
        this.f415040m = (QZoneUserAvatarView) view.findViewById(R.id.mlp);
        this.C = (QZoneAsyncTextView) view.findViewById(R.id.mld);
        this.f415039i.setOnClickListener(new View.OnClickListener() { // from class: ln.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                s.this.C(view2);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: ln.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                s.this.D(view2);
            }
        });
        this.C.setOnLongClickListener(new a());
        u(this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mlb};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.qzmoment.comment.f fVar, int i3, List<Object> list) {
        if (fVar == null) {
            return;
        }
        QZMomentMeta$StReply qZMomentMeta$StReply = fVar.f58884b;
        this.f415014f = qZMomentMeta$StReply;
        this.f415015h = fVar.f58885c;
        H(qZMomentMeta$StReply);
        J(fVar.f58884b);
        G(fVar.f58884b);
    }
}

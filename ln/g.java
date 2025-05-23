package ln;

import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends ln.a {
    private i C;
    private long D;

    /* renamed from: h, reason: collision with root package name */
    private QZoneNickNameView f415021h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneUserAvatarView f415022i;

    /* renamed from: m, reason: collision with root package name */
    private QZoneAsyncTextView f415023m;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            g.this.B(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    private void A() {
        ho.h.b(p(), this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        if (this.C == null) {
            this.C = new i(p());
        }
        gn.b bVar = (gn.b) q(gn.b.class);
        if (bVar == null || bVar.a() == null) {
            return;
        }
        QZMFeedCommentInfo a16 = bVar.a();
        QZMFeedCommentInfo qZMFeedCommentInfo = new QZMFeedCommentInfo();
        qZMFeedCommentInfo.mFeed = a16.mFeed;
        qZMFeedCommentInfo.mComment = this.f415010f;
        qZMFeedCommentInfo.mIsGuest = a16.mIsGuest;
        bVar.b(qZMFeedCommentInfo);
        this.C.p(bVar);
        this.C.q(view);
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

    private void G(QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (this.f415023m == null || qZMomentMeta$StComment == null) {
            return;
        }
        this.f415023m.setText(qZMomentMeta$StComment.content.get());
    }

    private void H(QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (this.f415022i == null || qZMomentMeta$StComment == null || qZMomentMeta$StComment.postUser.get() == null) {
            return;
        }
        String str = qZMomentMeta$StComment.postUser.f430367id.get();
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZMCommentContentPresenter", 1, "uin is empty");
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            this.D = parseLong;
            this.f415022i.setUser(parseLong);
        } catch (Exception e16) {
            QLog.e("QZMCommentContentPresenter", 1, "parse uin exception " + e16);
        }
    }

    private void J(QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (this.f415021h == null || qZMomentMeta$StComment == null || qZMomentMeta$StComment.postUser.get() == null) {
            return;
        }
        this.f415021h.setRichText(qZMomentMeta$StComment.postUser.nick.get());
        this.f415021h.setMaxLine(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZMomentMeta$StComment qZMomentMeta$StComment, int i3, List<Object> list) {
        this.f415010f = qZMomentMeta$StComment;
        H(qZMomentMeta$StComment);
        J(qZMomentMeta$StComment);
        G(qZMomentMeta$StComment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ln.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        this.f415021h = (QZoneNickNameView) view.findViewById(R.id.f162778ml1);
        this.f415022i = (QZoneUserAvatarView) view.findViewById(R.id.mlp);
        this.f415023m = (QZoneAsyncTextView) view.findViewById(R.id.mld);
        this.f415021h.setOnClickListener(new View.OnClickListener() { // from class: ln.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.this.C(view2);
            }
        });
        this.f415023m.setOnClickListener(new View.OnClickListener() { // from class: ln.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.this.D(view2);
            }
        });
        this.f415023m.setOnLongClickListener(new a());
        u(this.f415023m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mk5};
    }
}

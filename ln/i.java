package ln;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StReply;
import qzonemoment.QZMomentMeta$StUser;
import xg.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends xg.a<gn.b> {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements a.d {
        a() {
        }

        @Override // xg.a.d
        public void onDelete() {
            i.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements a.c {
        b() {
        }

        @Override // xg.a.c
        public void onCopy() {
            i.this.m();
        }
    }

    public i(Activity activity) {
        this.f447910a = activity;
    }

    private int k() {
        return (!o() || n()) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        T t16 = this.f447912c;
        if (t16 == 0) {
            QLog.e("QZMCommentLongClickEventManager", 1, "ioc is null");
            return;
        }
        if (((gn.b) t16).d() == null) {
            QLog.e("QZMCommentLongClickEventManager", 1, "ioc view model is null");
            return;
        }
        if (((gn.b) this.f447912c).a() == null) {
            QLog.e("QZMCommentLongClickEventManager", 1, "ioc comment info is null");
            return;
        }
        QZMCommentBusinessViewModel d16 = ((gn.b) this.f447912c).d();
        QZMFeedCommentInfo a16 = ((gn.b) this.f447912c).a();
        if (a16.mReply != null) {
            d16.k2(k(), a16.mFeed, a16.mComment, a16.mReply);
        } else {
            d16.l2(k(), this.f447910a.hashCode(), a16.mFeed, a16.mComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String str;
        T t16 = this.f447912c;
        if (t16 == 0) {
            QLog.e("QZMCommentLongClickEventManager", 1, "ioc is null");
            return;
        }
        if (((gn.b) t16).a() == null) {
            QLog.e("QZMCommentLongClickEventManager", 1, "ioc comment info is null");
            return;
        }
        QZMFeedCommentInfo a16 = ((gn.b) this.f447912c).a();
        QZMomentMeta$StReply qZMomentMeta$StReply = a16.mReply;
        if (qZMomentMeta$StReply != null && !TextUtils.isEmpty(qZMomentMeta$StReply.content.get())) {
            str = a16.mReply.content.get();
        } else {
            QZMomentMeta$StComment qZMomentMeta$StComment = a16.mComment;
            if (qZMomentMeta$StComment != null && !TextUtils.isEmpty(qZMomentMeta$StComment.content.get())) {
                str = a16.mComment.content.get();
            } else {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().s(TextCellParser.toPlainText(str));
    }

    private boolean n() {
        QZMomentMeta$StComment qZMomentMeta$StComment;
        QZMomentMeta$StUser qZMomentMeta$StUser;
        QZMomentMeta$StReply qZMomentMeta$StReply;
        QZMomentMeta$StUser qZMomentMeta$StUser2;
        T t16 = this.f447912c;
        if (t16 == 0 || ((gn.b) t16).a() == null) {
            return false;
        }
        if (((gn.b) this.f447912c).a().mReply == null || (qZMomentMeta$StReply = ((gn.b) this.f447912c).a().mReply) == null || (qZMomentMeta$StUser2 = qZMomentMeta$StReply.postUser) == null || !TextUtils.equals(qZMomentMeta$StUser2.f430367id.get(), LoginData.getInstance().getUinString())) {
            return (((gn.b) this.f447912c).a().mComment == null || (qZMomentMeta$StComment = ((gn.b) this.f447912c).a().mComment) == null || (qZMomentMeta$StUser = qZMomentMeta$StComment.postUser) == null || !TextUtils.equals(qZMomentMeta$StUser.f430367id.get(), LoginData.getInstance().getUinString())) ? false : true;
        }
        return true;
    }

    private boolean o() {
        T t16 = this.f447912c;
        if (t16 == 0 || ((gn.b) t16).a() == null) {
            return false;
        }
        return !((gn.b) this.f447912c).a().mIsGuest;
    }

    @Override // xg.a
    protected List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id.n0y));
        if (o() || n()) {
            arrayList.add(Integer.valueOf(R.id.n0z));
        }
        return arrayList;
    }

    @Override // xg.a
    protected List<String> b() {
        T t16 = this.f447912c;
        if (t16 == 0 || ((gn.b) t16).a() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.b.f447914a);
        if (o() || n()) {
            arrayList.add(a.b.f447916c);
        }
        return arrayList;
    }

    @Override // xg.a
    protected a.c e() {
        return new b();
    }

    @Override // xg.a
    protected a.d f() {
        return new a();
    }

    @Override // xg.a
    protected a.e g() {
        return null;
    }

    @Override // xg.a
    protected a.f h() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(gn.b bVar) {
        this.f447912c = bVar;
    }

    public void q(View view) {
        d(view);
    }
}

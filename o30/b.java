package o30;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.manager.c;
import com.tencent.biz.qqcircle.widgets.person.QFSPersonalListPymkContainerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ViewStub f421862a;

    /* renamed from: b, reason: collision with root package name */
    private View f421863b;

    /* renamed from: c, reason: collision with root package name */
    private QFSPersonalListPymkContainerView f421864c;

    /* renamed from: d, reason: collision with root package name */
    private c f421865d;

    /* renamed from: e, reason: collision with root package name */
    private List<FeedCloudMeta$StUserRecomInfo> f421866e = null;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StUser f421867f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f421868g;

    /* renamed from: h, reason: collision with root package name */
    private Fragment f421869h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f421870a;

        public a(b bVar) {
            this.f421870a = new WeakReference<>(bVar);
        }

        @Override // com.tencent.biz.qqcircle.manager.c.b
        public void a(@NonNull List<FeedCloudMeta$StUserRecomInfo> list) {
            b bVar = this.f421870a.get();
            if (bVar != null) {
                bVar.c(list);
                bVar.f();
            }
        }
    }

    public b(Fragment fragment) {
        this.f421869h = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<FeedCloudMeta$StUserRecomInfo> list) {
        if (list == null) {
            QLog.w("PYMK-QCirclePersonalListPymkControl", 1, "[handlerPersonalUserRecomPymkResult] feeds should not be null.");
        } else {
            this.f421866e = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f421866e != null && this.f421868g) {
            if (this.f421863b == null) {
                this.f421863b = this.f421862a.inflate();
            }
            QFSPersonalListPymkContainerView qFSPersonalListPymkContainerView = (QFSPersonalListPymkContainerView) this.f421863b.findViewById(R.id.f486120g);
            this.f421864c = qFSPersonalListPymkContainerView;
            if (qFSPersonalListPymkContainerView == null) {
                QLog.d("PYMK-QCirclePersonalListPymkControl", 1, "[showProfilePymkRecommendView] pymk container view should not be null.");
                return;
            }
            qFSPersonalListPymkContainerView.setVisibility(0);
            ViewTreeViewModelStoreOwner.set(this.f421864c, this.f421869h);
            c cVar = this.f421865d;
            if (cVar != null) {
                this.f421864c.setPYMKGuestViewModel(cVar.e());
                return;
            }
            return;
        }
        QLog.d("PYMK-QCirclePersonalListPymkControl", 1, "[showProfilePymkRecommendView] return: mNeedShow=" + this.f421868g);
    }

    private void g(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (this.f421865d == null) {
            c cVar = new c();
            this.f421865d = cVar;
            cVar.j();
            this.f421865d.m(new a(this));
        }
        if (TextUtils.equals(feedCloudMeta$StUser.f398463id.get(), this.f421865d.f())) {
            return;
        }
        this.f421865d.d(feedCloudMeta$StUser.f398463id.get());
    }

    public void d() {
        this.f421868g = false;
        QFSPersonalListPymkContainerView qFSPersonalListPymkContainerView = this.f421864c;
        if (qFSPersonalListPymkContainerView == null) {
            return;
        }
        qFSPersonalListPymkContainerView.setVisibility(8);
    }

    public void e(View view) {
        this.f421862a = (ViewStub) view.findViewById(R.id.ypq);
    }

    public void h(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        String str;
        if (QCirclePluginUtil.isOwner(feedCloudMeta$StUser)) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = this.f421867f;
        String str2 = null;
        if (feedCloudMeta$StUser2 == null) {
            str = null;
        } else {
            str = feedCloudMeta$StUser2.f398463id.get();
        }
        if (feedCloudMeta$StUser != null) {
            str2 = feedCloudMeta$StUser.f398463id.get();
        }
        QLog.d("PYMK-QCirclePersonalListPymkControl", 1, "userId:" + str2);
        if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, str2)) {
            return;
        }
        this.f421867f = feedCloudMeta$StUser;
        g(feedCloudMeta$StUser);
        this.f421868g = true;
        f();
    }
}

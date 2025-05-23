package com.tencent.biz.qqcircle.comment.abovebar;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.sticker.QFSCommentRecommendStickersView;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.an;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentRecStickersBar extends com.tencent.biz.qqcircle.comment.abovebar.b {
    public static boolean L = false;
    private static final int M = cx.a(8.0f);
    private String C;
    private String D;
    private final List<com.tencent.biz.qqcircle.comment.sticker.a> E;
    private Runnable F;
    private boolean G;
    private boolean H;
    private boolean I;
    private TextWatcher J;
    private boolean K;

    /* renamed from: i, reason: collision with root package name */
    private QFSCommentRecommendStickersView f83286i;

    /* renamed from: m, reason: collision with root package name */
    private String f83287m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            rect.right = QFSCommentRecStickersBar.M;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSCommentRecommendStickersView.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f83289a;

        b(boolean z16) {
            this.f83289a = z16;
        }

        @Override // com.tencent.biz.qqcircle.comment.sticker.QFSCommentRecommendStickersView.f
        public void onDismiss() {
            QFSCommentRecStickersBar.this.f83286i.setVisibility(8);
            if (this.f83289a) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(QFSCommentRecStickersBar.this.getContextHashCode(), QFSCommentRecStickersBar.this.getGroup());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d implements IStickerRecManager.ImgUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSCommentRecStickersBar> f83292a;

        public d(QFSCommentRecStickersBar qFSCommentRecStickersBar) {
            this.f83292a = new WeakReference<>(qFSCommentRecStickersBar);
        }

        @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener
        public void onImgUpdated(List<IStickerRecEmoticon> list, String str, String str2, int i3, String str3) {
            JSONArray optJSONArray;
            QFSCommentRecStickersBar qFSCommentRecStickersBar = this.f83292a.get();
            if (qFSCommentRecStickersBar != null && !qFSCommentRecStickersBar.f83294d.Of()) {
                String contextHashCode = qFSCommentRecStickersBar.getContextHashCode();
                String group = qFSCommentRecStickersBar.getGroup();
                if (com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(contextHashCode, group) instanceof QFSCommentRecPicBar) {
                    QLog.d("QFSCommentRecStickersBar", 1, "[onImgUpdated] show rec bar");
                    return;
                }
                JSONObject c16 = com.tencent.biz.qqcircle.comment.sticker.b.c(list);
                if (c16 != null && (optJSONArray = c16.optJSONArray("data")) != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        com.tencent.biz.qqcircle.comment.sticker.a b16 = com.tencent.biz.qqcircle.comment.sticker.a.b(optJSONArray.optJSONObject(i16));
                        if (b16 != null) {
                            arrayList.add(b16);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(contextHashCode, group);
                        return;
                    }
                    qFSCommentRecStickersBar.I(arrayList);
                    if (qFSCommentRecStickersBar.C()) {
                        com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(contextHashCode, group);
                    } else {
                        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(contextHashCode, group);
                    }
                }
            }
        }
    }

    public QFSCommentRecStickersBar(@NonNull View view, @NonNull com.tencent.biz.qqcircle.comment.abovebar.a aVar, @NonNull CommentEditText commentEditText) {
        super(view, aVar, commentEditText);
        this.E = new CopyOnWriteArrayList();
        this.G = false;
        this.H = false;
        this.I = false;
        this.K = false;
        r();
    }

    private void A() {
        ViewStub viewStub;
        if (this.f83286i != null || (viewStub = (ViewStub) this.f83295e.findViewById(R.id.f1204279i)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        QFSCommentRecommendStickersView qFSCommentRecommendStickersView = (QFSCommentRecommendStickersView) inflate.findViewById(R.id.f361313q);
        this.f83286i = qFSCommentRecommendStickersView;
        if (qFSCommentRecommendStickersView == null) {
            return;
        }
        qFSCommentRecommendStickersView.setParentContainer(inflate);
        this.f83286i.setVisibility(8);
        this.f83286i.addItemDecoration(new a());
        this.f83286i.setStickerClickListener(this.f83294d.y9());
        this.f83286i.setFeedId(this.f83294d.getFeed().f398449id.get());
        this.f83286i.setDtPageId(this.f83294d.d8().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        if (this.K) {
            return false;
        }
        this.K = true;
        an E = QFSCommentHelper.L().E(this.f83294d.getFeed(), v(), w());
        if (E == null) {
            return false;
        }
        return true ^ TextUtils.isEmpty(E.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.H = false;
        this.D = "";
        this.E.clear();
        u();
    }

    private void t() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fast_input_check_sticker_emoji", true)) {
            return;
        }
        String obj = this.f83296f.getText().toString();
        String str = this.C;
        if (s(obj) && !TextUtils.isEmpty(obj) && !TextUtils.isEmpty(str) && !TextUtils.equals(str, obj)) {
            QLog.d("QFSCommentRecStickersBar", 1, "[onImgUpdated] request again. ");
            F(obj, x());
        }
        if (TextUtils.isEmpty(obj)) {
            QLog.d("QFSCommentRecStickersBar", 1, "[onImgUpdated] hide. ");
            z(true);
        }
    }

    private FeedCloudMeta$StComment v() {
        if (this.f83294d.d8() == null) {
            return null;
        }
        return this.f83294d.d8().f421798f;
    }

    private FeedCloudMeta$StReply w() {
        if (this.f83294d.d8() == null) {
            return null;
        }
        return this.f83294d.d8().f421799g;
    }

    private String x() {
        FeedCloudMeta$StReply w3 = w();
        FeedCloudMeta$StComment v3 = v();
        FeedCloudMeta$StFeed feed = this.f83294d.getFeed();
        if (w3 != null && !TextUtils.isEmpty(w3.f398460id.get())) {
            return w3.postUser.f398463id.get();
        }
        if (v3 != null && !TextUtils.isEmpty(v3.f398447id.get())) {
            return v3.postUser.f398463id.get();
        }
        if (feed != null) {
            return feed.poster.f398463id.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) {
        if (TextUtils.isEmpty(str)) {
            z(true);
        } else if (s(str)) {
            G();
            F(str, x());
        }
    }

    public boolean C() {
        return this.H;
    }

    public void D() {
        CommentEditText commentEditText;
        TextWatcher textWatcher = this.J;
        if (textWatcher != null && (commentEditText = this.f83296f) != null) {
            commentEditText.removeTextChangedListener(textWatcher);
        }
    }

    public void F(String str, String str2) {
        if (!com.tencent.biz.qqcircle.comment.sticker.b.a(this.f83294d.getFeed())) {
            return;
        }
        this.G = false;
        this.f83287m = str;
        this.D = str2;
        boolean e16 = com.tencent.biz.qqcircle.comment.sticker.b.e(str, str2);
        L = e16;
        if (!e16 && this.H) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(getContextHashCode(), getGroup());
        }
        if (this.F == null) {
            this.F = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecStickersBar.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSCommentRecStickersBar.this.G = true;
                    QFSCommentRecStickersBar.this.E();
                }
            };
        }
        if (!this.H) {
            this.f83295e.removeCallbacks(this.F);
            this.f83295e.postDelayed(this.F, 500L);
        }
    }

    public void G() {
        if (this.I) {
            return;
        }
        com.tencent.biz.qqcircle.comment.sticker.b.d(new d(this));
        this.I = true;
    }

    public void H() {
        A();
        QFSCommentRecommendStickersView qFSCommentRecommendStickersView = this.f83286i;
        if (qFSCommentRecommendStickersView == null) {
            return;
        }
        if (this.H) {
            qFSCommentRecommendStickersView.K(this.E);
            return;
        }
        qFSCommentRecommendStickersView.H(this.E, new Runnable() { // from class: com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecStickersBar.3
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentRecStickersBar.this.z(true);
            }
        });
        this.H = true;
        QLog.d("QFSCommentRecStickersBar", 1, "show recommend stickers, comment: " + this.f83287m);
    }

    public void I(List<com.tencent.biz.qqcircle.comment.sticker.a> list) {
        this.E.clear();
        this.E.addAll(list);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 104;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        com.tencent.biz.qqcircle.comment.abovebar.a aVar;
        com.tencent.biz.qqcircle.comment.abovebar.a aVar2 = this.f83294d;
        if (aVar2 != null) {
            feedCloudMeta$StFeed = aVar2.getFeed();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (com.tencent.biz.qqcircle.comment.sticker.b.a(feedCloudMeta$StFeed) && !TextUtils.isEmpty(this.f83287m) && !TextUtils.isEmpty(this.D) && !this.E.isEmpty() && !this.G && (aVar = this.f83294d) != null && !aVar.Of()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.b
    public void j() {
        z(false);
        Runnable runnable = this.F;
        if (runnable != null) {
            this.f83295e.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        H();
        u();
        t();
        Runnable runnable = this.F;
        if (runnable != null) {
            this.f83295e.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        z(true);
    }

    public void r() {
        if (this.J == null) {
            this.J = new c();
        }
        this.f83296f.addTextChangedListener(this.J);
    }

    public boolean s(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 8 || str.contains("@")) {
            return false;
        }
        if (this.H) {
            QLog.d("QFSCommentRecStickersBar", 1, "stickers bar is showing");
        }
        if (!TextUtils.isEmpty(this.f83287m)) {
            QLog.d("QFSCommentRecStickersBar", 1, "requesting stickers.");
        }
        if (!com.tencent.biz.qqcircle.comment.sticker.b.a(this.f83294d.getFeed()) || !TextUtils.isEmpty(this.f83287m)) {
            return false;
        }
        return true;
    }

    public void u() {
        this.C = this.f83287m;
        this.f83287m = "";
        L = false;
    }

    public void z(boolean z16) {
        QFSCommentRecommendStickersView qFSCommentRecommendStickersView = this.f83286i;
        if (qFSCommentRecommendStickersView != null && this.H) {
            qFSCommentRecommendStickersView.setDismissListener(new b(z16));
            this.f83286i.F();
            E();
            QLog.d("QFSCommentRecStickersBar", 1, "hide recommend stickers.");
            return;
        }
        QLog.d("QFSCommentRecStickersBar", 1, "[hideStickersView] isShow: " + this.H);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!QFSCommentRecStickersBar.this.f83294d.V8(0) && !QFSCommentRecStickersBar.this.B()) {
                QFSCommentRecStickersBar.this.y(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

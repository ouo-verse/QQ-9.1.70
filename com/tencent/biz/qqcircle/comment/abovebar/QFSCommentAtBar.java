package com.tencent.biz.qqcircle.comment.abovebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAtBar extends com.tencent.biz.qqcircle.comment.abovebar.b implements com.tencent.biz.qqcircle.comment.at.a {
    private static final float J = RFWApplication.getApplication().getResources().getDimension(R.dimen.d0d);
    private com.tencent.biz.qqcircle.comment.at.dialog.c C;
    private TextWatcher D;
    private boolean E;
    private boolean F;
    private final List<String> G;
    private boolean H;
    private String I;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f83269i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.at.b f83270m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            rect.right = cx.a(4.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSCommentAtBar.this.F = true;
            QFSCommentAtHelper.s0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentAtBar.this.D();
            QFSCommentAtHelper.Q();
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(QFSCommentAtBar.this.getContextHashCode(), QFSCommentAtBar.this.getGroup());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements Consumer<List<o20.c>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f83276d;

        e(String str) {
            this.f83276d = str;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<o20.c> list) {
            if (RFSafeListUtils.isEmpty(list)) {
                QFSCommentAtBar.this.y();
                if (!TextUtils.isEmpty(this.f83276d)) {
                    QFSCommentAtBar.this.G.add(this.f83276d);
                }
                QFSCommentAtBar.this.E = false;
                return;
            }
            if (QFSCommentAtBar.this.f83270m != null) {
                QFSCommentAtBar.this.f83270m.setItems(list);
            }
            if (!QFSCommentAtBar.this.A() && QFSCommentAtBar.this.x()) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(QFSCommentAtBar.this.getContextHashCode(), QFSCommentAtBar.this.getGroup());
            }
        }
    }

    public QFSCommentAtBar(@NonNull View view, @NonNull com.tencent.biz.qqcircle.comment.abovebar.a aVar, @NonNull CommentEditText commentEditText) {
        super(view, aVar, commentEditText);
        this.G = new ArrayList();
        u();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        if (com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(this) == this) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.F = false;
        this.E = false;
    }

    private void E() {
        if (this.f83270m == null) {
            return;
        }
        this.f83270m.setItems(QFSCommentAtHelper.Y());
    }

    private void F() {
        if (this.F) {
            return;
        }
        z();
        g(this.f83269i, J, true, new c());
    }

    private void u() {
        if (this.D == null) {
            this.D = new a();
        }
        this.f83296f.addTextChangedListener(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(CharSequence charSequence, int i3, int i16, int i17) {
        String charSequence2 = charSequence.toString();
        final boolean z16 = false;
        if (i17 == 1 && i16 == 0) {
            if (charSequence2.substring(i3, i3 + 1).equals("@")) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFSCommentAtBar", 2, "\u8f93\u5165@\u547c\u8d77\u597d\u53cb\u9009\u62e9\u5668");
                }
            } else {
                this.f83294d.Z3(false);
                if (this.f83294d.Of() && this.H) {
                    return;
                }
            }
        }
        int length = charSequence2.length();
        if (length > i17 && i16 == 0 && i17 > 0) {
            int i18 = length - i17;
            String substring = charSequence2.substring(i18 - 1, i18);
            String substring2 = charSequence2.substring(i3, i3 + 1);
            if (TextUtils.equals(substring, " ") && !TextUtils.equals(substring2, "@")) {
                z16 = true;
            }
        }
        this.f83296f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.abovebar.QFSCommentAtBar.2
            @Override // java.lang.Runnable
            public void run() {
                int selectionStart = QFSCommentAtBar.this.f83296f.getSelectionStart();
                int t16 = af.t(QFSCommentAtBar.this.f83296f);
                if (t16 < 0 || z16) {
                    QFSCommentAtBar.this.y();
                    return;
                }
                String substring3 = QFSCommentAtBar.this.f83296f.getText().toString().substring(t16 + 1, selectionStart);
                if (!substring3.contains(" ")) {
                    QFSCommentAtBar.this.B(substring3);
                }
            }
        });
    }

    private List<o20.c> w() {
        ArrayList<o20.c> arrayList = new ArrayList();
        com.tencent.biz.qqcircle.comment.at.b bVar = this.f83270m;
        if (bVar == null) {
            return arrayList;
        }
        arrayList.addAll(bVar.getItems());
        if (RFSafeListUtils.isEmpty(arrayList)) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        o20.c cVar = null;
        for (o20.c cVar2 : arrayList) {
            if (cVar2.f() == o20.c.f421787h && cVar2.b()) {
                arrayList2.add(cVar2.a().uin);
            } else if (cVar2.f() == o20.c.f421786g) {
                Iterator<QFSCommentAtEntity> it = cVar2.e().iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().uin);
                }
                cVar = cVar2;
            }
        }
        if (cVar != null && !RFSafeListUtils.isEmpty(arrayList3) && arrayList2.containsAll(arrayList3)) {
            arrayList.remove(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(this) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        RecyclerView recyclerView = this.f83269i;
        if (recyclerView != null && this.F) {
            g(recyclerView, J, false, new d());
        }
    }

    private void z() {
        ViewStub viewStub;
        if (this.f83269i != null || (viewStub = (ViewStub) this.f83295e.findViewById(R.id.f1203879e)) == null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) viewStub.inflate();
        this.f83269i = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(h());
        linearLayoutManager.setOrientation(0);
        this.f83269i.setLayoutManager(linearLayoutManager);
        this.f83269i.setItemAnimator(null);
        this.f83269i.addItemDecoration(new b());
        this.f83270m = new com.tencent.biz.qqcircle.comment.at.b();
        this.f83269i.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f83270m}));
    }

    public void B(String str) {
        z();
        Iterator<String> it = this.G.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                y();
                return;
            }
        }
        this.E = true;
        if (!x()) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(getContextHashCode(), getGroup());
        }
        if (TextUtils.equals(this.I, str) && !TextUtils.isEmpty(this.I)) {
            QLog.d("QFSCommentAtBar", 2, "[loadUserData] return:searchKey equals mLastSearchWord, searchKey=", str);
            return;
        }
        this.I = str;
        E();
        QFSCommentAtHelper.e0(str, this.f83294d.i9(), new e(str));
    }

    public void C() {
        RFWIocAbilityProvider.g().registerIoc(this.f83295e, this, com.tencent.biz.qqcircle.comment.at.a.class);
    }

    public void G() {
        RFWIocAbilityProvider.g().unregisterSingleIoc(this.f83295e, com.tencent.biz.qqcircle.comment.at.a.class);
    }

    @Override // com.tencent.biz.qqcircle.comment.at.a
    public void a(@NonNull List<HostSelectMemberUtils.QCircleResultData> list, boolean z16) {
        y();
        if (z16) {
            Iterator<HostSelectMemberUtils.QCircleResultData> it = this.f83294d.i9().iterator();
            while (it.hasNext()) {
                HostSelectMemberUtils.QCircleResultData next = it.next();
                if (!list.contains(next)) {
                    it.remove();
                    this.f83296f.g(next);
                } else {
                    list.remove(next);
                }
            }
            if (!list.isEmpty()) {
                this.f83294d.S8(list);
            }
        }
        this.f83296f.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.abovebar.QFSCommentAtBar.7
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentAtBar.this.f83294d.showKeyboard();
                QFSCommentAtBar.this.f83294d.Z3(false);
            }
        }, 200L);
    }

    @Override // com.tencent.biz.qqcircle.comment.at.a
    public void b(@NonNull HostSelectMemberUtils.QCircleResultData qCircleResultData) {
        this.f83294d.i9().remove(qCircleResultData);
        com.tencent.biz.qqcircle.comment.at.b bVar = this.f83270m;
        if (bVar == null) {
            return;
        }
        List<o20.c> items = bVar.getItems();
        for (o20.c cVar : items) {
            if (cVar.f() == o20.c.f421787h && TextUtils.equals(cVar.a().uin, qCircleResultData.uin)) {
                cVar.d(false);
                this.f83270m.setItems(new ArrayList(items));
                return;
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.at.a
    public void c(@NonNull o20.c cVar) {
        String str;
        boolean z16 = !cVar.b();
        QFSCommentAtEntity a16 = cVar.a();
        if (z16) {
            if (TextUtils.isEmpty(a16.name)) {
                str = a16.uin;
            } else {
                str = a16.name;
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.f83294d.V8(("@" + str + " ").length())) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1910843u), 0);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a16);
            this.f83294d.S8(arrayList);
            this.f83294d.d8().f421795c.add(Boolean.valueOf(cVar.g()));
            if (cVar.g()) {
                y();
                return;
            }
        } else {
            this.f83296f.g(a16);
            this.f83294d.i9().remove(a16);
        }
        cVar.d(z16);
        List<o20.c> w3 = w();
        if (this.f83270m != null && !RFSafeListUtils.isEmpty(w3)) {
            this.f83270m.setItems(w3);
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.at.a
    public void d(@NonNull o20.c cVar) {
        if (this.f83270m == null) {
            return;
        }
        List<QFSCommentAtEntity> e16 = cVar.e();
        QFSCommentAtHelper.T(e16, this.f83294d.i9());
        this.f83294d.S8(new ArrayList(e16));
        ArrayList arrayList = new ArrayList(this.f83270m.getItems());
        arrayList.remove(cVar);
        ArrayList arrayList2 = new ArrayList();
        for (HostSelectMemberUtils.QCircleResultData qCircleResultData : this.f83294d.i9()) {
            String str = qCircleResultData.name;
            String str2 = qCircleResultData.uin;
            o20.c cVar2 = new o20.c(o20.c.f421787h);
            cVar2.c(new QFSCommentAtEntity(str2, null, str, 0));
            cVar2.d(true);
            arrayList2.add(cVar2);
            QFSCommentAtHelper.S(arrayList, str2);
        }
        arrayList.addAll(0, arrayList2);
        this.f83270m.setItems(new ArrayList(arrayList));
    }

    @Override // com.tencent.biz.qqcircle.comment.at.a
    public void e(@NonNull o20.c cVar) {
        if (fb0.a.a("QFSCommentAtBar")) {
            return;
        }
        this.f83294d.Z3(true);
        com.tencent.biz.qqcircle.comment.at.dialog.c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.dismiss();
        }
        com.tencent.biz.qqcircle.comment.at.dialog.c cVar3 = new com.tencent.biz.qqcircle.comment.at.dialog.c(h(), this, this.f83294d.i9());
        this.C = cVar3;
        cVar3.show();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 105;
    }

    @Override // com.tencent.biz.qqcircle.comment.at.a
    @NonNull
    public o20.d getReportBean() {
        return this.f83294d.d8();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return this.E;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.b
    public void j() {
        com.tencent.biz.qqcircle.comment.at.dialog.c cVar = this.C;
        if (cVar != null) {
            cVar.dismiss();
        }
        G();
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.b
    public void k(boolean z16) {
        this.H = z16;
        if (z16 && this.f83294d.Of()) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(getContextHashCode(), getGroup());
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        F();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            QFSCommentAtBar.this.v(charSequence, i3, i16, i17);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

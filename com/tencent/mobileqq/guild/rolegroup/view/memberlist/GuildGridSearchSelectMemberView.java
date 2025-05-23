package com.tencent.mobileqq.guild.rolegroup.view.memberlist;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.main.view.QQGuildChannelRecyclerViewEx;
import com.tencent.mobileqq.guild.performance.report.p;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.rolegroup.view.GuildCommonMemberSearchGridView;
import com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import xx1.b;
import xx1.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildGridSearchSelectMemberView extends LinearLayout {
    private EditText C;
    private View D;
    private GuildCommonMemberSearchGridView E;
    private xx1.b F;
    private QQGuildChannelRecyclerViewEx G;
    private xx1.c H;
    private boolean I;
    private f J;
    private boolean K;
    private boolean L;
    private GuildRoleMemberParamData M;
    private final b.a N;
    private final c.a P;
    private final RecyclerView.OnScrollListener Q;
    private final View.OnTouchListener R;

    /* renamed from: d, reason: collision with root package name */
    private final Context f232824d;

    /* renamed from: e, reason: collision with root package name */
    private View f232825e;

    /* renamed from: f, reason: collision with root package name */
    private QQProgressDialog f232826f;

    /* renamed from: h, reason: collision with root package name */
    private View f232827h;

    /* renamed from: i, reason: collision with root package name */
    private View f232828i;

    /* renamed from: m, reason: collision with root package name */
    private View f232829m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements kv1.a {
        a() {
        }

        @Override // kv1.a
        public void a() {
            if (GuildGridSearchSelectMemberView.this.K) {
                GuildGridSearchSelectMemberView.this.G.O();
                if (GuildGridSearchSelectMemberView.this.M == null || GuildGridSearchSelectMemberView.this.M.getFetchType() != 0) {
                    GuildGridSearchSelectMemberView.K(GuildGridSearchSelectMemberView.this.H.getNUM_BACKGOURND_ICON());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements b.a {
        b() {
        }

        @Override // xx1.b.a
        public void a(String[] strArr, boolean z16) {
            GuildGridSearchSelectMemberView.this.H.p0(strArr);
            GuildGridSearchSelectMemberView.this.J.h();
            if (z16) {
                GuildGridSearchSelectMemberView.this.J.e();
            }
        }

        @Override // xx1.b.a
        public void b() {
            GuildGridSearchSelectMemberView.this.J.h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements c.a {
        c() {
        }

        private List<b.C11573b> h(RoleGroupUserUIData[] roleGroupUserUIDataArr) {
            ArrayList arrayList = new ArrayList();
            for (RoleGroupUserUIData roleGroupUserUIData : roleGroupUserUIDataArr) {
                b.C11573b c11573b = new b.C11573b(0);
                c11573b.f448974c = roleGroupUserUIData.getMName();
                c11573b.f448973b = roleGroupUserUIData.getMTinyId();
                arrayList.add(c11573b);
            }
            return arrayList;
        }

        @Override // xx1.c.a
        public void a(RoleGroupUserUIData roleGroupUserUIData) {
            GuildGridSearchSelectMemberView.this.J.a(roleGroupUserUIData);
        }

        @Override // xx1.c.a
        public void b() {
            GuildGridSearchSelectMemberView.this.J.h();
            GuildGridSearchSelectMemberView.this.L();
        }

        @Override // xx1.c.a
        public void c() {
            GuildGridSearchSelectMemberView.this.J.h();
            GuildGridSearchSelectMemberView.this.x();
        }

        @Override // xx1.c.a
        public void d() {
            GuildGridSearchSelectMemberView.this.J.e();
        }

        @Override // xx1.c.a
        public void e(RoleGroupUserUIData roleGroupUserUIData) {
            if (roleGroupUserUIData == null) {
                return;
            }
            GuildGridSearchSelectMemberView.this.J.i(roleGroupUserUIData);
        }

        @Override // xx1.c.a
        public void f(RoleGroupUserUIData[] roleGroupUserUIDataArr) {
            String[] strArr = new String[roleGroupUserUIDataArr.length];
            for (int i3 = 0; i3 < roleGroupUserUIDataArr.length; i3++) {
                strArr[i3] = roleGroupUserUIDataArr[i3].getMTinyId();
            }
            GuildGridSearchSelectMemberView.this.F.i(strArr, true);
        }

        @Override // xx1.c.a
        public void g(String str, RoleGroupUserUIData[] roleGroupUserUIDataArr) {
            GuildGridSearchSelectMemberView.this.F.b(str, h(roleGroupUserUIDataArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            LinearLayoutManager linearLayoutManager;
            if (i3 == 0 || (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()) == null) {
                return;
            }
            if (GuildGridSearchSelectMemberView.this.H.getNUM_BACKGOURND_ICON() - linearLayoutManager.findLastVisibleItemPosition() < 20) {
                if (GuildGridSearchSelectMemberView.this.I) {
                    GuildGridSearchSelectMemberView.this.J.c();
                } else {
                    GuildGridSearchSelectMemberView.this.J.f();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements View.OnTouchListener {
        e() {
        }

        private void a() {
            if (!GuildGridSearchSelectMemberView.this.C.hasFocus()) {
                GuildGridSearchSelectMemberView.this.I = true;
                GuildGridSearchSelectMemberView.this.f232828i.findViewById(R.id.kag).setVisibility(8);
                GuildGridSearchSelectMemberView.this.C.setHint(GuildGridSearchSelectMemberView.this.getResources().getString(R.string.f155451hj));
                if (TextUtils.isEmpty(GuildGridSearchSelectMemberView.this.C.getText())) {
                    GuildGridSearchSelectMemberView.this.f232829m.setVisibility(8);
                } else {
                    GuildGridSearchSelectMemberView.this.f232829m.setVisibility(0);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!GuildGridSearchSelectMemberView.this.C.hasFocus()) {
                a();
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface f {
        void a(RoleGroupUserUIData roleGroupUserUIData);

        void b();

        void c();

        void d(String str);

        void e();

        void f();

        void g();

        void h();

        void i(RoleGroupUserUIData roleGroupUserUIData);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && i3 == 67 && TextUtils.isEmpty(((EditText) view).getText())) {
                List<b.C11573b> d16 = GuildGridSearchSelectMemberView.this.F.d();
                GuildGridSearchSelectMemberView.this.F.i(new String[]{d16.get(d16.size() - 1).f448973b}, false);
                if (GuildGridSearchSelectMemberView.this.F.d().isEmpty()) {
                    GuildGridSearchSelectMemberView.this.J.e();
                }
            }
            return false;
        }
    }

    public GuildGridSearchSelectMemberView(Context context) {
        this(context, null);
    }

    private void A(int i3) {
        this.f232827h = this.f232825e.findViewById(R.id.wqx);
        View findViewById = this.f232825e.findViewById(R.id.search_box);
        this.f232828i = findViewById;
        this.C = (EditText) findViewById.findViewById(R.id.et_search_keyword);
        if (i3 != 0 && i3 != 1 && i3 != 7) {
            if (i3 != 2 && i3 != 6 && i3 != 3 && i3 != 8) {
                if (i3 == 5) {
                    this.f232827h.setVisibility(8);
                }
            } else {
                B();
            }
        } else {
            B();
            z();
        }
        View findViewById2 = this.f232825e.findViewById(R.id.vwr);
        this.D = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: fy1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildGridSearchSelectMemberView.this.F(view);
            }
        });
    }

    private void B() {
        this.f232827h.setVisibility(0);
        this.f232828i.setVisibility(0);
        this.C.clearFocus();
        h hVar = new h(false);
        hVar.b(this.C);
        this.C.addTextChangedListener(hVar);
        this.C.setOnTouchListener(this.R);
        View findViewById = this.f232828i.findViewById(R.id.ib_clear_text);
        this.f232829m = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: fy1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildGridSearchSelectMemberView.this.G(view);
            }
        });
        this.f232825e.setFocusableInTouchMode(true);
    }

    private void D() {
        View inflate = LayoutInflater.from(this.f232824d).inflate(R.layout.est, this);
        this.f232825e = inflate;
        QQGuildChannelRecyclerViewEx qQGuildChannelRecyclerViewEx = (QQGuildChannelRecyclerViewEx) inflate.findViewById(R.id.z26);
        this.G = qQGuildChannelRecyclerViewEx;
        qQGuildChannelRecyclerViewEx.setLayoutManager(new LinearLayoutManager(getContext()));
        this.G.addOnScrollListener(this.Q);
        this.G.setDrawListener(u());
        this.f232826f = new QQProgressDialog(this.f232824d);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.J.b();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        t(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (this.L) {
            this.f232826f.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(int i3) {
        p.b(i3);
    }

    private kv1.a u() {
        return new a();
    }

    private void z() {
        this.E = (GuildCommonMemberSearchGridView) this.f232825e.findViewById(R.id.f80934ct);
        xx1.b bVar = new xx1.b(this.E, new h(true), new g(), this.N);
        this.F = bVar;
        this.E.setAdapter((ListAdapter) bVar);
        this.E.setNumColumns((bi.d() - ViewUtils.dpToPx(20.0f)) / ViewUtils.dpToPx(83.0f));
        this.E.setMaxHeight(ViewUtils.dpToPx(120.0f));
        x();
    }

    public void C() {
        this.E.setNumColumns((bi.d() - ViewUtils.dpToPx(20.0f)) / ViewUtils.dpToPx(83.0f));
    }

    public boolean E() {
        return this.I;
    }

    public void I() {
        xx1.b bVar = this.F;
        if (bVar != null) {
            bVar.h();
        }
        xx1.c cVar = this.H;
        if (cVar != null) {
            cVar.onDestroy();
        }
        s();
    }

    public void J(RoleGroupUserUIData roleGroupUserUIData) {
        this.H.o0(roleGroupUserUIData);
    }

    public void L() {
        if (this.E.getVisibility() == 0) {
            return;
        }
        this.f232828i.setVisibility(8);
        this.E.setVisibility(0);
        this.f232829m.setVisibility(8);
        this.C.setHint((CharSequence) null);
        EditText editText = this.F.f448966d;
        if (editText != null) {
            editText.setText(this.C.getText());
        }
        this.C.setText("");
    }

    public void M() {
        this.L = true;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: fy1.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildGridSearchSelectMemberView.this.H();
            }
        }, 500L);
    }

    public void N(boolean z16) {
        if (this.M.getLayoutType() != 2 && this.M.getLayoutType() != 6 && this.M.getLayoutType() != 5) {
            this.D.setVisibility(8);
        } else if (z16) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    public void p(String str, List<b.C11573b> list) {
        this.F.b(str, list);
    }

    public void q() {
        this.H.i0();
    }

    public void r() {
        EditText editText = this.C;
        if (editText == null) {
            return;
        }
        editText.clearFocus();
        InputMethodUtil.hide(this.C);
    }

    public void s() {
        this.L = false;
        QQProgressDialog qQProgressDialog = this.f232826f;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f232826f.dismiss();
        }
    }

    public void setItemUncheckedFromGridView(String[] strArr) {
        this.H.p0(strArr);
    }

    public void setRecyclerViewItemData(String str, List<RoleGroupUserUIData> list) {
        this.H.q0(str, list);
        this.K = true;
    }

    public void setSelectIdItems(String[] strArr) {
        this.H.r0(strArr);
    }

    public void t(boolean z16) {
        this.I = false;
        if (this.C == null) {
            return;
        }
        this.f232829m.setVisibility(8);
        if (z16) {
            this.C.setHint((CharSequence) null);
            this.C.setText("");
            this.f232828i.findViewById(R.id.kag).setVisibility(0);
            if (this.C.isFocused()) {
                InputMethodUtil.hide(this.C);
                this.C.clearFocus();
                this.J.e();
            }
        }
        this.J.g();
    }

    public List<String> v() {
        return this.H.j0();
    }

    public Set<String> w() {
        return this.H.k0();
    }

    public void x() {
        this.E.setVisibility(8);
        this.f232828i.setVisibility(0);
        this.f232828i.findViewById(R.id.kag).setVisibility(0);
    }

    public void y(GuildRoleMemberParamData guildRoleMemberParamData, f fVar) {
        this.M = guildRoleMemberParamData;
        A(guildRoleMemberParamData.getLayoutType());
        N(true);
        this.J = fVar;
        xx1.c cVar = new xx1.c(guildRoleMemberParamData.getLayoutType(), this.P, guildRoleMemberParamData.getMaxCountCanSelect());
        this.H = cVar;
        this.G.setAdapter(cVar);
    }

    public GuildGridSearchSelectMemberView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public GuildGridSearchSelectMemberView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildGridSearchSelectMemberView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = new b();
        this.P = new c();
        this.Q = new d();
        this.R = new e();
        this.f232824d = context;
        D();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private final boolean f232836d;

        /* renamed from: e, reason: collision with root package name */
        private EditText f232837e;

        h(boolean z16) {
            this.f232836d = z16;
        }

        private String a() {
            EditText editText = this.f232837e;
            if (editText != null) {
                return editText.getText().toString().trim();
            }
            return "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String a16 = a();
            if (!TextUtils.isEmpty(a16)) {
                GuildGridSearchSelectMemberView.this.I = true;
                GuildGridSearchSelectMemberView.this.f232829m.setVisibility(0);
                GuildGridSearchSelectMemberView.this.J.d(a16);
            } else if (GuildGridSearchSelectMemberView.this.I) {
                GuildGridSearchSelectMemberView.this.f232829m.setVisibility(8);
                GuildGridSearchSelectMemberView.this.t(this.f232836d);
            }
        }

        public void b(EditText editText) {
            this.f232837e = editText;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

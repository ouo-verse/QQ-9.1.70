package com.tencent.open.agent;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.util.t;
import com.tencent.open.widget.QUSFloatingViewDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenAuthorityAccountView extends BaseAuthorityAccountView {
    private View M;
    private OpenCardContainer.c N;
    private boolean P;
    private QUSFloatingViewDialog Q;
    private QUIListItemAdapter R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (OpenAuthorityAccountView.this.N != null) {
                OpenAuthorityAccountView.this.N.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            RecyclerView recyclerView = (RecyclerView) OpenAuthorityAccountView.this.G.findViewById(R.id.i4m);
            if (recyclerView == null || OpenAuthorityAccountView.this.R == null) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            RecyclerView recyclerView = (RecyclerView) OpenAuthorityAccountView.this.G.findViewById(R.id.i4m);
            if (recyclerView == null || OpenAuthorityAccountView.this.R == null) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() >= OpenAuthorityAccountView.this.R.getNUM_BACKGOURND_ICON() - 1) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            return OpenAuthorityAccountView.this.G;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            OpenAuthorityAccountView.this.Q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f339852d;

        d(String str) {
            this.f339852d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OpenAuthorityAccountView.this.n(this.f339852d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f339854d;

        e(String str) {
            this.f339854d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!OpenAuthorityAccountView.this.l(this.f339854d, true)) {
                Context context = OpenAuthorityAccountView.this.f339579f;
                if (context instanceof QuickLoginAuthorityActivity) {
                    ((QuickLoginAuthorityActivity) context).H2(this.f339854d, true);
                }
            }
            OpenAuthorityAccountView.this.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements Function2<ImageView, String, Unit> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(ImageView imageView, String str) {
            OpenAuthorityAccountView.this.p(str, imageView);
            return Unit.INSTANCE;
        }
    }

    public OpenAuthorityAccountView(Context context) {
        this(context, null);
    }

    private void x() {
        RecyclerView recyclerView = (RecyclerView) this.G.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        this.R = qUIListItemAdapter;
        recyclerView.setAdapter(qUIListItemAdapter);
        this.G.findViewById(R.id.f163887b9).setVisibility(8);
        s();
    }

    private void y() {
        this.I.setVisibility(8);
        x();
        QUSFloatingViewDialog qUSFloatingViewDialog = new QUSFloatingViewDialog(getContext(), new b());
        this.Q = qUSFloatingViewDialog;
        qUSFloatingViewDialog.setOnDismissListener(new c());
    }

    private void z() {
        t.b("OpenAuthorityAccountView", "-->initUI");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setOrientation(1);
        View inflate = LayoutInflater.from(this.f339579f).inflate(R.layout.f168454wl, (ViewGroup) null);
        this.F = inflate;
        addView(inflate, layoutParams);
        i();
        this.H.setOnClickListener(new a());
        this.M = findViewById(R.id.im7);
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public void c() {
        QUSFloatingViewDialog qUSFloatingViewDialog;
        if (this.P && (qUSFloatingViewDialog = this.Q) != null && qUSFloatingViewDialog.isShowing()) {
            this.Q.dismiss();
        } else {
            super.c();
        }
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected String d() {
        OpenCardContainer.c cVar = this.N;
        if (cVar == null) {
            t.e("OpenAuthorityAccountView", "findCurAccount listener is null");
            return null;
        }
        String currentAccount = cVar.getCurrentAccount();
        t.f("OpenAuthorityAccountView", "findCurAccount: " + currentAccount);
        return currentAccount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public int e() {
        if (this.P) {
            return R.layout.ftq;
        }
        return super.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public int f() {
        if (this.P) {
            return R.layout.ftm;
        }
        return super.f();
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean l(String str, boolean z16) {
        OpenCardContainer.c cVar;
        if ((this.f339579f instanceof PublicFragmentActivityForOpenSDK) && (cVar = this.N) != null) {
            cVar.c(str, z16);
            return true;
        }
        return false;
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    protected boolean m() {
        Context context = this.f339579f;
        if (context != null && (context instanceof PublicFragmentActivityForOpenSDK)) {
            OpenCardContainer.c cVar = this.N;
            if (cVar != null) {
                cVar.a();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public void o() {
        if (!this.L) {
            s();
            this.L = true;
        }
        if (this.P) {
            if (this.Q == null) {
                y();
            }
            if (!this.Q.isShowing()) {
                this.Q.show();
                return;
            }
            return;
        }
        super.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseAuthorityAccountView
    public void s() {
        if (this.R == null) {
            t.e("OpenAuthorityAccountView", "updateDropDownViews adapter is null");
            return;
        }
        ArrayList<String> arrayList = this.f339581i;
        if (arrayList != null && arrayList.size() != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.f339581i.size(); i3++) {
                String str = this.f339581i.get(i3);
                t.f("OpenAuthorityAccountView", "updateDropDownViews \u7b2c" + i3 + "\u8d26\u53f7: " + MsfSdkUtils.getShortUin(str));
                String c16 = com.tencent.mobileqq.login.account.b.c(str);
                if (TextUtils.isEmpty(c16)) {
                    c16 = str;
                }
                d dVar = new d(str);
                c.a.C8993c c8993c = new c.a.C8993c(c16, str, str);
                c.b.a aVar = new c.b.a("", null, true, dVar);
                aVar.g("\u5220\u9664");
                com.tencent.mobileqq.widget.listitem.c cVar = new com.tencent.mobileqq.widget.listitem.c(c8993c, aVar);
                cVar.x(new e(str));
                cVar.S(new f());
                linkedList.add(cVar);
            }
            com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[linkedList.size()];
            for (int i16 = 0; i16 < linkedList.size(); i16++) {
                aVarArr[i16] = (com.tencent.mobileqq.widget.listitem.a) linkedList.get(i16);
            }
            this.R.t0(new Group(aVarArr));
        }
    }

    public void setAccountEventListener(OpenCardContainer.c cVar) {
        this.N = cVar;
    }

    public void setMainAccountSelect(boolean z16) {
        int i3 = 0;
        t.b("OpenAuthorityAccountView", "setMainAccountSelect select=" + z16);
        View view = this.M;
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public OpenAuthorityAccountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OpenAuthorityAccountView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = null;
        this.P = lq3.a.a();
        t.f("OpenAuthorityAccountView", "isUseSlideDialog: " + this.P);
        z();
    }
}

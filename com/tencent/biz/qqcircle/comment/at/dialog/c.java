package com.tencent.biz.qqcircle.comment.at.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Size;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ExpandableListView;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends ReportDialog implements com.tencent.biz.qqcircle.comment.at.dialog.a, View.OnClickListener, DialogInterface.OnDismissListener {
    private final com.tencent.biz.qqcircle.comment.at.a C;
    private final View D;
    View E;
    ScrollView F;
    private final boolean[] G;
    private final QUSHalfScreenFloatingView H;
    private ExpandableListView I;
    private final List<HostSelectMemberUtils.QCircleResultData> J;
    private com.tencent.biz.qqcircle.comment.at.dialog.d K;
    private TextView L;
    private QFSCommentAtSearchExt.a<QFSCommentAtEntity> M;
    private com.tencent.biz.qqcircle.comment.at.dialog.e N;
    private RecyclerView P;
    private QuickPinyinEditText Q;
    private TextView R;
    private boolean S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            boolean z16 = false;
            if (c.this.I != null) {
                if (c.this.I.getFirstVisiblePosition() != 0) {
                    return true;
                }
                View childAt = c.this.I.getChildAt(0);
                boolean[] zArr = c.this.G;
                if (childAt == null || childAt.getTop() != 0) {
                    z16 = true;
                }
                zArr[1] = z16;
                return c.this.G[1];
            }
            if (c.this.F.getScrollY() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            boolean z16 = true;
            if (c.this.I != null) {
                if (c.this.I.getLastVisiblePosition() != c.this.I.getChildCount() - 1) {
                    return true;
                }
                View childAt = c.this.I.getChildAt(c.this.I.getChildCount() - 1);
                boolean[] zArr = c.this.G;
                if (childAt != null && childAt.getBottom() == c.this.I.getHeight()) {
                    z16 = false;
                }
                zArr[0] = z16;
                return c.this.G[0];
            }
            if (c.this.F.getScrollY() == c.this.E.getHeight() + c.this.F.getHeight()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            c cVar = c.this;
            cVar.E = LayoutInflater.from(cVar.getContext()).inflate(R.layout.f168661g91, (ViewGroup) null);
            c.this.initView();
            return c.this.E;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends QFSCommentAtSearchExt.a<QFSCommentAtEntity> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QFSCommentAtEntity f83511d;

            a(QFSCommentAtEntity qFSCommentAtEntity) {
                this.f83511d = qFSCommentAtEntity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.this.M.removeItem(this.f83511d);
                c.this.J.remove(this.f83511d);
                c.this.K.notifyDataSetChanged();
                c.this.n0();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.a
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void i0(QFSCommentAtSearchExt.b bVar, int i3, QFSCommentAtEntity qFSCommentAtEntity) {
            QCircleAvatarView qCircleAvatarView = bVar.E;
            String g16 = qFSCommentAtEntity.g();
            String e16 = qFSCommentAtEntity.e();
            int i16 = this.f83508m;
            qCircleAvatarView.setAvatar(g16, e16, new Size(i16, i16));
            bVar.itemView.setOnClickListener(new a(qFSCommentAtEntity));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.a
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public void l0(QFSCommentAtEntity qFSCommentAtEntity) {
            super.l0(qFSCommentAtEntity);
            c.this.J.remove(qFSCommentAtEntity);
            c.this.K.notifyDataSetChanged();
            c.this.n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements Consumer<List<o20.b>> {
        d() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<o20.b> list) {
            if (RFSafeListUtils.isEmpty(list)) {
                c.this.R.setVisibility(0);
                c.this.N.setItems(new ArrayList());
            } else {
                c.this.R.setVisibility(8);
                c.this.N.setItems(new ArrayList(list));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements ExpandableListView.OnChildClickListener {
        e() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i3, int i16, long j3) {
            QFSCommentAtEntity qFSCommentAtEntity = (QFSCommentAtEntity) c.this.K.getChild(i3, i16);
            if (c.this.K.a(qFSCommentAtEntity, c.this.J)) {
                c.this.J.remove(qFSCommentAtEntity);
                c.this.M.removeItem(qFSCommentAtEntity);
            } else {
                c.this.J.add(qFSCommentAtEntity);
                c.this.M.addLast(qFSCommentAtEntity);
            }
            c.this.K.notifyDataSetChanged();
            c.this.n0();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements Consumer<Map<Groups, List<QFSCommentAtEntity>>> {
        f() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<Groups, List<QFSCommentAtEntity>> map) {
            int i3;
            ArrayList arrayList = new ArrayList();
            SparseArray<List<QFSCommentAtEntity>> sparseArray = new SparseArray<>();
            int i16 = 0;
            for (Map.Entry<Groups, List<QFSCommentAtEntity>> entry : map.entrySet()) {
                Groups key = entry.getKey();
                if (i16 == 0 && (i3 = key.group_id) != 1003 && i3 != 1100 && i3 != 1010) {
                    i16 = arrayList.size();
                }
                arrayList.add(key);
                sparseArray.put(key.group_id, entry.getValue());
            }
            c.this.K.c(arrayList, sparseArray);
            if (!QFSCommentAtHelper.g0() && !QFSCommentAtHelper.h0()) {
                c.this.I.expandGroup(i16);
            } else {
                c.this.K.notifyDataSetChanged();
            }
        }
    }

    public c(@NonNull Context context, com.tencent.biz.qqcircle.comment.at.a aVar, List<HostSelectMemberUtils.QCircleResultData> list) {
        super(context, R.style.f173448dl);
        this.G = new boolean[2];
        this.C = aVar;
        this.J = new ArrayList(list);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168660g90, (ViewGroup) null);
        this.D = inflate;
        setContentView(inflate);
        this.H = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        e0();
        setOnDismissListener(this);
    }

    private List<QFSCommentAtEntity> a0() {
        ArrayList arrayList = new ArrayList();
        for (HostSelectMemberUtils.QCircleResultData qCircleResultData : this.J) {
            if (!arrayList.contains(qCircleResultData)) {
                if (qCircleResultData instanceof QFSCommentAtEntity) {
                    arrayList.add((QFSCommentAtEntity) qCircleResultData);
                } else {
                    arrayList.add(new QFSCommentAtEntity(qCircleResultData.uin, null, qCircleResultData.name, 0));
                }
            }
        }
        return arrayList;
    }

    private void b0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CHOOSE_FRI_MULTIPLE_DONE_BUTTON);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_ID, QFSCommentReportHelper.r(this.J));
        int i3 = 1;
        if (this.J.size() <= 1) {
            i3 = 0;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QQ_GROUP, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, this.C.getReportBean().d());
        buildElementParams.put("xsj_custom_pgid", this.C.getReportBean().a());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void c0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CHOOSE_FRI_MULTIPLE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, this.C.getReportBean().d());
        buildElementParams.put("xsj_custom_pgid", this.C.getReportBean().a());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P.setVisibility(8);
            this.R.setVisibility(8);
        } else {
            this.P.setVisibility(0);
            QFSCommentAtHelper.V(str, this.J, new d());
        }
    }

    private void e0() {
        this.H.setDraggable(false);
        this.H.q();
        this.H.setQUSDragFloatController(new a());
        this.H.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.comment.at.dialog.b
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                c.this.dismiss();
            }
        });
    }

    private void f0() {
        this.I = (ExpandableListView) this.E.findViewById(R.id.ebs);
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar = new com.tencent.biz.qqcircle.comment.at.dialog.d(getContext(), this.J);
        this.K = dVar;
        this.I.setAdapter(dVar);
        this.I.setOnChildClickListener(new e());
        k0();
    }

    private void g0() {
        getWindow().setSoftInputMode(3);
        QUISearchBar qUISearchBar = (QUISearchBar) this.E.findViewById(R.id.iir);
        qUISearchBar.setBackgroundColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_middle_light));
        i0(qUISearchBar);
        QFSCommentAtSearchExt qFSCommentAtSearchExt = new QFSCommentAtSearchExt(qUISearchBar);
        b bVar = new b();
        this.M = bVar;
        bVar.updateData(a0());
        qFSCommentAtSearchExt.d(this.M);
        qUISearchBar.setSearchBarLayoutExt(qFSCommentAtSearchExt);
    }

    private void i0(QUISearchBar qUISearchBar) {
        QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
        this.Q = inputWidget;
        inputWidget.setTextSize(1, 16.0f);
        this.Q.addTextChangedListener(new C0851c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.E.findViewById(R.id.dum).setOnClickListener(this);
        TextView textView = (TextView) this.D.findViewById(R.id.f106986_7);
        this.L = textView;
        textView.setOnClickListener(this);
        f0();
        g0();
        j0();
        n0();
        c0();
    }

    private void j0() {
        TextView textView = (TextView) this.E.findViewById(R.id.f80864cm);
        this.R = textView;
        textView.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) this.E.findViewById(R.id.f81114da);
        this.P = recyclerView;
        recyclerView.setVisibility(8);
        this.P.setLayoutManager(new LinearLayoutManager(getContext()));
        this.P.setItemAnimator(null);
        this.N = new com.tencent.biz.qqcircle.comment.at.dialog.e();
        this.P.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.N}));
        RFWIocAbilityProvider.g().registerIoc(this.P, this, com.tencent.biz.qqcircle.comment.at.dialog.a.class);
    }

    private void k0() {
        QFSCommentAtHelper.U(new f());
    }

    private boolean l0(@NonNull MotionEvent motionEvent) {
        Activity m06 = m0(getContext());
        if (m06 != null && m06.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private static Activity m0(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return m0(((ContextWrapper) context).getBaseContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        int size = this.J.size();
        boolean z16 = true;
        this.L.setText(RFWApplication.getApplication().getString(R.string.f188323wd, Integer.valueOf(size)));
        TextView textView = this.L;
        if (size <= 0) {
            z16 = false;
        }
        textView.setEnabled(z16);
    }

    @Override // com.tencent.biz.qqcircle.comment.at.dialog.a
    public void Z7(@NonNull o20.b bVar) {
        if (bVar.b()) {
            return;
        }
        QFSCommentAtEntity a16 = bVar.a();
        this.J.add(a16);
        this.M.addLast(a16);
        this.K.notifyDataSetChanged();
        n0();
        this.Q.setText((CharSequence) null);
        this.P.setVisibility(8);
        InputMethodUtil.hide(this.Q);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.dum) {
            this.H.t();
        } else if (id5 == R.id.f106986_7 && !FastClickUtils.isFastDoubleClick("QFSCommentAtDialog")) {
            this.S = true;
            dismiss();
            b0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.C.a(this.J, this.S);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!super.onTouchEvent(motionEvent) && !l0(motionEvent)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.at.dialog.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0851c implements TextWatcher {
        C0851c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            c cVar = c.this;
            cVar.d0(cVar.Q.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

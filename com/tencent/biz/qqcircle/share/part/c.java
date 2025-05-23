package com.tencent.biz.qqcircle.share.part;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt;
import com.tencent.biz.qqcircle.immersive.events.QFSQQFriendsSelectChangedEvent;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends Part implements com.tencent.biz.qqcircle.comment.at.dialog.a {
    private QuickPinyinEditText C;
    private TextView D;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<HostSelectMemberUtils.QCircleResultData> f92415d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ExpandableListView f92416e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.at.dialog.d f92417f;

    /* renamed from: h, reason: collision with root package name */
    private QFSCommentAtSearchExt.a<QFSCommentAtEntity> f92418h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.at.dialog.e f92419i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f92420m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ExpandableListView.OnChildClickListener {
        a() {
        }

        @Override // com.tencent.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i3, int i16, long j3) {
            QFSCommentAtEntity qFSCommentAtEntity = (QFSCommentAtEntity) c.this.f92417f.getChild(i3, i16);
            if (c.this.f92417f.a(qFSCommentAtEntity, c.this.f92415d)) {
                c.this.P9(qFSCommentAtEntity.uin);
                c.this.f92418h.removeItem(qFSCommentAtEntity);
            } else {
                if (c.this.f92415d.size() >= 9) {
                    yb0.c.h(c.this.getActivity());
                    QLog.d("QFSQQFriendsListPart", 1, "[initListView] most choose 9");
                    return true;
                }
                c.this.f92415d.add(qFSCommentAtEntity);
                c.this.f92418h.addLast(qFSCommentAtEntity);
            }
            c.this.f92417f.notifyDataSetChanged();
            c.this.R9();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Consumer<Map<Groups, List<QFSCommentAtEntity>>> {
        b() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<Groups, List<QFSCommentAtEntity>> map) {
            ArrayList arrayList = new ArrayList();
            SparseArray<List<QFSCommentAtEntity>> sparseArray = new SparseArray<>();
            for (Map.Entry<Groups, List<QFSCommentAtEntity>> entry : map.entrySet()) {
                Groups key = entry.getKey();
                arrayList.add(key);
                sparseArray.put(key.group_id, entry.getValue());
            }
            c.this.f92417f.c(arrayList, sparseArray);
            c.this.f92416e.expandGroup(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.share.part.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0930c extends QFSCommentAtSearchExt.a<QFSCommentAtEntity> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.share.part.c$c$a */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QFSCommentAtEntity f92423d;

            a(QFSCommentAtEntity qFSCommentAtEntity) {
                this.f92423d = qFSCommentAtEntity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.this.f92418h.removeItem(this.f92423d);
                c.this.P9(this.f92423d.uin);
                c.this.f92417f.notifyDataSetChanged();
                c.this.R9();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        C0930c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.a
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void i0(QFSCommentAtSearchExt.b bVar, int i3, QFSCommentAtEntity qFSCommentAtEntity) {
            QFSCommentAtHelper.t0(qFSCommentAtEntity.e(), qFSCommentAtEntity.f(), bVar.E);
            bVar.itemView.setOnClickListener(new a(qFSCommentAtEntity));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.comment.at.dialog.QFSCommentAtSearchExt.a
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public void l0(QFSCommentAtEntity qFSCommentAtEntity) {
            super.l0(qFSCommentAtEntity);
            c.this.P9(qFSCommentAtEntity.uin);
            c.this.f92417f.notifyDataSetChanged();
            c.this.R9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements Consumer<List<o20.b>> {
        e() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<o20.b> list) {
            if (RFSafeListUtils.isEmpty(list)) {
                c.this.D.setVisibility(0);
                c.this.f92419i.setItems(new ArrayList());
            } else {
                c.this.D.setVisibility(8);
                c.this.f92419i.setItems(new ArrayList(list));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                c.this.f92419i.notifyDataSetChanged();
            }
        }
    }

    public c(ArrayList<com.tencent.mobileqq.multishare.action.c> arrayList) {
        Q9(arrayList);
    }

    private List<QFSCommentAtEntity> I9() {
        ArrayList arrayList = new ArrayList();
        Iterator<HostSelectMemberUtils.QCircleResultData> it = this.f92415d.iterator();
        while (it.hasNext()) {
            HostSelectMemberUtils.QCircleResultData next = it.next();
            if (!arrayList.contains(next)) {
                if (next instanceof QFSCommentAtEntity) {
                    arrayList.add((QFSCommentAtEntity) next);
                } else {
                    arrayList.add(new QFSCommentAtEntity(next.uin, null, next.name, 0, next.uinType));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f92420m.setVisibility(8);
            this.D.setVisibility(8);
        } else {
            this.f92420m.setVisibility(0);
            QFSCommentAtHelper.c0(str, this.f92415d, new e());
            this.f92420m.addOnScrollListener(new f());
        }
    }

    private void K9(View view) {
        this.f92416e = (ExpandableListView) view.findViewById(R.id.ebs);
        com.tencent.biz.qqcircle.comment.at.dialog.d dVar = new com.tencent.biz.qqcircle.comment.at.dialog.d(getContext(), this.f92415d, 1);
        this.f92417f = dVar;
        this.f92416e.setAdapter(dVar);
        this.f92416e.setOnChildClickListener(new a());
        O9();
    }

    private void L9(View view) {
        if ((getPartHost() instanceof DialogFragment) && ((DialogFragment) getPartHost()).getDialog() != null && ((DialogFragment) getPartHost()).getDialog().getWindow() != null) {
            ((DialogFragment) getPartHost()).getDialog().getWindow().setSoftInputMode(3);
        }
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.iir);
        qUISearchBar.setBackgroundColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_middle_light));
        M9(qUISearchBar);
        QFSCommentAtSearchExt qFSCommentAtSearchExt = new QFSCommentAtSearchExt(qUISearchBar);
        C0930c c0930c = new C0930c();
        this.f92418h = c0930c;
        c0930c.updateData(I9());
        qFSCommentAtSearchExt.d(this.f92418h);
        qUISearchBar.setSearchBarLayoutExt(qFSCommentAtSearchExt);
    }

    private void M9(QUISearchBar qUISearchBar) {
        QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
        this.C = inputWidget;
        inputWidget.setTextSize(1, 16.0f);
        this.C.addTextChangedListener(new d());
    }

    private void N9(View view) {
        TextView textView = (TextView) view.findViewById(R.id.f80864cm);
        this.D = textView;
        textView.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f81114da);
        this.f92420m = recyclerView;
        recyclerView.setVisibility(8);
        this.f92420m.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f92420m.setItemAnimator(null);
        this.f92419i = new com.tencent.biz.qqcircle.comment.at.dialog.e(1);
        this.f92420m.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f92419i}));
        RFWIocAbilityProvider.g().registerIoc(this.f92420m, this, com.tencent.biz.qqcircle.comment.at.dialog.a.class);
    }

    private void O9() {
        QFSCommentAtHelper.b0(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(String str) {
        Iterator<HostSelectMemberUtils.QCircleResultData> it = this.f92415d.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().uin, str)) {
                it.remove();
            }
        }
    }

    private void Q9(ArrayList<com.tencent.mobileqq.multishare.action.c> arrayList) {
        this.f92415d.clear();
        Iterator<com.tencent.mobileqq.multishare.action.c> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.multishare.action.c next = it.next();
            HostSelectMemberUtils.QCircleResultData qCircleResultData = new HostSelectMemberUtils.QCircleResultData();
            qCircleResultData.uin = next.f();
            qCircleResultData.name = next.e();
            qCircleResultData.uinType = next.g();
            this.f92415d.add(qCircleResultData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9() {
        ArrayList arrayList = new ArrayList();
        Iterator<HostSelectMemberUtils.QCircleResultData> it = this.f92415d.iterator();
        while (it.hasNext()) {
            HostSelectMemberUtils.QCircleResultData next = it.next();
            arrayList.add(new com.tencent.mobileqq.multishare.action.c(next.uin, next.uinType, next.name));
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSQQFriendsSelectChangedEvent(arrayList));
    }

    @Override // com.tencent.biz.qqcircle.comment.at.dialog.a
    public void Z7(@NonNull o20.b bVar) {
        if (bVar.b()) {
            return;
        }
        if (this.f92415d.size() >= 9) {
            yb0.c.h(getActivity());
            QLog.d("QFSQQFriendsListPart", 1, "[onSearchItemClick] most choose 9");
            return;
        }
        QFSCommentAtEntity a16 = bVar.a();
        this.f92415d.add(a16);
        this.f92418h.addLast(a16);
        this.f92417f.notifyDataSetChanged();
        R9();
        this.C.setText((CharSequence) null);
        this.f92420m.setVisibility(8);
        InputMethodUtil.hide(this.C);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        K9(view);
        L9(view);
        N9(view);
        R9();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            c cVar = c.this;
            cVar.J9(cVar.C.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

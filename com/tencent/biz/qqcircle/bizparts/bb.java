package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.events.QFSForceTabRefreshEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.video.RFWVideoConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lb0.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bb extends Part implements Observer<b.a>, View.OnClickListener {
    private RFWSmartPopupWindow C;
    private TextView D;
    private ArrayList<e> E;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, WeakReference<ViewGroup>> f82931d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private String f82932e;

    /* renamed from: f, reason: collision with root package name */
    private b.a f82933f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f82934h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f82935i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f82936m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.Adapter {

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.bizparts.bb$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class ViewOnClickListenerC0845a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f82938d;

            ViewOnClickListenerC0845a(e eVar) {
                this.f82938d = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                bb.this.f82936m.setText(this.f82938d.f82945b);
                com.tencent.qcircle.cooperation.config.debug.c.j(QCircleDebugKey$SwitchStateKey.QCIRCLE_USE_SELECTED_URL, this.f82938d.f82944a);
                bb.this.Q9();
                SimpleEventBus.getInstance().dispatchEvent(new QFSForceTabRefreshEvent());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return bb.this.O9().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
            e eVar = bb.this.O9().get(i3);
            f fVar = (f) viewHolder;
            fVar.E.setText(eVar.f82945b);
            fVar.E.setOnClickListener(new ViewOnClickListenerC0845a(eVar));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            TextView textView = new TextView(viewGroup.getContext());
            textView.setPadding(com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f));
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.klf));
            textView.setTextSize(14.0f);
            frameLayout.addView(textView);
            frameLayout.setPadding(com.tencent.biz.qqcircle.utils.cx.a(10.0f), com.tencent.biz.qqcircle.utils.cx.a(15.0f), 0, 0);
            return new f(frameLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if ("-\u6536\u8d77\u6e05\u6670\u5ea6\u9762\u677f".contentEquals(bb.this.D.getText())) {
                bb.this.f82935i.setVisibility(8);
                bb.this.D.setText("+\u5c55\u5f00\u6e05\u6670\u5ea6\u9762\u677f");
                bb.this.f82934h.setText(bb.this.f82933f.f414275e.getVideoLevelString());
            } else {
                bb.this.f82935i.setVisibility(0);
                bb.this.D.setText("-\u6536\u8d77\u6e05\u6670\u5ea6\u9762\u677f");
                bb.this.f82934h.setText(bb.this.f82933f.f0());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (bb.this.P9().isShowing()) {
                bb.this.Q9();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f82942d;

        d(ActionSheet actionSheet) {
            this.f82942d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            lb0.a.a(bb.this.f82933f, this.f82942d.getContent(i3));
            QCircleToast.o("\u4e0a\u62a5\u6210\u529f", 0);
            this.f82942d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f82944a;

        /* renamed from: b, reason: collision with root package name */
        public String f82945b;

        public e(int i3, String str) {
            this.f82944a = i3;
            this.f82945b = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class f extends RecyclerView.ViewHolder {
        private TextView E;

        public f(@NonNull View view) {
            super(view);
            this.E = (TextView) ((FrameLayout) view).getChildAt(0);
        }
    }

    private void F9(ViewGroup viewGroup) {
        TextView textView = new TextView(getContext());
        this.f82934h = textView;
        textView.setVisibility(0);
        this.f82934h.setId(R.id.f57022m7);
        this.f82934h.setTextColor(getPartRootView().getContext().getResources().getColor(R.color.f158017al3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.tencent.biz.qqcircle.utils.cx.a(10.0f);
        viewGroup.addView(this.f82934h, layoutParams);
    }

    @NonNull
    private void G9(ViewGroup viewGroup) {
        TextView textView = new TextView(getContext());
        this.f82935i = textView;
        textView.setHeight(com.tencent.biz.qqcircle.utils.cx.a(30.0f));
        this.f82935i.setTextSize(14.0f);
        this.f82935i.setText("\u590d\u5236\u4ee5\u4e0a\u4fe1\u606f");
        this.f82935i.setTextColor(getPartRootView().getContext().getResources().getColor(R.color.f158017al3));
        this.f82935i.setOnClickListener(this);
        this.f82935i.setVisibility(8);
        viewGroup.addView(this.f82935i);
    }

    private void H9(LinearLayout linearLayout) {
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.tencent.biz.qqcircle.utils.cx.a(30.0f));
        layoutParams.leftMargin = com.tencent.biz.qqcircle.utils.cx.a(20.0f);
        textView.setPadding(com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setBackground(getContext().getResources().getDrawable(R.drawable.klf));
        textView.setTextSize(14.0f);
        textView.setText("\u89c6\u9891\u8d28\u91cf\u53cd\u9988");
        textView.setId(R.id.f57042m9);
        textView.setOnClickListener(this);
        linearLayout.addView(textView, layoutParams);
    }

    @NotNull
    private TextView I9(LinearLayout linearLayout) {
        this.D = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.tencent.biz.qqcircle.utils.cx.a(30.0f));
        this.D.setPadding(com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        this.D.setTextColor(-1);
        layoutParams.leftMargin = com.tencent.biz.qqcircle.utils.cx.a(20.0f);
        this.D.setGravity(17);
        this.D.setBackground(getContext().getResources().getDrawable(R.drawable.klf));
        this.D.setTextSize(14.0f);
        this.D.setText("+\u5c55\u5f00\u6e05\u6670\u5ea6\u9762\u677f");
        this.D.setId(R.id.f57052m_);
        this.D.setOnClickListener(new b());
        linearLayout.addView(this.D, layoutParams);
        return this.D;
    }

    private void J9(LinearLayout linearLayout) {
        this.f82936m = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.tencent.biz.qqcircle.utils.cx.a(30.0f));
        layoutParams.leftMargin = com.tencent.biz.qqcircle.utils.cx.a(10.0f);
        this.f82936m.setPadding(com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f), com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        this.f82936m.setTextColor(-1);
        this.f82936m.setGravity(17);
        this.f82936m.setBackground(getContext().getResources().getDrawable(R.drawable.klf));
        this.f82936m.setTextSize(14.0f);
        this.f82936m.setText(N9(com.tencent.qcircle.cooperation.config.debug.c.d(QCircleDebugKey$SwitchStateKey.QCIRCLE_USE_SELECTED_URL, 8)));
        this.f82936m.setId(R.id.f57072mb);
        linearLayout.addView(this.f82936m, layoutParams);
        this.f82936m.setOnClickListener(new c());
    }

    private void K9() {
        ViewGroup viewGroup;
        for (WeakReference<ViewGroup> weakReference : this.f82931d.values()) {
            if (weakReference == null) {
                viewGroup = null;
            } else {
                viewGroup = weakReference.get();
            }
            if (viewGroup == null) {
                return;
            } else {
                viewGroup.setVisibility(8);
            }
        }
    }

    private RecyclerView L9() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setId(R.id.f57082mc);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(new a());
        return recyclerView;
    }

    private QFSPageTurnContainer M9(View view) {
        if (view.getParent() instanceof QFSPageTurnContainer) {
            return (QFSPageTurnContainer) view.getParent();
        }
        if (view.getParent() instanceof View) {
            return M9((View) view.getParent());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RFWSmartPopupWindow P9() {
        if (this.C == null) {
            this.C = RFWSmartPopupWindow.from(getContext()).setContentView(L9()).setAnchor(this.f82936m).setPosition(1).setAlignment(0).setEnableClickDismiss(false).setTouchOutsideDismiss(false).setDismissInterval(0L);
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9() {
        P9().dismiss();
        this.C = null;
    }

    @NonNull
    private LinearLayout R9() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        J9(linearLayout);
        I9(linearLayout);
        H9(linearLayout);
        return linearLayout;
    }

    private void S9(ViewGroup viewGroup) {
        F9(viewGroup);
        G9(viewGroup);
    }

    private void U9() {
        ActionSheet a16 = ob0.a.a(getContext());
        a16.addButton("\u6f0f\u653e");
        a16.addButton("\u8bef\u4f24");
        a16.addButton("\u964d\u6743");
        a16.addButton("\u63d0\u6743");
        a16.setOnButtonClickListener(new d(a16));
        a16.show();
    }

    public String N9(int i3) {
        Iterator<e> it = O9().iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f82944a == i3) {
                return next.f82945b;
            }
        }
        return "\u672a\u77e5";
    }

    public ArrayList<e> O9() {
        if (this.E == null) {
            ArrayList<e> arrayList = new ArrayList<>();
            this.E = arrayList;
            arrayList.add(new e(RFWVideoConstants.CURRENT, "\u5f53\u524d\u6863"));
            this.E.add(new e(RFWVideoConstants.ORIGINAL, "\u539f\u6863"));
            this.E.add(new e(RFWVideoConstants.HIGH, "1080\u9ad8\u6863"));
            this.E.add(new e(RFWVideoConstants.MIDDLE, "720\u4e2d\u6863"));
            this.E.add(new e(RFWVideoConstants.LOW, "540\u4f4e\u6863"));
        }
        return this.E;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: T9, reason: merged with bridge method [inline-methods] */
    public void onChanged(b.a aVar) {
        View view;
        Context context;
        ViewGroup viewGroup;
        String videoLevelString;
        if (!com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_CLARITY_INFO, 0)) {
            K9();
            return;
        }
        this.f82933f = aVar;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null || (view = weakReference.get()) == null || (context = getContext()) == null) {
            return;
        }
        WeakReference<ViewGroup> weakReference2 = this.f82931d.get(Integer.valueOf(view.hashCode()));
        if (weakReference2 == null) {
            viewGroup = null;
        } else {
            viewGroup = weakReference2.get();
        }
        this.f82934h = null;
        if (viewGroup == null) {
            QFSPageTurnContainer M9 = M9(view);
            if (M9 == null) {
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) M9.findViewById(R.id.f57032m8);
            if (viewGroup2 == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = com.tencent.biz.qqcircle.utils.cx.a(100.0f);
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setBackgroundColor(context.getResources().getColor(R.color.by));
                linearLayout.setId(R.id.f57032m8);
                linearLayout.addView(R9());
                S9(linearLayout);
                M9.addView(linearLayout);
                viewGroup = linearLayout;
            } else {
                viewGroup = viewGroup2;
            }
            this.f82931d.put(Integer.valueOf(view.hashCode()), new WeakReference<>(viewGroup));
        }
        viewGroup.setVisibility(0);
        TextView textView = (TextView) viewGroup.findViewById(R.id.f57022m7);
        this.f82934h = textView;
        if (textView != null) {
            if (this.D.getText().equals("-\u6536\u8d77\u6e05\u6670\u5ea6\u9762\u677f")) {
                videoLevelString = aVar.f0();
            } else {
                videoLevelString = aVar.f414275e.getVideoLevelString();
            }
            this.f82932e = videoLevelString;
            this.f82934h.setText(videoLevelString);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSDebugVideoInfoPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f57042m9) {
            U9();
        } else {
            com.tencent.biz.qqcircle.utils.s.a(getContext(), this.f82932e);
            QCircleToast.o("\u590d\u5236\u6e05\u6670\u5ea6\u4fe1\u606f\u6210\u529f", 0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        w20.a.j().observerGlobalState(b.a.class, "QFSClarityReportHelper", this);
    }
}

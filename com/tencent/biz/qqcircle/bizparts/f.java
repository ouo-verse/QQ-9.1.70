package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel;
import com.tencent.biz.qqcircle.immersive.utils.QFSPersonalDraftUtil;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleClosePageEvent;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, QCircleDraftRecyclerView.a, SimpleEventReceiver {
    private Button C;
    private TextView D;
    private View E;
    private QFSDraftViewModel H;

    /* renamed from: d, reason: collision with root package name */
    private QCircleDraftRecyclerView f83091d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f83092e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f83093f;

    /* renamed from: h, reason: collision with root package name */
    private Group f83094h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f83095i;

    /* renamed from: m, reason: collision with root package name */
    private CheckBox f83096m;
    private boolean F = false;
    boolean G = true;
    View.OnClickListener I = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                DraftBean draftBean = (DraftBean) view.getTag();
                QFSPersonalDraftUtil qFSPersonalDraftUtil = new QFSPersonalDraftUtil();
                if (qFSPersonalDraftUtil.f(qFSPersonalDraftUtil.c(f.this.getActivity(), draftBean, 3))) {
                    f.this.L9(draftBean.getMissionId());
                }
            } catch (Exception e16) {
                QLog.e("QCircleDraftPart", 1, "mItemClickListener, start publish error ", e16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f83098d;

        b(String str) {
            this.f83098d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1 && f.this.f83091d != null) {
                f.this.f83091d.f(this.f83098d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                if (f.this.f83091d != null) {
                    f.this.f83091d.d(f.this.C);
                    f.this.f83091d.e();
                }
                if (f.this.C != null) {
                    f.this.C.setEnabled(false);
                    f.this.C.setText(f.this.getContext().getString(R.string.f183823k8));
                }
                if (f.this.f83096m != null && f.this.f83096m.isChecked()) {
                    f.this.f83096m.setChecked(false);
                }
            }
        }
    }

    private void D9() {
        String str;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("QCircleDraftPart", 1, "handleSelectBtn isSelected: ", Boolean.valueOf(this.F));
        }
        boolean z16 = !this.F;
        this.F = z16;
        TextView textView = this.f83093f;
        if (z16) {
            str = "\u53d6\u6d88";
        } else {
            str = "\u9009\u62e9";
        }
        textView.setText(str);
        this.f83091d.l(this.F);
        Group group = this.f83094h;
        if (this.F) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        group.setVisibility(i3);
        K9(this.F);
        if (!this.F) {
            this.f83091d.b();
            this.f83096m.setChecked(false);
        }
    }

    private void E9() {
        CheckBox checkBox = this.f83096m;
        if (checkBox != null) {
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    private void F9(View view) {
        this.f83095i = (TextView) view.findViewById(R.id.f107466ah);
        this.f83096m = (CheckBox) view.findViewById(R.id.tpb);
        this.C = (Button) view.findViewById(R.id.teb);
        this.D = (TextView) view.findViewById(R.id.f107436ae);
        this.f83096m.setOnCheckedChangeListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
    }

    private void G9() {
        QFSDraftViewModel qFSDraftViewModel = this.H;
        if (qFSDraftViewModel != null && qFSDraftViewModel.O1() != null) {
            this.H.O1().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    f.this.N9((List) obj);
                }
            });
        }
    }

    private void H9(View view) {
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(6).setTitle("\u6682\u65f6\u6ca1\u6709\u4f5c\u54c1\u54e6").build();
        this.E = build;
        build.setVisibility(4);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.bottomToBottom = 0;
        layoutParams.endToEnd = 0;
        layoutParams.startToStart = 0;
        layoutParams.topToBottom = R.id.f30990pu;
        this.E.setLayoutParams(layoutParams);
        ((ConstraintLayout) view.findViewById(R.id.ul8)).addView(this.E);
    }

    private void I9(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.y2h);
        this.f83092e = imageView;
        imageView.setOnClickListener(this);
        this.f83093f = (TextView) view.findViewById(R.id.tec);
        this.f83094h = (Group) view.findViewById(R.id.f30960pr);
        this.F = false;
        this.f83093f.setText("\u9009\u62e9");
        this.f83093f.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9() {
        QLog.i("QCircleDraftPart", 1, "[onPartCreate] WinkPublish, preload wink");
        QCirclePluginInitHelper.PreloadWink(getActivity());
    }

    private void K9(boolean z16) {
        int i3;
        int i16;
        CheckBox checkBox = this.f83096m;
        int i17 = 0;
        if (checkBox != null) {
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            checkBox.setVisibility(i16);
        }
        Button button = this.C;
        if (button != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            button.setVisibility(i3);
        }
        TextView textView = this.D;
        if (textView != null) {
            if (!z16) {
                i17 = 8;
            }
            textView.setVisibility(i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9(List<DraftBean> list) {
        if (list != null && list.size() != 0) {
            this.E.setVisibility(4);
            this.f83093f.setVisibility(0);
            Iterator<DraftBean> it = list.iterator();
            while (it.hasNext()) {
                it.next().setCanSelect(this.F);
            }
            QCircleDraftRecyclerView qCircleDraftRecyclerView = this.f83091d;
            if (qCircleDraftRecyclerView != null) {
                qCircleDraftRecyclerView.a(list);
                return;
            }
            return;
        }
        QLog.i("QCircleDraftPart", 1, "[updateRecyclerView] draftBeans == null || draftBeans.size() == 0.");
        this.E.setVisibility(0);
        this.f83093f.setVisibility(4);
    }

    public void L9(String str) {
        b bVar = new b(str);
        QCircleCustomDialog P = QCircleCustomDialog.P(getContext(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f182923hs), R.string.cancel, R.string.f183823k8, bVar, bVar);
        if (getActivity() != null && !getActivity().isFinishing()) {
            P.show();
        }
    }

    public void M9() {
        c cVar = new c();
        QCircleCustomDialog P = QCircleCustomDialog.P(getContext(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f182913hr), R.string.cancel, R.string.f183823k8, cVar, cVar);
        if (getActivity() != null && !getActivity().isFinishing()) {
            P.show();
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.a
    public void f5(int i3, int i16) {
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("QCircleDraftPart", 1, "itemSelected selectCount: ", Integer.valueOf(i3), " totalCount:", Integer.valueOf(i16));
        }
        this.G = false;
        CheckBox checkBox = this.f83096m;
        if (checkBox != null) {
            if (i3 == i16) {
                z17 = true;
            } else {
                z17 = false;
            }
            checkBox.setChecked(z17);
        }
        Button button = this.C;
        if (button != null) {
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            button.setEnabled(z16);
            if (i3 > 0) {
                Button button2 = this.C;
                button2.setText(button2.getResources().getString(R.string.f182903hq, Integer.valueOf(i3)));
            } else {
                Button button3 = this.C;
                button3.setText(button3.getResources().getString(R.string.f183823k8));
            }
        }
        this.G = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void finish() {
        super.finish();
        getActivity().overridePendingTransition(R.anim.f155107wd, R.anim.f155108we);
        QCircleDraftRecyclerView qCircleDraftRecyclerView = this.f83091d;
        if (qCircleDraftRecyclerView != null) {
            qCircleDraftRecyclerView.c();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleClosePageEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleDraftPart";
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton.getId() == R.id.tpb && this.G) {
            if (z16) {
                this.f83091d.h();
            } else {
                this.f83091d.b();
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y2h) {
            getActivity().finish();
        } else if (view.getId() == R.id.tec) {
            D9();
        } else if (view.getId() == R.id.teb) {
            M9();
        } else if (view.getId() == R.id.f107436ae) {
            E9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f83091d = new QCircleDraftRecyclerView();
        this.H = (QFSDraftViewModel) getViewModel(getPartHost(), null, QFSDraftViewModel.class);
        this.f83091d.g(view);
        this.f83091d.k(this);
        this.f83091d.i(this.I);
        I9(view);
        F9(view);
        H9(view);
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.J9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QCircleReportBean reportBean;
        if (simpleBaseEvent != null && (simpleBaseEvent instanceof QCircleClosePageEvent) && (reportBean = getReportBean()) != null && reportBean.getFromPageId() == 532 && getActivity() != null) {
            getActivity().finish();
        }
    }
}

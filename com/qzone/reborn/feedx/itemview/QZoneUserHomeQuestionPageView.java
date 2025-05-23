package com.qzone.reborn.feedx.itemview;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.feedx.event.QZoneChooseUserHomeQuestionEvent;
import com.qzone.reborn.feedx.event.QZoneShowUserHomeQuestionListEvent;
import com.qzone.reborn.feedx.viewmodel.t;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ToastUtil;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneUserHomeQuestionPageView extends QZoneBaseWidgetView implements SimpleEventReceiver {
    private TextView C;
    private ExtendEditText D;
    private x6.a E;
    private Context F;
    private RelativeLayout G;
    private w H;
    private t I;

    /* renamed from: e, reason: collision with root package name */
    private View f54833e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f54834f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f54835h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f54836i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f54837m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements t.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.t.g
        public void a(QZoneResult qZoneResult) {
            if (qZoneResult.getSucceed()) {
                if (QZoneUserHomeQuestionPageView.this.f54833e != null) {
                    QZoneUserHomeQuestionPageView.this.f54833e.setVisibility(8);
                }
                QZoneUserHomeQuestionPageView.this.u0();
                return;
            }
            ToastUtil.s(qZoneResult.getMessage(), 4);
        }
    }

    public QZoneUserHomeQuestionPageView(Context context) {
        super(context);
        this.F = context;
        initView();
    }

    private void A0() {
        x6.a aVar;
        ExtendEditText extendEditText = this.D;
        if (extendEditText != null && extendEditText.getText() != null && this.D.getText().toString().length() == 0) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAnswerCanNotBeNull", "\u7b54\u6848\u4e0d\u80fd\u4e3a\u7a7a"), 0);
            return;
        }
        t tVar = this.I;
        if (tVar == null || (aVar = this.E) == null || this.H == null) {
            return;
        }
        tVar.K2(aVar.uin, tVar.getMHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(String str) {
        t tVar = this.I;
        if (tVar == null) {
            return;
        }
        tVar.C2(str);
    }

    private void C0() {
        TextView textView = this.C;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.itemview.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeQuestionPageView.this.z0(view);
            }
        });
    }

    private void E0() {
        x6.a aVar;
        ArrayList<String> arrayList;
        if (this.f54836i == null || (aVar = this.E) == null || (arrayList = aVar.questionList) == null || arrayList.isEmpty()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.F.getResources().getString(R.string.f22011689));
        sb5.append(this.E.questionList.get(0));
        this.f54836i.setText(sb5);
        this.f54837m.setVisibility(this.E.questionList.size() > 1 ? 0 : 8);
        F0(this.E.questionList.get(0));
    }

    private void F0(String str) {
        t tVar = this.I;
        if (tVar == null) {
            return;
        }
        tVar.I2(str);
    }

    private void s0() {
        ExtendEditText extendEditText = this.D;
        if (extendEditText == null) {
            return;
        }
        extendEditText.addTextChangedListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        w wVar = this.H;
        if (wVar == null) {
            return;
        }
        wVar.d3();
        setVisibility(8);
    }

    private void w0() {
        ArrayList<String> arrayList;
        x6.a aVar = this.E;
        if (aVar == null || (arrayList = aVar.questionList) == null || arrayList.size() <= 1) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZoneShowUserHomeQuestionListEvent(this.E.questionList));
    }

    private void x0() {
        t tVar = this.I;
        if (tVar == null) {
            return;
        }
        tVar.F2(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        w0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        A0();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void D0(boolean z16) {
        View view = this.f54833e;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(z16 ? R.drawable.lvj : R.drawable.qui_common_bg_bottom_light_bg);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneChooseUserHomeQuestionEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ch6;
    }

    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneChooseUserHomeQuestionEvent) {
            v0((QZoneChooseUserHomeQuestionEvent) simpleBaseEvent);
        }
    }

    public void setForbiddenPageViewModel(t tVar) {
        this.I = tVar;
        x0();
    }

    public void setUserHomeViewModel(w wVar) {
        this.H = wVar;
    }

    public void setUserInfoData(x6.a aVar) {
        this.E = aVar;
        E0();
        C0();
    }

    private void v0(QZoneChooseUserHomeQuestionEvent qZoneChooseUserHomeQuestionEvent) {
        x6.a aVar;
        ArrayList<String> arrayList;
        if (qZoneChooseUserHomeQuestionEvent == null || (aVar = this.E) == null || (arrayList = aVar.questionList) == null || arrayList.isEmpty()) {
            return;
        }
        String str = qZoneChooseUserHomeQuestionEvent.mChosenQuestion;
        ArrayList<String> arrayList2 = this.E.questionList;
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (TextUtils.equals(str, arrayList2.get(i3))) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.F.getResources().getString(R.string.f22011689));
                sb5.append(str);
                this.f54836i.setText(sb5);
                F0(str);
            }
        }
    }

    public void initView() {
        this.f54833e = findViewById(R.id.miq);
        this.f54834f = (TextView) findViewById(R.id.mir);
        this.f54835h = (TextView) findViewById(R.id.miu);
        this.G = (RelativeLayout) findViewById(R.id.mip);
        this.f54836i = (TextView) findViewById(R.id.mis);
        this.f54837m = (ImageView) findViewById(R.id.mit);
        this.C = (TextView) findViewById(R.id.nay);
        this.D = (ExtendEditText) findViewById(R.id.mio);
        this.f54833e.setVisibility(0);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.itemview.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeQuestionPageView.this.y0(view);
            }
        });
        s0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (QZoneUserHomeQuestionPageView.this.D == null || QZoneUserHomeQuestionPageView.this.D.getText() == null) {
                return;
            }
            QZoneUserHomeQuestionPageView qZoneUserHomeQuestionPageView = QZoneUserHomeQuestionPageView.this;
            qZoneUserHomeQuestionPageView.B0(qZoneUserHomeQuestionPageView.D.getText().toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

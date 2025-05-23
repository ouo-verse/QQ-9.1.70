package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallenge;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSTagChallengeSwitchEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTagChallengeInfoEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTopicChallengeBannerClickEvent;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.api.IWinkKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSTagChallengeBannerPart extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {
    private ImageView C;
    private TextView D;
    private TextSwitcher E;
    private TextView F;
    private int G = 0;
    private final List<String> H = new ArrayList();
    private boolean I = false;
    private final float J = 13.0f;
    private boolean K = false;
    private int L = 0;
    private final Runnable M = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTagChallengeBannerPart.2
        @Override // java.lang.Runnable
        public void run() {
            if (QFSTagChallengeBannerPart.this.L9()) {
                RFWThreadManager.getUIHandler().postDelayed(QFSTagChallengeBannerPart.this.M, 3000L);
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f87578d;

    /* renamed from: e, reason: collision with root package name */
    private e30.b f87579e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleTagChallengeInfo f87580f;

    /* renamed from: h, reason: collision with root package name */
    private ViewStub f87581h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f87582i;

    /* renamed from: m, reason: collision with root package name */
    private Button f87583m;

    /* loaded from: classes4.dex */
    class a implements ViewSwitcher.ViewFactory {
        a() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(QFSTagChallengeBannerPart.this.getContext());
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
            textView.setTextSize(1, 13.0f);
            textView.setGravity(16);
            textView.setTextColor(-1);
            textView.setMaxLines(1);
            textView.setMaxEms(20);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    public QFSTagChallengeBannerPart(QCircleLayerBean qCircleLayerBean) {
        this.f87578d = qCircleLayerBean;
        if (qCircleLayerBean != null) {
            this.f87580f = qCircleLayerBean.getTagChallengeInfo();
        }
    }

    private void C9() {
        if (this.E != null && this.F != null && this.f87583m != null) {
            HashMap hashMap = new HashMap();
            if (c40.d.a(this.f87580f)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REF_TOPIC_NAME, this.f87580f.mTagChallenge.title);
            }
            VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_RANKING_ENTRANCE_BUTTON);
            VideoReport.setElementParams(this.E, hashMap);
            VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_NEXT_BUTTON);
            VideoReport.setElementParams(this.F, hashMap);
            VideoReport.setElementId(this.f87583m, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON);
            VideoReport.setElementParams(this.f87583m, hashMap);
        }
    }

    private void D9(View view, String str, Map<String, Object> map) {
        if (view == null) {
            QLog.d("QFSTagChallengeBannerPart", 1, "[dtReportCustomReport] view == null.");
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null && map.size() > 0) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    private String E9() {
        QCircleTagChallengeInfo tagChallengeInfo;
        QCircleTagChallenge qCircleTagChallenge;
        QCircleLayerBean qCircleLayerBean = this.f87578d;
        if (qCircleLayerBean == null || (tagChallengeInfo = qCircleLayerBean.getTagChallengeInfo()) == null || (qCircleTagChallenge = tagChallengeInfo.mTagChallenge) == null) {
            return null;
        }
        return qCircleTagChallenge.title;
    }

    private String F9(e30.b bVar) {
        QCircleTagChallenge qCircleTagChallenge;
        String str;
        QCircleTagChallengeInfo c16 = c40.d.c(bVar);
        if (c16 != null && (qCircleTagChallenge = c16.mTagChallenge) != null && (str = qCircleTagChallenge.title) != null) {
            return str;
        }
        return "";
    }

    private void G9(QFSSeekEvent qFSSeekEvent) {
        e30.b bVar;
        int i3;
        if (this.f87582i == null || (bVar = this.f87579e) == null || bVar.g() == null || !this.f87579e.g().f398449id.get().equals(qFSSeekEvent.mFeedId)) {
            return;
        }
        LinearLayout linearLayout = this.f87582i;
        if (qFSSeekEvent.mIsOnSeek) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
    }

    private void H9() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSTagChallengeSwitchEvent());
        com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
        T9(true);
    }

    private void I9(QFSTagChallengeInfoEvent qFSTagChallengeInfoEvent) {
        if (this.f87582i == null) {
            return;
        }
        List<QCircleTagChallengeInfo> tagChallengeInfoList = qFSTagChallengeInfoEvent.getTagChallengeInfoList();
        if (tagChallengeInfoList != null && tagChallengeInfoList.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (QCircleTagChallengeInfo qCircleTagChallengeInfo : tagChallengeInfoList) {
                QLog.d("QFSTagChallengeBannerPart", 1, "[handleTagChallengeInfoEvent] tagChallenge: ", qCircleTagChallengeInfo);
                arrayList.add(qCircleTagChallengeInfo.mTagChallenge.title);
            }
            QLog.e("QFSTagChallengeBannerPart", 1, "[handleTagChallengeInfoEvent] tagChallenge: ");
            if (!this.I) {
                this.H.clear();
                this.H.addAll(arrayList);
                R9();
                return;
            }
            return;
        }
        QLog.d("QFSTagChallengeBannerPart", 1, "[handleTagChallengeInfoEvent] tagChallengeInfoList == null || tagChallengeInfoList.size() == 0.");
    }

    private void J9(Object obj) {
        if (obj instanceof e30.b) {
            e30.b bVar = (e30.b) obj;
            e30.b bVar2 = this.f87579e;
            if (bVar2 == null || !bVar2.g().f398449id.get().equals(bVar.g().f398449id.get())) {
                this.L++;
            }
            if (this.L == 5) {
                QLog.d("QFSTagChallengeBannerPart", 1, "[handleUpdateFeed] mIsBubblePopped: ", Boolean.valueOf(this.K));
                QLog.d("QFSTagChallengeBannerPart", 1, "[handleUpdateFeed] IWinkKV getBoolean: ", Boolean.valueOf(((IWinkKV) QRoute.api(IWinkKV.class)).getBoolean("qfs_tag_challenge_can_show_bubble_pop")));
                if (!this.K && !((IWinkKV) QRoute.api(IWinkKV.class)).getBoolean("qfs_tag_challenge_can_show_bubble_pop")) {
                    T9(true);
                    Q9();
                    getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.fp
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSTagChallengeBannerPart.this.P9();
                        }
                    }, 8000L);
                } else {
                    this.K = true;
                }
            }
            this.f87579e = bVar;
            this.f87580f = c40.d.c(bVar);
        }
    }

    private void K9(QCirclePanelStateEvent qCirclePanelStateEvent) {
        int i3;
        if (qCirclePanelStateEvent.getPanelType() != 16) {
            return;
        }
        LinearLayout linearLayout = this.f87582i;
        if (qCirclePanelStateEvent.isShowing()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L9() {
        int size = this.H.size();
        if (size <= 1) {
            return false;
        }
        String str = this.H.get(this.G);
        int i3 = this.G + 1;
        this.G = i3;
        int i16 = i3 % size;
        this.G = i16;
        String str2 = this.H.get(i16);
        if (str2 != null && c40.d.a(this.f87580f) && str2.equals(this.f87580f.mTagChallenge.title)) {
            int i17 = this.G + 1;
            this.G = i17;
            int i18 = i17 % size;
            this.G = i18;
            str2 = this.H.get(i18);
        }
        if (str.equals(str2)) {
            return false;
        }
        this.E.setText(str2);
        return true;
    }

    private void M9() {
        if (!c40.d.a(this.f87580f)) {
            QLog.e("QFSTagChallengeBannerPart", 1, "[jumpToPublish] mCurTagChallengeInfo should not be null.");
        } else {
            c40.d.i(getContext(), this.f87580f.mTagChallenge.title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N9(com.tencent.biz.qqcircle.widgets.e eVar) {
        if (eVar != null) {
            try {
                if (eVar.isShowing()) {
                    eVar.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("QFSTagChallengeBannerPart", 1, e16, new Object[0]);
            }
        }
    }

    private void O9(View view, int i3, int i16, int i17, int i18, int i19, int i26) {
        final com.tencent.biz.qqcircle.widgets.e eVar = new com.tencent.biz.qqcircle.widgets.e(getContext());
        eVar.f(R.drawable.nu7);
        eVar.j(R.drawable.nu8);
        eVar.n(1, i16);
        eVar.i(ImmersiveUtils.dpToPx(4.0f), ImmersiveUtils.dpToPx(2.0f));
        eVar.l(i3);
        eVar.m(R.color.clk);
        eVar.setWidth(-2);
        eVar.setHeight(-2);
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.fq
            @Override // java.lang.Runnable
            public final void run() {
                QFSTagChallengeBannerPart.N9(com.tencent.biz.qqcircle.widgets.e.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9() {
        O9(this.D, R.string.f185373oe, ImmersiveUtils.dpToPx(14.0f), 1, 3, 0, ImmersiveUtils.dpToPx(-2.0f));
    }

    private void Q9() {
        O9(this.f87583m, R.string.f185343ob, ImmersiveUtils.dpToPx(46.0f), 1, 4, 0, ImmersiveUtils.dpToPx(-6.5f));
    }

    private void T9(boolean z16) {
        this.K = z16;
        ((IWinkKV) QRoute.api(IWinkKV.class)).putBoolean("qfs_tag_challenge_can_show_bubble_pop", z16);
    }

    public void R9() {
        int indexOf = this.H.indexOf(E9());
        if (indexOf != -1) {
            this.G = indexOf;
        }
        S9();
        RFWThreadManager.getUIHandler().postDelayed(this.M, 0L);
        this.I = true;
    }

    public void S9() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.M);
        this.I = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSTagChallengeInfoEvent.class);
        arrayList.add(QFSTagChallengeSwitchEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTagChallengeBannerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str)) {
            J9(obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f54962gm && view.getId() != R.id.f54992gp && view.getId() != R.id.f54982go) {
            if (view.getId() == R.id.f54972gn) {
                H9();
                D9(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_NEXT_BUTTON, null);
            } else if (view.getId() == R.id.f54872gd) {
                M9();
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_topic_name", F9(this.f87579e));
                D9(this.f87583m, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_BUTTON, hashMap);
            }
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTopicChallengeBannerClickEvent());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("xsj_topic_name", F9(this.f87579e));
            D9(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_RANKING_ENTRANCE_BUTTON, hashMap2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f54852gb);
        this.f87581h = viewStub;
        LinearLayout linearLayout = (LinearLayout) viewStub.inflate().findViewById(R.id.f54862gc);
        this.f87582i = linearLayout;
        linearLayout.setVisibility(0);
        this.f87583m = (Button) this.f87582i.findViewById(R.id.f54872gd);
        this.C = (ImageView) this.f87582i.findViewById(R.id.f54982go);
        this.D = (TextView) this.f87582i.findViewById(R.id.f54992gp);
        this.E = (TextSwitcher) this.f87582i.findViewById(R.id.f54962gm);
        this.F = (TextView) this.f87582i.findViewById(R.id.f54972gn);
        this.f87583m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.E.setFactory(new a());
        this.E.setInAnimation(getContext(), R.anim.f154920tp);
        this.E.setOutAnimation(getContext(), R.anim.f154921tq);
        QCircleLayerBean qCircleLayerBean = this.f87578d;
        if (qCircleLayerBean != null && qCircleLayerBean.getTagChallengeInfo() != null) {
            this.E.setCurrentText(E9());
        }
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        S9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTagChallengeInfoEvent) {
            QLog.d("QFSTagChallengeBannerPart", 1, "[onReceiveEvent] receive QFSTagChallengeInfoEvent");
            I9((QFSTagChallengeInfoEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            QLog.d("QFSTagChallengeBannerPart", 1, "[onReceiveEvent] receive QFSTopicChallengePanelChangeEvent");
            K9((QCirclePanelStateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSeekEvent) {
            G9((QFSSeekEvent) simpleBaseEvent);
        }
    }
}

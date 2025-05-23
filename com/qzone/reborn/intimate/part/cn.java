package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.event.QZoneIntimateNewBadgeEvent;
import com.qzone.reborn.intimate.widget.QZoneIntimateNewBadgeFullAnimView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashMap;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cn extends com.qzone.reborn.base.k implements SimpleEventReceiver<QZoneIntimateNewBadgeEvent> {

    /* renamed from: d, reason: collision with root package name */
    private QZoneIntimateNewBadgeFullAnimView f57470d;

    /* renamed from: e, reason: collision with root package name */
    private nk.at f57471e;

    /* renamed from: f, reason: collision with root package name */
    private nk.ag f57472f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f57473h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f57474i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements n.a<QZIntimateSpaceMedal$MainPageMedalDetail> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f57475a;

        a(String str) {
            this.f57475a = str;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZIntimateSpaceMedal$MainPageMedalDetail qZIntimateSpaceMedal$MainPageMedalDetail, long j3, String str, boolean z16) {
            xj.a.f448035a.c(this.f57475a);
            if (qZIntimateSpaceMedal$MainPageMedalDetail != null) {
                RFWLog.i("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "requestNewBadge success, show medal anim");
                ArrayList arrayList = new ArrayList();
                arrayList.add(qZIntimateSpaceMedal$MainPageMedalDetail);
                cn.this.f57470d.setData(mk.b.f416873a.c(arrayList, 1));
                qj.e eVar = (qj.e) cn.this.getIocInterface(qj.e.class);
                if (eVar != null) {
                    eVar.b3(cn.this.f57471e.X1());
                }
                cn.this.broadcastMessage("QZONE_INTIMATE_UPDATE_BADGE", qZIntimateSpaceMedal$MainPageMedalDetail);
            }
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long j3, String str) {
            RFWLog.i("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "requestNewBadge onFailure, errorCode: " + j3 + ", errorMsg: " + str);
        }
    }

    private void I9(QZIntimateSpaceMedal$MainPageMedalDetail qZIntimateSpaceMedal$MainPageMedalDetail) {
        HashMap hashMap = new HashMap();
        hashMap.put("badges_number", Integer.valueOf(qZIntimateSpaceMedal$MainPageMedalDetail.new_medals.get().size()));
        fo.c.o(this.f57470d, "pg_qz_badge_animation", new fo.b().l(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(UIStateData uIStateData) {
        M9((QZoneIntimateSpaceBean) uIStateData.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(Boolean bool) {
        QZoneIntimateNewBadgeFullAnimView qZoneIntimateNewBadgeFullAnimView = this.f57470d;
        if (qZoneIntimateNewBadgeFullAnimView != null) {
            qZoneIntimateNewBadgeFullAnimView.I0(bool.booleanValue());
        }
    }

    private void initViewModel() {
        this.f57472f = (nk.ag) getViewModel(nk.ag.class);
        nk.at atVar = (nk.at) getViewModel(nk.at.class);
        this.f57471e = atVar;
        atVar.U1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.intimate.part.cl
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cn.this.J9((UIStateData) obj);
            }
        });
        this.f57472f.Q1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.intimate.part.cm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cn.this.K9((Boolean) obj);
            }
        });
    }

    public void H9() {
        String mSpaceId = this.f57471e.getMSpaceId();
        if (xj.a.f448035a.d(mSpaceId)) {
            L9(mSpaceId);
        }
    }

    public void L9(String str) {
        if (this.f57474i) {
            RFWLog.e("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "requestNewBadge fail, is show calendar preview");
            return;
        }
        if (!this.f57473h) {
            RFWLog.i("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "requestNewBadge fail, not master space");
            return;
        }
        if (this.f57470d.getVisibility() == 0) {
            QLog.e(getTAG(), 1, "[requestNewBadge] fullAnimView is visible");
            return;
        }
        RFWLog.i("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "do requestNewBadge, space id: " + str);
        this.f57472f.R1(str, new a(str));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneIntimateNewBadgeEvent>> getEventClass() {
        ArrayList<Class<QZoneIntimateNewBadgeEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneIntimateNewBadgeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateSpaceNewBadgeFullViewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        str.hashCode();
        if (!str.equals("INTIMATE_CALENDAR_CARD_SHARE_PREVIEW_DISMISS")) {
            if (str.equals("INTIMATE_CALENDAR_CARD_SHARE_PREVIEW_SHOW")) {
                this.f57474i = true;
                return;
            }
            return;
        }
        this.f57474i = false;
        String mSpaceId = this.f57471e.getMSpaceId();
        RFWLog.i("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "handle dismiss calendarPreview spaceId: " + mSpaceId);
        if (TextUtils.isEmpty(mSpaceId)) {
            return;
        }
        L9(mSpaceId);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QZoneIntimateNewBadgeFullAnimView qZoneIntimateNewBadgeFullAnimView = (QZoneIntimateNewBadgeFullAnimView) view.findViewById(R.id.f162888n54);
        this.f57470d = qZoneIntimateNewBadgeFullAnimView;
        qZoneIntimateNewBadgeFullAnimView.setHostActivity(getActivity());
        initViewModel();
        xj.a.f448035a.c(this.f57471e.getMSpaceId());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f57470d.O0(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        H9();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneIntimateNewBadgeEvent) {
            String mSpaceId = this.f57471e.getMSpaceId();
            RFWLog.i("QZoneIntimateSpaceNewBadgeFullViewPart", RFWLog.USR, "onReceiveEvent, QZoneIntimateNewBadgeEvent:" + mSpaceId);
            if (TextUtils.equals(((QZoneIntimateNewBadgeEvent) simpleBaseEvent).getSpaceId(), mSpaceId)) {
                L9(mSpaceId);
            }
        }
    }

    private void M9(QZoneIntimateSpaceBean qZoneIntimateSpaceBean) {
        if (qZoneIntimateSpaceBean != null && qZoneIntimateSpaceBean.getMedalInfo() != null) {
            if (!qZoneIntimateSpaceBean.isFromRefreshSpace()) {
                QLog.d(getTAG(), 1, "[updateSpaceInfo] not from refresh space");
                return;
            } else {
                if (this.f57470d.getVisibility() == 0) {
                    QLog.e(getTAG(), 1, "[updateSpaceInfo] fullAnimView is visible");
                    return;
                }
                this.f57473h = qZoneIntimateSpaceBean.isMasterSpace();
                I9(qZoneIntimateSpaceBean.getMedalInfo());
                this.f57470d.setData(mk.b.d(qZoneIntimateSpaceBean));
                return;
            }
        }
        QLog.e(getTAG(), 1, "[updateSpaceInfo] medalInfo is null");
    }
}

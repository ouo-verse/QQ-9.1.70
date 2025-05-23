package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import androidx.lifecycle.Observer;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.event.QZoneIntimateNewBadgeFullAnimEvent;
import com.qzone.reborn.intimate.widget.QZoneIntimateBadgePoolAnimView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;
import qzone.QZIntimateSpaceMedal$MedalInfo;

/* loaded from: classes37.dex */
public class QZoneIntimateSpaceBadgeWallPart extends com.qzone.reborn.base.k implements SimpleEventReceiver, View.OnClickListener {
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private nk.at f57263d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneIntimateBadgePoolAnimView f57264e;

    /* renamed from: h, reason: collision with root package name */
    private Sensor f57266h;

    /* renamed from: i, reason: collision with root package name */
    private SensorManager f57267i;

    /* renamed from: m, reason: collision with root package name */
    private int f57268m;

    /* renamed from: f, reason: collision with root package name */
    int f57265f = -1;
    private final SensorEventListener E = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void M9(float f16) {
        this.f57264e.setAlpha(f16);
        if (f16 <= 0.0f) {
            this.f57264e.setVisibility(8);
            this.f57264e.j();
        } else {
            this.f57264e.setVisibility(0);
            this.f57264e.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O9() {
        if (getContext() == null) {
            QLog.e("QZoneIntimateSpaceBadgeWallPart", 1, "[getScreenRotation] context is null");
            return -1;
        }
        return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    private void P9(String str, Context context) {
        if (com.qzone.reborn.util.e.b("QZoneIntimateSpaceBadgeWallPartHalfScreen", 500L)) {
            return;
        }
        yo.d.d(str, context, null);
    }

    private void Q9(QZoneIntimateNewBadgeFullAnimEvent qZoneIntimateNewBadgeFullAnimEvent) {
        List<QZIntimateSpaceMedal$MedalInfo> newMedalInfo = qZoneIntimateNewBadgeFullAnimEvent.getNewMedalInfo();
        if (RFSafeListUtils.isEmpty(newMedalInfo)) {
            QLog.e(getTAG(), 1, "[handleNewBadgeFullAnimEnd] newMedalInfoList is empty");
            return;
        }
        QLog.d(getTAG(), 1, "[handleNewBadgeFullAnimEnd] new_medals.size = " + newMedalInfo.size() + ", alertMedalId = " + qZoneIntimateNewBadgeFullAnimEvent.getAlertMedalId());
        this.f57264e.b(49, newMedalInfo, false, qZoneIntimateNewBadgeFullAnimEvent.getAlertMedalId());
    }

    private void R9() {
        nk.at atVar = this.f57263d;
        if (atVar == null) {
            QLog.e(getTAG(), 1, "[handlePoolBallViewClick] mMainTabViewModel is null");
            return;
        }
        UIStateData<QZoneIntimateSpaceBean> value = atVar.U1().getValue();
        QZoneIntimateSpaceBean data = value == null ? null : value.getData();
        QZIntimateSpaceMedal$MainPageMedalDetail medalInfo = data != null ? data.getMedalInfo() : null;
        if (medalInfo == null) {
            QLog.e(getTAG(), 1, "[handlePoolBallViewClick] medalDetail is null");
            return;
        }
        if (!data.isMasterSpace() && medalInfo.got_num.get() <= 0) {
            QLog.d(getTAG(), 1, "[handlePoolBallViewClick] not master space and medal's got_num <= 0");
        } else if (TextUtils.isEmpty(medalInfo.detail_page_url.get())) {
            QLog.e(getTAG(), 1, "[handlePoolBallViewClick] jump url is empty");
        } else {
            P9(medalInfo.detail_page_url.get(), getContext());
            getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceBadgeWallPart.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneIntimateSpaceBadgeWallPart.this.f57263d != null) {
                        QZoneIntimateSpaceBadgeWallPart.this.f57263d.i2();
                    }
                }
            }, 200L);
        }
    }

    private void S9() {
        String sensor;
        if (this.f57267i == null) {
            SensorManager sensorManager = (SensorManager) getContext().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.f57267i = sensorManager;
            this.f57268m = 9;
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 9);
            this.f57266h = defaultSensor;
            if (defaultSensor == null) {
                QLog.e(getTAG(), 1, "[initSensor] error, device does not have a gravity sensor");
                this.f57268m = 1;
                this.f57266h = SensorMonitor.getDefaultSensor(this.f57267i, 1);
            }
            String tag = getTAG();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[initSensor] mSensorType = ");
            sb5.append(this.f57268m);
            sb5.append(", mSensor = ");
            Sensor sensor2 = this.f57266h;
            if (sensor2 == null) {
                sensor = "null";
            } else {
                sensor = sensor2.toString();
            }
            sb5.append(sensor);
            QLog.d(tag, 1, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(UIStateData uIStateData) {
        U9((QZoneIntimateSpaceBean) uIStateData.getData());
    }

    private void initViewModel() {
        nk.at atVar = (nk.at) getViewModel(nk.at.class);
        this.f57263d = atVar;
        atVar.U1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.intimate.part.br
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceBadgeWallPart.this.T9((UIStateData) obj);
            }
        });
        this.f57263d.S1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.intimate.part.bs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceBadgeWallPart.this.M9(((Float) obj).floatValue());
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneIntimateNewBadgeFullAnimEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateSpaceBadgeWallPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f162889n55) {
            R9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f57265f = O9();
        QZoneIntimateBadgePoolAnimView qZoneIntimateBadgePoolAnimView = this.f57264e;
        if (qZoneIntimateBadgePoolAnimView != null) {
            qZoneIntimateBadgePoolAnimView.h();
        }
        QLog.d("QZoneIntimateSpaceBadgeWallPart", 1, "[onConfigurationChanged] --> getScreenRotation, mScreenRotation = " + this.f57265f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QZoneIntimateBadgePoolAnimView qZoneIntimateBadgePoolAnimView = (QZoneIntimateBadgePoolAnimView) view.findViewById(R.id.f162889n55);
        this.f57264e = qZoneIntimateBadgePoolAnimView;
        qZoneIntimateBadgePoolAnimView.setOnClickListener(this);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        SensorManager sensorManager = this.f57267i;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.E);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        S9();
        SensorMonitor.registerListener(this.f57267i, this.E, this.f57266h, 2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        this.f57264e.i();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        this.f57264e.j();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneIntimateNewBadgeFullAnimEvent) {
            Q9((QZoneIntimateNewBadgeFullAnimEvent) simpleBaseEvent);
        }
    }

    private void N9(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("badge_entry_state", str);
        fo.b bVar = new fo.b();
        bVar.l(hashMap);
        fo.c.o(this.f57264e, "em_qz_badge_entrance", bVar);
    }

    private void U9(QZoneIntimateSpaceBean qZoneIntimateSpaceBean) {
        QZIntimateSpaceMedal$MainPageMedalDetail medalInfo = qZoneIntimateSpaceBean == null ? null : qZoneIntimateSpaceBean.getMedalInfo();
        if (medalInfo == null) {
            QLog.d(getTAG(), 1, "[updateSpaceInfo] medalDetail is null");
            return;
        }
        if (!qZoneIntimateSpaceBean.isFromRefreshSpace()) {
            QLog.d(getTAG(), 1, "[updateSpaceInfo] not from refresh space");
            return;
        }
        QLog.d(getTAG(), 1, "[updateSpaceInfo] medals.size = " + medalInfo.medals.get().size() + ", new_medals.size = " + medalInfo.new_medals.get().size() + ", alert_medal.icon = " + medalInfo.alert_medal.icon.get());
        this.f57264e.b(81, medalInfo.medals.get(), true, "");
        if (TextUtils.isEmpty(medalInfo.alert_medal.get().icon.get())) {
            this.f57264e.b(49, medalInfo.new_medals.get(), false, medalInfo.alert_medal.f430331id.get());
        }
        N9(medalInfo.has_new_medal.get());
    }

    /* loaded from: classes37.dex */
    class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int i3;
            float f16;
            float f17;
            if (sensorEvent.sensor.getType() == QZoneIntimateSpaceBadgeWallPart.this.f57268m) {
                QZoneIntimateSpaceBadgeWallPart qZoneIntimateSpaceBadgeWallPart = QZoneIntimateSpaceBadgeWallPart.this;
                if (qZoneIntimateSpaceBadgeWallPart.f57265f == -1) {
                    qZoneIntimateSpaceBadgeWallPart.f57265f = qZoneIntimateSpaceBadgeWallPart.O9();
                    QLog.d("QZoneIntimateSpaceBadgeWallPart", 1, "[onSensorChanged] --> getScreenRotation, mScreenRotation = " + QZoneIntimateSpaceBadgeWallPart.this.f57265f);
                }
                QZoneIntimateSpaceBadgeWallPart qZoneIntimateSpaceBadgeWallPart2 = QZoneIntimateSpaceBadgeWallPart.this;
                int i16 = qZoneIntimateSpaceBadgeWallPart2.f57265f;
                if (i16 == 1) {
                    float[] fArr = sensorEvent.values;
                    i3 = (int) (fArr[1] * 6.0f);
                    f16 = fArr[0];
                } else {
                    if (i16 == 2) {
                        float[] fArr2 = sensorEvent.values;
                        i3 = (int) (fArr2[0] * 6.0f);
                        f17 = fArr2[1];
                    } else if (i16 == 3) {
                        float[] fArr3 = sensorEvent.values;
                        i3 = (int) (fArr3[1] * (-1.0f) * 6.0f);
                        f17 = fArr3[0];
                    } else {
                        float[] fArr4 = sensorEvent.values;
                        i3 = (int) (fArr4[0] * 6.0f * (-1.0f));
                        f16 = fArr4[1];
                    }
                    f16 = f17 * (-1.0f);
                }
                int i17 = (int) (f16 * 6.0f);
                if (qZoneIntimateSpaceBadgeWallPart2.C != i3 || QZoneIntimateSpaceBadgeWallPart.this.D != i17) {
                    QZoneIntimateSpaceBadgeWallPart.this.f57264e.e().q(i3, i17);
                }
                QZoneIntimateSpaceBadgeWallPart.this.C = i3;
                QZoneIntimateSpaceBadgeWallPart.this.D = i17;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}

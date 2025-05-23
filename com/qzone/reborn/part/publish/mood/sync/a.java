package com.qzone.reborn.part.publish.mood.sync;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.lifecycle.Observer;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.util.ToastUtil;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends com.qzone.reborn.base.k implements View.OnClickListener {
    private gm.c C;
    private hm.b D;
    private fm.b E;
    private o F;

    /* renamed from: d, reason: collision with root package name */
    private final QZonePublishMoodNewStyleActivity f58703d;

    /* renamed from: e, reason: collision with root package name */
    protected View f58704e;

    /* renamed from: f, reason: collision with root package name */
    public CheckBox f58705f;

    /* renamed from: h, reason: collision with root package name */
    public CheckBox f58706h;

    /* renamed from: i, reason: collision with root package name */
    private CheckBox f58707i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f58708m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.reborn.part.publish.mood.sync.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public class C0490a implements CompoundButton.OnCheckedChangeListener {
        C0490a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            a.this.F.T1().postValue(Boolean.valueOf(z16));
            a aVar = a.this;
            aVar.Q9(aVar.f58705f, Boolean.valueOf(z16));
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            a.this.F.U1().postValue(Boolean.valueOf(z16));
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements Observer<Integer> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            a.this.O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e implements Observer<Integer> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            a.this.O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class f implements Observer<Long> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            a.this.O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g implements Observer<Long> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            a.this.O9();
        }
    }

    public a(QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity) {
        this.f58703d = qZonePublishMoodNewStyleActivity;
    }

    private boolean J9() {
        CheckBox checkBox = this.f58707i;
        if (checkBox != null && checkBox.getVisibility() == 0) {
            return true;
        }
        CheckBox checkBox2 = this.f58705f;
        if (checkBox2 != null && checkBox2.getVisibility() == 0) {
            return true;
        }
        CheckBox checkBox3 = this.f58706h;
        return checkBox3 != null && checkBox3.getVisibility() == 0;
    }

    private void M9() {
        CheckBox checkBox;
        CheckBox checkBox2;
        int G = u5.b.G(QZonePublishMoodNewStyleActivity.mp("shuoshuo_sync_bits"), 0);
        boolean z16 = (G & 1) != 0;
        boolean z17 = (G & 4) != 0;
        if (z16 && (checkBox2 = this.f58705f) != null) {
            checkBox2.setChecked(true);
        }
        if (!z17 || (checkBox = this.f58706h) == null) {
            return;
        }
        checkBox.setChecked(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N9() {
        boolean W1 = this.C.W1();
        if (this.f58705f != null && F9()) {
            if (W1) {
                this.f58705f.setChecked(false);
                this.f58705f.setVisibility(8);
                QZLog.d("QZonePublishSyncAllPlatformPart", 2, "has video ,set qq icon gone");
            } else {
                QZLog.d("QZonePublishSyncAllPlatformPart", 2, "don't has video ,set qq  icon visible");
                this.f58705f.setVisibility(0);
            }
        }
        if (this.f58706h != null && G9()) {
            if (W1) {
                this.f58706h.setChecked(false);
                this.f58706h.setVisibility(8);
                QZLog.d("QZonePublishSyncAllPlatformPart", 2, "has video ,set wechat icon gone");
            } else {
                QZLog.d("QZonePublishSyncAllPlatformPart", 2, "don't has video ,set  wechat icon visible");
                this.f58706h.setVisibility(0);
            }
        }
        if (this.f58704e != null) {
            this.f58704e.setVisibility(J9() ? 0 : 8);
        }
    }

    private void P9() {
        this.C.S1().observeForever(new c());
        this.D.T1().observeForever(new d());
        this.D.a2().observeForever(new e());
        this.D.X1().observeForever(new f());
        this.D.Z1().observeForever(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(View view, Boolean bool) {
        String str;
        HashMap hashMap = new HashMap();
        if (bool.booleanValue()) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("after_click_state", str);
        fo.c.e("em_qz_sync_qq", "pg_qz_space_says_publish", view, hashMap);
    }

    private void R9(boolean z16, boolean z17) {
        CheckBox checkBox = this.f58705f;
        if (checkBox == null) {
            return;
        }
        checkBox.setAlpha(1.0f);
        if (!F9()) {
            this.f58705f.setChecked(false);
            this.f58705f.setVisibility(8);
        } else if (z17) {
            this.f58705f.setChecked(false);
            this.f58705f.setAlpha(0.5f);
        }
    }

    private void S9(boolean z16, boolean z17) {
        CheckBox checkBox = this.f58706h;
        if (checkBox == null) {
            return;
        }
        checkBox.setAlpha(1.0f);
        if (!G9()) {
            this.f58706h.setChecked(false);
            this.f58706h.setVisibility(8);
        } else if (z17) {
            this.f58706h.setChecked(false);
            this.f58706h.setAlpha(0.5f);
        } else if (this.D.c2()) {
            this.f58706h.setChecked(false);
        }
    }

    public boolean F9() {
        return (this.E.T1() || !this.E.O1() || this.E.S1()) ? false : true;
    }

    public boolean G9() {
        return this.f58708m && this.E.O1() && !this.E.S1();
    }

    public void O9() {
        boolean W1 = this.C.W1();
        if (this.f58705f == null || this.f58706h == null) {
            return;
        }
        boolean d26 = this.D.d2();
        if (d26 && (this.f58705f.isChecked() || this.f58706h.isChecked())) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastPerssionShuoshuoCannotSync", "\u5df2\u8bbe\u7f6e\u6743\u9650\u7684\u8bf4\u8bf4\u4e0d\u80fd\u8fdb\u884c\u540c\u6b65"), 3);
        }
        R9(W1, d26);
        S9(W1, d26);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishSyncAllPlatformPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f58706h) {
            I9();
        } else if (view == this.f58705f) {
            H9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View findViewById = view.findViewById(R.id.f69263i_);
        this.f58704e = findViewById.findViewById(R.id.iuk);
        K9(findViewById);
        L9(findViewById);
        this.f58707i = (CheckBox) findViewById.findViewById(R.id.f85284oj);
        if (this.E.O1()) {
            M9();
            P9();
            this.f58704e.setVisibility(0);
            return;
        }
        this.f58704e.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.C = (gm.c) getViewModel(gm.c.class);
        this.D = (hm.b) getViewModel(hm.b.class);
        this.E = (fm.b) getViewModel(fm.b.class);
        this.F = (o) getViewModel(o.class);
    }

    private void H9() {
        QZLog.d("QZonePublishSyncAllPlatformPart", 2, "handleQQClick");
        com.qzone.misc.network.report.b.p(this.E.P1());
        if (this.D.d2()) {
            this.f58705f.setChecked(false);
            return;
        }
        this.f58705f.setChecked(!r0.isChecked());
        if (this.f58705f.isChecked()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSyncToQQ", "\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230QQ\u4e2a\u6027\u7b7e\u540d"), 6);
        } else {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCancelSyncToQQ", "\u5df2\u53d6\u6d88\u540c\u6b65QQ\u4e2a\u6027\u7b7e\u540d"), 5);
        }
    }

    private void I9() {
        String str;
        QZLog.d("QZonePublishSyncAllPlatformPart", 2, "handleWechatClick");
        if (this.D.c2()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotSyncToWeixin", "\u8bbe\u7f6e\u4e86\u65f6\u6548\u7684\u8bf4\u8bf4\u65e0\u6cd5\u540c\u6b65\u5230\u5fae\u4fe1"), 6);
            this.f58706h.setChecked(false);
            return;
        }
        if (this.E.T1() && u5.b.h0("key_dynamic_share_url", "null").equals("null")) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastWeakNetWork", "\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002"), 6);
            return;
        }
        com.qzone.misc.network.report.b.q(this.E.P1());
        if (this.D.d2()) {
            this.f58706h.setChecked(false);
            return;
        }
        this.f58706h.setChecked(!r0.isChecked());
        if (this.f58706h.isChecked()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSyncToWechat", "\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230\u670b\u53cb\u5708"), 6);
        } else {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCancelSyncToWechat", "\u5df2\u53d6\u6d88\u540c\u6b65\u670b\u53cb\u5708"), 5);
        }
        HashMap hashMap = new HashMap();
        if (this.f58706h.isChecked()) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("after_click_state", str);
        fo.c.e("em_qz_sync_moments", "pg_qz_space_says_publish", this.f58706h, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements Observer<DynamicArrayList<String>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.qzone.reborn.part.publish.mood.sync.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        public class C0491a implements Observer<ArrayList<String>> {
            C0491a() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(ArrayList<String> arrayList) {
                a.this.N9();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(DynamicArrayList<String> dynamicArrayList) {
            if (dynamicArrayList == null) {
                return;
            }
            dynamicArrayList.getLiveData().observeForever(new C0491a());
        }
    }

    private void K9(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.f69783jo);
        this.f58705f = checkBox;
        checkBox.setOnClickListener(this);
        if (!F9()) {
            this.f58705f.setVisibility(8);
        }
        this.f58705f.setOnCheckedChangeListener(new C0490a());
    }

    private void L9(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.f69823js);
        this.f58706h = checkBox;
        checkBox.setOnClickListener(this);
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        if (this.E.R1()) {
            this.f58706h.setVisibility(8);
        } else if (iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportTimeLine()) {
            this.f58708m = true;
            this.f58706h.setVisibility(0);
        } else {
            this.f58708m = false;
            this.f58706h.setVisibility(8);
        }
        this.f58706h.setOnCheckedChangeListener(new b());
    }
}

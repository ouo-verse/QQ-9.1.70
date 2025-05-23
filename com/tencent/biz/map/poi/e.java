package com.tencent.biz.map.poi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e extends com.tencent.biz.map.poi.a {

    /* renamed from: d, reason: collision with root package name */
    private f f78762d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.map.poi.b f78763e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.map.poi.d f78764f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.map.poi.a.x9("em_location_search_cancel", "dt_clck");
            if (e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                e.this.getActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f78766d;

        b(TextView textView) {
            this.f78766d = textView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f78766d.setAlpha(0.5f);
                return false;
            }
            if (motionEvent.getAction() == 1) {
                this.f78766d.setAlpha(1.0f);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.map.poi.a.x9("em_location_search_send", "dt_clck");
            if (e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                Activity activity = e.this.getActivity();
                e eVar = e.this;
                activity.setResult(-1, eVar.B9(eVar.f78764f.L1()));
                e.this.getActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            e.this.A9(bool.booleanValue());
        }
    }

    private void C9() {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.i(getTAG(), 1, "initTitleView");
            return;
        }
        TextView textView = (TextView) partRootView.findViewById(R.id.cau);
        textView.setOnClickListener(new a());
        textView.setOnTouchListener(new b(textView));
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(textView, textView.getResources().getString(R.string.f171177vu1), Button.class.getName());
        }
        partRootView.findViewById(R.id.cax).setOnClickListener(new c());
    }

    private void D9() {
        com.tencent.biz.map.poi.a.x9("em_location_search_send", "dt_imp");
        com.tencent.biz.map.poi.a.x9("em_location_search_cancel", "dt_imp");
    }

    private void initViewModel() {
        f fVar = (f) getViewModel(f.class);
        this.f78762d = fVar;
        if (fVar != null) {
            fVar.L1().observe(getHostFragment(), new d());
        }
        this.f78764f = (com.tencent.biz.map.poi.d) getViewModel(com.tencent.biz.map.poi.d.class);
        this.f78763e = (com.tencent.biz.map.poi.b) getViewModel(com.tencent.biz.map.poi.b.class);
    }

    protected void A9(boolean z16) {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.findViewById(R.id.cax).setEnabled(z16);
        }
    }

    public Intent B9(LocationRoom.Venue venue) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (venue != null) {
            bundle.putString("latitude", String.valueOf(venue.f241273i.getLatitude()));
            bundle.putString("longitude", String.valueOf(venue.f241273i.getLongitude()));
            bundle.putString("description", venue.f241271f);
            bundle.putString("title", venue.f241271f);
            bundle.putString("summary", venue.f241272h);
            bundle.putString("dianping_id", "-1");
            bundle.putString("latSpan", String.valueOf(venue.f241273i.getLatitude()));
            bundle.putString("lngSpan", String.valueOf(venue.f241273i.getLongitude()));
            bundle.putInt("isArk", 1);
            intent.putExtras(bundle);
            return intent;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "LBSTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        C9();
        initViewModel();
        D9();
    }
}

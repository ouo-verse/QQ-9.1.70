package com.tencent.mobileqq.nearbypro.map.poi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e extends Part {

    /* renamed from: d, reason: collision with root package name */
    private f f253581d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.nearbypro.map.poi.a f253582e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.nearbypro.map.poi.d f253583f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.getActivity() == null || e.this.getActivity().isFinishing()) {
                return;
            }
            e.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f253585d;

        b(TextView textView) {
            this.f253585d = textView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f253585d.setAlpha(0.5f);
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            this.f253585d.setAlpha(1.0f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.getActivity() == null || e.this.getActivity().isFinishing()) {
                return;
            }
            Activity activity = e.this.getActivity();
            e eVar = e.this;
            activity.setResult(-1, eVar.B9(eVar.f253583f.L1()));
            e.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            e.this.A9(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent B9(LbsDataV2.PoiInfo poiInfo) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (poiInfo == null) {
            return null;
        }
        bundle.putParcelable(PoiDbManager.TBL_POI, poiInfo);
        intent.putExtras(bundle);
        return intent;
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
        Button button = (Button) partRootView.findViewById(R.id.cax);
        button.setText("\u786e\u5b9a");
        button.setOnClickListener(new c());
    }

    private void initViewModel() {
        f fVar = (f) getViewModel(f.class);
        this.f253581d = fVar;
        if (fVar != null) {
            fVar.L1().observe(getHostFragment(), new d());
        }
        this.f253583f = (com.tencent.mobileqq.nearbypro.map.poi.d) getViewModel(com.tencent.mobileqq.nearbypro.map.poi.d.class);
        this.f253582e = (com.tencent.mobileqq.nearbypro.map.poi.a) getViewModel(com.tencent.mobileqq.nearbypro.map.poi.a.class);
    }

    protected void A9(boolean z16) {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            if (z16) {
                partRootView.findViewById(R.id.cax).setEnabled(true);
                partRootView.findViewById(R.id.cax).setAlpha(127.0f);
            } else {
                partRootView.findViewById(R.id.cax).setEnabled(false);
                partRootView.findViewById(R.id.cax).setAlpha(255.0f);
            }
        }
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
    }
}

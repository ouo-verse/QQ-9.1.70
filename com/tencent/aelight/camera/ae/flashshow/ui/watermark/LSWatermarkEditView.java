package com.tencent.aelight.camera.ae.flashshow.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkListView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.light.bean.WMElement;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSWatermarkEditView extends RelativeLayout implements View.OnClickListener {
    private List<WMElement> C;

    /* renamed from: d, reason: collision with root package name */
    private WatermarkListView f65087d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f65088e;

    /* renamed from: f, reason: collision with root package name */
    private DatePicker f65089f;

    /* renamed from: h, reason: collision with root package name */
    private WatermarkEditListAdapter f65090h;

    /* renamed from: i, reason: collision with root package name */
    protected lq.b f65091i;

    /* renamed from: m, reason: collision with root package name */
    private int f65092m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements WatermarkEditListAdapter.j {
        a() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.j
        public void a() {
            LSWatermarkEditView.this.f65089f.setVisibility(8);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.j
        public void b(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            LSWatermarkEditView.this.f65089f.init(calendar.get(1), calendar.get(2), calendar.get(5), LSWatermarkEditView.this.f65090h);
            LSWatermarkEditView.this.f65089f.setVisibility(0);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.j
        public void c() {
            LSWatermarkEditView.this.f65089f.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
    }

    public LSWatermarkEditView(Context context) {
        super(context);
        this.f65092m = 0;
    }

    private void f() {
        if (this.f65091i.f(589824) && ((Boolean) this.f65091i.b(589826, new Object[0])).booleanValue()) {
            this.f65091i.q(589826, new Object[0]);
        }
    }

    public void c() {
        ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void d(Activity activity, lq.b bVar) {
        this.f65088e = activity;
        this.f65091i = bVar;
        this.f65087d = (WatermarkListView) findViewById(R.id.rsp);
        this.f65089f = (DatePicker) findViewById(R.id.rrw);
        findViewById(R.id.s2e).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.s2f);
        textView.setOnClickListener(this);
        if (gq.a.r(activity.getIntent())) {
            textView.setTextColor(activity.getResources().getColor(R.color.afb));
        } else {
            textView.setTextColor(activity.getResources().getColor(R.color.afc));
        }
    }

    public void e(List<WMElement> list) {
        this.C = list;
        WatermarkEditListAdapter watermarkEditListAdapter = new WatermarkEditListAdapter(this.f65088e, list);
        this.f65090h = watermarkEditListAdapter;
        this.f65087d.setAdapter(watermarkEditListAdapter);
        this.f65089f.setVisibility(8);
        DatePicker datePicker = this.f65089f;
        datePicker.init(datePicker.getYear(), this.f65089f.getMonth(), this.f65089f.getDayOfMonth(), this.f65090h);
        this.f65090h.E(new a());
        this.f65087d.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.watermark.LSWatermarkEditView.2
            @Override // java.lang.Runnable
            public void run() {
                LSWatermarkEditView.this.f65090h.A();
            }
        }, 100L);
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WMElement wMElement;
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.s2e /* 2097545819 */:
                c();
                postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.watermark.LSWatermarkEditView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LSWatermarkEditView.this.setVisibility(8);
                    }
                }, 200L);
                f();
                break;
            case R.id.s2f /* 2097545820 */:
                c();
                postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.watermark.LSWatermarkEditView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LSWatermarkEditView.this.setVisibility(8);
                    }
                }, 200L);
                for (int i3 = 0; i3 < this.f65087d.b(); i3++) {
                    WatermarkEditListAdapter.i iVar = (WatermarkEditListAdapter.i) this.f65087d.a(i3);
                    if (iVar != null && !CollectionUtils.indexOutOfBounds(this.C, i3) && (wMElement = this.C.get(i3)) != null) {
                        if (!WMElement.TYPE_SINCE.equals(wMElement.type) && !WMElement.TYPE_COUNTDOWN.equals(wMElement.type)) {
                            if (WMElement.TYPE_CHECK_IN.equals(wMElement.type)) {
                                if (iVar.f63406h) {
                                    iVar.f63406h = false;
                                    wMElement.resetCheckIn();
                                }
                            } else if (WMElement.TYPE_EDITABLE_LOCATION.equals(wMElement.type)) {
                                String removeUTF8Emoji = StringUtils.removeUTF8Emoji(iVar.C.getText().toString().trim());
                                if (!TextUtils.isEmpty(removeUTF8Emoji)) {
                                    wMElement.setLocation(removeUTF8Emoji);
                                }
                            } else {
                                wMElement.setText(StringUtils.removeUTF8Emoji(iVar.f63403d.getText().toString().trim()));
                            }
                        } else if (iVar.f63403d.getTag() != null && (iVar.f63403d.getTag() instanceof Date)) {
                            wMElement.setDate(((Date) iVar.f63403d.getTag()).getTime());
                        }
                    }
                }
                f();
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setActionBarHeight(int i3) {
        this.f65092m = i3;
    }

    public void setWaterMarkLocation(String str) {
        WatermarkEditListAdapter watermarkEditListAdapter = this.f65090h;
        if (watermarkEditListAdapter != null) {
            watermarkEditListAdapter.F(str);
        }
    }

    public LSWatermarkEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65092m = 0;
    }

    public LSWatermarkEditView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65092m = 0;
    }

    public void setOnRenderTextListener(b bVar) {
    }
}

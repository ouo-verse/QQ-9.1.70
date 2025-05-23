package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.dc.b;
import com.tencent.luggage.wxa.fc.f;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class AppBrandTimePickerV2 implements c {
    private Context context;
    private int currentHour;
    private int currentMinute;
    private View mView;
    private com.tencent.luggage.wxa.hc.c pvTime;
    private int mMinTimeHour = -1;
    private int mMinTimeMinute = -1;
    private int mMaxTimeHour = -1;
    private int mMaxTimeMinute = -1;

    /* loaded from: classes9.dex */
    public class a implements f {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.fc.f
        public void onTimeSelect(Date date) {
            AppBrandTimePickerV2.this.getTimeString(date);
        }
    }

    @Keep
    public AppBrandTimePickerV2(Context context) {
        this.pvTime = new com.tencent.luggage.wxa.hc.c(context);
        this.context = context;
    }

    private void configPadding(List<WheelView> list) {
        if (list.size() == 1) {
            list.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.context.getResources().getDimensionPixelSize(R.dimen.bht));
            return;
        }
        if (list.size() == 2) {
            list.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.bht), this.context.getResources().getDimensionPixelSize(R.dimen.bht), this.context.getResources().getDimensionPixelSize(R.dimen.bht));
            list.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bht), this.context.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.context.getResources().getDimensionPixelSize(R.dimen.bht));
        } else if (list.size() == 3) {
            list.get(0).setPadding(0, this.context.getResources().getDimensionPixelSize(R.dimen.bht), this.context.getResources().getDimensionPixelSize(R.dimen.bgc), this.context.getResources().getDimensionPixelSize(R.dimen.bht));
            list.get(1).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bgc), this.context.getResources().getDimensionPixelSize(R.dimen.bht), this.context.getResources().getDimensionPixelSize(R.dimen.bgc), this.context.getResources().getDimensionPixelSize(R.dimen.bht));
            list.get(2).setPadding(this.context.getResources().getDimensionPixelSize(R.dimen.bgc), this.context.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.context.getResources().getDimensionPixelSize(R.dimen.bht));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTimeString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.currentHour = calendar.get(11);
        this.currentMinute = calendar.get(12);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public View getView() {
        if (this.mView == null) {
            this.mView = this.pvTime.l();
        }
        return this.mView;
    }

    public void init(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i3);
        calendar.set(12, i16);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, this.mMinTimeHour);
        calendar2.set(12, this.mMinTimeMinute);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(11, this.mMaxTimeHour);
        calendar3.set(12, this.mMaxTimeMinute);
        new b(this.context, new a()).a(new boolean[]{false, false, false, true, true, false}).a(calendar).a(calendar2, calendar3).a(false).a(ContextCompat.getColor(this.context, R.color.f156611ai0)).a(this.pvTime);
        this.pvTime.a(this.context.getResources().getDimensionPixelSize(R.dimen.c5l));
        this.pvTime.c(this.context.getResources().getDimensionPixelSize(R.dimen.cxz));
        this.pvTime.a(0, this.context.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.context.getResources().getDimensionPixelSize(R.dimen.bht));
        Iterator it = this.pvTime.m().iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).d(ContextCompat.getColor(this.context, R.color.f156614aj0)).c(this.context.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.context, R.color.ah_));
        }
        configPadding(this.pvTime.m());
    }

    public boolean isNewPicker() {
        return true;
    }

    public void setMaxTime(int i3, int i16) {
        this.mMaxTimeHour = i3;
        this.mMaxTimeMinute = i16;
    }

    public void setMinTime(int i3, int i16) {
        this.mMinTimeHour = i3;
        this.mMinTimeMinute = i16;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public String currentValue() {
        this.pvTime.p();
        return String.format(Locale.US, "%02d:%02d", Integer.valueOf(this.currentHour), Integer.valueOf(this.currentMinute));
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
    }
}

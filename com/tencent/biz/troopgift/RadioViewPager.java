package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public class RadioViewPager extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected GridListViewPager f96903d;

    /* renamed from: e, reason: collision with root package name */
    protected RadioButtonIndicator f96904e;

    /* renamed from: f, reason: collision with root package name */
    protected View f96905f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f96906h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f96907i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f96908m;

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f96909d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96910e;

        a(Context context, String str) {
            this.f96909d = context;
            this.f96910e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent(this.f96909d, (Class<?>) QQBrowserActivity.class);
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
            intent.putExtra("hide_more_button", true);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("url", this.f96910e);
            this.f96909d.startActivity(intent);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RadioViewPager(Context context) {
        this(context, null);
    }

    public void setEmptyInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f96906h.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f96908m.setText(str2);
        }
    }

    public void setGiftPanel(TroopGiftPanel troopGiftPanel) {
        this.f96903d.H = troopGiftPanel;
    }

    public void setIsListEmpty(boolean z16) {
        int i3;
        View view = this.f96905f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void setIsShowJumpInfo(boolean z16, String str, Context context) {
        int i3;
        TextView textView = this.f96908m;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.f96907i;
        if (!z16) {
            i16 = 8;
        }
        textView2.setVisibility(i16);
        if (z16 && !TextUtils.isEmpty(str)) {
            this.f96908m.setOnClickListener(new a(context, str));
        }
    }

    public RadioViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.aif, (ViewGroup) this, false);
        this.f96903d = (GridListViewPager) inflate.findViewById(R.id.fho);
        RadioButtonIndicator radioButtonIndicator = (RadioButtonIndicator) inflate.findViewById(R.id.djp);
        this.f96904e = radioButtonIndicator;
        radioButtonIndicator.setOrientation(0);
        this.f96903d.setOnPagerSizeChangeListener(this.f96904e);
        this.f96903d.setOnPageChangeListener(this.f96904e);
        this.f96905f = inflate.findViewById(R.id.cv7);
        this.f96906h = (TextView) inflate.findViewById(R.id.cv5);
        this.f96908m = (TextView) inflate.findViewById(R.id.cv6);
        this.f96907i = (TextView) inflate.findViewById(R.id.f165371cv4);
        this.f96908m.getPaint().setFlags(8);
        this.f96908m.getPaint().setAntiAlias(true);
        addView(inflate);
    }
}

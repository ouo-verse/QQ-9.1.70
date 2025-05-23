package com.tencent.mobileqq.qwallet.widget.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Locale;
import qk2.TransferConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class YellowTipsLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f279309d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f279310e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f279311f;

    /* renamed from: h, reason: collision with root package name */
    private String f279312h;

    public YellowTipsLayout(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ags, (ViewGroup) this, true);
        inflate.setClickable(true);
        inflate.setOnClickListener(this);
        this.f279309d = (ImageView) findViewById(R.id.dbh);
        this.f279310e = (TextView) findViewById(R.id.dbg);
        this.f279311f = (ImageView) findViewById(R.id.dbe);
    }

    public boolean b() {
        setVisibility(8);
        TransferConfig.TransferAd ad5 = ((TransferConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_TRANSFER_TIP_CONFIG, new TransferConfig())).getAd();
        if (ad5 == null) {
            return false;
        }
        try {
        } catch (Exception e16) {
            QLog.e("YellowTipsLayout", 1, "error msg in qqpay-impl module: ", e16);
        }
        if (!TextUtils.isEmpty(ad5.getText()) && !TextUtils.isEmpty(ad5.getBeginTime()) && !TextUtils.isEmpty(ad5.getEndTime())) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            long time = simpleDateFormat.parse(ad5.getBeginTime()).getTime();
            long time2 = simpleDateFormat.parse(ad5.getEndTime()).getTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= time && currentTimeMillis <= time2) {
                setVisibility(0);
                this.f279310e.setText(ad5.getText());
                setUrl(ad5.getUrl());
                setAdLevel(ad5.getLevel());
                if (getVisibility() != 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f279312h != null) {
            Intent intent = new Intent();
            Context context = view.getContext();
            intent.putExtra("url", this.f279312h);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAdLevel(String str) {
        if (str != null && "info".equals(str)) {
            setWarningVisible(false);
        } else {
            setWarningVisible(true);
        }
    }

    public void setArrowVisible(boolean z16) {
        if (z16) {
            if (this.f279311f.getVisibility() != 0) {
                this.f279311f.setVisibility(0);
            }
        } else if (this.f279311f.getVisibility() == 0) {
            this.f279311f.setVisibility(4);
        }
    }

    public void setMessage(String str) {
        this.f279310e.setText(str);
    }

    public void setUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            setArrowVisible(false);
            this.f279312h = null;
        } else {
            setArrowVisible(true);
            this.f279312h = str;
        }
    }

    public void setWarningVisible(boolean z16) {
        if (z16) {
            if (this.f279309d.getVisibility() != 0) {
                this.f279309d.setVisibility(0);
            }
        } else if (this.f279309d.getVisibility() == 0) {
            this.f279309d.setVisibility(4);
        }
    }

    public YellowTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}

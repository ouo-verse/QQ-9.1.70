package com.tencent.mobileqq.guild.widget.countrySelect;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.countrySelect.GuildCountrySelectView;
import com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends GuildActionSheetProfileEdit implements GuildActionSheetProfileEdit.d {
    private final Context Q;
    private GuildCountrySelectView R;
    private IProfileEditBusinessApi.OnGetUserLocationListener S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.widget.countrySelect.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C7913a implements GuildCountrySelectView.f {
        C7913a() {
        }

        @Override // com.tencent.mobileqq.guild.widget.countrySelect.GuildCountrySelectView.f
        public void getSelectResult(String str) {
            a.this.updateCountryData(str);
            a.this.dismiss();
            a.this.R = null;
        }
    }

    public a(Context context, String str, boolean z16) {
        super(context);
        this.Q = context;
        d0(str, z16);
        initUI();
        setContentWrapperView(this.R.getRootView());
        a0(this);
        this.P = z16;
        if (z16) {
            S();
        }
    }

    private void d0(String str, boolean z16) {
        GuildCountrySelectView guildCountrySelectView = new GuildCountrySelectView(this.Q, z16);
        this.R = guildCountrySelectView;
        guildCountrySelectView.l(str, false);
        this.R.setCountrySelectListener(new C7913a());
    }

    private int getSystemStatusBarHeight() {
        int identifier;
        Context context = this.Q;
        if (context == null || context.getResources() == null || (identifier = this.Q.getResources().getIdentifier("status_bar_height", "dimen", "android")) == 0) {
            return 0;
        }
        return this.Q.getResources().getDimensionPixelSize(identifier);
    }

    private void initUI() {
        ((TextView) this.I.findViewById(R.id.title)).setText("\u9009\u62e9\u56fd\u5bb6");
        ((TextView) this.I.findViewById(R.id.b7m)).setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.dip2px(60.0f) + getSystemStatusBarHeight();
        this.J.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountryData(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("CountrySelectActionSheet", 4, "\u66f4\u65b0\u56fd\u5bb6\u4fe1\u606f\u5931\u8d25");
            return;
        }
        QLog.d("CountrySelectActionSheet", 4, "\u9009\u62e9\u4e86\u56fd\u5bb6\uff1a" + str);
        this.S.onGetUserLocation(true, new String[]{str, "0", "0", "0"}, true);
    }

    @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
    public void onDismiss() {
        IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener = this.S;
        if (onGetUserLocationListener != null) {
            onGetUserLocationListener.onGetUserLocation(false, null, true);
        }
    }

    public void setOnGetUserLocationListener(IProfileEditBusinessApi.OnGetUserLocationListener onGetUserLocationListener) {
        this.S = onGetUserLocationListener;
    }

    @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
    public void onConfirm() {
    }
}

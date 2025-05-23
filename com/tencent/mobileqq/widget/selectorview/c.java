package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.selectorview.CountryPickerView;
import com.tencent.mobileqq.widget.selectorview.LocationSelectorView;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends QActionSheet implements QActionSheet.f {
    private CountryPickerView Y;
    private LocationSelectorView.f Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements CountryPickerView.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.CountryPickerView.f
        public void getSelectResult(String str) {
            c.this.updateCountryData(str);
            c.this.dismiss();
            c.this.Y = null;
        }
    }

    public c(Context context, String str, boolean z16, List<BaseAddress> list) {
        this(context, str, z16, list, true);
    }

    private int getSystemStatusBarHeight() {
        int identifier;
        Context context = this.C;
        if (context == null || context.getResources() == null || (identifier = this.C.getResources().getIdentifier("status_bar_height", "dimen", "android")) == 0) {
            return 0;
        }
        return this.C.getResources().getDimensionPixelSize(identifier);
    }

    private void initUI() {
        ((TextView) this.J.findViewById(R.id.f62062zt)).setText(HardCodeUtil.qqStr(R.string.f2040251s));
        ((TextView) this.J.findViewById(R.id.f61972zk)).setVisibility(8);
        ((TextView) this.J.findViewById(R.id.f61982zl)).setText(R.string.f2040151r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.dip2px(60.0f) + getSystemStatusBarHeight();
        this.K.setLayoutParams(layoutParams);
    }

    private void o0(String str, boolean z16, List<BaseAddress> list, boolean z17) {
        CountryPickerView countryPickerView = new CountryPickerView(this.C);
        this.Y = countryPickerView;
        countryPickerView.setCountryList(list);
        this.Y.g(str, z17);
        this.Y.setCountrySelectListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountryData(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("CountrySelectorView", 1, "updateCountryData fail");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CountrySelectorView", 2, "updateCountryData\uff1a" + str);
        }
        this.Z.onGetUserLocation(true, new String[]{str, "0", "0", "0"}, true);
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
    public void onConfirm() {
        onDismiss();
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
    public void onDismiss() {
        LocationSelectorView.f fVar = this.Z;
        if (fVar != null) {
            fVar.onGetUserLocation(false, null, true);
        }
    }

    public void p0(LocationSelectorView.f fVar) {
        this.Z = fVar;
    }

    public c(Context context, String str, boolean z16, List<BaseAddress> list, boolean z17) {
        super(context, z16);
        o0(str, z16, list, z17);
        initUI();
        setContentWrapperView(this.Y.getRootView());
        j0(this);
        if (z16) {
            U();
        }
    }

    @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
    public void t() {
    }
}

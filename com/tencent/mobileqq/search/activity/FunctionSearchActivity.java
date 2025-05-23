package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.FunctionSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FunctionSearchActivity extends BaseSearchActivity {
    private static String P2(String str) {
        if (h.o()) {
            if (str.equals(HardCodeUtil.qqStr(R.string.f187513u7)) || str.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.f187503u6)) || str.equalsIgnoreCase(HardCodeUtil.qqStr(R.string.f187493u5))) {
                return HardCodeUtil.qqStr(R.string.f187533u9);
            }
            return str;
        }
        return str;
    }

    public static void launch(Context context, String str) {
        String P2 = P2(str);
        Intent intent = new Intent(context, (Class<?>) FunctionSearchActivity.class);
        intent.putExtra("keyword", P2);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String I2() {
        return String.valueOf(11);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String J2() {
        return "\u641c\u7d22\u529f\u80fd";
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected BaseSearchFragment K2() {
        return FunctionSearchFragment.rh();
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String trim = P2(this.f282784c0.getText().toString()).trim();
        if (!trim.equals(this.f282782a0)) {
            SearchUtils.f284957f = 0L;
        }
        L2(trim);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.f282789h0 = true;
        super.doOnCreate(bundle);
        return true;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

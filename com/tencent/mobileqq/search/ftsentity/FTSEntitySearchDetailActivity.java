package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.ftsentity.qqnt.NTFTSEntitySearchDetailFragment;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ca;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FTSEntitySearchDetailActivity extends IphoneTitleBarActivity {

    /* renamed from: c0, reason: collision with root package name */
    private static List<FTSEntity> f283228c0;

    /* renamed from: a0, reason: collision with root package name */
    private List<FTSEntity> f283229a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f283230b0;

    private Fragment G2() {
        if (this.f283230b0 == 2) {
            return NTFTSEntitySearchDetailFragment.vh(getIntent().getStringExtra("original_keyword"), getIntent().getStringExtra("segment_keyword"), getIntent().getIntExtra("query_id", -1), getIntent().getStringExtra("uin"), getIntent().getIntExtra("uinType", -1), getIntent().getStringExtra("title"), getIntent().getIntExtra("item_count", 0));
        }
        return FTSEntitySearchDetailFragment.qh(getIntent().getStringExtra("original_keyword"), getIntent().getStringExtra("segment_keyword"), this.f283229a0);
    }

    public static void I2(Context context, String str, String str2, CharSequence charSequence, List<? extends FTSEntity> list, int i3, String str3, int i16, int i17) {
        J2(context, str, str2, charSequence, list, i3, str3, i16, i17, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void J2(Context context, String str, String str2, CharSequence charSequence, List<? extends FTSEntity> list, int i3, String str3, int i16, int i17, int i18) {
        f283228c0 = list;
        Intent intent = new Intent(context, (Class<?>) FTSEntitySearchDetailActivity.class);
        intent.putExtra("original_keyword", str);
        intent.putExtra("segment_keyword", str2);
        intent.putExtra("title", charSequence);
        intent.putExtra("query_id", i17);
        intent.putExtra("extra_key_fts_type", i3);
        intent.putExtra("uin", str3);
        intent.putExtra("uinType", i16);
        intent.putExtra("item_count", i18);
        context.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d1, code lost:
    
        if (r9.length() <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
    
        r13 = r9 + "\u2026";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void H2(String str, String str2, TextView textView) {
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("IphoneTitleBarActivity", 2, "genDiscussTitle, name == null");
                return;
            }
            return;
        }
        int q16 = ((n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(str2);
        if (q16 <= 0) {
            textView.setText(str);
            return;
        }
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int f16 = i3 - BaseAIOUtils.f(207.0f, getResources());
        TextPaint paint = textView.getPaint();
        float measureText = (f16 - paint.measureText(String.format("(%d\u4eba)", Integer.valueOf(q16)))) - (getResources().getDisplayMetrics().density * 4.0f);
        if (measureText > 0.0f) {
            float measureText2 = paint.measureText(str);
            if (measureText2 > measureText) {
                float measureText3 = measureText - paint.measureText("\u2026");
                String str3 = str;
                while (measureText3 > 0.0f && measureText2 > measureText3 && str3.length() > 0) {
                    str3 = str3.substring(0, str3.length() - 1);
                    measureText2 = paint.measureText(str3);
                    if (measureText2 == 0.0f && str3.length() > 0) {
                        measureText2 = 1.0f + measureText3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("IphoneTitleBarActivity", 2, "genDiscussTitle : name widht = " + measureText2);
                    }
                }
            }
        }
        textView.setText(String.format("%s(%d\u4eba)", str, Integer.valueOf(q16)));
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        ca.a(this);
        super.doOnCreate(bundle);
        this.f283229a0 = f283228c0;
        this.f283230b0 = getIntent().getIntExtra("extra_key_fts_type", 0);
        setContentView(R.layout.f167784he);
        String stringExtra = getIntent().getStringExtra("uin");
        int intExtra = getIntent().getIntExtra("uinType", -1);
        if (intExtra == 3000) {
            H2(ac.Q(this.app, stringExtra, intExtra), stringExtra, this.centerView);
        } else if (intExtra == 10007) {
            super.setTitle(getIntent().getStringExtra("title"));
        } else if (this.f283230b0 == 2) {
            super.setTitle(getIntent().getStringExtra("title"));
        } else {
            super.setTitle(ac.Q(this.app, stringExtra, intExtra));
        }
        FragmentManager supportFragmentManager = super.getSupportFragmentManager();
        Fragment G2 = G2();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.b9v, G2);
        beginTransaction.commitAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        f283228c0 = null;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

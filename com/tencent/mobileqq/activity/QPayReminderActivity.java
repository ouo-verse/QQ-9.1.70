package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class QPayReminderActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private Button f176719a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f176720b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f176721c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f176722d0;

    public QPayReminderActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean G2() {
        try {
            Intent intent = getIntent();
            if (intent.getIntExtra("URGENCY", 1) == 1) {
                this.f176721c0.setImageResource(R.drawable.fqb);
            } else {
                this.f176721c0.setImageResource(R.drawable.fqa);
            }
            this.f176722d0 = intent.getIntExtra("TEMPLATE", 1);
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("CONTENT"));
            setTitle(jSONObject.getJSONObject("title").getString("text"));
            String string = jSONObject.getJSONObject("footnote").getString("text");
            this.f176719a0.setText(string);
            this.f176719a0.setContentDescription(string);
            JSONArray jSONArray = jSONObject.getJSONArray("para");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                if (jSONArray.get(i3) instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3).getJSONObject(TtmlNode.TAG_SPAN);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) jSONObject2.getString("text"));
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(jSONObject2.getInt("fontsize"), true), length, length2, 33);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(jSONObject2.getString("color"))), length, length2, 33);
                }
            }
            this.f176720b0.setText(spannableStringBuilder);
            this.f176720b0.setContentDescription(spannableStringBuilder.toString());
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        super.doOnCreate(bundle);
        super.setContentView(R.layout.bd9);
        setLeftButton(R.string.close, this);
        Button button = (Button) findViewById(R.id.fjj);
        this.f176719a0 = button;
        button.setOnClickListener(this);
        this.f176720b0 = (TextView) findViewById(R.id.fjd);
        this.f176721c0 = (ImageView) findViewById(R.id.fjc);
        if (!G2()) {
            finish();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (view == this.f176719a0) {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", "https://imgcache.qq.com/club/mqq/wallet/webank/qf/index.html?_wv=1027&pvsrc=1");
                startActivity(intent);
            } else {
                finish();
            }
            QQAppInterface qQAppInterface = this.app;
            if (view == this.f176719a0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004B3F", "0X8004B3F", 0, i3, String.valueOf(this.f176722d0), "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

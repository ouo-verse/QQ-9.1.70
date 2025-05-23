package cooperation.troop_homework.outer;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TroopHWRecordBaseActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    protected CommonRecordSoundPanel f391007a0;

    /* renamed from: b0, reason: collision with root package name */
    protected RelativeLayout f391008b0;

    /* renamed from: c0, reason: collision with root package name */
    protected View f391009c0;

    /* renamed from: d0, reason: collision with root package name */
    protected AudioInfo f391010d0;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f391011e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private View.OnClickListener f391012f0 = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.jva) {
                TroopHWRecordBaseActivity troopHWRecordBaseActivity = TroopHWRecordBaseActivity.this;
                if (!troopHWRecordBaseActivity.f391011e0) {
                    troopHWRecordBaseActivity.setResult(0);
                    TroopHWRecordBaseActivity.this.finish();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void G2(Resources resources, View view) {
        Bitmap bitmap;
        Drawable drawable = resources.getDrawable(R.drawable.skin_panel_background);
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof SkinnableBitmapDrawable) {
            bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setDither(true);
        view.setBackgroundDrawable(bitmapDrawable);
    }

    private void initViews() {
        View findViewById = findViewById(R.id.jva);
        this.f391009c0 = findViewById;
        findViewById.setBackgroundColor(1291845632);
        this.f391009c0.setOnClickListener(this.f391012f0);
        this.f391008b0 = (RelativeLayout) findViewById(R.id.i3r);
        G2(getResources(), this.f391008b0);
        F2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        setContentView(R.layout.aiw);
        initViews();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        if (this.f391007a0 != null) {
            QLog.d("TroopHomeworkRecordActivity", 1, "RecordPanel.onDestroy() is called,isRecording is:" + this.f391007a0.m());
            this.f391007a0.onDestroy();
            return;
        }
        QLog.d("TroopHomeworkRecordActivity", 1, "doOnDestroy with mRecordPanel is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        if (this.f391007a0 != null) {
            QLog.d("TroopHomeworkRecordActivity", 1, "RecordPanel.onPause() is called,isRecording is:" + this.f391007a0.m());
            this.f391007a0.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        this.f391009c0.setBackgroundResource(R.drawable.f162601b70);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopHomeworkRecordActivity", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + this.f391007a0.m());
        }
        this.f391007a0.onBackEvent();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    protected void F2() {
    }
}

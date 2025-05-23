package cooperation.qqfav.globalsearch;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FavoriteSearchActivity extends BaseSearchActivity {
    public static void launch(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FavoriteSearchActivity.class);
        intent.putExtra("keyword", str);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String I2() {
        return String.valueOf(15);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String J2() {
        return HardCodeUtil.qqStr(R.string.mew);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected BaseSearchFragment<b> K2() {
        return new FavoriteSearchFragment();
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (getIntent() != null && UniteSearchActivity.class.getSimpleName().equals(getIntent().getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY))) {
            overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

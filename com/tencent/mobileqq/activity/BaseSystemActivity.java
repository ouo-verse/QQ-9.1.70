package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BaseSystemActivity extends IphoneTitleBarActivity implements Observer {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    private static int f175040e0;

    /* renamed from: f0, reason: collision with root package name */
    private static Calendar f175041f0;

    /* renamed from: g0, reason: collision with root package name */
    private static StringBuffer f175042g0;

    /* renamed from: a0, reason: collision with root package name */
    private XListView f175043a0;

    /* renamed from: b0, reason: collision with root package name */
    CursorAdapter f175044b0;

    /* renamed from: c0, reason: collision with root package name */
    String f175045c0;

    /* renamed from: d0, reason: collision with root package name */
    HashMap<Long, Long> f175046d0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66658);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f175041f0 = Calendar.getInstance();
            f175042g0 = new StringBuffer();
        }
    }

    public BaseSystemActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f175046d0 = new HashMap<>();
        }
    }

    private static int I2(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = f175040e0;
        int i16 = (int) ((currentTimeMillis + i3) / 86400000);
        int i17 = i16 - 1;
        int i18 = i16 - 2;
        int i19 = (int) ((j3 + i3) / 86400000);
        if (i19 == i16) {
            return R.string.i3f;
        }
        if (i19 == i17) {
            return R.string.ihd;
        }
        if (i19 == i18) {
            return R.string.f170578ul;
        }
        return -1;
    }

    public static String J2(long j3, boolean z16) {
        boolean z17 = false;
        f175042g0.setLength(0);
        f175041f0.setTimeInMillis(j3);
        int I2 = I2(j3);
        if (I2 != -1) {
            if (I2 != R.string.i3f) {
                f175042g0.append(BaseApplication.getContext().getString(I2));
            }
            z17 = true;
        }
        int i3 = f175041f0.get(11);
        int i16 = f175041f0.get(12);
        if (z17) {
            if (I2 == R.string.i3f) {
                int i17 = 24;
                if (i3 != 24) {
                    i17 = i3 % 24;
                }
                if (i17 < 10) {
                    f175042g0.append('0');
                }
                f175042g0.append(i17);
                f175042g0.append(':');
                if (i16 < 10) {
                    f175042g0.append('0');
                }
                f175042g0.append(i16);
            } else if (!z16) {
                f175042g0.append(TokenParser.SP);
                if (i3 < 10) {
                    f175042g0.append('0');
                }
                f175042g0.append(i3);
                f175042g0.append(':');
                if (i16 < 10) {
                    f175042g0.append('0');
                }
                f175042g0.append(i16);
            }
        } else {
            StringBuffer stringBuffer = f175042g0;
            stringBuffer.append(f175041f0.get(1));
            stringBuffer.append('/');
            stringBuffer.append(f175041f0.get(2) + 1);
            stringBuffer.append('/');
            stringBuffer.append(f175041f0.get(5));
            if (!z16) {
                f175042g0.append(TokenParser.SP);
                f175042g0.append(i3);
                f175042g0.append(':');
                if (i16 < 10) {
                    f175042g0.append('0');
                }
                f175042g0.append(i16);
            }
        }
        return f175042g0.toString();
    }

    private void init() throws Exception {
        super.setContentView(R.layout.b3b);
        setContentBackgroundResource(R.drawable.bg_texture);
        this.f175043a0 = (XListView) findViewById(R.id.j9v);
        String K2 = K2();
        this.f175045c0 = K2;
        if (K2 != null) {
            CursorAdapter G2 = G2();
            this.f175044b0 = G2;
            if (G2 != null) {
                this.f175043a0.setAdapter((ListAdapter) G2);
                this.f175043a0.setTranscriptMode(1);
                this.f175043a0.setSelection(0);
                this.app.getMessageFacade().addObserver(this);
                setTitle(M2());
                f175040e0 = TimeZone.getDefault().getRawOffset();
                return;
            }
            throw new Exception("mAdapter is null");
        }
        throw new Exception("peerUin is null");
    }

    protected CursorAdapter G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CursorAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    protected Cursor H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Cursor) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    protected String K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long L2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, j3)).longValue();
        }
        if (this.f175046d0.containsKey(Long.valueOf(j3))) {
            return this.f175046d0.get(Long.valueOf(j3)).longValue();
        }
        return -1L;
    }

    protected CharSequence M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N2(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cursor);
            return;
        }
        this.f175046d0.clear();
        if (cursor.moveToFirst()) {
            String str = null;
            do {
                long j3 = cursor.getLong(cursor.getColumnIndex("uniseq"));
                long j16 = cursor.getLong(cursor.getColumnIndex("time"));
                if (str == null) {
                    str = cursor.getString(cursor.getColumnIndex("frienduin"));
                }
                this.f175046d0.put(Long.valueOf(j3), Long.valueOf(j16));
            } while (cursor.moveToNext());
        }
        cursor.moveToFirst();
    }

    protected void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        try {
            init();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public View onCreateRightView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        super.onCreateRightView();
        this.rightViewText.setVisibility(0);
        this.rightViewText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.byj, 0, 0, 0);
        return this.rightViewText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        this.app.getMessageFacade().deleteObserver(this);
        CursorAdapter cursorAdapter = this.f175044b0;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
            this.f175044b0.changeCursor(H2());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (H2() != null) {
            N2(H2());
            this.f175044b0.changeCursor(H2());
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj != null && (obj instanceof MessageRecord)) {
            MessageRecord messageRecord = (MessageRecord) obj;
            if (this.f175045c0.equals(messageRecord.frienduin) && messageRecord.istroop == 0) {
                this.app.getMessageFacade().O0(this.f175045c0, 0);
                runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.BaseSystemActivity.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseSystemActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (BaseSystemActivity.this.f175044b0.getCursor() != null) {
                            BaseSystemActivity.this.refresh();
                        }
                    }
                });
            }
            if (!messageRecord.isSendFromLocal()) {
                runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.BaseSystemActivity.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseSystemActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            BaseSystemActivity.this.P2();
                        }
                    }
                });
            }
        }
    }
}

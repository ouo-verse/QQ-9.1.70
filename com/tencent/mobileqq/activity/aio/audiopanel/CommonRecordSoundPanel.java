package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUITemp;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class CommonRecordSoundPanel extends RelativeLayout implements j, View.OnClickListener, c {
    private TextView C;
    private ImageView D;
    private PopupWindow E;
    private View F;
    AppActivity G;
    Handler H;
    i I;
    private String J;
    private String K;
    private String L;
    int M;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f178257d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f178258e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f178259f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f178260h;

    /* renamed from: i, reason: collision with root package name */
    private VolumeIndicateSquareView f178261i;

    /* renamed from: m, reason: collision with root package name */
    private VolumeIndicateSquareView f178262m;

    public CommonRecordSoundPanel(Context context) {
        super(context);
        this.J = "common record panel";
        this.M = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j() {
        return this.G.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public AppActivity a() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void b() {
        this.f178258e.setVisibility(8);
        this.f178259f.setVisibility(0);
        this.f178260h.setVisibility(8);
        this.D.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public Handler c() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void d(String str) {
        this.G.getWindow().clearFlags(128);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void e(String str) {
        this.G.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.2
            @Override // java.lang.Runnable
            public void run() {
                CommonRecordSoundPanel.this.G.getWindow().clearFlags(128);
                QQToast.makeText(CommonRecordSoundPanel.this.G, R.string.f170311lx, 1).show(CommonRecordSoundPanel.this.j());
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void f(int i3) {
        int i16 = i3 / 1180;
        this.f178261i.c(i16);
        this.f178262m.c(i16);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public AppRuntime getApp() {
        return this.f178257d;
    }

    @Override // com.tencent.mvp.c
    public com.tencent.mvp.b getPresenter() {
        return this.I;
    }

    public double i() {
        i iVar = this.I;
        if (iVar != null) {
            return iVar.getRecordTime();
        }
        return 0.0d;
    }

    public void k(AppRuntime appRuntime, AppActivity appActivity, Handler handler, int i3) {
        l(appRuntime, appActivity, handler, i3, false);
    }

    public void l(AppRuntime appRuntime, AppActivity appActivity, Handler handler, int i3, boolean z16) {
        this.f178257d = appRuntime;
        this.G = appActivity;
        this.H = handler;
        this.f178258e = (TextView) findViewById(R.id.fy8);
        this.f178259f = (ViewGroup) findViewById(R.id.j1m);
        this.f178260h = (ViewGroup) findViewById(R.id.djl);
        this.f178261i = (VolumeIndicateSquareView) findViewById(R.id.djn);
        this.f178262m = (VolumeIndicateSquareView) findViewById(R.id.djo);
        this.C = (TextView) findViewById(R.id.i46);
        ImageView imageView = (ImageView) findViewById(R.id.f166767i40);
        this.D = imageView;
        imageView.setOnClickListener(this);
        i iVar = this.I;
        if (iVar != null) {
            iVar.a(i3);
        }
        if (z16) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.1
                @Override // java.lang.Runnable
                public void run() {
                    CommonRecordSoundPanel commonRecordSoundPanel = CommonRecordSoundPanel.this;
                    commonRecordSoundPanel.onClick(commonRecordSoundPanel.D);
                }
            }, 100L);
        }
    }

    public boolean m() {
        i iVar = this.I;
        if (iVar != null) {
            return iVar.isRecording();
        }
        return false;
    }

    public void n(int i3) {
        i iVar = this.I;
        if (iVar != null) {
            iVar.b(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        boolean m3 = m();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + m3);
        }
        if (m3) {
            n(102);
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        AppActivity appActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
        }
        if (id5 == R.id.f166767i40) {
            boolean m3 = m();
            AppActivity appActivity2 = this.G;
            if (appActivity2 != null && appActivity2.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "isRecording is:" + m3 + " hasPermission is:" + z16);
            }
            if (m3) {
                n(102);
            } else if (!z16 && (appActivity = this.G) != null) {
                QQUITemp.requestRecordAudioPermission(appActivity, this.K, this.L);
                n(102);
            } else {
                boolean equals = Environment.getExternalStorageState().equals("mounted");
                if (this.G != null) {
                    int j3 = j();
                    if (equals) {
                        if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) {
                            i iVar = this.I;
                            if (iVar != null) {
                                if (iVar.g()) {
                                    if (QQTheme.isNowThemeIsNight()) {
                                        this.D.setImageResource(R.drawable.qui_aio_audio_panel_new_listen_stop_btn_night);
                                    } else {
                                        this.D.setImageResource(R.drawable.aa_);
                                    }
                                    this.D.setContentDescription(HardCodeUtil.qqStr(R.string.kuv));
                                    this.I.d();
                                    this.I.e(102);
                                    getWindowVisibleDisplayFrame(new Rect());
                                }
                            } else {
                                QLog.e(this.J, 1, "recorderInit mPresenter not find");
                            }
                        } else {
                            QQToast.makeText(BaseApplication.getContext(), R.string.f224266ig, 0).show(j3);
                        }
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), R.string.ck7, 0).show(j3);
                    }
                }
                ReportController.o(this.f178257d, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        boolean m3 = m();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + m3);
        }
        if (m3) {
            n(1);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        boolean m3 = m();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + m3);
        }
        if (m3) {
            n(102);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return m();
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void reset() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
        }
        this.f178258e.setVisibility(0);
        this.f178259f.setVisibility(8);
        this.f178260h.setVisibility(8);
        this.D.setVisibility(0);
        if (QQTheme.isNowThemeIsNight()) {
            this.D.setImageResource(R.drawable.kou);
        } else {
            this.D.setImageResource(R.drawable.aab);
        }
        this.D.setContentDescription(HardCodeUtil.qqStr(R.string.kuu));
        i iVar = this.I;
        if (iVar != null) {
            this.C.setText(iVar.getTimeStrByMillis(0.0d));
        }
        PopupWindow popupWindow = this.E;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                try {
                    this.E.dismiss();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", e16);
                    }
                }
            }
            this.E = null;
        }
        View view = this.F;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.F.getParent()).removeView(this.F);
            }
            this.F = null;
        }
    }

    public void setPermissionBusinessParams(String str, String str2) {
        this.K = str;
        this.L = str2;
    }

    public void setPresenter(com.tencent.mvp.b bVar) {
        if (bVar == null) {
            this.I = null;
        } else if (bVar instanceof i) {
            this.I = (i) bVar;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void setRecordTime(String str) {
        this.C.setText(str);
    }

    public void setTimeOutTime(int i3) {
        i iVar = this.I;
        if (iVar != null) {
            iVar.f(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.j
    public void startRecord() {
        VolumeIndicateSquareView volumeIndicateSquareView = this.f178261i;
        if (volumeIndicateSquareView != null && this.f178262m != null) {
            volumeIndicateSquareView.b();
            this.f178262m.b();
        }
        this.f178258e.setVisibility(8);
        this.f178259f.setVisibility(8);
        this.f178260h.setVisibility(0);
        this.D.setVisibility(0);
    }

    public CommonRecordSoundPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.J = "common record panel";
        this.M = 0;
    }
}

package com.qzone.preview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class QzonePictureSelectViewer extends BasePictureViewer implements View.OnClickListener {

    /* renamed from: y1, reason: collision with root package name */
    public static final long f49734y1 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MAX_P2V_VIDEO_DURING, 15000L);

    /* renamed from: c1, reason: collision with root package name */
    private View f49737c1;

    /* renamed from: d1, reason: collision with root package name */
    private View f49738d1;

    /* renamed from: e1, reason: collision with root package name */
    private TextView f49739e1;

    /* renamed from: f1, reason: collision with root package name */
    private TextView f49740f1;

    /* renamed from: g1, reason: collision with root package name */
    private TextView f49741g1;

    /* renamed from: h1, reason: collision with root package name */
    private Button f49742h1;

    /* renamed from: i1, reason: collision with root package name */
    private NumberCheckBox f49743i1;

    /* renamed from: j1, reason: collision with root package name */
    private CheckBox f49744j1;

    /* renamed from: k1, reason: collision with root package name */
    private View f49745k1;

    /* renamed from: l1, reason: collision with root package name */
    private ArrayList<String> f49746l1;

    /* renamed from: m1, reason: collision with root package name */
    private int f49747m1;
    private boolean Z0 = false;

    /* renamed from: a1, reason: collision with root package name */
    private int f49735a1 = -1;

    /* renamed from: b1, reason: collision with root package name */
    private int f49736b1 = 0;

    /* renamed from: n1, reason: collision with root package name */
    private boolean f49748n1 = false;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f49749o1 = false;

    /* renamed from: p1, reason: collision with root package name */
    public String f49750p1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureViewerMaxSelectHint", "\u6700\u591a\u9009\u62e9%d\u4e2a");

    /* renamed from: q1, reason: collision with root package name */
    public String f49751q1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureViewerConfirmHint", "\u786e\u5b9a(%d)");

    /* renamed from: r1, reason: collision with root package name */
    public String f49752r1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureViewerConfirmText", "\u786e\u5b9a");

    /* renamed from: s1, reason: collision with root package name */
    public String f49753s1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureNoVideoHint", "\u4e0d\u652f\u6301\u9009\u62e9\u89c6\u9891");

    /* renamed from: t1, reason: collision with root package name */
    public String f49754t1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureNoPanoramaHint", "\u4e0d\u652f\u6301\u9009\u62e9\u5168\u666f\u56fe");

    /* renamed from: u1, reason: collision with root package name */
    public String f49755u1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureNoGifHint", "\u4e0d\u652f\u6301\u9009\u62e9\u52a8\u56fe");

    /* renamed from: v1, reason: collision with root package name */
    public String f49756v1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SelectPictureVideoLengthHint", "\u4e0d\u652f\u6301\u9009\u62e9\u8d85\u8fc7%ds\u7684\u89c6\u9891");

    /* renamed from: w1, reason: collision with root package name */
    private BasePicureViewController.f f49757w1 = new a();

    /* renamed from: x1, reason: collision with root package name */
    private Callback f49758x1 = new Callback() { // from class: com.qzone.preview.QzonePictureSelectViewer.2
        @Override // cooperation.qzone.remote.Callback
        public void onResult(final Object obj) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureSelectViewer.2.1
                @Override // java.lang.Runnable
                public void run() {
                    QzonePictureSelectViewer.this.i5((QZoneResult) obj);
                }
            });
        }
    };

    /* loaded from: classes39.dex */
    class a implements BasePicureViewController.f {
        a() {
        }

        @Override // com.qzone.preview.business.BasePicureViewController.f
        public void a(int i3) {
            QZLog.i("QzonePictureSelectViewer", 4, "QzonePictureSelectViewer load getMore count = " + QzonePictureSelectViewer.this.f49494w0);
            if (QzonePictureSelectViewer.this.Z0) {
                QzonePictureSelectViewer qzonePictureSelectViewer = QzonePictureSelectViewer.this;
                if (qzonePictureSelectViewer.f49494w0 != 0) {
                    int i16 = qzonePictureSelectViewer.f49495x0 + (i3 - qzonePictureSelectViewer.f49735a1);
                    int i17 = i16 + 1;
                    QzonePictureSelectViewer qzonePictureSelectViewer2 = QzonePictureSelectViewer.this;
                    if (i17 <= qzonePictureSelectViewer2.f49494w0) {
                        if (i16 < qzonePictureSelectViewer2.f49736b1) {
                            PictureManager.getInstance().getSender().getMorePhotoDataList(1, QzonePictureSelectViewer.this.getHandler());
                            QzonePictureSelectViewer.this.f49736b1 -= QzonePictureSelectViewer.this.E0;
                        }
                    } else {
                        PictureManager.getInstance().getSender().getMorePhotoDataList(2, QzonePictureSelectViewer.this.getHandler());
                        QzonePictureSelectViewer qzonePictureSelectViewer3 = QzonePictureSelectViewer.this;
                        qzonePictureSelectViewer3.f49494w0 += qzonePictureSelectViewer3.E0;
                    }
                }
            }
            QzonePictureSelectViewer.this.j5(2);
        }
    }

    private boolean e5(PhotoInfo photoInfo, int i3) {
        VideoInfo videoInfo;
        int size = this.f49746l1.size();
        int i16 = this.f49747m1;
        if (size >= i16) {
            ToastUtil.r(String.format(this.f49750p1, Integer.valueOf(i16)));
            return false;
        }
        if (i3 == 8) {
            if (photoInfo.videoflag == 1) {
                ToastUtil.r(this.f49753s1);
                return false;
            }
        } else if (i3 == 2 || i3 == 7) {
            if (photoInfo.videoflag == 1) {
                ToastUtil.r(this.f49753s1);
                return false;
            }
            int i17 = photoInfo.flag;
            if (i17 == 32 || i17 == 16) {
                ToastUtil.r(this.f49754t1);
                return false;
            }
        } else if (i3 == 3) {
            if (photoInfo.photoType != 2) {
                if (photoInfo.videoflag == 1 && (videoInfo = photoInfo.videodata) != null) {
                    long j3 = videoInfo.videoTime;
                    long j16 = f49734y1;
                    if (j3 > j16) {
                        ToastUtil.r(String.format(this.f49756v1, Long.valueOf(j16 / 1000)));
                        return false;
                    }
                }
            } else {
                ToastUtil.r(this.f49755u1);
                return false;
            }
        }
        return true;
    }

    private void f5() {
        try {
            View inflate = this.f49472a0.inflate(R.layout.f169030bp3, (ViewGroup) null);
            this.f49738d1 = inflate;
            Button button = (Button) inflate.findViewById(R.id.send_btn);
            this.f49742h1 = button;
            button.setOnClickListener(this);
            this.f49745k1 = this.f49738d1.findViewById(R.id.ftk);
            l3(this.f49738d1);
        } catch (Throwable th5) {
            QZLog.e("QzonePictureSelectViewer", 2, "initFooterView exception", th5);
        }
    }

    private void h5() {
        PhotoInfo b16 = this.f49483l0.b();
        if (this.f49746l1 == null) {
            this.f49746l1 = new ArrayList<>();
        }
        if (this.f49746l1.indexOf(b16.lloc) >= 0) {
            this.f49746l1.remove(b16.lloc);
            j5(4);
        } else if (e5(b16, this.f49483l0.M())) {
            this.f49746l1.add(b16.lloc);
            j5(3);
        }
        k5();
        l5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j5(int i3) {
        if (this.f49483l0.M() == 1) {
            LpReportInfo_pf00064.allReport(86, 12, i3, false);
        }
    }

    private void k5() {
        if (this.f49743i1 == null || this.f49744j1 == null || this.f49746l1 == null) {
            return;
        }
        int indexOf = this.f49746l1.indexOf(this.f49483l0.b().lloc);
        if (indexOf >= 0) {
            if (this.f49748n1) {
                this.f49743i1.setCheckedNumber(indexOf + 1);
                return;
            } else {
                this.f49744j1.setChecked(true);
                return;
            }
        }
        if (this.f49748n1) {
            this.f49743i1.setChecked(false);
        } else {
            this.f49744j1.setChecked(false);
        }
    }

    private void l5() {
        if (this.f49742h1 != null) {
            ArrayList<String> arrayList = this.f49746l1;
            if (arrayList != null && arrayList.size() > 0) {
                this.f49742h1.setText(String.format(this.f49751q1, Integer.valueOf(this.f49746l1.size())));
            } else {
                this.f49742h1.setText(this.f49752r1);
            }
        }
    }

    private void m5() {
        TextView textView;
        TextView textView2;
        PhotoInfo b16 = this.f49483l0.b();
        if (this.f49740f1 == null || (textView = this.f49741g1) == null) {
            return;
        }
        textView.setVisibility(8);
        if (TextUtils.isEmpty(b16.albumName)) {
            this.f49740f1.setText("");
            return;
        }
        String str = b16.albumName;
        this.f49740f1.setMaxWidth(ar.e(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM, 200)));
        if (this.f49483l0.getCount() > 1) {
            String str2 = "(" + (this.f49483l0.getSelectedIndex() + 1) + "/" + this.f49483l0.H() + ")";
            if (!TextUtils.isEmpty(str2) && (textView2 = this.f49739e1) != null && textView2.getText() != null && !str2.equals(this.f49739e1.getText().toString())) {
                this.f49740f1.setMaxWidth(ar.e(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM, 144)));
                this.f49740f1.setText(str);
                if (BasePicureViewController.b0()) {
                    this.f49741g1.setVisibility(8);
                } else if (this.Z0) {
                    this.f49741g1.setVisibility(0);
                    this.f49741g1.setText(str2);
                }
                if (this.Z0) {
                    return;
                }
                this.Z0 = true;
                this.f49735a1 = this.f49483l0.getSelectedIndex();
                return;
            }
            this.f49740f1.setText(str);
            return;
        }
        this.f49740f1.setText(str);
    }

    @Override // com.qzone.preview.BasePictureViewer
    protected void C4() {
        if (this.f49737c1 == null) {
            g5();
        }
        if (this.f49738d1 == null) {
            f5();
        }
        m5();
        l5();
        k5();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer
    public void D4(Bundle bundle) {
        super.D4(bundle);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PictureConst.KEY_SELECTED_PHOTO_LLOC);
        this.f49746l1 = stringArrayList;
        if (stringArrayList == null) {
            this.f49746l1 = new ArrayList<>();
        }
        this.f49747m1 = bundle.getInt(PictureConst.KEY_MAX_SELECT_COUNT, 50);
        this.f49748n1 = bundle.getBoolean(PictureConst.KEY_CHECKBOX_WITH_NUMBER, false);
        j5(1);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void S7(boolean z16) {
        super.S7(z16);
        View view = this.f49745k1;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public boolean X() {
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra(PictureConst.KEY_SELECTED_PHOTO_LLOC, this.f49746l1);
        intent.putExtra(PictureConst.KEY_CONFIRM_BTN_CLICK, this.f49749o1);
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public View h8() {
        return this.f49745k1;
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public Callback n7() {
        return this.f49758x1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ftt) {
            finish();
        } else if (id5 == R.id.fq9 || id5 == R.id.fol) {
            h5();
        } else if (id5 == R.id.send_btn) {
            j5(5);
            this.f49749o1 = true;
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null) {
            basePicureViewController.W0(this.f49757w1);
        }
    }

    private void g5() {
        try {
            View inflate = this.f49472a0.inflate(R.layout.f169031bp4, (ViewGroup) null);
            this.f49737c1 = inflate;
            ((RelativeLayout.LayoutParams) ((RelativeLayout) inflate.findViewById(R.id.ftv)).getLayoutParams()).topMargin = SystemUtil.getNotchHeight(getOutActivity(), this);
            ((TextView) this.f49737c1.findViewById(R.id.ftt)).setOnClickListener(this);
            this.f49739e1 = (TextView) this.f49737c1.findViewById(R.id.kxr);
            this.f49740f1 = (TextView) this.f49737c1.findViewById(R.id.kxv);
            this.f49741g1 = (TextView) this.f49737c1.findViewById(R.id.kxw);
            this.f49743i1 = (NumberCheckBox) this.f49737c1.findViewById(R.id.fq9);
            CheckBox checkBox = (CheckBox) this.f49737c1.findViewById(R.id.fol);
            this.f49744j1 = checkBox;
            if (this.f49748n1) {
                this.f49743i1.setVisibility(0);
                this.f49744j1.setVisibility(8);
                this.f49743i1.setOnClickListener(this);
            } else {
                checkBox.setVisibility(0);
                this.f49743i1.setVisibility(8);
                this.f49744j1.setOnClickListener(this);
            }
            n3(this.f49737c1);
        } catch (Throwable th5) {
            QZLog.e("QzonePictureSelectViewer", 2, "initHeaderView exception", th5);
        }
    }

    protected void i5(QZoneResult qZoneResult) {
        if (qZoneResult != null) {
            BasePicureViewController basePicureViewController = this.f49483l0;
            basePicureViewController.C0(qZoneResult, basePicureViewController.getSelectedIndex());
            if (!this.Z0) {
                this.Z0 = true;
                this.f49735a1 = this.f49483l0.getSelectedIndex();
            }
            getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureSelectViewer.3
                @Override // java.lang.Runnable
                public void run() {
                    QzonePictureSelectViewer.this.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z16) {
    }
}

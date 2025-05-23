package com.tencent.aelight.camera.aioeditor.takevideo;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.BubblePopupWindow;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends u implements View.OnClickListener, com.tencent.aelight.camera.aioeditor.takevideo.c {
    protected static final int[] X = {R.id.rs9, R.id.rs_, R.id.rsb, R.id.rsc, R.id.rsd, R.id.rse, R.id.rsf, R.id.rsg, R.id.rsh, R.id.rsi, R.id.rsa};
    protected static int Y = 1035391;
    protected static final LongSparseArray<d> Z = new LongSparseArray<>();
    private ImageView[] C;
    protected ImageView D;
    protected TextView E;
    protected QUIButton F;
    private View G;
    private ImageView H;
    private ImageView I;
    private long J;
    private boolean K;
    protected BubblePopupWindow L;
    boolean M;
    boolean N;
    protected SparseArray<Long> P;
    protected LongSparseArray<ImageView> Q;
    public int R;
    private long S;
    private boolean T;
    private int U;
    private EditVideoPartManager V;
    private boolean W;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f68785d;

    /* renamed from: e, reason: collision with root package name */
    private View f68786e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutTransition f68787f;

    /* renamed from: h, reason: collision with root package name */
    protected ViewGroup f68788h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f68789i;

    /* renamed from: m, reason: collision with root package name */
    protected ViewGroup f68790m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f68791d;

        a(int i3) {
            this.f68791d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditVideoPartManager editVideoPartManager = r.this.mParent;
            if (editVideoPartManager.f67794m != null && editVideoPartManager.C != null) {
                editVideoPartManager.t(this.f68791d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            r.this.C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends TypeToken<List<Map<String, Object>>> {
        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f68795a;

        /* renamed from: b, reason: collision with root package name */
        public final int f68796b;

        /* renamed from: c, reason: collision with root package name */
        public final CharSequence f68797c;

        public d(long j3, int i3, CharSequence charSequence) {
            this.f68795a = j3;
            this.f68796b = i3;
            this.f68797c = charSequence;
        }
    }

    public r(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager);
        this.f68787f = new LayoutTransition();
        this.J = 0L;
        this.M = true;
        this.N = false;
        this.P = new SparseArray<>();
        this.Q = new LongSparseArray<>();
        this.S = 0L;
        this.T = true;
        this.U = 0;
        this.W = false;
        this.R = i3;
        this.V = editVideoPartManager;
    }

    private void B0(View... viewArr) {
        float fontLevel = FontSettingManager.getFontLevel();
        if (fontLevel > 16.0f) {
            for (View view : viewArr) {
                if (view == null || view.getLayoutParams() == null) {
                    return;
                }
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    textView.setTextSize(0, textView.getTextSize() * (16.0f / fontLevel));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        com.tencent.aelight.camera.aioeditor.capture.view.a.d(this.H, 200L, null);
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
        this.mParent.I0();
        int i3 = this.mParent.C.f204055d;
        int i16 = (i3 == 2 || i3 == 5 || i3 == 6) ? 1 : 0;
        id0.a.n("video_edit_aio", "download_clk", 0, i16, new String[0]);
        id0.a.n("video_edit_new", "clk_download", 0, i16, new String[0]);
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportDownloadBtn();
    }

    private void G0(ImageView imageView, boolean z16) {
        if (AppSetting.f99565y && (imageView instanceof PressDarkImageButton) && imageView.getContentDescription() != null) {
            AccessibilityUtil.x(imageView, imageView.getContentDescription().toString(), z16, Button.class.getName());
        }
    }

    private void J0(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            this.mParent.C.e();
            EditVideoParams editVideoParams = this.mParent.C;
            int i3 = editVideoParams.f204055d;
            if (i3 == 2) {
                String qqStr = HardCodeUtil.qqStr(R.string.m3j);
                int k3 = this.mParent.C.k();
                if (k3 == 122 || k3 == 125 || k3 == 133 || EditVideoParams.u(k3) || this.mParent.C.t()) {
                    qqStr = getString(R.string.f170244k4);
                }
                boolean z16 = false;
                if (this.mUi.getActivity() != null && this.mUi.getActivity().getIntent() != null && this.mUi.getActivity().getIntent().getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false)) {
                    z16 = true;
                }
                if (z16) {
                    qqStr = getString(R.string.f171151ok);
                }
                if (k3 == 126) {
                    qqStr = HardCodeUtil.qqStr(R.string.f170244k4);
                    textView.setCompoundDrawables(null, null, null, null);
                }
                textView.setText(qqStr);
                textView.setContentDescription(qqStr);
                return;
            }
            if (i3 == 8) {
                textView.setText(HardCodeUtil.qqStr(R.string.ket));
                textView.setContentDescription(HardCodeUtil.qqStr(R.string.ket));
                return;
            }
            if (i3 != 3) {
                if (i3 == 5 || i3 == 6) {
                    textView.setText(HardCodeUtil.qqStr(R.string.m36));
                    textView.setContentDescription(HardCodeUtil.qqStr(R.string.m3k));
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = BaseAIOUtils.f(70.0f, textView.getContext().getResources());
                    textView.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            String m3 = editVideoParams.m("extra_publish_text");
            if (!TextUtils.isEmpty(m3)) {
                textView.setText(m3);
                textView.setContentDescription(m3);
            } else {
                String qqStr2 = HardCodeUtil.qqStr(R.string.f170244k4);
                textView.setText(qqStr2);
                textView.setContentDescription(qqStr2);
                textView.setCompoundDrawables(null, null, null, null);
            }
        }
    }

    private void L0(boolean z16) {
        ViewGroup viewGroup = this.f68788h;
        if (viewGroup == null) {
            ms.a.c("Q.qqstory.record.EditVideoButton", "mButtonLayout is null.");
            return;
        }
        View findViewById = viewGroup.findViewById(R.id.f163733rq0);
        View findViewById2 = this.f68788h.findViewById(R.id.s28);
        if (findViewById != null) {
            findViewById.setVisibility(z16 ? 0 : 8);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(z16 ? 0 : 8);
        }
    }

    private void m0(int i3) {
        EditVideoParams editVideoParams = this.mParent.C;
        if (editVideoParams != null) {
            int i16 = 3;
            if (editVideoParams.f204055d == 3) {
                if (i3 != 1) {
                    i16 = 4;
                    if (i3 == 4) {
                        i16 = 2;
                    } else if (i3 != 8) {
                        i16 = i3 != 1024 ? -1 : 1;
                    }
                }
                LpReportInfo_pf00064.report(615, i16);
            }
        }
    }

    private void n0(int i3) {
        if (SlideShowPhotoListManager.n().m() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, i3);
        }
    }

    private void o0(View view, d dVar) {
        if ((dVar.f68795a & Y) == 524288) {
            w53.b.a("Q.qqstory.record.EditVideoButton", "dtReport exposure ai eliminate");
            VideoReport.setElementId(view, "em_bas_ai_erase ");
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementParams(view, kr.a.a());
        }
    }

    private boolean w0() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("aio_edit_video_unable_music");
    }

    private void z0() {
        A0();
        TransitionCategoryItem v3 = com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().v();
        if (v3 != null) {
            id0.a.n("video_edit_transition", "pub_effects", z.k0(this.mParent.C.l("extra_transiton_src_from", -1)), 0, v3.Q, v3.T, v3.R, v3.S);
        }
        if (this.mParent.C.k() == 122) {
            ReportController.o(null, "dc00898", "", "", "0X8009DEF", "0X8009DEF", 0, 0, "", "", "", "");
        }
        if (this.mParent.C.t()) {
            ReportController.o(null, "dc00898", "", "", "0X800A06E", "0X800A06E", 0, 0, "", "", "", "");
        }
    }

    public void K0(int i3) {
        this.H.setVisibility(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void attachEditVideoUi(aa aaVar) {
        super.attachEditVideoUi(aaVar);
        QLog.i("Q.qqstory.record.EditVideoButton", 1, "attachEditVideoUi completed, mUi is:" + this.mUi);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void detachEditVideoUi() {
        QLog.i("Q.qqstory.record.EditVideoButton", 1, "detachEditVideoUi ready to make mUi:" + this.mUi + " to null");
        super.detachEditVideoUi();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        super.editVideoPrePublish(i3, bVar);
        bVar.f400401r = r0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, int i16, Object obj) {
        BubblePopupWindow bubblePopupWindow = this.L;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            this.L.dismiss();
        }
        switch (i16) {
            case 0:
                I0(null);
                this.f68790m.setBackgroundColor(this.U);
                this.f68786e.setVisibility(0);
                if (i3 == 6) {
                    E0(true, true, false);
                } else if (i3 == 11) {
                    E0(true, true, false);
                } else {
                    D0(true, false);
                }
                if (this.T) {
                    this.mParent.s(Message.obtain(null, 12, 3, (int) this.mAnimationEndTime));
                    this.T = false;
                }
                if (this.W && this.mParent.l0()) {
                    ImageView imageView = this.D;
                    if (imageView != null && imageView.getVisibility() != 0) {
                        this.D.setVisibility(0);
                    }
                    ImageView imageView2 = this.H;
                    if (imageView2 == null || imageView2.getVisibility() == 0 || (this.R & 512) == 0) {
                        return;
                    }
                    this.H.setVisibility(0);
                    return;
                }
                return;
            case 1:
                I0(this.Q.get(2L));
                F0(false, false, true);
                return;
            case 2:
                if (i3 != i16 && this.N) {
                    I0(this.Q.get(1L));
                }
                int intValue = (obj == null || !(obj instanceof Integer)) ? -1 : ((Integer) obj).intValue();
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqstory.record.EditVideoButton", 2, "editVideoStateChanged text old:" + i3 + " new:" + i16 + " softInputMode:" + intValue);
                }
                if (intValue == 0) {
                    this.f68790m.setVisibility(8);
                    this.f68786e.setVisibility(8);
                } else {
                    D0(true, false);
                }
                F0(false, false, true);
                if (this.W && this.mParent.l0()) {
                    ImageView imageView3 = this.D;
                    if (imageView3 != null && imageView3.getVisibility() == 0) {
                        this.D.setVisibility(4);
                    }
                    ImageView imageView4 = this.H;
                    if (imageView4 == null || imageView4.getVisibility() != 0) {
                        return;
                    }
                    K0(4);
                    return;
                }
                return;
            case 3:
                I0(this.Q.get(8L));
                F0(false, false, true);
                return;
            case 4:
                I0(this.Q.get(1024L));
                if (!this.mParent.l0()) {
                    this.f68790m.setBackgroundColor(getResources().getColor(R.color.f156812c1));
                }
                this.f68786e.setVisibility(8);
                if (i3 == 5) {
                    if (obj instanceof Boolean) {
                        E0(true, true, ((Boolean) obj).booleanValue());
                        return;
                    } else {
                        D0(true, true);
                        return;
                    }
                }
                D0(true, false);
                return;
            case 5:
                if (i3 == 5 || i3 == 26) {
                    return;
                }
                D0(false, true);
                return;
            case 6:
                if (i3 == 5 || i3 == 26) {
                    return;
                }
                D0(false, true);
                return;
            case 7:
                I0(this.Q.get(4L));
                D0(false, false);
                return;
            case 8:
                D0(false, false);
                return;
            case 9:
                I0(null);
                D0(true, false);
                return;
            case 10:
                I0(this.Q.get(2048L));
                return;
            case 11:
                E0(false, true, false);
                id0.b.h("0X80080E5", id0.b.f407534c);
                return;
            case 12:
            case 18:
            case 19:
            case 20:
            case 22:
            case 24:
            default:
                return;
            case 13:
                I0(this.Q.get(64L));
                F0(false, false, true);
                return;
            case 14:
                I0(this.Q.get(32L));
                F0(false, false, true);
                return;
            case 15:
                this.f68790m.setVisibility(8);
                this.f68786e.setVisibility(8);
                return;
            case 16:
                if (i3 == 15) {
                    this.f68790m.setVisibility(0);
                    this.f68786e.setVisibility(0);
                    return;
                }
                return;
            case 17:
                I0(this.Q.get(16L));
                F0(false, false, true);
                return;
            case 21:
                I0(this.Q.get(65536L));
                F0(false, false, true);
                return;
            case 23:
                if (obj instanceof Boolean) {
                    ms.a.f("Q.qqstory.record.EditVideoButton", "in show hide top bar.");
                    L0(((Boolean) obj).booleanValue());
                    return;
                } else {
                    ms.a.c("Q.qqstory.record.EditVideoButton", "extra is null.");
                    return;
                }
            case 25:
                I0(this.Q.get(131072L));
                if (!this.mParent.l0()) {
                    this.f68790m.setBackgroundColor(getResources().getColor(R.color.f156812c1));
                }
                this.f68786e.setVisibility(8);
                if (i3 == 5) {
                    if (obj instanceof Boolean) {
                        D0(true, ((Boolean) obj).booleanValue());
                        return;
                    } else {
                        D0(true, true);
                        return;
                    }
                }
                D0(true, false);
                return;
            case 26:
                D0(false, false);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (message.what == 2) {
            ImageView imageView = this.Q.get(message.arg1);
            if (imageView != null) {
                hd0.c.l("Q.qqstory.record.EditVideoButton", "perform button click %s", imageView);
                imageView.performClick();
            } else {
                hd0.c.v("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", Integer.valueOf(message.arg1));
            }
        }
        return super.handleEditVideoMessage(message);
    }

    protected int l0() {
        int i3 = Y;
        int i16 = this.mParent.C.f204055d;
        if ((i16 == 2 || i16 == 6) && EditPicMeiHua.l0(this.R) && this.mParent.l0()) {
            i3 = i3 & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS & (-65537);
        }
        if (!EditVideoPartManager.v(this.R, 524288)) {
            return i3;
        }
        int l3 = this.mParent.C.l("uintype", -1);
        QLog.d("Q.qqstory.record.EditVideoButton", 1, "startEditPic curType: " + l3);
        return (l3 == 0 || l3 == 1 || l3 == 1000) ? i3 : i3 & (-524289);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        return System.currentTimeMillis() < this.mAnimationEndTime;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0353  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        int i3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (Math.abs(SystemClock.uptimeMillis() - this.J) > 500) {
            this.J = SystemClock.uptimeMillis();
            int id5 = view.getId();
            int i16 = 1;
            if (this.mAnimationEndTime > System.currentTimeMillis()) {
                hd0.c.v("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", Long.valueOf(this.mAnimationEndTime), Long.valueOf(System.currentTimeMillis()));
            } else {
                int[] iArr = X;
                int length = iArr.length;
                int i17 = 0;
                while (true) {
                    if (i17 < length) {
                        if (iArr[i17] == id5) {
                            long longValue = this.P.get(id5).longValue();
                            hd0.c.v("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", Long.valueOf(longValue), view);
                            int s16 = this.mParent.s(Message.obtain(null, 1, new Object[]{Long.valueOf(longValue), view}));
                            if (s16 > 0) {
                                hd0.c.k("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + s16);
                            } else {
                                this.mParent.I();
                                int i18 = (int) ((-1) & longValue);
                                if (i18 == 1) {
                                    if (this.mParent.y(2)) {
                                        this.mParent.t(0);
                                    } else {
                                        this.mParent.O0();
                                    }
                                    com.tencent.aelight.camera.ae.report.b.b().x0();
                                    id0.b.h("0X80075C6", id0.b.f407534c);
                                    id0.a.l("clk_text", getOpIn(), 0, new String[0]);
                                    m0(1);
                                    n0(9);
                                    if (this.mParent.l0()) {
                                        com.tencent.mobileqq.shortvideo.c.d("0X800B3C9", this.mParent.C.k());
                                    }
                                } else {
                                    if (i18 != 2) {
                                        int i19 = 3;
                                        int i26 = 4;
                                        switch (i18) {
                                            case 4:
                                                this.mParent.v0();
                                                com.tencent.aelight.camera.ae.report.b.b().k0();
                                                id0.b.h("0X80075C5", id0.b.f407534c);
                                                m0(4);
                                                id0.a.n("video_edit_new", "clk_cut", getOpIn(), 0, new String[0]);
                                                com.tencent.mobileqq.shortvideo.c.d("0X800B3C7", this.mParent.C.k());
                                                break;
                                            case 8:
                                                if (this.mParent.y(3)) {
                                                    this.mParent.t(0);
                                                    i19 = -1;
                                                }
                                                com.tencent.aelight.camera.ae.report.b.b().w0();
                                                id0.b.h("0X80075C7", id0.b.f407534c);
                                                m0(8);
                                                id0.a.n("video_edit_new", "clk_sticker", getOpIn(), 0, new String[0]);
                                                n0(12);
                                                i3 = i19;
                                                break;
                                            case 16:
                                                q qVar = (q) getEditExport(q.class);
                                                if (qVar != null) {
                                                    if (qVar.y() == 0) {
                                                        i3 = 17;
                                                        if (this.mParent.y(17)) {
                                                            this.mParent.t(0);
                                                            i3 = -1;
                                                        }
                                                        id0.a.n("video_edit_transition", "clk_transition", z.k0(this.mParent.C.l("extra_transiton_src_from", -1)), 0, new String[0]);
                                                        n0(11);
                                                        break;
                                                    } else {
                                                        qVar.l();
                                                        id0.a.n("video_edit_transition", "exp_toastFail", z.k0(this.mParent.C.l("extra_transiton_src_from", -1)), 0, new String[0]);
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 32:
                                                if (this.mParent.y(14)) {
                                                    this.mParent.t(0);
                                                    i3 = -1;
                                                } else {
                                                    i3 = 14;
                                                }
                                                id0.a.l("clk_effect", getOpIn(), 0, new String[0]);
                                                n0(10);
                                                break;
                                            case 64:
                                                if (this.mParent.y(13)) {
                                                    this.mParent.t(0);
                                                } else {
                                                    this.mParent.t(13);
                                                }
                                                com.tencent.aelight.camera.ae.report.b.b().o0();
                                                int opIn = getOpIn();
                                                String[] strArr = new String[4];
                                                strArr[0] = "";
                                                if (this.mParent.l0()) {
                                                    str = "1";
                                                } else {
                                                    str = "2";
                                                }
                                                strArr[1] = str;
                                                strArr[2] = "";
                                                strArr[3] = "";
                                                id0.a.n("video_edit_new", "clk_filter", opIn, 0, strArr);
                                                break;
                                            case 1024:
                                                if (this.mParent.y(4)) {
                                                    this.mParent.t(0);
                                                    i26 = -1;
                                                }
                                                com.tencent.aelight.camera.ae.report.b.b().q0();
                                                id0.b.h("0X80075C4", id0.b.f407534c);
                                                id0.a.l("clk_graffiti", getOpIn(), 0, new String[0]);
                                                m0(1024);
                                                if (this.mParent.l0()) {
                                                    com.tencent.mobileqq.shortvideo.c.d("0X800B3C5", this.mParent.C.k());
                                                }
                                                i3 = i26;
                                                break;
                                            case 2048:
                                                EditVideoPartManager editVideoPartManager = this.mParent;
                                                if (editVideoPartManager.f67780d == 10) {
                                                    editVideoPartManager.t(0);
                                                } else {
                                                    editVideoPartManager.t(10);
                                                }
                                                int i27 = this.mParent.C.f204055d;
                                                if (i27 != 2 && i27 != 5 && i27 != 6) {
                                                    i16 = 0;
                                                }
                                                id0.a.n("video_edit_aio", "ttpt_clk", 0, i16, new String[0]);
                                                id0.a.n("video_edit_new", "clk_pitu", 0, i16, new String[0]);
                                                break;
                                            case 16384:
                                                if (SlideShowPhotoListManager.n().m() == 22) {
                                                    LpReportInfo_pf00064.allReport(680, 2, 2);
                                                }
                                                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(SlideShowPhotoListManager.n().o());
                                                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                                                Bundle bundle = new Bundle();
                                                bundle.putParcelableArrayList("qzone_slide_show_matters", arrayList);
                                                QZoneHelper.forwardToQzDynamicEditVideoActivity(this.mUi.getActivity(), userInfo, bundle, 666);
                                                break;
                                            case 65536:
                                                i3 = 21;
                                                if (this.mParent.y(21)) {
                                                    this.mParent.t(0);
                                                    break;
                                                }
                                                break;
                                            case 131072:
                                                i3 = 25;
                                                if (this.mParent.y(25)) {
                                                    this.mParent.t(0);
                                                    i3 = -1;
                                                }
                                                com.tencent.aelight.camera.ae.report.b.b().s0();
                                                break;
                                            case 262144:
                                                this.mParent.B0();
                                                break;
                                            case 524288:
                                                this.mParent.q0();
                                                break;
                                        }
                                    } else {
                                        if (this.mParent.y(1)) {
                                            this.mParent.t(0);
                                            i3 = -1;
                                        } else {
                                            i3 = 1;
                                        }
                                        com.tencent.aelight.camera.ae.report.b.b().v0();
                                        n0(1);
                                        id0.a.l("clk_music", getOpIn(), 0, new String[0]);
                                    }
                                    a aVar = i3 != -1 ? new a(i3) : null;
                                    if ((Y & longValue) == longValue) {
                                        M0(view, aVar);
                                    }
                                    y0(view, i18);
                                }
                                i3 = -1;
                                if (i3 != -1) {
                                }
                                if ((Y & longValue) == longValue) {
                                }
                                y0(view, i18);
                            }
                        } else {
                            i17++;
                        }
                    } else {
                        x0(view);
                        break;
                    }
                }
            }
        } else {
            hd0.c.t("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        ViewGroup viewGroup = (ViewGroup) findViewSure(R.id.rpy);
        this.f68788h = viewGroup;
        viewGroup.setVisibility(0);
        TextView textView = (TextView) findViewSure(R.id.rrc);
        this.E = textView;
        textView.setOnClickListener(this);
        this.E.setVisibility(8);
        ImageView imageView = (ImageView) findViewSure(R.id.rrd);
        this.D = imageView;
        imageView.setOnClickListener(this);
        vq.a aVar = vq.a.f443174a;
        aVar.b(this.D, "em_ae_cancel_btn");
        QUIButton qUIButton = (QUIButton) findViewSure(R.id.rrb);
        this.F = qUIButton;
        qUIButton.setPadding(0, 0, 0, 0);
        this.F.setOnClickListener(this);
        aVar.b(this.F, "em_ae_send_btn");
        View findViewSure = findViewSure(R.id.rsj);
        this.G = findViewSure;
        findViewSure.setVisibility(8);
        this.G.setOnClickListener(this);
        J0(this.F);
        this.f68786e = findViewSure(R.id.rus);
        this.C = v0(this.R, this);
        this.f68789i = (ViewGroup) findViewSure(R.id.f163733rq0);
        this.f68790m = (ViewGroup) findViewSure(R.id.rpz);
        this.f68785d = this.Q.get(8L);
        if (LiuHaiUtils.needShowLiuHaiTopBar()) {
            ViewGroup.LayoutParams layoutParams = this.f68789i.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += LiuHaiUtils.LiuHaiTopBarHeight();
                this.f68789i.setLayoutParams(layoutParams);
            }
        }
        ImageView imageView2 = (ImageView) findViewSure(R.id.s2v);
        this.H = imageView2;
        if ((this.R & 512) != 0) {
            if (this.mParent instanceof QzEditVideoPartManager) {
                imageView2.setImageResource(R.drawable.iz_);
            }
            this.H.setVisibility(0);
            this.H.setOnClickListener(this);
        } else {
            imageView2.setVisibility(8);
        }
        aVar.b(this.H, "em_ae_save_btn");
        ImageView imageView3 = (ImageView) findViewSure(R.id.s2t);
        this.I = imageView3;
        imageView3.setVisibility(8);
        B0(this.E, this.F);
        B0(this.C);
        this.f68787f.setAnimator(3, ObjectAnimator.ofFloat((Object) null, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        this.f68787f.setDuration(3, 500L);
        this.f68787f.setAnimator(2, ObjectAnimator.ofFloat((Object) null, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        this.f68787f.setDuration(2, 500L);
        publishEditExport(com.tencent.aelight.camera.aioeditor.takevideo.c.class, this);
        this.M = QMMKV.from(BaseApplicationImpl.getApplication(), "common_mmkv_configurations").decodeBool("showFlashPic" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true);
        Bundle bundle = this.mParent.C.f204058h;
        if (bundle != null) {
            this.W = bundle.getBoolean(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, false);
        }
        if (this.mParent.l0()) {
            ViewGroup.LayoutParams layoutParams2 = this.f68790m.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = UIUtils.b(getContext(), 28.0f);
                this.f68790m.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        QLog.i("Q.qqstory.record.EditVideoButton", 1, "onDestroy completed, mIsDestroy is:" + this.mIsDestroy + ", mUi is:" + this.mUi);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        EditVideoPartManager editVideoPartManager = this.mParent;
        if (editVideoPartManager.f67780d != 0 || this.K) {
            return;
        }
        EditVideoParams.EditSource editSource = editVideoPartManager.C.f204059i;
        if ((editSource instanceof EditTakePhotoSource) || (editSource instanceof EditTakeVideoSource)) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f68789i, "translationY", BaseAIOUtils.f(-48.0f, getResources()), 0.0f);
            ofFloat.setDuration(800L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f68790m, "translationY", BaseAIOUtils.f(getResources().getDimension(R.dimen.f159424ac2), getResources()), 0.0f);
            ofFloat2.setDuration(800L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
        }
        this.K = true;
    }

    public int p0() {
        return 500;
    }

    protected int q0() {
        return getResources().getColor(R.color.f157748yb);
    }

    public HashMap<String, String> r0() {
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.V.Z()) {
            String partPlayGameName = uVar.getPartPlayGameName();
            if (partPlayGameName != null && !partPlayGameName.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("function", uVar.getPartPlayGameName());
                hashMap2.put("function_value", uVar.getPartPlayGameValue());
                arrayList.add(hashMap2);
            }
        }
        hashMap.put("gameplay", new Gson().toJson(arrayList, new c().getType()));
        QLog.i("Q.qqstory.record.EditVideoButton", 4, "GAME_PLAY:" + hashMap);
        return hashMap;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.c
    public void s() {
        ImageView imageView = this.Q.get(16L);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f160004iz3);
        }
    }

    public View t0() {
        LongSparseArray<ImageView> longSparseArray = this.Q;
        if (longSparseArray != null) {
            return longSparseArray.get(16L);
        }
        return null;
    }

    protected void u0() {
        LongSparseArray<d> longSparseArray = Z;
        longSparseArray.put(2L, new d(2L, R.drawable.iyw, HardCodeUtil.qqStr(R.string.f171935m11)));
        longSparseArray.put(1024L, new d(1024L, R.drawable.iyu, HardCodeUtil.qqStr(R.string.lzl)));
        longSparseArray.put(131072L, new d(131072L, R.drawable.iyy, getContext().getResources().getString(R.string.y4_)));
        longSparseArray.put(1L, new d(1L, R.drawable.iyz, HardCodeUtil.qqStr(R.string.f171938m23)));
        longSparseArray.put(8L, new d(8L, R.drawable.f160002iz1, HardCodeUtil.qqStr(R.string.f171936m12)));
        longSparseArray.put(4L, new d(4L, R.drawable.iyq, HardCodeUtil.qqStr(R.string.m28)));
        longSparseArray.put(64L, new d(64L, R.drawable.iyr, HardCodeUtil.qqStr(R.string.m1y)));
        longSparseArray.put(32L, new d(32L, R.drawable.iyp, HardCodeUtil.qqStr(R.string.m3a)));
        longSparseArray.put(16L, new d(16L, R.drawable.iz4, HardCodeUtil.qqStr(R.string.m3g)));
        longSparseArray.put(2048L, new d(2048L, R.drawable.iyx, "\u8df3\u8f6c\u5230P\u56fe"));
        longSparseArray.put(16384L, new d(16384L, R.drawable.iyo, HardCodeUtil.qqStr(R.string.lzp)));
        longSparseArray.put(65536L, new d(65536L, R.drawable.iyv, BaseApplication.getContext().getString(R.string.y1w)));
    }

    protected ImageView[] v0(int i3, View.OnClickListener onClickListener) {
        if (this.mParent.C.e() == 11 || this.mParent.C.e() == 12) {
            this.N = true;
        }
        int l06 = i3 & l0();
        int i16 = 0;
        for (int i17 = 0; i17 < 20; i17++) {
            int i18 = 1 << i17;
            if ((l06 & i18 & Y) == i18) {
                i16++;
            }
        }
        int length = X.length;
        if (length >= i16) {
            ImageView[] imageViewArr = new ImageView[length];
            for (int i19 = 0; i19 < length; i19++) {
                int[] iArr = X;
                View findViewSure = findViewSure(iArr[i19]);
                if (findViewSure instanceof ImageView) {
                    imageViewArr[i19] = (ImageView) findViewSure;
                } else {
                    throw new IllegalArgumentException("can not find ImageView by id : " + iArr[i19] + ", view : " + findViewSure);
                }
            }
            this.P.clear();
            this.Q.clear();
            k0(l06);
            int i26 = 0;
            for (int i27 = 0; i27 < 20; i27++) {
                long j3 = 1 << i27;
                if ((l06 & j3) == j3 && (Y & j3) == j3) {
                    int i28 = i26 + 1;
                    ImageView imageView = imageViewArr[i26];
                    d dVar = Z.get(j3);
                    if (dVar != null) {
                        if (dVar.f68795a == 524288) {
                            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), dVar.f68796b));
                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                            FrameLayout frameLayout = new FrameLayout(imageView.getContext());
                            frameLayout.setLayoutParams(layoutParams);
                            ViewParent parent = imageView.getParent();
                            if (parent instanceof LinearLayout) {
                                LinearLayout linearLayout = (LinearLayout) parent;
                                int indexOfChild = linearLayout.indexOfChild(imageView);
                                linearLayout.removeView(imageView);
                                frameLayout.addView(imageView, -1, -1);
                                linearLayout.addView(frameLayout, indexOfChild);
                            }
                            if (!com.tencent.aelight.camera.aioeditor.takevideo.eliminate.a.b()) {
                                QUIBadge qUIBadge = new QUIBadge(imageView.getContext());
                                qUIBadge.setRedText("\u65b0");
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                                layoutParams2.gravity = 53;
                                layoutParams2.topMargin = ViewUtils.dip2px(4.0f);
                                frameLayout.addView(qUIBadge, layoutParams2);
                            }
                        } else {
                            imageView.setImageResource(dVar.f68796b);
                        }
                        imageView.setContentDescription(dVar.f68797c);
                        if ((imageView instanceof PressDarkImageButton) && !TextUtils.isEmpty(dVar.f68797c)) {
                            ((PressDarkImageButton) imageView).setDefContentDescription(dVar.f68797c.toString());
                        }
                        imageView.setOnClickListener(onClickListener);
                        this.P.put(imageView.getId(), Long.valueOf(dVar.f68795a));
                        this.Q.put(dVar.f68795a, imageView);
                        o0(imageView, dVar);
                    }
                    i26 = i28;
                }
            }
            while (i26 < X.length) {
                imageViewArr[i26].setOnClickListener(null);
                imageViewArr[i26].setVisibility(8);
                i26++;
            }
            return imageViewArr;
        }
        throw new IllegalArgumentException("too many parts, there is no enough view to show");
    }

    public void D0(boolean z16, boolean z17) {
        E0(z16, z17, true);
    }

    public void H0(boolean z16) {
        hd0.c.v("Q.qqstory.record.EditVideoButton", "setEnableButtonEnable: %d", Integer.valueOf(z16 ? 1 : 0));
        this.F.setEnabled(z16);
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            this.Q.get(this.Q.keyAt(i3)).setEnabled(z16);
        }
    }

    private String s0(FaceLayer faceLayer) {
        if (faceLayer == null) {
            return null;
        }
        Map<String, List<String>> Y2 = faceLayer.Y();
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : Y2.entrySet()) {
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                String key = entry.getKey();
                for (String str : value) {
                    sb5.append(key);
                    sb5.append(util.base64_pad_url);
                    sb5.append(str);
                    sb5.append(',');
                }
            }
        }
        return sb5.toString();
    }

    protected void I0(ImageView imageView) {
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            ImageView valueAt = this.Q.valueAt(i3);
            if (valueAt != null) {
                valueAt.getDrawable().clearColorFilter();
                valueAt.clearColorFilter();
                G0(valueAt, false);
            }
        }
        if (imageView != null) {
            imageView.setColorFilter(q0(), PorterDuff.Mode.SRC_IN);
            G0(imageView, true);
        }
    }

    protected void M0(View view, View.OnClickListener onClickListener) {
        com.tencent.aelight.camera.aioeditor.capture.view.a.d(view, 200L, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(View view) {
        long a06;
        aa aaVar;
        int id5 = view.getId();
        if (id5 == R.id.s2t) {
            this.mParent.x0();
        } else if (id5 != R.id.s2v) {
            switch (id5) {
                case R.id.rrb /* 2097545410 */:
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (uptimeMillis - this.S < 800 || this.mUi.getActivity().isFinishing()) {
                        return;
                    }
                    this.S = uptimeMillis;
                    if (SlideShowPhotoListManager.n().m() == 22) {
                        LpReportInfo_pf00064.allReport(680, 2, 7);
                        LpReportInfo_pf00064.allReport(680, 11, 1);
                    }
                    ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
                    if (this.mParent.j1() && !NetworkUtil.isNetworkAvailable()) {
                        QQToast.makeText(getContext(), getContext().getString(R.string.f173056gt1), 0).show();
                        return;
                    }
                    this.mParent.Q0();
                    ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportPostBtn();
                    ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
                    ms.a.f("Q.qqstory.record.EditVideoButton", "\u3010Click\u3011+ control_publish");
                    z0();
                    break;
                    break;
                case R.id.rrc /* 2097545411 */:
                case R.id.rrd /* 2097545412 */:
                    id0.a.l("clk_reshoot", getOpIn(), 0, new String[0]);
                    EditVideoPartManager editVideoPartManager = this.mParent;
                    if (editVideoPartManager instanceof QzEditVideoPartManager) {
                        ((QzEditVideoPartManager) editVideoPartManager).V0 = true;
                    }
                    if (editVideoPartManager.C.t()) {
                        ReportController.o(null, "dc00898", "", "", "0X800A06F", "0X800A06F", 0, 0, "", "", "", "");
                    }
                    this.mParent.n1();
                    if (this.mParent.C.f204056e == 2 && SlideShowPhotoListManager.n().l() == 13 && (aaVar = this.mUi) != null && aaVar.getActivity() != null) {
                        id0.a.j("video_edit_new", "back_smartalbum", this.mUi.getActivity().getIntent(), new String[0]);
                        break;
                    }
                    break;
            }
        } else {
            EditVideoPartManager editVideoPartManager2 = this.V;
            if (editVideoPartManager2 != null && !editVideoPartManager2.i0()) {
                this.V.c1(new b());
            } else {
                EditVideoPartManager editVideoPartManager3 = this.V;
                if (editVideoPartManager3 != null && editVideoPartManager3.i0()) {
                    C0();
                }
            }
        }
        try {
            HashMap hashMap = new HashMap();
            EditVideoPartManager editVideoPartManager4 = this.mParent;
            EditVideoParams.EditSource editSource = editVideoPartManager4.C.f204059i;
            if (!(editSource instanceof EditLocalVideoSource) && !(editSource instanceof EditTakeVideoSource)) {
                a06 = 0;
                hashMap.put("ae_duration", Long.valueOf(a06));
                vq.a.f443174a.a(view, hashMap);
            }
            a06 = editVideoPartManager4.a0(0);
            hashMap.put("ae_duration", Long.valueOf(a06));
            vq.a.f443174a.a(view, hashMap);
        } catch (Exception e16) {
            ms.a.d("Q.qqstory.record.EditVideoButton", "report datong error", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d0 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dc A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0102 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0137 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0147 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0004, B:8:0x0022, B:10:0x0057, B:11:0x005d, B:13:0x006a, B:16:0x007b, B:18:0x0085, B:19:0x00ca, B:21:0x00d0, B:22:0x00d6, B:24:0x00dc, B:25:0x00e2, B:27:0x00ea, B:29:0x00f0, B:30:0x00fc, B:32:0x0102, B:35:0x010b, B:37:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x0125, B:44:0x0137, B:45:0x0141, B:47:0x0147, B:48:0x014d, B:54:0x008a, B:58:0x0092, B:60:0x0096, B:62:0x00a5, B:65:0x00a9, B:67:0x00ae, B:69:0x00b2, B:71:0x00c1, B:75:0x0072), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0() {
        boolean z16;
        String str;
        com.tencent.aelight.camera.aioeditor.d dVar;
        int i3;
        String str2;
        String str3;
        String valueOf;
        String valueOf2;
        try {
            JSONObject jSONObject = new JSONObject();
            int K = this.mParent.K();
            int k3 = this.mParent.C.k();
            if (K != 9 && K != 2) {
                z16 = false;
                str = s0(this.mParent.I.V().l0()) + s0(this.mParent.I.V().d0());
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("sticker", str);
                }
                dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
                if (dVar == null) {
                    if (dVar.i() == 4) {
                        i3 = 2;
                    } else {
                        i3 = dVar.i() == 8 ? 1 : 0;
                    }
                    String[] g16 = dVar.g();
                    String[] h16 = dVar.h();
                    if (z16) {
                        str3 = g16[1];
                        str2 = h16[1];
                    } else {
                        String str4 = null;
                        for (String str5 : g16) {
                            if (str5 != null) {
                                str4 = str5 + ",";
                            }
                        }
                        String str6 = null;
                        for (String str7 : h16) {
                            if (str7 != null) {
                                str6 = str7 + ",";
                            }
                        }
                        str2 = str6;
                        str3 = str4;
                    }
                } else {
                    i3 = 0;
                    str2 = null;
                    str3 = null;
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put(QQWinkConstants.TAB_EFFECT, str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("filter", str2);
                }
                com.tencent.aelight.camera.aioeditor.capture.music.g gVar = (com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.c(8);
                valueOf = (gVar != null || gVar.m() == null) ? null : String.valueOf(gVar.m().mItemId);
                if (!TextUtils.isEmpty(valueOf)) {
                    jSONObject.put("music", valueOf);
                }
                if (z16) {
                    QIMPtvTemplateManager qIMPtvTemplateManager = (QIMPtvTemplateManager) fr.f.c(3);
                    String m3 = qIMPtvTemplateManager != null ? qIMPtvTemplateManager.m() : null;
                    if (!TextUtils.isEmpty(m3)) {
                        jSONObject.put(PreDetect.FACE_DETECT, m3);
                    }
                }
                DynamicTextItem W = this.mParent.I.V().C0().W();
                valueOf2 = W == null ? String.valueOf(W.v()) : null;
                if (!TextUtils.isEmpty(valueOf2)) {
                    jSONObject.put("text", valueOf2);
                }
                id0.a.n("video_edit_new", "send_clk", getOpIn(), 0, id0.a.b(K), jSONObject.toString(), String.valueOf(i3), String.valueOf(k3));
            }
            z16 = true;
            str = s0(this.mParent.I.V().l0()) + s0(this.mParent.I.V().d0());
            if (!TextUtils.isEmpty(str)) {
            }
            dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
            if (dVar == null) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            com.tencent.aelight.camera.aioeditor.capture.music.g gVar2 = (com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.c(8);
            if (gVar2 != null) {
            }
            if (!TextUtils.isEmpty(valueOf)) {
            }
            if (z16) {
            }
            DynamicTextItem W2 = this.mParent.I.V().C0().W();
            if (W2 == null) {
            }
            if (!TextUtils.isEmpty(valueOf2)) {
            }
            id0.a.n("video_edit_new", "send_clk", getOpIn(), 0, id0.a.b(K), jSONObject.toString(), String.valueOf(i3), String.valueOf(k3));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.record.EditVideoButton", 2, e16, new Object[0]);
            }
        }
    }

    public void E0(boolean z16, boolean z17, boolean z18) {
        if (z17) {
            long currentTimeMillis = System.currentTimeMillis() + p0();
            this.mAnimationEndTime = currentTimeMillis;
            if (z18) {
                this.mAnimationEndTime = currentTimeMillis + 500;
            }
            if (z16) {
                ad.b(this.f68788h, z18, p0());
            } else {
                ad.a(this.f68788h, p0());
            }
        } else {
            this.f68788h.setAnimation(null);
            this.f68788h.setVisibility(z16 ? 0 : 8);
            this.mAnimationEndTime = 0L;
        }
        this.mParent.s(Message.obtain(null, 11, Long.valueOf(this.mAnimationEndTime)));
        if (z16) {
            for (int i3 = 0; i3 < this.Q.size(); i3++) {
                this.Q.valueAt(i3).setVisibility(0);
            }
        }
        if (z16) {
            if (this.f68789i.getVisibility() != 0) {
                this.f68789i.setVisibility(0);
            }
            if (this.f68790m.getVisibility() != 0) {
                this.f68790m.setVisibility(0);
            }
        }
    }

    public void F0(boolean z16, boolean z17, boolean z18) {
        if (z17) {
            long currentTimeMillis = System.currentTimeMillis() + p0();
            this.mAnimationEndTime = currentTimeMillis;
            if (z18) {
                this.mAnimationEndTime = currentTimeMillis + 500;
            }
            if (z16) {
                ad.b(this.f68790m, z18, p0());
            } else {
                ad.a(this.f68790m, p0());
            }
        } else {
            this.f68790m.setAnimation(null);
            this.f68790m.setVisibility(z16 ? 0 : 8);
            this.mAnimationEndTime = 0L;
        }
        this.mParent.s(Message.obtain(null, 11, Long.valueOf(this.mAnimationEndTime)));
        if (z16) {
            for (int i3 = 0; i3 < this.Q.size(); i3++) {
                this.Q.valueAt(i3).setVisibility(0);
            }
        }
    }

    protected void k0(int i3) {
        u0();
        if (this.mParent.d0() != null && (this.mParent.d0().getActivity() instanceof EditPicActivity)) {
            Z.put(32L, new d(32L, R.drawable.iyp, HardCodeUtil.qqStr(R.string.m0z)));
        }
        EditVideoPartManager editVideoPartManager = this.mParent;
        int i16 = editVideoPartManager.C.f204055d;
        if (i16 == 2 || i16 == 6) {
            if (!editVideoPartManager.l0()) {
                LongSparseArray<d> longSparseArray = Z;
                longSparseArray.put(1L, new d(1024L, R.drawable.iuo, HardCodeUtil.qqStr(R.string.f171930lz2)));
                longSparseArray.put(2L, new d(8L, R.drawable.iuw, HardCodeUtil.qqStr(R.string.m07)));
                longSparseArray.put(8L, new d(64L, R.drawable.ius, HardCodeUtil.qqStr(R.string.m3_)));
                longSparseArray.put(64L, new d(1L, R.drawable.iur, HardCodeUtil.qqStr(R.string.lyh)));
                if (w0()) {
                    longSparseArray.remove(1024L);
                } else {
                    longSparseArray.put(1024L, new d(2L, R.drawable.iyw, HardCodeUtil.qqStr(R.string.lye)));
                }
            } else {
                if ((i3 & 1) == 0 || (i3 & 4) == 0 || (i3 & 8) == 0 || (i3 & 64) == 0 || (i3 & 1024) == 0 || (i3 & 131072) == 0) {
                    return;
                }
                LongSparseArray<d> longSparseArray2 = Z;
                longSparseArray2.put(1L, new d(1024L, R.drawable.iyu, HardCodeUtil.qqStr(R.string.m3e)));
                longSparseArray2.put(4L, new d(131072L, R.drawable.iyy, getContext().getResources().getString(R.string.y4_)));
                longSparseArray2.put(8L, new d(1L, R.drawable.iyz, HardCodeUtil.qqStr(R.string.lyh)));
                longSparseArray2.put(64L, new d(4L, R.drawable.iyq, HardCodeUtil.qqStr(R.string.m28)));
                longSparseArray2.put(1024L, new d(8L, R.drawable.f160002iz1, HardCodeUtil.qqStr(R.string.lxy)));
                longSparseArray2.put(131072L, new d(64L, R.drawable.iyr, HardCodeUtil.qqStr(R.string.m3_)));
            }
        }
        if (i16 == 3 && SlideShowPhotoListManager.n().m() == 22) {
            LongSparseArray<d> longSparseArray3 = Z;
            longSparseArray3.put(1L, new d(2L, R.drawable.iyw, HardCodeUtil.qqStr(R.string.lyr)));
            longSparseArray3.put(2L, new d(16384L, R.drawable.iyo, HardCodeUtil.qqStr(R.string.f171939m31)));
            longSparseArray3.put(8L, new d(16L, R.drawable.iz4, HardCodeUtil.qqStr(R.string.m2y)));
            longSparseArray3.put(16L, new d(8L, R.drawable.f160002iz1, HardCodeUtil.qqStr(R.string.lxy)));
            longSparseArray3.put(16384L, new d(1L, R.drawable.iyz, HardCodeUtil.qqStr(R.string.lya)));
            return;
        }
        if (i16 == 3 && this.mParent.l0()) {
            LongSparseArray<d> longSparseArray4 = Z;
            longSparseArray4.put(1L, new d(1024L, R.drawable.iyu, HardCodeUtil.qqStr(R.string.m1r)));
            longSparseArray4.put(1024L, new d(1L, R.drawable.iyz, HardCodeUtil.qqStr(R.string.f171932m01)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y0(View view, int i3) {
    }
}

package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.gyailib.library.GYAIDocEnhance;
import com.tencent.aelight.camera.ae.camera.ui.bubble.BubbleTextView;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScaleGestureDetector;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DocEnhanceFragment extends AEFullScreenPublicFragment implements View.OnClickListener {

    /* renamed from: m0, reason: collision with root package name */
    private static final int f67368m0 = ViewConfiguration.get(BaseApplication.getContext()).getScaledTouchSlop();

    /* renamed from: n0, reason: collision with root package name */
    private static final int f67369n0 = ViewConfiguration.getLongPressTimeout();
    private ImageView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private RelativeLayout I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private TextView M;
    private TextView N;
    private TextView P;
    private BubbleTextView Q;
    private float T;
    private float U;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f67370a0;

    /* renamed from: b0, reason: collision with root package name */
    private Bitmap f67371b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f67372c0;

    /* renamed from: d0, reason: collision with root package name */
    private Bitmap f67373d0;

    /* renamed from: h0, reason: collision with root package name */
    private Bitmap f67377h0;

    /* renamed from: i0, reason: collision with root package name */
    private float f67378i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f67379j0;

    /* renamed from: k0, reason: collision with root package name */
    private Runnable f67380k0;
    private Rect R = new Rect();
    private Matrix S = new Matrix();
    private final float[] V = new float[9];
    private final RectF W = new RectF();
    private final RectF X = new RectF();

    /* renamed from: e0, reason: collision with root package name */
    private float[] f67374e0 = {0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: f0, reason: collision with root package name */
    private int f67375f0 = 2;

    /* renamed from: g0, reason: collision with root package name */
    private GYAIDocEnhance f67376g0 = new GYAIDocEnhance();

    /* renamed from: l0, reason: collision with root package name */
    private Handler f67381l0 = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DocEnhanceFragment.this.Mh();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DocEnhanceFragment.this.Sh(1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DocEnhanceFragment.this.Sh(2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DocEnhanceFragment.this.Sh(3);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap f67388d;

        f(Bitmap bitmap) {
            this.f67388d = bitmap;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            DocEnhanceFragment.this.C.removeOnLayoutChangeListener(this);
            DocEnhanceFragment.this.Vh(this.f67388d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ScaleGestureDetector f67393d;

        h(ScaleGestureDetector scaleGestureDetector) {
            this.f67393d = scaleGestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f67393d.onTouchEvent(motionEvent);
        }
    }

    private void Dh() {
        this.f67381l0.removeCallbacks(this.f67380k0);
    }

    private void Eh() {
        boolean c16 = AECameraPrefsUtil.f().c(AEEditorConstants.SP_KEY_DOC_ENHANCE_HAS_SHOWN_ADJUST_GUIDE_BUBBLE, false, 0);
        ms.a.f("DocEnhanceFragment", "checkShowGuideBubble---hasShown=" + c16);
        if (c16) {
            return;
        }
        AECameraPrefsUtil.f().l(AEEditorConstants.SP_KEY_DOC_ENHANCE_HAS_SHOWN_ADJUST_GUIDE_BUBBLE, true, 0);
        Dh();
        this.Q.setText(R.string.f169880y35);
        this.Q.setVisibility(0);
    }

    private void Fh() {
        int g16 = AECameraPrefsUtil.f().g(AEEditorConstants.SP_KEY_DOC_ENHANCE_FAIL_DETECT_BUBBLE_TIMES, 0, 0);
        ms.a.f("DocEnhanceFragment", "checkShowNeedAdjustBubble---showTimes=" + g16);
        if (g16 >= 2) {
            return;
        }
        AECameraPrefsUtil.f().n(AEEditorConstants.SP_KEY_DOC_ENHANCE_FAIL_DETECT_BUBBLE_TIMES, g16 + 1, 0);
        Dh();
        this.Q.setText(R.string.y36);
        this.Q.setVisibility(0);
        Ih();
    }

    private boolean Gh(MotionEvent motionEvent) {
        boolean z16 = motionEvent.getEventTime() - motionEvent.getDownTime() <= ((long) f67369n0);
        float rawX = motionEvent.getRawX() - this.f67378i0;
        float rawY = motionEvent.getRawY() - this.f67379j0;
        boolean z17 = Math.sqrt((double) ((rawX * rawX) + (rawY * rawY))) <= ((double) f67368m0);
        ms.a.a("DocEnhanceFragment", "considerAClick inTapTime=" + z16 + ", inTapDis=" + z17);
        return z16 && z17;
    }

    private void Hh() {
        float[] fArr = this.f67374e0;
        if (fArr == null || fArr.length != 8) {
            return;
        }
        float[] fArr2 = new float[8];
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = i3 * 2;
            fArr2[i16] = this.f67374e0[i16] * this.f67371b0.getWidth();
            int i17 = i16 + 1;
            fArr2[i17] = this.f67374e0[i17] * this.f67371b0.getHeight();
        }
        Bitmap bitmap = this.f67377h0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f67377h0 = this.f67376g0.documentWarp(this.f67371b0, fArr2);
    }

    private void Ih() {
        this.f67381l0.postDelayed(this.f67380k0, 3000L);
    }

    private void Jh() {
        ms.a.f("DocEnhanceFragment", "doEnhancementOnAdjustPointsChanged---mAdjustPoints=" + Arrays.toString(this.f67374e0));
        float[] fArr = this.f67374e0;
        if (fArr == null || fArr.length != 8) {
            return;
        }
        Hh();
        Oh(true);
    }

    private void Kh() {
        if (this.f67377h0 == null) {
            return;
        }
        Oh(false);
    }

    private void Lh() {
        long currentTimeMillis = System.currentTimeMillis();
        float[] documentDetect = this.f67376g0.documentDetect(this.f67371b0);
        ms.a.f("DocEnhanceFragment", "doEnhancementOnFirstEnter---detect points=" + Arrays.toString(documentDetect));
        if (documentDetect != null && documentDetect.length == 8) {
            for (int i3 = 0; i3 < 4; i3++) {
                int i16 = i3 * 2;
                this.f67374e0[i16] = documentDetect[i16] / this.f67371b0.getWidth();
                int i17 = i16 + 1;
                this.f67374e0[i17] = documentDetect[i17] / this.f67371b0.getHeight();
            }
            Eh();
        } else {
            Fh();
        }
        Hh();
        Oh(true);
        if (documentDetect == null || documentDetect.length != 8) {
            return;
        }
        ms.a.f("DocEnhanceFragment", "doEnhancementOnFirstEnter---cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private Bitmap Nh() {
        int i3 = this.f67375f0;
        if (i3 == 1) {
            return this.f67377h0;
        }
        if (i3 == 2) {
            return this.f67376g0.documentDeshadow(this.f67377h0);
        }
        if (i3 == 3) {
            return this.f67376g0.documentEnhance(this.f67377h0);
        }
        return null;
    }

    private void Oh(boolean z16) {
        Bitmap Nh = Nh();
        if (Nh != null) {
            this.f67370a0 = true;
            this.D.setEnabled(true);
            Bitmap bitmap = this.f67373d0;
            if (bitmap != null && bitmap != Nh && bitmap != this.f67371b0 && bitmap != this.f67377h0) {
                bitmap.recycle();
            }
            this.f67373d0 = Nh;
            Xh(Nh, z16);
        }
    }

    private void Ph(final FragmentActivity fragmentActivity) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment.9
            @Override // java.lang.Runnable
            public void run() {
                String str = com.tencent.aelight.camera.ae.h.f65577b + File.separator + System.currentTimeMillis() + ".jpg";
                FileUtils.createFileIfNotExits(str);
                try {
                    BaseImageUtil.saveBitmapFileAsJPEG(DocEnhanceFragment.this.f67373d0, new File(str));
                    Intent intent = new Intent();
                    intent.putExtra("RESULT_KEY_IS_ENHANCED", DocEnhanceFragment.this.f67370a0);
                    if (DocEnhanceFragment.this.f67370a0) {
                        intent.putExtra("RESULT_KEY_ENHANCED_POINTS_ARRAY", DocEnhanceFragment.this.f67374e0);
                        intent.putExtra("RESULT_KEY_ENHANCED_PIC_PATH", str);
                        intent.putExtra("RESULT_KEY_ENHANCED_COLOR_CONFIG", DocEnhanceFragment.this.f67375f0);
                    }
                    fragmentActivity.setResult(-1, intent);
                    fragmentActivity.finish();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }, 64, null, false);
    }

    private void Qh() {
        this.I.setVisibility(8);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        this.I.startAnimation(translateAnimation);
    }

    public static void Rh(Activity activity, int i3, String str, String str2, float[] fArr, int i16) {
        if (!com.tencent.aelight.camera.ae.d.s()) {
            ms.a.c("DocEnhanceFragment", "jumpToMeForResult---light sdk not ready");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), R.string.san, 1).show();
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("ARG_RAW_PIC_PATH", str);
        intent.putExtra("ARG_ENHANCED_PIC_PATH", str2);
        intent.putExtra("ARG_ENHANCED_POINTS_ARRAY", fArr);
        intent.putExtra("ARG_ENHANCED_COLOR_CONFIG", i16);
        QPublicFragmentActivityForMultiProcess.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) DocEnhanceFragment.class, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(int i3) {
        if (this.f67375f0 == i3) {
            return;
        }
        this.f67375f0 = i3;
        bi();
        Kh();
    }

    private void Th() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (this.f67370a0) {
                Ph(activity);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("RESULT_KEY_IS_ENHANCED", this.f67370a0);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private void Uh() {
        Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wh() {
        float f16;
        float f17;
        float f18;
        float f19 = 0.0f;
        this.X.set(0.0f, 0.0f, this.Y, this.Z);
        this.S.mapRect(this.X);
        RectF rectF = this.X;
        float f26 = rectF.left;
        RectF rectF2 = this.W;
        float f27 = rectF2.left;
        if (f26 <= f27) {
            f26 = rectF.right;
            f27 = rectF2.right;
            if (f26 >= f27) {
                f16 = 0.0f;
                f17 = rectF.top;
                f18 = rectF2.top;
                if (f17 <= f18) {
                    f19 = f18 - f17;
                } else {
                    float f28 = rectF.bottom;
                    float f29 = rectF2.bottom;
                    if (f28 < f29) {
                        f19 = f29 - f28;
                    }
                }
                this.S.postTranslate(f16, f19);
            }
        }
        f16 = f27 - f26;
        f17 = rectF.top;
        f18 = rectF2.top;
        if (f17 <= f18) {
        }
        this.S.postTranslate(f16, f19);
    }

    private void Yh() {
        this.C.setOnTouchListener(new h(new ScaleGestureDetector(getContext(), new g())));
    }

    private void Zh() {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.y38));
        qQCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.y37));
        qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.y2a), new a());
        qQCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.y2c), new b());
        qQCustomDialog.setCanceledOnTouchOutside(true);
        qQCustomDialog.show();
    }

    private void ai() {
        if (this.f67375f0 == 2) {
            Sh(1);
        } else {
            Sh(2);
        }
    }

    private void bi() {
        this.J.setSelected(false);
        this.K.setSelected(false);
        this.L.setSelected(false);
        int i3 = this.f67375f0;
        if (i3 == 1) {
            this.J.setSelected(true);
        } else if (i3 == 2) {
            this.K.setSelected(true);
        } else if (i3 == 3) {
            this.L.setSelected(true);
        }
        if (this.f67375f0 == 2) {
            this.F.setTextColor(-16725252);
            this.F.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ix8, 0, 0, 0);
        } else {
            this.F.setTextColor(-1);
            this.F.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ix7, 0, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f67378i0 = motionEvent.getRawX();
            this.f67379j0 = motionEvent.getRawY();
        } else if (actionMasked == 1) {
            if (this.Q.getVisibility() == 0 && Gh(motionEvent)) {
                Dh();
                this.Q.setVisibility(8);
                return false;
            }
            if (this.I.getVisibility() == 0 && Gh(motionEvent)) {
                this.I.getGlobalVisibleRect(this.R);
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                ms.a.a("DocEnhanceFragment", "considerAClick mConfigPanelRect=" + this.R + ", ev=" + rawX + "," + rawY);
                if (rawY < this.R.top) {
                    Qh();
                    return true;
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.I.getVisibility() == 0) {
            Qh();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.s36 /* 2097545847 */:
                DocEnhanceAdjustFragment.sh(getActivity(), 3721, this.f67372c0, this.f67374e0);
                com.tencent.aelight.camera.ae.report.b.b().n0("\u6821\u51c6");
                break;
            case R.id.s39 /* 2097545850 */:
                onBackEvent();
                com.tencent.aelight.camera.ae.report.b.b().n0("\u53d6\u6d88");
                break;
            case R.id.s3l /* 2097545863 */:
                ai();
                com.tencent.aelight.camera.ae.report.b b16 = com.tencent.aelight.camera.ae.report.b.b();
                if (this.f67375f0 != 1) {
                    str = "\u6548\u679c\u5f00";
                } else {
                    str = "\u6548\u679c\u5173";
                }
                b16.n0(str);
                break;
            case R.id.s3n /* 2097545865 */:
                Th();
                com.tencent.aelight.camera.ae.report.b.b().n0("\u5b8c\u6210");
                break;
            case R.id.s3x /* 2097545875 */:
                Uh();
                com.tencent.aelight.camera.ae.report.b.b().n0("\u8fd8\u539f");
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("ARG_RAW_PIC_PATH");
            if (!TextUtils.isEmpty(string)) {
                this.f67372c0 = string;
                this.f67371b0 = BitmapFactory.decodeFile(string);
            }
            String string2 = arguments.getString("ARG_ENHANCED_PIC_PATH");
            float[] floatArray = arguments.getFloatArray("ARG_ENHANCED_POINTS_ARRAY");
            if (!TextUtils.isEmpty(string2) && floatArray != null && floatArray.length == 8) {
                this.f67374e0 = floatArray;
                this.f67373d0 = BitmapFactory.decodeFile(string2);
                this.f67375f0 = arguments.getInt("ARG_ENHANCED_COLOR_CONFIG", 2);
                this.f67370a0 = true;
            }
            ms.a.f("DocEnhanceFragment", "onCreate--mIsEnhanced=" + this.f67370a0 + ", mRawPicPath=" + this.f67372c0 + ", mEnhancedPicPath=" + string2 + ", mEnhancePoints=" + Arrays.toString(this.f67374e0));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f67371b0;
        if (bitmap != null) {
            bitmap.recycle();
            this.f67371b0 = null;
        }
        Bitmap bitmap2 = this.f67373d0;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f67373d0 = null;
        }
        Bitmap bitmap3 = this.f67377h0;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.f67377h0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        this.f67370a0 = false;
        this.D.setEnabled(false);
        Xh(this.f67371b0, true);
        this.f67374e0 = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        Hh();
        this.f67375f0 = 1;
        bi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(Bitmap bitmap) {
        float f16;
        float f17;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.Y = bitmap.getWidth();
        this.Z = bitmap.getHeight();
        int width = this.C.getWidth();
        float f18 = width;
        float f19 = (f18 * 1.0f) / this.Y;
        float height = this.C.getHeight();
        float f26 = (1.0f * height) / this.Z;
        float min = Math.min(f19, f26);
        if (f19 < f26) {
            f17 = (height - (this.Z * min)) / 2.0f;
            f16 = 0.0f;
        } else {
            f16 = (f18 - (this.Y * min)) / 2.0f;
            f17 = 0.0f;
        }
        this.S.reset();
        this.S.postScale(min, min);
        this.S.postTranslate(f16, f17);
        this.C.setImageMatrix(this.S);
        this.T = min;
        this.U = Math.max(3.0f, min);
        this.W.set(0.0f, 0.0f, this.Y, this.Z);
        this.S.mapRect(this.W);
    }

    private void Xh(Bitmap bitmap, boolean z16) {
        if (z16) {
            if (this.C.getWidth() > 0 && this.C.getHeight() > 0) {
                Vh(bitmap);
            } else {
                this.C.addOnLayoutChangeListener(new f(bitmap));
            }
        }
        this.C.setImageBitmap(bitmap);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.C = (ImageView) view.findViewById(R.id.rvo);
        this.D = (TextView) view.findViewById(R.id.s3x);
        this.E = (TextView) view.findViewById(R.id.s36);
        this.F = (TextView) view.findViewById(R.id.s3l);
        this.G = (TextView) view.findViewById(R.id.s39);
        this.H = (TextView) view.findViewById(R.id.s3n);
        this.Q = (BubbleTextView) view.findViewById(R.id.rpx);
        Context context = getContext();
        this.Q.setPadding(UIUtils.b(context, 10.0f), UIUtils.b(context, 11.0f), UIUtils.b(context, 10.0f), UIUtils.b(context, 11.0f));
        this.Q.setIncludeFontPadding(false);
        this.Q.setTextSize(1, 14.0f);
        this.Q.setTextColor(Color.parseColor("#03081A"));
        BubbleTextView bubbleTextView = this.Q;
        bubbleTextView.f62581m = -1;
        bubbleTextView.f62578f = UIUtils.b(context, 6.0f);
        this.Q.a();
        this.f67380k0 = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment.2
            @Override // java.lang.Runnable
            public void run() {
                DocEnhanceFragment.this.Q.setVisibility(8);
            }
        };
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rzy);
        this.I = relativeLayout;
        View findViewById = relativeLayout.findViewById(R.id.rwj);
        this.J = (ImageView) findViewById.findViewById(R.id.rvv);
        this.M = (TextView) findViewById.findViewById(R.id.s3c);
        findViewById.setOnClickListener(new c());
        View findViewById2 = this.I.findViewById(R.id.rwi);
        this.K = (ImageView) findViewById2.findViewById(R.id.rvv);
        this.N = (TextView) findViewById2.findViewById(R.id.s3c);
        findViewById2.setOnClickListener(new d());
        View findViewById3 = this.I.findViewById(R.id.rwh);
        this.L = (ImageView) findViewById3.findViewById(R.id.rvv);
        this.P = (TextView) findViewById3.findViewById(R.id.s3c);
        findViewById3.setOnClickListener(new e());
        this.M.setText(R.string.f169875y30);
        this.N.setText(R.string.y2z);
        this.P.setText(R.string.y2y);
        this.J.setImageResource(R.drawable.ix6);
        this.K.setImageResource(R.drawable.ix5);
        this.L.setImageResource(R.drawable.f159990ix4);
        bi();
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.D.setEnabled(this.f67370a0);
        this.C.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.f67370a0) {
            Xh(this.f67373d0, true);
            Hh();
        } else {
            Xh(this.f67371b0, true);
            Lh();
        }
        Yh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dnm, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 3721 && i16 == -1 && intent != null) {
            this.f67374e0 = intent.getFloatArrayExtra("RESULT_ADJUST_POINTS_ARRAY");
            Jh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements ScaleGestureDetector.OnScaleGestureListener {

        /* renamed from: d, reason: collision with root package name */
        float f67390d;

        /* renamed from: e, reason: collision with root package name */
        float f67391e;

        g() {
        }

        private void a(float f16, float f17, float f18) {
            ms.a.a("DocEnhanceFragment", "doScale---scaleFactor=" + f16 + ", focusX=" + f17 + ", focusY=" + f18);
            DocEnhanceFragment.this.S.postTranslate(f17 - this.f67390d, f18 - this.f67391e);
            DocEnhanceFragment.this.S.postScale(f16, f16, f17, f18);
            DocEnhanceFragment.this.Wh();
            DocEnhanceFragment.this.C.setImageMatrix(DocEnhanceFragment.this.S);
            DocEnhanceFragment.this.C.invalidate();
            this.f67390d = f17;
            this.f67391e = f18;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            DocEnhanceFragment.this.S.getValues(DocEnhanceFragment.this.V);
            float f16 = DocEnhanceFragment.this.V[0];
            a(Math.min(DocEnhanceFragment.this.U / f16, Math.max(DocEnhanceFragment.this.T / f16, scaleFactor)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f67390d = scaleGestureDetector.getFocusX();
            this.f67391e = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

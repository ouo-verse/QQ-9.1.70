package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.h;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes32.dex */
public class DocEnhancePart extends u {
    private static final HashSet<String> F;
    private boolean C;
    private String D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private float[] f67395d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f67396e;

    /* renamed from: f, reason: collision with root package name */
    private int f67397f;

    /* renamed from: h, reason: collision with root package name */
    private String f67398h;

    /* renamed from: i, reason: collision with root package name */
    private String f67399i;

    /* renamed from: m, reason: collision with root package name */
    protected View f67400m;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DocEnhancePart.this.mParent.I();
            if (DocEnhancePart.this.mParent.P() > 0) {
                DocEnhancePart.this.x0();
            } else {
                DocEnhancePart.this.v0();
            }
            com.tencent.aelight.camera.ae.report.b.b().l0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DocEnhancePart.this.v0();
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        F = hashSet;
        hashSet.add("\u7ed8\u753b");
        hashSet.add("\u540d\u7247");
        hashSet.add("\u5e7b\u706f\u7247");
        hashSet.add("\u7968\u636e");
        hashSet.add("\u6587\u672c");
        hashSet.add("\u62a5\u7eb8");
        hashSet.add("\u6587\u6863");
        hashSet.add("\u6587\u5b57");
        hashSet.add("\u8bc1\u4ef6");
        hashSet.add("\u8eab\u4efd\u8bc1");
        hashSet.add("\u4e66\u6cd5");
        hashSet.add("\u94f6\u884c\u5361");
        hashSet.add("\u56fe\u8868_\u8d26\u5355");
        hashSet.add("\u4e66");
    }

    public DocEnhancePart(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        int i3 = this.mParent.C.f204055d;
        if (i3 != 2) {
            ms.a.c("DocEnhancePart", "checkShowEntrance---wrong business: " + i3);
            return;
        }
        int i16 = this.E;
        if (i16 != 0 && i16 != 4 && i16 != 25) {
            ms.a.c("DocEnhancePart", "checkShowEntrance---wrong state: " + this.E);
        }
        if (!F.contains(this.D)) {
            ms.a.c("DocEnhancePart", "checkShowEntrance---wrong sub label: " + this.D);
            return;
        }
        if (AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE) && AEResUtil.U(AEResInfo.AE_RES_BASE_PACKAGE) && AEResUtil.U(AEResInfo.LIGHT_RES_BUNDLE_SCENE)) {
            if (d.n() && FeatureManager.Features.PTU_TOOLS.init() && FeatureManager.Features.PTU_ALGO.init() && FeatureManager.Features.IMAGE_ALGO.init()) {
                this.f67400m.setVisibility(0);
                return;
            } else {
                ms.a.c("DocEnhancePart", "checkShowEntrance---features init fail");
                return;
            }
        }
        ms.a.c("DocEnhancePart", "checkShowEntrance---res not exist");
    }

    private void r0() {
        ms.a.f("DocEnhancePart", "clearEnhancementInfo---");
        this.f67396e = false;
        this.f67399i = null;
        this.f67395d = null;
        this.f67398h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s0(Bitmap bitmap) {
        return this.mParent.O(bitmap);
    }

    private void t0() {
        final Bitmap S = this.mParent.S();
        if (S == null || S.isRecycled()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.4
            @Override // java.lang.Runnable
            public void run() {
                String str = h.f65577b + File.separator + System.currentTimeMillis() + ".jpg";
                FileUtils.createFileIfNotExits(str);
                try {
                    BaseImageUtil.saveBitmapFileAsJPEG(S, new File(str));
                    DocEnhancePart.this.f67398h = str;
                    DocEnhanceFragment.Rh((Activity) DocEnhancePart.this.getContext(), 7532, str, null, null, DocEnhancePart.this.f67397f);
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }, 64, null, false);
    }

    private void u0() {
        this.f67400m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        ms.a.f("DocEnhancePart", "onClickEnter--mIsEnhanced=" + this.f67396e + ", mRawPicPath=" + this.f67398h + ", mEnhancedPicPath=" + this.f67399i + ", mEnhancePoints=" + Arrays.toString(this.f67395d));
        if (this.f67396e) {
            DocEnhanceFragment.Rh((Activity) getContext(), 7532, this.f67398h, this.f67399i, this.f67395d, this.f67397f);
        } else if (!TextUtils.isEmpty(this.f67398h)) {
            DocEnhanceFragment.Rh((Activity) getContext(), 7532, this.f67398h, null, null, this.f67397f);
        } else {
            t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.f169878y33));
        qQCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f169877y32));
        qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.y2a), new b());
        qQCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.y2c), new c());
        qQCustomDialog.setCanceledOnTouchOutside(true);
        qQCustomDialog.show();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        if (this.f67396e) {
            bVar.f400395l.f400420f++;
        }
        AEBaseReportParam.U().F0(this.f67396e);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, int i16, Object obj) {
        this.E = i16;
        if (i16 == 24) {
            r0();
            if (this.C) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.5
                    @Override // java.lang.Runnable
                    public void run() {
                        DocEnhancePart docEnhancePart = DocEnhancePart.this;
                        docEnhancePart.p0(docEnhancePart.s0(docEnhancePart.mParent.S()));
                    }
                }, 16, null, false);
            }
        }
        if (i16 != 0) {
            if (i16 != 13) {
                if (i16 != 25) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            return;
                        }
                    }
                }
                q0();
                w0(true);
                return;
            }
            u0();
            return;
        }
        q0();
        w0(false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (7532 == i3 && i16 == -1 && intent != null) {
            this.f67396e = intent.getBooleanExtra("RESULT_KEY_IS_ENHANCED", false);
            ms.a.f("DocEnhancePart", "onActivityResult--mIsEnhanced=" + this.f67396e + ", mRawPicPath=" + this.f67398h);
            if (this.f67396e) {
                String stringExtra = intent.getStringExtra("RESULT_KEY_ENHANCED_PIC_PATH");
                this.f67399i = stringExtra;
                Bitmap decodeFile = BitmapFactory.decodeFile(stringExtra);
                this.mParent.e1(decodeFile, false);
                m.n().S(decodeFile);
                this.f67395d = intent.getFloatArrayExtra("RESULT_KEY_ENHANCED_POINTS_ARRAY");
                this.f67397f = intent.getIntExtra("RESULT_KEY_ENHANCED_COLOR_CONFIG", 2);
            } else {
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.f67398h);
                this.mParent.e1(decodeFile2, false);
                m.n().S(decodeFile2);
                r0();
            }
            this.mParent.z0();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        View findViewSure = findViewSure(R.id.rrz);
        this.f67400m = findViewSure;
        findViewSure.setVisibility(8);
        this.f67400m.setBackgroundResource(R.drawable.it_);
        this.f67400m.setOnClickListener(new a());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
    }

    public void p0(final String str) {
        if (this.C) {
            if (!TextUtils.isEmpty(str)) {
                this.C = false;
            }
            this.D = str;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart.6
                @Override // java.lang.Runnable
                public void run() {
                    DocEnhancePart.this.q0();
                    ms.a.f("DocEnhancePart", "AiSubLabel: " + str);
                }
            });
        }
    }

    protected void w0(boolean z16) {
        int dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.f67400m.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z16) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f13209j);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f13199i);
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.f67400m.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

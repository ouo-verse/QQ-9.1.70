package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.gyailib.library.GYAISceneChain;
import com.gyailib.library.GYDetectCommonItemParams;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.takevideo.ac;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.light.LightConstants;

/* loaded from: classes32.dex */
public class VideoFilterViewPager extends UnHandleTouchEventViewPager implements d.c {
    private View C;
    private boolean D;
    private boolean E;
    private boolean F;
    public boolean G;
    private String H;
    private AEFilterManager I;
    private ps.b J;
    private SimpleGLThread K;
    private Handler L;
    private Runnable M;
    private int N;
    private int P;
    private String Q;
    private boolean R;
    private boolean S;
    private HandlerThread T;
    public boolean U;
    private int V;
    private GYAISceneChain W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f66385a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f66386b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f66387c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f66388d0;

    /* renamed from: e, reason: collision with root package name */
    private d f66389e;

    /* renamed from: e0, reason: collision with root package name */
    long f66390e0;

    /* renamed from: f, reason: collision with root package name */
    private c f66391f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f66392h;

    /* renamed from: i, reason: collision with root package name */
    private b f66393i;

    /* renamed from: m, reason: collision with root package name */
    private a f66394m;

    /* loaded from: classes32.dex */
    public interface a {
        void a(String str);
    }

    /* loaded from: classes32.dex */
    public interface b {
        void a(int i3, QIMFilterCategoryItem qIMFilterCategoryItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        public final Map<Class<? extends View>, Queue<View>> f66405d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray<View> f66406e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<QIMFilterCategoryItem> f66407f = new ArrayList<>();

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(ArrayList arrayList, Runnable runnable) {
            if (VideoFilterViewPager.this.S) {
                return;
            }
            this.f66407f.clear();
            this.f66407f = arrayList;
            notifyDataSetChanged();
            if (runnable != null) {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(ArrayList arrayList, final Runnable runnable) {
            if (VideoFilterViewPager.this.S) {
                return;
            }
            final ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) it.next();
                if (!qIMFilterCategoryItem.n()) {
                    arrayList2.add(qIMFilterCategoryItem);
                }
            }
            if (!m.n().E()) {
                m.f(arrayList2);
            }
            m.g(VideoFilterViewPager.this.getContext(), arrayList2);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.o
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFilterViewPager.d.this.j(arrayList2, runnable);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFilterViewPager", 2, "destroyItem position: " + i3);
            }
            View view = (View) obj;
            view.removeCallbacks((Runnable) view.getTag());
            view.clearAnimation();
            viewGroup.removeView(view);
            Queue<View> queue = this.f66405d.get(view.getClass());
            if (queue == null) {
                queue = new LinkedList<>();
                this.f66405d.put(view.getClass(), queue);
            }
            queue.offer(view);
            this.f66406e.remove(i3);
        }

        public int f() {
            return this.f66407f.size();
        }

        public int g(int i3) {
            int size = this.f66407f.size();
            if (size > 0) {
                return i3 % size;
            }
            return -1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f66407f.size() * 100;
        }

        public View h(int i3) {
            return this.f66406e.get(i3);
        }

        public QIMFilterCategoryItem i(int i3) {
            int g16 = g(i3);
            if (g16 < 0 || g16 >= this.f66407f.size()) {
                return null;
            }
            return this.f66407f.get(g16);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            QIMFilterCategoryItem i16 = i(i3);
            if (QLog.isColorLevel()) {
                QLog.d("VideoFilterViewPager", 2, "instantiateItem position: " + i16);
            }
            if (i16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("VideoFilterViewPager", 2, "instantiateItem find data is null!");
                }
                return null;
            }
            Queue<View> queue = this.f66405d.get(i16.getClass());
            View poll = queue != null ? queue.poll() : null;
            if (poll == null) {
                poll = ((LayoutInflater) VideoFilterViewPager.this.getContext().getSystemService("layout_inflater")).inflate(R.layout.f167918me, (ViewGroup) null);
                poll.setVisibility(8);
            }
            viewGroup.addView(poll);
            this.f66406e.put(i3, poll);
            return poll;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return (obj instanceof View) && obj == view;
        }

        public void l(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (int i3 = 0; i3 < this.f66407f.size(); i3++) {
                if (str.equals(this.f66407f.get(i3).f66697d)) {
                    VideoFilterViewPager.this.P(i3);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("VideoFilterViewPager", 2, "onResourceDownload - selectFilterById() - set last selected item: (" + i3 + ", " + this.f66407f.get(i3).f66697d + ")");
                    }
                }
            }
        }

        public void m(List<QIMFilterCategoryItem> list, final Runnable runnable) {
            final ArrayList arrayList = new ArrayList(list);
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.n
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFilterViewPager.d.this.k(arrayList, runnable);
                }
            });
        }
    }

    public VideoFilterViewPager(Context context) {
        super(context);
        this.f66392h = true;
        this.E = true;
        this.F = false;
        this.G = false;
        this.R = false;
        this.S = false;
        this.U = true;
        this.V = -1;
        this.f66385a0 = false;
        this.f66386b0 = false;
        this.f66387c0 = false;
        this.f66388d0 = 0;
        this.f66390e0 = 0L;
        init();
    }

    private void G(int i3) {
        QIMFilterCategoryItem i16;
        View h16 = this.f66389e.h(i3);
        if (h16 == null || (i16 = this.f66389e.i(i3)) == null) {
            return;
        }
        X(h16, i16, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3, String str) {
        QIMFilterCategoryItem i16;
        View h16 = this.f66389e.h(i3);
        if (h16 == null || (i16 = this.f66389e.i(i3)) == null) {
            return;
        }
        i16.N = str;
        X(h16, i16, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String J(Bitmap bitmap) {
        if (bitmap == null) {
            ms.a.c("VideoFilterViewPager", "bitmap is null.");
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        O();
        GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
        if (bitmap.getHeight() <= 512 && bitmap.getWidth() <= 512) {
            GYAISceneChain gYAISceneChain = this.W;
            if (gYAISceneChain != null) {
                gYAISceneChain.forwardDetect(bitmap, gYDetectCommonResultStruct, 0);
            } else {
                ms.a.c("VideoFilterViewPager", "gyAiSceneChain is null.");
            }
        } else {
            Bitmap scaleBitmap = BitmapUtil.scaleBitmap(bitmap, 512);
            if (scaleBitmap != null) {
                GYAISceneChain gYAISceneChain2 = this.W;
                if (gYAISceneChain2 != null) {
                    gYAISceneChain2.forwardDetect(scaleBitmap, gYDetectCommonResultStruct, 0);
                }
                scaleBitmap.recycle();
            }
        }
        String string = BaseApplication.getContext().getResources().getString(R.string.f170132ym1);
        GYDetectCommonItemParams[] gYDetectCommonItemParamsArr = gYDetectCommonResultStruct.items;
        if (gYDetectCommonItemParamsArr != null && gYDetectCommonItemParamsArr.length > 0 && !TextUtils.isEmpty(gYDetectCommonItemParamsArr[0].classifyType)) {
            GYDetectCommonItemParams gYDetectCommonItemParams = gYDetectCommonResultStruct.items[0];
            String str = gYDetectCommonItemParams.classifyType;
            this.H = gYDetectCommonItemParams.classifyName;
            ms.a.f("VideoFilterViewPager", "aio photo ai label: " + str + " subLabel: " + this.H);
            string = str;
        }
        a aVar = this.f66394m;
        if (aVar != null) {
            aVar.a(this.H);
        }
        ms.a.a("VideoFilterViewPager", "[AICost] aio ai process time: " + (System.currentTimeMillis() - currentTimeMillis));
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final int i3, final int i16) {
        SimpleGLThread simpleGLThread = new SimpleGLThread(null, "AIOEdit");
        this.K = simpleGLThread;
        simpleGLThread.postJob(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                VideoFilterViewPager.this.N = iArr[0];
                VideoFilterViewPager.this.I = new AEFilterManager();
                VideoFilterViewPager.this.I.initInGL(i3, i16);
                VideoFilterViewPager.this.I.defineFiltersAndOrder(300, 100);
                VideoFilterViewPager.this.I.setFilterInSmooth(true);
                VideoFilterViewPager.this.I.setSyncMode(true);
                VideoFilterViewPager.this.I.updateMaterialGL(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
            }
        });
    }

    private int O() {
        if (this.W != null) {
            return 0;
        }
        if (AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE) && AEResUtil.U(AEResInfo.AE_RES_BASE_PACKAGE) && AEResUtil.U(AEResInfo.LIGHT_RES_BUNDLE_SCENE)) {
            if (FeatureManager.Features.LIGHT_SDK.init() && com.tencent.aelight.camera.ae.d.s() && FeatureManager.Features.PAG.init() && FeatureManager.Features.PTU_TOOLS.init() && FeatureManager.Features.PTU_ALGO.init() && FeatureManager.Features.IMAGE_ALGO.init()) {
                SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
                sDKDeviceConfig.setDevice("ARM");
                GYAISceneChain gYAISceneChain = new GYAISceneChain();
                this.W = gYAISceneChain;
                int initInstance = gYAISceneChain.initInstance(sDKDeviceConfig);
                if (initInstance != 0) {
                    ms.a.c("VideoFilterViewPager", "GYAISceneChain initInstance with error:" + initInstance);
                    return initInstance;
                }
                SDKModelConfig sDKModelConfig = new SDKModelConfig();
                HashMap hashMap = new HashMap();
                sDKModelConfig.modelPaths = hashMap;
                hashMap.put("scene-dir", AEResUtil.v("SCENE_CLASSIFY"));
                sDKModelConfig.modelPaths.put("face-dir", AEResUtil.v("FACE_AGENT"));
                sDKModelConfig.modelPaths.put("feature-dir", AEResUtil.v(LightConstants.AgentType.FACE_STATIC_FEATURE_AGENT));
                int i3 = this.W.setupWithModel(sDKModelConfig);
                if (i3 == 0) {
                    return 0;
                }
                ms.a.c("VideoFilterViewPager", "init error code: " + i3);
                return i3;
            }
            ms.a.c("VideoFilterViewPager", "ensureInitSceneChain---features init fail");
            return -1;
        }
        ms.a.c("VideoFilterViewPager", "ensureInitSceneChain---res not exist");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(View view, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoFilterViewPager", 2, "onPageSelect position: " + i3 + ", mCurPosition: " + this.V + ", mFromOnlyChangeUi: " + this.f66386b0);
        }
        if (i3 == this.V) {
            return;
        }
        this.C = view;
        this.V = i3;
        view.setVisibility(0);
        QIMFilterCategoryItem i16 = this.f66389e.i(i3);
        if (i16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
                return;
            }
            return;
        }
        String str = "none";
        if (((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).getGifMode()) {
            IAEBaseDataReporter iAEBaseDataReporter = (IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class);
            if (i3 != 0) {
                str = "" + i16.f66697d;
            }
            iAEBaseDataReporter.reportEmoFilterItem(str);
        } else {
            IAEBaseDataReporter iAEBaseDataReporter2 = (IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class);
            if (i3 != 0) {
                str = "" + i16.f66697d;
            }
            iAEBaseDataReporter2.reportClickFilterItem(str);
        }
        TextView textView = (TextView) view.findViewById(R.id.b2w);
        TextView textView2 = (TextView) view.findViewById(R.id.b2v);
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
        if (i16.e()) {
            M(i3, false);
        }
        if (!this.f66386b0) {
            Bundle bundle = new Bundle();
            bundle.putInt("apply_source", 2);
            bundle.putInt("capture_scene", this.f66388d0);
            dVar.m(i16, (Activity) getContext(), bundle);
            if (this.F && this.E) {
                T(i16.f66697d);
            }
            if (z16 && ((Activity) getContext()).getIntent() != null) {
                id0.a.l("filter_swipe", ((Activity) getContext()).getIntent().getIntExtra("edit_video_type", 10002), 0, "", i16.f66697d);
            }
        }
        com.tencent.aelight.camera.aioeditor.capture.data.j s16 = dVar.s(i16);
        int v3 = s16.v();
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "onPageSelect state = " + v3 + " " + s16.toString());
        }
        if (!i16.l() && !i16.L && !this.f66385a0) {
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        }
        if (this.U) {
            this.U = false;
        }
        if (!this.f66392h) {
            this.f66392h = true;
        }
        view.setVisibility(0);
        if (i16.e()) {
            X(view, i16, 3);
        } else {
            X(view, i16, v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.5
            @Override // java.lang.Runnable
            public void run() {
                VideoFilterViewPager videoFilterViewPager = VideoFilterViewPager.this;
                videoFilterViewPager.H(videoFilterViewPager.P, VideoFilterViewPager.this.Q);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final Bitmap bitmap) {
        if (this.J == null) {
            ms.a.c("VideoFilterViewPager", "aePhotoAIResult is null.");
        } else {
            this.K.postJob(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.6
                @Override // java.lang.Runnable
                public void run() {
                    AEFilterManager aEFilterManager = VideoFilterViewPager.this.I;
                    if (aEFilterManager == null) {
                        ms.a.c("VideoFilterViewPager", "processBitmap error, aeFilterManager is null.");
                        return;
                    }
                    aEFilterManager.updateLutGL(VideoFilterViewPager.this.J.b());
                    aEFilterManager.updateLutAlpha((int) (VideoFilterViewPager.this.J.c() * 100.0f));
                    aEFilterManager.setSmoothLevel((int) (VideoFilterViewPager.this.J.d() * 100.0f));
                    aEFilterManager.setGlowAlpha(VideoFilterViewPager.this.J.a());
                    aEFilterManager.setPicNeedFlipBeforeRender(true);
                    GlUtil.loadTexture(VideoFilterViewPager.this.N, bitmap);
                    final Bitmap saveTexture = GlUtil.saveTexture(aEFilterManager.drawFrame(VideoFilterViewPager.this.N, true, 0L), bitmap.getWidth(), bitmap.getHeight());
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (m.n().p() == null) {
                                return;
                            }
                            m.n().p().e1(saveTexture, true);
                        }
                    });
                }
            });
        }
    }

    public static void T(String str) {
        String str2;
        if (AEDashboardUtil.q()) {
            str2 = AECameraConstants.DY_FILTER_ID;
        } else {
            str2 = AECameraConstants.AE_FILTER_ID;
        }
        ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).putString(str2, str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("VideoFilterViewPager", 2, "saveFilterPref(" + str2 + ", " + str + ")");
        }
    }

    private void Y(int i3) {
        QIMFilterCategoryItem i16;
        View h16 = this.f66389e.h(i3);
        if (h16 == null || (i16 = this.f66389e.i(i3)) == null) {
            return;
        }
        int i17 = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).s(i16).f66706e;
        if (i16.e()) {
            i17 = 3;
        }
        X(h16, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z16, Bitmap bitmap) {
        this.Q = J(bitmap);
        this.J = ((IAEPhotoAIManager) QRoute.api(IAEPhotoAIManager.class)).getPhotoAIResult(this.Q);
        if (z16) {
            return;
        }
        R();
        S(bitmap);
    }

    private void init() {
        this.f66389e = new d();
        this.f66391f = new c();
        setAdapter(this.f66389e);
        addOnPageChangeListener(this.f66391f);
        V();
    }

    public void C() {
        boolean z16;
        int currentItem = getCurrentItem();
        QLog.i("VideoFilterViewPager", 2, "needReselectMiddle getActualCount " + this.f66389e.f());
        if (currentItem == 0 || currentItem % this.f66389e.f() == 0) {
            QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            setCurrentItem(this.f66389e.f() * 50, false);
        }
    }

    public void D() {
        SimpleGLThread simpleGLThread = this.K;
        if (simpleGLThread != null) {
            simpleGLThread.postJob(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.3
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoFilterViewPager.this.I != null) {
                        VideoFilterViewPager.this.I.destroy();
                        VideoFilterViewPager.this.I = null;
                    }
                }
            });
        }
    }

    public void F(boolean z16) {
        this.D = z16;
    }

    public void I() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public String K(Bitmap bitmap) {
        return this.H;
    }

    public String L() {
        String str;
        if (AEDashboardUtil.q()) {
            str = AECameraConstants.DY_FILTER_ID;
        } else {
            str = AECameraConstants.AE_FILTER_ID;
        }
        String string = ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getString(str, "", 0);
        if (QLog.isColorLevel()) {
            QLog.d("VideoFilterViewPager", 2, "getFilterId(" + str + ", " + string + ")");
        }
        return string;
    }

    public void M(int i3, boolean z16) {
        boolean z17;
        if (!m.B(getContext()) || (z17 = this.S)) {
            ms.a.c("VideoFilterViewPager", "ai filter res not ready.");
            return;
        }
        if (z17) {
            ms.a.c("VideoFilterViewPager", "view pager detached.");
            return;
        }
        this.P = i3;
        this.R = z16;
        if (this.M == null) {
            this.M = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.4
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap s16 = m.n().s();
                    if (s16 != null) {
                        if (VideoFilterViewPager.this.I == null) {
                            VideoFilterViewPager.this.N(s16.getWidth(), s16.getHeight());
                        }
                        if (TextUtils.isEmpty(VideoFilterViewPager.this.Q)) {
                            VideoFilterViewPager videoFilterViewPager = VideoFilterViewPager.this;
                            videoFilterViewPager.Z(videoFilterViewPager.R, s16);
                            return;
                        }
                        ms.a.f("VideoFilterViewPager", "aio photo ai label saved: " + VideoFilterViewPager.this.Q + " isPreload: " + VideoFilterViewPager.this.R);
                        if (VideoFilterViewPager.this.R) {
                            return;
                        }
                        VideoFilterViewPager.this.R();
                        VideoFilterViewPager.this.S(s16);
                        String J = VideoFilterViewPager.this.J(s16);
                        if (J == null || J.equals(VideoFilterViewPager.this.Q)) {
                            return;
                        }
                        VideoFilterViewPager.this.Z(false, s16);
                        return;
                    }
                    ms.a.c("VideoFilterViewPager", "bitmap is null.");
                }
            };
        }
        if (this.L == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AIDetectThread");
            this.T = baseHandlerThread;
            baseHandlerThread.start();
            this.L = new Handler(this.T.getLooper());
        }
        this.L.removeCallbacks(this.M);
        this.L.post(this.M);
    }

    public void P(int i3) {
        setCurrentItem((this.f66389e.f() * 50) + i3);
    }

    public void U() {
        this.f66389e.l(L());
    }

    public void W(List<QIMFilterCategoryItem> list, Runnable runnable) {
        if (!(getContext() instanceof QzoneEditVideoActivity)) {
            setVisibility(0);
            setEnabled(true);
        }
        this.f66389e.m(list, runnable);
        QLog.i("VideoFilterViewPager", 2, "update getCurrentItem = " + getCurrentItem());
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(com.tencent.aelight.camera.aioeditor.capture.data.j jVar, boolean z16, int i3, Bundle bundle) {
        int indexOf;
        if (bundle == null) {
            QLog.e("QCombo", 1, "onFilterApply aborted");
            return;
        }
        int i16 = bundle.getInt("capture_scene", -1);
        if (this.f66388d0 != i16) {
            QLog.e("QCombo", 2, "onFilterApply aborted " + this.f66388d0 + i16);
            return;
        }
        if (jVar.f66709i instanceof QIMFilterCategoryItem) {
            ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setFilterId(jVar.t());
            QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) jVar.f66709i;
            ArrayList<QIMFilterCategoryItem> arrayList = this.f66389e.f66407f;
            if (arrayList == null || (indexOf = arrayList.indexOf(qIMFilterCategoryItem)) < 0) {
                return;
            }
            this.f66385a0 = false;
            if (bundle.getInt("apply_source", 2) != 1 && bundle.getInt("apply_source", 2) != com.tencent.aelight.camera.aioeditor.capture.data.d.P) {
                if (bundle.getInt("apply_source", 2) == 2 && indexOf == this.f66389e.g(this.V)) {
                    int i17 = this.V;
                    if (z16) {
                        Y(i17);
                    } else {
                        G(i17);
                    }
                }
            } else {
                this.f66386b0 = true;
                int f16 = (this.f66389e.f() * 50) + indexOf;
                if (f16 == this.V) {
                    if (z16) {
                        Y(f16);
                        this.f66386b0 = false;
                    } else {
                        G(f16);
                    }
                } else if (z16) {
                    P(indexOf);
                }
            }
            id0.a.m((Activity) getContext(), "filter_element", String.valueOf(qIMFilterCategoryItem.f66701i), qIMFilterCategoryItem.f66697d);
            if (this.G) {
                ac.a().b();
            }
        }
    }

    @Override // com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.S = true;
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).G(this);
        Handler handler = this.L;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.L.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoFilterViewPager.this.W != null) {
                        VideoFilterViewPager.this.W.cleanupModelData();
                        VideoFilterViewPager.this.W = null;
                    }
                    VideoFilterViewPager.this.T.quit();
                }
            });
            this.L = null;
        }
        D();
        SimpleGLThread simpleGLThread = this.K;
        if (simpleGLThread != null) {
            simpleGLThread.destroy();
        }
    }

    @Override // com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f66390e0 = System.currentTimeMillis();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCaptureScene(int i3) {
        this.f66388d0 = i3;
    }

    public void setIaiSubLabelReady(a aVar) {
        this.f66394m = aVar;
    }

    public void setIsNormalMode(boolean z16) {
        this.E = z16;
        if (this.F) {
            return;
        }
        this.F = true;
    }

    public void setReadyToApply(boolean z16) {
        this.f66392h = z16;
    }

    public void setSecleteCallBack(b bVar) {
        this.f66393i = bVar;
    }

    public void V() {
        m.b c16;
        m.a aVar = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I;
        if (aVar == null || (c16 = aVar.c(this.f66388d0)) == null) {
            return;
        }
        W(c16.f66517c, null);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(com.tencent.aelight.camera.aioeditor.capture.data.h hVar, boolean z16, int i3, Bundle bundle) {
        if (bundle == null) {
            QLog.e("QCombo", 1, "onComboApply aborted");
            return;
        }
        int i16 = -1;
        int i17 = bundle.getInt("capture_scene", -1);
        if (this.f66388d0 != i17) {
            QLog.e("QCombo", 2, "onComboApply aborted " + this.f66388d0 + i17);
            return;
        }
        QIMFilterCategoryItem y16 = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).y(hVar, this.f66389e.f66407f);
        ArrayList<QIMFilterCategoryItem> arrayList = this.f66389e.f66407f;
        this.f66385a0 = true;
        if (arrayList != null && (i16 = arrayList.indexOf(y16)) >= 0 && i16 != getCurrentItem()) {
            this.f66386b0 = true;
            P(i16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "vp onComboApply combo " + hVar.f66709i + " filter " + y16 + " index " + i16);
        }
    }

    public void E() {
        this.f66390e0 = 0L;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
        m.b c16;
        if (aVar == null || (c16 = aVar.c(this.f66388d0)) == null) {
            return;
        }
        V();
        int indexOf = c16.f66517c.indexOf(m.n().i(this.f66388d0));
        QLog.i("VideoFilterViewPager", 2, "onResourceDownload - update viewpagerIndex = " + indexOf + "; getCurrentItem()" + getCurrentItem());
        if (indexOf == -1 || indexOf == getCurrentItem()) {
            return;
        }
        QLog.i("VideoFilterViewPager", 2, "onResourceDownload - initialViewPagerPosition ");
        this.f66386b0 = true;
        P(indexOf);
        this.f66386b0 = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        public View f66402d;

        /* renamed from: e, reason: collision with root package name */
        public int f66403e;

        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (QLog.isDevelopLevel()) {
                QLog.d("VideoFilterViewPager", 2, "onPageScrollStateChanged state: " + i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("VideoFilterViewPager", 2, "onPageScrolled position: " + i3 + ", positionOffset: " + f16 + ", positionOffsetPixels: " + i16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            int i16;
            int i17;
            boolean z16 = System.currentTimeMillis() - VideoFilterViewPager.this.f66390e0 < 400;
            if (this.f66403e == i3) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.f66403e + ",n " + i3 + " scroll " + z16);
                }
                VideoFilterViewPager.this.f66386b0 = false;
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("VideoFilterViewPager", 2, "onPageSelected 2 " + this.f66403e + ",n" + i3 + " scroll " + z16);
            }
            if (VideoFilterViewPager.this.f66393i != null) {
                VideoFilterViewPager.this.f66393i.a(VideoFilterViewPager.this.f66389e.g(i3), VideoFilterViewPager.this.f66389e.i(i3));
            }
            com.tencent.mobileqq.activity.richmedia.d.d("", "0X8007804", "", "", "", "");
            if (z16) {
                try {
                    QIMFilterCategoryItem i18 = VideoFilterViewPager.this.f66389e.i(i3);
                    if (i18 != null) {
                        if (i3 > this.f66403e && VideoFilterViewPager.this.f66389e.f() != 0 && i3 % VideoFilterViewPager.this.f66389e.f() != 0) {
                            if (i3 != 0 && i18.l() && (i17 = i3 + 1) < VideoFilterViewPager.this.f66389e.getF373114d()) {
                                VideoFilterViewPager.this.setCurrentItem(i17, false);
                                return;
                            }
                        } else if (i18.l() && VideoFilterViewPager.this.f66389e.f() != 0 && i3 % VideoFilterViewPager.this.f66389e.f() != 0 && i3 - 1 > 0) {
                            VideoFilterViewPager.this.setCurrentItem(i16, false);
                            return;
                        }
                    }
                    if (i18 != null) {
                        com.tencent.aelight.camera.ae.report.b.b().f0(i18.f66697d, AEProviderViewModel.t2(i18));
                    }
                } catch (Exception unused) {
                }
            }
            this.f66403e = i3;
            View h16 = VideoFilterViewPager.this.f66389e.h(i3);
            if (QLog.isDevelopLevel()) {
                QLog.d("VideoFilterViewPager", 2, "onPageSelected 3 " + i3 + ",n" + i3 + " pageItem " + h16);
            }
            if (h16 == null) {
                if (!VideoFilterViewPager.this.f66392h) {
                    VideoFilterViewPager.this.f66392h = true;
                }
            } else {
                View view = this.f66402d;
                if (view != null) {
                    Runnable runnable = (Runnable) view.getTag();
                    if (runnable != null) {
                        this.f66402d.removeCallbacks(runnable);
                    }
                    this.f66402d.clearAnimation();
                }
                Runnable runnable2 = (Runnable) h16.getTag();
                if (runnable2 != null) {
                    h16.removeCallbacks(runnable2);
                    h16.setTag(null);
                }
                VideoFilterViewPager.this.Q(h16, i3, z16);
            }
            this.f66402d = h16;
            VideoFilterViewPager videoFilterViewPager = VideoFilterViewPager.this;
            videoFilterViewPager.f66386b0 = false;
            videoFilterViewPager.f66387c0 = false;
        }
    }

    private void X(final View view, QIMFilterCategoryItem qIMFilterCategoryItem, int i3) {
        TextView textView = (TextView) view.findViewById(R.id.b2w);
        TextView textView2 = (TextView) view.findViewById(R.id.b2v);
        ViewParent parent = getParent();
        RelativeLayout relativeLayout = parent instanceof RelativeLayout ? (RelativeLayout) ((RelativeLayout) parent).findViewById(R.id.efs) : null;
        boolean w3 = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).w();
        if (i3 == 1 || i3 == 2) {
            if (w3) {
                if (textView != null) {
                    textView.setText(qIMFilterCategoryItem.f66698e);
                    textView.setVisibility(8);
                }
                if (textView2 != null) {
                    textView2.setText(qIMFilterCategoryItem.N);
                    textView2.setVisibility(8);
                }
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                    QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
                }
            } else {
                if (this.f66387c0) {
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                        QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
                    }
                } else if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                    QLog.i("VideoFilterViewPager", 2, "loadingView VISIBLE");
                }
                view.setVisibility(0);
                if (textView != null) {
                    textView.setText(qIMFilterCategoryItem.f66698e);
                }
                if (textView2 != null) {
                    textView2.setText(qIMFilterCategoryItem.N);
                }
            }
        } else if (i3 != 3) {
            if (i3 == 4) {
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                    QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
                }
                view.setVisibility(8);
            }
        } else if (w3) {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (textView != null) {
                textView.setText(qIMFilterCategoryItem.f66698e);
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setText(qIMFilterCategoryItem.N);
                textView2.setVisibility(8);
            }
        } else {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            if (textView != null) {
                textView.setText(qIMFilterCategoryItem.f66698e);
            }
            if (textView2 != null) {
                textView2.setText(qIMFilterCategoryItem.N);
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.7
                @Override // java.lang.Runnable
                public void run() {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(1000L);
                    alphaAnimation.setFillAfter(true);
                    view.startAnimation(alphaAnimation);
                    alphaAnimation.setAnimationListener(new a());
                }

                /* renamed from: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager$7$a */
                /* loaded from: classes32.dex */
                class a implements Animation.AnimationListener {
                    a() {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                }
            };
            view.setVisibility(0);
            view.postDelayed(runnable, 800L);
            view.setTag(runnable);
        }
        if (!this.D || textView == null || textView2 == null) {
            return;
        }
        textView.setVisibility(8);
        textView2.setVisibility(8);
    }

    public VideoFilterViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66392h = true;
        this.E = true;
        this.F = false;
        this.G = false;
        this.R = false;
        this.S = false;
        this.U = true;
        this.V = -1;
        this.f66385a0 = false;
        this.f66386b0 = false;
        this.f66387c0 = false;
        this.f66388d0 = 0;
        this.f66390e0 = 0L;
        init();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void f(com.tencent.aelight.camera.aioeditor.capture.data.h hVar) {
    }
}

package com.tencent.mobileqq.wink.edit.manager;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQHashMap;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.sticker.sticker.RecentStickerData;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class WinkEditorResourceManager extends WinkEditorResourceDownloader {

    /* renamed from: e0, reason: collision with root package name */
    private static final String f318286e0;

    /* renamed from: f0, reason: collision with root package name */
    private static volatile WinkEditorResourceManager f318287f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final String f318288g0;
    private final u53.j A;
    private final u53.j B;
    private final MutableLiveData<List<MetaCategory>> C;
    private final MutableLiveData<CircleTemplateInfo> D;
    private final MutableLiveData<List<MetaCategory>> E;
    private final MutableLiveData<MetaCategory> F;
    private final MutableLiveData<List<MetaCategory>> G;
    private final u53.j H;
    private final u53.j I;
    private final u53.j J;
    private final u53.j K;
    private final u53.j L;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> M;
    protected volatile boolean N;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> O;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> P;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> Q;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> R;
    protected volatile boolean S;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> T;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> U;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> V;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> W;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> X;

    @NonNull
    private final Map<String, AEEditorDownloadResBean> Y;
    private final Map<String, MetaMaterial> Z;

    /* renamed from: a0, reason: collision with root package name */
    protected volatile boolean f318289a0;

    /* renamed from: b0, reason: collision with root package name */
    private final boolean f318290b0;

    /* renamed from: c0, reason: collision with root package name */
    private final int f318291c0;

    /* renamed from: d0, reason: collision with root package name */
    private ConcurrentHashMap<Integer, JSONObject> f318292d0;

    /* renamed from: j, reason: collision with root package name */
    private final u53.j f318293j;

    /* renamed from: k, reason: collision with root package name */
    private final u53.j f318294k;

    /* renamed from: l, reason: collision with root package name */
    private final u53.j f318295l;

    /* renamed from: m, reason: collision with root package name */
    private final u53.j f318296m;

    /* renamed from: n, reason: collision with root package name */
    private final u53.j f318297n;

    /* renamed from: o, reason: collision with root package name */
    private final MutableLiveData<Boolean> f318298o;

    /* renamed from: p, reason: collision with root package name */
    private final u53.j f318299p;

    /* renamed from: q, reason: collision with root package name */
    private final u53.j f318300q;

    /* renamed from: r, reason: collision with root package name */
    private final u53.j f318301r;

    /* renamed from: s, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f318302s;

    /* renamed from: t, reason: collision with root package name */
    private final u53.j f318303t;

    /* renamed from: u, reason: collision with root package name */
    private final u53.j f318304u;

    /* renamed from: v, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f318305v;

    /* renamed from: w, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f318306w;

    /* renamed from: x, reason: collision with root package name */
    private final MutableLiveData<List<RecentStickerData>> f318307x;

    /* renamed from: y, reason: collision with root package name */
    private final u53.j f318308y;

    /* renamed from: z, reason: collision with root package name */
    private final u53.j f318309z;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes21.dex */
    public @interface FontUsage {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends TypeToken<List<AEEditorDownloadResBean>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f318315a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318316b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean[] f318317c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f318318d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318319e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f318320f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f318321g;

        c(AtomicInteger atomicInteger, String str, boolean[] zArr, int i3, ResDownLoadListener resDownLoadListener, AtomicInteger atomicInteger2, int i16) {
            this.f318315a = atomicInteger;
            this.f318316b = str;
            this.f318317c = zArr;
            this.f318318d = i3;
            this.f318319e = resDownLoadListener;
            this.f318320f = atomicInteger2;
            this.f318321g = i16;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            ResDownLoadListener resDownLoadListener;
            int decrementAndGet = this.f318315a.decrementAndGet();
            ms.a.a("WinkEditorResourceManager", " downloaded font:" + this.f318316b + "," + decrementAndGet);
            boolean[] zArr = this.f318317c;
            zArr[this.f318318d] = z16;
            if (decrementAndGet == 0 && (resDownLoadListener = this.f318319e) != null) {
                resDownLoadListener.onDownloadFinish(WinkEditorResourceManager.this.L0(zArr));
                ms.a.a("WinkEditorResourceManager", " download font:" + this.f318316b);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int i3) {
            ResDownLoadListener resDownLoadListener = this.f318319e;
            if (resDownLoadListener != null) {
                resDownLoadListener.onProgressUpdate(this.f318320f.addAndGet((int) (i3 / this.f318321g)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f318323a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318324b;

        d(String str, ResDownLoadListener resDownLoadListener) {
            this.f318323a = str;
            this.f318324b = resDownLoadListener;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            ms.a.a("jumptest ", " downloaded " + this.f318323a);
            ResDownLoadListener resDownLoadListener = this.f318324b;
            if (resDownLoadListener != null) {
                resDownLoadListener.onDownloadFinish(z16);
                ms.a.a("jumptest ", " downloaded listener" + this.f318323a);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
            ResDownLoadListener resDownLoadListener = this.f318324b;
            if (resDownLoadListener != null) {
                resDownLoadListener.onProgressUpdate(i3);
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = u53.b.f438371b;
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("text");
        f318286e0 = sb5.toString();
        f318288g0 = str + str2 + AIInput.KEY_FRAME;
    }

    WinkEditorResourceManager() {
        super("winkEdit/wink_editor_download_resources.json", u53.b.f438371b, 4, "WinkEditorResourceManager");
        this.f318293j = new u53.j(MaterialType.FILTER);
        this.f318294k = new u53.j(MaterialType.AUTO_TEMPLATE);
        this.f318295l = new u53.j(MaterialType.FIRST_TEMPLATE);
        this.f318296m = new u53.j(MaterialType.PIC_RECOMMEND);
        this.f318297n = new u53.j(MaterialType.QZONE_MAGIC_STUDIO);
        this.f318298o = new MutableLiveData<>();
        this.f318299p = new u53.j(MaterialType.DAILY_SIGN_MUSIC);
        this.f318300q = new u53.j(MaterialType.OPENING_ENDING);
        this.f318301r = new u53.j(MaterialType.DAILY_SIGN_BACKGROUND);
        this.f318302s = new MutableLiveData<>();
        this.f318303t = new u53.j(MaterialType.PIC_RECOMMEND_USER_PUBLISHED);
        this.f318304u = new u53.j(MaterialType.PICK_ONLINE);
        this.f318305v = new MutableLiveData<>();
        this.f318306w = new MutableLiveData<>();
        this.f318307x = new MutableLiveData<>();
        this.f318308y = new u53.j(MaterialType.SPECIAL_EFFECT);
        this.f318309z = new u53.j(MaterialType.TEXT);
        this.A = new u53.j(MaterialType.LYRIC_STICKER);
        this.B = new u53.j(MaterialType.COVER_TEMPLATE);
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.H = new u53.j(MaterialType.MAGIC_AVATAR);
        this.I = new u53.j(MaterialType.QZONE_RECOMMEND_TEMPLATE);
        this.J = new u53.j(MaterialType.UGC_BOT);
        this.K = new u53.j(MaterialType.IMAGE_TEMPLATE);
        this.L = new u53.j(MaterialType.TEXT_FONT);
        this.M = new LinkedHashMap();
        this.N = false;
        this.O = new LinkedHashMap();
        this.P = new ConcurrentHashMap();
        this.Q = new LinkedHashMap();
        this.R = new LinkedHashMap();
        this.S = false;
        this.T = new LinkedHashMap();
        this.U = new LinkedHashMap();
        this.V = new LinkedHashMap();
        this.W = new LinkedHashMap();
        this.X = new LinkedHashMap();
        this.Y = new LinkedHashMap();
        this.Z = new QQHashMap(Business.QCircle, "WinkEditorResourceManager");
        this.f318289a0 = false;
        this.f318292d0 = new ConcurrentHashMap<>();
        this.f318291c0 = ((Integer) y53.c.b(3, 5, 7)).intValue();
        this.f318290b0 = !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101751", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2() {
        if (!new File(u53.f.f438394g, "editor_magic_avatar_template.json").exists()) {
            return;
        }
        j1().postValue(i1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2() {
        this.f318300q.postValue(n1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2() {
        List<MetaCategory> r16 = r1();
        if (!r16.isEmpty()) {
            s1().postValue(r16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2() {
        q1().postValue(p1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E2() {
        File file = new File(u53.f.f438398k, "editor_qzone_image_template.json");
        if (!file.exists()) {
            w53.b.f("WinkEditorResourceManager", "loadQzoneImageTemplateList. File not exist: " + file);
            return;
        }
        this.K.postValue(z1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(List list) {
        this.f318297n.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2() {
        if (!new File(u53.f.f438395h, "editor_qzone_magic_studio_template.json").exists()) {
            return;
        }
        final List<MetaCategory> B1 = B1();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.v
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.F2(B1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2() {
        if (!new File(u53.f.C, "qzone_auto_template_recommend.json").exists()) {
            return;
        }
        List<MetaCategory> Q1 = Q1();
        if (Q1 != null) {
            w53.b.f("WinkEditorResourceManager", "loadRecommendTemplateList." + Q1.size());
        }
        w1().postValue(Q1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2() {
        G1().postValue(E1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2() {
        this.f318309z.postValue(S1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2() {
        this.L.postValue(W1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L0(boolean[] zArr) {
        for (boolean z16 : zArr) {
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2() {
        if (!new File(u53.f.f438397j, "editor_ugc_bot_template.json").exists()) {
            return;
        }
        e2().postValue(d2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2() {
        List<MetaCategory> f26 = f2();
        if (!f26.isEmpty()) {
            g2().postValue(f26);
        }
    }

    private AEEditorDownloadResBean O1(String str) {
        q0();
        Map<String, AEEditorDownloadResBean> map = this.Y;
        if (map != null && map.get(str) != null) {
            return this.Y.get(str);
        }
        w53.b.a("[getTemplateLibraryMaterial] null or empty", this.Y + "");
        return null;
    }

    private void R2() {
        T2(this.f318301r, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.u
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.t2();
            }
        });
    }

    private void S2() {
        T2(this.f318299p, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.t
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.u2();
            }
        });
    }

    private void T2(MutableLiveData mutableLiveData, @androidx.annotation.NonNull Runnable runnable) {
        String name = MaterialType.NULL.name();
        if (mutableLiveData instanceof u53.j) {
            name = ((u53.j) mutableLiveData).f438434d.name();
        }
        w53.b.a("WinkEditorResourceManager", "loadEditorMaterial type:" + name + ", hasActiveObservers:" + mutableLiveData.hasActiveObservers() + " ...");
        if (mutableLiveData.hasActiveObservers()) {
            a3(runnable);
        }
    }

    public static WinkEditorResourceManager a1() {
        if (f318287f0 == null) {
            synchronized (WinkEditorResourceManager.class) {
                if (f318287f0 == null) {
                    f318287f0 = new WinkEditorResourceManager();
                }
            }
        }
        return f318287f0;
    }

    private void e0(String[] strArr, ResDownLoadListener resDownLoadListener) {
        AtomicInteger atomicInteger;
        int i3;
        boolean z16;
        String[] strArr2 = strArr;
        ResDownLoadListener resDownLoadListener2 = resDownLoadListener;
        int length = strArr2.length;
        AtomicInteger atomicInteger2 = new AtomicInteger(length);
        boolean[] zArr = new boolean[length];
        o0();
        p0();
        boolean z17 = false;
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        int i16 = 0;
        while (i16 < length) {
            String trim = strArr2[i16].trim();
            ms.a.a("WinkEditorResourceManager", " check font " + trim);
            if (m2(trim, 1)) {
                int decrementAndGet = atomicInteger2.decrementAndGet();
                ms.a.a("WinkEditorResourceManager", " exist font:" + trim + "," + decrementAndGet);
                if (resDownLoadListener2 != null) {
                    resDownLoadListener2.onProgressUpdate(atomicInteger3.addAndGet((int) (100.0f / length)));
                }
                zArr[i16] = true;
                if (decrementAndGet == 0 && resDownLoadListener2 != null) {
                    resDownLoadListener2.onDownloadFinish(L0(zArr));
                    ms.a.a("WinkEditorResourceManager", " download exist font:" + trim);
                }
                i3 = i16;
                z16 = z17;
                atomicInteger = atomicInteger2;
            } else {
                ms.a.a("WinkEditorResourceManager", " start download font:" + trim);
                atomicInteger = atomicInteger2;
                i3 = i16;
                z16 = z17;
                if (!q3(1, trim, new c(atomicInteger2, trim, zArr, i16, resDownLoadListener, atomicInteger3, length))) {
                    zArr[i3] = z16;
                }
            }
            i16 = i3 + 1;
            strArr2 = strArr;
            resDownLoadListener2 = resDownLoadListener;
            atomicInteger2 = atomicInteger;
            z17 = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void k2() {
        List<MetaCategory> v06 = v0();
        MetaCategory e16 = h.d().e();
        if (e16 != null) {
            v06.add(0, e16);
        }
        WinkMaterialRedDotManager.f326249a.i(v06);
        h2().postValue(v06);
    }

    private boolean m2(String str, int i3) {
        AEEditorDownloadResBean O1;
        if (i3 != 1) {
            if (i3 != 2 || (O1 = O1(str)) == null || !r(O1)) {
                return false;
            }
            return true;
        }
        AEEditorDownloadResBean V0 = V0(str);
        if (V0 == null || !r(V0)) {
            return false;
        }
        return true;
    }

    @WorkerThread
    private void n0() {
        String str = u53.f.f438404q;
        l0(str, "editor_filter_update_template.json", "winkEdit/wink_editor_display_effects.json", this.T, AEEditorDownloadResBean.RES_TYPE_FILTER);
        l0(str, "editor_text_sticker_update_template.json", "winkEdit/wink_editor_text_stickers_default.json", this.W, AEEditorDownloadResBean.RES_TYPE_OTHER);
        String str2 = u53.f.f438405r;
        l0(str2, "editor_text_update_template.json", "winkEdit/wink_editor_text.json", t1(), AEEditorDownloadResBean.RES_TYPE_OTHER);
        l0(str2, "editor_auto_template_update_template.json", "winkEdit/wink_editor_auto_template.json", this.X, AEEditorDownloadResBean.RES_TYPE_OTHER);
        l0(u53.f.f438409v, "editor_lyric_stickers_update_template.json", "winkEdit/wink_editor_wink_lyrics_default.json", this.Q, AEEditorDownloadResBean.RES_TYPE_OTHER);
        l0(u53.f.f438410w, "cover_template.json", "winkEdit/wink_cover_template_default.json", this.R, AEEditorDownloadResBean.RES_TYPE_OTHER);
    }

    @WorkerThread
    private void o0() {
        Object valueOf;
        if (this.f318290b0) {
            WinkTextFontManager.INSTANCE.a().o();
            return;
        }
        synchronized (this.M) {
            if (this.N) {
                return;
            }
            this.N = true;
            String x16 = x("winkEdit/wink_editor_base_fonts.json");
            if (TextUtils.isEmpty(x16)) {
                w53.b.c(this.f318259d, "ensureSetupFontConfigMap---read assets json content empty");
                return;
            }
            List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(x16, new a().getType());
            String str = this.f318259d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ensureSetupFontConfigMap---size = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            w53.b.f(str, sb5.toString());
            if (list != null) {
                for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                    this.M.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    @WorkerThread
    private void p0() {
        Object valueOf;
        synchronized (this.P) {
            if (this.S) {
                w53.b.f(this.f318259d, "already ensure config qcircleFontConfigMap");
                return;
            }
            this.S = true;
            List<MetaCategory> S1 = a1().S1();
            String str = this.f318259d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ensureSetupQCircleFontConfigMap---size = ");
            if (S1 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(S1.size());
            }
            sb5.append(valueOf);
            w53.b.f(str, sb5.toString());
            Iterator<MetaCategory> it = S1.iterator();
            while (it.hasNext()) {
                Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next = it5.next();
                    AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                    aEEditorDownloadResBean.setId(next.f30533id);
                    aEEditorDownloadResBean.setUrl(next.packageUrl);
                    aEEditorDownloadResBean.setMd5(next.packageMd5);
                    String str2 = next.additionalFields.get("preDownload");
                    if (!TextUtils.isEmpty(str2)) {
                        aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str2));
                    }
                    this.P.put(next.f30533id, aEEditorDownloadResBean);
                }
            }
        }
    }

    @WorkerThread
    private synchronized void q0() {
        if (this.f318289a0) {
            return;
        }
        List<MetaCategory> f16 = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.f();
        QLog.d("WinkEditorResourceManager", 1, "allGroups = " + f16);
        MetaCategory s06 = s0(f16);
        if (s06 != null) {
            this.f318289a0 = true;
            QLog.d("WinkEditorResourceManager", 1, "\u62c9\u53d6\u7684\u6a21\u7248\u4fe1\u606f\uff1a sysCategory = " + s06);
            Iterator<MetaCategory> it = f16.iterator();
            while (it.hasNext()) {
                u3(it.next());
            }
            return;
        }
        ms.a.a("WinkEditorResourceManager", "sysCategory == null");
    }

    private boolean q3(int i3, String str, ResDownLoadListener resDownLoadListener) {
        AEEditorDownloadResBean V0;
        if (i3 != 1) {
            if (i3 != 2) {
                V0 = null;
            } else {
                q0();
                V0 = O1(str);
            }
        } else {
            V0 = V0(str);
        }
        if (V0 != null) {
            ms.a.a("jumptest ", "start download " + V0.getId());
            h(V0, new d(str, resDownLoadListener));
        } else {
            ms.a.f("WinkEditorResourceManager", "id not exist");
            this.S = false;
            if (resDownLoadListener != null) {
                resDownLoadListener.onDownloadFinish(false);
            }
        }
        if (V0 != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void r0() {
        String str = f318286e0;
        new File(str);
        com.tencent.open.base.c.a(com.tencent.mobileqq.wink.b.c(), "wink/pag", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2() {
        x0().postValue(w0());
    }

    private MetaCategory s0(List<MetaCategory> list) {
        if (list != null && !list.isEmpty()) {
            for (MetaCategory metaCategory : list) {
                if (HippyQQConstants.HIPPY_CHANNEL.equals(metaCategory.f30532id)) {
                    return metaCategory;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2() {
        E0().postValue(F0());
    }

    @Nullable
    private String t0(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean) {
        String str = n(aEEditorDownloadResBean) + File.separator + aEEditorDownloadResBean.getId();
        if (new File(str).exists()) {
            return str;
        }
        String str2 = str + ".ttf";
        if (new File(str2).exists()) {
            return str2;
        }
        String str3 = str + ".otf";
        if (new File(str3).exists()) {
            return str3;
        }
        return null;
    }

    private Map<String, AEEditorDownloadResBean> t1() {
        if (this.f318290b0) {
            return WinkTextFontManager.INSTANCE.a().x();
        }
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2() {
        G0().postValue(H0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2() {
        K0().postValue(J0());
    }

    private void u3(MetaCategory metaCategory) {
        String str;
        Iterator<MetaMaterial> it = metaCategory.materials.iterator();
        while (it.hasNext()) {
            MetaMaterial next = it.next();
            AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
            aEEditorDownloadResBean.setId(next.f30533id);
            aEEditorDownloadResBean.setUrl(next.packageUrl);
            aEEditorDownloadResBean.setMd5(next.packageMd5);
            Map<String, String> map = next.additionalFields;
            if (map != null) {
                str = map.get("preDownload");
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str));
            }
            this.Y.put(next.f30533id, aEEditorDownloadResBean);
            this.Z.put(next.f30533id, next);
        }
        ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<MetaCategory> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                u3(it5.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2() {
        this.f318308y.postValue(M0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2() {
        this.f318293j.postValue(P0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2() {
        S0().postValue(R0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(String str) {
        e1().postValue(d1(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2() {
        h1().postValue(g1());
    }

    public String A0(@NonNull MetaMaterial metaMaterial) {
        return m(metaMaterial) + File.separator + "blur_texture.png";
    }

    public MutableLiveData<List<MetaCategory>> A1() {
        return this.K;
    }

    public String B0(@NonNull MetaMaterial metaMaterial) {
        return C0(m(metaMaterial));
    }

    public List<MetaCategory> B1() {
        return h.d().l(u53.f.f438395h, "editor_qzone_magic_studio_template.json", "", false);
    }

    public String C0(@NonNull String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("bottom");
        sb5.append(str2);
        sb5.append("main.pag");
        return sb5.toString();
    }

    public MutableLiveData<List<MetaCategory>> C1() {
        return this.f318297n;
    }

    public String D0() {
        return f318286e0 + File.separator + "chinese_english_subtitle.pag";
    }

    public MutableLiveData<List<RecentStickerData>> D1() {
        return this.f318307x;
    }

    public MutableLiveData<List<MetaCategory>> E0() {
        return this.B;
    }

    public List<MetaCategory> E1() {
        return F1();
    }

    public List<MetaCategory> F0() {
        return h.d().l(u53.f.f438410w, "cover_template.json", "winkEdit/wink_cover_template_default.json", false);
    }

    public List<MetaCategory> F1() {
        return h.d().l(u53.f.A, "editor_red_packet_template.json", "", false);
    }

    public MutableLiveData<List<MetaCategory>> G0() {
        return this.f318301r;
    }

    public MutableLiveData<List<MetaCategory>> G1() {
        return this.G;
    }

    public List<MetaCategory> H0() {
        return h.d().l(u53.f.f438396i, "editor_daily_sign_background_template.json", "", false);
    }

    public ArrayList<MetaCategory> H1() {
        return h.d().l(u53.f.f438389b, "editor_text_sticker_update_template.json", "winkEdit/wink_editor_text_stickers_default.json", false);
    }

    public List<MetaCategory> I0() {
        return h.d().l(u53.f.f438396i, "editor_daily_sign_mood_template.json", "", false);
    }

    public MutableLiveData<List<MetaCategory>> I1() {
        return this.f318305v;
    }

    public List<MetaCategory> J0() {
        return h.d().l(u53.f.f438396i, "editor_daily_sign_music_template.json", "", false);
    }

    public MutableLiveData<List<MetaCategory>> J1() {
        return this.f318306w;
    }

    public MutableLiveData<List<MetaCategory>> K0() {
        return this.f318299p;
    }

    public String K1() {
        return f318286e0 + File.separator + "subtitle_main.pag";
    }

    public String L1() {
        return f318286e0 + File.separator + "icon_share_qcircle.pag";
    }

    public List<MetaCategory> M0() {
        return h.d().l(u53.f.f438390c, "editor_special_effect_update_template.json", "winkEdit/wink_editor_special_effects_default.json", false);
    }

    public MutableLiveData<CircleTemplateInfo> M1() {
        return this.D;
    }

    public MutableLiveData<List<MetaCategory>> N0() {
        return this.f318308y;
    }

    public List<MetaCategory> N1() {
        return h.d().l(u53.f.f438406s, "editor_template_library.json", "winkEdit/wink_template_library.json", false);
    }

    public void N2() {
        w53.b.f(this.f318259d, "loadAssets");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.5
            @Override // java.lang.Runnable
            public void run() {
                WinkEditorResourceManager.this.r0();
                String str = WinkEditorResourceManager.this.f318257b + File.separator + ".nomedia";
                if (!new File(str).exists()) {
                    try {
                        FileUtils.createFile(str);
                    } catch (IOException e16) {
                        w53.b.d(WinkEditorResourceManager.this.f318259d, "loadAssets", e16);
                    }
                }
            }
        }, 64, null, true);
    }

    public String O0(MetaMaterial metaMaterial) {
        return m(metaMaterial) + File.separator + "effectInfo.json";
    }

    public void O2() {
        w53.b.a("WinkEditorResourceManager", "loadBackgroundTemplate...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.x
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorResourceManager.this.r2();
                }
            }, 64, null, true);
        } else {
            x0().postValue(w0());
        }
    }

    public List<MetaCategory> P0() {
        return h.d().l(u53.f.f438404q, "editor_filter_update_template.json", "winkEdit/wink_editor_display_effects.json", false);
    }

    public synchronized MetaMaterial P1(String str) {
        q0();
        w53.b.a("WinkEditorResourceManager", "[getTemplateLibraryMaterialById] size:" + this.Z.size() + ", contains " + str + " :" + this.Z.containsKey(str));
        return this.Z.get(str);
    }

    public void P2() {
        T2(this.B, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.af
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.s2();
            }
        });
    }

    public MutableLiveData<List<MetaCategory>> Q0() {
        return this.f318293j;
    }

    public List<MetaCategory> Q1() {
        return h.d().l(u53.f.C, "qzone_auto_template_recommend.json", "winkEdit/qzone_editor_auto_template.json", false);
    }

    public void Q2(String str) {
        if (str.equals("music")) {
            S2();
        } else if (str.equals("background")) {
            R2();
        }
    }

    public List<MetaCategory> R0() {
        return h.d().l(u53.f.f438392e, "editor_first_template_update_template.json", "", false);
    }

    public ArrayList<String> R1() {
        String[] split;
        String g16 = AECameraPrefsUtil.c().g(AECameraPrefsUtil.f318482t, null, 4);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0, AECameraPrefsUtil.f318480r);
        if (g16 != null && !g16.isEmpty() && (split = g16.split(AECameraPrefsUtil.f318481s)) != null && split.length > 0 && !split[0].isEmpty()) {
            arrayList.addAll(1, Arrays.asList(split));
        }
        return arrayList;
    }

    public MutableLiveData<List<MetaCategory>> S0() {
        return this.f318295l;
    }

    public List<MetaCategory> S1() {
        return h.d().l(u53.f.f438405r, "editor_text_update_template.json", "winkEdit/wink_editor_text.json", false);
    }

    @Nullable
    public String[] T0(MetaMaterial metaMaterial) {
        Map<String, String> map;
        if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
            String str = map.get("fontID");
            ms.a.a("WinkEditorResourceManager", "" + metaMaterial.f30533id + ", has font" + str);
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                HashSet hashSet = new HashSet();
                Collections.addAll(hashSet, split);
                return (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }
        return null;
    }

    public String T1(String str) {
        return str + File.separator + IVideoFilterTools.CONFIG_FILE;
    }

    @Nullable
    public String U0(String str, int i3) {
        if (this.f318290b0) {
            return WinkTextFontManager.INSTANCE.a().u(str, i3);
        }
        return (String) v3(str, i3).first;
    }

    public String U1() {
        return f318286e0 + File.separator + IVideoFilterTools.CONFIG_FILE;
    }

    public void U2() {
        T2(this.f318308y, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.n
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.v2();
            }
        });
    }

    public AEEditorDownloadResBean V0(String str) {
        Map<String, AEEditorDownloadResBean> map = this.M;
        if (map != null && map.get(str) != null) {
            return this.M.get(str);
        }
        Map<String, AEEditorDownloadResBean> map2 = this.P;
        if (map2 != null && map2.get(str) != null) {
            return this.P.get(str);
        }
        return null;
    }

    public String V1() {
        return f318286e0 + File.separator + "main.pag";
    }

    public void V2() {
        T2(this.f318293j, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.aj
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.w2();
            }
        });
    }

    @Nullable
    public AEEditorDownloadResBean W0(@NonNull String str) {
        if (this.f318290b0) {
            return WinkTextFontManager.INSTANCE.a().w(str);
        }
        o0();
        p0();
        return V0(str);
    }

    public List<MetaCategory> W1() {
        return h.d().l(u53.f.f438405r, "editor_text_font.json", "winkEdit/wink_editor_text.json", false);
    }

    public void W2() {
        T2(this.f318295l, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.s
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.x2();
            }
        });
    }

    public String X0(MetaMaterial metaMaterial) {
        return m(metaMaterial) + File.separator + TemplateBean.TEMPLATE_JSON;
    }

    public MutableLiveData<List<MetaCategory>> X1() {
        return this.f318309z;
    }

    public void X2(final String str) {
        w53.b.a("WinkEditorResourceManager", "loadLowThresholdTemplateMaterial...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.w
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorResourceManager.this.y2(str);
                }
            }, 64, null, true);
        } else {
            e1().postValue(d1(str));
        }
    }

    public MutableLiveData<MetaCategory> Y0() {
        return this.F;
    }

    public String Y1(@NonNull MetaMaterial metaMaterial, String str) {
        return m(metaMaterial) + File.separator + str;
    }

    public void Y2() {
        T2(this.A, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.o
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.z2();
            }
        });
    }

    public JSONArray Z0() {
        if (this.f318292d0.isEmpty()) {
            w53.b.a("WinkEditorResourceManager", "getInspirationAIData is null");
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.f318292d0.size(); i3++) {
            jSONArray.mo162put(this.f318292d0.get(Integer.valueOf(i3)));
        }
        w53.b.a("WinkEditorResourceManager", "getInspirationAIData: " + jSONArray);
        return jSONArray;
    }

    public String Z1(@NonNull MetaMaterial metaMaterial) {
        return a2(m(metaMaterial));
    }

    public void Z2() {
        T2(this.H, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ae
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.A2();
            }
        });
    }

    public String a2(String str) {
        return str + File.separator + "main.pag";
    }

    public void a3(@androidx.annotation.NonNull Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.e(new com.tencent.mobileqq.qcoroutine.api.g("Wink_LoadMaterialAsync", i.d.f261782e, runnable));
        } else {
            runnable.run();
        }
    }

    public synchronized MetaMaterial b1(String str) {
        q0();
        for (MetaMaterial metaMaterial : this.Z.values()) {
            if (!metaMaterial.packageMd5.isEmpty() && str.contains(metaMaterial.packageMd5)) {
                return metaMaterial;
            }
        }
        return null;
    }

    public String b2(@NonNull MetaMaterial metaMaterial) {
        return c2(m(metaMaterial));
    }

    public void b3() {
        w53.b.a("WinkEditorResourceManager", "loadMemoryAlbumList...");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.6
            @Override // java.lang.Runnable
            public void run() {
                WinkEditorResourceManager.this.l1().postValue(WinkEditorResourceManager.this.k1());
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(runnable, 64, null, true);
        } else {
            runnable.run();
        }
    }

    public String c1() {
        return f318286e0 + File.separator + "editor_loading_img_wezone.pag";
    }

    public String c2(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("top");
        sb5.append(str2);
        sb5.append("main.pag");
        return sb5.toString();
    }

    public void c3() {
        T2(this.f318300q, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ab
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.B2();
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader
    protected void d(@NonNull List<AEEditorDownloadResBean> list) {
        n0();
        for (AEEditorDownloadResBean aEEditorDownloadResBean : new LinkedHashMap(this.T).values()) {
            if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !r(aEEditorDownloadResBean)) {
                list.add(aEEditorDownloadResBean);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean2 : new LinkedHashMap(this.U).values()) {
            if (aEEditorDownloadResBean2 != null && aEEditorDownloadResBean2.getPreDownload() == 1 && !r(aEEditorDownloadResBean2)) {
                list.add(aEEditorDownloadResBean2);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean3 : new LinkedHashMap(this.V).values()) {
            if (aEEditorDownloadResBean3 != null && aEEditorDownloadResBean3.getPreDownload() == 1 && !r(aEEditorDownloadResBean3)) {
                list.add(aEEditorDownloadResBean3);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean4 : new LinkedHashMap(this.X).values()) {
            if (aEEditorDownloadResBean4 != null && aEEditorDownloadResBean4.getPreDownload() == 1 && !r(aEEditorDownloadResBean4)) {
                list.add(aEEditorDownloadResBean4);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean5 : new LinkedHashMap(this.R).values()) {
            if (aEEditorDownloadResBean5 != null && aEEditorDownloadResBean5.getPreDownload() == 1 && !r(aEEditorDownloadResBean5)) {
                list.add(aEEditorDownloadResBean5);
            }
        }
    }

    public List<MetaCategory> d1(String str) {
        if (str.equals("10012")) {
            return h.d().l(u53.f.f438401n, "editor_avatar_update_template.json", "", false);
        }
        if (str.equals("10013")) {
            return h.d().l(u53.f.f438401n, "editor_low_threshold_update_template.json", "", false);
        }
        if (str.equals("muban")) {
            return h.d().l(u53.f.f438396i, "editor_daily_sign_muban_template.json", "", false);
        }
        if (str.equals(HippyQQConstants.HIPPY_CHANNEL)) {
            return h.d().l(u53.f.C, "qzone_auto_template_recommend.json", "winkEdit/qzone_editor_auto_template.json", false);
        }
        return null;
    }

    public List<MetaCategory> d2() {
        return h.d().l(u53.f.f438397j, "editor_ugc_bot_template.json", "", false);
    }

    public void d3() {
        T2(this.f318296m, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ag
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.C2();
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader
    protected void e(@NonNull List<AEEditorDownloadResBean> list) {
        for (AEEditorDownloadResBean aEEditorDownloadResBean : this.W.values()) {
            if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !r(aEEditorDownloadResBean)) {
                list.add(aEEditorDownloadResBean);
            }
        }
        if (this.f318290b0) {
            WinkTextFontManager.INSTANCE.a().g(list);
            return;
        }
        o0();
        for (AEEditorDownloadResBean aEEditorDownloadResBean2 : this.M.values()) {
            if (aEEditorDownloadResBean2 != null && aEEditorDownloadResBean2.getPreDownload() == 1 && !r(aEEditorDownloadResBean2)) {
                list.add(aEEditorDownloadResBean2);
            }
        }
        p0();
        for (AEEditorDownloadResBean aEEditorDownloadResBean3 : this.P.values()) {
            if (aEEditorDownloadResBean3 != null && aEEditorDownloadResBean3.getPreDownload() == 1 && !r(aEEditorDownloadResBean3)) {
                list.add(aEEditorDownloadResBean3);
            }
        }
    }

    public MutableLiveData<List<MetaCategory>> e1() {
        return this.E;
    }

    public MutableLiveData<List<MetaCategory>> e2() {
        return this.J;
    }

    public void e3() {
        T2(this.f318304u, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.q
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.D2();
            }
        });
    }

    public void f0(@Nullable MetaMaterial metaMaterial, ResDownLoadListener resDownLoadListener) {
        ms.a.a("WinkEditorResourceManager", "checkAndDownloadTemplate" + metaMaterial);
        if (metaMaterial != null) {
            String str = metaMaterial.f30533id;
            ms.a.a("WinkEditorResourceManager", "checkAndDownloadTemplate template id:" + str);
            if (s(metaMaterial)) {
                ms.a.a("WinkEditorResourceManager", "checkAndDownloadTemplate: exist " + str);
                h0(metaMaterial, resDownLoadListener);
                return;
            }
            ms.a.a("WinkEditorResourceManager", "checkAndDownloadTemplate: downloaded not exist " + str);
            if (!NetworkUtil.isNetSupport(null)) {
                resDownLoadListener.onDownloadFinish(false);
                return;
            } else {
                j(metaMaterial, new b(str, metaMaterial, resDownLoadListener));
                return;
            }
        }
        if (resDownLoadListener != null) {
            resDownLoadListener.onDownloadFinish(false);
        }
    }

    public String f1(MetaMaterial metaMaterial) {
        String l3 = com.tencent.mobileqq.wink.editor.filter.f.l(metaMaterial);
        if (l3.isEmpty()) {
            return null;
        }
        k();
        AEEditorDownloadResBean aEEditorDownloadResBean = this.f318260e.get(l3);
        if (Looper.getMainLooper() != Looper.myLooper() && this.T.isEmpty()) {
            l0(u53.f.f438404q, "editor_filter_update_template.json", "winkEdit/wink_editor_display_effects.json", this.T, AEEditorDownloadResBean.RES_TYPE_FILTER);
        }
        if (aEEditorDownloadResBean == null) {
            AEEditorDownloadResBean aEEditorDownloadResBean2 = this.T.get(l3);
            if (aEEditorDownloadResBean2 == null) {
                return null;
            }
            return n(aEEditorDownloadResBean2) + File.separator + l3 + ".png";
        }
        return n(aEEditorDownloadResBean) + File.separator + l3 + ".png";
    }

    public List<MetaCategory> f2() {
        return h.d().l(u53.f.f438402o, "editor_pic_recommend_user_published_update_template.json", "", false);
    }

    public void f3() {
        w53.b.f("WinkEditorResourceManager", "loadQzoneImageTemplateList.");
        T2(this.K, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ai
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.E2();
            }
        });
    }

    public synchronized void g0(String str, ResDownLoadListener resDownLoadListener) {
        q0();
        f0(this.Z.get(str), resDownLoadListener);
    }

    public List<MetaCategory> g1() {
        return h.d().l(u53.f.f438409v, "editor_lyric_stickers_update_template.json", "winkEdit/wink_editor_wink_lyrics_default.json", false);
    }

    public MutableLiveData<List<MetaCategory>> g2() {
        return this.f318303t;
    }

    public void g3() {
        T2(this.f318297n, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.y
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.G2();
            }
        });
    }

    public void h0(MetaMaterial metaMaterial, ResDownLoadListener resDownLoadListener) {
        if (this.f318290b0) {
            WinkTextFontManager.INSTANCE.a().i(metaMaterial, resDownLoadListener);
            return;
        }
        String[] T0 = T0(metaMaterial);
        if (T0 != null && T0.length > 0) {
            e0(T0, resDownLoadListener);
        } else {
            resDownLoadListener.onDownloadFinish(true);
        }
    }

    public MutableLiveData<List<MetaCategory>> h1() {
        return this.A;
    }

    public MutableLiveData<List<MetaCategory>> h2() {
        return this.f318294k;
    }

    public void h3() {
        T2(this.I, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.aa
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.H2();
            }
        });
    }

    public void i0(MetaMaterial metaMaterial) {
        String[] T0;
        if (this.f318290b0) {
            WinkTextFontManager.INSTANCE.a().j(metaMaterial);
            return;
        }
        if (metaMaterial == null || (T0 = T0(metaMaterial)) == null) {
            return;
        }
        ms.a.a("WinkEditorResourceManager", "checkAndRegisterTemplateFont size:" + T0.length);
        for (int i3 = 0; i3 < T0.length; i3++) {
            String U0 = U0(T0[i3], 0);
            ms.a.a("WinkEditorResourceManager", "checkAndRegisterTemplateFont :" + U0 + "," + com.tencent.mobileqq.wink.utils.w.e().b(U0, T0[i3]));
        }
    }

    public List<MetaCategory> i1() {
        return h.d().l(u53.f.f438394g, "editor_magic_avatar_template.json", "", false);
    }

    public String i2(@NonNull MetaMaterial metaMaterial) {
        if (Objects.equals(metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY), QQWinkConstants.BUSINESS_ZSHOW_NAME)) {
            return metaMaterial.additionalFields.get(QQWinkConstants.EDITOR_LOCAL_TEMPLATE_PATH);
        }
        return m(metaMaterial) + File.separator + TemplateBean.TEMPLATE_JSON;
    }

    public void i3() {
        w53.b.a("WinkEditorResourceManager", "loadRedPacketTemplate...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.p
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorResourceManager.this.I2();
                }
            }, 64, null, true);
        } else {
            G1().postValue(E1());
        }
    }

    public void j0(String str) {
        i0(P1(str));
    }

    public MutableLiveData<List<MetaCategory>> j1() {
        return this.H;
    }

    public void j2(int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("index", i16);
                jSONObject.put("datas", new JSONArray());
            } catch (JSONException e16) {
                w53.b.c("WinkEditorResourceManager", "initInspirationAIDataMap error: " + e16.getMessage());
            }
        }
    }

    public void j3() {
        WinkEditorStickerResourceManager.f318326a.l(false);
    }

    public boolean k0(@NonNull String str) {
        synchronized (this.O) {
            boolean z16 = false;
            if (this.O.get(str) != null) {
                return false;
            }
            if (this.O.size() >= this.f318291c0) {
                z16 = true;
            }
            return z16;
        }
    }

    public List<MetaCategory> k1() {
        return h.d().l(u53.f.f438399l, "editor_memory_album_config_template.json", "", false);
    }

    public void k3() {
        WinkEditorStickerResourceManager.f318326a.l(true);
    }

    public void l0(String str, String str2, String str3, Map<String, AEEditorDownloadResBean> map, String str4) {
        w53.b.a(this.f318259d, "checkNeedDownload... json:" + str2 + " defaultJson:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (map) {
            ArrayList<MetaCategory> l3 = h.d().l(str, str2, str3, true);
            if (l3 != null && l3.size() != 0) {
                map.clear();
                w53.b.a(this.f318259d, "checkNeedDownload... groupList size:" + l3.size());
                Iterator<MetaCategory> it = l3.iterator();
                while (it.hasNext()) {
                    Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                    while (it5.hasNext()) {
                        MetaMaterial next = it5.next();
                        AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                        aEEditorDownloadResBean.setId(next.f30533id);
                        aEEditorDownloadResBean.setUrl(next.packageUrl);
                        aEEditorDownloadResBean.setMd5(next.packageMd5);
                        aEEditorDownloadResBean.setResType(str4);
                        Map<String, String> map2 = next.additionalFields;
                        if (map2 != null) {
                            String str5 = map2.get("preDownload");
                            if (!TextUtils.isEmpty(str5)) {
                                aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str5));
                            }
                        }
                        map.put(next.f30533id, aEEditorDownloadResBean);
                    }
                }
                w53.b.a(this.f318259d, "checkNeedDownload... cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            w53.b.c(this.f318259d, "checkNeedDownload... groupList is empty.");
        }
    }

    public MutableLiveData<List<MetaCategory>> l1() {
        return this.f318302s;
    }

    public boolean l2(String str) {
        List<MetaCategory> k16;
        if (str.equals("XsjRemberTemplate") && (k16 = a1().k1()) != null && !k16.isEmpty()) {
            return true;
        }
        return false;
    }

    public void l3() {
        T2(this.f318309z, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.r
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.J2();
            }
        });
    }

    public void m0() {
        this.f318289a0 = false;
        Map<String, AEEditorDownloadResBean> map = this.Y;
        if (map != null) {
            map.clear();
        }
        Map<String, MetaMaterial> map2 = this.Z;
        if (map2 != null) {
            map2.clear();
        }
    }

    public ArrayList<MetaMaterial> m1(ArrayList<MetaMaterial> arrayList) {
        ArrayList<MetaMaterial> f16 = h.d().f();
        ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
        if (f16 != null) {
            if (arrayList != null && arrayList.size() > 1) {
                arrayList2.add(arrayList.get(0));
                arrayList2.add(arrayList.get(1));
            }
            arrayList2.addAll(f16);
        }
        return arrayList2;
    }

    public void m3() {
        T2(this.L, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ad
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.K2();
            }
        });
    }

    public List<MetaCategory> n1() {
        return h.d().l(u53.f.f438400m, "editor_opening_ending_template.json", "", false);
    }

    public boolean n2(MetaMaterial metaMaterial) {
        if (!q(metaMaterial)) {
            return false;
        }
        List<String> f16 = j73.a.f409615a.f(metaMaterial);
        for (int i3 = 0; i3 < f16.size(); i3++) {
            AEResInfo aEResInfo = j73.a.f409615a.h().get(f16.get(i3));
            if (aEResInfo == null || !((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                return false;
            }
        }
        return true;
    }

    public void n3() {
        T2(this.J, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.z
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.L2();
            }
        });
    }

    public MutableLiveData<List<MetaCategory>> o1() {
        return this.f318300q;
    }

    public boolean o2(MetaMaterial metaMaterial) {
        if (this.f318290b0) {
            return WinkTextFontManager.INSTANCE.a().z(metaMaterial);
        }
        if (metaMaterial == null) {
            return false;
        }
        String[] T0 = T0(metaMaterial);
        if (T0 == null) {
            return true;
        }
        for (String str : T0) {
            if (!m2(str, 1)) {
                w53.b.a("WinkEditorResourceManager", "[isTemplateFontExist] font not exist" + str);
                return false;
            }
        }
        return true;
    }

    public void o3() {
        T2(this.f318303t, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ac
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.M2();
            }
        });
    }

    public List<MetaCategory> p1() {
        return h.d().l(u53.f.f438403p, "editor_pic_online_material.json", "", false);
    }

    public boolean p2() {
        q0();
        w53.b.a("WinkEditorResourceManager", "[isTemplateLibraryConfigReady] " + this.f318289a0);
        return this.f318289a0;
    }

    public void p3() {
        T2(this.f318294k, new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ah
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorResourceManager.this.k2();
            }
        });
    }

    public MutableLiveData<List<MetaCategory>> q1() {
        return this.f318304u;
    }

    public synchronized boolean q2(String str) {
        q0();
        MetaMaterial metaMaterial = this.Z.get(str);
        if (metaMaterial == null) {
            return false;
        }
        if (!m2(str, 2)) {
            w53.b.a("WinkEditorResourceManager", "[isTemplateAndFontExist] template not exist" + str);
            return false;
        }
        return o2(metaMaterial);
    }

    public List<MetaCategory> r1() {
        return h.d().l(u53.f.f438393f, "editor_pic_recommend_update_template.json", "", false);
    }

    public void r3() {
        w53.b.a("WinkEditorResourceManager", "resetInspirationAIData");
        this.f318292d0.clear();
    }

    public MutableLiveData<List<MetaCategory>> s1() {
        return this.f318296m;
    }

    public void s3(int i3, Object obj) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject = this.f318292d0.get(Integer.valueOf(i3));
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                jSONObject.put("index", i3);
                jSONObject.put("datas", new JSONArray());
                this.f318292d0.put(Integer.valueOf(i3), jSONObject);
            }
            if (jSONObject.has("datas")) {
                jSONArray = jSONObject.getJSONArray("datas");
            } else {
                jSONArray = null;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                jSONObject.put("datas", jSONArray);
            }
            jSONArray.mo162put(obj);
        } catch (JSONException e16) {
            w53.b.c("WinkEditorResourceManager", "setInspirationAIDataArrayData error: " + e16.getMessage());
        }
    }

    public void t3(int i3, Object obj) {
        JSONObject jSONObject = this.f318292d0.get(Integer.valueOf(i3));
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("index", obj);
        } catch (JSONException e16) {
            w53.b.c("WinkEditorResourceManager", "setInspirationAIDataIndex error: " + e16.getMessage());
        }
    }

    public List<MetaCategory> u0() {
        return h.d().l(u53.f.f438408u, "winkEdit/wink_ai_avatar.json", "wink_ai_avatar_update_material.json", false);
    }

    @Nullable
    public Pair<String, Long> u1() {
        Setting qQHeadSettingFromDB;
        AppInterface e16 = com.tencent.mobileqq.wink.b.e();
        if (e16 == null || (qQHeadSettingFromDB = ((IQQAvatarDataService) e16.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSettingFromDB(e16.getCurrentUin())) == null) {
            return null;
        }
        return new Pair<>(ew.c.a(qQHeadSettingFromDB.url, 640, qQHeadSettingFromDB.bFaceFlags), Long.valueOf(qQHeadSettingFromDB.headImgTimestamp));
    }

    public List<MetaCategory> v0() {
        return h.d().l(u53.f.f438391d, "editor_auto_template_update_template.json", "winkEdit/wink_editor_auto_template.json", false);
    }

    public String v1() {
        z93.e h16 = Wink.INSTANCE.h();
        if (h16 != null) {
            return h16.b();
        }
        return "";
    }

    @NonNull
    public Pair<String, String> v3(@NonNull String str, int i3) {
        String str2;
        Pair<String, String> pair;
        AEEditorDownloadResBean W0 = W0(str);
        if (W0 != null) {
            str2 = t0(W0);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            w53.b.c("WinkEditorResourceManager", "font:" + str + " not find.");
            return new Pair<>(str2, AEEditorConstants.GetFontResult.ERROR_CANNOT_FIND_VALID_FONT);
        }
        if (i3 == 1) {
            return new Pair<>(str2, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        if (k0(str)) {
            w53.b.c("WinkEditorResourceManager", "fontExceededLimit.");
            return new Pair<>(str2, AEEditorConstants.GetFontResult.ERROR_EXCEEDED_FONT_LIMIT);
        }
        synchronized (this.O) {
            AEEditorDownloadResBean V0 = V0(str);
            if (V0 != null) {
                this.O.put(str, V0);
            }
            pair = new Pair<>(str2, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        return pair;
    }

    public List<MetaCategory> w0() {
        return y0();
    }

    public MutableLiveData<List<MetaCategory>> w1() {
        return this.I;
    }

    public MutableLiveData<List<MetaCategory>> x0() {
        return this.C;
    }

    public List<MetaCategory> x1() {
        return h.d().l(u53.f.f438407t, "editor_qzone_template_library.json", "winkEdit/wink_qzone_template_library.json", false);
    }

    public List<MetaCategory> y0() {
        return h.d().l(u53.f.f438411x, "background_template.json", "", false);
    }

    public MutableLiveData<Boolean> y1() {
        return this.f318298o;
    }

    public String z0(@NonNull MetaMaterial metaMaterial) {
        return m(metaMaterial) + File.separator + "blur_text.png";
    }

    public List<MetaCategory> z1() {
        return h.d().l(u53.f.f438398k, "editor_qzone_image_template.json", "", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f318311a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f318312b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318313c;

        b(String str, MetaMaterial metaMaterial, ResDownLoadListener resDownLoadListener) {
            this.f318311a = str;
            this.f318312b = metaMaterial;
            this.f318313c = resDownLoadListener;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            ms.a.a("WinkEditorResourceManager", "checkAndDownloadTemplate: downloaded " + this.f318311a);
            if (z16) {
                WinkEditorResourceManager.this.h0(this.f318312b, this.f318313c);
            } else {
                this.f318313c.onDownloadFinish(false);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
        }
    }
}

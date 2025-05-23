package com.tencent.aelight.camera.aeeditor.module.filter;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import ar.d;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aelight.camera.ae.i;
import com.tencent.aelight.camera.ae.report.b;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class AEEditorResourceManager extends AEEditorResourceDownloader {
    private static volatile AEEditorResourceManager A;
    public static final String B;

    /* renamed from: z, reason: collision with root package name */
    private static final String f66200z;

    /* renamed from: j, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f66201j;

    /* renamed from: k, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f66202k;

    /* renamed from: l, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f66203l;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f66204m;

    /* renamed from: n, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f66205n;

    /* renamed from: o, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f66206o;

    /* renamed from: p, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66207p;

    /* renamed from: q, reason: collision with root package name */
    protected volatile boolean f66208q;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66209r;

    /* renamed from: s, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66210s;

    /* renamed from: t, reason: collision with root package name */
    protected volatile boolean f66211t;

    /* renamed from: u, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66212u;

    /* renamed from: v, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66213v;

    /* renamed from: w, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66214w;

    /* renamed from: x, reason: collision with root package name */
    private final Map<String, AEEditorDownloadResBean> f66215x;

    /* renamed from: y, reason: collision with root package name */
    private final int f66216y;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager$3, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f66217d;

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f66217d, "camera/frame", AEEditorResourceManager.B);
            ms.a.f("[AEEditor2]AEEditorResourceManager", "setupFrameEnv---pag file is successfully copied");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager$4, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ AEEditorResourceManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.x();
            String str = ((AEEditorResourceDownloader) this.this$0).f66136b + File.separator + ".nomedia";
            if (new File(str).exists()) {
                return;
            }
            try {
                FileUtils.createFile(str);
            } catch (IOException e16) {
                ms.a.d(((AEEditorResourceDownloader) this.this$0).f66138d, "loadAssets", e16);
            }
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface FontUsage {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends TypeToken<List<AEEditorDownloadResBean>> {
        a() {
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = d.f26769b;
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("text");
        f66200z = sb5.toString();
        B = str + str2 + AIInput.KEY_FRAME;
    }

    AEEditorResourceManager() {
        super("camera/ae_camera_editor_download_resources.json", d.f26769b, 4, "[AEEditor2]AEEditorResourceManager");
        this.f66201j = new MutableLiveData<>();
        this.f66202k = new MutableLiveData<>();
        this.f66203l = new MutableLiveData<>();
        this.f66204m = new MutableLiveData<>();
        this.f66205n = new MutableLiveData<>();
        this.f66206o = new MutableLiveData<>();
        this.f66207p = new LinkedHashMap();
        this.f66208q = false;
        this.f66209r = new LinkedHashMap();
        this.f66210s = new LinkedHashMap();
        this.f66211t = false;
        this.f66212u = new LinkedHashMap();
        this.f66213v = new LinkedHashMap();
        this.f66214w = new LinkedHashMap();
        this.f66215x = new LinkedHashMap();
        this.f66216y = ((Integer) dr.c.e(3, 5, 7)).intValue();
    }

    public static AEEditorResourceManager J() {
        if (A == null) {
            synchronized (AEEditorResourceManager.class) {
                if (A == null) {
                    A = new AEEditorResourceManager();
                }
            }
        }
        return A;
    }

    private void u() {
        String str = i.f65581d;
        s(str, "editor_filter_update_template.json", AEEditorConstants.AE_EDITOR_FILTER_JSON, this.f66212u);
        s(str, "editor_text_sticker_update_template.json", AEEditorConstants.AE_EDITOR_TEXT_STICKER_JSON, this.f66215x);
        s(i.f65582e, "editor_frame_update_template.json", AEEditorConstants.AE_EDITOR_FRAME_JSON, this.f66214w);
        s(i.f65583f, "editor_pic_template_update_template.json", AEEditorConstants.AE_EDITOR_PIC_TEMPLATE_JSON, this.f66213v);
        s(i.f65584g, "editor_text_update_template.json", AEEditorConstants.AE_EDITOR_TEXT_JSON, this.f66210s);
    }

    private void v() {
        Object valueOf;
        synchronized (this.f66207p) {
            if (this.f66208q) {
                return;
            }
            this.f66208q = true;
            String i3 = i("camera/ae_camera_editor_fonts.json");
            if (TextUtils.isEmpty(i3)) {
                ms.a.c(this.f66138d, "setupFontListConfig---read assets json content empty");
                return;
            }
            List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(i3, new a().getType());
            String str = this.f66138d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setupFontListConfig---size = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            ms.a.f(str, sb5.toString());
            if (list != null) {
                for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                    this.f66207p.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    private void w() {
        synchronized (this.f66210s) {
            if (this.f66211t) {
                return;
            }
            this.f66211t = true;
            Iterator<MetaCategory> it = J().Q().iterator();
            while (it.hasNext()) {
                Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next = it5.next();
                    AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                    aEEditorDownloadResBean.setId(next.f30533id);
                    aEEditorDownloadResBean.setUrl(next.packageUrl);
                    aEEditorDownloadResBean.setMd5(next.packageMd5);
                    String str = next.additionalFields.get("preDownload");
                    if (!TextUtils.isEmpty(str)) {
                        aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str));
                    }
                    this.f66210s.put(next.f30533id, aEEditorDownloadResBean);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (new File("camera/text").exists()) {
            ms.a.f("[AEEditor2]AEEditorResourceManager", "ensureSetupTextConfig---pag file is already copied");
        } else {
            c.a(BaseApplication.getContext(), "camera/text", f66200z);
        }
    }

    private String y(AEEditorDownloadResBean aEEditorDownloadResBean) {
        String str = f(aEEditorDownloadResBean) + File.separator + aEEditorDownloadResBean.getId();
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

    public MutableLiveData<List<MetaCategory>> A() {
        return this.f66204m;
    }

    public List<MetaCategory> B() {
        return com.tencent.aelight.camera.aeeditor.manage.c.b().h(i.f65581d, "editor_filter_update_template.json", AEEditorConstants.AE_EDITOR_FILTER_JSON, false);
    }

    public MutableLiveData<List<MetaCategory>> C() {
        return this.f66201j;
    }

    public String D(String str, int i3) {
        return (String) Z(str, i3).first;
    }

    public AEEditorDownloadResBean E(String str) {
        Map<String, AEEditorDownloadResBean> map = this.f66207p;
        if (map != null && map.get(str) != null) {
            return this.f66207p.get(str);
        }
        Map<String, AEEditorDownloadResBean> map2 = this.f66210s;
        if (map2 == null || map2.get(str) == null) {
            return null;
        }
        return this.f66210s.get(str);
    }

    public AEEditorDownloadResBean F(String str) {
        v();
        w();
        return E(str);
    }

    public Map<String, AEEditorDownloadResBean> G() {
        v();
        return new HashMap(this.f66207p);
    }

    public List<MetaCategory> H() {
        return com.tencent.aelight.camera.aeeditor.manage.c.b().h(i.f65582e, "editor_frame_update_template.json", AEEditorConstants.AE_EDITOR_FRAME_JSON, false);
    }

    public MutableLiveData<List<MetaCategory>> I() {
        return this.f66202k;
    }

    public String K(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e();
        AEEditorDownloadResBean aEEditorDownloadResBean = this.f66139e.get(str);
        if (aEEditorDownloadResBean == null) {
            return null;
        }
        return f(aEEditorDownloadResBean) + File.separator + str + ".png";
    }

    public String L() {
        e();
        return f(this.f66139e.get("AIPhotoConfig"));
    }

    public List<MetaCategory> M() {
        return com.tencent.aelight.camera.aeeditor.manage.c.b().h(i.f65583f, "editor_pic_template_update_template.json", AEEditorConstants.AE_EDITOR_PIC_TEMPLATE_JSON, false);
    }

    public MutableLiveData<List<MetaCategory>> N() {
        return this.f66203l;
    }

    public List<MetaCategory> O() {
        return com.tencent.aelight.camera.aeeditor.manage.c.b().h(i.f65579b, "editor_text_sticker_update_template.json", AEEditorConstants.AE_EDITOR_TEXT_STICKER_JSON, false);
    }

    public MutableLiveData<List<MetaCategory>> P() {
        return this.f66205n;
    }

    public List<MetaCategory> Q() {
        return com.tencent.aelight.camera.aeeditor.manage.c.b().h(i.f65584g, "editor_text_update_template.json", AEEditorConstants.AE_EDITOR_TEXT_JSON, false);
    }

    public MutableLiveData<List<MetaCategory>> R() {
        return this.f66206o;
    }

    public boolean S() {
        return new File(L()).exists();
    }

    public void T() {
        ms.a.a("[AEEditor2]AEEditorResourceManager", "loadAutoTemplate...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.8
                @Override // java.lang.Runnable
                public void run() {
                    AEEditorResourceManager.this.A().postValue(AEEditorResourceManager.this.z());
                }
            }, 64, null, true);
        } else {
            A().postValue(z());
        }
    }

    public void U() {
        ms.a.a("[AEEditor2]AEEditorResourceManager", "loadFilter...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.5
                @Override // java.lang.Runnable
                public void run() {
                    AEEditorResourceManager.this.C().postValue(AEEditorResourceManager.this.B());
                }
            }, 64, null, true);
        } else {
            C().postValue(B());
        }
    }

    public void V() {
        ms.a.a("[AEEditor2]AEEditorResourceManager", "loadFrame...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.6
                @Override // java.lang.Runnable
                public void run() {
                    AEEditorResourceManager.this.I().postValue(AEEditorResourceManager.this.H());
                }
            }, 64, null, true);
        } else {
            I().postValue(H());
        }
    }

    public void W() {
        ms.a.a("[AEEditor2]AEEditorResourceManager", "loadPicTemplate...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.7
                @Override // java.lang.Runnable
                public void run() {
                    AEEditorResourceManager.this.N().postValue(AEEditorResourceManager.this.M());
                }
            }, 64, null, true);
        } else {
            N().postValue(M());
        }
    }

    public void X() {
        ms.a.a("[AEEditor2]AEEditorResourceManager", "loadSticker...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.9
                @Override // java.lang.Runnable
                public void run() {
                    AEEditorResourceManager.this.P().postValue(AEEditorResourceManager.this.O());
                }
            }, 64, null, true);
        } else {
            P().postValue(O());
        }
    }

    public void Y() {
        ms.a.a("[AEEditor2]AEEditorResourceManager", "loadText...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager.10
                @Override // java.lang.Runnable
                public void run() {
                    AEEditorResourceManager.this.R().postValue(AEEditorResourceManager.this.Q());
                }
            }, 64, null, true);
        } else {
            R().postValue(Q());
        }
    }

    public Pair<String, String> Z(String str, int i3) {
        Pair<String, String> pair;
        AEEditorDownloadResBean F = F(str);
        String y16 = F != null ? y(F) : null;
        if (TextUtils.isEmpty(y16)) {
            ms.a.c("[AEEditor2]AEEditorResourceManager", "font not find.");
            return new Pair<>(y16, AEEditorConstants.GetFontResult.ERROR_CANNOT_FIND_VALID_FONT);
        }
        if (i3 == 1) {
            return new Pair<>(y16, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        if (r(str)) {
            ms.a.c("[AEEditor2]AEEditorResourceManager", "fontExceededLimit.");
            return new Pair<>(y16, AEEditorConstants.GetFontResult.ERROR_EXCEEDED_FONT_LIMIT);
        }
        synchronized (this.f66209r) {
            AEEditorDownloadResBean E = E(str);
            if (E != null) {
                this.f66209r.put(str, E);
            }
            pair = new Pair<>(y16, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        return pair;
    }

    @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader
    protected void a(List<AEEditorDownloadResBean> list) {
        u();
        for (AEEditorDownloadResBean aEEditorDownloadResBean : this.f66212u.values()) {
            if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !g(aEEditorDownloadResBean)) {
                list.add(aEEditorDownloadResBean);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean2 : this.f66213v.values()) {
            if (aEEditorDownloadResBean2 != null && aEEditorDownloadResBean2.getPreDownload() == 1 && !g(aEEditorDownloadResBean2)) {
                list.add(aEEditorDownloadResBean2);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean3 : this.f66214w.values()) {
            if (aEEditorDownloadResBean3 != null && aEEditorDownloadResBean3.getPreDownload() == 1 && !g(aEEditorDownloadResBean3)) {
                list.add(aEEditorDownloadResBean3);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader
    protected void b(List<AEEditorDownloadResBean> list) {
        for (AEEditorDownloadResBean aEEditorDownloadResBean : this.f66215x.values()) {
            if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !g(aEEditorDownloadResBean)) {
                list.add(aEEditorDownloadResBean);
            }
        }
        v();
        for (AEEditorDownloadResBean aEEditorDownloadResBean2 : this.f66207p.values()) {
            if (aEEditorDownloadResBean2 != null && aEEditorDownloadResBean2.getPreDownload() == 1 && !g(aEEditorDownloadResBean2)) {
                list.add(aEEditorDownloadResBean2);
            }
        }
        w();
        for (AEEditorDownloadResBean aEEditorDownloadResBean3 : this.f66210s.values()) {
            if (aEEditorDownloadResBean3 != null && aEEditorDownloadResBean3.getPreDownload() == 1 && !g(aEEditorDownloadResBean3)) {
                list.add(aEEditorDownloadResBean3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void j(boolean z16, int i3, long j3, String str) {
        String str2;
        String str3;
        String str4 = "AEEditorFilter";
        if (!this.f66139e.containsKey(str) && !this.f66212u.containsKey(str)) {
            str4 = "AEEditorFont";
            if (!this.f66207p.containsKey(str) && !this.f66210s.containsKey(str)) {
                if (str != null && str.contains("effect_")) {
                    str2 = "AEEditorEffect";
                } else {
                    str2 = "";
                }
                str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    b.b().f(z16, 3, str3, str, i3, j3);
                    return;
                }
                return;
            }
        }
        str3 = str4;
        if (TextUtils.isEmpty(str3)) {
        }
    }

    public boolean r(String str) {
        synchronized (this.f66209r) {
            if (this.f66209r.get(str) != null) {
                return false;
            }
            return this.f66209r.size() >= this.f66216y;
        }
    }

    public void s(String str, String str2, String str3, Map<String, AEEditorDownloadResBean> map) {
        ms.a.a(this.f66138d, "checkNeedDownload... json:" + str2 + " defaultJson:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (map) {
            List<MetaCategory> h16 = com.tencent.aelight.camera.aeeditor.manage.c.b().h(str, str2, str3, true);
            if (h16 != null && h16.size() != 0) {
                map.clear();
                ms.a.a(this.f66138d, "checkNeedDownload... groupList size:" + h16.size());
                Iterator<MetaCategory> it = h16.iterator();
                while (it.hasNext()) {
                    Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                    while (it5.hasNext()) {
                        MetaMaterial next = it5.next();
                        AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                        aEEditorDownloadResBean.setId(next.f30533id);
                        aEEditorDownloadResBean.setUrl(next.packageUrl);
                        aEEditorDownloadResBean.setMd5(next.packageMd5);
                        String str4 = next.additionalFields.get("preDownload");
                        if (!TextUtils.isEmpty(str4)) {
                            aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str4));
                        }
                        map.put(next.f30533id, aEEditorDownloadResBean);
                    }
                }
                ms.a.a(this.f66138d, "checkNeedDownload... cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            ms.a.c(this.f66138d, "checkNeedDownload... groupList is empty.");
        }
    }

    public void t() {
        d("AIPhotoConfig", null);
    }

    public List<MetaCategory> z() {
        return com.tencent.aelight.camera.aeeditor.manage.c.b().g();
    }
}

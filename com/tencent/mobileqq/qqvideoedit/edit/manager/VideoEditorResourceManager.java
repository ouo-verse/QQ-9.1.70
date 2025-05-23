package com.tencent.mobileqq.qqvideoedit.edit.manager;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqvideoedit.VideoEditorResourceManagerExtKt;
import com.tencent.mobileqq.qqvideoedit.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.c;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oj2.b;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class VideoEditorResourceManager extends VideoEditorResourceDownloader {
    public static final String A;
    private static final String B;
    private static volatile VideoEditorResourceManager C;

    /* renamed from: j, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f275061j;

    /* renamed from: k, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f275062k;

    /* renamed from: l, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f275063l;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f275064m;

    /* renamed from: n, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f275065n;

    /* renamed from: o, reason: collision with root package name */
    private final MutableLiveData<List<MetaCategory>> f275066o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275067p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275068q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275069r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275070s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275071t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275072u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275073v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    private final Map<String, AEEditorDownloadResBean> f275074w;

    /* renamed from: x, reason: collision with root package name */
    private final int f275075x;

    /* renamed from: y, reason: collision with root package name */
    protected volatile boolean f275076y;

    /* renamed from: z, reason: collision with root package name */
    protected volatile boolean f275077z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f275078d;

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f275078d, "camera/frame", VideoEditorResourceManager.A);
            mj2.a.d("[AEEditor2]AEEditorResourceManager", "setupFrameEnv---pag file is successfully copied");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager$5, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ VideoEditorResourceManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.K().postValue(this.this$0.J());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager$6, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ VideoEditorResourceManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.N().postValue(this.this$0.M());
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface FontUsage {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends TypeToken<List<AEEditorDownloadResBean>> {
        a() {
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = lj2.a.f414862b;
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(AIInput.KEY_FRAME);
        A = sb5.toString();
        B = str + str2 + "text";
    }

    VideoEditorResourceManager() {
        super("videoEdit/video_editor_download_resources.json", lj2.a.f414862b, 4, "[AEEditor2]AEEditorResourceManager");
        this.f275061j = new MutableLiveData<>();
        this.f275062k = new MutableLiveData<>();
        this.f275063l = new MutableLiveData<>();
        this.f275064m = new MutableLiveData<>();
        this.f275065n = new MutableLiveData<>();
        this.f275066o = new MutableLiveData<>();
        this.f275067p = new LinkedHashMap();
        this.f275068q = new LinkedHashMap();
        this.f275069r = new LinkedHashMap();
        this.f275070s = new LinkedHashMap();
        this.f275071t = new LinkedHashMap();
        this.f275072u = new LinkedHashMap();
        this.f275073v = new LinkedHashMap();
        this.f275074w = new LinkedHashMap();
        this.f275076y = false;
        this.f275077z = false;
        this.f275075x = ((Integer) b.a(3, 5, 7)).intValue();
    }

    public static VideoEditorResourceManager L() {
        if (C == null) {
            synchronized (VideoEditorResourceManager.class) {
                if (C == null) {
                    C = new VideoEditorResourceManager();
                }
            }
        }
        return C;
    }

    @WorkerThread
    private void v() {
        String str = lj2.b.f414871d;
        u(str, "editor_filter_update_template.json", "videoEdit/video_editor_display_effects.json", this.f275070s);
        u(str, "editor_text_sticker_update_template.json", "videoEdit/video_editor_text_stickers_default.json", this.f275073v);
        String str2 = lj2.b.f414874g;
        u(str2, "editor_text_update_template.json", "videoEdit/video_editor_text.json", this.f275069r);
        u(str2, "editor_auto_template_update_template.json", "videoEdit/video_editor_auto_template.json", this.f275074w);
    }

    @WorkerThread
    private void w() {
        Object valueOf;
        synchronized (this.f275067p) {
            if (this.f275076y) {
                return;
            }
            this.f275076y = true;
            String l3 = l("videoEdit/video_editor_base_fonts.json");
            if (TextUtils.isEmpty(l3)) {
                mj2.a.b(this.f275036d, "setupFontListConfig---read assets json content empty");
                return;
            }
            List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(l3, new a().getType());
            String str = this.f275036d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setupFontListConfig---size = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            mj2.a.d(str, sb5.toString());
            if (list != null) {
                for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
                    this.f275067p.put(aEEditorDownloadResBean.getId(), aEEditorDownloadResBean);
                }
            }
        }
    }

    @WorkerThread
    private void x() {
        synchronized (this.f275069r) {
            if (this.f275077z) {
                return;
            }
            this.f275077z = true;
            Iterator<MetaCategory> it = L().R().iterator();
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
                    this.f275069r.put(next.f30533id, aEEditorDownloadResBean);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void y() {
        String str = B;
        new File(str);
        c.a(com.tencent.mobileqq.qqvideoedit.a.c(), "video/pag", str);
    }

    @Nullable
    private String z(@NonNull AEEditorDownloadResBean aEEditorDownloadResBean) {
        String str = g(aEEditorDownloadResBean) + File.separator + aEEditorDownloadResBean.getId();
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

    public List<MetaCategory> A() {
        return com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(lj2.b.f414870c, "editor_auto_template_update_template.json", "videoEdit/video_editor_auto_template.json", false);
    }

    public String B(@NonNull MetaMaterial metaMaterial) {
        return f(metaMaterial) + File.separator + "blur_text.png";
    }

    public String C(@NonNull MetaMaterial metaMaterial) {
        return f(metaMaterial) + File.separator + "blur_texture.png";
    }

    public String D(@NonNull MetaMaterial metaMaterial) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f(metaMaterial));
        String str = File.separator;
        sb5.append(str);
        sb5.append("bottom");
        sb5.append(str);
        sb5.append("qq_richmedia_main.pag");
        return sb5.toString();
    }

    public List<MetaCategory> E() {
        return com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(lj2.b.f414871d, "editor_filter_update_template.json", "videoEdit/video_editor_display_effects.json", false);
    }

    public MutableLiveData<List<MetaCategory>> F() {
        return this.f275061j;
    }

    @Nullable
    public String G(String str, int i3) {
        return (String) e0(str, i3).first;
    }

    public AEEditorDownloadResBean H(String str) {
        Map<String, AEEditorDownloadResBean> map = this.f275067p;
        if (map != null && map.get(str) != null) {
            return this.f275067p.get(str);
        }
        Map<String, AEEditorDownloadResBean> map2 = this.f275069r;
        if (map2 != null && map2.get(str) != null) {
            return this.f275069r.get(str);
        }
        return null;
    }

    @Nullable
    public AEEditorDownloadResBean I(@NonNull String str) {
        w();
        x();
        return H(str);
    }

    public List<MetaCategory> J() {
        return com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(lj2.b.f414872e, "editor_frame_update_template.json", "videoEdit/video_editor_frame.json", false);
    }

    public MutableLiveData<List<MetaCategory>> K() {
        return this.f275062k;
    }

    public List<MetaCategory> M() {
        return com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(lj2.b.f414873f, "editor_pic_template_update_template.json", "videoEdit/video_editor_pic_template.json", false);
    }

    public MutableLiveData<List<MetaCategory>> N() {
        return this.f275063l;
    }

    public List<MetaCategory> O() {
        return com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(lj2.b.f414869b, "editor_text_sticker_update_template.json", "videoEdit/video_editor_text_stickers_default.json", false);
    }

    public MutableLiveData<List<MetaCategory>> P() {
        return this.f275065n;
    }

    public String Q() {
        return B + File.separator + "qq_richmedia_text_background.pag";
    }

    public List<MetaCategory> R() {
        return com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(lj2.b.f414874g, "editor_text_update_template.json", "videoEdit/video_editor_text.json", false);
    }

    public String S(@NonNull MetaMaterial metaMaterial) {
        return f(metaMaterial) + File.separator + IVideoFilterTools.CONFIG_FILE;
    }

    public String T() {
        return B + File.separator + IVideoFilterTools.CONFIG_FILE;
    }

    public String U() {
        return B + File.separator + "qq_richmedia_main.pag";
    }

    public MutableLiveData<List<MetaCategory>> V() {
        return this.f275066o;
    }

    public String W(@NonNull MetaMaterial metaMaterial) {
        return f(metaMaterial) + File.separator + "qq_richmedia_main.pag";
    }

    public String X(@NonNull MetaMaterial metaMaterial) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f(metaMaterial));
        String str = File.separator;
        sb5.append(str);
        sb5.append("top");
        sb5.append(str);
        sb5.append("qq_richmedia_main.pag");
        return sb5.toString();
    }

    public MutableLiveData<List<MetaCategory>> Y() {
        return this.f275064m;
    }

    public void Z() {
        mj2.a.d(this.f275036d, "loadAssets");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager.3
            @Override // java.lang.Runnable
            public void run() {
                VideoEditorResourceManager.this.y();
                String str = VideoEditorResourceManager.this.f275034b + File.separator + ".nomedia";
                if (!new File(str).exists()) {
                    try {
                        FileUtils.createFile(str);
                    } catch (IOException e16) {
                        mj2.a.c(VideoEditorResourceManager.this.f275036d, "loadAssets", e16);
                    }
                }
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader
    protected void a(@NonNull List<AEEditorDownloadResBean> list) {
        v();
        Collection<AEEditorDownloadResBean> values = this.f275070s.values();
        if (VideoEditorResourceManagerExtKt.a()) {
            values = new ArrayList<>(this.f275070s.values());
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean : values) {
            if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !i(aEEditorDownloadResBean)) {
                list.add(aEEditorDownloadResBean);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean2 : this.f275071t.values()) {
            if (aEEditorDownloadResBean2 != null && aEEditorDownloadResBean2.getPreDownload() == 1 && !i(aEEditorDownloadResBean2)) {
                list.add(aEEditorDownloadResBean2);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean3 : this.f275072u.values()) {
            if (aEEditorDownloadResBean3 != null && aEEditorDownloadResBean3.getPreDownload() == 1 && !i(aEEditorDownloadResBean3)) {
                list.add(aEEditorDownloadResBean3);
            }
        }
        for (AEEditorDownloadResBean aEEditorDownloadResBean4 : this.f275074w.values()) {
            if (aEEditorDownloadResBean4 != null && aEEditorDownloadResBean4.getPreDownload() == 1 && !i(aEEditorDownloadResBean4)) {
                list.add(aEEditorDownloadResBean4);
            }
        }
    }

    public void a0() {
        mj2.a.a("[AEEditor2]AEEditorResourceManager", "loadFilter...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager.4
                @Override // java.lang.Runnable
                public void run() {
                    VideoEditorResourceManager.this.F().postValue(VideoEditorResourceManager.this.E());
                }
            }, 64, null, true);
        } else {
            F().postValue(E());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceDownloader
    protected void b(@NonNull List<AEEditorDownloadResBean> list) {
        for (AEEditorDownloadResBean aEEditorDownloadResBean : this.f275073v.values()) {
            if (aEEditorDownloadResBean != null && aEEditorDownloadResBean.getPreDownload() == 1 && !i(aEEditorDownloadResBean)) {
                list.add(aEEditorDownloadResBean);
            }
        }
        w();
        for (AEEditorDownloadResBean aEEditorDownloadResBean2 : this.f275067p.values()) {
            if (aEEditorDownloadResBean2 != null && aEEditorDownloadResBean2.getPreDownload() == 1 && !i(aEEditorDownloadResBean2)) {
                list.add(aEEditorDownloadResBean2);
            }
        }
        x();
        for (AEEditorDownloadResBean aEEditorDownloadResBean3 : this.f275069r.values()) {
            if (aEEditorDownloadResBean3 != null && aEEditorDownloadResBean3.getPreDownload() == 1 && !i(aEEditorDownloadResBean3)) {
                list.add(aEEditorDownloadResBean3);
            }
        }
    }

    public void b0() {
        mj2.a.a("[AEEditor2]AEEditorResourceManager", "loadSticker...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager.8
                @Override // java.lang.Runnable
                public void run() {
                    VideoEditorResourceManager.this.P().postValue(VideoEditorResourceManager.this.O());
                }
            }, 64, null, true);
        } else {
            P().postValue(O());
        }
    }

    public void c0() {
        mj2.a.a("[AEEditor2]AEEditorResourceManager", "loadText...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager.9
                @Override // java.lang.Runnable
                public void run() {
                    VideoEditorResourceManager.this.V().postValue(VideoEditorResourceManager.this.R());
                }
            }, 64, null, true);
        } else {
            V().postValue(R());
        }
    }

    public void d0() {
        mj2.a.a("[AEEditor2]AEEditorResourceManager", "loadAutoTemplate...");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager.7
                @Override // java.lang.Runnable
                public void run() {
                    List<MetaCategory> A2 = VideoEditorResourceManager.this.A();
                    MetaCategory c16 = com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().c();
                    if (c16 != null) {
                        A2.add(0, c16);
                    }
                    VideoEditorResourceManager.this.Y().postValue(A2);
                }
            }, 64, null, true);
            return;
        }
        List<MetaCategory> A2 = A();
        MetaCategory c16 = com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().c();
        if (c16 != null) {
            A2.add(0, c16);
        }
        Y().postValue(A2);
    }

    @NonNull
    public Pair<String, String> e0(@NonNull String str, int i3) {
        String str2;
        Pair<String, String> pair;
        AEEditorDownloadResBean I = I(str);
        if (I != null) {
            str2 = z(I);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            mj2.a.b("[AEEditor2]AEEditorResourceManager", "font not find.");
            return new Pair<>(str2, AEEditorConstants.GetFontResult.ERROR_CANNOT_FIND_VALID_FONT);
        }
        if (i3 == 1) {
            return new Pair<>(str2, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        if (t(str)) {
            mj2.a.b("[AEEditor2]AEEditorResourceManager", "fontExceededLimit.");
            return new Pair<>(str2, AEEditorConstants.GetFontResult.ERROR_EXCEEDED_FONT_LIMIT);
        }
        synchronized (this.f275068q) {
            AEEditorDownloadResBean H = H(str);
            if (H != null) {
                this.f275068q.put(str, H);
            }
            pair = new Pair<>(str2, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        return pair;
    }

    public boolean t(@NonNull String str) {
        synchronized (this.f275068q) {
            boolean z16 = false;
            if (this.f275068q.get(str) != null) {
                return false;
            }
            if (this.f275068q.size() >= this.f275075x) {
                z16 = true;
            }
            return z16;
        }
    }

    public void u(String str, String str2, String str3, Map<String, AEEditorDownloadResBean> map) {
        mj2.a.a(this.f275036d, "checkNeedDownload... json:" + str2 + " defaultJson:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (map) {
            List<MetaCategory> h16 = com.tencent.mobileqq.qqvideoedit.edit.manager.a.b().h(str, str2, str3, true);
            if (h16 != null && h16.size() != 0) {
                map.clear();
                mj2.a.a(this.f275036d, "checkNeedDownload... groupList size:" + h16.size());
                Iterator<MetaCategory> it = h16.iterator();
                while (it.hasNext()) {
                    Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                    while (it5.hasNext()) {
                        MetaMaterial next = it5.next();
                        AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                        aEEditorDownloadResBean.setId(next.f30533id);
                        aEEditorDownloadResBean.setUrl(next.packageUrl);
                        aEEditorDownloadResBean.setMd5(next.packageMd5);
                        Map<String, String> map2 = next.additionalFields;
                        if (map2 != null) {
                            String str4 = map2.get("preDownload");
                            if (!TextUtils.isEmpty(str4)) {
                                aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str4));
                            }
                        }
                        map.put(next.f30533id, aEEditorDownloadResBean);
                    }
                }
                mj2.a.a(this.f275036d, "checkNeedDownload... cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            mj2.a.b(this.f275036d, "checkNeedDownload... groupList is empty.");
        }
    }
}

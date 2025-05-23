package ak2;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class o extends BaseViewModel {
    private static final String S = "o";
    public static final String T = VideoEditorResourceManager.L().U();
    public static final String U = VideoEditorResourceManager.L().Q();
    static final String V = RFWApplication.getApplication().getString(R.string.yma);
    static final List<Integer> W = Arrays.asList(Integer.valueOf(Color.parseColor("#F95251")), Integer.valueOf(Color.parseColor("#FFC300")), Integer.valueOf(Color.parseColor("#07C060")), Integer.valueOf(Color.parseColor("#0FAFFF")), Integer.valueOf(Color.parseColor("#6468F0")), Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#000000")));
    static final List<Integer> X = Arrays.asList(Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#000000")), Integer.valueOf(Color.parseColor("#FFFFFF")));
    static final int Y = Color.parseColor("#EFEFEF");
    protected List<MetaMaterial> N;
    private String P;
    private MetaMaterial Q;
    private VideoStickerModel R;
    private final List<MetaMaterial> K = new ArrayList();
    private final List<MetaMaterial> L = new ArrayList();
    private final List<MetaMaterial> M = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<String> f26234i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<MetaMaterial>> f26235m = new MutableLiveData<>();
    private final MutableLiveData<List<MetaMaterial>> C = new MutableLiveData<>();
    private final MutableLiveData<MetaMaterial> D = new MutableLiveData<>();
    private final MutableLiveData<Integer> E = new MutableLiveData<>();
    private final MutableLiveData<Integer> F = new MutableLiveData<>();
    private final MutableLiveData<Integer> G = new MutableLiveData<>();
    private final MutableLiveData<Boolean> H = new MutableLiveData<>();
    private final MutableLiveData<VideoStickerModel> I = new MutableLiveData<>();
    private final MutableLiveData<MetaMaterial> J = new MutableLiveData<>();

    private void O1() {
        if (this.Q != null && !"CATEGORY_KEYBOARD".equals(this.P)) {
            String a16 = com.tencent.mobileqq.qqvideoedit.editor.b.a(this.Q);
            int i3 = 0;
            if (!f2(a16, this.P) && (!"CATEGORY_TEXT_STYLE".equals(a16) || !"CATEGORY_TEXT_STYLE".equals(this.P))) {
                if (this.N != null) {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= this.N.size()) {
                            break;
                        }
                        if (this.N.get(i16) != null && this.Q.f30533id.equals(this.N.get(i16).f30533id)) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                    this.F.postValue(Integer.valueOf(i3));
                    return;
                }
                return;
            }
            String k3 = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.k(this.Q);
            if (this.K != null) {
                int i17 = 0;
                while (true) {
                    if (i17 >= this.K.size()) {
                        break;
                    }
                    if (k3.equals(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.k(this.K.get(i17)))) {
                        i3 = i17;
                        break;
                    }
                    i17++;
                }
            }
            this.E.postValue(Integer.valueOf(i3));
        }
    }

    public static int R1(int i3) {
        int indexOf = W.indexOf(Integer.valueOf(i3));
        if (indexOf >= 0) {
            return X.get(indexOf).intValue();
        }
        return X.get(0).intValue();
    }

    private String T1(String str) {
        if (X1(str, this.K) != null) {
            return "CATEGORY_TEXT_STYLE";
        }
        if (X1(str, this.L) != null) {
            return "CATEGORY_TEXT_PATTERN";
        }
        if (X1(str, this.M) != null) {
            return "CATEGORY_TEXT_DECOR";
        }
        return null;
    }

    private MetaMaterial X1(String str, List<MetaMaterial> list) {
        int Z1;
        if (list == null || (Z1 = Z1(str, list)) == -1) {
            return null;
        }
        return list.get(Z1);
    }

    private int Z1(String str, List<MetaMaterial> list) {
        if (list != null && str != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (str.equals(list.get(i3).f30533id)) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    private boolean f2(String str, String str2) {
        if (("CATEGORY_TEXT_PATTERN".equals(str) || "CATEGORY_TEXT_DECOR".equals(str)) && "CATEGORY_TEXT_STYLE".equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean g2(String str, String str2) {
        if ("CATEGORY_TEXT_DECOR".equals(str) && !"CATEGORY_TEXT_DECOR".equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean h2(String str, String str2) {
        if (!"CATEGORY_TEXT_DECOR".equals(str) && "CATEGORY_TEXT_DECOR".equals(str2)) {
            return true;
        }
        return false;
    }

    private void j2(String str) {
        MetaMaterial G = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.G();
        this.Q = G;
        this.D.postValue(G);
    }

    private void l2() {
        int i3;
        MetaMaterial metaMaterial = this.Q;
        if (metaMaterial != null) {
            i3 = W.indexOf(Integer.valueOf(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(metaMaterial)));
        } else {
            i3 = -1;
        }
        QLog.e(S, 1, "updateColorSelector: " + i3);
        this.G.postValue(Integer.valueOf(i3));
    }

    private void m2() {
        boolean z16;
        MetaMaterial metaMaterial = this.Q;
        if (metaMaterial != null) {
            if (U.equals(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.t(metaMaterial))) {
                z16 = true;
                QLog.e(S, 1, "updateHasBackgroundColor: " + z16);
                this.H.postValue(Boolean.valueOf(z16));
            }
        }
        z16 = false;
        QLog.e(S, 1, "updateHasBackgroundColor: " + z16);
        this.H.postValue(Boolean.valueOf(z16));
    }

    private void n2(MetaMaterial metaMaterial, VideoStickerModel videoStickerModel) {
        List<TextItem> list;
        if (videoStickerModel != null && (list = videoStickerModel.textItems) != null && list.size() > 0) {
            TextItem textItem = videoStickerModel.textItems.get(0);
            String str = textItem.text;
            if (!TextUtils.isEmpty(str)) {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.Q(this.Q, str);
            }
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.d0(this.Q, videoStickerModel.filePath);
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.c0(this.Q, videoStickerModel.scale);
            if (U.equals(videoStickerModel.filePath)) {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.f0(this.Q, Color.parseColor(textItem.backgroundColor));
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.J(this.Q, Color.parseColor(textItem.textColor));
            } else {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.f0(this.Q, Color.parseColor(textItem.textColor));
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.J(this.Q, Color.parseColor(textItem.backgroundColor));
            }
        }
    }

    private void o2(@NonNull MetaMaterial metaMaterial) {
        if (!"CATEGORY_TEXT_STYLE".equals(com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial))) {
            this.Q.f30533id = metaMaterial.f30533id;
        }
        MetaMaterial metaMaterial2 = this.Q;
        metaMaterial2.packageUrl = metaMaterial.packageUrl;
        metaMaterial2.packageMd5 = metaMaterial.packageMd5;
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.V(metaMaterial2, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.k(metaMaterial));
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.W(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.l(metaMaterial));
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.U(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.j(metaMaterial));
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.Y(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.n(metaMaterial));
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.T(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.i(metaMaterial));
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.X(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.m(metaMaterial));
        String T1 = T1(this.Q.f30533id);
        if (h2(T1, com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial)) || g2(T1, com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial))) {
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.e0(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.v(metaMaterial));
        }
        if ("CATEGORY_TEXT_PATTERN".equals(com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial)) || "CATEGORY_TEXT_DECOR".equals(com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial))) {
            com.tencent.mobileqq.qqvideoedit.editor.b.v(this.Q, com.tencent.mobileqq.qqvideoedit.editor.b.a(metaMaterial));
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.d0(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.t(metaMaterial));
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.f0(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(metaMaterial));
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.J(this.Q, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.c(metaMaterial));
        }
        this.D.postValue(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L1() {
        if (this.R == null) {
            MetaMaterial G = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.G();
            this.Q = G;
            this.D.postValue(G);
            N1("CATEGORY_KEYBOARD");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M1(@NonNull MetaMaterial metaMaterial) {
        String str = metaMaterial.f30533id;
        if (str == null || this.Q == null) {
            return;
        }
        if (!"TEXT_PATTERN_NON_ID".equals(str) && !"TEXT_DECOR_NON_ID".equals(metaMaterial.f30533id)) {
            o2(metaMaterial);
        } else {
            j2(metaMaterial.f30533id);
        }
    }

    void N1(String str) {
        if (str != null && !str.equals(this.P)) {
            this.P = str;
            if (!str.equals("CATEGORY_TEXT_DECOR")) {
                if (str.equals("CATEGORY_TEXT_PATTERN")) {
                    this.N = this.L;
                }
            } else {
                this.N = this.M;
            }
            this.f26234i.postValue(this.P);
            this.C.postValue(this.N);
            O1();
            l2();
            m2();
            return;
        }
        O1();
        l2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P1(boolean z16) {
        MetaMaterial metaMaterial = this.Q;
        if (metaMaterial == null) {
            return;
        }
        if (z16) {
            VideoStickerModel videoStickerModel = this.R;
            if (videoStickerModel != null) {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.N(metaMaterial, videoStickerModel.centerX);
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.O(this.Q, this.R.centerY);
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.I(this.Q, this.R.rotate);
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.S(this.Q, false);
            } else {
                com.tencent.mobileqq.qqvideoedit.editor.sticker.h.S(metaMaterial, true);
            }
            this.J.postValue(this.Q);
        } else {
            VideoStickerModel videoStickerModel2 = this.R;
            if (videoStickerModel2 != null) {
                this.I.postValue(videoStickerModel2);
            }
        }
        this.Q = null;
        this.R = null;
        this.P = null;
    }

    public LiveData<MetaMaterial> Q1() {
        return this.J;
    }

    public String S1() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<String> U1() {
        return this.f26234i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<MetaMaterial> W1() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<VideoStickerModel> a2() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<Integer> b2() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<Integer> c2() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<List<MetaMaterial>> d2() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<Boolean> e2() {
        return this.H;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return S;
    }

    public boolean i2(VideoStickerModel videoStickerModel) {
        MetaMaterial material;
        if (videoStickerModel == null || (material = videoStickerModel.getMaterial()) == null) {
            return false;
        }
        return com.tencent.mobileqq.qqvideoedit.editor.sticker.h.F(material);
    }

    public void k2(List<MetaCategory> list) {
        if (list.size() >= 3) {
            if (list.get(0).materials != null) {
                this.K.clear();
                this.K.addAll(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.B("CATEGORY_TEXT_STYLE", list.get(0).materials));
                this.K.add(0, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.G());
                this.f26235m.postValue(this.K);
            }
            if (list.get(1).materials != null) {
                this.L.clear();
                this.L.addAll(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.B("CATEGORY_TEXT_PATTERN", list.get(1).materials));
                this.L.add(0, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.H("TEXT_PATTERN_NON_ID"));
            }
            if (list.get(2).materials != null) {
                this.M.clear();
                this.M.addAll(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.B("CATEGORY_TEXT_DECOR", list.get(2).materials));
                this.M.add(0, com.tencent.mobileqq.qqvideoedit.editor.sticker.h.H("TEXT_DECOR_NON_ID"));
            }
        }
    }

    public boolean p2(VideoStickerModel videoStickerModel) {
        if (!i2(videoStickerModel)) {
            return false;
        }
        MetaMaterial material = videoStickerModel.getMaterial();
        this.Q = material;
        this.R = videoStickerModel;
        n2(material, videoStickerModel);
        this.D.postValue(this.Q);
        N1("CATEGORY_KEYBOARD");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q2(int i3, int i16) {
        MetaMaterial metaMaterial = this.Q;
        if (metaMaterial == null) {
            return;
        }
        if (com.tencent.mobileqq.qqvideoedit.editor.sticker.h.w(metaMaterial) == i3 && com.tencent.mobileqq.qqvideoedit.editor.sticker.h.c(this.Q) == i16) {
            return;
        }
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.f0(this.Q, i3);
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.J(this.Q, i16);
        this.D.postValue(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r2(String str) {
        if (this.Q == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = V;
        }
        if (str.equals(com.tencent.mobileqq.qqvideoedit.editor.sticker.h.h(this.Q))) {
            return;
        }
        com.tencent.mobileqq.qqvideoedit.editor.sticker.h.Q(this.Q, str);
        this.D.postValue(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s2(boolean z16) {
        MetaMaterial metaMaterial = this.Q;
        if (metaMaterial == null) {
            return;
        }
        String t16 = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.t(metaMaterial);
        String str = U;
        if (z16 == t16.equals(str)) {
            return;
        }
        if (z16) {
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.d0(this.Q, str);
        } else {
            com.tencent.mobileqq.qqvideoedit.editor.sticker.h.d0(this.Q, T);
        }
        this.D.postValue(this.Q);
    }
}

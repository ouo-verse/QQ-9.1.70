package k93;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.wink.utils.aj;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {
    private final DeclarationParams A;

    /* renamed from: a, reason: collision with root package name */
    private final String f411916a;

    /* renamed from: b, reason: collision with root package name */
    private final String f411917b;

    /* renamed from: c, reason: collision with root package name */
    private final String f411918c;

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f411919d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, LocalMediaInfo> f411920e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f411921f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f411922g;

    /* renamed from: h, reason: collision with root package name */
    private final int f411923h;

    /* renamed from: i, reason: collision with root package name */
    private final String f411924i;

    /* renamed from: j, reason: collision with root package name */
    private final LbsDataV2.PoiInfo f411925j;

    /* renamed from: k, reason: collision with root package name */
    private final PromotionParams f411926k;

    /* renamed from: l, reason: collision with root package name */
    private final long f411927l;

    /* renamed from: m, reason: collision with root package name */
    private final String f411928m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f411929n;

    /* renamed from: o, reason: collision with root package name */
    private final String f411930o;

    /* renamed from: p, reason: collision with root package name */
    private int f411931p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f411932q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f411933r;

    /* renamed from: s, reason: collision with root package name */
    private final String f411934s;

    /* renamed from: t, reason: collision with root package name */
    private final String f411935t;

    /* renamed from: u, reason: collision with root package name */
    private final String f411936u;

    /* renamed from: v, reason: collision with root package name */
    private final String f411937v;

    /* renamed from: w, reason: collision with root package name */
    private final long f411938w;

    /* renamed from: x, reason: collision with root package name */
    private final String f411939x;

    /* renamed from: y, reason: collision with root package name */
    private final String f411940y;

    /* renamed from: z, reason: collision with root package name */
    private final String f411941z;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {
        public DeclarationParams A;

        /* renamed from: a, reason: collision with root package name */
        private final String f411942a;

        /* renamed from: b, reason: collision with root package name */
        private final int f411943b;

        /* renamed from: c, reason: collision with root package name */
        private final List<String> f411944c;

        /* renamed from: d, reason: collision with root package name */
        private final HashMap<String, LocalMediaInfo> f411945d;

        /* renamed from: e, reason: collision with root package name */
        private String f411946e;

        /* renamed from: f, reason: collision with root package name */
        private String f411947f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f411948g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f411949h;

        /* renamed from: i, reason: collision with root package name */
        private String f411950i;

        /* renamed from: j, reason: collision with root package name */
        private LbsDataV2.PoiInfo f411951j;

        /* renamed from: k, reason: collision with root package name */
        private PromotionParams f411952k;

        /* renamed from: m, reason: collision with root package name */
        private String f411954m;

        /* renamed from: o, reason: collision with root package name */
        private String f411956o;

        /* renamed from: p, reason: collision with root package name */
        private int f411957p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f411958q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f411959r;

        /* renamed from: s, reason: collision with root package name */
        private String f411960s;

        /* renamed from: t, reason: collision with root package name */
        private String f411961t;

        /* renamed from: u, reason: collision with root package name */
        private String f411962u;

        /* renamed from: v, reason: collision with root package name */
        private String f411963v;

        /* renamed from: w, reason: collision with root package name */
        private long f411964w;

        /* renamed from: x, reason: collision with root package name */
        private String f411965x;

        /* renamed from: y, reason: collision with root package name */
        private String f411966y;

        /* renamed from: z, reason: collision with root package name */
        private String f411967z;

        /* renamed from: l, reason: collision with root package name */
        private long f411953l = -1;

        /* renamed from: n, reason: collision with root package name */
        private boolean f411955n = true;

        public a(String str, int i3, List<String> list, HashMap<String, LocalMediaInfo> hashMap) {
            this.f411942a = str;
            this.f411943b = i3;
            this.f411944c = list;
            this.f411945d = hashMap;
        }

        public c A() {
            return new c(this);
        }

        public a B(String str) {
            this.f411961t = str;
            return this;
        }

        public a C(String str) {
            this.f411962u = str;
            return this;
        }

        public a D(String str) {
            this.f411950i = str;
            return this;
        }

        public a E(String str) {
            this.f411954m = str;
            return this;
        }

        public a F(String str) {
            this.f411947f = str;
            return this;
        }

        public a G(String str) {
            this.f411960s = str;
            return this;
        }

        public a H(DeclarationParams declarationParams) {
            this.A = declarationParams;
            return this;
        }

        public a I(boolean z16) {
            this.f411949h = z16;
            return this;
        }

        public a J(boolean z16) {
            this.f411959r = z16;
            return this;
        }

        public a K(int i3) {
            this.f411957p = i3;
            return this;
        }

        public a L(LbsDataV2.PoiInfo poiInfo) {
            this.f411951j = poiInfo;
            return this;
        }

        public a M(@NonNull PromotionParams promotionParams) {
            this.f411952k = promotionParams;
            return this;
        }

        public a N(boolean z16) {
            this.f411955n = z16;
            return this;
        }

        public a O(String str) {
            this.f411963v = str;
            return this;
        }

        public a P(boolean z16) {
            this.f411958q = z16;
            return this;
        }

        public a Q(String str) {
            this.f411956o = str;
            return this;
        }

        public a R(boolean z16) {
            this.f411948g = z16;
            return this;
        }

        public a S(long j3) {
            this.f411953l = j3;
            return this;
        }

        public a T(String str) {
            this.f411946e = str;
            return this;
        }

        public a U(String str) {
            this.f411966y = str;
            return this;
        }

        public a V(long j3) {
            this.f411964w = j3;
            return this;
        }

        public a W(String str) {
            this.f411965x = str;
            return this;
        }
    }

    c(a aVar) {
        this.f411916a = aVar.f411942a;
        this.f411918c = aVar.f411947f;
        this.f411917b = aVar.f411946e;
        this.f411919d = aVar.f411944c;
        this.f411920e = aVar.f411945d;
        this.f411921f = aVar.f411948g;
        this.f411922g = aVar.f411949h;
        this.f411923h = aVar.f411943b;
        this.f411924i = aVar.f411950i;
        this.f411925j = aVar.f411951j;
        this.f411926k = aVar.f411952k;
        this.f411927l = aVar.f411953l;
        this.f411928m = aVar.f411954m;
        this.f411929n = aVar.f411955n;
        this.f411930o = aVar.f411956o;
        this.f411931p = aVar.f411957p;
        this.f411932q = aVar.f411958q;
        this.f411933r = aVar.f411959r;
        this.f411934s = aVar.f411960s;
        this.f411935t = aVar.f411961t;
        this.f411936u = aVar.f411962u;
        this.f411937v = aVar.f411963v;
        this.f411938w = aVar.f411964w;
        this.f411939x = aVar.f411965x;
        this.f411940y = aVar.f411966y;
        this.f411941z = aVar.f411967z;
        this.A = aVar.A;
    }

    public String a() {
        return this.f411928m;
    }

    public String b() {
        return this.f411918c;
    }

    public String c() {
        return this.f411934s;
    }

    public int d() {
        return this.f411923h;
    }

    public String e() {
        return this.f411916a;
    }

    public List<String> f() {
        return this.f411919d;
    }

    public HashMap<String, LocalMediaInfo> g() {
        return this.f411920e;
    }

    public ha3.b h() {
        String str;
        ha3.b bVar = new ha3.b("key_shuoshuo_draft_flash_show_publish_" + this.f411916a);
        bVar.f404617b = aj.c();
        bVar.f404620e = this.f411916a;
        List<String> list = this.f411919d;
        if (list != null && list.size() > 0) {
            bVar.f404621f = new ArrayList(this.f411919d);
        }
        bVar.f404622g = this.f411920e;
        String str2 = this.f411918c;
        if (str2 != null) {
            bVar.f404619d = QzoneEmotionUtils.emCodesToQQcodes(str2);
        }
        bVar.f404629n = this.f411921f;
        bVar.f404623h = this.f411925j;
        bVar.f404625j = this.f411922g;
        bVar.f404624i = System.currentTimeMillis();
        bVar.f404632q = this.f411926k;
        if (!TextUtils.isEmpty(this.f411924i)) {
            bVar.f404628m = this.f411924i;
        }
        long j3 = this.f411927l;
        if (j3 != -1) {
            bVar.f404633r = j3;
        }
        bVar.f404634s = this.f411928m;
        if (bVar.f404635t == null) {
            bVar.f404635t = new HashMap<>();
        }
        String str3 = this.f411917b;
        if (str3 != null) {
            bVar.f404635t.put("title", QzoneEmotionUtils.emCodesToQQcodes(str3));
        }
        HashMap<String, String> hashMap = bVar.f404635t;
        if (this.f411929n) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("feedType", str);
        if (!TextUtils.isEmpty(this.f411930o)) {
            bVar.f404635t.put("mSchoolName", this.f411930o);
            bVar.f404635t.put("mSchoolIsSelected", this.f411932q + "");
            bVar.f404635t.put("isOpenSchool", String.valueOf(this.f411933r));
        }
        int i3 = this.f411931p;
        if (i3 != 0) {
            bVar.f404635t.put("mOriginalReshipState", String.valueOf(i3));
        }
        if (!TextUtils.isEmpty(this.f411935t)) {
            bVar.f404635t.put("taskid", this.f411935t);
        }
        if (!TextUtils.isEmpty(this.f411936u)) {
            bVar.f404635t.put(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, this.f411936u);
        }
        if (!TextUtils.isEmpty(this.f411937v)) {
            bVar.f404635t.put("key_scheme", this.f411937v);
        }
        if (this.f411938w != 0 && !TextUtils.isEmpty(this.f411939x)) {
            bVar.f404635t.put("feedBindTroopId", String.valueOf(this.f411938w));
            bVar.f404635t.put("feedBindTroopName", String.valueOf(this.f411939x));
            bVar.f404635t.put("feedBindTroopIconUrl", String.valueOf(this.f411940y));
        }
        if (!TextUtils.isEmpty(this.f411941z)) {
            bVar.f404635t.put("declaration_id", this.f411941z);
        }
        DeclarationParams declarationParams = this.A;
        if (declarationParams != null) {
            bVar.f404636u = declarationParams;
        }
        int i16 = this.f411923h;
        if (i16 != 4 && i16 != 5) {
            bVar.f404626k = 0;
        } else {
            bVar.f404626k = 5;
        }
        return bVar;
    }

    public String toString() {
        return "WinkDraftParameter{missionId='" + this.f411916a + "', title='" + this.f411917b + "', content='" + this.f411918c + "', selectedImageList=" + this.f411919d + ", selectedMediaInfoMap=" + this.f411920e + ", isSyncQzoneChecked=" + this.f411921f + ", hasSelectedCover=" + this.f411922g + ", from=" + this.f411923h + ", clientKey='" + this.f411924i + "', poiInfo=" + this.f411925j + ", promotionItem='" + this.f411926k + "', taskId=" + this.f411927l + ", clientTraceId='" + this.f411928m + "', isPublicFeed=" + this.f411929n + ", schoolName='" + this.f411930o + "', originalReshipState='" + this.f411931p + "', schoolIsSelected=" + this.f411932q + ", isOpenSchool=" + this.f411933r + ", coverPath=" + this.f411934s + ", businessTaskId=" + this.f411935t + ", businessUserData=" + this.f411936u + ", scheme=" + this.f411937v + '}';
    }
}

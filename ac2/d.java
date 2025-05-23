package ac2;

import com.tencent.mobileqq.nearby.now.model.MedalItem;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$MedalInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RichTitleElement;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {
    public String A;
    public String B;
    public String D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public String f25826a;

    /* renamed from: b, reason: collision with root package name */
    public int f25827b;

    /* renamed from: c, reason: collision with root package name */
    public int f25828c;

    /* renamed from: d, reason: collision with root package name */
    public String f25829d;

    /* renamed from: e, reason: collision with root package name */
    public String f25830e;

    /* renamed from: f, reason: collision with root package name */
    public String f25831f;

    /* renamed from: g, reason: collision with root package name */
    public String f25832g;

    /* renamed from: h, reason: collision with root package name */
    public String f25833h;

    /* renamed from: i, reason: collision with root package name */
    public int f25834i;

    /* renamed from: m, reason: collision with root package name */
    public String f25838m;

    /* renamed from: p, reason: collision with root package name */
    public List<NowQQLiveHomepageProto$RichTitleElement> f25841p;

    /* renamed from: q, reason: collision with root package name */
    public MedalItem f25842q;

    /* renamed from: r, reason: collision with root package name */
    public String f25843r;

    /* renamed from: s, reason: collision with root package name */
    public String f25844s;

    /* renamed from: t, reason: collision with root package name */
    public String f25845t;

    /* renamed from: u, reason: collision with root package name */
    public long f25846u;

    /* renamed from: x, reason: collision with root package name */
    public String f25849x;

    /* renamed from: z, reason: collision with root package name */
    public int f25851z;

    /* renamed from: j, reason: collision with root package name */
    private long f25835j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f25836k = true;

    /* renamed from: l, reason: collision with root package name */
    public int f25837l = 0;

    /* renamed from: n, reason: collision with root package name */
    private String f25839n = null;

    /* renamed from: o, reason: collision with root package name */
    private List<String> f25840o = null;

    /* renamed from: v, reason: collision with root package name */
    public int f25847v = -16711936;

    /* renamed from: w, reason: collision with root package name */
    public int f25848w = -16711936;

    /* renamed from: y, reason: collision with root package name */
    public String f25850y = "NOW\u8fbe\u4eba";
    public boolean C = false;

    public String a() {
        if (this.f25839n == null) {
            List<NowQQLiveHomepageProto$RichTitleElement> list = this.f25841p;
            String str = "";
            if (list != null && list.size() != 0) {
                int size = this.f25841p.size();
                for (int i3 = 0; i3 < size; i3++) {
                    NowQQLiveHomepageProto$RichTitleElement nowQQLiveHomepageProto$RichTitleElement = this.f25841p.get(i3);
                    if (nowQQLiveHomepageProto$RichTitleElement.uint32_type.get() != 2) {
                        str = nowQQLiveHomepageProto$RichTitleElement.string_text.get();
                    }
                }
                this.f25839n = str;
            } else {
                this.f25839n = "";
            }
        }
        return this.f25839n;
    }

    public String b() {
        if (a() != null && this.f25839n.length() > 0) {
            return this.f25839n;
        }
        return this.f25844s;
    }

    public void c(List<NowQQLiveHomepageProto$MedalInfo> list) {
        NowQQLiveHomepageProto$MedalInfo nowQQLiveHomepageProto$MedalInfo = list.get(0);
        if (nowQQLiveHomepageProto$MedalInfo.medal_type.get() != 3) {
            if (this.f25842q == null) {
                this.f25842q = new MedalItem();
            }
            this.f25842q.f252683d = nowQQLiveHomepageProto$MedalInfo.medal_id.get();
            this.f25842q.f252684e = nowQQLiveHomepageProto$MedalInfo.medal_version.get();
            this.f25842q.f252688m = nowQQLiveHomepageProto$MedalInfo.medal_type.get();
            if (nowQQLiveHomepageProto$MedalInfo.medal_name.has()) {
                this.f25842q.f252685f = nowQQLiveHomepageProto$MedalInfo.medal_name.get().toStringUtf8();
            }
            if (nowQQLiveHomepageProto$MedalInfo.medal_bg.has()) {
                this.f25842q.H = nowQQLiveHomepageProto$MedalInfo.medal_bg.get();
            }
            if (nowQQLiveHomepageProto$MedalInfo.medal_frame.has()) {
                this.f25842q.I = nowQQLiveHomepageProto$MedalInfo.medal_frame.get();
            }
            if (nowQQLiveHomepageProto$MedalInfo.medal_level.has()) {
                this.f25842q.J = nowQQLiveHomepageProto$MedalInfo.medal_level.get();
            }
        }
    }
}

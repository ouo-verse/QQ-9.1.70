package jz3;

import android.text.TextUtils;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.util.m;
import java.util.HashMap;
import java.util.List;
import nz3.DiffInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements g {
    public int A;
    public int B;
    public String C;
    public long D;
    public long E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;

    /* renamed from: a, reason: collision with root package name */
    public String f411260a;

    /* renamed from: b, reason: collision with root package name */
    public long f411261b;

    /* renamed from: c, reason: collision with root package name */
    public long f411262c;

    /* renamed from: d, reason: collision with root package name */
    public long f411263d;

    /* renamed from: e, reason: collision with root package name */
    public String f411264e;

    /* renamed from: f, reason: collision with root package name */
    public String f411265f;

    /* renamed from: g, reason: collision with root package name */
    public String f411266g;

    /* renamed from: h, reason: collision with root package name */
    public String f411267h;

    /* renamed from: j, reason: collision with root package name */
    public List<DiffInfo> f411269j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public HashMap<String, String> f411270k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public HashMap<String, String> f411271l;

    /* renamed from: m, reason: collision with root package name */
    public String f411272m;

    /* renamed from: n, reason: collision with root package name */
    public int f411273n;

    /* renamed from: o, reason: collision with root package name */
    public String f411274o;

    /* renamed from: p, reason: collision with root package name */
    public String f411275p;

    /* renamed from: q, reason: collision with root package name */
    public String f411276q;

    /* renamed from: r, reason: collision with root package name */
    public String f411277r;

    /* renamed from: s, reason: collision with root package name */
    public int f411278s;

    /* renamed from: t, reason: collision with root package name */
    public String f411279t;

    /* renamed from: u, reason: collision with root package name */
    public int f411280u;

    /* renamed from: v, reason: collision with root package name */
    public int f411281v;

    /* renamed from: w, reason: collision with root package name */
    public List<String> f411282w;

    /* renamed from: x, reason: collision with root package name */
    public List<DiffInfo> f411283x;

    /* renamed from: y, reason: collision with root package name */
    public int f411284y;

    /* renamed from: z, reason: collision with root package name */
    public int f411285z;

    /* renamed from: i, reason: collision with root package name */
    public String f411268i = "";

    @Deprecated
    public boolean L = true;
    public String M = null;
    public boolean N = false;

    @Override // com.tencent.rdelivery.reshub.api.g
    @Nullable
    public String a() {
        return this.f411264e;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    @Nullable
    public String b() {
        return this.f411266g;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    public long c(long j3) {
        DiffInfo b16 = f.b(this, j3);
        if (b16 == null) {
            b16 = i(j3);
        }
        if (b16 != null) {
            return b16.getSize();
        }
        return 0L;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    @Nullable
    public String d() {
        return this.f411272m;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    @NotNull
    public String e() {
        return this.G;
    }

    public boolean f(String str) {
        if (l() && m.b(str, this.f411260a)) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return c.b(this.H, this.f411265f, this.f411264e);
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    public String getDescription() {
        return this.f411267h;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    @NotNull
    public String getResId() {
        return this.f411260a;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    public long getSize() {
        return this.f411263d;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    public String getTaskId() {
        return this.f411279t;
    }

    @Override // com.tencent.rdelivery.reshub.api.g
    public long getVersion() {
        return this.f411261b;
    }

    public boolean h(com.tencent.rdelivery.reshub.core.a aVar) {
        if (com.tencent.rdelivery.reshub.core.g.i(aVar, this)) {
            return b.d(this.f411271l, this.f411270k, this.G, true);
        }
        return c.b(this.G, this.f411265f, this.f411264e);
    }

    @Nullable
    public DiffInfo i(long j3) {
        List<DiffInfo> list = this.f411269j;
        if (list == null) {
            return null;
        }
        for (DiffInfo diffInfo : list) {
            if (diffInfo.j() && diffInfo.getVersion() == j3) {
                return diffInfo;
            }
        }
        return null;
    }

    @Nullable
    public DiffInfo j(String str) {
        if (this.f411269j != null && str != null && str.length() != 0) {
            for (DiffInfo diffInfo : this.f411269j) {
                if (diffInfo.j() && diffInfo.getOld_md5().equals(str)) {
                    return diffInfo;
                }
            }
        }
        return null;
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.C);
    }

    public boolean l() {
        if (!m.a(this.f411260a) && !m.a(this.f411264e) && this.f411261b > 0 && this.f411263d > 0 && !m.a(this.f411266g)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ResConfig{id='" + this.f411260a + "', version=" + this.f411261b + ", size=" + this.f411263d + ", md5='" + this.f411264e + "', crc32='" + this.f411265f + "', downloadUrl='" + this.f411266g + "', diffInfoList=" + this.f411269j + ", innerMd5=" + this.f411270k + ", innerCrc32=" + this.f411271l + ", fileExtra='" + this.f411272m + "', local='" + this.G + "', originLocal='" + this.H + "', compOrigLocal='" + this.J + "', needUnzip=" + this.L + ", resType=" + this.f411268i + ", description=" + this.f411267h + ", isLoadFromPresetAssets=" + this.N + ", allowAssetDowngrade=" + this.f411285z + ", presetResAssetPath='" + this.M + "', bigResDiffInfoList=" + this.f411283x + '}';
    }
}

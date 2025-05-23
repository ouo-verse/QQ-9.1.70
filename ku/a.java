package ku;

import com.tencent.av.business.manager.pendant.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private String f413031a;

    /* renamed from: b, reason: collision with root package name */
    private String f413032b;

    /* renamed from: c, reason: collision with root package name */
    private String f413033c;

    /* renamed from: d, reason: collision with root package name */
    private String f413034d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f413035e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f413036f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f413037g;

    public boolean a() {
        return this.f413037g;
    }

    public void b(boolean z16) {
        this.f413037g = z16;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getDesc() {
        return null;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getIconUrl() {
        return this.f413034d;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getId() {
        return this.f413031a;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getMd5() {
        return this.f413033c;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public int getPlatform() {
        return 0;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getResUrl() {
        return this.f413032b;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public String getVersion() {
        return null;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public boolean isUsable() {
        return this.f413035e;
    }

    public void setIconUrl(String str) {
        this.f413034d = str;
    }

    public void setId(String str) {
        this.f413031a = str;
    }

    public void setMd5(String str) {
        this.f413033c = str;
    }

    public void setPredownload(boolean z16) {
        this.f413036f = z16;
    }

    public void setResUrl(String str) {
        this.f413032b = str;
    }

    @Override // com.tencent.av.business.manager.pendant.c
    public void setUsable(boolean z16) {
        this.f413035e = z16;
    }

    @NotNull
    public String toString() {
        return "ZplanAvatarItem{\n\tid = " + this.f413031a + "\n\tresUrl = " + this.f413032b + "\n\tmd5=" + this.f413033c + "\n\tusable=" + this.f413035e + "\n\t}";
    }
}

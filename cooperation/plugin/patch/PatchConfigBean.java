package cooperation.plugin.patch;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
/* loaded from: classes28.dex */
public class PatchConfigBean {
    public String from;
    public String md5;

    /* renamed from: op, reason: collision with root package name */
    public String f390332op;

    /* renamed from: to, reason: collision with root package name */
    public String f390333to;

    public PatchConfigBean() {
    }

    @NonNull
    public String toString() {
        return "{op:" + this.f390332op + ",to:" + this.f390333to + ",from:" + this.from + ",md5:" + this.md5;
    }

    public PatchConfigBean(String str, String str2, String str3, String str4) {
        this.f390332op = str;
        this.f390333to = str2;
        this.from = str3;
        this.md5 = str4;
    }

    public PatchConfigBean(PatchConfigBean patchConfigBean) {
        this(patchConfigBean.f390332op, patchConfigBean.f390333to, patchConfigBean.from, patchConfigBean.md5);
    }
}

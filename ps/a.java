package ps;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.utils.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f427066a;

    /* renamed from: b, reason: collision with root package name */
    private String f427067b;

    public a(@Nullable String str, @Nullable String str2) {
        this.f427066a = str;
        this.f427067b = str2;
    }

    @Nullable
    public String a() {
        return this.f427066a;
    }

    @Nullable
    public String b() {
        return this.f427067b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (StringUtil.isEmpty(this.f427066a) || StringUtil.isEmpty(this.f427067b) || aVar == null || !this.f427066a.equals(aVar.a()) || !this.f427067b.equals(aVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f427067b;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (527 + hashCode) * 31;
        String str2 = this.f427066a;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }
}

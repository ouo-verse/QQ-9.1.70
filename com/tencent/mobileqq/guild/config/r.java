package com.tencent.mobileqq.guild.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.aw;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes13.dex */
public class r implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private int f216166d;

    /* renamed from: e, reason: collision with root package name */
    private int f216167e;

    /* renamed from: f, reason: collision with root package name */
    private int f216168f;

    public r() {
    }

    public static r e(int i3) {
        if (!aw.a().containsKey(Integer.valueOf(i3))) {
            QLog.w("GuildAvatarIconInfo", 1, "GuildAvatarIconInfo get error state:" + i3);
            return new r();
        }
        return aw.a().get(Integer.valueOf(i3));
    }

    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public r clone() throws CloneNotSupportedException {
        r rVar = (r) super.clone();
        rVar.f216166d = this.f216166d;
        rVar.f216167e = this.f216167e;
        rVar.f216168f = this.f216168f;
        return rVar;
    }

    public int b() {
        return this.f216168f;
    }

    public int c() {
        return this.f216167e;
    }

    public int d() {
        return this.f216166d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f216166d == rVar.f216166d && this.f216167e == rVar.f216167e && this.f216168f == rVar.f216168f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f216166d), Integer.valueOf(this.f216167e), Integer.valueOf(this.f216168f));
    }

    public String toString() {
        return "GuildAvatarIconInfo{state=" + this.f216166d + ", priority=" + this.f216167e + ", iconResId='" + this.f216168f + "'}";
    }

    public r(int i3, int i16, int i17) {
        this.f216166d = i3;
        this.f216167e = i16;
        this.f216168f = i17;
    }
}

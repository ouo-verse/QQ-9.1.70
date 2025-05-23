package com.tencent.mobileqq.guild.main.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class d implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public String f227153d;

    /* renamed from: e, reason: collision with root package name */
    public long f227154e;

    /* renamed from: f, reason: collision with root package name */
    public IGProChannelInfo f227155f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f227156h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f227157i = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f227158m = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // 
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() throws CloneNotSupportedException {
        d dVar = (d) super.clone();
        dVar.f227156h = this.f227156h;
        dVar.f227153d = this.f227153d;
        dVar.f227154e = this.f227154e;
        dVar.f227157i = this.f227157i;
        dVar.f227158m = this.f227158m;
        return dVar;
    }

    public boolean b() {
        return false;
    }

    public d c(@NonNull c cVar) {
        if (!TextUtils.isEmpty(cVar.b())) {
            this.f227153d = cVar.b();
        }
        if (cVar.a() != 0) {
            this.f227154e = cVar.a();
        }
        this.f227155f = cVar.c();
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f227156h == dVar.f227156h && Objects.equals(this.f227153d, dVar.f227153d) && Objects.equals(Long.valueOf(this.f227154e), Long.valueOf(dVar.f227154e)) && this.f227157i == dVar.f227157i && this.f227158m == dVar.f227158m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f227153d, Long.valueOf(this.f227154e), Boolean.valueOf(this.f227156h), Boolean.valueOf(this.f227157i), Boolean.valueOf(this.f227158m));
    }
}

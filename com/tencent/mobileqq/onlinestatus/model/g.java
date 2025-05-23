package com.tencent.mobileqq.onlinestatus.model;

import com.tencent.mobileqq.DiyStatusEmoInfo;
import java.util.Objects;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public AppRuntime.Status f256022a;

    /* renamed from: b, reason: collision with root package name */
    public long f256023b;

    /* renamed from: c, reason: collision with root package name */
    public DiyStatusEmoInfo f256024c;

    public g(AppRuntime.Status status, long j3) {
        this.f256022a = status;
        this.f256023b = j3;
    }

    public boolean a(g gVar) {
        if (gVar == null || this.f256023b != gVar.f256023b || !Objects.equals(this.f256022a, gVar.f256022a)) {
            return false;
        }
        return true;
    }
}

package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSmobaArchiveTemplate;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ca implements en {

    /* renamed from: a, reason: collision with root package name */
    private final GProSmobaArchiveTemplate f265802a;

    public ca(GProSmobaArchiveTemplate gProSmobaArchiveTemplate) {
        this.f265802a = gProSmobaArchiveTemplate;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.en
    public int getGradeLevel() {
        return this.f265802a.getGradeLevel();
    }

    @NotNull
    public String toString() {
        return "GProSmobaArchiveTemplateInfo{smobaArchiveTemplate=" + this.f265802a + "}";
    }
}

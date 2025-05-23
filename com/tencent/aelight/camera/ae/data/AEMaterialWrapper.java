package com.tencent.aelight.camera.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEMaterialWrapper {

    /* renamed from: a, reason: collision with root package name */
    public String f63553a;

    /* renamed from: b, reason: collision with root package name */
    public MetaMaterial f63554b;

    /* renamed from: c, reason: collision with root package name */
    public String f63555c;

    /* renamed from: d, reason: collision with root package name */
    public String f63556d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f63557e;

    /* renamed from: f, reason: collision with root package name */
    public int f63558f;

    /* renamed from: g, reason: collision with root package name */
    public int f63559g;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface DownloadState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface WrapperType {
    }

    public String toString() {
        return "AEMaterialWrapper{id='" + this.f63553a + "', material=" + this.f63554b + ", state=" + this.f63558f + ", type=" + this.f63559g + '}';
    }
}

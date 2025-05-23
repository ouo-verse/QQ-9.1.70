package com.tencent.aelight.camera.ae.flashshow.zshow;

import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WinkZShowContext {

    /* renamed from: a, reason: collision with root package name */
    String f65185a = "";

    /* renamed from: b, reason: collision with root package name */
    List<ClipSource> f65186b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    UEState f65187c = UEState.PREPARE;

    /* renamed from: d, reason: collision with root package name */
    int f65188d = 0;

    /* renamed from: e, reason: collision with root package name */
    String f65189e = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public enum FilamentState {
        PREPARE,
        LOADING,
        SUCC,
        EXPORTING,
        FAILED
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    enum UEState {
        PREPARE,
        LOADING,
        SUCC,
        FAILED
    }
}

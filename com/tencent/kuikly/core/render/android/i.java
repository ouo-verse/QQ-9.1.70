package com.tencent.kuikly.core.render.android;

import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final /* synthetic */ class i {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f118113a;

    static {
        int[] iArr = new int[KuiklyRenderCoreExecuteMode.values().length];
        f118113a = iArr;
        iArr[KuiklyRenderCoreExecuteMode.JVM.ordinal()] = 1;
        iArr[KuiklyRenderCoreExecuteMode.SO.ordinal()] = 2;
        iArr[KuiklyRenderCoreExecuteMode.JS.ordinal()] = 3;
        iArr[KuiklyRenderCoreExecuteMode.DEX.ordinal()] = 4;
    }
}

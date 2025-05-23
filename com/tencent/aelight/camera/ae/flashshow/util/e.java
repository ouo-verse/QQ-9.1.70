package com.tencent.aelight.camera.ae.flashshow.util;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/util/e;", "", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "", "b", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f65107a = new e();

    e() {
    }

    @JvmStatic
    public static final boolean a(AEMaterialMetaData material) {
        return material == null || Intrinsics.areEqual(material.f69050id, "0");
    }

    @JvmStatic
    public static final boolean b(AEMaterialMetaData material) {
        return (material == null || Intrinsics.areEqual(material.f69050id, "0")) ? false : true;
    }
}

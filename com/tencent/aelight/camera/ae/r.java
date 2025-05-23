package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0003B#\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aelight/camera/ae/r;", "", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "a", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "b", "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "", "I", "c", "()I", "type", "", "Z", "()Z", "forceUpdate", "<init>", "(Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;IZ)V", "d", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AEMaterialMetaData material;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean forceUpdate;

    public r(AEMaterialMetaData aEMaterialMetaData, int i3, boolean z16) {
        this.material = aEMaterialMetaData;
        this.type = i3;
        this.forceUpdate = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    /* renamed from: b, reason: from getter */
    public final AEMaterialMetaData getMaterial() {
        return this.material;
    }

    /* renamed from: c, reason: from getter */
    public final int getType() {
        return this.type;
    }
}

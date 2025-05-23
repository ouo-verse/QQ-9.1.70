package com.tencent.mobileqq.wink.editor.hdr;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.utils.ar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0011\u0010\f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/e;", "", "", "enable", "", "a", "d", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "c", "b", "()Z", "enableDebug", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f320476a = new e();

    e() {
    }

    public final void a(boolean enable) {
        ar.f326685a.m("mmkv_key_enable_test_material", enable);
    }

    public final boolean b() {
        return false;
    }

    @NotNull
    public final List<MetaMaterial> c() {
        ArrayList arrayList = new ArrayList();
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "styleextention_test_gif";
        com.tencent.mobileqq.wink.editor.c.B1(metaMaterial, "\u6d4b\u8bd5gif");
        metaMaterial.showName = "\u6d4b\u8bd5gif";
        com.tencent.mobileqq.wink.editor.c.q1(metaMaterial, "test_gif");
        com.tencent.mobileqq.wink.editor.c.K1(metaMaterial, true);
        com.tencent.mobileqq.wink.editor.c.H1(metaMaterial, "https://xmaterial.tu.qq.com/xmaterial/materials/2b846c08-66b6-11ef-bc28-5254001af036-1000x1500.jpg");
        com.tencent.mobileqq.wink.editor.c.C1(metaMaterial, "1:1");
        com.tencent.mobileqq.wink.editor.c.u1(metaMaterial, true);
        arrayList.add(metaMaterial);
        MetaMaterial videoMaterial = metaMaterial.copy();
        videoMaterial.f30533id = "styleextention_test_video";
        Intrinsics.checkNotNullExpressionValue(videoMaterial, "videoMaterial");
        com.tencent.mobileqq.wink.editor.c.B1(videoMaterial, "\u6d4b\u8bd5mp4");
        videoMaterial.showName = "\u6d4b\u8bd5mp4";
        com.tencent.mobileqq.wink.editor.c.q1(videoMaterial, "test_mp4");
        com.tencent.mobileqq.wink.editor.c.C1(videoMaterial, "1:1");
        com.tencent.mobileqq.wink.editor.c.u1(videoMaterial, true);
        arrayList.add(videoMaterial);
        MetaMaterial invalidMaterial = videoMaterial.copy();
        invalidMaterial.f30533id = "styleextention_test_invalid";
        Intrinsics.checkNotNullExpressionValue(invalidMaterial, "invalidMaterial");
        com.tencent.mobileqq.wink.editor.c.B1(invalidMaterial, "\u6d4b\u8bd5\u65e0\u6548\u7d20\u6750");
        invalidMaterial.showName = "\u6d4b\u8bd5\u65e0\u6548\u7d20\u6750";
        com.tencent.mobileqq.wink.editor.c.q1(invalidMaterial, "test_invalid");
        com.tencent.mobileqq.wink.editor.c.u1(invalidMaterial, true);
        arrayList.add(invalidMaterial);
        return arrayList;
    }

    public final boolean d() {
        if (!ar.f326685a.c("mmkv_key_enable_test_material", false) || !b()) {
            return false;
        }
        return true;
    }
}

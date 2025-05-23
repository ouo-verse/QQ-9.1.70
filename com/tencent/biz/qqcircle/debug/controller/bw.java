package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/debug/controller/bw;", "Lcom/tencent/biz/qqcircle/debug/controller/bs;", "", "e", "c", "d", "", "Lcom/tencent/qcircle/cooperation/config/debug/b;", "list", "", "l", "", tl.h.F, "b", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bw extends bs {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f84239e = QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_COMPRESS_MODE.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.d, com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 9999;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @Nullable
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String d() {
        return f84239e;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String e() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f182003fa);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qcircle_debug_compress_soft_mode)");
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    protected void l(@Nullable List<com.tencent.qcircle.cooperation.config.debug.b> list) {
        if (list != null) {
            list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182013fb), 0));
            list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182023fc), 1));
            list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182043fe), 2));
            list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182033fd), 3));
        }
    }
}

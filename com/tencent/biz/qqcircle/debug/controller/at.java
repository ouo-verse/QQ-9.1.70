package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/debug/controller/at;", "Lcom/tencent/biz/qqcircle/debug/controller/bs;", "", "e", "c", "d", "", tl.h.F, "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class at extends bs {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String c() {
        return "";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String d() {
        return QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_QUIC_PIC_DOWNLOADER.name();
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String e() {
        return "Feed \u4e0b\u8f7d\u6253\u5f00 quic";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 1;
    }
}

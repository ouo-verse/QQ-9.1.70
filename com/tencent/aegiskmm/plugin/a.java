package com.tencent.aegiskmm.plugin;

import com.tencent.aegiskmm.bean.AegisLogLevel;
import com.tencent.aegiskmm.bean.AegisLogType;
import com.tencent.aegiskmm.bean.NormalLog;
import com.tencent.aegiskmm.bean.g;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aegiskmm/plugin/a;", "Lcom/tencent/aegiskmm/bean/g;", "", "a", "b", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class a extends g {
    @Override // com.tencent.aegiskmm.bean.h
    public void b() {
        c().a(new NormalLog("pv", AegisLogLevel.REPORT, AegisLogType.PV, null, 8, null));
    }

    @Override // com.tencent.aegiskmm.bean.h
    public void a() {
    }
}

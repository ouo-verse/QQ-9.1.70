package com.tencent.mobileqq.zplan.authorize.api;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", "Ljava/io/Serializable;", QzoneIPCModule.RESULT_CODE, "", "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "(ILcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "processInner", "", "getResultCode", "()I", "setResultCode", "(I)V", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setSource", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "isPassed", "isProcessedInner", "setProcessInner", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public class CheckResult implements Serializable {
    private boolean processInner;
    private int resultCode;
    private ZootopiaSource source;

    public CheckResult(int i3, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.resultCode = i3;
        this.source = source;
        this.processInner = true;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final ZootopiaSource getSource() {
        return this.source;
    }

    public final boolean isPassed() {
        return this.resultCode == 0;
    }

    /* renamed from: isProcessedInner, reason: from getter */
    public final boolean getProcessInner() {
        return this.processInner;
    }

    public final void setProcessInner(boolean processInner) {
        this.processInner = processInner;
    }

    public final void setResultCode(int i3) {
        this.resultCode = i3;
    }

    public final void setSource(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.source = zootopiaSource;
    }
}

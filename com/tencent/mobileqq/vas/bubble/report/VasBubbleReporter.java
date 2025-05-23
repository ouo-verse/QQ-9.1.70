package com.tencent.mobileqq.vas.bubble.report;

import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/report/VasBubbleReporter;", "", "()V", VasBubbleReporter.BUBBLE_DRAW, "", "ERROR_BUBBLE_CREATE", "ERROR_DRAW_FILE_EXIST", "ERROR_FILE_DOWNLOAD", "TAG", "inEnable", "", "getInEnable", "()Z", "setInEnable", "(Z)V", "report", "", "errorMsg", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasBubbleReporter {

    @NotNull
    private static final String BUBBLE_DRAW = "BUBBLE_DRAW";

    @NotNull
    public static final String ERROR_BUBBLE_CREATE = "\u6c14\u6ce1\u7ed8\u5236\u5f02\u5e38\u3002id:{id}, msg:{msg}";

    @NotNull
    public static final String ERROR_DRAW_FILE_EXIST = "\u6c14\u6ce1\u6587\u4ef6\u4e0d\u5b58\u5728,\u7ed8\u5236\u5931\u8d25\u3002id:{id}";

    @NotNull
    public static final String ERROR_FILE_DOWNLOAD = "\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25\u3002errorCode:{errorCode}, id={id}, httpCode:{httpCode}";

    @NotNull
    private static final String TAG = "VasBubbleReporter";

    @NotNull
    public static final VasBubbleReporter INSTANCE = new VasBubbleReporter();
    private static boolean inEnable = VasNtToggle.VAS_BUBBLE_REPORT_SWITCH.isEnable(true);

    VasBubbleReporter() {
    }

    public final boolean getInEnable() {
        return inEnable;
    }

    public final void report(@NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (!inEnable) {
            return;
        }
        VasNtCommonReporter.getBubble().setNum1(MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin()).setValue1(BUBBLE_DRAW).setValue2(errorMsg).reportEveryDay(errorMsg);
    }

    public final void setInEnable(boolean z16) {
        inEnable = z16;
    }
}

package com.tencent.mobileqq.wink.editor.aielimination.model;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;", "", "status", "", "(Ljava/lang/String;II)V", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "SHARE", "OPEN_YELLOW_DIAMOND", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum AIEliminationButtonStatus {
    NORMAL(1),
    SHARE(2),
    OPEN_YELLOW_DIAMOND(3);

    private final int status;

    AIEliminationButtonStatus(int i3) {
        this.status = i3;
    }

    public final int getStatus() {
        return this.status;
    }
}

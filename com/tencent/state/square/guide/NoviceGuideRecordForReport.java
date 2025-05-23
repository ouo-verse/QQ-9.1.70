package com.tencent.state.square.guide;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/guide/NoviceGuideRecordForReport;", "", "hasPlayBornAnim", "", "hasShowCreateRolePage", "hasPlayPublishStatusAnim", "(ZZZ)V", "getDynamicType", "", "getPublishStatusDynamicType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class NoviceGuideRecordForReport {
    private final boolean hasPlayBornAnim;
    private final boolean hasPlayPublishStatusAnim;
    private final boolean hasShowCreateRolePage;

    public NoviceGuideRecordForReport(boolean z16, boolean z17, boolean z18) {
        this.hasPlayBornAnim = z16;
        this.hasShowCreateRolePage = z17;
        this.hasPlayPublishStatusAnim = z18;
    }

    public final int getDynamicType() {
        boolean z16 = this.hasPlayBornAnim;
        if ((z16 || this.hasShowCreateRolePage) && this.hasPlayPublishStatusAnim) {
            return 3;
        }
        if (z16 || this.hasShowCreateRolePage) {
            return 1;
        }
        return this.hasPlayPublishStatusAnim ? 2 : 0;
    }

    public final int getPublishStatusDynamicType() {
        return this.hasPlayPublishStatusAnim ? 1 : 0;
    }
}

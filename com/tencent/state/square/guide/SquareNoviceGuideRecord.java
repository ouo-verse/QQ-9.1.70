package com.tencent.state.square.guide;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/guide/SquareNoviceGuideRecord;", "", "()V", "blockByMe", "", "getBlockByMe", "()Z", "setBlockByMe", "(Z)V", "hasPlayedPublishStatusAnim", "hasPlayedPublishStatusAnimForDetailReport", "hasPlayedRoleBornAnim", "hasPlayedRoleBornAnimForDetailReport", "hasShowedCreateRolePage", "hasShowedCreateRolePageForDetailReport", "playingPublishStatusAnim", "playingRoleBornAnim", "rolePageResult", "getRolePageResult", "()Ljava/lang/Boolean;", "setRolePageResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showingCreateRolePage", "getReportParamsForDetailPage", "Lcom/tencent/state/square/guide/NoviceGuideRecordForReport;", "reset", "isPlayingPublishStatusAnim", "isPlayingRoleBornAnim", "isShowingCreateRolePage", "recordCreateRolePageEnd", "", "recordCreateRolePageStart", "recordPublishStatusAnimEnd", "recordPublishStatusAnimStart", "recordRoleBornAnimEnd", "recordRoleBornAnimStart", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareNoviceGuideRecord {
    private boolean blockByMe;
    private boolean hasPlayedPublishStatusAnim;
    private boolean hasPlayedPublishStatusAnimForDetailReport;
    private boolean hasPlayedRoleBornAnim;
    private boolean hasPlayedRoleBornAnimForDetailReport;
    private boolean hasShowedCreateRolePage;
    private boolean hasShowedCreateRolePageForDetailReport;
    private boolean playingPublishStatusAnim;
    private boolean playingRoleBornAnim;
    private Boolean rolePageResult;
    private boolean showingCreateRolePage;

    public final boolean getBlockByMe() {
        return this.blockByMe;
    }

    public final NoviceGuideRecordForReport getReportParamsForDetailPage(boolean reset) {
        NoviceGuideRecordForReport noviceGuideRecordForReport = new NoviceGuideRecordForReport(this.hasPlayedRoleBornAnimForDetailReport, this.hasShowedCreateRolePageForDetailReport, this.hasPlayedPublishStatusAnimForDetailReport);
        if (reset) {
            this.hasPlayedRoleBornAnimForDetailReport = false;
            this.hasShowedCreateRolePageForDetailReport = false;
            this.hasPlayedPublishStatusAnimForDetailReport = false;
        }
        return noviceGuideRecordForReport;
    }

    public final Boolean getRolePageResult() {
        return this.rolePageResult;
    }

    /* renamed from: hasPlayedPublishStatusAnim, reason: from getter */
    public final boolean getHasPlayedPublishStatusAnim() {
        return this.hasPlayedPublishStatusAnim;
    }

    /* renamed from: hasPlayedRoleBornAnim, reason: from getter */
    public final boolean getHasPlayedRoleBornAnim() {
        return this.hasPlayedRoleBornAnim;
    }

    /* renamed from: hasShowedCreateRolePage, reason: from getter */
    public final boolean getHasShowedCreateRolePage() {
        return this.hasShowedCreateRolePage;
    }

    /* renamed from: isPlayingPublishStatusAnim, reason: from getter */
    public final boolean getPlayingPublishStatusAnim() {
        return this.playingPublishStatusAnim;
    }

    /* renamed from: isPlayingRoleBornAnim, reason: from getter */
    public final boolean getPlayingRoleBornAnim() {
        return this.playingRoleBornAnim;
    }

    /* renamed from: isShowingCreateRolePage, reason: from getter */
    public final boolean getShowingCreateRolePage() {
        return this.showingCreateRolePage;
    }

    public final void setBlockByMe(boolean z16) {
        this.blockByMe = z16;
    }

    public final void setRolePageResult(Boolean bool) {
        this.rolePageResult = bool;
    }

    public final void recordCreateRolePageEnd() {
        this.showingCreateRolePage = false;
    }

    public final void recordCreateRolePageStart() {
        this.showingCreateRolePage = true;
        this.hasShowedCreateRolePage = true;
        this.hasShowedCreateRolePageForDetailReport = true;
    }

    public final void recordPublishStatusAnimEnd() {
        this.playingPublishStatusAnim = false;
    }

    public final void recordPublishStatusAnimStart() {
        this.playingPublishStatusAnim = true;
        this.hasPlayedPublishStatusAnim = true;
        this.hasPlayedPublishStatusAnimForDetailReport = true;
    }

    public final void recordRoleBornAnimEnd() {
        this.playingRoleBornAnim = false;
    }

    public final void recordRoleBornAnimStart() {
        this.playingRoleBornAnim = true;
        this.hasPlayedRoleBornAnim = true;
        this.hasPlayedRoleBornAnimForDetailReport = true;
    }

    public static /* synthetic */ NoviceGuideRecordForReport getReportParamsForDetailPage$default(SquareNoviceGuideRecord squareNoviceGuideRecord, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return squareNoviceGuideRecord.getReportParamsForDetailPage(z16);
    }
}

package com.tencent.mobileqq.qqlive.api;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/IODAnchorJudgeStrategyAdapter;", "", "acquireAnchorUid", "", "roomId", "isOpenAnchorProfile", "", "uid", "isShowGiftBtn", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public interface IODAnchorJudgeStrategyAdapter {
    long acquireAnchorUid(long roomId);

    boolean isOpenAnchorProfile(long roomId, long uid);

    boolean isShowGiftBtn();
}

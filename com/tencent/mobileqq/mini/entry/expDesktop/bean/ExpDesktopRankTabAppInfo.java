package com.tencent.mobileqq.mini.entry.expDesktop.bean;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0003J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mainTitle", "", "rankSubTabAppInfo", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankSubTabAppInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "mMainTitle", "mRankSubTabAppInfo", "getMainTitle", "getRankSubTabAppInfo", "getViewType", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopRankTabAppInfo extends DesktopItemInfo {
    private String mMainTitle;
    private List<ExpDesktopRankSubTabAppInfo> mRankSubTabAppInfo;

    public ExpDesktopRankTabAppInfo(String mainTitle, List<ExpDesktopRankSubTabAppInfo> rankSubTabAppInfo) {
        Intrinsics.checkNotNullParameter(mainTitle, "mainTitle");
        Intrinsics.checkNotNullParameter(rankSubTabAppInfo, "rankSubTabAppInfo");
        this.mMainTitle = "";
        CollectionsKt__CollectionsKt.emptyList();
        this.mMainTitle = mainTitle;
        this.mRankSubTabAppInfo = rankSubTabAppInfo;
    }

    /* renamed from: getMainTitle, reason: from getter */
    public final String getMMainTitle() {
        return this.mMainTitle;
    }

    public final List<ExpDesktopRankSubTabAppInfo> getRankSubTabAppInfo() {
        return this.mRankSubTabAppInfo;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 6;
    }
}

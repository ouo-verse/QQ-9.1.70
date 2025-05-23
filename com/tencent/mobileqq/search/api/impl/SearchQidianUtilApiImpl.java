package com.tencent.mobileqq.search.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.api.ISearchQidianUtilApi;
import com.tencent.qidian.QidianManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchQidianUtilApiImpl;", "Lcom/tencent/mobileqq/search/api/ISearchQidianUtilApi;", "()V", "addShowUin", "", "app", "Lcom/tencent/common/app/AppInterface;", "uin", "", "showUin", "isCrmMaster", "", AppConstants.Key.CSPECIAL_FLAG, "", "isQidianMaster", "updateQidianAccountType", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SearchQidianUtilApiImpl implements ISearchQidianUtilApi {
    @Override // com.tencent.mobileqq.search.api.ISearchQidianUtilApi
    public void addShowUin(@Nullable AppInterface app, @Nullable String uin, @Nullable String showUin) {
        Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QidianManager.h((QQAppInterface) app, uin, showUin);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchQidianUtilApi
    public boolean isCrmMaster(int cSpecialFlag) {
        return QidianManager.E(cSpecialFlag);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchQidianUtilApi
    public boolean isQidianMaster(int cSpecialFlag) {
        return QidianManager.O(cSpecialFlag);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchQidianUtilApi
    public void updateQidianAccountType(@NotNull AppInterface app, int cSpecialFlag, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        QidianManager.m0((QQAppInterface) app, cSpecialFlag, uin);
    }
}

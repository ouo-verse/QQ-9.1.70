package com.tencent.qqnt.ntrelation.vasinfo.api.impl;

import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import hx3.a;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J*\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010H\u0016J2\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010H\u0016J:\u0010\u0015\u001a\u00020\r2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0016J*\u0010\u0018\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/impl/QQVasInfoApiNtImpl;", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "getVasSimpleInfoWithUid", "uid", "Lhx3/b;", "Lkx3/a;", "iQueryGeneralDataCallback", "", "getVasInfoWithUid", "ntVasDetailInfo", "Lhx3/c;", "updateCallback", "updateVasDetailInfo", "originDetailInfo", "changedDetailInfo", "accurateUpdateVasDetailInfo", "Lhx3/a;", "deleteCallback", "deleteVasDetailInfo", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQVasInfoApiNtImpl implements IQQVasInfoApi {
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void accurateUpdateVasDetailInfo(@NotNull ArrayList<NTVasSimpleInfo> changedDetailInfo, @Nullable String trace, @Nullable c<NTVasSimpleInfo> updateCallback) {
        Intrinsics.checkNotNullParameter(changedDetailInfo, "changedDetailInfo");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void deleteVasDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable a<kx3.a> deleteCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void getVasInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<kx3.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    @Nullable
    public ArrayList<NTVasSimpleInfo> getVasSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void updateVasDetailInfo(@NotNull kx3.a ntVasDetailInfo, @Nullable String trace, @Nullable c<kx3.a> updateCallback) {
        Intrinsics.checkNotNullParameter(ntVasDetailInfo, "ntVasDetailInfo");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void updateVasDetailInfo(@NotNull kx3.a originDetailInfo, @NotNull kx3.a changedDetailInfo, @Nullable String trace, @Nullable c<kx3.a> updateCallback) {
        Intrinsics.checkNotNullParameter(originDetailInfo, "originDetailInfo");
        Intrinsics.checkNotNullParameter(changedDetailInfo, "changedDetailInfo");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

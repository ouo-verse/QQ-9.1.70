package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J8\u0010\u000e\u001a\u00020\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J*\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0016J:\u0010\u0013\u001a\u00020\r2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0002j\b\u0012\u0004\u0012\u00020\u000b`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0016J*\u0010\u0017\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015H\u0016J:\u0010\u0019\u001a\u00020\r2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/impl/QQZoneInfoApiNtImpl;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IQQZoneInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "getZoneSimpleInfoWithUid", "uid", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "iQueryGeneralDataCallback", "", "getZoneDetailWithUid", "uidList", "ntZoneDetailInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateZoneDetailInfo", "ntZoneDetailInfoList", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteZoneDetailInfo", "ntZoneSimpleInfoList", "updateZoneSimpleInfo", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQZoneInfoApiNtImpl implements IQQZoneInfoApi {
    static IPatchRedirector $redirector_;

    public QQZoneInfoApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void deleteZoneDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void getZoneDetailWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> getZoneSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneDetailInfo(@NotNull com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, ntZoneDetailInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneDetailInfo, "ntZoneDetailInfo");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> ntZoneSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, ntZoneSimpleInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneSimpleInfoList, "ntZoneSimpleInfoList");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void getZoneDetailWithUid(@NotNull ArrayList<String> uidList, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uidList, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneDetailInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> ntZoneDetailInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, ntZoneDetailInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneDetailInfoList, "ntZoneDetailInfoList");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

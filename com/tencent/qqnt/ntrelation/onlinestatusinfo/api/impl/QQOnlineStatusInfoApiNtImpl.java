package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J8\u0010\r\u001a\u00020\f2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J:\u0010\u0011\u001a\u00020\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0016J*\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/QQOnlineStatusInfoApiNtImpl;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IQQOnlineStatusInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "getOnlineStatusSimpleInfoWithUid", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "iQueryGeneralDataCallback", "", "getOnlineStatusInfoWithUid", "ntOnlineStatusDetailInfoList", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateOnlineStatusInfo", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteOnlineStatusInfo", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQOnlineStatusInfoApiNtImpl implements IQQOnlineStatusInfoApi {
    static IPatchRedirector $redirector_;

    public QQOnlineStatusInfoApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void deleteOnlineStatusInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void getOnlineStatusInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uids, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    @Nullable
    public ArrayList<c> getOnlineStatusSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void updateOnlineStatusInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> ntOnlineStatusDetailInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, ntOnlineStatusDetailInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOnlineStatusDetailInfoList, "ntOnlineStatusDetailInfoList");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

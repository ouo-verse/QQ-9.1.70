package com.tencent.qqnt.ntrelation.intimateinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J:\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016J*\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH\u0016J \u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/QQIntimateInfoApiNtImpl;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IQQIntimateInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "getIntimateSimpleInfoWithUid", "ntIntimateSimpleInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "", "accurateUpdateIntimateInfo", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteIntimateInfo", "Lhx3/b;", "", "iQueryGeneralDataCallback", "getBindIntimateRelationshipFriendCount", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQIntimateInfoApiNtImpl implements IQQIntimateInfoApi {
    static IPatchRedirector $redirector_;

    public QQIntimateInfoApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void accurateUpdateIntimateInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> ntIntimateSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, ntIntimateSimpleInfo, trace, iUpdateGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(ntIntimateSimpleInfo, "ntIntimateSimpleInfo");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void deleteIntimateInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, trace, iDeleteGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void getBindIntimateRelationshipFriendCount(@Nullable String trace, @NotNull hx3.b<Integer> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> getIntimateSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

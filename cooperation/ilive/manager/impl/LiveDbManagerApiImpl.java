package cooperation.ilive.manager.impl;

import MQQ.QqLiveMsg;
import cooperation.ilive.manager.ILiveDbManagerApi;
import cooperation.ilive.manager.IliveDbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcooperation/ilive/manager/impl/LiveDbManagerApiImpl;", "Lcooperation/ilive/manager/ILiveDbManagerApi;", "()V", "getCurrentUin", "", "getILiveEnterInfo", "infoType", "", "getIliveDrawerData", "mainKey", "getIliveSwitch", "type", "saveIliveData", "", "isQQLivePgc", "qqLiveMsg", "LMQQ/QqLiveMsg;", "saveIliveDrawerData", "", "value", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class LiveDbManagerApiImpl implements ILiveDbManagerApi {
    @Override // cooperation.ilive.manager.ILiveDbManagerApi
    @NotNull
    public String getCurrentUin() {
        String currentUin = IliveDbManager.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "getCurrentUin()");
        return currentUin;
    }

    @Override // cooperation.ilive.manager.ILiveDbManagerApi
    @Nullable
    public String getILiveEnterInfo(int infoType) {
        return IliveDbManager.getILiveEnterInfo(infoType);
    }

    @Override // cooperation.ilive.manager.ILiveDbManagerApi
    @Nullable
    public String getIliveDrawerData(@Nullable String mainKey) {
        return IliveDbManager.getIliveDrawerData(mainKey);
    }

    @Override // cooperation.ilive.manager.ILiveDbManagerApi
    public int getIliveSwitch(int type) {
        return IliveDbManager.getIliveSwitch(type);
    }

    @Override // cooperation.ilive.manager.ILiveDbManagerApi
    public void saveIliveData(int isQQLivePgc, @Nullable QqLiveMsg qqLiveMsg) {
        IliveDbManager.saveIliveData(isQQLivePgc, qqLiveMsg);
    }

    @Override // cooperation.ilive.manager.ILiveDbManagerApi
    public boolean saveIliveDrawerData(@Nullable String mainKey, @Nullable String value) {
        return IliveDbManager.saveIliveDrawerData(mainKey, value);
    }
}

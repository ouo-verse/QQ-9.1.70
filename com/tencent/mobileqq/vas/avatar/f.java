package com.tencent.mobileqq.vas.avatar;

import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/avatar/f;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "", "getBid", "", "getFrom", "getBusinessDir", "", "isEnableCheckFile", "isEnableFileClean", "", "id", "", "startDownload", "scid", "bid", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "getBusinessItemInfo", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness$CustomBusinessItemInfo;", "getCustomItemInfo", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "onLoadSuccess", "e", "isFileExists", "isFileExist", "onLoadFail", "<init>", "()V", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f extends QQVasUpdateBusiness<f> {
    @NotNull
    public final String e(@NotNull String scid) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        return getSavePath(scid) + ".png";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 23L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return PreDetect.FACE_DETECT;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @NotNull String scid) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        BusinessItemInfo itemInfo = super.getBusinessItemInfo(bid, scid);
        itemInfo.mSaveInDir = false;
        itemInfo.mSavePath = e(scid);
        Intrinsics.checkNotNullExpressionValue(itemInfo, "itemInfo");
        return itemInfo;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long bid, @NotNull String scid) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        customBusinessItemInfo.mSaveInDir = false;
        customBusinessItemInfo.mSavePath = e(scid);
        return customBusinessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return PreDetect.FACE_DETECT;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExist(@NotNull String scid) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        if (isDownloadingOrUnpacking(scid)) {
            return false;
        }
        File file = new File(e(scid));
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int id5) {
        String scid = h.a(id5, h.b(200));
        Intrinsics.checkNotNullExpressionValue(scid, "scid");
        return isFileExist(scid);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NotNull UpdateListenerParams params) {
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        super.onLoadFail(params);
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null) {
            str = businessUpdateParams.mScid;
        } else {
            str = null;
        }
        QLog.i("FaceBusiness", 1, "onLoadFail " + str);
        NtVasFaceManager.j().m(params.mBusinessUpdateParams.mScid, params.mErrorCode);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NotNull UpdateListenerParams params) {
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        super.onLoadSuccess(params);
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null) {
            str = businessUpdateParams.mScid;
        } else {
            str = null;
        }
        QLog.i("FaceBusiness", 1, "onLoadSuccess " + str);
        NtVasFaceManager.j().m(params.mBusinessUpdateParams.mScid, params.mErrorCode);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void startDownload(int id5) {
        startDownload(h.a(id5, h.b(200)));
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness
    public void startDownload(@Nullable String scid) {
        super.startDownload(scid);
    }
}

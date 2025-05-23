package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/QzoneCommentBigVipBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "()V", "addDownLoadListener", "", "id", "", "level", "listener", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "getBid", "", "getBusinessDir", "", "getBusinessItemInfo", "Lcom/tencent/vas/update/entity/BusinessItemInfo;", "bid", "scid", "getFrom", "getSavePath", "isFileExits", "", "startDownload", "transformScid", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QzoneCommentBigVipBusiness extends QQVasUpdateBusiness<QzoneCommentBigVipBusiness> {
    private static final long BID = 58;

    @NotNull
    private static final String TAG = "QzoneBigVipBusiness";

    private final String transformScid(int id5, int level) {
        return "qzoneCommentBadge.common." + id5 + "." + level + ".png";
    }

    public final void addDownLoadListener(int id5, int level, @NotNull IDownLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        addDownLoadListener(transformScid(id5, level), listener);
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return BID;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "qzoneCommentBadge";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public BusinessItemInfo getBusinessItemInfo(long bid, @Nullable String scid) {
        String savePath = getSavePath(scid);
        BusinessItemInfo itemInfo = super.getBusinessItemInfo(bid, scid);
        itemInfo.mSaveInDir = false;
        itemInfo.mSavePath = savePath;
        Intrinsics.checkNotNullExpressionValue(itemInfo, "itemInfo");
        return itemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return TAG;
    }

    @NotNull
    public final String getSavePath(int id5, int level) {
        String savePath = getSavePath(transformScid(id5, level));
        Intrinsics.checkNotNullExpressionValue(savePath, "getSavePath(transformScid(id, level))");
        return savePath;
    }

    public final boolean isFileExits(int id5, int level) {
        return isFileExist(transformScid(id5, level));
    }

    public final void startDownload(int id5, int level) {
        startDownload(transformScid(id5, level));
    }
}

package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.vas.update.business.BaseUpdateBusiness;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/AvatarMaskBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "Lcom/tencent/vas/update/business/BaseUpdateBusiness;", "()V", "getBid", "", "getBusinessDir", "", "getFrom", "getMaskPath", "id", "", "getScid", "isEnableCheckFile", "", "isFileExist", "scid", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class AvatarMaskBusiness extends QQVasUpdateBusiness<BaseUpdateBusiness> {

    @NotNull
    private static final String FILE_NAME = "mask_shape.png";

    @NotNull
    private static final String SCID_STR = "facemask.%s.common.zip";

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 333L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "avatar_mask";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "avatar_mask";
    }

    @NotNull
    public final String getMaskPath(int id5) {
        return getSavePath(id5) + File.separator + FILE_NAME;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public String getScid(int id5) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(id5);
        String format = String.format(SCID_STR, Arrays.copyOf(new Object[]{sb5.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExist(@Nullable String scid) {
        return super.isFileExist(scid);
    }
}

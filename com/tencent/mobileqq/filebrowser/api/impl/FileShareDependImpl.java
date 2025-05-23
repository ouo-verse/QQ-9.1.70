package com.tencent.mobileqq.filebrowser.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filebrowser.api.IFileShareDepend;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J+\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u0002H\u000fH\u0016\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/api/impl/FileShareDependImpl;", "Lcom/tencent/mobileqq/filebrowser/api/IFileShareDepend;", "()V", "createQRCodeOrLink", "", "context", "Landroid/content/Context;", "fileInfo", "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "localPath", "", "isQRCode", "", "forwardToMyComputer", "", "T", "forwardIntent", "Landroid/content/Intent;", "filePath", "callback", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Object;)I", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FileShareDependImpl implements IFileShareDepend {
    @Override // com.tencent.mobileqq.filebrowser.api.IFileShareDepend
    public void createQRCodeOrLink(Context context, ForwardFileInfo fileInfo, String localPath, boolean isQRCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        LinkByWeiyunFragment.th(context, fileInfo, localPath, isQRCode);
    }

    @Override // com.tencent.mobileqq.filebrowser.api.IFileShareDepend
    public <T> int forwardToMyComputer(Intent forwardIntent, String filePath, T callback) {
        Intrinsics.checkNotNullParameter(forwardIntent, "forwardIntent");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
        forwardIntent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, DATALINE_PC_UIN);
        forwardIntent.putExtra("dataline_forward_type", 100);
        forwardIntent.putExtra("dataline_forward_path", filePath);
        Bundle bundle = new Bundle();
        bundle.putAll(forwardIntent.getExtras());
        IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class);
        Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
        return iMyComputerHelpApi.singleForwardToMyComputer(DATALINE_PC_UIN, bundle, null);
    }
}

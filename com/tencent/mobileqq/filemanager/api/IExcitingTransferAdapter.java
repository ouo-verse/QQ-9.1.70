package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IExcitingTransferAdapter extends IRuntimeService {
    List<ExcitingTransferHostInfo> getBigDataHostList(boolean z16);

    ExcitingTransferDownloadConfig getC2CDownloadConfig();

    long getC2CDownloadLimitedSize();

    ExcitingTransferUploadChnConfigInfo getC2CUploadChnConfig();

    long getC2CUploadLimitedSize();

    boolean getConfigFromServer();

    ExcitingTransferDownloadConfig getGroupDownloadConfig();

    long getGroupDownloadLimitedSize();

    ExcitingTransferUploadChnConfigInfo getGroupUploadChnConfig();

    long getGroupUploadLimitedSize();

    long getSelfUin();

    boolean isEnableC2CDownload();

    boolean isEnableC2CUpload();

    boolean isEnableGroupDownload();

    boolean isEnableGroupUpload();
}

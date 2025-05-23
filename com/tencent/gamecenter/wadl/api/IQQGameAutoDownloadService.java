package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreCircleResponse;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreUpdateResponse;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IQQGameAutoDownloadService extends IRuntimeService {
    void handleAutoDownloadFail(int i3);

    void handleCircleAutoDownloadSuccess(QQGameAutoDownloadTask$GetPreCircleResponse qQGameAutoDownloadTask$GetPreCircleResponse);

    void handleUpdateAutoDownloadSuccess(QQGameAutoDownloadTask$GetPreUpdateResponse qQGameAutoDownloadTask$GetPreUpdateResponse);

    void pullAutoDownloadTask();
}

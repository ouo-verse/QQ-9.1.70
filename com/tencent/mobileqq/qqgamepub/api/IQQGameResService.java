package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameResService extends QRouteApi {
    void checkAndCleanExpireCache(int i3);

    void deleteArkResRecordAndFile(String str);

    void deleteFile(String str);

    String getActivityDSL(String str, int i3);

    String getArkResRecordName(String str, String str2);

    String getArkResRecordPath(String str, String str2);

    String getFilePath(String str, int i3);

    String getResPathByUrl(String str, int i3);

    String getResPathPrefix(int i3);

    String getResRealMd5(String str);

    String getResRecordMd5(String str, String str2, int i3);

    boolean isOnlySupportInnerFilePos();

    void removeResInfo(String str, int i3);

    void saveArkResPreloadName(String str, String str2, String str3);

    void updateResInfo(String str, String str2, long j3, int i3);
}

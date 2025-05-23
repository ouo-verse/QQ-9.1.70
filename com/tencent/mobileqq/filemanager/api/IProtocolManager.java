package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.app.g;
import com.tencent.mobileqq.filemanager.app.h;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IProtocolManager extends IRuntimeService {
    void forwardDisc2Disc(String str, String str2, h hVar, g.a aVar);

    void forwardDiscToOther(String str, int i3, String str2, int i16, h hVar, int i17, int i18, g.a aVar);

    void forwardOfflineFileToBuddy(String str, int i3, String str2, String str3, int i16, int i17, g.a aVar);

    void forwardOfflineFileToOther(String str, String str2, h hVar, int i3, int i16, int i17, g.a aVar);

    void sendLocalFileToBuddyBySHA(String str, String str2, String str3, long j3, byte[] bArr, byte[] bArr2, int i3, int i16, g.b bVar);

    void setUploadBuddyFileSuccess(String str, byte[] bArr, int i3, int i16, g.c cVar);
}

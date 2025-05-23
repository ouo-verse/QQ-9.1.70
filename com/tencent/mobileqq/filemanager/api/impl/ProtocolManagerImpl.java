package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IProtocolManager;
import com.tencent.mobileqq.filemanager.app.g;
import com.tencent.mobileqq.filemanager.app.h;
import com.tencent.mobileqq.filemanager.app.i;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class ProtocolManagerImpl implements IProtocolManager {
    private i mgr;

    @Override // com.tencent.mobileqq.filemanager.api.IProtocolManager
    public void forwardDisc2Disc(String str, String str2, h hVar, g.a aVar) {
        this.mgr.a(str, str2, hVar, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IProtocolManager
    public void forwardDiscToOther(String str, int i3, String str2, int i16, h hVar, int i17, int i18, g.a aVar) {
        this.mgr.b(str, i3, str2, i16, hVar, i17, i18, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IProtocolManager
    public void forwardOfflineFileToBuddy(String str, int i3, String str2, String str3, int i16, int i17, g.a aVar) {
        this.mgr.c(str, i3, str2, str3, i16, i17, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IProtocolManager
    public void forwardOfflineFileToOther(String str, String str2, h hVar, int i3, int i16, int i17, g.a aVar) {
        this.mgr.d(str, str2, hVar, i3, i16, i17, aVar);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mgr = new i((BaseQQAppInterface) appRuntime);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IProtocolManager
    public void sendLocalFileToBuddyBySHA(String str, String str2, String str3, long j3, byte[] bArr, byte[] bArr2, int i3, int i16, g.b bVar) {
        this.mgr.j(str, str2, str3, j3, bArr, bArr2, i3, i16, bVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IProtocolManager
    public void setUploadBuddyFileSuccess(String str, byte[] bArr, int i3, int i16, g.c cVar) {
        this.mgr.l(str, bArr, i3, i16, cVar);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}

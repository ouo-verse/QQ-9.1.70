package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMConfigImpl implements IFMConfig {
    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public String getConfigValue(Context context, String str, String str2, String str3) {
        return com.tencent.mobileqq.filemanager.data.d.b(context, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public long getFlowDialogSize() {
        return com.tencent.mobileqq.filemanager.data.d.c();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public long getFlowDialogTime() {
        return com.tencent.mobileqq.filemanager.data.d.d();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public long getMaxCreateThumbFileSize() {
        return com.tencent.mobileqq.filemanager.data.d.e();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public String getPreviewConfig(Context context, String str, String str2) {
        return com.tencent.mobileqq.filemanager.data.d.g(context, str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public String getTAG() {
        return "FMConfig<FileAssistant>";
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean getUserFtnSpeedTest() {
        return com.tencent.mobileqq.filemanager.data.d.h();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean getUserHarCodeIp() {
        return com.tencent.mobileqq.filemanager.data.d.i();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsDownload4C2C(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.j(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.k(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsDownload4Disc(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.l(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.m(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsThumb4C2C(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.n(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsThumb4Disc(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.o(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsUpload4C2C(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.p(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean isEnableHttpsUpload4Disc(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.data.d.q(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public boolean preDownloadThumb() {
        return com.tencent.mobileqq.filemanager.data.d.r();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsDownload4C2C(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.s(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsDownload4C2C_ZipInner(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.t(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsDownload4Disc(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.u(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsDownload4Disc_ZipInner(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.v(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsThumb4C2C(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.w(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsThumb4Disc(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.x(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsUpload4C2C(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.y(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void setEnableHttpsUpload4Disc(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.data.d.z(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public int timAIOGaryTipsCount() {
        return com.tencent.mobileqq.filemanager.data.d.A();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public String timGuideUrl() {
        return com.tencent.mobileqq.filemanager.data.d.B();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public void updatePreviewList(BaseQQAppInterface baseQQAppInterface, String str, long j3) {
        com.tencent.mobileqq.filemanager.data.d.C(baseQQAppInterface, str, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFMConfig
    public String getConfigValue(Context context, String str) {
        return com.tencent.mobileqq.filemanager.data.d.a(context, str);
    }
}

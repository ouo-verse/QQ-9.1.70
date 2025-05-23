package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferAdapterImpl implements IExcitingTransferAdapter {
    private wb1.c adapter = new wb1.c();

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public List<ExcitingTransferHostInfo> getBigDataHostList(boolean z16) {
        return this.adapter.a(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public ExcitingTransferDownloadConfig getC2CDownloadConfig() {
        return this.adapter.b();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public long getC2CDownloadLimitedSize() {
        return this.adapter.c();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public ExcitingTransferUploadChnConfigInfo getC2CUploadChnConfig() {
        return this.adapter.d();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public long getC2CUploadLimitedSize() {
        return this.adapter.e();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public boolean getConfigFromServer() {
        return this.adapter.f();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public ExcitingTransferDownloadConfig getGroupDownloadConfig() {
        return this.adapter.g();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public long getGroupDownloadLimitedSize() {
        return this.adapter.h();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public ExcitingTransferUploadChnConfigInfo getGroupUploadChnConfig() {
        return this.adapter.i();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public long getGroupUploadLimitedSize() {
        return this.adapter.j();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public long getSelfUin() {
        return this.adapter.k();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public boolean isEnableC2CDownload() {
        return this.adapter.m();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public boolean isEnableC2CUpload() {
        return this.adapter.n();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public boolean isEnableGroupDownload() {
        return this.adapter.o();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
    public boolean isEnableGroupUpload() {
        return this.adapter.p();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.adapter.l(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.adapter.q();
    }
}

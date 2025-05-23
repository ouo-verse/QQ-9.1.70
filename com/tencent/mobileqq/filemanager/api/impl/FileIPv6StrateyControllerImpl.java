package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import java.util.List;

/* loaded from: classes12.dex */
public class FileIPv6StrateyControllerImpl implements IFileIPv6StrateyController {
    private QQFileIPv6StrateyController controller;

    public FileIPv6StrateyControllerImpl() {
        QQFileIPv6StrateyController qQFileIPv6StrateyController = new QQFileIPv6StrateyController();
        this.controller = qQFileIPv6StrateyController;
        qQFileIPv6StrateyController.z();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public int debugGetLocalConfigIPv6Strategy() {
        return this.controller.e();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public boolean debugIsLocalConfigEnableC2CIPv6() {
        return this.controller.f();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public boolean debugIsLocalConfigEnableDatalineIPv6() {
        return this.controller.g();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public boolean debugIsLocalConfigEnableDiscIPv6() {
        return this.controller.h();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public boolean debugIsLocalConfigEnableGroupIPv6() {
        return this.controller.i();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public boolean debugIsUseLocalConfig() {
        return this.controller.j();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public void debugSetLocalConfigEnableC2CIPv6(boolean z16) {
        this.controller.k(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public void debugSetLocalConfigEnableDatalineIPv6(boolean z16) {
        this.controller.l(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public void debugSetLocalConfigEnableDiscIPv6(boolean z16) {
        this.controller.m(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public void debugSetLocalConfigEnableGroupIPv6(boolean z16) {
        this.controller.n(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public void debugSetLocalConfigIPv6Strategy(int i3) {
        this.controller.o(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public void debugSetUseLocalConfig(boolean z16) {
        this.controller.p(z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public List<ExcitingTransferHostInfo> getIPV6listForExcitingUpload(BaseQQAppInterface baseQQAppInterface, int i3) {
        return this.controller.s(baseQQAppInterface, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public List<String> getIPV6listForMediaPlatfrom(BaseQQAppInterface baseQQAppInterface, int i3, List<String> list) {
        return this.controller.t(baseQQAppInterface, i3, list);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public d.c getIPlistForV6Domain(BaseQQAppInterface baseQQAppInterface, d.a aVar, int i3) {
        return this.controller.u(baseQQAppInterface, aVar, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController
    public boolean isConfigEnableIPV6(BaseQQAppInterface baseQQAppInterface, int i3) {
        return this.controller.B(baseQQAppInterface, i3);
    }
}

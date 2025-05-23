package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTransferWrapper;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildFileTransferWrapperImpl implements IGuildFileTransferWrapper {
    private QFileGuildTransferWrapper mGuildTransferWrapper;

    private synchronized QFileGuildTransferWrapper getQFileGuildTransferWrapper(BaseQQAppInterface baseQQAppInterface) {
        if (this.mGuildTransferWrapper == null) {
            this.mGuildTransferWrapper = new QFileGuildTransferWrapper((QQAppInterface) baseQQAppInterface);
        }
        return this.mGuildTransferWrapper;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTransferWrapper
    public boolean cancelSend(BaseQQAppInterface baseQQAppInterface, long j3) {
        return getQFileGuildTransferWrapper(baseQQAppInterface).g(j3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTransferWrapper
    public void resendFile(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        getQFileGuildTransferWrapper(baseQQAppInterface).m(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTransferWrapper
    public void uploadFileToGuild(BaseQQAppInterface baseQQAppInterface, String str, String str2, Set<FileInfo> set) {
        getQFileGuildTransferWrapper(baseQQAppInterface).p(str, str2, set);
    }
}

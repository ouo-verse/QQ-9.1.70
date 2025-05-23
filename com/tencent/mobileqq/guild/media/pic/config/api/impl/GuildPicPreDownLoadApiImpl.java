package com.tencent.mobileqq.guild.media.pic.config.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi;
import com.tencent.qphone.base.util.QLog;
import gt1.a;
import mqq.app.AppRuntime;

/* loaded from: classes14.dex */
public class GuildPicPreDownLoadApiImpl implements IGuildPicPreDownLoadApi {
    private static final String TAG = "GuildPicDownLoadConfigApiImpl<gld>";
    BaseQQAppInterface mApp;

    public static a getDownloadConfig() {
        a aVar = (a) am.s().x(772);
        if (aVar == null) {
            return new a();
        }
        return aVar;
    }

    public static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("flowlog.GuildPicDownLoadConfigApiImpl<gld>", 2, str);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi
    public boolean isPreDownLoadWhenScrollView() {
        return getDownloadConfig().c();
    }

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi
    public boolean isUsing720Flag() {
        return getDownloadConfig().d().booleanValue();
    }

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi
    public boolean isUsingHttps() {
        return getDownloadConfig().e().booleanValue();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = (BaseQQAppInterface) appRuntime;
    }

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi
    public int preDownLoadImageCountWhenScrollView() {
        return getDownloadConfig().a();
    }

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi
    public int preDownLoadMsgCountWhenScrollView() {
        return getDownloadConfig().b();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}

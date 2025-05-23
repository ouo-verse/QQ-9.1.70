package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListCustomGuildDirectMessageAIO;
import com.tencent.mobileqq.activity.aio.photo.PhotoListCustomizationGuildAIO;
import com.tencent.mobileqq.activity.aio.photo.PhotoListCustomizationGuildFeed;
import com.tencent.mobileqq.activity.aio.photo.PhotoPreviewCustomizationGuildAIO;
import com.tencent.mobileqq.activity.aio.photo.PhotoPreviewCustomizationGuildFeed;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes33.dex */
public class GuildPhotoUtilsApiImpl implements IGuildPhotoUtilsApi {
    private static final String TAG = "GuildPhotoUtilsApiImpl";

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public boolean downloadNonGuildPhoto(Object obj, IGuildPhotoUtilsApi.a aVar) {
        if (!(obj instanceof MessageForPic)) {
            QLog.i(TAG, 1, "downloadNonGuildPhoto FAILED. message is not Pic!");
            return false;
        }
        MessageForPic messageForPic = (MessageForPic) obj;
        String filePath = AbsDownloader.getFilePath(URLDrawableHelper.getURL(messageForPic, 131075, null).toString());
        if (new File(filePath).exists()) {
            QLog.i(TAG, 1, "downloadNonGuildPhoto. pic file exists.");
            if (aVar != null) {
                aVar.onDownloaded(0, filePath);
            }
        }
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(7, 1);
        createPicReq.d(messageForPic, messageForPic.getPicDownloadInfo());
        createPicReq.g(new a(aVar, filePath));
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public void forward(String str, Activity activity) {
        if (!TextUtils.isEmpty(str) && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
            bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
            bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 21);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("forward to friend error param! filePath: ");
            sb5.append(str);
            sb5.append(" activity == null: ");
            sb5.append(activity == null);
            QLog.e(TAG, 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public void forwardFavourite(String str, Object obj, Activity activity) {
        if (obj instanceof QQAppInterface) {
            ProfileCardUtil.l(str, (QQAppInterface) obj, activity);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public void forwardQzone(String str, Object obj, Activity activity) {
        if (obj instanceof QQAppInterface) {
            ProfileCardUtil.m(str, (QQAppInterface) obj, activity);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public String getPhotoListCustomizationGuildAIOClassName() {
        return PhotoListCustomizationGuildAIO.V;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public String getPhotoListCustomizationGuildDirectMessageAIOClassName() {
        return PhotoListCustomGuildDirectMessageAIO.U;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public String getPhotoListCustomizationGuildFeedClassName() {
        return PhotoListCustomizationGuildFeed.f179634c0;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public String getPhotoPreviewCustomizationGuildAIOClassName() {
        return PhotoPreviewCustomizationGuildAIO.Z;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public String getPhotoPreviewCustomizationGuildFeedClassName() {
        return PhotoPreviewCustomizationGuildFeed.f179714a0;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public void savePic(String str, Activity activity) {
        AIOGalleryUtils.o(activity, new File(str), Utils.Crc64String(str));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi
    public boolean useGuildPhotoList(Object obj) {
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return sessionInfo.f179555d == 10014 && !((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).isDirectMsg(sessionInfo);
    }

    /* loaded from: classes33.dex */
    class a extends ac.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f235247d;

        a(IGuildPhotoUtilsApi.a aVar, String str) {
            this.f235247d = str;
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void b(int i3, boolean z16) {
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void g(int i3, q qVar) {
        }
    }
}

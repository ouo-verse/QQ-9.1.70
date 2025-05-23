package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopHw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Bosses;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHWApiImpl implements ITroopHWApi {
    static IPatchRedirector $redirector_;

    public TroopHWApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void browserNoticeFile(Activity activity, String str, String str2, String str3, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.peerUin = str;
        fileManagerEntity.peerType = 1;
        fileManagerEntity.cloudType = -1;
        fileManagerEntity.nOpType = 1;
        fileManagerEntity.fileName = str2;
        fileManagerEntity.nFileType = i3;
        fileManagerEntity.fileSize = j3;
        fileManagerEntity.strFilePath = str3;
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            fileManagerEntity.selfUin = f16.getCurrentAccountUin();
        }
        fileManagerEntity.status = -1;
        com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d(f16, fileManagerEntity, 2);
        com.tencent.mobileqq.filemanager.openbrowser.c cVar = new com.tencent.mobileqq.filemanager.openbrowser.c();
        cVar.d(21);
        cVar.f(0);
        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(activity, dVar, cVar);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public int getBknBySkey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        return TroopUtils.h(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public String getFileSuffix(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.troop.utils.d.a(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public Intent getSelectMediaIntent(int i3, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), activity, str);
        }
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 47);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationTroopHw.H);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", i3);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", i3);
        intent.putExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_IS_NEED_MEDIA_INFO, true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0);
        intent.putExtra(QAlbumConstants.SHOW_GIF_TYPE_ICON, true);
        intent.putExtra("uin", str);
        intent.putExtra(PeakConstants.PHOTOLIST_IS_FROM_HWUPLOAD, true);
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void goSelectMedia(Activity activity, Object obj, Object obj2, Intent intent, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, obj, obj2, intent, Byte.valueOf(b16));
        } else if (activity instanceof AbsBaseWebViewActivity) {
            ((AbsBaseWebViewActivity) activity).gotoSelectPicture((WebViewPlugin) obj2, intent, b16);
        } else if (obj != null) {
            ao.c((WebViewPlugin) obj2, intent, b16, (WebViewProvider) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void gotoSelectPicture(Activity activity, Object obj, Object obj2, int i3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, obj, obj2, Integer.valueOf(i3), Byte.valueOf(b16));
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 47);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationTroopHw.H);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i3);
        activityURIRequest.extra().putBoolean(QAlbumConstants.PHOTOLIST_IS_NEED_MEDIA_INFO, true);
        if (i3 == 1) {
            activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        }
        if (activity instanceof AbsBaseWebViewActivity) {
            ((AbsBaseWebViewActivity) activity).gotoSelectPicture((WebViewPlugin) obj2, activityURIRequest, b16);
        } else if (obj != null) {
            ao.d((WebViewPlugin) obj2, activityURIRequest, b16, (WebViewProvider) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void initBossForMediaItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            Bosses.initWithBoss(BaseApplicationImpl.getApplication(), new StoryBoss(BaseApplicationImpl.getApplication()));
        } catch (Exception e16) {
            QLog.e("TroopHWApiImpl", 1, "[initBossForMediaItem] exception = " + e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public boolean isAbsBaseWebViewActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity)).booleanValue();
        }
        return activity instanceof AbsBaseWebViewActivity;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void notifyTroopBannerHWBizOpened(@NonNull String str, @NonNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
            return;
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            ((com.tencent.mobileqq.troop.troopaiobanner.c) e16.getManager(QQManagerFactory.TROOP_GAME_BANNER_MANAGER)).d(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void showOnePicture(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) str);
        } else {
            TroopNoticeJsHandler.showOnePicture(activity, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHWApi
    public void start_BulkSendMessageFragment(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
        } else {
            BulkSendMessageFragment.th(activity, bundle);
        }
    }
}

package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class EmotionPanelDataBuilder {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionPanelDataBuilder";
    private static EmotionPanelDataBuilder sInstance;

    /* loaded from: classes12.dex */
    public interface EmotionPanelDataCallback {
        void callbackInMainThread(List<EmotionPanelData> list);
    }

    EmotionPanelDataBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static EmotionPanelDataBuilder getInstance() {
        if (sInstance == null) {
            synchronized (EmotionPanelDataBuilder.class) {
                if (sInstance == null) {
                    sInstance = new EmotionPanelDataBuilder();
                }
            }
        }
        return sInstance;
    }

    public void asyncGetEmotionPanelData(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, EmoticonPackage emoticonPackage, int i16, int i17, boolean z16, IEmotionPanelDataCallback iEmotionPanelDataCallback, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iEmoticonMainPanelApp, Integer.valueOf(i3), emoticonPackage, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), iEmotionPanelDataCallback, Boolean.valueOf(z17), Boolean.valueOf(z18));
        } else {
            if (iEmotionPanelDataCallback == null) {
                return;
            }
            ThreadManagerV2.post(new Runnable(iEmoticonMainPanelApp, i3, emoticonPackage, i16, i17, z16, z17, z18, iEmotionPanelDataCallback) { // from class: com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IEmoticonMainPanelApp val$app;
                final /* synthetic */ int val$businessType;
                final /* synthetic */ IEmotionPanelDataCallback val$callback;
                final /* synthetic */ boolean val$canShowGif;
                final /* synthetic */ EmoticonPackage val$emotionPkg;
                final /* synthetic */ boolean val$kanDianBiu;
                final /* synthetic */ boolean val$needShowFavAndFunnyPicIcon;
                final /* synthetic */ int val$panelType;
                final /* synthetic */ int val$uinType;

                {
                    this.val$app = iEmoticonMainPanelApp;
                    this.val$panelType = i3;
                    this.val$emotionPkg = emoticonPackage;
                    this.val$uinType = i16;
                    this.val$businessType = i17;
                    this.val$kanDianBiu = z16;
                    this.val$needShowFavAndFunnyPicIcon = z17;
                    this.val$canShowGif = z18;
                    this.val$callback = iEmotionPanelDataCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmotionPanelDataBuilder.this, iEmoticonMainPanelApp, Integer.valueOf(i3), emoticonPackage, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), iEmotionPanelDataCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable(EmotionPanelDataBuilder.this.syncGetEmotionPanelData(this.val$app, this.val$panelType, this.val$emotionPkg, this.val$uinType, this.val$businessType, this.val$kanDianBiu, this.val$needShowFavAndFunnyPicIcon, this.val$canShowGif)) { // from class: com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ List val$dataList;

                            {
                                this.val$dataList = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass1.this.val$callback.callbackInMainThread(this.val$dataList);
                                }
                            }
                        });
                    }
                }
            }, 5, null, true);
        }
    }

    public List<EmotionPanelData> syncGetEmotionPanelData(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, EmoticonPackage emoticonPackage, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        boolean z26;
        List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, iEmoticonMainPanelApp, Integer.valueOf(i3), emoticonPackage, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        if (iEmoticonMainPanelApp == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getEmotionPanelData panelType = " + i3);
        }
        ArrayList arrayList = new ArrayList();
        EmoticonManagerServiceProxy emoticonManagerServiceProxy = (EmoticonManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class);
        switch (i3) {
            case 1:
                return SystemAndEmojiEmoticonInfo.getEmoticonList(iEmoticonMainPanelApp, i17);
            case 2:
            case 6:
            case 8:
            case 9:
            case 12:
                if (emoticonPackage == null || TextUtils.isEmpty(emoticonPackage.epId)) {
                    return null;
                }
                List<Emoticon> syncGetSubEmoticonsByPackageId = emoticonManagerServiceProxy.syncGetSubEmoticonsByPackageId(emoticonPackage.epId, true);
                if (emoticonPackage.jobType == 4) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (syncGetSubEmoticonsByPackageId != null) {
                    int size = syncGetSubEmoticonsByPackageId.size();
                    for (int i18 = 0; i18 < size; i18++) {
                        Emoticon emoticon = syncGetSubEmoticonsByPackageId.get(i18);
                        if (z19) {
                            SmallEmoticonInfo smallEmoticonInfo = new SmallEmoticonInfo(iEmoticonMainPanelApp.getCurrentAccountUin());
                            smallEmoticonInfo.type = 10;
                            smallEmoticonInfo.imageType = emoticonPackage.type;
                            smallEmoticonInfo.emoticon = emoticon;
                            arrayList.add(smallEmoticonInfo);
                        } else {
                            PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(iEmoticonMainPanelApp.getCurrentAccountUin());
                            picEmoticonInfo.type = 6;
                            picEmoticonInfo.imageType = emoticonPackage.type;
                            picEmoticonInfo.emoticon = emoticon;
                            if (emoticonPackage.isAPNG == 2) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            picEmoticonInfo.isAPNG = z26;
                            arrayList.add(picEmoticonInfo);
                        }
                    }
                    return arrayList;
                }
                return arrayList;
            case 3:
                List<PromotionEmoticonPkg> proEmoticonPkgs = emoticonManagerServiceProxy.getProEmoticonPkgs(true, i17, z16);
                if (proEmoticonPkgs != null) {
                    arrayList.addAll(proEmoticonPkgs);
                    return arrayList;
                }
                return arrayList;
            case 4:
                FavroamingDBManagerServiceProxy favroamingDBManagerServiceProxy = (FavroamingDBManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(IFavroamingDBManagerService.class);
                if (i16 != 10016 && i16 != 10014) {
                    syncGetCustomEmotionInfoShowedInPanel = favroamingDBManagerServiceProxy.syncGetCustomEmotionInfoShowedInAIOPanel();
                } else {
                    syncGetCustomEmotionInfoShowedInPanel = favroamingDBManagerServiceProxy.syncGetCustomEmotionInfoShowedInPanel();
                }
                if (z17) {
                    if (iEmoticonMainPanelApp.getQQAppInterface() != null) {
                        EmoticonInfo emoticonInfo = new EmoticonInfo();
                        emoticonInfo.action = EmoticonInfo.FAV_EDIT_ACTION;
                        arrayList.add(emoticonInfo);
                        if (i16 != 1024 && i16 != 10026) {
                            EmoticonInfo emoticonInfo2 = new EmoticonInfo();
                            emoticonInfo2.action = "funny_pic";
                            arrayList.add(emoticonInfo2);
                        }
                    }
                } else {
                    ArrayList<EmoticonInfo> arrayList2 = new ArrayList(syncGetCustomEmotionInfoShowedInPanel);
                    syncGetCustomEmotionInfoShowedInPanel.clear();
                    for (EmoticonInfo emoticonInfo3 : arrayList2) {
                        if (emoticonInfo3 instanceof FavoriteEmoticonInfo) {
                            FavoriteEmoticonInfo favoriteEmoticonInfo = (FavoriteEmoticonInfo) emoticonInfo3;
                            if (!TextUtils.isEmpty(favoriteEmoticonInfo.url) && (z18 || !GifDrawable.isGifFile(new File(favoriteEmoticonInfo.path)))) {
                                syncGetCustomEmotionInfoShowedInPanel.add(emoticonInfo3);
                            }
                        }
                    }
                }
                if (syncGetCustomEmotionInfoShowedInPanel != null) {
                    QLog.d(TAG, 1, "syncGetEmotionPanelData FAV_LOCAL_MAX_COUNT=" + FavEmoConstant.FAV_LOCAL_MAX_COUNT + ",size=" + syncGetCustomEmotionInfoShowedInPanel.size());
                    arrayList.addAll(syncGetCustomEmotionInfoShowedInPanel);
                    return arrayList;
                }
                return arrayList;
            case 5:
                new PicEmoticonInfo(iEmoticonMainPanelApp.getCurrentAccountUin()).action = "push";
                arrayList.addAll(emoticonManagerServiceProxy.getMagicEmoticonInfoList(0));
                return arrayList;
            case 7:
                arrayList.add(new EmotionPanelData());
                return arrayList;
            case 10:
            case 11:
            default:
                return arrayList;
            case 13:
                List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel2 = ((CameraEmotionRoamingDBManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).syncGetCustomEmotionInfoShowedInPanel();
                CameraEmoticonInfo cameraEmoticonInfo = new CameraEmoticonInfo();
                cameraEmoticonInfo.action = EmoticonInfo.CAMERA_EDIT_ACTION;
                arrayList.add(cameraEmoticonInfo);
                if (syncGetCustomEmotionInfoShowedInPanel2.isEmpty() || !com.tencent.mobileqq.config.business.h.INSTANCE.b()) {
                    CameraEmoticonInfo cameraEmoticonInfo2 = new CameraEmoticonInfo();
                    cameraEmoticonInfo2.action = EmoticonInfo.CAMERA_JUMP_ACTION;
                    arrayList.add(cameraEmoticonInfo2);
                }
                if (syncGetCustomEmotionInfoShowedInPanel2.size() > com.tencent.mobileqq.emosm.cameraemotionroaming.a.f204252a) {
                    arrayList.addAll(new ArrayList(syncGetCustomEmotionInfoShowedInPanel2.subList(0, com.tencent.mobileqq.emosm.cameraemotionroaming.a.f204252a)));
                    return arrayList;
                }
                arrayList.addAll(syncGetCustomEmotionInfoShowedInPanel2);
                return arrayList;
        }
    }
}

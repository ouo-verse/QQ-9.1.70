package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.j;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.SendTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.guild.message.api.IDirectMessageNode;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.qbasealbum.model.SelectMediaInfo;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rw1.g;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildAIOMediaApiImpl implements IGuildAIOMediaApi {
    private static final String TAG = "GuildAIOMediaApiImpl";
    public static HashMap<Long, EncodeVideoTask> encodeVideoMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements com.tencent.mobileqq.shortvideo.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGuildAIOMediaApi.b f235245a;

        a(IGuildAIOMediaApi.b bVar) {
            this.f235245a = bVar;
        }

        @Override // com.tencent.mobileqq.shortvideo.g
        public void a(final String str, byte[] bArr, String str2, int i3, int i16, byte[] bArr2, int i17) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final IGuildAIOMediaApi.b bVar = this.f235245a;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.temp.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    IGuildAIOMediaApi.b.this.onSuccess(str);
                }
            });
        }

        @Override // com.tencent.mobileqq.shortvideo.g
        public void onError(final int i3) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final IGuildAIOMediaApi.b bVar = this.f235245a;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.temp.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    IGuildAIOMediaApi.b.this.onError(i3);
                }
            });
        }
    }

    private SessionInfo getSessionInfo(String str, String str2) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = 10014;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        Bundle bundle = new Bundle();
        if (((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).isDirectMessageNodeNotNull(str2)) {
            bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        } else {
            bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 0);
        }
        sessionInfo.f(bundle);
        return sessionInfo;
    }

    private static void setPhotoClassNames(boolean z16, ActivityURIRequest activityURIRequest) {
        IGuildPhotoUtilsApi iGuildPhotoUtilsApi = (IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class);
        if (z16) {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoListCustomizationGuildDirectMessageAIOClassName());
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoPreviewCustomizationGuildAIOClassName());
            activityURIRequest.extra().putBoolean(PeakConstants.PHOTOLIST_KEY_FILTER_VIDEO, true);
        } else {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoListCustomizationGuildAIOClassName());
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoPreviewCustomizationGuildAIOClassName());
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void compressVideo(MsgRecord msgRecord, MsgElement msgElement, Context context, AppRuntime appRuntime, boolean z16, IGuildAIOMediaApi.a aVar) {
        rw1.g.b().d(msgRecord.getMsgId(), new g.a(msgRecord, msgElement, appRuntime, context, z16, aVar));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void encodeVideo(Context context, String str, String str2, Long l3, String str3, IGuildAIOMediaApi.b bVar) {
        String shortVideoFakeId = getShortVideoFakeId(str3);
        if (TextUtils.isEmpty(shortVideoFakeId)) {
            return;
        }
        EncodeVideoTask encodeVideoTask = encodeVideoMap.get(l3);
        if (encodeVideoTask == null) {
            EncodeVideoTask encodeVideoTask2 = new EncodeVideoTask(context, shortVideoFakeId, true, new EncodeVideoTask.d(str, str2, null, 0, 0));
            Utils.executeAsyncTaskOnSerialExcuter(encodeVideoTask2, null);
            encodeVideoMap.put(l3, encodeVideoTask2);
            encodeVideoTask = encodeVideoTask2;
        }
        encodeVideoTask.I(new a(bVar));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public Boolean findCompressTask(long j3) {
        return Boolean.valueOf(rw1.g.b().a(j3) != null);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public ActivityURIRequest getPhotoPreviewFromPhotoPanelURIReq(ArrayList<String> arrayList, HashMap hashMap, ArrayList<String> arrayList2, String str, String str2, String str3, Intent intent, HashMap hashMap2) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        SessionInfo sessionInfo = getSessionInfo(str2, str3);
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        HashMap hashMap3 = new HashMap();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            hashMap3.put(arrayList.get(i3), Integer.valueOf(i3));
        }
        Integer num = (Integer) hashMap3.get(str);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            Integer num2 = (Integer) hashMap3.get(it.next());
            if (num2 != null) {
                arrayList3.add(num2);
            }
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(qBaseActivity == null ? BaseApplication.getContext() : qBaseActivity, IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        activityURIRequest.extra().putString("uin", str2);
        activityURIRequest.extra().putInt("uintype", 10014);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
        activityURIRequest.extra().putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
        activityURIRequest.extra().putBoolean(QAlbumConstants.SHOW_ALBUM, true);
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1052);
        activityURIRequest.extra().putString("troop_uin", str3);
        activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_SELECTED_INDEX, num != null ? num.intValue() : 0);
        activityURIRequest.extra().putStringArrayList("PhotoConst.SELECTED_PATHS", arrayList2);
        activityURIRequest.extra().putIntegerArrayList(QAlbumConstants.SELECTED_INDEXS, arrayList3);
        activityURIRequest.extra().putSerializable(QAlbumConstants.ALL_MEDIA_PATHS, hashMap);
        activityURIRequest.extra().putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, j.e(new HashMap()));
        activityURIRequest.extra().putInt(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoListCustomizationGuildAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoPreviewCustomizationGuildAIOClassName());
        activityURIRequest.extra().putString("key_activity_code", qBaseActivity == null ? "" : ChatActivityUtils.p(qBaseActivity));
        activityURIRequest.extra().putBoolean(QAlbumConstants.KEEP_SELECTED_STATUS_AFTER_FINISH, true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_OVERLOAD, false);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 9);
        activityURIRequest.extra().putBoolean(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT, true);
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_ACTION_NAME, "0X8005E0A");
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_REVERSE2, "0");
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_EDITBTN_REPORT_ACTION_NAME, "0X8005E0B");
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME, "0X8005E0C");
        activityURIRequest.extra().putParcelable(AppConstants.Key.SESSION_INFO, sessionInfo);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 1);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        activityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", true);
        activityURIRequest.setFlags(603979776);
        return activityURIRequest;
    }

    protected String getShortVideoFakeId(String str) {
        String str2 = str + File.separator + "configure.txt";
        if (!FileUtils.fileExistsAndNotEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "configure file empty!");
            }
            return null;
        }
        try {
            String readFileToString = FileUtils.readFileToString(new File(str2));
            if (readFileToString == null) {
                return null;
            }
            String replaceAll = readFileToString.replaceAll("[\\t\\n\\r]", "");
            if (TextUtils.isEmpty(replaceAll)) {
                return null;
            }
            return replaceAll;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public String getShortVideoThumbPicPath(String str, String str2) {
        return com.tencent.mobileqq.shortvideo.j.l(str, str2);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void initEncodeQualityParam(Intent intent) {
        SendTask.a(intent);
        CodecParam.mRecordFrames = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
        CodecParam.mRecordTime = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void openCamera(Activity activity, String str, String str2, Bundle bundle) throws Throwable {
        if (activity instanceof QBaseActivity) {
            r61.a.c(getSessionInfo(str, str2), false, (QBaseActivity) activity, (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), bundle);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void removeCompressTask(long j3) {
        g.a a16 = rw1.g.b().a(j3);
        if (a16 != null && a16.getStatus() != AsyncTask.Status.FINISHED) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "task cancel, taskId = " + j3);
            }
            a16.cancel(true);
        }
        rw1.g.b().c(j3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void removeEncodeVideoTask(Long l3) {
        EncodeVideoTask remove = encodeVideoMap.remove(l3);
        if (remove == null || remove.f186213t) {
            return;
        }
        remove.y();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public void setCompressListener(long j3, IGuildAIOMediaApi.a aVar) {
        g.a a16 = rw1.g.b().a(j3);
        if (a16 != null) {
            a16.k(aVar);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public ActivityURIRequest getPostMediaItemClickURIReq(Context context, String str, Object obj, List list) {
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
        String str2 = localMediaInfo.path;
        if (TextUtils.isEmpty(str2) || !FileUtils.fileExistsAndNotEmpty(str2)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int indexOf = list.indexOf(obj);
        for (int i3 = 0; i3 < list.size(); i3++) {
            LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) list.get(i3);
            arrayList2.add(Integer.valueOf(i3));
            arrayList.add(localMediaInfo2.path);
            if (!TextUtils.isEmpty(localMediaInfo2.picPathBeforeEdit)) {
                hashMap2.put(localMediaInfo2.picPathBeforeEdit, localMediaInfo2.path);
            } else {
                hashMap.put(localMediaInfo2.path, localMediaInfo2);
            }
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        activityURIRequest.extra().putString("uin", str);
        activityURIRequest.extra().putInt("uintype", 10014);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
        activityURIRequest.extra().putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
        activityURIRequest.extra().putBoolean(QAlbumConstants.SHOW_ALBUM, true);
        activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        activityURIRequest.extra().putSerializable(QAlbumConstants.ALL_MEDIA_PATHS, hashMap);
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_SELECTED_INDEX, indexOf);
        activityURIRequest.extra().putStringArrayList("PhotoConst.SELECTED_PATHS", arrayList);
        activityURIRequest.extra().putIntegerArrayList(QAlbumConstants.SELECTED_INDEXS, arrayList2);
        activityURIRequest.extra().putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, hashMap2);
        activityURIRequest.extra().putInt(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoListCustomizationGuildAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoPreviewCustomizationGuildAIOClassName());
        activityURIRequest.setRequestCode(10015);
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, localMediaInfo.isRwa ? 2 : 0);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 9);
        activityURIRequest.extra().putBoolean(QAlbumConstants.KEEP_SELECTED_STATUS_AFTER_FINISH, true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_OVERLOAD, false);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_JUMPTO_TROOP_ALBUM, false);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 1);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        activityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", false);
        activityURIRequest.extra().putBoolean(PeakConstants.VIDEO_EDIT_ENABLED, false);
        activityURIRequest.setFlags(603979776);
        return activityURIRequest;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public Intent getOpenAlbumIntent(Activity activity, ArrayList<SelectMediaInfo> arrayList, String str, String str2, Intent intent, boolean z16, boolean z17, HashMap<String, String> hashMap) {
        if (z16) {
            return com.tencent.mobileqq.guild.album.a.f214243a.j(activity, arrayList, hashMap);
        }
        return com.tencent.mobileqq.guild.album.a.f214243a.h(activity, arrayList, hashMap);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi
    public Object getGuildAIOMediaProvider(int i3) {
        if (i3 == 7) {
            return new sw1.f();
        }
        if (i3 == 2) {
            return new sw1.b();
        }
        if (i3 == 9) {
            return new sw1.d();
        }
        if (i3 == 3) {
            return new sw1.a();
        }
        return null;
    }
}

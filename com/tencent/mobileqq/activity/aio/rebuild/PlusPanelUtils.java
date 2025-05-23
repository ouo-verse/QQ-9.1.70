package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.av.utils.bc;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.map.MapUtils;
import com.tencent.biz.map.poi.PoiMapPartFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.activity.photo.j;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.pic.y;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class PlusPanelUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f179796a;

    /* renamed from: b, reason: collision with root package name */
    public static String f179797b;

    /* renamed from: com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bc f179798d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f179799e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SessionInfo f179800f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f179801h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ LBSHandler.a f179802i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Context f179803m;

        AnonymousClass2(bc bcVar, int[] iArr, SessionInfo sessionInfo, QQAppInterface qQAppInterface, LBSHandler.a aVar, Context context) {
            this.f179798d = bcVar;
            this.f179799e = iArr;
            this.f179800f = sessionInfo;
            this.f179801h = qQAppInterface;
            this.f179802i = aVar;
            this.f179803m = context;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(final View view, int i3) {
            String str;
            String str2;
            this.f179798d.dismiss();
            int i16 = this.f179799e[i3];
            final HashMap hashMap = new HashMap();
            hashMap.put("should_believe_only_audio_flag", "true");
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 5) {
                            CrmUtils.i(this.f179801h, this.f179803m, ((QidianManager) this.f179801h.getManager(QQManagerFactory.QIDIAN_MANAGER)).s(this.f179800f.f179557e), this.f179800f.f179557e);
                            return;
                        }
                        return;
                    }
                    hashMap.put("inviteScene", "2");
                    ReportController.o(this.f179801h, "dc00898", "", "", "0X800C433", "0X800C433", 0, 0, "1", "", "", "");
                    ReportController.o(this.f179801h, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "1", "", "", "");
                    QLog.i("PlusPanelUtils", 1, "AVAvatarRes. click MENU_ITEM_ZPLAN_CALL.");
                    if (AVAvatarResMgr.v().k()) {
                        PlusPanelUtils.h(this.f179801h, this.f179803m, this.f179800f, true, null, hashMap);
                        return;
                    } else {
                        AVAvatarResMgr.v().F(new AVAvatarResMgr.c() { // from class: com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.2.1
                            @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
                            public void onRequestFinish(final boolean z16) {
                                QLog.i("PlusPanelUtils", 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z16);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z16) {
                                            QQToast.makeText(view.getContext(), R.string.f1786837b, 0).show();
                                            return;
                                        }
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        PlusPanelUtils.h(anonymousClass2.f179801h, anonymousClass2.f179803m, anonymousClass2.f179800f, true, null, hashMap);
                                    }
                                });
                            }
                        }, 3000);
                        return;
                    }
                }
                kv.a.f413301a.k();
                SessionInfo sessionInfo = this.f179800f;
                int i17 = sessionInfo.f179555d;
                if (i17 != 1001 && i17 != 10002) {
                    if (i17 == 1010 && !com.tencent.mobileqq.dating.f.a(this.f179801h, sessionInfo.f179557e)) {
                        this.f179802i.a(this.f179803m.getString(R.string.cgm));
                        ReportController.o(this.f179801h, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
                        return;
                    }
                } else {
                    ReportController.o(this.f179801h, "CliOper", "", "", "0X8005151", "0X8005151", 0, 0, "", "", "", "");
                    if (!LBSHandler.D2(this.f179801h, this.f179800f.f179557e)) {
                        this.f179802i.a(this.f179803m.getString(R.string.cgm));
                        ReportController.o(this.f179801h, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
                        QQAppInterface qQAppInterface = this.f179801h;
                        if (this.f179800f.f179555d == 1001) {
                            str2 = "0";
                        } else {
                            str2 = "1";
                        }
                        ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str2, "1", "", "");
                        return;
                    }
                }
                hashMap.put("start_double_rtc_talk_from_source", "1");
                PlusPanelUtils.h(this.f179801h, this.f179803m, this.f179800f, false, null, hashMap);
                ReportController.o(this.f179801h, "CliOper", "", "", "0X8004C09", "0X8004C09", 0, 0, "", "", "", "");
                return;
            }
            kv.a.f413301a.a();
            SessionInfo sessionInfo2 = this.f179800f;
            int i18 = sessionInfo2.f179555d;
            if (i18 != 1001 && i18 != 10002) {
                if (i18 == 1010 && !com.tencent.mobileqq.dating.f.a(this.f179801h, sessionInfo2.f179557e)) {
                    this.f179802i.a(this.f179803m.getString(R.string.cgl));
                    ReportController.o(this.f179801h, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
                    return;
                }
            } else {
                ReportController.o(this.f179801h, "CliOper", "", "", "0X8005150", "0X8005150", 0, 0, "", "", "", "");
                if (!LBSHandler.D2(this.f179801h, this.f179800f.f179557e)) {
                    this.f179802i.a(this.f179803m.getString(R.string.cgl));
                    ReportController.o(this.f179801h, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
                    QQAppInterface qQAppInterface2 = this.f179801h;
                    if (this.f179800f.f179555d == 1001) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    ReportController.o(qQAppInterface2, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "0", "", "");
                    return;
                }
            }
            hashMap.put("start_double_rtc_talk_from_source", "1");
            PlusPanelUtils.h(this.f179801h, this.f179803m, this.f179800f, true, null, hashMap);
            ReportController.o(this.f179801h, "CliOper", "", "", "0X8004861", "0X8004861", 0, 0, "", "", "", "");
        }
    }

    /* renamed from: com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils$5, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f179817d;

        @Override // java.lang.Runnable
        public void run() {
            FileUtils.createFileIfNotExits(this.f179817d + ".nomedia");
        }
    }

    /* loaded from: classes10.dex */
    class a implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f179818d;

        a(QQAppInterface qQAppInterface) {
            this.f179818d = qQAppInterface;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            kv.a.f413301a.c();
            ReportController.o(this.f179818d, "CliOper", "", "", "0X8004862", "0X8004862", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bc f179819d;

        b(bc bcVar) {
            this.f179819d = bcVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            kv.a.f413301a.d();
            this.f179819d.mDefaultDismissListener.onClick(null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    class c extends AsyncTask<Void, Void, ImageInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SessionInfo f179820a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f179821b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f179822c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f179823d;

        c(SessionInfo sessionInfo, QQAppInterface qQAppInterface, Context context, String str) {
            this.f179820a = sessionInfo;
            this.f179821b = qQAppInterface;
            this.f179822c = context;
            this.f179823d = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo doInBackground(Void... voidArr) {
            aw.m(-1L, this.f179820a.f179555d, true, "image_send_prepare", "sessionInfo.handleScreenPhoto");
            String j3 = aw.j(this.f179821b.getApplication(), this.f179823d, this.f179820a.f179555d);
            ImageInfo imageInfo = new ImageInfo();
            aw.n(imageInfo, "compress_start", "sessionInfo.handleScreenPhoto");
            aw.c(3, this.f179822c, this.f179823d, j3, true, imageInfo, this.f179820a.f179555d);
            if (!FileUtils.fileExistsAndNotEmpty(imageInfo.f184139m)) {
                return null;
            }
            try {
                m.k(new String[]{j3}, this.f179820a.f179555d, false, false, -1, this.f179821b);
            } catch (Exception unused) {
            }
            return imageInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ImageInfo imageInfo) {
            int i3 = 0;
            if (imageInfo != null) {
                v.a aVar = new v.a();
                aVar.v(imageInfo.f184139m);
                aVar.m(1027);
                aVar.x(this.f179820a.f179557e);
                if (imageInfo.Y == 2) {
                    i3 = 1;
                }
                aVar.y(i3);
                aVar.A(this.f179820a.f179559f);
                aVar.B(this.f179821b.getCurrentAccountUin());
                aVar.I(this.f179820a.f179555d);
                p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1027);
                createPicReq.f(aVar.l());
                ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
                ArrayList arrayList = new ArrayList();
                arrayList.add(imageInfo);
                aw.t(this.f179822c, arrayList, this.f179820a.f179555d);
                return;
            }
            aw.m(-1L, this.f179820a.f179555d, true, "image_send_prepared_failed", "sessionInfo.handleScreenPhoto");
            Context context = this.f179822c;
            QQToast.makeText(context, context.getResources().getString(R.string.cwd), 0).show(this.f179822c.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private static void A(SessionInfo sessionInfo, ActivityURIRequest activityURIRequest) {
        IGuildPhotoUtilsApi iGuildPhotoUtilsApi = (IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class);
        if (iGuildPhotoUtilsApi.useGuildPhotoList(sessionInfo)) {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoListCustomizationGuildAIOClassName());
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoPreviewCustomizationGuildAIOClassName());
        } else if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isDirectMsg(sessionInfo)) {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, iGuildPhotoUtilsApi.getPhotoListCustomizationGuildDirectMessageAIOClassName());
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        } else {
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
            activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        }
    }

    public static void a(QQAppInterface qQAppInterface, Activity activity, SessionInfo sessionInfo, ArrayList<String> arrayList, Intent intent) {
        g(qQAppInterface, activity, sessionInfo, arrayList, intent, null);
    }

    public static void b(AppInterface appInterface, Activity activity, int i3, int i16) {
        c(appInterface, activity, i3, i16, false);
    }

    public static void c(AppInterface appInterface, Activity activity, int i3, int i16, boolean z16) {
        boolean z17;
        if ((appInterface instanceof QQAppInterface) && ((QQAppInterface) appInterface).isVideoChatting()) {
            return;
        }
        if (!Utils.B()) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.h9v), 0).show();
            return;
        }
        String str = AppConstants.SDCARD_IMG_CAMERA;
        if (i16 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        String o16 = o(str, z17);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(AppConstants.Preferences.CAMERA_PHOTO_PATH, o16).commit();
        Intent intent = new Intent();
        if (i16 == 0) {
            FileProvider7Helper.setSystemCapture(activity, new File(o16), intent);
        } else {
            intent.setAction("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("output", Uri.fromFile(new File(o16)));
            intent.putExtra("android.intent.extra.videoQuality", 100);
        }
        if (z16) {
            intent.removeExtra("android.intent.extra.videoQuality");
        }
        intent.putExtra("big_brother_source_key", "biz_src_jc_camera");
        intent.putExtra("android.intent.extra.quickCapture", true);
        intent.setFlags(536870912);
        try {
            activity.startActivityForResult(intent, i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            QQToast.makeText(activity, R.string.f170671xw, 0).show();
        }
        if (QLog.isColorLevel()) {
            QLog.i("PlusPanelUtils", 2, "enter sys camera");
        }
    }

    public static void d(QQAppInterface qQAppInterface, Context context, QBaseActivity qBaseActivity, int i3, int i16) {
        e(qQAppInterface, context, qBaseActivity, i3, i16, false);
    }

    public static void e(QQAppInterface qQAppInterface, Context context, QBaseActivity qBaseActivity, int i3, int i16, boolean z16) {
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i("PlusPanelUtils", 2, "enter Camera");
        }
        if (AudioUtil.h(0)) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f6e), context.getString(R.string.f6f), new d(), null).show();
            return;
        }
        if (QQAudioHelper.g(0)) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f6e), context.getString(R.string.f6g), new e(), null).show();
            return;
        }
        if (qQAppInterface.getApp().checkPermission(QQPermissionConstants.Permission.CAMERA, Process.myPid(), Process.myUid()) != 0) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f6e), HardCodeUtil.qqStr(R.string.p_x), new f(), null).show();
            return;
        }
        if (i3 == 0) {
            i17 = 1;
        } else {
            i17 = 17000;
        }
        if (i16 == -1) {
            i16 = i17;
        }
        c(qQAppInterface, qBaseActivity, i16, i3, z16);
        com.tencent.mobileqq.activity.richmedia.f.g();
        qBaseActivity.setCanLock(false);
    }

    public static void f(QQAppInterface qQAppInterface, Activity activity, int i3) {
        try {
            if (!b71.a.a(activity)) {
                if (MapUtils.d(activity) <= 0) {
                    QQToastUtil.showQQToastInUiThread(1, activity.getString(R.string.f171143iv2));
                    return;
                } else {
                    QPublicFragmentActivity.startForResult(activity, new Intent(), (Class<? extends QPublicBaseFragment>) PoiMapPartFragment.class, 18);
                    return;
                }
            }
            com.tencent.biz.map.d.f78690a.a(qQAppInterface.getAccount());
            Intent putExtra = new Intent(activity, (Class<?>) PoiMapActivity.class).putExtra("uin", qQAppInterface.getAccount());
            putExtra.putExtra("is_need_destroy_broadcast", false);
            putExtra.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
            boolean isNowThemeIsDefault = ThemeUtil.isNowThemeIsDefault(qQAppInterface, true, null);
            putExtra.putExtra("int_unread_msgs_num", qQAppInterface.getMessageFacade().H1());
            putExtra.putExtra("boolean_is_default_theme", isNowThemeIsDefault);
            putExtra.putExtra("key_from", "key_from_aio");
            activity.startActivityForResult(putExtra, 18);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("enterQQMap", 2, e16, new Object[0]);
            }
        }
    }

    public static void g(QQAppInterface qQAppInterface, Activity activity, SessionInfo sessionInfo, ArrayList<String> arrayList, Intent intent, HashMap<LocalMediaInfo, LocalMediaInfo> hashMap) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        if (intent == null) {
            intent = new Intent();
        }
        Intent intent2 = intent;
        intent2.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1052);
        intent2.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        if (sessionInfo.f179555d != 10014) {
            intent2.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
        }
        intent2.putExtra(PeakConstants.MY_UIN, sessionInfo.T);
        intent2.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, true);
        intent2.putExtra("KEY_IS_ANONYMOUS", com.tencent.biz.anonymous.a.h().d(sessionInfo.f179557e));
        intent2.putExtra(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, com.tencent.mobileqq.activity.photo.aiocomment.d.a(qQAppInterface, sessionInfo));
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 1);
        A(sessionInfo, activityURIRequest);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        activityURIRequest.extra().putBoolean(PeakConstants.VIDEO_EDIT_ENABLED, ABTestUtil.getVideoEditABTest());
        int l3 = l(qQAppInterface, activity, sessionInfo, arrayList, intent2, activityURIRequest);
        if (l3 == -1) {
            if (sessionInfo.f179555d == 10014) {
                activityURIRequest.setRequestCode(10014);
            }
        } else {
            HashMap<String, String> a16 = j.a(hashMap);
            if (a16 != null) {
                activityURIRequest.extra().putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, a16);
            }
            activityURIRequest.setRequestCode(l3);
        }
        QRoute.startUri(activityURIRequest);
        if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "enterPhotoPicker");
        }
        QAlbumUtil.anim(activity, false, true);
        com.tencent.mobileqq.hitrate.d dVar = r05.a.f430452a;
        if (dVar != null) {
            dVar.d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
    
        r2 = "0X80049C5";
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00aa, code lost:
    
        if (r2 != 1001) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, boolean z16, String str, Map<String, String> map) {
        String str2;
        String str3;
        Integer valueOf;
        int i3 = 2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enterVideo, onlyAudio[");
            sb5.append(z16);
            sb5.append("], type[");
            String str4 = null;
            if (sessionInfo == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(sessionInfo.f179555d);
            }
            sb5.append(valueOf);
            sb5.append("], uin[");
            if (sessionInfo != null) {
                str4 = sessionInfo.f179557e;
            }
            sb5.append(str4);
            sb5.append("], from[");
            sb5.append(str);
            sb5.append("]");
            QLog.i("PlusPanelUtils", 2, sb5.toString());
        }
        if (z16) {
            i3 = 1;
        }
        if (sessionInfo != null && qQAppInterface.getAVNotifyCenter().g(context, i3, sessionInfo.f179555d, sessionInfo.f179557e)) {
            return;
        }
        String str5 = "0X80049C7";
        String str6 = str5;
        if (sessionInfo == null) {
            return;
        }
        int i16 = sessionInfo.f179555d;
        if (i16 != 0) {
            if (i16 != 1004) {
                if (i16 != 1006) {
                    if (i16 != 1010) {
                        if (i16 != 1021) {
                            if (i16 != 1024) {
                                if (i16 != 1044) {
                                    if (i16 != 10002) {
                                        if (i16 == 1000) {
                                            str3 = "2";
                                        }
                                    }
                                    str2 = "4";
                                    ReportController.o(qQAppInterface, "CliOper", "", "", str6, str6, 0, 0, str2, "", "", "");
                                    if (com.tencent.relation.common.config.toggle.c.M.g(false)) {
                                        j(qQAppInterface, context, sessionInfo, z16, str, map);
                                        return;
                                    } else {
                                        i(qQAppInterface, context, sessionInfo, z16, str, map);
                                        return;
                                    }
                                }
                                str3 = "30";
                            } else {
                                str3 = "6";
                            }
                        } else {
                            str3 = "5";
                        }
                    } else {
                        str3 = "7";
                    }
                } else {
                    str3 = "3";
                }
            } else {
                str3 = "1";
            }
            str2 = str3;
            ReportController.o(qQAppInterface, "CliOper", "", "", str6, str6, 0, 0, str2, "", "", "");
            if (com.tencent.relation.common.config.toggle.c.M.g(false)) {
            }
        }
        str2 = "0";
        ReportController.o(qQAppInterface, "CliOper", "", "", str6, str6, 0, 0, str2, "", "", "");
        if (com.tencent.relation.common.config.toggle.c.M.g(false)) {
        }
    }

    public static void i(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, boolean z16, String str, Map<String, String> map) {
        String phoneNumByUin;
        String str2;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (sessionInfo.f179555d == 1006) {
            str2 = iPhoneContactService.getUinByPhoneNum(sessionInfo.f179557e);
            phoneNumByUin = sessionInfo.f179557e;
        } else {
            String str3 = sessionInfo.f179557e;
            phoneNumByUin = iPhoneContactService.getPhoneNumByUin(str3);
            str2 = str3;
        }
        if (str == null) {
            ChatActivityUtils.j0(qQAppInterface, context, sessionInfo.f179555d, str2, sessionInfo.f179563i, phoneNumByUin, z16, sessionInfo.f179559f, true, true, null, "from_internal", map);
            return;
        }
        if ("AIOShareScreen".equals(str)) {
            ChatActivityUtils.k0(qQAppInterface, context, sessionInfo.f179555d, str2, sessionInfo.f179563i, phoneNumByUin, z16, sessionInfo.f179559f, true, true, null, str, map, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV_SHARE_SCREEN);
        } else if ("AIO_Adelie_AV".equals(str)) {
            ChatActivityUtils.c0(qQAppInterface, context, sessionInfo.f179555d, str2, sessionInfo.f179563i, z16, sessionInfo.f179559f, true, true, null, str, map);
        } else {
            ChatActivityUtils.j0(qQAppInterface, context, sessionInfo.f179555d, str2, sessionInfo.f179563i, phoneNumByUin, z16, sessionInfo.f179559f, true, true, null, str, map);
        }
    }

    public static void j(final QQAppInterface qQAppInterface, final Context context, final SessionInfo sessionInfo, final boolean z16, final String str, final Map<String, String> map) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.4
            @Override // java.lang.Runnable
            public void run() {
                final String phoneNumByUin;
                final String str2;
                IPhoneContactService iPhoneContactService = (IPhoneContactService) QQAppInterface.this.getRuntimeService(IPhoneContactService.class, "");
                SessionInfo sessionInfo2 = sessionInfo;
                if (sessionInfo2.f179555d == 1006) {
                    str2 = iPhoneContactService.getUinByPhoneNum(sessionInfo2.f179557e);
                    phoneNumByUin = sessionInfo.f179557e;
                } else {
                    String str3 = sessionInfo2.f179557e;
                    phoneNumByUin = iPhoneContactService.getPhoneNumByUin(str3);
                    str2 = str3;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        String str4 = str;
                        if (str4 == null) {
                            QQAppInterface qQAppInterface2 = QQAppInterface.this;
                            Context context2 = context;
                            SessionInfo sessionInfo3 = sessionInfo;
                            ChatActivityUtils.j0(qQAppInterface2, context2, sessionInfo3.f179555d, str2, sessionInfo3.f179563i, phoneNumByUin, z16, sessionInfo3.f179559f, true, true, null, "from_internal", map);
                            return;
                        }
                        if ("AIOShareScreen".equals(str4)) {
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            QQAppInterface qQAppInterface3 = QQAppInterface.this;
                            Context context3 = context;
                            SessionInfo sessionInfo4 = sessionInfo;
                            ChatActivityUtils.k0(qQAppInterface3, context3, sessionInfo4.f179555d, str2, sessionInfo4.f179563i, phoneNumByUin, z16, sessionInfo4.f179559f, true, true, null, str, map, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV_SHARE_SCREEN);
                            return;
                        }
                        if ("AIO_Adelie_AV".equals(str)) {
                            AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                            QQAppInterface qQAppInterface4 = QQAppInterface.this;
                            Context context4 = context;
                            SessionInfo sessionInfo5 = sessionInfo;
                            ChatActivityUtils.c0(qQAppInterface4, context4, sessionInfo5.f179555d, str2, sessionInfo5.f179563i, z16, sessionInfo5.f179559f, true, true, null, str, map);
                            return;
                        }
                        AnonymousClass4 anonymousClass44 = AnonymousClass4.this;
                        QQAppInterface qQAppInterface5 = QQAppInterface.this;
                        Context context5 = context;
                        SessionInfo sessionInfo6 = sessionInfo;
                        ChatActivityUtils.j0(qQAppInterface5, context5, sessionInfo6.f179555d, str2, sessionInfo6.f179563i, phoneNumByUin, z16, sessionInfo6.f179559f, true, true, null, str, map);
                    }
                });
            }
        }, 32, null, true);
    }

    public static void k(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, LBSHandler.a aVar) {
        if (bc.p0()) {
            return;
        }
        int i3 = 0;
        bc o06 = bc.o0(context, false);
        int[] iArr = new int[5];
        int i16 = sessionInfo.f179555d;
        if ((i16 == 1025 || i16 == 0 || i16 == 1000 || i16 == 1004) && ((QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).X(sessionInfo.f179557e)) {
            iArr[0] = 5;
            o06.addButton(R.string.f0q);
            i3 = 1;
        }
        iArr[i3] = 1;
        o06.addButton(R.string.i3u);
        iArr[i3 + 1] = 2;
        o06.addButton(R.string.i4e);
        y(sessionInfo);
        o06.addCancelButton(R.string.cancel);
        o06.setOnDismissListener(new a(qQAppInterface));
        o06.setOnButtonClickListener(new AnonymousClass2(o06, iArr, sessionInfo, qQAppInterface, aVar, context));
        o06.setOnBottomCancelListener(new b(o06));
        o06.show();
        kv.a.f413301a.b();
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
    }

    public static int l(QQAppInterface qQAppInterface, Activity activity, SessionInfo sessionInfo, ArrayList<String> arrayList, Intent intent, ActivityURIRequest activityURIRequest) {
        ActivityURIRequest activityURIRequest2;
        int i3;
        boolean z16;
        boolean z17;
        Intent intent2;
        if (intent == null || !intent.hasExtra("showFlashPic")) {
            activityURIRequest.extra().putBoolean("showFlashPic", ((IPicFlash) QRoute.api(IPicFlash.class)).showFlashPicOption(sessionInfo.f179555d, sessionInfo.f179559f));
        }
        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1052);
        boolean z18 = activity instanceof SplashActivity;
        if (!z18 && !(activity instanceof ChatActivity) && !(activity instanceof LiteActivity)) {
            activityURIRequest.extra().putAll(activity.getIntent().getExtras());
            activityURIRequest2 = activityURIRequest;
        } else {
            activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
            if (activity instanceof SplashActivity) {
                activityURIRequest2 = BaseAIOUtils.n(activityURIRequest, null);
            } else {
                activityURIRequest2 = activityURIRequest;
            }
            activityURIRequest2.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            activityURIRequest2.extra().putString("key_activity_code", ChatActivityUtils.p(activity));
            activityURIRequest2.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
            activityURIRequest2.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
            activityURIRequest2.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
            activityURIRequest2.extra().putInt(ConfessInfo.KEY_CONFESS_TOPICID, sessionInfo.S);
            activityURIRequest2.extra().putString(PeakConstants.DEST_VIDEO_ACTIVITY_CLASS_NAME, SendVideoActivity.class.getName());
            activityURIRequest2.extra().putString(PeakConstants.DEST_VIDEO_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        }
        activityURIRequest2.extra().putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
        int i16 = -1;
        if (intent != null) {
            int intExtra = intent.getIntExtra(PeakConstants.REQUEST_CODE, -1);
            activityURIRequest2.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0));
            int intExtra2 = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
            boolean booleanExtra = intent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
            boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.FILTER_PHOTOLIST_TROOPALBUM_TOOLBAR, false);
            int intExtra3 = intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1);
            if (intExtra3 == 1039) {
                activityURIRequest2.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1039);
            }
            if (intExtra3 == 1040) {
                activityURIRequest2.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1040);
            }
            activityURIRequest2.extra().putBoolean(PeakConstants.IS_TROOP_SEND_MIXED_MSG, intent.getBooleanExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, false));
            PhotoUtils.copyReportInfo(intent, activityURIRequest2);
            activityURIRequest2.extra().putBoolean(PeakConstants.DISABLE_UPLOAD_TO_TROOP_ALBUM, intent.getBooleanExtra(PeakConstants.DISABLE_UPLOAD_TO_TROOP_ALBUM, false));
            activityURIRequest2.extra().putBoolean(PeakConstants.UPLOAD_CHECKBOX_IS_CHECKED, intent.getBooleanExtra(PeakConstants.UPLOAD_CHECKBOX_IS_CHECKED, false));
            activityURIRequest2.extra().putBoolean(PeakConstants.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR, intent.getBooleanExtra(PeakConstants.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR, false));
            activityURIRequest2.extra().putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false));
            activityURIRequest2.extra().putBoolean(PeakConstants.QZONE_ALBUM_FROM_AIO, intent.getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false));
            activityURIRequest2.extra().putBoolean(PeakConstants.FROM_PHOTO_LIST_PANEL, intent.getBooleanExtra(PeakConstants.FROM_PHOTO_LIST_PANEL, false));
            activityURIRequest2.extra().putBoolean("KEY_IS_ANONYMOUS", intent.getBooleanExtra("KEY_IS_ANONYMOUS", false));
            activityURIRequest2.extra().putBoolean(PeakConstants.SEND_NO_PRESEND, intent.getBooleanExtra(PeakConstants.SEND_NO_PRESEND, false));
            activityURIRequest2.extra().putBoolean(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, intent.getBooleanExtra(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, false));
            z16 = booleanExtra;
            z17 = booleanExtra2;
            i3 = intExtra2;
            i16 = intExtra;
        } else {
            i3 = 20;
            z16 = false;
            z17 = false;
        }
        int i17 = i16;
        if (sessionInfo.f179555d == 1 && ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).V(sessionInfo.f179557e)) {
            activityURIRequest2.extra().putBoolean(PeakConstants.DISABLE_UPLOAD_TO_TROOP_ALBUM, true);
        }
        if (sessionInfo.f179555d == 10014) {
            if (!TextUtils.isEmpty(sessionInfo.f179559f) && !TextUtils.isEmpty(sessionInfo.f179557e)) {
                if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
                    intent2 = q(activity, sessionInfo);
                } else {
                    intent2 = p(activity, sessionInfo);
                }
            } else {
                intent2 = null;
            }
            activityURIRequest2.extra().putParcelable(PeakConstants.GUILD_OPEN_AIO_INTENT, intent2);
            if (((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isDirectMsg(sessionInfo)) {
                activityURIRequest2.extra().putBoolean(PeakConstants.PHOTOLIST_KEY_FILTER_VIDEO, true);
            }
        }
        activityURIRequest2.extra().putBoolean("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", z16);
        activityURIRequest2.extra().putBoolean(PeakConstants.FILTER_PHOTOLIST_TROOPALBUM_TOOLBAR, z17);
        activityURIRequest2.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i3);
        activityURIRequest2.extra().putString("extra_image_sender_tag", "sessionInfo.enterAlbum");
        activityURIRequest2.extra().putBoolean(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        activityURIRequest2.extra().putBoolean(QAlbumConstants.ALBUM_ENTER_DIRECTLY, true);
        activityURIRequest2.extra().putString(QAlbumConstants.ALBUM_ID, com.tencent.mobileqq.utils.e.h(activity));
        activityURIRequest2.extra().putString(QAlbumConstants.ALBUM_NAME, com.tencent.mobileqq.utils.e.i(activity));
        activityURIRequest2.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        activityURIRequest2.extra().putString("uin", sessionInfo.f179557e);
        activityURIRequest2.extra().putInt("uintype", sessionInfo.f179555d);
        activityURIRequest2.extra().putString("troop_uin", sessionInfo.f179559f);
        activityURIRequest2.extra().putString("uinname", sessionInfo.f179563i);
        activityURIRequest2.extra().putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, sessionInfo.P);
        activityURIRequest2.extra().putBoolean(QAlbumConstants.IS_SHOW_CAMERA, false);
        if (z18 || (activity instanceof ChatActivity)) {
            BaseActivity baseActivity = (BaseActivity) activity;
            if (baseActivity.getChatFragment() != null) {
                activityURIRequest2.extra().putBoolean("isBack2Root", baseActivity.getChatFragment().qh().f25590o);
            }
        }
        activityURIRequest2.extra().putBoolean("is_anonymous", com.tencent.biz.anonymous.a.h().d(sessionInfo.f179557e));
        activityURIRequest2.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, s(sessionInfo));
        activityURIRequest2.extra().remove("forward_type");
        if (intent != null && intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)) {
            activityURIRequest2.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
            activityURIRequest2.extra().putBoolean("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
            activityURIRequest2.extra().putParcelable(AppConstants.Key.SESSION_INFO, sessionInfo);
            activityURIRequest2.extra().putBoolean("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
            activityURIRequest2.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", Math.min(com.tencent.mobileqq.receipt.a.a(qQAppInterface), i3));
        }
        activityURIRequest2.extra().putParcelable(AppConstants.Key.SESSION_INFO, sessionInfo);
        if (arrayList != null && !arrayList.isEmpty()) {
            activityURIRequest2.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + activityURIRequest2.extra().getString("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
            QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + i3);
        }
        return i17;
    }

    public static String m() {
        return n(AppConstants.SDCARD_IMG_CAMERA);
    }

    public static String n(String str) {
        return o(str, false);
    }

    public static String o(String str, boolean z16) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Object valueOf5;
        String str2;
        Calendar calendar = Calendar.getInstance();
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append("IMG");
        sb5.append(calendar.get(1));
        int i3 = calendar.get(2) + 1;
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = Integer.valueOf(i3);
        }
        sb5.append(valueOf);
        int i16 = calendar.get(5);
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = Integer.valueOf(i16);
        }
        sb5.append(valueOf2);
        int i17 = calendar.get(11);
        if (i17 < 10) {
            valueOf3 = "0" + i17;
        } else {
            valueOf3 = Integer.valueOf(i17);
        }
        sb5.append(valueOf3);
        int i18 = calendar.get(12);
        if (i18 < 10) {
            valueOf4 = "0" + i18;
        } else {
            valueOf4 = Integer.valueOf(i18);
        }
        sb5.append(valueOf4);
        int i19 = calendar.get(13);
        if (i19 < 10) {
            valueOf5 = "0" + i19;
        } else {
            valueOf5 = Integer.valueOf(i19);
        }
        sb5.append(valueOf5);
        if (z16) {
            str2 = ".mp4";
        } else {
            str2 = ".jpg";
        }
        if (!new File(sb5.toString() + str2).exists()) {
            return sb5.toString() + str2;
        }
        StringBuilder sb6 = new StringBuilder(sb5);
        int length = sb5.length();
        for (int i26 = 1; i26 < Integer.MAX_VALUE; i26++) {
            sb6.append('(');
            sb6.append(i26);
            sb6.append(')');
            sb6.append(str2);
            if (!new File(sb6.toString()).exists()) {
                break;
            }
            sb6.delete(length, sb6.length());
        }
        return sb6.toString();
    }

    private static Intent p(Context context, SessionInfo sessionInfo) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, sessionInfo.b().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG));
        return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(context, new LaunchGuildChatPieParam().l(sessionInfo.f179559f).b(sessionInfo.f179557e).k(bundle).r(true).o(1).f(true).a());
    }

    private static Intent q(Context context, SessionInfo sessionInfo) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, sessionInfo.b().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG));
        return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(context, new i().f(sessionInfo.f179559f).b(sessionInfo.f179557e).d(com.tencent.guild.aio.factory.a.class.getName()).e(bundle).a());
    }

    private static long r() {
        SharedPreferences u16 = u();
        if (u16.contains(PeakConstants.KEY_PRESEND_OFF_TIME)) {
            return u16.getLong(PeakConstants.KEY_PRESEND_OFF_TIME, 0L);
        }
        long j3 = t().getLong(PeakConstants.KEY_PRESEND_OFF_TIME, 0L);
        u16.edit().putLong(PeakConstants.KEY_PRESEND_OFF_TIME, j3).commit();
        return j3;
    }

    public static int s(com.tencent.mobileqq.activity.aio.p pVar) {
        int i3;
        if (com.tencent.mobileqq.utils.e.m(pVar.f179555d)) {
            i3 = 5;
        } else {
            i3 = 6;
        }
        if (com.tencent.biz.anonymous.a.h().d(pVar.f179557e)) {
            return 1;
        }
        return i3;
    }

    public static SharedPreferences t() {
        return BaseApplication.getContext().getSharedPreferences(PeakConstants.PRESEND_CONFIG_SP, 4);
    }

    public static SharedPreferences u() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), PeakConstants.PRESEND_CONFIG_SP, "common_mmkv_configurations");
    }

    private static boolean v() {
        SharedPreferences u16 = u();
        if (u16.contains(PeakConstants.KEY_PRESEND_OFF_FLAG)) {
            return u16.getBoolean(PeakConstants.KEY_PRESEND_OFF_FLAG, false);
        }
        boolean z16 = t().getBoolean(PeakConstants.KEY_PRESEND_OFF_FLAG, false);
        u16.edit().putBoolean(PeakConstants.KEY_PRESEND_OFF_FLAG, z16).commit();
        return z16;
    }

    public static void w(QQAppInterface qQAppInterface, Context context, Uri uri, SessionInfo sessionInfo) {
        new c(sessionInfo, qQAppInterface, context, BaseImageUtil.getRealPathFromContentURI(context, uri)).execute(new Void[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean x(SessionInfo sessionInfo, boolean z16) {
        boolean z17;
        boolean isFeatureSupported = ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpresend_whitelist.name());
        boolean v3 = v();
        boolean z18 = false;
        if (v3) {
            if (System.currentTimeMillis() - r() > 86400000) {
                if (QLog.isColorLevel()) {
                    QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
                }
                u().edit().putBoolean(PeakConstants.KEY_PRESEND_OFF_FLAG, false).commit();
                v3 = false;
            }
        }
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name())) {
            if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
            }
            v3 = false;
        }
        int i3 = sessionInfo.f179555d;
        if ((i3 == 1001 || i3 == 10002) && !z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "isPresendAllowed,old lbs protocol ,disable PicPresend!");
            }
            v3 = true;
        }
        int i16 = sessionInfo.f179555d;
        if (i16 == 9500 || i16 == 9501) {
            if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "curType is smart device ,disable PicPresend!");
            }
            v3 = true;
        }
        if (sessionInfo.f179555d == 10014) {
            if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "curType is guild ,disable PicPresend!");
            }
            v3 = true;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pic_presend.name(), IDPCApiConstant.PIC_PRESEND_DEFAULT);
        if (!v3 && featureValue != null && featureValue.length() > 0) {
            String[] split = featureValue.split("\\|");
            if (split.length >= 4) {
                boolean equals = split[0].equals("1");
                boolean equals2 = split[1].equals("1");
                boolean equals3 = split[2].equals("1");
                boolean equals4 = split[3].equals("1");
                int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                if (systemNetwork != 1) {
                    if (systemNetwork != 2) {
                        if (systemNetwork != 3) {
                            if (systemNetwork == 4) {
                                z17 = !equals4;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("PEAK", 2, "isPresendAllowed netType = " + systemNetwork + ",enablePreCompress_WIFI:" + equals + ", enablePreCompress_2G = " + equals2 + ", enablePreCompress_3G = " + equals3 + ", enablePreCompress_4G = " + equals4 + ", presendOFF  = " + v3);
                            }
                        } else {
                            z17 = !equals3;
                        }
                    } else {
                        z17 = !equals2;
                    }
                } else {
                    z17 = !equals;
                }
                v3 = z17;
                if (QLog.isColorLevel()) {
                }
            }
        }
        if (!isFeatureSupported && !v3) {
            z18 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed, isInDPCPicPresendWhiteList :" + isFeatureSupported + ", presendOFF = " + v3 + ", result  = " + z18);
        }
        return z18;
    }

    public static boolean y(SessionInfo sessionInfo) {
        int i3 = sessionInfo.f179555d;
        if (i3 != 1001 && i3 != 10002 && i3 != 1010) {
            return true;
        }
        return false;
    }

    public static void z(ActivityURIRequest activityURIRequest, SessionInfo sessionInfo, QQAppInterface qQAppInterface) {
        if (x(sessionInfo, qQAppInterface.isLBSFriendNewClient(sessionInfo.f179557e))) {
            if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
            }
            activityURIRequest.extra().putParcelable(PeakConstants.BINDER_PRESENDSERVICE, new BinderWarpper(new y(sessionInfo.f179555d, sessionInfo.f179557e, sessionInfo.f179559f, qQAppInterface.getAccount(), sessionInfo.S).asBinder()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

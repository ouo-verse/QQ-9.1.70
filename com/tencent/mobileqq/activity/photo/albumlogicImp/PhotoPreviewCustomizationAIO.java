package com.tencent.mobileqq.activity.photo.albumlogicImp;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.aiocomment.c;
import com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.i;
import com.tencent.mobileqq.activity.photo.album.j;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.d;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.activity.richmedia.f;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.SystemBarTintManager;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class PhotoPreviewCustomizationAIO extends PhotoPreviewCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String R;
    public int G;
    public boolean H;
    boolean I;
    boolean J;
    private SendByFile K;
    protected boolean L;
    protected boolean M;
    public boolean N;
    protected c P;
    private boolean Q;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            R = PhotoPreviewCustomizationAIO.class.getName();
        }
    }

    public PhotoPreviewCustomizationAIO(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoPreviewActivity);
            return;
        }
        this.G = 1052;
        this.H = false;
        this.I = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U() {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
            QQToast.makeText(basePhotoPreviewActivity, basePhotoPreviewActivity.getResources().getString(R.string.f237737hv), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(this.f184197m.getIntent());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", this.f184197m.getPackageName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, this.f184197m.getPackageName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
        intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, R);
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, true);
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(this.f184197m, intent, ((h) this.f184335f).a(this.f184334e, this.C.f184264w));
    }

    private void W(int i3) {
        boolean z16;
        int i16;
        boolean z17;
        String j3;
        if (this.f184334e.selectedPhotoList.size() >= this.f184334e.maxSelectNum) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", i16, 0, "", "", "", "");
        if (z16) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184328f >= 700) {
                BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
                if (this.L) {
                    j3 = basePhotoPreviewActivity.getResources().getString(R.string.w2l, Integer.valueOf(this.f184334e.maxSelectNum));
                } else {
                    j3 = v().j();
                }
                QQToast.makeText(basePhotoPreviewActivity, j3, 1000).show();
                i iVar = this.C;
                iVar.f184328f = currentTimeMillis;
                if (iVar.F) {
                    ReportController.o(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
                }
            }
            v().I.setChecked(false);
            return;
        }
        if (i3 != -1 && this.C.f184324b.size() > i3) {
            this.f184337i.k(this.C.f184324b.get(i3));
            PresendPicMgr g16 = PresendPicMgr.g(null);
            if (g16 != null) {
                i iVar2 = this.C;
                if (!iVar2.B && this.f184337i.l(iVar2.f184324b.get(i3)) != 1) {
                    g16.j(this.C.f184324b.get(i3), this.G);
                }
            }
            String str = this.C.f184324b.get(i3);
            this.f184334e.selectedPhotoList.add(str);
            HashMap<String, PhotoSendParams> hashMap = this.C.f184252k;
            if (hashMap != null) {
                PhotoSendParams photoSendParams = hashMap.get(str);
                HashMap<String, PhotoSendParams> hashMap2 = this.C.f184253l;
                if (hashMap2 != null && photoSendParams != null) {
                    hashMap2.put(str, photoSendParams);
                }
            }
            HashMap<String, PicInfo> hashMap3 = this.C.f184254m;
            if (hashMap3 != null) {
                PicInfo picInfo = hashMap3.get(str);
                HashMap<String, PicInfo> hashMap4 = this.C.f184255n;
                if (hashMap4 != null && picInfo != null) {
                    hashMap4.put(str, picInfo);
                }
            }
            this.f184334e.selectedIndex.add(Integer.valueOf(i3));
            v().n(str);
            SendByFile sendByFile = this.K;
            if (sendByFile != null) {
                BasePhotoPreviewActivity basePhotoPreviewActivity2 = this.f184197m;
                if (((h) this.f184335f).f184248f == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
                sendByFile.c(basePhotoPreviewActivity2, str, z17, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap, true);
            }
        }
        g();
    }

    private void X(int i3) {
        v().I.setChecked(false);
        int indexOf = this.f184334e.selectedIndex.indexOf(Integer.valueOf(i3));
        if (indexOf >= 0) {
            this.f184334e.selectedIndex.remove(indexOf);
            if (i3 != -1) {
                this.f184334e.selectedPhotoList.remove(this.C.f184324b.get(i3));
                i iVar = this.C;
                HashMap<String, PicInfo> hashMap = iVar.f184255n;
                if (hashMap != null) {
                    hashMap.remove(iVar.f184324b.get(i3));
                }
                i iVar2 = this.C;
                HashMap<String, PhotoSendParams> hashMap2 = iVar2.f184253l;
                if (hashMap2 != null) {
                    hashMap2.remove(iVar2.f184324b.get(i3));
                }
                PresendPicMgr g16 = PresendPicMgr.g(null);
                if (g16 != null) {
                    g16.b(this.C.f184324b.get(i3), 1014);
                }
            }
        }
        g();
        if (this.f184334e.selectedIndex.size() == 0) {
            i iVar3 = this.C;
            if (!iVar3.B) {
                iVar3.D = false;
            }
        }
    }

    private void Y() {
        String str;
        Intent intent = this.f184197m.getIntent();
        if (this.C.B && intent != null) {
            intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1040);
            int i3 = this.C.f184261t;
            if (i3 == 0) {
                ReportController.o(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
            } else if (i3 == 3000) {
                ReportController.o(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
            } else if (i3 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
            }
        }
        int i16 = 0;
        if (intent != null && intent.getBooleanExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT, false)) {
            String stringExtra = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_ACTION_NAME);
            String stringExtra2 = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_ALBUM_REPORT_REVERSE2);
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_CAMERA_REPORT_REVERSE2);
            }
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_REVERSE2);
            }
            if (stringExtra2 == null) {
                str = "";
            } else {
                str = stringExtra2;
            }
            if (stringExtra != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, str, "", "", "");
            }
        }
        if (A() && this.C.G > 0) {
            Iterator<String> it = this.f184334e.selectedPhotoList.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                String next = it.next();
                for (String str2 : this.C.f184325c.values()) {
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(str2) && next.equals(str2)) {
                        i17++;
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
            if (arrayList != null) {
                i16 = arrayList.size();
            }
            sb5.append(i16);
            sb5.append("");
            ReportController.o(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, sb5.toString(), i17 + "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        ArrayList<String> arrayList = this.f184334e.selectedPhotoList;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void B(int i3, int i16, Intent intent) {
        boolean z16;
        String stringExtra;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 != -1 || intent == null || !(!intent.getBooleanExtra(PeakConstants.SEND_PICTURE_ORIGIN, false)) || (stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(stringExtra) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f184430d;

            {
                this.f184430d = stringExtra;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationAIO.this, (Object) stringExtra);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    j.a(new File(this.f184430d).getParent());
                }
            }
        }, 64, null, true);
        if (QLog.isColorLevel()) {
            QLog.i("QQAlbum", 2, "onActivityResultForMultiEdit hasEdit:" + z16 + ", picPath:" + stringExtra);
        }
        String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH);
        int indexOf = this.C.f184324b.indexOf(stringExtra2);
        if (indexOf >= 0) {
            if (this.C.f184325c.containsValue(stringExtra2)) {
                str = com.tencent.mobileqq.activity.photo.j.d(this.C.f184325c, stringExtra2);
            } else {
                str = stringExtra2;
            }
            this.C.f184325c.put(str, stringExtra);
            this.C.f184324b.add(indexOf, stringExtra);
            this.C.f184324b.remove(indexOf + 1);
            int indexOf2 = this.f184334e.selectedPhotoList.indexOf(stringExtra2);
            this.F = indexOf2;
            if (indexOf2 >= 0) {
                this.f184334e.selectedPhotoList.add(indexOf2, stringExtra);
                this.f184334e.selectedPhotoList.remove(this.F + 1);
            }
            this.f184197m.selectedPhotoAdapter.notifyDataSetChanged();
            RichMediaBrowserInfo richMediaBrowserInfo = new RichMediaBrowserInfo();
            if (intent.hasExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA)) {
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA);
                PreviewVideoData previewVideoData = new PreviewVideoData();
                previewVideoData.f184339d = localMediaInfo;
                previewVideoData.filePath = localMediaInfo.path;
                richMediaBrowserInfo.baseData = previewVideoData;
                this.f184334e.selectedMediaInfoHashMap.remove(stringExtra2);
                this.f184334e.selectedMediaInfoHashMap.put(stringExtra, localMediaInfo);
                this.f184334e.allMediaInfoHashMap.remove(stringExtra2);
                this.f184334e.allMediaInfoHashMap.put(stringExtra, localMediaInfo);
                this.D = (LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA);
                this.E = (LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA);
                VideoReport.addToDetectionWhitelist(this.f184197m);
                VideoReport.setPageId(this.f184197m, "pg_video_process");
                HashMap hashMap = new HashMap();
                hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
                hashMap.put("type_aio_pg", Integer.valueOf(intent.getIntExtra("uintype", 5)));
                VideoReport.setPageParams(this.f184197m, new PageParams(hashMap));
            } else {
                PreviewPictureData previewPictureData = new PreviewPictureData();
                previewPictureData.filePath = stringExtra;
                richMediaBrowserInfo.baseData = previewPictureData;
            }
            this.f184337i.f184341e.updateItem(richMediaBrowserInfo, indexOf);
            this.f184337i.f184341e.setSelectedIndex(indexOf);
            v().notifyDataSetChanged();
            v().scrollToCurrentPosition();
            PresendPicMgr f16 = PresendPicMgr.f();
            if (f16 != null) {
                f16.b(stringExtra2, 1003);
                f16.j(stringExtra, this.G);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void C(View view, int i3, Bundle bundle, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), bundle, Integer.valueOf(i16), intent);
            return;
        }
        int i17 = v().i();
        if (i17 != -1 && i17 < this.C.f184324b.size()) {
            if (this.f184197m.isInMultiWindow()) {
                QQToast.makeText(this.f184197m, R.string.lwl, 0).show();
                return;
            }
            if (v().getItem(i17).baseData.getType() == 101) {
                i iVar = this.C;
                iVar.f184264w = iVar.f184324b.get(i17);
                U();
            } else {
                bundle.putBoolean("key_multi_edit_pic", true);
                bundle.putBoolean(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
                if (this.C.B) {
                    this.f184197m.getIntent().putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1040);
                }
                super.C(view, 10000, bundle, 2, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    protected void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        PresendPicMgr g16 = PresendPicMgr.g(null);
        v().I.setChecked(false);
        int indexOf = this.f184334e.selectedIndex.indexOf(Integer.valueOf(i3));
        if (indexOf >= 0) {
            this.f184334e.selectedIndex.remove(indexOf);
            if (i3 != -1) {
                this.f184334e.selectedPhotoList.remove(this.C.f184324b.get(i3));
                i iVar = this.C;
                HashMap<String, PicInfo> hashMap = iVar.f184255n;
                if (hashMap != null) {
                    hashMap.remove(iVar.f184324b.get(i3));
                }
                i iVar2 = this.C;
                HashMap<String, PhotoSendParams> hashMap2 = iVar2.f184253l;
                if (hashMap2 != null) {
                    hashMap2.remove(iVar2.f184324b.get(i3));
                }
                if (g16 != null) {
                    g16.b(this.C.f184324b.get(i3), 1014);
                }
            }
        }
        g();
        if (this.f184334e.selectedIndex.size() == 0) {
            i iVar3 = this.C;
            if (!iVar3.B) {
                iVar3.D = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        PresendPicMgr g16 = PresendPicMgr.g(null);
        if (this.f184334e.selectedPhotoList.size() >= this.f184334e.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184328f >= 700) {
                QQToast.makeText(this.f184197m, v().j(), 1000).show();
                i iVar = this.C;
                iVar.f184328f = currentTimeMillis;
                if (iVar.F) {
                    ReportController.o(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
                }
            }
            v().I.setChecked(false);
            return;
        }
        if (i3 != -1) {
            String str = this.C.f184324b.get(i3);
            this.f184337i.k(str);
            if (((h) this.f184335f).f184248f == 2 && F()) {
                return;
            }
            if (this.f184197m.getIntent().getBooleanExtra(PeakConstants.IS_SEND_GIF_SIZE_LIMIT, false) && BaseImageUtil.isGifFile(str) && FileUtils.getFileSizes(str) > 3145728) {
                QQToast.makeText(this.f184197m, "\u56fe\u7247\u6587\u4ef6\u8fc7\u5927", 0).show();
                v().I.setChecked(false);
                return;
            }
            if (g16 != null) {
                i iVar2 = this.C;
                if (!iVar2.B && this.f184337i.l(iVar2.f184324b.get(i3)) != 1) {
                    g16.j(this.C.f184324b.get(i3), this.G);
                }
            }
            String str2 = this.C.f184324b.get(i3);
            this.f184334e.selectedPhotoList.add(str2);
            HashMap<String, PhotoSendParams> hashMap = this.C.f184252k;
            if (hashMap != null) {
                PhotoSendParams photoSendParams = hashMap.get(str2);
                HashMap<String, PhotoSendParams> hashMap2 = this.C.f184253l;
                if (hashMap2 != null && photoSendParams != null) {
                    hashMap2.put(str2, photoSendParams);
                }
            }
            HashMap<String, PicInfo> hashMap3 = this.C.f184254m;
            if (hashMap3 != null) {
                PicInfo picInfo = hashMap3.get(str2);
                HashMap<String, PicInfo> hashMap4 = this.C.f184255n;
                if (hashMap4 != null && picInfo != null) {
                    hashMap4.put(str2, picInfo);
                }
            }
            this.f184334e.selectedIndex.add(Integer.valueOf(i3));
            v().n(str2);
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        String str = this.C.f184324b.get(v().i());
        if (this.f184337i.l(str) == 1) {
            LocalMediaInfo k3 = this.f184337i.k(str);
            if (k3 != null && k3.fileSize > ShortVideoConstants.VIDEO_SIZE_LIMIT) {
                BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
                QQToast.makeText(basePhotoPreviewActivity, basePhotoPreviewActivity.getResources().getString(R.string.hlf), 0).show(this.f184197m.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                e.p();
            }
            return false;
        }
        return super.F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e0  */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G(Intent intent, boolean z16, ArrayList<String> arrayList) {
        int i3;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        Pair pair = new Pair(new ArrayList(), new ArrayList());
        SendByFile sendByFile = this.K;
        if (sendByFile != null) {
            if (((h) this.f184335f).f184248f == 2) {
                z19 = true;
            } else {
                z19 = false;
            }
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
            Pair<ArrayList<String>, ArrayList<String>> b16 = sendByFile.b(arrayList, z19, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap);
            ((ArrayList) pair.first).addAll(b16.first);
            ((ArrayList) pair.second).addAll(b16.second);
            intent.putStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE, (ArrayList) pair.second);
        } else {
            ((ArrayList) pair.first).addAll(arrayList);
        }
        try {
            i3 = PhotoUtils.getTypeforReportSpcialDiscuss((SessionInfo) intent.getParcelableExtra(AppConstants.Key.SESSION_INFO));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQAlbum", 2, "submit", e16);
            }
            i3 = -1;
        }
        HashMap hashMap = new HashMap();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        while (i17 < ((ArrayList) pair.first).size()) {
            String str = (String) ((ArrayList) pair.first).get(i17);
            if (!ImageManager.isNetworkUrl(str)) {
                if (this.f184337i.l(str) == i16) {
                    LocalMediaInfo k3 = this.f184337i.k(str);
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    i19++;
                    sendVideoInfo.fileSize = k3.fileSize;
                    sendVideoInfo.duration = k3.mDuration;
                    hashMap.put(Integer.valueOf(i26), sendVideoInfo);
                } else {
                    i18++;
                }
                i26++;
            }
            i17++;
            i16 = 1;
        }
        String valueOf = String.valueOf(i18);
        String valueOf2 = String.valueOf(i19);
        try {
            intent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "put extra Exception");
            }
        }
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
            z17 = true;
            if (com.tencent.mobileqq.shortvideo.h.f287891c == 0 && System.currentTimeMillis() - com.tencent.mobileqq.shortvideo.h.f287891c < MiniBoxNoticeInfo.MIN_5) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "upload video isConfirmed=" + z18 + " allowUploadInXGTime=" + com.tencent.mobileqq.shortvideo.h.f287891c);
            }
            if (!NetworkUtil.isMobileNetWork(BaseApplication.getContext()) && !z18 && z17 && H()) {
                DialogUtil.createCustomDialog(this.f184197m, 232, null, this.f184197m.getResources().getString(R.string.f173101he2), new DialogInterface.OnClickListener(new Runnable(z16, intent, pair, i3, valueOf, valueOf2) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ boolean f184421d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Intent f184422e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Pair f184423f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f184424h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f184425i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ String f184426m;

                    {
                        this.f184421d = z16;
                        this.f184422e = intent;
                        this.f184423f = pair;
                        this.f184424h = i3;
                        this.f184425i = valueOf;
                        this.f184426m = valueOf2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, PhotoPreviewCustomizationAIO.this, Boolean.valueOf(z16), intent, pair, Integer.valueOf(i3), valueOf, valueOf2);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (!this.f184421d) {
                            BasePhotoPreviewActivity basePhotoPreviewActivity = ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAIO.this).f184197m;
                            Intent intent2 = this.f184422e;
                            ArrayList arrayList2 = (ArrayList) this.f184423f.first;
                            PhotoPreviewCustomizationAIO photoPreviewCustomizationAIO = PhotoPreviewCustomizationAIO.this;
                            PhotoUtils.sendPhoto(basePhotoPreviewActivity, intent2, arrayList2, ((h) photoPreviewCustomizationAIO.f184335f).f184248f, ((PhotoPreviewCustomizationDefault) photoPreviewCustomizationAIO).C.f184256o);
                        } else {
                            ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAIO.this).f184197m, this.f184422e, (ArrayList) this.f184423f.first, ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAIO.this).C.f184253l, ((h) PhotoPreviewCustomizationAIO.this.f184335f).f184248f, true);
                            ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAIO.this).f184197m.setResult(-1);
                            ((PhotoPreviewCustomizationDefault) PhotoPreviewCustomizationAIO.this).f184197m.finish();
                        }
                        ReportController.o(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.f184424h, 0, this.f184425i, this.f184426m, "", "");
                        com.tencent.mobileqq.shortvideo.h.f287891c = System.currentTimeMillis();
                    }
                }) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Runnable f184427d;

                    {
                        this.f184427d = r5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationAIO.this, (Object) r5);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i27) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i27);
                        } else {
                            this.f184427d.run();
                        }
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationAIO.this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i27) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i27);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("QQAlbum", 2, "cancel shortvideo_mobile_send_confirm dialog");
                        }
                        if (PhotoPreviewCustomizationAIO.this.v().H != null) {
                            PhotoPreviewCustomizationAIO.this.v().H.setClickable(true);
                        }
                    }
                }).show();
                if (QLog.isColorLevel()) {
                    QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
                    return;
                }
                return;
            }
            if (!z16) {
                ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(this.f184197m, intent, (ArrayList) pair.first, this.C.f184253l, ((h) this.f184335f).f184248f, true);
                this.f184197m.setResult(-1);
                this.f184197m.finish();
            } else {
                PhotoUtils.sendPhoto(this.f184197m, intent, (ArrayList) pair.first, ((h) this.f184335f).f184248f, this.C.f184256o);
            }
            ReportController.o(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", i3, 0, valueOf, valueOf2, "", "");
        }
        z17 = false;
        if (com.tencent.mobileqq.shortvideo.h.f287891c == 0) {
        }
        z18 = false;
        if (QLog.isColorLevel()) {
        }
        if (!NetworkUtil.isMobileNetWork(BaseApplication.getContext())) {
        }
        if (!z16) {
        }
        ReportController.o(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", i3, 0, valueOf, valueOf2, "", "");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    protected void I(TextView textView) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
            return;
        }
        Iterator<String> it = this.f184334e.selectedPhotoList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!NetworkUtils.isNetworkUrl(next) && this.f184337i.l(next) == 1) {
                textView.setText(this.f184197m.getString(d.f184452e));
            }
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
        int f16 = j.f(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap, true, this.C.f184253l, photoCommonBaseData.selectedMediaInfoHashMap);
        if (f16 == 0) {
            textView.setText(this.f184197m.getString(d.f184452e));
            return;
        }
        String rawPhotoSize = PhotoUtils.getRawPhotoSize(this.f184197m, f16);
        if (this.f184334e.selectedPhotoList.size() != 0 && !rawPhotoSize.equals("0")) {
            string = this.f184197m.getString(d.f184452e) + "(\u5171" + rawPhotoSize + ")";
        } else {
            string = this.f184197m.getString(d.f184452e);
        }
        textView.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public void J() {
        Intent intent;
        String str;
        PhotoSendParams photoSendParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Y();
        if (PhotoCommonBaseData.FROM_QZONE_PHOTO_LIST.equals(this.C.f184326d)) {
            ArrayList<String> m3 = v().m();
            if (m3 != null && m3.size() == 1 && (str = m3.get(0)) != null && str.startsWith("http") && (photoSendParams = this.C.f184252k.get(str)) != null) {
                this.C.f184253l.put(str, photoSendParams);
            }
            if (this.f184334e.selectedPhotoList.size() != 0) {
                if (this.f184197m.getIntent().getParcelableExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT) != null) {
                    intent = (Intent) this.f184197m.getIntent().getParcelableExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT);
                } else {
                    intent = this.f184197m.getIntent();
                }
                intent.setExtrasClassLoader(PeakConstants.class.getClassLoader());
                intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1052);
                intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
                intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
                this.P.t(intent);
                G(intent, true, v().m());
                return;
            }
            return;
        }
        if (this.L) {
            Intent V = V(v().m());
            if (V != null) {
                this.f184197m.setResult(-1, V);
                this.f184197m.finish();
                return;
            }
            return;
        }
        if (this.C.B) {
            this.f184197m.getIntent().putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1040);
        }
        i iVar = this.C;
        if (iVar.f184258q && (!TextUtils.isEmpty(iVar.f184266y) || !TextUtils.isEmpty(this.C.f184267z))) {
            v().C.performClick();
        }
        ArrayList<String> m16 = v().m();
        Intent intent2 = this.f184197m.getIntent();
        m.p(m16.size(), this.C.f184329g);
        m.i(intent2, m16.size(), ((h) this.f184335f).f184248f);
        PresendPicMgr g16 = PresendPicMgr.g(null);
        if (((h) this.f184335f).f184248f == 2) {
            if (this.f184334e.selectedPhotoList.size() == 0 && m16.size() == 1 && FileUtils.getFileSizes(m16.get(0)) > ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
                BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
                QQToast.makeText(basePhotoPreviewActivity, basePhotoPreviewActivity.getResources().getString(R.string.cui), 0).show(this.f184197m.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                v().H.setClickable(true);
                return;
            } else {
                if (g16 != null) {
                    g16.a(1010);
                    g16.d();
                }
                ReportController.o(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
            }
        } else if (g16 != null && this.f184334e.selectedPhotoList.size() > 0) {
            i iVar2 = this.C;
            if (!iVar2.B && !iVar2.D && !iVar2.F && !intent2.getBooleanExtra(PeakConstants.SEND_NO_PRESEND, false) && ((h) this.f184335f).c(this.f184334e)) {
                g16.c(intent2);
            }
        }
        if (this.C.f184256o) {
            v().f184365h.setVisibility(4);
        }
        f.l(m16);
        if (this.C.F) {
            intent2.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
            intent2.putExtra(AppConstants.Key.SESSION_INFO, (SessionInfo) intent2.getParcelableExtra(AppConstants.Key.SESSION_INFO));
        }
        this.P.t(intent2);
        G(intent2, this.f184334e.containNetImage(), v().m());
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault
    public boolean K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.Q;
    }

    protected void T(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Rect rect = (Rect) intent.getParcelableExtra("KEY_THUMBNAL_BOUND");
        if (rect == null) {
            return;
        }
        int navigationBarHeight = SystemBarTintManager.getNavigationBarHeight(this.f184197m);
        rect.top -= navigationBarHeight;
        rect.bottom -= navigationBarHeight;
        v().mDragView.setOriginRect(rect);
    }

    public Intent V(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Intent) iPatchRedirector.redirect((short) 16, (Object) this, (Object) arrayList);
        }
        if (arrayList != null && arrayList.size() > 0) {
            Intent intent = this.f184197m.getIntent();
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP, this.C.f184325c);
            intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184335f).f184248f);
            return intent;
        }
        return null;
    }

    protected void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TextView textView = v().K;
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(ViewUtils.dip2px(16.5f), 0, 0, 0);
            textView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void a() {
        RichMediaBaseData richMediaBaseData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.a();
        this.P.j(this.f184197m, v(), this);
        RichMediaBrowserInfo item = v().getItem(v().i());
        boolean z16 = true;
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() != 101) {
            z16 = false;
        }
        Z();
        a0(z16);
        if (this.H && this.C.f184253l.size() != 0) {
            v().C.setVisibility(8);
        }
        if (this.M) {
            super.z(8);
            v().I.setVisibility(8);
            v().L.setVisibility(8);
        }
        if (t()) {
            T(this.f184197m.getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(boolean z16) {
        int i3 = 0;
        v().F.setVisibility(0);
        v().G.setVisibility(0);
        if (z16) {
            TextView textView = v().C;
            if (!this.Q) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (v().D.getVisibility() != 8) {
                v().D.setVisibility(8);
                v().E.setVisibility(8);
            }
        } else {
            v().C.setVisibility(0);
            if (!this.C.f184257p) {
                v().F.setVisibility(8);
                v().G.setVisibility(8);
            }
            if (!this.C.f184258q) {
                v().C.setVisibility(8);
            }
            i iVar = this.C;
            if (iVar.A && iVar.f184255n.size() == 0) {
                v().D.setVisibility(0);
                v().E.setVisibility(0);
                v().D.setOnCheckedChangeListener(v());
                v().E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewCustomizationAIO.this);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                        } else {
                            PhotoPreviewCustomizationAIO.this.v().D.toggle();
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                v().D.setContentDescription("\u95ea\u7167");
                v().E.setContentDescription("\u95ea\u7167");
            }
        }
        this.P.updateView();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184197m.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(R.layout.gzp, (ViewGroup) null);
        if (TokenResUtils.useTokenRes4()) {
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ccu);
            CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.h1y);
            if (checkBox != null && checkBox2 != null) {
                Drawable drawable = this.f184197m.getDrawable(R.drawable.qui_common_check_box_white_border);
                Drawable drawable2 = this.f184197m.getDrawable(R.drawable.qui_common_check_box_white_border);
                int f16 = BaseAIOUtils.f(20.0f, this.f184197m.getResources());
                drawable.setBounds(0, 0, f16, f16);
                drawable2.setBounds(0, 0, f16, f16);
                checkBox.setButtonDrawable((Drawable) null);
                checkBox2.setButtonDrawable((Drawable) null);
                checkBox.setCompoundDrawables(drawable, null, null, null);
                checkBox2.setCompoundDrawables(drawable2, null, null, null);
            }
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            super.doOnDestroy();
            this.f184197m = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.doOnPause();
        c cVar = this.P;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.g();
        c cVar = this.P;
        boolean A = A();
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        cVar.r(A, basePhotoPreviewActivity.selectedPhotoAdapter, basePhotoPreviewActivity.selectedPhotoListView, basePhotoPreviewActivity.selectedPhotoListDivider);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        BinderWarpper binderWarpper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        boolean z16 = true;
        this.C.f184258q = true;
        this.H = intent.getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false);
        this.I = intent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
        this.L = intent.getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
        this.M = intent.getBooleanExtra(PeakConstants.INPUT_CLICK_PREVIEW, false);
        super.j(intent);
        this.C.F = intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
        this.N = intent.getBooleanExtra(PeakConstants.SEND_FLAG, false);
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, false);
        this.P.q(booleanExtra);
        String stringExtra = intent.getStringExtra(PeakConstants.COMMENT_CONTENT);
        this.P.o(stringExtra);
        QLog.i("QQAlbum", 1, "initData isSupportCommentInPreview=" + booleanExtra + ",commentContent=" + stringExtra);
        if (this.N) {
            intent.removeExtra(PeakConstants.SEND_FLAG);
            PresendPicMgr g16 = PresendPicMgr.g(null);
            if (g16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
                }
                g16.a(1003);
            }
            PhotoUtils.sendPhoto(this.f184197m, intent, this.f184334e.selectedPhotoList, ((h) this.f184335f).f184248f, true);
        }
        if (!this.f184334e.isSingleMode && (binderWarpper = (BinderWarpper) intent.getParcelableExtra(PeakConstants.BINDER_PRESENDSERVICE)) != null) {
            if (PresendPicMgr.g(null) != null) {
                PresendPicMgr.g(null).l();
            }
            PresendPicMgr i3 = PresendPicMgr.i(e.a.j(binderWarpper.binder));
            this.G = 1037;
            String str = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
            if (this.f184337i.l(str) != 1) {
                i3.j(str, this.G);
            }
        }
        this.f184334e.customSendBtnText = this.f184197m.getResources().getString(R.string.cvd);
        if (this.L) {
            this.f184334e.customSendBtnText = this.f184197m.getResources().getString(R.string.ctx);
        }
        m.a();
        if (((h) this.f184335f).f184248f == 2) {
            this.J = true;
        }
        SendByFile g17 = new SendByFile().g(((h) this.f184335f).f184250i);
        if (this.I || this.C.F) {
            z16 = false;
        }
        this.K = g17.f(z16);
        this.Q = intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_ENABLED, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void k(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (v().getItem(i3).baseData.getType() == 101) {
            z16 = true;
        } else {
            z16 = false;
        }
        a0(z16);
        super.k(i3);
        this.P.u(i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void l(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        i iVar = this.C;
        iVar.B = z16;
        if (z16) {
            iVar.D = true;
            v().F.setChecked(!z16);
            if (this.f184334e.selectedPhotoList.isEmpty() && v().i() < this.C.f184324b.size()) {
                v().J.performClick();
                g();
            }
            if (v().i() != -1 && this.C.f184324b.size() > v().i()) {
                if (this.f184337i.l(this.C.f184324b.get(v().i())) != 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                i iVar2 = this.C;
                if (iVar2.C && this.f184197m.popup == null && z17) {
                    iVar2.C = false;
                    QMMKV.from(BaseApplicationImpl.getApplication(), "common_mmkv_configurations").encodeBool("showFlashPic" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false).commitAsync();
                    this.f184197m.popup = new BubblePopupWindow(-2, -2);
                    TextView textView = new TextView(this.f184197m);
                    int f16 = BaseAIOUtils.f(10.0f, this.f184197m.getResources());
                    textView.setPadding(f16, 0, f16, 0);
                    textView.setTextColor(-1);
                    textView.setText("\u9009\u4e2d\u7684\u56fe\u7247\u6bcf\u4eba\u53ea\u80fd\u67e5\u770b\u4e00\u6b21");
                    textView.setTextSize(14.0f);
                    this.f184197m.popup.setContentView(textView);
                    this.f184197m.popup.setFocusable(false);
                    this.f184197m.popup.showAsDropDown(v().E);
                }
            }
            int i3 = this.C.f184261t;
            if (i3 == 0) {
                ReportController.o(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
            } else if (i3 == 3000) {
                ReportController.o(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
            } else if (i3 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
            }
        } else {
            BubblePopupWindow bubblePopupWindow = this.f184197m.popup;
            if (bubblePopupWindow != null) {
                bubblePopupWindow.dismiss();
            }
        }
        this.P.updateView();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.f184334e.selectedIndex.isEmpty()) {
            this.P.f();
        }
        BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
        if (basePhotoPreviewActivity != null) {
            basePhotoPreviewActivity.getIntent().putExtra(PeakConstants.COMMENT_CONTENT, this.P.h());
        }
        super.onBackPressed();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        this.f184197m.getResources();
        int i3 = v().i();
        if (this.f184334e.selectedIndex.contains(Integer.valueOf(i3))) {
            X(i3);
        } else {
            W(i3);
        }
        LpReportInfo_pf00064.allReport(603, 2);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void q(CompoundButton compoundButton, boolean z16) {
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, compoundButton, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            v().D.setChecked(false);
            if (this.f184334e.selectedPhotoList.isEmpty() && v().i() < this.C.f184324b.size()) {
                v().J.performClick();
                g();
            }
            SendByFile sendByFile = this.K;
            if (sendByFile != null) {
                if (!this.J) {
                    BasePhotoPreviewActivity basePhotoPreviewActivity = this.f184197m;
                    PhotoCommonBaseData<O> photoCommonBaseData = this.f184334e;
                    sendByFile.d(basePhotoPreviewActivity, photoCommonBaseData.selectedPhotoList, z16, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap);
                } else {
                    this.J = false;
                }
            }
            ((h) this.f184335f).f184248f = 2;
            v().F.setChecked(true);
            g();
            Intent intent = this.f184197m.getIntent();
            if (intent != null && intent.hasExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME) && (stringExtra = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_RAWCHECKBOX_REPORT_ACTION_NAME)) != null) {
                ReportController.o(null, "CliOper", "", "", stringExtra, stringExtra, 0, 0, "", "", "", "");
            }
        } else {
            ((h) this.f184335f).f184248f = 0;
            M();
        }
        this.P.updateView();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.e
    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.f184197m.getIntent().getBooleanExtra("PHOTO_PREVIEW_NEED_DRAG_KEY", false);
    }
}

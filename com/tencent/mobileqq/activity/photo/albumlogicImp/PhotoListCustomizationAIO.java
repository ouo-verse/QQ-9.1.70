package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.g;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.j;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.activity.richmedia.f;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class PhotoListCustomizationAIO extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String T;
    boolean F;
    boolean G;
    boolean H;
    protected boolean I;
    private SendByFile J;
    boolean K;
    public boolean L;
    public HashSet<String> M;
    public HashSet<String> N;
    public SessionInfo P;
    boolean Q;
    public String R;
    private boolean S;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            T = PhotoListCustomizationAIO.class.getName();
        }
    }

    public PhotoListCustomizationAIO(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
            return;
        }
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.L = false;
        this.M = new HashSet<>();
        this.N = new HashSet<>();
        this.P = null;
        this.Q = false;
        this.R = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L0() {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.f237737hv), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(this.D.getIntent());
        intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 5);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, T);
        intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, true);
        h hVar = (h) this.f184311f;
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(this.D, intent, hVar.a(photoCommonBaseData, photoCommonBaseData.selectedPhotoList.get(0)));
        TextView textView = this.D.magicStickBtn;
        if (textView != null) {
            textView.setClickable(false);
        }
    }

    private void O0() {
        BasePhotoListActivity basePhotoListActivity;
        if (SimpleUIUtil.isNowElderMode() && (basePhotoListActivity = this.D) != null && this.f184313i != null) {
            int f16 = BaseAIOUtils.f(11.0f, basePhotoListActivity.getResources());
            P0(this.D.magicStickBtn, 18, f16);
            P0(this.D.qualityCountTv, 18, f16);
            P0(this.D.qualityTv, 18, f16);
            P0(this.D.previewTv, 18, f16);
            this.D.qualityCheckBox.setPadding(0, f16, 0, f16);
            float f17 = 18;
            this.f184313i.K.setTextSize(2, f17);
            ViewGroup.LayoutParams layoutParams = this.f184313i.K.getLayoutParams();
            layoutParams.height = BaseAIOUtils.f(44.0f, this.D.getResources());
            this.f184313i.K.setLayoutParams(layoutParams);
            this.f184313i.M.setTextSize(2, f17);
        }
    }

    private void P0(TextView textView, int i3, int i16) {
        if (textView == null) {
            return;
        }
        textView.setTextSize(2, i3);
        textView.setPadding(0, i16, 0, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    protected void B0(Intent intent, boolean z16, ArrayList<String> arrayList) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        Pair<ArrayList<String>, ArrayList<String>> pair = new Pair<>(new ArrayList(), new ArrayList());
        SendByFile sendByFile = this.J;
        if (sendByFile != null) {
            if (((h) this.f184311f).f184248f == 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            pair = sendByFile.b(arrayList, z18, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap);
            intent.putStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE, pair.second);
        } else {
            pair.first.addAll(arrayList);
        }
        ArrayList<String> arrayList2 = pair.first;
        int typeforReportSpcialDiscuss = PhotoUtils.getTypeforReportSpcialDiscuss(this.P);
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < arrayList2.size(); i18++) {
            String str = arrayList2.get(i18);
            if (!ImageManager.isNetworkUrl(str)) {
                if (((h) this.f184311f).b(this.f184310e, str) == 1) {
                    LocalMediaInfo a16 = ((h) this.f184311f).a(this.f184310e, str);
                    if (a16 != null) {
                        SendVideoInfo sendVideoInfo = new SendVideoInfo();
                        sendVideoInfo.fileSize = a16.fileSize;
                        sendVideoInfo.duration = a16.mDuration;
                        hashMap.put(Integer.valueOf(i17), sendVideoInfo);
                        i16++;
                    }
                } else {
                    i3++;
                }
                i17++;
            }
        }
        String valueOf = String.valueOf(i3);
        String valueOf2 = String.valueOf(i16);
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
            z17 = true;
        } else {
            z17 = false;
        }
        if (com.tencent.mobileqq.shortvideo.h.f287891c != 0 && System.currentTimeMillis() - com.tencent.mobileqq.shortvideo.h.f287891c < MiniBoxNoticeInfo.MIN_5) {
            z19 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "upload video isConfirmed=" + z19 + " allowUploadInXGTime=" + com.tencent.mobileqq.shortvideo.h.f287891c);
        }
        if (NetworkUtil.isMobileNetWork(BaseApplication.getContext()) && !z19 && z17) {
            DialogUtil.createCustomDialog(this.D, 232, null, this.D.getResources().getString(R.string.f173101he2), new DialogInterface.OnClickListener(new Runnable(z16, intent, arrayList2, typeforReportSpcialDiscuss, valueOf, valueOf2) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f184377d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Intent f184378e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ArrayList f184379f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f184380h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f184381i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f184382m;

                {
                    this.f184377d = z16;
                    this.f184378e = intent;
                    this.f184379f = arrayList2;
                    this.f184380h = typeforReportSpcialDiscuss;
                    this.f184381i = valueOf;
                    this.f184382m = valueOf2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PhotoListCustomizationAIO.this, Boolean.valueOf(z16), intent, arrayList2, Integer.valueOf(typeforReportSpcialDiscuss), valueOf, valueOf2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!this.f184377d) {
                        BasePhotoListActivity basePhotoListActivity = ((PhotoListCustomizationDefault) PhotoListCustomizationAIO.this).D;
                        Intent intent2 = this.f184378e;
                        ArrayList arrayList3 = this.f184379f;
                        PhotoListCustomizationAIO photoListCustomizationAIO = PhotoListCustomizationAIO.this;
                        PhotoUtils.sendPhoto(basePhotoListActivity, intent2, arrayList3, ((h) photoListCustomizationAIO.f184311f).f184248f, ((PhotoListCustomizationDefault) photoListCustomizationAIO).C.f184241v);
                    } else {
                        ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(((PhotoListCustomizationDefault) PhotoListCustomizationAIO.this).D, this.f184378e, this.f184379f, ((PhotoListCustomizationDefault) PhotoListCustomizationAIO.this).C.f184242w, ((h) PhotoListCustomizationAIO.this.f184311f).f184248f, false);
                    }
                    ReportController.o(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.f184380h, 0, this.f184381i, this.f184382m, "", "");
                    com.tencent.mobileqq.shortvideo.h.f287891c = System.currentTimeMillis();
                }
            }) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Runnable f184383d;

                {
                    this.f184383d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationAIO.this, (Object) r5);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i19) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i19);
                    } else {
                        this.f184383d.run();
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationAIO.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i19) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i19);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("QQAlbum", 2, "cancel shortvideo_mobile_send_confirm dialog");
                    }
                    Button button = PhotoListCustomizationAIO.this.f184313i.K;
                    if (button != null) {
                        button.setClickable(true);
                    }
                }
            }).show();
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
                return;
            }
            return;
        }
        if (z16) {
            ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(this.D, intent, arrayList2, this.C.f184242w, ((h) this.f184311f).f184248f, false);
        } else {
            PhotoUtils.sendPhoto(this.D, intent, arrayList2, ((h) this.f184311f).f184248f, this.C.f184241v);
        }
        ReportController.o(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", typeforReportSpcialDiscuss, 0, valueOf, valueOf2, "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Intent intent = this.D.getIntent();
        if (!TextUtils.isEmpty(this.R)) {
            intent.putExtra(PeakConstants.SEND_COMMENT_CONTENT, this.R);
        }
        if (this.F) {
            O o16 = this.f184311f;
            if (((h) o16).f184251m != null && ((h) o16).f184251m.size() > 0) {
                if (this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
                    StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
                } else if (!this.f184310e.albumName.equalsIgnoreCase("Camera") && !this.f184310e.albumName.equalsIgnoreCase("camera") && !this.f184310e.albumName.contains("Camera") && !this.f184310e.albumName.contains("camera")) {
                    StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
                } else {
                    StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
                }
                B0(intent, true, this.f184310e.selectedPhotoList);
                return;
            }
        }
        if (this.I) {
            this.D.setResult(-1, N0());
            I();
            return;
        }
        PresendPicMgr f16 = PresendPicMgr.f();
        if (((h) this.f184311f).f184248f == 2) {
            if (f16 != null) {
                f16.a(1008);
                f16.d();
            }
            ReportController.o(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
        } else if (f16 != null && !this.L && !intent.getBooleanExtra(PeakConstants.SEND_NO_PRESEND, false) && ((h) this.f184311f).c(this.f184310e)) {
            f16.c(intent);
        }
        if (this.f184310e.selectedPhotoList != null) {
            m.n(this.D.getIntent(), this.f184310e.selectedPhotoList.size());
            m.i(this.D.getIntent(), this.f184310e.selectedPhotoList.size(), ((h) this.f184311f).f184248f);
            f.l(this.f184310e.selectedPhotoList);
        }
        super.C0();
        S0(intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        PresendPicMgr f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.P = (SessionInfo) intent.getParcelableExtra(AppConstants.Key.SESSION_INFO);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQAlbum", 2, "submit", e16);
            }
        }
        boolean z16 = false;
        this.G = intent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
        super.E(intent);
        this.L = intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.SEND_FLAG, false);
        this.K = booleanExtra;
        if (booleanExtra) {
            intent.removeExtra(PeakConstants.SEND_FLAG);
            PresendPicMgr f17 = PresendPicMgr.f();
            if (f17 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
                }
                f17.a(1004);
            }
            PhotoUtils.sendPhoto(this.D, intent, this.f184310e.selectedPhotoList, ((h) this.f184311f).f184248f, true);
        }
        g gVar = this.C;
        gVar.f184293d = true;
        this.f184310e.isSingleMode = false;
        gVar.A = true;
        gVar.f184244y = intent.getBooleanExtra(PeakConstants.ALBUM_SHOW_ORI_BUTTON, true);
        MediaFileFilter mediaFileFilter = this.f184310e.filter;
        mediaFileFilter.needWebp = true;
        mediaFileFilter.needHeif = true;
        this.F = intent.getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false);
        this.I = intent.getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
        this.Q = intent.getBooleanExtra(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, false);
        this.R = intent.getStringExtra(PeakConstants.COMMENT_CONTENT);
        this.f184310e.customSendBtnText = this.D.getResources().getString(R.string.cvd);
        if (this.I) {
            this.f184310e.customSendBtnText = this.D.getResources().getString(R.string.ctx);
        }
        if (((h) this.f184311f).f184248f == 2) {
            this.H = true;
        }
        intent.getIntExtra("uintype", -1);
        SendByFile g16 = new SendByFile().g(((h) this.f184311f).f184250i);
        if (!this.G && !this.L) {
            z16 = true;
        }
        this.J = g16.f(z16);
        if (((BinderWarpper) intent.getParcelableExtra(PeakConstants.BINDER_PRESENDSERVICE)) == null && (f16 = PresendPicMgr.f()) != null) {
            f16.l();
        }
        QLog.i(T, 1, "initData cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public boolean E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_NEW_VIDEO_EDIT);
        this.S = !expEntity.isContrast();
        ABTestUtil.log("PEAK->EXP_QQ_NEW_VIDEO_EDIT:" + expEntity.toStr());
        return this.S;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.F();
        O0();
        QLog.i(T, 1, "initUI cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && (i3 == 10017 || i3 == 10018)) {
            if (i3 != 10017) {
                if (i3 == 10018) {
                    Q0(intent);
                    return;
                }
                return;
            } else {
                this.D.setResult(-1, M0(intent));
                this.D.finish();
                return;
            }
        }
        super.G(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        boolean z16;
        int i16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), checkBox);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "current select count:" + arrayList.size());
        }
        View findViewById = ((View) view.getParent()).findViewById(R.id.fui);
        int i19 = m06.selectStatus;
        if (i19 != 1 && arrayList.size() >= this.f184310e.maxSelectNum) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", i16, 0, "", "", "", "");
        if (z16) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C.f184299j >= 1000) {
                QQToast.makeText(this.D, Y(m06), 0).show();
                checkBox.setChecked(false);
                this.C.f184299j = currentTimeMillis;
                R0();
            }
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        if (this.I && m06.fileSize > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
            QQToast.makeText(this.D, R.string.f174412vs, 0).show();
            checkBox.setChecked(false);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        if (i19 != 1) {
            i17 = 1;
        }
        m06.selectStatus = i17;
        if (i17 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            s0(m06);
        } else {
            t0(m06);
        }
        if (findViewById != null) {
            if (!z17) {
                i18 = 8;
            }
            findViewById.setVisibility(i18);
        }
        this.f184313i.u(i3, z17);
        this.f184313i.t(!z17);
        T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void K(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.K(z16, i3, i16);
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            Iterator<String> it = this.M.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (((h) this.f184311f).b(this.f184310e, next) != 1) {
                    f16.j(next, 1052);
                }
            }
            Iterator<String> it5 = this.N.iterator();
            while (it5.hasNext()) {
                f16.b(it5.next(), 1013);
            }
        }
        this.M.clear();
        this.N.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void L(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
            return;
        }
        super.L(view);
        ReportController.o(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.f184310e.selectedPhotoList.size() + "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void M(CompoundButton compoundButton, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, compoundButton, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            if (this.J != null) {
                if (!this.H) {
                    if (K0()) {
                        SendByFile sendByFile = this.J;
                        BasePhotoListActivity basePhotoListActivity = this.D;
                        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                        sendByFile.d(basePhotoListActivity, photoCommonBaseData.selectedPhotoList, z16, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap);
                    }
                } else {
                    this.H = false;
                }
            }
            ((h) this.f184311f).f184248f = 2;
            this.D.qualityCheckBox.setChecked(true);
            this.D.qualityCountTv.setVisibility(0);
            F0();
        } else {
            ((h) this.f184311f).f184248f = 0;
            this.D.qualityCheckBox.setChecked(false);
            this.D.qualityCountTv.setVisibility(4);
        }
        if (!this.C.f184245z) {
            this.D.qualityCountTv.setVisibility(8);
        }
    }

    public Intent M0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Intent) iPatchRedirector.redirect((short) 25, (Object) this, (Object) intent);
        }
        HashMap hashMap = (HashMap) intent.getSerializableExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP);
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                if (this.f184310e.selectedPhotoList.contains(str)) {
                    int indexOf = this.f184310e.selectedPhotoList.indexOf(str);
                    this.f184310e.selectedPhotoList.add(indexOf, (String) entry.getValue());
                    this.f184310e.selectedPhotoList.remove(indexOf + 1);
                }
            }
        }
        Intent intent2 = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f184310e.selectedPhotoList.size() > 0) {
            arrayList.addAll(this.f184310e.selectedPhotoList);
        } else {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                arrayList.addAll(stringArrayListExtra);
            }
        }
        intent2.putStringArrayListExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT, arrayList);
        intent2.putExtra(PeakConstants.SEND_SIZE_SPEC, ((h) this.f184311f).f184248f);
        return intent2;
    }

    public Intent N0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Intent) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(this.f184310e.selectedPhotoList);
        intent.putStringArrayListExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT, arrayList);
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, ((h) this.f184311f).f184248f);
        return intent;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
            return;
        }
        SessionInfo sessionInfo = this.P;
        if (sessionInfo != null) {
            ReportController.o(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X800A916", "0X800A916", PhotoUtils.getTypeforReport2(sessionInfo), 0, "", "", "", "");
        }
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            f16.a(1006);
        }
        Intent intent = this.D.getIntent();
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        m.e(intent, i3);
        super.P(view);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public List<LocalMediaInfo> Q(Object... objArr) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this, (Object) objArr);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<LocalMediaInfo> Q = super.Q(objArr);
        MediaQueryHelper mediaQueryHelper = this.f184310e.getMediaQueryHelper();
        if (mediaQueryHelper != null) {
            mediaQueryHelper.upDateCount();
            int i3 = mediaQueryHelper.cursorsCount;
            if (i3 >= 1000) {
                HashMap<String, String> hashMap = new HashMap<>();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (this.f184310e.albumName == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z17 = z16;
                if (z17) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("isRecent", str);
                hashMap.put("duration", "" + currentTimeMillis2);
                hashMap.put("mediaQuantity", "" + i3);
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, StatisticCollector.ALBUM_QUERY_MEDIA, z17, currentTimeMillis2, (long) i3, hashMap, null);
            }
        }
        return Q;
    }

    public void Q0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) intent);
            return;
        }
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(stringExtra2, stringExtra);
            j.j(this.D, this.C.N, hashMap);
            ((h) this.f184311f).f184248f = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
            int indexOf = this.f184310e.selectedPhotoList.indexOf(stringExtra2);
            if (indexOf >= 0) {
                this.f184310e.selectedPhotoList.add(indexOf, stringExtra);
                this.f184310e.selectedPhotoList.remove(indexOf + 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else if (this.I) {
            this.D.startActivityForResult(intent, 10017);
        } else {
            super.R(intent);
        }
    }

    public void R0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else if (this.L) {
            ReportController.o(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
    }

    public void S0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) intent);
        } else if (this.L) {
            intent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
            intent.putExtra(AppConstants.Key.SESSION_INFO, (SessionInfo) this.D.getIntent().getParcelableExtra(AppConstants.Key.SESSION_INFO));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.T();
        if (this.f184310e.selectedPhotoList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            O o16 = this.f184311f;
            if (((h) o16).f184251m != null && ((h) o16).f184251m.size() > 0 && this.f184310e.selectedPhotoList.size() == ((h) this.f184311f).f184251m.size()) {
                this.D.magicStickBtn.setEnabled(false);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.R)) {
            this.D.getIntent().putExtra(PeakConstants.COMMENT_CONTENT, "");
            this.R = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public void X(boolean z16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), intent);
            return;
        }
        intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 2);
        intent.putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, this.I);
        intent.putExtra(PeakConstants.IS_SUPPORT_COMMENT_IN_PREVIEW, this.Q);
        intent.putExtra(PeakConstants.COMMENT_CONTENT, this.R);
        super.X(z16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public String Y(LocalMediaInfo localMediaInfo) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) localMediaInfo);
        }
        int i16 = this.f184310e.maxSelectNum;
        Resources resources = this.D.getResources();
        if (this.I) {
            i3 = R.string.w2l;
        } else {
            i3 = R.string.cu_;
        }
        return resources.getString(i3, Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, localMediaInfo, Boolean.valueOf(z16))).booleanValue();
        }
        boolean a16 = super.a(localMediaInfo, z16);
        if (a16) {
            if (z16) {
                String str = localMediaInfo.path;
                if (this.J != null && K0()) {
                    SendByFile sendByFile = this.J;
                    BasePhotoListActivity basePhotoListActivity = this.D;
                    String str2 = localMediaInfo.path;
                    if (((h) this.f184311f).f184248f == 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                    sendByFile.c(basePhotoListActivity, str2, z17, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap, true);
                }
                if (this.N.contains(str)) {
                    this.N.remove(str);
                }
                this.M.add(str);
            } else if (this.M.contains(localMediaInfo.path)) {
                this.M.remove(localMediaInfo.path);
            } else {
                this.N.add(localMediaInfo.path);
            }
        } else {
            R0();
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, i3);
        }
        Intent intent = this.D.getIntent();
        intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 3);
        intent.putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, this.I);
        ReportController.o(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.f184310e.selectedPhotoList.size() + "", "", "", "");
        int i16 = 1;
        if (this.f184313i.Q.m0(i3).selectStatus != 1) {
            if (this.f184310e.selectedPhotoList.size() >= this.f184310e.maxSelectNum) {
                i16 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i16, 0, "", "", "", "");
        }
        return super.k(view, i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void n0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) intent);
        } else {
            super.n0(intent);
            intent.putExtra(PeakConstants.SEND_PHOTO_ACTIVITY_FROM, PeakConstants.SEND_PHOTO_ACTIVITY_FROM_AIO_PHOTO_LIST);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
            return;
        }
        int i16 = 1;
        if (this.f184313i.Q.m0(i3).selectStatus != 1) {
            if (this.f184310e.selectedPhotoList.size() >= this.f184310e.maxSelectNum) {
                i16 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i16, 0, "", "", "", "");
        }
        super.p(view, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void p0(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent);
        } else if (this.I) {
            this.D.startActivityForResult(intent, 10018);
        } else {
            super.p0(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void s0(LocalMediaInfo localMediaInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) localMediaInfo);
            return;
        }
        String str = localMediaInfo.path;
        MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (this.J != null && K0()) {
            SendByFile sendByFile = this.J;
            BasePhotoListActivity basePhotoListActivity = this.D;
            if (((h) this.f184311f).f184248f == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            sendByFile.c(basePhotoListActivity, str, z16, photoCommonBaseData.selectedMediaInfoHashMap, photoCommonBaseData.allMediaInfoHashMap, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onCheckBoxSelected:path:" + str + ",mMimeType:" + localMediaInfo.mMimeType);
        }
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null && QAlbumUtil.getMediaType(localMediaInfo) == 0) {
            f16.k(str, 1052, this.D.getIntent().getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0));
        }
        super.s0(localMediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void t0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) localMediaInfo);
            return;
        }
        String str = localMediaInfo.path;
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            f16.b(str, 1013);
        }
        super.t0(localMediaInfo);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void u(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
            return;
        }
        SessionInfo sessionInfo = this.P;
        if (sessionInfo != null) {
            ReportController.o(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X800A915", "0X800A915", PhotoUtils.getTypeforReport2(sessionInfo), 0, "", "", "", "");
        }
        super.u(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void w0(View view, Bundle bundle, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, view, bundle, Integer.valueOf(i3), intent);
            return;
        }
        if (this.f184310e.selectedPhotoList.size() <= 0) {
            return;
        }
        if (this.D.isInMultiWindow()) {
            QQToast.makeText(this.D, R.string.lwl, 0).show();
            return;
        }
        h hVar = (h) this.f184311f;
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (hVar.b(photoCommonBaseData, photoCommonBaseData.selectedPhotoList.get(0)) != 1) {
            z16 = false;
        }
        if (z16) {
            L0();
        } else {
            S0(this.D.getIntent());
            super.w0(view, bundle, i3, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void x0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) localMediaInfo);
            return;
        }
        m.c(this.D.getIntent(), "param_totalSelNum");
        Intent intent = this.D.getIntent();
        if (!intent.hasExtra(QAlbumConstants.PARAM_INITTIME)) {
            intent.putExtra(QAlbumConstants.PARAM_INITTIME, System.currentTimeMillis());
        }
        super.x0(localMediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void y0(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) localMediaInfo);
        } else {
            super.y0(localMediaInfo);
            m.c(this.D.getIntent(), "param_cancelSelNum");
        }
    }
}

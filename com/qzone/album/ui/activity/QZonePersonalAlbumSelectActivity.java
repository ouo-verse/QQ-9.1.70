package com.qzone.album.ui.activity;

import NS_MOBILE_FEEDS.cnst.strKeyApplistPhotoScene;
import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity;
import com.qzone.album.business.photolist.adapter.aa;
import com.qzone.album.business.photolist.adapter.x;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.ui.widget.QzoneSwipPullRefreshListView;
import com.qzone.album.ui.widget.c;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.CustomListViewFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.activity.QZonePublishMoodTabActivity;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import com.tencent.widget.ListView;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneTopGestureLayout;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes39.dex */
public class QZonePersonalAlbumSelectActivity extends CustomListViewFragmentV2 implements com.qzone.album.env.common.c, x.e {
    private GridView L0;
    private aa M0;
    private HorizontalScrollView N0;
    private TextView O0;
    private RelativeLayout P0;
    protected TextView Q0;
    private int R0;
    private String S0;
    private String T0;
    private boolean U0;
    private boolean V0;
    private int W0;
    private String X0;
    private HashMap<String, PicInfo> Y0;

    /* renamed from: h1, reason: collision with root package name */
    private String f44056h1;

    /* renamed from: k1, reason: collision with root package name */
    HashMap<String, LocalMediaInfo> f44059k1;

    /* renamed from: l1, reason: collision with root package name */
    public com.qzone.album.ui.widget.c f44060l1;

    /* renamed from: m1, reason: collision with root package name */
    private FrameLayout f44061m1;

    /* renamed from: n1, reason: collision with root package name */
    private String f44062n1;

    /* renamed from: o1, reason: collision with root package name */
    Intent f44063o1;

    /* renamed from: p1, reason: collision with root package name */
    int f44064p1;

    /* renamed from: u1, reason: collision with root package name */
    private ProgressDialog f44069u1;

    /* renamed from: v1, reason: collision with root package name */
    private o f44070v1;

    /* renamed from: w0, reason: collision with root package name */
    private List<BusinessAlbumInfo> f44071w0;

    /* renamed from: x0, reason: collision with root package name */
    private com.qzone.album.base.Service.c f44073x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f44074y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f44075z0 = 0;
    public int A0 = -1;
    protected Dialog B0 = null;
    protected TextView C0 = null;
    boolean D0 = false;
    boolean E0 = false;
    boolean F0 = false;
    private boolean G0 = false;
    public boolean H0 = false;
    public ArrayList<NetImageInfo> I0 = new ArrayList<>();
    public ArrayList<String> J0 = new ArrayList<>();
    private HashMap<String, Integer> K0 = new HashMap<>();
    private String Z0 = "";

    /* renamed from: a1, reason: collision with root package name */
    private boolean f44049a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    private String f44050b1 = null;

    /* renamed from: c1, reason: collision with root package name */
    private String f44051c1 = null;

    /* renamed from: d1, reason: collision with root package name */
    private String f44052d1 = null;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f44053e1 = false;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f44054f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    private boolean f44055g1 = false;

    /* renamed from: i1, reason: collision with root package name */
    protected int f44057i1 = 0;

    /* renamed from: j1, reason: collision with root package name */
    protected boolean f44058j1 = false;

    /* renamed from: q1, reason: collision with root package name */
    private x.g f44065q1 = new k();

    /* renamed from: r1, reason: collision with root package name */
    private x.f f44066r1 = new l();

    /* renamed from: s1, reason: collision with root package name */
    private Handler f44067s1 = new a(Looper.getMainLooper());

    /* renamed from: t1, reason: collision with root package name */
    private ConcurrentHashMap<Long, Boolean> f44068t1 = new ConcurrentHashMap<>();

    /* renamed from: w1, reason: collision with root package name */
    private final Handler f44072w1 = new f();

    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QZonePersonalAlbumSelectActivity.this.N0.scrollTo(QZonePersonalAlbumSelectActivity.this.L0.getLayoutParams().width, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f44084d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f44085e;

        b(BusinessAlbumInfo businessAlbumInfo, String str) {
            this.f44084d = businessAlbumInfo;
            this.f44085e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO, this.f44084d);
            bundle.putString("albumid", this.f44085e);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            QZonePersonalAlbumSelectActivity.this.setResult(-1, intent);
            QZonePersonalAlbumSelectActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessAlbumInfo f44089d;

        e(BusinessAlbumInfo businessAlbumInfo) {
            this.f44089d = businessAlbumInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            OutSiteShareService.a().c(QZonePersonalAlbumSelectActivity.this.f44072w1, 4, -1, null, this.f44089d.mAlbumId, null, null);
            QZonePersonalAlbumSelectActivity qZonePersonalAlbumSelectActivity = QZonePersonalAlbumSelectActivity.this;
            qZonePersonalAlbumSelectActivity.f44069u1 = DialogUtil.showProgressDialog(qZonePersonalAlbumSelectActivity.getActivity(), R.string.an9);
            QZonePersonalAlbumSelectActivity.this.f44069u1.setCanceledOnTouchOutside(false);
            QZonePersonalAlbumSelectActivity.this.f44069u1.show();
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes39.dex */
    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (QZonePersonalAlbumSelectActivity.this.f44069u1 != null && QZonePersonalAlbumSelectActivity.this.f44069u1.isShowing()) {
                QZonePersonalAlbumSelectActivity.this.f44069u1.dismiss();
            }
            QZoneResult unpack = QZoneResult.unpack(message);
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25");
            if (unpack != null && unpack.getSucceed()) {
                String string = unpack.getBundle().getString("url");
                Intent intent = new Intent();
                intent.putExtra("url", string);
                intent.setAction("send_album_url_to_device");
                QZonePersonalAlbumSelectActivity.this.sendBroadcast(intent);
                return;
            }
            ToastUtil.s(config, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePersonalAlbumSelectActivity.this.Aj();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class l implements x.f {
        l() {
        }

        @Override // com.qzone.album.business.photolist.adapter.x.f
        public void a(int i3) {
            if (((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45060j0 == null || ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45059i0 == null || i3 < 0 || i3 >= ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45059i0.getCount()) {
                return;
            }
            if (QZonePersonalAlbumSelectActivity.this.f44049a1 && i3 == 0) {
                QZonePersonalAlbumSelectActivity.this.Ej();
                LpReportInfo_pf00064.allReport(602, 11, 3);
                return;
            }
            Object item = ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45059i0.getItem(i3);
            if (item == null || !(item instanceof BusinessAlbumInfo)) {
                return;
            }
            BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) item;
            if ("from_device_lightapp".equals(QZonePersonalAlbumSelectActivity.this.S0)) {
                QZonePersonalAlbumSelectActivity.this.ik(businessAlbumInfo);
                return;
            }
            if (businessAlbumInfo.mAlbumType != 21) {
                if (QZonePersonalAlbumSelectActivity.this.Xj()) {
                    QZonePersonalAlbumSelectActivity.this.zj(businessAlbumInfo);
                    LpReportInfo_pf00064.allReport(602, 11, 2);
                    return;
                }
                BusinessAlbumInfo businessAlbumInfo2 = new BusinessAlbumInfo(QZonePersonalAlbumSelectActivity.this.X0);
                businessAlbumInfo2.copyFrom(businessAlbumInfo);
                businessAlbumInfo2.mUin = LoginData.getInstance().getUin();
                Intent I = ak.I(QZonePersonalAlbumSelectActivity.this.getActivity(), businessAlbumInfo2, QZonePersonalAlbumSelectActivity.this.f44075z0);
                I.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME));
                I.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME));
                I.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"));
                I.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                I.putExtra("PhotoConst.PLUGIN_NAME", QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra("PhotoConst.PLUGIN_NAME"));
                I.putExtra("PhotoConst.PLUGIN_APK", QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra("PhotoConst.PLUGIN_APK"));
                I.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", QZonePersonalAlbumSelectActivity.this.getIntent().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false));
                I.putExtra(PeakConstants.IS_FROM_XIAOWO, QZonePersonalAlbumSelectActivity.this.f44056h1);
                if (QZonePersonalAlbumSelectActivity.this.Uj()) {
                    ParcelableWrapper.putArrayListToIntent(I, QZoneContant.INPUT_IMAGES, QZonePersonalAlbumSelectActivity.this.I0);
                    I.putExtra("PeakConstants.selectedMediaInfoHashMap", QZonePersonalAlbumSelectActivity.this.f44059k1);
                    I.putExtra("_input_max", QZonePersonalAlbumSelectActivity.this.A0);
                    I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, QZonePersonalAlbumSelectActivity.this.D0);
                    I.putExtra(QZoneContant.QQ_SELECT_COUNT, QZonePersonalAlbumSelectActivity.this.W0);
                    I.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, QZonePersonalAlbumSelectActivity.this.U0);
                    I.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", QZonePersonalAlbumSelectActivity.this.J0);
                    I.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, QZonePersonalAlbumSelectActivity.this.getIntent().getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false));
                    I.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, QZonePersonalAlbumSelectActivity.this.getIntent().getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0));
                    I.putExtra(PeakConstants.KEY_SHOW_TYPE, QZonePersonalAlbumSelectActivity.this.f44064p1);
                    I.putExtra(PeakConstants.FROM_QZONE, QZonePersonalAlbumSelectActivity.this.getIntent().getBooleanExtra(PeakConstants.FROM_QZONE, false));
                }
                QZonePersonalAlbumSelectActivity qZonePersonalAlbumSelectActivity = QZonePersonalAlbumSelectActivity.this;
                if (qZonePersonalAlbumSelectActivity.F0) {
                    I.putExtra("uin", qZonePersonalAlbumSelectActivity.getIntent().getStringExtra("uin"));
                    I.putExtra("uintype", QZonePersonalAlbumSelectActivity.this.getIntent().getIntExtra("uintype", 0));
                    I.putExtra("troop_uin", QZonePersonalAlbumSelectActivity.this.getIntent().getStringExtra("troop_uin"));
                    I.putExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, QZonePersonalAlbumSelectActivity.this.f44058j1);
                    I.putExtra("PeakConstants.selectedMediaInfoHashMap", QZonePersonalAlbumSelectActivity.this.f44059k1);
                    I.putExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT, QZonePersonalAlbumSelectActivity.this.getIntent());
                    LpReportInfo_pf00064.allReport(96, 2, 2);
                }
                if (QZonePersonalAlbumSelectActivity.this.E0) {
                    I.putExtra(PeakConstants.IS_FROM_P2V, true);
                }
                PerfTracer.traceStart(PerfTracer.QZONEALBUM_SHOW);
                QZonePersonalAlbumSelectActivity.this.startActivityForResult(I, 24);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m implements AdapterView.OnItemClickListener {
        m() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof NetImageInfo)) {
                return;
            }
            NetImageInfo netImageInfo = (NetImageInfo) tag;
            if (QZonePersonalAlbumSelectActivity.this.Vj(netImageInfo)) {
                QZonePersonalAlbumSelectActivity.this.bk(netImageInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePersonalAlbumSelectActivity qZonePersonalAlbumSelectActivity = QZonePersonalAlbumSelectActivity.this;
            if (!qZonePersonalAlbumSelectActivity.D0) {
                qZonePersonalAlbumSelectActivity.dk();
            } else {
                qZonePersonalAlbumSelectActivity.Fj();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    private final class o extends BroadcastReceiver {

        /* loaded from: classes39.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QZonePersonalAlbumSelectActivity.this.setResult(-1);
                QZonePersonalAlbumSelectActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("receive_share_alum_success".equals(intent.getAction())) {
                DialogUtil.createContentOnlyDialog(QZonePersonalAlbumSelectActivity.this.getActivity(), QZonePersonalAlbumSelectActivity.this.getResources().getString(R.string.an8), 0, R.string.f170834an4, null, new a()).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj() {
        Intent intent = this.f44063o1;
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        if (this.I0.size() > 0) {
            arrayList = new ArrayList<>();
            arrayList.addAll(this.I0);
        }
        if (this.J0 == null) {
            this.J0 = new ArrayList<>();
        }
        HashMap<String, PicInfo> hashMap = new HashMap<>();
        Ij(arrayList, this.J0, hashMap, null);
        intent.putExtra(PeakConstants.PHOTO_INFOS, hashMap);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.J0);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.f44057i1);
        intent.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
        intent.putExtra(PeakConstants.MY_UIN, LoginData.getInstance().getUin());
        intent.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, com.qzone.album.util.a.d(this.I0));
        intent.putExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, this.f44058j1);
        intent.putExtra("FROM_QZONR_NO_FINISH", true);
        intent.setClass(BaseApplication.getContext(), NewPhotoListActivity.class);
        intent.setFlags(603979776);
        startActivity(intent);
        finish();
        QAlbumUtil.anim(getActivity(), true, false);
    }

    private boolean Cj() {
        if (this.A0 <= 0 || this.I0.size() + this.W0 < this.A0) {
            return true;
        }
        toast(String.format(getString(R.string.gr5), Integer.valueOf(this.A0)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        Intent o16 = ak.o(getActivity(), QZonePersonalAlbumActivity.Q2());
        o16.putExtra("suggestedNewAlbumName", getIntent().getStringExtra("suggestedNewAlbumName"));
        o16.putExtra("QZoneNewAlbumActivity.key_choose_type", getIntent().getIntExtra("QZoneNewAlbumActivity.key_choose_type", 0));
        startActivityForResult(o16, 25);
    }

    private void Hj(boolean z16, HashMap<String, PhotoSendParams> hashMap) {
        HashMap<String, PicInfo> hashMap2;
        this.K0.clear();
        if (this.U0 && z16 && (hashMap2 = this.Y0) != null && hashMap2.size() > 0 && this.I0.size() == 0) {
            this.I0.clear();
            for (Map.Entry<String, PicInfo> entry : this.Y0.entrySet()) {
                String key = entry.getKey();
                PicInfo value = entry.getValue();
                if (value != null) {
                    PhotoSendParams photoSendParams = hashMap != null ? hashMap.get(key) : null;
                    NetImageInfo netImageInfo = new NetImageInfo();
                    netImageInfo.type = value.pictype;
                    netImageInfo.lloc = value.pictureid;
                    netImageInfo.mBigPath = key;
                    netImageInfo.mSmallPath = value.pic_url;
                    netImageInfo.mAlbumId = value.albumid;
                    netImageInfo.height = value.picheight;
                    netImageInfo.width = value.picwidth;
                    netImageInfo.sendParams = photoSendParams;
                    this.I0.add(netImageInfo);
                }
            }
        }
        for (int i3 = 0; i3 < this.I0.size(); i3++) {
            String str = this.I0.get(i3).mAlbumId;
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.K0.get(str);
                if (num == null) {
                    this.K0.put(str, 1);
                } else {
                    this.K0.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    private String Jj() {
        return "KEY_ALBUMLIST_HASMORE_" + LoginData.getInstance().getUin();
    }

    private LocalMediaInfo Kj(String str) {
        HashMap<String, LocalMediaInfo> hashMap = PhotoCommonBaseData.getInstance().allMediaInfoHashMap;
        HashMap<String, LocalMediaInfo> hashMap2 = this.f44059k1;
        LocalMediaInfo localMediaInfo = hashMap2 != null ? hashMap2.get(str) : null;
        if (localMediaInfo == null && hashMap != null) {
            localMediaInfo = hashMap.get(str);
        }
        if (localMediaInfo != null && (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0)) {
            d.a aVar = new d.a();
            com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
            int[] iArr = aVar.f288248a;
            localMediaInfo.mediaWidth = iArr[0];
            localMediaInfo.mediaHeight = iArr[1];
            localMediaInfo.rotation = iArr[2];
            LocalMediaInfo localMediaInfo2 = hashMap != null ? hashMap.get(str) : null;
            if (localMediaInfo2 != null && (localMediaInfo2.mediaWidth == 0 || localMediaInfo2.mediaHeight == 0)) {
                localMediaInfo2.mediaWidth = localMediaInfo.mediaWidth;
                localMediaInfo2.mediaHeight = localMediaInfo.mediaHeight;
                localMediaInfo2.rotation = localMediaInfo.rotation;
            }
        }
        return localMediaInfo;
    }

    private int Lj(String str) {
        if (TextUtils.isEmpty(str) || Kj(str) == null) {
            return -1;
        }
        return QAlbumUtil.getMediaType(Kj(str));
    }

    private HashMap<String, PhotoSendParams> Mj(ArrayList<String> arrayList, ArrayList<NetImageInfo> arrayList2) {
        HashMap<String, PhotoSendParams> hashMap = new HashMap<>(1);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = arrayList.get(i3);
            PhotoSendParams Gj = ImageManager.isNetworkUrl(str) ? Gj(str, arrayList2) : null;
            if (Gj != null) {
                hashMap.put(str, Gj);
            }
        }
        QZLog.d("[PhotoAlbum]aioSendPhotos", 1, "selectedPhotoList size:", Integer.valueOf(arrayList.size()), " selectedImages size:", Integer.valueOf(arrayList2.size()), " sendParams size:", Integer.valueOf(hashMap.size()));
        return hashMap;
    }

    private void Nj(QZoneResult qZoneResult) {
        Dh();
        if (qZoneResult == null) {
            QZLog.w("QZonePersonalAlbumSelectActivity", 1, "handleGetMoreResult: result is null");
            return;
        }
        Zj();
        if (QZLog.isColorLevel()) {
            QZLog.d("QZonePersonalAlbumSelectActivity", 2, "handleGetMoreResult" + qZoneResult.getSucceed());
        }
        if (qZoneResult.getSucceed()) {
            this.f45060j0.s0(getString(R.string.gm6));
            boolean hasMore = qZoneResult.getHasMore();
            ek(hasMore);
            if (hasMore) {
                Ci(5);
            } else {
                Ci(4);
            }
        } else {
            this.f45060j0.r0(getString(R.string.gm5), qZoneResult.getMessage());
            Ci(this.f45065o0);
        }
        fi();
    }

    private void Oj(QZoneResult qZoneResult) {
        Dh();
        if (qZoneResult == null) {
            QZLog.w("QZonePersonalAlbumSelectActivity", 1, "handleResult: result is null");
            this.f44060l1.l(5);
            return;
        }
        Zj();
        if (QZLog.isColorLevel()) {
            QZLog.d("QZonePersonalAlbumSelectActivity", 2, "handleResult:" + qZoneResult.getSucceed());
        }
        if (qZoneResult.getSucceed()) {
            if (qZoneResult.getNewCnt() == 0) {
                this.f44060l1.l(22);
            }
            this.f45060j0.s0(getString(R.string.gm6));
            boolean hasMore = qZoneResult.getHasMore();
            ek(hasMore);
            if (hasMore) {
                Ci(5);
            } else {
                Ci(4);
            }
        } else {
            this.f44060l1.l(5);
            this.f45060j0.r0(getString(R.string.gm5), qZoneResult.getMessage());
            Ci(this.f45065o0);
        }
        fi();
    }

    private void Sj() {
        if (TextUtils.isEmpty(this.f44062n1)) {
            return;
        }
        this.f44061m1 = new FrameLayout(getContext());
        this.f44061m1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f44061m1.addView(QUINoticeBarManager.l().h(getContext()).setMsg(this.f44062n1).getView());
        this.f45060j0.j0().addHeaderView(this.f44061m1);
    }

    private boolean Tj() {
        if (this.f44055g1) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNoSelectAlbum", "\u8bf7\u9009\u62e9\u76f8\u518c"));
            return false;
        }
        if (this.f44053e1 && this.f44054f1) {
            for (int i3 = 0; i3 < this.f44071w0.size(); i3++) {
                if (this.f44071w0.get(i3).mAlbumId.equals(this.f44050b1)) {
                    zj(this.f44071w0.get(i3));
                    return true;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uj() {
        return this.f44075z0 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wj() {
        return this.G0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xj() {
        return this.f44075z0 == 0;
    }

    private void Zj() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity.7
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList<AlbumCacheData> z16 = AlbumCacheDataManager.J().z(LoginData.getInstance().getUin());
                QZonePersonalAlbumSelectActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZonePersonalAlbumSelectActivity.this.f44071w0.clear();
                        if (z16 != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= z16.size()) {
                                    break;
                                }
                                AlbumCacheData albumCacheData = (AlbumCacheData) z16.get(i3);
                                if (albumCacheData != null) {
                                    BusinessAlbumInfo createFrom = BusinessAlbumInfo.createFrom(albumCacheData.albumid, albumCacheData.albumtype, albumCacheData.albumname, albumCacheData.getLloc(), albumCacheData.albumrights, albumCacheData.albumnum, albumCacheData.anonymity, albumCacheData.individual, albumCacheData.operatemask, albumCacheData.allow_share, albumCacheData.isSharingAlbumOnServer(), com.qzone.album.util.b.a(albumCacheData), albumCacheData.isSharingOwner);
                                    if (QZonePersonalAlbumSelectActivity.this.Wj()) {
                                        if (createFrom.mAlbumType == 10) {
                                            QZonePersonalAlbumSelectActivity.this.f44071w0.add(createFrom);
                                            QZonePersonalAlbumSelectActivity.this.Yj(createFrom);
                                            QZonePersonalAlbumSelectActivity.this.finish();
                                            break;
                                        }
                                    } else {
                                        int i16 = createFrom.mAlbumType;
                                        if (i16 != 21 && i16 != 102 && i16 != 10 && i16 != 101 && ((!"RecycleBin".equals(QZonePersonalAlbumSelectActivity.this.T0) || !createFrom.isShareAlbum() || createFrom.isSharingOwner != 0) && (TextUtils.isEmpty(QZonePersonalAlbumSelectActivity.this.Z0) || !QZonePersonalAlbumSelectActivity.this.Z0.equals(createFrom.mAlbumId)))) {
                                            QZonePersonalAlbumSelectActivity.this.f44071w0.add(createFrom);
                                            if (!TextUtils.isEmpty(QZonePersonalAlbumSelectActivity.this.X0) && QZonePersonalAlbumSelectActivity.this.X0.equals(createFrom.mAlbumId)) {
                                                QZonePersonalAlbumSelectActivity.this.Yj(createFrom);
                                            }
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                        QZonePersonalAlbumSelectActivity qZonePersonalAlbumSelectActivity = QZonePersonalAlbumSelectActivity.this;
                        qZonePersonalAlbumSelectActivity.notifyAdapter(((CustomListViewFragmentV2) qZonePersonalAlbumSelectActivity).f45059i0);
                        if (QZonePersonalAlbumSelectActivity.this.f44061m1 != null) {
                            QZonePersonalAlbumSelectActivity.this.f44061m1.setVisibility(QZonePersonalAlbumSelectActivity.this.f44071w0.isEmpty() ? 8 : 0);
                        }
                    }
                });
            }
        });
    }

    private void ak() {
        String format;
        int size = this.I0.size() + this.W0;
        if (size > 0) {
            if (this.F0) {
                this.O0.setEnabled(true);
                format = String.format(getResources().getString(R.string.f170778a90), Integer.valueOf(size));
            } else if (this.f44064p1 == 1) {
                String format2 = String.format(getResources().getString(R.string.f170779a91), Integer.valueOf(size));
                if (size >= 3) {
                    this.O0.setEnabled(true);
                } else {
                    this.O0.setEnabled(false);
                }
                format = format2;
            } else {
                format = String.format(getResources().getString(R.string.a8z), Integer.valueOf(size));
            }
            nk(format);
            return;
        }
        if (this.F0) {
            mk(R.string.gi9);
        } else if (this.f44064p1 == 1) {
            mk(R.string.cuc);
        } else {
            mk(R.string.gi8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(NetImageInfo netImageInfo) {
        boolean remove = this.I0.remove(netImageInfo);
        if (remove) {
            lk(netImageInfo.mAlbumId, 0);
            if (this.I0.size() == 0 && this.W0 == 0) {
                this.P0.setVisibility(8);
            }
            ak();
            yj(false);
            ck();
        }
        return remove;
    }

    private void ck() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.idz);
        RelativeLayout relativeLayout = this.P0;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                layoutParams.setMargins(0, 0, 0, this.R0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
        }
        this.f45060j0.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk() {
        ArrayList<NetImageInfo> arrayList;
        Intent intent = getIntent();
        if (this.I0.size() >= 0) {
            arrayList = new ArrayList<>();
            arrayList.addAll(this.I0);
        } else {
            arrayList = null;
        }
        if (!this.U0) {
            ParcelableWrapper.putArrayListToIntent(intent, QZoneContant.OUTPUT_IMAGES, arrayList);
            this.I0.clear();
            setResult(-1, intent);
        } else {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (this.E0) {
                if (stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList<>();
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        NetImageInfo netImageInfo = arrayList.get(i3);
                        if (netImageInfo != null) {
                            stringArrayListExtra.add(netImageInfo.getBigPath());
                        }
                    }
                    EventCenter.getInstance().post("QzDynamicVideo", 1, stringArrayListExtra);
                }
            } else if (this.F0) {
                LpReportInfo_pf00064.allReport(96, 3, 3);
                if (this.J0 == null) {
                    this.J0 = new ArrayList<>();
                }
                Ij(arrayList, this.J0, new HashMap<>(), new HashMap<>());
                HashMap<String, PhotoSendParams> Mj = Mj(this.J0, arrayList);
                if (Mj.size() != 0) {
                    fk(intent, true, this.J0, Mj, false);
                } else {
                    fk(intent, false, this.J0, null, false);
                }
            } else {
                if (1 == this.f44064p1) {
                    intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 1);
                    intent.putExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, 1);
                } else {
                    intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 0);
                }
                if (stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList<>();
                }
                HashMap<String, PicInfo> hashMap = new HashMap<>();
                HashMap<String, Integer> hashMap2 = new HashMap<>();
                Ij(arrayList, stringArrayListExtra, hashMap, hashMap2);
                intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", stringArrayListExtra);
                intent.putExtra(PeakConstants.PHOTO_INFOS, hashMap);
                intent.putExtra(PeakConstants.PANORAMA_IMAGES, hashMap2);
                intent.addFlags(603979776);
                intent.setClass(getActivity(), QZonePublishMoodTabActivity.class);
                startActivity(intent);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(BusinessAlbumInfo businessAlbumInfo) {
        DialogUtil.createNoTitleDialog(getActivity(), getResources().getString(R.string.an7), R.string.an6, R.string.an5, new d(), new e(businessAlbumInfo)).show();
    }

    private void initData() {
        Resources resources = getResources();
        if (resources != null) {
            this.R0 = resources.getDimensionPixelSize(R.dimen.f159098w6);
        }
        this.f44073x0 = com.qzone.album.base.Service.c.G();
        this.f44071w0 = new ArrayList();
    }

    private void initUI() {
        if (this.C != null) {
            if (this.U0) {
                setLeftButton(R.string.gj6, new g());
            } else {
                setLeftButton(R.string.f170549u3, null);
            }
        }
        if (!TextUtils.isEmpty(this.f44074y0)) {
            setTitle(this.f44074y0);
        }
        if (Uj()) {
            Qj();
        }
        Rj();
    }

    private void mk(int i3) {
        TextView textView = this.O0;
        if (textView != null) {
            textView.setText(i3);
        }
    }

    private void ok() {
        BaseAdapter baseAdapter = this.f45059i0;
        if (baseAdapter != null && baseAdapter.getCount() > 0) {
            if (Pj(LoginData.getInstance().getUin())) {
                Ci(5);
            } else {
                Ci(4);
            }
        }
    }

    private void parseIntent() {
        Intent intent = getIntent();
        this.f44063o1 = intent;
        boolean z16 = true;
        if (intent != null) {
            this.U0 = intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
            this.V0 = intent.getBooleanExtra(PeakConstants.IS_NEED_FILTER_MOOD_PRIVATE_ALBUM, false);
            this.E0 = intent.getBooleanExtra(PeakConstants.IS_FROM_P2V, false);
            this.F0 = intent.getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false);
            this.f44056h1 = intent.getStringExtra("key_source");
            if (this.F0) {
                LpReportInfo_pf00064.allReport(96, 2, 1);
            }
            this.Y0 = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_INFOS);
            this.J0 = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            this.f44059k1 = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
            ArrayList<String> arrayList = this.J0;
            if (arrayList != null) {
                int size = arrayList.size();
                HashMap<String, PicInfo> hashMap = this.Y0;
                this.W0 = size - (hashMap == null ? 0 : hashMap.size());
            }
            this.f44074y0 = intent.getStringExtra("key_title");
            this.f44075z0 = intent.getIntExtra("key_personal_album_enter_model", 0);
            this.G0 = intent.getBooleanExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_SELECT_VIDEO, false);
            this.H0 = intent.getBooleanExtra(QZoneContant.KEY_RESHIP, false);
            this.T0 = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_FROM_TYPE);
            this.S0 = intent.getStringExtra("refer");
            this.Z0 = intent.getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID);
            this.X0 = intent.getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_JUMP_ALBUM_ID);
            this.f44050b1 = intent.getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID);
            this.f44053e1 = intent.getBooleanExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_UPLOAD, false);
            HashMap<String, PhotoSendParams> hashMap2 = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM);
            this.f44057i1 = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
            this.f44058j1 = intent.getBooleanExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, false);
            this.f44064p1 = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
            this.f44062n1 = intent.getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_TIP_TEXT);
            if (hashMap2 == null) {
                hashMap2 = new HashMap<>(1);
            }
            if (Uj()) {
                this.A0 = intent.getIntExtra("_input_max", -1);
                this.D0 = intent.getBooleanExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, false);
                if (this.U0) {
                    this.A0 = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", -1);
                }
                ArrayList arrayListFromIntent = ParcelableWrapper.getArrayListFromIntent(intent, QZoneContant.INPUT_IMAGES);
                if (arrayListFromIntent != null && arrayListFromIntent.size() > 0) {
                    xj(arrayListFromIntent);
                }
                Hj(true, hashMap2);
            }
        }
        if (!Xj() || (intent != null && !intent.getBooleanExtra(QZoneHelper.QZoneAlbumConstants.KEY_CAN_NEW_ALBUM, true))) {
            z16 = false;
        }
        this.f44049a1 = z16;
    }

    private void yj(boolean z16) {
        if (this.U0) {
            return;
        }
        int size = this.I0.size();
        if (size > 0) {
            this.L0.setNumColumns(size);
            ViewGroup.LayoutParams layoutParams = this.L0.getLayoutParams();
            layoutParams.width = (int) (((this.I0.size() * 40) + ((this.I0.size() - 1) * 10) + 10) * u5.a.f438263a);
            this.L0.setLayoutParams(layoutParams);
            if (z16) {
                this.f44067s1.sendEmptyMessageDelayed(0, 200L);
            }
        }
        aa aaVar = this.M0;
        if (aaVar != null) {
            aaVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(BusinessAlbumInfo businessAlbumInfo) {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_ACCEPT_ALBUM_ANONYMITY) : null;
        boolean z16 = true;
        if (!TextUtils.isEmpty(stringExtra)) {
            String[] split = stringExtra.split(",");
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = false;
                    break;
                } else {
                    if (String.valueOf(QZoneAlbumUtil.s(businessAlbumInfo.mAnonymity)).equals(split[i3])) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        if (!z16 && intent != null) {
            ToastUtil.r(intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_DENY_SELECT_TIPS));
            return;
        }
        if (intent != null && intent.hasExtra("refer") && "QZonePublishQueueAcitvity".equals(intent.getStringExtra("refer"))) {
            jk(businessAlbumInfo, intent.getIntArrayExtra(QZoneQueueTask.RESUMENUM), intent.getStringExtra("albumid"));
            return;
        }
        if (intent != null && intent.getBooleanExtra(QZoneHelper.QZoneAlbumConstants.KEY_PASS_RESULT_BY_BUNDLE, false)) {
            Bundle bundle = new Bundle();
            bundle.putString(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ID, businessAlbumInfo.getId());
            bundle.putString(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_NAME, businessAlbumInfo.getTitle());
            bundle.putString(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_COVER, businessAlbumInfo.mCover);
            bundle.putInt(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_PERMISSION, businessAlbumInfo.mPrivacy);
            bundle.putInt(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_TYPE, businessAlbumInfo.mAlbumType);
            bundle.putInt(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ANONYMITY, businessAlbumInfo.mAnonymity);
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            setResult(-1, intent2);
            intent2.setAction("troop_select");
            sendBroadcast(intent2);
            finish();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO, businessAlbumInfo);
        Intent intent3 = new Intent();
        intent3.putExtras(bundle2);
        setResult(-1, intent3);
        finish();
    }

    public void Dj() {
        try {
            Dialog dialog = this.B0;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.B0.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void Fj() {
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            toast(getString(R.string.ci5));
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<NetImageInfo> it = this.I0.iterator();
        while (it.hasNext()) {
            NetImageInfo next = it.next();
            if (!TextUtils.isEmpty(next.getBigPath())) {
                arrayList.add(next.getBigPath());
            }
        }
        if (arrayList.size() == 0) {
            toast(R.string.gkh, 4);
        } else {
            kk(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoSaving", "\u6b63\u5728\u4fdd\u5b58"));
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity.10

                /* renamed from: com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity$10$a */
                /* loaded from: classes39.dex */
                class a implements u4.f {
                    a() {
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void a(String str, ArrayList<String> arrayList) {
                        String arrays;
                        QZonePersonalAlbumSelectActivity.this.Dj();
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH, arrayList);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("downloadPhoto onDownloadSucceed  | url = ");
                        sb5.append(str);
                        sb5.append(" | path = ");
                        if (bl.b(arrayList)) {
                            arrays = "";
                        } else {
                            arrays = Arrays.toString(arrayList.toArray());
                        }
                        sb5.append(arrays);
                        QLog.e("QZonePersonalAlbumSelectActivity", 1, sb5.toString());
                        if (arrayList != null) {
                            Iterator<String> it = arrayList.iterator();
                            while (it.hasNext()) {
                                QLog.e("QZonePersonalAlbumSelectActivity", 1, "downloadPhoto onDownloadSucceed | imagePath.exists" + new File(it.next()).exists());
                            }
                        }
                        QZonePersonalAlbumSelectActivity qZonePersonalAlbumSelectActivity = QZonePersonalAlbumSelectActivity.this;
                        qZonePersonalAlbumSelectActivity.toast(qZonePersonalAlbumSelectActivity.getString(R.string.gki), 5);
                        QZonePersonalAlbumSelectActivity.this.setResult(-1, intent);
                        QZonePersonalAlbumSelectActivity.this.finish();
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void onDownloadFailed(String str) {
                        QZonePersonalAlbumSelectActivity.this.toast(R.string.gkh, 4);
                        QZonePersonalAlbumSelectActivity.this.Dj();
                        QLog.e("QZonePersonalAlbumSelectActivity", 1, "downloadPics onDownloadFailed , url = " + str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    u4.a.z().s(System.currentTimeMillis() + "", arrayList, new a());
                }
            });
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    protected boolean Hh() {
        return true;
    }

    @Override // com.qzone.album.env.common.c
    public boolean P2() {
        return false;
    }

    public boolean Pj(long j3) {
        Boolean bool = this.f44068t1.get(Long.valueOf(j3));
        if (bool == null) {
            bool = Boolean.valueOf(u5.b.D(Jj(), true));
        }
        return bool.booleanValue();
    }

    @Override // com.qzone.album.env.common.c
    public ListView R3() {
        return this.f45060j0;
    }

    @Override // com.qzone.album.env.common.c
    public boolean Ta() {
        return checkNetworkConnect();
    }

    public boolean Vj(NetImageInfo netImageInfo) {
        return this.I0.contains(netImageInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    public void c0() {
        super.c0();
        HashMap<String, String> hashMap = new HashMap<>(1);
        if (this.F0) {
            hashMap.put(strKeyApplistPhotoScene.value, String.valueOf(1));
        } else {
            hashMap.put(strKeyApplistPhotoScene.value, String.valueOf(0));
        }
        gk(hashMap);
        hk(hashMap);
        this.f44073x0.R(LoginData.getInstance().getUin(), getHandler(), 2, hashMap);
    }

    public void ek(boolean z16) {
        this.f44068t1.put(Long.valueOf(LoginData.getInstance().getUin()), Boolean.valueOf(z16));
        u5.b.o0(Jj(), z16);
    }

    @Override // com.qzone.album.env.common.c
    public Activity getCurrentActivity() {
        return getActivity();
    }

    @Override // com.qzone.album.env.common.c
    public View getRootView() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    public void ii() {
        super.ii();
        HashMap<String, String> hashMap = new HashMap<>(1);
        if (this.F0) {
            hashMap.put(strKeyApplistPhotoScene.value, String.valueOf(1));
        } else {
            hashMap.put(strKeyApplistPhotoScene.value, String.valueOf(0));
        }
        hk(hashMap);
        gk(hashMap);
        if (this.f44073x0 == null || !Pj(LoginData.getInstance().getUin())) {
            return;
        }
        this.f44073x0.H(LoginData.getInstance().getUin(), getHandler(), 2, hashMap);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean isEnableNightMask() {
        return !QZoneConfigHelper.O0();
    }

    public void kk(String str) {
        Dialog dialog = this.B0;
        if (dialog == null || !dialog.isShowing()) {
            if (this.B0 == null) {
                ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
                this.B0 = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.C0 = (TextView) this.B0.findViewById(R.id.dialogText);
                this.B0.findViewById(R.id.kja).setVisibility(8);
                this.B0.findViewById(R.id.cib).setVisibility(0);
            }
            this.C0.setText(str);
            try {
                this.B0.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void lk(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.K0.get(str);
        if (num == null) {
            num = 0;
        }
        if (i3 == 0) {
            if (num.intValue() <= 1) {
                this.K0.remove(str);
            } else {
                this.K0.put(str, Integer.valueOf(num.intValue() - 1));
            }
        } else {
            this.K0.put(str, Integer.valueOf(num.intValue() + 1));
        }
        BaseAdapter baseAdapter = this.f45059i0;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        Parcelable parcelableExtra;
        super.onActivityResult(i3, i16, intent);
        if (i16 == 100001) {
            finish();
        }
        if (i16 == 0 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("key_selected_has_change", false);
            this.f44058j1 = intent.getBooleanExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, false);
            if (Uj() && booleanExtra) {
                ArrayList arrayListFromIntent = ParcelableWrapper.getArrayListFromIntent(intent, QZoneContant.OUTPUT_IMAGES);
                this.J0 = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                this.f44057i1 = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
                Bj();
                if ((arrayListFromIntent == null || arrayListFromIntent.size() < 0) && this.W0 <= 0) {
                    return;
                }
                this.I0.clear();
                this.I0.addAll(arrayListFromIntent);
                if (this.I0.size() <= 0 && this.W0 <= 0) {
                    if (this.P0.getVisibility() != 8) {
                        this.P0.setVisibility(8);
                    }
                } else if (this.P0.getVisibility() != 0) {
                    this.P0.setVisibility(0);
                }
                ak();
                yj(true);
                ck();
                Hj(false, null);
                BaseAdapter baseAdapter = this.f45059i0;
                if (baseAdapter != null) {
                    notifyAdapter(baseAdapter);
                    return;
                }
                return;
            }
            return;
        }
        if (i16 == -1) {
            if (i3 == 1) {
                if (intent == null) {
                    return;
                }
                this.f44051c1 = intent.getStringExtra("albumId");
                this.f44052d1 = intent.getStringExtra(QZoneContant.KEY_DELETED_ALBUM_ID);
                final int intExtra = intent.getIntExtra("albumRight", 0);
                final int intExtra2 = intent.getIntExtra("albumType", 0);
                final String stringExtra = intent.getStringExtra(AEEditorConstants.ALBUMNAME);
                String str = this.f44051c1;
                if (str != null && str.equals(this.f44050b1)) {
                    this.f44054f1 = true;
                }
                String str2 = this.f44052d1;
                if (str2 != null && str2.equals(this.f44050b1)) {
                    this.f44055g1 = true;
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity.12
                    @Override // java.lang.Runnable
                    public void run() {
                        QZLog.d("QZonePersonalAlbumSelectActivity", 2, "lastSelectAlbumId:", QZonePersonalAlbumSelectActivity.this.f44051c1, " albumName:", stringExtra, " albumType", Integer.valueOf(intExtra2), " albumRights:", Integer.valueOf(intExtra));
                        AlbumCacheData x16 = AlbumCacheDataManager.J().x(LoginData.getInstance().getUin(), QZonePersonalAlbumSelectActivity.this.f44051c1);
                        if (x16 != null) {
                            x16.albumtype = intExtra2;
                            x16.albumname = stringExtra;
                            x16.albumrights = intExtra;
                            AlbumCacheDataManager.J().t0(x16);
                            return;
                        }
                        QZLog.d("QZonePersonalAlbumSelectActivity", 2, "onActivityResult() PhotoConst.RquestCode.REQUEST_CODE_EDIT_ALBUM albumCacheData is null! may be deleted!");
                    }
                });
                onRefresh();
                return;
            }
            if (i3 != 24) {
                if (i3 == 25 && intent != null && Xj() && (parcelableExtra = intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO)) != null && (parcelableExtra instanceof BusinessAlbumInfo)) {
                    zj((BusinessAlbumInfo) parcelableExtra);
                    return;
                }
                return;
            }
            if (intent != null) {
                if (Uj()) {
                    if (this.D0) {
                        setResult(-1, intent);
                        finish();
                    }
                    ArrayList arrayListFromIntent2 = ParcelableWrapper.getArrayListFromIntent(intent, QZoneContant.OUTPUT_IMAGES);
                    this.f44057i1 = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.f44057i1);
                    this.J0 = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                    Bj();
                    if (arrayListFromIntent2 == null || arrayListFromIntent2.size() < 0) {
                        return;
                    }
                    this.I0.clear();
                    this.I0.addAll(arrayListFromIntent2);
                    dk();
                    return;
                }
                if (this.f44075z0 == 2) {
                    setResult(-1, intent);
                    finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean onBackPress() {
        if (this.U0) {
            Aj();
            return true;
        }
        if (!Tj()) {
            return true;
        }
        LpReportInfo_pf00064.allReport(602, 11, 4);
        return super.onBackPress();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
        onBackPress();
        super.onBackPressed();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if ("from_device_lightapp".equals(this.S0)) {
            unregisterReceiver(this.f44070v1);
        }
        QZoneTopGestureLayout.shouldInterceptEvent(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        int i3 = message.what;
        if (i3 == 999914) {
            ni();
            Hi(true);
            if (this.f45058h0 != 1) {
                return;
            }
            Oj(unpack);
            return;
        }
        if (i3 != 999916) {
            if (i3 != 87) {
                Dh();
            }
        } else {
            if (this.f45058h0 != 2) {
                return;
            }
            Nj(unpack);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        parseIntent();
        initData();
        initUI();
        if (!this.V0) {
            Zj();
        }
        ck();
        this.f45060j0.setRefreshing(false);
        Ci(3);
        LpReportInfo_pf00064.allReport(602, 11, 1);
        if ("from_device_lightapp".equals(this.S0)) {
            this.f44070v1 = new o();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("receive_share_alum_success");
            registerReceiver(this.f44070v1, intentFilter);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (this.F0 && z16) {
            try {
                Intent intent = new Intent();
                intent.setAction("AlbumListActivity_finish");
                sendBroadcast(intent);
                QZLog.i("QZonePersonalAlbumSelectActivity", "sendBroadcast to finish the last activity. hasFocus:" + z16);
            } catch (Throwable th5) {
                QZLog.e("QZonePersonalAlbumSelectActivity", "sendBroadcast to finish the last activity error", th5);
            }
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragmentV2
    protected boolean ri() {
        return true;
    }

    @Override // com.qzone.album.business.photolist.adapter.x.e
    public int ta(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = this.K0.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    private void Bj() {
        this.W0 = 0;
        ArrayList<String> arrayList = this.J0;
        if (arrayList == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = arrayList.get(i3);
            if (!TextUtils.isEmpty(str) && !str.startsWith("http")) {
                this.W0++;
            }
        }
    }

    private PhotoSendParams Gj(String str, ArrayList<NetImageInfo> arrayList) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (str.equals(arrayList.get(i3).getBigPath())) {
                return arrayList.get(i3).sendParams;
            }
        }
        return null;
    }

    private void Ij(ArrayList<NetImageInfo> arrayList, ArrayList<String> arrayList2, HashMap<String, PicInfo> hashMap, HashMap<String, Integer> hashMap2) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<NetImageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                NetImageInfo next = it.next();
                HashMap<String, PicInfo> hashMap3 = this.Y0;
                if (hashMap3 != null && hashMap3.size() > 0) {
                    this.Y0.remove(next.getBigPath());
                }
                if (!arrayList2.contains(next.getBigPath())) {
                    arrayList2.add(next.getBigPath());
                }
                PicInfo picInfo = new PicInfo();
                picInfo.albumid = next.mAlbumId;
                picInfo.pictype = next.type;
                String str = next.lloc;
                picInfo.sloc = str;
                picInfo.pictureid = str;
                picInfo.pic_url = next.getSmallPath();
                picInfo.picwidth = next.width;
                picInfo.picheight = next.height;
                hashMap.put(next.getBigPath(), picInfo);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                }
                int i3 = next.flag;
                if (i3 == 16) {
                    hashMap2.put(next.getBigPath(), 1);
                } else if (i3 == 32) {
                    hashMap2.put(next.getBigPath(), 2);
                }
            }
        }
        HashMap<String, PicInfo> hashMap4 = this.Y0;
        if (hashMap4 == null || hashMap4.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<String, PicInfo>> it5 = this.Y0.entrySet().iterator();
        while (it5.hasNext()) {
            arrayList2.remove(it5.next().getKey());
        }
    }

    private void jk(BusinessAlbumInfo businessAlbumInfo, int[] iArr, String str) {
        String config;
        if (iArr != null && iArr.length >= 2) {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(getActivity(), R.style.qZoneInputDialog);
            qQCustomDialog.setCancelable(false);
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.setContentView(R.layout.custom_dialog);
            int i3 = iArr[0];
            if (i3 > 0 && iArr[1] > 0) {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoUploadPicAndVid", "\u4e0a\u4f20\u7167\u7247\u548c\u89c6\u9891\u5230\u8be5\u76f8\u518c?");
            } else if (i3 > 0 && iArr[1] <= 0) {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoUploadPic", "\u4e0a\u4f20\u7167\u7247\u5230\u8be5\u76f8\u518c?");
            } else if (i3 <= 0 && iArr[1] > 0) {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoUploadVid", "\u4e0a\u4f20\u89c6\u9891\u5230\u8be5\u76f8\u518c?");
            } else {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoUploadPic", "\u4e0a\u4f20\u7167\u7247\u5230\u8be5\u76f8\u518c?");
            }
            qQCustomDialog.setTitle(config);
            qQCustomDialog.setMessage((CharSequence) null);
            qQCustomDialog.setPositiveButton(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogUpload", "\u7acb\u5373\u4e0a\u4f20"), new b(businessAlbumInfo, str));
            qQCustomDialog.setNegativeButton(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancel", "\u53d6\u6d88"), new c());
            qQCustomDialog.show();
            return;
        }
        QZLog.w("QZonePersonalAlbumSelectActivity", "has not picture or video are chosen");
    }

    private void nk(String str) {
        TextView textView;
        if (str == null || str.trim().equals("") || (textView = this.O0) == null) {
            return;
        }
        textView.setText(str);
    }

    private void Qj() {
        this.P0 = (RelativeLayout) findViewById(R.id.abq);
        if (this.I0.size() > 0 && this.P0.getVisibility() != 0) {
            this.P0.setVisibility(0);
        }
        this.N0 = (HorizontalScrollView) findViewById(R.id.ii_);
        this.O0 = (TextView) findViewById(R.id.k6q);
        TextView textView = (TextView) findViewById(R.id.dg7);
        this.Q0 = textView;
        if (this.f44064p1 == 1) {
            textView.setVisibility(0);
        }
        ak();
        if (!this.U0) {
            this.L0 = (GridView) findViewById(R.id.imh);
            aa aaVar = new aa(this.I0, getActivity());
            this.M0 = aaVar;
            this.L0.setAdapter((ListAdapter) aaVar);
            yj(true);
            this.L0.setOnItemClickListener(new m());
        }
        this.O0.setOnClickListener(new n());
    }

    private void Rj() {
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) findViewById(R.id.album_list);
        this.f45060j0 = qZonePullToRefreshListView;
        if (qZonePullToRefreshListView instanceof QzoneSwipPullRefreshListView) {
            ((QzoneSwipPullRefreshListView) qZonePullToRefreshListView).setDragEnable(true);
        }
        this.f45060j0.setOnRefreshListener(new h());
        this.f45060j0.setOnScrollListener(new i());
        this.f44060l1 = new com.qzone.album.ui.widget.c(this, new j());
        x xVar = new x(getActivity(), this.f44071w0, this.f44049a1, this);
        this.f45059i0 = xVar;
        xVar.g(this.f44050b1);
        ((x) this.f45059i0).i(this.f44065q1);
        ((x) this.f45059i0).h(this.f44066r1);
        Sj();
        qi(true);
        this.f45060j0.j0().setAdapter((ListAdapter) this.f45059i0);
        this.f45060j0.setSupportPullUp(true);
        ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yj(BusinessAlbumInfo businessAlbumInfo) {
        if (businessAlbumInfo == null) {
            return;
        }
        BusinessAlbumInfo businessAlbumInfo2 = new BusinessAlbumInfo(businessAlbumInfo.mAlbumId);
        businessAlbumInfo2.copyFrom(businessAlbumInfo);
        businessAlbumInfo2.mUin = LoginData.getInstance().getUin();
        startActivityForResult(ak.I(getActivity(), businessAlbumInfo2, this.f44075z0), 24);
        this.X0 = null;
    }

    private void gk(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        if (!this.V0) {
            QLog.i("QZonePersonalAlbumSelectActivity", 1, "no need to filter");
        } else {
            QLog.i("QZonePersonalAlbumSelectActivity", 1, "setFilterMoodPrivateAlbum");
            hashMap.put("not_mood_album", "1");
        }
    }

    private void hk(HashMap<String, String> hashMap) {
        if (hashMap != null && QZoneHelper.QZoneAlbumConstants.VALUE_SOURCE_FROM_XIAOWO.equals(this.f44056h1)) {
            hashMap.put("only_public_album", String.valueOf(1));
        }
    }

    private boolean xj(List<NetImageInfo> list) {
        NetImageInfo next;
        boolean z16 = false;
        if (list != null && list.size() > 0) {
            Iterator<NetImageInfo> it = list.iterator();
            while (it.hasNext() && (next = it.next()) != null && Cj()) {
                if (!this.I0.contains(next)) {
                    z16 = this.I0.add(next);
                }
            }
        }
        return z16;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bo_, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements AbsListView.OnScrollListener {
        i() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if ((i3 == 0 || i3 == 2) && ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45060j0.j0().getLastVisiblePosition() >= ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45060j0.j0().getCount() - 2) {
                QZonePersonalAlbumSelectActivity.this.ti();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }

    /* loaded from: classes39.dex */
    class k implements x.g {
        k() {
        }

        @Override // com.qzone.album.business.photolist.adapter.x.g
        public boolean a(int i3, boolean z16) {
            if (!(z16 && i3 == 0) && (((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45060j0 instanceof QzoneSwipPullRefreshListView)) {
                return ((QzoneSwipPullRefreshListView) ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45060j0).u0(i3);
            }
            return false;
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        LpReportInfo_pf00064.allReport(602, 11, 4);
        LpReportInfo_pf00064.allReport(86, 7, 2);
        if (Tj()) {
            return super.onBackEvent();
        }
        return true;
    }

    private void fk(Intent intent, boolean z16, ArrayList<String> arrayList, HashMap<String, PhotoSendParams> hashMap, boolean z17) {
        HashMap hashMap2 = new HashMap();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            String str = arrayList.get(i18);
            if (!ImageManager.isNetworkUrl(str)) {
                if (Lj(str) == 1) {
                    LocalMediaInfo Kj = Kj(str);
                    if (Kj != null) {
                        SendVideoInfo sendVideoInfo = new SendVideoInfo();
                        sendVideoInfo.fileSize = Kj.fileSize;
                        sendVideoInfo.duration = Kj.mDuration;
                        hashMap2.put(Integer.valueOf(i17), sendVideoInfo);
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
        if (!hashMap2.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap2);
        }
        if (z16) {
            ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(getActivity(), intent, arrayList, hashMap, this.f44057i1, false);
        } else {
            PhotoUtils.sendPhoto(getActivity(), intent, arrayList, this.f44057i1, z17);
        }
        ReportController.o(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", 0, 0, valueOf, valueOf2, "", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements QZonePullToRefreshListView.c {
        h() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            QZonePersonalAlbumSelectActivity.this.Dh();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
            QZonePersonalAlbumSelectActivity.this.si(new long[0]);
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            QZonePersonalAlbumSelectActivity.this.onRefresh();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements c.b {
        j() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void refresh() {
            try {
                QZonePersonalAlbumSelectActivity.this.Hi(false);
                ((CustomListViewFragmentV2) QZonePersonalAlbumSelectActivity.this).f45060j0.setRefreshing(false);
            } catch (Exception e16) {
                QZLog.e("QZonePersonalAlbumSelectActivity", " mEmptyViewController refresh error !! ", e16);
            }
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void a() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}

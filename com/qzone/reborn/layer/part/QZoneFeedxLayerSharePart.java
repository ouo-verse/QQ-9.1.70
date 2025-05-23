package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.component.g;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.QZoneAlbumMediaRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart;
import com.qzone.reborn.layer.share.QZoneBaseShareAction;
import com.qzone.reborn.layer.share.QZoneShareOcrAction;
import com.qzone.reborn.layer.share.QZoneShareScanQRCodeAction;
import com.qzone.reborn.layer.share.QZoneShareWXFriendAction;
import com.qzone.widget.AsyncImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import rk.QZoneLayerPicOriginState;

/* loaded from: classes37.dex */
public class QZoneFeedxLayerSharePart extends ap implements View.OnClickListener, DialogInterface.OnCancelListener, RFWGalleryViewPager.OnItemLongClickListener {

    /* renamed from: c0, reason: collision with root package name */
    public static final List<Integer> f57857c0 = new ArrayList<Integer>() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart.1
        {
            add(39);
            add(230);
            add(100);
            add(48);
            add(6);
            add(84);
            add(40);
            add(56);
            add(23);
            add(107);
            add(11);
            add(3);
            add(52);
            add(104);
            add(106);
        }
    };
    private boolean H;
    private ImageView I;
    protected com.qzone.detail.ui.component.g L;
    long R;
    private com.qzone.reborn.layer.share.m S;
    private c T;
    private RFWGalleryViewPager U;
    private QZoneShareScanQRCodeAction Y;
    protected boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private uk.g f57858a0;
    private int G = -1;
    private boolean J = true;
    private boolean K = false;
    private final AtomicBoolean M = new AtomicBoolean(false);
    private final Map<Integer, QZoneBaseShareAction> N = new ConcurrentHashMap();
    final List<ShareActionSheetBuilder.ActionSheetItem> P = new ArrayList();
    final List<ShareActionSheetBuilder.ActionSheetItem> Q = new ArrayList();
    private String V = null;
    private String W = null;
    private String X = null;

    /* renamed from: b0, reason: collision with root package name */
    protected ShareActionSheet.c f57859b0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f57860a;

        a(String str) {
            this.f57860a = str;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            QZoneFeedxLayerSharePart.this.S.W(this.f57860a, z16);
            if (z16) {
                QZoneFeedxLayerSharePart qZoneFeedxLayerSharePart = QZoneFeedxLayerSharePart.this;
                qZoneFeedxLayerSharePart.Q9(2, 84, (!qZoneFeedxLayerSharePart.W9() || QZoneFeedxLayerSharePart.this.L9() || QZoneFeedxLayerSharePart.this.D == 0) ? false : true);
            } else {
                QZoneFeedxLayerSharePart qZoneFeedxLayerSharePart2 = QZoneFeedxLayerSharePart.this;
                qZoneFeedxLayerSharePart2.Q9(2, 6, (!qZoneFeedxLayerSharePart2.W9() || QZoneFeedxLayerSharePart.this.L9() || QZoneFeedxLayerSharePart.this.D == 0) ? false : true);
            }
        }
    }

    /* loaded from: classes37.dex */
    class b implements ShareActionSheet.c {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            QZoneFeedxLayerSharePart.this.Qa(view, actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private View f57863a;

        /* renamed from: b, reason: collision with root package name */
        private Handler f57864b;

        c(Context context, Handler handler) {
            this.f57863a = LayoutInflater.from(context).inflate(R.layout.bqh, (ViewGroup) null);
            this.f57864b = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, String str2, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(str)) {
                yo.d.d(str, this.f57863a.getContext(), null);
                QZoneFeedxPictureManager.getInstance().sendReportExposeOrClick(new QZoneAlbumMediaRequestBuilder().setTraceInfo(str2).setUin(String.valueOf(LoginData.getInstance().getUin())).setIsExpose(false), this.f57864b);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        View b() {
            return this.f57863a;
        }

        void d(final String str, String str2, final String str3, boolean z16) {
            QZLog.i("AdvViewModel", "showOrHideNamingAdv logo:" + str2 + " traceInfo:" + str + " url:" + str3 + " isPhotoItem:" + z16);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.f57863a.findViewById(R.id.h9p);
            if (z16) {
                linearLayout.setVisibility(0);
                QZoneFeedxPictureManager.getInstance().sendReportExposeOrClick(new QZoneAlbumMediaRequestBuilder().setTraceInfo(str).setUin(String.valueOf(LoginData.getInstance().getUin())).setIsExpose(true), this.f57864b);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.aj
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZoneFeedxLayerSharePart.c.this.c(str3, str, view);
                    }
                });
                int screenWidth = ViewUtils.getScreenWidth();
                int i3 = (int) (((screenWidth * 1.0d) / 750.0d) * 98.0d);
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = i3;
                linearLayout.setLayoutParams(layoutParams);
                AsyncImageView asyncImageView = (AsyncImageView) this.f57863a.findViewById(R.id.h9q);
                ViewGroup.LayoutParams layoutParams2 = asyncImageView.getLayoutParams();
                layoutParams2.width = screenWidth;
                layoutParams2.height = i3;
                asyncImageView.setLayoutParams(layoutParams2);
                asyncImageView.setAsyncImageProcessor(new ScaleProcessor(screenWidth, i3));
                asyncImageView.setAsyncImage(str2);
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    private void Ha() {
        if (this.S == null) {
            return;
        }
        String b16 = com.qzone.preview.d.b(this.f57984d, this.f57988i);
        this.S.S(new a(b16), b16);
    }

    private boolean Ia(int i3) {
        String str;
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : this.Q) {
            if (actionSheetItem != null && build != null && (str = actionSheetItem.label) != null && str.equals(build.label)) {
                return true;
            }
        }
        return false;
    }

    private boolean Ma() {
        return com.qzone.reborn.util.i.b().d("QZONE_LAYER_SHARE_PHOTO_REPAIR_RED_DOT", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oa(PhotoInfo photoInfo) {
        boolean z16 = false;
        QZLog.d(getTAG(), 1, "decodeFile result call... photoInfo.hasQQCode:", photoInfo.hasQQCode, " !isVideoViewer():", Boolean.valueOf(!L9()));
        if (photoInfo.hasQQCode.booleanValue()) {
            Va(23);
            LpReportInfo_pf00064.allReport(301, 5, 1);
            if (photoInfo.hasQQCode.booleanValue() && !L9()) {
                z16 = true;
            }
            Q9(2, 56, z16);
        } else {
            if (photoInfo.hasQRCode.booleanValue() && !L9()) {
                z16 = true;
            }
            Q9(2, 23, z16);
        }
        com.qzone.detail.ui.component.g gVar = this.L;
        if (gVar != null) {
            gVar.refresh();
        }
    }

    private void Ra() {
        QZoneShareScanQRCodeAction qZoneShareScanQRCodeAction = this.Y;
        if (qZoneShareScanQRCodeAction == null) {
            return;
        }
        qZoneShareScanQRCodeAction.M();
    }

    private void S9(QZoneBaseShareAction qZoneBaseShareAction) {
        for (int i3 : qZoneBaseShareAction.s()) {
            this.N.put(Integer.valueOf(i3), qZoneBaseShareAction);
        }
    }

    private void Sa() {
        QZLog.i("QZoneFeedxLayerSharePart", "QzonePictureViewer requestAdData ");
        QZoneFeedxPictureManager.getInstance().getBigPhotoAdList(new QZoneAlbumMediaRequestBuilder().setLocalType(1).setRemoteType(2541), A9());
    }

    private void Ya() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        QZoneLayerPicOriginState picOriginState;
        if (this.f57858a0 == null || (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) == null || rFWLayerItemMediaInfo.getLayerPicInfo() == null || this.mCurrentSelectedItem.getLayerPicInfo().getPicId() == null || (picOriginState = this.f57858a0.getPicOriginState()) == null || !Objects.equals(picOriginState.getPicId(), this.mCurrentSelectedItem.getLayerPicInfo().getPicId())) {
            return;
        }
        this.f57984d.isShowOriginState = picOriginState.getIsShowOrigin();
    }

    private void ja() {
        Pair<Boolean, Boolean> K = sa().K(this.f57984d, new QZoneShareScanQRCodeAction.c() { // from class: com.qzone.reborn.layer.part.ah
            @Override // com.qzone.reborn.layer.share.QZoneShareScanQRCodeAction.c
            public final void a(PhotoInfo photoInfo) {
                QZoneFeedxLayerSharePart.this.Oa(photoInfo);
            }
        });
        if (K != null) {
            QZLog.d(getTAG(), 1, "showMoreActionMenu... qrCode.first:", K.first, " qrCode.second:", K.second);
            if (!Ia(56)) {
                Q9(2, 56, ((Boolean) K.second).booleanValue());
            }
            if (((Boolean) K.second).booleanValue()) {
                LpReportInfo_pf00064.allReport(301, 5, 1);
            }
            if (Ia(23)) {
                return;
            }
            Q9(2, 23, ((Boolean) K.first).booleanValue());
        }
    }

    private void pa(Bundle bundle) {
        String string = bundle.getString("trace_info");
        String string2 = bundle.getString("logo_pic");
        String string3 = bundle.getString("jump_url");
        if (!TextUtils.isEmpty(string)) {
            this.V = string;
        }
        if (!TextUtils.isEmpty(string2)) {
            this.W = string2;
        }
        if (!TextUtils.isEmpty(string3)) {
            this.X = string3;
        }
        QZLog.i("QZoneFeedxLayerSharePart", "filledWithAdData success trace_info: " + string + " logo: " + string2 + " url: " + string3);
    }

    private int qa(int i3) {
        int indexOf = f57857c0.indexOf(Integer.valueOf(i3));
        for (int i16 = 0; i16 < this.Q.size(); i16++) {
            if (indexOf < f57857c0.indexOf(Integer.valueOf(this.Q.get(i16).action))) {
                return i16;
            }
        }
        return -1;
    }

    private QZoneShareScanQRCodeAction sa() {
        if (this.Y == null) {
            this.Y = new QZoneShareScanQRCodeAction(getActivity());
        }
        return this.Y;
    }

    private void wa(QZoneResult qZoneResult) {
        if (qZoneResult.getSucceed()) {
            c6.a.j(getActivity().getResources().getString(R.string.akw), 5);
        } else {
            c6.a.i(qZoneResult.getMessage());
        }
    }

    protected void Aa(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().shareToQQ();
        }
        new com.qzone.reborn.layer.share.t(getActivity()).t(ta(), actionSheetItem);
    }

    protected void Ba(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().shareToQQ();
        }
        new com.qzone.reborn.layer.share.u(getActivity()).t(ta(), actionSheetItem);
    }

    protected void Ca(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().x5();
        }
        new com.qzone.reborn.layer.share.s(getActivity()).t(ta(), actionSheetItem);
    }

    protected void Da(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().e4();
        }
        new com.qzone.reborn.layer.share.v(getActivity()).t(ta(), actionSheetItem);
        na();
    }

    protected void Fa(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().w4();
        }
        new QZoneShareWXFriendAction(getActivity()).t(ta(), actionSheetItem);
    }

    protected void Ga(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().j5();
        }
        new com.qzone.reborn.layer.share.af(getActivity()).t(ta(), actionSheetItem);
    }

    protected boolean Ja() {
        com.qzone.detail.ui.component.g gVar = this.L;
        return gVar != null && gVar.isShowing();
    }

    protected boolean Ka() {
        PhotoInfo photoInfo = this.f57984d;
        boolean z16 = photoInfo != null && photoInfo.isShowRepair;
        QZLog.d("QZoneFeedxLayerSharePart", 1, "isNeedOpenPhotoRepair  | isShowRepair = " + z16);
        return z16;
    }

    protected boolean La() {
        if (this.G == -1) {
            this.G = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_PHOTO_SAVE, 1);
        }
        return this.G == 1;
    }

    protected void Q9(final int i3, final int i16, final boolean z16) {
        com.tencent.mobileqq.leba.util.a.b(new Runnable() { // from class: com.qzone.reborn.layer.part.ai
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxLayerSharePart.this.Na(i3, i16, z16);
            }
        });
    }

    protected void R9(int i3, int i16, boolean z16, boolean z17) {
        if (this.L == null) {
            return;
        }
        if (z16) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i16);
            build.showRedDot = z17;
            if (i3 == 1) {
                this.P.add(build);
            } else {
                int qa5 = qa(i16);
                if (qa5 >= 0) {
                    this.Q.add(qa5, build);
                } else {
                    this.Q.add(build);
                }
            }
        }
        this.L.updateUI();
    }

    public boolean T9() {
        PhotoInfo photoInfo = this.f57984d;
        boolean z16 = (photoInfo.opMask & 128) != 0;
        PhotoParam photoParam = this.f57988i;
        return z16 && tk.k.f436438a.e(photoParam) && (photoParam != null && photoParam.appid != 2) && ((photoInfo.allow_share != 0) || (photoParam != null && photoParam.appid == 311));
    }

    protected void Ta() {
        if (this.f57984d != null) {
            this.U.setOnItemLongClickListener(this);
        } else {
            this.U.setOnItemClickListener(null);
        }
    }

    protected boolean U9(boolean z16) {
        PhotoParam photoParam;
        if (this.f57984d == null) {
            return false;
        }
        if (!L9()) {
            return true;
        }
        int y16 = tk.h.y(this.f57984d, this.f57988i, false);
        return ((y16 != 0 && y16 != 4) || (photoParam = this.f57988i) == null || photoParam.notAllowShareOutside) ? false : true;
    }

    protected void Ua(int i3, boolean z16) {
        com.qzone.detail.ui.component.g gVar = this.L;
        if (gVar != null) {
            gVar.s0(i3, z16);
            this.L.updateUI();
        }
    }

    protected boolean V9(boolean z16) {
        return (K9() || I9() || J9()) && BasePicureViewController.e(this.f57984d) && z16;
    }

    protected void Va(int i3) {
        com.qzone.detail.ui.component.g gVar = this.L;
        if (gVar != null) {
            gVar.p0(i3);
            this.L.updateUI();
        }
    }

    protected boolean W9() {
        return true;
    }

    public void Wa(Handler handler, Intent intent) {
        BusinessFeedData businessFeedData = QZoneFeedUtil.f47421a.get("current_forward_key");
        if (businessFeedData != null && intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
            if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
                QLog.e("QZoneFeedxLayerSharePart", 1, "[shareToQzone] bean is not instanceof");
                return;
            } else {
                QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
                QZoneFeedUtil.r(businessFeedData, qZoneCommentPanelResultBean.getInputContent(), businessFeedData.getFeedCommInfo().appid == 311 ? 1 : 2, null, qZoneCommentPanelResultBean.getCacheUniKey(), handler, qZoneCommentPanelResultBean.getIsCheckedForwardAndComment(), 1);
                return;
            }
        }
        QZLog.i("QZoneFeedxLayerSharePart", 1, "shareToQzone data is:" + intent);
    }

    protected boolean X9() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Xa() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_OCR_BUTTON, QzoneConfig.DefaultValue.DEFAULT_SHOW_OCR_BUTTON);
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(config)) {
            String[] split = config.split("-");
            if (split.length >= 2) {
                try {
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                } catch (Exception e16) {
                    RFWLog.e("QZoneFeedxLayerSharePart", RFWLog.USR, "exception is " + e16);
                    return false;
                }
            }
        }
        long uin = LoginData.getInstance().getUin() % 100;
        return uin >= ((long) iArr[0]) && uin < ((long) iArr[1]);
    }

    protected boolean Y9() {
        return false;
    }

    protected boolean Z9(IOCRService iOCRService, String str) {
        return Xa() && iOCRService.isQZoneSupportOcr(str) && !L9() && !E9();
    }

    protected boolean aa() {
        return true;
    }

    public boolean ba() {
        return true;
    }

    protected boolean ca() {
        return true;
    }

    protected boolean da() {
        return (this.f57987h == 1 || this.K || Ia(107)) ? false : true;
    }

    protected boolean ea() {
        return tk.k.f436438a.e(this.f57988i) && this.f57987h == 0 && !Ia(100);
    }

    protected boolean ga() {
        return true;
    }

    protected boolean ha() {
        PhotoInfo photoInfo = this.f57984d;
        return (photoInfo == null || TextUtils.isEmpty(photoInfo.albumId) || TextUtils.isEmpty(photoInfo.lloc)) ? false : true;
    }

    public boolean ia() {
        PhotoParam photoParam;
        PhotoInfo photoInfo = this.f57984d;
        return (photoInfo == null || TextUtils.isEmpty(photoInfo.albumId) || TextUtils.isEmpty(photoInfo.lloc) || (photoParam = this.f57988i) == null || TextUtils.isEmpty(photoParam.cell_id)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        super.initIntentData(bundle);
        this.H = bundle.getBoolean(PictureConst.KEY_FAKE_FEED, false);
        this.R = bundle.getLong(PictureConst.KEY_FEED_DELETE_TIME, 0L);
        this.K = bundle.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_WX, false);
        Sa();
    }

    protected void la() {
        if (this.J && this.f57984d != null) {
            try {
                com.qzone.detail.ui.component.g ma5 = ma();
                this.L = ma5;
                ma5.setActionSheetTitle(getContext().getString(R.string.hja));
                this.L.setIsShowRecentFriends(aa());
                Intent intent = new Intent();
                intent.putExtra("forward_type", this.f57984d.isVideo() ? 39 : 1);
                this.L.setIntentForStartForwardRecentActivity(intent);
                this.P.clear();
                this.Q.clear();
                this.L.setActionSheetItems(this.P, this.Q);
                Q9(1, 3, X9());
                Q9(1, 2, true);
                Q9(1, 203, ga());
                if (ha() && ua()) {
                    Q9(1, 9, true);
                }
                if (ia() && ua()) {
                    Q9(1, 10, true);
                }
                if (Y9()) {
                    Q9(1, 218, true);
                }
                this.L.setItemClickListenerV3(this.f57859b0);
                if (ba()) {
                    Q9(2, 39, La());
                }
                if (ca() && !L9() && this.f57987h != 1 && !this.K) {
                    Q9(2, 48, La());
                }
                R9(2, 230, Ka(), Ma());
                PhotoParam photoParam = this.f57988i;
                if (photoParam != null && photoParam.ownerUin == 0 && TextUtils.isEmpty(photoParam.albumid)) {
                    return;
                }
                Ha();
                Ua(6, com.qzone.reborn.layer.share.m.J(this.D, this.f57988i));
                Ua(84, com.qzone.reborn.layer.share.m.J(this.D, this.f57988i));
            } catch (Exception e16) {
                RFWLog.e("QZoneFeedxLayerSharePart", RFWLog.USR, e16);
            }
        }
    }

    protected com.qzone.detail.ui.component.g ma() {
        g.a aVar = new g.a();
        aVar.context = getContext();
        return new com.qzone.detail.ui.component.g(aVar);
    }

    protected void na() {
        com.qzone.detail.ui.component.g gVar;
        if (Ja() && (gVar = this.L) != null) {
            try {
                gVar.dismiss();
                this.L.setItemClickListenerV2(null);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    protected void oa() {
        if (this.L != null) {
            try {
                if (getActivity() == null || getActivity().isFinishing()) {
                    return;
                }
                if (B9() != null) {
                    B9().l1();
                }
                this.L.show();
                this.L.setCancelListener(this);
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.w(e16);
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            RFWLog.e("QZoneFeedxLayerSharePart", RFWLog.USR, "[onActivityResult] current data should not be null. error");
            return;
        }
        if (i3 != 37679) {
            if (i3 == 1206) {
                Wa(A9(), intent);
                return;
            }
            return;
        }
        BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO);
        if (businessAlbumInfo != null) {
            n5.d.l().v(businessAlbumInfo);
            return;
        }
        CommonAlbumInfo commonAlbumInfo = (CommonAlbumInfo) intent.getParcelableExtra("SELECTED_ALBUM_INFO");
        if (commonAlbumInfo == null) {
            return;
        }
        BusinessAlbumInfo businessAlbumInfo2 = new BusinessAlbumInfo(commonAlbumInfo.getAlbumId());
        businessAlbumInfo2.mTitle = commonAlbumInfo.getName();
        businessAlbumInfo2.mPrivacy = commonAlbumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType();
        businessAlbumInfo2.mCover = commonAlbumInfo.getCover().l();
        n5.d.l().v(businessAlbumInfo2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.n0n) {
            w1();
            if (B9() != null) {
                B9().R5();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 2541) {
            pa((Bundle) unpack.getData());
        } else if (i3 == 999908) {
            wa(unpack);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f57858a0 = (uk.g) getViewModel(uk.g.class);
        ra(view);
        this.I = (ImageView) view.findViewById(R.id.n0n);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.I, -1);
        this.I.setOnClickListener(this);
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int i3) {
        w1();
        tk.h.S(20L);
        if (B9() != null) {
            B9().x4();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        super.onLayerStateUpdate(rFWLayerState);
        Ta();
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        com.qzone.reborn.layer.share.m mVar = new com.qzone.reborn.layer.share.m(activity);
        this.S = mVar;
        S9(mVar);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        n5.d.l().r(null);
        Ra();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedxLayerSharePart.this.M.set(((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled() && ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWxSupportTimeLine());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qzone.reborn.layer.share.f ta() {
        Ya();
        com.qzone.reborn.layer.share.f fVar = new com.qzone.reborn.layer.share.f();
        fVar.f58180d = this.f57988i;
        fVar.f58179c = this.f57984d;
        fVar.f58177a = this.f57987h;
        fVar.f58178b = this.D;
        fVar.f58182f = this.mCurrentSelectedItem;
        return fVar;
    }

    protected boolean ua() {
        return this.M.get();
    }

    protected void va(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().o1();
        }
        new com.qzone.reborn.layer.share.h(getActivity()).t(ta(), actionSheetItem);
    }

    protected void xa(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().b1(view, getPartRootView());
        }
        new com.qzone.reborn.layer.share.e(getActivity()).t(ta(), actionSheetItem);
    }

    protected void za(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (B9() != null) {
            B9().r2();
        }
        new com.qzone.reborn.layer.share.z(getActivity()).t(ta(), actionSheetItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Na(int i3, int i16, boolean z16) {
        R9(i3, i16, z16, false);
    }

    protected boolean Qa(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        int i3 = actionSheetItem != null ? actionSheetItem.action : 0;
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 11) {
                    if (i3 != 23) {
                        if (i3 == 40) {
                            va(actionSheetItem);
                            na();
                            return true;
                        }
                        if (i3 == 52) {
                            if (B9() != null) {
                                B9().getWord();
                            }
                            new QZoneShareOcrAction(getActivity()).t(ta(), actionSheetItem);
                            na();
                        } else if (i3 != 56) {
                            if (i3 != 84) {
                                if (i3 == 100) {
                                    new com.qzone.reborn.layer.share.r(getActivity()).t(ta(), actionSheetItem);
                                    na();
                                    return true;
                                }
                                if (i3 == 107) {
                                    if (B9() != null) {
                                        B9().x6();
                                    }
                                    new com.qzone.reborn.layer.share.g(getActivity()).t(ta(), actionSheetItem);
                                    na();
                                    return true;
                                }
                            }
                        }
                    }
                    if (B9() != null) {
                        B9().E4();
                    }
                    sa().t(ta(), actionSheetItem);
                    na();
                    return true;
                }
                new com.qzone.reborn.layer.share.w(getActivity()).t(ta(), actionSheetItem);
                return true;
            }
            if (B9() != null) {
                B9().n5();
            }
            this.S.t(ta(), actionSheetItem);
            na();
            return true;
        }
        Da(actionSheetItem);
        return Pa(view, actionSheetItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w1() {
        if (com.qzone.reborn.feedx.util.l.b("QZoneFeedxLayerSharePart", 1000L) || this.H || G9() || !this.J) {
            return;
        }
        if (this.f57984d == null) {
            QLog.e("QZoneFeedxLayerSharePart", 1, "showMoreActionMenu but selectedPhoto is null");
            return;
        }
        if (Ja()) {
            return;
        }
        la();
        PhotoInfo photoInfo = this.f57984d;
        boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_DELETE_BUTTON, 1) == 1;
        if (!Ia(40)) {
            Q9(2, 40, V9(z16));
        }
        ja();
        if (ea()) {
            Q9(1, 100, !L9());
            Ua(100, T9());
        }
        if (da()) {
            Q9(2, 107, !L9());
        }
        if (!Ia(52)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !TextUtils.isEmpty(LoginData.getInstance().getUinString())) {
                String uinString = LoginData.getInstance().getUinString();
                if (!TextUtils.isEmpty(uinString)) {
                    Q9(2, 52, Z9((IOCRService) peekAppRuntime.getRuntimeService(IOCRService.class, ""), uinString));
                }
            } else {
                QLog.w(getTAG(), 1, "uin is null, cannot get IOCRService");
                return;
            }
        }
        if (!Ia(11)) {
            Q9(2, 11, x9());
        }
        if (L9() || this.D == 0 || this.R != 0) {
            Va(6);
            Va(84);
        }
        Ua(2, U9(false));
        Ua(203, U9(false));
        Ua(9, U9(true) && ua());
        Ua(10, U9(true) && ua());
        Ua(6, (photoInfo.photoOpmask & 16) == 0);
        oa();
        if (this.L != null) {
            if (this.T == null) {
                this.T = new c(getContext(), A9());
            }
            this.L.setAdvView(this.T.b(), new RelativeLayout.LayoutParams(-1, -2));
            this.T.d(this.V, this.W, this.X, true ^ L9());
        }
    }

    protected void ra(View view) {
        this.U = (RFWGalleryViewPager) view.findViewById(R.id.f73943ux);
    }

    protected boolean Pa(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (actionSheetItem == null) {
            return false;
        }
        int i3 = actionSheetItem.action;
        this.Z = false;
        if (i3 != 2) {
            if (i3 == 39) {
                za(actionSheetItem);
                na();
                return true;
            }
            if (i3 == 48) {
                if (B9() != null) {
                    B9().V2();
                }
                new com.qzone.reborn.layer.share.aa(getActivity()).t(ta(), actionSheetItem);
                na();
                return true;
            }
            if (i3 == 203) {
                Ca(actionSheetItem);
                return true;
            }
            if (i3 == 218) {
                Ea(actionSheetItem);
                na();
                return true;
            }
            if (i3 == 230) {
                xa(view, actionSheetItem);
                na();
                return true;
            }
            if (i3 == 9) {
                Fa(actionSheetItem);
                na();
                return true;
            }
            if (i3 == 10) {
                Ga(actionSheetItem);
                na();
                return true;
            }
            if (i3 == 72) {
                Ba(actionSheetItem);
                na();
                return true;
            }
            if (i3 != 73) {
                return false;
            }
        }
        Aa(actionSheetItem);
        na();
        return true;
    }

    protected void Ea(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int i3) {
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int i3) {
    }
}

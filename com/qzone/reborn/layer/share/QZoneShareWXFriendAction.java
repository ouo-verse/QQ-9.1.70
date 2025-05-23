package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.util.ToastUtil;
import com.qzone.util.ad;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import oo.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneShareWXFriendAction extends c {

    /* renamed from: k, reason: collision with root package name */
    private WeChatForwardHandler f58156k;

    /* renamed from: l, reason: collision with root package name */
    IQzoneShareApi.WXShareListener f58157l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class WeChatForwardHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneShareWXFriendAction> f58158a;

        WeChatForwardHandler(QZoneShareWXFriendAction qZoneShareWXFriendAction) {
            this.f58158a = new WeakReference<>(qZoneShareWXFriendAction);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.o(R.string.gk7, 4);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                ToastUtil.o(R.string.gk6, 4);
            } else {
                if (!(message.obj instanceof String) || this.f58158a.get() == null) {
                    return;
                }
                final String str = (String) message.obj;
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareWXFriendAction.WeChatForwardHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] i16 = com.qzone.util.image.c.i(str);
                        if (WeChatForwardHandler.this.f58158a.get() != null) {
                            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(((QZoneShareWXFriendAction) WeChatForwardHandler.this.f58158a.get()).f58157l);
                        }
                        if (WeChatForwardHandler.this.f58158a.get() != null && ((QZoneShareWXFriendAction) WeChatForwardHandler.this.f58158a.get()).W() && QZoneShareWXFriendAction.O()) {
                            ShareUtils.r(((QZoneShareWXFriendAction) WeChatForwardHandler.this.f58158a.get()).n(), 9, ShareUtils.d.a(((QZoneShareWXFriendAction) WeChatForwardHandler.this.f58158a.get()).f58109d, ((QZoneShareWXFriendAction) WeChatForwardHandler.this.f58158a.get()).f58110e, com.qzone.util.image.c.u(str)), 1);
                        } else {
                            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str, i16, 0);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements IQzoneShareApi.WXShareListener {
        b() {
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            int i3 = baseResp.errCode;
            if (i3 == 0) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShared", "\u5df2\u5206\u4eab"), 5);
            } else if (i3 != -2) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShareFail", ShareJsPlugin.ERRMSG_INVITE_REQUIRE), 4);
            }
        }
    }

    public QZoneShareWXFriendAction(Activity activity) {
        super(activity);
        this.f58157l = new b();
    }

    static /* bridge */ /* synthetic */ boolean O() {
        return X();
    }

    private void R(f fVar) {
        if (J()) {
            M();
            return;
        }
        int x16 = tk.h.x(fVar.f58179c, fVar.f58180d);
        if (x16 == 0 || x16 == 4) {
            T(fVar);
        }
    }

    private void S(Bundle bundle) {
        String string = bundle.getString("url", "");
        String string2 = bundle.getString("mini_id", "");
        String string3 = bundle.getString("mini_path", "");
        String string4 = bundle.getString("mini_title", "");
        boolean a16 = ShareUtils.a(string2, string3);
        PhotoInfo photoInfo = this.f58109d;
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = photoInfo.shareTitle;
        gVar.f44742c = photoInfo.shareSummary;
        gVar.f44743d = photoInfo.sharePhotoUrl;
        gVar.f44740a = string;
        Activity n3 = n();
        if (X() && a16) {
            gVar = ShareUtils.d.b(photoInfo, string2, string3, string4);
        }
        ShareUtils.r(n3, 9, gVar, (X() && a16) ? 1 : 0);
    }

    private void T(f fVar) {
        String str;
        long j3;
        PhotoInfo photoInfo = fVar.f58179c;
        HashMap<Integer, String> hashMap = new HashMap<>(1);
        if (photoInfo.videoflag == 1) {
            hashMap.put(1, photoInfo.videodata.videoUrl.url);
            hashMap.put(11, "1");
        }
        PhotoParam photoParam = fVar.f58180d;
        if (photoInfo.appid != 311) {
            QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
            QZoneInteractPhotoRequestBuilder ugcType = new QZoneInteractPhotoRequestBuilder().setAppId(4).setUgcType(3);
            if (TextUtils.isEmpty(photoInfo.pssCellId)) {
                str = photoInfo.albumId;
            } else {
                str = photoInfo.pssCellId;
            }
            QZoneInteractPhotoRequestBuilder iisShareTo = ugcType.setCellId(str).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(null).setIisShareTo(3);
            if (photoParam != null) {
                j3 = photoParam.ownerUin;
            } else {
                j3 = photoInfo.uploaduin;
            }
            qZoneFeedxPictureManager.getOutShareUrl(iisShareTo.setOwnerUin(j3).setShareScene(2).setExtraInfoMap(hashMap), r());
        } else {
            Q(photoInfo, photoParam, hashMap);
        }
        B(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    private static boolean X() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SETTING_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM, 1) == 1;
    }

    public void P() {
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        if (iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportTimeLine()) {
            LpReportInfo_pf00064.report(301, 8, 3);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("photo/");
            if (this.f58156k == null) {
                this.f58156k = new WeChatForwardHandler(this);
            }
            f(5, sDKPrivatePath, this.f58156k);
            return;
        }
        ToastUtil.n(R.string.gjq);
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(n());
    }

    protected boolean U() {
        return true;
    }

    protected boolean V() {
        return true;
    }

    protected boolean W() {
        return true;
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    protected void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (fVar.f58179c.isVideo()) {
            R(fVar);
        } else if (oo.b.l() && V() && !fVar.f58179c.isSrUrl) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f58109d.downloadUrl);
            oo.b.f(null, 1, arrayList, new a());
        } else {
            P();
        }
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "30", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.c, com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        super.x(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000069 && U()) {
            P();
        }
    }

    @Override // com.qzone.reborn.layer.share.c
    protected void L(Bundle bundle) {
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "QZoneShareWXFriendAction", " handleGetShareUrlResult rsp:", bundle.toString());
        S(bundle);
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "30", true);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{9};
    }

    protected void Q(PhotoInfo photoInfo, PhotoParam photoParam, HashMap<Integer, String> hashMap) {
        if (photoInfo == null || photoParam == null) {
            return;
        }
        String str = photoParam.cell_id;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(photoInfo.pssCellId)) {
                str = photoInfo.albumId;
            } else {
                str = photoInfo.pssCellId;
            }
        }
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder iisShareTo = new QZoneInteractPhotoRequestBuilder().setAppId(photoInfo.appid).setUgcType(3).setCellId(str).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(null).setIisShareTo(3);
        long j3 = photoParam.ownerUin;
        if (j3 == 0) {
            j3 = photoInfo.uploaduin;
        }
        qZoneFeedxPictureManager.getOutShareUrl(iisShareTo.setOwnerUin(j3).setShareScene(2).setExtraInfoMap(hashMap), r());
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements b.InterfaceC10931b {
        a() {
        }

        @Override // oo.b.InterfaceC10931b
        public void a(ArrayList<String> arrayList) {
            com.qzone.util.ad.f59766a.d(arrayList, new C0486a());
        }

        /* compiled from: P */
        /* renamed from: com.qzone.reborn.layer.share.QZoneShareWXFriendAction$a$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        class C0486a implements ad.a {
            C0486a() {
            }

            @Override // com.qzone.util.ad.a
            public void a(String str, String str2) {
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str2, com.qzone.util.image.c.i(str2), 0);
            }

            @Override // com.qzone.util.ad.a
            public void b(String str) {
            }
        }
    }
}

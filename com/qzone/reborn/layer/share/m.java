package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.reborn.event.QZoneFavorStateChangeEvent;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import g5.a;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m extends QZoneBaseShareAction {

    /* renamed from: j, reason: collision with root package name */
    private boolean f58193j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Boolean> f58194k;

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, Boolean> f58195l;

    public m(Activity activity) {
        super(activity);
        this.f58194k = new ConcurrentHashMap();
        this.f58195l = new ConcurrentHashMap();
    }

    private void K(QZoneResult qZoneResult) {
        String str = (String) qZoneResult.getData();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneShareFavoriteAction", 4, "add,key=" + str);
        }
        U(str);
        if (qZoneResult.getSucceed()) {
            QfavHelper.B(n(), LoginData.getInstance().getUinString(), true, null, false);
            return;
        }
        X(str);
        if (TextUtils.isEmpty(qZoneResult.getMessage())) {
            return;
        }
        ToastUtil.s(qZoneResult.getMessage(), 4);
    }

    private void L(QZoneResult qZoneResult) {
        String str = (String) qZoneResult.getData();
        U(str);
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneShareFavoriteAction", 4, "del,key=" + str);
        }
        if (qZoneResult.getSucceed()) {
            ToastUtil.s(n().getString(R.string.gfr), 5);
            return;
        }
        X(str);
        if (TextUtils.isEmpty(qZoneResult.getMessage())) {
            return;
        }
        ToastUtil.s(qZoneResult.getMessage(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(String str, String str2, boolean z16) {
        if (!NetworkState.isNetSupport()) {
            if (!z16) {
                ToastUtil.n(R.string.ger);
                return;
            } else {
                ToastUtil.o(R.string.gex, 4);
                return;
            }
        }
        if (!M(str)) {
            ToastUtil.o(R.string.gfq, 4);
            return;
        }
        V(!z16, r());
        T(new QzoneFavoriteService.d() { // from class: com.qzone.reborn.layer.share.k
            @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
            public final void a(String str3, boolean z17) {
                m.N(str3, z17);
            }
        }, str, true);
        this.f58193j = !z16;
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "3", true);
    }

    private void R(final QzoneFavoriteService.d dVar, final String str) {
        g5.a.b(new a.b() { // from class: com.qzone.reborn.layer.share.l
            @Override // g5.a.b
            public final void onResult(boolean z16, Bundle bundle) {
                m.this.P(dVar, str, z16, bundle);
            }
        }, str);
    }

    private void T(QzoneFavoriteService.d dVar, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            dVar.a(null, false);
            return;
        }
        Boolean bool = this.f58194k.get(str);
        if (bool != null && z16) {
            boolean z17 = !bool.booleanValue();
            this.f58194k.put(str, Boolean.valueOf(z17));
            dVar.a(null, z17);
        } else if (bool != null) {
            dVar.a(null, bool.booleanValue());
        } else {
            R(dVar, str);
        }
    }

    public void I(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f58195l.put(str, Boolean.FALSE);
    }

    public boolean M(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = this.f58195l.get(str)) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void S(QzoneFavoriteService.d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            dVar.a(null, false);
        } else {
            R(dVar, str);
        }
    }

    public void U(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f58195l.put(str, Boolean.TRUE);
    }

    public void V(boolean z16, Handler handler) {
        ArrayList<String> arrayList;
        String str;
        PhotoParam photoParam = this.f58110e;
        if (photoParam == null) {
            return;
        }
        long j3 = photoParam.subid;
        String str2 = photoParam.ugcKey;
        String str3 = photoParam.cell_id;
        String str4 = photoParam.cell_subId;
        if (photoParam.appid == 4) {
            arrayList = new ArrayList<>();
            PhotoInfo photoInfo = this.f58109d;
            str4 = "";
            if (photoInfo != null) {
                if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
                    str = photoInfo.bigUrl;
                } else {
                    str = photoInfo.currentUrl;
                }
                if (z16) {
                    arrayList.add(str);
                }
                if (!com.qzone.preview.d.c(this.f58109d, this.f58110e)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f58110e.ownerUin);
                    sb5.append("_");
                    PhotoParam photoParam2 = this.f58110e;
                    sb5.append(photoParam2.mFromRecent ? 4 : photoParam2.appid);
                    sb5.append("_");
                    sb5.append(this.f58110e.albumid);
                    sb5.append("_");
                    sb5.append(photoInfo.lloc);
                    str2 = sb5.toString();
                }
            }
            str3 = "";
        } else {
            arrayList = null;
        }
        I(str2);
        if (z16) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzonePictureViewer", 2, "ugckey=" + str2 + ",owner=" + this.f58110e.ownerUin + ",appid=" + this.f58110e.appid + ",subid=" + j3 + ",cellid=" + str3 + ",sid=" + str4);
            }
            QZoneFeedxPictureManager.getInstance().addFavor(new QZoneInteractPhotoRequestBuilder().setOwnerUin(this.f58110e.ownerUin).setAppId(this.f58110e.appid).setSubId(j3).setCellId(str3).setCellSubId(str4).setUgcKey(str2).setExtendMap(null).setPhotoUrlList(arrayList), handler);
            return;
        }
        QZoneFeedxPictureManager.getInstance().deleteFavor(new QZoneInteractPhotoRequestBuilder().setOwnerUin(this.f58110e.ownerUin).setUgcKey(str2).setAppId(this.f58110e.appid).setSubId(j3), handler);
    }

    public void W(String str, boolean z16) {
        this.f58194k.put(str, Boolean.valueOf(z16));
        this.f58193j = z16;
    }

    public void X(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g5.a.b(new a.b() { // from class: com.qzone.reborn.layer.share.j
            @Override // g5.a.b
            public final void onResult(boolean z16, Bundle bundle) {
                m.this.Q(str, z16, bundle);
            }
        }, str);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        final String b16 = com.qzone.preview.d.b(fVar.f58179c, fVar.f58180d);
        T(new QzoneFavoriteService.d() { // from class: com.qzone.reborn.layer.share.i
            @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
            public final void a(String str, boolean z16) {
                m.this.O(b16, str, z16);
            }
        }, b16, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 1000028) {
            K(unpack);
        } else if (i3 == 1000029) {
            L(unpack);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{6, 84};
    }

    public static boolean J(int i3, PhotoParam photoParam) {
        if (i3 != 0 && photoParam != null && photoParam.canAddFavor && photoParam.appid != 7035) {
            return true;
        }
        if (!QZLog.isDevelopLevel()) {
            return false;
        }
        QZLog.d("QzonePictureViewer", 4, "photoParam=" + photoParam);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(QzoneFavoriteService.d dVar, String str, boolean z16, Bundle bundle) {
        if (z16 && bundle != null) {
            String string = bundle.getString("rsp_fav_id");
            if (!TextUtils.isEmpty(string)) {
                dVar.a(string, true);
                this.f58194k.put(str, Boolean.TRUE);
                SimpleEventBus.getInstance().dispatchEvent(new QZoneFavorStateChangeEvent(true));
                return;
            }
        }
        dVar.a(null, false);
        this.f58194k.put(str, Boolean.FALSE);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFavorStateChangeEvent(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(String str, boolean z16, Bundle bundle) {
        if (z16 && bundle != null && !TextUtils.isEmpty(bundle.getString("rsp_fav_id"))) {
            this.f58194k.put(str, Boolean.TRUE);
        }
        this.f58194k.put(str, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(String str, boolean z16) {
    }
}

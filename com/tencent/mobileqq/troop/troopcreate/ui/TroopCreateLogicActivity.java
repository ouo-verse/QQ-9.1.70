package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qzonehub.api.IQzoneShareApi;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreateLogicActivity extends QBaseActivity implements ITroopCreateInfoService.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    ITroopCreateService f300124a0;

    /* renamed from: b0, reason: collision with root package name */
    TroopInfoData f300125b0;

    /* renamed from: c0, reason: collision with root package name */
    AppInterface f300126c0;

    /* renamed from: d0, reason: collision with root package name */
    ITroopShareUtility f300127d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f300128e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f300129f0;

    /* renamed from: g0, reason: collision with root package name */
    ICreateTroopShare f300130g0;

    /* renamed from: h0, reason: collision with root package name */
    IWXShareHelperListener f300131h0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements IWXShareHelperListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCreateLogicActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener
        public void onWXShareResp(WXShareRsp wXShareRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) wXShareRsp);
                return;
            }
            String str = TroopCreateLogicActivity.this.f300129f0;
            if (str != null && str.equals(wXShareRsp.transaction)) {
                if (wXShareRsp.errCode == ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_OK()) {
                    QQToast.makeText(BaseApplication.getContext(), 2, R.string.hj9, 1).show();
                } else if (wXShareRsp.errCode != ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_USER_CANCEL()) {
                    QQToast.makeText(BaseApplication.getContext(), 2, R.string.hit, 1).show();
                }
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).removeObserver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f300133a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f300134b;

        b(long j3, String str) {
            this.f300133a = j3;
            this.f300134b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCreateLogicActivity.this, Long.valueOf(j3), str);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopCreateLogicActivity.this.Q2(this.f300133a, i3, this.f300134b);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f300136a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f300137b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f300138c;

        c(String str, String str2, String str3) {
            this.f300136a = str;
            this.f300137b = str2;
            this.f300138c = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCreateLogicActivity.this, str, str2, str3);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.g
        public void a(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            } else {
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).addObserver(TroopCreateLogicActivity.this.f300131h0);
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).shareTroopToWXFriend(TroopCreateLogicActivity.this.f300129f0, this.f300136a, bitmap, this.f300137b, this.f300138c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f300140a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f300141b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f300142c;

        d(String str, String str2, String str3) {
            this.f300140a = str;
            this.f300141b = str2;
            this.f300142c = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCreateLogicActivity.this, str, str2, str3);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.g
        public void a(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            } else {
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).addObserver(TroopCreateLogicActivity.this.f300131h0);
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).shareTroopToWXFriendCircle(TroopCreateLogicActivity.this.f300129f0, this.f300140a, bitmap, this.f300141b, this.f300142c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f300144d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f300145e;

        e(URLDrawable uRLDrawable, g gVar) {
            this.f300144d = uRLDrawable;
            this.f300145e = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCreateLogicActivity.this, uRLDrawable, gVar);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            } else {
                this.f300145e.a(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else {
                this.f300145e.a(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else {
                this.f300145e.a(BaseImageUtil.drawabletoBitmapV2(this.f300144d, 100, 100));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements URLDrawable.DownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f300147d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f300148e;

        f(URLDrawable uRLDrawable, g gVar) {
            this.f300147d = uRLDrawable;
            this.f300148e = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCreateLogicActivity.this, uRLDrawable, gVar);
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f300148e.a(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.f300148e.a(BaseImageUtil.drawabletoBitmapV2(this.f300147d, 100, 100));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface g {
        void a(Bitmap bitmap);
    }

    public TroopCreateLogicActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f300124a0 = null;
        this.f300125b0 = new TroopInfoData();
        this.f300128e0 = false;
        this.f300129f0 = null;
        this.f300131h0 = new a();
    }

    private void G2() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("chanelId", -1);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            if (intExtra != 0) {
                if (intExtra != 1) {
                    if (intExtra != 2) {
                        if (intExtra != 3) {
                            QLog.e("qqBaseActivity", 1, "unrecognized channel! shareChanel = " + intExtra);
                            finish();
                        } else {
                            S2(jSONObject);
                        }
                    } else {
                        V2(jSONObject);
                    }
                } else {
                    U2(jSONObject);
                }
            } else {
                T2(jSONObject);
            }
        } catch (Exception e16) {
            QLog.e("qqBaseActivity", 1, "commonShare failed! exception = ", e16);
        }
    }

    private void I2(long j3, String str) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopLocation(String.valueOf(j3), str, this, new b(j3, str));
    }

    private void K2(String str, g gVar) {
        if (gVar != null && !TextUtils.isEmpty(str)) {
            URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
            drawable.setURLDrawableListener(new e(drawable, gVar));
            drawable.setDownloadListener(new f(drawable, gVar));
            if (drawable.getStatus() == 1) {
                gVar.a(BaseImageUtil.drawabletoBitmapV2(drawable, 100, 100));
            } else {
                drawable.startDownload();
            }
        }
    }

    private void N2() {
        if (getIntent() != null) {
            this.f300130g0.miniAppShareQQDirectly(getIntent(), this);
        }
    }

    private void P2() {
        if (getIntent() != null) {
            this.f300130g0.miniAppShareQQDirectlyWithOutDialog(getIntent(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(long j3, int i3, String str) {
        int i16;
        int i17;
        String[] split = str.split("\\|");
        if (split.length == 4) {
            i16 = (int) (Float.parseFloat(split[1]) * 1000000.0f);
            i17 = (int) (Float.parseFloat(split[2]) * 1000000.0f);
        } else {
            i16 = 0;
            i17 = 0;
        }
        Intent intent = new Intent();
        intent.putExtra("troopUin", j3);
        intent.putExtra("errCode", i3);
        intent.putExtra("isClear", TextUtils.isEmpty(str));
        intent.putExtra("location", str);
        intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, i16);
        intent.putExtra("lon", i17);
        setResult(-1, intent);
        finish();
    }

    private void S2(JSONObject jSONObject) {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            QQToast.makeText(this, 1, R.string.f171139ci4, 1).show();
            return;
        }
        this.f300129f0 = String.valueOf(System.currentTimeMillis());
        String optString = jSONObject.optString("shareLink");
        K2(jSONObject.optString("shareIcon"), new d(jSONObject.optString("shareTitle"), jSONObject.optString("shareDesc"), optString));
        finish();
    }

    private void T2(JSONObject jSONObject) {
        this.f300130g0.ShareToQQ(jSONObject, this);
    }

    private void U2(JSONObject jSONObject) {
        String optString = jSONObject.optString("shareLink");
        String optString2 = jSONObject.optString("shareTitle");
        String optString3 = jSONObject.optString("shareDesc");
        String optString4 = jSONObject.optString("shareIcon");
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(optString4)) {
            arrayList.add(optString4);
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", optString2);
        bundle.putString("desc", optString3);
        bundle.putLong("req_share_id", 0L);
        bundle.putString("detail_url", optString);
        bundle.putString("url", optString);
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putString(AppConstants.Key.SHARE_REQ_BIZNAME, "SharePlato");
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(this.mRuntime.getCurrentAccountUin(), this, bundle, (DialogInterface.OnDismissListener) null, 1001);
    }

    private void V2(JSONObject jSONObject) {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            QQToast.makeText(this, 1, R.string.f171139ci4, 1).show();
            return;
        }
        this.f300129f0 = String.valueOf(System.currentTimeMillis());
        String optString = jSONObject.optString("shareLink");
        K2(jSONObject.optString("shareIcon"), new c(jSONObject.optString("shareTitle"), jSONObject.optString("shareDesc"), optString));
        finish();
    }

    public void H2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("qqBaseActivity", 4, "[createTroop] cfg:" + str);
        }
        if (this.f300124a0 != null) {
            ((ITroopCreateInfoService) this.f300126c0.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(str, 5);
            this.f300124a0.createTroop(this, this);
        }
    }

    public void J2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        ITroopCreateService iTroopCreateService = this.f300124a0;
        if (iTroopCreateService != null) {
            iTroopCreateService.terminateLogic();
        }
        TextUtils.isEmpty(str);
        finish();
    }

    public void L2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            finish();
            return;
        }
        String str2 = "";
        ITroopInfoService iTroopInfoService = (ITroopInfoService) this.f300126c0.getRuntimeService(ITroopInfoService.class, "");
        if (iTroopInfoService == null) {
            finish();
            return;
        }
        TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(str);
        if (findTroopInfo == null) {
            finish();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(findTroopInfo.mRichFingerMemo)) {
                str2 = new QQText(findTroopInfo.mRichFingerMemo, 11).toPlainText();
            }
            jSONObject.put("classify", findTroopInfo.dwGroupClassExt);
            jSONObject.put("name", findTroopInfo.troopname);
            jSONObject.put("introduction", str2);
            jSONObject.put("location", findTroopInfo.strLocation);
            jSONObject.put("percentage", "1.0");
            Intent intent = new Intent();
            intent.putExtra("modifiedInfo", jSONObject.toString());
            setResult(-1, intent);
            finish();
        } catch (JSONException e16) {
            e16.printStackTrace();
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M2(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        String str3 = "";
        boolean z16 = false;
        if (this.f300126c0 == null || TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("troopUin");
                try {
                    str3 = jSONObject.getString("groupName");
                    if (Long.parseLong(string) > 0) {
                        z16 = true;
                    }
                    str3 = string;
                    str2 = str3;
                } catch (NumberFormatException e16) {
                    e = e16;
                    String str4 = str3;
                    str3 = string;
                    str2 = str4;
                    e.printStackTrace();
                    if (z16) {
                    }
                    finish();
                } catch (JSONException e17) {
                    e = e17;
                    String str5 = str3;
                    str3 = string;
                    str2 = str5;
                    e.printStackTrace();
                    if (z16) {
                    }
                    finish();
                }
            } catch (NumberFormatException e18) {
                e = e18;
                str2 = "";
            } catch (JSONException e19) {
                e = e19;
                str2 = "";
            }
        }
        if (z16) {
            TroopInfo troopInfo = new TroopInfo(str3);
            troopInfo.troopname = str2;
            troopInfo.Administrator = this.f300126c0.getCurrentAccountUin();
            ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).saveTroopInCache(troopInfo);
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R2(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (this.f300126c0 != null && !TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).getString("troopUin");
            } catch (JSONException e16) {
                e = e16;
                str2 = "";
            }
            try {
                if (Long.parseLong(str2) <= 0) {
                    finish();
                    return;
                }
            } catch (JSONException e17) {
                e = e17;
                finish();
                e.printStackTrace();
                if (!TextUtils.isEmpty(str2)) {
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                finish();
                return;
            }
            this.f300125b0.troopUin = str2;
            ITroopInfoService iTroopInfoService = (ITroopInfoService) this.f300126c0.getRuntimeService(ITroopInfoService.class, "");
            if (iTroopInfoService != null) {
                TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(str2);
                if (findTroopInfo != null) {
                    this.f300125b0.updateForTroopChatSetting(findTroopInfo, getResources(), this.f300126c0.getCurrentAccountUin());
                    this.f300125b0.isMember = true;
                }
                if (this.f300127d0 == null) {
                    this.f300127d0 = (ITroopShareUtility) QRoute.api(ITroopShareUtility.class);
                }
                this.f300127d0.initTroopShareUtility(this, this.f300125b0);
                this.f300127d0.handleTroopLinkShare(this.f300125b0);
                return;
            }
            return;
        }
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 3) {
            if (i3 != 1001) {
                if (i3 == 1002) {
                    if (i16 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES);
                        String stringExtra = intent.getStringExtra("uin");
                        ITroopCreateForStructMsg iTroopCreateForStructMsg = (ITroopCreateForStructMsg) QRoute.api(ITroopCreateForStructMsg.class);
                        if (iTroopCreateForStructMsg == null) {
                            QLog.e("qqBaseActivity", 2, "friendUin = " + stringExtra + " structMsg == null ");
                            return;
                        }
                        iTroopCreateForStructMsg.setAbsStructMsgFromByte(byteArrayExtra);
                        int intExtra = intent.getIntExtra("uintype", -1);
                        if (!TextUtils.isEmpty(stringExtra)) {
                            iTroopCreateForStructMsg.sendStructingMsg(this.f300126c0, stringExtra, intExtra, null);
                        } else {
                            QLog.e("qqBaseActivity", 2, "friendUin == null structMsg=" + iTroopCreateForStructMsg);
                        }
                    }
                    finish();
                }
            } else {
                finish();
            }
        } else {
            if (i16 == -1) {
                QQToast.makeText(this, 2, getString(R.string.e08), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                byte[] byteArrayExtra2 = intent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES);
                ITroopCreateForStructMsg iTroopCreateForStructMsg2 = (ITroopCreateForStructMsg) QRoute.api(ITroopCreateForStructMsg.class);
                iTroopCreateForStructMsg2.setAbsStructMsgFromByte(byteArrayExtra2);
                if (!iTroopCreateForStructMsg2.instanceofImgaeShare()) {
                    iTroopCreateForStructMsg2.sendStructingMsg(this.f300126c0, intent.getStringExtra("uin"), intent.getIntExtra("uintype", -1), null);
                    iTroopCreateForStructMsg2.onDestroy();
                }
            }
            this.f300128e0 = false;
            finish();
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f300126c0 = (AppInterface) getAppRuntime();
        this.f300124a0 = (ITroopCreateService) this.mRuntime.getRuntimeService(ITroopCreateService.class, "");
        this.f300130g0 = (ICreateTroopShare) this.f300126c0.getRuntimeService(ICreateTroopShare.class, "");
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("type", -1);
        if (intExtra == 1) {
            H2(intent.getStringExtra("cfg"));
        } else if (intExtra == 2) {
            J2(intent.getStringExtra("troop_uin"));
        } else if (intExtra == 3) {
            R2(intent.getStringExtra("cfg"));
        } else if (intExtra == 4) {
            L2(intent.getStringExtra("troop_uin"));
        } else if (intExtra == 5) {
            I2(intent.getLongExtra("troop_uin", 0L), intent.getStringExtra("troop_location"));
        } else if (intExtra == 6) {
            if (this.f300124a0 == null) {
                finish();
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("has_head", ((ITroopCreateInfoService) this.f300126c0.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo().hasTroopHead);
                setResult(-1, intent2);
                finish();
            }
        } else if (intExtra == 7) {
            M2(intent.getStringExtra("cfg"));
        } else if (intExtra == 8) {
            G2();
        } else if (intExtra == 9) {
            N2();
        } else if (intExtra == 10) {
            P2();
        } else {
            finish();
        }
        be.a("TroopCreateLogicActivity", "" + intExtra);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f300124a0 = null;
        ITroopShareUtility iTroopShareUtility = this.f300127d0;
        if (iTroopShareUtility != null) {
            iTroopShareUtility.onDestroy();
            this.f300127d0 = null;
        }
        ICreateTroopShare iCreateTroopShare = this.f300130g0;
        if (iCreateTroopShare != null) {
            iCreateTroopShare.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (this.f300128e0) {
                return;
            }
            super.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onCreateTroopCompletely(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("retCode", i3);
        intent.putExtra("troopUin", str);
        intent.putExtra("errMsg", str2);
        setResult(-1, intent);
        finish();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onInviteComplete(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onReusedTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
    }
}

package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxBannerManager implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static DownloadParams.DecodeHandler C;

    /* renamed from: i, reason: collision with root package name */
    private static int f185407i;

    /* renamed from: m, reason: collision with root package name */
    private static int f185408m;

    /* renamed from: d, reason: collision with root package name */
    private View f185409d;

    /* renamed from: e, reason: collision with root package name */
    private View f185410e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f185411f;

    /* renamed from: h, reason: collision with root package name */
    private p f185412h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<GameMsgBoxBannerManager> f185413d;

        public a(GameMsgBoxBannerManager gameMsgBoxBannerManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gameMsgBoxBannerManager);
            } else {
                this.f185413d = new WeakReference<>(gameMsgBoxBannerManager);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), getAdsRsp);
                return;
            }
            QLog.i("GameMsgBoxBannerManager", 1, "[onGetAdvs], result:" + z16);
            GameMsgBoxBannerManager gameMsgBoxBannerManager = this.f185413d.get();
            if (gameMsgBoxBannerManager != null) {
                if (z16 && getAdsRsp != null) {
                    gameMsgBoxBannerManager.i(getAdsRsp);
                } else {
                    QLog.i("GameMsgBoxBannerManager", 1, "param is error.");
                    gameMsgBoxBannerManager.p();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f185407i = 0;
        f185408m = 0;
        C = new DownloadParams.DecodeHandler() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.q
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap m3;
                m3 = GameMsgBoxBannerManager.m(downloadParams, bitmap);
                return m3;
            }
        };
    }

    public GameMsgBoxBannerManager(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        View inflate = View.inflate(context, R.layout.ean, null);
        this.f185409d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.vjh);
        this.f185411f = linearLayout;
        linearLayout.setVisibility(8);
        f185407i = (int) com.tencent.mobileqq.utils.al.a(this.f185409d.getContext(), 24.0f);
        f185408m = (int) com.tencent.mobileqq.utils.al.a(this.f185409d.getContext(), 20.0f);
        x(context, ThemeUtil.isNowThemeIsNight(qQAppInterface, false, null));
    }

    private String g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return new JSONObject(str).optString("msg_id");
        } catch (Throwable th5) {
            QLog.e("GameMsgBoxBannerManager", 1, th5, new Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<TianShuAdPosItemData> h() {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = com.tencent.luggage.wxa.gf.f.CTRL_INDEX;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        try {
            if (getAdsRsp.mapAds.has()) {
                list = getAdsRsp.mapAds.get();
            } else {
                list = null;
            }
            if (list != null && list.size() != 0) {
                TianShuAccess.RspEntry rspEntry = list.get(0);
                if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
                    List<TianShuAccess.AdItem> list2 = pBRepeatMessageField.get();
                    if (list2 != null && list2.size() != 0) {
                        j(list2.get(0));
                        return;
                    }
                    QLog.i("GameMsgBoxBannerManager", 1, "no ads item~");
                    p();
                    return;
                }
                QLog.i("GameMsgBoxBannerManager", 1, "ads resp param is error.");
                p();
                return;
            }
            p();
        } catch (Throwable th5) {
            p();
            QLog.e("GameMsgBoxBannerManager", 1, "[handleGetAdvCallback], error happens! " + th5.getMessage());
        }
    }

    private void j(TianShuAccess.AdItem adItem) {
        try {
            QLog.i("GameMsgBoxBannerManager", 1, "[handleSingleAdItem]");
            if (adItem == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                hashMap.put(mapEntry.key.get(), mapEntry.value.get());
            }
            String str = (String) hashMap.get("pic");
            String str2 = (String) hashMap.get("text");
            String str3 = (String) hashMap.get("url");
            String str4 = (String) hashMap.get("busi_id");
            int parseInt = Integer.parseInt((String) hashMap.get("type"));
            p pVar = new p();
            this.f185412h = pVar;
            pVar.f185551c = str;
            pVar.f185552d = str2;
            pVar.f185553e = str3;
            pVar.f185555g = str4;
            pVar.f185550b = parseInt;
            pVar.f185549a = String.valueOf(adItem.iAdId.get());
            this.f185412h.f185554f = g(str4);
            this.f185412h.f185556h = adItem.traceinfo.get();
            QLog.i("GameMsgBoxBannerManager", 1, "avatarUrl:" + str + ",wording:" + str2 + ",busInf:" + str4 + ",jumpUrl:" + str3 + ",type:" + parseInt + ",reportId:" + this.f185412h.f185554f);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.s
                @Override // java.lang.Runnable
                public final void run() {
                    GameMsgBoxBannerManager.this.k();
                }
            });
            ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(HippyQQConstants.ModuleName.QQ_GAME_CENTER, "game_msg_box", null);
        } catch (Throwable th5) {
            p();
            QLog.e("GameMsgBoxBannerManager", 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        y(this.f185412h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        try {
            NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter = (NTChatRecyclerViewWithHeaderFooter) this.f185410e.findViewById(R.id.tug);
            if (nTChatRecyclerViewWithHeaderFooter != null) {
                nTChatRecyclerViewWithHeaderFooter.E(f());
                this.f185409d = null;
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgBoxBannerManager", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bitmap m(DownloadParams downloadParams, Bitmap bitmap) {
        QLog.i("GameMsgBoxBannerManager", 1, "[ROUND_FACE_DECODER]");
        if (bitmap == null) {
            return null;
        }
        float f16 = f185408m;
        int i3 = f185407i;
        return BaseImageUtil.getRoundedCornerBitmap(bitmap, f16, i3, i3);
    }

    private boolean n(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    private boolean o(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    private static void q(int i3, String str, String str2) {
        String str3;
        QLog.d("GameMsgBoxBannerManager", 1, "report2Tianshu action:", Integer.valueOf(i3), ", itemId=", str, ",traceInfo=", str2);
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            str3 = "";
        } else {
            str3 = runtime.getAccount();
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str3 + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE;
        tianShuReportData.mPageId = QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE;
        tianShuReportData.mItemId = str;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = str2;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    private void r() {
        if (this.f185412h == null) {
            return;
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92045", "209161", this.f185412h.f185554f, "", "20", "");
        p pVar = this.f185412h;
        q(102, pVar.f185549a, pVar.f185556h);
    }

    private void s() {
        if (this.f185412h == null) {
            return;
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92045", "209160", this.f185412h.f185554f, "", "8", "");
        p pVar = this.f185412h;
        q(101, pVar.f185549a, pVar.f185556h);
    }

    private void u() {
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((LinearLayout) this.f185409d.findViewById(R.id.yob)).getLayoutParams();
            layoutParams.height = (int) com.tencent.mobileqq.utils.al.a(this.f185409d.getContext(), 40.0f);
            int a16 = (int) com.tencent.mobileqq.utils.al.a(this.f185409d.getContext(), 12.0f);
            layoutParams.topMargin = a16;
            layoutParams.bottomMargin = a16;
        } catch (Throwable th5) {
            QLog.e("GameMsgBoxBannerManager", 1, "[setBannerHeight]:" + th5);
        }
    }

    private void v(Context context, String str, String str2, String str3, int i3) {
        try {
            GradientDrawable gradientDrawable = (GradientDrawable) context.getDrawable(R.drawable.mun);
            gradientDrawable.setColor(Color.parseColor(str));
            ((LinearLayout) this.f185409d.findViewById(R.id.yob)).setBackgroundDrawable(gradientDrawable);
            ((TextView) this.f185409d.findViewById(R.id.f109436ft)).setTextColor(Color.parseColor(str2));
            ((ImageView) this.f185409d.findViewById(R.id.dtx)).setImageDrawable(context.getResources().getDrawable(i3));
            this.f185411f.setBackgroundColor(Color.parseColor(str3));
        } catch (Throwable th5) {
            QLog.e("GameMsgBoxBannerManager", 1, th5, new Object[0]);
        }
    }

    private void x(Context context, boolean z16) {
        if (z16) {
            v(context, "#FF1C1D1E", "#FF8E8E93", "#000000", R.drawable.skin_icon_arrow_right_normal);
        } else {
            v(context, "#FF28B9FF", "#FFFFFFFF", "#FFFFFFFF", R.drawable.mum);
        }
    }

    private void y(p pVar) {
        View view;
        if (pVar != null && (view = this.f185409d) != null) {
            view.setOnClickListener(this);
            u();
            ImageView imageView = (ImageView) this.f185409d.findViewById(R.id.dvn);
            TextView textView = (TextView) this.f185409d.findViewById(R.id.f109436ft);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = (int) com.tencent.mobileqq.utils.al.a(this.f185409d.getContext(), 24.0f);
            obtain.mRequestHeight = (int) com.tencent.mobileqq.utils.al.a(this.f185409d.getContext(), 24.0f);
            Drawable drawable = this.f185409d.getContext().getResources().getDrawable(R.drawable.f160830com);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(pVar.f185551c, obtain);
            drawable2.setDecodeHandler(C);
            drawable2.startDownload();
            imageView.setImageDrawable(drawable2);
            if (!TextUtils.isEmpty(pVar.f185552d)) {
                textView.setText(pVar.f185552d);
            }
            this.f185411f.setVisibility(0);
            QLog.i("GameMsgBoxBannerManager", 1, "[showBanner] ends");
            s();
        }
    }

    public View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f185409d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (this.f185412h != null && view.getId() == R.id.vjh) {
            p();
            QLog.i("GameMsgBoxBannerManager", 1, "jumpType:" + this.f185412h.f185550b);
            int i3 = this.f185412h.f185550b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        QLog.w("GameMsgBoxBannerManager", 1, "invalid jump type.");
                    } else {
                        o(this.f185411f.getContext(), this.f185412h.f185553e);
                    }
                } else {
                    n(this.f185411f.getContext(), this.f185412h.f185553e);
                }
                r();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.r
                @Override // java.lang.Runnable
                public final void run() {
                    GameMsgBoxBannerManager.this.l();
                }
            });
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.i("GameMsgBoxBannerManager", 1, "[requestAdv]");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxBannerManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameMsgBoxBannerManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TianShuManager.getInstance().requestAdv(GameMsgBoxBannerManager.this.h(), new a(GameMsgBoxBannerManager.this));
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 128, null, true);
        }
    }

    public void w(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            this.f185410e = view;
        }
    }
}

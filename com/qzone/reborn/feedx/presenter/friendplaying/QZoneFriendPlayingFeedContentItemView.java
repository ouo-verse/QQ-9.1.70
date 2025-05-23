package com.qzone.reborn.feedx.presenter.friendplaying;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.module.feedcomponent.extend.AlphaGradientProcessor;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.am;
import com.qzone.widget.AsyncImageView;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameQfsSubscribe;

/* loaded from: classes37.dex */
public class QZoneFriendPlayingFeedContentItemView extends QZoneBaseWidgetView<PicText> implements View.OnClickListener, WadlTrpcListener {
    private TextView C;
    private TextView D;
    private Activity E;
    private int F;
    private final HashSet<String> G;

    /* renamed from: e, reason: collision with root package name */
    private BusinessFeedData f55633e;

    /* renamed from: f, reason: collision with root package name */
    private PicText f55634f;

    /* renamed from: h, reason: collision with root package name */
    private AsyncImageView f55635h;

    /* renamed from: i, reason: collision with root package name */
    private AsyncImageView f55636i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f55637m;

    public QZoneFriendPlayingFeedContentItemView(Context context) {
        super(context);
        this.G = new HashSet<>();
        q0();
    }

    private void A0() {
        PicText picText = this.f55634f;
        if (picText == null) {
            return;
        }
        this.f55637m.setText(picText.title);
    }

    private void B0() {
        PicText picText = this.f55634f;
        if (picText == null) {
            return;
        }
        this.C.setText(picText.summary);
    }

    private JSONObject o0() {
        JSONObject jSONObject = new JSONObject();
        PicText picText = this.f55634f;
        if (picText == null || am.h(picText.extraInfo)) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.f55634f.extraInfo);
        } catch (JSONException e16) {
            QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "get extra info exception:", e16);
            return jSONObject;
        }
    }

    private void p0() {
        PicText picText;
        if (this.E != null && (picText = this.f55634f) != null) {
            if (TextUtils.isEmpty(picText.actionUrl)) {
                QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "actionUrl is null");
                return;
            }
            if (s0()) {
                String optString = o0().optString("pkg_name");
                if (((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).hasGameInstall(optString)) {
                    QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "game has installed:", optString);
                    PackageUtil.startAppWithPkgName(this.E, optString, null, "biz_src_zf_games", 0);
                    w0("205992");
                    w0("914342");
                    return;
                }
                QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "game is not installed:", optString);
            }
            gh.c.c(this.E, this.f55633e, new com.qzone.proxy.feedcomponent.model.e(this.f55634f.actionUrl, "", this.F));
            v0("pg_click");
            w0("914342");
            return;
        }
        QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "mActivity is null");
    }

    private void q0() {
        this.E = i.c(this);
        this.f55635h = (AsyncImageView) findViewById(R.id.n2n);
        this.f55636i = (AsyncImageView) findViewById(R.id.n2o);
        this.f55637m = (TextView) findViewById(R.id.n2p);
        this.C = (TextView) findViewById(R.id.n_1);
        this.D = (TextView) findViewById(R.id.n9f);
        this.f55636i.setOnClickListener(this);
        this.f55637m.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.f55635h.setCornerRadius(8.0f);
        this.f55636i.setCornerRadius(8.0f);
        this.G.add(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
    }

    private boolean r0() {
        return o0().optInt("game_type") == 1;
    }

    private boolean s0() {
        return o0().optInt("game_type") == 1 && o0().optInt("online_status") == 3;
    }

    private void u0(Intent intent, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        PBBytesField pBBytesField;
        String stringExtra = intent.getStringExtra("appid");
        QLog.i("QZoneFriendPlayingFeedContentItemView", 1, "onQuerySubscribeRsp appId: " + stringExtra);
        if (this.f55634f != null && TextUtils.equals(o0().optString("app_id"), stringExtra)) {
            if (trpcInovkeRsp != null && (pBBytesField = trpcInovkeRsp.data) != null && pBBytesField.get() != null) {
                try {
                    QQGameQfsSubscribe.GetUserGameStatusRsp getUserGameStatusRsp = new QQGameQfsSubscribe.GetUserGameStatusRsp();
                    getUserGameStatusRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    final int i3 = getUserGameStatusRsp.result.get();
                    QLog.i("QZoneFriendPlayingFeedContentItemView", 1, "subscribeStatus: " + i3);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.friendplaying.QZoneFriendPlayingFeedContentItemView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i16 = i3;
                            if (i16 == 2) {
                                QZoneFriendPlayingFeedContentItemView.this.y0(HardCodeUtil.qqStr(R.string.f1334465));
                            } else if (i16 == 3) {
                                QZoneFriendPlayingFeedContentItemView.this.y0(HardCodeUtil.qqStr(R.string.f132904o));
                            }
                        }
                    });
                    return;
                } catch (Exception e16) {
                    QLog.e("QZoneFriendPlayingFeedContentItemView", 1, e16, new Object[0]);
                    return;
                }
            }
            QLog.i("QZoneFriendPlayingFeedContentItemView", 1, "rsp.data.get() == null");
        }
    }

    private void v0(String str) {
        int optInt = o0().optInt("game_type");
        String optString = o0().optString("app_id");
        if (optInt != 4) {
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQzoneFeed(optString, "2009", "2009_222", null, "page_view", str, "qzone_friends_playing", this.f55633e.cellGameRecommend.f50337c);
    }

    private void w0(String str) {
        String str2;
        int optInt = o0().optInt("game_type");
        String optString = o0().optString("app_id");
        if (str == "914341") {
            str2 = "8";
        } else {
            str2 = "20";
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087);
        wadlReportBuilder.setBussinessId("5").setPageId("1092").setOperModule("9404").setModuleType("940403");
        if ("205992".equals(str)) {
            wadlReportBuilder.setExtSubModule("940402");
        }
        wadlReportBuilder.setGameAppId(optString).setOperId(str);
        wadlReportBuilder.setExt(4, str2).setExt(6, String.valueOf(optInt)).setExt(45, l6.d.a(optInt));
        wadlReportBuilder.report();
    }

    private void x0() {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        PicText picText = this.f55634f;
        if (picText == null || (pictureItem = picText.pictureItem) == null || (pictureUrl = pictureItem.currentUrl) == null) {
            return;
        }
        if (TextUtils.isEmpty(pictureUrl.url)) {
            QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "game background url is null");
            return;
        }
        this.f55635h.setAsyncImageProcessor(new AlphaGradientProcessor());
        AsyncImageView asyncImageView = this.f55635h;
        PictureUrl pictureUrl2 = this.f55634f.pictureItem.currentUrl;
        asyncImageView.setAsyncImage(pictureUrl2.imageUrl, pictureUrl2.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.D.setText(str);
        if (TextUtils.equals(str, HardCodeUtil.qqStr(R.string.f1334465))) {
            this.f55634f.descBeforeClick = HardCodeUtil.qqStr(R.string.f1334465);
            this.D.setTextColor(Color.parseColor("#80FFFFFF"));
            this.D.setBackgroundResource(R.drawable.f15013_);
            return;
        }
        this.D.setTextColor(Color.parseColor("#FFFFFF"));
        this.D.setBackgroundResource(R.drawable.f150039);
    }

    private void z0() {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        PicText picText = this.f55634f;
        if (picText == null || (pictureItem = picText.pictureItem) == null || (pictureUrl = pictureItem.currentUrl) == null) {
            return;
        }
        if (TextUtils.isEmpty(pictureUrl.url)) {
            QLog.e("QZoneFriendPlayingFeedContentItemView", 1, "game logo url is null");
            return;
        }
        AsyncImageView asyncImageView = this.f55636i;
        PictureUrl pictureUrl2 = this.f55634f.pictureItem.currentUrl;
        asyncImageView.setAsyncImage(pictureUrl2.imageUrl, pictureUrl2.url);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return this.G;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167269c32;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        v0("expo");
        w0("914341");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.n2o /* 1745225034 */:
            case R.id.n2p /* 1745225035 */:
            case R.id.n_1 /* 1745225306 */:
                LpReportInfo_pf00064.allReport(619, 19, 2, (String) null, "2");
                p0();
                break;
            case R.id.n9f /* 1745225284 */:
                LpReportInfo_pf00064.allReport(619, 19, 3, (String) null, "2");
                p0();
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDestroy() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
    }

    public void onResume() {
        if (r0()) {
            String optString = o0().optString("app_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("appid", optString);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).querySubscribeStatus(optString, "10035116", bundle);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS.equals(str)) {
            try {
                if (j3 == 0 && trpcInovkeRsp != null) {
                    u0(intent, trpcInovkeRsp);
                } else {
                    QLog.w("QZoneFriendPlayingFeedContentItemView", 1, "rsp errors!");
                }
            } catch (Throwable th5) {
                QLog.e("QZoneFriendPlayingFeedContentItemView", 1, th5, new Object[0]);
            }
        }
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.f55633e = businessFeedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(PicText picText, int i3) {
        if (picText == null) {
            return;
        }
        if (picText == this.f55634f && i3 == this.F) {
            return;
        }
        this.F = i3;
        this.f55634f = picText;
        x0();
        z0();
        A0();
        y0(picText.descBeforeClick);
        B0();
    }
}

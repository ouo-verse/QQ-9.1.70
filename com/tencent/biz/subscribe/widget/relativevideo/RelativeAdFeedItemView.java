package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.vac_adv_get;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RelativeAdFeedItemView extends BaseWidgetView<CertifiedAccountMeta$StFeed> implements View.OnClickListener, View.OnLongClickListener {
    private RelativeLayout E;
    private AsyncRichTextView F;
    private TextView G;
    private TextView H;
    private RoundCornerImageView I;
    private Set<String> J;
    private SquareImageView K;
    private int L;
    private Drawable M;
    private View N;
    private ImageView P;
    private ActionSheet Q;
    private CertifiedAccountMeta$StFeed R;
    private vac_adv_get.VacFeedsAdvMetaInfo S;
    private a T;
    private boolean U;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void k(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed);
    }

    public RelativeAdFeedItemView(@NonNull Context context) {
        super(context);
        this.J = new HashSet();
        this.L = ImmersiveUtils.getScreenWidth() / 2;
        this.M = getResources().getDrawable(R.drawable.f160830com);
    }

    private void t() {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        if (this.S == null) {
            return;
        }
        try {
            GdtHandler.Params params = new GdtHandler.Params();
            params.processId = 1;
            if (getContext() instanceof Activity) {
                params.activity = new WeakReference<>((Activity) getContext());
            }
            params.f108486ad = new GdtAd(this.S.adv_rsp);
            params.reportForClick = true;
            params.appAutoDownload = true;
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.S.adv_rsp;
            if (adInfo != null && (displayInfo = adInfo.display_info) != null && displayInfo.creative_size.get() == 185) {
                params.videoCeilingSupportedIfNotInstalled = true;
                params.videoCeilingSupportedIfInstalled = true;
            }
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_renzhenghao");
            params.extra = bundle;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c7b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.m6b) {
            t();
        } else if (id5 == R.id.m5h) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.R;
            if (certifiedAccountMeta$StFeed != null && certifiedAccountMeta$StFeed.adBuffer.has() && (aVar = this.T) != null) {
                aVar.k(this.R);
                vac_adv_get.VacFeedsAdvMetaInfo vacFeedsAdvMetaInfo = this.S;
                if (vacFeedsAdvMetaInfo != null && (adInfo = vacFeedsAdvMetaInfo.adv_rsp) != null && (reportInfo = adInfo.report_info) != null && !TextUtils.isEmpty(reportInfo.negative_feedback_url.get())) {
                    SubscribeUtils.s(this.S.adv_rsp.report_info.negative_feedback_url.get().replace("__ACT_TYPE__", "2001"));
                }
            }
            this.Q.cancel();
        } else if (id5 == R.id.f166371lx0) {
            PBRepeatMessageField<vac_adv_get.DropList> pBRepeatMessageField = this.S.droplist;
            if (pBRepeatMessageField != null) {
                for (vac_adv_get.DropList dropList : pBRepeatMessageField.get()) {
                    PBEnumField pBEnumField = dropList.action_type;
                    if (pBEnumField != null && pBEnumField.get() == 1) {
                        com.tencent.biz.subscribe.d.l(dropList.jumpurl.get());
                    }
                }
            }
            this.Q.cancel();
        } else if (id5 == R.id.cancel) {
            this.Q.cancel();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        u();
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.F = (AsyncRichTextView) findViewById(R.id.mck);
        this.G = (TextView) findViewById(R.id.mbu);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.lnn);
        this.I = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(4.0f));
        this.K = (SquareImageView) findViewById(R.id.ln7);
        this.H = (TextView) findViewById(R.id.mcf);
        this.N = findViewById(R.id.f166123lr2);
        this.P = (ImageView) findViewById(R.id.f165898ln1);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.m6b);
        this.E = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.E.setOnLongClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    @RequiresApi(api = 8)
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        float f16;
        if (certifiedAccountMeta$StFeed != null && certifiedAccountMeta$StFeed.adBuffer.has()) {
            this.R = certifiedAccountMeta$StFeed;
            try {
                vac_adv_get.VacFeedsAdvMetaInfo vacFeedsAdvMetaInfo = new vac_adv_get.VacFeedsAdvMetaInfo();
                this.S = vacFeedsAdvMetaInfo;
                vacFeedsAdvMetaInfo.mergeFrom(certifiedAccountMeta$StFeed.adBuffer.get().toByteArray());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            vac_adv_get.VacFeedsAdvMetaInfo vacFeedsAdvMetaInfo2 = this.S;
            if (vacFeedsAdvMetaInfo2 == null) {
                return;
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = vacFeedsAdvMetaInfo2.adv_rsp;
            if (adInfo2 != null && (displayInfo = adInfo2.display_info) != null) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = displayInfo.basic_info;
                if (basicInfo != null) {
                    if (basicInfo.pic_width.get() >= this.S.adv_rsp.display_info.basic_info.pic_height.get()) {
                        f16 = 0.5625f;
                    } else {
                        f16 = 1.7777778f;
                    }
                    this.I.getLayoutParams().height = (int) (this.L * f16);
                    this.I.getLayoutParams().width = this.L;
                    this.I.requestLayout();
                    this.F.setText(this.S.adv_rsp.display_info.basic_info.txt.get());
                    String str = this.S.adv_rsp.display_info.basic_info.img.get();
                    if (!TextUtils.isEmpty(str)) {
                        com.tencent.biz.subscribe.a.e(str, this.I);
                    }
                }
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo advertiserInfo = this.S.adv_rsp.display_info.advertiser_info;
                if (advertiserInfo != null) {
                    this.G.setText(advertiserInfo.corporate_image_name.get());
                    com.tencent.biz.subscribe.a.e(this.S.adv_rsp.display_info.advertiser_info.corporate_logo.get(), this.K);
                }
                if (this.S.adv_rsp.display_info.creative_size.get() != 185 && this.S.adv_rsp.display_info.creative_size.get() != 585) {
                    this.H.setVisibility(8);
                } else {
                    qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo = this.S.adv_rsp.display_info.video_info;
                    if (videoInfo != null) {
                        this.H.setText(String.format("%02d:%02d", Integer.valueOf(videoInfo.media_duration.get() / 60), Integer.valueOf(this.S.adv_rsp.display_info.video_info.media_duration.get() % 60)));
                    }
                    this.H.setVisibility(0);
                }
            }
            vac_adv_get.VacFeedsAdvMetaInfo vacFeedsAdvMetaInfo3 = this.S;
            if (vacFeedsAdvMetaInfo3 != null && (adInfo = vacFeedsAdvMetaInfo3.adv_rsp) != null && (reportInfo = adInfo.report_info) != null && !TextUtils.isEmpty(reportInfo.exposure_url.get()) && !this.J.contains(this.S.adv_rsp.report_info.exposure_url.get())) {
                SubscribeUtils.s(this.S.adv_rsp.report_info.exposure_url.get());
                this.J.add(this.S.adv_rsp.report_info.exposure_url.get());
            }
            if (this.U) {
                this.K.setFilterColor(1711276032);
                this.I.setColorFilter(1711276032);
                this.F.setTextColor(-5723992);
                this.G.setTextColor(-10132123);
                this.H.setTextColor(-5723992);
                this.H.setBackgroundDrawable(getResources().getDrawable(R.drawable.hli));
            }
        }
    }

    public void setIsInNightMode(boolean z16) {
        this.U = z16;
    }

    public void u() {
        if (this.Q == null) {
            this.Q = ActionSheet.createMenuSheet(getContext());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.c7a, (ViewGroup) null);
            viewGroup.findViewById(R.id.m5h).setOnClickListener(this);
            viewGroup.findViewById(R.id.f166371lx0).setOnClickListener(this);
            viewGroup.findViewById(R.id.cancel).setOnClickListener(this);
            this.Q.setActionContentView(viewGroup, null);
        }
        this.Q.show();
    }

    public RelativeAdFeedItemView(Context context, a aVar) {
        super(context);
        this.J = new HashSet();
        this.L = ImmersiveUtils.getScreenWidth() / 2;
        this.M = getResources().getDrawable(R.drawable.f160830com);
        this.T = aVar;
    }
}

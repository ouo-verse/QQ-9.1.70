package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b;
import com.tencent.mobileqq.guild.discoveryv2.content.util.DeleteRecommendData;
import com.tencent.mobileqq.guild.discoveryv2.util.ExtKt;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rh1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u001cB\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0016J*\u0010\u0016\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001aH\u0016R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010&R\u001a\u0010,\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/f;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/p;", "Lrh1/e$a;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/b;", "", "event", "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "onThemeChanged", "data", "", "position", "", "", "payload", "u", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", tl.h.F, "", DomainData.DOMAIN_NAME, "a", "l", "b", "g", NodeProps.VISIBLE, "onVisibleChanged", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mContainer", "Lrh1/e;", "Lrh1/e;", "mCardAd", "i", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "()I", "playPriority", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends av<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p> implements e.a, CardAdView.b, b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private rh1.e mCardAd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String type = "Ad";

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(String event) {
        GdtAd adInfo;
        int i3;
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p pVar = (com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p) this.mData;
        if (pVar != null && (adInfo = pVar.getAdInfo()) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i16 = 2;
            if (adInfo.isContractAd()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            linkedHashMap.put("sgrp_ad_type", Integer.valueOf(i3));
            linkedHashMap.put("sgrp_ad_space_id", String.valueOf(adInfo.getPosId()));
            linkedHashMap.put("sgrp_ad_id", String.valueOf(adInfo.getAId()));
            if (adInfo.getInnerShowType() != 3 && adInfo.getInnerShowType() != 4) {
                i16 = 1;
            }
            linkedHashMap.put("sgrp_ad_content_type", Integer.valueOf(i16));
            linkedHashMap.put("sgrp_ad_trace_id", String.valueOf(adInfo.getTraceId()));
            linkedHashMap.put("sgrp_rank", Integer.valueOf(this.mPosition));
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            ViewGroup viewGroup = this.mContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup = null;
            }
            iGuildDTReportApi.reportDtEventManual(viewGroup, event, "clck", linkedHashMap);
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public boolean a() {
        rh1.e eVar = this.mCardAd;
        if (eVar != null) {
            eVar.e();
        }
        VideoReport.unbindVideoPlayerInfo(getRootView());
        return true;
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.b
    public void b() {
        QLog.d("RecommendAdSection", 1, "feedback onOpenDialog");
        v("em_sgrp_ad_card_content_feedback");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rh1.e.a
    public void f() {
        GdtAd adInfo;
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p pVar = (com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p) this.mData;
        if (pVar != null && (adInfo = pVar.getAdInfo()) != null) {
            q().getMessage().h(new RecommendAdMessage(0L, adInfo.getAId()));
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.b
    public void g() {
        QLog.d("RecommendAdSection", 1, "feedback onHideAd");
        if (this.mData != 0) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            simpleEventBus.dispatchEvent(new DeleteRecommendData((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData));
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    @NotNull
    public String getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // rh1.e.a
    public void h() {
        v("em_sgrp_ad_card");
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public int i() {
        return this.mPosition;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public void l() {
        b.a.a(this);
        rh1.e eVar = this.mCardAd;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public boolean n() {
        View f16;
        GdtAd adInfo;
        Map<String, ?> mapOf;
        rh1.e eVar = this.mCardAd;
        if (eVar == null || (f16 = eVar.f()) == null) {
            return false;
        }
        if (ExtKt.c(f16) <= 0.5d) {
            a();
            return false;
        }
        if (!eVar.a()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("tryPlay: not video ad");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("RecommendAdSection", 1, (String) it.next(), null);
            }
            a();
            return false;
        }
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p pVar = (com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p) this.mData;
        if (pVar == null || (adInfo = pVar.getAdInfo()) == null) {
            return false;
        }
        View rootView = getRootView();
        VideoEntity.Builder videoDuration = new VideoEntity.Builder().setContentId(adInfo.getTraceId()).setContentType(1).setPage((Object) ci1.a.c()).setVideoView(getRootView()).setVideoDuration(adInfo.getVideoDuration());
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_eid", RecommendReportHelperKt.b((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, ((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p) this.mData).getRecommendExtData().getTraceId()), TuplesKt.to("sgrp_rank", Integer.valueOf(this.mPosition)), TuplesKt.to("sgrp_video_id", adInfo.getTraceId()));
        VideoReport.bindVideoPlayerInfo(rootView, videoDuration.addCustomParams(mapOf).build());
        rh1.e eVar2 = this.mCardAd;
        if (eVar2 != null) {
            eVar2.d();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.av, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        rh1.e eVar = this.mCardAd;
        if (eVar != null) {
            eVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        ViewGroup viewGroup;
        if (containerView != null) {
            viewGroup = (ViewGroup) containerView.findViewById(R.id.w5b);
        } else {
            viewGroup = null;
        }
        Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mContainer = viewGroup;
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            viewGroup = null;
        }
        viewGroup.invalidate();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        if (visible) {
            q().g().a(this);
        } else {
            q().g().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p data, int position, @Nullable List<Object> payload) {
        GdtAd adInfo;
        if (data != null && (adInfo = data.getAdInfo()) != null) {
            rh1.e eVar = this.mCardAd;
            if (eVar != null && eVar != null) {
                eVar.b();
            }
            ViewGroup viewGroup = this.mContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup = null;
            }
            this.mCardAd = new rh1.e(viewGroup, adInfo, position, this, this);
            q().getMessage().h(new RecommendAdMessage(adInfo.getAId(), 0L));
        }
    }
}

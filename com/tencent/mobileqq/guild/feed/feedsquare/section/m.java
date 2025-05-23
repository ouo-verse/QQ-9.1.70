package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareFeedRefreshEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareFeedScrollEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareFeedVideoPlayingEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCardPosAdvertise;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 J2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J*\u0010\u0019\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000eH\u0014J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(`)H\u0016R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010@\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/m;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "adByteArray", "", "position", "", "c0", "", "b0", "W", "d0", "Landroid/view/View;", "view", "", "videoEvent", "Z", "X", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "", "payload", "M", "", "a0", "", "getViewStubLayoutId", "containerView", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mContainer", "Luj1/e;", "f", "Luj1/e;", "mCardAd", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRecommendCardPosAdvertise;", tl.h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRecommendCardPosAdvertise;", "mAdData", "Lij1/g;", "i", "Lij1/g;", "mBlockData", "Lon1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lon1/a;", "mGameCardAd", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "mReportMap", "D", "Ljava/lang/String;", "mPageId", "", "E", "mPageParams", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends GuildFeedSquareFeedBaseSection implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> mReportMap = new LinkedHashMap();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mPageId = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> mPageParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private uj1.e mCardAd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProRecommendCardPosAdvertise mAdData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ij1.g mBlockData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private on1.a mGameCardAd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/m$b", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "", "b", "g", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements CardAdView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.b
        public void b() {
            uj1.e eVar = m.this.mCardAd;
            if (eVar != null) {
                eVar.p();
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView.b
        public void g() {
            QLog.d("GuildFeedSquareFeedAdSection", 1, "feedback onHideAd");
            m.this.d0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/m$c", "Lon1/d;", "", "onClose", "onVideoStart", "onVideoStop", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements on1.d {
        c() {
        }

        @Override // on1.d
        public void onClose() {
            QLog.d("GuildFeedSquareFeedAdSection", 1, "gamecenter card onHideAd");
            m.this.d0();
        }

        @Override // on1.d
        public void onVideoStart() {
            QLog.d("GuildFeedSquareFeedAdSection", 1, "gamecenter onVideoStart");
            m mVar = m.this;
            ViewGroup viewGroup = mVar.mContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup = null;
            }
            mVar.Z(viewGroup, "dt_video_start");
        }

        @Override // on1.d
        public void onVideoStop() {
            m mVar = m.this;
            ViewGroup viewGroup = mVar.mContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup = null;
            }
            mVar.Z(viewGroup, "dt_video_end");
            QLog.d("GuildFeedSquareFeedAdSection", 1, "gamecenter onVideoStop");
        }
    }

    public m() {
        Map<String, ? extends Object> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.mPageParams = emptyMap;
    }

    private final void W(byte[] adByteArray, int position) {
        if (adByteArray == null) {
            return;
        }
        if (this.mCardAd != null && b0(adByteArray)) {
            QLog.e("GuildFeedSquareFeedAdSection", 1, "addAmsAdView error: mCardAd exist");
            return;
        }
        QLog.d("GuildFeedSquareFeedAdSection", 1, "addAmsAdView");
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            viewGroup = null;
        }
        uj1.e eVar = new uj1.e(viewGroup, adByteArray, position, a0(), new b());
        this.mCardAd = eVar;
        eVar.q(this.mPageId, this.mPageParams);
    }

    private final void X() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.l
            @Override // java.lang.Runnable
            public final void run() {
                m.Y(m.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        uj1.e eVar = this$0.mCardAd;
        if (eVar != null) {
            eVar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(View view, String videoEvent) {
        String str;
        String str2;
        String str3;
        GuildFeedBaseInitBean initBean;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.mReportMap);
        linkedHashMap.put("sgrp_eid", "em_sgrp_feed_section_ad");
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise = this.mAdData;
        String str4 = null;
        if (gProRecommendCardPosAdvertise != null) {
            str = gProRecommendCardPosAdvertise.traceId;
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = "";
        }
        linkedHashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, str);
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise2 = this.mAdData;
        if (gProRecommendCardPosAdvertise2 != null) {
            str2 = gProRecommendCardPosAdvertise2.traceId;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("sgrp_video_id", str2);
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise3 = this.mAdData;
        if (gProRecommendCardPosAdvertise3 != null) {
            str3 = gProRecommendCardPosAdvertise3.traceId;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENTID, str3);
        linkedHashMap.put(DTParamKey.REPORT_KEY_VIDEO_CONTENT_TYPE, "1");
        xj1.c u16 = u();
        if (u16 != null && (initBean = u16.getInitBean()) != null) {
            str4 = initBean.getChannelId();
        }
        if (str4 != null) {
            str5 = str4;
        }
        linkedHashMap.put("sgrp_channel_id", str5);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_feed_section_ad", this.mPageId, "", videoEvent, linkedHashMap, this.mPageParams);
    }

    private final boolean b0(byte[] adByteArray) {
        String traceId;
        uj1.e eVar;
        String n3;
        GdtAd r16 = uj1.d.f439072a.r(adByteArray);
        if (r16 == null || (traceId = r16.getTraceId()) == null || (eVar = this.mCardAd) == null || (n3 = eVar.n()) == null || TextUtils.isEmpty(n3) || !TextUtils.equals(traceId, n3)) {
            return false;
        }
        QLog.d("GuildFeedSquareFeedAdSection", 1, "isSameAd");
        return true;
    }

    private final void c0(byte[] adByteArray, int position) {
        String str;
        ViewGroup viewGroup;
        QLog.d("GuildFeedSquareFeedAdSection", 1, "onBindDataForGameCenterAd position=" + position + " mGameCardAd=" + this.mGameCardAd + " adByteArray=" + adByteArray);
        if (adByteArray == null) {
            return;
        }
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise = this.mAdData;
        if (gProRecommendCardPosAdvertise != null) {
            str = gProRecommendCardPosAdvertise.traceId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = str;
        on1.a aVar = this.mGameCardAd;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (Intrinsics.areEqual(str2, aVar.getMTraceId())) {
                QLog.d("GuildFeedSquareFeedAdSection", 1, "onBindDataForGameCenterAd mGameCardAd onDisplayChanged()");
                on1.a aVar2 = this.mGameCardAd;
                Intrinsics.checkNotNull(aVar2);
                aVar2.c();
                return;
            }
            on1.a aVar3 = this.mGameCardAd;
            Intrinsics.checkNotNull(aVar3);
            aVar3.b();
            QLog.d("GuildFeedSquareFeedAdSection", 1, "onBindDataForGameCenterAd mGameCardAd onDestroy()");
        }
        ViewGroup viewGroup2 = this.mContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            viewGroup = null;
        } else {
            viewGroup = viewGroup2;
        }
        this.mGameCardAd = new on1.a(str2, viewGroup, adByteArray, a0(), position, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        GuildFeedBaseInitBean guildFeedBaseInitBean;
        String str;
        String str2;
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        xj1.c u16 = u();
        String str3 = null;
        if (u16 != null) {
            guildFeedBaseInitBean = u16.getInitBean();
        } else {
            guildFeedBaseInitBean = null;
        }
        if (guildFeedBaseInitBean != null) {
            str = guildFeedBaseInitBean.getGuildId();
        } else {
            str = null;
        }
        QLog.e("GuildFeedSquareFeedAdSection", 4, "removeFeed " + D + " guildId" + str);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str4 = D.idd;
        if (guildFeedBaseInitBean != null) {
            str2 = guildFeedBaseInitBean.getGuildId();
        } else {
            str2 = null;
        }
        String str5 = "0";
        if (str2 == null) {
            str2 = "0";
        }
        if (guildFeedBaseInitBean != null) {
            str3 = guildFeedBaseInitBean.getChannelId();
        }
        if (str3 != null) {
            str5 = str3;
        }
        simpleEventBus.dispatchEvent(new GuildFeedDeleteEvent(str4, str2, str5));
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ij1.g blockData;
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise;
        Integer num;
        QLog.d("GuildFeedSquareFeedAdSection", 1, "onBindDataReally");
        if (data != null && (blockData = data.getBlockData()) != null) {
            this.mBlockData = blockData;
            Object d16 = blockData.d(blockData.m());
            byte[] bArr = null;
            if (d16 instanceof GProRecommendCardPosAdvertise) {
                gProRecommendCardPosAdvertise = (GProRecommendCardPosAdvertise) d16;
            } else {
                gProRecommendCardPosAdvertise = null;
            }
            if (gProRecommendCardPosAdvertise == null) {
                return;
            }
            this.mAdData = gProRecommendCardPosAdvertise;
            this.mPageId = ci1.a.c();
            this.mPageParams = ci1.a.d();
            GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise2 = this.mAdData;
            if (gProRecommendCardPosAdvertise2 != null) {
                num = Integer.valueOf(gProRecommendCardPosAdvertise2.adContentType);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise3 = this.mAdData;
                if (gProRecommendCardPosAdvertise3 != null) {
                    bArr = gProRecommendCardPosAdvertise3.adContent;
                }
                W(bArr, position);
                return;
            }
            if (num != null && num.intValue() == 2) {
                GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise4 = this.mAdData;
                if (gProRecommendCardPosAdvertise4 != null) {
                    bArr = gProRecommendCardPosAdvertise4.adContent;
                }
                c0(bArr, position);
            }
        }
    }

    @NotNull
    public final Map<String, String> a0() {
        String str;
        String str2;
        String str3;
        String str4;
        Long l3;
        String str5;
        String str6;
        String str7;
        String num;
        GuildFeedBaseInitBean initBean;
        GuildFeedBaseInitBean initBean2;
        xj1.c u16 = u();
        String str8 = null;
        if (u16 != null && (initBean2 = u16.getInitBean()) != null) {
            str = initBean2.getGuildId();
        } else {
            str = null;
        }
        String str9 = "";
        if (str == null) {
            str = "";
        }
        xj1.c u17 = u();
        if (u17 != null && (initBean = u17.getInitBean()) != null) {
            str2 = initBean.getChannelId();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(str);
        if (guildInfo != null) {
            str3 = guildInfo.getCreatorId();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise = this.mAdData;
        if (gProRecommendCardPosAdvertise != null) {
            str4 = gProRecommendCardPosAdvertise.traceId;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        }
        if (gProRecommendCardPosAdvertise != null) {
            l3 = Long.valueOf(gProRecommendCardPosAdvertise.adId);
        } else {
            l3 = null;
        }
        String valueOf = String.valueOf(l3);
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise2 = this.mAdData;
        if (gProRecommendCardPosAdvertise2 != null) {
            str8 = gProRecommendCardPosAdvertise2.traceInfo;
        }
        if (str8 == null) {
            str8 = "";
        }
        this.mReportMap.put("guild_id", str);
        this.mReportMap.put(INetChannelCallback.KEY_TINY_ID, str3);
        this.mReportMap.put("trace_id", str4);
        this.mReportMap.put("ad_id", valueOf);
        this.mReportMap.put("trace_info", str8);
        this.mReportMap.put("channel_id", str2);
        this.mReportMap.put("sgrp_ad_id", valueOf);
        this.mReportMap.put("sgrp_rank", String.valueOf(this.mPosition));
        this.mReportMap.put("sgrp_ad_trace_id", str4);
        Map<String, String> map = this.mReportMap;
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise3 = this.mAdData;
        if (gProRecommendCardPosAdvertise3 == null || (str5 = Integer.valueOf(gProRecommendCardPosAdvertise3.adType).toString()) == null) {
            str5 = "";
        }
        map.put("sgrp_ad_content_type", str5);
        Map<String, String> map2 = this.mReportMap;
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise4 = this.mAdData;
        if (gProRecommendCardPosAdvertise4 == null || (str6 = Integer.valueOf(gProRecommendCardPosAdvertise4.providerId).toString()) == null) {
            str6 = "";
        }
        map2.put("sgrp_provider_id", str6);
        Map<String, String> map3 = this.mReportMap;
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise5 = this.mAdData;
        if (gProRecommendCardPosAdvertise5 == null || (str7 = Integer.valueOf(gProRecommendCardPosAdvertise5.adContentType).toString()) == null) {
            str7 = "";
        }
        map3.put("sgrp_ad_source", str7);
        Map<String, String> map4 = this.mReportMap;
        GProRecommendCardPosAdvertise gProRecommendCardPosAdvertise6 = this.mAdData;
        if (gProRecommendCardPosAdvertise6 != null && (num = Integer.valueOf(gProRecommendCardPosAdvertise6.providerPriority).toString()) != null) {
            str9 = num;
        }
        map4.put("sgrp_provider_manual_rank", str9);
        return this.mReportMap;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedSquareFeedScrollEvent.class, GuildFeedSquareFeedRefreshEvent.class, GuildFeedSquareFeedVideoPlayingEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w9u};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            SimpleEventBus.getInstance().registerReceiver(this);
            X();
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        uj1.e eVar = this.mCardAd;
        if (eVar != null) {
            eVar.o();
        }
        on1.a aVar = this.mGameCardAd;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w9t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d_feed_item_ad_container)");
        this.mContainer = (ViewGroup) findViewById;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedSquareFeedScrollEvent) {
            QLog.d("GuildFeedSquareFeedAdSection", 1, "scroll checkExpoAndAutoPlay");
            uj1.e eVar = this.mCardAd;
            if (eVar != null) {
                eVar.l();
            }
        }
        if (event instanceof GuildFeedSquareFeedRefreshEvent) {
            QLog.d("GuildFeedSquareFeedAdSection", 1, "refresh checkExpoAndAutoPlay");
            X();
        }
        if (event instanceof GuildFeedSquareFeedVideoPlayingEvent) {
            if (((GuildFeedSquareFeedVideoPlayingEvent) event).getIsPlaying()) {
                uj1.e eVar2 = this.mCardAd;
                if (eVar2 != null) {
                    eVar2.r();
                    return;
                }
                return;
            }
            uj1.e eVar3 = this.mCardAd;
            if (eVar3 != null) {
                eVar3.l();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        on1.a aVar = this.mGameCardAd;
        if (aVar != null) {
            aVar.d(visible);
        }
    }
}

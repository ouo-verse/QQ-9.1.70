package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedPayloadType;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareLiveRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareMediaRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedRecommendCardUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedRecommendCardMorePanelHelper;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCard;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zp1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rJ*\u0010\u0016\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J*\u0010\u0017\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H&J6\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J&\u0010\"\u001a\u00020\u001a2\u001c\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dj\u0002` 0\u001cH\u0014J\u001e\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011J\b\u0010(\u001a\u00020\u001aH\u0004J\b\u0010)\u001a\u0004\u0018\u00010#J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140*H\u0016J\u0010\u0010,\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0004J\b\u0010-\u001a\u00020\u0003H\u0004J\u0006\u0010.\u001a\u00020\r\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/n;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "N", "Lij1/g;", "blockData", "G", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "detailInitBean", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "view", "", "elementId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "data", "", "position", "", "", "payload", "L", "M", "payloads", "Lkotlin/Pair;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadType;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/i;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadInstanceType;", "payloadMaps", "H", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", com.tencent.luggage.wxa.c8.c.G, "fromPage", "K", "J", "D", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "O", "B", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildFeedSquareFeedBaseSection extends n<com.tencent.mobileqq.guild.feed.feedsquare.data.h> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void G(ij1.g blockData) {
        int i3 = 2;
        GuildFeedSquareLiveRoomItemData guildFeedSquareLiveRoomItemData = null;
        GuildScheduleInfo guildScheduleInfo = null;
        GuildFeedSquareMediaRoomItemData guildFeedSquareMediaRoomItemData = null;
        int i16 = 1;
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                Object d16 = blockData.d(blockData.m());
                if (d16 instanceof GuildFeedSquareLiveRoomItemData) {
                    guildFeedSquareLiveRoomItemData = (GuildFeedSquareLiveRoomItemData) d16;
                }
                if (guildFeedSquareLiveRoomItemData == null) {
                    return;
                }
                t().put("sgrp_live_room_id", guildFeedSquareLiveRoomItemData.getRoomId());
                Map<String, Object> t16 = t();
                if (guildFeedSquareLiveRoomItemData.getRoomState() == 1) {
                    i3 = 1;
                }
                t16.put("sgrp_card_state", Integer.valueOf(i3));
                return;
            case 14:
                Object d17 = blockData.d(blockData.m());
                if (d17 instanceof GuildFeedSquareMediaRoomItemData) {
                    guildFeedSquareMediaRoomItemData = (GuildFeedSquareMediaRoomItemData) d17;
                }
                if (guildFeedSquareMediaRoomItemData == null) {
                    return;
                }
                t().put("sgrp_subchannel_session_id", guildFeedSquareMediaRoomItemData.getSessionId());
                Map<String, Object> t17 = t();
                if (guildFeedSquareMediaRoomItemData.getChannelMemberCount() != 0) {
                    i3 = 1;
                }
                t17.put("sgrp_card_state", Integer.valueOf(i3));
                return;
            case 15:
                Object d18 = blockData.d(blockData.m());
                if (d18 instanceof GuildScheduleInfo) {
                    guildScheduleInfo = (GuildScheduleInfo) d18;
                }
                if (guildScheduleInfo == null) {
                    return;
                }
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                if (serverTimeMillis >= guildScheduleInfo.getStartTimeMs()) {
                    if (serverTimeMillis < guildScheduleInfo.getEndTimeMs()) {
                        i16 = 3;
                    } else {
                        i16 = 4;
                    }
                }
                t().put("sgrp_event_status", Integer.valueOf(i16));
                t().put("sgrp_schedular_id", Long.valueOf(guildScheduleInfo.getScheduleId()));
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N() {
        String str;
        Map map;
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData;
        if (hVar != null) {
            switch (hVar.b()) {
                case 13:
                    str = "em_sgrp_nowplay_single_card";
                    break;
                case 14:
                    str = "em_sgrp_voice_single_card";
                    break;
                case 15:
                    str = "em_sgrp_single_event_card";
                    break;
                default:
                    return;
            }
            View view = new View(this.mRootView.getContext());
            VideoReport.setLogicParent(view, this.mRootView);
            map = MapsKt__MapsKt.toMap(C());
            com.tencent.mobileqq.guild.feed.report.d.a("clck", view, str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map P(GuildFeedSquareFeedBaseSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.C();
    }

    private final void Q(GuildFeedDetailInitBean detailInitBean) {
        detailInitBean.setBusinessType(p());
        detailInitBean.setImmersiveSource(s());
        if (r() != null) {
            JumpGuildParam.JoinInfoParam r16 = r();
            boolean z16 = false;
            if (r16 != null && r16.isValid()) {
                z16 = true;
            }
            if (z16) {
                detailInitBean.setJoinInfoParam(r());
            }
        }
        GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", com.tencent.mobileqq.guild.feed.presenter.l.b(p()));
        guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_forum_type", com.tencent.mobileqq.guild.feed.presenter.l.a(p()));
        detailInitBean.setFeedReportSourceInfo(guildFeedReportSourceInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(@Nullable View view, @NotNull String elementId) {
        T t16;
        Map map;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (view != null && (t16 = this.mData) != 0) {
            String valueOf = String.valueOf(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) t16).hashCode());
            map = MapsKt__MapsKt.toMap(C());
            com.tencent.mobileqq.guild.feed.report.d.b(view, elementId, valueOf, map);
        }
    }

    @NotNull
    public final String B() {
        return "click_area_feed_item";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public Map<String, Object> C() {
        String string;
        T t16 = this.mData;
        if (t16 != 0) {
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData");
            ij1.g blockData = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) t16).getBlockData();
            GProStFeed b16 = blockData.b();
            if (b16 != null) {
                Map<String, Object> t17 = t();
                Map<String, Object> d16 = com.tencent.mobileqq.guild.feed.report.f.d(b16, "");
                Intrinsics.checkNotNullExpressionValue(d16, "convertDataToDtParamsMap\u2026 \"\"\n                    )");
                t17.putAll(d16);
            }
            if (!TextUtils.isEmpty(blockData.c())) {
                Map<String, Object> t18 = t();
                String c16 = blockData.c();
                Intrinsics.checkNotNullExpressionValue(c16, "blockData.traceId");
                t18.put("sgrp_forum_trace_id", c16);
            }
            boolean z16 = true;
            t().put("sgrp_type", 1);
            Map<String, Object> t19 = t();
            if (p() == 15) {
                string = q();
            } else {
                wo1.c cVar = (wo1.c) SectionIOCKt.getIocInterface(this, wo1.c.class);
                if (cVar == null || cVar.getSortMode() != 2) {
                    z16 = false;
                }
                if (z16) {
                    string = BaseApplication.context.getString(R.string.f145420rf);
                } else {
                    string = BaseApplication.context.getString(R.string.f145440rh);
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    if\u2026      }\n                }");
            }
            t19.put("sgrp_section_name", string);
            t().put("sgrp_rank", Integer.valueOf(this.mPosition));
            if (J()) {
                G(blockData);
            }
        }
        return new ConcurrentHashMap(t());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final GProStFeed D() {
        T t16 = this.mData;
        if (t16 != 0 && ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) t16).getBlockData().b() != null) {
            return ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData().b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final GuildFeedDetailInitBean F(@NotNull GProStFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        GuildFeedDetailInitBean it = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(feed);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Q(it);
        Intrinsics.checkNotNullExpressionValue(it, "initFeedDetailInitBeanFr\u2026yPageDepend(it)\n        }");
        return it;
    }

    protected boolean H(@NotNull List<? extends Map<GuildFeedSquareFeedPayloadType, ? extends com.tencent.mobileqq.guild.feed.feedsquare.data.i>> payloadMaps) {
        Intrinsics.checkNotNullParameter(payloadMaps, "payloadMaps");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean J() {
        int i3;
        ij1.g blockData;
        GProStFeed b16;
        GProRecommendCard gProRecommendCard;
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData;
        if (hVar != null && (blockData = hVar.getBlockData()) != null && (b16 = blockData.b()) != null && (gProRecommendCard = b16.recommendCard) != null) {
            i3 = gProRecommendCard.cardType;
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    public final void K(@NotNull final GProStFeed feed, final int pos, final int fromPage) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (J()) {
            N();
            GuildFeedRecommendCardUtils.f219300a.j(this.mRootView.getContext(), new com.tencent.mobileqq.guild.feed.feedsquare.utils.f(feed), r());
        } else {
            GuildMainFrameUtils.l(String.valueOf(feed.channelInfo.sign.guildId), false, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection$jump2FeedDetail$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                    invoke2(iGProGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                    Object obj;
                    View view;
                    GuildFeedDetailInitBean F = GuildFeedSquareFeedBaseSection.this.F(feed);
                    if (iGProGuildInfo == null) {
                        QLog.e(GuildFeedSquareFeedBaseSection.this.v(), 1, "fetchGuildInfoAnyway failed guildId=" + F.getGuildId());
                        F.setIsMember(true);
                    } else {
                        F.setIsMember(iGProGuildInfo.isMember());
                    }
                    F.setPosition(pos);
                    F.setFromPage(fromPage);
                    wo1.c cVar = (wo1.c) SectionIOCKt.getIocInterface(GuildFeedSquareFeedBaseSection.this, wo1.c.class);
                    F.setImmersiveSource(mk1.e.f(F, cVar != null ? cVar.getSortMode() : 0));
                    mk1.e.a(F, GuildFeedSquareFeedBaseSection.this.C());
                    F.setStFeed(feed);
                    obj = ((Section) GuildFeedSquareFeedBaseSection.this).mData;
                    F.setGuildFeedPublishInfo(com.tencent.mobileqq.guild.feed.feedsquare.data.g.b(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) obj).getBlockData()));
                    boolean needOpenNativeDetailPage = ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(feed);
                    view = ((Section) GuildFeedSquareFeedBaseSection.this).mRootView;
                    GuildFeedLauncher.x(view.getContext(), F, Boolean.valueOf(needOpenNativeDetailPage));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        ArrayList arrayList;
        Pair<Boolean, Boolean> z16 = z(data, position, payload);
        boolean booleanValue = z16.component1().booleanValue();
        boolean booleanValue2 = z16.component2().booleanValue();
        if (booleanValue) {
            M(data, position, payload);
            return;
        }
        if (booleanValue2) {
            if (payload != null) {
                arrayList = new ArrayList();
                for (Object obj : payload) {
                    if (obj instanceof Map) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || H(arrayList)) {
                M(data, position, payload);
            }
        }
    }

    public abstract void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void O() {
        FragmentActivity fragmentActivity;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        Fragment a16;
        GProStFeed D = D();
        if (D != null) {
            zp1.a aVar = null;
            if (J()) {
                com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
                if (gVar != null && (context = gVar.getContext()) != null && (a16 = context.a()) != null && (fragmentActivity = a16.getActivity()) != null) {
                    Intrinsics.checkNotNullExpressionValue(fragmentActivity, "this");
                    new FeedRecommendCardMorePanelHelper(fragmentActivity).i(D);
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity == null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("showSharePanel activity is null");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("MsgExt", 1, (String) it.next(), null);
                    }
                    return;
                }
                return;
            }
            Object iocInterface = SectionIOCKt.getIocInterface(this, zp1.a.class);
            if (iocInterface instanceof zp1.a) {
                aVar = (zp1.a) iocInterface;
            }
            zp1.a aVar2 = aVar;
            if (aVar2 != null) {
                a.C11708a.a(aVar2, this.mPosition, ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData(), new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.p
                    @Override // androidx.core.util.Supplier
                    public final Object get() {
                        Map P;
                        P = GuildFeedSquareFeedBaseSection.P(GuildFeedSquareFeedBaseSection.this);
                        return P;
                    }
                }, 0, 8, null);
            }
        }
    }

    @NotNull
    protected Pair<Boolean, Boolean> z(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payloads) {
        boolean z16;
        List<Object> list = payloads;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
        }
        Iterator<Object> it = payloads.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Map) {
                return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
            }
        }
        Boolean bool = Boolean.FALSE;
        return TuplesKt.to(bool, bool);
    }
}

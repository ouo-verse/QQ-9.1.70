package lk1;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryPagerEvent;
import com.tencent.mobileqq.guild.feed.gallery.pb.GuildFeedRecommendParam$ItemCbData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import fk1.b;
import gh1.ExposeModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J0\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0016JH\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010*\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'`)H\u0016J\u0012\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006C"}, d2 = {"Llk1/d;", "Llk1/a;", "", "position", "", "needExposeEnd", "", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feedData", ReportConstant.COSTREPORT_PREFIX, "", "id", "stateData", "", "cbExtData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgh1/b;", "exposeHelper", "r", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "isScrollUp", "j", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "f", "onResume", "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "c", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "D", "I", "currentVerticalPosition", "Landroid/view/View;", "E", "Landroid/view/View;", "lastExposureItemView", "", UserInfo.SEX_FEMALE, "J", "lastExposureItemViewTime", "Ljk1/a;", "G", "Ljk1/a;", "lastBlockData", "H", "Lgh1/b;", "recommendExposeHelper", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends a {

    /* renamed from: D, reason: from kotlin metadata */
    private int currentVerticalPosition = -1;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View lastExposureItemView;

    /* renamed from: F, reason: from kotlin metadata */
    private long lastExposureItemViewTime;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private jk1.a lastBlockData;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private gh1.b recommendExposeHelper;

    private final void m(String id5, String stateData, byte[] cbExtData) {
        gh1.b bVar = this.recommendExposeHelper;
        if (bVar != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", "[doExpose] id:" + id5 + ", stateData:" + stateData + ", cbExtData:" + cbExtData);
            }
            bVar.i(new ExposeModel(id5, stateData, cbExtData));
        }
    }

    private final void n(int position, boolean needExposeEnd) {
        b.C10321b c10321b;
        Object orNull;
        GuildFeedGalleryInitBean initBean;
        Object orNull2;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f414954e.findViewHolderForAdapterPosition(position);
        if (findViewHolderForAdapterPosition instanceof b.C10321b) {
            c10321b = (b.C10321b) findViewHolderForAdapterPosition;
        } else {
            c10321b = null;
        }
        if (c10321b == null) {
            return;
        }
        List<jk1.a> dataList = this.f414957i.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "mAdapter.dataList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, position);
        jk1.a aVar = (jk1.a) orNull;
        if (aVar != null && (initBean = aVar.getInitBean()) != null) {
            HashMap<String, Object> e16 = mk1.e.e(initBean);
            e16.put("sgrp_rank", Integer.valueOf(position));
            e16.put("sgrp_forum_hold_expend_type", Integer.valueOf(aVar.getExtType()));
            GProStFeed b16 = aVar.b();
            if (b16 != null && (gProStChannelInfo = b16.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
                e16.put("sgrp_channel_id", String.valueOf(gProStChannelSign.guildId));
                e16.put("sgrp_sub_channel_id", String.valueOf(gProStChannelSign.channelId));
            }
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(c10321b.itemView, "em_sgrp_forum_item", "imp", e16);
            if (needExposeEnd) {
                List<jk1.a> dataList2 = this.f414957i.getDataList();
                Intrinsics.checkNotNullExpressionValue(dataList2, "mAdapter.dataList");
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(dataList2, this.currentVerticalPosition);
                this.lastBlockData = (jk1.a) orNull2;
                p();
            }
            s(initBean.getFeed());
            this.lastExposureItemView = c10321b.itemView;
            this.lastExposureItemViewTime = System.currentTimeMillis();
            this.lastBlockData = aVar;
        }
    }

    static /* synthetic */ void o(d dVar, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        dVar.n(i3, z16);
    }

    private final void p() {
        HashMap<String, Object> hashMap;
        jk1.a aVar = this.lastBlockData;
        if (aVar == null || (hashMap = mk1.e.e(aVar.getInitBean())) == null) {
            hashMap = new HashMap<>();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lastExposureItemViewTime;
        hashMap.put("sgrp_rank", Integer.valueOf(this.currentVerticalPosition));
        hashMap.put(DTParamKey.REPORT_KEY_ELEMENT_LVTM, Long.valueOf(currentTimeMillis));
        View view = this.lastExposureItemView;
        if (view != null) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_forum_item", "imp_end", hashMap);
        }
    }

    private final void q(int position) {
        boolean z16;
        String str;
        Object orNull;
        HashMap<String, Object> hashMap;
        int i3 = 0;
        if (position > this.currentVerticalPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "em_sgrp_up_slideup";
        } else {
            str = "em_sgrp_down_slideup";
        }
        List<jk1.a> dataList = this.f414957i.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "mAdapter.dataList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, position);
        jk1.a aVar = (jk1.a) orNull;
        if (aVar == null || (hashMap = mk1.e.e(aVar.getInitBean())) == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("sgrp_rank", Integer.valueOf(position));
        HashMap hashMap2 = new HashMap();
        if (z16) {
            if (aVar != null) {
                i3 = aVar.getExtType();
            }
            hashMap2.put("sgrp_forum_hold_expend_type", Integer.valueOf(i3));
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.f414954e, str, "clck", hashMap2);
    }

    private final void s(GProStFeed feedData) {
        Integer num;
        Logger logger = Logger.f235387a;
        byte[] bArr = null;
        if (QLog.isDevelopLevel()) {
            gh1.b bVar = this.recommendExposeHelper;
            if (feedData != null) {
                num = Integer.valueOf(feedData.hashCode());
            } else {
                num = null;
            }
            Log.d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", "[tryToDoExpose] exposeHelper:" + bVar + ", feedData:" + num);
        }
        if (this.recommendExposeHelper != null && feedData != null) {
            String str = feedData.idd;
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "it.idd ?: \"\"");
            }
            byte[] bArr2 = feedData.busiReport;
            if (bArr2 == null) {
                bArr2 = new byte[0];
            } else {
                Intrinsics.checkNotNullExpressionValue(bArr2, "it.busiReport ?: ByteArray(0)");
            }
            GuildFeedRecommendParam$ItemCbData guildFeedRecommendParam$ItemCbData = new GuildFeedRecommendParam$ItemCbData();
            byte[] bArr3 = new byte[0];
            try {
                guildFeedRecommendParam$ItemCbData.mergeFrom(bArr2);
                String str3 = guildFeedRecommendParam$ItemCbData.stat_data.get();
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "itemCbData.stat_data.get() ?: \"\"");
                    str2 = str3;
                }
                ByteStringMicro byteStringMicro = guildFeedRecommendParam$ItemCbData.cb_ext_data.get();
                if (byteStringMicro != null) {
                    bArr = byteStringMicro.toByteArray();
                }
                if (bArr == null) {
                    bArr3 = new byte[0];
                } else {
                    Intrinsics.checkNotNullExpressionValue(bArr, "itemCbData.cb_ext_data.g\u2026teArray() ?: ByteArray(0)");
                    bArr3 = bArr;
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                Logger logger2 = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", "[tryToDoExpose] mergeFrom with Exception");
                }
            }
            m(str, str2, bArr3);
        }
    }

    @Override // lk1.a
    public void c(int position) {
        super.c(position);
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", 1, "[onPageSelected] position " + position + ", lastPage " + this.currentVerticalPosition);
        if (this.currentVerticalPosition == position) {
            return;
        }
        o(this, position, false, 2, null);
        if (this.currentVerticalPosition == -1) {
            this.currentVerticalPosition = position;
        } else {
            q(position);
            this.currentVerticalPosition = position;
        }
    }

    @Override // lk1.a
    public void d() {
        super.d();
        p();
    }

    @Override // lk1.a
    public void f(@NotNull RecyclerView recyclerView, int newState, @NotNull RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", "[onScrollStateChanged] newState " + newState + ", VisiblePos[" + firstVisiblePos + ", " + lastVisiblePos + "], CompletelyVisible[" + firstCompletelyVisible + ", " + lastCompletelyVisible + "], isScrollUp " + isScrollUp);
        }
    }

    @Override // lk1.a, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryPagerEvent.class);
        return eventClass;
    }

    @Override // lk1.a
    public void j(int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", "[triggerSlowScroll] VisiblePos[" + firstVisiblePos + ", " + lastVisiblePos + "], CompletelyVisible[" + firstCompletelyVisible + ", " + lastCompletelyVisible + "], isScrollUp " + isScrollUp);
        }
    }

    @Override // lk1.a
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", 1, "[onDestroy] ");
        this.lastExposureItemView = null;
        this.lastExposureItemViewTime = 0L;
        this.lastBlockData = null;
    }

    @Override // lk1.a, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        String str;
        Object orNull;
        HashMap<String, Object> hashMap;
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedGalleryPagerEvent) {
            GuildFeedGalleryPagerEvent guildFeedGalleryPagerEvent = (GuildFeedGalleryPagerEvent) simpleBaseEvent;
            if (guildFeedGalleryPagerEvent.getScrollState() == GuildFeedGalleryPagerEvent.GalleryPageScrollState.INIT) {
                return;
            }
            if (guildFeedGalleryPagerEvent.getScrollState() == GuildFeedGalleryPagerEvent.GalleryPageScrollState.SCROLL_TO_RIGHT) {
                str = "em_sgrp_left_slideup";
            } else {
                str = "em_sgrp_right_slideup";
            }
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", 1, "[onReceiveEvent] GuildFeedGalleryPagerEvent state " + guildFeedGalleryPagerEvent.getScrollState());
            List<jk1.a> dataList = this.f414957i.getDataList();
            Intrinsics.checkNotNullExpressionValue(dataList, "mAdapter.dataList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, this.currentVerticalPosition);
            jk1.a aVar = (jk1.a) orNull;
            if (aVar == null || (hashMap = mk1.e.e(aVar.getInitBean())) == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("sgrp_rank", Integer.valueOf(this.currentVerticalPosition));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.f414954e, str, "clck", hashMap);
        }
    }

    @Override // lk1.a
    public void onResume() {
        super.onResume();
        n(this.currentVerticalPosition, false);
    }

    public final void r(@Nullable gh1.b exposeHelper) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild_Feed_GAL_GuildFeedGalleryReportScroller", "[setRecommendExposeHelper] exposeHelper:" + exposeHelper);
        }
        this.recommendExposeHelper = exposeHelper;
    }
}

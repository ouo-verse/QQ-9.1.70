package com.tencent.mobileqq.guild.media.qcircle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010&\u001a\n #*\u0004\u0018\u00010\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010)\u001a\n #*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(R\u001c\u0010,\u001a\n #*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u001c\u0010.\u001a\n #*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u001c\u00101\u001a\n #*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00100R\u001c\u00103\u001a\n #*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u001c\u00105\u001a\n #*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100R\u001c\u00107\u001a\n #*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010A\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/QCircleBaseView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/qcircle/d;", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "guildFeedData", HippyTKDListViewAdapter.X, "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "w", "v", "y", "Lfeedcloud/FeedCloudMeta$StLive;", "r", "f", "", tl.h.F, "k", "j", "Lj30/a;", "controller", "l", "", "position", "g", DomainData.DOMAIN_NAME, "roomType", "a", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "d", "Lj30/a;", "kotlin.jvm.PlatformType", "e", "Landroid/widget/FrameLayout;", "roomContent", "Landroid/view/View;", "Landroid/view/View;", "clickView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "feedName", "i", "feedTitle", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "enterView", BdhLogUtil.LogTag.Tag_Conn, ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG, "D", "statusView", "E", "recommendView", "Lcom/tencent/mobileqq/guild/media/qcircle/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/qcircle/e;", "mediaContent", "G", "Lcom/tencent/mobileqq/guild/media/qcircle/c;", "H", "Lfeedcloud/FeedCloudMeta$StFeed;", "feedData", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "J", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QCircleBaseView extends FrameLayout implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView coverImg;

    /* renamed from: D, reason: from kotlin metadata */
    private final ImageView statusView;

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView recommendView;

    /* renamed from: F, reason: from kotlin metadata */
    private e mediaContent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private c guildFeedData;

    /* renamed from: H, reason: from kotlin metadata */
    private FeedCloudMeta$StFeed feedData;

    /* renamed from: I, reason: from kotlin metadata */
    private int position;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private j30.a controller;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout roomContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View clickView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView feedName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView feedTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ImageView enterView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/qcircle/QCircleBaseView$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GuildPicStateListener {
        b() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS) {
                Bitmap resultBitMap = option.getResultBitMap();
                a aVar = a.f229172a;
                Context context = QCircleBaseView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNullExpressionValue(resultBitMap, "resultBitMap");
                QCircleBaseView.this.coverImg.setImageBitmap(aVar.a(context, resultBitMap, 16.0f, 1, 1));
                QCircleBaseView.this.coverImg.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QCircleBaseView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feedData;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            feedCloudMeta$StFeed = null;
        }
        String str = feedCloudMeta$StFeed.live.room.coverUrl.get();
        Intrinsics.checkNotNullExpressionValue(str, "feedData.live.room.coverUrl.get()");
        QLog.d("QGMC.QCircle.QCircleBaseView", 1, "cover url=" + str);
        Option loadingDrawable = Option.obtain().setUrl(str).setLoadingDrawable(new ColorDrawable(0));
        ViewGroup.LayoutParams layoutParams = this.coverImg.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "coverImg.layoutParams");
        loadingDrawable.setRequestWidth(layoutParams.width).setRegionHeight(layoutParams.height);
        loadingDrawable.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        com.tencent.mobileqq.guild.picload.e.a().f(loadingDrawable, new b());
    }

    private final boolean h() {
        boolean z16;
        boolean z17;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feedData;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed.live.room.roomState.get() == 2) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.feedData;
            if (feedCloudMeta$StFeed3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedData");
            } else {
                feedCloudMeta$StFeed2 = feedCloudMeta$StFeed3;
            }
            QLog.d("QGMC.QCircle.QCircleBaseView", 1, "checkNeedDelete close " + feedCloudMeta$StFeed2.f398449id.get());
            return true;
        }
        if (GLiveChannelCore.f226698a.t().N()) {
            QLog.d("QGMC.QCircle.QCircleBaseView", 1, "self is living");
            return true;
        }
        if (MobileQQ.sProcessId != 1) {
            QLog.d("QGMC.QCircle.QCircleBaseView", 1, "\u975e\u4e3b\u8fdb\u7a0b");
            return true;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = this.feedData;
        if (feedCloudMeta$StFeed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
        } else {
            feedCloudMeta$StFeed2 = feedCloudMeta$StFeed4;
        }
        if (feedCloudMeta$StFeed2.live.room.roomType.get() != 2 && this.guildFeedData.getPlayerSum() == 0) {
            QLog.d("QGMC.QCircle.QCircleBaseView", 1, "\u9ea6\u4f4d\u533a\u4eba\u6570\u4e3a0");
            return true;
        }
        if (this.guildFeedData.getGuildId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !Intrinsics.areEqual(this.guildFeedData.getGuildId(), "0")) {
            if (this.guildFeedData.getChannelId().length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 && !Intrinsics.areEqual(this.guildFeedData.getChannelId(), "0")) {
                return false;
            }
        }
        QLog.d("QGMC.QCircle.QCircleBaseView", 1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QCircleBaseView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j30.a aVar = this$0.controller;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
            aVar = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this$0.feedData;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
        } else {
            feedCloudMeta$StFeed = feedCloudMeta$StFeed2;
        }
        aVar.d(feedCloudMeta$StFeed.f398449id.get());
    }

    private final void j() {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.clickView;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        iGuildDTReportApi.setElementReport(view, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA, clickPolicy, ExposurePolicy.REPORT_NONE);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementReport(this.feedName, "em_xsj_author_name", clickPolicy, ExposurePolicy.REPORT_ALL);
    }

    private final void k() {
        Map<String, Object> mapOf;
        Pair[] pairArr = new Pair[14];
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feedData;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
            feedCloudMeta$StFeed = null;
        }
        pairArr[0] = TuplesKt.to("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        pairArr[1] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.position));
        pairArr[2] = TuplesKt.to("xsj_stream_id", this.guildFeedData.getLiveRoomId());
        pairArr[3] = TuplesKt.to("sgrp_subchannel_session_id", this.guildFeedData.getSessionId());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.feedData;
        if (feedCloudMeta$StFeed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
        } else {
            feedCloudMeta$StFeed2 = feedCloudMeta$StFeed3;
        }
        pairArr[4] = TuplesKt.to("sgrp_avchannel_room_type", Integer.valueOf(feedCloudMeta$StFeed2.live.room.roomType.get()));
        pairArr[5] = TuplesKt.to("sgrp_channel_id", this.guildFeedData.getGuildId());
        pairArr[6] = TuplesKt.to("sgrp_sub_channel_id", this.guildFeedData.getChannelId());
        pairArr[7] = TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.guildFeedData.getChannelType()));
        pairArr[8] = TuplesKt.to("sgrp_user_type", Integer.valueOf(v.c(this.guildFeedData.getGuildId())));
        pairArr[9] = TuplesKt.to("sgrp_on_mic", Integer.valueOf(this.guildFeedData.getPlayerSum()));
        pairArr[10] = TuplesKt.to("sgrp_open_mic", Integer.valueOf(this.guildFeedData.getOpenMicSum()));
        pairArr[11] = TuplesKt.to("sgrp_xsj_explore_feeds_button_status", Integer.valueOf(this.guildFeedData.getRoomState()));
        pairArr[12] = TuplesKt.to("sgrp_recommend_content", this.guildFeedData.getCom.tencent.tuxmeterqui.config.TuxUIConstants.POP_BTN_TEXT java.lang.String());
        pairArr[13] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE1, 6);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA, mapOf);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
    }

    private final c r(FeedCloudMeta$StLive data) {
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str2;
        Object obj5;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        PBBytesField pBBytesField2;
        ByteStringMicro byteStringMicro2;
        List<FeedCloudCommon$BytesEntry> list = data.liveBytesExtInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "data.liveBytesExtInfo.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj).key.get(), "room_atom_info")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = (FeedCloudCommon$BytesEntry) obj;
        List<FeedCloudCommon$BytesEntry> list2 = data.liveBytesExtInfo.get();
        Intrinsics.checkNotNullExpressionValue(list2, "data.liveBytesExtInfo.get()");
        Iterator<T> it5 = list2.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj2).key.get(), "room_atom_tag")) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry2 = (FeedCloudCommon$BytesEntry) obj2;
        List<FeedCloudCommon$BytesEntry> list3 = data.liveBytesExtInfo.get();
        Intrinsics.checkNotNullExpressionValue(list3, "data.liveBytesExtInfo.get()");
        Iterator<T> it6 = list3.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj3 = it6.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj3).key.get(), "daTongReportJson")) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry3 = (FeedCloudCommon$BytesEntry) obj3;
        this.guildFeedData = new c(null, null, null, null, null, null, 0, null, null, null, null, 0, null, 0, 0, 0, 0L, 0, null, 524287, null);
        if (feedCloudCommon$BytesEntry != null) {
            try {
                JSONObject jSONObject = new JSONObject(feedCloudCommon$BytesEntry.value.get().toStringUtf8());
                c cVar = this.guildFeedData;
                cVar.w(jSONObject.optString("guild_id").toString());
                cVar.t(jSONObject.optString("channel_id").toString());
                String optString = jSONObject.optString("guild_name");
                Intrinsics.checkNotNullExpressionValue(optString, "infoJson.optString(GUILD_NAME)");
                cVar.x(optString);
                String optString2 = jSONObject.optString("guild_icon");
                Intrinsics.checkNotNullExpressionValue(optString2, "infoJson.optString(GUILD_ICON)");
                cVar.v(optString2);
                String optString3 = jSONObject.optString("join_guild_sig");
                Intrinsics.checkNotNullExpressionValue(optString3, "infoJson.optString(JOIN_GUILD_SIG)");
                cVar.y(optString3);
                cVar.u(jSONObject.optInt("channel_type"));
                cVar.D(jSONObject.optInt("players_num"));
                cVar.C(jSONObject.optInt("openmic_num"));
                cVar.p(jSONObject.optLong("anchor_tiny_id"));
                String optString4 = jSONObject.optString(AudienceReportConst.ROOM_ID);
                Intrinsics.checkNotNullExpressionValue(optString4, "infoJson.optString(ROOM_ID)");
                cVar.A(optString4);
                cVar.z(jSONObject.optInt("joined_guild"));
                String optString5 = jSONObject.optString("suggest_tag_name");
                Intrinsics.checkNotNullExpressionValue(optString5, "infoJson.optString(SUGGEST_TAG_NAME)");
                cVar.H(optString5);
                QLog.d("QGMC.QCircle.QCircleBaseView", 1, "parseRoomInfo " + this.guildFeedData.getGuildId() + " -- " + this.guildFeedData.getChannelId());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (feedCloudCommon$BytesEntry2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(feedCloudCommon$BytesEntry2.value.get().toStringUtf8());
                c cVar2 = this.guildFeedData;
                String optString6 = jSONObject2.optString("button_url");
                Intrinsics.checkNotNullExpressionValue(optString6, "tagJson.optString(TAG_BTN_URL)");
                cVar2.r(optString6);
                this.guildFeedData.s(jSONObject2.optInt("width"));
                c cVar3 = this.guildFeedData;
                String optString7 = jSONObject2.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString7, "tagJson.optString(BTN_TEXT)");
                cVar3.q(optString7);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (feedCloudCommon$BytesEntry3 != null) {
            try {
                JSONObject jSONObject3 = new JSONObject(feedCloudCommon$BytesEntry3.value.get().toStringUtf8());
                c cVar4 = this.guildFeedData;
                String optString8 = jSONObject3.optString("sgrp_subchannel_session_id");
                Intrinsics.checkNotNullExpressionValue(optString8, "reportJson.optString(SESSION_ID)");
                cVar4.F(optString8);
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
        this.guildFeedData.E(data.room.roomState.get());
        c cVar5 = this.guildFeedData;
        List<FeedCloudCommon$BytesEntry> list4 = data.liveBytesExtInfo.get();
        Intrinsics.checkNotNullExpressionValue(list4, "data.liveBytesExtInfo.get()");
        Iterator<T> it7 = list4.iterator();
        while (true) {
            if (it7.hasNext()) {
                obj4 = it7.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj4).key.get(), "mainSourceId")) {
                    break;
                }
            } else {
                obj4 = null;
                break;
            }
        }
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry4 = (FeedCloudCommon$BytesEntry) obj4;
        if (feedCloudCommon$BytesEntry4 != null && (pBBytesField2 = feedCloudCommon$BytesEntry4.value) != null && (byteStringMicro2 = pBBytesField2.get()) != null) {
            str2 = byteStringMicro2.toStringUtf8();
        } else {
            str2 = null;
        }
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        cVar5.B(str2);
        c cVar6 = this.guildFeedData;
        List<FeedCloudCommon$BytesEntry> list5 = data.liveBytesExtInfo.get();
        Intrinsics.checkNotNullExpressionValue(list5, "data.liveBytesExtInfo.get()");
        Iterator<T> it8 = list5.iterator();
        while (true) {
            if (it8.hasNext()) {
                obj5 = it8.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$BytesEntry) obj5).key.get(), "subSourceId")) {
                    break;
                }
            } else {
                obj5 = null;
                break;
            }
        }
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry5 = (FeedCloudCommon$BytesEntry) obj5;
        if (feedCloudCommon$BytesEntry5 != null && (pBBytesField = feedCloudCommon$BytesEntry5.value) != null && (byteStringMicro = pBBytesField.get()) != null) {
            str = byteStringMicro.toStringUtf8();
        }
        if (str != null) {
            str3 = str;
        }
        cVar6.G(str3);
        QLog.d("QGMC.QCircle.QCircleBaseView", 4, "parseRoomInfo " + this.guildFeedData);
        return this.guildFeedData;
    }

    private final void s() {
        this.clickView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.qcircle.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleBaseView.t(QCircleBaseView.this, view);
            }
        });
        this.feedName.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.qcircle.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleBaseView.u(QCircleBaseView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(QCircleBaseView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e eVar = this$0.mediaContent;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
            eVar = null;
        }
        eVar.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(QCircleBaseView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j30.a aVar = this$0.controller;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
            aVar = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this$0.feedData;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedData");
        } else {
            feedCloudMeta$StFeed = feedCloudMeta$StFeed2;
        }
        aVar.s(feedCloudMeta$StFeed);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(FeedCloudMeta$StFeed data) {
        String imageUrl = data.live.liveJumpButton.button_url.get();
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
        this.enterView.setImageDrawable(iVasApngFactory.getApngURLDrawable("QGMC.QCircle.QCircleBaseView", imageUrl));
    }

    private final void w(FeedCloudMeta$StFeed data) {
        String imageUrl = data.live.liveStatusButton.button_url.get();
        if (!StringUtil.isEmpty(imageUrl)) {
            IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
            Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
            this.statusView.setImageDrawable(iVasApngFactory.getApngURLDrawable("QGMC.QCircle.QCircleBaseView", imageUrl));
            this.statusView.setVisibility(0);
        }
    }

    private final void x(c guildFeedData) {
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("QGMC.QCircle.QCircleBaseView", guildFeedData.getBtnUrl());
        this.recommendView.getLayoutParams().width = QQGuildUIUtil.f(guildFeedData.getBtnWidth() / 3);
        this.recommendView.setImageDrawable(apngURLDrawable);
        this.recommendView.setVisibility(0);
    }

    private final void y(FeedCloudMeta$StFeed data) {
        boolean z16;
        String str;
        String str2 = data.live.room.roomTitle.get();
        String str3 = data.poster.nick.get();
        TextView textView = this.feedTitle;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = str3 + getContext().getString(R.string.f1914744w);
        }
        textView.setText(str2);
        TextView textView2 = this.feedName;
        if (TextUtils.isEmpty(str3)) {
            str = "";
        } else {
            str = "@\u9891\u9053\uff5c" + str3;
        }
        textView2.setText(str);
    }

    @Override // com.tencent.mobileqq.guild.media.qcircle.d
    public void a(int roomType) {
        f();
        if (roomType != 2) {
            if (roomType != 5) {
                if (roomType != 11) {
                    QQToast.makeText(getContext(), getContext().getString(R.string.f14974134), 0).show();
                } else {
                    QQToast.makeText(getContext(), getContext().getString(R.string.f14975135), 0).show();
                }
            } else {
                QQToast.makeText(getContext(), getContext().getString(R.string.f14976136), 0).show();
            }
        } else {
            QQToast.makeText(getContext(), getContext().getString(R.string.f1914144q), 0).show();
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.qcircle.h
            @Override // java.lang.Runnable
            public final void run() {
                QCircleBaseView.i(QCircleBaseView.this);
            }
        }, 500L);
    }

    public final void g(@NotNull FeedCloudMeta$StFeed data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("QGMC.QCircle.QCircleBaseView", 1, "bindData roomType " + data.live.room.roomType.get() + " feedId " + data.f398449id.get());
        this.feedData = data;
        FeedCloudMeta$StLive feedCloudMeta$StLive = data.live;
        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StLive, "data.live");
        this.guildFeedData = r(feedCloudMeta$StLive);
        this.position = position;
        this.roomContent.removeAllViews();
        y(data);
        v(data);
        x(this.guildFeedData);
        w(data);
        if (h()) {
            a(data.live.room.roomType.get());
            return;
        }
        this.coverImg.setVisibility(8);
        GuildMainFrameUtils.e(this.guildFeedData.getGuildId(), this.guildFeedData.getChannelId(), new Function2<IGProChannelInfo, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.qcircle.QCircleBaseView$bindData$1
            public final void invoke(@Nullable IGProChannelInfo iGProChannelInfo, boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo, Boolean bool) {
                invoke(iGProChannelInfo, bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
        int i3 = 2;
        e eVar = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        if (data.live.room.roomType.get() == 2) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LiveRoomContent liveRoomContent = new LiveRoomContent(context, b19 == true ? 1 : 0, i3, b18 == true ? 1 : 0);
            this.mediaContent = liveRoomContent;
            this.roomContent.addView(liveRoomContent);
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            MediaRoomContent mediaRoomContent = new MediaRoomContent(context2, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
            this.mediaContent = mediaRoomContent;
            this.roomContent.addView(mediaRoomContent);
        }
        e eVar2 = this.mediaContent;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
            eVar2 = null;
        }
        c cVar = this.guildFeedData;
        j30.a aVar = this.controller;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
            aVar = null;
        }
        eVar2.h(data, cVar, aVar);
        e eVar3 = this.mediaContent;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
        } else {
            eVar = eVar3;
        }
        eVar.setFeedController(this);
        s();
        k();
        j();
    }

    public final void l(@NotNull j30.a controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.controller = controller;
    }

    public final void m() {
        e eVar = this.mediaContent;
        if (eVar != null) {
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                eVar = null;
            }
            eVar.onActivityDestroy();
        }
    }

    public final void n() {
        e eVar = this.mediaContent;
        if (eVar != null) {
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                eVar = null;
            }
            eVar.g();
            e eVar2 = this.mediaContent;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                eVar2 = null;
            }
            eVar2.setFeedController(null);
        }
    }

    public final void o() {
        e eVar = this.mediaContent;
        if (eVar != null) {
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                eVar = null;
            }
            eVar.b();
        }
    }

    public final void p() {
        e eVar = this.mediaContent;
        if (eVar != null) {
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                eVar = null;
            }
            eVar.onPagePause();
        }
    }

    public final void q() {
        e eVar = this.mediaContent;
        if (eVar != null) {
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContent");
                eVar = null;
            }
            eVar.e();
        }
    }

    public /* synthetic */ QCircleBaseView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QCircleBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eyx, this);
        this.roomContent = (FrameLayout) findViewById(R.id.z08);
        this.clickView = findViewById(R.id.ty6);
        this.feedName = (TextView) findViewById(R.id.f165183v34);
        this.feedTitle = (TextView) findViewById(R.id.v3m);
        this.enterView = (ImageView) findViewById(R.id.spi);
        this.coverImg = (ImageView) findViewById(R.id.w8i);
        this.statusView = (ImageView) findViewById(R.id.ymk);
        this.recommendView = (ImageView) findViewById(R.id.wf5);
        this.guildFeedData = new c(null, null, null, null, null, null, 0, null, null, null, null, 0, null, 0, 0, 0, 0L, 0, null, 524287, null);
    }
}

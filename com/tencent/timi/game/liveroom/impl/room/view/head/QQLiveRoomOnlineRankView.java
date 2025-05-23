package com.tencent.timi.game.liveroom.impl.room.view.head;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.room.preload.PreloadSwitch;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel;
import com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView;
import com.tencent.timi.game.liveroom.impl.room.view.rank.base.RankView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nf4.d;
import nr2.ad;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 z2\u00020\u00012\u00020\u0002:\u0002{|B\u0013\b\u0016\u0012\b\u0010r\u001a\u0004\u0018\u00010q\u00a2\u0006\u0004\bs\u0010tB\u001d\b\u0016\u0012\b\u0010r\u001a\u0004\u0018\u00010q\u0012\b\u0010v\u001a\u0004\u0018\u00010u\u00a2\u0006\u0004\bs\u0010wB%\b\u0016\u0012\b\u0010r\u001a\u0004\u0018\u00010q\u0012\b\u0010v\u001a\u0004\u0018\u00010u\u0012\u0006\u0010x\u001a\u00020>\u00a2\u0006\u0004\bs\u0010yJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J,\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 J\u0010\u0010%\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010#J\"\u0010(\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0015H\u0016J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0015J\u000e\u00100\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u00101\u001a\u00020\u0015J\u0006\u00102\u001a\u00020\u000bJ\u0010\u00103\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u000e\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0015J\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u001d\u001a\u00020\u000eJ\b\u00107\u001a\u00020\u000bH\u0014J\b\u00108\u001a\u00020\u000bH\u0014R\"\u00104\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b4\u0010;\"\u0004\b<\u0010=R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010\u0013R\u0016\u0010I\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u0013R\u0016\u0010K\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010:R\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010]R\u0014\u0010a\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010cR\u001c\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010jR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010X\u001a\u0004\bn\u0010o\u00a8\u0006}"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "", "prefixNumStr", "postfixTxt", "Landroid/text/SpannableStringBuilder;", "p", "", "reportMap", "v", "", BdhLogUtil.LogTag.Tag_Conn, "G", "", "size", "w", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/o;", "result", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isClick", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", "elementId", "params", "o", "roomId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "Lvi4/a;", "audienceViewModel", "setAudienceViewModel", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "listener", "setOpenGiftPanelListener", "isAnchor", AppConstants.Key.KEY_QZONE_VIDEO_URL, "onPreload", "onPageIn", "onPageOut", "onEnterRoom", "anchorUid", "setAnchorId", "show", "setGiftEnableBtn", "setContentByConfig", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "onExitRoom", "isStart", "H", "r", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Z", "()Z", "setStart", "(Z)V", "", "e", "I", "getRoomType", "()I", "setRoomType", "(I)V", "roomType", "f", "onlineCount", tl.h.F, "queryInterval", "i", "isDistroyed", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankView;", "rankView", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "popupWin", "D", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "openGiftPanelListener", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "E", "Lkotlin/Lazy;", "u", "()Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "rankViewModel", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lnr2/ad;", "Lnr2/ad;", "binding", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "rankArrawIv", "Lzi4/a;", "Ld55/j;", "Lzi4/a;", "mQueryRankListCallback", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "itemClickListener", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/a;", "K", "t", "()Lcom/tencent/timi/game/liveroom/impl/room/view/rank/a;", "detailRankViewDataReadyListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveRoomOnlineRankView extends RelativeLayout implements IRoomWidget {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PopupWindow popupWin;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SelfRankInfoView.b openGiftPanelListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy rankViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private IAegisLogApi mAegisLog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ad binding;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView rankArrawIv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final zi4.a<d55.j> mQueryRankListCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener itemClickListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy detailRankViewDataReadyListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isStart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long onlineCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long queryInterval;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDistroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RankView rankView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView$b;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/TextPaint;", "textPaint", "", "updateMeasureState", "tp", "updateDrawState", "Landroid/graphics/Typeface;", "d", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", TextComponent.SpanStyle.TYPEFACE, "<init>", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends MetricAffectingSpan {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Typeface typeface;

        public b(@NotNull Typeface typeface) {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.typeface = typeface;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint tp5) {
            Intrinsics.checkNotNullParameter(tp5, "tp");
            tp5.setTypeface(this.typeface);
        }

        @Override // android.text.style.MetricAffectingSpan
        public void updateMeasureState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            textPaint.setTypeface(this.typeface);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView$c", "Lzi4/a;", "Ld55/j;", "", "code", "", "msg", "", "fail", "data", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements zi4.a<d55.j> {
        c() {
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable d55.j data) {
            z zVar;
            SpannableStringBuilder p16;
            SpannableStringBuilder p17;
            ArrayList arrayListOf;
            ArrayList arrayListOf2;
            RankView rankView;
            if (data == null) {
                return;
            }
            QQLiveRoomOnlineRankView.this.t().a(com.tencent.timi.game.liveroom.impl.room.view.rank.c.e(data, -1), com.tencent.timi.game.liveroom.impl.room.view.rank.c.c(data));
            if (QQLiveRoomOnlineRankView.this.F() && (rankView = QQLiveRoomOnlineRankView.this.rankView) != null) {
                rankView.N0(data, QQLiveRoomOnlineRankView.this.u().m());
            }
            RecyclerView.Adapter adapter = QQLiveRoomOnlineRankView.this.binding.f420787c.getAdapter();
            if (adapter instanceof z) {
                zVar = (z) adapter;
            } else {
                zVar = null;
            }
            if (zVar != null) {
                QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = QQLiveRoomOnlineRankView.this;
                AegisLogger.INSTANCE.i(AegisLogger.ROOM_INFO, "rankViewDataFetched", "pv = " + data.f393092e + ", online num =" + data.f393089b);
                zVar.m0(qQLiveRoomOnlineRankView.itemClickListener);
                long j3 = data.f393092e;
                if (j3 <= 10000) {
                    p16 = qQLiveRoomOnlineRankView.p(String.valueOf(j3), "\u4eba\u770b\u8fc7");
                } else {
                    String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) j3) / 10000.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    p16 = qQLiveRoomOnlineRankView.p(format, "\u4e07\u4eba\u770b\u8fc7");
                }
                long j16 = data.f393089b;
                if (j16 <= 10000) {
                    p17 = qQLiveRoomOnlineRankView.p(String.valueOf(j16), "\u4eba\u5728\u7ebf");
                } else {
                    String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) j16) / 10000.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                    p17 = qQLiveRoomOnlineRankView.p(format2, "\u4e07\u4eba\u5728\u7ebf");
                }
                if (wj4.c.a(qQLiveRoomOnlineRankView.u().l()) == 2) {
                    zVar.setData(new ArrayList());
                } else if (qQLiveRoomOnlineRankView.u().m()) {
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(p16, new SpannableStringBuilder(), p17);
                    zVar.setData(arrayListOf2);
                } else {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(p16);
                    zVar.setData(arrayListOf);
                }
            }
        }

        @Override // zi4.a
        public void fail(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("AnchorRankView", "getRankListForDetail fail, code=" + code + ", msg=" + msg2);
        }
    }

    public QQLiveRoomOnlineRankView(@Nullable Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        this.queryInterval = 2000L;
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveRoomOnlineRankView$rankViewModel$2.INSTANCE);
        this.rankViewModel = lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        ad f16 = ad.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mQueryRankListCallback = new c();
        this.itemClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveRoomOnlineRankView.B(QQLiveRoomOnlineRankView.this, view);
            }
        };
        lazy2 = LazyKt__LazyJVMKt.lazy(new QQLiveRoomOnlineRankView$detailRankViewDataReadyListener$2(this));
        this.detailRankViewDataReadyListener = lazy2;
    }

    private final boolean A(long roomId) {
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        return busConfigHelper.g(1, busConfigHelper.j().get(Long.valueOf(roomId)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QQLiveRoomOnlineRankView this$0, View view) {
        Map<String, String> r16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.liveroom.impl.room.util.b.a()) {
            if (this$0.A(this$0.u().l())) {
                QLog.w("AnchorRankView", 1, "rankListEnable:false. interrupt click action!");
            } else {
                if (this$0.u().m()) {
                    r16 = this$0.q();
                } else {
                    r16 = this$0.r(this$0.u().l());
                }
                boolean o16 = this$0.u().o();
                QLog.i("AnchorRankView", 1, "isShowNativeRankList: " + o16);
                if (o16) {
                    this$0.C();
                } else {
                    String v3 = this$0.v(r16);
                    com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.l(com.tencent.timi.game.utils.b.d(this$0), ViewUtils.dip2px(472.0f), this$0.getContext().getResources().getDrawable(R.drawable.lsr), v3, null);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C() {
        int i3;
        Activity d16 = com.tencent.timi.game.utils.b.d(this);
        if (d16 != null && getContext() != null) {
            if (!d16.isFinishing() && !d16.isDestroyed()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                RankView rankView = new RankView(context);
                this.rankView = rankView;
                rankView.F0(u(), d16, u().l(), u().i(), u().m(), this.roomType);
                rankView.H0();
                Activity d17 = com.tencent.timi.game.utils.b.d(this);
                Intrinsics.checkNotNull(d17);
                RankView rankView2 = this.rankView;
                Intrinsics.checkNotNull(rankView2);
                com.tencent.timi.game.liveroom.impl.room.util.h hVar = new com.tencent.timi.game.liveroom.impl.room.util.h();
                hVar.t(false);
                hVar.v(-1);
                hVar.u((int) (ScreenUtils.getAppScreenHeight() * 0.58d));
                hVar.x(true);
                hVar.q(R.style.b0e);
                Unit unit = Unit.INSTANCE;
                final PopupWindow e16 = com.tencent.timi.game.liveroom.impl.room.util.g.e(d17, rankView2, hVar);
                PopupWindow popupWindow = this.popupWin;
                if (popupWindow != null) {
                    i3 = popupWindow.hashCode();
                } else {
                    i3 = 0;
                }
                lj4.a.c(i3, true);
                RankView rankView3 = this.rankView;
                if (rankView3 != null) {
                    SelfRankInfoView.b bVar = this.openGiftPanelListener;
                    if (bVar != null) {
                        rankView3.setOpenGiftPanelListener(bVar);
                    }
                    rankView3.setSelfRankViewClickListener(new SelfRankInfoView.c() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.v
                        @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView.c
                        public final void a() {
                            QQLiveRoomOnlineRankView.E(e16);
                        }
                    });
                }
                e16.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.w
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        QQLiveRoomOnlineRankView.D(QQLiveRoomOnlineRankView.this);
                    }
                });
                this.popupWin = e16;
                u().h(false, this.mQueryRankListCallback);
                return;
            }
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("AnchorRankView", "activity is Finishing or Destroyed!!");
            return;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("AnchorRankView", 1, "hostActivity: " + com.tencent.timi.game.utils.b.d(this) + ", context: " + getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(QQLiveRoomOnlineRankView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RankView rankView = this$0.rankView;
        if (rankView != null) {
            rankView.I0();
        }
        this$0.rankView = null;
        this$0.popupWin = null;
        lj4.a.c(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(PopupWindow this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (this_apply.isShowing()) {
            this_apply.dismiss();
        }
    }

    private final void G() {
        if (PreloadSwitch.INSTANCE.d()) {
            this.mAegisLog.i("AnchorRankView", "onlineRankUnEnable");
        } else {
            if (u().p()) {
                return;
            }
            u().h(false, this.mQueryRankListCallback);
            u().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(QQLiveRoomOnlineRankView this$0, long j3, uq4.c cVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDistroyed && this$0.u().l() == j3) {
            boolean g16 = BusConfigHelper.f378723a.g(1, cVar);
            this$0.mAegisLog.i("AnchorRankView", "onConfigUpdate roomId:" + j3 + " banRankList:" + g16 + " ");
            LinearLayout linearLayout = this$0.binding.f420788d;
            if (linearLayout != null) {
                fh4.g.o(linearLayout, !g16);
            }
            QQLiveRankRecyclerView qQLiveRankRecyclerView = this$0.binding.f420787c;
            if (qQLiveRankRecyclerView != null) {
                fh4.g.o(qQLiveRankRecyclerView, !g16);
            }
            this$0.u().w(!r0.g(5, cVar));
            return;
        }
        this$0.mAegisLog.e("AnchorRankView", "onConfigUpdate error " + j3 + " " + this$0.u().l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(OnlineRankData result) {
        z zVar;
        long j3;
        if (BusConfigHelper.f378723a.f(1, u().l())) {
            QLog.i("AnchorRankView", 2, "updateOnlineRankList rank list flag true");
            return;
        }
        RecyclerView.Adapter adapter = this.binding.f420787c.getAdapter();
        if (adapter instanceof z) {
            zVar = (z) adapter;
        } else {
            zVar = null;
        }
        if (zVar != null) {
            zVar.m0(this.itemClickListener);
        }
        if (result != null) {
            j3 = result.getOnlineCount();
        } else {
            j3 = 0;
        }
        this.onlineCount = j3;
        if (j3 > 0 && this.binding.f420788d.getVisibility() != 0) {
            this.binding.f420788d.setVisibility(0);
            this.binding.f420787c.setVisibility(0);
        }
        if (QLog.isDevelopLevel()) {
            this.mAegisLog.d("AnchorRankView", "queryOnlineRankList result:" + result);
        }
    }

    private final void o(View view, String elementId, Map<String, String> params) {
        ((ug4.a) mm4.b.b(ug4.a.class)).g(view, true, String.valueOf(view.hashCode()), elementId, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannableStringBuilder p(String prefixNumStr, String postfixTxt) {
        Typeface typeface = RFWTypefaceUtil.getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(prefixNumStr + postfixTxt);
        if (typeface != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                spannableStringBuilder.setSpan(new TypefaceSpan(typeface), 0, prefixNumStr.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new b(typeface), 0, prefixNumStr.length(), 33);
            }
        }
        return spannableStringBuilder;
    }

    private final Map<String, String> q() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        concurrentHashMap.put("userId", String.valueOf(cVar.G()));
        concurrentHashMap.put("anchorId", String.valueOf(cVar.d().f()));
        concurrentHashMap.put("roomId", String.valueOf(u().l()));
        concurrentHashMap.put("programId", cVar.d().l());
        concurrentHashMap.put("enterId", u().l() + "_" + cVar.d().l());
        concurrentHashMap.put("zhiboType", "0");
        concurrentHashMap.put("zhiboContent", String.valueOf(cVar.d().j()));
        return concurrentHashMap;
    }

    private final Map<String, String> s(boolean isClick) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        long l3 = u().l();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        String w3 = com.tencent.mobileqq.qqlive.sail.c.w(cVar, l3, 0, 2, null);
        concurrentHashMap.put("qqlive_user_id", String.valueOf(cVar.G()));
        concurrentHashMap.put("qqlive_room_id", String.valueOf(l3));
        concurrentHashMap.put("qqlive_program_id", w3);
        if (isClick) {
            concurrentHashMap.put("qqlive_clk_entertime", String.valueOf(System.currentTimeMillis()));
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.timi.game.liveroom.impl.room.view.rank.a t() {
        return (com.tencent.timi.game.liveroom.impl.room.view.rank.a) this.detailRankViewDataReadyListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RankViewModel u() {
        return (RankViewModel) this.rankViewModel.getValue();
    }

    private final String v(Map<String, String> reportMap) {
        String a16 = com.tencent.qqlive.common.webview.a.a(ht3.a.d("qqlive_rank_web_url", "https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/rank.html?_wv=16777216"), "appId=" + QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullExpressionValue(a16, "appendArgs(url, \"appId=$\u2026ssConfig.QQLIVE_APP_ID}\")");
        for (Map.Entry<String, String> entry : reportMap.entrySet()) {
            a16 = com.tencent.qqlive.common.webview.a.a(a16, ((Object) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) entry.getValue()));
            Intrinsics.checkNotNullExpressionValue(a16, "appendArgs(url, \"${entry.key}=${entry.value}\")");
        }
        String a17 = com.tencent.qqlive.common.webview.a.a(a16, "qqlivestream_sdk_app_id=" + QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullExpressionValue(a17, "appendArgs(url, \"qqlives\u2026ssConfig.QQLIVE_APP_ID}\")");
        this.mAegisLog.i("AnchorRankView", "[getRankWebUrl] url=" + ((Object) a17));
        return a17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long w(long size) {
        if (size >= 10) {
            long j3 = this.onlineCount;
            if (size <= j3) {
                return j3;
            }
            return size;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map z(QQLiveRoomOnlineRankView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "clck")) {
            return this$0.s(true);
        }
        return this$0.s(false);
    }

    public final boolean F() {
        PopupWindow popupWindow = this.popupWin;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public final void H(boolean isStart) {
        if (u().p()) {
            return;
        }
        u().h(isStart, this.mQueryRankListCallback);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isDistroyed = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoReport.setEventDynamicParams(this, null);
        this.isDistroyed = true;
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onEnterRoom(long roomId, boolean isAnchor) {
        u().x(roomId);
        u().t(isAnchor);
        this.isStart = true;
        setContentByConfig(roomId);
        if (u().p()) {
            return;
        }
        u().h(this.isStart, this.mQueryRankListCallback);
        u().g();
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onExitRoom(long roomId) {
        this.isStart = false;
        u().e();
        x();
        com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.b(roomId);
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageIn(long roomId) {
        u().x(roomId);
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageOut(long roomId) {
        u().x(roomId);
        this.isStart = false;
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPreload(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        u().x(roomId);
        u().t(isAnchor);
        G();
    }

    @NotNull
    public final Map<String, String> r(long roomId) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long n3 = SailAudienceRoomManager.n(cVar.m(), roomId, 0, 2, null);
        concurrentHashMap.put("userId", String.valueOf(cVar.G()));
        concurrentHashMap.put("anchorId", String.valueOf(SailAudienceRoomManager.i(cVar.m(), roomId, 0, 2, null)));
        concurrentHashMap.put("roomId", String.valueOf(roomId));
        concurrentHashMap.put("programId", SailAudienceRoomManager.r(cVar.m(), roomId, 0, 2, null));
        concurrentHashMap.put("enterId", cVar.G() + "_" + roomId + "_" + n3);
        concurrentHashMap.put("zhiboType", "0");
        concurrentHashMap.put("zhiboContent", "0");
        return concurrentHashMap;
    }

    public final void setAnchorId(long anchorUid) {
        u().u(anchorUid);
    }

    public final void setAudienceViewModel(@NotNull vi4.a audienceViewModel) {
        Intrinsics.checkNotNullParameter(audienceViewModel, "audienceViewModel");
        u().v(audienceViewModel);
    }

    public final void setContentByConfig(final long roomId) {
        final uq4.c cVar = BusConfigHelper.f378723a.j().get(Long.valueOf(roomId));
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.t
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveRoomOnlineRankView.I(QQLiveRoomOnlineRankView.this, roomId, cVar);
            }
        });
    }

    public final void setGiftEnableBtn(boolean show) {
        u().y(show);
    }

    public final void setOpenGiftPanelListener(@Nullable SelfRankInfoView.b listener) {
        this.openGiftPanelListener = listener;
    }

    public final void setRoomType(int i3) {
        this.roomType = i3;
    }

    public final void setStart(boolean z16) {
        this.isStart = z16;
    }

    public final void x() {
        PopupWindow popupWindow = this.popupWin;
        boolean z16 = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        }
        if (z16) {
            PopupWindow popupWindow2 = this.popupWin;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
            }
            this.popupWin = null;
        }
    }

    public final void y() {
        QQLiveRankRecyclerView qQLiveRankRecyclerView = this.binding.f420787c;
        if (qQLiveRankRecyclerView != null) {
            qQLiveRankRecyclerView.C();
            o(qQLiveRankRecyclerView, "em_qqlive_top_user", new HashMap<>());
        }
        this.rankArrawIv = (ImageView) findViewById(R.id.f70163kp);
        d.a.a(((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil(), this, false, null, "em_qqlive_online_audience_list_entry", s(false), 6, null);
        VideoReport.setEventDynamicParams(this, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.u
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map z16;
                z16 = QQLiveRoomOnlineRankView.z(QQLiveRoomOnlineRankView.this, str);
                return z16;
            }
        });
    }

    public QQLiveRoomOnlineRankView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        this.queryInterval = 2000L;
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveRoomOnlineRankView$rankViewModel$2.INSTANCE);
        this.rankViewModel = lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        ad f16 = ad.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mQueryRankListCallback = new c();
        this.itemClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveRoomOnlineRankView.B(QQLiveRoomOnlineRankView.this, view);
            }
        };
        lazy2 = LazyKt__LazyJVMKt.lazy(new QQLiveRoomOnlineRankView$detailRankViewDataReadyListener$2(this));
        this.detailRankViewDataReadyListener = lazy2;
    }

    public QQLiveRoomOnlineRankView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        this.queryInterval = 2000L;
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveRoomOnlineRankView$rankViewModel$2.INSTANCE);
        this.rankViewModel = lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        ad f16 = ad.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mQueryRankListCallback = new c();
        this.itemClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveRoomOnlineRankView.B(QQLiveRoomOnlineRankView.this, view);
            }
        };
        lazy2 = LazyKt__LazyJVMKt.lazy(new QQLiveRoomOnlineRankView$detailRankViewDataReadyListener$2(this));
        this.detailRankViewDataReadyListener = lazy2;
    }
}

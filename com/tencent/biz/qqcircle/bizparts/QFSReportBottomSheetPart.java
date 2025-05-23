package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleReportRequest;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QFSReportReasonItemView;
import com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QFSReportResultEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSShowReportBottomSheetEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import trpc.feedcloud.tip_off.SubmitTipOffRsp;

@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 k2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004lmn$B\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0004J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 `!H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010Q\u001a\u0004\u0018\u00010J8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010R8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010]\u001a\b\u0018\u00010ZR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R$\u0010e\u001a\u0004\u0018\u00010^8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010g\u00a8\u0006o"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qcircle/api/event/QFSShowReportBottomSheetEvent;", "", "S9", "ca", "J9", "event", "T9", "aa", "initListener", "H9", "X9", "", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Z9", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Landroid/view/View;", "P9", "Y9", "R9", "Q9", "ba", "G9", LocaleUtils.L_JAPANESE, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView;", "d", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView;", "mReportBottomSheet", "Lfeedcloud/FeedCloudMeta$StFeed;", "e", "Lfeedcloud/FeedCloudMeta$StFeed;", "L9", "()Lfeedcloud/FeedCloudMeta$StFeed;", "ea", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "mFeed", "Lfeedcloud/FeedCloudMeta$StBarrage;", "f", "Lfeedcloud/FeedCloudMeta$StBarrage;", "mBarrage", "Lfeedcloud/FeedCloudMeta$StComment;", tl.h.F, "Lfeedcloud/FeedCloudMeta$StComment;", "mComment", "Lfeedcloud/FeedCloudMeta$StReply;", "i", "Lfeedcloud/FeedCloudMeta$StReply;", "mReply", "Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent$ReportType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qcircle/api/event/QFSReportResultEvent$ReportType;", "mReportType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mContentView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "O9", "()Landroid/widget/TextView;", "ia", "(Landroid/widget/TextView;)V", "mTitleView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "K9", "()Landroid/widget/ImageView;", "da", "(Landroid/widget/ImageView;)V", "mCloseBtn", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "M9", "()Landroidx/recyclerview/widget/RecyclerView;", "ga", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReasonList", "Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$c;", "G", "Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$c;", "mReasonAdapter", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "H", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "N9", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "ha", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "mSubmitBtn", "", "I", "mPreNavColor", "<init>", "()V", "J", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class QFSReportBottomSheetPart extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver<QFSShowReportBottomSheetEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View mContentView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView mTitleView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView mCloseBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mReasonList;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private c mReasonAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QUIButton mSubmitBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private int mPreNavColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSCommonBottomSheetView mReportBottomSheet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StBarrage mBarrage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StComment mComment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StReply mReply;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSReportResultEvent.ReportType mReportType;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", ReportConstant.COSTREPORT_PREFIX, "", "", "getDynamicParams", "", "a", "I", "getType", "()I", "type", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;", "b", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "mWrfPart", "part", "<init>", "(Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;ILcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.avatar.meta.refresh.c<QFSReportBottomSheetPart> mWrfPart;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QFSReportBottomSheetPart f82804c;

        public b(QFSReportBottomSheetPart qFSReportBottomSheetPart, @NotNull int i3, QFSReportBottomSheetPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.f82804c = qFSReportBottomSheetPart;
            this.type = i3;
            this.mWrfPart = new com.tencent.qqnt.avatar.meta.refresh.c<>(part);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String s16) {
            String str;
            String str2;
            String str3;
            FeedCloudMeta$StUser feedCloudMeta$StUser;
            PBStringField pBStringField;
            PBStringField pBStringField2;
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            QFSReportBottomSheetPart qFSReportBottomSheetPart = this.mWrfPart.get();
            if (qFSReportBottomSheetPart != null) {
                if (qFSReportBottomSheetPart.mBarrage != null) {
                    str = "bullet";
                } else {
                    str = "cmt";
                }
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put(QCircleDaTongConstant.ElementParamKey.XSJ_POPUP_TYPE, str);
                FeedCloudMeta$StFeed mFeed = qFSReportBottomSheetPart.getMFeed();
                String str4 = null;
                if (mFeed != null && (pBStringField2 = mFeed.f398449id) != null) {
                    str2 = pBStringField2.get();
                } else {
                    str2 = null;
                }
                String str5 = "";
                if (str2 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "it.mFeed?.id?.get() ?: \"\"");
                }
                params.put("xsj_feed_id", str2);
                FeedCloudMeta$StFeed mFeed2 = qFSReportBottomSheetPart.getMFeed();
                if (mFeed2 != null && (feedCloudMeta$StUser = mFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
                    str3 = pBStringField.get();
                } else {
                    str3 = null;
                }
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "it.mFeed?.poster?.id?.get() ?: \"\"");
                    str5 = str3;
                }
                params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str5);
                if (2 == this.type) {
                    c cVar = qFSReportBottomSheetPart.mReasonAdapter;
                    if (cVar != null) {
                        str4 = cVar.j0();
                    }
                    params.put(QCircleDaTongConstant.ElementParamKey.XSJ_REASON, str4);
                }
            }
            Intrinsics.checkNotNullExpressionValue(params, "params");
            return params;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\n\u0010\r\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0016j\b\u0012\u0004\u0012\u00020\u0013`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0016j\b\u0012\u0004\u0012\u00020\u0013`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R)\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$d;", "Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;", "Lcom/tencent/biz/qqcircle/widgets/QFSReportReasonItemView$b;", "", com.tencent.luggage.wxa.c8.c.G, "", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "m0", "getItemCount", "holder", "l0", "", "isSelect", "a0", "n0", "", "k0", "j0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mDataList", BdhLogUtil.LogTag.Tag_Conn, "mDataType", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "D", "Landroidx/lifecycle/MutableLiveData;", "i0", "()Landroidx/lifecycle/MutableLiveData;", "mSelectResult", "<init>", "(Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class c extends RecyclerView.Adapter<d> implements QFSReportReasonItemView.b {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final ArrayList<String> mDataType;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final MutableLiveData<Pair<Integer, String>> mSelectResult;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<String> mDataList;

        public c() {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mDataList = arrayList;
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.mDataType = arrayList2;
            this.mSelectResult = new MutableLiveData<>(new Pair(-1, ""));
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
            byte[] bytes = "{\"5\":\"\u8272\u60c5\u4f4e\u4fd7\",\"7\":\"\u4e0d\u5b9e\u4fe1\u606f\",\"10\":\"\u7f51\u7edc\u66b4\u529b\",\"1\":\"\u653f\u6cbb\u654f\u611f\",\"4\":\"\u5e7f\u544a\u5f15\u6d41\",\"3\":\"\u6d89\u5acc\u6b3a\u8bc8\",\"2\":\"\u8fdd\u6cd5\u8fdd\u89c4\",\"12\":\"\u672a\u6210\u5e74\u4e0d\u5f53\",\"13\":\"\u5176\u4ed6\"}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] loadRawConfig = iUnitedConfigManager.loadRawConfig("qqcircle_report_bottom_sheet_reason_list", bytes);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(loadRawConfig, UTF_8));
            arrayList.clear();
            arrayList2.clear();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonConfig.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.mDataList.add(jSONObject.optString(str));
                this.mDataType.add(str);
            }
        }

        private final void o0(int pos) {
            View view;
            RecyclerView.LayoutManager layoutManager;
            RecyclerView mReasonList = QFSReportBottomSheetPart.this.getMReasonList();
            if (mReasonList != null && (layoutManager = mReasonList.getLayoutManager()) != null) {
                view = layoutManager.findViewByPosition(pos);
            } else {
                view = null;
            }
            if (view instanceof QFSReportReasonItemView) {
                ((QFSReportReasonItemView) view).d();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSReportReasonItemView.b
        public void a0(int pos, boolean isSelect) {
            int i3;
            Pair<Integer, String> value = this.mSelectResult.getValue();
            if (value != null) {
                i3 = value.getFirst().intValue();
            } else {
                i3 = -1;
            }
            if (i3 == pos && !isSelect) {
                this.mSelectResult.setValue(new Pair<>(-1, ""));
            } else if (i3 != -1 && i3 != pos) {
                o0(i3);
            }
            if (isSelect) {
                MutableLiveData<Pair<Integer, String>> mutableLiveData = this.mSelectResult;
                Integer valueOf = Integer.valueOf(pos);
                String str = this.mDataList.get(pos);
                Intrinsics.checkNotNullExpressionValue(str, "mDataList[pos]");
                mutableLiveData.setValue(new Pair<>(valueOf, str));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.mDataList.size();
        }

        @NotNull
        public final MutableLiveData<Pair<Integer, String>> i0() {
            return this.mSelectResult;
        }

        @NotNull
        public final String j0() {
            int i3;
            Pair<Integer, String> value = this.mSelectResult.getValue();
            if (value != null) {
                i3 = value.getFirst().intValue();
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && i3 < this.mDataList.size()) {
                String str = this.mDataList.get(i3);
                Intrinsics.checkNotNullExpressionValue(str, "mDataList[pos]");
                return str;
            }
            return "";
        }

        @NotNull
        public final String k0() {
            int i3;
            Pair<Integer, String> value = this.mSelectResult.getValue();
            if (value != null) {
                i3 = value.getFirst().intValue();
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && i3 < this.mDataType.size()) {
                String str = this.mDataType.get(i3);
                Intrinsics.checkNotNullExpressionValue(str, "mDataType[pos]");
                return str;
            }
            return "";
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int pos) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (pos >= this.mDataList.size()) {
                return;
            }
            View view = holder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.biz.qqcircle.widgets.QFSReportReasonItemView");
            QFSReportReasonItemView qFSReportReasonItemView = (QFSReportReasonItemView) view;
            String str = this.mDataList.get(pos);
            Intrinsics.checkNotNullExpressionValue(str, "mDataList[pos]");
            qFSReportReasonItemView.a(str, pos);
            qFSReportReasonItemView.b(this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int pos) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            QFSReportReasonItemView qFSReportReasonItemView = new QFSReportReasonItemView(context);
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = DisplayUtil.dip2px(parent.getContext(), 6.5f);
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = DisplayUtil.dip2px(parent.getContext(), 6.5f);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = DisplayUtil.dip2px(parent.getContext(), 6.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = DisplayUtil.dip2px(parent.getContext(), 6.0f);
            qFSReportReasonItemView.setLayoutParams(layoutParams);
            return new d(QFSReportBottomSheetPart.this, qFSReportReasonItemView);
        }

        public final void n0() {
            Pair<Integer, String> value = this.mSelectResult.getValue();
            if (value != null) {
                int intValue = value.getFirst().intValue();
                if (intValue != -1) {
                    o0(intValue);
                }
                this.mSelectResult.setValue(new Pair<>(-1, ""));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class d extends RecyclerView.ViewHolder {
        final /* synthetic */ QFSReportBottomSheetPart E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull QFSReportBottomSheetPart qFSReportBottomSheetPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = qFSReportBottomSheetPart;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$e", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$b;", "", "d", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements QFSCommonBottomSheetView.b {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.b
        public void a() {
            if (QFSReportBottomSheetPart.this.getContext() == null || !com.tencent.biz.qqcircle.helpers.i.f84624a.a(String.valueOf(QFSReportBottomSheetPart.this.getContext().hashCode()))) {
                com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSReportBottomSheetPart.this.getContext(), true);
            }
            QFSReportBottomSheetPart.this.Q9();
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.b
        public /* synthetic */ void b() {
            sc0.c.c(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.b
        public /* synthetic */ void c() {
            sc0.c.b(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.b
        public void d() {
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSReportBottomSheetPart.this.getContext(), false);
            QFSReportBottomSheetPart.this.R9();
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.b
        public /* synthetic */ void e() {
            sc0.c.d(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.b
        public /* synthetic */ void f(float f16) {
            sc0.c.a(this, f16);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart$f", "Lcom/tencent/biz/qqcircle/widgets/sheet/QFSCommonBottomSheetView$c;", "", "c", "Landroid/view/View;", "getContentView", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f implements QFSCommonBottomSheetView.c {
        f() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public boolean a() {
            return true;
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ boolean b() {
            return sc0.d.d(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public int c() {
            return -2;
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        @Nullable
        public View getContentView() {
            TextView textView;
            ImageView imageView;
            RecyclerView recyclerView;
            if (QFSReportBottomSheetPart.this.mContentView == null) {
                QFSReportBottomSheetPart qFSReportBottomSheetPart = QFSReportBottomSheetPart.this;
                QUIButton qUIButton = null;
                qFSReportBottomSheetPart.mContentView = LayoutInflater.from(qFSReportBottomSheetPart.getContext()).inflate(R.layout.gqc, (ViewGroup) null, false);
                QFSReportBottomSheetPart qFSReportBottomSheetPart2 = QFSReportBottomSheetPart.this;
                View view = qFSReportBottomSheetPart2.mContentView;
                if (view != null) {
                    textView = (TextView) view.findViewById(R.id.f52232_9);
                } else {
                    textView = null;
                }
                qFSReportBottomSheetPart2.ia(textView);
                QFSReportBottomSheetPart qFSReportBottomSheetPart3 = QFSReportBottomSheetPart.this;
                View view2 = qFSReportBottomSheetPart3.mContentView;
                if (view2 != null) {
                    imageView = (ImageView) view2.findViewById(R.id.f520729t);
                } else {
                    imageView = null;
                }
                qFSReportBottomSheetPart3.da(imageView);
                QFSReportBottomSheetPart qFSReportBottomSheetPart4 = QFSReportBottomSheetPart.this;
                View view3 = qFSReportBottomSheetPart4.mContentView;
                if (view3 != null) {
                    recyclerView = (RecyclerView) view3.findViewById(R.id.f52192_5);
                } else {
                    recyclerView = null;
                }
                qFSReportBottomSheetPart4.ga(recyclerView);
                QFSReportBottomSheetPart qFSReportBottomSheetPart5 = QFSReportBottomSheetPart.this;
                View view4 = qFSReportBottomSheetPart5.mContentView;
                if (view4 != null) {
                    qUIButton = (QUIButton) view4.findViewById(R.id.f52222_8);
                }
                qFSReportBottomSheetPart5.ha(qUIButton);
            }
            return QFSReportBottomSheetPart.this.mContentView;
        }

        @Override // com.tencent.biz.qqcircle.widgets.sheet.QFSCommonBottomSheetView.c
        public /* synthetic */ int getMaxHeight() {
            return sc0.d.e(this);
        }
    }

    private final void H9() {
        final boolean z16;
        PBStringField pBStringField;
        String str;
        String str2;
        String str3;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StBarrage feedCloudMeta$StBarrage = this.mBarrage;
        if (feedCloudMeta$StBarrage == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str4 = null;
        if (!z16 ? !(feedCloudMeta$StBarrage == null || (pBStringField = feedCloudMeta$StBarrage.f398446id) == null) : !((feedCloudMeta$StComment = this.mComment) == null || (pBStringField = feedCloudMeta$StComment.f398447id) == null)) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        FeedCloudMeta$StFeed mFeed = getMFeed();
        if (mFeed != null && (pBStringField3 = mFeed.f398449id) != null) {
            str2 = pBStringField3.get();
        } else {
            str2 = null;
        }
        FeedCloudMeta$StReply feedCloudMeta$StReply = this.mReply;
        if (feedCloudMeta$StReply != null && (pBStringField2 = feedCloudMeta$StReply.f398460id) != null) {
            str3 = pBStringField2.get();
        } else {
            str3 = null;
        }
        c cVar = this.mReasonAdapter;
        if (cVar != null) {
            str4 = cVar.k0();
        }
        final QCircleReportRequest qCircleReportRequest = new QCircleReportRequest(str2, str, str3, z16, str4);
        VSNetworkHelper.getInstance().sendRequest(qCircleReportRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.di
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str5, Object obj) {
                QFSReportBottomSheetPart.I9(QCircleReportRequest.this, z16, this, baseRequest, z17, j3, str5, (SubmitTipOffRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QCircleReportRequest request, boolean z16, QFSReportBottomSheetPart this$0, BaseRequest baseRequest, boolean z17, long j3, String errMsg, SubmitTipOffRsp submitTipOffRsp) {
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str5;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        String str6;
        PBStringField pBStringField5;
        PBStringField pBStringField6;
        PBStringField pBStringField7;
        PBStringField pBStringField8;
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        String str7 = null;
        if (baseRequest != null) {
            str = baseRequest.getTraceId();
        } else {
            str = null;
        }
        QLog.d("QFSReportBottomSheetPart", 1, "[onReceive] -> request = " + request + " , traceId : " + str + " , isSuccess : " + z17 + " , retCode : " + j3 + " , errMsg : " + errMsg);
        if (z17 && submitTipOffRsp != null && j3 == 0) {
            if (z16) {
                i3 = R.string.f181813es;
            } else {
                i3 = R.string.f19043423;
            }
            QCircleToast.l(QCircleToast.f91646f, this$0.getContext().getResources().getString(R.string.f194894d5, com.tencent.biz.qqcircle.utils.h.a(i3)), 0, true, false);
            QFSReportResultEvent.ReportType reportType = this$0.mReportType;
            FeedCloudMeta$StFeed mFeed = this$0.getMFeed();
            FeedCloudMeta$StBarrage feedCloudMeta$StBarrage = this$0.mBarrage;
            FeedCloudMeta$StComment feedCloudMeta$StComment = this$0.mComment;
            if (feedCloudMeta$StComment != null && (pBStringField8 = feedCloudMeta$StComment.f398447id) != null) {
                str2 = pBStringField8.get();
            } else {
                str2 = null;
            }
            FeedCloudMeta$StReply feedCloudMeta$StReply = this$0.mReply;
            if (feedCloudMeta$StReply != null && (pBStringField7 = feedCloudMeta$StReply.f398460id) != null) {
                str3 = pBStringField7.get();
            } else {
                str3 = null;
            }
            QFSReportResultEvent qFSReportResultEvent = new QFSReportResultEvent(reportType, mFeed, feedCloudMeta$StBarrage, str2, str3);
            qFSReportResultEvent.mHashCode = this$0.getActivityHashCode();
            SimpleEventBus.getInstance().dispatchEvent(qFSReportResultEvent);
            if (this$0.mBarrage != null) {
                FeedCloudMeta$StFeed mFeed2 = this$0.getMFeed();
                if (mFeed2 != null && (pBStringField6 = mFeed2.f398449id) != null) {
                    str6 = pBStringField6.get();
                } else {
                    str6 = null;
                }
                FeedCloudMeta$StBarrage feedCloudMeta$StBarrage2 = this$0.mBarrage;
                if (feedCloudMeta$StBarrage2 != null && (pBStringField5 = feedCloudMeta$StBarrage2.f398446id) != null) {
                    str7 = pBStringField5.get();
                }
                com.tencent.biz.qqcircle.utils.cg.a(str6, str7);
                return;
            }
            if (this$0.mReply != null) {
                FeedCloudMeta$StFeed mFeed3 = this$0.getMFeed();
                if (mFeed3 != null && (pBStringField4 = mFeed3.f398449id) != null) {
                    str5 = pBStringField4.get();
                } else {
                    str5 = null;
                }
                FeedCloudMeta$StReply feedCloudMeta$StReply2 = this$0.mReply;
                if (feedCloudMeta$StReply2 != null && (pBStringField3 = feedCloudMeta$StReply2.f398460id) != null) {
                    str7 = pBStringField3.get();
                }
                com.tencent.biz.qqcircle.utils.cg.c(str5, str7);
                return;
            }
            FeedCloudMeta$StFeed mFeed4 = this$0.getMFeed();
            if (mFeed4 != null && (pBStringField2 = mFeed4.f398449id) != null) {
                str4 = pBStringField2.get();
            } else {
                str4 = null;
            }
            FeedCloudMeta$StComment feedCloudMeta$StComment2 = this$0.mComment;
            if (feedCloudMeta$StComment2 != null && (pBStringField = feedCloudMeta$StComment2.f398447id) != null) {
                str7 = pBStringField.get();
            }
            com.tencent.biz.qqcircle.utils.cg.b(str4, str7);
        }
    }

    private final void J9() {
        VideoReport.setElementId(P9(), QCircleDaTongConstant.ElementId.EM_XSJ_REPORT_POP);
        VideoReport.setEventDynamicParams(P9(), new b(this, 1, this));
        VideoReport.setElementExposePolicy(P9(), ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(P9(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(getMSubmitBtn(), QCircleDaTongConstant.ElementId.EM_XSJ_REPORT_POP_SUBMIT);
        VideoReport.setEventDynamicParams(getMSubmitBtn(), new b(this, 2, this));
        VideoReport.setElementExposePolicy(getMSubmitBtn(), ExposurePolicy.REPORT_NONE);
    }

    private final void S9() {
        ViewStub viewStub;
        if (getPartRootView() == null || (viewStub = (ViewStub) getPartRootView().findViewById(R.id.f520629s)) == null) {
            return;
        }
        viewStub.inflate();
        Z9();
        X9();
        initListener();
        J9();
    }

    private final void T9(QFSShowReportBottomSheetEvent event) {
        QFSReportResultEvent.ReportType reportType;
        ea(event.getFeed());
        this.mBarrage = event.getBarrage();
        this.mComment = event.getComment();
        FeedCloudMeta$StReply reply = event.getReply();
        this.mReply = reply;
        if (this.mBarrage != null) {
            reportType = QFSReportResultEvent.ReportType.BARRAGE;
        } else if (reply != null) {
            reportType = QFSReportResultEvent.ReportType.REPLY;
        } else {
            reportType = QFSReportResultEvent.ReportType.COMMENT;
        }
        this.mReportType = reportType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QFSReportBottomSheetPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QFSReportBottomSheetPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f194864d2), 0, true, false);
        } else {
            this$0.H9();
            this$0.G9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X9() {
        this.mReasonAdapter = new c();
        RecyclerView mReasonList = getMReasonList();
        if (mReasonList != null) {
            mReasonList.setLayoutManager(new GridLayoutManager(mReasonList.getContext(), 3));
            mReasonList.setAdapter(this.mReasonAdapter);
        }
    }

    private final void aa() {
        int i3;
        TextView mTitleView = getMTitleView();
        if (mTitleView != null) {
            if (this.mBarrage != null) {
                i3 = R.string.f194844d0;
            } else {
                i3 = R.string.f194854d1;
            }
            mTitleView.setText(com.tencent.biz.qqcircle.utils.h.a(i3));
        }
    }

    private final void ca() {
        aa();
        c cVar = this.mReasonAdapter;
        if (cVar != null) {
            cVar.n0();
        }
    }

    private final void initListener() {
        MutableLiveData<Pair<Integer, String>> i06;
        Y9();
        ImageView mCloseBtn = getMCloseBtn();
        if (mCloseBtn != null) {
            mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.df
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSReportBottomSheetPart.U9(QFSReportBottomSheetPart.this, view);
                }
            });
        }
        QUIButton mSubmitBtn = getMSubmitBtn();
        if (mSubmitBtn != null) {
            mSubmitBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.dg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSReportBottomSheetPart.V9(QFSReportBottomSheetPart.this, view);
                }
            });
        }
        c cVar = this.mReasonAdapter;
        if (cVar != null && (i06 = cVar.i0()) != null) {
            final Function1<Pair<? extends Integer, ? extends String>, Unit> function1 = new Function1<Pair<? extends Integer, ? extends String>, Unit>() { // from class: com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart$initListener$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends String> pair) {
                    invoke2((Pair<Integer, String>) pair);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Pair<Integer, String> pair) {
                    QUIButton mSubmitBtn2 = QFSReportBottomSheetPart.this.getMSubmitBtn();
                    if (mSubmitBtn2 == null) {
                        return;
                    }
                    mSubmitBtn2.setEnabled(pair.getSecond().length() > 0);
                }
            };
            i06.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.dh
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QFSReportBottomSheetPart.W9(Function1.this, obj);
                }
            });
        }
    }

    public void G9() {
        QFSCommonBottomSheetView qFSCommonBottomSheetView = this.mReportBottomSheet;
        if (qFSCommonBottomSheetView != null) {
            qFSCommonBottomSheetView.l();
        }
    }

    @Nullable
    /* renamed from: K9, reason: from getter */
    public ImageView getMCloseBtn() {
        return this.mCloseBtn;
    }

    @Nullable
    /* renamed from: L9, reason: from getter */
    public FeedCloudMeta$StFeed getMFeed() {
        return this.mFeed;
    }

    @Nullable
    /* renamed from: M9, reason: from getter */
    public RecyclerView getMReasonList() {
        return this.mReasonList;
    }

    @Nullable
    /* renamed from: N9, reason: from getter */
    public QUIButton getMSubmitBtn() {
        return this.mSubmitBtn;
    }

    @Nullable
    /* renamed from: O9, reason: from getter */
    public TextView getMTitleView() {
        return this.mTitleView;
    }

    @Nullable
    public View P9() {
        return this.mReportBottomSheet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q9() {
        String str;
        PBStringField pBStringField;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed mFeed = getMFeed();
        if (mFeed != null && (pBStringField = mFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(37, str, false));
        VideoReport.traversePage(P9());
        com.tencent.biz.qqcircle.immersive.utils.r.a1(getContext(), this.mPreNavColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R9() {
        String str;
        PBStringField pBStringField;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed mFeed = getMFeed();
        if (mFeed != null && (pBStringField = mFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(37, str, true));
        VideoReport.traversePage(P9());
        this.mPreNavColor = com.tencent.biz.qqcircle.immersive.utils.r.p(getContext());
        com.tencent.biz.qqcircle.immersive.utils.r.a1(getContext(), QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_middle_light));
    }

    public void Y9() {
        QFSCommonBottomSheetView qFSCommonBottomSheetView = this.mReportBottomSheet;
        if (qFSCommonBottomSheetView != null) {
            qFSCommonBottomSheetView.setStateListener(new e());
        }
    }

    public void Z9() {
        if (this.mContentView != null) {
            return;
        }
        QFSCommonBottomSheetView qFSCommonBottomSheetView = (QFSCommonBottomSheetView) getPartRootView().findViewById(R.id.f520529r);
        this.mReportBottomSheet = qFSCommonBottomSheetView;
        if (qFSCommonBottomSheetView != null) {
            qFSCommonBottomSheetView.setConfig(new f());
        }
        com.tencent.mobileqq.qui.b.f276860a.a(this.mContentView, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
    }

    public boolean ba() {
        QFSCommonBottomSheetView qFSCommonBottomSheetView = this.mReportBottomSheet;
        if (qFSCommonBottomSheetView != null) {
            return qFSCommonBottomSheetView.s();
        }
        return false;
    }

    public void da(@Nullable ImageView imageView) {
        this.mCloseBtn = imageView;
    }

    public void ea(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
    }

    public void ga(@Nullable RecyclerView recyclerView) {
        this.mReasonList = recyclerView;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSShowReportBottomSheetEvent>> getEventClass() {
        ArrayList<Class<QFSShowReportBottomSheetEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSShowReportBottomSheetEvent.class);
        return arrayListOf;
    }

    public void ha(@Nullable QUIButton qUIButton) {
        this.mSubmitBtn = qUIButton;
    }

    public void ia(@Nullable TextView textView) {
        this.mTitleView = textView;
    }

    public void ja() {
        QFSCommonBottomSheetView qFSCommonBottomSheetView = this.mReportBottomSheet;
        if (qFSCommonBottomSheetView != null) {
            qFSCommonBottomSheetView.u();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!ba()) {
            return super.onBackEvent();
        }
        G9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSShowReportBottomSheetEvent) {
            QFSShowReportBottomSheetEvent qFSShowReportBottomSheetEvent = (QFSShowReportBottomSheetEvent) event;
            if (qFSShowReportBottomSheetEvent.mHashCode == getActivityHashCode()) {
                T9(qFSShowReportBottomSheetEvent);
                S9();
                ca();
                ja();
            }
        }
    }
}

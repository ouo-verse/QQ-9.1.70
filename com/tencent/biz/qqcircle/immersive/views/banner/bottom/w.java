package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSSendMsgResultEvent;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J4\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0017J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b`\u001cH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010 \u00a8\u0006/"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/w;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "showEmojiPanel", "", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "", "event", "eid", "", "", "extParams", "y", "isElementCanActivate", "onElementActivated", "onElementInactivated", "", "getPriority", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/View;", "D", "Landroid/view/View;", "mBottomBannerWrapper", "mBanner", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mFriendNick", "G", "mEmojiIcon", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class w extends c implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static ArrayList<String> I = new ArrayList<>();

    @NotNull
    private static final HashMap<String, String> J = new HashMap<>();

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mBottomBannerWrapper;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mBanner;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mFriendNick;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View mEmojiIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR7\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/w$a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mInputCacheList", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.banner.bottom.w$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashMap<String, String> a() {
            return w.J;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/w$b", "Lcom/tencent/biz/qqcircle/comment/QFSBaseInputPopupWindow$b;", "", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QFSBaseInputPopupWindow.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
        public void a() {
            String str;
            Map mapOf;
            w.this.A();
            com.tencent.biz.qqcircle.comment.u K = QFSCommentHelper.L().K();
            if (K != null) {
                str = K.g0();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            w wVar = w.this;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("xsj_text_content", str));
            wVar.y("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SEND_MSG_PANEL_SEND_BTN, mapOf);
            com.tencent.biz.qqcircle.comment.u K2 = QFSCommentHelper.L().K();
            if (K2 != null) {
                K2.dismiss();
            }
            w.INSTANCE.a().remove(w.this.l());
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
        public void b() {
            String str;
            HashMap<String, String> a16 = w.INSTANCE.a();
            String feedId = w.this.l();
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            com.tencent.biz.qqcircle.comment.u K = QFSCommentHelper.L().K();
            if (K != null) {
                str = K.f0();
            } else {
                str = null;
            }
            a16.put(feedId, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        String str;
        if (fb0.a.b("QFSFeedSendMsgToQQFriendView", 500L)) {
            return;
        }
        QCircleShareInfo c16 = au.c(this.f90602e);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        c16.feed = feedCloudMeta$StFeed;
        c16.silentShareType = 2;
        c16.mShareUin = feedCloudMeta$StFeed.poster.f398463id.get();
        c16.mShareUinType = 0;
        c16.mShareUinName = this.f90602e.poster.nick.get();
        com.tencent.biz.qqcircle.comment.u K = QFSCommentHelper.L().K();
        if (K == null || (str = K.f0()) == null) {
            str = "";
        }
        c16.mDirectShowMsg = str;
        c16.mNeedShowShareDialog = false;
        t40.a o16 = o();
        if (o16 != null) {
            o16.onHandlerMessage("event_silent_share", c16);
        }
    }

    private final void B() {
        if (this.mBanner != null) {
            return;
        }
        this.mBottomBannerWrapper = this.f90604h.findViewById(R.id.f34340yw);
        View findViewById = this.f90604h.findViewById(R.id.f54512fe);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026g_to_qq_friend_view_stub)");
        View inflate = ((ViewStub) findViewById).inflate();
        this.mBanner = inflate.findViewById(R.id.f54492fc);
        this.mFriendNick = (TextView) inflate.findViewById(R.id.f54502fd);
        this.mEmojiIcon = inflate.findViewById(R.id.f54482fb);
        z(this, "ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SEND_MSG_PANEL, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(w this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(w this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E(boolean showEmojiPanel) {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSFeedSendMsgToQQFriendView", 1, "[openCommentInputWindow] forbid fast share because of sencebeat");
            return;
        }
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.activity = (Activity) j();
        CharSequence charSequence = null;
        QFSFeedCommentInfo qFSFeedCommentInfo = new QFSFeedCommentInfo(this.f90602e, null, null);
        TextView textView = this.mFriendNick;
        if (textView != null) {
            charSequence = textView.getText();
        }
        qFSFeedCommentInfo.mHintText = String.valueOf(charSequence);
        qFSCommentInputWindowConfig.commentInfo = qFSFeedCommentInfo;
        qFSFeedCommentInfo.mCommentText = J.get(l());
        qFSCommentInputWindowConfig.needShowAtIcon = false;
        qFSCommentInputWindowConfig.needShowRecommendBar = false;
        qFSCommentInputWindowConfig.needShowFavoriteTab = false;
        qFSCommentInputWindowConfig.isShowEmoji = showEmojiPanel;
        qFSCommentInputWindowConfig.isShowPostBtn = !TextUtils.isEmpty(r4.get(l()));
        qFSCommentInputWindowConfig.isAllowAiComment = false;
        qFSCommentInputWindowConfig.reportBean = p();
        if (QFSCommentHelper.L().z0(qFSCommentInputWindowConfig, new b())) {
            QLog.d("QFSFeedSendMsgToQQFriendView", 1, "showSendMsgInputWindow");
            z(this, "ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SEND_MSG_PANEL, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String event, String eid, Map<String, ? extends Object> extParams) {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_feed_id", l());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        String str2 = null;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        params.put("xsj_eid", eid);
        QCircleReportBean p16 = p();
        if (p16 != null) {
            str2 = p16.getDtPageId();
        }
        params.put("xsj_custom_pgid", str2);
        if (extParams != null) {
            params.putAll(extParams);
        }
        VideoReport.reportEvent(event, params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void z(w wVar, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        wVar.y(str, str2, map);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSSendMsgResultEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 126;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean z16;
        PBRepeatField<Integer> pBRepeatField;
        List<Integer> list;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && (list = pBRepeatField.get()) != null) {
            z16 = list.contains(55);
        } else {
            z16 = false;
        }
        if (!z16 || I.contains(l())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onDestroy() {
        super.onDestroy();
        J.clear();
        I.clear();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    @SuppressLint({"SetTextI18n"})
    public void onElementActivated() {
        B();
        View view = this.mBanner;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.mFriendNick;
        if (textView != null) {
            textView.setText("\u53d1\u6d88\u606f\u7ed9 " + this.f90602e.poster.nick.get());
        }
        View view2 = this.mBottomBannerWrapper;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mBanner;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    w.C(w.this, view4);
                }
            });
        }
        View view4 = this.mEmojiIcon;
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    w.D(w.this, view5);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        View view = this.mBanner;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mBottomBannerWrapper;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSSendMsgResultEvent) {
            QFSSendMsgResultEvent qFSSendMsgResultEvent = (QFSSendMsgResultEvent) event;
            if (qFSSendMsgResultEvent.getSendSuccess() && TextUtils.equals(l(), qFSSendMsgResultEvent.getFeedId())) {
                onElementInactivated();
                I.add(l());
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
}

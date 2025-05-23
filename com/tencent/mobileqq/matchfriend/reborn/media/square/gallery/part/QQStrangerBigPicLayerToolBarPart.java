package com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerBigPicDeleteFeedSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerBigPicUpdateLikeFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerReportFeedSubmitEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002J\u001a\u0010,\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00100\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00104\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030201j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000302`3H\u0016R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR#\u0010I\u001a\n \u001c*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/square/gallery/part/QQStrangerBigPicLayerToolBarPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "K9", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "W9", "Z9", "X9", "ba", "M9", "Landroid/widget/TextView;", "textView", "", "resId", "ha", "O9", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "S9", "U9", "V9", ReportConstant.COSTREPORT_PREFIX, "kotlin.jvm.PlatformType", "P9", "Landroid/content/Context;", "context", "ia", "N9", "feedId", "result", "R9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerReportFeedSubmitEvent;", "event", "T9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Landroid/widget/TextView;", "likeTv", "e", "commentTv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "moreIv", tl.h.F, "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "", "i", "Z", "isFromFeedDetailPage", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "Q9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", "viewModel", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerBigPicLayerToolBarPart extends RFWLayerBasePart implements SimpleEventReceiver<SimpleBaseEvent> {
    private static final IntRange D = new IntRange(50000, 60000);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView likeTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView commentTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView moreIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedPB$Feed feed = new FeedPB$Feed();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFromFeedDetailPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    public QQStrangerBigPicLayerToolBarPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSquareViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.QQStrangerBigPicLayerToolBarPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSquareViewModel invoke() {
                return (QQStrangerSquareViewModel) QQStrangerBigPicLayerToolBarPart.this.getViewModel(QQStrangerSquareViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final View K9() {
        LayoutInflater from = LayoutInflater.from(getContext());
        View partRootView = getPartRootView();
        View inflate = from.inflate(R.layout.cy9, partRootView instanceof ViewGroup ? (ViewGroup) partRootView : null, false);
        ((TextView) inflate.findViewById(R.id.ojb)).setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerBigPicLayerToolBarPart.L9(QQStrangerBigPicLayerToolBarPart.this, view);
            }
        }, 1, null)));
        View findViewById = inflate.findViewById(R.id.f163186os0);
        TextView it = (TextView) findViewById;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ha(it, R.drawable.qui_like_outline_testing_icon_white);
        o.b(it, 16.0f);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        View d16 = w72.a.d(it, clickPolicy);
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        w72.a.f(d16, exposurePolicy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this.findViewById<TextVi\u2026T_NONE)\n                }");
        this.likeTv = it;
        View findViewById2 = inflate.findViewById(R.id.orv);
        TextView it5 = (TextView) findViewById2;
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        ha(it5, R.drawable.qui_comment_testing_icon_white);
        o.b(it5, 16.0f);
        w72.a.f(w72.a.d(it5, clickPolicy), exposurePolicy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "this.findViewById<TextVi\u2026T_NONE)\n                }");
        this.commentTv = it5;
        View findViewById3 = inflate.findViewById(R.id.okw);
        ImageView it6 = (ImageView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(it6, "it");
        o.b(it6, 16.0f);
        w72.a.f(w72.a.d(it6, clickPolicy), exposurePolicy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "this.findViewById<ImageV\u2026T_NONE)\n                }");
        this.moreIv = it6;
        W9(this.feed);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026egate(feed)\n            }");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QQStrangerBigPicLayerToolBarPart this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        w72.a.b(it, "em_kl_comment_box", null, 2, null);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(0, BaseApplication.context.getString(R.string.x0e));
        } else {
            this$0.V9(this$0.feed);
        }
    }

    private final View M9() {
        View view = new View(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Color.parseColor("#B2000000")});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        view.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.b(150));
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        return view;
    }

    private final void N9(FeedPB$Feed feed) {
        Q9().O1(u72.a.b(feed));
    }

    private final void O9(FeedPB$Feed feed) {
        View partRootView = getPartRootView();
        Context context = partRootView != null ? partRootView.getContext() : null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).reportFeed(activity, String.valueOf(u72.a.i(feed)), u72.a.b(feed));
    }

    private final String P9(String s16) {
        try {
            return URLEncoder.encode(s16, "UTF-8");
        } catch (Exception unused) {
            return s16;
        }
    }

    private final QQStrangerSquareViewModel Q9() {
        return (QQStrangerSquareViewModel) this.viewModel.getValue();
    }

    private final void S9(String eventName, JSONObject data) {
        Integer a16;
        Integer a17;
        Integer a18;
        QLog.d("QQStrangerBigPicLayerToolBarPart", 1, "handleKuiklyEvent " + eventName + " " + data);
        int hashCode = eventName.hashCode();
        if (hashCode == -1569686147) {
            if (eventName.equals("NBPFeedCommentInputSubmitEvent")) {
                if (Intrinsics.areEqual(data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "submit") : null, "false")) {
                    return;
                }
                if (Intrinsics.areEqual(data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "request_id") : null, getActivity().getClass().getSimpleName())) {
                    if (Intrinsics.areEqual(data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "feed_id") : null, this.feed.feed_id.get())) {
                        String b16 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "input_text") : null;
                        if (b16 != null) {
                            Q9().P1(this.feed, b16);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (hashCode != -1030828404) {
            if (hashCode == 603858797 && eventName.equals("onNearbyProFeedCommentCountChange")) {
                if (Intrinsics.areEqual(data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "feedId") : null, this.feed.feed_id.get())) {
                    if (data != null && (a18 = com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "commentCount")) != null) {
                        u72.a.k(this.feed, a18.intValue());
                    }
                    X9(this.feed);
                    return;
                }
                return;
            }
            return;
        }
        if (eventName.equals("NearbyFeedLikeStatusChangedEvent")) {
            if (Intrinsics.areEqual(data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "feedId") : null, this.feed.feed_id.get())) {
                if (data != null && (a17 = com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "count")) != null) {
                    u72.a.l(this.feed, a17.intValue());
                }
                if (data != null && (a16 = com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "isLike")) != null) {
                    u72.a.m(this.feed, a16.intValue() == 1);
                }
                Z9(this.feed);
            }
        }
    }

    private final void T9(QQStrangerReportFeedSubmitEvent event) {
        Activity activity;
        if (!Intrinsics.areEqual(event.getFeedId(), u72.a.b(this.feed)) || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    private final void U9(FeedPB$Feed feed) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        String str = null;
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        String str2 = (userinfo_miniinfo == null || (pBStringField3 = userinfo_miniinfo.open_id) == null) ? null : pBStringField3.get();
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (userinfo_miniinfo == null || (pBStringField2 = userinfo_miniinfo.nick) == null) ? null : pBStringField2.get();
        if (str3 == null) {
            str3 = "";
        }
        if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.avatar) != null) {
            str = pBStringField.get();
        }
        String str4 = str != null ? str : "";
        String str5 = "mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_feed_comment&app_id=1&viewer_user_id=" + P9(str2) + "&viewer_nickname=" + P9(str3) + "&viewer_avatar=" + P9(str4) + "&poster_user_id=" + P9(u72.a.g(feed)) + "&feed_id=" + P9(u72.a.b(feed)) + "&with_keyboard=false&nbp_source=1&modal_mode=1&custom_back_pressed=1";
        Intent intent = new Intent();
        intent.setData(Uri.parse(str5));
        RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTER_JUMP);
    }

    private final void V9(FeedPB$Feed feed) {
        String simpleName = getActivity().getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
        String str = "mqqapi://kuikly/open?version=1&src_type=app&modal_mode=1&page_name=nearby_feed_comment_input&custom_back_pressed=1&request_id=" + P9(simpleName) + "&app_id=1&feed_id=" + P9(u72.a.b(feed));
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTER_JUMP);
    }

    private final void W9(FeedPB$Feed feed) {
        Z9(feed);
        X9(feed);
        ba(feed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(final FeedPB$Feed feed) {
        String string;
        TextView textView = this.commentTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView = null;
        }
        if (u72.a.a(feed) > 99) {
            string = "99+";
        } else if (u72.a.a(feed) > 0) {
            string = String.valueOf(u72.a.a(feed));
        } else {
            string = getContext().getString(R.string.x2o);
        }
        textView.setText(string);
        TextView textView2 = this.commentTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView2 = null;
        }
        textView2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerBigPicLayerToolBarPart.Y9(QQStrangerBigPicLayerToolBarPart.this, feed, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QQStrangerBigPicLayerToolBarPart this$0, FeedPB$Feed feed, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        w72.a.b(it, "em_kl_comment", null, 2, null);
        this$0.U9(feed);
    }

    private final void Z9(final FeedPB$Feed feed) {
        String string;
        TextView textView = this.likeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView = null;
        }
        if (u72.a.f(feed) > 99) {
            string = "99+";
        } else if (u72.a.f(feed) > 0) {
            string = String.valueOf(u72.a.f(feed));
        } else {
            string = getContext().getString(R.string.x2q);
        }
        textView.setText(string);
        TextView textView2 = this.likeTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView2 = null;
        }
        ha(textView2, u72.a.j(feed) ? R.drawable.qui_like_fill_testing_feedback_error : R.drawable.qui_like_outline_testing_icon_white);
        TextView textView3 = this.likeTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView3 = null;
        }
        textView3.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerBigPicLayerToolBarPart.aa(FeedPB$Feed.this, this, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(FeedPB$Feed feed, QQStrangerBigPicLayerToolBarPart this$0, View it) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        w72.a.b(it, "em_kl_like", null, 2, null);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(0, BaseApplication.context.getString(R.string.x0e));
            return;
        }
        if (u72.a.j(feed)) {
            u72.a.m(feed, false);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(u72.a.f(feed) - 1, 0);
            u72.a.l(feed, coerceAtLeast);
            this$0.Q9().i2(feed);
        } else {
            u72.a.m(feed, true);
            u72.a.l(feed, u72.a.f(feed) + 1);
            this$0.Q9().c2(feed);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerBigPicUpdateLikeFeedEvent(u72.a.b(feed), u72.a.f(feed), u72.a.j(feed)));
        this$0.Z9(feed);
    }

    private final void ba(final FeedPB$Feed feed) {
        ImageView imageView = this.moreIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreIv");
            imageView = null;
        }
        imageView.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerBigPicLayerToolBarPart.ca(QQStrangerBigPicLayerToolBarPart.this, feed, view);
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(QQStrangerBigPicLayerToolBarPart this$0, FeedPB$Feed feed, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        w72.a.b(it, "em_kl_report", null, 2, null);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.ia(context, feed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ha(TextView textView, int resId) {
        Drawable drawable = ContextCompat.getDrawable(textView.getContext(), resId);
        if (drawable != null) {
            drawable.setBounds(0, 0, o.e(20), o.e(20));
        } else {
            drawable = null;
        }
        textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    private final void ia(Context context, final FeedPB$Feed feed) {
        String string;
        final boolean areEqual = Intrinsics.areEqual(u72.a.g(feed), com.tencent.mobileqq.matchfriend.utils.b.d().j());
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (areEqual) {
            string = context.getString(R.string.x2p);
        } else {
            string = context.getString(R.string.x2r);
        }
        actionSheet.addButton(string, 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QQStrangerBigPicLayerToolBarPart.ja(areEqual, this, feed, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(boolean z16, QQStrangerBigPicLayerToolBarPart this$0, FeedPB$Feed feed, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            if (z16) {
                this$0.N9(feed);
            } else {
                this$0.O9(feed);
            }
        }
        actionSheet.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Bundle extras;
        Intent intent2;
        Bundle extras2;
        byte[] byteArray;
        super.onInitView(rootView);
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && (intent2 = activity.getIntent()) != null && (extras2 = intent2.getExtras()) != null && (byteArray = extras2.getByteArray("qqstranger_square_feed")) != null) {
            MessageMicro mergeFrom = MessageMicro.mergeFrom(new FeedPB$Feed(), byteArray);
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "mergeFrom(Feed(), byteArray)");
            this.feed = (FeedPB$Feed) mergeFrom;
        }
        Context context2 = getContext();
        Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
        if (activity2 != null && (intent = activity2.getIntent()) != null && (extras = intent.getExtras()) != null) {
            this.isFromFeedDetailPage = extras.getBoolean("qqstranger_is_from_detail_page", false);
        }
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            viewGroup.addView(M9());
            viewGroup.addView(K9());
        }
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        MutableLiveData<Integer> S1 = Q9().S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QQStrangerBigPicLayerToolBarPart$onPartCreate$1 qQStrangerBigPicLayerToolBarPart$onPartCreate$1 = new QQStrangerBigPicLayerToolBarPart$onPartCreate$1(this);
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerBigPicLayerToolBarPart.da(Function1.this, obj);
            }
        });
        MutableLiveData<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>> T1 = Q9().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final QQStrangerBigPicLayerToolBarPart$onPartCreate$2 qQStrangerBigPicLayerToolBarPart$onPartCreate$2 = new Function1<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.QQStrangerBigPicLayerToolBarPart$onPartCreate$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp> bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp> bVar) {
                String string;
                IntRange intRange;
                if (bVar.a() != null) {
                    intRange = QQStrangerBigPicLayerToolBarPart.D;
                    int first = intRange.getFirst();
                    int last = intRange.getLast();
                    int i3 = bVar.a().ret_code.get();
                    if ((first <= i3 && i3 <= last) && bVar.a().f381603msg != null) {
                        string = bVar.a().f381603msg.get();
                        QQToastUtil.showQQToastInUiThread(0, string);
                    }
                }
                string = BaseApplication.context.getString(R.string.x3q);
                QQToastUtil.showQQToastInUiThread(0, string);
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerBigPicLayerToolBarPart.ea(Function1.this, obj);
            }
        });
        MutableLiveData<Pair<String, Integer>> W1 = Q9().W1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Pair<? extends String, ? extends Integer>, Unit> function1 = new Function1<Pair<? extends String, ? extends Integer>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.QQStrangerBigPicLayerToolBarPart$onPartCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Integer> pair) {
                invoke2((Pair<String, Integer>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, Integer> pair) {
                QQStrangerBigPicLayerToolBarPart.this.R9(pair.getFirst(), pair.getSecond().intValue());
            }
        };
        W1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerBigPicLayerToolBarPart.ga(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.d("QQStrangerBigPicLayerToolBarPart", 1, "onReceive " + event);
        if (event instanceof QQStrangerKuiklyEvent) {
            QQStrangerKuiklyEvent qQStrangerKuiklyEvent = (QQStrangerKuiklyEvent) event;
            S9(qQStrangerKuiklyEvent.getEventName(), qQStrangerKuiklyEvent.getData());
        } else if (event instanceof QQStrangerReportFeedSubmitEvent) {
            T9((QQStrangerReportFeedSubmitEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerKuiklyEvent.class, QQStrangerReportFeedSubmitEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(String feedId, int result) {
        if (result != 0) {
            QQToast.makeText(getContext(), 1, NetworkUtil.isNetworkAvailable() ? R.string.f169690x22 : R.string.x0e, 0).show();
            return;
        }
        QQToast.makeText(getContext(), R.string.f169691x23, 0).show();
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerBigPicDeleteFeedSuccessEvent(feedId));
        Context context = getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", feedId);
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(context, "NBPFeedDeleteEvent", jSONObject);
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}

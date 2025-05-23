package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedpro.event.QzoneFeedProRefreshEvent;
import com.qzone.reborn.feedpro.widget.QzoneFriendFeedProTitle;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.widget.RedDotImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 I2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0006\u0010#\u001a\u00020\u001bJ\u001c\u0010&\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*`+H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/feedpro/part/QzoneFriendFeedProTitlePart;", "Lcom/qzone/reborn/feedpro/part/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/feedpro/widget/QzoneFriendFeedProTitle;", "feedxTitle", "", "aa", "Y9", "T9", "P9", "R9", "V9", "I9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisiblePosition", "J9", "", "elementId", "Landroid/view/View;", "view", "K9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "L9", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartResume", "N9", "O9", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/content/BroadcastReceiver;", "d", "Landroid/content/BroadcastReceiver;", "mPublishBroadcastReceiver", "e", "Lcom/qzone/reborn/feedpro/widget/QzoneFriendFeedProTitle;", "M9", "()Lcom/qzone/reborn/feedpro/widget/QzoneFriendFeedProTitle;", "Z9", "(Lcom/qzone/reborn/feedpro/widget/QzoneFriendFeedProTitle;)V", "mFeedxTitle", "Lcom/qzone/reborn/feedx/viewmodel/r;", "f", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/p;", tl.h.F, "Lcom/qzone/reborn/feedpro/viewmodel/p;", "mFriendFeedModel", "i", "I", "mTotalDistance", "Lcom/qzone/widget/RedDotImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/widget/RedDotImageView;", "mMessageIconView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFriendFeedProTitlePart extends com.qzone.reborn.feedpro.part.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mPublishBroadcastReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public QzoneFriendFeedProTitle mFeedxTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.p mFriendFeedModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTotalDistance;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RedDotImageView mMessageIconView;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/part/QzoneFriendFeedProTitlePart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QzoneFriendFeedProTitlePart.this.M9().setTitleAlpha(QzoneFriendFeedProTitlePart.this.J9(recyclerView, ah.a(recyclerView)));
        }
    }

    private final void I9() {
        com.qzone.reborn.feedx.viewmodel.r rVar = this.mScrollViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new b());
    }

    private final void P9() {
        String string = getContext().getResources().getString(R.string.f2202168i);
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_remind, R.drawable.qui_remind);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFriendFeedProTitlePart.Q9(QzoneFriendFeedProTitlePart.this, view);
            }
        };
        boolean O9 = O9();
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.qzone.R.string.qzone_voice_message)");
        View c16 = QzoneFriendFeedProTitle.c(M9(), new uh.d(tokenRes, null, onClickListener, null, string, O9, 10, null), true, false, 4, null);
        RedDotImageView redDotImageView = c16 instanceof RedDotImageView ? (RedDotImageView) c16 : null;
        this.mMessageIconView = redDotImageView;
        K9("em_qz_message_notification", redDotImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QzoneFriendFeedProTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fl.a u16 = ho.i.u();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        u16.a(activity, "getActiveFeeds", 1);
        eo.a.f396875a.c(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9() {
        fo.c.r(M9().t(false), "em_qz_outbox", null);
    }

    private final void T9() {
        String string = getContext().getResources().getString(R.string.wbm);
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_setting, R.drawable.qui_setting);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFriendFeedProTitlePart.U9(QzoneFriendFeedProTitlePart.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qzone_setting)");
        K9("em_qz_set_en", QzoneFriendFeedProTitle.c(M9(), new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null), false, false, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QzoneFriendFeedProTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.z().v(this$0.getActivity(), LoginData.getInstance().getUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        String string = getContext().getResources().getString(R.string.wbu);
        String string2 = getContext().getResources().getString(R.string.wbu);
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_hometown, R.drawable.qui_hometown);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFriendFeedProTitlePart.W9(QzoneFriendFeedProTitlePart.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.qzone_user_home)");
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qzone_user_home)");
        K9("em_qz_personal_home_en", QzoneFriendFeedProTitle.c(M9(), new uh.d(tokenRes, string2, onClickListener, null, string, false, 40, null), false, false, 6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QzoneFriendFeedProTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.z().r(this$0.getActivity(), LoginData.getInstance().getUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QzoneFriendFeedProTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("SCROLL_TO_TOP_AND_REFRESH", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y9() {
        IntentFilter intentFilter = new IntentFilter(new IntentFilter(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY));
        this.mPublishBroadcastReceiver = new BroadcastReceiver() { // from class: com.qzone.reborn.feedpro.part.QzoneFriendFeedProTitlePart$registerPublishBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    QzoneFriendFeedProTitlePart.this.M9().A(intent);
                }
            }
        };
        getActivity().registerReceiver(this.mPublishBroadcastReceiver, intentFilter);
    }

    private final void aa(QzoneFriendFeedProTitle feedxTitle) {
        int e16 = QZoneFeedxViewUtils.e(getActivity());
        if (feedxTitle.getLayoutParams() == null) {
            feedxTitle.setLayoutParams(new ViewGroup.LayoutParams(-1, e16));
        } else {
            feedxTitle.getLayoutParams().height = e16;
        }
    }

    public boolean L9() {
        return true;
    }

    public final QzoneFriendFeedProTitle M9() {
        QzoneFriendFeedProTitle qzoneFriendFeedProTitle = this.mFeedxTitle;
        if (qzoneFriendFeedProTitle != null) {
            return qzoneFriendFeedProTitle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedxTitle");
        return null;
    }

    public int N9() {
        return R.id.n2i;
    }

    public final boolean O9() {
        return QZoneFeedAlertService.getInstance().getSingleUnreadCount(1027) > 0 && com.qzone.reborn.util.k.f59549a.c();
    }

    public void S9() {
        R9();
        V9();
        P9();
        T9();
    }

    public final void Z9(QzoneFriendFeedProTitle qzoneFriendFeedProTitle) {
        Intrinsics.checkNotNullParameter(qzoneFriendFeedProTitle, "<set-?>");
        this.mFeedxTitle = qzoneFriendFeedProTitle;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedTitlePart";
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.p.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFriend\u2026ProViewModel::class.java)");
        this.mFriendFeedModel = (com.qzone.reborn.feedpro.viewmodel.p) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QzoneFriend\u2026ollViewModel::class.java)");
        this.mScrollViewModel = (com.qzone.reborn.feedx.viewmodel.r) viewModel2;
        View findViewById = rootView.findViewById(N9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(getTitleViewId())");
        Z9((QzoneFriendFeedProTitle) findViewById);
        aa(M9());
        if (L9()) {
            I9();
        }
        M9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFriendFeedProTitlePart.X9(QzoneFriendFeedProTitlePart.this, view);
            }
        });
        S9();
        Y9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BroadcastReceiver broadcastReceiver = this.mPublishBroadcastReceiver;
        if (broadcastReceiver != null) {
            activity.unregisterReceiver(broadcastReceiver);
        }
        M9().u();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        RedDotImageView redDotImageView = this.mMessageIconView;
        if (redDotImageView != null) {
            redDotImageView.h(O9());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QzoneFeedProRefreshEvent) {
            broadcastMessage("SCROLL_TO_TOP_AND_REFRESH", null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QzoneFeedProRefreshEvent.class);
        return arrayListOf;
    }

    private final void K9(String elementId, View view) {
        if (view != null) {
            fo.c.n(view, elementId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int J9(RecyclerView recyclerView, int firstVisiblePosition) {
        if (firstVisiblePosition > 1) {
            return 255;
        }
        View childAt = recyclerView.getChildAt(0);
        if (!(childAt instanceof com.qzone.reborn.feedpro.widget.header.b)) {
            return 0;
        }
        int abs = Math.abs(childAt.getTop());
        int e16 = ((com.qzone.reborn.feedpro.widget.header.b) childAt).e();
        if (e16 == 0) {
            e16 = childAt.getMeasuredHeight();
        }
        if (abs <= 0 || e16 <= 0) {
            return 0;
        }
        if (this.mTotalDistance <= 0) {
            this.mTotalDistance = e16 - M9().getMeasuredHeight();
        }
        int i3 = this.mTotalDistance;
        if (abs >= i3) {
            return 255;
        }
        return (abs * 255) / i3;
    }
}

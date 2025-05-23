package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.utils.QZonePlusIconBubbleController;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.title.QZoneFriendFeedxTitle;
import com.qzone.widget.RedDotImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.TokenResUtils;
import eo.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 I2\u00020\u0001:\u0002JKB\u000f\u0012\u0006\u0010)\u001a\u00020\u0015\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010!\u001a\u00020\u0015J\b\u0010\"\u001a\u00020\u0015H\u0016J\u001c\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00102\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006L"}, d2 = {"Lcom/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart;", "Lcom/qzone/reborn/feedx/part/g;", "Lcom/qzone/reborn/feedx/widget/title/QZoneFriendFeedxTitle;", "feedxTitle", "", "Y9", "V9", "Q9", "O9", "W9", "I9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisiblePosition", "J9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "K9", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartResume", "M9", "p4", "Lcom/qzone/common/business/result/QZoneResult;", "result", "i5", "N9", "T9", "action", "", "args", "handleBroadcastMessage", "d", "Z", "mShowPlusIcon", "Landroid/content/BroadcastReceiver;", "e", "Landroid/content/BroadcastReceiver;", "mPublishBroadcastReceiver", "f", "Lcom/qzone/reborn/feedx/widget/title/QZoneFriendFeedxTitle;", "L9", "()Lcom/qzone/reborn/feedx/widget/title/QZoneFriendFeedxTitle;", "X9", "(Lcom/qzone/reborn/feedx/widget/title/QZoneFriendFeedxTitle;)V", "mFeedxTitle", "Lcom/qzone/reborn/feedx/viewmodel/r;", tl.h.F, "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/viewmodel/q;", "i", "Lcom/qzone/reborn/feedx/viewmodel/q;", "mFeedxDataViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mTotalDistance", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mPlusIconView", "Lcom/qzone/widget/RedDotImageView;", "D", "Lcom/qzone/widget/RedDotImageView;", "mMessageIconView", "<init>", "(Z)V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFriendFeedTitlePart extends g {

    /* renamed from: C, reason: from kotlin metadata */
    private View mPlusIconView;

    /* renamed from: D, reason: from kotlin metadata */
    private RedDotImageView mMessageIconView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mShowPlusIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mPublishBroadcastReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public QZoneFriendFeedxTitle mFeedxTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.q mFeedxDataViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mTotalDistance;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart;", "a", "Lmqq/util/WeakReference;", "mWeakReference", "part", "<init>", "(Lcom/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZoneFriendFeedTitlePart> mWeakReference;

        public b(QZoneFriendFeedTitlePart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.mWeakReference = new WeakReference<>(part);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            QZoneFriendFeedTitlePart qZoneFriendFeedTitlePart = this.mWeakReference.get();
            if (qZoneFriendFeedTitlePart != null) {
                hashMap.put(ProfileCardDtReportUtil.IS_REDDOT, Integer.valueOf(qZoneFriendFeedTitlePart.N9() ? 1 : 2));
            }
            return hashMap;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/QZoneFriendFeedTitlePart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int J9 = QZoneFriendFeedTitlePart.this.J9(recyclerView, com.qzone.reborn.feedx.util.ah.a(recyclerView));
            QZoneFriendFeedTitlePart.this.L9().setTitleAlpha(J9);
            QZoneFriendFeedTitlePart.this.L9().S(dy5);
            com.qzone.reborn.feedx.viewmodel.q qVar = QZoneFriendFeedTitlePart.this.mFeedxDataViewModel;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedxDataViewModel");
                qVar = null;
            }
            qVar.H2().setValue(Integer.valueOf(J9));
        }
    }

    public QZoneFriendFeedTitlePart(boolean z16) {
        this.mShowPlusIcon = z16;
    }

    private final void I9() {
        com.qzone.reborn.feedx.viewmodel.r rVar = this.mScrollViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new c());
    }

    private final void O9() {
        String string = getContext().getResources().getString(R.string.f2202168i);
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_remind, R.drawable.qui_remind);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFriendFeedTitlePart.P9(QZoneFriendFeedTitlePart.this, view);
            }
        };
        boolean N9 = N9();
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.qzone.R.string.qzone_voice_message)");
        View g16 = L9().g(new uh.d(tokenRes, null, onClickListener, null, string, N9, 10, null));
        this.mMessageIconView = g16 instanceof RedDotImageView ? (RedDotImageView) g16 : null;
        W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZoneFriendFeedTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fl.a u16 = ho.i.u();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        u16.a(activity, "getActiveFeeds", 1);
        eo.a.f396875a.c(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q9() {
        String string = getContext().getResources().getString(R.string.f2202568m);
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_add_circle, R.drawable.qui_add_circle);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.bs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFriendFeedTitlePart.R9(QZoneFriendFeedTitlePart.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.qzone.R.st\u2026ng.qzone_voice_plus_icon)");
        this.mPlusIconView = L9().f(new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null));
        eo.a.f396875a.d(2);
        fo.c.o(this.mPlusIconView, "em_qz_plus_sign", new fo.b().h(new c.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZoneFriendFeedTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eo.c.f396879a.b();
        this$0.broadcastMessage("OPEN_NEW_PLUS_MENU", 2);
        eo.a.f396875a.c(2);
        if (QZonePlusIconBubbleController.d() != null) {
            com.qzone.util.ak.g(QZonePlusIconBubbleController.d(), 102);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QZoneFriendFeedTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        tc.b C9 = this$0.C9();
        if (C9 != null) {
            C9.P1();
        }
        this$0.broadcastMessage("SCROLL_TO_TOP", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        IntentFilter intentFilter = new IntentFilter(new IntentFilter(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY));
        this.mPublishBroadcastReceiver = new BroadcastReceiver() { // from class: com.qzone.reborn.feedx.part.QZoneFriendFeedTitlePart$registerPublishBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    QZoneFriendFeedTitlePart.this.L9().K(intent);
                }
            }
        };
        getActivity().registerReceiver(this.mPublishBroadcastReceiver, intentFilter);
    }

    private final void W9() {
        eo.a.f396875a.d(3);
        fo.c.o(this.mMessageIconView, "em_qz_message_notification", new fo.b().h(new b(this)));
    }

    private final void Y9(QZoneFriendFeedxTitle feedxTitle) {
        int e16 = QZoneFeedxViewUtils.e(getActivity());
        if (feedxTitle.getLayoutParams() == null) {
            feedxTitle.setLayoutParams(new ViewGroup.LayoutParams(-1, e16));
        } else {
            feedxTitle.getLayoutParams().height = e16;
        }
    }

    public boolean K9() {
        return true;
    }

    public final QZoneFriendFeedxTitle L9() {
        QZoneFriendFeedxTitle qZoneFriendFeedxTitle = this.mFeedxTitle;
        if (qZoneFriendFeedxTitle != null) {
            return qZoneFriendFeedxTitle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedxTitle");
        return null;
    }

    public int M9() {
        return R.id.n2i;
    }

    public final boolean N9() {
        return QZoneFeedAlertService.getInstance().getSingleUnreadCount(1027) > 0 && com.qzone.reborn.util.k.f59549a.c();
    }

    public void S9() {
        O9();
        if (this.mShowPlusIcon) {
            Q9();
        }
    }

    public boolean T9() {
        return true;
    }

    public final void X9(QZoneFriendFeedxTitle qZoneFriendFeedxTitle) {
        Intrinsics.checkNotNullParameter(qZoneFriendFeedxTitle, "<set-?>");
        this.mFeedxTitle = qZoneFriendFeedxTitle;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        View view;
        if (Intrinsics.areEqual(action, "FAST_MINIFY_QZM_ENTRANCE")) {
            if (T9()) {
                L9().T();
            }
        } else {
            if (!Intrinsics.areEqual(action, "DISMISS_PLUS_MENU") || (view = this.mPlusIconView) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i5(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        L9().v();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFriend\u2026ataViewModel::class.java)");
        this.mFeedxDataViewModel = (com.qzone.reborn.feedx.viewmodel.q) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneFriend\u2026ollViewModel::class.java)");
        this.mScrollViewModel = (com.qzone.reborn.feedx.viewmodel.r) viewModel2;
        View findViewById = rootView.findViewById(M9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(getTitleViewId())");
        X9((QZoneFriendFeedxTitle) findViewById);
        Y9(L9());
        L9().w();
        if (T9()) {
            L9().Q();
        }
        if (K9()) {
            I9();
        }
        L9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.bq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFriendFeedTitlePart.U9(QZoneFriendFeedTitlePart.this, view);
            }
        });
        V9();
        S9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BroadcastReceiver broadcastReceiver = this.mPublishBroadcastReceiver;
        if (broadcastReceiver != null) {
            activity.unregisterReceiver(broadcastReceiver);
        }
        L9().z();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (T9()) {
            L9().W();
        }
        RedDotImageView redDotImageView = this.mMessageIconView;
        if (redDotImageView != null) {
            redDotImageView.h(N9());
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void p4() {
        L9().G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int J9(RecyclerView recyclerView, int firstVisiblePosition) {
        if (firstVisiblePosition > 1) {
            return 255;
        }
        View childAt = recyclerView.getChildAt(0);
        if (!(childAt instanceof com.qzone.reborn.feedx.widget.header.a)) {
            return 0;
        }
        int abs = Math.abs(childAt.getTop());
        int e16 = ((com.qzone.reborn.feedx.widget.header.a) childAt).e();
        if (e16 == 0) {
            e16 = childAt.getMeasuredHeight();
        }
        if (abs <= 0 || e16 <= 0) {
            return 0;
        }
        if (this.mTotalDistance <= 0) {
            this.mTotalDistance = e16 - L9().getMeasuredHeight();
        }
        int i3 = this.mTotalDistance;
        if (abs >= i3) {
            return 255;
        }
        return (abs * 255) / i3;
    }
}

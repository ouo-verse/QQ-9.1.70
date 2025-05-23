package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyRsp;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040!0 H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020B0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010=\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteActionListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "I9", "M9", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "L9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository$b;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$CommentAndReplyRsp;", WebViewPlugin.KEY_RESPONSE, "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "d", "Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "recyclerView", "Lz72/c;", "e", "Lz72/c;", "viewAdapter", "Lz72/d;", "f", "Lz72/d;", "loadMoreAdapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "viewManager", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/e;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/e;", "dataCenter", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", "emptyRootView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/viewmodel/QQStrangerSquareViewModel;", "viewModel", "Lkotlin/Lazy;", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "D", "emptyView", "<init>", "()V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLiteActionListPart extends Part implements ILoadMoreProvider$LoadMoreListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> F = new HashSet();
    private static QQStrangerLiteActionModel G;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy<QUIEmptyState> emptyView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SkinnableRecycleView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private z72.c viewAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private z72.d loadMoreAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.LayoutManager viewManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final e dataCenter = new e();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout emptyRootView;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteActionListPart$a;", "", "", "msgId", "elementId", "", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "commentOrReplyActionModel", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "getCommentOrReplyActionModel", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "b", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;)V", "TAG", "Ljava/lang/String;", "", "exposedIdSet", "Ljava/util/Set;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionListPart$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String msgId, String elementId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            String str = msgId + elementId;
            if (QQStrangerLiteActionListPart.F.contains(str)) {
                return false;
            }
            QQStrangerLiteActionListPart.F.add(str);
            return true;
        }

        public final void b(QQStrangerLiteActionModel qQStrangerLiteActionModel) {
            QQStrangerLiteActionListPart.G = qQStrangerLiteActionModel;
        }

        Companion() {
        }
    }

    public QQStrangerLiteActionListPart() {
        Lazy lazy;
        Lazy<QUIEmptyState> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSquareViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionListPart$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSquareViewModel invoke() {
                return new QQStrangerSquareViewModel();
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new QQStrangerLiteActionListPart$emptyView$1(this));
        this.emptyView = lazy2;
    }

    private final void I9() {
        F.clear();
    }

    private final QQStrangerSquareViewModel J9() {
        return (QQStrangerSquareViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp> responseData) {
        String string;
        if (responseData.getIsSuccess()) {
            QQToastUtil.showQQToast(2, R.string.x2_);
            return;
        }
        if (responseData.a() != null) {
            int i3 = responseData.a().ret_code.get();
            if (50000 <= i3 && i3 < 60001) {
                String str = responseData.a().f381603msg.get();
                Intrinsics.checkNotNullExpressionValue(str, "responseData.data.msg.get()");
                if (str.length() > 0) {
                    string = responseData.a().f381603msg.get();
                    QQToastUtil.showQQToast(0, string);
                }
            }
        }
        string = BaseApplication.context.getString(R.string.x3q);
        QQToastUtil.showQQToast(0, string);
    }

    private final void L9(String eventName, JSONObject data) {
        String userId;
        String b16;
        if (Intrinsics.areEqual(eventName, "NBPFeedCommentInputSubmitEvent")) {
            QQStrangerLiteActionModel qQStrangerLiteActionModel = G;
            G = null;
            boolean z16 = true;
            QLog.i("QQStrangerLiteActionListPart", 1, "handleKuiklyEvent: " + data);
            if (Intrinsics.areEqual(data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "submit") : null, "false")) {
                return;
            }
            if (Intrinsics.areEqual(data != null ? data.get("request_id") : null, "com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.ButtonSection")) {
                String string = data != null ? data.getString("feed_id") : null;
                String string2 = data != null ? data.getString("target_comment_id") : null;
                if (string == null || string.length() == 0) {
                    return;
                }
                if (string2 == null || string2.length() == 0) {
                    return;
                }
                String b17 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "input_text") : null;
                if (b17 != null && b17.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                J9().Q1((qQStrangerLiteActionModel == null || (userId = qQStrangerLiteActionModel.getUserId()) == null) ? "" : userId, string, string2, (data == null || (b16 = com.tencent.mobileqq.matchfriend.reborn.config.a.b(data, "target_reply_id")) == null) ? "" : b16, b17);
            }
        }
    }

    private final void M9() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getPartRootView(), "pg_bas_interactive_notification");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(final QQStrangerLiteActionListPart this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.emptyRootView;
        z72.d dVar = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyRootView");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        z72.c cVar = this$0.viewAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            cVar = null;
        }
        cVar.setItems(new ArrayList(this$0.dataCenter.m(((QQStrangerLiteActionPushEvent) simpleBaseEvent).getData(), true)), new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.h
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerLiteActionListPart.P9(QQStrangerLiteActionListPart.this);
            }
        });
        z72.d dVar2 = this$0.loadMoreAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        } else {
            dVar = dVar2;
        }
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QQStrangerLiteActionListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SkinnableRecycleView skinnableRecycleView = this$0.recyclerView;
        if (skinnableRecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            skinnableRecycleView = null;
        }
        skinnableRecycleView.scrollToPosition(0);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerLiteActionPushEvent.class);
        arrayList.add(QQStrangerLiteActionDeleteEvent.class);
        arrayList.add(QQStrangerKuiklyEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        z72.d dVar = null;
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        String uid = appInterface.getCurrentUid();
        super.onInitView(rootView);
        if (rootView != null) {
            this.viewManager = new LinearLayoutManager(getContext());
            z72.c cVar = new z72.c();
            cVar.setHasStableIds(true);
            e eVar = this.dataCenter;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            cVar.setItems(eVar.j(uid));
            if (QLog.isColorLevel()) {
                QLog.d("QQStrangerLiteActionListPart", 2, "Using cache model, current uid: " + uid + ".");
                QLog.d("QQStrangerLiteActionListPart", 2, "Uid: " + uid + ". Map Size: " + this.dataCenter.j(uid).size() + ".");
            }
            this.viewAdapter = cVar;
            z72.d dVar2 = new z72.d();
            dVar2.setHasStableIds(true);
            dVar2.registerLoadMoreListener(this);
            dVar2.setLoadState(true, true);
            this.loadMoreAdapter = dVar2;
            View findViewById = rootView.findViewById(R.id.oj9);
            SkinnableRecycleView skinnableRecycleView = (SkinnableRecycleView) findViewById;
            skinnableRecycleView.setHasFixedSize(true);
            skinnableRecycleView.setItemAnimator(null);
            RecyclerView.LayoutManager layoutManager = this.viewManager;
            if (layoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewManager");
                layoutManager = null;
            }
            skinnableRecycleView.setLayoutManager(layoutManager);
            RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
            RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
            z72.c cVar2 = this.viewAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                cVar2 = null;
            }
            adapterArr[0] = cVar2;
            z72.d dVar3 = this.loadMoreAdapter;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            } else {
                dVar = dVar3;
            }
            adapterArr[1] = dVar;
            skinnableRecycleView.setAdapter(new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr));
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById<Skinnabl\u2026          )\n            }");
            this.recyclerView = skinnableRecycleView;
            View findViewById2 = rootView.findViewById(R.id.onq);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            relativeLayout.addView(this.emptyView.getValue(), layoutParams);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById<Relative\u2026params)\n                }");
            this.emptyRootView = relativeLayout;
        }
        M9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        this.dataCenter.q(new QQStrangerLiteActionListPart$onLoadMoreStart$1(this));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>> U1 = J9().U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QQStrangerLiteActionListPart$onPartCreate$1 qQStrangerLiteActionListPart$onPartCreate$1 = new QQStrangerLiteActionListPart$onPartCreate$1(this);
        U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerLiteActionListPart.N9(Function1.this, obj);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.dataCenter.p();
        G = null;
        I9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof QQStrangerLiteActionPushEvent) {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerLiteActionListPart.O9(QQStrangerLiteActionListPart.this, event);
                }
            });
            return;
        }
        if (event instanceof QQStrangerLiteActionDeleteEvent) {
            ArrayList<QQStrangerLiteActionModel> f16 = this.dataCenter.f(((QQStrangerLiteActionDeleteEvent) event).getPosition());
            z72.c cVar = this.viewAdapter;
            RelativeLayout relativeLayout = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                cVar = null;
            }
            cVar.setItems(new ArrayList(f16));
            z72.c cVar2 = this.viewAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                cVar2 = null;
            }
            if (cVar2.getItems().isEmpty()) {
                z72.d dVar = this.loadMoreAdapter;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                    dVar = null;
                }
                dVar.hide();
                RelativeLayout relativeLayout2 = this.emptyRootView;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyRootView");
                } else {
                    relativeLayout = relativeLayout2;
                }
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (event instanceof QQStrangerKuiklyEvent) {
            QQStrangerKuiklyEvent qQStrangerKuiklyEvent = (QQStrangerKuiklyEvent) event;
            L9(qQStrangerKuiklyEvent.getEventName(), qQStrangerKuiklyEvent.getData());
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}

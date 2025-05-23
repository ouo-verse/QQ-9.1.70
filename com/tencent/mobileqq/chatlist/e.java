package com.tencent.mobileqq.chatlist;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerApi;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.g;
import com.tencent.mobileqq.cardcontainer.i;
import com.tencent.mobileqq.cardcontainer.j;
import com.tencent.mobileqq.cardcontainer.k;
import com.tencent.mobileqq.chatlist.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.chats.biz.main.part.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0003UVWB\u0017\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u000201\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\u001c\u0010+\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00106R\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00106R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR \u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/chatlist/e;", "Lcom/tencent/mobileqq/chatlist/a;", "Lcom/tencent/qqnt/chats/biz/main/part/c$b;", "", "ma", "Landroid/content/Context;", "context", "", "show", "Lcom/tencent/mobileqq/cardcontainer/i;", "ha", "ga", "Lcom/tencent/mobileqq/cardcontainer/g;", "viewModel", "ea", "view", "na", "la", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lmqq/app/AppRuntime;", "app", "K9", "newRuntime", "onAccountChanged", "onPostThemeChanged", "onPartResume", "onPartPause", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "O9", "", "L0", "X9", "Lcom/tencent/qqnt/chats/biz/main/part/c;", "f", "Lcom/tencent/qqnt/chats/biz/main/part/c;", "chatListPart", "Lcom/tencent/mobileqq/cardcontainer/k;", h.F, "Lcom/tencent/mobileqq/cardcontainer/k;", "parentScrollHelper", "i", "Z", "isCardAdded", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/cardcontainer/g;", "cardsViewModel", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/cardcontainer/i;", "cardContainerView", "D", "cachedCardContainerView", "Lcom/tencent/mobileqq/chatlist/e$b;", "E", "Lcom/tencent/mobileqq/chatlist/e$b;", "cardDataPreloader", UserInfo.SEX_FEMALE, "isRealAccountChange", "G", "preCardContainerVisible", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "checkCardContainerExposureRunnable", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "I", "Landroidx/lifecycle/Observer;", "cardsViewModelObserver", "<init>", "(Lcom/tencent/qqnt/chats/biz/main/part/c;Lcom/tencent/mobileqq/cardcontainer/k;)V", "J", "a", "b", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends com.tencent.mobileqq.chatlist.a implements c.b {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private i cardContainerView;

    /* renamed from: D, reason: from kotlin metadata */
    private i cachedCardContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    private b cardDataPreloader;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isRealAccountChange;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean preCardContainerVisible;

    /* renamed from: H, reason: from kotlin metadata */
    private Runnable checkCardContainerExposureRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    private final Observer<List<com.tencent.mobileqq.cardcontainer.data.a>> cardsViewModelObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.qqnt.chats.biz.main.part.c chatListPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final k parentScrollHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isCardAdded;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private g cardsViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/chatlist/e$a;", "Lcom/tencent/mobileqq/cardcontainer/api/a;", "Lcom/tencent/mobileqq/cardcontainer/data/CardContainerSwitchState;", "state", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/chatlist/e;", "Lmqq/util/WeakReference;", "weakCardContainerPart", "part", "<init>", "(Lcom/tencent/mobileqq/chatlist/e;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements com.tencent.mobileqq.cardcontainer.api.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<e> weakCardContainerPart;

        public a(e part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.weakCardContainerPart = new WeakReference<>(part);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0) {
            List<com.tencent.mobileqq.cardcontainer.data.a> emptyList;
            g gVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            e eVar = this$0.weakCardContainerPart.get();
            MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> L1 = (eVar == null || (gVar = eVar.cardsViewModel) == null) ? null : gVar.L1();
            if (L1 == null) {
                return;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            L1.setValue(emptyList);
        }

        @Override // com.tencent.mobileqq.cardcontainer.api.a
        public void a(CardContainerSwitchState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            QLog.d("CardContainer.MainChatsPart", 1, "onCardContainerSwitchStateChanged state:" + state);
            if (state == CardContainerSwitchState.OFF) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.chatlist.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.c(e.a.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u0006\u0010\u0005\u001a\u00020\u0004R*\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\n \u0011*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/chatlist/e$b;", "", "", "f", "", "uin", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "e", "a", "Ljava/util/ArrayList;", "dataList", "Ljava/util/concurrent/CountDownLatch;", "b", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "kotlin.jvm.PlatformType", "c", "Ljava/lang/String;", "", "d", "J", "startTime", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private ArrayList<com.tencent.mobileqq.cardcontainer.data.a> dataList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private CountDownLatch countDownLatch = new CountDownLatch(1);

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long startTime = System.currentTimeMillis();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/chatlist/e$b$a", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "dataList", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes33.dex */
        public static final class a implements com.tencent.mobileqq.cardcontainer.api.b {
            a() {
            }

            @Override // com.tencent.mobileqq.cardcontainer.api.b
            public void a(boolean isSuccess, ArrayList<com.tencent.mobileqq.cardcontainer.data.a> dataList) {
                if (QLog.isColorLevel()) {
                    String str = b.this.uin;
                    Integer valueOf = dataList != null ? Integer.valueOf(dataList.size()) : null;
                    QLog.d("CardContainer.MainChatsPart", 1, "CardDataPreloader.preload, uin=" + str + ", count=" + valueOf + " time=" + (System.currentTimeMillis() - b.this.startTime) + "ms");
                }
                b.this.dataList = dataList;
                b.this.countDownLatch.countDown();
            }
        }

        public final ArrayList<com.tencent.mobileqq.cardcontainer.data.a> e(String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (this.uin != uin) {
                QLog.w("CardContainer.MainChatsPart", 1, "CardDataPreloader.getData, uin not match");
                return null;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.countDownLatch.await();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (QLog.isColorLevel()) {
                    ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList = this.dataList;
                    QLog.d("CardContainer.MainChatsPart", 1, "CardDataPreloader.getData, uin=" + uin + ", cost=" + currentTimeMillis2 + " ms, data=" + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
                }
            } catch (Exception e16) {
                QLog.i("CardContainer.MainChatsPart", 1, "CardDataPreloader.getData, exception: " + e16);
            }
            return this.dataList;
        }

        public final void f() {
            ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).getCardDataFromMMKV(new a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0002J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0002J,\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/chatlist/e$c;", "", "", "e", "elementId", "", QQBrowserActivity.APP_PARAM, "", "f", "g", "event", h.F, "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.chatlist.e$c, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String e() {
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
            return currentAccountUin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(String elementId, Map<String, ? extends Object> extraParams) {
            h("qq_clck", elementId, extraParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(String elementId, Map<String, ? extends Object> extraParams) {
            h("qq_imp", elementId, extraParams);
        }

        private final void h(final String event, String elementId, Map<String, ? extends Object> extraParams) {
            if (QLog.isDevelopLevel()) {
                QLog.d("CardContainer.MainChatsPart", 1, "reportExposureToDaTong, elementId=" + elementId + ", params=" + extraParams);
            }
            final HashMap hashMap = new HashMap(extraParams);
            hashMap.put("qq_pgid", "pg_bas_msglist");
            hashMap.put("qq_eid", elementId);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("msglist_type", 0);
            String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
            Intrinsics.checkNotNullExpressionValue(currentUid, "sMobileQQ.peekAppRuntime().currentUid");
            hashMap2.put("uid", currentUid);
            hashMap2.put("home_uin", e.INSTANCE.e());
            hashMap.put("cur_pg", hashMap2);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.chatlist.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.Companion.i(event, hashMap);
                }
            }, 16, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(String event, HashMap params) {
            Intrinsics.checkNotNullParameter(event, "$event");
            Intrinsics.checkNotNullParameter(params, "$params");
            VideoReport.reportEvent(event, params);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/chatlist/e$d", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements Observer<List<? extends com.tencent.mobileqq.cardcontainer.data.a>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
            List<? extends com.tencent.mobileqq.cardcontainer.data.a> list = cardDataList;
            if (list == null || list.isEmpty()) {
                QLog.i("CardContainer.MainChatsPart", 1, "cardsViewModelObserver onChanged, card list is empty");
                return;
            }
            QLog.i("CardContainer.MainChatsPart", 1, "cardsViewModelObserver onChanged, init card container");
            Context context = e.this.getContext();
            if (context == null || e.this.ha(context, true) == null) {
                QLog.w("CardContainer.MainChatsPart", 1, "cardsViewModelObserver onChanged, context is null");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/chatlist/e$e", "Lcom/tencent/mobileqq/cardcontainer/j;", "", "elementId", "", "", "params", "", "b", "c", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "cardData", "", AdMetricTag.Report.TYPE, "customData", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.chatlist.e$e, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C7448e implements j {
        C7448e() {
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void a(ContainerData cardData, int reportType, String customData) {
            Intrinsics.checkNotNullParameter(cardData, "cardData");
            ICardContainerDataApi iCardContainerDataApi = (ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class);
            int n3 = cardData.n();
            String g16 = cardData.g();
            String value = cardData.i().getValue();
            String str = customData == null ? "" : customData;
            String q16 = cardData.q();
            String p16 = cardData.p();
            iCardContainerDataApi.sendCardReport(n3, g16, value, reportType, str, q16, p16 == null ? "" : p16);
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void b(String elementId, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            Intrinsics.checkNotNullParameter(params, "params");
            e.INSTANCE.g(elementId, params);
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void c(String elementId, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            Intrinsics.checkNotNullParameter(params, "params");
            e.INSTANCE.f(elementId, params);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/chatlist/e$f", "Lcom/tencent/mobileqq/cardcontainer/h;", "", "a", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class f implements com.tencent.mobileqq.cardcontainer.h {
        f() {
        }

        @Override // com.tencent.mobileqq.cardcontainer.h
        public void a() {
            e.this.chatListPart.ta();
            QLog.i("CardContainer.MainChatsPart", 1, "[showCardContainerView], setLocalCardContainerSwitchShowingState: true");
            ((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).setLocalCardContainerSwitchShowingState(true);
        }

        @Override // com.tencent.mobileqq.cardcontainer.h
        public void b() {
            QLog.i("CardContainer.MainChatsPart", 1, "onAllCardsClosed");
            e.this.la();
        }
    }

    public e(com.tencent.qqnt.chats.biz.main.part.c chatListPart, k parentScrollHelper) {
        Intrinsics.checkNotNullParameter(chatListPart, "chatListPart");
        Intrinsics.checkNotNullParameter(parentScrollHelper, "parentScrollHelper");
        this.chatListPart = chatListPart;
        this.parentScrollHelper = parentScrollHelper;
        chatListPart.na(this);
        this.preCardContainerVisible = true;
        this.cardsViewModelObserver = new d();
    }

    private final i ea(Context context, g viewModel) {
        i iVar = this.cachedCardContainerView;
        if (iVar != null) {
            this.cachedCardContainerView = null;
            return iVar;
        }
        i createCardContainerView = ((ICardContainerApi) QRoute.api(ICardContainerApi.class)).createCardContainerView(context, D9(), viewModel, new C7448e(), this.parentScrollHelper, new f());
        createCardContainerView.getView().setId(R.id.f174209);
        createCardContainerView.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(168.0f)));
        return createCardContainerView;
    }

    private final boolean ga() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chat_list_hide_card_container_if_business_splash_exists", true)) {
            QLog.i("CardContainer.MainChatsPart", 1, "[hasBusinessSplash] switch is off");
            return false;
        }
        return ((ITianshuManager) QRoute.api(ITianshuManager.class)).isBizExecuted(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i ha(Context context, boolean show) {
        if (!com.tencent.mobileqq.cardcontainer.config.a.INSTANCE.a().e()) {
            QLog.i("CardContainer.MainChatsPart", 1, "initCardContainer, main switch is off");
            return null;
        }
        CardContainerSwitchState remoteCardContainerSwitchState = ((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).getRemoteCardContainerSwitchState();
        QLog.i("CardContainer.MainChatsPart", 1, "initCardContainer, remoteCardContainerSwitchState:" + remoteCardContainerSwitchState + ", show:" + show);
        if (remoteCardContainerSwitchState == CardContainerSwitchState.OFF) {
            return null;
        }
        g gVar = this.cardsViewModel;
        if (gVar == null) {
            gVar = ((ICardContainerApi) QRoute.api(ICardContainerApi.class)).getViewModel(F9());
        }
        this.cardsViewModel = gVar;
        List<com.tencent.mobileqq.cardcontainer.data.a> value = gVar.L1().getValue();
        if (value == null || value.isEmpty()) {
            QLog.i("CardContainer.MainChatsPart", 1, "initCardContainer, card list is empty, start observing cards data");
            gVar.P1(true);
            gVar.L1().observe(D9(), this.cardsViewModelObserver);
            return null;
        }
        gVar.L1().removeObserver(this.cardsViewModelObserver);
        if (this.isCardAdded) {
            if (QLog.isDevelopLevel()) {
                QLog.d("CardContainer.MainChatsPart", 1, "initCardContainer, card container view is already added");
            }
            return null;
        }
        this.isCardAdded = true;
        i ea5 = ea(context, gVar);
        if (show) {
            na(ea5);
        } else {
            gVar.P1(false);
            this.cardContainerView = ea5;
        }
        return ea5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(e this$0) {
        List<com.tencent.mobileqq.cardcontainer.data.a> emptyList;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            if (!this$0.X9()) {
                obj = this$0.ha(context, true);
            } else {
                b bVar = this$0.cardDataPreloader;
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> e16 = bVar != null ? bVar.e(INSTANCE.e()) : null;
                if (!(e16 == null || e16.isEmpty())) {
                    g gVar = this$0.cardsViewModel;
                    MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> L1 = gVar != null ? gVar.L1() : null;
                    if (L1 != null) {
                        L1.setValue(e16);
                    }
                } else {
                    g gVar2 = this$0.cardsViewModel;
                    MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> L12 = gVar2 != null ? gVar2.L1() : null;
                    if (L12 != null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        L12.setValue(emptyList);
                    }
                }
                g gVar3 = this$0.cardsViewModel;
                if (gVar3 != null) {
                    gVar3.P1(false);
                    obj = Unit.INSTANCE;
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                return;
            }
        }
        QLog.w("CardContainer.MainChatsPart", 1, "onAccountChanged, context is null");
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(RecyclerView recyclerView, e this$0) {
        boolean z16;
        boolean z17;
        i iVar;
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (recyclerView.isAttachedToWindow() && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                while (true) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                    if (findViewHolderForAdapterPosition != null && findViewHolderForAdapterPosition.getItemViewType() == -4) {
                        z16 = true;
                        break;
                    } else if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                        break;
                    } else {
                        findFirstVisibleItemPosition++;
                    }
                }
                z17 = this$0.preCardContainerVisible;
                if (z17 && z16) {
                    i iVar2 = this$0.cardContainerView;
                    if (iVar2 != null) {
                        iVar2.onResume();
                    }
                } else if (z17 && !z16 && (iVar = this$0.cardContainerView) != null) {
                    iVar.a(true);
                }
                this$0.preCardContainerVisible = z16;
            }
            z16 = false;
            z17 = this$0.preCardContainerVisible;
            if (z17) {
            }
            if (z17) {
                iVar.a(true);
            }
            this$0.preCardContainerVisible = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        i iVar = this.cardContainerView;
        if (iVar != null) {
            this.cardContainerView = null;
            this.cachedCardContainerView = iVar;
            QLog.i("CardContainer.MainChatsPart", 1, "[removeCardContainerView] view=" + iVar.hashCode());
            this.chatListPart.ia(-4);
            this.chatListPart.ta();
        }
    }

    private final void na(i view) {
        if (this.cardContainerView != null) {
            QLog.i("CardContainer.MainChatsPart", 1, "[showCardContainerView], cardContainerView is not null");
        }
        QLog.i("CardContainer.MainChatsPart", 1, "[showCardContainerView] view=" + view.hashCode());
        this.cardContainerView = view;
        this.chatListPart.ma(-4, view.getView());
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void K9(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        super.K9(app);
        this.isRealAccountChange = true;
        String currentAccountUin = app.getCurrentAccountUin();
        if (!(currentAccountUin == null || currentAccountUin.length() == 0) && !Intrinsics.areEqual(app.getCurrentAccountUin(), INSTANCE.e())) {
            if (QLog.isColorLevel()) {
                QLog.d("CardContainer.MainChatsPart", 1, "onBeforeAccountChanged, clear card data");
            }
            this.isCardAdded = false;
            i iVar = this.cardContainerView;
            if (iVar != null) {
                iVar.c();
            }
            b bVar = new b();
            bVar.f();
            this.cardDataPreloader = bVar;
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CardContainer.MainChatsPart", 1, "onBeforeAccountChanged, uin not changed, uin=" + app.getCurrentAccountUin());
        }
        this.isRealAccountChange = false;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.c.b
    public Map<Integer, View> L0(Context context) {
        Map<Integer, View> mapOf;
        Map<Integer, View> emptyMap;
        Map<Integer, View> emptyMap2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (ga()) {
            QLog.i("CardContainer.MainChatsPart", 1, "[getFixedHeaderView] has business splash, do not show card container");
            this.isCardAdded = true;
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            return emptyMap2;
        }
        i ha5 = ha(context, false);
        if (ha5 == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(-4, ha5.getView()));
        return mapOf;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void O9(final RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (X9() && newState == 0) {
            Runnable runnable = this.checkCardContainerExposureRunnable;
            if (runnable != null) {
                recyclerView.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.chatlist.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.ja(RecyclerView.this, this);
                }
            };
            this.checkCardContainerExposureRunnable = runnable2;
            recyclerView.postDelayed(runnable2, 200L);
        }
    }

    @Override // com.tencent.mobileqq.chatlist.a
    public boolean X9() {
        return this.cardContainerView != null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MainChatsCardContainerPart";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime newRuntime) {
        super.onAccountChanged(newRuntime);
        if (QLog.isColorLevel()) {
            QLog.d("CardContainer.MainChatsPart", 1, "onAccountChanged, init card container, isRealAccountChange: " + this.isRealAccountChange);
        }
        ma();
        if (this.isRealAccountChange) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.chatlist.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.ia(e.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i iVar = this.cardContainerView;
        if (iVar != null) {
            iVar.refresh();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ma();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        i iVar = this.cardContainerView;
        if (iVar != null) {
            iVar.a(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        i iVar;
        super.onPartResume(activity);
        if (!this.preCardContainerVisible || (iVar = this.cardContainerView) == null) {
            return;
        }
        iVar.onResume();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        i iVar = this.cardContainerView;
        if (iVar != null) {
            iVar.refresh();
        }
    }

    private final void ma() {
        QLog.i("CardContainer.MainChatsPart", 1, "setCardContainerSwitchSwitchListener");
        ((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).setCardContainerSwitchChangedListener(new a(this));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QLog.i("CardContainer.MainChatsPart", 1, "onPartDestroy removeCardContainerSwitchChangedListener");
        ((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).removeCardContainerSwitchChangedListener();
        super.onPartDestroy(activity);
    }
}

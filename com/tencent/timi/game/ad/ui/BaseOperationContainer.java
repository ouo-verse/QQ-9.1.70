package com.tencent.timi.game.ad.ui;

import af4.OperationData;
import af4.OperationItem;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.timi.game.ad.ui.BaseOperationContainer;
import com.tencent.timi.game.ad.ui.OperationItemView;
import com.tencent.timi.game.utils.l;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qn4.BlockOptConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 R2\u00020\u0001:\u0002STB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\n\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH$J\b\u0010\u0010\u001a\u00020\nH$J\b\u0010\u0011\u001a\u00020\nH$J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H$J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H$J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u0002H\u0014J\b\u0010 \u001a\u00020\u0002H\u0004J\b\u0010!\u001a\u00020\u0002H\u0004R*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00050\"j\b\u0012\u0004\u0012\u00020\u0005`#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00050\"j\b\u0012\u0004\u0012\u00020\u0005`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010%R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00050\"j\b\u0012\u0004\u0012\u00020\u0005`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010%R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\f0\"j\b\u0012\u0004\u0012\u00020\f`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010%R\u0016\u0010/\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010.R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0018\u00106\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010I\u00a8\u0006U"}, d2 = {"Lcom/tencent/timi/game/ad/ui/BaseOperationContainer;", "Landroid/widget/LinearLayout;", "", "j", "", "Laf4/c;", "dataList", h.F, HippyTKDListViewAdapter.X, "data", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/timi/game/ad/ui/OperationItemView;", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "o", DomainData.DOMAIN_NAME, "w", "adId", "v", "k", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "jumpInterceptor", "setJumpInterceptor", "Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "skinCallback", "setSkinCallback", "u", "l", "t", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "r", "()Ljava/util/ArrayList;", "mDataList", "e", "mDefaultList", "f", "mAdditionList", "mOperationViewList", "J", "mFetchDataTimeStamp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mNextStartTime", BdhLogUtil.LogTag.Tag_Conn, "mNextEndTime", "D", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "mJumpInterceptor", "E", "Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "mSkinCallback", "", UserInfo.SEX_FEMALE, "Z", "mIsLandScape", "Landroid/os/CountDownTimer;", "G", "Landroid/os/CountDownTimer;", "mSoftUpdateTimer", "H", "isDestroy", "Lcom/tencent/timi/game/ad/ui/BaseOperationContainer$b;", "I", "Lcom/tencent/timi/game/ad/ui/BaseOperationContainer$b;", "operationAdsCallback", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "fetchOperationAdsTaskForCancel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BaseOperationContainer extends LinearLayout {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<BlockOptConfig> L;

    /* renamed from: C, reason: from kotlin metadata */
    private long mNextEndTime;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private OperationItemView.b mJumpInterceptor;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private OperationItemView.c mSkinCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsLandScape;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private CountDownTimer mSoftUpdateTimer;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final b operationAdsCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Runnable fetchOperationAdsTaskForCancel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<OperationData> mDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<OperationData> mDefaultList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<OperationData> mAdditionList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<OperationItemView> mOperationViewList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mFetchDataTimeStamp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long mNextStartTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/ad/ui/BaseOperationContainer$a;", "", "Lqn4/a;", "blockOptConfig$delegate", "Lkotlin/Lazy;", "b", "()Lqn4/a;", "blockOptConfig", "", "AUTO_FETCH_DATA_GAP", "I", "MAX_VIEW_NUM", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.ad.ui.BaseOperationContainer$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BlockOptConfig b() {
            return (BlockOptConfig) BaseOperationContainer.L.getValue();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/ad/ui/BaseOperationContainer$b;", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/timi/game/ad/ui/BaseOperationContainer;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "baseOperationContainerWeakRef", "baseOperationContainer", "<init>", "(Lcom/tencent/timi/game/ad/ui/BaseOperationContainer;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements TianShuGetAdvCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<BaseOperationContainer> baseOperationContainerWeakRef;

        public b(@NotNull BaseOperationContainer baseOperationContainer) {
            Intrinsics.checkNotNullParameter(baseOperationContainer, "baseOperationContainer");
            this.baseOperationContainerWeakRef = new WeakReference<>(baseOperationContainer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(b this$0, List data) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            BaseOperationContainer baseOperationContainer = this$0.baseOperationContainerWeakRef.get();
            if (baseOperationContainer != null) {
                baseOperationContainer.h(data);
            } else {
                l.h("BaseOperationContainer_", 1, "baseOperationContainer is null");
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean result, @Nullable TianShuAccess.GetAdsRsp getAdsRsp) {
            l.h("BaseOperationContainer_", 1, "requestOperationAds result:" + result + ", getAdsRsp:" + getAdsRsp);
            if (getAdsRsp == null) {
                return;
            }
            BaseOperationContainer baseOperationContainer = this.baseOperationContainerWeakRef.get();
            if (baseOperationContainer != null && !baseOperationContainer.isDestroy) {
                final List<OperationData> c16 = af4.g.f26031a.c(getAdsRsp, baseOperationContainer.n(), baseOperationContainer.s());
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.ad.ui.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseOperationContainer.b.b(BaseOperationContainer.b.this, c16);
                    }
                });
            } else {
                l.h("BaseOperationContainer_", 1, "baseOperationContainer is null or destroy");
            }
        }
    }

    static {
        Lazy<BlockOptConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BlockOptConfig>() { // from class: com.tencent.timi.game.ad.ui.BaseOperationContainer$Companion$blockOptConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BlockOptConfig invoke() {
                return new BlockOptConfig(false, false, false, false, false, 31, null);
            }
        });
        L = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseOperationContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<OperationData> dataList) {
        l.h("BaseOperationContainer_", 1, "addDefaultList " + dataList);
        this.mDefaultList.clear();
        this.mDefaultList.addAll(dataList);
        u();
    }

    private final OperationItemView i(OperationData data, int pos) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        OperationItemView operationItemView = new OperationItemView(context, null, 0, pos, this.mIsLandScape, 6, null);
        operationItemView.setData(data);
        operationItemView.setJumpInterceptor(this.mJumpInterceptor);
        OperationItemView.c cVar = this.mSkinCallback;
        if (cVar != null) {
            operationItemView.setSkinCallback(cVar);
        }
        return operationItemView;
    }

    private final void j() {
        this.mSoftUpdateTimer = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(BaseOperationContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("BaseOperationContainer_", "fetchData scheduled");
        af4.g.f26031a.h(this$0.operationAdsCallback, this$0.o());
        this$0.mFetchDataTimeStamp = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        boolean z16;
        Iterator<OperationItemView> it = this.mOperationViewList.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mFetchDataTimeStamp;
        if (currentTimeMillis >= MiniBoxNoticeInfo.MIN_5) {
            l.h("BaseOperationContainer_", 1, "softUpdateUI timeGap:" + currentTimeMillis + ", need fetch data!");
            l();
            return;
        }
        long a16 = OperationItem.INSTANCE.a();
        long j3 = this.mNextStartTime;
        boolean z17 = false;
        if (j3 != -1 && a16 >= j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j16 = this.mNextEndTime;
        if (j16 != -1 && a16 >= j16) {
            z17 = true;
        }
        if (z16 || z17) {
            l.h("BaseOperationContainer_", 1, "softUpdateUI need refresh data! currentTime:" + a16 + ", mNextStartTime:" + j3 + ", mNextEndTime:" + j16);
            u();
        }
    }

    public final void k() {
        CountDownTimer countDownTimer = this.mSoftUpdateTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mSoftUpdateTimer = null;
        Iterator<T> it = this.mOperationViewList.iterator();
        while (it.hasNext()) {
            ((OperationItemView) it.next()).h();
        }
        this.mOperationViewList.clear();
        this.isDestroy = true;
        Runnable runnable = this.fetchOperationAdsTaskForCancel;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 128);
        }
        this.fetchOperationAdsTaskForCancel = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        l.i("BaseOperationContainer_", "fetchData start");
        Companion companion = INSTANCE;
        if (!companion.b().getGameRoomFetchOperationAds()) {
            this.mFetchDataTimeStamp = System.currentTimeMillis();
            return;
        }
        if (companion.b().getGameRoomFetchOperationAdsInSubThread()) {
            Runnable runnable = this.fetchOperationAdsTaskForCancel;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 128);
            }
            this.fetchOperationAdsTaskForCancel = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.timi.game.ad.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseOperationContainer.m(BaseOperationContainer.this);
                }
            }, 128, null, true, 0L);
            return;
        }
        af4.g.f26031a.h(this.operationAdsCallback, o());
        this.mFetchDataTimeStamp = System.currentTimeMillis();
    }

    @NotNull
    protected abstract List<Integer> n();

    @NotNull
    protected abstract List<TianShuAdPosItemData> o();

    protected abstract int p();

    protected abstract long q();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<OperationData> r() {
        return this.mDataList;
    }

    protected abstract int s();

    public final void setJumpInterceptor(@Nullable OperationItemView.b jumpInterceptor) {
        this.mJumpInterceptor = jumpInterceptor;
    }

    public final void setSkinCallback(@NotNull OperationItemView.c skinCallback) {
        Intrinsics.checkNotNullParameter(skinCallback, "skinCallback");
        this.mSkinCallback = skinCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        ((lo4.a) mm4.b.b(lo4.a.class)).K1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        if (this.isDestroy) {
            return;
        }
        CountDownTimer countDownTimer = this.mSoftUpdateTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mDataList.clear();
        this.mDataList.addAll(this.mDefaultList);
        this.mDataList.addAll(this.mAdditionList);
        CollectionsKt__MutableCollectionsJVMKt.sort(this.mDataList);
        if (this.mDataList.size() > 4) {
            ArrayList<OperationData> arrayList = this.mDataList;
            List<OperationData> subList = arrayList.subList(arrayList.size() - 4, this.mDataList.size());
            Intrinsics.checkNotNullExpressionValue(subList, "mDataList.subList(mDataL\u2026size - 4, mDataList.size)");
            this.mDataList.clear();
            this.mDataList.addAll(subList);
        }
        this.mOperationViewList.clear();
        Iterator<OperationData> it = this.mDataList.iterator();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            int i16 = i3 + 1;
            OperationData next = it.next();
            long a16 = OperationItem.INSTANCE.a();
            int adId = next.getAdId();
            List<OperationItem> i17 = next.i();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : i17) {
                long j3 = a16;
                if (af4.g.f26031a.e(q(), p(), (OperationItem) obj, a16)) {
                    arrayList2.add(obj);
                }
                a16 = j3;
            }
            long j16 = a16;
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                ((OperationItem) it5.next()).O(q());
            }
            OperationData operationData = new OperationData(adId, arrayList2);
            af4.g gVar = af4.g.f26031a;
            long b16 = gVar.b(next.i(), j16);
            long j17 = this.mNextStartTime;
            if (j17 == -1) {
                this.mNextStartTime = b16;
            } else if (j17 > b16) {
                this.mNextStartTime = b16;
            }
            long a17 = gVar.a(next.i(), j16);
            long j18 = this.mNextEndTime;
            if (j18 == -1) {
                this.mNextEndTime = a17;
            } else if (j18 > a17) {
                this.mNextEndTime = a17;
            }
            List<OperationItem> i18 = operationData.i();
            if (i18 != null && !i18.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                this.mOperationViewList.add(i(operationData, 3 - i3));
            }
            i3 = i16;
        }
        l.h("BaseOperationContainer_", 1, "refreshUI mNextStartTime:" + this.mNextStartTime + ", mNextEndTime:" + this.mNextEndTime);
        CollectionsKt___CollectionsJvmKt.reverse(this.mOperationViewList);
        removeAllViews();
        Iterator<OperationItemView> it6 = this.mOperationViewList.iterator();
        while (it6.hasNext()) {
            View view = (OperationItemView) it6.next();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = fh4.b.b(12);
            addView(view, layoutParams);
            view.setVisibility(0);
        }
        if (this.mSoftUpdateTimer == null) {
            j();
        }
        CountDownTimer countDownTimer2 = this.mSoftUpdateTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
    }

    public final void v(int adId) {
        Iterator<OperationData> it = this.mAdditionList.iterator();
        while (it.hasNext()) {
            OperationData next = it.next();
            if (next.getAdId() == adId && this.mAdditionList.remove(next)) {
                u();
                return;
            }
        }
    }

    public final void w(@NotNull OperationData data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        int adId = data.getAdId();
        ArrayList<OperationData> arrayList = this.mAdditionList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (adId != ((OperationData) obj).getAdId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        this.mAdditionList.clear();
        this.mAdditionList.addAll(arrayList2);
        this.mAdditionList.add(data);
        u();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseOperationContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BaseOperationContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseOperationContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDataList = new ArrayList<>();
        this.mDefaultList = new ArrayList<>();
        this.mAdditionList = new ArrayList<>();
        this.mOperationViewList = new ArrayList<>();
        this.mNextStartTime = -1L;
        this.mNextEndTime = -1L;
        this.operationAdsCallback = new b(this);
        setOrientation(1);
        setPadding(fh4.b.b(16), 0, fh4.b.b(16), 0);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/ad/ui/BaseOperationContainer$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends CountDownTimer {
        c() {
            super(Long.MAX_VALUE, 500L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            BaseOperationContainer.this.x();
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }
    }
}

package com.tencent.robot.adelie.homepage.mine.part;

import a24.CreateCenterPageData;
import a24.i;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotOperationType;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.robot.adelie.homepage.mine.AdelieHomeCreateCenterViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001Q\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R#\u0010F\u001a\n B*\u0004\u0018\u00010A0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010\"\u001a\u0004\bD\u0010ER\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010LR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/AdelieHomeMineGridPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "K9", "La24/j;", ISchemeApi.KEY_PAGE_DATA, "V9", "Q9", "P9", "showErrorView", "S9", "", "I9", "O9", "R9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "e", "Lkotlin/Lazy;", "M9", "()I", "spanCount", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Ls14/a;", "i", "Ls14/a;", "listAdapter", "Ls14/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ls14/b;", "loadMoreAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "gridListContainer", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterStateView;", "D", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterStateView;", "stateView", "E", "Z", "isEnd", "Lcom/tencent/robot/adelie/homepage/mine/AdelieHomeCreateCenterViewModel;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "L9", "()Lcom/tencent/robot/adelie/homepage/mine/AdelieHomeCreateCenterViewModel;", "pageViewModel", "Landroidx/lifecycle/LiveData;", "G", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/Observer;", "H", "Landroidx/lifecycle/Observer;", "pageObserver", "La24/i;", "I", "changeRobotObserver", "com/tencent/robot/adelie/homepage/mine/part/AdelieHomeMineGridPart$kuiklyBroadcastReceiver$1", "J", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieHomeMineGridPart$kuiklyBroadcastReceiver$1;", "kuiklyBroadcastReceiver", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "K", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeMineGridPart extends Part implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int L = com.tencent.qqnt.base.utils.c.f353052a.a(0.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private SmartRefreshLayout gridListContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AdelieCreateCenterStateView stateView;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile boolean isEnd;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LiveData<CreateCenterPageData> pageData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Observer<CreateCenterPageData> pageObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Observer<i> changeRobotObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final AdelieHomeMineGridPart$kuiklyBroadcastReceiver$1 kuiklyBroadcastReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy spanCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s14.a listAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s14.b loadMoreAdapter;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR!\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/AdelieHomeMineGridPart$a;", "", "", "Lkotlin/Pair;", "", "a", "(J)Lkotlin/Pair;", "toChineseUnit", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Pair<String, String> a(long j3) {
            String[] strArr = {"", "\u4e07", "\u4e07+"};
            boolean z16 = false;
            if (j3 <= AppConstants.LBS_HELLO_UIN_LONGVALUE) {
                return new Pair<>(String.valueOf(j3), strArr[0]);
            }
            if (j3 >= 10000000) {
                return new Pair<>("999", strArr[2]);
            }
            double rint = Math.rint((j3 / 10000.0d) * 10.0f) / 10.0d;
            if (rint % 1.0d == 0.0d) {
                z16 = true;
            }
            if (z16) {
                return new Pair<>(String.valueOf((int) rint), strArr[1]);
            }
            return new Pair<>(String.valueOf(rint), strArr[1]);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/mine/part/AdelieHomeMineGridPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            s14.b bVar;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0 && !recyclerView.canScrollVertically(1) && !AdelieHomeMineGridPart.this.isEnd && (bVar = AdelieHomeMineGridPart.this.loadMoreAdapter) != null) {
                bVar.setLoadState(true, !AdelieHomeMineGridPart.this.isEnd);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/robot/adelie/homepage/mine/part/AdelieHomeMineGridPart$c", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SafeGridLayoutManager f366448b;

        c(SafeGridLayoutManager safeGridLayoutManager) {
            this.f366448b = safeGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            RFWConcatAdapter rFWConcatAdapter = AdelieHomeMineGridPart.this.concatAdapter;
            Intrinsics.checkNotNull(rFWConcatAdapter);
            if (position != rFWConcatAdapter.getNUM_BACKGOURND_ICON() - 1) {
                return 1;
            }
            return this.f366448b.getSpanCount();
        }
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart$kuiklyBroadcastReceiver$1] */
    public AdelieHomeMineGridPart(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart$spanCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int I9;
                I9 = AdelieHomeMineGridPart.this.I9();
                return Integer.valueOf(I9);
            }
        });
        this.spanCount = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AdelieHomeCreateCenterViewModel>() { // from class: com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart$pageViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdelieHomeCreateCenterViewModel invoke() {
                return (AdelieHomeCreateCenterViewModel) AdelieHomeMineGridPart.this.getViewModel(AdelieHomeCreateCenterViewModel.class);
            }
        });
        this.pageViewModel = lazy2;
        this.pageObserver = new Observer() { // from class: com.tencent.robot.adelie.homepage.mine.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieHomeMineGridPart.N9(AdelieHomeMineGridPart.this, (CreateCenterPageData) obj);
            }
        };
        this.changeRobotObserver = new Observer() { // from class: com.tencent.robot.adelie.homepage.mine.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieHomeMineGridPart.J9(AdelieHomeMineGridPart.this, (i) obj);
            }
        };
        this.kuiklyBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart$kuiklyBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                String str2 = null;
                if (intent != null) {
                    str = intent.getStringExtra(AdMetricTag.EVENT_NAME);
                } else {
                    str = null;
                }
                QLog.i("AdelieHomeMineGridPart", 1, "kuiklyBroadcastReceiver onReceive " + str);
                String str3 = "";
                if (Intrinsics.areEqual(str, "adelie_delete_robot")) {
                    String stringExtra = intent.getStringExtra("data");
                    if (stringExtra != null) {
                        str2 = new JSONObject(stringExtra).optString("uid", "");
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    MutableLiveData<i> a16 = com.tencent.robot.adelie.homepage.g.f366352a.a();
                    ChangeMyBotOperationType changeMyBotOperationType = ChangeMyBotOperationType.KDELETE;
                    MyBotInfo myBotInfo = new MyBotInfo();
                    myBotInfo.uid = str3;
                    Unit unit = Unit.INSTANCE;
                    a16.postValue(new i(changeMyBotOperationType, myBotInfo));
                    return;
                }
                if (Intrinsics.areEqual(str, "adelie_edit_robot")) {
                    String stringExtra2 = intent.getStringExtra("data");
                    if (stringExtra2 != null) {
                        str2 = new JSONObject(stringExtra2).optString("uid", "");
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    MutableLiveData<i> a17 = com.tencent.robot.adelie.homepage.g.f366352a.a();
                    ChangeMyBotOperationType changeMyBotOperationType2 = ChangeMyBotOperationType.KEDIT;
                    MyBotInfo myBotInfo2 = new MyBotInfo();
                    myBotInfo2.uid = str3;
                    Unit unit2 = Unit.INSTANCE;
                    a17.postValue(new i(changeMyBotOperationType2, myBotInfo2));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int I9() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(AdelieHomeMineGridPart this$0, i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (iVar == null) {
            return;
        }
        QLog.i("AdelieHomeMineGridPart", 1, "observe changeRobotObserver:" + iVar);
        this$0.L9().N1(this$0.lifecycleOwner);
        LiveData<CreateCenterPageData> liveData = this$0.pageData;
        if (liveData != null) {
            liveData.removeObserver(this$0.pageObserver);
        }
        LiveData<CreateCenterPageData> L1 = this$0.L9().L1();
        L1.observe(this$0.lifecycleOwner, this$0.pageObserver);
        this$0.pageData = L1;
        com.tencent.robot.adelie.homepage.g.f366352a.a().postValue(null);
        this$0.L9().Q1();
        this$0.K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        L9().P1();
    }

    private final AdelieHomeCreateCenterViewModel L9() {
        return (AdelieHomeCreateCenterViewModel) this.pageViewModel.getValue();
    }

    private final int M9() {
        return ((Number) this.spanCount.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(AdelieHomeMineGridPart this$0, CreateCenterPageData createCenterPageData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (createCenterPageData == null) {
            return;
        }
        this$0.isEnd = createCenterPageData.getIsEnd();
        this$0.V9(createCenterPageData);
    }

    private final void O9() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            MobileQQ.sMobileQQ.registerReceiver(this.kuiklyBroadcastReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e("AdelieHomeMineGridPart", 1, "registerKuiklyBroadcast registerReceiver fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        SmartRefreshLayout smartRefreshLayout = this.gridListContainer;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(8);
        }
        AdelieCreateCenterStateView adelieCreateCenterStateView = this.stateView;
        if (adelieCreateCenterStateView != null) {
            adelieCreateCenterStateView.setVisibility(0);
        }
        AdelieCreateCenterStateView adelieCreateCenterStateView2 = this.stateView;
        if (adelieCreateCenterStateView2 != null) {
            adelieCreateCenterStateView2.e();
        }
    }

    private final void Q9(CreateCenterPageData pageData) {
        AdelieCreateCenterStateView adelieCreateCenterStateView = this.stateView;
        if (adelieCreateCenterStateView != null) {
            adelieCreateCenterStateView.setVisibility(8);
        }
        SmartRefreshLayout smartRefreshLayout = this.gridListContainer;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        S9(pageData);
    }

    private final void R9() {
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.kuiklyBroadcastReceiver);
        } catch (Exception e16) {
            QLog.e("AdelieHomeMineGridPart", 1, "unRegisterKuiklyBroadcast registerReceiver fail.", e16);
        }
    }

    private final void S9(final CreateCenterPageData pageData) {
        SmartRefreshLayout smartRefreshLayout;
        List<a24.g> b16 = pageData.b();
        boolean z16 = !pageData.getIsEnd();
        if (this.loadMoreAdapter != null && this.listAdapter != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieHomeMineGridPart", 1, this + " updateAdapterData total:" + b16.size() + ", hasMore:" + z16);
            }
            a24.e eVar = new a24.e();
            eVar.f(pageData.getType());
            eVar.d(pageData.getIsEnd());
            if (b16.size() < 6 && eVar.getIsEnd()) {
                eVar.e(true);
            }
            a24.d header = pageData.getHeader();
            if (header == null) {
                header = new a24.d();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(header);
            a24.a robotActivity = pageData.getRobotActivity();
            if (robotActivity != null && a24.c.a(robotActivity)) {
                arrayList.add(robotActivity);
            }
            arrayList.add(new a24.f());
            arrayList.addAll(b16);
            if (b16.isEmpty()) {
                arrayList.add(new a24.h());
            }
            arrayList.add(eVar);
            s14.a aVar = this.listAdapter;
            if (aVar != null) {
                aVar.setItems(arrayList, new Runnable() { // from class: com.tencent.robot.adelie.homepage.mine.part.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdelieHomeMineGridPart.T9(CreateCenterPageData.this, this);
                    }
                });
            }
            if (!pageData.getIsEnd() && (smartRefreshLayout = this.gridListContainer) != null) {
                smartRefreshLayout.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.mine.part.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdelieHomeMineGridPart.U9(AdelieHomeMineGridPart.this);
                    }
                });
            }
            s14.b bVar = this.loadMoreAdapter;
            if (bVar != null) {
                bVar.hide();
            }
            s14.b bVar2 = this.loadMoreAdapter;
            if (bVar2 != null) {
                bVar2.setLoadState(false, z16);
                return;
            }
            return;
        }
        QLog.d("AdelieHomeMineGridPart", 1, "updateAdapterData null return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(CreateCenterPageData pageData, AdelieHomeMineGridPart this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(pageData, "$pageData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pageData.getIsFirstSection() && pageData.getIsRefresh() && (recyclerView = this$0.recyclerView) != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(AdelieHomeMineGridPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9().P1();
    }

    @MainThread
    private final void V9(CreateCenterPageData pageData) {
        int type = pageData.getType();
        if (type != -1) {
            if (type != 0) {
                if (type != 1) {
                    if (type == 2) {
                        Q9(pageData);
                        return;
                    }
                    return;
                }
                Q9(pageData);
                return;
            }
            P9();
            return;
        }
        showErrorView();
    }

    private final void showErrorView() {
        SmartRefreshLayout smartRefreshLayout = this.gridListContainer;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(8);
        }
        AdelieCreateCenterStateView adelieCreateCenterStateView = this.stateView;
        if (adelieCreateCenterStateView != null) {
            adelieCreateCenterStateView.setVisibility(0);
        }
        AdelieCreateCenterStateView adelieCreateCenterStateView2 = this.stateView;
        if (adelieCreateCenterStateView2 != null) {
            adelieCreateCenterStateView2.d();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        com.tencent.robot.adelie.homepage.g.f366352a.a().observe(this.lifecycleOwner, this.changeRobotObserver);
        this.stateView = (AdelieCreateCenterStateView) rootView.findViewById(R.id.f88124w8);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.f72383qp);
        this.gridListContainer = smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setEnableOverScrollDrag(true);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.gridListContainer;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.setEnableRefresh(false);
        }
        s14.a aVar = new s14.a(new b24.a());
        aVar.setHasStableIds(true);
        this.listAdapter = aVar;
        s14.b bVar = new s14.b();
        bVar.registerLoadMoreListener(this);
        bVar.setMaxAutoLoadMoreTimes(3);
        this.loadMoreAdapter = bVar;
        this.concatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.listAdapter, this.loadMoreAdapter});
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f790548q);
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
        }
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), M9());
        safeGridLayoutManager.setSpanSizeLookup(new c(safeGridLayoutManager));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(safeGridLayoutManager);
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.concatAdapter);
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 != null) {
            recyclerView4.setOnScrollListener(new b());
        }
        v14.a aVar2 = new v14.a(M9(), L, false);
        aVar2.a(0, ViewUtils.dpToPx(15.0f));
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 != null) {
            recyclerView5.addItemDecoration(aVar2);
        }
        LiveData<CreateCenterPageData> L1 = L9().L1();
        L1.observe(this.lifecycleOwner, this.pageObserver);
        this.pageData = L1;
        K9();
        P9();
        AdelieCreateCenterStateView adelieCreateCenterStateView = this.stateView;
        if (adelieCreateCenterStateView != null) {
            adelieCreateCenterStateView.setCallback(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.mine.part.AdelieHomeMineGridPart$onInitView$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AdelieHomeMineGridPart.this.P9();
                    AdelieHomeMineGridPart.this.K9();
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        if (QLog.isColorLevel()) {
            QLog.d("AdelieHomeMineGridPart", 1, this + " onLoadMoreStart");
        }
        if (this.isEnd) {
            return;
        }
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QLog.i("AdelieHomeMineGridPart", 1, this + " onPartCreate");
        O9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QLog.i("AdelieHomeMineGridPart", 1, this + " onPartDestroy");
        LiveData<CreateCenterPageData> liveData = this.pageData;
        if (liveData != null) {
            liveData.removeObserver(this.pageObserver);
        }
        this.pageData = null;
        com.tencent.robot.adelie.homepage.g.f366352a.a().removeObserver(this.changeRobotObserver);
        L9().N1(this.lifecycleOwner);
        s14.b bVar = this.loadMoreAdapter;
        if (bVar != null) {
            bVar.onAdapterDestroyed(this.recyclerView);
        }
        s14.b bVar2 = this.loadMoreAdapter;
        if (bVar2 != null) {
            bVar2.unRegisterLoadMoreListener(this);
        }
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter != null) {
            s14.b bVar3 = this.loadMoreAdapter;
            Intrinsics.checkNotNull(bVar3);
            rFWConcatAdapter.removeAdapter(bVar3);
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 != null) {
            s14.a aVar = this.listAdapter;
            Intrinsics.checkNotNull(aVar);
            rFWConcatAdapter2.removeAdapter(aVar);
        }
        this.loadMoreAdapter = null;
        this.listAdapter = null;
        this.concatAdapter = null;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager != null) {
            gridLayoutManager.setSpanSizeLookup(null);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(null);
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(null);
        }
        AdelieCreateCenterStateView adelieCreateCenterStateView = this.stateView;
        if (adelieCreateCenterStateView != null) {
            adelieCreateCenterStateView.b();
        }
        R9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}

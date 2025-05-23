package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel;

import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerPositiveActionCollector;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import e30.d;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 R2\u00020\u0001:\u0002STB\u0007\u00a2\u0006\u0004\bP\u0010QJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J6\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J#\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J-\u0010!\u001a\u00020\u00072%\u0010 \u001a!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u001aj\u0002`\u001fJ\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ&\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\f\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040#j\u0002`$J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0002R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R&\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R)\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040/038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R&\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00101R)\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040/038\u0006\u00a2\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00107R \u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u00101R#\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0/038\u0006\u00a2\u0006\f\n\u0004\bB\u00105\u001a\u0004\bC\u00107R\u0018\u0010G\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/QFSPublicAccountStaggeredViewModel;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "Le30/b;", "dataList", "", "X1", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$RequestType;", "requestType", "", "currentFeedIds", "", "transInfo", "l2", "o2", "", "", "args", "c2", "([Ljava/lang/Object;)V", "onCleared", "getLogTag", "e2", "d2", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "feedBlockData", "", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/Predicate;", "predicate", "j2", SemanticAttributes.DbSystemValues.H2, "Lkotlin/Function0;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/CurrentFeedIds;", "f2", ICustomDataEditor.NUMBER_PARAM_2, "g2", "qCircleInitBean", "W1", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", "repo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_feedsData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "feedsData", "Lorg/json/JSONObject;", "E", "_maskTaskInfo", UserInfo.SEX_FEMALE, "b2", "maskTaskInfo", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "G", "_followUsersData", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "followUsersData", "I", "Ljava/lang/String;", "attachInfo", "J", "Ljava/lang/Boolean;", "isFirstPreloadSetData", "K", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$RequestType;", "lastRequestType", "L", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "<init>", "()V", "M", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredViewModel extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<e30.b>>> _feedsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<e30.b>>> feedsData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<JSONObject>>> _maskTaskInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<JSONObject>>> maskTaskInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp>> _followUsersData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp>> followUsersData;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String attachInfo;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Boolean isFirstPreloadSetData;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QFSPublicAccountStaggeredRepo.RequestType lastRequestType;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QCircleInitBean initBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSPublicAccountStaggeredRepo repo = new QFSPublicAccountStaggeredRepo();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "it", "", "invoke", "(Lcom/tencent/richframework/data/base/UIStateData;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<UIStateData<List<? extends e30.b>>, Unit> {
        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QFSPublicAccountStaggeredViewModel this$0, UIStateData it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0._feedsData.setValue(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends e30.b>> uIStateData) {
            invoke2((UIStateData<List<e30.b>>) uIStateData);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull final UIStateData<List<e30.b>> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List<e30.b> data = it.getData();
            if (data == null || data.isEmpty()) {
                return;
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = QFSPublicAccountStaggeredViewModel.this;
            uIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublicAccountStaggeredViewModel.AnonymousClass1.b(QFSPublicAccountStaggeredViewModel.this, it);
                }
            }, 300L);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0003\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/QFSPublicAccountStaggeredViewModel$b;", "Lcom/tencent/mobileqq/engineering/preload/inter/OnTaskListener;", "", "", "args", "", "onComplete", "([Ljava/lang/Object;)V", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/QFSPublicAccountStaggeredViewModel;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "viewModel", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/QFSPublicAccountStaggeredViewModel;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements OnTaskListener<Object> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<QFSPublicAccountStaggeredViewModel> mWeakReference;

        public b(@Nullable QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel) {
            this.mWeakReference = new WeakReference<>(qFSPublicAccountStaggeredViewModel);
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(@NotNull Object... args) {
            QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel;
            Intrinsics.checkNotNullParameter(args, "args");
            WeakReference<QFSPublicAccountStaggeredViewModel> weakReference = this.mWeakReference;
            if (weakReference != null) {
                qFSPublicAccountStaggeredViewModel = weakReference.get();
            } else {
                qFSPublicAccountStaggeredViewModel = null;
            }
            if (qFSPublicAccountStaggeredViewModel != null && args.length == 4) {
                QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel2 = this.mWeakReference.get();
                Intrinsics.checkNotNull(qFSPublicAccountStaggeredViewModel2);
                qFSPublicAccountStaggeredViewModel2.c2(Arrays.copyOf(args, args.length));
            }
        }
    }

    public QFSPublicAccountStaggeredViewModel() {
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = new MutableLiveData<>();
        this._feedsData = mutableLiveData;
        this.feedsData = mutableLiveData;
        MutableLiveData<UIStateData<List<JSONObject>>> mutableLiveData2 = new MutableLiveData<>();
        this._maskTaskInfo = mutableLiveData2;
        this.maskTaskInfo = mutableLiveData2;
        MutableLiveData<UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp>> mutableLiveData3 = new MutableLiveData<>();
        this._followUsersData = mutableLiveData3;
        this.followUsersData = mutableLiveData3;
        this.isFirstPreloadSetData = Boolean.FALSE;
        QFSPublicAccountStaggerPositiveActionCollector.f86891a.f(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(QCircleInitBean initBean, List<e30.b> dataList) {
        boolean z16;
        e30.b B;
        String str;
        PBStringField pBStringField;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_gzh_use_return_feed", true) && initBean != null && initBean.getSchemeAttrs() != null) {
            List<e30.b> list = dataList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 || !TextUtils.equals(initBean.getSchemeAttrs().get("is_from_return_jump"), "1") || (B = QCirclePluginGlobalInfo.B()) == null) {
                return;
            }
            if (dataList instanceof ArrayList) {
                ((ArrayList) dataList).add(0, B);
                FeedCloudMeta$StFeed g16 = B.g();
                if (g16 != null && (pBStringField = g16.f398449id) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                QLog.i("QFSPublicAccountStaggeredViewModel", 1, "[appendPageReturnFeed] real append:" + str);
            }
            QCirclePluginGlobalInfo.i0(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(Object... args) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp;
        List emptyList;
        String str;
        int i3;
        boolean z16;
        boolean z17;
        List<FeedCloudMeta$StFeed> list;
        List<FeedCloudMeta$StFeed> list2;
        QLog.d("QFSPublicAccountStaggeredViewModel", 4, "xcy after [handleFeed] rsp time=" + System.currentTimeMillis());
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Object obj2 = args[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
        long longValue = ((Long) obj2).longValue();
        Object obj3 = args[2];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj3;
        Object obj4 = args[3];
        Integer num = null;
        if (obj4 != null) {
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type feedcloud.FeedCloudRead.StGetFeedListRsp");
            feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj4;
        } else {
            feedCloudRead$StGetFeedListRsp = null;
        }
        int ordinal = QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH.ordinal();
        QLog.d("QFSPublicAccountStaggeredViewModel", 1, "[handleFeed] isSucceed: " + booleanValue + ", retCode: " + longValue + ", errorMsg: " + str2);
        this.isFirstPreloadSetData = Boolean.TRUE;
        if (booleanValue && feedCloudRead$StGetFeedListRsp != null && longValue == 0) {
            PBStringField pBStringField = feedCloudRead$StGetFeedListRsp.feedAttchInfo;
            if (pBStringField != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            this.attachInfo = str;
            PBUInt32Field pBUInt32Field = feedCloudRead$StGetFeedListRsp.isFinish;
            if (pBUInt32Field != null) {
                i3 = pBUInt32Field.get();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("QFSPublicAccountStaggeredViewModel", 1, "[handleFeed] isFinished: " + z16 + ", attachInfo: " + this.attachInfo);
            PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField = feedCloudRead$StGetFeedListRsp.vecFeed;
            if (pBRepeatMessageField != null && pBRepeatMessageField.isEmpty()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this._feedsData.setValue(UIStateData.obtainEmpty().setFinish(z16).setLoadMore(false).setType(ordinal).setRetCode(longValue));
                return;
            }
            PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField2 = feedCloudRead$StGetFeedListRsp.vecFeed;
            if (pBRepeatMessageField2 != null) {
                list = pBRepeatMessageField2.get();
            } else {
                list = null;
            }
            ArrayList<e30.b> b16 = d.b(list);
            X1(this.initBean, b16);
            this._feedsData.setValue(UIStateData.obtainSuccess(false).setFinish(z16).setLoadMore(false).setType(ordinal).setDataList(b16).setRetCode(longValue));
            QCircleInitBean qCircleInitBean = this.initBean;
            if (qCircleInitBean != null) {
                this.repo.q(feedCloudRead$StGetFeedListRsp, qCircleInitBean);
            }
            w20.a.j().initOrUpdateGlobalState((List) b16, true);
            this.repo.Q(feedCloudRead$StGetFeedListRsp);
            PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField3 = feedCloudRead$StGetFeedListRsp.vecFeed;
            if (pBRepeatMessageField3 != null && (list2 = pBRepeatMessageField3.get()) != null) {
                num = Integer.valueOf(list2.size());
            }
            QLog.i("QFSPublicAccountStaggeredViewModel", 1, "[handleFeed] <-- type=" + ordinal + ", rspSize=" + num);
            return;
        }
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = this._feedsData;
        UIStateData retCode = UIStateData.obtainError(str2).setType(ordinal).setRetCode(longValue);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(retCode.setDataList(emptyList));
    }

    public static /* synthetic */ void i2(QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel, QCircleInitBean qCircleInitBean, byte[] bArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bArr = null;
        }
        qFSPublicAccountStaggeredViewModel.h2(qCircleInitBean, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(QFSPublicAccountStaggeredViewModel this$0, Function1 predicate) {
        List list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(predicate, "$predicate");
        UIStateData value = this$0._feedsData.getValue();
        if (value == null || (list = (List) value.getData()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((Boolean) predicate.invoke((e30.b) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        value.setDataList(arrayList);
    }

    private final void l2(final QFSPublicAccountStaggeredRepo.RequestType requestType, QCircleInitBean initBean, List<String> currentFeedIds, byte[] transInfo) {
        boolean z16;
        this.lastRequestType = requestType;
        this._feedsData.setValue(UIStateData.obtainLoading().setType(requestType.ordinal()));
        QFSPublicAccountStaggeredRepo.RequestType requestType2 = QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH;
        if (requestType != requestType2 && requestType != QFSPublicAccountStaggeredRepo.RequestType.REFRESH) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z17 = z16;
        if (requestType == requestType2) {
            QLog.d("QFSPublicAccountStaggeredViewModel", 4, "xcy before [request] time=" + System.currentTimeMillis());
        }
        this.repo.w(initBean, this.attachInfo, requestType, z17, currentFeedIds, transInfo, new Function1<QFSPublicAccountStaggeredRepo.GetFeedResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel$requestFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPublicAccountStaggeredRepo.GetFeedResult getFeedResult) {
                invoke2(getFeedResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull QFSPublicAccountStaggeredRepo.GetFeedResult result) {
                QFSPublicAccountStaggeredRepo.RequestType requestType3;
                boolean z18;
                String str;
                List emptyList;
                String str2;
                List emptyList2;
                QFSPublicAccountStaggeredRepo.RequestType requestType4;
                Intrinsics.checkNotNullParameter(result, "result");
                QFSPublicAccountStaggeredRepo.RequestType requestType5 = QFSPublicAccountStaggeredRepo.RequestType.this;
                QFSPublicAccountStaggeredRepo.RequestType requestType6 = QFSPublicAccountStaggeredRepo.RequestType.LOAD_MORE;
                if (requestType5 != requestType6) {
                    QLog.d("QFSPublicAccountStaggeredViewModel", 4, "xcy before [rsp] time=" + System.currentTimeMillis());
                }
                boolean z19 = QFSPublicAccountStaggeredRepo.RequestType.this == requestType6;
                requestType3 = this.lastRequestType;
                if (requestType3 != QFSPublicAccountStaggeredRepo.RequestType.REFRESH) {
                    requestType4 = this.lastRequestType;
                    if (requestType4 != QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH) {
                        z18 = false;
                        if (!z18 && z19) {
                            str2 = this.attachInfo;
                            QLog.i("QFSPublicAccountStaggeredViewModel", 1, "discard duplicated req, attachInfo: " + str2);
                            MutableLiveData mutableLiveData = this._feedsData;
                            UIStateData type = UIStateData.obtainSuccess(false).setFinish(result.getIsFinished()).setLoadMore(true).setType(QFSPublicAccountStaggeredRepo.RequestType.this.ordinal());
                            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                            mutableLiveData.setValue(type.setDataList(emptyList2).setRetCode(-55555L));
                            return;
                        }
                        boolean isSucceed = result.getIsSucceed();
                        QFSPublicAccountStaggeredRepo.RequestType requestType7 = QFSPublicAccountStaggeredRepo.RequestType.this;
                        str = this.attachInfo;
                        QLog.d("QFSPublicAccountStaggeredViewModel", 1, "[requestFeed] isSucceed: " + isSucceed + ", requestType: " + requestType7 + ", attachInfo: " + str);
                        if (result.getIsSucceed()) {
                            MutableLiveData mutableLiveData2 = this._feedsData;
                            UIStateData retCode = UIStateData.obtainError(result.getMsg()).setType(QFSPublicAccountStaggeredRepo.RequestType.this.ordinal()).setRetCode(result.getCode());
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            mutableLiveData2.setValue(retCode.setDataList(emptyList));
                            return;
                        }
                        this.attachInfo = result.getAttachInfo();
                        boolean z26 = QFSPublicAccountStaggeredRepo.RequestType.this == requestType6;
                        if (result.c().isEmpty()) {
                            this._feedsData.setValue(UIStateData.obtainEmpty().setFinish(result.getIsFinished()).setLoadMore(z26).setType(QFSPublicAccountStaggeredRepo.RequestType.this.ordinal()).setRetCode(result.getCode()));
                            return;
                        } else {
                            this._feedsData.setValue(UIStateData.obtainSuccess(result.getIsCache()).setFinish(result.getIsFinished()).setLoadMore(z26).setType(QFSPublicAccountStaggeredRepo.RequestType.this.ordinal()).setDataList(result.c()).setRetCode(result.getCode()));
                            return;
                        }
                    }
                }
                z18 = true;
                if (!z18) {
                }
                boolean isSucceed2 = result.getIsSucceed();
                QFSPublicAccountStaggeredRepo.RequestType requestType72 = QFSPublicAccountStaggeredRepo.RequestType.this;
                str = this.attachInfo;
                QLog.d("QFSPublicAccountStaggeredViewModel", 1, "[requestFeed] isSucceed: " + isSucceed2 + ", requestType: " + requestType72 + ", attachInfo: " + str);
                if (result.getIsSucceed()) {
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void m2(QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel, QFSPublicAccountStaggeredRepo.RequestType requestType, QCircleInitBean qCircleInitBean, List list, byte[] bArr, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = null;
        }
        if ((i3 & 8) != 0) {
            bArr = null;
        }
        qFSPublicAccountStaggeredViewModel.l2(requestType, qCircleInitBean, list, bArr);
    }

    private final void o2() {
        QFSPublicAccountStaggeredRepo.J(this.repo, null, new Function1<QFSPublicAccountStaggeredRepo.GetAdMaskTaskInfoResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel$requestPreloadXingHuanMaskInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPublicAccountStaggeredRepo.GetAdMaskTaskInfoResult getAdMaskTaskInfoResult) {
                invoke2(getAdMaskTaskInfoResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QFSPublicAccountStaggeredRepo.GetAdMaskTaskInfoResult result) {
                MutableLiveData mutableLiveData;
                List mutableListOf;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.d("QFSPublicAccountStaggeredViewModel", 1, "[requestPreloadXingHuanMaskInfo] isSucceed: " + result.getIsSucceed());
                if (!result.getIsSucceed()) {
                    mutableLiveData3 = QFSPublicAccountStaggeredViewModel.this._maskTaskInfo;
                    mutableLiveData3.setValue(UIStateData.obtainError(result.getMsg()).setRetCode(result.getCode()));
                } else if (result.getMaskTaskInfo().length() <= 0) {
                    mutableLiveData2 = QFSPublicAccountStaggeredViewModel.this._maskTaskInfo;
                    mutableLiveData2.setValue(UIStateData.obtainEmpty().setRetCode(result.getCode()));
                } else {
                    mutableLiveData = QFSPublicAccountStaggeredViewModel.this._maskTaskInfo;
                    UIStateData obtainSuccess = UIStateData.obtainSuccess(result.getIsCache());
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(result.getMaskTaskInfo());
                    mutableLiveData.setValue(obtainSuccess.setDataList(mutableListOf).setRetCode(result.getCode()));
                }
            }
        }, 1, null);
    }

    public final void W1(@NotNull QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(qCircleInitBean, "qCircleInitBean");
        this.initBean = qCircleInitBean;
        PreLoader.addListener("2020", new b(this));
    }

    @NotNull
    public final LiveData<UIStateData<List<e30.b>>> Z1() {
        return this.feedsData;
    }

    @NotNull
    public final LiveData<UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp>> a2() {
        return this.followUsersData;
    }

    @NotNull
    public final LiveData<UIStateData<List<JSONObject>>> b2() {
        return this.maskTaskInfo;
    }

    public final void d2(@NotNull QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.attachInfo = null;
        m2(this, QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH, initBean, null, null, 12, null);
    }

    public final void e2(@Nullable final QCircleInitBean initBean) {
        this.repo.s(initBean, new Function1<QFSPublicAccountStaggeredRepo.GetFeedResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel$initFetchCached$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPublicAccountStaggeredRepo.GetFeedResult getFeedResult) {
                invoke2(getFeedResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QFSPublicAccountStaggeredRepo.GetFeedResult it) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(it, "it");
                bool = QFSPublicAccountStaggeredViewModel.this.isFirstPreloadSetData;
                if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    QFSPublicAccountStaggeredViewModel.this.X1(initBean, it.c());
                    QFSPublicAccountStaggeredViewModel.this.attachInfo = it.getAttachInfo();
                    QFSPublicAccountStaggeredViewModel.this._feedsData.setValue(UIStateData.obtainSuccess(it.getIsCache()).setFinish(it.getIsFinished()).setLoadMore(false).setType(QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH_CACHED.ordinal()).setDataList(it.c()));
                    return;
                }
                QLog.i("QFSPublicAccountStaggeredViewModel", 1, "[initFetchCached] discard cache data, use preload data");
            }
        });
    }

    public final void f2(@NotNull QCircleInitBean initBean, @NotNull Function0<? extends List<String>> currentFeedIds) {
        boolean z16;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(currentFeedIds, "currentFeedIds");
        UIStateData<List<e30.b>> value = this._feedsData.getValue();
        boolean z17 = false;
        if (value != null && value.getState() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && PreLoader.exists("2020")) {
            QLog.i("QFSPublicAccountStaggeredViewModel", 1, "discard duplicated loadMore, return");
            return;
        }
        UIStateData<List<e30.b>> value2 = this._feedsData.getValue();
        if (value2 != null && value2.isLoading()) {
            z17 = true;
        }
        if (z17) {
            QLog.i("QFSPublicAccountStaggeredViewModel", 1, "discard duplicated loadMore, attachInfo: " + this.attachInfo);
            return;
        }
        m2(this, QFSPublicAccountStaggeredRepo.RequestType.LOAD_MORE, initBean, currentFeedIds.invoke(), null, 8, null);
    }

    public final void g2() {
        o2();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPublicAccountStaggeredViewModel";
    }

    public final void h2(@NotNull QCircleInitBean initBean, @Nullable byte[] transInfo) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.attachInfo = null;
        l2(QFSPublicAccountStaggeredRepo.RequestType.REFRESH, initBean, null, transInfo);
    }

    public final void j2(@NotNull final Function1<? super e30.b, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredViewModel.k2(QFSPublicAccountStaggeredViewModel.this, predicate);
            }
        });
    }

    public final void n2() {
        this.repo.E(new Function1<QFSPublicAccountStaggeredRepo.GetOfficialTopFollowUsersResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel$requestFollowUsers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPublicAccountStaggeredRepo.GetOfficialTopFollowUsersResult getOfficialTopFollowUsersResult) {
                invoke2(getOfficialTopFollowUsersResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QFSPublicAccountStaggeredRepo.GetOfficialTopFollowUsersResult result) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                Intrinsics.checkNotNullParameter(result, "result");
                if (!result.getIsSucceed() || result.getCode() != 0) {
                    mutableLiveData = QFSPublicAccountStaggeredViewModel.this._followUsersData;
                    mutableLiveData.setValue(UIStateData.obtainError(result.getMsg()).setRetCode(result.getCode()));
                } else {
                    mutableLiveData2 = QFSPublicAccountStaggeredViewModel.this._followUsersData;
                    UIStateData obtainSuccess = UIStateData.obtainSuccess(false);
                    FeedCloudOfficialaccount$OfficialTopFollowUsersRsp rsp = result.getRsp();
                    mutableLiveData2.setValue(obtainSuccess.setData(false, rsp != null ? rsp.get() : null).setRetCode(result.getCode()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QFSPublicAccountStaggerPositiveActionCollector.f86891a.f(null);
    }
}

package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.TroopItemType;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.requests.QCircleCheckBindGroupRequest;
import com.tencent.biz.qqcircle.requests.QFSModifyFeedRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$CheckBindGroupRsp;
import qqcircle.QQCircleProfile$GetQQGroupsRsp;
import qqcircle.QQCircleProfile$QQGroup;
import qqcircle.QQCircleProfile$SetProfileRsp;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u001d\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J#\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0002J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J!\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001f2\u0006\u0010!\u001a\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u0004H\u0016J\"\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010'\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\u001dJ\"\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002R*\u0010/\u001a\u0018\u0012\u0014\u0012\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110+j\u0002`,0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R-\u00105\u001a\u0018\u0012\u0014\u0012\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110+j\u0002`,008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R&\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b060*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010.R)\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b06008\u0006\u00a2\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSProfileTroopViewModel;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "W1", "(Lfeedcloud/FeedCloudMeta$StFeed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSPersonalEditViewModel$Group;", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "troop", "", "scene", "b2", "(Lcom/tencent/biz/qqcircle/immersive/personal/data/o;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "troopList", "", "m2", "Lqqcircle/QQCircleProfile$GetQQGroupsRsp;", "rsp", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/TroopRequestType;", "type", "k2", SemanticAttributes.DbSystemValues.H2, "i2", "j2", "", "l2", "T", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "o2", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogTag", "uin", "c2", "f2", "U1", "Z1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/ResponseUIState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_troopListLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "g2", "()Landroidx/lifecycle/LiveData;", "troopListLiveData", "Lkotlin/Pair;", "D", "_changeTroopBindLiveData", "E", "e2", "changeTroopBindLiveData", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "G", "I", "maxAllowBindCount", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSProfileTroopViewModel extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<QFSTroopItemInfo>>> troopListLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<String, QFSTroopItemInfo>> _changeTroopBindLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<String, QFSTroopItemInfo>> changeTroopBindLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<QFSTroopItemInfo> troopList;

    /* renamed from: G, reason: from kotlin metadata */
    private int maxAllowBindCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<QFSTroopItemInfo>>> _troopListLiveData;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f89129a;

        static {
            int[] iArr = new int[TroopRequestType.values().length];
            try {
                iArr[TroopRequestType.PROFILE_HOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopRequestType.PROFILE_GUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TroopRequestType.TYPE_FEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f89129a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "success", "", "retCode", "", "errMsg", "Lqqcircle/QQCircleProfile$SetProfileRsp;", "<anonymous parameter 4>", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqqcircle/QQCircleProfile$SetProfileRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f89130a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super String> cancellableContinuation) {
            this.f89130a = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
            boolean isBlank;
            if (!this.f89130a.isActive()) {
                QLog.w("QFSProfileTroopViewModel", 1, "[changeProfile] cont is not active");
                return;
            }
            QLog.d("QFSProfileTroopViewModel", 1, "[changeProfile] retCode=" + j3 + ", errMsg=" + str);
            if (!z16 || j3 != 0) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (isBlank) {
                    str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19003410);
                }
                this.f89130a.resumeWith(Result.m476constructorimpl(str));
                return;
            }
            this.f89130a.resumeWith(Result.m476constructorimpl(""));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\n\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "success", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class d<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f89132a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super T> cancellableContinuation) {
            this.f89132a = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            if (!this.f89132a.isActive()) {
                QLog.d("QFSProfileTroopViewModel", 1, "[sendRequestSuspend] cont is not active");
                return;
            }
            if (z16 && j3 == 0 && obj != null) {
                this.f89132a.resumeWith(Result.m476constructorimpl(obj));
                return;
            }
            QLog.w("QFSProfileTroopViewModel", 1, "[sendRequestSuspend] success=" + z16 + ", retCode=" + j3 + ", errMsg=" + str);
            CancellableContinuation<T> cancellableContinuation = this.f89132a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException(str))));
        }
    }

    public QFSProfileTroopViewModel() {
        MutableLiveData<UIStateData<List<QFSTroopItemInfo>>> mutableLiveData = new MutableLiveData<>();
        this._troopListLiveData = mutableLiveData;
        this.troopListLiveData = mutableLiveData;
        MutableLiveData<Pair<String, QFSTroopItemInfo>> mutableLiveData2 = new MutableLiveData<>();
        this._changeTroopBindLiveData = mutableLiveData2;
        this.changeTroopBindLiveData = mutableLiveData2;
        this.troopList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object W1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Continuation<? super String> continuation) {
        QFSProfileTroopViewModel$changeFeed$1 qFSProfileTroopViewModel$changeFeed$1;
        Object coroutine_suspended;
        int i3;
        Object obj;
        long j3;
        try {
            if (continuation instanceof QFSProfileTroopViewModel$changeFeed$1) {
                qFSProfileTroopViewModel$changeFeed$1 = (QFSProfileTroopViewModel$changeFeed$1) continuation;
                int i16 = qFSProfileTroopViewModel$changeFeed$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    qFSProfileTroopViewModel$changeFeed$1.label = i16 - Integer.MIN_VALUE;
                    Object obj2 = qFSProfileTroopViewModel$changeFeed$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = qFSProfileTroopViewModel$changeFeed$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj2);
                            return "";
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj2);
                    if (feedCloudMeta$StFeed == null) {
                        QLog.w("QFSProfileTroopViewModel", 1, "[changeFeed] invalid feed");
                        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1929748y);
                        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_perso\u2026bind_qq_group_fail_toast)");
                        return a16;
                    }
                    Iterator<T> it = this.troopList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((QFSTroopItemInfo) obj).getIsBound()) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    QFSTroopItemInfo qFSTroopItemInfo = (QFSTroopItemInfo) obj;
                    if (qFSTroopItemInfo != null) {
                        j3 = qFSTroopItemInfo.getId();
                    } else {
                        j3 = 0;
                    }
                    QLog.d("QFSProfileTroopViewModel", 1, "[changeFeed] troopId=" + j3 + ", feedId=" + feedCloudMeta$StFeed.f398449id.get());
                    QFSModifyFeedRequest qFSModifyFeedRequest = new QFSModifyFeedRequest(feedCloudMeta$StFeed, j3);
                    qFSProfileTroopViewModel$changeFeed$1.label = 1;
                    if (o2(qFSModifyFeedRequest, qFSProfileTroopViewModel$changeFeed$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return "";
                }
            }
            if (i3 == 0) {
            }
        } catch (Throwable th5) {
            QLog.e("QFSProfileTroopViewModel", 1, "[changeFeed] errMsg=" + th5.getMessage());
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1929748y);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_perso\u2026bind_qq_group_fail_toast)");
            return a17;
        }
        qFSProfileTroopViewModel$changeFeed$1 = new QFSProfileTroopViewModel$changeFeed$1(this, continuation);
        Object obj22 = qFSProfileTroopViewModel$changeFeed$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qFSProfileTroopViewModel$changeFeed$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X1(Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QFSPersonalEditViewModel.f2(10015, n2(), new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ void a2(QFSProfileTroopViewModel qFSProfileTroopViewModel, QFSTroopItemInfo qFSTroopItemInfo, TroopRequestType troopRequestType, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            feedCloudMeta$StFeed = null;
        }
        qFSProfileTroopViewModel.Z1(qFSTroopItemInfo, troopRequestType, feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:10:0x002e, B:11:0x005a, B:16:0x008b, B:23:0x0051), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b2(QFSTroopItemInfo qFSTroopItemInfo, int i3, Continuation<? super String> continuation) {
        QFSProfileTroopViewModel$checkTroopBindPermission$1 qFSProfileTroopViewModel$checkTroopBindPermission$1;
        Object coroutine_suspended;
        int i16;
        String str;
        boolean isBlank;
        List listOf;
        boolean isBlank2;
        try {
            if (continuation instanceof QFSProfileTroopViewModel$checkTroopBindPermission$1) {
                qFSProfileTroopViewModel$checkTroopBindPermission$1 = (QFSProfileTroopViewModel$checkTroopBindPermission$1) continuation;
                int i17 = qFSProfileTroopViewModel$checkTroopBindPermission$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    qFSProfileTroopViewModel$checkTroopBindPermission$1.label = i17 - Integer.MIN_VALUE;
                    Object obj = qFSProfileTroopViewModel$checkTroopBindPermission$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = qFSProfileTroopViewModel$checkTroopBindPermission$1.label;
                    str = "";
                    if (i16 == 0) {
                        if (i16 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(Boxing.boxLong(qFSTroopItemInfo.getId()));
                        QCircleCheckBindGroupRequest qCircleCheckBindGroupRequest = new QCircleCheckBindGroupRequest(listOf, i3);
                        qFSProfileTroopViewModel$checkTroopBindPermission$1.label = 1;
                        obj = o2(qCircleCheckBindGroupRequest, qFSProfileTroopViewModel$checkTroopBindPermission$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    QQCircleProfile$CheckBindGroupRsp qQCircleProfile$CheckBindGroupRsp = (QQCircleProfile$CheckBindGroupRsp) obj;
                    QLog.d("QFSProfileTroopViewModel", 1, "[checkTroopBindPermission] prompt=" + qQCircleProfile$CheckBindGroupRsp.prompt_text.get());
                    String str2 = qQCircleProfile$CheckBindGroupRsp.prompt_text.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "rsp.prompt_text.get()");
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!(!isBlank2)) {
                        return "";
                    }
                    String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19003410);
                    Intrinsics.checkNotNullExpressionValue(a16, "{\n                HardCo\u2026toast_text)\n            }");
                    return a16;
                }
            }
            if (i16 == 0) {
            }
            QQCircleProfile$CheckBindGroupRsp qQCircleProfile$CheckBindGroupRsp2 = (QQCircleProfile$CheckBindGroupRsp) obj;
            QLog.d("QFSProfileTroopViewModel", 1, "[checkTroopBindPermission] prompt=" + qQCircleProfile$CheckBindGroupRsp2.prompt_text.get());
            String str22 = qQCircleProfile$CheckBindGroupRsp2.prompt_text.get();
            Intrinsics.checkNotNullExpressionValue(str22, "rsp.prompt_text.get()");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str22);
            if (!(!isBlank2)) {
            }
        } catch (Throwable th5) {
            QLog.e("QFSProfileTroopViewModel", 1, "[checkTroopBindPermission] errMsg=" + th5.getMessage());
            String message = th5.getMessage();
            if (message != null) {
                str = message;
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19003410);
                Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_error_toast_text)");
                return a17;
            }
            return str;
        }
        qFSProfileTroopViewModel$checkTroopBindPermission$1 = new QFSProfileTroopViewModel$checkTroopBindPermission$1(this, continuation);
        Object obj2 = qFSProfileTroopViewModel$checkTroopBindPermission$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qFSProfileTroopViewModel$checkTroopBindPermission$1.label;
        str = "";
    }

    public static /* synthetic */ void d2(QFSProfileTroopViewModel qFSProfileTroopViewModel, String str, TroopRequestType troopRequestType, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            feedCloudMeta$StFeed = null;
        }
        qFSProfileTroopViewModel.c2(str, troopRequestType, feedCloudMeta$StFeed);
    }

    private final List<QFSTroopItemInfo> h2(QQCircleProfile$GetQQGroupsRsp rsp) {
        List sortedWith;
        this.troopList.clear();
        if (l2(rsp)) {
            QLog.i("QFSProfileTroopViewModel", 1, "[handleFeedTroopListRsp] empty lists");
            return this.troopList;
        }
        String titleText = com.tencent.biz.qqcircle.utils.h.a(R.string.f188413wm);
        List<QFSTroopItemInfo> list = this.troopList;
        QFSTroopItemInfo.Companion companion = QFSTroopItemInfo.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(titleText, "titleText");
        list.add(QFSTroopItemInfo.Companion.d(companion, titleText, null, 2, null));
        String resetText = com.tencent.biz.qqcircle.utils.h.a(R.string.f188423wn);
        List<QFSTroopItemInfo> list2 = this.troopList;
        Intrinsics.checkNotNullExpressionValue(resetText, "resetText");
        list2.add(companion.c(resetText, TroopItemType.RESET));
        ArrayList arrayList = new ArrayList();
        List<QQCircleProfile$QQGroup> list3 = rsp.groups.get();
        Intrinsics.checkNotNullExpressionValue(list3, "rsp.groups.get()");
        arrayList.addAll(companion.b(list3, true));
        List<QQCircleProfile$QQGroup> list4 = rsp.other_groups.get();
        Intrinsics.checkNotNullExpressionValue(list4, "rsp.other_groups.get()");
        arrayList.addAll(companion.b(list4, false));
        List<QQCircleProfile$QQGroup> list5 = rsp.used_groups.get();
        Intrinsics.checkNotNullExpressionValue(list5, "rsp.used_groups.get()");
        arrayList.addAll(companion.b(list5, false));
        List<QQCircleProfile$QQGroup> list6 = rsp.unbind_groups.get();
        Intrinsics.checkNotNullExpressionValue(list6, "rsp.unbind_groups.get()");
        arrayList.addAll(companion.b(list6, false));
        List<QFSTroopItemInfo> list7 = this.troopList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Long.valueOf(((QFSTroopItemInfo) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, QFSTroopItemInfo.INSTANCE.e());
        list7.addAll(sortedWith);
        return this.troopList;
    }

    private final List<QFSTroopItemInfo> i2(QQCircleProfile$GetQQGroupsRsp rsp) {
        this.troopList.clear();
        List<QFSTroopItemInfo> list = this.troopList;
        QFSTroopItemInfo.Companion companion = QFSTroopItemInfo.INSTANCE;
        List<QQCircleProfile$QQGroup> list2 = rsp.groups.get();
        Intrinsics.checkNotNullExpressionValue(list2, "rsp.groups.get()");
        list.addAll(companion.b(list2, true));
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.troopList, companion.f());
        return this.troopList;
    }

    private final List<QFSTroopItemInfo> j2(QQCircleProfile$GetQQGroupsRsp rsp) {
        this.troopList.clear();
        if (l2(rsp)) {
            QLog.i("QFSProfileTroopViewModel", 1, "[handleHostTroopListRsp] empty lists");
            return this.troopList;
        }
        List<QFSTroopItemInfo> list = this.troopList;
        QFSTroopItemInfo.Companion companion = QFSTroopItemInfo.INSTANCE;
        List<QQCircleProfile$QQGroup> list2 = rsp.groups.get();
        Intrinsics.checkNotNullExpressionValue(list2, "rsp.groups.get()");
        list.addAll(companion.b(list2, true));
        String text = com.tencent.biz.qqcircle.utils.h.a(R.string.f19234479);
        List<QFSTroopItemInfo> list3 = this.troopList;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        list3.add(QFSTroopItemInfo.Companion.d(companion, text, null, 2, null));
        ArrayList arrayList = new ArrayList();
        List<QQCircleProfile$QQGroup> list4 = rsp.other_groups.get();
        Intrinsics.checkNotNullExpressionValue(list4, "rsp.other_groups.get()");
        arrayList.addAll(companion.b(list4, false));
        List<QQCircleProfile$QQGroup> list5 = rsp.unbind_groups.get();
        Intrinsics.checkNotNullExpressionValue(list5, "rsp.unbind_groups.get()");
        arrayList.addAll(companion.b(list5, false));
        List<QQCircleProfile$QQGroup> list6 = rsp.used_groups.get();
        Intrinsics.checkNotNullExpressionValue(list6, "rsp.used_groups.get()");
        arrayList.addAll(companion.b(list6, false));
        List<QFSTroopItemInfo> list7 = this.troopList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Long.valueOf(((QFSTroopItemInfo) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        list7.addAll(arrayList2);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.troopList, QFSTroopItemInfo.INSTANCE.g());
        return this.troopList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<QFSTroopItemInfo> k2(QQCircleProfile$GetQQGroupsRsp rsp, TroopRequestType type) {
        this.maxAllowBindCount = rsp.controller.allow_bind_groups_count.get();
        QLog.d("QFSProfileTroopViewModel", 1, "[handleTroopListRsp] type=" + type + "size=" + rsp.groups.size() + ", max=" + this.maxAllowBindCount);
        int i3 = b.f89129a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return h2(rsp);
                }
                throw new NoWhenBranchMatchedException();
            }
            return i2(rsp);
        }
        return j2(rsp);
    }

    private final boolean l2(QQCircleProfile$GetQQGroupsRsp rsp) {
        if (rsp.groups.get().isEmpty() && rsp.other_groups.get().isEmpty() && rsp.unbind_groups.get().isEmpty() && rsp.used_groups.get().isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2(List<QFSTroopItemInfo> troopList) {
        if (troopList.isEmpty()) {
            this._troopListLiveData.postValue(UIStateData.obtainEmpty());
        } else {
            this._troopListLiveData.postValue(UIStateData.obtainSuccess(false).setData(false, troopList).setLoadMore(false).setFinish(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QFSPersonalEditViewModel.Group n2() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String joinToString$default;
        String replace$default;
        List<QFSTroopItemInfo> list = this.troopList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((QFSTroopItemInfo) obj).getIsBound()) {
                arrayList.add(obj);
            }
        }
        bg bgVar = bg.f302144a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((QFSTroopItemInfo) it.next()).getId()));
        }
        ArrayList n3 = bgVar.n(arrayList2);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            replace$default = StringsKt__StringsJVMKt.replace$default(((QFSTroopItemInfo) it5.next()).getName(), "\uff0c", "", false, 4, (Object) null);
            arrayList3.add(replace$default);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList3, "\uff0c", null, null, 0, null, null, 62, null);
        QLog.d("QFSProfileTroopViewModel", 1, "[prepareProfilePageGroup] groupNames=" + joinToString$default);
        return new QFSPersonalEditViewModel.Group(true, joinToString$default, n3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object o2(BaseRequest baseRequest, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        sendRequest(baseRequest, new d(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final boolean U1() {
        List<QFSTroopItemInfo> list = this.troopList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((QFSTroopItemInfo) obj).getIsBound()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() < this.maxAllowBindCount) {
            return true;
        }
        return false;
    }

    public final void Z1(@NotNull QFSTroopItemInfo troop, @NotNull TroopRequestType type, @Nullable FeedCloudMeta$StFeed feed) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(troop, "troop");
        Intrinsics.checkNotNullParameter(type, "type");
        long id5 = troop.getId();
        if (feed != null) {
            pBStringField = feed.f398449id;
        } else {
            pBStringField = null;
        }
        QLog.d("QFSProfileTroopViewModel", 1, "[changeTroopBind] troopId=" + id5 + ", scene=" + type + ", feedId=" + pBStringField);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSProfileTroopViewModel$changeTroopBind$1(type, troop, this, feed, null), 3, null);
    }

    public final void c2(@NotNull String uin, @NotNull TroopRequestType type, @Nullable FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(type, "type");
        this._troopListLiveData.setValue(UIStateData.obtainLoading());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSProfileTroopViewModel$fetchTroopList$1(type, uin, feed, this, null), 3, null);
    }

    @NotNull
    public final LiveData<Pair<String, QFSTroopItemInfo>> e2() {
        return this.changeTroopBindLiveData;
    }

    /* renamed from: f2, reason: from getter */
    public final int getMaxAllowBindCount() {
        return this.maxAllowBindCount;
    }

    @NotNull
    public final LiveData<UIStateData<List<QFSTroopItemInfo>>> g2() {
        return this.troopListLiveData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSProfileTroopViewModel";
    }
}

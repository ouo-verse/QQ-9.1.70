package com.tencent.mobileqq.wink.publish.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.request.QCircleCheckBindGroupRequest;
import com.tencent.mobileqq.wink.request.QFSPersonalQQGroupRequest;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$CheckBindGroupRsp;
import qqcircle.QQCircleProfile$GetQQGroupsRsp;
import qqcircle.QQCircleProfile$QQGroup;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\u0011\u001a\u00020\u00022\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\nJ&\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0\n8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 \u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "W1", "", "troopId", "", "troopName", "troopIconUrl", "Z1", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/wink/publish/viewmodel/q;", "businessSourceState", "f2", "", "Lha3/b;", "draftContent", "d2", SemanticAttributes.DbSystemValues.H2, "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "enableBindTroop", "Landroidx/lifecycle/MediatorLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MediatorLiveData;", "_bindTroopItemState", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "bindTroopItemState", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel$b;", "D", "_troopInfo", "E", "c2", "troopInfo", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishTroopViewModel extends BaseViewModel {

    /* renamed from: F */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    @NotNull
    private final LiveData<PublishSettingItemState> bindTroopItemState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<TroopInfo> _troopInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<TroopInfo> troopInfo;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> enableBindTroop;

    /* renamed from: m */
    @NotNull
    private final MediatorLiveData<PublishSettingItemState> _bindTroopItemState;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel$1 */
    /* loaded from: classes21.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke */
        public final void invoke2(Boolean it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                PublishSettingItemState publishSettingItemState = (PublishSettingItemState) PublishTroopViewModel.this._bindTroopItemState.getValue();
                if (publishSettingItemState == null) {
                    publishSettingItemState = new PublishSettingItemState(true, true, false);
                }
                publishSettingItemState.f(true);
                PublishTroopViewModel.this._bindTroopItemState.postValue(publishSettingItemState);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel$a */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTroopViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "troopId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "troopName", "troopIconUrl", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class TroopInfo {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final long troopId;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @Nullable
        private final String troopName;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        @Nullable
        private final String troopIconUrl;

        public TroopInfo(long j3, @Nullable String str, @Nullable String str2) {
            this.troopId = j3;
            this.troopName = str;
            this.troopIconUrl = str2;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getTroopIconUrl() {
            return this.troopIconUrl;
        }

        /* renamed from: b, reason: from getter */
        public final long getTroopId() {
            return this.troopId;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getTroopName() {
            return this.troopName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TroopInfo)) {
                return false;
            }
            TroopInfo troopInfo = (TroopInfo) other;
            if (this.troopId == troopInfo.troopId && Intrinsics.areEqual(this.troopName, troopInfo.troopName) && Intrinsics.areEqual(this.troopIconUrl, troopInfo.troopIconUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int a16 = androidx.fragment.app.a.a(this.troopId) * 31;
            String str = this.troopName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            String str2 = this.troopIconUrl;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "TroopInfo(troopId=" + this.troopId + ", troopName=" + this.troopName + ", troopIconUrl=" + this.troopIconUrl + ")";
        }
    }

    public PublishTroopViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.enableBindTroop = mutableLiveData;
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = new MediatorLiveData<>();
        this._bindTroopItemState = mediatorLiveData;
        this.bindTroopItemState = mediatorLiveData;
        MediatorLiveData<TroopInfo> mediatorLiveData2 = new MediatorLiveData<>();
        this._troopInfo = mediatorLiveData2;
        this.troopInfo = mediatorLiveData2;
        final AnonymousClass1 anonymousClass1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel.1
            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    PublishSettingItemState publishSettingItemState = (PublishSettingItemState) PublishTroopViewModel.this._bindTroopItemState.getValue();
                    if (publishSettingItemState == null) {
                        publishSettingItemState = new PublishSettingItemState(true, true, false);
                    }
                    publishSettingItemState.f(true);
                    PublishTroopViewModel.this._bindTroopItemState.postValue(publishSettingItemState);
                }
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishTroopViewModel.Q1(Function1.this, obj);
            }
        });
        W1();
    }

    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W1() {
        sendRequest(new QCircleCheckBindGroupRequest(null, 1, 0 == true ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.y
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                PublishTroopViewModel.X1(PublishTroopViewModel.this, baseRequest, z16, j3, str, (QQCircleProfile$CheckBindGroupRsp) obj);
            }
        });
    }

    public static final void X1(PublishTroopViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$CheckBindGroupRsp qQCircleProfile$CheckBindGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("PublishTroopViewModel", "[checkBindGroup] onReceive: isSuccess=" + z16 + ", retCode=" + j3 + ", errMsg=" + str);
        if (z16 && j3 == 0 && qQCircleProfile$CheckBindGroupRsp != null) {
            this$0.enableBindTroop.postValue(Boolean.TRUE);
        }
    }

    public final void Z1(final long troopId, final String troopName, final String troopIconUrl) {
        sendRequest(new QFSPersonalQQGroupRequest(com.tencent.mobileqq.wink.b.b().getCurrentAccountUin(), true), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.z
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                PublishTroopViewModel.a2(PublishTroopViewModel.this, troopId, troopName, troopIconUrl, baseRequest, z16, j3, str, (QQCircleProfile$GetQQGroupsRsp) obj);
            }
        });
    }

    public static final void a2(PublishTroopViewModel this$0, long j3, String str, String str2, BaseRequest baseRequest, boolean z16, long j16, String str3, QQCircleProfile$GetQQGroupsRsp qQCircleProfile$GetQQGroupsRsp) {
        QQCircleProfile$QQGroup qQCircleProfile$QQGroup;
        boolean z17;
        Object obj;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("PublishTroopViewModel", "[checkBindTroopExist] onReceive: isSuccess=" + z16 + ", retCode=" + j16 + ", errMsg=" + str3);
        if (z16 && j16 == 0 && qQCircleProfile$GetQQGroupsRsp != null) {
            List<QQCircleProfile$QQGroup> list = qQCircleProfile$GetQQGroupsRsp.groups.get();
            Object obj2 = null;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((QQCircleProfile$QQGroup) obj).f429310id.get() == j3) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                qQCircleProfile$QQGroup = (QQCircleProfile$QQGroup) obj;
            } else {
                qQCircleProfile$QQGroup = null;
            }
            if (qQCircleProfile$QQGroup == null) {
                List<QQCircleProfile$QQGroup> list2 = qQCircleProfile$GetQQGroupsRsp.allow_bind_groups.get();
                if (list2 != null) {
                    Iterator<T> it5 = list2.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next = it5.next();
                        if (((QQCircleProfile$QQGroup) next).f429310id.get() == j3) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            obj2 = next;
                            break;
                        }
                    }
                    obj2 = (QQCircleProfile$QQGroup) obj2;
                }
                if (obj2 == null) {
                    return;
                }
            }
            this$0.h2(j3, str, str2);
        }
    }

    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void g2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void i2(PublishTroopViewModel publishTroopViewModel, long j3, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        publishTroopViewModel.h2(j3, str, str2);
    }

    @NotNull
    public final LiveData<PublishSettingItemState> b2() {
        return this.bindTroopItemState;
    }

    @NotNull
    public final LiveData<TroopInfo> c2() {
        return this.troopInfo;
    }

    public final void d2(@Nullable final LiveData<List<ha3.b>> draftContent) {
        if (draftContent != null) {
            MediatorLiveData<TroopInfo> mediatorLiveData = this._troopInfo;
            final Function1<List<? extends ha3.b>, Unit> function1 = new Function1<List<? extends ha3.b>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel$observeCachedTroopInfo$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ha3.b> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
                /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(List<? extends ha3.b> it) {
                    Object firstOrNull;
                    HashMap<String, String> hashMap;
                    MediatorLiveData mediatorLiveData2;
                    long j3;
                    Long longOrNull;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) it);
                    ha3.b bVar = (ha3.b) firstOrNull;
                    if (bVar == null || (hashMap = bVar.f404635t) == null) {
                        return;
                    }
                    PublishTroopViewModel publishTroopViewModel = PublishTroopViewModel.this;
                    LiveData<List<ha3.b>> liveData = draftContent;
                    mediatorLiveData2 = publishTroopViewModel._troopInfo;
                    mediatorLiveData2.removeSource(liveData);
                    String str = hashMap.get("feedBindTroopId");
                    if (str != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "get(FSPublishDraft.TROOP_ID)");
                        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                        if (longOrNull != null) {
                            j3 = longOrNull.longValue();
                            if (j3 == 0) {
                                publishTroopViewModel.Z1(j3, hashMap.get("feedBindTroopName"), hashMap.get("feedBindTroopIconUrl"));
                                return;
                            }
                            return;
                        }
                    }
                    j3 = 0;
                    if (j3 == 0) {
                    }
                }
            };
            mediatorLiveData.addSource(draftContent, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PublishTroopViewModel.e2(Function1.this, obj);
                }
            });
        }
    }

    public final void f2(@NotNull LiveData<PublishSettingItemState> businessSourceState) {
        Intrinsics.checkNotNullParameter(businessSourceState, "businessSourceState");
        this._bindTroopItemState.removeSource(businessSourceState);
        MediatorLiveData<PublishSettingItemState> mediatorLiveData = this._bindTroopItemState;
        final Function1<PublishSettingItemState, Unit> function1 = new Function1<PublishSettingItemState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel$observeItemState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItemState publishSettingItemState) {
                invoke2(publishSettingItemState);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItemState publishSettingItemState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = PublishTroopViewModel.this.enableBindTroop;
                Boolean bool = (Boolean) mutableLiveData.getValue();
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                publishSettingItemState.f(bool.booleanValue());
                PublishTroopViewModel.this._bindTroopItemState.postValue(publishSettingItemState);
            }
        };
        mediatorLiveData.addSource(businessSourceState, new Observer() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishTroopViewModel.g2(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "PublishTroopViewModel";
    }

    public final void h2(long j3, @Nullable String str, @Nullable String str2) {
        this._troopInfo.postValue(new TroopInfo(j3, str, str2));
    }
}

package com.tencent.mobileqq.troop.troopnotification.recommend;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.recommend.c;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.troopnotification.event.LaunchMoreNotificationPageEvent;
import com.tencent.mobileqq.troop.troopnotification.event.TroopTryHideLoadingDialogEvent;
import com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendViewModel;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\t*\u0002LP\u0018\u0000 V2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0014J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0010\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017H\u0016R\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR%\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e0\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u001dR)\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120,0\u001a8\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u001d\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0006\u00a2\u0006\f\n\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010/R+\u0010<\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u00010\u00060,0\u001a8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b;\u0010/R\"\u0010B\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00106\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0006\u00a2\u0006\f\n\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010/R\u001d\u0010K\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "j2", "", "troopUin", "g2", SemanticAttributes.DbSystemValues.H2, "onCleared", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b2", "", "Lcom/tencent/qqnt/notification/f;", TabPreloadItem.TAB_NAME_MESSAGE, "i2", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "d2", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_showDataList", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "showDataList", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "notificationMsgList", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "D", "_rcmdTroopList", "Lkotlin/Pair;", "E", "T1", "()Landroidx/lifecycle/MutableLiveData;", "loadMoreRcmdDataState", "", UserInfo.SEX_FEMALE, "I", "curLoadRcmdTroopPage", "G", "Z", "hasLoadTroopFinish", "H", "Z1", UIJsPlugin.EVENT_SHOW_LOADING, ICustomDataEditor.STRING_ARRAY_PARAM_2, UIJsPlugin.EVENT_SHOW_TOAST, "J", "U1", "()Z", "f2", "(Z)V", "needShowToast", "K", "S1", "hadLaunchMoreNotificationPage", "Lcom/tencent/mobileqq/troop/recommend/a;", "L", "Lkotlin/Lazy;", "W1", "()Lcom/tencent/mobileqq/troop/recommend/a;", "recommendHandler", "com/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$b", "M", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$b;", "recommendObserver", "com/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$c", "N", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$c;", "troopMngObserver", "<init>", "()V", "P", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationWithRecommendViewModel extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.notification.f> notificationMsgList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<RecommendTroopItem>> _rcmdTroopList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, Boolean>> loadMoreRcmdDataState;

    /* renamed from: F, reason: from kotlin metadata */
    private int curLoadRcmdTroopPage;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasLoadTroopFinish;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> showLoading;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Integer, String>> showToast;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean needShowToast;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> hadLaunchMoreNotificationPage;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy recommendHandler;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final b recommendObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final c troopMngObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<Object>> _showDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<List<Object>> showDataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$a;", "", "", "RECOMMEND_KEY_WORD_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JX\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0014\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$b", "Lcom/tencent/mobileqq/troop/recommend/c;", "", "isSuccess", "", "itemType", "", "keyWord", "serverPageID", "isEnd", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.recommend.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.recommend.c
        protected void a(boolean isSuccess, int itemType, @NotNull String keyWord, int serverPageID, boolean isEnd, @Nullable List<? extends c.a> dataList, @NotNull guildSearchRecommendSvr$FirstShow firstShow, @NotNull ByteStringMicro sessionInfo, boolean isLoadMore) {
            Integer num;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            List arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(itemType), keyWord, Integer.valueOf(serverPageID), Boolean.valueOf(isEnd), dataList, firstShow, sessionInfo, Boolean.valueOf(isLoadMore));
                return;
            }
            Intrinsics.checkNotNullParameter(keyWord, "keyWord");
            Intrinsics.checkNotNullParameter(firstShow, "firstShow");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            if (!Intrinsics.areEqual(keyWord, "")) {
                if (QLog.isDebugVersion()) {
                    QLog.i("TroopNotifyWithRcmdVM", 2, "[onGetRecommendGroup] keyWord:" + keyWord + ", not recommend data");
                    return;
                }
                return;
            }
            ArrayList arrayList2 = null;
            if (dataList != null) {
                num = Integer.valueOf(dataList.size());
            } else {
                num = null;
            }
            QLog.i("TroopNotifyWithRcmdVM", 1, "[onGetRecommendGroup] isSuccess:" + isSuccess + ". keyWord:" + keyWord + ", dataList:" + num + ", page:" + serverPageID + ", isEnd:" + isEnd + ", isLoadMore:" + isLoadMore);
            TroopNotificationWithRecommendViewModel.this.hasLoadTroopFinish = true;
            if (isSuccess) {
                TroopNotificationWithRecommendViewModel.this.curLoadRcmdTroopPage = serverPageID;
            }
            if (!isLoadMore || !isSuccess) {
                MutableLiveData mutableLiveData = TroopNotificationWithRecommendViewModel.this._rcmdTroopList;
                if (dataList != null) {
                    List<? extends c.a> list = dataList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((c.a) it.next()).a());
                    }
                }
                mutableLiveData.postValue(arrayList2);
            } else if (dataList != null) {
                List<? extends c.a> list2 = dataList;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList3.add(((c.a) it5.next()).a());
                }
                TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = TroopNotificationWithRecommendViewModel.this;
                List list3 = (List) troopNotificationWithRecommendViewModel._rcmdTroopList.getValue();
                if (list3 != null) {
                    arrayList = list3;
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList4 = new ArrayList(arrayList);
                arrayList4.addAll(arrayList3);
                troopNotificationWithRecommendViewModel._rcmdTroopList.postValue(arrayList4);
            }
            MutableLiveData<Pair<Boolean, Boolean>> T1 = TroopNotificationWithRecommendViewModel.this.T1();
            Boolean bool = Boolean.FALSE;
            if (isSuccess && !isEnd) {
                z16 = true;
            }
            T1.postValue(new Pair<>(bool, Boolean.valueOf(z16)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel$c", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "reqtype", "result", "", "troopUin", "", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendViewModel.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(int i3, TroopNotificationWithRecommendViewModel this$0, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i3 == 0) {
                this$0.h2(str);
            } else {
                this$0.g2(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int reqtype, final int result, @Nullable final String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
                return;
            }
            QLog.d("TroopNotifyWithRcmdVM", 1, "[onTroopManagerSuccess] result:" + result + ", troopUin:" + troopUin);
            if (1 == reqtype) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = TroopNotificationWithRecommendViewModel.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopNotificationWithRecommendViewModel.c.z(result, troopNotificationWithRecommendViewModel, troopUin);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationWithRecommendViewModel() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<List<Object>> mutableLiveData = new MutableLiveData<>();
        this._showDataList = mutableLiveData;
        this.showDataList = mutableLiveData;
        this.notificationMsgList = new ArrayList();
        this._rcmdTroopList = new MutableLiveData<>();
        this.loadMoreRcmdDataState = new MutableLiveData<>();
        this.curLoadRcmdTroopPage = -1;
        this.showLoading = new MutableLiveData<>();
        this.showToast = new MutableLiveData<>();
        this.hadLaunchMoreNotificationPage = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(TroopNotificationWithRecommendViewModel$recommendHandler$2.INSTANCE);
        this.recommendHandler = lazy;
        b bVar = new b();
        this.recommendObserver = bVar;
        c cVar = new c();
        this.troopMngObserver = cVar;
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.addObserver(bVar);
        }
        AppInterface e17 = bg.e();
        if (e17 != null) {
            e17.addObserver(cVar);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final com.tencent.mobileqq.troop.recommend.a W1() {
        return (com.tencent.mobileqq.troop.recommend.a) this.recommendHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void e2(TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        troopNotificationWithRecommendViewModel.d2(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String troopUin) {
        boolean z16;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<RecommendTroopItem> value = this._rcmdTroopList.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (Intrinsics.areEqual(((RecommendTroopItem) obj).uin, troopUin)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((RecommendTroopItem) it.next()).hasRequestJoin = true;
            }
        }
        this._rcmdTroopList.postValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(String troopUin) {
        boolean z16;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<RecommendTroopItem> value = this._rcmdTroopList.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (Intrinsics.areEqual(((RecommendTroopItem) obj).uin, troopUin)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((RecommendTroopItem) it.next()).privilege = 0;
            }
        }
        this._rcmdTroopList.postValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2() {
        boolean z16;
        Integer num;
        if (QLog.isDebugVersion()) {
            int size = this.notificationMsgList.size();
            List<RecommendTroopItem> value = this._rcmdTroopList.getValue();
            if (value != null) {
                num = Integer.valueOf(value.size());
            } else {
                num = null;
            }
            QLog.d("TroopNotifyWithRcmdVM", 4, "[updateShowDataList] notSize:" + size + ", rcmdSize:" + num);
        }
        ArrayList arrayList = new ArrayList();
        boolean isEmpty = this.notificationMsgList.isEmpty();
        List<RecommendTroopItem> value2 = this._rcmdTroopList.getValue();
        if (value2 != null && !value2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.hasLoadTroopFinish && isEmpty && z16) {
            arrayList.add(TroopNotifyWithRecommendPlaceHolder.SHOW_ALL_EMPTY);
        } else {
            if (isEmpty) {
                arrayList.add(TroopNotifyWithRecommendPlaceHolder.SHOW_EMPTY_NOTIFICATION);
            } else if (this.notificationMsgList != null) {
                arrayList.add(TroopNotifyWithRecommendPlaceHolder.SHOW_MORE);
            }
            if (z16) {
                if (this.hasLoadTroopFinish) {
                    arrayList.add(TroopNotifyWithRecommendPlaceHolder.SHOW_EMPTY_TROOP);
                } else {
                    arrayList.add(TroopNotifyWithRecommendPlaceHolder.SHOW_LOADING_TROOP);
                }
            } else {
                List<RecommendTroopItem> value3 = this._rcmdTroopList.getValue();
                if (value3 != null) {
                    arrayList.add(TroopNotifyWithRecommendPlaceHolder.SHOW_MORE_TROOP);
                    arrayList.addAll(value3);
                }
            }
        }
        this._showDataList.postValue(arrayList);
    }

    @NotNull
    public final MutableLiveData<Boolean> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.hadLaunchMoreNotificationPage;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, Boolean>> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.loadMoreRcmdDataState;
    }

    public final boolean U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.needShowToast;
    }

    @NotNull
    public final LiveData<List<Object>> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showDataList;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showLoading;
    }

    @NotNull
    public final MutableLiveData<Pair<Integer, String>> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.showToast;
    }

    public final void b2(@NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (QLog.isColorLevel()) {
            QLog.i("TroopNotifyWithRcmdVM", 2, "[loadData] ");
        }
        MutableLiveData<List<RecommendTroopItem>> mutableLiveData = this._rcmdTroopList;
        final Function1<List<? extends RecommendTroopItem>, Unit> function1 = new Function1<List<? extends RecommendTroopItem>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendViewModel$loadData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RecommendTroopItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<? extends RecommendTroopItem> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopNotificationWithRecommendViewModel.this.j2();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNotificationWithRecommendViewModel.c2(Function1.this, obj);
            }
        });
        e2(this, false, 1, null);
    }

    public final void d2(boolean isLoadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, isLoadMore);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopNotifyWithRcmdVM", 2, "[loadRcmdTroopData] isLoadMore:" + isLoadMore + ", page:" + this.curLoadRcmdTroopPage + ", state:" + this.loadMoreRcmdDataState.getValue());
        }
        if (isLoadMore) {
            Pair<Boolean, Boolean> value = this.loadMoreRcmdDataState.getValue();
            boolean z16 = false;
            if (value != null && value.getFirst().booleanValue()) {
                z16 = true;
            }
            if (z16) {
                QLog.i("TroopNotifyWithRcmdVM", 1, "[loadRcmdTroopData] isLoading");
                return;
            }
            this.loadMoreRcmdDataState.postValue(new Pair<>(Boolean.TRUE, Boolean.FALSE));
        }
        com.tencent.mobileqq.troop.recommend.a W1 = W1();
        if (W1 != null) {
            W1.C1(-1, null, "", this.curLoadRcmdTroopPage, 2, false, isLoadMore, "TroopNotifyWithRcmdVM", false);
        }
    }

    public final void f2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.needShowToast = z16;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TroopTryHideLoadingDialogEvent.class);
        arrayList.add(LaunchMoreNotificationPageEvent.class);
        return arrayList;
    }

    public final void i2(@NotNull List<com.tencent.qqnt.notification.f> msgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        this.notificationMsgList.clear();
        this.notificationMsgList.addAll(msgList);
        j2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onCleared();
        if (QLog.isColorLevel()) {
            QLog.i("TroopNotifyWithRcmdVM", 2, "[onCleared] ");
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.removeObserver(this.recommendObserver);
        }
        AppInterface e17 = bg.e();
        if (e17 != null) {
            e17.removeObserver(this.troopMngObserver);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TroopTryHideLoadingDialogEvent) {
            if (Intrinsics.areEqual(this.showLoading.getValue(), Boolean.TRUE)) {
                this.showLoading.postValue(Boolean.FALSE);
            }
        } else if (event instanceof LaunchMoreNotificationPageEvent) {
            this.hadLaunchMoreNotificationPage.postValue(Boolean.TRUE);
        }
    }
}

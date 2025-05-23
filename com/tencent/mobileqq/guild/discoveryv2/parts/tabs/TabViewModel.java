package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.mobileqq.qqguildsdk.data.genc.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bw;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\u00020\u0001:\u0002>?B%\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0002\u0010 \u001a\u00020\u0018\u00a2\u0006\u0004\b;\u0010<J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0007J\u001a\u0010\u0012\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0010R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0-0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010%R \u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180-0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0-0\u00108F\u00a2\u0006\u0006\u001a\u0004\b7\u00106R\u001d\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180-0\u00108F\u00a2\u0006\u0006\u001a\u0004\b9\u00106\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "tabList", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "account", "onAccountChanged", "e2", "b2", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/a;", "clickData", "d2", "c2", "Landroidx/lifecycle/LiveData;", "liveTabList", "P1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "X1", "()Ljava/lang/String;", "tabName", "", "D", "I", "W1", "()I", "tabId", "E", "Z1", "tabType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetConfigTabContentRsp;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "configTabLoadState", "Landroidx/lifecycle/MediatorLiveData;", "G", "Landroidx/lifecycle/MediatorLiveData;", "_liveTabList", "Lef1/a;", "H", "_liveEventClickData", "_liveEventNavTabClickData", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "J", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "U1", "()Landroidx/lifecycle/LiveData;", "S1", "liveEventClickData", "T1", "liveEventNavTabClickData", "<init>", "(Ljava/lang/String;II)V", "K", "a", "LoadState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TabViewModel extends ef1.b {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String tabName;

    /* renamed from: D, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: E, reason: from kotlin metadata */
    private final int tabType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LoadState<IGProGetConfigTabContentRsp>> configTabLoadState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<IGProNavigationTab>> _liveTabList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<TabClickData>> _liveEventClickData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Integer>> _liveEventNavTabClickData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private IGPSService gpsService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0004\u0015B#\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0004\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "T", "", "", "a", "I", "b", "()I", "status", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "Lri1/a;", "c", "Lri1/a;", "getError", "()Lri1/a;", "error", "<init>", "(ILjava/lang/Object;Lri1/a;)V", "d", "Status", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class LoadState<T> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int status;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final T data;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ri1.a error;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState$Status;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: classes13.dex */
        public @interface Status {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = Companion.f217703a;
            public static final int ERROR = 2;
            public static final int LOADING = 0;
            public static final int SUCCESS = 1;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState$Status$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel$LoadState$Status$a, reason: from kotlin metadata */
            /* loaded from: classes13.dex */
            public static final class Companion {

                /* renamed from: a, reason: collision with root package name */
                static final /* synthetic */ Companion f217703a = new Companion();

                Companion() {
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u0002J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState$a;", "", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "b", "data", "c", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$LoadState;", "Lri1/a;", "error", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel$LoadState$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final <T> LoadState<T> a(@NotNull ri1.a error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new LoadState<>(2, null, error);
            }

            @NotNull
            public final <T> LoadState<T> b() {
                return new LoadState<>(0, null, null);
            }

            @NotNull
            public final <T> LoadState<T> c(T data) {
                return new LoadState<>(1, data, null);
            }

            Companion() {
            }
        }

        public LoadState(int i3, @Nullable T t16, @Nullable ri1.a aVar) {
            this.status = i3;
            this.data = t16;
            this.error = aVar;
        }

        @Nullable
        public final T a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getStatus() {
            return this.status;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J#\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$a;", "", "", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/NavigationTab;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "T", "tabViewModel", "b", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;Ljava/lang/Object;)Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<NavigationTab> a() {
            List<NavigationTab> listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new NavigationTab("\u63a8\u8350", 1, 0, 1));
            return listOf;
        }

        @NotNull
        public final <T extends BaseFeedViewModel> T b(@NotNull T t16, @NotNull Object tabViewModel) {
            Intrinsics.checkNotNullParameter(t16, "<this>");
            Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
            if (!(tabViewModel instanceof TabViewModel)) {
                return t16;
            }
            ((TabViewModel) tabViewModel).P1(t16.T1());
            return t16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel$b", "Lwh2/bw;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetConfigTabContentRsp;", "rsp", "", "rspBuf", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements bw {
        b() {
        }

        @Override // wh2.bw
        public void a(int result, @NotNull String errMsg, @Nullable IGProGetConfigTabContentRsp rsp, @Nullable byte[] rspBuf) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ri1.a error = ri1.a.c(result, errMsg, rsp);
            if (error.d() && rsp != null) {
                TabsSnapshot tabsSnapshot = TabsSnapshot.f217705a;
                int tabType = TabViewModel.this.getTabType();
                ArrayList<IGProNavigationTab> tabList = rsp.getCommonRsp().getTabList();
                Intrinsics.checkNotNullExpressionValue(tabList, "rsp.commonRsp.tabList");
                tabsSnapshot.e(tabType, rspBuf, tabList);
                TabViewModel.this.R1().postValue(LoadState.INSTANCE.c(rsp));
                TabViewModel tabViewModel = TabViewModel.this;
                ArrayList<IGProNavigationTab> tabList2 = rsp.getCommonRsp().getTabList();
                Intrinsics.checkNotNullExpressionValue(tabList2, "rsp.commonRsp.tabList");
                tabViewModel.a2(tabList2);
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "loadSubTabData: error=" + error;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("TabViewModel", 1, (String) it.next(), null);
            }
            MutableLiveData<LoadState<IGProGetConfigTabContentRsp>> R1 = TabViewModel.this.R1();
            LoadState.Companion companion = LoadState.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(error, "error");
            R1.postValue(companion.a(error));
        }
    }

    public TabViewModel() {
        this(null, 0, 0, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(TabViewModel this$0, List list) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Logger.f235387a.d().i("TabViewModel", 1, "addTabListSource[" + System.identityHashCode(this$0) + "]: tabId=" + this$0.getTabId() + ", tabType=" + this$0.getTabType() + ", tabs.size=" + list.size());
        this$0._liveTabList.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void a2(List<? extends IGProNavigationTab> tabList) {
        String joinToString$default;
        if (tabList.isEmpty()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "handleTabList[" + System.identityHashCode(bVar) + "]: tabList is empty";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("TabViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger2.d();
            int identityHashCode = System.identityHashCode(this);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(tabList, null, null, null, 0, null, new Function1<IGProNavigationTab, CharSequence>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel$handleTabList$2$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull IGProNavigationTab it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return it5.getName() + "|" + it5.getTabId() + "|" + it5.getTabType() + "-" + it5.getSubType();
                }
            }, 31, null);
            d16.d("TabViewModel", 1, "handleTabList[" + identityHashCode + "]: " + joinToString$default);
        }
        this._liveTabList.setValue(tabList);
    }

    public final void P1(@NotNull LiveData<List<IGProNavigationTab>> liveTabList) {
        Intrinsics.checkNotNullParameter(liveTabList, "liveTabList");
        this._liveTabList.removeSource(liveTabList);
        this._liveTabList.addSource(liveTabList, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabViewModel.Q1(TabViewModel.this, (List) obj);
            }
        });
    }

    @NotNull
    public final MutableLiveData<LoadState<IGProGetConfigTabContentRsp>> R1() {
        return this.configTabLoadState;
    }

    @NotNull
    public final LiveData<ef1.a<TabClickData>> S1() {
        return this._liveEventClickData;
    }

    @NotNull
    public final LiveData<ef1.a<Integer>> T1() {
        return this._liveEventNavTabClickData;
    }

    @NotNull
    public final LiveData<List<IGProNavigationTab>> U1() {
        return this._liveTabList;
    }

    /* renamed from: W1, reason: from getter */
    public final int getTabId() {
        return this.tabId;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    /* renamed from: Z1, reason: from getter */
    public final int getTabType() {
        return this.tabType;
    }

    @UiThread
    public final void b2() {
        Logger.f235387a.d().i("TabViewModel", 1, "loadConfigTabContent[" + System.identityHashCode(this) + "]: tabId=" + getTabId());
        this.configTabLoadState.setValue(LoadState.INSTANCE.b());
        IGPSService iGPSService = this.gpsService;
        bi biVar = new bi();
        biVar.a().o(this.tabId);
        iGPSService.getConfigTabContent(biVar, new b());
    }

    @UiThread
    public final void c2() {
        this._liveEventNavTabClickData.setValue(new ef1.a<>(Integer.valueOf(this.tabId)));
    }

    @UiThread
    public final void d2(@NotNull TabClickData clickData) {
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        this._liveEventClickData.setValue(new ef1.a<>(clickData));
    }

    public final void e2() {
        Logger.f235387a.d().i("TabViewModel", 1, "whoAmI[" + System.identityHashCode(this) + "]: tabId=" + getTabId() + ", tabType=" + getTabType());
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gpsService = (IGPSService) S0;
    }

    public /* synthetic */ TabViewModel(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
    }

    public TabViewModel(@NotNull String tabName, int i3, int i16) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.tabName = tabName;
        this.tabId = i3;
        this.tabType = i16;
        this.configTabLoadState = new MutableLiveData<>();
        this._liveTabList = new MediatorLiveData<>();
        this._liveEventClickData = new MutableLiveData<>();
        this._liveEventNavTabClickData = new MutableLiveData<>();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gpsService = (IGPSService) S0;
    }
}

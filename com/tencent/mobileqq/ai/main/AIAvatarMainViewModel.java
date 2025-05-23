package com.tencent.mobileqq.ai.main;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.ai.QuickLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.ai.GenerateBtnStatusUpdateEvent;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 [2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0 j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!`\"H\u0016R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0/0.8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R&\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R/\u0010<\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0/090.8\u0006\u00a2\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u00103R\"\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001c0?8\u0006\u00a2\u0006\f\n\u0004\bF\u0010B\u001a\u0004\bG\u0010DR)\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c050?8\u0006\u00a2\u0006\f\n\u0004\bI\u0010B\u001a\u0004\bJ\u0010DR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001c0?8\u0006\u00a2\u0006\f\n\u0004\bL\u0010B\u001a\u0004\bM\u0010DR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001c0?8\u0006\u00a2\u0006\f\n\u0004\bO\u0010B\u001a\u0004\bP\u0010DR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00150?8\u0006\u00a2\u0006\f\n\u0004\bR\u0010B\u001a\u0004\bS\u0010DR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "g2", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "d2", "onResume", "Landroidx/fragment/app/FragmentActivity;", "P1", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "tabInfo", SemanticAttributes.DbSystemValues.H2, "", "", "b2", "()[Ljava/lang/String;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, com.tencent.luggage.wxa.c8.c.G, "Z1", "", "Lcom/tencent/mobileqq/ai/main/feeds/a;", "T1", "", "c2", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/ai/main/l;", "i", "Lcom/tencent/mobileqq/ai/main/l;", "repo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "_tabData", "Landroidx/lifecycle/MutableLiveData;", "", "D", "Landroidx/lifecycle/MutableLiveData;", "X1", "()Landroidx/lifecycle/MutableLiveData;", "tabData", "", "E", "Ljava/util/Map;", "_feedsData", "", UserInfo.SEX_FEMALE, "S1", "feedsData", "G", "_hasMore", "Lcom/tencent/mobileqq/ai/QuickLiveData;", "Lcom/tencent/mobileqq/ai/main/a;", "H", "Lcom/tencent/mobileqq/ai/QuickLiveData;", "Q1", "()Lcom/tencent/mobileqq/ai/QuickLiveData;", "actionStatusInfo", "I", "f2", "isFirstLoading", "J", "U1", "hasMore", "K", "e2", "isEmpty", "L", "R1", "enableTransition", "M", "W1", "onNavMoreAction", "Lcom/tencent/mobileqq/ai/main/AIAvatarSVipPayBroadcastHelper;", "N", "Lcom/tencent/mobileqq/ai/main/AIAvatarSVipPayBroadcastHelper;", "svipBroadcastHelper", "<init>", "()V", "P", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarMainViewModel extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<AIAvatarFeedsTabInfo> _tabData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<AIAvatarFeedsTabInfo>> tabData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>> _feedsData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>>> feedsData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Map<AIAvatarFeedsTabInfo, Boolean> _hasMore;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QuickLiveData<a> actionStatusInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final QuickLiveData<Boolean> isFirstLoading;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final QuickLiveData<Map<AIAvatarFeedsTabInfo, Boolean>> hasMore;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QuickLiveData<Boolean> isEmpty;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final QuickLiveData<Boolean> enableTransition;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final QuickLiveData<Integer> onNavMoreAction;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final AIAvatarSVipPayBroadcastHelper svipBroadcastHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l repo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.main.AIAvatarMainViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final AIAvatarMainViewModel a(@NotNull ViewModelStoreOwner owner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIAvatarMainViewModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) owner);
            }
            Intrinsics.checkNotNullParameter(owner, "owner");
            ViewModel viewModel = new ViewModelProvider(owner).get(AIAvatarMainViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner)\u2026ainViewModel::class.java)");
            return (AIAvatarMainViewModel) viewModel;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22444);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIAvatarMainViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.repo = new l();
        this._tabData = new ArrayList();
        this.tabData = new QuickLiveData();
        this._feedsData = new LinkedHashMap();
        this.feedsData = new QuickLiveData();
        this._hasMore = new LinkedHashMap();
        this.actionStatusInfo = new QuickLiveData<>();
        Boolean bool = Boolean.FALSE;
        this.isFirstLoading = new QuickLiveData<>(bool);
        this.hasMore = new QuickLiveData<>(this._hasMore);
        this.isEmpty = new QuickLiveData<>(bool);
        this.enableTransition = new QuickLiveData<>(Boolean.TRUE);
        this.onNavMoreAction = new QuickLiveData<>();
        this.svipBroadcastHelper = new AIAvatarSVipPayBroadcastHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        a value = this.actionStatusInfo.getValue();
        if (value != null) {
            this.actionStatusInfo.postValue(value);
        }
    }

    public final void P1(@NotNull FragmentActivity context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.svipBroadcastHelper.b(context);
    }

    @NotNull
    public final QuickLiveData<a> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QuickLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.actionStatusInfo;
    }

    @NotNull
    public final QuickLiveData<Boolean> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QuickLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.enableTransition;
    }

    @NotNull
    public final MutableLiveData<Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>>> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.feedsData;
    }

    @Nullable
    public final List<com.tencent.mobileqq.ai.main.feeds.a> T1(@NotNull AIAvatarFeedsTabInfo tabInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this, (Object) tabInfo);
        }
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        return this._feedsData.get(tabInfo);
    }

    @NotNull
    public final QuickLiveData<Map<AIAvatarFeedsTabInfo, Boolean>> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QuickLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.hasMore;
    }

    @NotNull
    public final QuickLiveData<Integer> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QuickLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.onNavMoreAction;
    }

    @NotNull
    public final MutableLiveData<List<AIAvatarFeedsTabInfo>> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tabData;
    }

    @NotNull
    public final AIAvatarFeedsTabInfo Z1(int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (AIAvatarFeedsTabInfo) iPatchRedirector.redirect((short) 16, (Object) this, pos);
        }
        return this._tabData.get(pos);
    }

    public final int a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this._tabData.size();
    }

    @NotNull
    public final String[] b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        int size = this._tabData.size();
        String[] strArr = new String[size];
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = "";
        }
        Iterator<AIAvatarFeedsTabInfo> it = this._tabData.iterator();
        while (it.hasNext()) {
            strArr[i3] = it.next().b();
            i3++;
        }
        return strArr;
    }

    public final boolean c2(@NotNull AIAvatarFeedsTabInfo tabInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) tabInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        Boolean bool = this._hasMore.get(tabInfo);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void d2(@NotNull Context context, @NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleOwner = owner;
        this.isFirstLoading.f(Boolean.TRUE, 100L);
        this.repo.j(owner, new Function3<List<? extends AIAvatarFeedsTabInfo>, List<com.tencent.mobileqq.ai.main.feeds.a>, a, Unit>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarMainViewModel$init$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarMainViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AIAvatarFeedsTabInfo> list, List<com.tencent.mobileqq.ai.main.feeds.a> list2, a aVar) {
                invoke2((List<AIAvatarFeedsTabInfo>) list, list2, aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<AIAvatarFeedsTabInfo> tabInfo, @NotNull List<com.tencent.mobileqq.ai.main.feeds.a> mainTabFeedsInfo, @Nullable a aVar) {
                List list;
                List list2;
                Map map;
                Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>> map2;
                List<AIAvatarFeedsTabInfo> list3;
                Map map3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, tabInfo, mainTabFeedsInfo, aVar);
                    return;
                }
                Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
                Intrinsics.checkNotNullParameter(mainTabFeedsInfo, "mainTabFeedsInfo");
                AIAvatarMainViewModel.this.f2().postValue(Boolean.FALSE);
                list = AIAvatarMainViewModel.this._tabData;
                list.clear();
                list2 = AIAvatarMainViewModel.this._tabData;
                list2.addAll(tabInfo);
                map = AIAvatarMainViewModel.this._feedsData;
                map.clear();
                if (!r1.isEmpty()) {
                    map3 = AIAvatarMainViewModel.this._feedsData;
                    map3.put(tabInfo.get(0), mainTabFeedsInfo);
                }
                MutableLiveData<Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>>> S1 = AIAvatarMainViewModel.this.S1();
                map2 = AIAvatarMainViewModel.this._feedsData;
                S1.postValue(map2);
                MutableLiveData<List<AIAvatarFeedsTabInfo>> X1 = AIAvatarMainViewModel.this.X1();
                list3 = AIAvatarMainViewModel.this._tabData;
                X1.postValue(list3);
                AIAvatarMainViewModel.this.e2().postValue(Boolean.valueOf(tabInfo.isEmpty()));
                if (aVar != null) {
                    AIAvatarMainViewModel.this.Q1().postValue(aVar);
                }
            }
        }, new Function1<a, Unit>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarMainViewModel$init$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarMainViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                } else if (aVar != null) {
                    AIAvatarMainViewModel.this.Q1().postValue(aVar);
                }
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
        this.svipBroadcastHelper.a(context, new Function0<Unit>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarMainViewModel$init$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarMainViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AIAvatarMainViewModel.this.g2();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @NotNull
    public final QuickLiveData<Boolean> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QuickLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.isEmpty;
    }

    @NotNull
    public final QuickLiveData<Boolean> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QuickLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.isFirstLoading;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GenerateBtnStatusUpdateEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this);
    }

    public final void h2(@NotNull final AIAvatarFeedsTabInfo tabInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) tabInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        l lVar = this.repo;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleOwner = null;
        }
        lVar.o(lifecycleOwner, tabInfo, new Function2<Boolean, List<? extends com.tencent.mobileqq.ai.main.feeds.a>, Unit>(this) { // from class: com.tencent.mobileqq.ai.main.AIAvatarMainViewModel$requestNextPageFeedsData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIAvatarMainViewModel this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarFeedsTabInfo.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends com.tencent.mobileqq.ai.main.feeds.a> list) {
                invoke(bool.booleanValue(), (List<com.tencent.mobileqq.ai.main.feeds.a>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull List<com.tencent.mobileqq.ai.main.feeds.a> feedsList) {
                Map map;
                Map<AIAvatarFeedsTabInfo, Boolean> map2;
                Map map3;
                Map map4;
                Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>> map5;
                Map map6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), feedsList);
                    return;
                }
                Intrinsics.checkNotNullParameter(feedsList, "feedsList");
                List<com.tencent.mobileqq.ai.main.feeds.a> list = feedsList;
                if (!list.isEmpty()) {
                    AIAvatarFeedsTabInfo.this.c(System.currentTimeMillis());
                    map3 = this.this$0._feedsData;
                    if (map3.get(AIAvatarFeedsTabInfo.this) == null) {
                        map6 = this.this$0._feedsData;
                        map6.put(AIAvatarFeedsTabInfo.this, new ArrayList());
                    }
                    map4 = this.this$0._feedsData;
                    List list2 = (List) map4.get(AIAvatarFeedsTabInfo.this);
                    if (list2 != null) {
                        list2.addAll(list);
                    }
                    MutableLiveData<Map<AIAvatarFeedsTabInfo, List<com.tencent.mobileqq.ai.main.feeds.a>>> S1 = this.this$0.S1();
                    map5 = this.this$0._feedsData;
                    S1.postValue(map5);
                }
                Boolean valueOf = Boolean.valueOf(z16);
                map = this.this$0._hasMore;
                map.put(AIAvatarFeedsTabInfo.this, valueOf);
                QuickLiveData<Map<AIAvatarFeedsTabInfo, Boolean>> U1 = this.this$0.U1();
                map2 = this.this$0._hasMore;
                U1.postValue(map2);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GenerateBtnStatusUpdateEvent generateBtnStatusUpdateEvent;
        ShadowAIGCStatus$GetStatusReply data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) event);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarMainViewModel", 2, "onReceiveEvent: event=" + event);
        }
        a value = this.actionStatusInfo.getValue();
        if (value != null) {
            if (event instanceof GenerateBtnStatusUpdateEvent) {
                generateBtnStatusUpdateEvent = (GenerateBtnStatusUpdateEvent) event;
            } else {
                generateBtnStatusUpdateEvent = null;
            }
            if (generateBtnStatusUpdateEvent != null && (data = generateBtnStatusUpdateEvent.getData()) != null) {
                a b16 = a.INSTANCE.b(data, value);
                if (b16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIAvatarMainViewModel", 2, "onReceiveEvent: available=" + b16.a());
                    }
                    this.actionStatusInfo.postValue(b16);
                    this.repo.s(b16);
                    return;
                }
                QLog.e("AIAvatarMainViewModel", 1, "onReceiveEvent: actionInfo is null");
            }
        }
    }

    public final void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            g2();
        }
    }
}

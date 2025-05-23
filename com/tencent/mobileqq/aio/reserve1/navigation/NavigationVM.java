package com.tencent.mobileqq.aio.reserve1.navigation;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.reserve1.navigation.NavUIState;
import com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent;
import com.tencent.mobileqq.aio.reserve1.navigation.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ContactMsgBoxInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012*\u00012\b\u0007\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001MB\u000f\u0012\u0006\u0010&\u001a\u00020\u0012\u00a2\u0006\u0004\bK\u0010LJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J,\u0010\"\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e0 H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001c0-j\b\u0012\u0004\u0012\u00020\u001c`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00108R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010@R\u0016\u0010C\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010E\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@R\u0018\u0010H\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010@\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/NavigationVM;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "Lcom/tencent/mobileqq/aio/reserve1/navigation/d;", "Lcom/tencent/mobileqq/aio/reserve1/navigation/NavUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactMsgBoxInfo;", "msgBoxInfo", "", "highLightCurrentScreen", "", "B", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "revokeMsgs", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "forceUpdate", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationResultNotify;", "t", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$MsgListScrollEvent;", "r", "delay", "y", "u", "", "seq", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "navType", "", "seq2Type", "w", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "initMsgIntent", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "Z", "isLoading", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "revokeList", "com/tencent/mobileqq/aio/reserve1/navigation/NavigationVM$b", "i", "Lcom/tencent/mobileqq/aio/reserve1/navigation/NavigationVM$b;", "mAction", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "loadingTimeoutRunnable", "showLoadingRunnable", "", "Lcom/tencent/mobileqq/aio/reserve1/navigation/b;", "D", "Ljava/util/List;", "navigations", "J", "unreadCnt", UserInfo.SEX_FEMALE, "firstUnreadSeq", "G", "endUnreadSeq", "H", "Lcom/tencent/mobileqq/aio/reserve1/navigation/b;", "lastShowNavInfo", "I", "mTopSeq", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class NavigationVM extends com.tencent.qqnt.aio.lazy.lazyInit.b<d, NavUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Runnable showLoadingRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.aio.reserve1.navigation.b> navigations;

    /* renamed from: E, reason: from kotlin metadata */
    private long unreadCnt;

    /* renamed from: F, reason: from kotlin metadata */
    private long firstUnreadSeq;

    /* renamed from: G, reason: from kotlin metadata */
    private long endUnreadSeq;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.reserve1.navigation.b lastShowNavInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private long mTopSeq;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLoading;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Long> revokeList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable loadingTimeoutRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/NavigationVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.navigation.NavigationVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/navigation/NavigationVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NavigationVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                NavigationVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.mobileqq.aio.reserve1.navigation.b) t16).a()), Long.valueOf(((com.tencent.mobileqq.aio.reserve1.navigation.b) t17).a()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationVM(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
            return;
        }
        this.revokeList = new ArrayList<>();
        this.mAction = new b();
        this.loadingTimeoutRunnable = new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.navigation.f
            @Override // java.lang.Runnable
            public final void run() {
                NavigationVM.v(NavigationVM.this);
            }
        };
        this.showLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.navigation.g
            @Override // java.lang.Runnable
            public final void run() {
                NavigationVM.A(NavigationVM.this);
            }
        };
        this.navigations = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(NavigationVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateUI(new NavUIState.UpdateLoading(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B(ContactMsgBoxInfo msgBoxInfo, boolean highLightCurrentScreen) {
        z.d dVar;
        long j3;
        z.i iVar;
        int i3;
        List sortedWith;
        ArrayList<MsgBoxNecessaryMsgInfo> msgInfos;
        HashSet hashSet;
        Iterator it;
        long j16;
        int i16;
        Iterator it5;
        LinkedHashMap linkedHashMap;
        com.tencent.aio.data.msglist.a a16;
        ContactMsgBoxInfo contactMsgBoxInfo = msgBoxInfo;
        int i17 = 1;
        if (contactMsgBoxInfo.listOfSpecificEventTypeInfosInMsgBox.isEmpty()) {
            QLog.d("NavigationVM", 1, "updateNavigation listOfSpecificEventTypeInfosInMsgBox empty. " + contactMsgBoxInfo.listOfSpecificEventTypeInfosInMsgBox);
            return;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (com.tencent.mobileqq.aio.reserve1.navigation.b bVar : this.navigations) {
            linkedHashMap2.put(Long.valueOf(bVar.a()), bVar.b());
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.GetCurTopMsg.f188302d);
        if (k3 instanceof z.d) {
            dVar = (z.d) k3;
        } else {
            dVar = null;
        }
        long j17 = 0;
        if (dVar != null && (a16 = dVar.a()) != null) {
            j3 = a16.getMsgSeq();
        } else {
            j3 = 0;
        }
        k k16 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.GetFirstPageRealMsgSize.f188303d);
        if (k16 instanceof z.i) {
            iVar = (z.i) k16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            i3 = iVar.a();
        } else {
            i3 = 0;
        }
        HashSet hashSet2 = new HashSet();
        ArrayList<SpecificEventTypeInfoInMsgBox> arrayList = contactMsgBoxInfo.listOfSpecificEventTypeInfosInMsgBox;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgBoxInfo.listOfSpecificEventTypeInfosInMsgBox");
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox = (SpecificEventTypeInfoInMsgBox) it6.next();
            QLog.d("NavigationVM", i17, "updateNavigation type = " + specificEventTypeInfoInMsgBox.eventTypeInMsgBox);
            AIONavType e16 = com.tencent.mobileqq.aio.reserve1.navigation.c.e(specificEventTypeInfoInMsgBox.eventTypeInMsgBox);
            if (e16 != AIONavType.UNKNOWN && (msgInfos = specificEventTypeInfoInMsgBox.msgInfos) != null) {
                Intrinsics.checkNotNullExpressionValue(msgInfos, "msgInfos");
                Iterator it7 = msgInfos.iterator();
                while (it7.hasNext()) {
                    MsgBoxNecessaryMsgInfo msgBoxNecessaryMsgInfo = (MsgBoxNecessaryMsgInfo) it7.next();
                    long j18 = j3;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("NavigationVM", 4, "updateNavigation seq = " + msgBoxNecessaryMsgInfo.msgSeq);
                    }
                    long j19 = msgBoxNecessaryMsgInfo.msgSeq;
                    if (j18 > j17 && j19 >= j18) {
                        if (highLightCurrentScreen && e16 != AIONavType.UNREAD) {
                            QLog.i("NavigationVM", 1, "[updateNavigation]: highLight curScreen msg, navType is " + e16);
                            hashSet2.add(Long.valueOf(j19));
                        }
                    } else {
                        if (e16 == AIONavType.UNREAD) {
                            Long l3 = contactMsgBoxInfo.unreadCnt;
                            Intrinsics.checkNotNullExpressionValue(l3, "msgBoxInfo.unreadCnt");
                            if (l3.longValue() >= 15) {
                                long longValue = contactMsgBoxInfo.unreadCnt.longValue() - i3;
                                this.unreadCnt = longValue;
                                this.firstUnreadSeq = j19;
                                this.endUnreadSeq = (longValue + j19) - 1;
                                j16 = j18;
                                this.mTopSeq = j16;
                                i16 = i3;
                                it5 = it7;
                                hashSet = hashSet2;
                                it = it6;
                                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ShowUnreadNavigationEvent(this.unreadCnt, this.firstUnreadSeq, this.endUnreadSeq));
                                QLog.i("NavigationVM", 1, "updateNavigation unreadCnt " + this.unreadCnt + " firstUnreadSeq " + this.firstUnreadSeq + " endUnreadSeq " + this.endUnreadSeq + " topMsgSeq " + j16);
                                linkedHashMap = linkedHashMap2;
                            }
                        } else {
                            hashSet = hashSet2;
                            it = it6;
                            j16 = j18;
                            i16 = i3;
                            it5 = it7;
                            linkedHashMap = linkedHashMap2;
                        }
                        if (w(j19, e16, linkedHashMap)) {
                            linkedHashMap.put(Long.valueOf(j19), e16);
                        }
                        linkedHashMap2 = linkedHashMap;
                        j3 = j16;
                        i3 = i16;
                        it7 = it5;
                        hashSet2 = hashSet;
                        it6 = it;
                        j17 = 0;
                        contactMsgBoxInfo = msgBoxInfo;
                    }
                    linkedHashMap = linkedHashMap2;
                    hashSet = hashSet2;
                    it = it6;
                    j16 = j18;
                    i16 = i3;
                    it5 = it7;
                    linkedHashMap2 = linkedHashMap;
                    j3 = j16;
                    i3 = i16;
                    it7 = it5;
                    hashSet2 = hashSet;
                    it6 = it;
                    j17 = 0;
                    contactMsgBoxInfo = msgBoxInfo;
                }
            }
            linkedHashMap2 = linkedHashMap2;
            j3 = j3;
            i3 = i3;
            hashSet2 = hashSet2;
            it6 = it6;
            i17 = 1;
            j17 = 0;
            contactMsgBoxInfo = msgBoxInfo;
        }
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        HashSet hashSet3 = hashSet2;
        if (!hashSet3.isEmpty()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.HighLightMsgView(hashSet3));
        }
        this.navigations.clear();
        List<com.tencent.mobileqq.aio.reserve1.navigation.b> list = this.navigations;
        ArrayList arrayList2 = new ArrayList(linkedHashMap3.size());
        for (Map.Entry<Long, AIONavType> entry : linkedHashMap3.entrySet()) {
            arrayList2.add(new com.tencent.mobileqq.aio.reserve1.navigation.b(entry.getKey().longValue(), entry.getValue(), true));
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new c());
        list.addAll(sortedWith);
        D(this, false, 1, null);
    }

    private final void C(boolean forceUpdate) {
        Object last;
        com.tencent.mobileqq.aio.reserve1.navigation.b bVar;
        com.tencent.mobileqq.aio.reserve1.navigation.b bVar2 = null;
        if (!this.navigations.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.navigations);
            bVar = (com.tencent.mobileqq.aio.reserve1.navigation.b) last;
        } else {
            bVar = null;
        }
        if (!forceUpdate && bVar != null && Intrinsics.areEqual(this.lastShowNavInfo, bVar)) {
            return;
        }
        if (bVar != null && bVar.b() == AIONavType.UNREAD && this.unreadCnt <= 0) {
            CollectionsKt__MutableCollectionsKt.removeLast(this.navigations);
        } else {
            bVar2 = bVar;
        }
        updateUI(new NavUIState.NavigationState(bVar2, this.unreadCnt));
        this.lastShowNavInfo = bVar2;
    }

    static /* synthetic */ void D(NavigationVM navigationVM, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        navigationVM.C(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(final MsgIntent intent) {
        if (intent instanceof NavigationMsgIntent.UpdateNavigationList) {
            com.tencent.qqnt.aio.util.d.e(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.reserve1.navigation.NavigationVM$handleAction$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ NavigationVM this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgIntent.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList<ContactMsgBoxInfo> b16 = ((NavigationMsgIntent.UpdateNavigationList) MsgIntent.this).b();
                    NavigationVM navigationVM = this.this$0;
                    MsgIntent msgIntent = MsgIntent.this;
                    Iterator<T> it = b16.iterator();
                    while (it.hasNext()) {
                        navigationVM.B((ContactMsgBoxInfo) it.next(), ((NavigationMsgIntent.UpdateNavigationList) msgIntent).a());
                    }
                }
            }, 500L);
            return;
        }
        if (intent instanceof MsgNavigationEvent.NavigationResultNotify) {
            t((MsgNavigationEvent.NavigationResultNotify) intent);
            return;
        }
        if (intent instanceof AIOMsgListEvent.MsgListScrollEvent) {
            r((AIOMsgListEvent.MsgListScrollEvent) intent);
            return;
        }
        if (intent instanceof NavigationMsgIntent.UpdateNavigationTranslationY) {
            updateUI(new NavUIState.UpdateTranslationY(((NavigationMsgIntent.UpdateNavigationTranslationY) intent).a()));
            return;
        }
        if (intent instanceof NavigationMsgIntent.UpdateNavigation) {
            NavigationMsgIntent.UpdateNavigation updateNavigation = (NavigationMsgIntent.UpdateNavigation) intent;
            B(updateNavigation.b(), updateNavigation.a());
        } else if (intent instanceof NavigationMsgIntent.RemoveRevokeNav) {
            x(((NavigationMsgIntent.RemoveRevokeNav) intent).a());
        }
    }

    private final void r(AIOMsgListEvent.MsgListScrollEvent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        AIOMsgItem b16 = intent.b();
        if (b16 != null) {
            long msgSeq = b16.getMsgSeq();
            if (msgSeq <= 0) {
                return;
            }
            Iterator<com.tencent.mobileqq.aio.reserve1.navigation.b> it = this.navigations.iterator();
            long j3 = this.unreadCnt;
            if (this.navigations.size() == 1 && this.navigations.get(0).b() == AIONavType.UNREAD) {
                z17 = true;
                z16 = false;
            } else {
                z16 = false;
                z17 = false;
            }
            while (it.hasNext()) {
                com.tencent.mobileqq.aio.reserve1.navigation.b next = it.next();
                if (next.a() >= msgSeq) {
                    it.remove();
                    long a16 = next.a() - this.firstUnreadSeq;
                    if (a16 < this.unreadCnt) {
                        this.unreadCnt = a16;
                        this.endUnreadSeq = next.a() - 1;
                    }
                    z16 = true;
                } else if (z17 && msgSeq < this.mTopSeq && !com.tencent.mobileqq.aio.utils.d.C(b16)) {
                    long a17 = msgSeq - next.a();
                    long j16 = this.unreadCnt - 1;
                    this.unreadCnt = j16;
                    if (a17 < j16) {
                        this.unreadCnt = a17;
                        this.endUnreadSeq = msgSeq - 1;
                    }
                    this.mTopSeq = msgSeq;
                }
            }
            if (this.unreadCnt == j3) {
                z18 = false;
            } else {
                z18 = z17;
            }
            if (!z16 && !z18) {
                return;
            }
            C(z18);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        Object last;
        if (this.navigations.isEmpty()) {
            QLog.d("NavigationVM", 1, "handleNavClick isEmpty");
            D(this, false, 1, null);
            return;
        }
        if (this.isLoading) {
            QLog.d("NavigationVM", 1, "handleNavClick in loading");
            return;
        }
        QLog.d("NavigationVM", 1, "handleNavClick");
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.navigations);
        com.tencent.mobileqq.aio.reserve1.navigation.b bVar = (com.tencent.mobileqq.aio.reserve1.navigation.b) last;
        if (!AppNetConnInfo.isNetSupport() && bVar.b() != AIONavType.UNREAD) {
            if (bVar.c()) {
                y(false);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.loadingTimeoutRunnable, 1000L);
                return;
            }
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateBySeqEvent("navigation_bar", bVar.a(), 0L, com.tencent.mobileqq.aio.reserve1.navigation.c.d(bVar.b()), bVar.b(), false, false, null, 228, null));
        if (bVar.c()) {
            z(this, false, 1, null);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.loadingTimeoutRunnable, 10000L);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MsgNavigationEvent.ClickNavigationEvent.f188632d);
    }

    private final void t(MsgNavigationEvent.NavigationResultNotify intent) {
        Object last;
        Object removeLast;
        Object last2;
        if (!Intrinsics.areEqual(intent.b().h(), "navigation_bar")) {
            QLog.i("NavigationVM", 1, "handleNavigationResult source " + intent.b().h());
            return;
        }
        List<com.tencent.mobileqq.aio.reserve1.navigation.b> list = this.navigations;
        if (!list.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            if (((com.tencent.mobileqq.aio.reserve1.navigation.b) last).a() != intent.b().b()) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                QLog.i("NavigationVM", 1, "handleNavigationResult last().msgSeq " + ((com.tencent.mobileqq.aio.reserve1.navigation.b) last2).a() + " msgSeq " + intent.b().b());
                return;
            }
            QLog.d("NavigationVM", 1, "handleNavigationResult " + intent);
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.loadingTimeoutRunnable);
            u();
            if (intent.c()) {
                removeLast = CollectionsKt__MutableCollectionsKt.removeLast(list);
                com.tencent.mobileqq.aio.reserve1.navigation.b bVar = (com.tencent.mobileqq.aio.reserve1.navigation.b) removeLast;
                if (!list.isEmpty()) {
                    this.unreadCnt = bVar.a() - this.firstUnreadSeq;
                    this.endUnreadSeq = bVar.a() - 1;
                }
                D(this, false, 1, null);
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), R.string.f180913cc, 0).show();
            return;
        }
        QLog.i("NavigationVM", 1, "handleNavigationResult isEmpty");
    }

    private final void u() {
        this.isLoading = false;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showLoadingRunnable);
        updateUI(new NavUIState.UpdateLoading(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(NavigationVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    private final boolean w(long seq, AIONavType navType, Map<Long, AIONavType> seq2Type) {
        if (seq <= 0) {
            return false;
        }
        if (seq2Type.containsKey(Long.valueOf(seq))) {
            AIONavType aIONavType = seq2Type.get(Long.valueOf(seq));
            Intrinsics.checkNotNull(aIONavType);
            if (!com.tencent.mobileqq.aio.reserve1.navigation.c.c(navType, aIONavType)) {
                return false;
            }
        }
        return true;
    }

    private final void x(List<MsgRecord> revokeMsgs) {
        boolean z16;
        Object last;
        boolean z17;
        if (this.navigations.isEmpty()) {
            return;
        }
        List<MsgRecord> list = revokeMsgs;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z18 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            long j3 = this.firstUnreadSeq;
            long j16 = this.endUnreadSeq + 1;
            long j17 = ((MsgRecord) next).msgSeq;
            if (j3 <= j17 && j17 < j16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && !this.revokeList.contains(Long.valueOf(j17))) {
                z18 = true;
            }
            if (z18) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            this.unreadCnt -= size;
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                this.revokeList.add(Long.valueOf(((MsgRecord) it5.next()).msgSeq));
            }
            if (this.navigations.size() == 1) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.navigations);
                if (((com.tencent.mobileqq.aio.reserve1.navigation.b) last).b() == AIONavType.UNREAD) {
                    C(true);
                    return;
                }
            }
        }
        Iterator<com.tencent.mobileqq.aio.reserve1.navigation.b> it6 = this.navigations.iterator();
        boolean z19 = false;
        while (true) {
            Object obj = null;
            if (!it6.hasNext()) {
                break;
            }
            com.tencent.mobileqq.aio.reserve1.navigation.b next2 = it6.next();
            long a16 = next2.a();
            Iterator<T> it7 = list.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                Object next3 = it7.next();
                if (((MsgRecord) next3).getMsgSeq() == a16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next3;
                    break;
                }
            }
            if (((MsgRecord) obj) != null && next2.b() != AIONavType.UNREAD) {
                it6.remove();
                z19 = true;
            }
        }
        if (z19) {
            D(this, false, 1, null);
        }
    }

    private final void y(boolean delay) {
        this.isLoading = true;
        if (delay) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.showLoadingRunnable, 400L);
        } else {
            updateUI(new NavUIState.UpdateLoading(true));
        }
    }

    static /* synthetic */ void z(NavigationVM navigationVM, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        navigationVM.y(z16);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent.UpdateNavigationList");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigationResultNotify");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MsgListScrollEvent");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent.UpdateNavigationTranslationY");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent.UpdateNavigation");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent.RemoveRevokeNav");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.b
    public void l(@NotNull MsgIntent initMsgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) initMsgIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        QLog.i("NavigationVM", 1, "handleInitMsgIntent");
        E(initMsgIntent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        this.navigations.clear();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.loadingTimeoutRunnable);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showLoadingRunnable);
        this.isLoading = false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.a) {
            s();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        if (context.g().r().c().e() != 2) {
            return;
        }
        QLog.i("NavigationVM", 1, "onCreate");
        context.e().f(this, this.mAction);
    }
}

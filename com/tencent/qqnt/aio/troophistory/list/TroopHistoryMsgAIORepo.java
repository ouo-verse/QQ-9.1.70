package com.tencent.qqnt.aio.troophistory.list;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.msgprocessor.e;
import com.tencent.mobileqq.aio.msglist.msgrepo.NickNameAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.RichMediaAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import tl.h;
import ws.a;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 52\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0017J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0016H\u0017R2\u0010$\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001dj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e`\u001f8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgAIORepo;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "opType", "", "x0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/aio/data/msglist/a;", "list", "b", "displayList", "k", "", "source", "i", "a", "e", "", "beginMsgSeq", "endMsgSeq", "f", "o", "msgSeq", h.F, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lkotlin/collections/ArrayList;", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/ArrayList;", "k0", "()Ljava/util/ArrayList;", "msgRepoAbilityList", "Lcom/tencent/qqnt/aio/troophistory/list/d;", "t", "Lkotlin/Lazy;", "z0", "()Lcom/tencent/qqnt/aio/troophistory/list/d;", "msgLoader", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "u", "Ljava/util/List;", "msgProcessors", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "v", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopHistoryMsgAIORepo extends BaseMsgRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<g<?>> msgRepoAbilityList;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgLoader;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends AbsAIOMsgProcessor> msgProcessors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgAIORepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.troophistory.list.TroopHistoryMsgAIORepo$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f352201a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60711);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IMsgListRepository.MsgListRepoOpType.values().length];
            try {
                iArr[IMsgListRepository.MsgListRepoOpType.LoadFirst.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IMsgListRepository.MsgListRepoOpType.LoadPrePage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IMsgListRepository.MsgListRepoOpType.LoadNextPage.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f352201a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
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
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHistoryMsgAIORepo(@NotNull final com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        super(context, scope);
        ArrayList<g<?>> arrayListOf;
        Lazy lazy;
        List<? extends AbsAIOMsgProcessor> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new NickNameAbility(this, context, scope), new RichMediaAbility(this, context, scope));
            this.msgRepoAbilityList = arrayListOf;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.qqnt.aio.troophistory.list.TroopHistoryMsgAIORepo$msgLoader$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.aio.api.runtime.a.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final d invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (d) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String j3 = com.tencent.aio.api.runtime.a.this.g().r().c().j();
                    List stringArrayList = com.tencent.aio.api.runtime.a.this.g().l().getStringArrayList("key_troop_history_uid_list");
                    if (stringArrayList == null) {
                        stringArrayList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    return new d(j3, stringArrayList);
                }
            });
            this.msgLoader = lazy;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new e(context, scope));
            this.msgProcessors = listOf;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(final List<MsgRecord> msgList, final IMsgListRepository.MsgListRepoOpType opType) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.qqnt.aio.troophistory.list.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopHistoryMsgAIORepo.y0(msgList, this, opType);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(List msgList, TroopHistoryMsgAIORepo this$0, IMsgListRepository.MsgListRepoOpType opType) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(opType, "$opType");
        List list = msgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MsgListUtil.s(MsgListUtil.f24918a, (MsgRecord) it.next(), false, null, null, 14, null));
        }
        MsgList M = this$0.M();
        int i3 = b.f352201a[opType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    M.addAll(arrayList);
                }
            } else {
                M.addAll(0, arrayList);
            }
        } else {
            M.clear();
            M.addAll(arrayList);
        }
        this$0.l0(arrayList);
        a.C11505a.a(this$0, opType, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d z0() {
        return (d) this.msgLoader.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.Q();
        Iterator<T> it = this.msgProcessors.iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).d();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        List sortedWith;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Collection) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
        return sortedWith;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!z0().f()) {
            QLog.i("TroopHistoryMsgAIORepo.", 1, "loadPrePage, ignore, no more data.");
        } else if (!z0().g()) {
            BuildersKt__Builders_commonKt.launch$default(J(), zs.b.a(Dispatchers.INSTANCE), null, new TroopHistoryMsgAIORepo$loadPrePage$1(this, null), 2, null);
        } else {
            QLog.i("TroopHistoryMsgAIORepo.", 1, "loadPrePage, ignore, is loading.");
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    @Deprecated(message = "\u5e9f\u5f03\uff0c \u65e0\u7528\u63a5\u53e3")
    public void h(long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, msgSeq);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) source);
        } else {
            Intrinsics.checkNotNullParameter(source, "source");
            BuildersKt__Builders_commonKt.launch$default(J(), zs.b.a(Dispatchers.INSTANCE), null, new TroopHistoryMsgAIORepo$loadFirstPage$1(this, null), 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        Iterator<T> it = this.msgProcessors.iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).a(displayList);
        }
        return displayList;
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo
    @NotNull
    protected ArrayList<g<?>> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgRepoAbilityList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    @Deprecated(message = "\u5e9f\u5f03\uff0c \u65e0\u7528\u63a5\u53e3")
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.msgProcessors.iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).e();
        }
    }
}

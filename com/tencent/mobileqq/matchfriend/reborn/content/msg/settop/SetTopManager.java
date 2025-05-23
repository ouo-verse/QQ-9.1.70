package com.tencent.mobileqq.matchfriend.reborn.content.msg.settop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$mHandler$2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$StickyItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\t*\u0001.\u0018\u0000 52\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopManager;", "", "", "v", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "cache", "r", "newTopSets", "", ReportConstant.COSTREPORT_PREFIX, "w", "tinyId", "u", "t", "Lcom/tencent/qqnt/chats/api/c;", "callback", "k", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/chats/api/d;", "l", "Lcom/tencent/qqnt/chats/api/e;", "listener", "y", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopBizType;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopBizType;", "bizType", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/a;", "b", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/a;", "setTopListCache", "c", "Lcom/tencent/qqnt/chats/api/e;", "setTopUpdateListener", "d", "Lkotlin/Lazy;", "p", "()Ljava/lang/String;", "uin", "e", DomainData.DOMAIN_NAME, "cacheSaveKey", "com/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopManager$mHandler$2$a", "f", "o", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopManager$mHandler$2$a;", "mHandler", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopBizType;)V", "g", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SetTopManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SetTopBizType bizType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a<String> setTopListCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.chats.api.e setTopUpdateListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheSaveKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mHandler;

    public SetTopManager(SetTopBizType bizType) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        this.bizType = bizType;
        this.setTopListCache = new a<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$uin$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
                return currentUin == null ? "" : currentUin;
            }
        });
        this.uin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$cacheSaveKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                SetTopBizType setTopBizType;
                String p16;
                setTopBizType = SetTopManager.this.bizType;
                p16 = SetTopManager.this.p();
                return "setTop" + setTopBizType + "_" + p16;
            }
        });
        this.cacheSaveKey = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SetTopManager$mHandler$2.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$mHandler$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopManager$mHandler$2$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes33.dex */
            public static final class a extends Handler {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ SetTopManager f244803a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(SetTopManager setTopManager, Looper looper) {
                    super(looper);
                    this.f244803a = setTopManager;
                }

                @Override // android.os.Handler
                public void handleMessage(Message msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    int i3 = msg2.what;
                    if (i3 == 1000) {
                        this.f244803a.q();
                    } else {
                        if (i3 != 1001) {
                            return;
                        }
                        SetTopManager setTopManager = this.f244803a;
                        Object obj = msg2.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                        setTopManager.r((Set) obj);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(SetTopManager.this, ThreadManagerV2.getQQCommonThreadLooper());
            }
        });
        this.mHandler = lazy3;
        v();
    }

    private final String n() {
        return (String) this.cacheSaveKey.getValue();
    }

    private final SetTopManager$mHandler$2.a o() {
        return (SetTopManager$mHandler$2.a) this.mHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        return (String) this.uin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Set<String> emptySet;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String n3 = n();
        emptySet = SetsKt__SetsKt.emptySet();
        Set<String> topSets = from.decodeStringSet(n3, emptySet);
        a<String> aVar = this.setTopListCache;
        Intrinsics.checkNotNullExpressionValue(topSets, "topSets");
        aVar.b(topSets);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Set<String> cache) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeStringSet(n(), cache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(Set<String> newTopSets) {
        Set minus;
        Set<String> c16 = this.setTopListCache.c();
        if (newTopSets.size() != c16.size()) {
            return true;
        }
        minus = SetsKt___SetsKt.minus((Set) c16, (Iterable) newTopSets);
        return !minus.isEmpty();
    }

    private final void v() {
        o().sendEmptyMessage(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Set<String> newTopSets) {
        Set<String> minus;
        Set<String> minus2;
        Set<String> c16 = this.setTopListCache.c();
        minus = SetsKt___SetsKt.minus((Set) c16, (Iterable) newTopSets);
        minus2 = SetsKt___SetsKt.minus((Set) newTopSets, (Iterable) c16);
        this.setTopListCache.e(newTopSets);
        x();
        com.tencent.qqnt.chats.api.e eVar = this.setTopUpdateListener;
        if (eVar != null) {
            eVar.c(minus2, minus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        o().sendMessage(o().obtainMessage(1001, this.setTopListCache.c()));
    }

    public final void j(final String tinyId, final com.tencent.qqnt.chats.api.c callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        e.f244810a.c(tinyId, this.bizType, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$doCancelTop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.qqnt.chats.api.c cVar = com.tencent.qqnt.chats.api.c.this;
                if (cVar != null) {
                    cVar.onResult(-1, "doCancelTop failed");
                }
            }
        }, new Function3<Integer, String, Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$doCancelTop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool) {
                invoke(num.intValue(), str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2, boolean z16) {
                a aVar;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (i3 == 0 && !z16) {
                    aVar = SetTopManager.this.setTopListCache;
                    aVar.g(tinyId);
                    SetTopManager.this.x();
                }
                com.tencent.qqnt.chats.api.c cVar = callback;
                if (cVar != null) {
                    cVar.onResult(i3, msg2);
                }
            }
        });
    }

    public final void k(final String tinyId, final com.tencent.qqnt.chats.api.c callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        e.f244810a.e(tinyId, this.bizType, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$doSetTop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.qqnt.chats.api.c cVar = com.tencent.qqnt.chats.api.c.this;
                if (cVar != null) {
                    cVar.onResult(-1, "doSetTop failed");
                }
            }
        }, new Function3<Integer, String, Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$doSetTop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool) {
                invoke(num.intValue(), str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2, boolean z16) {
                a aVar;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (i3 == 0 && z16) {
                    aVar = SetTopManager.this.setTopListCache;
                    aVar.a(tinyId);
                    SetTopManager.this.x();
                }
                com.tencent.qqnt.chats.api.c cVar = callback;
                if (cVar != null) {
                    cVar.onResult(i3, msg2);
                }
            }
        });
    }

    public final void l(final String tinyId, final com.tencent.qqnt.chats.api.d callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        e.f244810a.h(new String[]{tinyId}, this.bizType, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$fetchOneSetTopStatus$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }, new Function3<Integer, String, List<? extends Relation$StickyItem>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$fetchOneSetTopStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, List<? extends Relation$StickyItem> list) {
                invoke(num.intValue(), str, (List<Relation$StickyItem>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2, List<Relation$StickyItem> tops) {
                a aVar;
                a aVar2;
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(tops, "tops");
                if (QLog.isColorLevel()) {
                    List<Relation$StickyItem> list = tops;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Relation$StickyItem) it.next()).user_id);
                    }
                    QLog.i("SetTopManager", 2, "fetchOneSetTopStatus result: " + i3 + ", msg: " + msg2 + ", tops: " + arrayList);
                }
                if (i3 == 0) {
                    boolean z16 = !tops.isEmpty();
                    com.tencent.qqnt.chats.api.d.this.onResult(i3, msg2, z16);
                    if (z16) {
                        aVar2 = this.setTopListCache;
                        aVar2.a(tinyId);
                    } else {
                        aVar = this.setTopListCache;
                        aVar.g(tinyId);
                    }
                    this.x();
                }
            }
        });
    }

    public final void m() {
        e.f244810a.h(new String[0], this.bizType, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$fetchSetTopList$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isColorLevel()) {
                    QLog.i("SetTopManager", 2, "fetchSetTopList failed: " + it);
                }
            }
        }, new Function3<Integer, String, List<? extends Relation$StickyItem>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager$fetchSetTopList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, List<? extends Relation$StickyItem> list) {
                invoke(num.intValue(), str, (List<Relation$StickyItem>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2, List<Relation$StickyItem> tops) {
                int collectionSizeOrDefault;
                Set<String> set;
                boolean s16;
                com.tencent.qqnt.chats.api.e eVar;
                int collectionSizeOrDefault2;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Intrinsics.checkNotNullParameter(tops, "tops");
                if (QLog.isColorLevel()) {
                    List<Relation$StickyItem> list = tops;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Relation$StickyItem) it.next()).user_id);
                    }
                    QLog.i("SetTopManager", 2, "fetchSetTopList result: " + i3 + ", msg: " + msg2 + ", tops: " + arrayList);
                }
                if (i3 == 0) {
                    List<Relation$StickyItem> list2 = tops;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        arrayList2.add(((Relation$StickyItem) it5.next()).user_id.get());
                    }
                    set = CollectionsKt___CollectionsKt.toSet(arrayList2);
                    s16 = SetTopManager.this.s(set);
                    if (s16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("SetTopManager", 2, "fetchSetTopList hasChanged true");
                        }
                        SetTopManager.this.w(set);
                    }
                    eVar = SetTopManager.this.setTopUpdateListener;
                    if (eVar != null) {
                        eVar.a(set);
                    }
                }
            }
        });
    }

    public final boolean t() {
        return !this.setTopListCache.f();
    }

    public final boolean u(String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        return this.setTopListCache.d(tinyId);
    }

    public final void y(com.tencent.qqnt.chats.api.e listener) {
        this.setTopUpdateListener = listener;
    }
}

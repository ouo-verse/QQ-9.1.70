package com.tencent.mobileqq.zplan.aio.panel.page;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aio.panel.item.NormalItem;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.utils.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ku4.n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u0003:\u00016BF\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012 \b\u0002\u0010#\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040 \u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001f\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010>J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\n\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR/\u0010#\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040 \u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001f8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u000f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020\u00048\u0016X\u0097D\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b!\u0010*R@\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010:\u001a\u00020\u00148\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/ScenePage;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/g;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "", "position", "", "y", "(Ljava/lang/Integer;)V", "b", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", "selectFunction", "j", "", "toString", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "i", "Ljava/util/List;", "c", "()Ljava/util/List;", "items", "Ljava/lang/String;", "friendUin", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "k", "Lkotlin/jvm/functions/Function1;", "getSelectingSceneId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "tabName", DomainData.DOMAIN_NAME, "I", "l", "()I", "tabIconResInt", "o", "sortKey", "Lkotlin/Pair;", "", "value", "p", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lkotlin/Pair;)V", "realSelected", "a", "()Z", "setRedDotHint", "(Z)V", "redDotHint", tl.h.F, "reportTabName", "<init>", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final /* data */ class ScenePage extends Page implements Page.c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.mobileqq.zplan.aio.panel.item.b> items;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final String friendUin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final Function1<Continuation<? super Integer>, Object> getSelectingSceneId;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ h f331245l;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String tabName;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int tabIconResInt;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int sortKey;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Pair<Integer, Long> realSelected;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0001\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.ScenePage$1", f = "ScenePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.page.ScenePage$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation, Object> {
        int label;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ ScenePage(List list, String str, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? new AnonymousClass1(null) : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void y(Integer position) {
        Integer lastSelected = getLastSelected();
        if (Intrinsics.areEqual(lastSelected, position)) {
            return;
        }
        if (lastSelected != null) {
            int intValue = lastSelected.intValue();
            c().get(intValue).s(false);
            Page.b selectFunction = getSelectFunction();
            if (selectFunction != null) {
                selectFunction.T(intValue);
            }
        }
        if (position != null) {
            int intValue2 = position.intValue();
            c().get(intValue2).s(true);
            Page.b selectFunction2 = getSelectFunction();
            if (selectFunction2 != null) {
                selectFunction2.T(intValue2);
            }
        }
        p(position);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(Continuation<? super Unit> continuation) {
        ScenePage$updateSelect$1 scenePage$updateSelect$1;
        Object coroutine_suspended;
        int i3;
        ScenePage scenePage;
        if (continuation instanceof ScenePage$updateSelect$1) {
            scenePage$updateSelect$1 = (ScenePage$updateSelect$1) continuation;
            int i16 = scenePage$updateSelect$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                scenePage$updateSelect$1.label = i16 - Integer.MIN_VALUE;
                Object obj = scenePage$updateSelect$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = scenePage$updateSelect$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super Integer>, Object> function1 = this.getSelectingSceneId;
                    scenePage$updateSelect$1.L$0 = this;
                    scenePage$updateSelect$1.label = 1;
                    obj = function1.invoke(scenePage$updateSelect$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    scenePage = this;
                } else if (i3 == 1) {
                    scenePage = (ScenePage) scenePage$updateSelect$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                final Integer num = (Integer) obj;
                scenePage.y(num == null ? z.a(scenePage.c(), new Function1<com.tencent.mobileqq.zplan.aio.panel.item.b, Boolean>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePage$updateSelect$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(com.tencent.mobileqq.zplan.aio.panel.item.b it) {
                        n w3;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Integer num2 = null;
                        NormalItem normalItem = it instanceof NormalItem ? (NormalItem) it : null;
                        if (normalItem != null && (w3 = normalItem.w()) != null) {
                            num2 = Integer.valueOf(w3.f413120a);
                        }
                        return Boolean.valueOf(Intrinsics.areEqual(num2, num));
                    }
                }) : null);
                return Unit.INSTANCE;
            }
        }
        scenePage$updateSelect$1 = new ScenePage$updateSelect$1(this, continuation);
        Object obj2 = scenePage$updateSelect$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = scenePage$updateSelect$1.label;
        if (i3 != 0) {
        }
        final Integer num2 = (Integer) obj2;
        scenePage.y(num2 == null ? z.a(scenePage.c(), new Function1<com.tencent.mobileqq.zplan.aio.panel.item.b, Boolean>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePage$updateSelect$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(com.tencent.mobileqq.zplan.aio.panel.item.b it) {
                n w3;
                Intrinsics.checkNotNullParameter(it, "it");
                Integer num22 = null;
                NormalItem normalItem = it instanceof NormalItem ? (NormalItem) it : null;
                if (normalItem != null && (w3 = normalItem.w()) != null) {
                    num22 = Integer.valueOf(w3.f413120a);
                }
                return Boolean.valueOf(Intrinsics.areEqual(num22, num2));
            }
        }) : null);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.g
    /* renamed from: a */
    public boolean getRedDotHint() {
        return this.f331245l.getRedDotHint();
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page.c
    public void b(int position) {
        com.tencent.mobileqq.zplan.aio.panel.item.b bVar = c().get(position);
        if (bVar.b()) {
            Integer lastSelected = getLastSelected();
            if (lastSelected != null && lastSelected.intValue() == position) {
                return;
            }
            y(Integer.valueOf(position));
            CorountineFunKt.e(bVar.i(), "zplan_ScenePage_\u597d\u53cb\u65f6\u5149_\u5207\u6362\u573a\u666f", null, null, null, new ScenePage$setUserSelect$1(bVar, this, position, null), 14, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public List<com.tencent.mobileqq.zplan.aio.panel.item.b> c() {
        return this.items;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public String h() {
        return "scene";
    }

    public int hashCode() {
        int hashCode = c().hashCode() * 31;
        String str = this.friendUin;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.getSelectingSceneId.hashCode();
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public Page.c j(Page.b selectFunction) {
        Intrinsics.checkNotNullParameter(selectFunction, "selectFunction");
        s(selectFunction);
        return this;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: k, reason: from getter */
    public int getSortKey() {
        return this.sortKey;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: l, reason: from getter */
    public int getTabIconResInt() {
        return this.tabIconResInt;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: m, reason: from getter */
    public String getTabName() {
        return this.tabName;
    }

    public String toString() {
        return "ScenePage(items=" + c() + ", friendUin=" + this.friendUin + ", getSelectingSceneId=" + this.getSelectingSceneId + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScenePage(List<? extends com.tencent.mobileqq.zplan.aio.panel.item.b> items, String str, Function1<? super Continuation<? super Integer>, ? extends Object> getSelectingSceneId) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(getSelectingSceneId, "getSelectingSceneId");
        this.items = items;
        this.friendUin = str;
        this.getSelectingSceneId = getSelectingSceneId;
        this.f331245l = new h("SCENE_PAGE");
        this.tabName = "\u573a\u666f";
        this.tabIconResInt = R.drawable.i4q;
        this.sortKey = 3;
        Integer a16 = z.a(c(), new Function1<com.tencent.mobileqq.zplan.aio.panel.item.b, Boolean>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ScenePage$nowSelected$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(com.tencent.mobileqq.zplan.aio.panel.item.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NormalItem normalItem = it instanceof NormalItem ? (NormalItem) it : null;
                boolean z16 = false;
                if (normalItem != null && normalItem.j()) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }
        });
        p(a16);
        z(a16 != null ? TuplesKt.to(Integer.valueOf(a16.intValue()), Long.valueOf(System.currentTimeMillis())) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(Pair<Integer, Long> pair) {
        if (pair == null) {
            return;
        }
        Pair<Integer, Long> pair2 = this.realSelected;
        if (pair2 == null || pair.getSecond().longValue() > pair2.getSecond().longValue()) {
            this.realSelected = pair;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScenePage)) {
            return false;
        }
        ScenePage scenePage = (ScenePage) other;
        return Intrinsics.areEqual(c(), scenePage.c()) && Intrinsics.areEqual(this.friendUin, scenePage.friendUin) && Intrinsics.areEqual(this.getSelectingSceneId, scenePage.getSelectingSceneId);
    }
}

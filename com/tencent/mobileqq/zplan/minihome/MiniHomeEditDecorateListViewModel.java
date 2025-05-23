package com.tencent.mobileqq.zplan.minihome;

import androidx.lifecycle.ViewModel;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004H\u0002J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0013\u0010\u000e\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R,\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R/\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dRI\u0010)\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00105\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MiniHomeEditDecorateListViewModel;", "Landroidx/lifecycle/ViewModel;", "", "N1", "Lkotlin/Pair;", "", "", "Ln55/a;", "pageIndexFurniturePair", "", "O1", "", "expression", "R1", "P1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "L1", "Q1", "i", "Ljava/lang/String;", "TAG", "Lkotlinx/coroutines/flow/MutableStateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_source", "Lkotlinx/coroutines/flow/StateFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "M1", "()Lkotlinx/coroutines/flow/StateFlow;", "source", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", TtmlNode.ATTR_TTS_ORIGIN, "D", "Lkotlin/jvm/functions/Function1;", "getFilter", "()Lkotlin/jvm/functions/Function1;", "S1", "(Lkotlin/jvm/functions/Function1;)V", "filter", "Ljava/util/concurrent/atomic/AtomicInteger;", "E", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextPageIndex", "Ljava/util/concurrent/atomic/AtomicBoolean;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLastPage", "G", "isRequesting", "H", "filterExpression", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeEditDecorateListViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final StateFlow<Pair<Integer, List<n55.a>>> source;

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<? super List<n55.a>, ? extends List<n55.a>> filter;

    /* renamed from: E, reason: from kotlin metadata */
    private final AtomicInteger nextPageIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private final AtomicBoolean isLastPage;

    /* renamed from: G, reason: from kotlin metadata */
    private final AtomicBoolean isRequesting;

    /* renamed from: H, reason: from kotlin metadata */
    private String filterExpression;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "EditMiniHomeFragment_DecorateListViewModel";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<Pair<Integer, List<n55.a>>> _source;

    public MiniHomeEditDecorateListViewModel() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableStateFlow<Pair<Integer, List<n55.a>>> MutableStateFlow = StateFlowKt.MutableStateFlow(new Pair(0, emptyList));
        this._source = MutableStateFlow;
        this.source = MutableStateFlow;
        this.filter = new Function1<List<? extends n55.a>, List<? extends n55.a>>() { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeEditDecorateListViewModel$filter$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<n55.a> invoke2(List<n55.a> origin) {
                Intrinsics.checkNotNullParameter(origin, "origin");
                return origin;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends n55.a> invoke(List<? extends n55.a> list) {
                return invoke2((List<n55.a>) list);
            }
        };
        this.nextPageIndex = new AtomicInteger(0);
        this.isLastPage = new AtomicBoolean(false);
        this.isRequesting = new AtomicBoolean(false);
    }

    private final boolean N1() {
        return this.nextPageIndex.get() >= 0 && !this.isLastPage.get();
    }

    private final void O1(Pair<Integer, ? extends List<n55.a>> pageIndexFurniturePair) {
        int intValue = pageIndexFurniturePair.getFirst().intValue();
        List<n55.a> invoke = this.filter.invoke(pageIndexFurniturePair.getSecond());
        QLog.i(this.TAG, 1, "onDataLoaded pageIndex:" + intValue + ", dataSize:" + invoke.size());
        this._source.setValue(new Pair<>(Integer.valueOf(intValue), invoke));
    }

    public final void L1() {
        this.filter.invoke(this._source.getValue().getSecond());
    }

    public final StateFlow<Pair<Integer, List<n55.a>>> M1() {
        return this.source;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object P1(Continuation<? super Unit> continuation) {
        MiniHomeEditDecorateListViewModel$requestNextPage$1 miniHomeEditDecorateListViewModel$requestNextPage$1;
        Object coroutine_suspended;
        int i3;
        String str;
        int i16;
        MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel;
        List mutableList;
        if (continuation instanceof MiniHomeEditDecorateListViewModel$requestNextPage$1) {
            miniHomeEditDecorateListViewModel$requestNextPage$1 = (MiniHomeEditDecorateListViewModel$requestNextPage$1) continuation;
            int i17 = miniHomeEditDecorateListViewModel$requestNextPage$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                miniHomeEditDecorateListViewModel$requestNextPage$1.label = i17 - Integer.MIN_VALUE;
                Object obj = miniHomeEditDecorateListViewModel$requestNextPage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeEditDecorateListViewModel$requestNextPage$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    str = this.filterExpression;
                    boolean N1 = N1();
                    boolean z16 = this.isRequesting.get();
                    if (!(str == null || str.length() == 0) && N1 && !z16) {
                        this.isRequesting.set(true);
                        int i18 = this.nextPageIndex.get();
                        QLog.i(this.TAG, 1, "requestNextPage start, request expression:" + str + ", filterExpression: " + this.filterExpression + ", pageIndex:" + i18);
                        miniHomeEditDecorateListViewModel$requestNextPage$1.L$0 = this;
                        miniHomeEditDecorateListViewModel$requestNextPage$1.L$1 = str;
                        miniHomeEditDecorateListViewModel$requestNextPage$1.I$0 = i18;
                        miniHomeEditDecorateListViewModel$requestNextPage$1.label = 1;
                        Object c16 = MiniHomeNetworkKt.c(str, i18, miniHomeEditDecorateListViewModel$requestNextPage$1);
                        if (c16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i16 = i18;
                        obj = c16;
                        miniHomeEditDecorateListViewModel = this;
                    } else {
                        QLog.i(this.TAG, 1, "requestNextPage return!!, expression:" + str + ", hasNextPage:" + N1 + ", isRequesting:" + z16);
                        return Unit.INSTANCE;
                    }
                } else if (i3 == 1) {
                    i16 = miniHomeEditDecorateListViewModel$requestNextPage$1.I$0;
                    str = (String) miniHomeEditDecorateListViewModel$requestNextPage$1.L$1;
                    miniHomeEditDecorateListViewModel = (MiniHomeEditDecorateListViewModel) miniHomeEditDecorateListViewModel$requestNextPage$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m55.b bVar = (m55.b) obj;
                miniHomeEditDecorateListViewModel.isRequesting.set(false);
                int i19 = bVar.f416283b;
                boolean z17 = bVar.f416284c;
                QLog.i(miniHomeEditDecorateListViewModel.TAG, 1, "requestNextPage finish, expression:" + str + ", pageIndex:" + i16 + ", nextPageIndex:" + i19 + ", isLastPage:" + z17);
                String str2 = miniHomeEditDecorateListViewModel.TAG;
                String str3 = miniHomeEditDecorateListViewModel.filterExpression;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("requestNextPage finish expression:");
                sb5.append(str);
                sb5.append(", filterExpression: ");
                sb5.append(str3);
                QLog.i(str2, 1, sb5.toString());
                if (Intrinsics.areEqual(str, miniHomeEditDecorateListViewModel.filterExpression)) {
                    QLog.i(miniHomeEditDecorateListViewModel.TAG, 1, "requestNextPage finish but expression:" + str + " changed to " + miniHomeEditDecorateListViewModel.filterExpression);
                    return Unit.INSTANCE;
                }
                n55.a[] aVarArr = bVar.f416282a;
                Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.furnitures");
                mutableList = ArraysKt___ArraysKt.toMutableList(aVarArr);
                miniHomeEditDecorateListViewModel.nextPageIndex.set(i19);
                miniHomeEditDecorateListViewModel.isLastPage.set(z17);
                List plus = i16 == 0 ? mutableList : CollectionsKt___CollectionsKt.plus((Collection) miniHomeEditDecorateListViewModel._source.getValue().getSecond(), (Iterable) mutableList);
                QLog.i(miniHomeEditDecorateListViewModel.TAG, 1, "nextIndex: " + i16 + ", rspFurniture size: " + mutableList.size() + ", _source.value.second size: " + miniHomeEditDecorateListViewModel._source.getValue().getSecond().size() + ", showFurnitures size: " + plus.size());
                miniHomeEditDecorateListViewModel.O1(new Pair<>(Boxing.boxInt(i16), plus));
                return Unit.INSTANCE;
            }
        }
        miniHomeEditDecorateListViewModel$requestNextPage$1 = new MiniHomeEditDecorateListViewModel$requestNextPage$1(this, continuation);
        Object obj2 = miniHomeEditDecorateListViewModel$requestNextPage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeEditDecorateListViewModel$requestNextPage$1.label;
        if (i3 != 0) {
        }
        m55.b bVar2 = (m55.b) obj2;
        miniHomeEditDecorateListViewModel.isRequesting.set(false);
        int i192 = bVar2.f416283b;
        boolean z172 = bVar2.f416284c;
        QLog.i(miniHomeEditDecorateListViewModel.TAG, 1, "requestNextPage finish, expression:" + str + ", pageIndex:" + i16 + ", nextPageIndex:" + i192 + ", isLastPage:" + z172);
        String str22 = miniHomeEditDecorateListViewModel.TAG;
        String str32 = miniHomeEditDecorateListViewModel.filterExpression;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("requestNextPage finish expression:");
        sb52.append(str);
        sb52.append(", filterExpression: ");
        sb52.append(str32);
        QLog.i(str22, 1, sb52.toString());
        if (Intrinsics.areEqual(str, miniHomeEditDecorateListViewModel.filterExpression)) {
        }
    }

    public final void Q1() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        O1(new Pair<>(-1, emptyList));
    }

    public final void R1(String expression) {
        Intrinsics.checkNotNullParameter(expression, "expression");
        this.filterExpression = expression;
        QLog.i(this.TAG, 1, "resetFilterExpression, input expression: " + expression + ", origin filterExpression: " + expression);
        this.isRequesting.set(false);
        this.nextPageIndex.set(0);
        this.isLastPage.set(false);
    }

    public final void S1(Function1<? super List<n55.a>, ? extends List<n55.a>> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.filter = function1;
    }
}

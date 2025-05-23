package com.tencent.mobileqq.zplan.aio.panel.page;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.aio.panel.item.ButtonItem;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001+B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00048\u0016X\u0097D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u0019\u0010\u001cR\u001c\u0010#\u001a\u00020\u00108\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/ActionPage;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/g;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "", "position", "", "b", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", "selectFunction", "j", "", "toString", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "i", "Ljava/util/List;", "c", "()Ljava/util/List;", "items", "k", "I", "l", "()I", "tabIconResInt", "sortKey", "a", "()Z", "setRedDotHint", "(Z)V", "redDotHint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "tabName", tl.h.F, "reportTabName", "<init>", "(Ljava/util/List;)V", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final /* data */ class ActionPage extends Page implements Page.c {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.mobileqq.zplan.aio.panel.item.b> items;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ h f331216j;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int tabIconResInt;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int sortKey;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u000b\u001a#\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/ActionPage$Companion;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "scope", "Lkotlinx/coroutines/Deferred;", "", "performClickAsync", "Lcom/tencent/mobileqq/zplan/aio/panel/item/ButtonItem;", "a", "", "TAB_NAME", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final ButtonItem a(Context context, final Function1<? super CoroutineScope, ? extends Deferred<Boolean>> performClickAsync) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(performClickAsync, "performClickAsync");
            String str = "\u6362\u88c5";
            Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.i3j);
            if (drawable == null) {
                drawable = new ColorDrawable();
            }
            return new ButtonItem(str, context, drawable, new Function1<CoroutineScope, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPage$Companion$generateDressupButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Deferred<Boolean> invoke(CoroutineScope it) {
                    Map mapOf;
                    Intrinsics.checkNotNullParameter(it, "it");
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "click"));
                    VideoReport.reportEvent("ev_zplan_new_entrance_action", mapOf);
                    return performClickAsync.invoke(it);
                }
            }, false, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.ActionPage$Companion$generateDressupButton$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Map mapOf;
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "imp"));
                    VideoReport.reportEvent("ev_zplan_new_entrance_action", mapOf);
                }
            }, false, false, 0, 0, 1920, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionPage(List<? extends com.tencent.mobileqq.zplan.aio.panel.item.b> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.f331216j = new h("ACTION_PAGE");
        this.tabIconResInt = R.drawable.i4o;
        this.sortKey = 2;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.g
    /* renamed from: a */
    public boolean getRedDotHint() {
        return this.f331216j.getRedDotHint();
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page.c
    public void b(int position) {
        com.tencent.mobileqq.zplan.aio.panel.item.b bVar = c().get(position);
        Integer lastSelected = getLastSelected();
        boolean z16 = false;
        if ((lastSelected == null || position != lastSelected.intValue()) && getLastSelected() != null) {
            List<com.tencent.mobileqq.zplan.aio.panel.item.b> c16 = c();
            Integer lastSelected2 = getLastSelected();
            Intrinsics.checkNotNull(lastSelected2);
            c16.get(lastSelected2.intValue()).s(false);
            Page.b selectFunction = getSelectFunction();
            if (selectFunction != null) {
                Integer lastSelected3 = getLastSelected();
                Intrinsics.checkNotNull(lastSelected3);
                selectFunction.T(lastSelected3.intValue());
            }
        }
        p(Integer.valueOf(position));
        if (bVar.getIsNeedPay() && !bVar.getHas()) {
            z16 = true;
        }
        bVar.s(z16);
        Page.b selectFunction2 = getSelectFunction();
        if (selectFunction2 != null) {
            selectFunction2.T(position);
        }
        CorountineFunKt.e(c().get(position).getScope(), "zplan_ActionPage_\u597d\u53cb\u65f6\u5149_\u53d1\u9001\u52a8\u4f5c", null, null, null, new ActionPage$setUserSelect$1(this, position, null), 14, null);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public List<com.tencent.mobileqq.zplan.aio.panel.item.b> c() {
        return this.items;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public String h() {
        return "action";
    }

    public int hashCode() {
        return c().hashCode();
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
    /* renamed from: m */
    public String getTabName() {
        return "\u52a8\u4f5c";
    }

    public String toString() {
        return "ActionPage(items=" + c() + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ActionPage) && Intrinsics.areEqual(c(), ((ActionPage) other).c());
    }
}

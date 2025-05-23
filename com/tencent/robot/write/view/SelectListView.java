package com.tencent.robot.write.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.l;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 F2\u00020\u0001:\u0003GH\u001eB1\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0006\u0012\b\b\u0002\u0010C\u001a\u00020\u0006\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\u00022\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u0006R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006I"}, d2 = {"Lcom/tencent/robot/write/view/SelectListView;", "Landroid/widget/LinearLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "location", "", "offsetY", DomainData.DOMAIN_NAME, "j", "o", "Lcom/tencent/robot/write/view/SelectListView$c;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setBubbleLocationStrategy", "l", "", "holder", "setPlaceHolder", "index", "setSelectedIndex", "", "Lcom/tencent/robot/write/view/b;", "list", "k", "Lcom/tencent/robot/write/view/a;", "listener", "setOnSelectedListener", "resId", "setImageResource", "Landroid/widget/TextView;", "d", "Lkotlin/Lazy;", "i", "()Landroid/widget/TextView;", "selectTextView", "Landroid/widget/ImageView;", "e", h.F, "()Landroid/widget/ImageView;", "selectOperationIcon", "f", "Ljava/lang/String;", "placeHolder", "Lcom/tencent/robot/write/view/c;", "Lcom/tencent/robot/write/view/c;", "adapter", "Lcom/tencent/qqnt/aio/widget/a;", "Lcom/tencent/qqnt/aio/widget/a;", "bubbleTip", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/write/view/a;", "onSelectedListener", "", "D", "Z", "isDrawRequire", "E", "Lcom/tencent/robot/write/view/SelectListView$c;", "bubbleLocationStrategy", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", UserInfo.SEX_FEMALE, "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SelectListView extends LinearLayout {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int G = l.b(16);
    private static final int H = l.b(170);
    private static final int I = l.b(40);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.robot.write.view.a onSelectedListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isDrawRequire;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private c bubbleLocationStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectOperationIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String placeHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.write.view.c adapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.aio.widget.a bubbleTip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/write/view/SelectListView$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            Object m476constructorimpl;
            EventCollector.getInstance().onViewClickedBefore(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            SelectListView selectListView = SelectListView.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                int[] iArr = new int[2];
                v3.getLocationOnScreen(iArr);
                View c16 = selectListView.bubbleLocationStrategy.c(selectListView);
                int[] iArr2 = new int[2];
                c16.getLocationOnScreen(iArr2);
                com.tencent.qqnt.aio.widget.a aVar = selectListView.bubbleTip;
                com.tencent.qqnt.aio.widget.a aVar2 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
                    aVar = null;
                }
                aVar.f(c16);
                Pair<Integer, Integer> a16 = selectListView.bubbleLocationStrategy.a(selectListView, iArr);
                int intValue = a16.component1().intValue();
                int intValue2 = a16.component2().intValue();
                com.tencent.qqnt.aio.widget.a aVar3 = selectListView.bubbleTip;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
                    aVar3 = null;
                }
                aVar3.g(intValue, intValue2);
                com.tencent.qqnt.aio.widget.a aVar4 = selectListView.bubbleTip;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
                    aVar4 = null;
                }
                aVar4.h(selectListView.bubbleLocationStrategy.b(selectListView, iArr));
                selectListView.n(iArr2, intValue2);
                com.tencent.qqnt.aio.widget.a aVar5 = selectListView.bubbleTip;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
                } else {
                    aVar2 = aVar5;
                }
                aVar2.j();
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.e("SelectListView", 2, m479exceptionOrNullimpl, new Object[0]);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/write/view/SelectListView$b;", "", "", "BUBBLE_MARGIN", "I", "a", "()I", "BUBBLE_WIDTH", "b", "BUBBLE_MARGIN_TOP", "ITEM_HEIGHT", "MARGIN_BOTTOM", "MARGIN_TOP", "MAX_ITEM_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.view.SelectListView$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return SelectListView.G;
        }

        public final int b() {
            return SelectListView.H;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/write/view/SelectListView$c;", "", "Lcom/tencent/robot/write/view/SelectListView;", "view", "Landroid/view/View;", "c", "", "location", "Lkotlin/Pair;", "", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface c {
        @NotNull
        Pair<Integer, Integer> a(@NotNull SelectListView view, @NotNull int[] location);

        int b(@NotNull SelectListView view, @NotNull int[] location);

        @NotNull
        View c(@NotNull SelectListView view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/write/view/SelectListView$d;", "Lcom/tencent/robot/write/view/SelectListView$c;", "Lcom/tencent/robot/write/view/SelectListView;", "view", "", "location", "", "d", "e", "Landroid/view/View;", "c", "Lkotlin/Pair;", "a", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements c {
        private final int d(SelectListView view, int[] location) {
            int a16;
            int b16;
            int i3 = ScreenUtil.SCREEN_WIDTH;
            int i16 = location[0];
            if (i16 <= 0) {
                return SelectListView.INSTANCE.a();
            }
            Companion companion = SelectListView.INSTANCE;
            if (i16 <= companion.a()) {
                a16 = companion.a();
                b16 = location[0];
            } else {
                if (location[0] < (i3 - companion.a()) - companion.b()) {
                    return 0;
                }
                a16 = (i3 - location[0]) - companion.a();
                b16 = companion.b();
            }
            return a16 - b16;
        }

        private final int e(SelectListView view, int[] location) {
            int coerceAtMost;
            int i3 = ScreenUtil.SCREEN_WIDTH;
            int width = location[0] + (view.getWidth() / 2);
            Companion companion = SelectListView.INSTANCE;
            if (width <= companion.a()) {
                return 0;
            }
            if (width >= i3 - companion.a()) {
                return companion.b();
            }
            if (location[0] < (i3 - companion.a()) - companion.b()) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(width - companion.a(), view.getWidth() / 2);
                return coerceAtMost;
            }
            return companion.b() - ((i3 - companion.a()) - width);
        }

        @Override // com.tencent.robot.write.view.SelectListView.c
        @NotNull
        public Pair<Integer, Integer> a(@NotNull SelectListView view, @NotNull int[] location) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(location, "location");
            return new Pair<>(Integer.valueOf(d(view, location)), Integer.valueOf(l.b(-6)));
        }

        @Override // com.tencent.robot.write.view.SelectListView.c
        public int b(@NotNull SelectListView view, @NotNull int[] location) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(location, "location");
            return e(view, location);
        }

        @Override // com.tencent.robot.write.view.SelectListView.c
        @NotNull
        public View c(@NotNull SelectListView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/write/view/SelectListView$e", "Lcom/tencent/robot/write/view/a;", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements com.tencent.robot.write.view.a {
        e() {
        }

        @Override // com.tencent.robot.write.view.a
        public void a(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            SelectListView.this.o();
            com.tencent.qqnt.aio.widget.a aVar = SelectListView.this.bubbleTip;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
                aVar = null;
            }
            aVar.a();
            com.tencent.robot.write.view.a aVar2 = SelectListView.this.onSelectedListener;
            if (aVar2 != null) {
                aVar2.a(selectedData, position);
            }
        }

        @Override // com.tencent.robot.write.view.a
        public void b(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            SelectListView.this.o();
            com.tencent.qqnt.aio.widget.a aVar = SelectListView.this.bubbleTip;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
                aVar = null;
            }
            aVar.a();
            com.tencent.robot.write.view.a aVar2 = SelectListView.this.onSelectedListener;
            if (aVar2 != null) {
                aVar2.b(selectedData, position);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectListView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView h() {
        Object value = this.selectOperationIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-selectOperationIcon>(...)");
        return (ImageView) value;
    }

    private final TextView i() {
        Object value = this.selectTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-selectTextView>(...)");
        return (TextView) value;
    }

    private final void j() {
        ViewGroup viewGroup;
        com.tencent.robot.write.view.c cVar = new com.tencent.robot.write.view.c(this.isDrawRequire);
        this.adapter = cVar;
        cVar.t0(new e());
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        com.tencent.robot.write.view.c cVar2 = this.adapter;
        com.tencent.qqnt.aio.widget.a aVar = null;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar2 = null;
        }
        recyclerView.setAdapter(cVar2);
        recyclerView.setPadding(0, l.b(12), 0, l.b(8));
        recyclerView.setItemAnimator(null);
        this.recyclerView = recyclerView;
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        com.tencent.qqnt.aio.widget.a aVar2 = new com.tencent.qqnt.aio.widget.a(context, recyclerView2);
        this.bubbleTip = aVar2;
        aVar2.i(getContext().getColor(R.color.qui_common_bg_top_light));
        com.tencent.qqnt.aio.widget.a aVar3 = this.bubbleTip;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
        } else {
            aVar = aVar3;
        }
        aVar.f(this.bubbleLocationStrategy.c(this));
    }

    private final void m() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerView recyclerView = this.recyclerView;
        com.tencent.qqnt.aio.widget.a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        com.tencent.qqnt.aio.widget.a aVar2 = new com.tencent.qqnt.aio.widget.a(context, recyclerView);
        this.bubbleTip = aVar2;
        aVar2.i(getContext().getColor(R.color.qui_common_bg_top_light));
        com.tencent.qqnt.aio.widget.a aVar3 = this.bubbleTip;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleTip");
        } else {
            aVar = aVar3;
        }
        aVar.f(this.bubbleLocationStrategy.c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int[] location, int offsetY) {
        boolean z16;
        int i3;
        int coerceAtMost;
        int coerceAtMost2;
        if (location.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!z16) && location.length >= 2) {
            i3 = ((location[1] + offsetY) - I) - l.b(6);
        } else {
            i3 = Integer.MAX_VALUE;
        }
        com.tencent.robot.write.view.c cVar = this.adapter;
        RecyclerView recyclerView = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(cVar.getNUM_BACKGOURND_ICON(), 7);
        int b16 = l.b((coerceAtMost * 44) + 8 + 12);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i3, b16);
        layoutParams.height = coerceAtMost2;
        recyclerView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        String str;
        com.tencent.robot.write.view.c cVar = this.adapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar = null;
        }
        SelectData<?> n06 = cVar.n0();
        TextView i3 = i();
        if (n06 == null) {
            str = this.placeHolder + " ";
        } else {
            str = this.placeHolder + " " + n06.getName();
        }
        i3.setText(str);
    }

    public final void k(@NotNull List<? extends SelectData<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        com.tencent.robot.write.view.c cVar = this.adapter;
        RecyclerView recyclerView = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar = null;
        }
        cVar.p0(list);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.scrollToPosition(0);
        m();
        o();
    }

    public final void l() {
        if (!(this.bubbleLocationStrategy instanceof d)) {
            this.bubbleLocationStrategy = new d();
        }
    }

    public final void setBubbleLocationStrategy(@NotNull c strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.bubbleLocationStrategy = strategy;
    }

    public final void setImageResource(@DrawableRes int resId) {
        h().setImageResource(resId);
    }

    public final void setOnSelectedListener(@NotNull com.tencent.robot.write.view.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSelectedListener = listener;
    }

    public final void setPlaceHolder(@Nullable String holder) {
        this.placeHolder = holder;
        o();
    }

    public final void setSelectedIndex(int index) {
        com.tencent.robot.write.view.c cVar = this.adapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar = null;
        }
        cVar.q0(index);
        o();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SelectListView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.robot.write.view.SelectListView$selectTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SelectListView.this.findViewById(R.id.f82454gx);
            }
        });
        this.selectTextView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.robot.write.view.SelectListView$selectOperationIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SelectListView.this.findViewById(R.id.f82394gr);
            }
        });
        this.selectOperationIcon = lazy2;
        this.bubbleLocationStrategy = new d();
        LayoutInflater.from(context).inflate(R.layout.f169076hp3, (ViewGroup) this, true);
        setOrientation(0);
        setBackground(context.getDrawable(R.drawable.lif));
        setPadding(l.b(16), l.b(6), l.b(16), l.b(6));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gn2.a.f402579o6);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026styleable.SelectListView)");
        this.placeHolder = obtainStyledAttributes.getString(gn2.a.f402599q6);
        i().setText(this.placeHolder);
        h().setImageDrawable(obtainStyledAttributes.getDrawable(gn2.a.f402589p6));
        this.isDrawRequire = obtainStyledAttributes.getBoolean(gn2.a.f402609r6, false);
        obtainStyledAttributes.recycle();
        j();
        setOnClickListener(new a());
    }
}

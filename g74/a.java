package g74;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.robot.write.view.SelectData;
import com.tencent.robot.write.view.SelectListView;
import e74.RequireData;
import e74.RequireList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000489:;B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n*\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0014\u0010\u0016\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0014\u0010\u0017\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018J\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u001b0\u0013R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001dj\b\u0012\u0004\u0012\u00020\u0014`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001dj\b\u0012\u0004\u0012\u00020\u0005`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R.\u00103\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010%\u00a8\u0006<"}, d2 = {"Lg74/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lg74/a$d;", "", "l0", "", "position", "column", "t0", "Le74/c;", "Lcom/tencent/robot/write/view/b;", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "vh", "n0", "getItemCount", "", "Le74/e;", "list", "m0", "r0", "Lg74/a$a;", "listener", "q0", "Lkotlin/Pair;", "k0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "requireList", BdhLogUtil.LogTag.Tag_Conn, "selectedIndexList", "D", "Lg74/a$a;", "onSelectedListener", "Lcom/tencent/robot/write/view/SelectListView$c;", "E", "Lcom/tencent/robot/write/view/SelectListView$c;", "bubbleLocationStrategy", "Landroid/view/View;", "value", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "p0", "(Landroid/view/View;)V", "anchorView", "G", "innerSelectedListener", "<init>", "()V", "a", "b", "c", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends RecyclerView.Adapter<d> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private InterfaceC10361a onSelectedListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private SelectListView.c bubbleLocationStrategy;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View anchorView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RequireList> requireList = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> selectedIndexList = new ArrayList<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final InterfaceC10361a innerSelectedListener = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J$\u0010\t\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lg74/a$a;", "", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "column", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g74.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC10361a {
        void a(@NotNull SelectData<?> selectedData, int position, int column);

        void b(@NotNull SelectData<?> selectedData, int position, int column);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lg74/a$b;", "Lcom/tencent/robot/write/view/a;", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "", "a", "b", "I", "index", "Lg74/a$a;", "Lg74/a$a;", "listener", "<init>", "(ILg74/a$a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.robot.write.view.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final InterfaceC10361a listener;

        public b(int i3, @Nullable InterfaceC10361a interfaceC10361a) {
            this.index = i3;
            this.listener = interfaceC10361a;
        }

        @Override // com.tencent.robot.write.view.a
        public void a(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            InterfaceC10361a interfaceC10361a = this.listener;
            if (interfaceC10361a != null) {
                interfaceC10361a.b(selectedData, this.index, position);
            }
        }

        @Override // com.tencent.robot.write.view.a
        public void b(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            InterfaceC10361a interfaceC10361a = this.listener;
            if (interfaceC10361a != null) {
                interfaceC10361a.a(selectedData, this.index, position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lg74/a$c;", "Lcom/tencent/robot/write/view/SelectListView$c;", "Lcom/tencent/robot/write/view/SelectListView;", "view", "", "location", "", "e", "d", "Landroid/view/View;", "c", "Lkotlin/Pair;", "a", "b", "Landroid/view/View;", "anchorView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements SelectListView.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View anchorView;

        public c(@NotNull View anchorView) {
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            this.anchorView = anchorView;
        }

        private final int d(int[] location) {
            int[] iArr = new int[2];
            this.anchorView.getLocationOnScreen(iArr);
            return (location[1] - iArr[1]) - l.b(6);
        }

        private final int e(SelectListView view, int[] location) {
            int i3;
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect) || rect.width() >= view.getWidth()) {
                return 0;
            }
            if (location[0] < 0) {
                SelectListView.Companion companion = SelectListView.INSTANCE;
                i3 = companion.a();
                view.requestRectangleOnScreen(new Rect(-companion.a(), 0, view.getWidth(), view.getHeight()));
            } else {
                SelectListView.Companion companion2 = SelectListView.INSTANCE;
                i3 = -companion2.a();
                view.requestRectangleOnScreen(new Rect(0, 0, view.getWidth() + companion2.a(), view.getHeight()));
            }
            return i3;
        }

        @Override // com.tencent.robot.write.view.SelectListView.c
        @NotNull
        public Pair<Integer, Integer> a(@NotNull SelectListView view, @NotNull int[] location) {
            int i3;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(location, "location");
            e(view, location);
            int i16 = ScreenUtil.SCREEN_WIDTH;
            int i17 = location[0];
            SelectListView.Companion companion = SelectListView.INSTANCE;
            if (i17 <= companion.a()) {
                i3 = companion.a();
            } else if (location[0] >= (i16 - companion.a()) - companion.b()) {
                i3 = (i16 - companion.a()) - companion.b();
            } else {
                i3 = location[0];
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(d(location)));
        }

        @Override // com.tencent.robot.write.view.SelectListView.c
        public int b(@NotNull SelectListView view, @NotNull int[] location) {
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(location, "location");
            int i3 = ScreenUtil.SCREEN_WIDTH;
            int width = view.getWidth();
            int i16 = location[0];
            int i17 = width / 2;
            int i18 = i16 + i17;
            if (i16 < 0) {
                return i17;
            }
            if (i16 + width > i3) {
                return SelectListView.INSTANCE.b() - i17;
            }
            SelectListView.Companion companion = SelectListView.INSTANCE;
            if (i18 <= companion.a()) {
                return 0;
            }
            if (i18 >= i3 - companion.a()) {
                return companion.b();
            }
            if (location[0] < (i3 - companion.a()) - companion.b()) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i18 - companion.a(), i17);
                return coerceAtMost;
            }
            return companion.b() - ((i3 - companion.a()) - i18);
        }

        @Override // com.tencent.robot.write.view.SelectListView.c
        @NotNull
        public View c(@NotNull SelectListView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return this.anchorView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lg74/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Le74/e;", "requireList", "", "selectedIndex", "Lcom/tencent/robot/write/view/a;", "onSelectedListener", "Lcom/tencent/robot/write/view/SelectListView$c;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "l", "Lcom/tencent/robot/write/view/SelectListView;", "E", "Lcom/tencent/robot/write/view/SelectListView;", "selectListView", "<init>", "(Lcom/tencent/robot/write/view/SelectListView;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final SelectListView selectListView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull SelectListView selectListView) {
            super(selectListView);
            Intrinsics.checkNotNullParameter(selectListView, "selectListView");
            this.selectListView = selectListView;
        }

        public final void l(@NotNull RequireList requireList, int selectedIndex, @NotNull com.tencent.robot.write.view.a onSelectedListener, @Nullable SelectListView.c strategy) {
            List<? extends SelectData<?>> emptyList;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(requireList, "requireList");
            Intrinsics.checkNotNullParameter(onSelectedListener, "onSelectedListener");
            this.selectListView.setPlaceHolder(requireList.getButtonName());
            this.selectListView.setOnSelectedListener(onSelectedListener);
            SelectListView selectListView = this.selectListView;
            List<RequireData> b16 = requireList.b();
            if (b16 == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                List<RequireData> list = b16;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                emptyList = new ArrayList<>(collectionSizeOrDefault);
                for (RequireData requireData : list) {
                    emptyList.add(new SelectData(requireData.getName(), requireData));
                }
            }
            selectListView.k(emptyList);
            this.selectListView.setSelectedIndex(selectedIndex);
            if (strategy != null) {
                this.selectListView.setBubbleLocationStrategy(strategy);
            } else {
                this.selectListView.l();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J$\u0010\t\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"g74/a$e", "Lg74/a$a;", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "column", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements InterfaceC10361a {
        e() {
        }

        @Override // g74.a.InterfaceC10361a
        public void a(@NotNull SelectData<?> selectedData, int position, int column) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            a.this.t0(position, -1);
            InterfaceC10361a interfaceC10361a = a.this.onSelectedListener;
            if (interfaceC10361a != null) {
                interfaceC10361a.a(selectedData, position, column);
            }
        }

        @Override // g74.a.InterfaceC10361a
        public void b(@NotNull SelectData<?> selectedData, int position, int column) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            a.this.t0(position, column);
            InterfaceC10361a interfaceC10361a = a.this.onSelectedListener;
            if (interfaceC10361a != null) {
                interfaceC10361a.b(selectedData, position, column);
            }
        }
    }

    private final void l0() {
        this.selectedIndexList.clear();
        int size = this.requireList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.selectedIndexList.add(-1);
        }
    }

    private final SelectData<?> s0(RequireData requireData) {
        return new SelectData<>(requireData.getName(), requireData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(int position, int column) {
        boolean z16 = false;
        if (position >= 0 && position < this.selectedIndexList.size()) {
            z16 = true;
        }
        if (z16) {
            this.selectedIndexList.set(position, Integer.valueOf(column));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.requireList.size();
    }

    @NotNull
    public final List<Pair<Integer, SelectData<?>>> k0() {
        RequireData requireData;
        Object orNull;
        ArrayList arrayList = new ArrayList();
        int min = Math.min(this.requireList.size(), this.selectedIndexList.size());
        for (int i3 = 0; i3 < min; i3++) {
            Integer num = this.selectedIndexList.get(i3);
            Intrinsics.checkNotNullExpressionValue(num, "selectedIndexList[i]");
            int intValue = num.intValue();
            if (intValue != -1) {
                List<RequireData> b16 = this.requireList.get(i3).b();
                if (b16 != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(b16, intValue);
                    requireData = (RequireData) orNull;
                } else {
                    requireData = null;
                }
                if (requireData != null) {
                    arrayList.add(new Pair(Integer.valueOf(intValue), s0(requireData)));
                }
            }
        }
        return arrayList;
    }

    public final void m0(@NotNull List<RequireList> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.requireList.clear();
        this.requireList.addAll(list);
        l0();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d vh5, int position) {
        Integer num;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        boolean z16 = false;
        if (position >= 0 && position < this.selectedIndexList.size()) {
            z16 = true;
        }
        if (z16) {
            num = this.selectedIndexList.get(position);
        } else {
            num = -1;
        }
        Intrinsics.checkNotNullExpressionValue(num, "if (position in 0 until \u2026t[position] } else { -1 }");
        int intValue = num.intValue();
        RequireList requireList = this.requireList.get(position);
        Intrinsics.checkNotNullExpressionValue(requireList, "requireList[position]");
        vh5.l(requireList, intValue, new b(position, this.innerSelectedListener), this.bubbleLocationStrategy);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SelectListView selectListView = new SelectListView(context, null, 0, 0, 14, null);
        selectListView.setImageResource(R.drawable.qui_chevron_down_icon_secondary);
        return new d(selectListView);
    }

    public final void p0(@Nullable View view) {
        c cVar;
        if (!Intrinsics.areEqual(this.anchorView, view)) {
            this.anchorView = view;
            if (view != null) {
                cVar = new c(view);
            } else {
                cVar = null;
            }
            this.bubbleLocationStrategy = cVar;
            notifyDataSetChanged();
        }
    }

    public final void q0(@NotNull InterfaceC10361a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSelectedListener = listener;
    }

    public final void r0(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int min = Math.min(list.size(), this.selectedIndexList.size());
        for (int i3 = 0; i3 < min; i3++) {
            this.selectedIndexList.set(i3, list.get(i3));
        }
        notifyDataSetChanged();
    }
}

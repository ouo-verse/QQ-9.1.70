package com.tencent.robot.write.vb.delegate;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.robot.write.vb.d;
import com.tencent.robot.write.vb.delegate.WriteListUIState;
import com.tencent.robot.write.vb.delegate.WriteListVBDelegate$onRequireSelectedListener$2;
import com.tencent.robot.write.vb.delegate.WriteListVBDelegate$onTypSelectedListener$2;
import com.tencent.robot.write.vb.delegate.a;
import com.tencent.robot.write.view.SelectData;
import e74.CallbackData;
import e74.ItemData;
import e74.RequireData;
import e74.RequireFunction;
import e74.RequireList;
import e74.f;
import g74.a;
import g74.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\n*\u0002W]\u0018\u0000 c2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0003#deB\u000f\u0012\u0006\u0010.\u001a\u00020\u0004\u00a2\u0006\u0004\bb\u0010-J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J \u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001cj\b\u0012\u0004\u0012\u00020\u000f`\u001d2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\u0016\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030$0\fH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0003H\u0016R\"\u0010.\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010;R\u0018\u0010=\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00108R\u0018\u0010?\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010;R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MRR\u0010T\u001a>\u0012\u0004\u0012\u00020P\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u001cj\b\u0012\u0004\u0012\u00020\u000f`\u001d0Oj\u001e\u0012\u0004\u0012\u00020P\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u001cj\b\u0012\u0004\u0012\u00020\u000f`\u001d`Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010MR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010`\u00a8\u0006f"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/WriteListVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/write/vb/delegate/a;", "Lcom/tencent/robot/write/vb/delegate/WriteListUIState;", "Lcom/tencent/robot/write/vb/b;", "Lcom/tencent/robot/write/vb/d;", "Lcom/tencent/robot/write/vb/IWriteListVBDelegate;", "Le74/f;", "data", "", DomainData.DOMAIN_NAME, "B", "", "Le74/b;", "list", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "w", "itemData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "selectedIndexList", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "position", "column", "t", "size", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p", "y", "i", "binding", "r", "a", "Ljava/lang/Class;", "getObserverStates", "state", "o", "d", "Lcom/tencent/robot/write/vb/b;", "j", "()Lcom/tencent/robot/write/vb/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/robot/write/vb/b;)V", "mHost", "e", "Lcom/tencent/robot/write/vb/d;", "mBinding", "Landroid/view/View;", "f", "Landroid/view/View;", "mContainer", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "mTypeText", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mTypeList", "mRequireText", BdhLogUtil.LogTag.Tag_Conn, "mRequireList", "Lg74/b;", "D", "Lg74/b;", "mTypeAdapter", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "E", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mLayoutManager", "Lg74/a;", UserInfo.SEX_FEMALE, "Lg74/a;", "mRequireAdapter", "G", "Le74/b;", "mDefaultItemData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "H", "Ljava/util/HashMap;", "mSelectedRequireIndexMap", "I", "mCurrentItemData", "com/tencent/robot/write/vb/delegate/WriteListVBDelegate$onTypSelectedListener$2$a", "J", "Lkotlin/Lazy;", "l", "()Lcom/tencent/robot/write/vb/delegate/WriteListVBDelegate$onTypSelectedListener$2$a;", "onTypSelectedListener", "com/tencent/robot/write/vb/delegate/WriteListVBDelegate$onRequireSelectedListener$2$a", "K", "k", "()Lcom/tencent/robot/write/vb/delegate/WriteListVBDelegate$onRequireSelectedListener$2$a;", "onRequireSelectedListener", "<init>", "L", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class WriteListVBDelegate implements com.tencent.input.base.mvicompat.c<a, WriteListUIState, com.tencent.robot.write.vb.b, d> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mRequireList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private g74.b mTypeAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private StaggeredGridLayoutManager mLayoutManager;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private g74.a mRequireAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ItemData mDefaultItemData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, ArrayList<Integer>> mSelectedRequireIndexMap;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ItemData mCurrentItemData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy onTypSelectedListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy onRequireSelectedListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.write.vb.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTypeText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mTypeList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mRequireText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/WriteListVBDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                i3 = adapter.getNUM_BACKGOURND_ICON();
            } else {
                i3 = 0;
            }
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = l.b(16);
            } else if (childAdapterPosition == i3 - 1) {
                outRect.right = l.b(16);
                outRect.left = l.b(10);
            } else {
                outRect.left = l.b(10);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/write/vb/delegate/WriteListVBDelegate$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            StaggeredGridLayoutManager staggeredGridLayoutManager;
            RecyclerView.Adapter adapter;
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            StaggeredGridLayoutManager.LayoutParams layoutParams = null;
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            } else {
                staggeredGridLayoutManager = null;
            }
            if (staggeredGridLayoutManager == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
            }
            if (layoutParams == null || (adapter = parent.getAdapter()) == null) {
                return;
            }
            int num_backgournd_icon = adapter.getNUM_BACKGOURND_ICON();
            int spanCount = staggeredGridLayoutManager.getSpanCount();
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.left = l.b(10);
            outRect.top = l.b(10);
            if (layoutParams.getSpanIndex() == 0) {
                outRect.top = l.b(8);
            }
            if (childAdapterPosition < spanCount) {
                outRect.left = l.b(16);
            }
            int i16 = num_backgournd_icon % spanCount;
            if (i16 == 0) {
                i3 = num_backgournd_icon - spanCount;
            } else {
                i3 = num_backgournd_icon - i16;
            }
            if (childAdapterPosition >= i3) {
                outRect.right = l.b(16);
            }
        }
    }

    public WriteListVBDelegate(@NotNull com.tencent.robot.write.vb.b mHost) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mSelectedRequireIndexMap = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WriteListVBDelegate$onTypSelectedListener$2.a>() { // from class: com.tencent.robot.write.vb.delegate.WriteListVBDelegate$onTypSelectedListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/write/vb/delegate/WriteListVBDelegate$onTypSelectedListener$2$a", "Lg74/b$a;", "Landroid/view/View;", "view", "", "position", "Le74/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements b.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WriteListVBDelegate f368748a;

                a(WriteListVBDelegate writeListVBDelegate) {
                    this.f368748a = writeListVBDelegate;
                }

                @Override // g74.b.a
                public void a(@NotNull View view, int position, @NotNull ItemData item) {
                    ItemData itemData;
                    ItemData itemData2;
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.f368748a.v(a.C9788a.f368749d);
                    WriteListVBDelegate writeListVBDelegate = this.f368748a;
                    itemData = writeListVBDelegate.mDefaultItemData;
                    writeListVBDelegate.w(itemData);
                    WriteListVBDelegate writeListVBDelegate2 = this.f368748a;
                    itemData2 = writeListVBDelegate2.mDefaultItemData;
                    writeListVBDelegate2.A(itemData2);
                }

                @Override // g74.b.a
                public void b(@NotNull View view, int position, @NotNull ItemData item) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.f368748a.v(a.C9788a.f368749d);
                    this.f368748a.w(item);
                    this.f368748a.A(item);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(WriteListVBDelegate.this);
            }
        });
        this.onTypSelectedListener = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WriteListVBDelegate$onRequireSelectedListener$2.a>() { // from class: com.tencent.robot.write.vb.delegate.WriteListVBDelegate$onRequireSelectedListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J$\u0010\t\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/write/vb/delegate/WriteListVBDelegate$onRequireSelectedListener$2$a", "Lg74/a$a;", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "column", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements a.InterfaceC10361a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WriteListVBDelegate f368747a;

                a(WriteListVBDelegate writeListVBDelegate) {
                    this.f368747a = writeListVBDelegate;
                }

                @Override // g74.a.InterfaceC10361a
                public void a(@NotNull SelectData<?> selectedData, int position, int column) {
                    Intrinsics.checkNotNullParameter(selectedData, "selectedData");
                    this.f368747a.v(new a.OnRequireListItemUnSelected(position));
                    this.f368747a.t(position, -1);
                }

                @Override // g74.a.InterfaceC10361a
                public void b(@NotNull SelectData<?> selectedData, int position, int column) {
                    Intrinsics.checkNotNullParameter(selectedData, "selectedData");
                    if (selectedData.b() instanceof RequireData) {
                        this.f368747a.v(new a.OnRequireListItemSelected((RequireData) selectedData.b(), position));
                    }
                    this.f368747a.t(position, column);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(WriteListVBDelegate.this);
            }
        });
        this.onRequireSelectedListener = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(ItemData itemData) {
        List<RequireList> emptyList;
        boolean z16;
        ArrayList<Integer> arrayList;
        RequireFunction requireFunction;
        String str;
        RequireFunction requireFunction2;
        this.mCurrentItemData = itemData;
        TextView textView = this.mRequireText;
        String str2 = null;
        if (textView != null) {
            if (itemData != null && (requireFunction2 = itemData.getRequireFunction()) != null) {
                str = requireFunction2.getTitle();
            } else {
                str = null;
            }
            textView.setText(str);
        }
        if (itemData == null || (requireFunction = itemData.getRequireFunction()) == null || (emptyList = requireFunction.a()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        g74.a aVar = this.mRequireAdapter;
        if (aVar != null) {
            aVar.m0(emptyList);
        }
        if (itemData != null) {
            str2 = itemData.getName();
        }
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !emptyList.isEmpty()) {
            if (!this.mSelectedRequireIndexMap.containsKey(str2)) {
                arrayList = p(emptyList.size());
                this.mSelectedRequireIndexMap.put(str2, arrayList);
            } else {
                arrayList = this.mSelectedRequireIndexMap.get(str2);
            }
            s(arrayList);
            x();
        }
    }

    private final void B(f data) {
        TextView textView = this.mTypeText;
        if (textView != null) {
            textView.setText(data.getTitle());
        }
        List<ItemData> e16 = data.e();
        if (e16 == null) {
            e16 = CollectionsKt__CollectionsKt.emptyList();
        }
        int m3 = m(e16);
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.mLayoutManager;
        if (staggeredGridLayoutManager != null) {
            staggeredGridLayoutManager.setSpanCount(m3);
        }
        g74.b bVar = this.mTypeAdapter;
        if (bVar != null) {
            bVar.o0(e16);
        }
        RecyclerView recyclerView = this.mTypeList;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final void i() {
        this.mSelectedRequireIndexMap.clear();
    }

    private final WriteListVBDelegate$onRequireSelectedListener$2.a k() {
        return (WriteListVBDelegate$onRequireSelectedListener$2.a) this.onRequireSelectedListener.getValue();
    }

    private final WriteListVBDelegate$onTypSelectedListener$2.a l() {
        return (WriteListVBDelegate$onTypSelectedListener$2.a) this.onTypSelectedListener.getValue();
    }

    private final int m(List<ItemData> list) {
        int coerceAtLeast;
        int coerceAtMost;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((list.size() + 17) - 1) / 17, 1);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 3);
        return coerceAtMost;
    }

    private final void n(f data) {
        if (data != null && this.mContainer != null) {
            y();
            i();
            B(data);
            this.mDefaultItemData = data.getDefaultData();
            ItemData defaultData = data.getDefaultData();
            if (defaultData != null) {
                A(defaultData);
            }
            w(data.getDefaultData());
        }
    }

    private final ArrayList<Integer> p(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(-1);
        }
        return arrayList;
    }

    private final void s(List<Integer> selectedIndexList) {
        g74.a aVar = this.mRequireAdapter;
        if (aVar != null) {
            if (selectedIndexList == null) {
                selectedIndexList = CollectionsKt__CollectionsKt.emptyList();
            }
            aVar.r0(selectedIndexList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int position, int column) {
        boolean z16;
        int i3;
        List<RequireList> a16;
        ItemData itemData = this.mCurrentItemData;
        if (itemData == null) {
            return;
        }
        String name = itemData.getName();
        boolean z17 = true;
        if (name != null && name.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        RequireFunction requireFunction = itemData.getRequireFunction();
        if (requireFunction != null && (a16 = requireFunction.a()) != null) {
            i3 = a16.size();
        } else {
            i3 = 0;
        }
        ArrayList<Integer> arrayList = this.mSelectedRequireIndexMap.get(itemData.getName());
        if (i3 == 0) {
            if (arrayList != null) {
                arrayList.clear();
                return;
            }
            return;
        }
        if (arrayList == null) {
            arrayList = p(i3);
            this.mSelectedRequireIndexMap.put(itemData.getName(), arrayList);
        }
        if (arrayList.size() != i3) {
            arrayList = p(i3);
            this.mSelectedRequireIndexMap.put(itemData.getName(), arrayList);
        }
        if (position < 0 || position >= i3) {
            z17 = false;
        }
        if (z17) {
            arrayList.set(position, Integer.valueOf(column));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(ItemData item) {
        String str;
        String str2;
        List<CallbackData> a16;
        HashMap hashMap = null;
        if (item != null) {
            str = item.getTemplate();
        } else {
            str = null;
        }
        if (item != null) {
            str2 = item.getPlaceholder();
        } else {
            str2 = null;
        }
        if (item != null && (a16 = item.a()) != null) {
            hashMap = new HashMap();
            for (CallbackData callbackData : a16) {
                Pair pair = TuplesKt.to(callbackData.getKey(), callbackData.getValue());
                hashMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        v(new a.OnTypeListItemClick(str, str2, hashMap));
    }

    private final void x() {
        List<Pair<Integer, SelectData<?>>> k06;
        g74.a aVar = this.mRequireAdapter;
        if (aVar != null && (k06 = aVar.k0()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = k06.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object b16 = ((SelectData) pair.getSecond()).b();
                if (b16 instanceof RequireData) {
                    arrayList.add(new Pair(pair.getFirst(), b16));
                }
            }
            if (!arrayList.isEmpty()) {
                v(new a.OnRequireListItemsSelected(arrayList));
            }
        }
    }

    private final void y() {
        a.GetAnchorViewIntent getAnchorViewIntent = new a.GetAnchorViewIntent(null, 1, null);
        v(getAnchorViewIntent);
        View anchorView = getAnchorViewIntent.getAnchorView();
        if (anchorView == null) {
            anchorView = this.mRequireList;
        }
        g74.a aVar = this.mRequireAdapter;
        if (aVar != null) {
            aVar.p0(anchorView);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull WriteListUIState writeListUIState) {
        c.a.a(this, writeListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends WriteListUIState>> getObserverStates() {
        List<Class<? extends WriteListUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(WriteListUIState.SubmitListUIState.class);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: j, reason: from getter */
    public com.tencent.robot.write.vb.b getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull WriteListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof WriteListUIState.SubmitListUIState) {
            n(((WriteListUIState.SubmitListUIState) state).getData());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull d binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        View container = binding.getContainer();
        this.mContainer = container;
        if (container != null) {
            container.setBackgroundColor(container.getContext().getColor(R.color.qui_common_bg_middle_light));
            this.mTypeText = (TextView) container.findViewById(R.id.f113826ro);
            this.mTypeList = (RecyclerView) container.findViewById(R.id.f113806rm);
            this.mRequireText = (TextView) container.findViewById(R.id.f73613u1);
            this.mRequireList = (RecyclerView) container.findViewById(R.id.f73603u0);
            RecyclerView recyclerView = this.mTypeList;
            if (recyclerView != null) {
                g74.b bVar = new g74.b();
                this.mTypeAdapter = bVar;
                bVar.r0(l());
                recyclerView.setAdapter(bVar);
                recyclerView.setItemAnimator(null);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
                this.mLayoutManager = staggeredGridLayoutManager;
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                recyclerView.addItemDecoration(new c());
            }
            RecyclerView recyclerView2 = this.mRequireList;
            if (recyclerView2 != null) {
                g74.a aVar = new g74.a();
                this.mRequireAdapter = aVar;
                aVar.q0(k());
                recyclerView2.setAdapter(aVar);
                recyclerView2.setItemAnimator(null);
                recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
                recyclerView2.addItemDecoration(new b());
            }
        }
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void v(@NotNull a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.robot.write.vb.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mHost = bVar;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
    }
}

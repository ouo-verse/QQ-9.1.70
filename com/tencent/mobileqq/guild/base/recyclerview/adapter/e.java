package com.tencent.mobileqq.guild.base.recyclerview.adapter;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import hf1.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 \u00a4\u0001*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0002\u00a5\u0001B'\b\u0007\u0012\b\b\u0001\u0010O\u001a\u00020\u001b\u0012\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$\u00a2\u0006\u0006\b\u00a2\u0001\u0010\u00a3\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J%\u0010\f\u001a\u0004\u0018\u00018\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u001f\u0010\"\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010 \u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\"\u0010#J-\u0010%\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010 \u001a\u00020\u001b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150$H\u0016\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020\u001bH\u0014J\u0019\u00102\u001a\u00028\u00002\b\b\u0001\u0010 \u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u001bH\u0014\u00a2\u0006\u0004\b5\u0010#J\u001f\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u001bH\u0014\u00a2\u0006\u0004\b6\u0010#J\b\u00107\u001a\u00020\u001bH\u0014J\u0010\u00108\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0014J\u001f\u00109\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0014\u00a2\u0006\u0004\b9\u0010\u001eJ\u0017\u0010:\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u000200J\u0006\u0010?\u001a\u000200J\u0018\u0010C\u001a\u00020\u00052\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u001bH\u0014J\u0018\u0010F\u001a\u00020\u00052\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010DH\u0016J\b\u0010H\u001a\u0004\u0018\u00010GJ\b\u0010J\u001a\u0004\u0018\u00010IJ\b\u0010L\u001a\u0004\u0018\u00010KJ\b\u0010N\u001a\u0004\u0018\u00010MJ\u0016\u0010P\u001a\u00020\n*\u00020\u00192\b\b\u0001\u0010O\u001a\u00020\u001bH\u0004R\u0014\u0010O\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR6\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000$2\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0006@@X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010a\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010e\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010\\\u001a\u0004\bc\u0010^\"\u0004\bd\u0010`R\"\u0010g\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010\\\u001a\u0004\bg\u0010^\"\u0004\bh\u0010`R\"\u0010l\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010\\\u001a\u0004\bj\u0010^\"\u0004\bk\u0010`R\"\u0010p\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010\\\u001a\u0004\bn\u0010^\"\u0004\bo\u0010`R\"\u0010s\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\\\u001a\u0004\bq\u0010^\"\u0004\br\u0010`R\"\u0010u\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010\\\u001a\u0004\bu\u0010^\"\u0004\bv\u0010`R.\u0010\u007f\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010w8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0082\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008b\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010RR\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R-\u0010\u0094\u0001\u001a\u0004\u0018\u00010+2\b\u0010S\u001a\u0004\u0018\u00010+8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001d\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0001\u0010\u0097\u0001R\u0015\u0010\u009c\u0001\u001a\u00030\u008c\u00018F\u00a2\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0014\u0010\u009f\u0001\u001a\u00020\u001b8F\u00a2\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0014\u0010\u00a1\u0001\u001a\u00020\u001b8F\u00a2\u0006\b\u001a\u0006\b\u00a0\u0001\u0010\u009e\u0001\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/e;", "T", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "l0", "Ljava/lang/Class;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w0", "Landroid/view/View;", "view", "o0", "(Ljava/lang/Class;Landroid/view/View;)Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "j0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "m0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "", "payloads", "n0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "M0", "(Landroid/view/ViewGroup;I)Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "getItemCount", "position", "getItemViewType", "J0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;I)V", "", "K0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;ILjava/util/List;)V", "", "getItemId", "O0", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "type", "", "I0", "getItem", "(I)Ljava/lang/Object;", "viewHolder", "k0", "N0", "q0", "r0", "L0", "p0", "(Landroid/view/View;)Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "R0", "H0", "F0", "E0", "Landroid/animation/Animator;", "anim", "index", "T0", "", "list", "S0", "Lgf1/d;", "B0", "Lgf1/e;", "C0", "Lgf1/b;", "z0", "Lgf1/c;", "A0", "layoutResId", "x0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData$qqguild_impl_release", "(Ljava/util/List;)V", "data", "D", "Z", "getHeaderWithEmptyEnable", "()Z", "setHeaderWithEmptyEnable", "(Z)V", "headerWithEmptyEnable", "E", "getFooterWithEmptyEnable", "setFooterWithEmptyEnable", "footerWithEmptyEnable", UserInfo.SEX_FEMALE, "isUseEmpty", "setUseEmpty", "G", "v0", "setHeaderViewAsFlow", "headerViewAsFlow", "H", "t0", "setFooterViewAsFlow", "footerViewAsFlow", "getAnimationEnable", "Q0", "animationEnable", "J", "isAnimationFirstOnly", "setAnimationFirstOnly", "Lff1/b;", "value", "K", "Lff1/b;", "getAdapterAnimation", "()Lff1/b;", "setAdapterAnimation", "(Lff1/b;)V", "adapterAnimation", "Landroid/widget/LinearLayout;", "L", "Landroid/widget/LinearLayout;", "mHeaderLayout", "M", "mFooterLayout", "Landroid/widget/FrameLayout;", "N", "Landroid/widget/FrameLayout;", "mEmptyLayout", "P", "mLastPosition", "Lhf1/e;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lhf1/e;", "mLoadMoreModule", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "D0", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewOrNull", "Ljava/util/LinkedHashSet;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/LinkedHashSet;", "childClickViewIds", "childLongClickViewIds", "y0", "()Lhf1/e;", "loadMoreModule", "u0", "()I", "headerLayoutCount", "s0", "footerLayoutCount", "<init>", "(ILjava/util/List;)V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class e<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<T> data;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean headerWithEmptyEnable;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean footerWithEmptyEnable;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isUseEmpty;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean headerViewAsFlow;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean footerViewAsFlow;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean animationEnable;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isAnimationFirstOnly;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ff1.b adapterAnimation;

    /* renamed from: L, reason: from kotlin metadata */
    private LinearLayout mHeaderLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private LinearLayout mFooterLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private FrameLayout mEmptyLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private hf1.e mLoadMoreModule;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerViewOrNull;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LinkedHashSet<Integer> childClickViewIds;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LinkedHashSet<Integer> childLongClickViewIds;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int layoutResId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/base/recyclerview/adapter/e$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<T, VH> f214779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f214780b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f214781c;

        b(e<T, VH> eVar, RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f214779a = eVar;
            this.f214780b = layoutManager;
            this.f214781c = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            int itemViewType = this.f214779a.getItemViewType(position);
            if (itemViewType == 268435729 && this.f214779a.getHeaderViewAsFlow()) {
                return 1;
            }
            if (itemViewType == 268436275 && this.f214779a.getFooterViewAsFlow()) {
                return 1;
            }
            e.i0(this.f214779a);
            if (this.f214779a.I0(itemViewType)) {
                return ((GridLayoutManager) this.f214780b).getSpanCount();
            }
            return this.f214781c.getSpanSize(position);
        }
    }

    @JvmOverloads
    public e(@LayoutRes int i3) {
        this(i3, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ gf1.a i0(e eVar) {
        eVar.getClass();
        return null;
    }

    private final void j0(RecyclerView.ViewHolder holder) {
        if (this.animationEnable) {
            if (!this.isAnimationFirstOnly || holder.getLayoutPosition() > this.mLastPosition) {
                ff1.b bVar = this.adapterAnimation;
                if (bVar == null) {
                    bVar = new ff1.a(0.0f, 1, null);
                }
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                for (Animator animator : bVar.a(view)) {
                    T0(animator, holder.getLayoutPosition());
                }
                this.mLastPosition = holder.getLayoutPosition();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l0() {
        if (this instanceof f) {
            this.mLoadMoreModule = ((f) this).Q(this);
        }
    }

    private final VH o0(Class<?> z16, View view) {
        try {
            if (z16.isMemberClass() && !Modifier.isStatic(z16.getModifiers())) {
                Constructor<?> declaredConstructor = z16.getDeclaredConstructor(getClass(), View.class);
                Intrinsics.checkNotNullExpressionValue(declaredConstructor, "z.getDeclaredConstructor\u2026aClass, View::class.java)");
                declaredConstructor.setAccessible(true);
                Object newInstance = declaredConstructor.newInstance(this, view);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type VH of com.tencent.mobileqq.guild.base.recyclerview.adapter.BaseQuickAdapter");
                return (VH) newInstance;
            }
            Constructor<?> declaredConstructor2 = z16.getDeclaredConstructor(View.class);
            Intrinsics.checkNotNullExpressionValue(declaredConstructor2, "z.getDeclaredConstructor(View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object newInstance2 = declaredConstructor2.newInstance(view);
            Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type VH of com.tencent.mobileqq.guild.base.recyclerview.adapter.BaseQuickAdapter");
            return (VH) newInstance2;
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            return null;
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            return null;
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            return null;
        }
    }

    private final Class<?> w0(Class<?> z16) {
        try {
            Type genericSuperclass = z16.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(types, "types");
                for (Type type : types) {
                    if (type instanceof Class) {
                        if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                            return (Class) type;
                        }
                    } else if (type instanceof ParameterizedType) {
                        Type rawType = ((ParameterizedType) type).getRawType();
                        if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                            return (Class) rawType;
                        }
                    } else {
                        continue;
                    }
                }
                return null;
            }
            return null;
        } catch (TypeNotPresentException e16) {
            e16.printStackTrace();
            return null;
        } catch (GenericSignatureFormatError e17) {
            e17.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final gf1.c A0() {
        return null;
    }

    @Nullable
    public final gf1.d B0() {
        return null;
    }

    @Nullable
    public final gf1.e C0() {
        return null;
    }

    @Nullable
    /* renamed from: D0, reason: from getter */
    public final RecyclerView getRecyclerViewOrNull() {
        return this.recyclerViewOrNull;
    }

    public final boolean E0() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() == 0 || !this.isUseEmpty) {
                return false;
            }
            return this.data.isEmpty();
        }
        return false;
    }

    public final boolean F0() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean H0() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    protected boolean I0(int type) {
        if (type != 268436821 && type != 268435729 && type != 268436275 && type != 268436002) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        hf1.e eVar = this.mLoadMoreModule;
        if (eVar != null) {
            eVar.e(position);
        }
        switch (holder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                return;
            case 268436002:
                hf1.e eVar2 = this.mLoadMoreModule;
                if (eVar2 != null) {
                    eVar2.getLoadMoreView().a(holder, position, eVar2.getLoadMoreStatus());
                    return;
                }
                return;
            default:
                m0(holder, getItem(position - u0()));
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull VH holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
            return;
        }
        hf1.e eVar = this.mLoadMoreModule;
        if (eVar != null) {
            eVar.e(position);
        }
        switch (holder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                return;
            case 268436002:
                hf1.e eVar2 = this.mLoadMoreModule;
                if (eVar2 != null) {
                    eVar2.getLoadMoreView().a(holder, position, eVar2.getLoadMoreStatus());
                    return;
                }
                return;
            default:
                n0(holder, getItem(position - u0()), payloads);
                return;
        }
    }

    @NotNull
    protected abstract VH L0(@NotNull ViewGroup parent, int viewType);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = null;
        switch (viewType) {
            case 268435729:
                LinearLayout linearLayout = this.mHeaderLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                    linearLayout = null;
                }
                ViewParent parent2 = linearLayout.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    LinearLayout linearLayout2 = this.mHeaderLayout;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                        linearLayout2 = null;
                    }
                    viewGroup.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.mHeaderLayout;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                } else {
                    view = linearLayout3;
                }
                return p0(view);
            case 268436002:
                hf1.e eVar = this.mLoadMoreModule;
                Intrinsics.checkNotNull(eVar);
                VH p06 = p0(eVar.getLoadMoreView().f(parent));
                hf1.e eVar2 = this.mLoadMoreModule;
                Intrinsics.checkNotNull(eVar2);
                eVar2.B(p06);
                return p06;
            case 268436275:
                LinearLayout linearLayout4 = this.mFooterLayout;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                    linearLayout4 = null;
                }
                ViewParent parent3 = linearLayout4.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent3;
                    LinearLayout linearLayout5 = this.mFooterLayout;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                        linearLayout5 = null;
                    }
                    viewGroup2.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.mFooterLayout;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                } else {
                    view = linearLayout6;
                }
                return p0(view);
            case 268436821:
                FrameLayout frameLayout = this.mEmptyLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout = null;
                }
                ViewParent parent4 = frameLayout.getParent();
                if (parent4 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent4;
                    FrameLayout frameLayout2 = this.mEmptyLayout;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                        frameLayout2 = null;
                    }
                    viewGroup3.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.mEmptyLayout;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                } else {
                    view = frameLayout3;
                }
                return p0(view);
            default:
                VH L0 = L0(parent, viewType);
                k0(L0, viewType);
                N0(L0, viewType);
                return L0;
        }
    }

    protected void N0(@NotNull VH viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: O0 */
    public void onViewAttachedToWindow(@NotNull VH holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (I0(holder.getItemViewType())) {
            R0(holder);
        } else {
            j0(holder);
        }
    }

    public final void Q0(boolean z16) {
        this.animationEnable = z16;
    }

    protected void R0(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void S0(@Nullable Collection<? extends T> list) {
        List<T> list2 = this.data;
        boolean z16 = false;
        if (list != list2) {
            list2.clear();
            if (list == null || list.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                this.data.addAll(list);
            }
        } else {
            if (list == null || list.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList(list);
                this.data.clear();
                this.data.addAll(arrayList);
            } else {
                this.data.clear();
            }
        }
        hf1.e eVar = this.mLoadMoreModule;
        if (eVar != null) {
            eVar.v();
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
        hf1.e eVar2 = this.mLoadMoreModule;
        if (eVar2 != null) {
            eVar2.f();
        }
    }

    protected void T0(@NotNull Animator anim, int index) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        anim.start();
    }

    @NotNull
    public final List<T> getData() {
        return this.data;
    }

    public T getItem(@IntRange(from = 0) int position) {
        return this.data.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i3 = 1;
        if (E0()) {
            if (this.headerWithEmptyEnable && H0()) {
                i3 = 2;
            }
            if (this.footerWithEmptyEnable && F0()) {
                return i3 + 1;
            }
            return i3;
        }
        hf1.e eVar = this.mLoadMoreModule;
        if (eVar == null || !eVar.m()) {
            i3 = 0;
        }
        return u0() + q0() + s0() + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        boolean z16;
        if (E0()) {
            if (this.headerWithEmptyEnable && H0()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (position != 0) {
                return position != 1 ? 268436275 : 268436275;
            }
            if (z16) {
                return 268435729;
            }
            return 268436821;
        }
        boolean H0 = H0();
        if (H0 && position == 0) {
            return 268435729;
        }
        if (H0) {
            position--;
        }
        int size = this.data.size();
        if (position < size) {
            return r0(position);
        }
        if (position - size < F0()) {
            return 268436275;
        }
        return 268436002;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(@NotNull VH viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    protected abstract void m0(@NotNull VH holder, T item);

    protected void n0(@NotNull VH holder, T item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerViewOrNull = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new b(this, layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerViewOrNull = null;
    }

    @NotNull
    protected VH p0(@NotNull View view) {
        VH o06;
        Intrinsics.checkNotNullParameter(view, "view");
        Class<?> cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = w0(cls2);
        }
        if (cls == null) {
            o06 = (VH) new BaseViewHolder(view);
        } else {
            o06 = o0(cls, view);
        }
        return o06 == null ? (VH) new BaseViewHolder(view) : o06;
    }

    protected int q0() {
        return this.data.size();
    }

    protected int r0(int position) {
        return super.getItemViewType(position);
    }

    public final int s0() {
        return F0() ? 1 : 0;
    }

    /* renamed from: t0, reason: from getter */
    public final boolean getFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public final int u0() {
        return H0() ? 1 : 0;
    }

    /* renamed from: v0, reason: from getter */
    public final boolean getHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View x0(@NotNull ViewGroup viewGroup, @LayoutRes int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(this.context).infla\u2026layoutResId, this, false)");
        return inflate;
    }

    @NotNull
    public final hf1.e y0() {
        hf1.e eVar = this.mLoadMoreModule;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            return eVar;
        }
        throw new IllegalStateException("Please first implements LoadMoreModule".toString());
    }

    @Nullable
    public final gf1.b z0() {
        return null;
    }

    public /* synthetic */ e(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : list);
    }

    @JvmOverloads
    public e(@LayoutRes int i3, @Nullable List<T> list) {
        this.layoutResId = i3;
        this.data = list == null ? new ArrayList<>() : list;
        this.isUseEmpty = true;
        this.isAnimationFirstOnly = true;
        this.mLastPosition = -1;
        l0();
        this.childClickViewIds = new LinkedHashSet<>();
        this.childLongClickViewIds = new LinkedHashSet<>();
    }
}

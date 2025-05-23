package com.tencent.mobileqq.mini.common.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0010\b&\u0018\u0000 H*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0003HIJB\u0005\u00a2\u0006\u0002\u0010\u0004JT\u0010\u001f\u001a\u00020 2:\u0010!\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u001cJ\\\u0010$\u001a\u00020 2:\u0010!\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010%\u001a\u00020\u000bJT\u0010&\u001a\u00020\u000b2:\u0010!\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u001cJ\\\u0010'\u001a\u00020 2:\u0010!\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010%\u001a\u00020\u000bJn\u0010(\u001a\u00020\u00022T\u0010)\u001aP\u0012L\u0012J\u00128\u00126\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00120*2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u000bH&J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0016J\u001d\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u000bH&\u00a2\u0006\u0002\u00100J\u001d\u00101\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000bH&\u00a2\u0006\u0002\u00102J\u0015\u00103\u001a\u00020 2\u0006\u0010/\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bJ\u000e\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\u000e\u00109\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000bJ\u000e\u0010=\u001a\u00020;2\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010>\u001a\u00020;2\u0006\u00106\u001a\u00020\u000bJ\u000e\u0010?\u001a\u00020;2\u0006\u0010%\u001a\u00020\u000bJ\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u0006H\u0017J\u0016\u0010B\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000bJ\u0016\u0010C\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000bJ\u0010\u0010D\u001a\u00020 2\u0006\u0010A\u001a\u00020\u0006H\u0017J\u000e\u0010E\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0002J\u000e\u0010F\u001a\u00020 2\u0006\u0010<\u001a\u00020\u000bJ\u000e\u0010G\u001a\u00020 2\u0006\u00106\u001a\u00020\u000bR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u00af\u0001\u0010\u0010\u001a\u00a2\u0001\u0012L\u0012J\u00128\u00126\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00120\u0011jP\u0012L\u0012J\u00128\u00126\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0012`\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u00af\u0001\u0010\u001e\u001a\u00a2\u0001\u0012L\u0012J\u00128\u00126\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00120\u0011jP\u0012L\u0012J\u00128\u00126\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0013j\u0002`\u001b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0012`\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "<set-?>", "Landroidx/recyclerview/widget/RecyclerView;", "attachedRecyclerView", "getAttachedRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "footerCount", "", "getFooterCount", "()I", "headerCount", "getHeaderCount", "mFooters", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "layoutInflater", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "Lcom/tencent/mobileqq/mini/common/ui/ViewFactory;", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;", "Lkotlin/collections/ArrayList;", "mHeaders", "addFooter", "", "viewFactory", "viewType", "showHideListener", "addFooterAt", "position", "addHeader", "addHeaderAt", "createDecorViewHolder", "list", "", c.G, "doGetItemCount", "doGetItemViewType", "doOnBindViewHolder", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "doOnCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "doOnViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "findFooterIndex", "headerViewType", "findHeaderIndex", "getItemCount", "getItemViewType", "isFooterAdded", "", "footerViewType", "isFooterPosition", "isHeaderAdded", "isHeaderPosition", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewRecycled", "removeFooter", "removeHeader", "Companion", "OnShowListener", "SimpleViewHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class RecyclerWrapperAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int HEADER_FOOTER_MAX_COUNT = 1024;
    public static final int VIEW_TYPE_FOOTER_BEGIN = -2147482623;
    public static final int VIEW_TYPE_FOOTER_END = -2147481599;
    public static final int VIEW_TYPE_HEADER_BEGIN = Integer.MIN_VALUE;
    public static final int VIEW_TYPE_HEADER_END = -2147482624;
    private RecyclerView attachedRecyclerView;
    private final ArrayList<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> mHeaders = new ArrayList<>();
    private final ArrayList<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> mFooters = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Jj\u0010\t\u001a\u00020\n\"\u0004\b\u0001\u0010\u000b2R\u0010\f\u001aN\u0012J\u0012H\u00128\u00126\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000fj\u0002`\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u000b0\u000e0\r2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002JH\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u001a\"\u0004\b\u0002\u0010\u001b\"\u0004\b\u0003\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001b2\u001e\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000e0\rH\u0082\b\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$Companion;", "", "()V", "HEADER_FOOTER_MAX_COUNT", "", "VIEW_TYPE_FOOTER_BEGIN", "VIEW_TYPE_FOOTER_END", "VIEW_TYPE_HEADER_BEGIN", "VIEW_TYPE_HEADER_END", "checkAdd", "", BdhLogUtil.LogTag.Tag_Req, "list", "", "Lkotlin/Triple;", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "layoutInflater", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "Lcom/tencent/mobileqq/mini/common/ui/ViewFactory;", "viewType", "findIndexForSecond", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "(Ljava/lang/Object;Ljava/util/List;)I", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <R> void checkAdd(List<? extends Triple<? extends Function2<? super LayoutInflater, ? super ViewGroup, ? extends View>, Integer, ? extends R>> list, int viewType) {
            Integer valueOf = Integer.valueOf(viewType);
            Iterator<? extends Triple<? extends Function2<? super LayoutInflater, ? super ViewGroup, ? extends View>, Integer, ? extends R>> it = list.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                if (list.size() + 1 > 1024) {
                    throw new IllegalStateException("header or footer cannot be more than 1024");
                }
            } else {
                throw new IllegalArgumentException("viewType already added " + viewType);
            }
        }

        private final <A, B, C> int findIndexForSecond(B second, List<? extends Triple<? extends A, ? extends B, ? extends C>> list) {
            Iterator<? extends Triple<? extends A, ? extends B, ? extends C>> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getSecond(), second)) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;", "", "onShow", "", "view", "Landroid/view/View;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface OnShowListener {
        void onShow(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$SimpleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mOnShowListener", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;", "(Landroid/view/View;Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;)V", "onShow", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class SimpleViewHolder extends RecyclerView.ViewHolder {
        private final OnShowListener mOnShowListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View itemView, OnShowListener onShowListener) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.mOnShowListener = onShowListener;
        }

        public final void onShow() {
            OnShowListener onShowListener = this.mOnShowListener;
            if (onShowListener != null) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                onShowListener.onShow(itemView);
            }
        }
    }

    private final RecyclerView.ViewHolder createDecorViewHolder(List<? extends Triple<? extends Function2<? super LayoutInflater, ? super ViewGroup, ? extends View>, Integer, ? extends OnShowListener>> list, int pos, ViewGroup parent) {
        Triple<? extends Function2<? super LayoutInflater, ? super ViewGroup, ? extends View>, Integer, ? extends OnShowListener> triple = list.get(pos);
        Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> first = triple.getFirst();
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(parent.context)");
        return new SimpleViewHolder(first.invoke(from, parent), triple.getThird());
    }

    public final void addFooter(Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> viewFactory, int viewType, OnShowListener showHideListener) {
        Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
        addFooterAt(viewFactory, viewType, showHideListener, getFooterCount());
    }

    public final void addFooterAt(Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> viewFactory, int viewType, OnShowListener showHideListener, int position) throws IndexOutOfBoundsException {
        Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
        boolean z16 = false;
        if (-2147482623 <= viewType && viewType < -2147481598) {
            z16 = true;
        }
        if (z16) {
            INSTANCE.checkAdd(this.mFooters, viewType);
            this.mFooters.add(position, new Triple<>(viewFactory, Integer.valueOf(viewType), showHideListener));
            notifyItemInserted(getHeaderCount() + doGetItemCount() + position);
            return;
        }
        throw new IllegalArgumentException("footer view type must in [VIEW_TYPE_FOOTER_BEGIN, VIEW_TYPE_FOOTER_END]");
    }

    public final int addHeader(Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> viewFactory, int viewType, OnShowListener showHideListener) {
        Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
        addHeaderAt(viewFactory, viewType, showHideListener, getHeaderCount());
        return getHeaderCount();
    }

    public final void addHeaderAt(Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> viewFactory, int viewType, OnShowListener showHideListener, int position) throws IndexOutOfBoundsException {
        Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
        boolean z16 = false;
        if (Integer.MIN_VALUE <= viewType && viewType < -2147482623) {
            z16 = true;
        }
        if (z16) {
            INSTANCE.checkAdd(this.mHeaders, viewType);
            this.mHeaders.add(position, new Triple<>(viewFactory, Integer.valueOf(viewType), showHideListener));
            notifyItemInserted(position);
            return;
        }
        throw new IllegalArgumentException("header view type must in [VIEW_TYPE_HEADER_BEGIN, VIEW_TYPE_HEADER_END]");
    }

    public abstract int doGetItemCount();

    public int doGetItemViewType(int position) {
        return 0;
    }

    public abstract void doOnBindViewHolder(T holder, int position);

    public abstract T doOnCreateViewHolder(ViewGroup parent, int viewType);

    public void doOnViewRecycled(T holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public final int findFooterIndex(int headerViewType) {
        Integer valueOf = Integer.valueOf(headerViewType);
        Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mFooters.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            return -1;
        }
        return getHeaderCount() + doGetItemCount() + i3;
    }

    public final int findHeaderIndex(int headerViewType) {
        Integer valueOf = Integer.valueOf(headerViewType);
        Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mHeaders.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public final RecyclerView getAttachedRecyclerView() {
        return this.attachedRecyclerView;
    }

    public final int getFooterCount() {
        return this.mFooters.size();
    }

    public final int getHeaderCount() {
        return this.mHeaders.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getHeaderCount() + getFooterCount() + doGetItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        if (position < getHeaderCount()) {
            return this.mHeaders.get(position).getSecond().intValue();
        }
        if (position >= getHeaderCount() + doGetItemCount()) {
            return this.mFooters.get(position - (getHeaderCount() + doGetItemCount())).getSecond().intValue();
        }
        int doGetItemViewType = doGetItemViewType(position - getHeaderCount());
        if (doGetItemViewType > -2147481599) {
            return doGetItemViewType;
        }
        throw new IllegalStateException("view type ranged in [-2147483648, -2147481599] are reserved for footer and header!");
    }

    public final boolean isFooterAdded(int footerViewType) {
        Integer valueOf = Integer.valueOf(footerViewType);
        Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mFooters.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                break;
            }
            i3++;
        }
        return i3 != -1;
    }

    public final boolean isFooterPosition(int position) {
        return position >= getHeaderCount() + doGetItemCount();
    }

    public final boolean isHeaderAdded(int headerViewType) {
        Integer valueOf = Integer.valueOf(headerViewType);
        Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mHeaders.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                break;
            }
            i3++;
        }
        return i3 != -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.attachedRecyclerView = recyclerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (!isHeaderPosition(position) && !isFooterPosition(position)) {
            doOnBindViewHolder(holder, position - getHeaderCount());
        } else {
            ((SimpleViewHolder) holder).onShow();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i3 = 0;
        int i16 = -1;
        if (Integer.MIN_VALUE <= viewType && viewType < -2147482623) {
            Integer valueOf = Integer.valueOf(viewType);
            Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mHeaders.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                    i16 = i3;
                    break;
                }
                i3++;
            }
            if (i16 >= 0) {
                return createDecorViewHolder(this.mHeaders, i16, parent);
            }
            throw new IllegalStateException("can't find header for type:" + viewType);
        }
        if (-2147482623 <= viewType && viewType < -2147481598) {
            Integer valueOf2 = Integer.valueOf(viewType);
            Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it5 = this.mFooters.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(it5.next().getSecond(), valueOf2)) {
                    i16 = i3;
                    break;
                }
                i3++;
            }
            if (i16 >= 0) {
                return createDecorViewHolder(this.mFooters, i16, parent);
            }
            throw new IllegalStateException("can't find footer for type:" + viewType);
        }
        return doOnCreateViewHolder(parent, viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.attachedRecyclerView = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() > -2147481599) {
            doOnViewRecycled(holder);
        }
    }

    public final void removeFooter(int footerViewType) {
        Integer valueOf = Integer.valueOf(footerViewType);
        Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mFooters.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            this.mFooters.remove(i3);
            notifyItemRemoved(getHeaderCount() + doGetItemCount() + i3);
        }
    }

    public final void removeHeader(int headerViewType) {
        Integer valueOf = Integer.valueOf(headerViewType);
        Iterator<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, OnShowListener>> it = this.mHeaders.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getSecond(), valueOf)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            this.mHeaders.remove(i3);
            notifyItemRemoved(i3);
        }
    }

    public final boolean isHeaderPosition(int position) {
        return position >= 0 && position <= getHeaderCount() - 1;
    }
}

package com.tencent.mobileqq.wink.editor.subtitle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.subtitle.k;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001_BM\u00126\u00103\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000b0+\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b04\u00a2\u0006\u0004\b\\\u0010]J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0016\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0007J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0003H\u0007J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0017J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0017J\b\u0010$\u001a\u00020\u0007H\u0016J\u0006\u0010%\u001a\u00020\u000bJ\u0016\u0010&\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010'\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0007RD\u00103\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000b0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\t08j\b\u0012\u0004\u0012\u00020\t`98\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010JR*\u0010R\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00078\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010F\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010Y\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00038\u0006@GX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0011\u0010[\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010V\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/j;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "focusLine", "Lcom/tencent/mobileqq/wink/editor/subtitle/o;", "holder", "", "position", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "subtitle", "", "r0", "Landroid/view/View;", "holderView", "w0", "index", "v0", "", "newItems", "O0", "x0", "", "curPositionUs", "byDrag", "J0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemViewType", "onBindViewHolder", "getItemCount", "u0", "t0", "B0", "y0", "keyboardHeightInPx", "H0", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "line", "Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "itemOperateListener", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "displayModeStatusChangeCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "items", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "E", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "scroller", "Landroid/widget/EditText;", UserInfo.SEX_FEMALE, "Landroid/widget/EditText;", "editor", "G", "I", "highlightIndex", "H", "editFocusIndex", "Landroidx/recyclerview/widget/RecyclerView;", "attachedRecyclerView", "value", "J", "z0", "()I", "M0", "(I)V", "displayMode", "K", "Z", "getPlayerState", "()Z", "N0", "(Z)V", "playerState", "A0", "hasContent", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int M = R.layout.hej;

    /* renamed from: C */
    @NotNull
    private final Function0<Unit> displayModeStatusChangeCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Subtitle> items;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearSmoothScroller scroller;

    /* renamed from: F */
    @Nullable
    private EditText editor;

    /* renamed from: G, reason: from kotlin metadata */
    private int highlightIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private int editFocusIndex;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private RecyclerView attachedRecyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private int displayMode;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean playerState;

    /* renamed from: m */
    @NotNull
    private final Function2<Subtitle, k, Unit> itemOperateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/j$b", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getVerticalSnapPreference", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends LinearSmoothScroller {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/j$d", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d */
        final /* synthetic */ View f322191d;

        d(View view) {
            this.f322191d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f322191d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            com.tencent.videocut.utils.j jVar = com.tencent.videocut.utils.j.f384247a;
            View v3 = this.f322191d;
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            jVar.b(v3);
            View view = this.f322191d;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            ((EditText) view).setSelection(((EditText) this.f322191d).getText().length());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/j$e", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends RecyclerView.ViewHolder {
        e(Space space) {
            super(space);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull Function2<? super Subtitle, ? super k, Unit> itemOperateListener, @NotNull Function0<Unit> displayModeStatusChangeCallback) {
        Intrinsics.checkNotNullParameter(itemOperateListener, "itemOperateListener");
        Intrinsics.checkNotNullParameter(displayModeStatusChangeCallback, "displayModeStatusChangeCallback");
        this.itemOperateListener = itemOperateListener;
        this.displayModeStatusChangeCallback = displayModeStatusChangeCallback;
        this.items = new ArrayList<>();
        this.highlightIndex = -1;
        this.editFocusIndex = -1;
    }

    public static final boolean C0(j this$0, EditText this_apply, TextView textView, int i3, KeyEvent keyEvent) {
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i3 == 5 || (keyEvent != null && keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.items, this$0.editFocusIndex);
            Subtitle subtitle = (Subtitle) orNull;
            if (subtitle != null) {
                CharSequence oldContent = textView.getText();
                if (this_apply.getSelectionEnd() == this_apply.getSelectionStart() && (this_apply.getSelectionStart() == 0 || this_apply.getSelectionStart() == oldContent.length())) {
                    return false;
                }
                Intrinsics.checkNotNullExpressionValue(oldContent, "oldContent");
                this$0.itemOperateListener.invoke(subtitle, new k.BreakLine(this$0.editFocusIndex, oldContent.toString(), oldContent.subSequence(0, textView.getSelectionStart()).toString(), oldContent.subSequence(textView.getSelectionEnd(), oldContent.length()).toString()));
                return true;
            }
            return true;
        }
        return false;
    }

    public static final void D0(View view, boolean z16) {
        if (z16) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new d(view));
        }
    }

    public static final void E0(j this$0, RecyclerView.ViewHolder holder, View view) {
        boolean z16;
        Object orNull;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (this$0.displayMode == 0) {
            int adapterPosition = ((o) holder).getAdapterPosition();
            orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.items, adapterPosition);
            Subtitle subtitle = (Subtitle) orNull;
            if (subtitle != null) {
                this$0.itemOperateListener.invoke(subtitle, new k.Click(adapterPosition));
            }
        } else {
            int i3 = this$0.editFocusIndex;
            this$0.editFocusIndex = ((o) holder).getAdapterPosition();
            boolean z17 = true;
            if (i3 >= 0 && i3 < this$0.items.size()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this$0.notifyItemChanged(i3);
            }
            int size = this$0.items.size();
            int i16 = this$0.editFocusIndex;
            if (i16 < 0 || i16 >= size) {
                z17 = false;
            }
            if (z17) {
                this$0.notifyItemChanged(i16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void F0(j this$0, RecyclerView.ViewHolder holder, View view) {
        Object orNull;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.items, ((o) holder).getAdapterPosition());
        Subtitle subtitle = (Subtitle) orNull;
        if (subtitle != null) {
            this$0.itemOperateListener.invoke(subtitle, k.d.f322199a);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void I0(RecyclerView rv5, j this$0) {
        Intrinsics.checkNotNullParameter(rv5, "$rv");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.LayoutManager layoutManager = rv5.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this$0.editFocusIndex, (rv5.getHeight() - rv5.getContext().getResources().getDimensionPixelSize(R.dimen.djs)) / 2);
    }

    public static /* synthetic */ void K0(j jVar, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        jVar.J0(j3, z16);
    }

    public static final void L0(j this$0, int i3) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearSmoothScroller linearSmoothScroller = this$0.scroller;
        LinearSmoothScroller linearSmoothScroller2 = null;
        if (linearSmoothScroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scroller");
            linearSmoothScroller = null;
        }
        linearSmoothScroller.setTargetPosition(i3);
        RecyclerView recyclerView = this$0.attachedRecyclerView;
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            LinearSmoothScroller linearSmoothScroller3 = this$0.scroller;
            if (linearSmoothScroller3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scroller");
            } else {
                linearSmoothScroller2 = linearSmoothScroller3;
            }
            linearLayoutManager.startSmoothScroll(linearSmoothScroller2);
        }
    }

    private final void r0(boolean focusLine, o holder, int position, Subtitle subtitle) {
        ViewParent viewParent;
        ViewGroup viewGroup;
        Object obj;
        ViewParent viewParent2;
        ViewGroup viewGroup2;
        ViewParent viewParent3;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4 = null;
        final Object obj2 = null;
        if (focusLine) {
            View view = holder.itemView;
            EditText editText = this.editor;
            if (editText != null) {
                viewParent2 = editText.getParent();
            } else {
                viewParent2 = null;
            }
            if (viewParent2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewParent2;
            } else {
                viewGroup2 = null;
            }
            if (!Intrinsics.areEqual(view, viewGroup2)) {
                w53.b.a("SubtitleAdapter", "remove editor in focusLine refresh");
                EditText editText2 = this.editor;
                if (editText2 != null) {
                    viewParent3 = editText2.getParent();
                } else {
                    viewParent3 = null;
                }
                if (viewParent3 instanceof ViewGroup) {
                    viewGroup3 = (ViewGroup) viewParent3;
                } else {
                    viewGroup3 = null;
                }
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.editor);
                }
                w53.b.a("SubtitleAdapter", "add editor in focusLine refresh");
                View view2 = holder.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) view2).addView(this.editor);
                EditText editText3 = this.editor;
                if (editText3 != null) {
                    obj2 = editText3.getTag();
                }
                if (obj2 != null && (!(obj2 instanceof Integer) || position != ((Number) obj2).intValue())) {
                    holder.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.s0(j.this, obj2);
                        }
                    });
                }
            }
            EditText editText4 = this.editor;
            if (editText4 != null) {
                editText4.setTag(Integer.valueOf(position));
            }
            EditText editText5 = this.editor;
            if (editText5 != null) {
                editText5.setText(subtitle.getEditContent());
            }
            EditText editText6 = this.editor;
            if (editText6 != null) {
                editText6.requestFocus();
                return;
            }
            return;
        }
        View view3 = holder.itemView;
        EditText editText7 = this.editor;
        if (editText7 != null) {
            viewParent = editText7.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        } else {
            viewGroup = null;
        }
        if (Intrinsics.areEqual(view3, viewGroup)) {
            w53.b.a("SubtitleAdapter", "remove view in unfocus line  refresh");
            EditText editText8 = this.editor;
            if (editText8 != null) {
                obj = editText8.getParent();
            } else {
                obj = null;
            }
            if (obj instanceof ViewGroup) {
                viewGroup4 = (ViewGroup) obj;
            }
            if (viewGroup4 != null) {
                viewGroup4.removeView(this.editor);
            }
        }
    }

    public static final void s0(j this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        this$0.v0(((Integer) obj).intValue());
    }

    private final void v0(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.items, index);
        Subtitle subtitle = (Subtitle) orNull;
        if (subtitle == null) {
            return;
        }
        w53.b.a("SubtitleAdapter", "commit change " + subtitle.getEditContent());
        Function2<Subtitle, k, Unit> function2 = this.itemOperateListener;
        String editContent = subtitle.getEditContent();
        if (editContent == null) {
            editContent = "";
        }
        function2.invoke(subtitle, new k.Edit(index, editContent));
    }

    private final void w0(View holderView) {
        RecyclerView.ViewHolder childViewHolder;
        Object orNull;
        RecyclerView recyclerView = this.attachedRecyclerView;
        if (recyclerView != null && (childViewHolder = recyclerView.getChildViewHolder(holderView)) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.items, childViewHolder.getAdapterPosition());
            Subtitle subtitle = (Subtitle) orNull;
            if (subtitle == null) {
                return;
            }
            w53.b.a("SubtitleAdapter", "commit change " + subtitle.getEditContent());
            Function2<Subtitle, k, Unit> function2 = this.itemOperateListener;
            int adapterPosition = childViewHolder.getAdapterPosition();
            String editContent = subtitle.getEditContent();
            if (editContent == null) {
                editContent = "";
            }
            function2.invoke(subtitle, new k.Edit(adapterPosition, editContent));
        }
    }

    public final boolean A0() {
        return !this.items.isEmpty();
    }

    public final void B0(int index, @NotNull Subtitle subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        boolean z16 = false;
        if (index >= 0 && index < this.items.size()) {
            z16 = true;
        }
        if (z16) {
            this.items.add(index, subtitle);
            int i3 = this.editFocusIndex;
            if (index == i3) {
                this.editFocusIndex = i3 + 1;
            }
            notifyItemInserted(index);
        }
    }

    public final void H0(int keyboardHeightInPx) {
        final RecyclerView recyclerView;
        if (this.displayMode == 0 || this.editFocusIndex == -1 || (recyclerView = this.attachedRecyclerView) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.g
            @Override // java.lang.Runnable
            public final void run() {
                j.I0(RecyclerView.this, this);
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void J0(long curPositionUs, boolean byDrag) {
        RecyclerView recyclerView;
        boolean z16;
        if (this.displayMode != 0) {
            return;
        }
        Iterator<Subtitle> it = this.items.iterator();
        final int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                Subtitle next = it.next();
                long absStartTimeUs = next.getAbsStartTimeUs();
                if (curPositionUs < next.getAbsStartTimeUs() + next.getDurationUs() && absStartTimeUs <= curPositionUs) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1 && this.highlightIndex != i3) {
            this.highlightIndex = i3;
            notifyDataSetChanged();
            if (!byDrag && (recyclerView = this.attachedRecyclerView) != null) {
                recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.L0(j.this, i3);
                    }
                });
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void M0(int i3) {
        if (this.displayMode == i3) {
            return;
        }
        this.displayMode = i3;
        if (i3 == 1) {
            this.editFocusIndex = -1;
        } else {
            EditText editText = this.editor;
            if (editText != null) {
                editText.setTag(null);
            }
        }
        notifyDataSetChanged();
        this.displayModeStatusChangeCallback.invoke();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void N0(boolean z16) {
        this.playerState = z16;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void O0(@NotNull List<Subtitle> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        Iterator<Subtitle> it = newItems.iterator();
        while (it.hasNext()) {
            it.next().setEditContent(null);
        }
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (this.displayMode == 1) {
            return this.items.size();
        }
        if (this.items.size() == 0) {
            return 0;
        }
        return this.items.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.displayMode == 1) {
            return M;
        }
        if (position >= this.items.size()) {
            return -1;
        }
        return M;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"NewApi"})
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.attachedRecyclerView = recyclerView;
        this.scroller = new b(recyclerView.getContext());
        final EditText editText = new EditText(recyclerView.getContext());
        editText.setImeOptions(5);
        editText.setBackground(null);
        editText.setTextSize(16.0f);
        if (Build.VERSION.SDK_INT >= 29) {
            editText.setTextCursorDrawable(ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.m6_));
        }
        editText.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMarginStart(recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.c_h));
        layoutParams.setMarginEnd(recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.c_h));
        editText.setLayoutParams(layoutParams);
        editText.setInputType(1);
        editText.setGravity(17);
        editText.setMaxLines(1);
        editText.setLines(1);
        editText.getPaint().setFakeBoldText(true);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.e
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean C0;
                C0 = j.C0(j.this, editText, textView, i3, keyEvent);
                return C0;
            }
        });
        editText.addTextChangedListener(new c());
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                j.D0(view, z16);
            }
        });
        this.editor = editText;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"NewApi"})
    public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder, int position) {
        int i3;
        ViewParent viewParent;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position < this.items.size() && (holder instanceof o)) {
            Subtitle subtitle = this.items.get(position);
            Intrinsics.checkNotNullExpressionValue(subtitle, "items[position]");
            Subtitle subtitle2 = subtitle;
            o oVar = (o) holder;
            int i16 = 0;
            oVar.getLine().setVisibility(0);
            oVar.getLine().setText(subtitle2.getEditContent());
            ImageView toggle = oVar.getToggle();
            int i17 = 8;
            if (position == this.editFocusIndex) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            toggle.setVisibility(i3);
            oVar.getToggle().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.F0(j.this, holder, view);
                }
            });
            oVar.getLine().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.subtitle.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.E0(j.this, holder, view);
                }
            });
            int i18 = this.displayMode;
            int i19 = -1;
            float f16 = 14.0f;
            boolean z16 = true;
            if (i18 != 0) {
                if (i18 == 1) {
                    if (this.editFocusIndex != position) {
                        z16 = false;
                    }
                    TextView line = oVar.getLine();
                    if (z16) {
                        f16 = 16.0f;
                    }
                    line.setTextSize(f16);
                    TextView line2 = oVar.getLine();
                    if (!z16) {
                        i19 = ContextCompat.getColor(holder.itemView.getContext(), R.color.alc);
                    }
                    line2.setTextColor(i19);
                    oVar.getLine().getPaint().setFakeBoldText(false);
                    TextView line3 = oVar.getLine();
                    if (!z16) {
                        i17 = 0;
                    }
                    line3.setVisibility(i17);
                    holder.itemView.getLayoutParams().height = holder.itemView.getResources().getDimensionPixelSize(R.dimen.djs);
                    View view = holder.itemView;
                    if (z16) {
                        i16 = ContextCompat.getColor(view.getContext(), R.color.al7);
                    }
                    view.setBackgroundColor(i16);
                    r0(z16, (o) holder, position, subtitle2);
                    return;
                }
                return;
            }
            if (this.highlightIndex != position) {
                z16 = false;
            }
            EditText editText = this.editor;
            ViewGroup viewGroup = null;
            if (editText != null) {
                viewParent = editText.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.editor);
            }
            TextView line4 = oVar.getLine();
            if (!z16) {
                i19 = ContextCompat.getColor(holder.itemView.getContext(), R.color.alc);
            }
            line4.setTextColor(i19);
            oVar.getLine().getPaint().setFakeBoldText(z16);
            oVar.getLine().setTextSize(14.0f);
            holder.itemView.setBackgroundColor(0);
            holder.itemView.getLayoutParams().height = holder.itemView.getResources().getDimensionPixelSize(R.dimen.djr);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup r46, int viewType) {
        Intrinsics.checkNotNullParameter(r46, "parent");
        if (viewType == M) {
            View inflate = LayoutInflater.from(r46.getContext()).inflate(viewType, r46, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026(viewType, parent, false)");
            return new o(inflate);
        }
        Space space = new Space(r46.getContext());
        space.setLayoutParams(new RecyclerView.LayoutParams(-1, com.tencent.videocut.utils.e.f384236a.a(96.0f)));
        return new e(space);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.attachedRecyclerView = null;
    }

    public final void t0(int index, @NotNull Subtitle subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        boolean z16 = false;
        if (index >= 0 && index < this.items.size()) {
            z16 = true;
        }
        if (z16) {
            this.items.set(index, subtitle);
            notifyItemChanged(index);
        }
    }

    public final void u0() {
        Object parent;
        w53.b.a("SubtitleAdapter", "commit change on back");
        EditText editText = this.editor;
        if (editText == null || (parent = editText.getParent()) == null) {
            return;
        }
        this.editFocusIndex = -1;
        w0((View) parent);
        com.tencent.videocut.utils.j.f384247a.a(editText);
    }

    public final void x0(int index) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.items, index);
        Subtitle subtitle = (Subtitle) orNull;
        if (subtitle == null) {
            return;
        }
        J0(subtitle.getAbsStartTimeUs(), true);
    }

    public final void y0(@NotNull Subtitle subtitle) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        int indexOf = this.items.indexOf(subtitle);
        if (indexOf != -1) {
            this.editFocusIndex = indexOf;
            notifyItemChanged(indexOf);
        }
    }

    /* renamed from: z0, reason: from getter */
    public final int getDisplayMode() {
        return this.displayMode;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/j$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable r36) {
            Object orNull;
            Intrinsics.checkNotNullParameter(r36, "s");
            orNull = CollectionsKt___CollectionsKt.getOrNull(j.this.items, j.this.editFocusIndex);
            Subtitle subtitle = (Subtitle) orNull;
            if (subtitle != null) {
                subtitle.setEditContent(r36.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence r16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence r16, int start, int before, int count) {
        }
    }
}

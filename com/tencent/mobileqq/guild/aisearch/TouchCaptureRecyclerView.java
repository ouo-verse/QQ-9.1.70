package com.tencent.mobileqq.guild.aisearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.aisearch.TouchCaptureRecyclerView;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0016\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0016R$\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\bR\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u0010-\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/TouchCaptureRecyclerView;", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "W", "X", "", "Z", "P", "O", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "answerData", "d0", "c0", "b0", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "child", "focused", "requestChildFocus", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "U", "a0", "Y", "V", "D", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "T", "()Lcom/tencent/mobileqq/guild/aisearch/models/e;", "setCurrentAnswerData", "(Lcom/tencent/mobileqq/guild/aisearch/models/e;)V", "currentAnswerData", "Lkotlin/Function1;", "E", "Lkotlin/jvm/functions/Function1;", ExifInterface.LATITUDE_SOUTH, "()Lkotlin/jvm/functions/Function1;", "setCheckShowJumpButton", "(Lkotlin/jvm/functions/Function1;)V", "checkShowJumpButton", UserInfo.SEX_FEMALE, "shouldAutoScroll", "G", "I", "nearBottomCounter", "H", "maxNearCounter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class TouchCaptureRecyclerView extends OverScrollRecyclerView {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ChatAnswerData currentAnswerData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Function1<? super Boolean, Unit> checkShowJumpButton;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean shouldAutoScroll;

    /* renamed from: G, reason: from kotlin metadata */
    private int nearBottomCounter;

    /* renamed from: H, reason: from kotlin metadata */
    private final int maxNearCounter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/aisearch/TouchCaptureRecyclerView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(TouchCaptureRecyclerView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.S().invoke(Boolean.FALSE);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1) {
                TouchCaptureRecyclerView.this.c0();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            LinearLayoutManager linearLayoutManager;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (TouchCaptureRecyclerView.this.getCurrentAnswerData() == null) {
                TouchCaptureRecyclerView.this.S().invoke(Boolean.FALSE);
                return;
            }
            ChatAnswerData currentAnswerData = TouchCaptureRecyclerView.this.getCurrentAnswerData();
            boolean z16 = false;
            if (currentAnswerData != null && currentAnswerData.k()) {
                z16 = true;
            }
            if (z16) {
                final TouchCaptureRecyclerView touchCaptureRecyclerView = TouchCaptureRecyclerView.this;
                touchCaptureRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        TouchCaptureRecyclerView.a.e(TouchCaptureRecyclerView.this);
                    }
                }, 500L);
                return;
            }
            RecyclerView.LayoutManager layoutManager = TouchCaptureRecyclerView.this.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null) {
                return;
            }
            if (linearLayoutManager.findLastVisibleItemPosition() == TouchCaptureRecyclerView.this.U() - 1) {
                TouchCaptureRecyclerView.this.W(recyclerView);
            } else {
                TouchCaptureRecyclerView.this.X();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TouchCaptureRecyclerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean O() {
        return !Z();
    }

    private final void P() {
        if (!this.shouldAutoScroll) {
            return;
        }
        smoothScrollToPosition(U());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(RecyclerView recyclerView) {
        Y();
        if (recyclerView.getScrollState() == 1) {
            this.checkShowJumpButton.invoke(Boolean.FALSE);
            a0();
        }
        if (getNearBottomCounter() > this.maxNearCounter) {
            this.checkShowJumpButton.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        this.checkShowJumpButton.invoke(Boolean.FALSE);
        a0();
    }

    private final boolean Z() {
        return !canScrollVertically(U());
    }

    public final void Q() {
        P();
    }

    public final void R() {
        if (O()) {
            P();
        }
    }

    @NotNull
    public final Function1<Boolean, Unit> S() {
        return this.checkShowJumpButton;
    }

    @Nullable
    /* renamed from: T, reason: from getter */
    public final ChatAnswerData getCurrentAnswerData() {
        return this.currentAnswerData;
    }

    public final int U() {
        int i3;
        int coerceAtLeast;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount() - 1;
        } else {
            i3 = 0;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        return coerceAtLeast;
    }

    /* renamed from: V, reason: from getter */
    public final int getNearBottomCounter() {
        return this.nearBottomCounter;
    }

    public final void Y() {
        this.nearBottomCounter++;
    }

    public final void a0() {
        this.nearBottomCounter = 0;
    }

    public final void b0() {
        smoothScrollToPosition(U());
    }

    public final void c0() {
        this.shouldAutoScroll = false;
    }

    public final void d0(@Nullable ChatAnswerData answerData) {
        this.currentAnswerData = answerData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(@Nullable View child, @Nullable View focused) {
        super.requestChildFocus(child, null);
    }

    public final void setCheckShowJumpButton(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.checkShowJumpButton = function1;
    }

    public final void setCurrentAnswerData(@Nullable ChatAnswerData chatAnswerData) {
        this.currentAnswerData = chatAnswerData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TouchCaptureRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TouchCaptureRecyclerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TouchCaptureRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.checkShowJumpButton = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.TouchCaptureRecyclerView$checkShowJumpButton$1
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.maxNearCounter = 5;
        addOnScrollListener(new a());
    }
}

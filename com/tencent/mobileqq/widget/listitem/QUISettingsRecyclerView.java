package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/theme/SkinnableView;", "", "has", "", "setHasTopSpace", "setHasBottomSpace", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView$DividerStyle;", "style", "setDividerStyle", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "onThemeChanged", "Lcom/tencent/mobileqq/widget/listitem/m;", "f", "Lcom/tencent/mobileqq/widget/listitem/m;", "dividerDecoration", "Lcom/tencent/mobileqq/widget/listitem/p;", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/p;", "groupSpaceDecoration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "DividerStyle", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class QUISettingsRecyclerView extends RecyclerView implements SkinnableView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m dividerDecoration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p groupSpaceDecoration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView$DividerStyle;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "Middle", "Hidden", "ShowAll", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public enum DividerStyle {
        Middle(0),
        Hidden(1),
        ShowAll(2);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView$DividerStyle$a;", "", "", "value", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView$DividerStyle;", "a", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView$DividerStyle$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final DividerStyle a(int value) {
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            return DividerStyle.Middle;
                        }
                        return DividerStyle.ShowAll;
                    }
                    return DividerStyle.Hidden;
                }
                return DividerStyle.Middle;
            }

            Companion() {
            }
        }

        DividerStyle(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f316986a;

        static {
            int[] iArr = new int[DividerStyle.values().length];
            try {
                iArr[DividerStyle.Middle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DividerStyle.ShowAll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DividerStyle.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f316986a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISettingsRecyclerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @Nullable
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public QUIListItemAdapter getAdapter() {
        return (QUIListItemAdapter) super.getAdapter();
    }

    public void onThemeChanged() {
        m mVar = this.dividerDecoration;
        if (mVar != null) {
            mVar.d(1000);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        boolean z16;
        if (adapter == null) {
            z16 = true;
        } else {
            z16 = adapter instanceof QUIListItemAdapter;
        }
        if (z16) {
            super.setAdapter(adapter);
            return;
        }
        throw new IllegalStateException("\u53ea\u80fd\u8bbe\u7f6eQUIListItemAdapter\u7c7b\u578b\u7684Adapter");
    }

    public final void setDividerStyle(@NotNull DividerStyle style) {
        RecyclerView.ItemDecoration itemDecoration;
        Intrinsics.checkNotNullParameter(style, "style");
        int i3 = a.f316986a[style.ordinal()];
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 && (itemDecoration = this.dividerDecoration) != null) {
                this.dividerDecoration = null;
                removeItemDecoration(itemDecoration);
                return;
            }
            return;
        }
        if (style != DividerStyle.ShowAll) {
            z16 = false;
        }
        m mVar = this.dividerDecoration;
        if (mVar != null) {
            if (mVar.getShowBottomDivider() != z16) {
                mVar.c(z16);
                requestLayout();
                return;
            }
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m mVar2 = new m(context, z16);
        addItemDecoration(mVar2);
        this.dividerDecoration = mVar2;
    }

    public final void setHasBottomSpace(boolean has) {
        this.groupSpaceDecoration.a(has);
        requestLayout();
    }

    public final void setHasTopSpace(boolean has) {
        this.groupSpaceDecoration.b(has);
        requestLayout();
    }

    public /* synthetic */ QUISettingsRecyclerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISettingsRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        if (getLayoutManager() == null) {
            setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        setItemAnimator(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410084i6);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026.QUISettingsRecyclerView)");
        setDividerStyle(DividerStyle.INSTANCE.a(obtainStyledAttributes.getInt(jj2.b.f410095j6, DividerStyle.Middle.getValue())));
        int i3 = jj2.b.f410106k6;
        p pVar = new p(context, obtainStyledAttributes.getBoolean(i3, true), obtainStyledAttributes.getBoolean(i3, true));
        addItemDecoration(pVar);
        this.groupSpaceDecoration = pVar;
        addItemDecoration(new o());
        obtainStyledAttributes.recycle();
    }
}

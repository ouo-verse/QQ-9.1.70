package com.tencent.qui.quilistitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/qui/quilistitem/QUISettingsRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/theme/SkinnableView;", "", "has", "", "setHasTopSpace", "setHasBottomSpace", "Lcom/tencent/qui/quilistitem/QUISettingsRecyclerView$DividerStyle;", "style", "setDividerStyle", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Lcom/tencent/qui/quilistitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "onThemeChanged", "Lcom/tencent/qui/quilistitem/n;", "f", "Lcom/tencent/qui/quilistitem/n;", "dividerDecoration", "Lcom/tencent/qui/quilistitem/p;", tl.h.F, "Lcom/tencent/qui/quilistitem/p;", "groupSpaceDecoration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "DividerStyle", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public class QUISettingsRecyclerView extends RecyclerView implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private n dividerDecoration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final p groupSpaceDecoration;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qui/quilistitem/QUISettingsRecyclerView$DividerStyle;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "Middle", "Hidden", "ShowAll", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class DividerStyle {
        private static final /* synthetic */ DividerStyle[] $VALUES;
        static IPatchRedirector $redirector_;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final DividerStyle Hidden;
        public static final DividerStyle Middle;
        public static final DividerStyle ShowAll;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qui/quilistitem/QUISettingsRecyclerView$DividerStyle$a;", "", "", "value", "Lcom/tencent/qui/quilistitem/QUISettingsRecyclerView$DividerStyle;", "a", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.qui.quilistitem.QUISettingsRecyclerView$DividerStyle$a, reason: from kotlin metadata */
        /* loaded from: classes25.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }

            @NotNull
            public final DividerStyle a(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return (DividerStyle) iPatchRedirector.redirect((short) 1, (Object) this, value);
                }
                DividerStyle dividerStyle = DividerStyle.Middle;
                dividerStyle.ordinal();
                if (value != dividerStyle.getValue()) {
                    DividerStyle dividerStyle2 = DividerStyle.Hidden;
                    if (value != dividerStyle2.getValue()) {
                        dividerStyle2 = DividerStyle.ShowAll;
                        if (value != dividerStyle2.getValue()) {
                            return dividerStyle;
                        }
                    }
                    return dividerStyle2;
                }
                return dividerStyle;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14728);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            DividerStyle dividerStyle = new DividerStyle("Middle", 0, 0);
            Middle = dividerStyle;
            DividerStyle dividerStyle2 = new DividerStyle("Hidden", 1, 1);
            Hidden = dividerStyle2;
            DividerStyle dividerStyle3 = new DividerStyle("ShowAll", 2, 2);
            ShowAll = dividerStyle3;
            $VALUES = new DividerStyle[]{dividerStyle, dividerStyle2, dividerStyle3};
            INSTANCE = new Companion(null);
        }

        DividerStyle(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static DividerStyle valueOf(String str) {
            return (DividerStyle) Enum.valueOf(DividerStyle.class, str);
        }

        public static DividerStyle[] values() {
            return (DividerStyle[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    @JvmOverloads
    public QUISettingsRecyclerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @Nullable
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public QUIListItemAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (QUIListItemAdapter) super.getAdapter();
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        n nVar = this.dividerDecoration;
        if (nVar != null) {
            nVar.d(1000);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) adapter);
            return;
        }
        if (adapter != null) {
            z16 = adapter instanceof QUIListItemAdapter;
        } else {
            z16 = true;
        }
        if (z16) {
            super.setAdapter(adapter);
            return;
        }
        throw new IllegalStateException("\u53ea\u80fd\u8bbe\u7f6eQUIListItemAdapter\u7c7b\u578b\u7684Adapter");
    }

    public final void setDividerStyle(@NotNull DividerStyle style) {
        RecyclerView.ItemDecoration itemDecoration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) style);
            return;
        }
        Intrinsics.checkNotNullParameter(style, "style");
        int i3 = r.f363816a[style.ordinal()];
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
        n nVar = this.dividerDecoration;
        if (nVar != null) {
            if (nVar.b() != z16) {
                nVar.c(z16);
                requestLayout();
                return;
            }
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        n nVar2 = new n(context, z16);
        addItemDecoration(nVar2);
        Unit unit = Unit.INSTANCE;
        this.dividerDecoration = nVar2;
    }

    public final void setHasBottomSpace(boolean has) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, has);
        } else {
            this.groupSpaceDecoration.a(has);
            requestLayout();
        }
    }

    public final void setHasTopSpace(boolean has) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, has);
        } else {
            this.groupSpaceDecoration.b(has);
            requestLayout();
        }
    }

    public /* synthetic */ QUISettingsRecyclerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISettingsRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        if (getLayoutManager() == null) {
            setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        setItemAnimator(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f363834i0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026.QUISettingsRecyclerView)");
        setDividerStyle(DividerStyle.INSTANCE.a(obtainStyledAttributes.getInt(s.f363836j0, DividerStyle.Middle.getValue())));
        int i3 = s.f363838k0;
        p pVar = new p(context, obtainStyledAttributes.getBoolean(i3, true), obtainStyledAttributes.getBoolean(i3, true));
        addItemDecoration(pVar);
        Unit unit = Unit.INSTANCE;
        this.groupSpaceDecoration = pVar;
        addItemDecoration(new o());
        obtainStyledAttributes.recycle();
    }
}

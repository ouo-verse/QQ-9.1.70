package com.tencent.qui.quilistitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qui.quilistitem.Group;
import com.tencent.qui.quilistitem.h;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u0006*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0014B\u0007\u00a2\u0006\u0004\bI\u0010%J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0004R(\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u0014\u0010\u001f\u0012\u0004\b$\u0010%\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010-\u001a\u00020'8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u0001058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b6\u00108\"\u0004\b9\u0010:R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010<8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010DR*\u0010H\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001c8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010/\u001a\u0004\b.\u00101\"\u0004\bG\u00103\u00a8\u0006J"}, d2 = {"Lcom/tencent/qui/quilistitem/a;", "Lcom/tencent/qui/quilistitem/h;", "VH", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, tl.h.F, "(Landroid/view/ViewGroup;)Lcom/tencent/qui/quilistitem/h;", "viewHolder", "", "position", "", "payloads", "", "g", "(Lcom/tencent/qui/quilistitem/h;ILjava/util/List;)V", "i", "(Lcom/tencent/qui/quilistitem/h;)V", "Lcom/tencent/qui/quilistitem/QUIListItemStyle;", "listItemStyle", "a", "(Lcom/tencent/qui/quilistitem/QUIListItemStyle;Lcom/tencent/qui/quilistitem/h;ILjava/util/List;)V", "Lcom/tencent/qui/quilistitem/Group$b;", "outMargin", "b", "(Lcom/tencent/qui/quilistitem/h;Lcom/tencent/qui/quilistitem/Group$b;)V", "Landroid/view/View;", "view", "", "enable", "j", "I", "f", "()I", "setThemeId", "(I)V", "getThemeId$annotations", "()V", "themeId", "Lcom/tencent/qui/quilistitem/Group$PositionType;", "Lcom/tencent/qui/quilistitem/Group$PositionType;", "e", "()Lcom/tencent/qui/quilistitem/Group$PositionType;", "setPositionInGroup$QUIListItem_debug", "(Lcom/tencent/qui/quilistitem/Group$PositionType;)V", "positionInGroup", "c", "Z", "isVisible$QUIListItem_debug", "()Z", "setVisible$QUIListItem_debug", "(Z)V", "isVisible", "Lcom/tencent/qui/quilistitem/Group;", "d", "Lcom/tencent/qui/quilistitem/Group;", "()Lcom/tencent/qui/quilistitem/Group;", "setGroup$QUIListItem_debug", "(Lcom/tencent/qui/quilistitem/Group;)V", VipFunCallConstants.KEY_GROUP, "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getViewRef$QUIListItem_debug", "()Ljava/lang/ref/WeakReference;", "setViewRef$QUIListItem_debug", "(Ljava/lang/ref/WeakReference;)V", "viewRef", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "onClickListener", "value", "setEnabled", NodeProps.ENABLED, "<init>", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public abstract class a<VH extends h> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int themeId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group.PositionType positionInGroup;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isVisible;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group group;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> viewRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onClickListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean enabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qui/quilistitem/a$a;", "", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quilistitem.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.themeId = 1000;
        this.positionInGroup = Group.PositionType.Other;
        this.isVisible = true;
        this.enabled = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(@NotNull QUIListItemStyle listItemStyle, @NotNull VH viewHolder, int position, @NotNull List<? extends Object> payloads) {
        View view;
        QUIListItemBackgroundType qUIListItemBackgroundType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, listItemStyle, viewHolder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(listItemStyle, "listItemStyle");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
        if (view2 instanceof q) {
            ((q) view2).setStyle(listItemStyle);
        } else {
            int i3 = b.f363779a[listItemStyle.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    v.f(view2, 0);
                }
            } else {
                v.f(view2, view2.getResources().getDimensionPixelSize(R.dimen.d_z));
            }
        }
        WeakReference<View> weakReference = this.viewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != view2) {
            this.viewRef = new WeakReference<>(view2);
        }
        view2.setOnClickListener(this.onClickListener);
        if (this.onClickListener == null) {
            view2.setClickable(false);
        }
        j(view2, this.enabled);
        int i16 = b.f363781c[listItemStyle.ordinal()];
        if (i16 != 1) {
            if (i16 == 2) {
                if (this.positionInGroup == Group.PositionType.Other) {
                    qUIListItemBackgroundType = QUIListItemBackgroundType.None;
                } else {
                    qUIListItemBackgroundType = QUIListItemBackgroundType.FullWidth;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i17 = b.f363780b[this.positionInGroup.ordinal()];
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 4) {
                            if (i17 == 5) {
                                qUIListItemBackgroundType = QUIListItemBackgroundType.None;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
                        }
                    } else {
                        qUIListItemBackgroundType = QUIListItemBackgroundType.BottomRound;
                    }
                } else {
                    qUIListItemBackgroundType = QUIListItemBackgroundType.TopRound;
                }
            } else {
                qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
            }
        }
        if (view2 instanceof l) {
            ((l) view2).setBackgroundType(qUIListItemBackgroundType);
        } else {
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view2.setBackground(qUIListItemBackgroundType.getBackground(context, this.themeId));
        }
        g(viewHolder, position, payloads);
    }

    public void b(@NotNull VH viewHolder, @NotNull Group.b outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) viewHolder, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.da8);
        outMargin.c(dimensionPixelSize);
        outMargin.d(dimensionPixelSize);
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.enabled;
    }

    @Nullable
    public final Group d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Group) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.group;
    }

    @NotNull
    public final Group.PositionType e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group.PositionType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.positionInGroup;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.themeId;
    }

    public abstract void g(@NotNull VH viewHolder, int position, @NotNull List<? extends Object> payloads);

    @NotNull
    public abstract VH h(@NotNull ViewGroup parent);

    public final void i(@NotNull VH viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullExpressionValue(viewHolder.itemView, "viewHolder.itemView");
        }
    }

    protected final void j(@NotNull View view, boolean enable) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, view, Boolean.valueOf(enable));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (enable) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        view.setAlpha(f16);
        view.setEnabled(enable);
    }
}

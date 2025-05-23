package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\ba\u0010\bJ\u0006\u0010\u0005\u001a\u00020\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0004J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0004J5\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fJ\"\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#J\u001f\u0010)\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010(\u001a\u00020'H\u0010\u00a2\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00028\u00002\u0006\u0010,\u001a\u00020+H&\u00a2\u0006\u0004\b-\u0010.J-\u0010/\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H&\u00a2\u0006\u0004\b/\u00100R\"\u00107\u001a\u0002018\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010>\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010E\u001a\u0004\u0018\u00010?8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010M\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\bF\u0010G\u0012\u0004\bL\u0010\b\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010VR*\u0010[\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u00109\u001a\u0004\bF\u0010;\"\u0004\bZ\u0010=R*\u0010]\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00109\u001a\u0004\bO\u0010;\"\u0004\b\\\u0010=R\u0013\u0010\n\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010^R$\u0010`\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u0010;\"\u0004\b_\u0010=\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/e;", "VH", "", "", "k", "", "B", "()V", "Landroid/view/View;", "view", "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isGrayed", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;", "listItemStyle", "viewHolder", "", "position", "", "payloads", "a", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;Lcom/tencent/mobileqq/widget/listitem/e;ILjava/util/List;)V", "o", "(Lcom/tencent/mobileqq/widget/listitem/e;)V", "Landroid/view/View$OnClickListener;", "listener", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/widget/listitem/g;", "w", "Lcom/tencent/mobileqq/widget/listitem/f;", "v", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/widget/listitem/DataObserver;", "l", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "c", "(Lcom/tencent/mobileqq/widget/listitem/e;Lcom/tencent/mobileqq/widget/listitem/Group$c;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "(Landroid/view/ViewGroup;)Lcom/tencent/mobileqq/widget/listitem/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/widget/listitem/e;ILjava/util/List;)V", "Lcom/tencent/mobileqq/widget/listitem/Group$PositionType;", "Lcom/tencent/mobileqq/widget/listitem/Group$PositionType;", "g", "()Lcom/tencent/mobileqq/widget/listitem/Group$PositionType;", "y", "(Lcom/tencent/mobileqq/widget/listitem/Group$PositionType;)V", "positionInGroup", "b", "Z", "j", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "isVisible", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "f", "()Lcom/tencent/mobileqq/widget/listitem/Group;", "u", "(Lcom/tencent/mobileqq/widget/listitem/Group;)V", VipFunCallConstants.KEY_GROUP, "d", "I", tl.h.F, "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(I)V", "getThemeId$annotations", "themeId", "Ljava/lang/ref/WeakReference;", "e", "Ljava/lang/ref/WeakReference;", "viewRef", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/mobileqq/widget/listitem/g;", "onBindViewListener", "Lcom/tencent/mobileqq/widget/listitem/f;", "onAttachViewListener", "value", "i", "r", NodeProps.ENABLED, "t", "grayed", "()Landroid/view/View;", "p", "configVisible", "<init>", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class a<VH extends e> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group group;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> viewRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onClickListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g onBindViewListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f onAttachViewListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean grayed;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group.PositionType positionInGroup = Group.PositionType.Other;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isVisible = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int themeId = 1000;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean enabled = true;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.widget.listitem.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public /* synthetic */ class C8991a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f316997a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f316998b;

        static {
            int[] iArr = new int[QUIListItemStyle.values().length];
            try {
                iArr[QUIListItemStyle.Card.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QUIListItemStyle.FullWidth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f316997a = iArr;
            int[] iArr2 = new int[Group.PositionType.values().length];
            try {
                iArr2[Group.PositionType.Only.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Group.PositionType.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Group.PositionType.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Group.PositionType.Middle.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Group.PositionType.Other.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            f316998b = iArr2;
        }
    }

    public final void A(boolean z16) {
        this.isVisible = z16;
    }

    public final void B() {
        View i3 = i();
        if (i3 == null) {
            return;
        }
        if (this.enabled) {
            if (this.grayed) {
                s(i3, true);
                return;
            } else {
                q(i3, true);
                return;
            }
        }
        q(i3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(@NotNull QUIListItemStyle listItemStyle, @NotNull VH viewHolder, int position, @NotNull List<? extends Object> payloads) {
        QUIListItemBackgroundType qUIListItemBackgroundType;
        Intrinsics.checkNotNullParameter(listItemStyle, "listItemStyle");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        if (view instanceof q) {
            ((q) view).setStyle(listItemStyle);
        } else {
            int i3 = C8991a.f316997a[listItemStyle.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    ab.e(view, 0);
                }
            } else {
                ab.e(view, view.getResources().getDimensionPixelSize(R.dimen.d_z));
            }
        }
        if (i() != view) {
            this.viewRef = new WeakReference<>(view);
        }
        view.setOnClickListener(this.onClickListener);
        if (this.onClickListener == null) {
            view.setClickable(false);
        }
        B();
        int i16 = C8991a.f316997a[listItemStyle.ordinal()];
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
            int i17 = C8991a.f316998b[this.positionInGroup.ordinal()];
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
        if (view instanceof l) {
            ((l) view).setBackgroundType(qUIListItemBackgroundType);
        } else {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view.setBackground(qUIListItemBackgroundType.getBackground(context, this.themeId));
        }
        m(viewHolder, position, payloads);
        g gVar = this.onBindViewListener;
        if (gVar != null) {
            gVar.M(view);
        }
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public void c(@NotNull VH viewHolder, @NotNull Group.c outMargin) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        int dimensionPixelSize = viewHolder.itemView.getResources().getDimensionPixelSize(R.dimen.da8);
        outMargin.c(dimensionPixelSize);
        outMargin.d(dimensionPixelSize);
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getGrayed() {
        return this.grayed;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Group getGroup() {
        return this.group;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final Group.PositionType getPositionInGroup() {
        return this.positionInGroup;
    }

    /* renamed from: h, reason: from getter */
    public final int getThemeId() {
        return this.themeId;
    }

    @Nullable
    public final View i() {
        WeakReference<View> weakReference = this.viewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean j() {
        return this.isVisible;
    }

    public final boolean k() {
        Group group = this.group;
        if (group != null) {
            return group.b(this);
        }
        return false;
    }

    @NotNull
    public final DataObserver<a<VH>> l(@NotNull LifecycleOwner lifeCycleOwner, @NotNull QUIListItemAdapter adapter) {
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new DataObserver<>(lifeCycleOwner, adapter, this);
    }

    public abstract void m(@NotNull VH viewHolder, int position, @NotNull List<? extends Object> payloads);

    @NotNull
    public abstract VH n(@NotNull ViewGroup parent);

    public final void o(@NotNull VH viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        f fVar = this.onAttachViewListener;
        if (fVar != null) {
            fVar.a(view);
        }
    }

    public final void p(boolean z16) {
        this.isVisible = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void q(@NotNull View view, boolean enable) {
        Intrinsics.checkNotNullParameter(view, "view");
        s(view, !enable);
        if (view instanceof n) {
            ((n) view).setEnableState(this.enabled);
        } else {
            view.setEnabled(enable);
        }
    }

    public final void r(boolean z16) {
        if (z16 == this.enabled) {
            return;
        }
        this.enabled = z16;
        View i3 = i();
        if (i3 != null) {
            q(i3, z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void s(@NotNull View view, boolean isGrayed) {
        float f16;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof n) {
            ((n) view).setGrayState(isGrayed);
            return;
        }
        if (isGrayed) {
            f16 = 0.5f;
        } else {
            f16 = 1.0f;
        }
        view.setAlpha(f16);
    }

    public final void t(boolean z16) {
        if (z16 == this.grayed) {
            return;
        }
        this.grayed = z16;
        View i3 = i();
        if (i3 != null) {
            s(i3, z16);
        }
    }

    public final void u(@Nullable Group group) {
        this.group = group;
    }

    @NotNull
    public final a<VH> v(@Nullable f listener) {
        this.onAttachViewListener = listener;
        return this;
    }

    @NotNull
    public final a<VH> w(@Nullable g listener) {
        this.onBindViewListener = listener;
        return this;
    }

    @NotNull
    public final a<VH> x(@Nullable View.OnClickListener listener) {
        this.onClickListener = listener;
        return this;
    }

    public final void y(@NotNull Group.PositionType positionType) {
        Intrinsics.checkNotNullParameter(positionType, "<set-?>");
        this.positionInGroup = positionType;
    }

    public final void z(int i3) {
        this.themeId = i3;
    }
}

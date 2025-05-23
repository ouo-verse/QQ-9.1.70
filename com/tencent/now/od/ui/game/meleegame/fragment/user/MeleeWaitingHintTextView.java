package com.tencent.now.od.ui.game.meleegame.fragment.user;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/od/ui/game/meleegame/fragment/user/MeleeWaitingHintTextView;", "Landroid/widget/TextView;", "", "a", "b", "c", "Lcom/tencent/now/od/ui/game/meleegame/fragment/user/MeleeWaitingHintTextView$HintType;", "type", IECSearchBar.METHOD_SET_HINT, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "HintType", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MeleeWaitingHintTextView extends TextView {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/od/ui/game/meleegame/fragment/user/MeleeWaitingHintTextView$HintType;", "", "(Ljava/lang/String;I)V", "LIST_IS_EMPTY", "LIST_IS_NOT_EMPTY", "LIST_SELF_HAS_JOINED", "qq-live-od-ui-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public enum HintType {
        LIST_IS_EMPTY,
        LIST_IS_NOT_EMPTY,
        LIST_SELF_HAS_JOINED
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f338559a;

        static {
            int[] iArr = new int[HintType.values().length];
            try {
                iArr[HintType.LIST_IS_EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HintType.LIST_IS_NOT_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HintType.LIST_SELF_HAS_JOINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f338559a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeWaitingHintTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        setText("\u865a\u4f4d\u4ee5\u5f85");
        setTextColor(getContext().getColor(R.color.f156800b93));
        setVisibility(0);
    }

    private final void b() {
        setVisibility(4);
    }

    private final void c() {
        setText("\u5019\u573a\u4e2d...");
        setTextColor(-1);
        setVisibility(0);
    }

    public final void setHint(@NotNull HintType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = a.f338559a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    c();
                    return;
                }
                return;
            }
            b();
            return;
        }
        a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeWaitingHintTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MeleeWaitingHintTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MeleeWaitingHintTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

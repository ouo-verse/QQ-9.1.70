package com.tencent.mobileqq.flock.repeat.part;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R8\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/part/FlockRepeatTypePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/ViewGroup;", "viewGroup", "", "B9", "Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "type", "z9", "A9", "Lcom/tencent/mobileqq/widget/listitem/h;", "F9", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/collection/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "d", "Landroidx/collection/ArrayMap;", "typeToItems", "Lcom/tencent/mobileqq/flock/repeat/b;", "e", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/flock/repeat/b;", "viewModel", "", "f", "C9", "()I", "dividerHeight", h.F, "D9", "dividerMarginLeft", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockRepeatTypePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayMap<FlockRepeatType, Pair<QUISingleLineListItem, x<x.b, x.c>>> typeToItems;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dividerHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dividerMarginLeft;

    public FlockRepeatTypePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.typeToItems = new ArrayMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.repeat.b>() { // from class: com.tencent.mobileqq.flock.repeat.part.FlockRepeatTypePart$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockRepeatTypePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.flock.repeat.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.flock.repeat.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FlockRepeatTypePart flockRepeatTypePart = FlockRepeatTypePart.this;
                Intent intent = flockRepeatTypePart.getActivity().getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                return com.tencent.mobileqq.flock.publish.a.d(flockRepeatTypePart, intent);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(FlockRepeatTypePart$dividerHeight$2.INSTANCE);
        this.dividerHeight = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(FlockRepeatTypePart$dividerMarginLeft$2.INSTANCE);
        this.dividerMarginLeft = lazy3;
    }

    private final void A9(FlockRepeatType type, ViewGroup viewGroup) {
        boolean z16;
        x.b.d dVar = new x.b.d(type.getContent());
        if (E9().S1() == type) {
            z16 = true;
        } else {
            z16 = false;
        }
        x<x.b, x.c> xVar = new x<>(dVar, new x.c.i(z16, F9(type)));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null, 2, null);
        qUISingleLineListItem.setConfig(xVar);
        qUISingleLineListItem.setStyle(QUIListItemStyle.FullWidth);
        viewGroup.addView(qUISingleLineListItem, new ViewGroup.LayoutParams(-1, -2));
        this.typeToItems.put(type, new Pair<>(qUISingleLineListItem, xVar));
    }

    private final void B9(ViewGroup viewGroup) {
        viewGroup.addView(new Space(getContext()), new ViewGroup.LayoutParams(0, ViewUtils.dpToPx(12.0f)));
        for (FlockRepeatType flockRepeatType : FlockRepeatType.values()) {
            A9(flockRepeatType, viewGroup);
            z9(flockRepeatType, viewGroup);
        }
    }

    private final int C9() {
        return ((Number) this.dividerHeight.getValue()).intValue();
    }

    private final int D9() {
        return ((Number) this.dividerMarginLeft.getValue()).intValue();
    }

    private final com.tencent.mobileqq.flock.repeat.b E9() {
        return (com.tencent.mobileqq.flock.repeat.b) this.viewModel.getValue();
    }

    private final com.tencent.mobileqq.widget.listitem.h F9(final FlockRepeatType type) {
        return new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.flock.repeat.part.e
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                FlockRepeatTypePart.G9(FlockRepeatTypePart.this, type, view, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(FlockRepeatTypePart this$0, FlockRepeatType type, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        if (z16) {
            this$0.E9().W1(type);
            if (type == FlockRepeatType.NONE) {
                this$0.E9().U1(null);
            }
        }
        this$0.H9();
    }

    private final void H9() {
        boolean z16;
        for (Map.Entry<FlockRepeatType, Pair<QUISingleLineListItem, x<x.b, x.c>>> entry : this.typeToItems.entrySet()) {
            FlockRepeatType type = entry.getKey();
            QUISingleLineListItem first = entry.getValue().getFirst();
            x<x.b, x.c> second = entry.getValue().getSecond();
            if (E9().S1() == type) {
                z16 = true;
            } else {
                z16 = false;
            }
            Intrinsics.checkNotNullExpressionValue(type, "type");
            second.U(new x.c.i(z16, F9(type)));
            first.setConfig(second);
        }
    }

    private final void z9(FlockRepeatType type, ViewGroup viewGroup) {
        if (type == FlockRepeatType.MONTH) {
            return;
        }
        View view = new View(getContext());
        view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.qui_common_border_standard_bg));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, C9());
        marginLayoutParams.setMargins(D9(), 0, 0, 0);
        Unit unit = Unit.INSTANCE;
        viewGroup.addView(view, marginLayoutParams);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        B9((ViewGroup) rootView);
    }
}

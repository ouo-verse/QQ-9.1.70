package com.tencent.mobileqq.aio.panel.photo;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.panel.photo.g;
import com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001/B#\u0012\u0006\u0010,\u001a\u00020'\u0012\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\t0-\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016JJ\u0010\u0014\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JR\u0010\u0017\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0016J \u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0006H\u0016J \u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R#\u00103\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\t0-8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/f;", "Lcom/tencent/mobileqq/aio/panel/photo/widget/ItemSwipeSendDecoration$c;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "f", "direction", "", "r", "Landroid/graphics/Canvas;", "c", "", "dX", "dY", "initialTouchY", "actionState", "", "isCurrentlyActive", DomainData.DOMAIN_NAME, "animationType", "fraction", "o", "j", "initialTouchX", "g", "animateDx", "animateDy", "", "d", "mDy", "mRecyclerView", "inputBarHeight", "i", "mInitialTouchX", "prevSelected", tl.h.F, "e", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;", "a", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;", "getRvAdapter", "()Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;", "rvAdapter", "Lkotlin/Function1;", "Lat/c;", "b", "Lkotlin/jvm/functions/Function1;", "getSendIntent", "()Lkotlin/jvm/functions/Function1;", "sendIntent", "Z", "swipedEnable", "<init>", "(Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;Lkotlin/jvm/functions/Function1;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends ItemSwipeSendDecoration.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f193090e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PhotoPanelAdapter rvAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<at.c, Unit> sendIntent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean swipedEnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/panel/photo/f$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/f$b;", "", "com/tencent/mobileqq/aio/panel/photo/f$a", "roundOutline", "Lcom/tencent/mobileqq/aio/panel/photo/f$a;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.photo.f$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            f193090e = new a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull PhotoPanelAdapter rvAdapter, @NotNull Function1<? super at.c, Unit> sendIntent) {
        Intrinsics.checkNotNullParameter(rvAdapter, "rvAdapter");
        Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rvAdapter, (Object) sendIntent);
            return;
        }
        this.rvAdapter = rvAdapter;
        this.sendIntent = sendIntent;
        this.swipedEnable = true;
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public long d(@NotNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, this, recyclerView, Integer.valueOf(animationType), Float.valueOf(animateDx), Float.valueOf(animateDy))).longValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        return 300L;
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        g.d dVar = g.d.f193098d;
        this.sendIntent.invoke(dVar);
        return dVar.a();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public int f(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) recyclerView, (Object) viewHolder)).intValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemSwipeSendDecoration.c.l(0, 1);
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public float g(float initialTouchX, float initialTouchY, @NotNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, this, Float.valueOf(initialTouchX), Float.valueOf(initialTouchY), viewHolder)).floatValue();
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return initialTouchY / viewHolder.itemView.getHeight();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public float h(float mInitialTouchX, @NotNull RecyclerView mRecyclerView, @NotNull RecyclerView.ViewHolder prevSelected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, this, Float.valueOf(mInitialTouchX), mRecyclerView, prevSelected)).floatValue();
        }
        Intrinsics.checkNotNullParameter(mRecyclerView, "mRecyclerView");
        Intrinsics.checkNotNullParameter(prevSelected, "prevSelected");
        Resources resources = mRecyclerView.getResources();
        int i3 = resources.getDisplayMetrics().widthPixels;
        float x16 = prevSelected.itemView.getX();
        int width = prevSelected.itemView.getWidth();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158194bz1);
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.bzr);
        return ((((i3 - x16) - width) - dimensionPixelSize) - dimensionPixelSize2) - dimensionPixelSize2;
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public float i(float mDy, @NotNull RecyclerView mRecyclerView, int inputBarHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, this, Float.valueOf(mDy), mRecyclerView, Integer.valueOf(inputBarHeight))).floatValue();
        }
        Intrinsics.checkNotNullParameter(mRecyclerView, "mRecyclerView");
        return Math.signum(mDy) * (mRecyclerView.getHeight() + ((int) mRecyclerView.getResources().getDimension(R.dimen.c0t)) + inputBarHeight);
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.swipedEnable;
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public void n(@NotNull Canvas c16, @NotNull RecyclerView recyclerView, @Nullable RecyclerView.ViewHolder viewHolder, float dX, float dY, float initialTouchY, int actionState, boolean isCurrentlyActive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, c16, recyclerView, viewHolder, Float.valueOf(dX), Float.valueOf(dY), Float.valueOf(initialTouchY), Integer.valueOf(actionState), Boolean.valueOf(isCurrentlyActive));
            return;
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.sendIntent.invoke(new g.c(isCurrentlyActive, Math.abs(dY) / initialTouchY));
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public void o(@Nullable Canvas c16, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, int animationType, float fraction, boolean isCurrentlyActive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, c16, recyclerView, viewHolder, Float.valueOf(dX), Float.valueOf(dY), Integer.valueOf(actionState), Integer.valueOf(animationType), Float.valueOf(fraction), Boolean.valueOf(isCurrentlyActive));
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.o(c16, recyclerView, viewHolder, dX, dY, actionState, animationType, fraction, isCurrentlyActive);
        if (animationType == 2) {
            this.swipedEnable = false;
            View view = viewHolder.itemView;
            double d16 = 1;
            double d17 = fraction;
            view.setAlpha((float) (d16 - (0.5d * d17)));
            float f16 = (float) (d16 - (d17 * 0.3d));
            view.setScaleX(f16);
            view.setScaleY(f16);
            view.setClipToOutline(true);
            view.setOutlineProvider(f193090e);
        }
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration.c
    public void r(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, direction);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.sendIntent.invoke(new g.h(((r) viewHolder).r(), false, 2, null));
        PhotoPanelAdapter photoPanelAdapter = this.rvAdapter;
        if (photoPanelAdapter != null) {
            photoPanelAdapter.notifyDataSetChanged();
        }
        this.swipedEnable = true;
    }
}

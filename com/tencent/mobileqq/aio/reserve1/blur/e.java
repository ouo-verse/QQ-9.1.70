package com.tencent.mobileqq.aio.reserve1.blur;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.reserve1.blur.TopBlurUIState;
import com.tencent.mobileqq.aio.reserve1.blur.c;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.x;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u001c\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\"#B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/e;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/reserve1/blur/c;", "Lcom/tencent/mobileqq/aio/reserve1/blur/TopBlurUIState;", "Lcom/tencent/mvi/base/route/g;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "enableBlur", "Landroid/graphics/drawable/Drawable;", "drawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "show", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "Lcom/tencent/mobileqq/aio/reserve1/blur/e$b;", "e", "Lcom/tencent/mobileqq/aio/reserve1/blur/e$b;", "mBlurFetcher", "com/tencent/mobileqq/aio/reserve1/blur/e$c", "f", "Lcom/tencent/mobileqq/aio/reserve1/blur/e$c;", "mAction", "<init>", "(Lcom/tencent/mobileqq/aio/reserve1/blur/e$b;)V", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class e extends com.tencent.qqnt.aio.baseVM.a<com.tencent.mobileqq.aio.reserve1.blur.c, TopBlurUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mBlurFetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mAction;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/e$a;", "Lcom/tencent/qui/quiblurview/f$b;", "", "b", "a", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "Landroid/view/View;", "getBlurView", "()Landroid/view/View;", "blurView", "", "c", "J", "lastPreDrawTime", "d", "preDrawInterval", "e", "Z", "enableFilter", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView recyclerView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View blurView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long lastPreDrawTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long preDrawInterval;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean enableFilter;

        public a(@NotNull RecyclerView recyclerView, @NotNull View blurView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(blurView, "blurView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) blurView);
                return;
            }
            this.recyclerView = recyclerView;
            this.blurView = blurView;
            this.preDrawInterval = 100L;
            this.enableFilter = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_top_blur_8996_117868909", true);
        }

        private final boolean b() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.lastPreDrawTime <= this.preDrawInterval) {
                return true;
            }
            this.lastPreDrawTime = elapsedRealtime;
            return false;
        }

        @Override // com.tencent.qui.quiblurview.f.b
        public boolean a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this.enableFilter && b()) {
                return false;
            }
            Sequence<View> children = ViewGroupKt.getChildren(this.recyclerView);
            int bottom = this.blurView.getBottom();
            for (View view : children) {
                if (view.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (view.isDirty()) {
                        return true;
                    }
                    if (view.getBottom() >= bottom) {
                        break;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/e$b;", "", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {
        @NotNull
        QQBlurViewWrapper a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/blur/e$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                e.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    public e(@NotNull b mBlurFetcher) {
        Intrinsics.checkNotNullParameter(mBlurFetcher, "mBlurFetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mBlurFetcher);
        } else {
            this.mBlurFetcher = mBlurFetcher;
            this.mAction = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOBackgroundMsgIntent.ImmersiveChangeMsg) {
            m(false, null);
            return;
        }
        AIOUtil aIOUtil = AIOUtil.f194084a;
        if (!aIOUtil.b((com.tencent.aio.api.runtime.a) getMContext())) {
            return;
        }
        if (intent instanceof AIOMsgListEvent.TopLayoutHeightChange) {
            updateUI(new TopBlurUIState.UpdateBlurHeight(((AIOMsgListEvent.TopLayoutHeightChange) intent).a()));
        } else if (intent instanceof FullBackgroundMviIntent.AIOBackgroundDrawable) {
            m(aIOUtil.b((com.tencent.aio.api.runtime.a) getMContext()), ((FullBackgroundMviIntent.AIOBackgroundDrawable) intent).a());
        } else if (intent instanceof ThemeEvent.PostThemeChanged) {
            updateUI(TopBlurUIState.PostThemeChange.f193217d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(boolean enableBlur, Drawable drawable) {
        z.b bVar;
        if (!enableBlur) {
            updateUI(TopBlurUIState.HideBlurView.f193216d);
            return;
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.TopBlurEvent.f188406d);
        if (k3 instanceof z.b) {
            bVar = (z.b) k3;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            QLog.i(FrameworkVM.TAG, 1, "[handleBackgroundDrawable]: getBlurView result is null");
            return;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        if (drawable != null) {
            arrayList.add(drawable);
        }
        QQBlurViewWrapper a16 = this.mBlurFetcher.a();
        arrayList.add(bVar.b());
        f.d dVar = new f.d(null, null, 3, null);
        dVar.d(bVar.a());
        dVar.c(new a(bVar.b(), a16));
        this.mBlurFetcher.a().setBlurSource(bVar.b(), arrayList, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        if (!AIOUtil.f194084a.b((com.tencent.aio.api.runtime.a) getMContext())) {
            return;
        }
        p(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(boolean show) {
        z.b bVar;
        int i3;
        if (show) {
            k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.TopBlurEvent.f188406d);
            if (k3 instanceof z.b) {
                bVar = (z.b) k3;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                QLog.i(FrameworkVM.TAG, 1, "[handleTopBlurIntent]: getBlurView result is null");
                return;
            }
            QQBlurViewWrapper a16 = this.mBlurFetcher.a();
            a16.setDebugTag("TopBlurVM");
            f.d dVar = new f.d(null, null, 3, null);
            dVar.d(bVar.a());
            dVar.c(new a(bVar.b(), a16));
            a16.setBlurSource(bVar.b(), null, dVar);
            if (((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_is_scale_chat")) {
                i3 = (int) MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.dbx);
            } else if (ImmersiveUtils.isSupporImmersive() == 1) {
                i3 = ImmersiveUtils.getStatusBarHeight(bVar.b().getContext());
            } else {
                i3 = 0;
            }
            updateUI(new TopBlurUIState.ShowBlurView(x.a(50.0f) + i3));
            return;
        }
        updateUI(TopBlurUIState.HideBlurView.f193216d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.TopLayoutHeightChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.AIOBackgroundDrawable");
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.ImmersiveChangeMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.aio.reserve1.blur.c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            n();
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            r();
            super.onDestroy();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        q();
    }
}

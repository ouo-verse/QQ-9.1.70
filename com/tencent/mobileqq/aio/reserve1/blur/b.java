package com.tencent.mobileqq.aio.reserve1.blur;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurUIState;
import com.tencent.mobileqq.aio.reserve1.blur.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000b*\u0001+\b\u0007\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0003234B\u0017\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010 \u001a\u00020\b\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/b;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "Lcom/tencent/mobileqq/aio/reserve1/blur/a;", "Lcom/tencent/mobileqq/aio/reserve1/blur/BottomBlurUIState;", "Lcom/tencent/mvi/base/route/g;", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "height", "t", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "enableBlur", "Landroid/graphics/drawable/Drawable;", "drawable", DomainData.DOMAIN_NAME, "isShotMode", "p", "show", "o", "r", "v", "w", "u", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "initMsgIntent", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/reserve1/blur/b$c;", "f", "Lcom/tencent/mobileqq/aio/reserve1/blur/b$c;", "mBlurFetcher", h.F, "I", "updatedBlurBarHeight", "com/tencent/mobileqq/aio/reserve1/blur/b$d", "i", "Lcom/tencent/mobileqq/aio/reserve1/blur/b$d;", "mAction", "<init>", "(Lcom/tencent/mobileqq/aio/reserve1/blur/b$c;Lcom/tencent/mvi/base/route/MsgIntent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class b extends com.tencent.qqnt.aio.lazy.lazyInit.b<a, BottomBlurUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mBlurFetcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int updatedBlurBarHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/b$a;", "", "", "DEFAULT_BLUR_HEIGHT_DP", UserInfo.SEX_FEMALE, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.blur.b$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/b$b;", "Lcom/tencent/qui/quiblurview/f$b;", "", "b", "a", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "Landroid/view/View;", "getBlurView", "()Landroid/view/View;", "blurView", "", "c", "J", "lastPreDrawTime", "d", "preDrawInterval", "e", "Z", "enableFilter", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.blur.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7346b implements f.b {
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

        public C7346b(@NotNull RecyclerView recyclerView, @NotNull View blurView) {
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
            this.enableFilter = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_bottom_blur_8996_117868909", true);
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
            int top = this.blurView.getTop();
            for (int childCount = this.recyclerView.getChildCount() - 1; -1 < childCount; childCount--) {
                View view = ViewGroupKt.get(this.recyclerView, childCount);
                if (view.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (view.isDirty()) {
                        return true;
                    }
                    if (view.getTop() < top) {
                        break;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/b$c;", "", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface c {
        @NotNull
        QQBlurViewWrapper a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/reserve1/blur/b$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                b.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull c mBlurFetcher, @NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Intrinsics.checkNotNullParameter(mBlurFetcher, "mBlurFetcher");
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mBlurFetcher, (Object) initMsgIntent);
            return;
        }
        this.mBlurFetcher = mBlurFetcher;
        this.updatedBlurBarHeight = x.a(88.0f);
        this.mAction = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(MsgIntent intent) {
        if (intent instanceof BottomBlurMsgIntent.BottomLayoutHeightChange) {
            t(((BottomBlurMsgIntent.BottomLayoutHeightChange) intent).a());
            return;
        }
        if (intent instanceof BottomBlurMsgIntent.LongShotModeChangeEvent) {
            p(((BottomBlurMsgIntent.LongShotModeChangeEvent) intent).a());
            return;
        }
        if (intent instanceof BottomBlurMsgIntent.AIOBackgroundDrawable) {
            n(AIOUtil.f194084a.b((com.tencent.aio.api.runtime.a) getMContext()), ((BottomBlurMsgIntent.AIOBackgroundDrawable) intent).a());
            return;
        }
        if (intent instanceof AIOBackgroundMsgIntent.ImmersiveChangeMsg) {
            n(false, null);
            return;
        }
        if (intent instanceof InputEvent.AIOBottomBlurShow) {
            q(true);
        } else if (intent instanceof InputEvent.AIOBottomBlurHide) {
            q(false);
        } else if (intent instanceof ThemeEvent.PostThemeChanged) {
            q(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(boolean enableBlur, Drawable drawable) {
        if (!enableBlur) {
            if (QLog.isColorLevel()) {
                QLog.d(FrameworkVM.TAG, 2, "handleBackgroundDrawable !enableBlur");
            }
            o(false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(FrameworkVM.TAG, 2, "handleBackgroundDrawable enableBlur=" + enableBlur);
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.BottomBlurEvent.f188279d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.MsgListResult.GetBlurRecyclerView");
        z.b bVar = (z.b) k3;
        ArrayList<Object> arrayList = new ArrayList<>();
        if (drawable != null) {
            arrayList.add(drawable);
        }
        QQBlurViewWrapper a16 = this.mBlurFetcher.a();
        arrayList.add(bVar.b());
        f.d dVar = new f.d(null, null, 3, null);
        dVar.d(bVar.a());
        dVar.c(new C7346b(bVar.b(), a16));
        this.mBlurFetcher.a().setBlurSource(bVar.b(), arrayList, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(boolean show) {
        int a16;
        if (show) {
            k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.BottomBlurEvent.f188279d);
            Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.MsgListResult.GetBlurRecyclerView");
            z.b bVar = (z.b) k3;
            QQBlurViewWrapper a17 = this.mBlurFetcher.a();
            a17.setDebugTag("BottomBlurVM");
            f.d dVar = new f.d(null, null, 3, null);
            dVar.d(bVar.a());
            dVar.c(new C7346b(bVar.b(), a17));
            a17.setBlurSource(bVar.b(), null, dVar);
            if (v()) {
                a16 = this.updatedBlurBarHeight;
            } else {
                a16 = x.a(88.0f);
            }
            updateUI(new BottomBlurUIState.ShowBlurView(a16));
            return;
        }
        updateUI(BottomBlurUIState.HideBlurView.f193211d);
    }

    private final void p(boolean isShotMode) {
        if (isShotMode) {
            updateUI(BottomBlurUIState.GetBottomBlurBitmap.f193210d);
        } else {
            r();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(boolean visible) {
        if (!AIOUtil.f194084a.b((com.tencent.aio.api.runtime.a) getMContext())) {
            if (QLog.isColorLevel()) {
                QLog.d(FrameworkVM.TAG, 2, "handleBottomBlurVisibleIntent !enableBlur");
            }
            o(false);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(FrameworkVM.TAG, 2, "handleBottomBlurVisibleIntent enableBlur=" + visible);
            }
            o(visible);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        o(AIOUtil.f194084a.b((com.tencent.aio.api.runtime.a) getMContext()));
    }

    private final void t(int height) {
        this.updatedBlurBarHeight = height;
        updateUI(new BottomBlurUIState.UpdateBlurHeight(height));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean u() {
        return ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isExperiment(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e());
    }

    private final boolean v() {
        if (!w() && !u()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean w() {
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return iRobotServiceApi.isRobotAIO(su3.c.b(g16), Integer.valueOf(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent.BottomLayoutHeightChange");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.blur.BottomBlurMsgIntent.AIOBackgroundDrawable");
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.ImmersiveChangeMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.AIOBottomBlurHide");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.AIOBottomBlurShow");
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.b
    public void l(@NotNull MsgIntent initMsgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) initMsgIntent);
        } else {
            Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
            E(initMsgIntent);
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            y();
            super.onDestroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7345a) {
            r();
        } else if (intent instanceof a.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.GetBottomBlurBitmap(((a.b) intent).a()));
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
        x();
    }
}

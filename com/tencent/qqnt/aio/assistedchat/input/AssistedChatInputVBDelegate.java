package com.tencent.qqnt.aio.assistedchat.input;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.input.AssistedChatInputUIState;
import com.tencent.qqnt.aio.assistedchat.input.a;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.utils.l;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\u0018B\u000f\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b9\u0010\u001fJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0016\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00120\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016R\"\u0010 \u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", NodeProps.VISIBLE, "showBubbleTip", "", h.F, "selected", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "u", "", "Ljava/lang/Class;", "getObserverStates", "binding", "o", "state", "l", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "j", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "inputBarViewBinding", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "assistedChatIcon", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/tip/a;", "i", "Lmqq/util/WeakReference;", "bubbleTipRef", "Landroid/os/Handler;", "Lkotlin/Lazy;", "k", "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/aio/api/runtime/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "D", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatInputVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a inputBarViewBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView assistedChatIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.mobileqq.widget.tip.a> bubbleTipRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/AssistedChatInputVBDelegate$a;", "", "", "INPUT_PADDING_WITHOUT_ASSISTED_CHAT", "I", "INPUT_PADDING_WITH_ASSISTED_CHAT", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.input.AssistedChatInputVBDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatInputVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        lazy = LazyKt__LazyJVMKt.lazy(AssistedChatInputVBDelegate$uiHandler$2.INSTANCE);
        this.uiHandler = lazy;
    }

    private final void g(boolean selected) {
        ImageView imageView = this.assistedChatIcon;
        if (imageView == null) {
            return;
        }
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            imageView = null;
        }
        if (imageView.isSelected() != selected) {
            ImageView imageView3 = this.assistedChatIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setSelected(selected);
        }
    }

    private final void h(boolean visible, boolean showBubbleTip) {
        ImageView imageView;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (visible) {
            m();
            ImageView imageView2 = this.assistedChatIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
                imageView2 = null;
            }
            if (imageView2.getVisibility() != 0) {
                ImageView imageView3 = this.assistedChatIcon;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
                    imageView3 = null;
                }
                imageView3.setVisibility(0);
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.inputBarViewBinding;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputBarViewBinding");
                    aVar2 = null;
                }
                o81.b.d(aVar2.a(), l.b(43));
                AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
                ImageView imageView4 = this.assistedChatIcon;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
                    imageView = null;
                } else {
                    imageView = imageView4;
                }
                AssistedChatPanelDtReporter.d(assistedChatPanelDtReporter, "em_kl_agent_en", imageView, null, 4, null);
            }
            if (showBubbleTip) {
                k().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.input.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AssistedChatInputVBDelegate.i(AssistedChatInputVBDelegate.this);
                    }
                }, 1000L);
                return;
            }
            return;
        }
        ImageView imageView5 = this.assistedChatIcon;
        if (imageView5 != null) {
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
                imageView5 = null;
            }
            if (imageView5.getVisibility() == 0) {
                ImageView imageView6 = this.assistedChatIcon;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
                    imageView6 = null;
                }
                imageView6.setVisibility(8);
                com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.inputBarViewBinding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputBarViewBinding");
                } else {
                    aVar = aVar3;
                }
                AIOEditText a16 = aVar.a();
                if (a16.getPaddingRight() == l.b(43)) {
                    o81.b.d(a16, l.b(11));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AssistedChatInputVBDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    private final Handler k() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void m() {
        if (this.assistedChatIcon != null) {
            return;
        }
        Context context = this.context;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ImageView imageView = new ImageView(context);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(l.b(40), l.b(36));
        layoutParams.endToEnd = R.id.input;
        layoutParams.topToTop = R.id.input;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (imageView.getResources().getDimensionPixelSize(R.dimen.cjj) - l.b(36)) / 2;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setBackgroundResource(R.drawable.j5l);
        imageView.setImageResource(R.drawable.j5m);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.input.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistedChatInputVBDelegate.n(AssistedChatInputVBDelegate.this, view);
            }
        });
        imageView.setVisibility(8);
        this.assistedChatIcon = imageView;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.inputBarViewBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBarViewBinding");
            aVar2 = null;
        }
        ConstraintLayout root = aVar2.getRoot();
        ImageView imageView2 = this.assistedChatIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            imageView2 = null;
        }
        root.addView(imageView2);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 != null) {
            AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.inputBarViewBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputBarViewBinding");
            } else {
                aVar = aVar4;
            }
            assistedChatPanelDtReporter.f(aVar.getRoot(), aVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AssistedChatInputVBDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r(new a.b(view.isSelected()));
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        ImageView imageView = this$0.assistedChatIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            imageView = null;
        }
        AssistedChatPanelDtReporter.b(assistedChatPanelDtReporter, "em_kl_agent_en", imageView, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t() {
        ImageView imageView = this.assistedChatIcon;
        if (imageView == null) {
            return;
        }
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            imageView = null;
        }
        if (imageView.getVisibility() != 0) {
            return;
        }
        com.tencent.mobileqq.widget.annimation.scaleview.a aVar = new com.tencent.mobileqq.widget.annimation.scaleview.a();
        ImageView imageView2 = this.assistedChatIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            imageView2 = null;
        }
        aVar.e(imageView2).b(R.anim.f154979um, 3).d(1.0f, 1.1f, 1.0f, 1.2f).f(null);
    }

    private final void u() {
        View childAt;
        Context context = this.context;
        ViewGroup viewGroup = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        com.tencent.mobileqq.widget.tip.a o06 = QUIDefaultBubbleTip.r(context).o0("\u4e0d\u77e5\u9053\u804a\u4ec0\u4e48\uff1f\u6233\u6211\u8bd5\u8bd5");
        ImageView imageView = this.assistedChatIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assistedChatIcon");
            imageView = null;
        }
        com.tencent.mobileqq.widget.tip.a r06 = o06.S(imageView).m0(3).R(0).k0(0).n0(9).i0(0.0f, -6.0f).g0(false).r0(false);
        r06.s0();
        this.bubbleTipRef = new WeakReference<>(r06);
        View v3 = r06.v();
        if (v3 != null) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null) {
                AssistedChatPanelDtReporter.f349138a.e(v3, aVar);
            }
            if (v3 instanceof ViewGroup) {
                viewGroup = (ViewGroup) v3;
            }
            if (viewGroup != null && (childAt = viewGroup.getChildAt(0)) != null) {
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
                AssistedChatPanelDtReporter.d(AssistedChatPanelDtReporter.f349138a, "em_kl_agent_guide_bubble", childAt, null, 4, null);
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        c.a.b(this);
        r(a.c.f349101d);
        r(a.C9455a.f349099d);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            c.a.e(this, bVar);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AssistedChatInputUIState.ChangeVisibilityState.class, AssistedChatInputUIState.ChangeSelectedState.class, AssistedChatInputUIState.SetAIOContextState.class, AssistedChatInputUIState.ShakeIconState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AssistedChatInputUIState.ChangeVisibilityState) {
            AssistedChatInputUIState.ChangeVisibilityState changeVisibilityState = (AssistedChatInputUIState.ChangeVisibilityState) state;
            h(changeVisibilityState.b(), changeVisibilityState.a());
        } else if (state instanceof AssistedChatInputUIState.ChangeSelectedState) {
            g(((AssistedChatInputUIState.ChangeSelectedState) state).a());
        } else if (state instanceof AssistedChatInputUIState.SetAIOContextState) {
            this.aioContext = ((AssistedChatInputUIState.SetAIOContextState) state).a();
        } else if (state instanceof AssistedChatInputUIState.ShakeIconState) {
            t();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.inputBarViewBinding = binding;
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.context = context;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        com.tencent.mobileqq.widget.tip.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        c.a.d(this);
        WeakReference<com.tencent.mobileqq.widget.tip.a> weakReference = this.bubbleTipRef;
        if (weakReference != null && (aVar = weakReference.get()) != null && aVar.L()) {
            aVar.o();
        }
        this.bubbleTipRef = null;
        k().removeCallbacksAndMessages(null);
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void r(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }
}

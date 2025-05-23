package com.tencent.qqnt.aio.lazy.lazyInit;

import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.lateinit.LatinitCreateModeIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0007*\u0001\"\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH&J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J\b\u0010\u0016\u001a\u00020\bH\u0017J\u001f\u0010\u0019\u001a\u00028\u00012\u000e\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017H&\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006J\"\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006H&R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/lazy/lazyInit/c;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "r", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/reflect/KClass;", "Lcom/tencent/mobileqq/aio/lateinit/LatinitCreateModeIntent;", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/a;", "childVB", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/aio/base/mvvm/a;)Lcom/tencent/mvi/base/mvi/MviUIState;", "modelName", "intent", "o", DomainData.DOMAIN_NAME, "e", "Ljava/util/HashSet;", "initMsgIntentSet", "com/tencent/qqnt/aio/lazy/lazyInit/c$a", "f", "Lcom/tencent/qqnt/aio/lazy/lazyInit/c$a;", "mCreateModelAction", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class c<I extends ol3.b, S extends MviUIState> extends com.tencent.qqnt.aio.baseVM.a<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> initMsgIntentSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mCreateModelAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/lazy/lazyInit/c$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<I, S> f351188d;

        a(c<I, S> cVar) {
            this.f351188d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                this.f351188d.r(i3);
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

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.initMsgIntentSet = q();
            this.mCreateModelAction = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(MsgIntent i3) {
        Unit unit;
        if (i3 instanceof LatinitCreateModeIntent) {
            LatinitCreateModeIntent latinitCreateModeIntent = (LatinitCreateModeIntent) i3;
            com.tencent.aio.base.mvvm.a<?, ?> o16 = o(latinitCreateModeIntent.b(), latinitCreateModeIntent.a());
            if (o16 != null) {
                updateUI(m(o16));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(latinitCreateModeIntent.a());
            }
        }
    }

    @NotNull
    public abstract S m(@NotNull com.tencent.aio.base.mvvm.a<?, ?> childVB);

    @Nullable
    public abstract com.tencent.aio.base.mvvm.a<?, ?> n(@NotNull String modelName, @NotNull MsgIntent intent);

    @Nullable
    public final com.tencent.aio.base.mvvm.a<?, ?> o(@NotNull String modelName, @NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) modelName, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!this.initMsgIntentSet.contains(modelName)) {
            return null;
        }
        this.initMsgIntentSet.remove(modelName);
        return n(modelName, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    @CallSuper
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        String a16 = com.tencent.qqnt.aio.utils.j.f352301a.a(p());
        a aVar = this.mCreateModelAction;
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(a16, aVar, d16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(p()), this.mCreateModelAction);
        }
    }

    @NotNull
    public abstract KClass<? extends LatinitCreateModeIntent> p();

    @NotNull
    public abstract HashSet<String> q();
}

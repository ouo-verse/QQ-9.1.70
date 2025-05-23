package com.tencent.input.base.panelcontainer.keyboard;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\u0002),\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/f;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "g", h.F, "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "", "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/log/b;", "logger", "i", "Lpz0/a;", "adapter", "j", "", "d", "I", "mCurKeyboardHeight", "e", "Z", "mKeyboardIsDisplaying", "f", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "Lcom/tencent/mvi/log/b;", "mLogger", "Lpz0/a;", "mMMKVAdapter", "Lcom/tencent/input/base/panelcontainer/keyboard/KeyboardHeightStrategyLoader;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/input/base/panelcontainer/keyboard/KeyboardHeightStrategyLoader;", "mKeyboardHeightStrategyLoader", "com/tencent/input/base/panelcontainer/keyboard/f$b", "Lcom/tencent/input/base/panelcontainer/keyboard/f$b;", "mKeyboardHeightListener", "com/tencent/input/base/panelcontainer/keyboard/f$a", "D", "Lcom/tencent/input/base/panelcontainer/keyboard/f$a;", "mActionR", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class f<C extends com.tencent.mvi.api.runtime.b> implements com.tencent.input.base.mvicompat.f<C>, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private b mKeyboardHeightListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final a mActionR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mCurKeyboardHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mKeyboardIsDisplaying;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mvi.log.b mLogger;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private pz0.a mMMKVAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private KeyboardHeightStrategyLoader mKeyboardHeightStrategyLoader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/input/base/panelcontainer/keyboard/f$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mvi/base/route/k;", "call", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class a implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f<C> f116893d;

        a(f<C> fVar) {
            this.f116893d = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
            }
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            return this.f116893d.g(msgIntent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/input/base/panelcontainer/keyboard/f$b", "Lcom/tencent/input/base/panelcontainer/keyboard/b;", "", "height", "", "a", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.input.base.panelcontainer.keyboard.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f<C> f116894a;

        b(f<C> fVar) {
            this.f116894a = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            }
        }

        @Override // com.tencent.input.base.panelcontainer.keyboard.b
        public void a(int height) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, height);
                return;
            }
            if (height > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (((f) this.f116894a).mKeyboardIsDisplaying != z16) {
                ((f) this.f116894a).mCurKeyboardHeight = height;
                ((f) this.f116894a).mKeyboardIsDisplaying = z16;
                com.tencent.mvi.api.runtime.b bVar = ((f) this.f116894a).mContext;
                if (bVar != null) {
                    bVar.e().h(new KeyboardMsgIntent.OnKeyboardStateChanged(((f) this.f116894a).mKeyboardIsDisplaying, height));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    throw null;
                }
            }
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mKeyboardHeightListener = new b(this);
            this.mActionR = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k g(MsgIntent msgIntent) {
        if (msgIntent instanceof KeyboardMsgIntent.GetKeyboardStatusMsgIntent) {
            return h();
        }
        return new com.tencent.input.base.utils.a();
    }

    private final k h() {
        return new d.a(this.mKeyboardIsDisplaying);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void b(@NotNull C context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        C c16 = this.mContext;
        if (c16 != null) {
            KeyboardHeightStrategyLoader keyboardHeightStrategyLoader = new KeyboardHeightStrategyLoader(c16, new g(this.mLogger, this.mMMKVAdapter));
            this.mKeyboardHeightStrategyLoader = keyboardHeightStrategyLoader;
            keyboardHeightStrategyLoader.d(this.mKeyboardHeightListener);
            C c17 = this.mContext;
            if (c17 != null) {
                c17.e().l(this, this.mActionR);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        throw null;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.GetKeyboardStatusMsgIntent");
        return hashSet;
    }

    public final void i(@Nullable com.tencent.mvi.log.b logger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) logger);
        } else {
            this.mLogger = logger;
        }
    }

    public final void j(@Nullable pz0.a adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) adapter);
        } else {
            this.mMMKVAdapter = adapter;
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        KeyboardHeightStrategyLoader keyboardHeightStrategyLoader = this.mKeyboardHeightStrategyLoader;
        if (keyboardHeightStrategyLoader != null) {
            keyboardHeightStrategyLoader.e();
            C c16 = this.mContext;
            if (c16 != null) {
                c16.e().e(this);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("mKeyboardHeightStrategyLoader");
        throw null;
    }
}

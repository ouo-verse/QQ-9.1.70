package com.tencent.mobileqq.aio.input.edit.delegate;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.accessability.AIOInputAccessibilityUIState;
import com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextTalkbackDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.emotion.utils.s;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\u001eB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0016\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\r0\fH\u0016R\"\u0010\u0015\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextTalkbackDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "binding", "", tl.h.F, "state", "g", "", "Ljava/lang/Class;", "getObserverStates", "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "f", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "j", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextTalkbackDelegate$ReplySourceExploreByTouchHelper;", "e", "Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextTalkbackDelegate$ReplySourceExploreByTouchHelper;", "mTouchHelper", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "mInput", "<init>", "ReplySourceExploreByTouchHelper", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InputEditTextTalkbackDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.adorn.e> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ReplySourceExploreByTouchHelper mTouchHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mInput;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010 \u001a\u00020\u001a\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0014J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u001c\u0010\u001d\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010 \u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u0014\u0010)\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextTalkbackDelegate$ReplySourceExploreByTouchHelper;", "Landroidx/customview/widget/ExploreByTouchHelper;", "", HippyTKDListViewAdapter.X, "y", "", "e", "f", "", "g", "", "getVirtualViewAt", "", "virtualViewIds", "getVisibleVirtualViews", "virtualViewId", "Landroid/view/accessibility/AccessibilityEvent;", "event", "onPopulateEventForVirtualView", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "node", "onPopulateNodeForVirtualView", "action", "Landroid/os/Bundle;", "arguments", "onPerformActionForVirtualView", "Landroid/view/View;", "host", "info", "onInitializeAccessibilityNodeInfo", "a", "Landroid/view/View;", "mHost", "", "b", "Lkotlin/Lazy;", "()Ljava/lang/String;", "clearItemContentDescription", "Landroid/graphics/Rect;", "c", "()Landroid/graphics/Rect;", "clearRectInParent", "d", "refMsgRectInParent", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class ReplySourceExploreByTouchHelper extends ExploreByTouchHelper {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View mHost;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy clearItemContentDescription;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/InputEditTextTalkbackDelegate$ReplySourceExploreByTouchHelper$a;", "", "", "CLEAR_ITEM", "I", "REF_MSG_ITEM", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextTalkbackDelegate$ReplySourceExploreByTouchHelper$a, reason: from kotlin metadata */
        /* loaded from: classes10.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54977);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplySourceExploreByTouchHelper(@NotNull View mHost) {
            super(mHost);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(mHost, "mHost");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
                return;
            }
            this.mHost = mHost;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.InputEditTextTalkbackDelegate$ReplySourceExploreByTouchHelper$clearItemContentDescription$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InputEditTextTalkbackDelegate.ReplySourceExploreByTouchHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    View view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    view = InputEditTextTalkbackDelegate.ReplySourceExploreByTouchHelper.this.mHost;
                    return view.getResources().getString(R.string.ajx);
                }
            });
            this.clearItemContentDescription = lazy;
        }

        private final String b() {
            return (String) this.clearItemContentDescription.getValue();
        }

        private final Rect c() {
            com.tencent.mobileqq.aio.reply.d dVar;
            int i3;
            int i16;
            Object tag = this.mHost.getTag(R.id.gja);
            Rect rect = null;
            if (tag instanceof com.tencent.mobileqq.aio.reply.d) {
                dVar = (com.tencent.mobileqq.aio.reply.d) tag;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                Drawable drawable = dVar.getDrawable();
                if (drawable != null) {
                    Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    if (com.tencent.mobileqq.aio.reply.b.c()) {
                        i3 = 40;
                        i16 = 20;
                    } else {
                        i3 = 0;
                        i16 = 0;
                    }
                    rect = new Rect(intrinsicWidth - dVar.f193186m, i16, intrinsicWidth + i3, intrinsicHeight + i16);
                }
                if (rect != null) {
                    return rect;
                }
            }
            return new Rect();
        }

        private final Rect d() {
            com.tencent.mobileqq.aio.reply.d dVar;
            int i3;
            int i16;
            Object tag = this.mHost.getTag(R.id.gja);
            Rect rect = null;
            if (tag instanceof com.tencent.mobileqq.aio.reply.d) {
                dVar = (com.tencent.mobileqq.aio.reply.d) tag;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                Drawable drawable = dVar.getDrawable();
                if (drawable != null) {
                    Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    if (com.tencent.mobileqq.aio.reply.b.c()) {
                        i3 = 40;
                        i16 = 20;
                    } else {
                        i3 = 0;
                        i16 = 0;
                    }
                    rect = new Rect(0, i16, intrinsicWidth + i3, intrinsicHeight + i16);
                }
                if (rect != null) {
                    return rect;
                }
            }
            return new Rect();
        }

        private final boolean e(float x16, float y16) {
            return c().contains((int) x16, (int) y16);
        }

        private final boolean f(float x16, float y16) {
            return d().contains((int) x16, (int) y16);
        }

        private final void g() {
            com.tencent.mobileqq.aio.reply.d dVar;
            Object tag = this.mHost.getTag(R.id.gja);
            if (tag instanceof com.tencent.mobileqq.aio.reply.d) {
                dVar = (com.tencent.mobileqq.aio.reply.d) tag;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                if (com.tencent.mobileqq.aio.reply.b.c()) {
                    dVar.j();
                    return;
                }
                View view = this.mHost;
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
                dVar.i((TextView) view);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, Float.valueOf(x16), Float.valueOf(y16))).intValue();
            }
            if (e(x16, y16)) {
                return 0;
            }
            if (f(x16, y16)) {
                return 1;
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NotNull List<Integer> virtualViewIds) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) virtualViewIds);
                return;
            }
            Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
            virtualViewIds.add(1);
            virtualViewIds.add(0);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfoCompat info) {
            EditText editText;
            boolean z16;
            CharSequence hint;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) host, (Object) info);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (host instanceof EditText) {
                editText = (EditText) host;
            } else {
                editText = null;
            }
            if (editText != null) {
                String obj = editText.getText().toString();
                boolean z17 = false;
                if (obj != null && obj.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String b16 = s.b(obj);
                    if (info != null) {
                        info.setText(b16);
                    }
                    if (info != null) {
                        info.setContentDescription(b16);
                        return;
                    }
                    return;
                }
                if (info != null) {
                    CharSequence hint2 = editText.getHint();
                    if (hint2 == null || hint2.length() == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        hint = QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME;
                    } else {
                        hint = editText.getHint();
                    }
                    info.setContentDescription(hint);
                }
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, @Nullable Bundle arguments) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(virtualViewId), Integer.valueOf(action), arguments)).booleanValue();
            }
            if (action != 16 || virtualViewId != 0) {
                return false;
            }
            g();
            invalidateVirtualView(0);
            sendEventForVirtualView(0, 1);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int virtualViewId, @NotNull AccessibilityEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, virtualViewId, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (virtualViewId == 0) {
                event.getText().add(b());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        
            if (r4 != null) goto L25;
         */
        @Override // androidx.customview.widget.ExploreByTouchHelper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void onPopulateNodeForVirtualView(int virtualViewId, @NotNull AccessibilityNodeInfoCompat node) {
            com.tencent.mobileqq.aio.reply.d dVar;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, virtualViewId, (Object) node);
                return;
            }
            Intrinsics.checkNotNullParameter(node, "node");
            if (virtualViewId != 0) {
                if (virtualViewId == 1) {
                    Object tag = this.mHost.getTag(R.id.gja);
                    String str2 = null;
                    if (tag instanceof com.tencent.mobileqq.aio.reply.d) {
                        dVar = (com.tencent.mobileqq.aio.reply.d) tag;
                    } else {
                        dVar = null;
                    }
                    if (dVar != null) {
                        CharSequence charSequence = dVar.f193184h;
                        if (charSequence != null) {
                            str2 = charSequence.toString();
                        }
                        str = s.b(str2);
                    }
                    str = "";
                    node.setText(str);
                    node.setBoundsInParent(d());
                    return;
                }
                return;
            }
            node.setText(b());
            node.addAction(16);
            node.setBoundsInParent(c());
            node.setClassName(Button.class.getName());
        }
    }

    public InputEditTextTalkbackDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(InputEditTextTalkbackDelegate this$0, View view, MotionEvent motionEvent) {
        boolean z16;
        ReplySourceExploreByTouchHelper replySourceExploreByTouchHelper;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReplySourceExploreByTouchHelper replySourceExploreByTouchHelper2 = this$0.mTouchHelper;
        if (replySourceExploreByTouchHelper2 != null) {
            z16 = replySourceExploreByTouchHelper2.dispatchHoverEvent(motionEvent);
        } else {
            z16 = false;
        }
        if (!z16 && !view.hasFocus() && (replySourceExploreByTouchHelper = this$0.mTouchHelper) != null) {
            replySourceExploreByTouchHelper.sendAccessibilityEvent(view, 8);
        }
        return z16;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            c.a.b(this);
        }
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
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        ReplySourceExploreByTouchHelper replySourceExploreByTouchHelper;
        EditText editText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if ((state instanceof AIOInputAccessibilityUIState.RequestInputFocus) && (replySourceExploreByTouchHelper = this.mTouchHelper) != null && (editText = this.mInput) != null && !editText.hasFocus()) {
            replySourceExploreByTouchHelper.sendAccessibilityEvent(editText, 8);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends InputUIState>> getObserverStates() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AIOInputAccessibilityUIState.RequestInputFocus.class);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.adorn.e binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            this.mInput = binding.a();
            this.mTouchHelper = new ReplySourceExploreByTouchHelper(binding.a());
            ViewCompat.setAccessibilityDelegate(binding.a(), this.mTouchHelper);
            binding.a().setOnHoverListener(new View.OnHoverListener() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.h
                @Override // android.view.View.OnHoverListener
                public final boolean onHover(View view, MotionEvent motionEvent) {
                    boolean i3;
                    i3 = InputEditTextTalkbackDelegate.i(InputEditTextTalkbackDelegate.this, view, motionEvent);
                    return i3;
                }
            });
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            c.a.d(this);
        }
    }
}

package com.tencent.mobileqq.troop.aivoicechat.aiobar.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.util.TroopAIVoiceChatImeHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\"\u001a\u00020\u000b\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0002R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/util/TroopAIVoiceChatImeHelper;", "", "", "p", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function0;", "onSoftInputHidden", "i", "l", "Ljava/lang/ref/WeakReference;", "Landroid/widget/EditText;", "a", "Ljava/lang/ref/WeakReference;", "editTextRef", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "mDelayShowSoftInputCallback", "c", "onGlobalLayoutCallback", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "d", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mGlobalLayoutListener", "e", "mOnWindowBeFocusedAction", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "f", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "mWindowFocusChangeListener", "k", "()Landroid/widget/EditText;", "mEditText", "editText", "<init>", "(Landroid/widget/EditText;)V", "g", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatImeHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<EditText> editTextRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Runnable mDelayShowSoftInputCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Runnable onGlobalLayoutCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Runnable mOnWindowBeFocusedAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/aivoicechat/aiobar/util/TroopAIVoiceChatImeHelper$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            EditText k3 = TroopAIVoiceChatImeHelper.this.k();
            if (k3 != null && (viewTreeObserver = k3.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            Runnable runnable = TroopAIVoiceChatImeHelper.this.onGlobalLayoutCallback;
            if (runnable != null) {
                runnable.run();
            }
            TroopAIVoiceChatImeHelper.this.onGlobalLayoutCallback = null;
        }
    }

    public TroopAIVoiceChatImeHelper(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editTextRef = new WeakReference<>(editText);
        this.mGlobalLayoutListener = new b();
        this.mWindowFocusChangeListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText k() {
        return this.editTextRef.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TroopAIVoiceChatImeHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(TroopAIVoiceChatImeHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    private final void p() {
        Context context;
        try {
            EditText k3 = k();
            if (k3 == null || (context = k3.getContext()) == null) {
                return;
            }
            Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            if (((InputMethodManager) systemService).showSoftInput(k(), 0)) {
                return;
            }
            QLog.e("TroopAIVoiceChatImeHelper", 1, "showSoftInput fail");
        } catch (Throwable th5) {
            QLog.i("TroopAIVoiceChatImeHelper", 1, "[showSoftInput], " + th5);
        }
    }

    public final void h() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        EditText k3 = k();
        if (k3 != null && (viewTreeObserver2 = k3.getViewTreeObserver()) != null) {
            viewTreeObserver2.addOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
        }
        EditText k16 = k();
        if (k16 == null || (viewTreeObserver = k16.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    public final void i(final Function0<Unit> onSoftInputHidden) {
        Context context;
        try {
            EditText k3 = k();
            if (k3 == null || (context = k3.getContext()) == null) {
                return;
            }
            EditText k16 = k();
            if (k16 != null) {
                k16.clearFocus();
            }
            Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            EditText k17 = k();
            IBinder windowToken = k17 != null ? k17.getWindowToken() : null;
            final Handler handler = new Handler(Looper.getMainLooper());
            if (inputMethodManager.hideSoftInputFromWindow(windowToken, 0, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.util.TroopAIVoiceChatImeHelper$clearFocusAndHideKeyboard$1$hideSoftInputResult$1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int resultCode, Bundle resultData) {
                    Function0<Unit> function0;
                    if ((resultCode == 1 || resultCode == 3) && (function0 = onSoftInputHidden) != null) {
                        function0.invoke();
                    }
                }
            })) {
                return;
            }
            QLog.e("TroopAIVoiceChatImeHelper", 1, "hideSoftInput fail");
        } catch (Throwable th5) {
            QLog.i("TroopAIVoiceChatImeHelper", 1, "[clearFocusAndHideKeyboard], " + th5);
        }
    }

    public final void l() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        ThreadManager.getUIHandler().removeCallbacks(this.mDelayShowSoftInputCallback);
        EditText k3 = k();
        if (k3 != null && (viewTreeObserver2 = k3.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
        }
        EditText k16 = k();
        if (k16 == null || (viewTreeObserver = k16.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    public final void m() {
        EditText k3 = k();
        if (k3 != null) {
            k3.requestFocus();
            QLog.i("TroopAIVoiceChatImeHelper", 1, "[requestFocusAndShowKeyboard]: hasFocus " + k3.hasFocus() + " hasWindowFocus = " + k3.hasWindowFocus());
            if (k3.hasFocus() && k3.hasWindowFocus()) {
                p();
            } else {
                this.mOnWindowBeFocusedAction = new Runnable() { // from class: vr2.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopAIVoiceChatImeHelper.n(TroopAIVoiceChatImeHelper.this);
                    }
                };
                this.onGlobalLayoutCallback = new Runnable() { // from class: vr2.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopAIVoiceChatImeHelper.o(TroopAIVoiceChatImeHelper.this);
                    }
                };
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/aivoicechat/aiobar/util/TroopAIVoiceChatImeHelper$c", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "", "onWindowFocusChanged", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ViewTreeObserver.OnWindowFocusChangeListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            ViewTreeObserver viewTreeObserver;
            if (hasFocus) {
                EditText k3 = TroopAIVoiceChatImeHelper.this.k();
                if (k3 != null && (viewTreeObserver = k3.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnWindowFocusChangeListener(this);
                }
                Runnable runnable = TroopAIVoiceChatImeHelper.this.mOnWindowBeFocusedAction;
                if (runnable != null) {
                    runnable.run();
                }
                TroopAIVoiceChatImeHelper.this.mOnWindowBeFocusedAction = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(TroopAIVoiceChatImeHelper troopAIVoiceChatImeHelper, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        troopAIVoiceChatImeHelper.i(function0);
    }
}

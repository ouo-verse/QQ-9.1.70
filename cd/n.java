package cd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.LocalMultiProcConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\u001f\u0018\u0000 \u00032\u00020\u0001:\u0002\f\u0010B\u0013\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\"\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 \u00a8\u0006$"}, d2 = {"Lcd/n;", "", "", "g", "", "value", tl.h.F, "d", "Lcd/n$b;", "onKeyBoardListener", "i", "Landroid/view/View;", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "b", "Z", "f", "()Z", "k", "(Z)V", "isSoftKeyboardOpened", "c", "Lcd/n$b;", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "rootViewRect", "e", "j", "openGlobalLayoutListener", "cd/n$c", "Lcd/n$c;", "onGlobalLayoutListener", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class n {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isSoftKeyboardOpened;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private b onKeyBoardListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Rect rootViewRect = new Rect();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean openGlobalLayoutListener = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c onGlobalLayoutListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcd/n$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "Landroid/view/View;", "view", "Landroid/content/Context;", "context", "c", "", "isFocus", "a", "", "MAX_VISIBLE_HEIGHT", "I", "", "QZONE_ACTION_SOFT_KEYBOARD", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cd.n$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity, boolean isFocus) {
            Window window;
            Window window2;
            QLog.i("SystemKeyboardUtils", 1, "[changeSoftInputState] isFocus=" + isFocus);
            if (isFocus) {
                if (activity == null || (window2 = activity.getWindow()) == null) {
                    return;
                }
                window2.setSoftInputMode(21);
                return;
            }
            if (activity == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(19);
        }

        public final void c(View view, Context context) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 1);
            }
        }

        Companion() {
        }

        public final void b(Activity activity) {
            View currentFocus = activity != null ? activity.getCurrentFocus() : null;
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            Object systemService = currentFocus.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcd/n$b;", "", "", "height", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public interface b {
        void a(int height);

        void b(int height);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"cd/n$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (n.this.rootView == null || !n.this.getOpenGlobalLayoutListener()) {
                return;
            }
            try {
                View view = n.this.rootView;
                Intrinsics.checkNotNull(view);
                view.getWindowVisibleDisplayFrame(n.this.rootViewRect);
                View view2 = n.this.rootView;
                Intrinsics.checkNotNull(view2);
                int height = view2.getHeight();
                int i3 = height - (n.this.rootViewRect.bottom - n.this.rootViewRect.top);
                View view3 = n.this.rootView;
                Intrinsics.checkNotNull(view3);
                int statusBarHeight = i3 - ImmersiveUtils.getStatusBarHeight(view3.getContext());
                RFWLog.d("SystemKeyboardUtils", RFWLog.USR, "onGlobalLayout, rootViewHeight: " + height + ", heightDiff: " + statusBarHeight + ", isSoftKeyboardOpened: " + n.this.getIsSoftKeyboardOpened());
                if (!n.this.getIsSoftKeyboardOpened() && statusBarHeight > 200) {
                    n.this.k(true);
                    n.this.h(statusBarHeight);
                    b bVar = n.this.onKeyBoardListener;
                    if (bVar != null) {
                        bVar.a(statusBarHeight);
                        return;
                    }
                    return;
                }
                if (!n.this.getIsSoftKeyboardOpened() || statusBarHeight >= 200) {
                    return;
                }
                n.this.k(false);
                b bVar2 = n.this.onKeyBoardListener;
                if (bVar2 != null) {
                    bVar2.b(0);
                }
            } catch (Exception e16) {
                QLog.e("SystemKeyboardUtils", 1, "[onKeyboardChange] getWindowVisibleDisplayFrame error:" + e16);
            }
        }
    }

    public n(View view) {
        ViewTreeObserver viewTreeObserver;
        c cVar = new c();
        this.onGlobalLayoutListener = cVar;
        this.rootView = view;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(cVar);
    }

    public final int d() {
        return LocalMultiProcConfig.getInt("QZoneSoftHeight", 0);
    }

    /* renamed from: e, reason: from getter */
    public final boolean getOpenGlobalLayoutListener() {
        return this.openGlobalLayoutListener;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSoftKeyboardOpened() {
        return this.isSoftKeyboardOpened;
    }

    public final void g() {
        ViewTreeObserver viewTreeObserver;
        View view = this.rootView;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public final void i(b onKeyBoardListener) {
        this.onKeyBoardListener = onKeyBoardListener;
    }

    public final void j(boolean z16) {
        this.openGlobalLayoutListener = z16;
    }

    public final void k(boolean z16) {
        this.isSoftKeyboardOpened = z16;
    }

    public final void h(int value) {
        if (value <= 0 || value == d()) {
            return;
        }
        LocalMultiProcConfig.putInt("QZoneSoftHeight", value);
    }
}

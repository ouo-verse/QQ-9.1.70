package h53;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010(R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u0016\u0010.\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010-R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lh53/i;", "", "", "o", "d", "u", "Landroid/app/Activity;", "j", "Landroid/widget/EditText;", "k", "Landroid/view/View;", "f", "i", "l", "Landroid/widget/ImageButton;", "button", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "e", "", "show", "v", "Landroid/content/Context;", "context", "p", "r", "Landroid/content/res/Configuration;", "newConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "editText", "", "themeId", ReportConstant.COSTREPORT_PREFIX, "t", DomainData.DOMAIN_NAME, "Lf53/a;", "b", "Lf53/a;", "quiEmojiPanel", "Lmqq/util/WeakReference;", "c", "Lmqq/util/WeakReference;", "contextRef", "editTextRef", "Z", "isKeyboard", "I", "windowHeight", "g", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", tl.h.F, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f404358a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_QQUIInputQQEmojiPanel.yml", version = 1)
    @Nullable
    private static f53.a quiEmojiPanel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<Context> contextRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<EditText> editTextRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isKeyboard;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int windowHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int themeId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

    /* renamed from: i, reason: collision with root package name */
    private static ArrayList f404366i;

    static {
        ArrayList arrayList = new ArrayList();
        f404366i = arrayList;
        arrayList.add(g53.b.class);
        f404358a = new i();
        isKeyboard = true;
        themeId = 1000;
        globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: h53.f
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                i.m();
            }
        };
        o();
    }

    i() {
    }

    private final void d() {
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        Activity j3 = j();
        if (j3 != null && (window = j3.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener);
        }
    }

    private final void e(ImageButton button, View panel) {
        boolean z16 = !isKeyboard;
        isKeyboard = z16;
        if (z16) {
            panel.setVisibility(8);
            button.setBackgroundResource(R.drawable.qui_emoticon);
            v(true);
        } else {
            panel.setVisibility(0);
            button.setBackgroundResource(R.drawable.qui_keyboard_circle);
            v(false);
        }
    }

    private final View f() {
        FrameLayout frameLayout;
        View view;
        final View a16;
        Activity j3 = j();
        View view2 = null;
        if (j3 != null) {
            View findViewById = j3.findViewById(android.R.id.content);
            if (findViewById instanceof FrameLayout) {
                frameLayout = (FrameLayout) findViewById;
            } else {
                frameLayout = null;
            }
            if (frameLayout != null) {
                view = frameLayout.findViewById(R.id.f66043_k);
            } else {
                view = null;
            }
            if (view instanceof View) {
                view2 = view;
            }
            if (view2 == null) {
                view2 = j3.getLayoutInflater().inflate(R.layout.f168951hg4, (ViewGroup) frameLayout, false);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                if (frameLayout != null) {
                    frameLayout.addView(view2, layoutParams);
                }
                View findViewById2 = view2.findViewById(R.id.trq);
                Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageButton");
                final ImageButton imageButton = (ImageButton) findViewById2;
                View findViewById3 = view2.findViewById(R.id.bvc);
                Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) findViewById3;
                f53.a aVar = quiEmojiPanel;
                if (aVar != null && (a16 = aVar.a(f404358a.k())) != null) {
                    a16.setBackgroundColor(ie0.a.f().g(j3, R.color.qui_common_bg_middle_light, themeId));
                    a16.setVisibility(8);
                    a16.setTag("QUI_EMOJI_PANEL_TAG");
                    viewGroup.addView(a16, new LinearLayout.LayoutParams(-1, -1));
                    imageButton.setOnClickListener(new View.OnClickListener() { // from class: h53.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            i.g(imageButton, a16, view3);
                        }
                    });
                }
                view2.setOnClickListener(new View.OnClickListener() { // from class: h53.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        i.h(view3);
                    }
                });
            }
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ImageButton button, View v3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(button, "$button");
        Intrinsics.checkNotNullParameter(v3, "$v");
        f404358a.e(button, v3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        FrameLayout frameLayout;
        View view;
        Activity j3 = j();
        if (j3 != null) {
            View findViewById = j3.findViewById(android.R.id.content);
            View view2 = null;
            if (findViewById instanceof FrameLayout) {
                frameLayout = (FrameLayout) findViewById;
            } else {
                frameLayout = null;
            }
            if (frameLayout != null) {
                view = frameLayout.findViewById(R.id.f66043_k);
            } else {
                view = null;
            }
            if (view instanceof View) {
                view2 = view;
            }
            if (view2 != null) {
                frameLayout.removeView(view2);
            }
        }
        f53.a aVar = quiEmojiPanel;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    private final Activity j() {
        Context context;
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        return (Activity) context;
    }

    private final EditText k() {
        WeakReference<EditText> weakReference = editTextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final View l() {
        FrameLayout frameLayout;
        View view;
        Activity j3 = j();
        if (j3 == null) {
            return null;
        }
        View findViewById = j3.findViewById(android.R.id.content);
        if (findViewById instanceof FrameLayout) {
            frameLayout = (FrameLayout) findViewById;
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            view = frameLayout.findViewById(R.id.f66043_k);
        } else {
            view = null;
        }
        if (!(view instanceof View)) {
            return null;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        View f16;
        i iVar = f404358a;
        Activity j3 = iVar.j();
        if (j3 != null) {
            Rect rect = new Rect();
            j3.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i3 = ScreenUtil.SCREEN_HIGHT / 4;
            int height = windowHeight - rect.height();
            if (windowHeight == 0 && height < i3) {
                windowHeight = rect.height();
                return;
            }
            if (iVar.k() != null && (f16 = iVar.f()) != null) {
                if (height >= i3) {
                    f16.setVisibility(0);
                    View findViewById = f16.findViewById(R.id.bvc);
                    Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) findViewById;
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.height = height;
                    viewGroup.setLayoutParams(layoutParams2);
                    return;
                }
                if (isKeyboard) {
                    f16.setVisibility(8);
                }
            }
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void o() {
        quiEmojiPanel = (f53.a) com.tencent.mobileqq.qroute.utils.b.a(f404366i);
        QLog.i("QUIInputQQEmojiHelper", 2, "injected");
    }

    private final void u() {
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        Activity j3 = j();
        if (j3 != null && (window = j3.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener);
        }
    }

    private final void v(boolean show) {
        EditText editText;
        InputMethodManager inputMethodManager;
        WeakReference<EditText> weakReference = editTextRef;
        if (weakReference != null && (editText = weakReference.get()) != null) {
            Object systemService = editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            if (show) {
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(editText, 0);
                }
            } else if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }
    }

    public final void n(@NotNull Context context) {
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        if (Intrinsics.areEqual(context2, context)) {
            View l3 = l();
            if (l3 != null) {
                l3.findViewWithTag("QUI_EMOJI_PANEL_TAG").setVisibility(8);
                ((ImageButton) l3.findViewById(R.id.trq)).setBackgroundResource(R.drawable.qui_emoticon);
                l3.setVisibility(8);
            }
            isKeyboard = true;
        }
    }

    public final void p(@NotNull Context context) {
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        if (!Intrinsics.areEqual(context2, context)) {
            u();
            i();
            isKeyboard = true;
            editTextRef = null;
            windowHeight = 0;
            contextRef = new WeakReference<>(context);
            d();
        }
    }

    public final void q(@Nullable Configuration newConfig) {
        int i3;
        if (newConfig != null && (i3 = newConfig.screenHeightDp) > 0) {
            windowHeight = ViewUtils.dip2px(i3);
        }
    }

    public final void r(@NotNull Context context) {
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        if (Intrinsics.areEqual(context2, context)) {
            u();
            i();
            contextRef = null;
            isKeyboard = true;
            editTextRef = null;
            windowHeight = 0;
        }
    }

    public final void s(@NotNull EditText editText, int themeId2) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        editTextRef = new WeakReference<>(editText);
        themeId = themeId2;
    }

    public final void t(@NotNull EditText editText) {
        Context context;
        Intrinsics.checkNotNullParameter(editText, "editText");
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (Intrinsics.areEqual(context, editText)) {
            i();
            isKeyboard = true;
            editTextRef = null;
        }
    }
}

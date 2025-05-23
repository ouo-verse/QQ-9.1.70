package com.tencent.nativepreview;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.nativepreview.base.EngineView;
import com.tencent.nativepreview.biz.FindReplaceView;
import com.tencent.nativepreview.biz.i;
import com.tencent.nativepreview.service.Log;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\u0005H\u0016J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u0013\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/nativepreview/NativeEngineView;", "Lcom/tencent/nativepreview/base/EngineView;", "Lcom/tencent/nativepreview/d;", "Landroid/view/View;", "content", "", "c", "", SQLiteDatabase.OPERATE_TYPE_REPLACE, "Lcom/tencent/nativepreview/biz/i;", "handler", h.F, "f", "g", "", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "e", "Lcom/tencent/nativepreview/d;", "d", "()Lcom/tencent/nativepreview/d;", "setController", "(Lcom/tencent/nativepreview/d;)V", "controller", "Lcom/tencent/nativepreview/biz/FindReplaceView;", "Lcom/tencent/nativepreview/biz/FindReplaceView;", "()Lcom/tencent/nativepreview/biz/FindReplaceView;", "setFindReplaceView", "(Lcom/tencent/nativepreview/biz/FindReplaceView;)V", "findReplaceView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class NativeEngineView extends EngineView<d> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public d controller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public FindReplaceView findReplaceView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/nativepreview/NativeEngineView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.nativepreview.NativeEngineView$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MtpConstants.FORMAT_EXIF_JPEG);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeEngineView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
    }

    public void c(@Nullable View content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) content);
            return;
        }
        if (content != null) {
            addView(content, new ViewGroup.LayoutParams(-1, -1));
        }
        b(content);
    }

    @NotNull
    public d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        d dVar = this.controller;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        return null;
    }

    @NotNull
    public final FindReplaceView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FindReplaceView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FindReplaceView findReplaceView = this.findReplaceView;
        if (findReplaceView != null) {
            return findReplaceView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("findReplaceView");
        return null;
    }

    public final void f() {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Log.INSTANCE.d("NativeEngineView", "hideFindReplaceView");
        FindReplaceView e16 = e();
        if (e16 != null) {
            e16.setVisibility(8);
        }
        View a16 = a();
        if (a16 == null) {
            layoutParams = null;
        } else {
            layoutParams = a16.getLayoutParams();
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public void g() {
        ViewParent parent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        View a16 = a();
        if (a16 == null) {
            parent = null;
        } else {
            parent = a16.getParent();
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(a());
        }
    }

    public final void h(boolean replace, @NotNull i handler) {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(replace), handler);
            return;
        }
        Intrinsics.checkNotNullParameter(handler, "handler");
        Log.INSTANCE.d("NativeEngineView", Intrinsics.stringPlus("showFindReplaceView replace: ", Boolean.valueOf(replace)));
        if (this.findReplaceView == null) {
            setFindReplaceView(new FindReplaceView(getContext(), null, 0, 0, 14, null));
        }
        e().setVisibility(0);
        DocSearchState docSearchState = new DocSearchState();
        docSearchState.setReplace(replace);
        e().setSearchOptions(docSearchState);
        e().setSearchHandler(handler);
        addView(e(), new ViewGroup.LayoutParams(-1, -2));
        View a16 = a();
        if (a16 == null) {
            layoutParams = null;
        } else {
            layoutParams = a16.getLayoutParams();
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 200, 0, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        Log.INSTANCE.d("NativeEngineView", "onSizeChanged w: " + w3 + ", h: " + h16);
        d d16 = d();
        if (d16 != null) {
            d16.w(new RectF(0.0f, 0.0f, w3, h16), getContext().getResources().getDisplayMetrics().density);
        }
    }

    public void setController(@NotNull d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.controller = dVar;
        }
    }

    public final void setFindReplaceView(@NotNull FindReplaceView findReplaceView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) findReplaceView);
        } else {
            Intrinsics.checkNotNullParameter(findReplaceView, "<set-?>");
            this.findReplaceView = findReplaceView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeEngineView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ NativeEngineView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeEngineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }
}

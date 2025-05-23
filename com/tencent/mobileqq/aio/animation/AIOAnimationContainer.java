package com.tencent.mobileqq.aio.animation;

import android.content.Context;
import android.graphics.Matrix;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.animation.animator.FloorJumperSet;
import com.tencent.mobileqq.aio.animation.animator.ParticleAnimator;
import com.tencent.mobileqq.aio.animation.animator.PathAnimation;
import com.tencent.mobileqq.aio.animation.business.BusinessEggsAnimation;
import com.tencent.mobileqq.aio.animation.data.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0017B\u001f\b\u0007\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u00a2\u0006\u0004\bU\u0010VJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J5\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0006\u0010\u0019\u001a\u00020\bJ\u000f\u0010\u001a\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ0\u0010!\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0014JP\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u000fH\u0016J(\u0010/\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u000fH\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0004H\u0016J\u0018\u00104\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\"2\u0006\u00103\u001a\u000202H\u0014J\u0010\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0016J\b\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u00020\bH\u0014R\u0018\u0010;\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010:R$\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00060<j\b\u0012\u0004\u0012\u00020\u0006`=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010AR\u0018\u0010C\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010BR$\u0010G\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010A\u001a\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010AR\"\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020J0I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u0004\u0018\u0001058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "Landroid/view/ViewGroup;", "Landroid/view/View$OnLayoutChangeListener;", "Lcom/tencent/mobileqq/aio/animation/data/h;", "", "type", "Lcom/tencent/mobileqq/aio/animation/f;", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "priority", "", "", "args", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(II[Ljava/lang/Object;)Z", "f", "p", DomainData.DOMAIN_NAME, "stopAnimation", "height", "a", "b", "o", "i", "()V", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/view/View;", "v", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange", "isInEditMode", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "preventRequestLayout", "addViewInLayout", "deltaY", "c", "Landroid/view/animation/Transformation;", "t", "getChildStaticTransformation", "Lcom/tencent/mobileqq/aio/animation/data/a;", HippyNestedScrollComponent.PRIORITY_PARENT, "d", tl.h.F, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/aio/animation/f;", "mCurrentAnimator", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mConcurrentAnimators", "I", "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<set-?>", "l", "()I", "titleBarHeight", "bottomBarHeight", "Landroid/util/ArrayMap;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/util/ArrayMap;", "idToTimeMap", "k", "()Lcom/tencent/mobileqq/aio/animation/data/a;", "listView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOAnimationContainer extends ViewGroup implements View.OnLayoutChangeListener, com.tencent.mobileqq.aio.animation.data.h {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final ViewGroup.LayoutParams E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayMap<Integer, Long> idToTimeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f mCurrentAnimator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<f> mConcurrentAnimators;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.animation.data.a listview;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int titleBarHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bottomBarHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer$a;", "", "Landroid/view/ViewGroup$LayoutParams;", "LAYOUT_PARAMS", "Landroid/view/ViewGroup$LayoutParams;", "a", "()Landroid/view/ViewGroup$LayoutParams;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.AIOAnimationContainer$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final ViewGroup.LayoutParams a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOAnimationContainer.E;
            }
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29067);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
            E = new ViewGroup.LayoutParams(-2, -2);
        }
    }

    @JvmOverloads
    public AIOAnimationContainer(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            return;
        }
        iPatchRedirector.redirect((short) 27, (Object) this, (Object) context);
    }

    private final f g(int type) {
        com.tencent.mobileqq.aio.animation.data.a aVar = this.listview;
        if (aVar == null) {
            return null;
        }
        if (type != 1) {
            if (type != 2) {
                if (type != 4) {
                    switch (type) {
                        case 7:
                            return new com.tencent.mobileqq.aio.animation.animator.h(type, this, aVar);
                        case 8:
                            return new BusinessEggsAnimation(type, this, aVar);
                        case 9:
                            return new com.tencent.mobileqq.aio.animation.business.i(type, this, aVar);
                        case 10:
                            return new ParticleAnimator(type, this, aVar);
                        default:
                            return null;
                    }
                }
                return new PathAnimation(type, this, aVar);
            }
            return new FloorJumperSet(type, this, aVar);
        }
        return new com.tencent.mobileqq.aio.animation.animator.a(type, this, aVar);
    }

    private final void j() {
        ArrayList<f> arrayList = this.mConcurrentAnimators;
        Iterator<f> it = arrayList.iterator();
        while (it.hasNext()) {
            p(it.next().d());
        }
        arrayList.clear();
    }

    private final void q() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = this.bottomBarHeight;
            marginLayoutParams.topMargin = this.titleBarHeight;
            marginLayoutParams2 = marginLayoutParams;
        }
        setLayoutParams(marginLayoutParams2);
    }

    @Override // com.tencent.mobileqq.aio.animation.data.h
    public void a(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, height);
        } else {
            if (height == this.titleBarHeight) {
                return;
            }
            this.titleBarHeight = height;
            q();
        }
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(@NotNull View child, int index, @NotNull ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, child, Integer.valueOf(index), params, Boolean.valueOf(preventRequestLayout))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @Override // com.tencent.mobileqq.aio.animation.data.h
    public void b(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, height);
        } else {
            if (height == this.bottomBarHeight) {
                return;
            }
            this.bottomBarHeight = height;
            q();
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.data.h
    public void c(int deltaY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, deltaY);
            return;
        }
        f fVar = this.mCurrentAnimator;
        if (fVar != null) {
            fVar.i(deltaY);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.data.h
    public void d(@NotNull com.tencent.mobileqq.aio.animation.data.a parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) parent);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (Intrinsics.areEqual(this.listview, parent)) {
            QLog.i("AIOAnimationContainer", 1, "attach the same listView!");
            return;
        }
        if (this.listview != null) {
            QLog.i("AIOAnimationContainer", 1, "attach and override listView!");
            h();
        }
        this.listview = parent;
        Intrinsics.checkNotNull(parent);
        parent.Y0(this);
    }

    public final boolean f(int type, int priority, @NotNull Object... args) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(type), Integer.valueOf(priority), args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        Iterator<f> it = this.mConcurrentAnimators.iterator();
        while (true) {
            if (it.hasNext()) {
                f next = it.next();
                if (type == next.d() && next.a(type)) {
                    next.n(Arrays.copyOf(args, args.length));
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAnimationContainer", 2, "[concurrentStartAnimation] reuse animator, type: " + type);
                    }
                    z16 = true;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            f g16 = g(type);
            if (g16 == null) {
                return false;
            }
            this.mConcurrentAnimators.add(g16);
            g16.n(Arrays.copyOf(args, args.length));
            if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationContainer", 2, "[concurrentStartAnimation] create new animator, type: " + type);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(@NotNull View child, @NotNull Transformation t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) child, (Object) t16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(t16, "t");
        Object tag = child.getTag();
        if (VersionUtils.isHoneycomb() && (tag instanceof f.b)) {
            f.b bVar = (f.b) tag;
            if (bVar.f()) {
                Matrix matrix = t16.getMatrix();
                matrix.reset();
                int width = child.getWidth() / 2;
                float height = child.getHeight() / 2;
                matrix.preRotate(bVar.c(), width, height);
                matrix.preScale(bVar.g(), bVar.h(), height, height);
                t16.setAlpha(bVar.a());
                return true;
            }
            return false;
        }
        return false;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        com.tencent.mobileqq.aio.animation.data.a aVar = this.listview;
        if (aVar != null) {
            aVar.l(this);
        }
        this.listview = null;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("animation end");
        this.mCurrentAnimator = null;
        if (this.mConcurrentAnimators.size() == 0) {
            removeAllViewsInLayout();
            if (QLog.isColorLevel()) {
                sb5.append("[end] removeAllViews");
            }
        }
        QLog.i("AIOAnimationContainer", 1, sb5.toString());
    }

    @Override // android.view.View
    public boolean isInEditMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public com.tencent.mobileqq.aio.animation.data.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.animation.data.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.listview;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.titleBarHeight;
    }

    public final boolean m(int type, int priority, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(type), Integer.valueOf(priority), args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        f fVar = this.mCurrentAnimator;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            if (priority < fVar.d()) {
                return false;
            }
        }
        f fVar2 = this.mCurrentAnimator;
        if (fVar2 != null) {
            Intrinsics.checkNotNull(fVar2);
            if (priority == fVar2.d()) {
                f fVar3 = this.mCurrentAnimator;
                Intrinsics.checkNotNull(fVar3);
                if (fVar3.a(type)) {
                    f fVar4 = this.mCurrentAnimator;
                    Intrinsics.checkNotNull(fVar4);
                    return fVar4.n(Arrays.copyOf(args, args.length));
                }
            }
        }
        if (this.mCurrentAnimator != null) {
            n();
        }
        this.type = type;
        f g16 = g(type);
        this.mCurrentAnimator = g16;
        if (g16 == null) {
            return false;
        }
        g16.m(priority);
        boolean n3 = g16.n(Arrays.copyOf(args, args.length));
        if (!n3) {
            this.mCurrentAnimator = null;
        }
        return n3;
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        f fVar = this.mCurrentAnimator;
        if (fVar != null) {
            fVar.o();
        }
        i();
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            j();
            n();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        com.tencent.mobileqq.aio.animation.data.a aVar = this.listview;
        if (aVar != null) {
            aVar.l(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        f fVar = this.mCurrentAnimator;
        if (fVar != null) {
            fVar.f(changed, left, top, right, bottom);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnLayoutChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayoutChange(@NotNull View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        boolean z16;
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, v3, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (left == oldLeft && top == oldTop) {
            if (right == oldRight && bottom == oldBottom) {
                z16 = false;
                fVar = this.mCurrentAnimator;
                if (fVar != null) {
                    fVar.f(z16, left, top, right, bottom);
                    return;
                }
                return;
            }
            z16 = true;
            fVar = this.mCurrentAnimator;
            if (fVar != null) {
            }
        }
        z16 = true;
        fVar = this.mCurrentAnimator;
        if (fVar != null) {
        }
    }

    public final void p(int type) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, type);
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.mConcurrentAnimators.size()) {
                f fVar2 = this.mConcurrentAnimators.get(i3);
                Intrinsics.checkNotNullExpressionValue(fVar2, "mConcurrentAnimators[i]");
                fVar = fVar2;
                if (type == fVar.d()) {
                    break;
                } else {
                    i3++;
                }
            } else {
                fVar = null;
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            if (fVar != null) {
                fVar.o();
            }
            this.mConcurrentAnimators.remove(i3);
        }
        if (this.mConcurrentAnimators.size() == 0 && this.mCurrentAnimator == null) {
            removeAllViewsInLayout();
            if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationContainer", 2, "[stopConcurrentAnimation] removeAllViews");
            }
        }
        invalidate();
    }

    @Override // com.tencent.mobileqq.aio.animation.data.h
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            o();
        }
    }

    public /* synthetic */ AIOAnimationContainer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @JvmOverloads
    public AIOAnimationContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mConcurrentAnimators = new ArrayList<>();
        this.idToTimeMap = new ArrayMap<>();
        setId(R.id.sgt);
    }
}

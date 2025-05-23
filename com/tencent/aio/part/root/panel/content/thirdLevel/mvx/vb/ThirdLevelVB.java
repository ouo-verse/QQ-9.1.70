package com.tencent.aio.part.root.panel.content.thirdLevel.mvx.vb;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aio.api.b;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvvm.a;
import com.tencent.aio.exception.AIOException;
import com.tencent.aio.part.root.panel.content.thirdLevel.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ.\u0010\u0007\u001a\u00020\u00002\u0018\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J&\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R*\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/thirdLevel/mvx/vb/ThirdLevelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "child", "Lcom/tencent/aio/part/root/panel/content/thirdLevel/b;", "typeThird", "c1", "", "onPreCreate", "Landroid/view/View;", "hostView", "", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "d", "Ljava/util/List;", "childrenVB", "", "e", "Ljava/util/Map;", "childrenTypeVB", "Lcom/tencent/aio/api/b;", "f", "Lcom/tencent/aio/api/b;", "layoutDelegate", "<init>", "()V", h.F, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ThirdLevelVB extends a<b, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<a<? extends b, ? extends MviUIState>> childrenVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<com.tencent.aio.part.root.panel.content.thirdLevel.b, a<?, ?>> childrenTypeVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.b layoutDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/thirdLevel/mvx/vb/ThirdLevelVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.thirdLevel.mvx.vb.ThirdLevelVB$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53290);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ThirdLevelVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.childrenVB = new ArrayList();
            this.childrenTypeVB = new LinkedHashMap();
        }
    }

    private final ThirdLevelVB c1(a<? extends b, ? extends MviUIState> child, com.tencent.aio.part.root.panel.content.thirdLevel.b typeThird) {
        if (child != null) {
            this.childrenVB.add(child);
            if (typeThird != null) {
                this.childrenTypeVB.put(typeThird, child);
            }
        }
        return this;
    }

    static /* synthetic */ ThirdLevelVB d1(ThirdLevelVB thirdLevelVB, a aVar, com.tencent.aio.part.root.panel.content.thirdLevel.b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bVar = null;
        }
        return thirdLevelVB.c1(aVar, bVar);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<a<? extends b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return this.childrenVB;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull final com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        final Context a16 = createViewParams.a();
        FrameLayout frameLayout = new FrameLayout(createViewParams, a16) { // from class: com.tencent.aio.part.root.panel.content.thirdLevel.mvx.vb.ThirdLevelVB$onCreateView$container$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mvi.api.help.a f69720e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a16);
                this.f69720e = createViewParams;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, ThirdLevelVB.this, createViewParams, a16);
                }
            }

            @Override // android.view.View
            public void draw(@Nullable Canvas canvas) {
                com.tencent.aio.api.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) canvas);
                    return;
                }
                super.draw(canvas);
                if (canvas != null) {
                    canvas.save();
                }
                bVar = ThirdLevelVB.this.layoutDelegate;
                if (bVar != null) {
                    b.a.b(bVar, canvas, null, 2, null);
                }
                if (canvas != null) {
                    canvas.restore();
                }
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                com.tencent.aio.api.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    bVar = ThirdLevelVB.this.layoutDelegate;
                    if (bVar != null) {
                        b.a.c(bVar, left, top, right, bottom, null, 16, null);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                com.tencent.aio.api.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
                    return;
                }
                setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
                bVar = ThirdLevelVB.this.layoutDelegate;
                if (bVar != null) {
                    b.a.d(bVar, widthMeasureSpec, heightMeasureSpec, null, 4, null);
                }
            }
        };
        frameLayout.setWillNotDraw(false);
        frameLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -1));
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onPreCreate() {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.mvi.runtime.strategy.b mStrategyService = getMStrategyService();
        if (mStrategyService != null) {
            fVar = (f) mStrategyService.b(f.class);
        } else {
            fVar = null;
        }
        Intrinsics.checkNotNull(fVar);
        c1(fVar.buildShortcutBarVB(), b.c.f69711b).c1(fVar.buildInputVB(), b.C0651b.f69710b).c1(fVar.buildBottomBarVB(), b.a.f69709b).c1(fVar.buildTitleVB(), b.d.f69712b).c1(fVar.buildTopTipVB(), b.e.f69713b);
        List<a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB = fVar.buildBusinessVB();
        if (buildBusinessVB != null) {
            com.tencent.aio.api.b layoutDelegate = fVar.getLayoutDelegate();
            if (layoutDelegate != null) {
                this.layoutDelegate = layoutDelegate;
                Iterator<T> it = buildBusinessVB.iterator();
                while (it.hasNext()) {
                    d1(this, (a) it.next(), null, 2, null);
                }
            } else {
                throw new AIOException("please set method getIArrangementDelegate ");
            }
        }
        if (this.layoutDelegate == null) {
            this.layoutDelegate = new com.tencent.aio.part.root.panel.content.thirdLevel.mvx.layout.a(this.childrenTypeVB);
        }
    }
}

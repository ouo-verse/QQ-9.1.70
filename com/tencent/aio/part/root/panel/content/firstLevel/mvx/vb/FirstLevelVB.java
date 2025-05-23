package com.tencent.aio.part.root.panel.content.firstLevel.mvx.vb;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.base.mvvm.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.MsgListVBImpl;
import com.tencent.aio.part.root.panel.content.thirdLevel.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0010\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J.\u0010\u0007\u001a\u00020\u00002\u0018\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\u000b\u001a\u00020\nH\u0010\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f*\u00020\nH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u000eJ&\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R*\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010)\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/mvx/vb/FirstLevelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "child", "Lcom/tencent/aio/part/root/panel/content/thirdLevel/a;", "type", "d1", "", "onPreCreate", "Lcom/tencent/aio/api/factory/j;", DTConstants.TAG.API, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "e1", "(Lcom/tencent/aio/api/factory/j;)Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "c1", "Landroid/view/View;", "hostView", "", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", "Ljava/util/List;", "childrenVB", "", "e", "Ljava/util/Map;", "childTypeVB", "Lcom/tencent/aio/api/b;", "f", "Lcom/tencent/aio/api/b;", "layoutDelegate", h.F, "Lcom/tencent/aio/api/factory/j;", "buildLeve1", "i", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "listVB", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class FirstLevelVB extends a<b, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<a<? extends b, ? extends MviUIState>> childrenVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<com.tencent.aio.part.root.panel.content.thirdLevel.a, a<?, ?>> childTypeVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.b layoutDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private j buildLeve1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AbsMsgListVB<?, ?> listVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/mvx/vb/FirstLevelVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.mvx.vb.FirstLevelVB$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FirstLevelVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.childrenVB = new ArrayList();
            this.childTypeVB = new LinkedHashMap();
        }
    }

    private final FirstLevelVB d1(a<? extends b, ? extends MviUIState> child, com.tencent.aio.part.root.panel.content.thirdLevel.a type) {
        if (child != null) {
            this.childrenVB.add(child);
            if (type != null) {
                this.childTypeVB.put(type, child);
            }
        }
        return this;
    }

    @NotNull
    public final AbsMsgListVB<?, ?> c1(@NotNull j coreBuildMsgListVB) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AbsMsgListVB) iPatchRedirector.redirect((short) 3, (Object) this, (Object) coreBuildMsgListVB);
        }
        Intrinsics.checkNotNullParameter(coreBuildMsgListVB, "$this$coreBuildMsgListVB");
        AbsMsgListVB<? extends at.b, ? extends MsgListUiState> viewBinder = coreBuildMsgListVB.getViewBinder();
        if (viewBinder instanceof c) {
            ((c) viewBinder).D1(new MsgListVBImpl());
        }
        return viewBinder;
    }

    @NotNull
    public AbsMsgListVB<?, ?> e1(@NotNull j api) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsMsgListVB) iPatchRedirector.redirect((short) 2, (Object) this, (Object) api);
        }
        Intrinsics.checkNotNullParameter(api, "api");
        return c1(api);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<a<? extends b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return this.childrenVB;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull final com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        j jVar = this.buildLeve1;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildLeve1");
        }
        int e16 = jVar.e(createViewParams.a());
        j jVar2 = this.buildLeve1;
        if (jVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildLeve1");
        }
        final com.tencent.aio.api.c cVar = new com.tencent.aio.api.c(0, jVar2.c(createViewParams.a()), 0, e16);
        final Context a16 = createViewParams.a();
        FrameLayout frameLayout = new FrameLayout(cVar, createViewParams, a16) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.mvx.vb.FirstLevelVB$onCreateView$container$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.api.c f69691e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.mvi.api.help.a f69692f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a16);
                this.f69691e = cVar;
                this.f69692f = createViewParams;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, FirstLevelVB.this, cVar, createViewParams, a16);
                }
            }

            @Override // android.view.View
            protected void onDraw(@Nullable Canvas canvas) {
                com.tencent.aio.api.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) canvas);
                    return;
                }
                if (canvas != null) {
                    canvas.save();
                }
                bVar = FirstLevelVB.this.layoutDelegate;
                if (bVar != null) {
                    bVar.b(canvas, this.f69691e);
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
                    bVar = FirstLevelVB.this.layoutDelegate;
                    if (bVar != null) {
                        bVar.a(left, top, right, bottom, this.f69691e);
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
                bVar = FirstLevelVB.this.layoutDelegate;
                if (bVar != null) {
                    bVar.c(widthMeasureSpec, heightMeasureSpec, this.f69691e);
                }
            }
        };
        frameLayout.setWillNotDraw(false);
        frameLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -1));
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            com.tencent.aio.base.log.a.f69187b.d("FirstLevelVB", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onPreCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        super.onPreCreate();
        com.tencent.mvi.runtime.strategy.b mStrategyService = getMStrategyService();
        Intrinsics.checkNotNull(mStrategyService);
        Object b16 = mStrategyService.b(j.class);
        Intrinsics.checkNotNull(b16);
        j jVar = (j) b16;
        this.buildLeve1 = jVar;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildLeve1");
        }
        this.listVB = e1(jVar);
        j jVar2 = this.buildLeve1;
        if (jVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildLeve1");
        }
        FirstLevelVB d16 = d1(jVar2.a(), a.c.f69707b);
        j jVar3 = this.buildLeve1;
        if (jVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildLeve1");
        }
        d16.d1(jVar3.d(), a.C0650a.f69705b).d1(this.listVB, a.b.f69706b);
        j jVar4 = this.buildLeve1;
        if (jVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildLeve1");
        }
        com.tencent.aio.api.b layoutDelegate = jVar4.getLayoutDelegate();
        if (layoutDelegate == null) {
            layoutDelegate = new com.tencent.aio.part.root.panel.content.firstLevel.mvx.layout.a(this.childTypeVB);
        }
        this.layoutDelegate = layoutDelegate;
    }
}

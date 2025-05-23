package com.tencent.biz.pubaccount.aio;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import com.tencent.biz.pubaccount.aio.c;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOExtBusinessVB;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J,\u0010$\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020!\u0012\u0006\b\u0001\u0012\u00020\"\u0012\u0004\u0012\u00020#0 0\u001f2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010,\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010*j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001`+H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020-H\u0016R\"\u00108\u001a\u0002018\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R+\u0010@\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020!\u0012\u0006\b\u0001\u0012\u00020\"0\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R+\u0010C\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020!\u0012\u0006\b\u0001\u0012\u00020\"0\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?R;\u0010G\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010*j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001`+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010=\u001a\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/biz/pubaccount/aio/PublicAccountInputContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "w1", "l1", "", "visibility", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SwitchMenuDataState;", "state", "p1", "Lcom/tencent/biz/pubaccount/aio/b;", "sessionInfo", "m1", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState$SetCustomMenuDataState;", "o1", "u1", "r1", "Landroid/graphics/Bitmap;", "d1", "Landroid/view/View;", "v", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "e1", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "initializeChildVB", "bindViewAndData", "A1", "q1", "z1", "x1", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "g1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Ljy/a;", "d", "Ljy/a;", "h1", "()Ljy/a;", "y1", "(Ljy/a;)V", "mBinding", "e", "Lcom/tencent/biz/pubaccount/aio/b;", "mSessionInfo", "f", "Lkotlin/Lazy;", "k1", "()Lcom/tencent/aio/base/mvvm/a;", "mMultiSelectBar", tl.h.F, "j1", "mLongShotBar", "i", "i1", "()Ljava/util/HashSet;", "mChildVb", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class PublicAccountInputContainerVB extends com.tencent.aio.base.mvvm.a<PAInputIntent, PAInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected jy.a mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PAInputSessionInfo mSessionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mMultiSelectBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLongShotBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mChildVb;

    public PublicAccountInputContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>>() { // from class: com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB$mMultiSelectBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> invoke() {
                return ((IAIOExtBusinessVB) QRoute.api(IAIOExtBusinessVB.class)).getMultiSelectBarVB();
            }
        });
        this.mMultiSelectBar = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>>() { // from class: com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB$mLongShotBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> invoke() {
                return ((IAIOExtBusinessVB) QRoute.api(IAIOExtBusinessVB.class)).getLongShotBarVB();
            }
        });
        this.mLongShotBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.biz.pubaccount.aio.PublicAccountInputContainerVB$mChildVb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final HashSet<com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                return PublicAccountInputContainerVB.this.g1();
            }
        });
        this.mChildVb = lazy3;
    }

    private final Bitmap d1() {
        View view;
        try {
            if (h1().f411142b.getVisibility() == 0) {
                view = h1().f411142b;
            } else {
                view = h1().f411143c;
            }
            Intrinsics.checkNotNullExpressionValue(view, "if (mBinding.extensionCu\u2026ionInputBar\n            }");
            return f1(view);
        } catch (Error e16) {
            QLog.e("PublicAccountInputContainerVB", 1, "LongShot inputBar bitmap error: " + e16);
            return null;
        } catch (Exception e17) {
            QLog.e("PublicAccountInputContainerVB", 1, "LongShot inputBar bitmap exception: " + e17);
            return null;
        }
    }

    private final Bitmap f1(View v3) {
        Bitmap viewBitmap = Bitmap.createBitmap(v3.getWidth(), v3.getHeight(), Bitmap.Config.ARGB_8888);
        v3.draw(new Canvas(viewBitmap));
        Intrinsics.checkNotNullExpressionValue(viewBitmap, "viewBitmap");
        return viewBitmap;
    }

    private final HashSet<com.tencent.aio.base.mvvm.a<?, ?>> i1() {
        return (HashSet) this.mChildVb.getValue();
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> j1() {
        return (com.tencent.aio.base.mvvm.a) this.mLongShotBar.getValue();
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> k1() {
        return (com.tencent.aio.base.mvvm.a) this.mMultiSelectBar.getValue();
    }

    private final void l1() {
        h1().f411142b.e();
    }

    private final void m1(PAInputSessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
        CustomMenuBar customMenuBar = h1().f411142b;
        PAInputSessionInfo pAInputSessionInfo = this.mSessionInfo;
        if (pAInputSessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            pAInputSessionInfo = null;
        }
        Integer menuType = pAInputSessionInfo.getMenuType();
        customMenuBar.setMenuType(menuType != null ? menuType.intValue() : 0);
        h1().f411142b.c();
    }

    private final void n1(int visibility) {
        h1().f411145e.setVisibility(visibility);
    }

    private final void o1(PAInputUIState.SetCustomMenuDataState state) {
        CustomMenuBar customMenuBar = h1().f411142b;
        List<com.tencent.biz.ui.c> a16 = state.a();
        PAInputSessionInfo pAInputSessionInfo = this.mSessionInfo;
        if (pAInputSessionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            pAInputSessionInfo = null;
        }
        customMenuBar.b(a16, String.valueOf(pAInputSessionInfo.getUin()));
    }

    private final void p1(PAInputUIState.SwitchMenuDataState state) {
        int type = state.getType();
        if (type == 1) {
            h1().f411143c.setVisibility(0);
            h1().f411142b.setVisibility(8);
        } else {
            if (type != 2) {
                return;
            }
            h1().f411143c.setVisibility(4);
            h1().f411142b.setVisibility(0);
        }
    }

    private final void r1() {
        h1().f411142b.setOnBackClickListner(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.aio.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublicAccountInputContainerVB.s1(PublicAccountInputContainerVB.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(PublicAccountInputContainerVB this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new PAInputIntent.CustomMenuSwitchBtnClickIntent());
    }

    private final void u1() {
        h1().f411142b.setOnMenuItemClickListener(new CustomMenuBar.e() { // from class: com.tencent.biz.pubaccount.aio.e
            @Override // com.tencent.biz.ui.CustomMenuBar.e
            public final void a(String str, int i3, int i16) {
                PublicAccountInputContainerVB.v1(PublicAccountInputContainerVB.this, str, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(PublicAccountInputContainerVB this$0, String command, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(command, "command");
        this$0.sendIntent(new PAInputIntent.CustomMenuItemClickIntent(command, i3, i16));
    }

    private final void w1() {
        CustomMenuBar customMenuBar = h1().f411142b;
        customMenuBar.setMinimumHeight(BaseAIOUtils.f(48.0f, customMenuBar.getResources()));
        u1();
        r1();
    }

    public void A1() {
        if (QQTheme.isVasTheme()) {
            h1().f411143c.setBackground(h1().getRoot().getResources().getDrawable(R.drawable.skin_aio_input_bar_bg_theme_version2, null));
            h1().f411142b.setBackground(h1().getRoot().getResources().getDrawable(R.drawable.skin_aio_input_bar_bg_theme_version2, null));
        } else {
            h1().f411143c.setBackground(h1().getRoot().getResources().getDrawable(R.drawable.qui_common_bg_nav_bottom_aio_bg, null));
            h1().f411142b.setBackground(h1().getRoot().getResources().getDrawable(R.drawable.qui_common_bg_nav_bottom_aio_bg, null));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        A1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<PAInputIntent, PAInputUIState> createVM() {
        return new PublicAccountInputContainerVM();
    }

    public HashSet<com.tencent.aio.base.mvvm.a<?, ?>> g1() {
        HashSet<com.tencent.aio.base.mvvm.a<?, ?>> hashSet = new HashSet<>();
        hashSet.add(new cy.d());
        hashSet.add(new cy.a());
        hashSet.add(new cy.b());
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    public Bundle generateVBState(com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof c.GetInputBitmap) {
            ((c.GetInputBitmap) stateCmd).b(d1());
        }
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final jy.a h1() {
        jy.a aVar = this.mBinding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> list;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        list = CollectionsKt___CollectionsKt.toList(i1());
        return list;
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        jy.a g16 = jy.a.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, true)");
        y1(g16);
        w1();
        RelativeLayout root = h1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(PAInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PAInputUIState.InitState) {
            m1(((PAInputUIState.InitState) state).getPAInputSessionInfo());
            return;
        }
        if (state instanceof PAInputUIState.SetCustomMenuDataState) {
            o1((PAInputUIState.SetCustomMenuDataState) state);
            return;
        }
        if (state instanceof PAInputUIState.SwitchMenuDataState) {
            p1((PAInputUIState.SwitchMenuDataState) state);
            return;
        }
        if (state instanceof PAInputUIState.InputContainerVisibleState) {
            n1(((PAInputUIState.InputContainerVisibleState) state).getVisibility());
            return;
        }
        if (state instanceof PAInputUIState.CustomMenuDismissPopupMenuState) {
            l1();
        } else if (state instanceof PAInputUIState.SetMultiSelectBarVisibility) {
            z1(((PAInputUIState.SetMultiSelectBarVisibility) state).getVisibility());
        } else if (state instanceof PAInputUIState.SetLongShotBarVisibility) {
            x1(((PAInputUIState.SetLongShotBarVisibility) state).getVisibility());
        }
    }

    protected final void y1(jy.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mBinding = aVar;
    }

    public void x1(int visibility) {
        if (visibility == 0) {
            addChildVB(j1());
            h1().f411146f.setVisibility(8);
        } else {
            removeChildVB(j1());
            h1().f411146f.setVisibility(0);
        }
    }

    public void z1(int visibility) {
        if (visibility == 0) {
            if (!i1().contains(k1())) {
                addChildVB(k1());
                i1().add(k1());
            }
            h1().f411145e.getLayoutParams().height = ViewUtils.dip2px(120.0f);
            h1().f411146f.setVisibility(8);
            return;
        }
        if (i1().contains(k1())) {
            removeChildVB(k1());
            i1().remove(k1());
        }
        h1().f411145e.getLayoutParams().height = -2;
        h1().f411146f.setVisibility(0);
    }
}

package com.tencent.qqnt.qbasealbum.albumlist.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.albumlist.adapter.c;
import com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/view/AlbumListPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "F9", "", NodeProps.VISIBLE, "I9", "Landroid/view/animation/Animation;", "D9", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "albumListPartRootView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mAlbumList", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "f", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "mAlbumListViewModel", h.F, "Landroid/view/animation/Animation;", "fadeInAnimation", "i", "fadeOutAnimation", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AlbumListPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View albumListPartRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mAlbumList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AlbumListViewModel mAlbumListViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animation fadeInAnimation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animation fadeOutAnimation;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/view/AlbumListPart$a;", "", "", "ITEM_DECORATION", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.albumlist.view.AlbumListPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/qbasealbum/albumlist/view/AlbumListPart$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlbumListPart.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            View view = AlbumListPart.this.albumListPartRootView;
            Intrinsics.checkNotNull(view);
            view.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/qbasealbum/albumlist/view/AlbumListPart$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlbumListPart.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            View view = AlbumListPart.this.albumListPartRootView;
            Intrinsics.checkNotNull(view);
            view.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/qbasealbum/albumlist/view/AlbumListPart$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.top = com.tencent.qqnt.qbasealbum.ktx.d.a(2.0f);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AlbumListPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Animation D9() {
        Animation slideDownAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154813sg);
        slideDownAnimation.setAnimationListener(new b());
        Intrinsics.checkNotNullExpressionValue(slideDownAnimation, "slideDownAnimation");
        return slideDownAnimation;
    }

    private final Animation E9() {
        Animation slideUpAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154814sh);
        slideUpAnimation.setAnimationListener(new c());
        Intrinsics.checkNotNullExpressionValue(slideUpAnimation, "slideUpAnimation");
        return slideUpAnimation;
    }

    private final void F9() {
        final com.tencent.qqnt.qbasealbum.albumlist.adapter.c cVar;
        MediatorLiveData<List<com.tencent.qqnt.qbasealbum.model.b>> T1;
        AlbumListViewModel albumListViewModel = this.mAlbumListViewModel;
        if (albumListViewModel != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar = new com.tencent.qqnt.qbasealbum.albumlist.adapter.c(context, albumListViewModel);
        } else {
            cVar = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.mAlbumList;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.mAlbumList;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.addItemDecoration(new d());
        RecyclerView recyclerView3 = this.mAlbumList;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setAdapter(cVar);
        AlbumListViewModel albumListViewModel2 = this.mAlbumListViewModel;
        if (albumListViewModel2 != null && (T1 = albumListViewModel2.T1()) != null) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<List<com.tencent.qqnt.qbasealbum.model.b>, Unit> function1 = new Function1<List<com.tencent.qqnt.qbasealbum.model.b>, Unit>(this) { // from class: com.tencent.qqnt.qbasealbum.albumlist.view.AlbumListPart$initAlbumList$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AlbumListPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<com.tencent.qqnt.qbasealbum.model.b> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable List<com.tencent.qqnt.qbasealbum.model.b> list) {
                    AlbumListViewModel albumListViewModel3;
                    String a16;
                    AlbumListViewModel albumListViewModel4;
                    AlbumListViewModel albumListViewModel5;
                    AlbumListViewModel albumListViewModel6;
                    LiveData<com.tencent.qqnt.qbasealbum.model.b> W1;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                        return;
                    }
                    c cVar2 = c.this;
                    if (cVar2 != null) {
                        cVar2.p0(list);
                    }
                    albumListViewModel3 = this.this$0.mAlbumListViewModel;
                    if (((albumListViewModel3 == null || (W1 = albumListViewModel3.W1()) == null) ? null : W1.getValue()) != null) {
                        albumListViewModel5 = this.this$0.mAlbumListViewModel;
                        Intrinsics.checkNotNull(albumListViewModel5);
                        albumListViewModel6 = this.this$0.mAlbumListViewModel;
                        Intrinsics.checkNotNull(albumListViewModel6);
                        com.tencent.qqnt.qbasealbum.model.b value = albumListViewModel6.W1().getValue();
                        Intrinsics.checkNotNull(value);
                        albumListViewModel5.a2(value);
                        return;
                    }
                    if (QAlbumPickerContext.f361201a.e().e() == TabType.TAB_VIDEO) {
                        a16 = com.tencent.qqnt.qbasealbum.model.a.f361348a.b();
                    } else {
                        a16 = com.tencent.qqnt.qbasealbum.model.a.f361348a.a();
                    }
                    Intrinsics.checkNotNull(list);
                    for (com.tencent.qqnt.qbasealbum.model.b bVar : list) {
                        if (Intrinsics.areEqual(a16, bVar.b())) {
                            albumListViewModel4 = this.this$0.mAlbumListViewModel;
                            Intrinsics.checkNotNull(albumListViewModel4);
                            albumListViewModel4.a2(bVar);
                            return;
                        }
                    }
                }
            };
            T1.observe((LifecycleOwner) partHost, new Observer() { // from class: com.tencent.qqnt.qbasealbum.albumlist.view.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AlbumListPart.G9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(boolean visible) {
        if (visible) {
            View view = this.albumListPartRootView;
            Intrinsics.checkNotNull(view);
            view.startAnimation(this.fadeInAnimation);
        } else {
            View view2 = this.albumListPartRootView;
            Intrinsics.checkNotNull(view2);
            view2.startAnimation(this.fadeOutAnimation);
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 != null) {
            b16.onAlbumListShown(visible);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AlbumListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f123927hz);
        this.albumListPartRootView = findViewById;
        RFWNavigationBarImmersiveHelper.adjustViewPaddingBottom$default(RFWNavigationBarImmersiveHelper.INSTANCE, findViewById, 0, 2, null);
        this.mAlbumList = (RecyclerView) this.albumListPartRootView;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment<*>");
        AlbumListViewModel a16 = com.tencent.qqnt.qbasealbum.album.b.a((QAlbumBaseMainFragment) partHost);
        this.mAlbumListViewModel = a16;
        Intrinsics.checkNotNull(a16);
        MutableLiveData<Boolean> U1 = a16.U1();
        IPartHost partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.qbasealbum.albumlist.view.AlbumListPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlbumListPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                AlbumListPart albumListPart = AlbumListPart.this;
                Intrinsics.checkNotNull(bool);
                albumListPart.I9(bool.booleanValue());
            }
        };
        U1.observe((LifecycleOwner) partHost2, new Observer() { // from class: com.tencent.qqnt.qbasealbum.albumlist.view.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AlbumListPart.H9(Function1.this, obj);
            }
        });
        this.fadeInAnimation = D9();
        this.fadeOutAnimation = E9();
        F9();
    }
}

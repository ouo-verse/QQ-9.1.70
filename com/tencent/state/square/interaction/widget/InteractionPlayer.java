package com.tencent.state.square.interaction.widget;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.databinding.VasSquareInteractionPlayerBinding;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquarePlayerPool;
import com.tencent.state.square.resource.IResourceManager;
import com.tencent.state.square.resource.SquareResourceManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0006\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u0011H\u0014J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\u001c\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\b\u0010 \u001a\u00020\u0011H\u0002J&\u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\nJ\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/square/interaction/widget/InteractionPlayer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareInteractionPlayerBinding;", "isPlaying", "", "mSquareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "mSquareResourceManager", "Lcom/tencent/state/square/resource/SquareResourceManager;", "prePlayingFinishFunc", "Lkotlin/Function0;", "", "scale", "", "showText", "textAnim", "Landroid/animation/AnimatorSet;", "bind", "cancelPlaying", "dispose", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "play", "interactionOption", "Lcom/tencent/state/square/interaction/widget/InteractionPlayData;", "onFinish", "playAvatar", "playInteraction", "pagPath", "", "scaleToContainer", "containerWidth", "", "containerHeight", "setShowText", ViewStickEventHelper.IS_SHOW, "startTextAnim", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionPlayer extends FrameLayout {
    private static final int AVATAR_CONTAINER_MIN_HEIGHT = 340;
    private static final int AVATAR_MAX_HEIGHT = 260;
    private static final int AVATAR_MAX_WIDTH = 260;
    private static final int INTERACTION_ANIM_REPEAT_COUNT = 1;
    private static final int PAG_HEIGHT = 300;
    private static final int PAG_WIDTH = 375;
    private final VasSquareInteractionPlayerBinding binding;
    private boolean isPlaying;
    private SquareAvatarItem mSquareItem;
    private SquareResourceManager mSquareResourceManager;
    private Function0<Unit> prePlayingFinishFunc;
    private float scale;
    private boolean showText;
    private AnimatorSet textAnim;

    public /* synthetic */ InteractionPlayer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final void cancelPlaying() {
        Function0<Unit> function0;
        if (this.isPlaying && (function0 = this.prePlayingFinishFunc) != null) {
            function0.invoke();
        }
    }

    private final void playAvatar() {
        final SquareAvatarItem squareAvatarItem = this.mSquareItem;
        if (squareAvatarItem != null) {
            SquareAvatarView squareAvatarView = this.binding.composedAvatar;
            Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.composedAvatar");
            ViewExtensionsKt.updateLayoutParams(squareAvatarView, new Function1<ViewGroup.LayoutParams, Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$playAvatar$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewGroup.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    if (SquareAvatarItem.this.getLocation().getWidth() > SquareAvatarItem.this.getLocation().getHeight()) {
                        receiver.height = com.tencent.state.square.common.ViewExtensionsKt.dip(this.getContext(), 260);
                        receiver.width = (int) ((SquareAvatarItem.this.getLocation().getWidth() / SquareAvatarItem.this.getLocation().getHeight()) * receiver.height);
                    } else {
                        receiver.width = com.tencent.state.square.common.ViewExtensionsKt.dip(this.getContext(), 260);
                        receiver.height = (int) ((SquareAvatarItem.this.getLocation().getHeight() / SquareAvatarItem.this.getLocation().getWidth()) * receiver.width);
                    }
                }
            });
            this.binding.composedAvatar.setData(squareAvatarItem);
            this.binding.composedAvatar.setVideoViewVisibility(false);
            this.binding.composedAvatar.setConfig(new AvatarAnimConfig(true, new SquarePlayerPool(null, 1, 0 == true ? 1 : 0), new PlayConfig(-1, true, null, 4, null), false, 8, null));
        }
    }

    private final void startTextAnim(InteractionPlayData interactionOption) {
        ArrayList<TextView> arrayListOf;
        int collectionSizeOrDefault;
        this.binding.selectResultTip.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        TextView textView = this.binding.selectResultTip;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.selectResultTip");
        textView.setText(interactionOption.getText());
        AnimatorSet animatorSet = this.textAnim;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.binding.selectResultTip);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListOf, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TextView it : arrayListOf) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(ObjectAnimator.ofFloat(it, c.f123400v, it.getAlpha(), 1.0f));
        }
        animatorSet.playTogether(arrayList);
        this.textAnim.start();
    }

    public final void bind(SquareAvatarItem mSquareItem) {
        Intrinsics.checkNotNullParameter(mSquareItem, "mSquareItem");
        this.mSquareItem = mSquareItem;
        playAvatar();
    }

    public final void dispose() {
        this.binding.composedAvatar.destroy();
        SquareResourceManager squareResourceManager = this.mSquareResourceManager;
        if (squareResourceManager != null) {
            IResourceManager.DefaultImpls.onRecycled$default(squareResourceManager, null, 1, null);
        }
        this.textAnim.cancel();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.binding.composedAvatar.resume();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.binding.composedAvatar.pause();
    }

    public final void play(final InteractionPlayData interactionOption, final Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(interactionOption, "interactionOption");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        cancelPlaying();
        InteractionManager.INSTANCE.loadPagResource(interactionOption.getOptionId(), interactionOption.getPagUrl(), new Function1<String, Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$play$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$play$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        InteractionPlayer$play$1 interactionPlayer$play$1 = InteractionPlayer$play$1.this;
                        InteractionPlayer.this.playInteraction(interactionOption, it, onFinish);
                    }
                });
            }
        }, new Function0<Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$play$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.state.square.interaction.widget.InteractionPlayer$sam$java_lang_Runnable$0] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Function0 function0 = Function0.this;
                if (function0 != null) {
                    function0 = new Runnable() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$sam$java_lang_Runnable$0
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                        }
                    };
                }
                uIHandlerV2.post((Runnable) function0);
            }
        });
    }

    public final void setShowText(boolean isShow) {
        this.showText = isShow;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showText = true;
        this.textAnim = new AnimatorSet();
        this.scale = 1.0f;
        VasSquareInteractionPlayerBinding inflate = VasSquareInteractionPlayerBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareInteractionPlay\u2026rom(context), this, true)");
        this.binding = inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playInteraction(final InteractionPlayData interactionOption, final String pagPath, final Function0<Unit> onFinish) {
        this.isPlaying = true;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$playInteraction$playingFinishFunc$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VasSquareInteractionPlayerBinding vasSquareInteractionPlayerBinding;
                Ref.BooleanRef booleanRef2 = booleanRef;
                if (booleanRef2.element) {
                    return;
                }
                booleanRef2.element = true;
                InteractionPlayer.this.isPlaying = false;
                onFinish.invoke();
                vasSquareInteractionPlayerBinding = InteractionPlayer.this.binding;
                vasSquareInteractionPlayerBinding.pagContainer.removeAllViews();
            }
        };
        this.prePlayingFinishFunc = function0;
        ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        if (pagView != null) {
            FrameLayout frameLayout = this.binding.pagContainer;
            View view = pagView.getView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 375), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 300));
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(view, layoutParams);
            pagView.setPagFile(pagPath);
            pagView.playPag(1);
            pagView.setPagViewListener(new ISquarePagViewListener() { // from class: com.tencent.state.square.interaction.widget.InteractionPlayer$playInteraction$$inlined$let$lambda$1
                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationCancel(ISquarePagView squarePagView) {
                    function0.invoke();
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationEnd(ISquarePagView squarePagView) {
                    function0.invoke();
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationUpdate(ISquarePagView iSquarePagView) {
                    ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationRepeat(ISquarePagView squarePagView) {
                }

                @Override // com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationStart(ISquarePagView squarePagView) {
                }
            });
            if (this.showText) {
                startTextAnim(interactionOption);
            }
        }
        if (pagView == null) {
            function0.invoke();
        }
    }

    public final void scaleToContainer(int containerWidth, int containerHeight) {
        if (containerHeight < AVATAR_CONTAINER_MIN_HEIGHT) {
            this.scale = containerHeight / AVATAR_CONTAINER_MIN_HEIGHT;
            FrameLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Intrinsics.checkNotNullExpressionValue(this.binding.getRoot(), "binding.root");
            root.setPivotX(r0.getMeasuredWidth() / 2.0f);
            FrameLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setPivotY(0.0f);
            FrameLayout root3 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            root3.setScaleX(this.scale);
            FrameLayout root4 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
            root4.setScaleY(this.scale);
        }
    }
}

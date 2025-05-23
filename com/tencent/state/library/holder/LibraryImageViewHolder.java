package com.tencent.state.library.holder;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.data.Image;
import com.tencent.state.library.data.LibraryDecoratorItem;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareItemLibraryImageBinding;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.EntryDecorator;
import com.tencent.state.view.SquareImageView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u001aH\u0014R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/library/holder/LibraryImageViewHolder;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/library/data/LibraryDecoratorItem;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemLibraryImageBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemLibraryImageBinding;)V", "animateImageView", "Lcom/tencent/state/view/SquareImageView;", "getAnimateImageView", "()Lcom/tencent/state/view/SquareImageView;", "animateImageView$delegate", "Lkotlin/Lazy;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemLibraryImageBinding;", "onAnimatePlayRepeatListener", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "bindBookshelfAnimate", "", "data", "bindImage", "bindListeners", "doBind", "index", "", "event", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onRecycled", "transform", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryImageViewHolder extends MapViewHolder<LibraryDecoratorItem> {

    /* renamed from: animateImageView$delegate, reason: from kotlin metadata */
    private final Lazy animateImageView;
    private final VasSquareItemLibraryImageBinding binding;
    private ApngDrawable.OnPlayRepeatListener onAnimatePlayRepeatListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LibraryImageViewHolder(VasSquareItemLibraryImageBinding binding) {
        super(r0);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(binding, "binding");
        RelativeLayout mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareImageView>() { // from class: com.tencent.state.library.holder.LibraryImageViewHolder$animateImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareImageView invoke() {
                View inflate = LibraryImageViewHolder.this.getBinding().animateView.inflate();
                if (!(inflate instanceof SquareImageView)) {
                    inflate = null;
                }
                return (SquareImageView) inflate;
            }
        });
        this.animateImageView = lazy;
    }

    private final void bindBookshelfAnimate(LibraryDecoratorItem data) {
        final Image image = data.getDecorator().getImage();
        Decorator decorator = data.getDecorator();
        if (!(decorator instanceof EntryDecorator)) {
            decorator = null;
        }
        EntryDecorator entryDecorator = (EntryDecorator) decorator;
        if (entryDecorator != null) {
            String bookshelfAnimate = entryDecorator.getBookshelfAnimate();
            if (bookshelfAnimate == null || bookshelfAnimate.length() == 0) {
                return;
            }
            String bookshelfAnimate2 = entryDecorator.getBookshelfAnimate();
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            urlDrawableOptions$default.mPlayGifImage = true;
            urlDrawableOptions$default.mUseApngImage = true;
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", 1);
            urlDrawableOptions$default.mExtraInfo = bundle;
            Unit unit = Unit.INSTANCE;
            final URLDrawable drawable = URLDrawable.getDrawable(bookshelfAnimate2, urlDrawableOptions$default);
            URLDrawable.URLDrawableListener uRLDrawableListener = new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.library.holder.LibraryImageViewHolder$bindBookshelfAnimate$$inlined$let$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                    SquareImageView animateImageView;
                    animateImageView = this.getAnimateImageView();
                    if (animateImageView != null) {
                        animateImageView.setVisibility(8);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareImageView animateImageView;
                    animateImageView = this.getAnimateImageView();
                    if (animateImageView != null) {
                        animateImageView.setVisibility(8);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable p06) {
                    SquareImageView animateImageView;
                    ApngDrawable.OnPlayRepeatListener onPlayRepeatListener;
                    if (p06 == null || !p06.isAnim()) {
                        animateImageView = this.getAnimateImageView();
                        if (animateImageView != null) {
                            animateImageView.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    this.onAnimatePlayRepeatListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.state.library.holder.LibraryImageViewHolder$bindBookshelfAnimate$$inlined$let$lambda$1.1
                        /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
                        
                            r2 = r2.getAnimateImageView();
                         */
                        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onPlayRepeat(int round) {
                            SquareImageView animateImageView2;
                            if (round <= 0 || animateImageView2 == null) {
                                return;
                            }
                            animateImageView2.setVisibility(8);
                        }
                    };
                    URLDrawable drawable2 = URLDrawable.this;
                    Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
                    Drawable currDrawable = drawable2.getCurrDrawable();
                    if (!(currDrawable instanceof ApngDrawable)) {
                        currDrawable = null;
                    }
                    ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
                    if (apngDrawable != null) {
                        onPlayRepeatListener = this.onAnimatePlayRepeatListener;
                        apngDrawable.setOnPlayRepeatListener(onPlayRepeatListener);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            };
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
                drawable.setURLDrawableListener(uRLDrawableListener);
            } else {
                uRLDrawableListener.onLoadSuccessed(drawable);
            }
            SquareImageView animateImageView = getAnimateImageView();
            if (animateImageView != null) {
                animateImageView.setVisibility(0);
            }
            SquareImageView animateImageView2 = getAnimateImageView();
            if (animateImageView2 != null) {
                animateImageView2.setImageDrawable(drawable);
            }
            SquareImageView animateImageView3 = getAnimateImageView();
            if (animateImageView3 != null) {
                ViewExtensionsKt.updateLayoutParams(animateImageView3, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.holder.LibraryImageViewHolder$bindBookshelfAnimate$$inlined$let$lambda$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                        invoke2(layoutParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(RelativeLayout.LayoutParams receiver) {
                        Intrinsics.checkNotNullParameter(receiver, "$receiver");
                        receiver.width = image.getSize().getWidth();
                        receiver.height = image.getSize().getHeight();
                    }
                });
            }
            ApngImage.playByTag(drawable.getURL().hashCode());
        }
    }

    private final void bindImage(LibraryDecoratorItem data) {
        final Image image = data.getDecorator().getImage();
        SquareImageView squareImageView = this.binding.image;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.image");
        ViewExtensionsKt.updateLayoutParams(squareImageView, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.holder.LibraryImageViewHolder$bindImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = Image.this.getSize().getWidth();
                receiver.height = Image.this.getSize().getHeight();
            }
        });
        SquareImageView squareImageView2 = this.binding.image;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.image");
        ViewExtensionsKt.setUri(squareImageView2, image.getUrl());
    }

    private final void bindListeners(final LibraryDecoratorItem data) {
        Decorator decorator = data.getDecorator();
        if (!(decorator instanceof EntryDecorator)) {
            decorator = null;
        }
        if (((EntryDecorator) decorator) != null) {
            this.binding.image.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.holder.LibraryImageViewHolder$bindListeners$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapItemController controller;
                    IMapViewListener listener;
                    controller = LibraryImageViewHolder.this.getController();
                    if (controller == null || (listener = controller.getListener()) == null) {
                        return;
                    }
                    LibraryImageViewHolder libraryImageViewHolder = LibraryImageViewHolder.this;
                    IMapViewListener.DefaultImpls.onItemClicked$default(listener, libraryImageViewHolder, libraryImageViewHolder.getIndex(), data, 6, null, 16, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareImageView getAnimateImageView() {
        return (SquareImageView) this.animateImageView.getValue();
    }

    public final VasSquareItemLibraryImageBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        super.onRecycled();
        this.binding.image.setImageDrawable(null);
        SquareImageView animateImageView = getAnimateImageView();
        if (animateImageView != null) {
            animateImageView.setImageDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.state.map.MapViewHolder
    public LibraryDecoratorItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof LibraryDecoratorItem)) {
            data = null;
        }
        return (LibraryDecoratorItem) data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(LibraryDecoratorItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        bindListeners(data);
        bindImage(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(LibraryDecoratorItem data, int index, int event) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.doBind((LibraryImageViewHolder) data, index, event);
        if (event != 2) {
            return;
        }
        bindBookshelfAnimate(data);
    }
}

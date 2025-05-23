package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.MediaListAdapter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseMediaItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaUploadStateView;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter$VH;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "Landroid/graphics/drawable/ColorDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/ColorDrawable;", "placeHolderDrawable", "<init>", "()V", "VH", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class MediaListAdapter extends ListAdapter<BaseMediaItem, VH> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ColorDrawable placeHolderDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u0010\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "imgView", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", "w", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "u", "E", "Landroid/widget/ImageView;", "imgIv", UserInfo.SEX_FEMALE, "delIv", "Landroid/view/View;", "G", "Landroid/view/View;", "playIcon", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", "H", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", "progressView", "I", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", "curItem", "Lqs2/a;", "J", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Lqs2/a;", "listener", "itemView", "<init>", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class VH extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private ImageView imgIv;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView delIv;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private View playIcon;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private HWMediaUploadStateView progressView;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private BaseMediaItem curItem;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final Lazy listener;
        final /* synthetic */ MediaListAdapter K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(@NotNull MediaListAdapter mediaListAdapter, final View itemView) {
            super(itemView);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.K = mediaListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<qs2.a>(itemView) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.MediaListAdapter$VH$listener$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $itemView;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$itemView = itemView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) itemView);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final qs2.a invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.troop.homework.common.widget.mediaedit.b.c(this.$itemView) : (qs2.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
                this.listener = lazy;
                View findViewById = itemView.findViewById(R.id.xvl);
                ImageView imageView = (ImageView) findViewById;
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Im\u2026CENTER_CROP\n            }");
                this.imgIv = imageView;
                TriggerRunnerKt.c(imageView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MediaListAdapter.VH.o(MediaListAdapter.VH.this, itemView, view);
                    }
                }, 1, null);
                View findViewById2 = itemView.findViewById(R.id.xwq);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_progress_view)");
                HWMediaUploadStateView hWMediaUploadStateView = (HWMediaUploadStateView) findViewById2;
                this.progressView = hWMediaUploadStateView;
                hWMediaUploadStateView.setOnRetryClickListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.MediaListAdapter.VH.3
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VH.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BaseMediaItem baseMediaItem = VH.this.curItem;
                        if (baseMediaItem != null) {
                            VH.this.x().j(baseMediaItem);
                        }
                    }
                });
                View findViewById3 = itemView.findViewById(R.id.xt7);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.item_del_iv)");
                ImageView imageView2 = (ImageView) findViewById3;
                this.delIv = imageView2;
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MediaListAdapter.VH.p(MediaListAdapter.VH.this, view);
                    }
                });
                View findViewById4 = itemView.findViewById(R.id.xwh);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.item_play_icon)");
                this.playIcon = findViewById4;
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaListAdapter, (Object) itemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(VH this$0, View itemView, View view) {
            Activity activity;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            BaseMediaItem baseMediaItem = this$0.curItem;
            if (baseMediaItem != null) {
                qs2.a x16 = this$0.x();
                Context context = itemView.getContext();
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                x16.m(baseMediaItem, activity);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(VH this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BaseMediaItem baseMediaItem = this$0.curItem;
            if (baseMediaItem != null) {
                this$0.x().y(baseMediaItem);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(BaseMediaItem item, final VH this$0) {
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.b(item, this$0.imgIv, new Function0<URLDrawable.URLDrawableOptions>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.MediaListAdapter$VH$bindData$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MediaListAdapter.VH.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final URLDrawable.URLDrawableOptions invoke() {
                    ImageView imageView;
                    URLDrawable.URLDrawableOptions w3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (URLDrawable.URLDrawableOptions) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    MediaListAdapter.VH vh5 = MediaListAdapter.VH.this;
                    imageView = vh5.imgIv;
                    w3 = vh5.w(imageView);
                    Intrinsics.checkNotNullExpressionValue(w3, "getImageLoadOption(imgIv)");
                    return w3;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final URLDrawable.URLDrawableOptions w(ImageView imgView) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            MediaListAdapter mediaListAdapter = this.K;
            obtain.mFailedDrawable = mediaListAdapter.placeHolderDrawable;
            obtain.mLoadingDrawable = mediaListAdapter.placeHolderDrawable;
            if (imgView.getWidth() > 0 && imgView.getHeight() > 0) {
                obtain.mRequestWidth = imgView.getWidth();
                obtain.mRequestHeight = imgView.getHeight();
            }
            return obtain;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final qs2.a x() {
            return (qs2.a) this.listener.getValue();
        }

        public final void u(@NotNull final BaseMediaItem item) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            this.curItem = item;
            ImageView imageView = this.delIv;
            int i16 = 0;
            if (item.isSupportDelete()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            View view = this.playIcon;
            if (!(item instanceof VideoItem)) {
                i16 = 8;
            }
            view.setVisibility(i16);
            this.progressView.d(item.getState(), item.getProgress(), item.getCompressProgress());
            if (this.imgIv.getWidth() <= 0) {
                this.imgIv.post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaListAdapter.VH.v(BaseMediaItem.this, this);
                    }
                });
            } else {
                com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.b(item, this.imgIv, new Function0<URLDrawable.URLDrawableOptions>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.medialist.MediaListAdapter$VH$bindData$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MediaListAdapter.VH.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final URLDrawable.URLDrawableOptions invoke() {
                        ImageView imageView2;
                        URLDrawable.URLDrawableOptions w3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (URLDrawable.URLDrawableOptions) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        MediaListAdapter.VH vh5 = MediaListAdapter.VH.this;
                        imageView2 = vh5.imgIv;
                        w3 = vh5.w(imageView2);
                        Intrinsics.checkNotNullExpressionValue(w3, "getImageLoadOption(imgIv)");
                        return w3;
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/medialist/MediaListAdapter$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", "oldItem", "newItem", "", "b", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends DiffUtil.ItemCallback<BaseMediaItem> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull BaseMediaItem oldItem, @NotNull BaseMediaItem newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull BaseMediaItem oldItem, @NotNull BaseMediaItem newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.areItemsTheSame(newItem);
        }
    }

    public MediaListAdapter() {
        super(new a());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.placeHolderDrawable = new ColorDrawable(Color.parseColor("#DEDEDE"));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull VH holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getCurrentList().size() > position) {
            BaseMediaItem baseMediaItem = getCurrentList().get(position);
            Intrinsics.checkNotNullExpressionValue(baseMediaItem, "currentList[position]");
            holder.u(baseMediaItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VH) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = xv3.a.a(parent).inflate(R.layout.f168609g13, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "parent.layoutInflater.in\u2026em_layout, parent, false)");
        return new VH(this, inflate);
    }
}

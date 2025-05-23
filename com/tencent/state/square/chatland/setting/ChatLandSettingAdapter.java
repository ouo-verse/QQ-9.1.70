package com.tencent.state.square.chatland.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkin;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinGroup;
import com.tencent.state.square.chatland.setting.ChatLandSettingAdapter;
import com.tencent.state.square.databinding.VasSquareBubbleItemBinding;
import com.tencent.state.square.databinding.ZtpSquareTaskSettingTitleBinding;
import com.tencent.state.utils.ColorFormatUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "broadcastSkinGroup", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;", "getBroadcastSkinGroup", "()Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;", "setBroadcastSkinGroup", "(Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;)V", "focusSkinGroup", "getFocusSkinGroup", "setFocusSkinGroup", "onGetMoreEffect", "Lkotlin/Function0;", "", "getOnGetMoreEffect", "()Lkotlin/jvm/functions/Function0;", "setOnGetMoreEffect", "(Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "BubbleViewHolder", "Companion", "TitleViewHolder", "ViewHolderType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "ChatLandSettingAdapter";
    private SquareBubbleSkinGroup broadcastSkinGroup = new SquareBubbleSkinGroup(0, null, null, 7, null);
    private SquareBubbleSkinGroup focusSkinGroup = new SquareBubbleSkinGroup(0, null, null, 7, null);
    private Function0<Unit> onGetMoreEffect;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/ZtpSquareTaskSettingTitleBinding;", "(Lcom/tencent/state/square/databinding/ZtpSquareTaskSettingTitleBinding;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    private static final class TitleViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(ZtpSquareTaskSettingTitleBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            TextView textView = binding.effectTitleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.effectTitleView");
            this.titleView = textView;
        }

        public final TextView getTitleView() {
            return this.titleView;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter$ViewHolderType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "TITLE", "ITEM", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public enum ViewHolderType {
        TITLE(1),
        ITEM(2);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int type;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter$ViewHolderType$Companion;", "", "()V", "fromInt", "Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter$ViewHolderType;", "value", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class Companion {
            Companion() {
            }

            public final ViewHolderType fromInt(int value) {
                for (ViewHolderType viewHolderType : ViewHolderType.values()) {
                    if (viewHolderType.getType() == value) {
                        return viewHolderType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        ViewHolderType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ViewHolderType.values().length];
            $EnumSwitchMapping$0 = iArr;
            ViewHolderType viewHolderType = ViewHolderType.TITLE;
            iArr[viewHolderType.ordinal()] = 1;
            int[] iArr2 = new int[ViewHolderType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[viewHolderType.ordinal()] = 1;
        }
    }

    public final SquareBubbleSkinGroup getBroadcastSkinGroup() {
        return this.broadcastSkinGroup;
    }

    public final SquareBubbleSkinGroup getFocusSkinGroup() {
        return this.focusSkinGroup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.broadcastSkinGroup.getSkins().size() + this.focusSkinGroup.getSkins().size() + 2;
    }

    public final Function0<Unit> getOnGetMoreEffect() {
        return this.onGetMoreEffect;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SquareBubbleSkinGroup squareBubbleSkinGroup;
        Object orNull;
        SquareBubbleSkin squareBubbleSkin;
        Object orNull2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (WhenMappings.$EnumSwitchMapping$1[ViewHolderType.INSTANCE.fromInt(holder.getItemViewType()).ordinal()] != 1) {
            if (!(holder instanceof BubbleViewHolder)) {
                holder = null;
            }
            BubbleViewHolder bubbleViewHolder = (BubbleViewHolder) holder;
            if (position <= this.broadcastSkinGroup.getSkins().size()) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.broadcastSkinGroup.getSkins(), position - 1);
                squareBubbleSkin = (SquareBubbleSkin) orNull2;
            } else {
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.focusSkinGroup.getSkins(), (position - this.broadcastSkinGroup.getSkins().size()) - 2);
                squareBubbleSkin = (SquareBubbleSkin) orNull;
            }
            if (squareBubbleSkin == null || bubbleViewHolder == null) {
                return;
            }
            bubbleViewHolder.doBindView(squareBubbleSkin);
            return;
        }
        TextView titleView = ((TitleViewHolder) holder).getTitleView();
        if (position == 0) {
            squareBubbleSkinGroup = this.broadcastSkinGroup;
        } else {
            squareBubbleSkinGroup = this.focusSkinGroup;
        }
        titleView.setText(squareBubbleSkinGroup.getGroupName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (WhenMappings.$EnumSwitchMapping$0[ViewHolderType.INSTANCE.fromInt(viewType).ordinal()] != 1) {
            VasSquareBubbleItemBinding inflate = VasSquareBubbleItemBinding.inflate(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareBubbleItemBindi\u2026ter.from(parent.context))");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new BubbleViewHolder(this, context, inflate);
        }
        ZtpSquareTaskSettingTitleBinding inflate2 = ZtpSquareTaskSettingTitleBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate2, "ZtpSquareTaskSettingTitl\u2026ter.from(parent.context))");
        LinearLayout root = inflate2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewExtensionsKt.dip((View) parent, 28)));
        return new TitleViewHolder(inflate2);
    }

    public final void setBroadcastSkinGroup(SquareBubbleSkinGroup squareBubbleSkinGroup) {
        Intrinsics.checkNotNullParameter(squareBubbleSkinGroup, "<set-?>");
        this.broadcastSkinGroup = squareBubbleSkinGroup;
    }

    public final void setFocusSkinGroup(SquareBubbleSkinGroup squareBubbleSkinGroup) {
        Intrinsics.checkNotNullParameter(squareBubbleSkinGroup, "<set-?>");
        this.focusSkinGroup = squareBubbleSkinGroup;
    }

    public final void setOnGetMoreEffect(Function0<Unit> function0) {
        this.onGetMoreEffect = function0;
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter$BubbleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "binding", "Lcom/tencent/state/square/databinding/VasSquareBubbleItemBinding;", "(Lcom/tencent/state/square/chatland/setting/ChatLandSettingAdapter;Landroid/content/Context;Lcom/tencent/state/square/databinding/VasSquareBubbleItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareBubbleItemBinding;", "getContext", "()Landroid/content/Context;", "bindLockButton", "", "status", "", "doBindView", "data", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkin;", "onClickLockBtn", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class BubbleViewHolder extends RecyclerView.ViewHolder {
        private final VasSquareBubbleItemBinding binding;
        private final Context context;
        final /* synthetic */ ChatLandSettingAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BubbleViewHolder(ChatLandSettingAdapter chatLandSettingAdapter, Context context, VasSquareBubbleItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = chatLandSettingAdapter;
            this.context = context;
            this.binding = binding;
        }

        public final void doBindView(final SquareBubbleSkin data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String showPic = data.getShowPic();
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            final WeakReference weakReference = new WeakReference(this.binding.bubbleIcon);
            URLDrawable drawable = URLDrawable.getDrawable(showPic, urlDrawableOptions$default);
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingAdapter$BubbleViewHolder$doBindView$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareBaseKt.getSquareLog().d("ChatLandSettingAdapter", "onLoadFailed $");
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable drawable2) {
                    SquareImageView squareImageView = (SquareImageView) weakReference.get();
                    if (squareImageView != null) {
                        squareImageView.setImageDrawable(drawable2);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            });
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
            }
            this.binding.bubbleIcon.setImageDrawable(drawable);
            TextView textView = this.binding.name;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.name");
            SquareBubbleInfo bubbleInfo = data.getBubbleInfo();
            textView.setText(bubbleInfo != null ? bubbleInfo.getName() : null);
            TextView textView2 = this.binding.validTimeLabel;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.validTimeLabel");
            textView2.setText(data.getSkinExpireTips());
            bindLockButton(data.getBubbleType());
            LinearLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setTag(Integer.valueOf(getPosition()));
            this.binding.bubbleItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingAdapter$BubbleViewHolder$doBindView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatLandSettingAdapter.BubbleViewHolder.this.onClickLockBtn(data);
                }
            });
        }

        public final VasSquareBubbleItemBinding getBinding() {
            return this.binding;
        }

        public final Context getContext() {
            return this.context;
        }

        private final void bindLockButton(int status) {
            if (status == 1) {
                SquareImageView squareImageView = this.binding.bubbleConfirm;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubbleConfirm");
                squareImageView.setVisibility(0);
                SquareImageView squareImageView2 = this.binding.bubbleLock;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.bubbleLock");
                squareImageView2.setVisibility(8);
                this.binding.name.setTextColor(-16777216);
                return;
            }
            if (status == 2) {
                SquareImageView squareImageView3 = this.binding.bubbleConfirm;
                Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.bubbleConfirm");
                squareImageView3.setVisibility(8);
                SquareImageView squareImageView4 = this.binding.bubbleLock;
                Intrinsics.checkNotNullExpressionValue(squareImageView4, "binding.bubbleLock");
                squareImageView4.setVisibility(8);
                TextView textView = this.binding.name;
                Integer parse = ColorFormatUtils.INSTANCE.parse("#888888");
                textView.setTextColor(parse != null ? parse.intValue() : -7829368);
                return;
            }
            if (status != 3) {
                if (status != 4) {
                    return;
                }
                SquareImageView squareImageView5 = this.binding.bubbleConfirm;
                Intrinsics.checkNotNullExpressionValue(squareImageView5, "binding.bubbleConfirm");
                squareImageView5.setVisibility(8);
                SquareImageView squareImageView6 = this.binding.bubbleLock;
                Intrinsics.checkNotNullExpressionValue(squareImageView6, "binding.bubbleLock");
                squareImageView6.setVisibility(8);
                return;
            }
            SquareImageView squareImageView7 = this.binding.bubbleConfirm;
            Intrinsics.checkNotNullExpressionValue(squareImageView7, "binding.bubbleConfirm");
            squareImageView7.setVisibility(8);
            SquareImageView squareImageView8 = this.binding.bubbleLock;
            Intrinsics.checkNotNullExpressionValue(squareImageView8, "binding.bubbleLock");
            squareImageView8.setVisibility(0);
            TextView textView2 = this.binding.name;
            Integer parse2 = ColorFormatUtils.INSTANCE.parse("#888888");
            textView2.setTextColor(parse2 != null ? parse2.intValue() : -7829368);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11, types: [com.tencent.state.square.bubblesetting.SquareBubbleSkinGroup, T] */
        /* JADX WARN: Type inference failed for: r1v7, types: [com.tencent.state.square.bubblesetting.SquareBubbleSkinGroup, T] */
        public final void onClickLockBtn(SquareBubbleSkin data) {
            Map<String, Object> mutableMapOf;
            Map<String, Object> mutableMapOf2;
            Integer valueOf = data != null ? Integer.valueOf(data.getBubbleType()) : null;
            if (valueOf != null && valueOf.intValue() == 4) {
                Function0<Unit> onGetMoreEffect = this.this$0.getOnGetMoreEffect();
                if (onGetMoreEffect != null) {
                    onGetMoreEffect.invoke();
                    return;
                }
                return;
            }
            if (valueOf != null && valueOf.intValue() == 2) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ACTION_UNLOCK_SITUATION, 0));
                squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ZPLAN_BUBBLE_CLICK, mutableMapOf2);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = this.this$0.getFocusSkinGroup();
                if (getAdapterPosition() <= this.this$0.getBroadcastSkinGroup().getSkins().size()) {
                    objectRef.element = this.this$0.getBroadcastSkinGroup();
                }
                SquareBubbleInfo bubbleInfo = data.getBubbleInfo();
                if (bubbleInfo != null) {
                    final int id5 = bubbleInfo.getId();
                    ZTPSquareRewardService.INSTANCE.dressSkin(((SquareBubbleSkinGroup) objectRef.element).getGroupId(), id5, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.setting.ChatLandSettingAdapter$BubbleViewHolder$onClickLockBtn$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            if (z16) {
                                SquareBaseKt.getSquareLog().i("ChatLandSettingAdapter", "dress up new bubble " + id5);
                                if (this.getAdapterPosition() <= this.this$0.getBroadcastSkinGroup().getSkins().size()) {
                                    for (SquareBubbleSkin squareBubbleSkin : this.this$0.getBroadcastSkinGroup().getSkins()) {
                                        if (squareBubbleSkin.getBubbleType() == 1) {
                                            squareBubbleSkin.setBubbleType(2);
                                        }
                                    }
                                    this.this$0.getBroadcastSkinGroup().getSkins().get(this.getAdapterPosition() - 1).setBubbleType(1);
                                } else {
                                    for (SquareBubbleSkin squareBubbleSkin2 : this.this$0.getFocusSkinGroup().getSkins()) {
                                        if (squareBubbleSkin2.getBubbleType() == 1) {
                                            squareBubbleSkin2.setBubbleType(2);
                                        }
                                    }
                                    this.this$0.getFocusSkinGroup().getSkins().get((this.getAdapterPosition() - this.this$0.getBroadcastSkinGroup().getSkins().size()) - 2).setBubbleType(1);
                                }
                                Square.INSTANCE.getConfig().getCommonUtils().showToast(this.getContext(), this.getContext().getString(R.string.xeu), 2);
                                this.this$0.notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (valueOf != null && valueOf.intValue() == 3) {
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ACTION_UNLOCK_SITUATION, 1));
                squareReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ZPLAN_BUBBLE_CLICK, mutableMapOf);
                String jumpUrl = data.getJumpUrl();
                if (jumpUrl != null) {
                    SquareBaseKt.getSquareRouter().routeLink(this.context, new EntranceLink(jumpUrl, 2));
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return ViewHolderType.TITLE.getType();
        }
        int size = this.broadcastSkinGroup.getSkins().size();
        if (1 <= position && size >= position) {
            return ViewHolderType.ITEM.getType();
        }
        if (position == this.broadcastSkinGroup.getSkins().size() + 1) {
            return ViewHolderType.TITLE.getType();
        }
        return ViewHolderType.ITEM.getType();
    }
}

package com.tencent.state.square.bubblesetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ZTPSquareRewardService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.bubblesetting.BubbleAdapter;
import com.tencent.state.square.databinding.VasSquareBubbleItemBinding;
import com.tencent.state.square.event.UpdateBubbleSkinEvent;
import com.tencent.state.utils.ColorFormatUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/bubblesetting/BubbleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/bubblesetting/BubbleAdapter$ViewHolder;", "()V", "onGetMoreEffect", "Lkotlin/Function0;", "", "getOnGetMoreEffect", "()Lkotlin/jvm/functions/Function0;", "setOnGetMoreEffect", "(Lkotlin/jvm/functions/Function0;)V", "skinGroup", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;", "getSkinGroup", "()Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;", "setSkinGroup", "(Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "BubbleAdapter";
    private Function0<Unit> onGetMoreEffect;
    private SquareBubbleSkinGroup skinGroup = new SquareBubbleSkinGroup(0, null, null, 7, null);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.skinGroup.getSkins().size();
    }

    public final Function0<Unit> getOnGetMoreEffect() {
        return this.onGetMoreEffect;
    }

    public final SquareBubbleSkinGroup getSkinGroup() {
        return this.skinGroup;
    }

    public final void setOnGetMoreEffect(Function0<Unit> function0) {
        this.onGetMoreEffect = function0;
    }

    public final void setSkinGroup(SquareBubbleSkinGroup squareBubbleSkinGroup) {
        Intrinsics.checkNotNullParameter(squareBubbleSkinGroup, "<set-?>");
        this.skinGroup = squareBubbleSkinGroup;
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/bubblesetting/BubbleAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "binding", "Lcom/tencent/state/square/databinding/VasSquareBubbleItemBinding;", "(Lcom/tencent/state/square/bubblesetting/BubbleAdapter;Landroid/content/Context;Lcom/tencent/state/square/databinding/VasSquareBubbleItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareBubbleItemBinding;", "getContext", "()Landroid/content/Context;", "bindLockButton", "", "status", "", "doBindView", "data", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkin;", "onClickLockBtn", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final VasSquareBubbleItemBinding binding;
        private final Context context;
        final /* synthetic */ BubbleAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BubbleAdapter bubbleAdapter, Context context, VasSquareBubbleItemBinding binding) {
            super(binding.getMRv());
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = bubbleAdapter;
            this.context = context;
            this.binding = binding;
        }

        public final void doBindView(final SquareBubbleSkin data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String showPic = data.getShowPic();
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            final WeakReference weakReference = new WeakReference(this.binding.bubbleIcon);
            URLDrawable drawable = URLDrawable.getDrawable(showPic, urlDrawableOptions$default);
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.bubblesetting.BubbleAdapter$ViewHolder$doBindView$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "BubbleAdapter", "onLoadFailed $", null, 4, null);
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
            this.binding.bubbleItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.bubblesetting.BubbleAdapter$ViewHolder$doBindView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BubbleAdapter.ViewHolder.this.onClickLockBtn(data);
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
        public final void onClickLockBtn(final SquareBubbleSkin data) {
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
                SquareBubbleInfo bubbleInfo = data.getBubbleInfo();
                if (bubbleInfo != null) {
                    final int id5 = bubbleInfo.getId();
                    ZTPSquareRewardService.INSTANCE.dressSkin(this.this$0.getSkinGroup().getGroupId(), id5, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.bubblesetting.BubbleAdapter$ViewHolder$onClickLockBtn$$inlined$let$lambda$1
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
                            Map<String, Object> mutableMapOf3;
                            if (z16) {
                                SquareBaseKt.getSquareLog().i("BubbleAdapter", "dress up new bubble " + id5);
                                for (SquareBubbleSkin squareBubbleSkin : this.this$0.getSkinGroup().getSkins()) {
                                    if (squareBubbleSkin.getBubbleType() == 1) {
                                        squareBubbleSkin.setBubbleType(2);
                                    }
                                }
                                this.this$0.getSkinGroup().getSkins().get(this.getAdapterPosition()).setBubbleType(1);
                                Square square = Square.INSTANCE;
                                SimpleEventBus.getInstance().dispatchEvent(new UpdateBubbleSkinEvent(square.getConfig().getCommonUtils().getCurrentAccountUin(), data.getBubbleInfo()));
                                square.getConfig().getCommonUtils().showToast(this.getContext(), this.getContext().getString(R.string.xeu), 2);
                                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                                mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ACTION_BUBBLE_ID, Integer.valueOf(id5)));
                                squareReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ZPLAN_BUBBLE_USE, mutableMapOf3);
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.skinGroup.getSkins(), position);
        SquareBubbleSkin squareBubbleSkin = (SquareBubbleSkin) orNull;
        if (squareBubbleSkin != null) {
            holder.doBindView(squareBubbleSkin);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareBubbleItemBinding inflate = VasSquareBubbleItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareBubbleItemBindi\u2026ter.from(parent.context))");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(this, context, inflate);
    }
}

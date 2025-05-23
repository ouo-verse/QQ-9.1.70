package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.databinding.VasSquareChatLandSpeakBubbleBinding;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.ViewUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0018\u001a\u00020\rJ\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandSpeakBubbleView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandSpeakBubbleBinding;", "endCb", "Lkotlin/Function0;", "", "lastTask", "Ljava/lang/Runnable;", "bindBubble", "data", "Lcom/tencent/state/template/push/BubbleMessage;", "speakingSkin", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "hideBubble", "initView", "startCb", "resetView", "updateBubbleSkin", VasPerfReportUtils.WHILE_UPDATE_ITEM, "isMe", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSpeakBubbleView extends RelativeLayout {
    private static final String TAG = "ChatLandSpeakBubbleView";
    private final VasSquareChatLandSpeakBubbleBinding binding;
    private Function0<Unit> endCb;
    private Runnable lastTask;

    public ChatLandSpeakBubbleView(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideBubble(BubbleMessage data) {
        final WeakReference weakReference = new WeakReference(this);
        this.lastTask = SquareBaseKt.getSquareThread().postOnSubThreadDelay(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView$hideBubble$1
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
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView$hideBubble$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0022, code lost:
                    
                        r0 = r0.endCb;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2() {
                        VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding;
                        Function0 function0;
                        vasSquareChatLandSpeakBubbleBinding = ChatLandSpeakBubbleView.this.binding;
                        RelativeLayout mRv = vasSquareChatLandSpeakBubbleBinding.getMRv();
                        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
                        ViewExtensionsKt.setVisibility(mRv, false);
                        ChatLandSpeakBubbleView chatLandSpeakBubbleView = (ChatLandSpeakBubbleView) weakReference.get();
                        if (chatLandSpeakBubbleView == null || function0 == null) {
                            return;
                        }
                    }
                });
            }
        }, data.getLastTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(BubbleMessage data, boolean isMe) {
        TextView textView = this.binding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(data.getText());
        this.binding.textView.setTextColor(-1);
        RelativeLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        ViewExtensionsKt.setVisibility(mRv, true);
        SquareImageView squareImageView = this.binding.bubbleArrow;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubbleArrow");
        DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
        squareImageView.setBackground(drawableUtil.getDrawable(isMe ? R.drawable.i8a : R.drawable.i8b));
        LinearLayout linearLayout = this.binding.textContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.textContainer");
        linearLayout.setBackground(drawableUtil.getDrawable(isMe ? R.drawable.gvg : R.drawable.gvf));
        hideBubble(data);
    }

    public final void initView(BubbleMessage data, SquareBubbleInfo speakingSkin, Function0<Unit> startCb, Function0<Unit> endCb) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(startCb, "startCb");
        Intrinsics.checkNotNullParameter(endCb, "endCb");
        if (!data.getCanShow()) {
            endCb.invoke();
            return;
        }
        Runnable runnable = this.lastTask;
        if (runnable != null) {
            SquareBaseKt.getSquareThread().removeTask(runnable);
        }
        startCb.invoke();
        this.endCb = endCb;
        bindBubble(data, speakingSkin);
    }

    public final void resetView() {
        Runnable runnable = this.lastTask;
        if (runnable != null) {
            SquareBaseKt.getSquareThread().removeTask(runnable);
        }
        RelativeLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        ViewExtensionsKt.setVisibility(mRv, false);
    }

    public ChatLandSpeakBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ChatLandSpeakBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void bindBubble(final BubbleMessage data, final SquareBubbleInfo speakingSkin) {
        if (speakingSkin != null) {
            if (SquareBubbleSkinKt.isReady(speakingSkin)) {
                updateBubbleSkin(data, speakingSkin);
            } else {
                BubbleSkinDownloadManager.INSTANCE.getBubbleSkinBitmap(speakingSkin.getSpeakingBubbleUrl(), new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView$bindBubble$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                        invoke2(bitmap);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Bitmap bitmap) {
                        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                        speakingSkin.setBitmap(bitmap);
                        ChatLandSpeakBubbleView.this.updateBubbleSkin(data, speakingSkin);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBubbleSkin(final BubbleMessage data, final SquareBubbleInfo speakingSkin) {
        if (speakingSkin == null) {
            updateView(data, CommonDataKt.isMe(data.getUin()));
        } else {
            this.binding.textContainer.post(new Runnable() { // from class: com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView$updateBubbleSkin$1
                @Override // java.lang.Runnable
                public final void run() {
                    VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding;
                    final int dip = com.tencent.state.square.common.ViewExtensionsKt.dip(ChatLandSpeakBubbleView.this.getContext(), 8);
                    final int dip2 = com.tencent.state.square.common.ViewExtensionsKt.dip(ChatLandSpeakBubbleView.this.getContext(), 8);
                    if (!SquareBubbleSkinKt.useDefault(speakingSkin)) {
                        BubbleSkinDownloadManager bubbleSkinDownloadManager = BubbleSkinDownloadManager.INSTANCE;
                        Context context = ChatLandSpeakBubbleView.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        bubbleSkinDownloadManager.loadBubbleNinePatchDrawable(context, new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandSpeakBubbleView$updateBubbleSkin$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                                invoke2(bitmap);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Bitmap bitmap) {
                                VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding2;
                                VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding3;
                                VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding4;
                                VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding5;
                                VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding6;
                                VasSquareChatLandSpeakBubbleBinding vasSquareChatLandSpeakBubbleBinding7;
                                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                Context context2 = ChatLandSpeakBubbleView.this.getContext();
                                Intrinsics.checkNotNullExpressionValue(context2, "context");
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context2.getResources(), speakingSkin.getBitmap(), bitmap.getNinePatchChunk(), null, null);
                                vasSquareChatLandSpeakBubbleBinding2 = ChatLandSpeakBubbleView.this.binding;
                                LinearLayout linearLayout = vasSquareChatLandSpeakBubbleBinding2.textContainer;
                                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.textContainer");
                                linearLayout.setBackground(ninePatchDrawable);
                                ViewUtils viewUtils = ViewUtils.INSTANCE;
                                String arrow = speakingSkin.getArrow();
                                vasSquareChatLandSpeakBubbleBinding3 = ChatLandSpeakBubbleView.this.binding;
                                SquareImageView squareImageView = vasSquareChatLandSpeakBubbleBinding3.bubbleArrow;
                                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubbleArrow");
                                viewUtils.loadImageDrawable(arrow, squareImageView);
                                vasSquareChatLandSpeakBubbleBinding4 = ChatLandSpeakBubbleView.this.binding;
                                RelativeLayout mRv = vasSquareChatLandSpeakBubbleBinding4.getMRv();
                                Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
                                ViewExtensionsKt.setVisibility(mRv, true);
                                vasSquareChatLandSpeakBubbleBinding5 = ChatLandSpeakBubbleView.this.binding;
                                TextView textView = vasSquareChatLandSpeakBubbleBinding5.textView;
                                Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
                                textView.setText(data.getText());
                                vasSquareChatLandSpeakBubbleBinding6 = ChatLandSpeakBubbleView.this.binding;
                                vasSquareChatLandSpeakBubbleBinding6.textView.setTextColor(-16777216);
                                vasSquareChatLandSpeakBubbleBinding7 = ChatLandSpeakBubbleView.this.binding;
                                LinearLayout linearLayout2 = vasSquareChatLandSpeakBubbleBinding7.textContainer;
                                int i3 = dip;
                                int i16 = dip2;
                                linearLayout2.setPadding(i3 * 2, i16, i3 * 2, i16);
                                ChatLandSpeakBubbleView$updateBubbleSkin$1 chatLandSpeakBubbleView$updateBubbleSkin$1 = ChatLandSpeakBubbleView$updateBubbleSkin$1.this;
                                ChatLandSpeakBubbleView.this.hideBubble(data);
                            }
                        });
                        return;
                    }
                    ChatLandSpeakBubbleView chatLandSpeakBubbleView = ChatLandSpeakBubbleView.this;
                    BubbleMessage bubbleMessage = data;
                    chatLandSpeakBubbleView.updateView(bubbleMessage, CommonDataKt.isMe(bubbleMessage.getUin()));
                    vasSquareChatLandSpeakBubbleBinding = ChatLandSpeakBubbleView.this.binding;
                    vasSquareChatLandSpeakBubbleBinding.textContainer.setPadding(dip, dip2, dip, dip2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSpeakBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareChatLandSpeakBubbleBinding inflate = VasSquareChatLandSpeakBubbleBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandSpeakBu\u2026rom(context), this, true)");
        this.binding = inflate;
    }
}

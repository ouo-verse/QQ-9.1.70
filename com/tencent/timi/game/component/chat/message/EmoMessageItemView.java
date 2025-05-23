package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimiEmoData;
import trpc.yes.common.MessageOuterClass$TimiPkgEmoticonData;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/component/chat/message/EmoMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Lcom/tencent/image/URLDrawable;", "d", "", "O", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "I", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "p", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "f0", "Landroid/graphics/drawable/Drawable;", "defaultColorDrawable", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "g0", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "mContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "h0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class EmoMessageItemView extends BaseMessageView {

    /* renamed from: i0, reason: collision with root package name */
    private static final int f376450i0 = com.tencent.timi.game.utils.b.a(165);

    /* renamed from: j0, reason: collision with root package name */
    private static final int f376451j0 = com.tencent.timi.game.utils.b.a(56);

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final Drawable defaultColorDrawable;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundCornerImageView mContent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmoMessageItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(URLDrawable d16) {
        Integer num;
        int i3;
        int intrinsicWidth = d16.getIntrinsicWidth();
        int intrinsicHeight = d16.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.mContent.getLayoutParams();
        Integer num2 = null;
        if (layoutParams != null) {
            num = Integer.valueOf(layoutParams.width);
        } else {
            num = null;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mContent.getLayoutParams();
        if (layoutParams2 != null) {
            num2 = Integer.valueOf(layoutParams2.height);
        }
        com.tencent.timi.game.utils.l.i("EmoMessageItemView_", "adjustSizeWithDrawable " + intrinsicWidth + ", " + intrinsicHeight + ", " + num + ", " + num2);
        ViewGroup.LayoutParams layoutParams3 = this.mContent.getLayoutParams();
        if (layoutParams3 != null) {
            int intrinsicWidth2 = d16.getIntrinsicWidth();
            int i16 = f376450i0;
            if (intrinsicWidth2 >= i16) {
                i3 = i16;
            } else {
                int intrinsicWidth3 = d16.getIntrinsicWidth();
                i3 = f376451j0;
                if (intrinsicWidth3 > i3) {
                    i3 = d16.getIntrinsicWidth();
                }
            }
            layoutParams3.width = i3;
            if (d16.getIntrinsicHeight() < i16) {
                int intrinsicHeight2 = d16.getIntrinsicHeight();
                i16 = f376451j0;
                if (intrinsicHeight2 > i16) {
                    i16 = d16.getIntrinsicHeight();
                }
            }
            layoutParams3.height = i16;
            this.mContent.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    public void I(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        URLDrawable g16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        MessageOuterClass$TimiEmoData messageOuterClass$TimiEmoData = msg2.a().timi_emo_msg.msg_data.get();
        com.tencent.timi.game.utils.l.i("EmoMessageItemView_", "renderUI type:" + messageOuterClass$TimiEmoData.type.get() + ", url:" + messageOuterClass$TimiEmoData.url.get() + ", epId:" + messageOuterClass$TimiEmoData.pkgEmoData.epId.get() + ", eId:" + messageOuterClass$TimiEmoData.pkgEmoData.eId.get());
        int i3 = messageOuterClass$TimiEmoData.type.get();
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                g16 = null;
            } else {
                RoundCornerImageView roundCornerImageView = this.mContent;
                MessageOuterClass$TimiPkgEmoticonData messageOuterClass$TimiPkgEmoticonData = messageOuterClass$TimiEmoData.pkgEmoData.get();
                Intrinsics.checkNotNullExpressionValue(messageOuterClass$TimiPkgEmoticonData, "timiMsgData.pkgEmoData.get()");
                g16 = th4.s.b(roundCornerImageView, EmotionConstants.FROM_AIO, messageOuterClass$TimiPkgEmoticonData);
            }
        } else {
            RoundCornerImageView roundCornerImageView2 = this.mContent;
            String str = messageOuterClass$TimiEmoData.url.get();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.defaultColorDrawable;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mPlayGifImage = true;
            obtain.mGifRoundCorner = com.tencent.timi.game.utils.b.c(8);
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026dpf\n                    }");
            g16 = com.tencent.timi.game.utils.b.g(roundCornerImageView2, str, obtain);
        }
        if (g16 == null) {
            return;
        }
        if (g16.getStatus() == 1) {
            O(g16);
        } else {
            g16.setURLDrawableListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    @Nullable
    public LongClickOperOption[] p() {
        ArrayList arrayList = new ArrayList();
        LongClickOperOption[] p16 = super.p();
        if (p16 != null) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, p16);
        }
        arrayList.add(LongClickOperOption.FAVORITE);
        Object[] array = arrayList.toArray(new LongClickOperOption[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (LongClickOperOption[]) array;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmoMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EmoMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmoMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultColorDrawable = context.getResources().getDrawable(R.drawable.o77);
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(context, null, 0, 6, null);
        this.mContent = roundCornerImageView;
        int i16 = f376451j0;
        roundCornerImageView.setMinimumWidth(i16);
        roundCornerImageView.setMinimumHeight(i16);
        int i17 = f376450i0;
        roundCornerImageView.setMaxWidth(i17);
        roundCornerImageView.setMaxHeight(i17);
        roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        roundCornerImageView.setRadius(com.tencent.timi.game.utils.b.c(8));
        setContentView(roundCornerImageView, new FrameLayout.LayoutParams(i17, i17));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/component/chat/message/EmoMessageItemView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "p0", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            if (drawable != null) {
                EmoMessageItemView.this.O(drawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
        }
    }
}

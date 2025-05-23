package com.tencent.mobileqq.aio.msglist.holder.component.videochat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.ITextSetting;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView;", "Landroid/widget/FrameLayout;", "", "c", "Landroid/widget/TextView;", "textView", "Landroid/graphics/drawable/Drawable;", "icon", "e", "", "iconWidth", "iconHeight", "Lkotlin/Pair;", "d", "", "text", "setContent", "Landroid/content/res/ColorStateList;", "textColor", "linkTextColor", "setTextColor", "Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView$a;", "listener", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView$a;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class AIOVideoChatResultView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView$a;", "", "", NodeProps.ON_CLICK, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
        void onClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOVideoChatResultView(@NotNull Context context, @NotNull a listener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) listener);
            return;
        }
        this.listener = listener;
        c();
        TextView textView = this.textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        e(textView, context.getResources().getDrawable(R.drawable.qav_audio_icon_self_normal));
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.videochat.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOVideoChatResultView.b(AIOVideoChatResultView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOVideoChatResultView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listener.onClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void c() {
        TextView textView = new TextView(getContext());
        textView.setId(R.id.sk7);
        textView.setGravity(16);
        textView.setText("(no content)");
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.skin_chat_buble));
        textView.setTextSize(0, textView.getContext().getResources().getDimensionPixelOffset(R.dimen.f158275c1));
        this.textView = textView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
    }

    private final Pair<Integer, Integer> d(int iconWidth, int iconHeight) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.cys);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.cyt);
        int chatTextSizeType = ((ITextSetting) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITextSetting.class)).getChatTextSizeType();
        float f16 = 1.0f;
        if (chatTextSizeType == 1 || chatTextSizeType == 2 || chatTextSizeType == 3) {
            f16 = (r2.getChatTextSize() * 1.0f) / dimensionPixelSize;
        }
        return new Pair<>(Integer.valueOf((iconWidth * iconHeight) / iconHeight), Integer.valueOf((int) ((f16 * dimensionPixelSize) + dimensionPixelSize2)));
    }

    private final void e(TextView textView, Drawable icon) {
        if (icon == null) {
            textView.setCompoundDrawables(null, null, null, null);
            return;
        }
        Pair<Integer, Integer> d16 = d(icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
        icon.setBounds(0, 0, d16.getFirst().intValue(), d16.getSecond().intValue());
        textView.setCompoundDrawables(icon, null, null, null);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.f158206ab));
    }

    public final void setContent(@NotNull String text, @Nullable Drawable icon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) text, (Object) icon);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setText(text);
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView2 = textView3;
        }
        e(textView2, icon);
    }

    public final void setTextColor(@Nullable ColorStateList textColor, @Nullable ColorStateList linkTextColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textColor, (Object) linkTextColor);
            return;
        }
        TextView textView = null;
        if (textColor != null) {
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView2 = null;
            }
            textView2.setTextColor(textColor);
        }
        if (linkTextColor != null) {
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView3;
            }
            textView.setLinkTextColor(linkTextColor);
        }
    }
}

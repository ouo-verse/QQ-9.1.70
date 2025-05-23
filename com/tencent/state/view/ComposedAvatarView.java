package com.tencent.state.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.NickName;
import com.tencent.state.square.databinding.VasSquareAvatarWithNameBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0015J&\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0015H\u0002R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/view/ComposedAvatarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatar", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "getAvatar", "()Lcom/tencent/state/square/avatar/SquareAvatarView;", "binding", "Lcom/tencent/state/square/databinding/VasSquareAvatarWithNameBinding;", "name", "Landroid/view/View;", "getName", "()Landroid/view/View;", "bindNickName", "", "Lcom/tencent/state/square/data/NickName;", "bindUnreadInfo", "unReadCount", "isMe", "", "forbiddenNotify", "pttMsgIconShowed", "getIntimateIcon", "Lcom/tencent/state/view/SquareImageView;", "getUnreadCountString", "", "setNameText", "view", "Landroid/widget/TextView;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ComposedAvatarView extends LinearLayout {
    private final SquareAvatarView avatar;
    private final VasSquareAvatarWithNameBinding binding;
    private final View name;

    public ComposedAvatarView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void setNameText(TextView view, NickName name) {
        TextPaint paint = view.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "view.paint");
        paint.setFakeBoldText(name.isMe());
        view.setTextSize(name.isMe() ? 14.0f : 12.0f);
        view.setText(name.getNick());
    }

    public final void bindNickName(NickName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        FrameLayout frameLayout = this.binding.avatarNameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarNameContainer");
        frameLayout.setVisibility(0);
        TextView textView = this.binding.avatarText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarText");
        setNameText(textView, name);
    }

    public final SquareAvatarView getAvatar() {
        return this.avatar;
    }

    public final SquareImageView getIntimateIcon() {
        SquareImageView squareImageView = this.binding.avatarIntimateIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarIntimateIcon");
        return squareImageView;
    }

    public final View getName() {
        return this.name;
    }

    public ComposedAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ComposedAvatarView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposedAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareAvatarWithNameBinding inflate = VasSquareAvatarWithNameBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareAvatarWithNameB\u2026ater.from(context), this)");
        this.binding = inflate;
        SquareAvatarView squareAvatarView = inflate.avatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.avatarImage");
        this.avatar = squareAvatarView;
        FrameLayout frameLayout = inflate.avatarNameContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarNameContainer");
        this.name = frameLayout;
        setOrientation(1);
    }

    private final String getUnreadCountString(int unReadCount) {
        if (unReadCount <= 99) {
            return String.valueOf(unReadCount);
        }
        return "99+";
    }

    public final void bindUnreadInfo(int unReadCount, boolean isMe, boolean forbiddenNotify, boolean pttMsgIconShowed) {
        boolean z16 = unReadCount > 0 && !isMe;
        this.binding.avatarNameContainer.setBackgroundResource(z16 ? R.drawable.gre : 0);
        TextView textView = this.binding.avatarNameUnread;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarNameUnread");
        textView.setVisibility(z16 ? 0 : 8);
        TextView textView2 = this.binding.avatarNameUnread;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.avatarNameUnread");
        textView2.setText(getUnreadCountString(unReadCount));
        TextView textView3 = this.binding.avatarNameUnread;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.avatarNameUnread");
        textView3.setSelected(!forbiddenNotify);
        TextView textView4 = this.binding.avatarText;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.avatarText");
        ViewGroup.LayoutParams layoutParams = textView4.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        }
        layoutParams2.weight = 1.0f;
        layoutParams2.setMarginStart(z16 ? ViewExtensionsKt.dip(getContext(), 4) : 0);
        TextView textView5 = this.binding.avatarText;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.avatarText");
        textView5.setLayoutParams(layoutParams2);
    }
}

package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SendGiftMessageSelfItemView;", "Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView;", "Lcom/tencent/image/URLImageView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "X", "Landroid/widget/TextView;", "V", "Landroid/view/View;", "W", "T", "j0", "Lcom/tencent/image/URLImageView;", "giftIv", "k0", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "usrNameTv", "l0", "Landroid/widget/TextView;", "sendGiftDetailTv", "m0", "Landroid/view/View;", "usrNameClickView", "n0", "usrNamePrefixTv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SendGiftMessageSelfItemView extends SendGiftMessageBaseItemView {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private URLImageView giftIv;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarTextView usrNameTv;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView sendGiftDetailTv;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View usrNameClickView;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView usrNamePrefixTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftMessageSelfItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    @Override // com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView
    @NotNull
    /* renamed from: R, reason: from getter */
    public URLImageView getGiftIv() {
        return this.giftIv;
    }

    @Override // com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView
    @NotNull
    /* renamed from: T, reason: from getter */
    public TextView getUsrNamePrefixTv() {
        return this.usrNamePrefixTv;
    }

    @Override // com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView
    @NotNull
    /* renamed from: V, reason: from getter */
    public TextView getSendGiftDetailTv() {
        return this.sendGiftDetailTv;
    }

    @Override // com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView
    @NotNull
    /* renamed from: W, reason: from getter */
    public View getUsrNameClickView() {
        return this.usrNameClickView;
    }

    @Override // com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView
    @NotNull
    /* renamed from: X, reason: from getter */
    public AvatarTextView getUsrNameTv() {
        return this.usrNameTv;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftMessageSelfItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ SendGiftMessageSelfItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftMessageSelfItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setContentView(R.layout.hwc);
        View findViewById = findViewById(R.id.f115846x5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.usrNamePrefixTv)");
        this.usrNamePrefixTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.vog);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.giftIv)");
        this.giftIv = (URLImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f115856x6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.usrNameTv)");
        this.usrNameTv = (AvatarTextView) findViewById3;
        View findViewById4 = findViewById(R.id.f83024ig);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.sendGiftDetailTv)");
        this.sendGiftDetailTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.txy);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.clickView)");
        this.usrNameClickView = findViewById5;
    }
}

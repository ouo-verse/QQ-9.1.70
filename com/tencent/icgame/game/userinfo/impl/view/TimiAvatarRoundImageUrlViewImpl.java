package com.tencent.icgame.game.userinfo.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.ui.widget.TimiRoundImageView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u001d\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000e\u0010\u0012B%\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/game/userinfo/impl/view/TimiAvatarRoundImageUrlViewImpl;", "Lcom/tencent/icgame/game/ui/widget/TimiRoundImageView;", "", "url", "", "setAvatarUrl", "", "f", "I", "defaultResId", h.F, "avatarSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class TimiAvatarRoundImageUrlViewImpl extends TimiRoundImageView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int defaultResId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int avatarSize;

    public TimiAvatarRoundImageUrlViewImpl(@Nullable Context context) {
        super(context);
        this.avatarSize = 128;
        this.defaultResId = R.drawable.ovu;
    }

    public final void setAvatarUrl(@Nullable String url) {
        if (TextUtils.isEmpty(url)) {
            setImageResource(this.defaultResId);
        } else {
            ly0.b.f415756a.g(url, this, this.avatarSize);
        }
    }

    public TimiAvatarRoundImageUrlViewImpl(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avatarSize = 128;
        this.defaultResId = R.drawable.ovu;
    }

    public TimiAvatarRoundImageUrlViewImpl(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.avatarSize = 128;
        this.defaultResId = R.drawable.ovu;
    }
}

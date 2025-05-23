package com.tencent.mobileqq.guild.discoveryv2.content.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\r\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshLoadingView;", "Landroid/widget/ImageView;", "", "c", "b", "e", "a", "d", "", "Z", "isAnimPlaying", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes13.dex */
public final class RefreshLoadingView extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimPlaying;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefreshLoadingView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        int i3;
        if (GuildThemeManager.f235286a.b()) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), i3));
    }

    private final void c() {
        int i3;
        if (GuildThemeManager.f235286a.b()) {
            i3 = R.drawable.guild_loading_white;
        } else {
            i3 = R.drawable.guild_loading_black;
        }
        setImageResource(i3);
    }

    public final void a() {
        if (this.isAnimPlaying) {
            return;
        }
        b();
        this.isAnimPlaying = true;
    }

    public final void d() {
        if (!this.isAnimPlaying) {
            return;
        }
        c();
        this.isAnimPlaying = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefreshLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }

    public final void e() {
    }
}

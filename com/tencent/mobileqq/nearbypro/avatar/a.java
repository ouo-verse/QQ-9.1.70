package com.tencent.mobileqq.nearbypro.avatar;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.avatar.filament.SquareAvatarFilamentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/a;", "", "", "filamentOn", "Landroid/content/Context;", "ctx", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f253200a = new a();

    a() {
    }

    @NotNull
    public final ISquareAvatarView a(boolean filamentOn, @NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (filamentOn) {
            SquareAvatarFilamentView squareAvatarFilamentView = new SquareAvatarFilamentView(ctx, null, 0, 6, null);
            squareAvatarFilamentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return squareAvatarFilamentView;
        }
        SquareAvatarView squareAvatarView = new SquareAvatarView(ctx, null, 0, null, 14, null);
        squareAvatarView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return squareAvatarView;
    }
}

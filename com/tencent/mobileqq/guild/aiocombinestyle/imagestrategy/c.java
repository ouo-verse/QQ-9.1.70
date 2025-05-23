package com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.guild.aio.component.combinestyle.ag;
import com.tencent.guild.aio.component.combinestyle.ah;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/aiocombinestyle/imagestrategy/c;", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/component/combinestyle/ag;", "callback", "", "a", "", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "iconUrl", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements ah {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/aiocombinestyle/imagestrategy/c$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ag f213913e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ag agVar) {
            super(true);
            this.f213913e = agVar;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            Bitmap bitmap;
            if (state == LoadState.STATE_SUCCESS) {
                if (option != null) {
                    bitmap = option.getResultBitMap();
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.f213913e.onLoaded(new BitmapDrawable(option.getResultBitMap()));
                }
            }
        }
    }

    public c(@NotNull String iconUrl) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.iconUrl = iconUrl;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ah
    public void a(@NotNull Context context, @NotNull ag callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        e.a().f(new Option().setUrl(this.iconUrl), new a(callback));
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ah
    @Nullable
    /* renamed from: d */
    public Drawable getDefaultDrawable() {
        return ah.a.a(this);
    }
}

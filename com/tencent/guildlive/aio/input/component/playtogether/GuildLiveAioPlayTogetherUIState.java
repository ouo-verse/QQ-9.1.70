package com.tencent.guildlive.aio.input.component.playtogether;

import android.graphics.drawable.Drawable;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guildlive/aio/input/component/playtogether/GuildLiveAioPlayTogetherUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "PlayTogetherUpdate", "Lcom/tencent/guildlive/aio/input/component/playtogether/GuildLiveAioPlayTogetherUIState$PlayTogetherUpdate;", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildLiveAioPlayTogetherUIState implements MviUIState {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildlive/aio/input/component/playtogether/GuildLiveAioPlayTogetherUIState$PlayTogetherUpdate;", "Lcom/tencent/guildlive/aio/input/component/playtogether/GuildLiveAioPlayTogetherUIState;", "", "d", "I", "b", "()I", "visibility", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "a", "()Landroid/graphics/drawable/Drawable;", "srcDrawable", "<init>", "(ILandroid/graphics/drawable/Drawable;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class PlayTogetherUpdate extends GuildLiveAioPlayTogetherUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable srcDrawable;

        public PlayTogetherUpdate(int i3, @Nullable Drawable drawable) {
            super(null);
            this.visibility = i3;
            this.srcDrawable = drawable;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Drawable getSrcDrawable() {
            return this.srcDrawable;
        }

        /* renamed from: b, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }
    }

    public /* synthetic */ GuildLiveAioPlayTogetherUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildLiveAioPlayTogetherUIState() {
    }
}

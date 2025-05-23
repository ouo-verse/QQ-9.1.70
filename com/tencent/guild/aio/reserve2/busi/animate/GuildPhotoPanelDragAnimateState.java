package com.tencent.guild.aio.reserve2.busi.animate;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "PhotoPanelAnimateState", "Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateState$PhotoPanelAnimateState;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildPhotoPanelDragAnimateState implements MviUIState {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateState$PhotoPanelAnimateState;", "Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateState;", "", "d", "Z", "c", "()Z", "show", "", "e", "I", "a", "()I", "bottomMargin", "", "f", UserInfo.SEX_FEMALE, "b", "()F", "ratio", "<init>", "(ZIF)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class PhotoPanelAnimateState extends GuildPhotoPanelDragAnimateState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int bottomMargin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final float ratio;

        public PhotoPanelAnimateState(boolean z16, int i3, float f16) {
            super(null);
            this.show = z16;
            this.bottomMargin = i3;
            this.ratio = f16;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottomMargin() {
            return this.bottomMargin;
        }

        /* renamed from: b, reason: from getter */
        public final float getRatio() {
            return this.ratio;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }
    }

    public /* synthetic */ GuildPhotoPanelDragAnimateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildPhotoPanelDragAnimateState() {
    }
}

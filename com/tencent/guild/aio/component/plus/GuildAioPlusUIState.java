package com.tencent.guild.aio.component.plus;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "PlusBtnRedDotState", "PlusPanelShowingState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class GuildAioPlusUIState implements MviUIState {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState$PlusBtnRedDotState;", "Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState;", "", "d", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class PlusBtnRedDotState extends GuildAioPlusUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShow;

        public PlusBtnRedDotState() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        public PlusBtnRedDotState(boolean z16) {
            this.isShow = z16;
        }

        public /* synthetic */ PlusBtnRedDotState(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState$PlusPanelShowingState;", "Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState;", "", "d", "Z", "a", "()Z", "setPanelShowing", "(Z)V", "panelShowing", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class PlusPanelShowingState extends GuildAioPlusUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean panelShowing;

        public PlusPanelShowingState() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getPanelShowing() {
            return this.panelShowing;
        }

        public PlusPanelShowingState(boolean z16) {
            this.panelShowing = z16;
        }

        public /* synthetic */ PlusPanelShowingState(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}

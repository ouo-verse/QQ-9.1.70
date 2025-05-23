package com.tencent.state.square.interaction.record;

import androidx.lifecycle.Observer;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.interaction.InteractionUnreadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00060\u00060\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordUnReadCase;", "", "type", "", "unReadInfoChange", "Lkotlin/Function1;", "Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "", "(ILkotlin/jvm/functions/Function1;)V", "observer", "Landroidx/lifecycle/Observer;", "kotlin.jvm.PlatformType", "pause", "resume", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionRecordUnReadCase {
    private final Observer<InteractionUnreadInfo> observer;
    private final int type;
    private final Function1<InteractionUnreadInfo, Unit> unReadInfoChange;

    /* JADX WARN: Multi-variable type inference failed */
    public InteractionRecordUnReadCase(int i3, Function1<? super InteractionUnreadInfo, Unit> unReadInfoChange) {
        Intrinsics.checkNotNullParameter(unReadInfoChange, "unReadInfoChange");
        this.type = i3;
        this.unReadInfoChange = unReadInfoChange;
        Observer<InteractionUnreadInfo> observer = new Observer<InteractionUnreadInfo>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordUnReadCase$observer$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(InteractionUnreadInfo info) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(info, "info");
                function1 = InteractionRecordUnReadCase.this.unReadInfoChange;
                function1.invoke(info);
            }
        };
        this.observer = observer;
        InteractionManager interactionManager = InteractionManager.INSTANCE;
        interactionManager.getRecordUnreadLiveData(i3).observeForever(observer);
        interactionManager.refreshInteractionUnread(i3);
    }

    public final void pause() {
        InteractionManager.INSTANCE.getRecordUnreadLiveData(this.type).removeObserver(this.observer);
    }

    public final void resume() {
        InteractionManager interactionManager = InteractionManager.INSTANCE;
        interactionManager.getRecordUnreadLiveData(this.type).removeObserver(this.observer);
        interactionManager.getRecordUnreadLiveData(this.type).observeForever(this.observer);
    }
}

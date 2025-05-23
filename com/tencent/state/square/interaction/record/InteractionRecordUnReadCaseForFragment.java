package com.tencent.state.square.interaction.record;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.state.square.interaction.InteractionUnreadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordUnReadCaseForFragment;", "", "type", "", "fragment", "Landroidx/fragment/app/Fragment;", "unReadInfoChange", "Lkotlin/Function1;", "Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "", "(ILandroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "unReadCase", "Lcom/tencent/state/square/interaction/record/InteractionRecordUnReadCase;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionRecordUnReadCaseForFragment {
    private final Fragment fragment;
    private final InteractionRecordUnReadCase unReadCase;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
        }
    }

    public InteractionRecordUnReadCaseForFragment(int i3, Fragment fragment, Function1<? super InteractionUnreadInfo, Unit> unReadInfoChange) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(unReadInfoChange, "unReadInfoChange");
        this.fragment = fragment;
        this.unReadCase = new InteractionRecordUnReadCase(i3, unReadInfoChange);
        fragment.getLifecycle().addObserver(new GenericLifecycleObserver() { // from class: com.tencent.state.square.interaction.record.InteractionRecordUnReadCaseForFragment.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                int i16 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i16 == 1) {
                    InteractionRecordUnReadCaseForFragment.this.unReadCase.resume();
                } else {
                    if (i16 != 2) {
                        return;
                    }
                    InteractionRecordUnReadCaseForFragment.this.unReadCase.pause();
                }
            }
        });
    }

    public final Fragment getFragment() {
        return this.fragment;
    }
}

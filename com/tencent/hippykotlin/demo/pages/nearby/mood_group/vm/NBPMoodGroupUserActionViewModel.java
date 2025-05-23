package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserActionMenuInfo;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class NBPMoodGroupUserActionViewModel {
    public String autoCloseUserActionMenuRef;
    public String autoCloseUserActionTipsRef;
    public final NBPMoodGroupConfig.BarrageConfig barrageConfig;
    public final MutableState menuInfo$delegate;
    public final MutableState tipsInfo$delegate;

    public NBPMoodGroupUserActionViewModel(NBPMoodGroupConfig.BarrageConfig barrageConfig) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.barrageConfig = barrageConfig;
        LazyKt__LazyJVMKt.lazy(new Function0<NBPMoodGroupRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupUserActionViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPMoodGroupRepo invoke() {
                return new NBPMoodGroupRepo();
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.menuInfo$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.tipsInfo$delegate = mutableStateOf$default2;
    }

    public final void clear() {
        this.menuInfo$delegate.setValue(null);
        this.tipsInfo$delegate.setValue(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserActionMenuInfo getMenuInfo() {
        return (UserActionMenuInfo) this.menuInfo$delegate.getValue();
    }
}

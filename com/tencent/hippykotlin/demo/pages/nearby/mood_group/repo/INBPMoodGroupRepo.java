package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import java.util.List;
import k35.c;
import k35.e;
import k35.i;
import k35.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public interface INBPMoodGroupRepo {
    void getAll(int i3, Function3<? super c, ? super Integer, ? super String, Unit> function3);

    void getBarrage(int i3, List<Long> list, Function3<? super e, ? super Integer, ? super String, Unit> function3);

    void interact(long j3, int i3, long j16, Function3<? super i, ? super Integer, ? super String, Unit> function3);

    void sendBarrage(int i3, long j3, Function3<? super p, ? super Integer, ? super String, Unit> function3);
}

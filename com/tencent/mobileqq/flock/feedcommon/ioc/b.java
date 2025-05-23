package com.tencent.mobileqq.flock.feedcommon.ioc;

import android.content.Context;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\rH&J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H&R\u0014\u0010\u0015\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "", "Landroid/content/Context;", "context", "Ly45/b;", "feed", "", ICustomDataEditor.NUMBER_PARAM_2, "S4", "Z8", "", "tagId", "j3", "", "y8", "Lkotlin/Pair;", "Z5", "C8", "", "c6", "()Z", "isPoiClickable", "t3", "isPublisherClickable", ICustomDataEditor.STRING_ARRAY_PARAM_8, "isParticipantClickable", "T1", "isTopicClickable", ICustomDataEditor.STRING_PARAM_1, "isTopicVisible", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface b {
    @Nullable
    String C8(@NotNull y45.b feed);

    void S4(@NotNull Context context, @NotNull y45.b feed);

    boolean T1();

    @NotNull
    Pair<Integer, Integer> Z5(@NotNull Context context);

    void Z8(@NotNull Context context, @NotNull y45.b feed);

    boolean a8();

    boolean c6();

    void j3(@NotNull Context context, int tagId);

    void n2(@NotNull Context context, @NotNull y45.b feed);

    boolean s1();

    boolean t3();

    @NotNull
    String y8();
}

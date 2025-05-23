package com.tencent.mobileqq.wink.reddot;

import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J*\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0004\u0012\u00020\b0\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&J\b\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/a;", "T", "V", "", "", "id", "Lkotlin/Function1;", "", "", "action", "b", "", "a", IVideoFilterTools.CATEGORYS, "d", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a<T, V> {
    boolean a(@NotNull String id5);

    void b(@NotNull String id5, @NotNull Function1<? super List<String>, Unit> action);

    @NotNull
    String c();

    void d(@NotNull List<? extends T> categorys);
}

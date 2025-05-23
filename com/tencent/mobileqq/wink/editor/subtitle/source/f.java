package com.tencent.mobileqq.wink.editor.subtitle.source;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jn\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022Z\u0010\u000e\u001aV\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\u0002\b\rH&JW\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022C\u0010\u000e\u001a?\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\u0002\b\rH&Ja\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00152C\u0010\u000e\u001a?\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\u0002\b\rH&JL\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000228\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\f0\u0019H&JG\u0010\"\u001a\u00020\u000f2\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0!H&\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/f;", "", "", "input", "Lkotlin/Function4;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/b;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "outputPath", "", "Lkotlin/ExtensionFunctionType;", "callback", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "a", "path", "Lkotlin/Function3;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "e", "", "delay", "url", "c", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleResult;", "content", "d", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "Lkotlin/collections/ArrayList;", "lines", "Lkotlin/Function1;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface f {
    @NotNull
    a a(@Nullable String input, @NotNull Function4<? super b, ? super Integer, ? super String, ? super String, Unit> callback);

    @NotNull
    a b(@Nullable ArrayList<Subtitle> lines, @NotNull Function1<? super Integer, Unit> callback);

    @NotNull
    a c(@Nullable String taskId, long delay, @NotNull Function3<? super b, ? super Integer, ? super String, Unit> callback);

    @NotNull
    a d(@Nullable String url, @NotNull Function2<? super Integer, ? super SubtitleResult, Unit> callback);

    @NotNull
    a e(@Nullable String path, @NotNull Function3<? super b, ? super Integer, ? super String, Unit> callback);
}

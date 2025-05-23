package dx4;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&J&\u0010\u0010\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Ldx4/d;", "", "", "Lex4/d;", "taskList", "Ldx4/e;", "callback", "", "c", "Lex4/b;", "b", "Lex4/c;", "", "errorCode", "", "errorMessage", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface d {
    void a(@NotNull List<ex4.c> taskList, int errorCode, @NotNull String errorMessage);

    void b(@NotNull List<ex4.b> taskList);

    void c(@NotNull List<ex4.d> taskList, @NotNull e callback);
}

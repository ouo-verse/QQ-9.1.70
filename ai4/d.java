package ai4;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import yh4.ReceiverInfoModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u000f\u001a\u00020\u0007H&\u00a8\u0006\u0010"}, d2 = {"Lai4/d;", "", "", "Lyh4/b;", "list", "", "noAnimate", "", "d", "Lai4/f;", "cb", "c", "chosenInfo", "b", "a", "reset", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface d {
    @NotNull
    List<ReceiverInfoModel> a();

    void b(@NotNull ReceiverInfoModel chosenInfo);

    void c(@NotNull f cb5);

    void d(@NotNull List<ReceiverInfoModel> list, boolean noAnimate);

    void reset();
}

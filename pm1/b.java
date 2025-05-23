package pm1;

import kotlin.Metadata;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lpm1/b;", "", "Lorg/json/JSONObject;", "jsonObject", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, JSONObject jSONObject, om1.b bVar2, RestoreInfo restoreInfo, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    restoreInfo = null;
                }
                bVar.a(jSONObject, bVar2, restoreInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: restore");
        }
    }

    void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo);
}

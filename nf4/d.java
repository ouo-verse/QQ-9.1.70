package nf4;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J8\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&JD\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H&J&\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H&J,\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H&\u00a8\u0006\u0016"}, d2 = {"Lnf4/d;", "", "target", "", ISchemeApi.KEY_PAGE_ID, "", "businessParams", "", "b", "fragment", "i", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "eventID", "reportEvent", "Ljava/lang/Object;", "obj", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void a(d dVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                boolean z17 = z16;
                if ((i3 & 4) != 0) {
                    str = null;
                }
                String str3 = str;
                if ((i3 & 16) != 0) {
                    map = new HashMap();
                }
                dVar.a(view, z17, str3, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindElementInfo");
        }
    }

    void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams);

    void b(@NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams);

    void i(@NotNull Object fragment, @NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams);

    void reportEvent(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, String> businessParams);

    void reportEvent(@NotNull String eventID, @NotNull Map<String, String> businessParams);
}

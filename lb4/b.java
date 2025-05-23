package lb4;

import androidx.fragment.app.Fragment;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContentUrl;
import com.tencent.sqshow.zootopia.recommend.main.tab.g;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Llb4/b;", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/g;", "Landroidx/fragment/app/Fragment;", "getFragment", "", "dh", "z6", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", Constants.BASE_IN_PLUGIN_ID, "()Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "tabContentUrl", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface b extends g {
    /* renamed from: D1 */
    ZPlanTabContentUrl getTabContentUrl();

    void dh();

    Fragment getFragment();

    void z6();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class a {
        public static ZPlanTabContentUrl a(b bVar) {
            return bVar.getTabContentUrl();
        }

        public static void b(b bVar) {
        }

        public static void c(b bVar) {
        }
    }
}

package nk3;

import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lnk3/b;", "", "", "couponCount", "", "onSuccess", "Lcom/tencent/mobileqq/zplan/aigc/const/ZPlanAIGCStatusCode;", "errCode", "", "errMsg", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, ZPlanAIGCStatusCode zPlanAIGCStatusCode, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = "";
                }
                bVar.a(zPlanAIGCStatusCode, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
        }
    }

    void a(@NotNull ZPlanAIGCStatusCode errCode, @Nullable String errMsg);

    void onSuccess(int couponCount);
}

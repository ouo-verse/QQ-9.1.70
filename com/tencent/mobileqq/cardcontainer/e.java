package com.tencent.mobileqq.cardcontainer;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0014\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/e;", "", "", "F8", "", ZPlanPublishSource.FROM_SCHEME, "aa", "customReportData", "Ie", "", "clickPosition", "nc", Constants.MMCCID, "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        public static /* synthetic */ void a(e eVar, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = null;
                }
                eVar.nc(i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClickElement");
        }

        public static /* synthetic */ void b(e eVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                eVar.G2(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClickMainButton");
        }

        public static /* synthetic */ void c(e eVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                eVar.Ie(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportCloseCard");
        }
    }

    void F8();

    void G2(@Nullable String customReportData);

    void Ie(@Nullable String customReportData);

    void aa(@NotNull String scheme);

    void nc(int clickPosition, @Nullable String customReportData);
}

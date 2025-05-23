package com.tencent.mobileqq.zplan.aio.badge;

import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&JS\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nH&\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/b;", "", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "a", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "info", "", "c", "", "from", "", "entranceContainerV", "redTouchV", "numRedDotV", "animImageViewV", "normalRedDotV", "b", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface b {
    RedTouch a();

    void b(String from, Integer entranceContainerV, Integer redTouchV, Integer numRedDotV, Integer animImageViewV, Integer normalRedDotV);

    void c(BusinessInfoCheckUpdate.AppInfo info);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i3, Object obj) {
            if (obj == null) {
                bVar.b(str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : num4, (i3 & 32) == 0 ? num5 : null);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: adjustVisibility");
        }
    }
}

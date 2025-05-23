package com.tencent.mobileqq.zplan.easteregg;

import com.tencent.mobileqq.zplan.easteregg.model.ErrorMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J@\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/t;", "", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "", "idList", "", "pathList", "msg", "", "a", "Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "errMsg", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface t {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(t tVar, PortraitSource portraitSource, List list, List list2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                if ((i3 & 4) != 0) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                if ((i3 & 8) != 0) {
                    str = null;
                }
                tVar.a(portraitSource, list, list2, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResource");
        }
    }

    void a(@NotNull PortraitSource source, @Nullable List<Integer> idList, @Nullable List<String> pathList, @Nullable String msg2);

    void b(@Nullable ErrorMsg errMsg);
}

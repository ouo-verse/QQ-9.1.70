package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "", "onDataUpdate", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "action", "", "index", "", "onListUpdate", "list", "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public interface IQzoneFeedUpdateCallback {
    void onDataUpdate(CommonFeed commonFeed, String action, int index);

    void onListUpdate(List<CommonFeed> list, String action, int index);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onDataUpdate$default(IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback, CommonFeed commonFeed, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iQzoneFeedUpdateCallback.onDataUpdate(commonFeed, str, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDataUpdate");
        }

        public static /* synthetic */ void onListUpdate$default(IQzoneFeedUpdateCallback iQzoneFeedUpdateCallback, List list, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iQzoneFeedUpdateCallback.onListUpdate(list, str, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onListUpdate");
        }
    }
}

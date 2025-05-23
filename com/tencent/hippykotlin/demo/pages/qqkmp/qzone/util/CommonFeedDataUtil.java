package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/util/CommonFeedDataUtil;", "", "()V", "stringToRichMsg", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "str", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonFeedDataUtil {
    public static final CommonFeedDataUtil INSTANCE = new CommonFeedDataUtil();

    CommonFeedDataUtil() {
    }

    public final List<CommonRichMsg> stringToRichMsg(String str) {
        ArrayList arrayList = new ArrayList();
        CommonRichMsg commonRichMsg = new CommonRichMsg();
        commonRichMsg.setType(0);
        commonRichMsg.setContent(str);
        arrayList.add(commonRichMsg);
        return arrayList;
    }
}

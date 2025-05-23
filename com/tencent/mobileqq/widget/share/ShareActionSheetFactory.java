package com.tencent.mobileqq.widget.share;

import android.content.Context;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ShareActionSheetFactory {
    public static ShareActionSheet create(ShareActionSheetV2.Param param) {
        return new c(new b(new ShareActionSheetV2(param)));
    }

    public static ShareActionSheet create(Context context, boolean z16) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        param.fullScreen = z16;
        return new c(new b(new ShareActionSheetV2(param)));
    }
}

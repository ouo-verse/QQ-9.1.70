package com.tencent.mobileqq.data;

import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EmojiConstants {
    public static final int COLUMNNUM_SYSTEM_AND_EMOJI = getColumnNumSystemAndEmoji();

    private static int getColumnNumSystemAndEmoji() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return 8;
        }
        return 7;
    }
}

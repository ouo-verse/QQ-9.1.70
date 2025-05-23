package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f179915a = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".sticker_recommended_pics/");

    public static String a(String str) {
        try {
            return f179915a + Utils.Crc64String(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}

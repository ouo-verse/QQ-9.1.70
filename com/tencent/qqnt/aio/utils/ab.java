package com.tencent.qqnt.aio.utils;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.SendByFile;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"", "chatType", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMediaInfo", "", CustomImageProps.QUALITY, "a", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ab {
    public static final boolean a(int i3, @NotNull LocalMediaInfo localMediaInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        SendByFile sendByFile = new SendByFile(0L, 0L, 0L, 0, 0, false, 63, null);
        if (i3 == 8) {
            QLog.d("PhotoPanelSendFileUtils", 1, "transFileToSend at dataLineAio");
            return true;
        }
        if (sendByFile.d(localMediaInfo, z16)) {
            QLog.d("PhotoPanelSendFileUtils", 1, "transFileToSend needSendByFile");
            return true;
        }
        return false;
    }
}

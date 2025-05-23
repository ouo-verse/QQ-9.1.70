package com.tencent.robot.action.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.robot.action.api.IRobotPreviewApi;
import g44.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/action/api/impl/RobotPreviewApiImpl;", "Lcom/tencent/robot/action/api/IRobotPreviewApi;", "()V", "createPreviewActionSheet", "T", "param", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "(Ljava/lang/Object;Landroid/graphics/Bitmap;)Ljava/lang/Object;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotPreviewApiImpl implements IRobotPreviewApi {
    /* JADX WARN: Type inference failed for: r0v4, types: [T, g44.d] */
    @Override // com.tencent.robot.action.api.IRobotPreviewApi
    @Nullable
    public <T> T createPreviewActionSheet(@NotNull Object param, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (param instanceof ShareActionSheetV2.Param) {
            ?? r06 = (T) new d((ShareActionSheetV2.Param) param);
            r06.F0(bitmap);
            return r06;
        }
        return null;
    }
}

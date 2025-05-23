package com.tencent.filament.zplan.listener;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "", "onScreenShot", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface GYScreenShotCallback {
    void onScreenShot(@Nullable Bitmap bitmap);
}

package com.tencent.aelight.camera.entry.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAECameraEntryManager extends QRouteApi {
    int getAEFromType(Intent intent);

    int getStoryMediaType(Intent intent);

    int getStoryShareType(Intent intent);

    boolean isAddPlayShowEntry(int i3);

    boolean isAddPlayShowEntry(Activity activity);

    boolean isFromCheckEntry(Intent intent);

    boolean isFromGuideCircle(Intent intent);

    boolean isFromMiniApp(Intent intent);

    boolean isQzoneTailEntry(Intent intent);

    boolean isSameStoryPhotoEntry(Intent intent);

    boolean isStoryDefaultShare(Intent intent);

    boolean isStoryPhoto(Intent intent, int i3);

    int switchModeToInt(String str);

    String switchTabToName(@Nullable String str);
}

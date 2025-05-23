package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQQStoryFlowManager extends QRouteApi {
    boolean isValidMedia(@NonNull Activity activity, @NonNull LocalMediaInfo localMediaInfo);

    void startEditVideoActivity(Activity activity, String str, LocalMediaInfo localMediaInfo, int i3, int i16, int i17, int i18, int i19, String str2, String str3, boolean z16, int i26, int i27, Bundle bundle);
}

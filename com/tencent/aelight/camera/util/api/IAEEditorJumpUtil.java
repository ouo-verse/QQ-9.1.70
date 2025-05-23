package com.tencent.aelight.camera.util.api;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEEditorJumpUtil extends QRouteApi {
    int getFragmentContainerId(Activity activity);

    void picChooseJump(int i3, @Nullable Activity activity, @Nullable PhotoCommonBaseData photoCommonBaseData, boolean z16);
}

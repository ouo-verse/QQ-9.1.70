package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ILaunchVideoEditorForAlbum extends QRouteApi {
    void jumpToEditVideoActivity(Activity activity, BaseVideoCaptureResult baseVideoCaptureResult, LocalMediaInfo localMediaInfo, Bundle bundle, int i3, @Nullable Bundle bundle2);

    void setVideoParams(int i3, int i16, int i17, int i18);
}

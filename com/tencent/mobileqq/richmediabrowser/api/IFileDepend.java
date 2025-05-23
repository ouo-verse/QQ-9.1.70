package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IFileDepend extends QRouteApi {
    boolean checkFileThumbOverSize(int i3, int i16, long j3);

    void forwardToTargetFriend(Activity activity, Intent intent, boolean z16, String str, int i3);

    SparseArray<Object> getDetectCode(Bitmap bitmap);

    boolean isVideoFileError(long j3);

    void openWithOtherApp(Activity activity, String str);

    void saveToAlbum(Context context, String str);

    void startEditPicActivity(Activity activity, int i3, boolean z16, boolean z17, int i16, String str, int i17, Parcelable parcelable);
}

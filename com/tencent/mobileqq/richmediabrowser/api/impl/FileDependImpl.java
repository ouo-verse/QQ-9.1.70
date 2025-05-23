package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.utils.b;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.utils.e;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FileDependImpl implements IFileDepend {
    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public boolean checkFileThumbOverSize(int i3, int i16, long j3) {
        return QFileUtils.f(i3, i16, j3);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public void forwardToTargetFriend(Activity activity, Intent intent, boolean z16, String str, int i3) {
        e.e(activity, intent, z16, str, i3);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public SparseArray<Object> getDetectCode(Bitmap bitmap) {
        Object obj;
        Object obj2;
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        int decodeQQCodeFromBmp = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(bitmap, 3, sparseArray);
        Object obj3 = null;
        if (b.g(decodeQQCodeFromBmp)) {
            obj = sparseArray.get(1);
        } else {
            obj = null;
        }
        if (b.f(decodeQQCodeFromBmp)) {
            obj2 = sparseArray.get(2);
        } else {
            obj2 = null;
        }
        if (b.f(decodeQQCodeFromBmp)) {
            obj3 = sparseArray.get(1001);
        }
        SparseArray<Object> sparseArray2 = new SparseArray<>(3);
        sparseArray2.put(0, obj);
        sparseArray2.put(1, obj2);
        sparseArray2.put(2, obj3);
        return sparseArray2;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public boolean isVideoFileError(long j3) {
        if (j3 == -134) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public void openWithOtherApp(Activity activity, String str) {
        FileManagerUtil.openWithOtherApp(activity, str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public void saveToAlbum(Context context, String str) {
        FileManagerUtil.saveToAlbum(context, str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IFileDepend
    public void startEditPicActivity(Activity activity, int i3, boolean z16, boolean z17, int i16, String str, int i17, Parcelable parcelable) {
        Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(activity, str, true, true, true, true, true, 2, i3, 7);
        startEditPic.putExtra("uintype", h.a().f());
        startEditPic.putExtra("open_chatfragment", true);
        startEditPic.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1041);
        startEditPic.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        if (z16) {
            startEditPic.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, z16);
        }
        if (z17) {
            startEditPic.putExtra("key_allow_multiple_forward_from_limit", false);
        }
        if (parcelable != null) {
            startEditPic.putExtra("fileinfo", parcelable);
        }
        startEditPic.putExtra("not_forward", true);
        if (i16 != 0) {
            activity.startActivityForResult(startEditPic, i16);
        } else {
            activity.startActivity(startEditPic);
        }
    }
}

package com.tencent.mobileqq.qqvideoedit.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.mini.servlet.GetMaterialRelevantAppServlet;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorFragment;
import com.tencent.mobileqq.qqvideoedit.impl.QQVideoEditActivity;
import com.tencent.mobileqq.qqvideoedit.zplan.ipc.ZootopiaVideoCutModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ik2.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kk2.b;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQVideoEditApiImpl implements IQQVideoEditApi {
    private static String TAG = "QQVideoEditApiImpl";

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi
    public QIPCModule getZootopiaVideoCutIPCModule() {
        return ZootopiaVideoCutModule.INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi
    public void jumpToVideoEditPage(Activity activity, Intent intent, LocalMediaInfo localMediaInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMediaInfo);
        Parcel obtain = Parcel.obtain();
        obtain.writeList(arrayList);
        obtain.setDataPosition(0);
        Serializable readArrayList = obtain.readArrayList(LocalMediaInfo.class.getClassLoader());
        OaidMonitor.parcelRecycle(obtain);
        intent.putExtra(AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, arrayList);
        intent.putExtra("localMediaInfos_output", readArrayList);
        intent.setClass(activity, QQVideoEditActivity.class);
        intent.putExtra("public_fragment_class", VideoEditorFragment.class.getName());
        activity.startActivityForResult(intent, 10000);
        QLog.d(TAG, 1, "jumpToVideoEditPage");
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi
    public void jumpToZootopiaVideoEditPage(String str, HashMap<String, String> hashMap) {
        if (b.a(str, 1000L)) {
            return;
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            BaseApplication context = BaseApplication.getContext();
            QQToast.makeText(context, context.getResources().getString(R.string.f237737hv), 0).show();
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
            return;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = str;
        i.f407919a.a(localMediaInfo);
        if (QAlbumUtil.getMediaType(localMediaInfo) != 1) {
            QLog.e(TAG, 1, "mMimeType: " + localMediaInfo.mMimeType + ", VideoPath: " + localMediaInfo.path);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMediaInfo);
        Parcel obtain = Parcel.obtain();
        obtain.writeList(arrayList);
        obtain.setDataPosition(0);
        ArrayList readArrayList = obtain.readArrayList(LocalMediaInfo.class.getClassLoader());
        Intent intent = new Intent();
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.getContext();
            intent.addFlags(268435456);
        }
        intent.putExtra(AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, arrayList);
        intent.putExtra("localMediaInfos_output", readArrayList);
        intent.setClass(topActivity, QQVideoEditActivity.class);
        intent.putExtra("public_fragment_class", VideoEditorFragment.class.getName());
        intent.putExtra("EDIT_FROM_TYPE", 1);
        intent.putExtra("key_fixed_max_duration", 5000000L);
        intent.putExtra(GetMaterialRelevantAppServlet.KEY_EXTRA_INFO, hashMap);
        intent.putExtra("IS_SHOW_TEXT_MENU", ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanGifText());
        intent.putExtra("IS_IGNORE_ATTRACT", true);
        topActivity.startActivity(intent);
    }
}

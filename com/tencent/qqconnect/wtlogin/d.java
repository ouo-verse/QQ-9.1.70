package com.tencent.qqconnect.wtlogin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.open.agent.util.l;
import com.tencent.open.agent.util.t;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakConstants;
import hp3.f;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    private static void a(f fVar) {
        String[] stringArray = MobileQQ.sMobileQQ.getResources().getStringArray(R.array.f155206av);
        ActionSheet actionSheet = fVar.f405832g;
        actionSheet.addButton(stringArray[24]);
        actionSheet.addButton(stringArray[13]);
        actionSheet.addCancelButton(stringArray[16]);
    }

    private static Object b(f fVar) {
        CompressInfo compressInfo = new CompressInfo(fVar.f405830e, 0);
        compressInfo.K = 0;
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        t.b("QQLiteStatusMgr", "uploadAvatar compressInfo:", compressInfo);
        return compressInfo.H;
    }

    public static Object c(f fVar) {
        boolean z16 = true;
        switch (fVar.f405826a) {
            case 1:
                return new com.tencent.mobileqq.drawable.b(0, fVar.f405835j, 100);
            case 2:
                return LastModifySupportDownloader.getCacheFilePath(fVar.f405836k);
            case 3:
                return com.tencent.mobileqq.urldrawable.a.f306322b;
            case 4:
                return Boolean.valueOf(l.a());
            case 5:
                return Boolean.valueOf(ForwardUtils.c());
            case 6:
                QrAgentLoginManager.t().r(fVar.f405829d, true);
                return null;
            case 7:
                if (!BaseGesturePWDUtil.getJumpLock(fVar.f405828c, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()) || BaseGesturePWDUtil.getAppForground(fVar.f405828c)) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            case 8:
                return b(fVar);
            case 9:
                return fVar.f405831f.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            case 10:
                a(fVar);
                return null;
            case 11:
                e(fVar);
                return null;
            case 12:
                return ProfileCardUtils.enterSnapshot(fVar.f405827b, 257);
            case 13:
                d(fVar);
                return null;
            default:
                return null;
        }
    }

    private static void d(f fVar) {
        if (fVar.f405834i != 257) {
            return;
        }
        Activity activity = fVar.f405827b;
        if (activity == null) {
            t.e("QQLiteStatusMgr", "startPhotoEdit activity is null ");
            return;
        }
        String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(activity, fVar.f405833h);
        if (TextUtils.isEmpty(realPathFromContentURI)) {
            return;
        }
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(fVar.f405827b, realPathFromContentURI, 103);
    }

    private static void e(f fVar) {
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", 103);
        intent.putExtra("BUSINESS_ORIGIN_NEW", 103);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra("fromWhereClick", PhotoCommonBaseData.FROM_PHOTO_LIST);
        Activity activity = fVar.f405827b;
        if (activity == null) {
            return;
        }
        int x16 = ProfileCardUtil.x(activity);
        String name = PublicFragmentActivityForOpenSDK.class.getName();
        if (activity.getClass() == QPublicFragmentActivity.class) {
            name = QPublicFragmentActivity.class.getName();
        }
        PhotoUtils.startPhotoListEdit(intent, activity, name, x16, x16, 1080, 1080, FaceUtil.getUploadAvatarTempPath());
    }
}

package com.tencent.hippy.qq.utils.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.ShareResultCallbackBase;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ShareImageUtils {
    public static final int REQUEST_CODE_SHARE_TO_QZONE = 1;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_OK = 0;
    private static final String SHARE_FAILURE = "\u5206\u4eab\u5931\u8d25";
    private static final String SHARE_SUCCESS = "\u5206\u4eab\u6210\u529f";
    private static final int SHARE_TO_QQ = 0;
    private static final int SHARE_TO_QZONE = 1;
    private static final int SHARE_TO_WECHAT = 2;
    private static final int SHARE_TO_WECHAT_MONMENT = 3;
    public static final String TAG = "Hippy.ShareImageUtils";
    private static final String WX_NOT_INSTALLED = "\u62b1\u6b49\uff0c\u4f60\u672a\u5b89\u88c5\u5fae\u4fe1\u5ba2\u6237\u7aef\uff0c\u65e0\u6cd5\u8fdb\u884c\u5fae\u4fe1\u5206\u4eab";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ShareResultCallBack {
        void callBack(int i3);
    }

    private static void makeText(String str) {
        QQToast.makeText(MobileQQ.sMobileQQ, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onShareWXResp(BaseResp baseResp, ShareResultCallBack shareResultCallBack) {
        int i3;
        if (baseResp.errCode == 0) {
            makeText(SHARE_SUCCESS);
            i3 = 0;
        } else {
            makeText("\u5206\u4eab\u5931\u8d25");
            i3 = 1;
        }
        shareResultCallBack.callBack(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void shareImage(String str, int i3, Fragment fragment, ShareResultCallBack shareResultCallBack) {
        if (fragment != 0 && fragment.isVisible() && !TextUtils.isEmpty(str)) {
            if (fragment instanceof ShareResultCallbackBase) {
                ((ShareResultCallbackBase) fragment).setShareResultCallback(shareResultCallBack);
            }
            if (i3 == 0) {
                shareToQQ(str, fragment, shareResultCallBack);
                return;
            }
            if (i3 == 1) {
                shareToQZone(str, fragment.getContext());
                return;
            }
            if (i3 == 2) {
                shareToWechat(str, shareResultCallBack);
                return;
            } else if (i3 != 3) {
                shareResultCallBack.callBack(1);
                return;
            } else {
                shareToWechatCircle(str, shareResultCallBack);
                return;
            }
        }
        shareResultCallBack.callBack(1);
    }

    private static void shareToQQ(String str, Fragment fragment, ShareResultCallBack shareResultCallBack) {
        if (fragment.getActivity() == null) {
            shareResultCallBack.callBack(1);
        } else {
            shareToQQ(str, fragment.getActivity());
        }
    }

    private static void shareToQZone(String str, Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(URLDecoder.decode(str));
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("images", arrayList);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        bundle.putBoolean("key_need_save_draft", false);
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("summary", null);
        }
        QZoneShareManager.publishToQzone((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context, bundle, null, 5);
    }

    private static void shareToWX(String str, int i3, final ShareResultCallBack shareResultCallBack) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (WXShareHelper.b0().e0()) {
            WXShareHelper.b0().A(new WXShareHelper.a() { // from class: com.tencent.hippy.qq.utils.screenshot.ShareImageUtils.1
                @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                public void onWXShareResp(BaseResp baseResp) {
                    ShareImageUtils.onShareWXResp(baseResp, ShareResultCallBack.this);
                    WXShareHelper.b0().q0(this);
                }
            });
            WXShareHelper.b0().u0(str, decodeFile, i3);
            return;
        }
        makeText(WX_NOT_INSTALLED);
    }

    private static void shareToWechat(String str, ShareResultCallBack shareResultCallBack) {
        shareToWX(str, 0, shareResultCallBack);
    }

    private static void shareToWechatCircle(String str, ShareResultCallBack shareResultCallBack) {
        shareToWX(str, 1, shareResultCallBack);
    }

    private static void shareToQQ(String str, Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(activity, ((IForwardApi) QRoute.api(IForwardApi.class)).getForwardRecentActivityClass());
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        activity.startActivityForResult(intent, 21);
    }

    public static void shareImage(String str, int i3, Activity activity, ShareResultCallBack shareResultCallBack) {
        if (i3 == 0) {
            shareToQQ(str, activity);
            return;
        }
        if (i3 == 1) {
            shareToQZone(str, activity);
            return;
        }
        if (i3 == 2) {
            shareToWechat(str, shareResultCallBack);
        } else if (i3 != 3) {
            shareResultCallBack.callBack(1);
        } else {
            shareToWechatCircle(str, shareResultCallBack);
        }
    }
}

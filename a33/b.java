package a33;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.c;
import com.tencent.open.appcommon.Common;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    private static boolean b() {
        return "com.tencent.mobileqq:tool".equals(Common.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppInterface appInterface, String str, Activity activity, int i3, EIPCResult eIPCResult) {
        Bundle bundle;
        RichStatus richStatus;
        if (eIPCResult.code == 0 && (bundle = eIPCResult.data) != null) {
            Serializable serializable = bundle.getSerializable("my_signature");
            if (serializable instanceof RichStatus) {
                richStatus = (RichStatus) serializable;
            } else {
                d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(appInterface.getCurrentAccountUin()), "SignatureEditManager");
                if (friendsSimpleInfoWithUid != null) {
                    richStatus = c.h(friendsSimpleInfoWithUid);
                } else {
                    richStatus = null;
                }
            }
            Bundle bundle2 = new Bundle();
            if ("signature_ziliaoka".equals(str)) {
                bundle2.putInt("from_type", 1);
            } else {
                bundle2.putInt("from_type", 2);
            }
            Intent intent = new Intent();
            intent.putExtras(bundle2);
            intent.putExtra(SquareJSConst.Params.PARAMS_RICH_STATUS, richStatus);
            intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
            intent.setClass(activity, QPublicFragmentActivity.class);
            activity.startActivityForResult(intent, i3);
        }
    }

    public static void d(Activity activity, AppInterface appInterface, int i3, String str) {
        f(activity, appInterface, i3, str, -1, -1, -1, null);
    }

    public static void e(Activity activity, AppInterface appInterface, int i3, String str, int i16) {
        f(activity, appInterface, i3, str, i16, -1, -1, null);
    }

    public static void f(Activity activity, AppInterface appInterface, int i3, String str, int i16, int i17, int i18, Bundle bundle) {
        g(activity, appInterface, i3, str, i16, i17, i18, bundle, 0);
    }

    public static void g(final Activity activity, final AppInterface appInterface, int i3, final String str, final int i16, int i17, int i18, Bundle bundle, int i19) {
        RichStatus richStatus = null;
        if (b()) {
            QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.L, null, new EIPCResultCallback() { // from class: a33.a
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    b.c(AppInterface.this, str, activity, i16, eIPCResult);
                }
            });
            return;
        }
        d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(appInterface.getCurrentAccountUin()), "SignatureEditManager");
        if (friendsSimpleInfoWithUid != null) {
            richStatus = c.h(friendsSimpleInfoWithUid);
        }
        Bundle bundle2 = new Bundle();
        if ("signature_ziliaoka".equals(str)) {
            bundle2.putInt("from_type", 1);
        } else {
            bundle2.putInt("from_type", 2);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        intent.putExtra(SquareJSConst.Params.PARAMS_RICH_STATUS, richStatus);
        intent.putExtra("public_fragment_class", "com.tencent.mobileqq.signature.SignTextEditFragment");
        intent.setClass(activity, QPublicFragmentActivity.class);
        activity.startActivityForResult(intent, i16);
    }

    public static void h(Activity activity, AppInterface appInterface, int i3, String str, int i16) {
        g(activity, appInterface, i3, str, -1, -1, -1, null, i16);
    }
}

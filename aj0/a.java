package aj0;

import android.app.Activity;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.share.api.ECQQShareData;
import com.tencent.ecommerce.base.share.api.ECQZoneShareData;
import com.tencent.ecommerce.base.share.api.ECWxShareData;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.shophome.repo.ECShareActionInfo;
import com.tencent.ecommerce.biz.shophome.repo.ECShareInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0003\u00a8\u0006\u0017"}, d2 = {"Laj0/a;", "", "", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "Lcom/tencent/ecommerce/biz/shophome/repo/a;", "shareActionInfo", "", "c", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "shareInfo", "d", "", "isTimeLine", "e", "shareAction", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f26146a = new a();

    a() {
    }

    public final void c(Activity activity, int requestCode, ECShareActionInfo shareActionInfo) {
        ECShareInfo eCShareInfo = shareActionInfo.shareInfo;
        String str = eCShareInfo != null ? eCShareInfo.arkShareInfo : null;
        if (str == null || str.length() == 0) {
            i.e(i.f101155b, R.string.wvp, null, 0, 6, null);
        } else {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy().shareMsgToQQ(activity, requestCode, new ECQQShareData(shareActionInfo.shareToFriendUin, shareActionInfo.shareToFriendUinName, shareActionInfo.getShareToFriendUinType(), new JSONObject(str), null, null, 48, null));
        }
    }

    public final void d(Activity activity, int requestCode, ECShareInfo shareInfo) {
        List listOf;
        IECShareProxy shareProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy();
        String str = shareInfo.title;
        String str2 = shareInfo.desc;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(shareInfo.picUrl);
        shareProxy.shareMsgToQZone(activity, requestCode, new ECQZoneShareData(str, str2, listOf, shareInfo.getJumpUrl(), null, null, null, 112, null));
    }

    public final void e(Activity activity, ECShareInfo shareInfo, boolean isTimeLine) {
        ECWxShareData eCWxShareData = new ECWxShareData(shareInfo.title, shareInfo.picUrl, shareInfo.desc, shareInfo.getJumpUrl(), null, null, false, 112, null);
        if (isTimeLine) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy().shareMsgToTimeLine(activity, eCWxShareData);
        } else {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy().shareMsgToWx(activity, eCWxShareData);
        }
    }

    public final List<Integer> b() {
        List<Integer> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(2, 3, 9, 10);
        return mutableListOf;
    }

    public final String a(int shareAction) {
        if (shareAction != 2) {
            if (shareAction == 3) {
                return "3";
            }
            if (shareAction == 9) {
                return "4";
            }
            if (shareAction == 10) {
                return "5";
            }
            if (shareAction != 72 && shareAction != 73) {
                if (shareAction != 171) {
                    return "0";
                }
                return "2";
            }
        }
        return "1";
    }
}

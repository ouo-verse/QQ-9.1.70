package com.tencent.mobileqq.qqecommerce.base.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.share.api.ECActionItemClickListener;
import com.tencent.ecommerce.base.share.api.ECQQShareData;
import com.tencent.ecommerce.base.share.api.ECQZoneShareData;
import com.tencent.ecommerce.base.share.api.ECShareParam;
import com.tencent.ecommerce.base.share.api.ECWxShareData;
import com.tencent.ecommerce.base.share.api.ECXhsShareData;
import com.tencent.ecommerce.base.share.api.IECAddShortCutCallback;
import com.tencent.ecommerce.base.share.api.IECShareCallback;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.base.share.api.ShortCutInfo;
import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001bH\u0016J\"\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001bH\u0016J<\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010 \u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\u0006\u0010%\u001a\u00020$H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/share/c;", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/ecommerce/base/share/api/h;", "shortCutInfo", "Lcom/tencent/ecommerce/base/share/api/IECAddShortCutCallback;", "callback", "", "addShortCut", "", "filePath", "copyImageFileToMediaStorage", "Landroid/content/Context;", "", "requestCode", "Lcom/tencent/ecommerce/base/share/api/c;", "data", "shareMsgToQQ", "Lcom/tencent/ecommerce/base/share/api/d;", "shareMsgToQZone", "Lcom/tencent/ecommerce/base/share/api/f;", "", "shareMsgToTimeLine", "shareMsgToWx", "context", "Lcom/tencent/ecommerce/base/share/api/g;", "Lcom/tencent/ecommerce/base/share/api/IECShareCallback;", "shareMsgToXhs", "Lcom/tencent/ecommerce/base/share/api/e;", "param", "showShareActionSheet", "title", "", "shareActions", "shareOperations", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "listener", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c implements IECShareProxy {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/share/c$b", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$a;", "", "type", "Landroid/os/Bundle;", "data", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IReadInjoyWebShareHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECShareCallback f262470a;

        b(IECShareCallback iECShareCallback) {
            this.f262470a = iECShareCallback;
        }

        @Override // com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper.a
        public void a(int type, Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.f262470a == null || type != 161) {
                return;
            }
            String string = data.getString("result");
            if (string == null || string.length() == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                String action = jSONObject.optString("action");
                String retCode = jSONObject.optString("retCode");
                IECShareCallback iECShareCallback = this.f262470a;
                Intrinsics.checkNotNullExpressionValue(action, "action");
                Intrinsics.checkNotNullExpressionValue(retCode, "retCode");
                iECShareCallback.onShareCallback(action, retCode);
            } catch (JSONException e16) {
                QLog.w("ECShareProxy", 1, e16.getMessage());
            }
        }
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void addShortCut(Activity activity, ShortCutInfo shortCutInfo, IECAddShortCutCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shortCutInfo, "shortCutInfo");
        ECShortCutUtil.f262463a.d(activity, shortCutInfo, callback);
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public String copyImageFileToMediaStorage(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return ((IFilePathUtil) QRoute.api(IFilePathUtil.class)).copyImageFileToMediaStorage(filePath);
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void shareMsgToQQ(Context activity, int requestCode, ECQQShareData data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Activity a16 = af2.b.f25996a.a(activity);
        if (a16 != null) {
            ECShareUtil.f262459a.n(a16, requestCode, data);
        }
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void shareMsgToQZone(Context activity, int requestCode, ECQZoneShareData data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Activity a16 = af2.b.f25996a.a(activity);
        if (a16 != null) {
            ECShareUtil.f262459a.o(a16, requestCode, data);
        }
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public boolean shareMsgToTimeLine(Context activity, ECWxShareData data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Activity a16 = af2.b.f25996a.a(activity);
        if (a16 != null) {
            return ECShareUtil.f262459a.r(a16, data, 1);
        }
        return false;
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public boolean shareMsgToWx(Context activity, ECWxShareData data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Activity a16 = af2.b.f25996a.a(activity);
        if (a16 != null) {
            return ECShareUtil.f262459a.r(a16, data, 0);
        }
        return false;
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void shareMsgToXhs(Context context, ECXhsShareData data, IECShareCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ECShareUtil.f262459a.q(af2.b.f25996a.a(context), data, callback);
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void showShareActionSheet(Context activity, ECShareParam param, IECShareCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.w("ECShareProxy", 1, "#showShareActionSheet: appRuntime is not instance of AppInterface");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("data", param.getJsonData());
        bundle.putInt("code_share_qzone_key", 2);
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        bundle.putString("uin_key", appInterface.getAccount());
        Activity a16 = af2.b.f25996a.a(activity);
        if (a16 != null) {
            ((IReadInjoyWebShareHelper) QRoute.api(IReadInjoyWebShareHelper.class)).showShareActionSheet(a16, appInterface, bundle, new b(callback));
        }
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void showShareActionSheet(Context activity, String title, List<Integer> shareActions, List<Integer> shareOperations, ECActionItemClickListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareActions, "shareActions");
        Intrinsics.checkNotNullParameter(shareOperations, "shareOperations");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Activity a16 = af2.b.f25996a.a(activity);
        if (a16 != null) {
            ECShareUtil.f262459a.t(a16, title, shareActions, shareOperations, listener);
        }
    }
}

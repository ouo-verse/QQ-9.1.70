package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.api.IVasMqqView;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.view.QQVipArkHeaderView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasMqqViewImpl;", "Lcom/tencent/mobileqq/vas/api/IVasMqqView;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "param", "Lcom/tencent/mobileqq/vas/api/a;", "getQQVipArkHeaderView", "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasMqqViewImpl implements IVasMqqView {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasMqqViewImpl$a;", "Lcom/tencent/mobileqq/vas/api/a;", "", "param", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "width", "height", "", "a", "onDestory", "Landroid/view/View;", "getView", "Lt23/a;", "Lt23/a;", "proxy", "", "b", UserInfo.SEX_FEMALE, "scale", "<init>", "(Lt23/a;F)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.vas.api.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final t23.a proxy;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final float scale;

        public a(t23.a proxy, float f16) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
            this.scale = f16;
        }

        @Override // com.tencent.mobileqq.vas.api.a
        public void a(String param, Activity activity, int width, int height) {
            String str;
            String jSONObject;
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(activity, "activity");
            JSONObject jSONObject2 = new JSONObject(param);
            String optString = jSONObject2.optString("content");
            int optInt = jSONObject2.optInt("msgTime");
            String optString2 = jSONObject2.optString("adID");
            String optString3 = jSONObject2.optString("uin");
            int optInt2 = jSONObject2.optInt("pageIndex");
            int optInt3 = jSONObject2.optInt("msgId");
            t23.a aVar = this.proxy;
            QQVipMsgInfo qQVipMsgInfo = new QQVipMsgInfo();
            qQVipMsgInfo.mMsgTime = optInt;
            qQVipMsgInfo.mAdvId = optString2;
            qQVipMsgInfo.mFrienduin = optString3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(optInt3);
            qQVipMsgInfo.mPaMsgid = sb5.toString();
            JSONObject jSONObject3 = new JSONObject(optString);
            String optString4 = jSONObject3.optString("app");
            jSONObject3.optString("desc");
            JSONObject optJSONObject = jSONObject3.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            String optString5 = jSONObject3.optString("ver");
            String optString6 = jSONObject3.optString("view");
            JSONObject optJSONObject2 = jSONObject3.optJSONObject(DownloadInfo.spKey_Config);
            qQVipMsgInfo.mArkAppName = optString4;
            String str2 = "";
            if (optJSONObject2 == null || (str = optJSONObject2.toString()) == null) {
                str = "";
            }
            qQVipMsgInfo.mArkAppConfig = str;
            qQVipMsgInfo.mArkAppView = optString6;
            qQVipMsgInfo.mArkAppMinVersion = optString5;
            if (optJSONObject != null && (jSONObject = optJSONObject.toString()) != null) {
                str2 = jSONObject;
            }
            qQVipMsgInfo.mArkMetaList = str2;
            qQVipMsgInfo.mArkScale = this.scale;
            qQVipMsgInfo.mArkWidth = width;
            qQVipMsgInfo.mArkHeight = height;
            qQVipMsgInfo.isKuikly = true;
            aVar.a(qQVipMsgInfo, activity, optInt2);
        }

        @Override // com.tencent.mobileqq.vas.api.a
        public View getView() {
            Object obj = this.proxy;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            return (View) obj;
        }

        @Override // com.tencent.mobileqq.vas.api.a
        public void onDestory() {
            this.proxy.onDestory();
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasMqqView
    public com.tencent.mobileqq.vas.api.a getQQVipArkHeaderView(Activity activity, String param) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        return new a(new QQVipArkHeaderView(activity, null), activity.getResources().getDisplayMetrics().scaledDensity);
    }
}

package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000  2\u00020\u0001:\u00017B%\u0012\b\u0010#\u001a\u0004\u0018\u00010\b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010*\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b5\u00106J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010 \u001a\u00020\u000fH\u0014J\b\u0010!\u001a\u00020\u0006H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00100R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00100R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/d;", "Lcom/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper;", "Landroid/content/Intent;", "intent", "", "requestCode", "", "O", "Landroid/app/Activity;", "r", "Landroid/os/Bundle;", "bundle", "N", "", "P", "", HippyTKDListViewAdapter.X, "v", "Lcom/tencent/common/app/AppInterface;", ReportConstant.COSTREPORT_PREFIX, "action", "", "successed", "data", "H", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$a;", "callback", "w", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "content", "B", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, DomainData.DOMAIN_NAME, "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$a;", "o", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$a;", "readInjoyWebShareHelperCallBack", "p", "I", "seq", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "codeShareQzone", "Ljava/lang/String;", "uin", "publicUin", "t", "currentUrl", "<init>", "(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$a;)V", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends AbstractReadInjoyWebShareHelper {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private AppInterface appInterface;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private IReadInjoyWebShareHelper.a readInjoyWebShareHelperCallBack;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int codeShareQzone;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int seq = -1;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String publicUin = "";

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String currentUrl = "";

    public d(Activity activity, AppInterface appInterface, IReadInjoyWebShareHelper.a aVar) {
        this.activity = activity;
        this.appInterface = appInterface;
        this.readInjoyWebShareHelperCallBack = aVar;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    protected void B(String content, ITroopMemberApiClientApi.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface appInterface = this.appInterface;
        Intrinsics.checkNotNull(appInterface, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) appInterface).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        boolean z16 = false;
        if (businessHandler != null && (businessHandler instanceof DataLineHandler)) {
            Long X2 = ((DataLineHandler) businessHandler).X2(content, 0);
            Intrinsics.checkNotNullExpressionValue(X2, "handler.SendText(content, 0)");
            if (X2.longValue() > 0) {
                z16 = true;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSuccess", z16);
        callback.callback(bundle);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public void H(int action, boolean successed, String data) {
        ReadInJoyShareHelperV2.INSTANCE.c(action, successed, data);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public /* bridge */ /* synthetic */ void L(Intent intent, Byte b16) {
        O(intent, b16.byteValue());
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public /* bridge */ /* synthetic */ int M(Byte b16) {
        return P(b16.byteValue());
    }

    public void N(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("data");
        this.seq = bundle.getInt("seq");
        this.codeShareQzone = bundle.getInt("code_share_qzone_key");
        String string2 = bundle.getString("uin_key", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(ReadInj\u2026HelperAction.UIN_KEY, \"\")");
        this.uin = string2;
        String string3 = bundle.getString("public_uin_key", "");
        Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(ReadInj\u2026ction.PUBLIC_UIN_KEY, \"\")");
        this.publicUin = string3;
        String string4 = bundle.getString("current_url_key", "");
        Intrinsics.checkNotNullExpressionValue(string4, "bundle.getString(ReadInj\u2026tion.CURRENT_URL_KEY, \"\")");
        this.currentUrl = string4;
        J(string);
    }

    public void O(Intent intent, byte requestCode) {
        Activity activity = this.activity;
        if (activity != null) {
            activity.startActivity(intent);
        }
        if (requestCode == 1) {
            A("qq_friend", true);
        } else if (requestCode == 2) {
            A("qzone", true);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public void m(String result) {
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        bundle.putInt("seq", this.seq);
        bundle.putString("methodName", "callBackToJs");
        IReadInjoyWebShareHelper.a aVar = this.readInjoyWebShareHelperCallBack;
        if (aVar != null) {
            aVar.a(161, bundle);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public Activity r() {
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        return activity;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public AppInterface s() {
        AppInterface appInterface = this.appInterface;
        Intrinsics.checkNotNull(appInterface);
        return appInterface;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    /* renamed from: u, reason: from getter */
    protected String getCurrentUrl() {
        return this.currentUrl;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    /* renamed from: v, reason: from getter */
    public String getPublicUin() {
        return this.publicUin;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    protected void w(ITroopMemberApiClientApi.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Bundle bundle = new Bundle();
        bundle.putInt("readinjoy_to_wx_config", ReadInJoyHelper.A(com.tencent.mobileqq.kandian.base.utils.b.c()));
        callback.callback(bundle);
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    /* renamed from: x, reason: from getter */
    public String getUin() {
        return this.uin;
    }

    @Override // com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
    public void z() {
        this.activity = null;
        this.appInterface = null;
        this.readInjoyWebShareHelperCallBack = null;
        y();
    }

    public int P(byte requestCode) {
        return requestCode == 2 ? this.codeShareQzone : requestCode;
    }
}

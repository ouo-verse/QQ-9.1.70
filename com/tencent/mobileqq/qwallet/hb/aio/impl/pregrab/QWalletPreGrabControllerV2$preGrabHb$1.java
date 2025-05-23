package com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab;

import android.content.Context;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.hb.aio.impl.d;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pl2.j;
import tencent.im.qqwallet.QWalletHbPreGrab$QQHBRequest;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pskey", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QWalletPreGrabControllerV2$preGrabHb$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ AppRuntime $appRuntime;
    final /* synthetic */ String $authKey;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $groupId;
    final /* synthetic */ int $hbFrom;
    final /* synthetic */ QWalletMsgModel $qqWalletMsg;
    final /* synthetic */ String $redId;
    final /* synthetic */ QWalletSessionInfo $sessionInfo;
    final /* synthetic */ QWalletPreGrabControllerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletPreGrabControllerV2$preGrabHb$1(QWalletPreGrabControllerV2 qWalletPreGrabControllerV2, QWalletSessionInfo qWalletSessionInfo, AppRuntime appRuntime, QWalletMsgModel qWalletMsgModel, String str, String str2, int i3, Context context, String str3) {
        super(1);
        this.this$0 = qWalletPreGrabControllerV2;
        this.$sessionInfo = qWalletSessionInfo;
        this.$appRuntime = appRuntime;
        this.$qqWalletMsg = qWalletMsgModel;
        this.$authKey = str;
        this.$groupId = str2;
        this.$hbFrom = i3;
        this.$context = context;
        this.$redId = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QWalletPreGrabControllerV2 this$0, AppRuntime appRuntime, Context context, QWalletSessionInfo sessionInfo, QWalletMsgModel qqWalletMsg, String redId, String str, int i3, String str2, String str3, int i16, boolean z16, Bundle bundle) {
        JSONObject m3;
        boolean i17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
        Intrinsics.checkNotNullParameter(qqWalletMsg, "$qqWalletMsg");
        Intrinsics.checkNotNullParameter(redId, "$redId");
        QLog.i("QWalletPreGrabController", 1, "pregrab request finish. type:" + i16 + " isSuccess:" + z16);
        if (!z16) {
            QWalletPreGrabControllerV2.k(this$0, bundle != null ? bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE) : -4, null, 2, null);
            return;
        }
        try {
            Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
            m3 = this$0.m(bundle, appRuntime, context);
            if (m3 != null) {
                i17 = this$0.i(appRuntime, sessionInfo, context, qqWalletMsg, redId, str, i3, str2, str3, m3);
                if (i17) {
                    QWalletPreGrabControllerV2.k(this$0, 0, null, 2, null);
                    return;
                } else {
                    QWalletPreGrabControllerV2.k(this$0, -6, null, 2, null);
                    return;
                }
            }
            QWalletPreGrabControllerV2.k(this$0, -5, null, 2, null);
        } catch (IllegalArgumentException e16) {
            this$0.j(-5, e16.getMessage());
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable String str) {
        Map f16;
        String g16;
        int i3;
        if (str == null || str.length() == 0) {
            QLog.e("QWalletPreGrabController", 1, "pskey isNullOrEmpty");
            QWalletPreGrabControllerV2.k(this.this$0, -2, null, 2, null);
            return;
        }
        Bundle d16 = d.d(this.$sessionInfo.getCurType());
        final int i16 = d16.getInt(NotifyMsgApiImpl.KEY_GROUP_TYPE);
        final String string = d16.getString("name");
        f16 = this.this$0.f(this.$appRuntime, this.$sessionInfo, this.$qqWalletMsg, this.$authKey, this.$groupId, i16, string, this.$hbFrom);
        g16 = this.this$0.g(this.$appRuntime, this.$context, f16, str);
        if (g16 == null || g16.length() == 0) {
            QWalletPreGrabControllerV2.k(this.this$0, -3, null, 2, null);
            QLog.e("QWalletPreGrabController", 1, "encrypt text fail, reqParams:" + f16);
            return;
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, j.class);
        newIntent.putExtra("cmd", "trpc.qqhb.qqhb_proxy.Handler.sso_handle");
        QWalletHbPreGrab$QQHBRequest qWalletHbPreGrab$QQHBRequest = new QWalletHbPreGrab$QQHBRequest();
        QWalletPreGrabControllerV2 qWalletPreGrabControllerV2 = this.this$0;
        qWalletHbPreGrab$QQHBRequest.cgiName.set("hb_pre_grap");
        qWalletHbPreGrab$QQHBRequest.reqText.set(g16);
        PBStringField pBStringField = qWalletHbPreGrab$QQHBRequest.random;
        i3 = qWalletPreGrabControllerV2.keyIndex;
        pBStringField.set(String.valueOf(i3));
        qWalletHbPreGrab$QQHBRequest.enType.set(0);
        newIntent.putExtra("data", fh.b(qWalletHbPreGrab$QQHBRequest.toByteArray()));
        final QWalletPreGrabControllerV2 qWalletPreGrabControllerV22 = this.this$0;
        final AppRuntime appRuntime = this.$appRuntime;
        final Context context = this.$context;
        final QWalletSessionInfo qWalletSessionInfo = this.$sessionInfo;
        final QWalletMsgModel qWalletMsgModel = this.$qqWalletMsg;
        final String str2 = this.$redId;
        final String str3 = this.$authKey;
        final String str4 = this.$groupId;
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.b
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i17, boolean z16, Bundle bundle) {
                QWalletPreGrabControllerV2$preGrabHb$1.b(QWalletPreGrabControllerV2.this, appRuntime, context, qWalletSessionInfo, qWalletMsgModel, str2, str3, i16, str4, string, i17, z16, bundle);
            }
        });
        this.$appRuntime.startServlet(newIntent);
    }
}

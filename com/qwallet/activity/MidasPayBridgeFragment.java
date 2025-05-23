package com.qwallet.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.pay.b;
import com.qwallet.pay.s;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/qwallet/activity/MidasPayBridgeFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "needDispatchTouchEvent", "Lcom/qwallet/pay/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qwallet/pay/b;", "payLogic", "D", "Z", "isOnResume", "", "E", "J", "lastResumeTime", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class MidasPayBridgeFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.qwallet.pay.b payLogic;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isOnResume;

    /* renamed from: E, reason: from kotlin metadata */
    private long lastResumeTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(MidasPayBridgeFragment this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setResult(-1);
        this$0.finish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        com.qwallet.pay.a aVar;
        boolean z16 = false;
        if (ev5 != null && 1 == ev5.getAction()) {
            z16 = true;
        }
        if (z16 && this.isOnResume && !isFinishing() && NetConnInfoCenter.getServerTimeMillis() - this.lastResumeTime > 5000) {
            com.qwallet.pay.b bVar = this.payLogic;
            if (bVar instanceof com.qwallet.pay.a) {
                aVar = (com.qwallet.pay.a) bVar;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.f(-94);
            }
            finish();
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return !((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_DISABLE_CLOSE_MIDAS_BRIDGE, false);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Unit unit;
        super.onCreate(savedInstanceState);
        com.qwallet.pay.b b16 = s.e().b(getQBaseActivity(), getIntent(), new b.a() { // from class: com.qwallet.activity.a
            @Override // com.qwallet.pay.b.a
            public final void x2(Context context) {
                MidasPayBridgeFragment.qh(MidasPayBridgeFragment.this, context);
            }
        });
        this.payLogic = b16;
        if (b16 != null) {
            b16.a(getQBaseActivity());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isOnResume = false;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isOnResume = true;
        this.lastResumeTime = NetConnInfoCenter.getServerTimeMillis();
    }
}

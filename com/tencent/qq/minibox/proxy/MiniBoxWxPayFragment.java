package com.tencent.qq.minibox.proxy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wxapi.WXPayHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxWxPayFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Handler;", "getHandler", "Landroid/os/Bundle;", "params", "", "rh", Constants.FILE_INSTANCE_STATE, "onCreate", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "callbackScheme", "D", "Landroid/os/Handler;", "observer", "<init>", "()V", "E", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxWxPayFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String callbackScheme;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Handler observer = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.qq.minibox.proxy.o
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean qh5;
            qh5 = MiniBoxWxPayFragment.qh(MiniBoxWxPayFragment.this, message);
            return qh5;
        }
    });

    /* renamed from: getHandler, reason: from getter */
    private final Handler getObserver() {
        return this.observer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean qh(MiniBoxWxPayFragment this$0, Message it) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        QLog.i("MiniBoxWxPayFragment", 1, "onWxPayResult: " + it);
        if (it.what == 10) {
            WXPayHelper.getInstance().removeObserver(this$0.getObserver());
            String str = this$0.callbackScheme;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                        intent.setData(Uri.parse(str));
                        intent.addFlags(268435456);
                        QLog.i("MiniBoxWxPayFragment", 1, "onWxPayResult, start callback scheme=" + str);
                        BaseApplication.getContext().startActivity(intent);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return true;
    }

    private final void rh(Bundle params) {
        String str;
        if (params != null) {
            str = params.getString("callback_scheme");
        } else {
            str = null;
        }
        this.callbackScheme = str;
        WXPayHelper.getInstance().addObserver(this.observer);
        WXPayHelper.getInstance().sendReq(params);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rh(getArguments());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}

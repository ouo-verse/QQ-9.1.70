package com.tencent.mobileqq.wxshare;

import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wxshare/f;", "Lcom/tencent/mobileqq/selectmember/wechat/a;", "", "forwardType", "", "b", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f implements com.tencent.mobileqq.selectmember.wechat.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str) {
        d.g(str);
    }

    @Override // com.tencent.mobileqq.selectmember.wechat.a
    public void a(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        final String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        if (stringExtra != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxshare.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.d(stringExtra);
                }
            }, 16, null, true);
        } else {
            QLog.e("WxSharePicOption", 1, "doShare picPath is null.");
        }
    }

    @Override // com.tencent.mobileqq.selectmember.wechat.a
    public boolean b(int forwardType) {
        if (forwardType == 1) {
            return true;
        }
        return false;
    }
}

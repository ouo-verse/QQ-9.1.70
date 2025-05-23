package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\b\u0010\u0002\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\u0007"}, d2 = {"", "d", "c", "", "path", "", "b", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    public static final boolean b(@Nullable String str) {
        boolean z16;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        if (new File(str).length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.d("AIOSendMsgVMDelegate", 1, "send file length is 0\uff1fpath: " + str);
        }
        return z17;
    }

    private static final void c() {
        QQToast.makeText(BaseApplication.context, 1, R.string.f237367gv, 0).show();
    }

    public static final void d() {
        if (UiThreadUtil.isOnUiThread()) {
            c();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.utils.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        c();
    }
}

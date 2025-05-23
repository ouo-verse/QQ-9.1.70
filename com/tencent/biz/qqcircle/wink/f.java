package com.tencent.biz.qqcircle.wink;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.qqcircle.immersive.personal.utils.k;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJB\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/f;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", IProfileCardConst.KEY_FROM_TYPE, "", "traceId", "", "reportBean", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f93951a = new f();

    f() {
    }

    public final void a(@Nullable Context context, @Nullable Bundle bundle, int fromType, @Nullable String traceId, @Nullable Map<String, Object> reportBean) {
        if (context == null) {
            QLog.i("QQWinkIndexJumper", 1, "context is null");
        } else if (context instanceof Activity) {
            QCircleToast.u(k.d(), 0, true);
        }
    }
}

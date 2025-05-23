package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.push.MsgNotification;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/parser/cp;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "cc", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class cp extends com.tencent.mobileqq.utils.ax {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(BaseQQAppInterface app, Context cc5) {
        super(app, cc5);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        if (QLog.isColorLevel()) {
            QLog.d("QZonePushAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        }
        try {
            Context context = this.f307437b;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            return MsgNotification.handle(activity, activity.getIntent());
        } catch (Exception e16) {
            QLog.e("QZonePushAction", 1, "doAction error: " + e16.getMessage());
            i("QZonePushAction");
            return false;
        }
    }
}

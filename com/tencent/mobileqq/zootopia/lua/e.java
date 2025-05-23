package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/e;", "", "Lcom/tencent/mobileqq/zootopia/helper/e;", BdhLogUtil.LogTag.Tag_Conn, "caller", "", "requestCode", "", "", "permissions", "", "requestPermissions", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "Landroid/app/Activity;", "x1", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface e {
    com.tencent.mobileqq.zootopia.helper.e C();

    void requestPermissions(Object caller, int requestCode, String... permissions);

    Activity x1();
}

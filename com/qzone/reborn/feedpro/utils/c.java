package com.qzone.reborn.feedpro.utils;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/c;", "", "", "errorCode", "", "errorMsg", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f54317a = new c();

    c() {
    }

    public final void a(long errorCode, String errorMsg, String defaultText) {
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        QLog.e("QzoneErrorToastUtils", 1, "toastError fail errorCode:" + errorCode + ", errorMsg:" + errorMsg);
        if (errorMsg == null) {
            errorMsg = defaultText;
        }
        c6.a.j(errorMsg, 4);
    }
}

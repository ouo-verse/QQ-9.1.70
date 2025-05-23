package com.tencent.mobileqq.config.business.qmmkv;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/g;", "Lcom/tencent/mobileqq/config/business/qmmkv/b;", "", "update", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends b {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final g f202811f = new g();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    g() {
        super("mmkv_is_highLevelFd_9020", r0);
        boolean z16;
        if (Build.VERSION.SDK_INT >= 28) {
            z16 = true;
        } else {
            z16 = false;
        }
    }

    @Override // com.tencent.mobileqq.config.business.qmmkv.b, com.tencent.mobileqq.config.business.qmmkv.m
    public void update() {
        boolean z16;
        if (qy3.a.g().f() > 1024) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QMMKV_ConfigSwitch", 1, "update switch [" + getConfigKey() + "] : " + z16);
        }
        c(z16);
    }
}

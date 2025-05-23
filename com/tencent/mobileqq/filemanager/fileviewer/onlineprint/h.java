package com.tencent.mobileqq.filemanager.fileviewer.onlineprint;

import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/h;", "", "", "action", "", "b", "c", "", "e", "serviceProvider", "a", "d", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "<init>", "()V", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f208453a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity mmkvEntity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        mmkvEntity = from;
    }

    h() {
    }

    public final void a(@NotNull String serviceProvider) {
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        mmkvEntity.encodeString("last_service_provider", serviceProvider);
    }

    public final void b(@NotNull String action) {
        String str;
        Intrinsics.checkNotNullParameter(action, "action");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(action);
        sb5.append(util.base64_pad_url);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        MMKVOptionEntity mMKVOptionEntity = mmkvEntity;
        mMKVOptionEntity.encodeInt(sb6, mMKVOptionEntity.decodeInt(sb6, 0) + 1);
    }

    public final void c(@NotNull String action) {
        String str;
        Intrinsics.checkNotNullParameter(action, "action");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(action);
        sb5.append(util.base64_pad_url);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        mmkvEntity.encodeInt(sb5.toString(), 3);
    }

    public final boolean d(@NotNull String serviceProvider) {
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        QLog.d("OnlinePrintNewerGuideFrequencyControl", 1, "needShowDisclaimerDialog serviceProvider: " + serviceProvider + ", lastServiceProvider: " + mmkvEntity.decodeString("last_service_provider", ""));
        return !TextUtils.equals(r0, serviceProvider);
    }

    public final boolean e(@NotNull String action) {
        String str;
        Intrinsics.checkNotNullParameter(action, "action");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(action);
        sb5.append(util.base64_pad_url);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        int decodeInt = mmkvEntity.decodeInt(sb6, 0);
        QLog.d("OnlinePrintNewerGuideFrequencyControl", 1, "needShowNewerGuide key: " + sb6 + ", times: " + decodeInt);
        if (decodeInt >= 3) {
            return false;
        }
        return true;
    }
}

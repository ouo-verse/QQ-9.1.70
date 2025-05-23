package com.tencent.timi.game.utils;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/utils/n;", "", "", "netUnavailableHintResId", "", "b", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f380308a = new n();

    n() {
    }

    public final boolean a() {
        if (!AppNetConnInfo.isMobileConn() && !AppNetConnInfo.isWifiConn()) {
            return false;
        }
        return true;
    }

    public final boolean b(int netUnavailableHintResId) {
        if (!AppNetConnInfo.isMobileConn() && !AppNetConnInfo.isWifiConn()) {
            if (netUnavailableHintResId != 0) {
                QQToast.makeText(BaseApplication.context, netUnavailableHintResId, 0).show();
            }
            return false;
        }
        return true;
    }
}

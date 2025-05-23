package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ai;", "", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ai f326672a = new ai();

    ai() {
    }

    private final String a(String key, String defaultValue) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(key, defaultValue);
    }

    @NotNull
    public final String b() {
        return a("qzone_picker_photo_recommend_string", "");
    }
}

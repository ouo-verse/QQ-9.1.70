package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import androidx.annotation.AnyThread;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.minigame.helper.PreloadStorageHelper;
import com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "appId", "", "a", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f346537a = new a();

    a() {
    }

    @JvmStatic
    @AnyThread
    public static final void a(@Nullable Activity activity, @Nullable String appId) {
        if (activity != null) {
            PreloadSystemInfoHelper.c(activity);
            PreloadStorageHelper.a(activity, appId);
        }
    }
}

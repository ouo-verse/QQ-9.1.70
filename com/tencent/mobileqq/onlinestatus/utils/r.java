package com.tencent.mobileqq.onlinestatus.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0006"}, d2 = {"Lmqq/app/AppRuntime;", "appRuntime", "", IOnlineStatusService.SONG_ID, "", "a", "qqonlinestatus-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class r {
    public static final boolean a(@Nullable AppRuntime appRuntime, @Nullable String str) {
        ArrayList<com.tencent.mobileqq.lyric.data.d> arrayList;
        Boolean bool;
        ArrayList<com.tencent.mobileqq.lyric.data.d> arrayList2;
        if (appRuntime == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicUtils", 2, "[hasLyrics] songId=" + str + '.');
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026rocessConstant.MAIN\n    )");
        com.tencent.mobileqq.onlinestatus.manager.e eVar = (com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class);
        if (eVar == null) {
            return false;
        }
        com.tencent.mobileqq.lyric.data.b j3 = eVar.j(str);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[hasLyrics] hasLyric=");
            if (j3 != null && (arrayList2 = j3.f243142b) != null) {
                bool = Boolean.valueOf(!arrayList2.isEmpty());
            } else {
                bool = null;
            }
            sb5.append(bool);
            sb5.append('.');
            QLog.d("MusicUtils", 2, sb5.toString());
        }
        if (j3 == null || (arrayList = j3.f243142b) == null || !(!arrayList.isEmpty())) {
            return false;
        }
        return true;
    }
}

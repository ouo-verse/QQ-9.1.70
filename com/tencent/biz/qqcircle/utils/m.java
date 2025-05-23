package com.tencent.biz.qqcircle.utils;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/m;", "", "", "appId", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "a", "", "ignoreCache", "b", "", "expNames", "", "d", "", "Ljava/util/Map;", "cachedGroupNames", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f92779a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> cachedGroupNames = new LinkedHashMap();

    m() {
    }

    private final ExpEntityInfo a(String appId, String expName) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(appId, expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(appId, expName)");
        return expEntity;
    }

    public static /* synthetic */ String c(m mVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return mVar.b(str, str2, z16);
    }

    @NotNull
    public final String b(@NotNull String expName, @NotNull String appId, boolean ignoreCache) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        QLog.d("QCircleAbTestUtilsExt", 1, "groupName expName=" + expName + ", appId=" + appId + ", ignoreCache=" + ignoreCache);
        String str = "";
        if (ignoreCache) {
            String assignment = a(appId, expName).getAssignment();
            if (assignment != null) {
                str = assignment;
            }
            cachedGroupNames.put(expName, str);
        } else {
            Map<String, String> map = cachedGroupNames;
            String str2 = map.get(expName);
            if (str2 == null) {
                String assignment2 = f92779a.a(appId, expName).getAssignment();
                if (assignment2 != null) {
                    Intrinsics.checkNotNullExpressionValue(assignment2, "getExpEntry(appId, expName).assignment ?: \"\"");
                    str = assignment2;
                }
                map.put(expName, str);
                str2 = str;
            }
            str = str2;
        }
        l.i(expName);
        return str;
    }

    public final void d(@Nullable Set<String> expNames) {
        QLog.d("QCircleAbTestUtilsExt", 1, "updateExpCache");
        if (expNames == null) {
            cachedGroupNames.clear();
            return;
        }
        Iterator<T> it = expNames.iterator();
        while (it.hasNext()) {
            cachedGroupNames.remove((String) it.next());
        }
    }
}

package com.tencent.rmonitor.common.lifecycle;

import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rmonitor/common/lifecycle/e;", "", "", "log", "", "a", "activityClassName", "action", "d", "Lorg/json/JSONArray;", "b", "", "c", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "formatter", "", "[Ljava/lang/String;", "msgArray", "", "I", "operationLogCount", "<init>", "()V", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String[] msgArray;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int operationLogCount;

    public e() {
        String[] strArr = new String[30];
        for (int i3 = 0; i3 < 30; i3++) {
            strArr[i3] = "";
        }
        this.msgArray = strArr;
    }

    private final void a(String log) {
        int i3 = this.operationLogCount;
        this.msgArray[i3 % 30] = log;
        int i16 = i3 + 1;
        this.operationLogCount = i16;
        if (i16 < 0) {
            this.operationLogCount = (i16 % 30) + 30;
        }
    }

    @NotNull
    public final JSONArray b() {
        int i3;
        int i16 = this.operationLogCount;
        if (i16 > 30) {
            i3 = i16 - 30;
        } else {
            i3 = 0;
        }
        int i17 = i16 - 1;
        JSONArray jSONArray = new JSONArray();
        if (i17 >= i3) {
            while (true) {
                jSONArray.mo162put(this.msgArray[i17 % 30]);
                if (i17 == i3) {
                    break;
                }
                i17--;
            }
        }
        return jSONArray;
    }

    @NotNull
    public final List<String> c() {
        int i3;
        try {
            int i16 = this.operationLogCount;
            if (i16 > 30) {
                i3 = i16 - 30;
            } else {
                i3 = 0;
            }
            int i17 = i16 - 1;
            ArrayList arrayList = new ArrayList();
            if (i17 >= i3) {
                while (true) {
                    arrayList.add(this.msgArray[i17 % 30]);
                    arrayList.add("\n");
                    if (i17 == i3) {
                        break;
                    }
                    i17--;
                }
            }
            return arrayList;
        } catch (Throwable th5) {
            Logger.f365497g.c("OperationLog", th5);
            return new ArrayList();
        }
    }

    public final void d(@NotNull String activityClassName, @NotNull String action) {
        String str;
        Intrinsics.checkParameterIsNotNull(activityClassName, "activityClassName");
        Intrinsics.checkParameterIsNotNull(action, "action");
        String format = this.formatter.format(new Date());
        if (TextUtils.isEmpty(activityClassName)) {
            str = format + " app switch to " + action;
        } else {
            str = format + TokenParser.SP + activityClassName + TokenParser.SP + action;
        }
        a(str);
    }
}

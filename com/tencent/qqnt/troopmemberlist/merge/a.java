package com.tencent.qqnt.troopmemberlist.merge;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002R2\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/merge/a;", "", "", "from", "", "b", "(Ljava/lang/String;)Ljava/lang/Integer;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "a", "(I)Ljava/lang/Long;", "configJsonStr", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "fromToTaskIdMap", "taskIdToMillsMap", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Integer> fromToTaskIdMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, Long> taskIdToMillsMap;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.fromToTaskIdMap = new HashMap<>();
            this.taskIdToMillsMap = new HashMap<>();
        }
    }

    @Nullable
    public final Long a(int taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Long) iPatchRedirector.redirect((short) 3, (Object) this, taskId);
        }
        return this.taskIdToMillsMap.get(Integer.valueOf(taskId));
    }

    @Nullable
    public final Integer b(@NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.fromToTaskIdMap.get(from);
    }

    public final void c(@NotNull String configJsonStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configJsonStr);
            return;
        }
        Intrinsics.checkNotNullParameter(configJsonStr, "configJsonStr");
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Long> hashMap2 = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONObject(configJsonStr).getJSONArray("configArr");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                long j3 = jSONObject.getLong("mergeMills");
                int i16 = jSONObject.getInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                hashMap2.put(Integer.valueOf(i16), Long.valueOf(j3));
                JSONArray jSONArray2 = jSONObject.getJSONArray("mergeFrom");
                int length2 = jSONArray2.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    String from = jSONArray2.getString(i17);
                    Integer valueOf = Integer.valueOf(i16);
                    Intrinsics.checkNotNullExpressionValue(from, "from");
                    hashMap.put(from, valueOf);
                }
            }
            this.fromToTaskIdMap = hashMap;
            this.taskIdToMillsMap = hashMap2;
        } catch (JSONException unused) {
            QLog.i("TroopMemberRequestMerge", 1, "[reload] json parse error, configJsonStr:" + configJsonStr);
        }
    }
}

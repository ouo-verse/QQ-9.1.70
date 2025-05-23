package com.tencent.mobileqq.troop.report.msgoperation;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0002J\u001a\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J.\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/report/msgoperation/c;", "", "", "eventId", "groupId", "msg", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", RemoteMessageConst.SEND_TIME, "", "c", "", "", "typeKeywords", "e", "d", "jsonString", "Lorg/json/JSONArray;", "j", "url", h.F, "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f298289a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f298289a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(String eventId, String groupId, String msg2, String senderUin, long sendTime) {
        boolean z16;
        String e16 = e(msg2, d());
        HashMap hashMap = new HashMap();
        hashMap.put("send_timestamp", String.valueOf(sendTime));
        hashMap.put("send_uid", senderUin);
        hashMap.put("group_id", groupId);
        if (e16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hashMap.put("aio_information_type", e16);
        }
        VideoReport.reportEvent(eventId, hashMap);
    }

    private final Map<String, Set<String>> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : com.tencent.mobileqq.troop.config.b.f294691a.a("100837").entrySet()) {
            String key = entry.getKey();
            JSONArray j3 = j(entry.getValue());
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int length = j3.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    String keyword = j3.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                    linkedHashSet.add(keyword);
                } catch (JSONException e16) {
                    QLog.e("TroopMsgOperationReport", 1, "get type keyword config exception: " + e16.getMessage());
                }
            }
            linkedHashMap.put(key, linkedHashSet);
        }
        return linkedHashMap;
    }

    private final String e(String msg2, Map<String, ? extends Set<String>> typeKeywords) {
        boolean contains;
        for (Map.Entry<String, ? extends Set<String>> entry : typeKeywords.entrySet()) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            boolean z16 = true;
            if (!(value instanceof Collection) || !value.isEmpty()) {
                Iterator<T> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    contains = StringsKt__StringsKt.contains((CharSequence) msg2, (CharSequence) it.next(), true);
                    if (!contains) {
                        z16 = false;
                        break;
                    }
                }
            }
            if (z16) {
                return key;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String groupId, String msg2, String senderUin, long j3) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(senderUin, "$senderUin");
        f298289a.c("ev_bas_long_press_msg", groupId, msg2, senderUin, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String groupId, String msg2, String senderUin, long j3) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(senderUin, "$senderUin");
        f298289a.c("ev_bas_click_link", groupId, msg2, senderUin, j3);
    }

    private final JSONArray j(String jsonString) {
        boolean z16;
        if (jsonString != null && jsonString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new JSONArray();
        }
        try {
            return new JSONArray(jsonString);
        } catch (JSONException e16) {
            QLog.e("TroopMsgOperationReport", 1, "parse keyword exception: " + e16.getMessage());
            return new JSONArray();
        }
    }

    public final void f(@NotNull final String groupId, @NotNull final String msg2, @NotNull final String senderUin, final long sendTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupId, msg2, senderUin, Long.valueOf(sendTime));
            return;
        }
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.report.msgoperation.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g(groupId, msg2, senderUin, sendTime);
            }
        }, 128, null, true);
    }

    public final void h(@NotNull final String groupId, @NotNull String url, @NotNull final String msg2, @NotNull final String senderUin, final long sendTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, groupId, url, msg2, senderUin, Long.valueOf(sendTime));
            return;
        }
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.report.msgoperation.a
            @Override // java.lang.Runnable
            public final void run() {
                c.i(groupId, msg2, senderUin, sendTime);
            }
        }, 128, null, true);
    }
}

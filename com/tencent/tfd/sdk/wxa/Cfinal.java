package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.util.JsonWriter;
import androidx.core.app.NotificationCompat;
import com.tencent.tfd.sdk.wxa.Ginkgo;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.final, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cfinal {
    public static String a(Context context) {
        String a16 = Coconut.f375544e.a(context, "s_h");
        if (a16 == null || a16.isEmpty()) {
            return "";
        }
        HashSet hashSet = new HashSet(Arrays.asList(a16.split(";")));
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                jsonWriter.name(str);
                Ginkgo.Cif a17 = Vulpecula.a(str);
                jsonWriter.beginObject();
                jsonWriter.name("std");
                jsonWriter.value(a17.f375631a);
                jsonWriter.name(NotificationCompat.CATEGORY_ERROR);
                jsonWriter.value(a17.f375632b);
                jsonWriter.endObject();
            }
            jsonWriter.endObject();
            return stringWriter.toString();
        } catch (IOException unused) {
            return "";
        }
    }
}

package com.tencent.turingcam;

import android.util.JsonWriter;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.VoByK;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ukkac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f382403a = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            new HashSet();
            new HashSet();
        }
    }

    public static String a() {
        String a16 = ZY08E.f382121f.a("s_h");
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
                VoByK.SkEpO b16 = L32b7.b(str);
                jsonWriter.beginObject();
                jsonWriter.name("std");
                jsonWriter.value(b16.f382081a);
                jsonWriter.name(NotificationCompat.CATEGORY_ERROR);
                jsonWriter.value(b16.f382082b);
                jsonWriter.endObject();
            }
            jsonWriter.endObject();
            return stringWriter.toString();
        } catch (IOException unused) {
            return "";
        }
    }
}

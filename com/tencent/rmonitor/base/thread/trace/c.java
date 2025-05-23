package com.tencent.rmonitor.base.thread.trace;

import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<b> a(String str) {
        if (str != null) {
            ArrayList<b> arrayList = new ArrayList<>();
            for (String str2 : str.split("#")) {
                String[] split = str2.split("%");
                if (split != null && split.length == 5) {
                    try {
                        b bVar = new b();
                        bVar.f365450e = Long.parseLong(split[0]);
                        bVar.f365451f = Long.parseLong(split[1]);
                        bVar.f365452h = Long.parseLong(split[2]);
                        bVar.f365453i = Long.parseLong(split[3]);
                        bVar.f365449d = split[4];
                        arrayList.add(bVar);
                    } catch (Throwable th5) {
                        Logger.f365497g.c("RMonitor_TStackInfoParser", th5);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}

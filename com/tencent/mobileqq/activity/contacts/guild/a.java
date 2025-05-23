package com.tencent.mobileqq.activity.contacts.guild;

import android.text.TextUtils;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements Comparator<b> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        long j3 = bVar.f181610b;
        long j16 = bVar2.f181610b;
        if (j3 > j16) {
            return -1;
        }
        if (j3 == j16) {
            if (!TextUtils.isEmpty(bVar.f181611c)) {
                return bVar.f181611c.compareTo(bVar2.f181611c);
            }
            return 0;
        }
        return 1;
    }
}

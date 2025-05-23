package com.tencent.mobileqq.vasgift.utils;

import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements Comparator<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2) {
        int i3 = aVar.f264916g;
        int i16 = aVar2.f264916g;
        if (i3 < i16) {
            return -1;
        }
        if (i3 == i16) {
            return 0;
        }
        return 1;
    }
}

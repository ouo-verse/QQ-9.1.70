package com.qzone.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f60902a;

    /* renamed from: b, reason: collision with root package name */
    public String f60903b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f60904c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<Long> f60905d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<Long, RapidCommentExpressionInfo> f60906e;

    /* renamed from: f, reason: collision with root package name */
    public int f60907f;

    /* renamed from: g, reason: collision with root package name */
    public int f60908g;

    /* renamed from: h, reason: collision with root package name */
    public int f60909h;

    /* renamed from: i, reason: collision with root package name */
    public int f60910i;

    public m(String str, String str2, ArrayList<Long> arrayList, boolean z16) {
        a(str, str2, arrayList, z16);
    }

    private void a(String str, String str2, ArrayList<Long> arrayList, boolean z16) {
        this.f60902a = str;
        this.f60903b = str2;
        this.f60905d = arrayList;
        this.f60904c = z16;
        if (arrayList != null) {
            this.f60906e = new HashMap<>();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                RapidCommentExpressionInfo rapidCommentExpressionInfo = new RapidCommentExpressionInfo();
                rapidCommentExpressionInfo.f60640e = next.longValue();
                rapidCommentExpressionInfo.D = false;
                this.f60906e.put(next, rapidCommentExpressionInfo);
            }
        }
    }
}

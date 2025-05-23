package com.tencent.luggage.wxa.zb;

import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements com.tencent.luggage.wxa.ac.b {

    /* renamed from: a, reason: collision with root package name */
    public List f146469a;

    public a(List list) {
        this.f146469a = list;
    }

    @Override // com.tencent.luggage.wxa.ac.b
    public String a(int i3) {
        Object item = getItem(i3);
        if (item == null) {
            item = "";
        } else if (!(item instanceof String)) {
            item = item.toString();
        }
        return (String) item;
    }

    @Override // com.tencent.luggage.wxa.ac.b
    public Object getItem(int i3) {
        if (i3 >= 0 && i3 < this.f146469a.size()) {
            return this.f146469a.get(i3);
        }
        return "";
    }

    @Override // com.tencent.luggage.wxa.ac.b
    public int a() {
        return this.f146469a.size();
    }
}

package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.DrawView2;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class x extends ab {

    /* renamed from: b, reason: collision with root package name */
    public long f198291b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f198292c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<DrawView2.a> f198293d;

    public x() {
        this.f197989a = 4L;
        this.f198293d = null;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ab
    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ARLocalFaceRecogResult{recogType = ");
        sb5.append(this.f197989a);
        sb5.append(",isTimeOut = ");
        sb5.append(this.f198292c);
        sb5.append(",frameIdx = ");
        sb5.append(this.f198291b);
        sb5.append(", faceDatas.size = ");
        ArrayList<DrawView2.a> arrayList = this.f198293d;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append('}');
        return sb5.toString();
    }
}

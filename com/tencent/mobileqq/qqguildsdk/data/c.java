package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements cy {

    /* renamed from: a, reason: collision with root package name */
    String f265798a;

    /* renamed from: b, reason: collision with root package name */
    long f265799b;

    /* renamed from: c, reason: collision with root package name */
    int f265800c;

    /* renamed from: d, reason: collision with root package name */
    Vector<GProChannelInfo> f265801d = new Vector<>();

    public c(String str, long j3) {
        this.f265798a = str;
        this.f265799b = j3;
    }

    public static Vector<c> b() {
        return new Vector<>();
    }

    public void a(GProChannelInfo gProChannelInfo) {
        this.f265801d.add(gProChannelInfo);
    }

    public void c(int i3) {
        this.f265800c = i3;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cy
    public long getCategoryId() {
        return this.f265799b;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cy
    public String getCategoryName() {
        return this.f265798a;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cy
    public int getCategoryType() {
        return this.f265800c;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.cy
    public List<IGProChannelInfo> getChannelList() {
        return new ArrayList(this.f265801d);
    }

    @NonNull
    public String toString() {
        return "CategoryInfo: categoryName:" + this.f265798a + ", categoryId:" + this.f265799b + ", channelList size:" + this.f265801d.size() + ", categoryType:" + this.f265800c;
    }
}

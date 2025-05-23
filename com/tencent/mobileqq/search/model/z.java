package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchDaTongApi;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class z extends y {

    /* renamed from: f, reason: collision with root package name */
    private int f283546f;

    /* renamed from: h, reason: collision with root package name */
    private int f283547h;

    /* renamed from: i, reason: collision with root package name */
    public int f283548i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f283549m = true;
    public int C = 0;
    private int D = 0;
    private boolean E = false;
    private String F = "";

    public JSONObject A() {
        return null;
    }

    public boolean B() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i3) {
        this.D = i3;
    }

    public void D(String str) {
        this.F = ((ISearchDaTongApi) QRoute.api(ISearchDaTongApi.class)).getDocId(this.D, str);
    }

    public void E(boolean z16) {
        this.E = z16;
        if (z16) {
            C(2);
        }
    }

    public void F(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public Object n(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public int p() {
        return this.f283546f;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public int q() {
        return this.f283547h;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void w(int i3, int i16) {
        this.f283546f = i3;
        this.f283547h = i16;
    }

    public int x() {
        return this.D;
    }

    public Map<String, String> y() {
        return null;
    }

    public String z() {
        return this.F;
    }
}

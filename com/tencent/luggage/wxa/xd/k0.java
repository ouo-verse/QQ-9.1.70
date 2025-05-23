package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.xd.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class k0 extends c {
    private d mComponent;
    private Map<String, Object> mDataAsMap;
    private String mDataAsString;
    private int mSrcId;

    public final void a(com.tencent.luggage.wxa.ei.p pVar) {
        if (pVar == this.mComponent.getJsRuntime()) {
            this.mComponent.a(getName(), getData(), getSrc());
        } else {
            h1.a(pVar, getName(), getData(), getSrc());
        }
    }

    public void dispatch() {
        if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) {
            Objects.requireNonNull(this.mComponent);
        }
        d dVar = this.mComponent;
        if (dVar == null || !dVar.isRunning()) {
            return;
        }
        dispatch(this.mComponent.getJsRuntime());
    }

    public String getData() {
        String str = this.mDataAsString;
        if (str != null) {
            return str;
        }
        Map<String, Object> map = this.mDataAsMap;
        if (map != null) {
            com.tencent.luggage.wxa.h6.f.a((Map) map);
            return new JSONObject(this.mDataAsMap).toString();
        }
        return null;
    }

    public final int getDest() {
        return this.mComponent.getComponentId();
    }

    public final int getSrc() {
        return this.mSrcId;
    }

    public k0 setContext(d dVar) {
        if (dVar == null) {
            return this;
        }
        this.mComponent = dVar;
        this.mSrcId = 0;
        return this;
    }

    public k0 setData(String str, Object obj) {
        if (this.mDataAsMap == null) {
            this.mDataAsMap = new HashMap();
        }
        this.mDataAsMap.put(str, obj);
        return this;
    }

    public k0 setContext(d dVar, int i3) {
        setContext(dVar);
        this.mSrcId = i3;
        return this;
    }

    public k0 setData(JSONObject jSONObject) {
        return jSONObject != null ? setData(jSONObject.toString()) : this;
    }

    public void dispatch(com.tencent.luggage.wxa.ei.p pVar) {
        if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) {
            Objects.requireNonNull(this.mComponent);
            Objects.requireNonNull(pVar);
        }
        d dVar = this.mComponent;
        if (dVar == null) {
            return;
        }
        if (pVar == null) {
            pVar = dVar.getJsRuntime();
        }
        if (this.mComponent.a(getName(), pVar)) {
            d.c interceptor = this.mComponent.getInterceptor();
            if (interceptor == null) {
                a(pVar);
            } else {
                interceptor.a(this, pVar, new a(pVar));
            }
        }
    }

    public k0 setData(String str) {
        this.mDataAsString = str;
        return this;
    }

    public k0 setData(Map<String, Object> map) {
        if (map == null) {
            return this;
        }
        com.tencent.luggage.wxa.h6.f.a((Map) map);
        this.mDataAsMap = map;
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.p f144860a;

        public a(com.tencent.luggage.wxa.ei.p pVar) {
            this.f144860a = pVar;
        }

        @Override // com.tencent.luggage.wxa.xd.d.b
        public void proceed() {
            k0.this.a(this.f144860a);
        }

        @Override // com.tencent.luggage.wxa.xd.d.b
        public void a(String str) {
        }
    }
}

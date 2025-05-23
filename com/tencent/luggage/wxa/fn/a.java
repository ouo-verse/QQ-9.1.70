package com.tencent.luggage.wxa.fn;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0015\u0012\u0006\u0010\u0014\u001a\u00020\r\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0005\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/luggage/wxa/fn/a;", "Lcom/tencent/luggage/wxa/fn/b;", "Lcom/tencent/luggage/wxa/mr/a;", "writer", "", "a", "", "", "data", "Lcom/tencent/luggage/wxa/hr/a;", "reader", "builder", "fieldNumber", "", "Lorg/json/JSONObject;", "e", "", "toString", "d", "Z", "printBytes", "", "Lcom/tencent/luggage/wxa/fn/d;", "[Lcom/tencent/luggage/wxa/fn/d;", "fields", "", "f", "[Ljava/lang/Object;", "cachedMaps", "Lcom/tencent/luggage/wxa/fn/e;", Node.ATTRS_ATTR, "<init>", "([Lcom/tencent/luggage/wxa/fn/e;Z)V", "autogen-proto"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class a extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean printBytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final d[] fields;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Object[] cachedMaps;

    public a(@NotNull e[] attrs, boolean z16) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.printBytes = z16;
        ArrayList arrayList = new ArrayList(attrs.length);
        for (e eVar : attrs) {
            arrayList.add(new d(null, null, 2, null));
        }
        Object[] array = arrayList.toArray(new d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.fields = (d[]) array;
        this.cachedMaps = new Object[attrs.length];
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public void a(com.tencent.luggage.wxa.mr.a writer) {
        if (writer == null) {
            return;
        }
        d[] dVarArr = this.fields;
        if (dVarArr.length <= 0) {
            return;
        }
        dVarArr[0].a();
        throw null;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        d[] dVarArr;
        JSONObject jSONObject = new JSONObject();
        try {
            dVarArr = this.fields;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (dVarArr.length > 0) {
            dVarArr[0].a();
            throw null;
        }
        return jSONObject;
    }

    public String toString() {
        d[] dVarArr = this.fields;
        if (dVarArr.length != 2) {
            String jSONObject = c().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toJSON().toString()");
            return jSONObject;
        }
        dVarArr[0].a();
        throw null;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public int a() {
        try {
            d[] dVarArr = this.fields;
            if (dVarArr.length <= 0) {
                return 0;
            }
            dVarArr[0].a();
            throw null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public b a(byte[] data) {
        if (data == null) {
            return null;
        }
        this.f126262b = data;
        com.tencent.luggage.wxa.hr.a aVar = new com.tencent.luggage.wxa.hr.a(data, b.f126260c);
        for (int a16 = b.a(aVar); a16 > 0; a16 = b.a(aVar)) {
            if (!a(aVar, this, a16)) {
                aVar.b();
            }
        }
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public boolean a(com.tencent.luggage.wxa.hr.a reader, b builder, int fieldNumber) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(builder, "builder");
        d[] dVarArr = this.fields;
        if (dVarArr.length <= 0) {
            this.f126261a = true;
            return false;
        }
        dVarArr[0].a();
        throw null;
    }
}

package com.tencent.luggage.wxa.yf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class x extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 880;

    @NotNull
    public static final String NAME = "setNavigateBackInterception";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145761a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i3) {
            if (i3 == 1) {
                return "scene_swipe_back";
            }
            if (i3 == 2) {
                return "scene_back_key_pressed";
            }
            if (i3 == 3) {
                return "scene_actionbar_back";
            }
            if (i3 == 4) {
                return "scene_jsapi_navigate_back";
            }
            throw new IllegalArgumentException("illegal type!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f145762a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145763b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f145764c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f145765d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f145766e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ x f145767f;

        public b(com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.ic.l lVar, Ref.BooleanRef booleanRef, ArrayList arrayList, int i3, x xVar) {
            this.f145762a = nVar;
            this.f145763b = lVar;
            this.f145764c = booleanRef;
            this.f145765d = arrayList;
            this.f145766e = i3;
            this.f145767f = xVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            String str2;
            com.tencent.luggage.wxa.kj.n nVar = this.f145762a;
            com.tencent.luggage.wxa.nj.g gVar = null;
            if (nVar != null) {
                str = nVar.getCurrentUrl();
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.kj.n currentPage = this.f145763b.getRuntime().Y().getCurrentPage();
            if (currentPage != null) {
                str2 = currentPage.getCurrentUrl();
            } else {
                str2 = null;
            }
            if (!TextUtils.equals(str, str2)) {
                return;
            }
            com.tencent.luggage.wxa.kj.n currentPage2 = this.f145763b.getRuntime().Y().getCurrentPage();
            if (currentPage2 != null) {
                com.tencent.luggage.wxa.nj.i iVar = com.tencent.luggage.wxa.nj.i.SILENT;
                if (this.f145764c.element) {
                    gVar = new com.tencent.luggage.wxa.nj.g(null, this.f145765d, 1, null);
                }
                currentPage2.a(iVar, gVar);
            }
            this.f145763b.a(this.f145766e, this.f145767f.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    public final boolean a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        IntRange until;
        if (lVar == null || jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scopes");
        if (a(optJSONArray)) {
            lVar.a(i3, makeReturnJson("fail:scopes is empty"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        until = RangesKt___RangesKt.until(0, optJSONArray.length());
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            Object obj = optJSONArray.get(((IntIterator) it).nextInt());
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject2 = (JSONObject) obj;
            boolean optBoolean = jSONObject2.optBoolean("interception", false);
            booleanRef.element |= optBoolean;
            try {
                arrayList.add(new com.tencent.luggage.wxa.nj.h(optBoolean, f145761a.a(jSONObject2.optInt("type", 0))));
            } catch (IllegalArgumentException unused) {
                lVar.a(i3, makeReturnJson("fail:illegal type"));
                return;
            }
        }
        lVar.a(new b(lVar.getRuntime().Y().getCurrentPage(), lVar, booleanRef, arrayList, i3, this));
    }
}

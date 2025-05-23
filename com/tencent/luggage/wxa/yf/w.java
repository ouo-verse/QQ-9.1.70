package com.tencent.luggage.wxa.yf;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class w extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 772;

    @NotNull
    public static final String NAME = "setNavigateBackConfirmDialog";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145754a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145755a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.n f145756b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f145757c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f145758d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ w f145759e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f145760f;

        public b(com.tencent.luggage.wxa.ic.l lVar, com.tencent.luggage.wxa.kj.n nVar, boolean z16, int i3, w wVar, Ref.ObjectRef objectRef) {
            this.f145755a = lVar;
            this.f145756b = nVar;
            this.f145757c = z16;
            this.f145758d = i3;
            this.f145759e = wVar;
            this.f145760f = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            String str;
            String str2;
            ArrayList arrayList;
            List listOf;
            if (this.f145755a.getRuntime().Y() == null) {
                com.tencent.luggage.wxa.tn.w.f("JsApiSetNavigateBackConfirmDialog", "pageContainer is null, return");
                return;
            }
            com.tencent.luggage.wxa.kj.n nVar = this.f145756b;
            com.tencent.luggage.wxa.nj.g gVar = null;
            if (nVar != null) {
                str = nVar.getCurrentUrl();
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.kj.n currentPage = this.f145755a.getRuntime().Y().getCurrentPage();
            if (currentPage != null) {
                str2 = currentPage.getCurrentUrl();
            } else {
                str2 = null;
            }
            if (!TextUtils.equals(str, str2)) {
                return;
            }
            if (this.f145757c) {
                arrayList = new ArrayList();
                boolean z16 = this.f145757c;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"scene_actionbar_back", "scene_back_key_pressed", "scene_jsapi_navigate_back"});
                Iterator it = listOf.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.tencent.luggage.wxa.nj.h(z16, (String) it.next()));
                }
            } else {
                arrayList = null;
            }
            com.tencent.luggage.wxa.ic.l lVar = this.f145755a;
            Ref.ObjectRef objectRef = this.f145760f;
            com.tencent.luggage.wxa.kj.n currentPage2 = lVar.getRuntime().Y().getCurrentPage();
            if (currentPage2 != null) {
                com.tencent.luggage.wxa.nj.i iVar = com.tencent.luggage.wxa.nj.i.WITH_CONFIRM_DIALOG;
                if (arrayList != null) {
                    T content = objectRef.element;
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    gVar = new com.tencent.luggage.wxa.nj.g((String) content, arrayList);
                }
                currentPage2.a(iVar, gVar);
            }
            this.f145755a.a(this.f145758d, this.f145759e.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [T, java.lang.String] */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        if (lVar != null && jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("enable", false);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = jSONObject.optString("content");
            com.tencent.luggage.wxa.tn.w.d("JsApiSetNavigateBackConfirmDialog", "[invoke] enable=" + optBoolean + "  content=" + ((String) objectRef.element));
            if (w0.c((String) objectRef.element)) {
                objectRef.element = lVar.getContext().getResources().getString(R.string.f1640224p);
            }
            lVar.a(new b(lVar, lVar.getRuntime().Y().getCurrentPage(), optBoolean, i3, this, objectRef));
        }
    }
}

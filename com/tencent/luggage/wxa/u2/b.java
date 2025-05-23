package com.tencent.luggage.wxa.u2;

import android.content.Context;
import android.content.Intent;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.f6.h;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 30;

    @NotNull
    public static final String NAME = "previewImage";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142091a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.u2.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6782a {

            /* renamed from: a, reason: collision with root package name */
            public final String[] f142092a;

            /* renamed from: b, reason: collision with root package name */
            public final int f142093b;

            /* renamed from: c, reason: collision with root package name */
            public final String[] f142094c;

            public C6782a(String[] urls, int i3, String[] diff) {
                Intrinsics.checkNotNullParameter(urls, "urls");
                Intrinsics.checkNotNullParameter(diff, "diff");
                this.f142092a = urls;
                this.f142093b = i3;
                this.f142094c = diff;
            }

            public final int a() {
                return this.f142093b;
            }

            public final String[] b() {
                return this.f142094c;
            }

            public final String[] c() {
                return this.f142092a;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u2.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6783b implements LuggageActivityHelper.d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a.C6782a f142096b;

        public C6783b(a.C6782a c6782a) {
            this.f142096b = c6782a;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            w.d("Luggage.JsApiPreviewImage", "previewImage ok: " + i3);
            b.this.a(this.f142096b);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (jSONObject == null) {
            env.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        a.C6782a a16 = a(env, jSONObject);
        if (a16 == null) {
            env.a(i3, makeReturnJson("fail:invalid data"));
        } else {
            a(env, a16, i3);
        }
    }

    public final a.C6782a a(l env, JSONObject data) {
        int i3;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONArray optJSONArray = data.optJSONArray(CoverDBCacheData.URLS);
        if (optJSONArray == null) {
            return null;
        }
        int length = optJSONArray.length();
        String[] strArr = new String[length];
        int length2 = optJSONArray.length();
        for (int i16 = 0; i16 < length2; i16++) {
            strArr[i16] = optJSONArray.optString(i16);
        }
        Object opt = data.opt("current");
        if (opt instanceof Integer) {
            i3 = ((Number) opt).intValue();
        } else if (opt instanceof String) {
            int i17 = 0;
            for (int i18 = 0; i18 < length; i18++) {
                String str = strArr[i18];
                if (Intrinsics.areEqual(opt, str)) {
                    i17 = ArraysKt___ArraysKt.indexOf(strArr, str);
                }
            }
            i3 = i17;
        } else {
            i3 = 0;
        }
        for (int i19 = 0; i19 < length; i19++) {
            r fileSystem = env.getFileSystem();
            v absoluteFile = fileSystem != null ? fileSystem.getAbsoluteFile(strArr[i19]) : null;
            if (absoluteFile == null) {
                r fileSystem2 = env.getFileSystem();
                absoluteFile = fileSystem2 != null ? fileSystem2.getPrivateAbsoluteFile(strArr[i19]) : null;
            }
            if (absoluteFile != null) {
                strArr[i19] = absoluteFile.g();
            }
        }
        String[] converted = com.tencent.luggage.wxa.gh.a.a(strArr);
        String[] diff = com.tencent.luggage.wxa.gh.a.a(converted, strArr);
        Intrinsics.checkNotNullExpressionValue(converted, "converted");
        int i26 = i3 < converted.length ? i3 : 0;
        Intrinsics.checkNotNullExpressionValue(diff, "diff");
        return new a.C6782a(converted, i26, diff);
    }

    public final void a(l env, a.C6782a previewData, int i3) {
        List listOf;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(previewData, "previewData");
        h.Companion companion = h.INSTANCE;
        Context context = env.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "env.context");
        String[] c16 = previewData.c();
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(c16, c16.length));
        companion.a(context, new ArrayList(listOf), previewData.a(), new C6783b(previewData));
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }

    public final void a(a.C6782a previewData) {
        Intrinsics.checkNotNullParameter(previewData, "previewData");
        com.tencent.luggage.wxa.gh.a.b(previewData.b());
    }
}

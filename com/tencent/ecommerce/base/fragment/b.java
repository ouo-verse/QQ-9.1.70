package com.tencent.ecommerce.base.fragment;

import android.os.Bundle;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpanStatus;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import mqq.app.Constants;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/b;", "", "", "a", "b", "Landroid/os/Bundle;", "argument", "k", Constants.FILE_INSTANCE_STATE, "l", "i", "g", "f", "j", "outState", h.F, "d", "e", "c", "", "Ljava/lang/String;", "TAG", "fragmentTag", "businessDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String fragmentTag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String businessDesc;

    public b(String str, String str2) {
        this.fragmentTag = str;
        this.businessDesc = str2;
        this.TAG = "LifecycleLogger.Fragment." + str;
    }

    public final void a() {
        cg0.a.b(this.TAG, "onAttach");
    }

    public final void b() {
        cg0.a.b(this.TAG, "onCreate");
        d dVar = d.f100713c;
        dVar.f(this.businessDesc, this.fragmentTag, dVar.d());
    }

    public final void c() {
        Map<String, String> emptyMap;
        cg0.a.b(this.TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        d dVar = d.f100713c;
        String str = this.businessDesc;
        emptyMap = MapsKt__MapsKt.emptyMap();
        dVar.a(str, MosaicConstants$JsFunction.FUNC_ON_DESTROY, emptyMap);
        String str2 = this.businessDesc;
        hg0.c d16 = dVar.d();
        dVar.c(str2, d16 != null ? d16.getParentSpan() : null, IECSpanStatus.ECSpanStatusOK.ordinal());
    }

    public final void d() {
        Map<String, String> emptyMap;
        cg0.a.b(this.TAG, "onDestroyView");
        d dVar = d.f100713c;
        String str = this.businessDesc;
        emptyMap = MapsKt__MapsKt.emptyMap();
        dVar.a(str, "onDestroyView", emptyMap);
    }

    public final void e() {
        cg0.a.b(this.TAG, "onDetach");
    }

    public final void f() {
        Map<String, String> emptyMap;
        cg0.a.b(this.TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        d dVar = d.f100713c;
        String str = this.businessDesc;
        emptyMap = MapsKt__MapsKt.emptyMap();
        dVar.a(str, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, emptyMap);
    }

    public final void g() {
        Map<String, String> emptyMap;
        cg0.a.b(this.TAG, "onResume");
        d dVar = d.f100713c;
        String str = this.businessDesc;
        emptyMap = MapsKt__MapsKt.emptyMap();
        dVar.a(str, "onResume", emptyMap);
    }

    public final void h(Bundle outState) {
        cg0.a.b(this.TAG, "onSaveInstanceState outState = " + outState);
    }

    public final void i() {
        cg0.a.b(this.TAG, "onStart");
    }

    public final void j() {
        cg0.a.b(this.TAG, DKHippyEvent.EVENT_STOP);
    }

    public final void k(Bundle argument) {
        Map<String, String> mapOf;
        cg0.a.b(this.TAG, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        JSONObject jSONObject = new JSONObject();
        if (argument != null) {
            for (String str : argument.keySet()) {
                jSONObject.put(str, String.valueOf(argument.get(str)));
            }
        }
        d dVar = d.f100713c;
        String str2 = this.businessDesc;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("page.argument", jSONObject.toString()));
        dVar.a(str2, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, mapOf);
    }

    public final void l(Bundle savedInstanceState) {
        cg0.a.b(this.TAG, "onViewStateRestored savedInstanceState = " + savedInstanceState);
    }
}

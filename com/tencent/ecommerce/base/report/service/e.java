package com.tencent.ecommerce.base.report.service;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u000e\b&\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB\u0013\b\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010*J\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003R\"\u0010\u0015\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R.\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001f\u001a\u0004\b\u001e\u0010!\"\u0004\b%\u0010#R\u0016\u0010(\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/e;", "T", "", "", "id", tl.h.F, "(Ljava/lang/String;)Ljava/lang/Object;", "g", "()Ljava/lang/Object;", "key", "value", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "eventId", "", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setTargetId", "(Ljava/lang/String;)V", "targetId", "", "b", "Z", "()Z", "setDataReady", "(Z)V", IECDtReport.ACTION_DATA_READY, "", "c", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setExtParams", "(Ljava/util/Map;)V", "extParams", "setExtAction", "extAction", "Ljava/lang/Object;", "target", "<init>", "(Ljava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class e<T> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String targetId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean dataReady = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Map<String, String> extParams = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> extAction = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object target;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/e$a;", "", "Landroid/view/View;", "target", "Lcom/tencent/ecommerce/base/report/service/f;", "d", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/ecommerce/base/report/service/d;", "c", "Landroid/app/Activity;", "b", "Lcom/tencent/ecommerce/base/report/service/c;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.report.service.e$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        public final c a() {
            return new c();
        }

        public final d b(Activity target) {
            return new d(target);
        }

        public final d c(Fragment target) {
            return new d(target);
        }

        public final f d(View target) {
            return new f(target);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Object obj) {
        this.target = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T a(String key, String value) {
        this.extParams.put(key, value);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: from getter */
    public final boolean getDataReady() {
        return this.dataReady;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, Object> c() {
        return this.extAction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, String> d() {
        return this.extParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final String getTargetId() {
        return this.targetId;
    }

    public final void f(String eventId) {
        b.f100913b.reportCustomDtEvent(this.target, eventId, this.extParams, this.extAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T g() {
        this.extAction.put(IECDtReport.ACTION_MULTI_SCENE, IECDtReport.INSTANCE.d());
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T h(String id5) {
        this.targetId = id5;
        return this;
    }
}

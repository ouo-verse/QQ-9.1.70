package com.tencent.mobileqq.zplan.web.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.f;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/api/impl/a;", "Lcom/tencent/mobileqq/webview/swift/f;", "Landroid/content/Intent;", "intent", "", "url", ZPlanPublishSource.FROM_SCHEME, "", "providePreCreatePlugins", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "", "onPreInit", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements f {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
    
        if (r5 != false) goto L6;
     */
    @Override // com.tencent.mobileqq.webview.swift.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] providePreCreatePlugins(Intent intent, String url, String scheme) {
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(url, "url");
        ArrayList arrayList = new ArrayList();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) IZPlanWebDataHandler.KEY_APOLLO_CLIENT, false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "https://zplan.qq.com/qq_zplan_record_avatar/", false, 2, (Object) null);
        }
        arrayList.add("zplan");
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @Override // com.tencent.mobileqq.webview.swift.c
    public void onPreInit() {
    }
}

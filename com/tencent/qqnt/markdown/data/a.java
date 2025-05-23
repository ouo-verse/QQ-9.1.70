package com.tencent.qqnt.markdown.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b`\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004R3\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b`\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/markdown/data/a;", "", "Lcom/tencent/android/androidbypass/viewgroup/c;", "extData", "Lcom/tencent/qqnt/markdown/data/d;", "options", "", "b", "Lcom/tencent/qqnt/markdown/data/b;", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "dataMap", "<init>", "(Ljava/util/HashMap;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, b> dataMap;

    public a(@NotNull HashMap<String, b> dataMap) {
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataMap);
        } else {
            this.dataMap = dataMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b a(@NotNull com.tencent.android.androidbypass.viewgroup.c extData) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) extData);
        }
        Intrinsics.checkNotNullParameter(extData, "extData");
        String d16 = extData.d();
        if (this.dataMap.containsKey(d16)) {
            b bVar2 = this.dataMap.get(d16);
            Intrinsics.checkNotNull(bVar2);
            bVar = bVar2;
        } else {
            b bVar3 = new b();
            bVar3.l(d16);
            bVar3.m(extData.e());
            this.dataMap.put(d16, bVar3);
            bVar = bVar3;
        }
        Intrinsics.checkNotNullExpressionValue(bVar, "if (dataMap.containsKey(\u2026           data\n        }");
        bVar.i(extData.c());
        return bVar;
    }

    public abstract void b(@NotNull com.tencent.android.androidbypass.viewgroup.c extData, @NotNull d options);
}

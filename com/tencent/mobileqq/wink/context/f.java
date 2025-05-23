package com.tencent.mobileqq.wink.context;

import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/context/f;", "", "Landroid/content/Intent;", "intent", "", "a", "", "", "b", "Ljava/util/Map;", "compactFirstPageMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f318044a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> compactFirstPageMap;

    static {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("4", "com.tencent.mobileqq.wink.publish.fs.activity.FSUploadActivityFragment"), TuplesKt.to("3", "com.tencent.mobileqq.wink.editor.WinkEditorFragment"));
        compactFirstPageMap = mapOf;
    }

    f() {
    }

    public final boolean a(@Nullable Intent intent) {
        Uri uri;
        String str = null;
        if (intent != null) {
            uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        } else {
            uri = null;
        }
        QLog.i("FirstPageIdentifier", 1, "[identifyFirstPage] uri=" + uri);
        if (uri != null) {
            str = uri.toString();
        }
        return !Intrinsics.areEqual(str, "wink://activity");
    }
}

package com.tencent.mobileqq.guild.webview;

import android.content.Intent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/f;", "Lcom/tencent/mobileqq/webview/swift/f;", "Landroid/content/Intent;", "intent", "", "url", ZPlanPublishSource.FROM_SCHEME, "", "providePreCreatePlugins", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "", "onPreInit", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f implements com.tencent.mobileqq.webview.swift.f {
    @Override // com.tencent.mobileqq.webview.swift.c
    public void onPreInit() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.jump.JS.QQGuildJsPlugin", 2, "checker onPreInit");
        }
        ch.E().a(101);
    }

    @Override // com.tencent.mobileqq.webview.swift.f
    @NotNull
    public String[] providePreCreatePlugins(@NotNull Intent intent, @NotNull String url, @Nullable String scheme) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(url, "url");
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mobileqq.guild.share.shorturl.a.m(url)) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.jump.JS.QQGuildJsPlugin", 2, "isNeedPreCreatePlugin-> ", url, " schema: ", scheme, " isGuildUrl:", Boolean.TRUE);
            }
            arrayList.add("guild");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }
}

package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentAppSetting;", "", "()V", "isPublicVersion", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentAppSetting {

    @NotNull
    public static final FilamentAppSetting INSTANCE = new FilamentAppSetting();

    FilamentAppSetting() {
    }

    @JvmStatic
    @NativeMethodProxy
    public static final boolean isPublicVersion() {
        dl0.a aVar = (dl0.a) fl0.a.f399763a.a(dl0.a.class);
        if (aVar != null) {
            return aVar.isPublicVersion();
        }
        return true;
    }
}

package com.tencent.zplan.device.config;

import android.content.Context;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.photoplus.sticker.Sticker;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/device/config/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/zplan/device/config/DeviceLevel;", "b", "a", "Lcom/tencent/zplan/device/config/DeviceLevel;", "_deviceLevel", "()Lcom/tencent/zplan/device/config/DeviceLevel;", "deviceLevel", "<init>", "()V", "zplan-device-config_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f385299b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static DeviceLevel _deviceLevel = DeviceLevel.UNKNOWN;

    a() {
    }

    @NotNull
    public final DeviceLevel a() {
        return _deviceLevel;
    }

    @NotNull
    public final DeviceLevel b(@NotNull Context context) {
        Character firstOrNull;
        String valueOf;
        boolean z16;
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(context, "context");
        String model = DeviceInfoMonitor.getModel();
        if (model != null) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
            String lowerCase = model.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            firstOrNull = StringsKt___StringsKt.firstOrNull(lowerCase);
            if (firstOrNull != null && (valueOf = String.valueOf(firstOrNull.charValue())) != null) {
                String str = valueOf + Sticker.JSON_SUFFIX;
                try {
                    String[] list = context.getAssets().list("zplan_device_config");
                    if (list != null) {
                        z16 = ArraysKt___ArraysKt.contains(list, str);
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        InputStream inputStream = context.getAssets().open("zplan_device_config/" + str);
                        try {
                            Intrinsics.checkNotNullExpressionValue(inputStream, "inputStream");
                            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                            if (inputStreamReader instanceof BufferedReader) {
                                bufferedReader = (BufferedReader) inputStreamReader;
                            } else {
                                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                            }
                            try {
                                String readText = TextStreamsKt.readText(bufferedReader);
                                CloseableKt.closeFinally(bufferedReader, null);
                                DeviceLevel a16 = DeviceLevel.INSTANCE.a(new JSONObject(readText).optInt(model, DeviceLevel.UNKNOWN.getLevel()));
                                CloseableKt.closeFinally(inputStream, null);
                                return a16;
                            } finally {
                            }
                        } finally {
                        }
                    } else {
                        return DeviceLevel.UNKNOWN;
                    }
                } catch (Exception unused) {
                    return DeviceLevel.UNKNOWN;
                }
            } else {
                return DeviceLevel.UNKNOWN;
            }
        } else {
            return DeviceLevel.UNKNOWN;
        }
    }
}

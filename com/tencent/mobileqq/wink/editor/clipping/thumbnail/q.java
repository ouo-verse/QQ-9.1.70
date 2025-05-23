package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/q;", "", "", "path", "", "b", "", "", "c", "paramString", "a", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "useCoverPath", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f319269a = new q();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> useCoverPath = new ConcurrentHashMap<>();

    q() {
    }

    private final Map<String, int[]> a(String paramString) {
        boolean z16;
        List list;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(paramString)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(paramString);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                int[] e16 = fx4.b.e(jSONObject.optJSONArray(key));
                if (e16.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    list = ArraysKt___ArraysKt.toList(e16);
                    w53.b.f("VideoThumbProviderManager", "convertJsonToMap key = " + key + ", value = " + list);
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, e16);
                }
            }
        } catch (JSONException e17) {
            w53.b.d("VideoThumbProviderManager", "convertJsonToMap with exception !", e17);
        }
        return hashMap;
    }

    private final byte[] b(String path) {
        boolean startsWith$default;
        byte[] copyOfRange;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(path);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i3 = 0; i3 < trackCount; i3++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                Intrinsics.checkNotNullExpressionValue(trackFormat, "mediaExtractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                if (string == null) {
                    string = "";
                }
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null);
                if (startsWith$default) {
                    byte[] bArr = new byte[100];
                    ByteBuffer byteBuffer = trackFormat.getByteBuffer("csd-0");
                    if (byteBuffer == null) {
                        return new byte[0];
                    }
                    int limit = byteBuffer.limit();
                    byteBuffer.get(bArr, 0, limit);
                    w53.b.f("VideoThumbProviderManager", "getSpsData limit = " + limit + ",  csd-0:" + bArr);
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr, 0, limit);
                    return copyOfRange;
                }
            }
            mediaExtractor.release();
            return new byte[0];
        } catch (Exception e16) {
            w53.b.d("VideoThumbProviderManager", "getSpsData = " + path, e16);
            return new byte[0];
        } finally {
            mediaExtractor.release();
        }
    }

    private final Map<String, int[]> c() {
        String config = QzoneConfig.getWinkThumbSpsConfig();
        Intrinsics.checkNotNullExpressionValue(config, "config");
        return a(config);
    }

    public final boolean d(@NotNull String path) {
        boolean z16;
        boolean z17;
        boolean contains;
        Intrinsics.checkNotNullParameter(path, "path");
        if (path.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = useCoverPath;
        if (concurrentHashMap.containsKey(path)) {
            Boolean bool = concurrentHashMap.get(path);
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        try {
            byte[] b16 = b(path);
            if (b16.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                concurrentHashMap.put(path, Boolean.FALSE);
                return false;
            }
            Map<String, Integer> c16 = b.c(b16);
            Map<String, int[]> c17 = c();
            w53.b.f("VideoThumbProviderManager", "isUnSupportFile map = " + c16);
            for (Map.Entry<String, int[]> entry : c17.entrySet()) {
                Integer num = c16.get(entry.getKey());
                if (num != null) {
                    contains = ArraysKt___ArraysKt.contains(entry.getValue(), num.intValue());
                    if (!contains) {
                    }
                }
                useCoverPath.put(path, Boolean.FALSE);
                return false;
            }
            useCoverPath.put(path, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            useCoverPath.put(path, Boolean.FALSE);
            return false;
        }
    }
}

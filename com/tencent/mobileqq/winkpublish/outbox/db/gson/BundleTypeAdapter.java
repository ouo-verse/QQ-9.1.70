package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\b\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003H\u0002J$\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/BundleTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/os/Bundle;", "", "Lkotlin/Pair;", "", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "f", "Lcom/google/gson/stream/JsonReader;", "reader", "d", "e", "c", "b", "Lcom/google/gson/stream/JsonWriter;", "writer", "bundle", "", "g", "a", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class BundleTypeAdapter extends TypeAdapter<Bundle> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Gson gson;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327255a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            try {
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonToken.NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[JsonToken.STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f327255a = iArr;
        }
    }

    public BundleTypeAdapter(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.gson = gson;
    }

    private final List<Object> b(JsonReader reader) {
        ArrayList arrayList = new ArrayList();
        reader.beginArray();
        while (reader.peek() != JsonToken.END_ARRAY) {
            arrayList.add(e(reader));
        }
        reader.endArray();
        return arrayList;
    }

    private final Object c(JsonReader reader) {
        double nextDouble = reader.nextDouble();
        if (((long) (nextDouble - Math.ceil(nextDouble))) != 0) {
            return Double.valueOf(nextDouble);
        }
        long j3 = (long) nextDouble;
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            return Integer.valueOf((int) j3);
        }
        return Long.valueOf(j3);
    }

    private final List<Pair<String, Object>> d(JsonReader reader) {
        ArrayList arrayList = new ArrayList();
        reader.beginObject();
        while (true) {
            if (reader.peek() == JsonToken.END_OBJECT) {
                break;
            }
            JsonToken peek = reader.peek();
            int i3 = peek == null ? -1 : a.f327255a[peek.ordinal()];
            if (i3 == 2) {
                arrayList.add(new Pair(reader.nextName(), e(reader)));
            } else if (i3 != 3) {
                throw new IOException("expecting object: " + reader.getPath());
            }
        }
        reader.endObject();
        return arrayList;
    }

    private final Object e(JsonReader reader) {
        JsonToken peek = reader.peek();
        int i3 = peek == null ? -1 : a.f327255a[peek.ordinal()];
        if (i3 != 1) {
            switch (i3) {
                case 4:
                    return b(reader);
                case 5:
                    return Boolean.valueOf(reader.nextBoolean());
                case 6:
                    reader.nextNull();
                    return null;
                case 7:
                    return c(reader);
                case 8:
                    return reader.nextString();
                default:
                    throw new IOException("expecting value: " + reader.getPath());
            }
        }
        return d(reader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Bundle f(List<? extends Pair<String, ? extends Object>> elements) {
        Bundle bundle = new Bundle();
        Iterator<? extends Pair<String, ? extends Object>> it = elements.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.getFirst();
            Object second = pair.getSecond();
            if (second instanceof String) {
                bundle.putString(str, (String) second);
            } else if (second instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) second).booleanValue());
            } else if (second instanceof Integer) {
                bundle.putInt(str, ((Number) second).intValue());
            } else if (second instanceof Long) {
                bundle.putLong(str, ((Number) second).longValue());
            } else if (second instanceof Double) {
                bundle.putDouble(str, ((Number) second).doubleValue());
            } else if (second instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) second);
            } else if (second instanceof List) {
                Intrinsics.checkNotNull(pair, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Pair<kotlin.String, kotlin.Any?>>");
                bundle.putParcelable(str, f((List) pair));
            } else {
                throw new IOException("unsupported type, key=" + str + ", value=" + second);
            }
        }
        return bundle;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bundle read2(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        JsonToken peek = reader.peek();
        int i3 = peek == null ? -1 : a.f327255a[peek.ordinal()];
        if (i3 == -1) {
            reader.nextNull();
            return null;
        }
        if (i3 == 1) {
            return f(d(reader));
        }
        throw new IOException("expecting object: " + reader.getPath());
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter writer, Bundle bundle) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (bundle == null) {
            writer.nullValue();
            return;
        }
        writer.beginObject();
        for (String str : bundle.keySet()) {
            writer.name(str);
            Object obj = bundle.get(str);
            if (obj == null) {
                writer.nullValue();
            } else {
                this.gson.toJson(obj, obj.getClass(), writer);
            }
        }
        writer.endObject();
    }
}

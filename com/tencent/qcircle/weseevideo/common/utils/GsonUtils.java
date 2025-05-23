package com.tencent.qcircle.weseevideo.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.tencent.qcircle.tavcut.util.Logger;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GsonUtils {
    private static Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().serializeNulls().create();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ProxyJsonReader extends JsonReader {
        private static final String TAG = "ProxyJsonReader";

        public ProxyJsonReader(Reader reader) {
            super(reader);
        }

        @Override // com.google.gson.stream.JsonReader
        public boolean nextBoolean() {
            try {
                return super.nextBoolean();
            } catch (Exception e16) {
                Logger.e(TAG, "nextBoolean", e16);
                return false;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public double nextDouble() {
            try {
                return super.nextDouble();
            } catch (Exception e16) {
                Logger.e(TAG, "nextDouble", e16);
                return 0.0d;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public int nextInt() {
            try {
                return super.nextInt();
            } catch (Exception e16) {
                Logger.e(TAG, "nextInt", e16);
                return 0;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public long nextLong() {
            try {
                return super.nextLong();
            } catch (Exception e16) {
                Logger.e(TAG, "nextLong", e16);
                return 0L;
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public String nextName() {
            try {
                return super.nextName();
            } catch (Exception e16) {
                Logger.e(TAG, "nextName", e16);
                return "";
            }
        }

        @Override // com.google.gson.stream.JsonReader
        public String nextString() {
            try {
                return super.nextString();
            } catch (Exception e16) {
                Logger.e(TAG, "nextString", e16);
                return "";
            }
        }
    }

    public static <T> T json2Obj(String str, Type type) {
        try {
            ProxyJsonReader proxyJsonReader = new ProxyJsonReader(new StringReader(str));
            proxyJsonReader.setLenient(false);
            return (T) gson.fromJson(proxyJsonReader, type);
        } catch (Exception e16) {
            Logger.e(e16);
            return null;
        }
    }

    public static <T> List<T> json2ObjList(String str, Type type) {
        ArrayList arrayList = null;
        try {
            JsonArray asJsonArray = new JsonParser().parse(str).getAsJsonArray();
            ArrayList arrayList2 = new ArrayList();
            try {
                int size = asJsonArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList2.add(gson.fromJson(asJsonArray.get(i3), type));
                }
                return arrayList2;
            } catch (Exception e16) {
                e = e16;
                arrayList = arrayList2;
                Logger.e(e);
                return arrayList;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static <T> String obj2Json(T t16) {
        try {
            return gson.toJson(t16);
        } catch (Exception e16) {
            Logger.e(e16);
            return null;
        }
    }

    public static <T> String objList2Json(List<T> list) {
        try {
            return gson.toJson(list);
        } catch (Exception e16) {
            Logger.e(e16);
            return null;
        }
    }
}

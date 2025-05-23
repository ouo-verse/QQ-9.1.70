package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import android.graphics.PointF;
import android.util.Log;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes6.dex */
public class PointFAdapter extends TypeAdapter<PointF> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public PointF read2(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            if (peek != JsonToken.BEGIN_ARRAY) {
                return null;
            }
            jsonReader.beginArray();
            PointF pointF = new PointF();
            pointF.x = (float) jsonReader.nextDouble();
            pointF.y = (float) jsonReader.nextDouble();
            jsonReader.endArray();
            Log.d("gson", "PointF x=" + pointF.x + " y=" + pointF.y);
            return pointF;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PointF pointF) throws IOException {
        if (pointF == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        jsonWriter.value(pointF.x);
        jsonWriter.value(pointF.y);
        jsonWriter.endArray();
    }
}

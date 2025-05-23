package com.tencent.gdtad.json;

import android.text.TextUtils;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtJsonXmlUtil {
    private static final String TAG = "GdtJsonXmlUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class XmlData {
        String name;
        Object value;

        XmlData() {
        }

        private Object getJSONValue() {
            try {
                Object obj = this.value;
                if (obj == null) {
                    return JSONObject.NULL;
                }
                Object obj2 = JSONObject.NULL;
                if (!obj2.equals(obj)) {
                    Object obj3 = this.value;
                    if (!(obj3 instanceof String)) {
                        if (obj3 instanceof List) {
                            JSONObject jSONObject = new JSONObject();
                            for (XmlData xmlData : (List) obj3) {
                                if (TextUtils.isEmpty(xmlData.name)) {
                                    GdtLog.e(GdtJsonXmlUtil.TAG, "getJSONValue error");
                                } else {
                                    jSONObject.put(xmlData.name, xmlData.getJSONValue());
                                }
                            }
                            if (jSONObject.length() <= 0) {
                                return JSONObject.NULL;
                            }
                            return jSONObject;
                        }
                        GdtLog.e(GdtJsonXmlUtil.TAG, "toJsonObject error");
                        return obj2;
                    }
                }
                return this.value;
            } catch (JSONException e16) {
                GdtLog.e(GdtJsonXmlUtil.TAG, "toJsonObject", e16);
                return JSONObject.NULL;
            }
        }

        @NonNull
        Object toJSONObject() {
            if (TextUtils.isEmpty(this.name)) {
                GdtLog.e(GdtJsonXmlUtil.TAG, "toJsonObject error");
                return JSONObject.NULL;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(this.name, getJSONValue());
                return jSONObject;
            } catch (JSONException e16) {
                GdtLog.e(GdtJsonXmlUtil.TAG, "toJSONObject", e16);
                return JSONObject.NULL;
            }
        }
    }

    @Nullable
    private static XmlData parseTag(@NonNull XmlPullParser xmlPullParser) {
        try {
            if (xmlPullParser.getEventType() != 2) {
                GdtLog.e(TAG, "parseTag error");
                return null;
            }
            XmlData xmlData = new XmlData();
            String name = xmlPullParser.getName();
            xmlData.name = name;
            if (TextUtils.isEmpty(name)) {
                GdtLog.e(TAG, "parseTag error");
                return null;
            }
            skip(xmlPullParser);
            if (xmlPullParser.getEventType() == 3) {
                skip(xmlPullParser);
                return xmlData;
            }
            if (xmlPullParser.getEventType() == 2) {
                ArrayList arrayList = new ArrayList();
                xmlData.value = arrayList;
                while (xmlPullParser.getEventType() == 2) {
                    XmlData parseTag = parseTag(xmlPullParser);
                    if (parseTag != null) {
                        arrayList.add(parseTag);
                    }
                }
            } else if (xmlPullParser.getEventType() == 4) {
                xmlData.value = xmlPullParser.getText();
                skip(xmlPullParser);
            } else {
                GdtLog.e(TAG, "parseTag error");
                return null;
            }
            if (xmlPullParser.getEventType() == 3) {
                skip(xmlPullParser);
                return xmlData;
            }
            GdtLog.e(TAG, "parseTag error");
            return null;
        } catch (XmlPullParserException e16) {
            GdtLog.e(TAG, "parseTag", e16);
            return null;
        }
    }

    @Nullable
    private static XmlData parserDocument(@NonNull XmlPullParser xmlPullParser) {
        try {
            if (xmlPullParser.getEventType() != 0) {
                GdtLog.e(TAG, "parserDocument error");
                return null;
            }
            skip(xmlPullParser);
            if (xmlPullParser.getEventType() == 1) {
                return null;
            }
            if (xmlPullParser.getEventType() == 2) {
                XmlData parseTag = parseTag(xmlPullParser);
                if (xmlPullParser.getEventType() == 1) {
                    return parseTag;
                }
                GdtLog.e(TAG, "parserDocument error");
                return null;
            }
            GdtLog.e(TAG, "parserDocument error");
            return null;
        } catch (XmlPullParserException e16) {
            GdtLog.e(TAG, "parserDocument", e16);
            return null;
        }
    }

    private static void skip(@NonNull XmlPullParser xmlPullParser) {
        while (xmlPullParser.next() == 4) {
            try {
                String text = xmlPullParser.getText();
                if (TextUtils.isEmpty(text) || !text.matches("\\s+")) {
                    return;
                }
            } catch (IOException e16) {
                GdtLog.e(TAG, "skip", e16);
                return;
            } catch (XmlPullParserException e17) {
                GdtLog.e(TAG, "skip", e17);
                return;
            }
        }
    }

    @Nullable
    public static JSONObject toJSONObject(@NonNull String str) {
        Object jSONObject;
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), null);
            XmlData parserDocument = parserDocument(newPullParser);
            if (parserDocument != null && (jSONObject = parserDocument.toJSONObject()) != null && !JSONObject.NULL.equals(jSONObject) && (jSONObject instanceof JSONObject)) {
                return (JSONObject) JSONObject.class.cast(jSONObject);
            }
            GdtLog.e(TAG, "toJSONObject error");
            return null;
        } catch (XmlPullParserException e16) {
            GdtLog.e(TAG, "toJSONObject", e16);
            return null;
        }
    }
}

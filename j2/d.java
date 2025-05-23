package j2;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {
    public static void a(XmlSerializer xmlSerializer, String str, String str2) {
        if (str2 != null && xmlSerializer != null && str != null) {
            xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
        }
    }
}

package com.tencent.mobileqq.ark;

import com.heytap.databaseengine.utils.DateUtil;
import java.text.SimpleDateFormat;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f199503a = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);

    /* renamed from: b, reason: collision with root package name */
    public static int f199504b = 5;

    /* renamed from: c, reason: collision with root package name */
    public static int f199505c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static int f199506d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static int f199507e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static int f199508f = 10;

    /* renamed from: g, reason: collision with root package name */
    public static int f199509g = 1;

    public static boolean a(Node node, JSONObject jSONObject) {
        if (node == null) {
            return false;
        }
        try {
            String nodeName = node.getNodeName();
            NodeList childNodes = node.getChildNodes();
            JSONObject jSONObject2 = new JSONObject();
            boolean z16 = false;
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item = childNodes.item(i3);
                if (item instanceof Element) {
                    a(item, jSONObject2);
                    z16 = true;
                } else if (item instanceof Text) {
                    jSONObject.put(nodeName, node.getFirstChild().getNodeValue());
                }
            }
            if (z16) {
                jSONObject.put(nodeName, jSONObject2);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

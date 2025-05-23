package com.tencent.ams.mosaic.utils.vid2url;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    private static String a(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    private static int b(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf == -1) {
            return 1;
        }
        String substring = str.substring(indexOf + 1, str.indexOf("]"));
        if (substring.equals("*")) {
            return -1;
        }
        return Integer.parseInt(substring);
    }

    public static ArrayList<Node> c(Document document, String str) {
        String[] split = str.split("/");
        Element documentElement = document.getDocumentElement();
        ArrayList arrayList = new ArrayList();
        arrayList.add(documentElement);
        return h(arrayList, split, 1);
    }

    public static ArrayList<Node> d(Node node, String str) {
        String[] split = str.split("/");
        ArrayList arrayList = new ArrayList();
        arrayList.add(node);
        return h(arrayList, split, 0);
    }

    public static String e(Node node, String str) {
        return f(g(node, str.split("/"), 0));
    }

    private static String f(Node node) {
        if (node != null && node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        }
        return null;
    }

    private static Node g(Node node, String[] strArr, int i3) {
        if (node != null) {
            int i16 = 1;
            if (i3 != strArr.length - 1) {
                int i17 = i3 + 1;
                String str = strArr[i17];
                String a16 = a(str);
                int b16 = b(str);
                NodeList childNodes = node.getChildNodes();
                if (childNodes != null) {
                    for (int i18 = 0; i18 < childNodes.getLength(); i18++) {
                        Node item = childNodes.item(i18);
                        if (item != null && !TextUtils.isEmpty(item.getNodeName()) && item.getNodeName().equalsIgnoreCase(a16)) {
                            if (i16 == b16) {
                                return g(item, strArr, i17);
                            }
                            i16++;
                        }
                    }
                }
                return null;
            }
            return node;
        }
        return node;
    }

    private static ArrayList<Node> h(ArrayList<Node> arrayList, String[] strArr, int i3) {
        if (i3 == strArr.length - 1) {
            return arrayList;
        }
        int i16 = i3 + 1;
        String str = strArr[i16];
        String a16 = a(str);
        int b16 = b(str);
        ArrayList<Node> arrayList2 = new ArrayList<>();
        Iterator<Node> it = arrayList.iterator();
        while (it.hasNext()) {
            NodeList childNodes = it.next().getChildNodes();
            int i17 = 0;
            int i18 = 1;
            while (true) {
                if (i17 < childNodes.getLength()) {
                    Node item = childNodes.item(i17);
                    if (item.getNodeName().equalsIgnoreCase(a16)) {
                        if (b16 > 0) {
                            if (i18 == b16) {
                                arrayList2.add(item);
                                break;
                            }
                        } else {
                            arrayList2.add(item);
                        }
                        i18++;
                    }
                    i17++;
                }
            }
        }
        if (arrayList2.size() > 0) {
            return h(arrayList2, strArr, i16);
        }
        return arrayList2;
    }
}

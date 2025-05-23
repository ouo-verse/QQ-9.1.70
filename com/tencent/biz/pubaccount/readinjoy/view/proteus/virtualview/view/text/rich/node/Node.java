package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class Node {
    public static final String ATTRS_ATTR = "attrs";
    public static final String CHILDREN_ATTR = "children";
    public static final String IMG_NODE = "img";
    public static final String NAME_ATTR = "name";
    public static final int NODE_TYPE_IMG = 2;
    public static final int NODE_TYPE_LAYOUT = 3;
    public static final int NODE_TYPE_TEXT = 1;
    public static final String STYLE_ATTR = "style";
    public static final String TEXT_NODE = "text";
    public static final String TRUNCATE_ATTR = "truncationAttrs";
    public static final String TYPE_ATTR = "type";
    public CssStyleSet cssStyleSet;
    public int nodeType;
    public TruncateAttr truncateAttr;
    public double nodeRatio = 1.0d;
    public List<Node> children = new ArrayList();

    public Node(int i3) {
        this.nodeType = i3;
    }

    public static boolean valueIsLegal(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("$") && str.length() > 1) {
            char charAt = str.charAt(1);
            if (charAt >= 'a' && charAt <= 'z') {
                return false;
            }
            if ((charAt >= 'A' && charAt <= 'Z') || charAt == '_') {
                return false;
            }
        }
        return true;
    }
}

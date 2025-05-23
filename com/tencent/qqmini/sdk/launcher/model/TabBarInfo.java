package com.tencent.qqmini.sdk.launcher.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TabBarInfo implements Cloneable {
    public static final String BORDER_STYLE_BLACK = "black";
    public static final String BORDER_STYLE_WHITE = "white";
    public static final String POS_BOTTOM = "bottom";
    public static final String POS_TOP = "top";
    public int backgroundColor;
    public String borderStyle;
    public int color;
    public boolean custom;
    public boolean isShow = true;
    public List<ButtonInfo> list;
    public String position;
    public int selectedColor;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ButtonInfo implements Cloneable {
        public Bitmap iconBitmap;
        public String iconPath;
        public String pagePath;
        public Bitmap selectedBitmap;
        public String selectedIconPath;
        public String text;

        public static ButtonInfo parse(JSONObject jSONObject) {
            ButtonInfo buttonInfo = new ButtonInfo();
            if (jSONObject != null) {
                buttonInfo.pagePath = jSONObject.optString("pagePath");
                buttonInfo.text = jSONObject.optString("text");
                buttonInfo.iconPath = jSONObject.optString("iconData");
                buttonInfo.selectedIconPath = jSONObject.optString("selectedIconData");
                buttonInfo.iconBitmap = TabBarInfo.transDataToBitmap(buttonInfo.iconPath);
                buttonInfo.selectedBitmap = TabBarInfo.transDataToBitmap(buttonInfo.selectedIconPath);
            }
            return buttonInfo;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ButtonInfo m245clone() {
            try {
                return (ButtonInfo) super.clone();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
    }

    public static TabBarInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            TabBarInfo tabBarInfo = new TabBarInfo();
            boolean optBoolean = jSONObject.optBoolean("custom", false);
            tabBarInfo.custom = optBoolean;
            if (optBoolean) {
                tabBarInfo.isShow = false;
            }
            tabBarInfo.color = ColorUtils.parseColor(jSONObject.optString("color"));
            tabBarInfo.selectedColor = ColorUtils.parseColor(jSONObject.optString("selectedColor"));
            tabBarInfo.backgroundColor = ColorUtils.parseColor(jSONObject.optString("backgroundColor"));
            tabBarInfo.borderStyle = jSONObject.optString(NodeProps.BORDER_STYLES, "black");
            tabBarInfo.list = parseIconList(jSONObject.optJSONArray("list"));
            tabBarInfo.position = jSONObject.optString("position", "bottom");
            return tabBarInfo;
        }
        return null;
    }

    public static List<ButtonInfo> parseIconList(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    linkedList.add(ButtonInfo.parse(optJSONObject));
                }
            }
        }
        return linkedList;
    }

    public static Bitmap transDataToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            if (decode == null) {
                return null;
            }
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setShow(boolean z16) {
        this.isShow = z16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TabBarInfo m244clone() {
        TabBarInfo tabBarInfo;
        Throwable th5;
        try {
            tabBarInfo = (TabBarInfo) super.clone();
        } catch (Throwable th6) {
            tabBarInfo = null;
            th5 = th6;
        }
        try {
            tabBarInfo.list = new LinkedList();
            Iterator<ButtonInfo> it = this.list.iterator();
            while (it.hasNext()) {
                tabBarInfo.list.add(it.next().m245clone());
            }
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return tabBarInfo;
        }
        return tabBarInfo;
    }
}

package com.tencent.mobileqq.mini.apkg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
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
    /* loaded from: classes33.dex */
    public static class ButtonInfo implements Cloneable {
        public Bitmap iconBitmap;
        public String iconData;
        public String iconPath;
        public String pagePath;
        public Bitmap selectedBitmap;
        public String selectedIconData;
        public String selectedIconPath;
        public String text;

        public static ButtonInfo parse(JSONObject jSONObject, ApkgInfo apkgInfo) {
            ButtonInfo buttonInfo = new ButtonInfo();
            if (jSONObject != null) {
                buttonInfo.pagePath = jSONObject.optString("pagePath");
                buttonInfo.text = jSONObject.optString("text");
                buttonInfo.iconData = jSONObject.optString("iconData");
                buttonInfo.iconPath = jSONObject.optString("iconPath");
                buttonInfo.selectedIconData = jSONObject.optString("selectedIconData");
                buttonInfo.selectedIconPath = jSONObject.optString("selectedIconPath");
                if (!TextUtils.isEmpty(buttonInfo.iconPath)) {
                    buttonInfo.iconBitmap = TabBarInfo.transPathToBitmap(buttonInfo.iconPath, apkgInfo);
                } else {
                    buttonInfo.iconBitmap = TabBarInfo.transDataToBitmap(buttonInfo.iconData);
                }
                if (!TextUtils.isEmpty(buttonInfo.selectedIconPath)) {
                    buttonInfo.selectedBitmap = TabBarInfo.transPathToBitmap(buttonInfo.selectedIconPath, apkgInfo);
                } else {
                    buttonInfo.selectedBitmap = TabBarInfo.transDataToBitmap(buttonInfo.selectedIconData);
                }
            }
            return buttonInfo;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ButtonInfo m203clone() {
            try {
                return (ButtonInfo) super.clone();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
    }

    public static List<ButtonInfo> parseIconList(JSONArray jSONArray, ApkgInfo apkgInfo) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    linkedList.add(ButtonInfo.parse(optJSONObject, apkgInfo));
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

    public static Bitmap transPathToBitmap(String str, ApkgInfo apkgInfo) {
        return apkgInfo.getBitmap(apkgInfo.getFilePath(str));
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setShow(boolean z16) {
        this.isShow = z16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TabBarInfo m202clone() {
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
                tabBarInfo.list.add(it.next().m203clone());
            }
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return tabBarInfo;
        }
        return tabBarInfo;
    }

    public static TabBarInfo parse(JSONObject jSONObject, ApkgInfo apkgInfo) {
        if (jSONObject == null) {
            return null;
        }
        TabBarInfo tabBarInfo = new TabBarInfo();
        boolean optBoolean = jSONObject.optBoolean("custom", false);
        tabBarInfo.custom = optBoolean;
        if (optBoolean) {
            tabBarInfo.isShow = false;
        }
        tabBarInfo.color = DisplayUtil.parseColor(jSONObject.optString("color"));
        tabBarInfo.selectedColor = DisplayUtil.parseColor(jSONObject.optString("selectedColor"));
        tabBarInfo.backgroundColor = DisplayUtil.parseColor(jSONObject.optString("backgroundColor"));
        tabBarInfo.borderStyle = jSONObject.optString(NodeProps.BORDER_STYLES, "black");
        tabBarInfo.list = parseIconList(jSONObject.optJSONArray("list"), apkgInfo);
        tabBarInfo.position = jSONObject.optString("position", "bottom");
        return tabBarInfo;
    }
}

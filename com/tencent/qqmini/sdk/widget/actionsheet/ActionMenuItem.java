package com.tencent.qqmini.sdk.widget.actionsheet;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ActionMenuItem {
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_WARN = 2;
    public int action;
    public String content;
    public HashMap<String, Object> tag;
    public int type;
    public int viewid;
    public int visibility;

    public ActionMenuItem(String str, int i3, int i16) {
        this(0, str, i3, i16);
    }

    public Object getTag(String str) {
        return this.tag.get(str);
    }

    public void setTag(String str, Object obj) {
        this.tag.put(str, obj);
    }

    public void setVisibility(int i3) {
        this.visibility = i3;
    }

    public ActionMenuItem(int i3, String str, int i16, int i17) {
        this(i3, str, i16, i17, 1);
    }

    public ActionMenuItem(int i3, String str, int i16, int i17, int i18) {
        this.type = 1;
        this.tag = new HashMap<>();
        this.viewid = i3;
        this.content = str;
        this.action = i16;
        this.visibility = i17;
        this.type = i18;
    }
}

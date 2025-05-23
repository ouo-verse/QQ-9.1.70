package com.tencent.qqlive.module.videoreport.visual.debug.data;

import android.graphics.Rect;
import android.view.View;
import com.tencent.qqlive.module.videoreport.visual.debug.util.UIUtils;
import java.util.Map;

/* loaded from: classes22.dex */
public class PageData {
    public String pageId;
    public Map<String, ?> pageParams;
    public final String type;
    public final Rect viewRect;

    public PageData(Object obj, View view) {
        this.type = obj.getClass().getSimpleName();
        this.viewRect = UIUtils.getViewRect(view);
    }
}

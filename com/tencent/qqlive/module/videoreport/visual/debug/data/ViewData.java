package com.tencent.qqlive.module.videoreport.visual.debug.data;

import android.graphics.Rect;
import android.view.View;
import com.tencent.qqlive.module.videoreport.visual.debug.util.UIUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewData {
    public String elementId;
    public Map<String, ?> elementParams;
    public boolean hasClickListener;
    public boolean hasInject;
    public int layer;
    public String pageId;
    public ViewData parent;
    public boolean reportClick;
    public boolean reportEndExposure;
    public boolean reportExposure;
    public final WeakReference<View> target;
    public final String type;
    public final Rect viewRect;
    public final Rect visibleRect;

    public ViewData(View view) {
        this.target = new WeakReference<>(view);
        this.type = view.getClass().getSimpleName();
        this.viewRect = UIUtils.getViewRect(view);
        this.visibleRect = UIUtils.getViewVisibleRect(view);
    }
}

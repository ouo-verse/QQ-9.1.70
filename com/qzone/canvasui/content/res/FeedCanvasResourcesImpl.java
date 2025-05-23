package com.qzone.canvasui.content.res;

import android.graphics.drawable.Drawable;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.ditto.content.res.DittoResources;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedCanvasResourcesImpl implements DittoResources {
    @Override // com.tencent.ditto.content.res.DittoResources
    public int getColor(int i3) {
        return FeedGlobalEnv.getContext().getResources().getColor(i3);
    }

    @Override // com.tencent.ditto.content.res.DittoResources
    public int getCustomColor(String str) {
        HashMap<String, Integer> l3 = j.l();
        if (l3 != null) {
            return l3.get(str).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ditto.content.res.DittoResources
    public Drawable getDrawable(int i3) {
        return FeedGlobalEnv.getContext().getResources().getDrawable(i3);
    }

    @Override // com.tencent.ditto.content.res.DittoResources
    public String getString(int i3) {
        return FeedGlobalEnv.getContext().getResources().getString(i3);
    }
}

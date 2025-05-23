package com.tencent.ditto.shell;

import com.tencent.ditto.utils.ClassLoadUtils;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.FlexLinearAreaLayout;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoAreaEnv {
    public static final Map<String, Class> mAreaLib;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        mAreaLib = concurrentHashMap;
        concurrentHashMap.put("com.tencent.ditto.widget.DittoImageArea", DittoImageArea.class);
        concurrentHashMap.put("com.tencent.ditto.widget.DittoButtonArea", DittoButtonArea.class);
        concurrentHashMap.put("com.tencent.ditto.widget.DittoListArea", DittoListArea.class);
        concurrentHashMap.put("com.tencent.ditto.widget.DittoTextArea", DittoTextArea.class);
        concurrentHashMap.put("com.tencent.ditto.widget.FlexLinearAreaLayout", FlexLinearAreaLayout.class);
        concurrentHashMap.put("com.tencent.ditto.widget.LinearAreaLayout", LinearAreaLayout.class);
        concurrentHashMap.put("com.tencent.ditto.widget.RelativeAreaLayout", RelativeAreaLayout.class);
    }

    public static Class findAreaClass(String str) throws ClassNotFoundException {
        Map<String, Class> map = mAreaLib;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        Class<?> load = ClassLoadUtils.load(DittoUIEngine.g().getContext().getClassLoader(), str);
        map.put(str, load);
        return load;
    }
}

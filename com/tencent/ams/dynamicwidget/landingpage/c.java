package com.tencent.ams.dynamicwidget.landingpage;

import com.tencent.ams.dynamicwidget.e;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/c;", "Lcom/tencent/ams/dynamicwidget/e;", "", "downX", "downY", "Lorg/json/JSONObject;", "params", "", "d", "", "clickArea", "c", "g", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface c extends e {
    void c(float downX, float downY, int clickArea);

    void d(float downX, float downY, @Nullable JSONObject params);

    void g();
}

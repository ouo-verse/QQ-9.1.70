package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements a {
    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, JSONArray jSONArray) {
        return a(path);
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public String getMethod() {
        return CanvasView.ACTION_CLOSEPATH;
    }

    public final boolean a(Path path) {
        path.close();
        return true;
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        return a(path);
    }
}

package com.tencent.luggage.wxa.we;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 509;
    public static final String NAME = "insertPositioningContainer";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                com.tencent.luggage.wxa.gh.e.a((ViewGroup) view, motionEvent);
                return false;
            }
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(f fVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.we.a aVar = new com.tencent.luggage.wxa.we.a(fVar.getContext());
        int i3 = 0;
        aVar.setBackgroundColor(0);
        boolean optBoolean = jSONObject.optBoolean(NodeProps.VISIBLE, true);
        boolean optBoolean2 = jSONObject.optBoolean("canFullScreenByChild", false);
        int a16 = g.a(jSONObject, "contentOffsetLeft", 0);
        int a17 = g.a(jSONObject, "contentOffsetTop", 0);
        aVar.setX(-a16);
        aVar.setY(-a17);
        e eVar = new e(fVar.getContext(), aVar);
        if (!optBoolean) {
            i3 = 4;
        }
        eVar.setVisibility(i3);
        eVar.setDuplicateParentStateEnabled(true);
        aVar.setDuplicateParentStateEnabled(true);
        aVar.setFullscreenWithChild(optBoolean2);
        return eVar;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(f fVar, int i3, View view, JSONObject jSONObject) {
        view.setOnTouchListener(new a());
    }
}

package com.tencent.ams.mosaic.jsengine.component.draw;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ShapeComponent extends Component {
    void addArc(float f16, float f17, float f18, float f19, float f26);

    void addCubic(float f16, float f17, float f18, float f19, float f26, float f27);

    void addLine(float f16, float f17);

    void addQuad(float f16, float f17, float f18, float f19);

    void clean();

    void finishPath();

    void moveToPoint(float f16, float f17);

    void setFillColor(String str);

    void setFillColorGradient(String str);

    void setStrokeCap(int i3);

    void setStrokeColor(String str);

    void setStrokeWidth(float f16);

    void shapeClose();
}

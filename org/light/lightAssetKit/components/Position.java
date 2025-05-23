package org.light.lightAssetKit.components;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class Position extends Component {

    /* renamed from: x, reason: collision with root package name */
    private float f423820x;

    /* renamed from: y, reason: collision with root package name */
    private float f423821y;

    /* renamed from: z, reason: collision with root package name */
    private float f423822z;

    public Position() {
        this.f423820x = 1.0f;
        this.f423821y = 1.0f;
        this.f423822z = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Position) {
            Position position = (Position) componentBase;
            this.f423820x = position.f423820x;
            this.f423821y = position.f423821y;
            this.f423822z = position.f423822z;
        }
        super.doUpdate(componentBase);
    }

    public float getX() {
        return this.f423820x;
    }

    public float getY() {
        return this.f423821y;
    }

    public float getZ() {
        return this.f423822z;
    }

    public void setX(float f16) {
        this.f423820x = f16;
        reportPropertyChange(HippyTKDListViewAdapter.X, Float.valueOf(f16));
    }

    public void setY(float f16) {
        this.f423821y = f16;
        reportPropertyChange("y", Float.valueOf(f16));
    }

    public void setZ(float f16) {
        this.f423822z = f16;
        reportPropertyChange(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Position";
    }

    public Position(float f16, float f17, float f18) {
        this.f423820x = f16;
        this.f423821y = f17;
        this.f423822z = f18;
    }
}

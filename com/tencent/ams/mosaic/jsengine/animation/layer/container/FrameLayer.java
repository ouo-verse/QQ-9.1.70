package com.tencent.ams.mosaic.jsengine.animation.layer.container;

import android.content.Context;
import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameLayer extends ContainerLayerBase {
    static IPatchRedirector $redirector_;

    public FrameLayer(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(LayerBase layerBase) {
        float f16;
        float f17;
        LayerBase layerBase2;
        float f18;
        boolean z16;
        float f19;
        boolean z17;
        Float f26;
        if (layerBase == null) {
            return;
        }
        float width = layerBase.getWidth();
        float height = layerBase.getHeight();
        Component parent = layerBase.getParent();
        Float f27 = null;
        if (parent instanceof LayerBase) {
            layerBase2 = (LayerBase) parent;
            f16 = layerBase2.getWidth();
            f17 = layerBase2.getHeight();
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
            layerBase2 = null;
        }
        if (width == -1.0f) {
            f18 = (f16 - layerBase.getMarginLeft()) - layerBase.getMarginRight();
            z16 = true;
        } else {
            f18 = width;
            z16 = false;
        }
        if (height == -1.0f) {
            f19 = (f17 - layerBase.getMarginTop()) - layerBase.getMarginBottom();
            z17 = true;
        } else {
            f19 = height;
            z17 = false;
        }
        String[] alignParentArray = layerBase.getAlignParentArray();
        if (alignParentArray != null) {
            f26 = null;
            for (String str : alignParentArray) {
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals("bottom")) {
                            c16 = 0;
                        }
                        switch (c16) {
                            case 0:
                                f26 = Float.valueOf((f17 - f19) - layerBase.getMarginBottom());
                                break;
                            case 1:
                                if (!z16) {
                                    f27 = Float.valueOf((f16 - f18) / 2.0f);
                                }
                                if (z17) {
                                    break;
                                } else {
                                    f26 = Float.valueOf((f17 - f19) / 2.0f);
                                    break;
                                }
                            case 2:
                                if (z17) {
                                    break;
                                } else {
                                    f26 = Float.valueOf((f17 - f19) / 2.0f);
                                    break;
                                }
                            case 3:
                                f26 = Float.valueOf(layerBase.getMarginTop());
                                break;
                            case 4:
                                f27 = Float.valueOf(layerBase.getMarginLeft());
                                break;
                            case 5:
                                f27 = Float.valueOf((f16 - f18) - layerBase.getMarginRight());
                                break;
                            case 6:
                                if (z16) {
                                    break;
                                } else {
                                    f27 = Float.valueOf((f16 - f18) / 2.0f);
                                    break;
                                }
                        }
                        break;
                    case -1364013995:
                        if (str.equals("center")) {
                            c16 = 1;
                        }
                        switch (c16) {
                        }
                        break;
                    case -348726240:
                        if (str.equals("center_vertical")) {
                            c16 = 2;
                        }
                        switch (c16) {
                        }
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            c16 = 3;
                        }
                        switch (c16) {
                        }
                        break;
                    case 3317767:
                        if (str.equals("left")) {
                            c16 = 4;
                        }
                        switch (c16) {
                        }
                        break;
                    case 108511772:
                        if (str.equals("right")) {
                            c16 = 5;
                        }
                        switch (c16) {
                        }
                        break;
                    case 1063616078:
                        if (str.equals("center_horizontal")) {
                            c16 = 6;
                        }
                        switch (c16) {
                        }
                        break;
                    default:
                        switch (c16) {
                        }
                        break;
                }
            }
        } else {
            f26 = null;
        }
        if (f27 == null) {
            f27 = Float.valueOf(layerBase.getMarginLeft());
        }
        if (f26 == null) {
            f26 = Float.valueOf(layerBase.getMarginTop());
        }
        if (layerBase2 != null) {
            float[] h16 = h(f27.floatValue(), f26.floatValue(), f18, f19, f16, f17);
            layerBase.setFrame(h16[0] + layerBase.getPositionX(), h16[1] + layerBase.getPositionY(), (int) h16[2], (int) h16[3]);
        } else {
            layerBase.setFrame(f27.floatValue() + layerBase.getPositionX(), f26.floatValue() + layerBase.getPositionY(), f18, f19);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayerBase
    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Iterator<LayerBase> it = this.S.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
    }
}

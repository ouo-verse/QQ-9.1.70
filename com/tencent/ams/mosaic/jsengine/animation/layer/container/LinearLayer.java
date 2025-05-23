package com.tencent.ams.mosaic.jsengine.animation.layer.container;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.component.container.Linear;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LinearLayer extends ContainerLayerBase implements Linear {
    static IPatchRedirector $redirector_ = null;
    public static final String DIRECTION_COLUMN = "column";
    public static final String DIRECTION_ROW = "row";
    private String U;
    private String[] V;

    public LinearLayer(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    private void i() {
        float f16;
        float f17;
        char c16;
        char c17;
        float width = getWidth();
        float height = getHeight();
        Iterator<LayerBase> it = this.S.iterator();
        int i3 = 0;
        while (true) {
            f16 = -1.0f;
            if (!it.hasNext()) {
                break;
            }
            LayerBase next = it.next();
            float height2 = next.getHeight();
            if (height2 == -1.0f) {
                height2 = (height - next.getMarginTop()) - next.getMarginBottom();
            }
            i3 = (int) (i3 + next.getMarginTop() + height2 + next.getMarginBottom());
        }
        String[] strArr = this.V;
        if (strArr != null) {
            float f18 = 0.0f;
            for (String str : strArr) {
                str.hashCode();
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals("bottom")) {
                            c17 = 0;
                            break;
                        }
                        break;
                    case -1364013995:
                        if (str.equals("center")) {
                            c17 = 1;
                            break;
                        }
                        break;
                    case -348726240:
                        if (str.equals("center_vertical")) {
                            c17 = 2;
                            break;
                        }
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            c17 = 3;
                            break;
                        }
                        break;
                }
                c17 = '\uffff';
                switch (c17) {
                    case 0:
                        f18 = height - i3;
                        break;
                    case 1:
                    case 2:
                        f18 = (height - i3) / 2.0f;
                        break;
                    case 3:
                        f18 = 0.0f;
                        break;
                }
            }
            f17 = f18;
        } else {
            f17 = 0.0f;
        }
        for (LayerBase layerBase : this.S) {
            float marginTop = f17 + layerBase.getMarginTop();
            float width2 = layerBase.getWidth();
            if (width2 == f16) {
                width2 = (width - layerBase.getMarginLeft()) - layerBase.getMarginRight();
            }
            float f19 = width2;
            float height3 = layerBase.getHeight();
            if (height3 == f16) {
                height3 = (height - layerBase.getMarginTop()) - layerBase.getMarginBottom();
            }
            float f26 = height3;
            float marginLeft = layerBase.getMarginLeft();
            String[] strArr2 = this.V;
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -1364013995:
                            if (str2.equals("center")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case 100571:
                            if (str2.equals("end")) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str2.equals("start")) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case 1063616078:
                            if (str2.equals("center_horizontal")) {
                                c16 = 3;
                                break;
                            }
                            break;
                    }
                    c16 = '\uffff';
                    switch (c16) {
                        case 0:
                        case 3:
                            marginLeft = (width - f19) / 2.0f;
                            break;
                        case 1:
                            marginLeft = (width - f19) - layerBase.getMarginRight();
                            break;
                        case 2:
                            marginLeft = layerBase.getMarginLeft();
                            break;
                    }
                }
            }
            float marginBottom = marginTop + f26 + layerBase.getMarginBottom();
            float[] h16 = h(marginLeft, marginTop, f19, f26, width, height);
            layerBase.setFrame(h16[0], h16[1], (int) h16[2], (int) h16[3]);
            f17 = marginBottom;
            f16 = -1.0f;
        }
    }

    private void j() {
        float f16;
        float f17;
        char c16;
        char c17;
        float width = getWidth();
        float height = getHeight();
        Iterator<LayerBase> it = this.S.iterator();
        int i3 = 0;
        while (true) {
            f16 = -1.0f;
            if (!it.hasNext()) {
                break;
            }
            LayerBase next = it.next();
            float width2 = next.getWidth();
            if (width2 == -1.0f) {
                width2 = (width - next.getMarginLeft()) - next.getMarginRight();
            }
            i3 = (int) (i3 + next.getMarginLeft() + width2 + next.getMarginRight());
        }
        String[] strArr = this.V;
        if (strArr != null) {
            float f18 = 0.0f;
            for (String str : strArr) {
                str.hashCode();
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c17 = 0;
                            break;
                        }
                        break;
                    case 100571:
                        if (str.equals("end")) {
                            c17 = 1;
                            break;
                        }
                        break;
                    case 109757538:
                        if (str.equals("start")) {
                            c17 = 2;
                            break;
                        }
                        break;
                    case 1063616078:
                        if (str.equals("center_horizontal")) {
                            c17 = 3;
                            break;
                        }
                        break;
                }
                c17 = '\uffff';
                switch (c17) {
                    case 0:
                    case 3:
                        f18 = (width - i3) / 2.0f;
                        break;
                    case 1:
                        f18 = width - i3;
                        break;
                    case 2:
                        f18 = 0.0f;
                        break;
                }
            }
            f17 = f18;
        } else {
            f17 = 0.0f;
        }
        for (LayerBase layerBase : this.S) {
            float width3 = layerBase.getWidth();
            if (width3 == f16) {
                width3 = (width - layerBase.getMarginLeft()) - layerBase.getMarginRight();
            }
            float f19 = width3;
            float height2 = layerBase.getHeight();
            if (height2 == f16) {
                height2 = (height - layerBase.getMarginTop()) - layerBase.getMarginBottom();
            }
            float f26 = height2;
            float marginLeft = f17 + layerBase.getMarginLeft();
            float marginTop = layerBase.getMarginTop();
            String[] strArr2 = this.V;
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -1383228885:
                            if (str2.equals("bottom")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case -1364013995:
                            if (str2.equals("center")) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case -348726240:
                            if (str2.equals("center_vertical")) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case 115029:
                            if (str2.equals("top")) {
                                c16 = 3;
                                break;
                            }
                            break;
                    }
                    c16 = '\uffff';
                    switch (c16) {
                        case 0:
                            marginTop = (height - f26) - layerBase.getMarginBottom();
                            break;
                        case 1:
                        case 2:
                            marginTop = (height - f26) / 2.0f;
                            break;
                        case 3:
                            marginTop = layerBase.getMarginTop();
                            break;
                    }
                }
            }
            float marginRight = marginLeft + f19 + layerBase.getMarginRight();
            float[] h16 = h(marginLeft, marginTop, f19, f26, width, height);
            layerBase.setFrame(h16[0], h16[1], (int) h16[2], (int) h16[3]);
            f17 = marginRight;
            f16 = -1.0f;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayerBase
    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if ("row".equalsIgnoreCase(this.U)) {
            j();
        } else if ("column".equalsIgnoreCase(this.U)) {
            i();
        } else {
            j();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Linear
    public void setAlignItems(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.V = str.split("[|]");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Linear
    public void setDirection(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.U = str;
        }
    }
}

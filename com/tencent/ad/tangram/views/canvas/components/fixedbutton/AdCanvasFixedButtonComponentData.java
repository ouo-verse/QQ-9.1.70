package com.tencent.ad.tangram.views.canvas.components.fixedbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasFixedButtonComponentData extends AdCanvasAppBtnComponentData {
    public static final String BUTTON_STYLE_1 = "fixedBtn-1";
    public static final String BUTTON_STYLE_2 = "fixedBtn-2";
    public static final String POSITION_B0TTOM = "bottom";
    public static final String POSITION_TOP = "top";
    public String buttonStyle;
    public String desc;
    public long fileSize;
    public String imageUrl;
    public String name;
    public String position;
    public int bottomWhiteSpace = 0;
    public int topWhiteSpace = 0;

    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData, com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        return !TextUtils.isEmpty(this.buttonStyle);
    }
}

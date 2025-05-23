package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import com.tencent.hippykotlin.demo.pages.foundation.view.QQAvatarView;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.c;
import com.tencent.ntcompose.core.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieComposeUiCreator implements e {
    public static final AdelieComposeUiCreator INSTANCE = new AdelieComposeUiCreator();

    @Override // com.tencent.ntcompose.core.e
    public final ComposeRenderView createComposeView(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1898171474) {
            if (hashCode != 279945113) {
                if (hashCode == 1882743493 && str.equals("ScanningLight")) {
                    return c.b(new QUIScanningLightView());
                }
            } else if (str.equals("QQAvatar")) {
                return c.b(new QQAvatarView());
            }
        } else if (str.equals("QRCode")) {
            return c.b(new QRCodeView());
        }
        return c.b(new v());
    }

    public final ComposeRenderView createViewFromRegister(String str) {
        return e.a.a(this, str);
    }
}

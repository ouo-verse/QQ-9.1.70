package com.tencent.luggage.wxa.zd;

import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.rc.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m extends JsApiSetAudioState {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState
    public a0.a a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        try {
            if (dVar.getFileSystem() instanceof y) {
                IWxaFileSystemWithModularizing iWxaFileSystemWithModularizing = (IWxaFileSystemWithModularizing) ((y) dVar.getFileSystem()).a(IWxaFileSystemWithModularizing.class);
                Objects.requireNonNull(iWxaFileSystemWithModularizing);
                return iWxaFileSystemWithModularizing.openReadPartialInfo(str);
            }
            return null;
        } catch (Exception e16) {
            w.b("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", str, e16);
            return null;
        }
    }
}

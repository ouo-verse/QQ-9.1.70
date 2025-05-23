package com.tencent.qqnt.emotion.stickerrecommended.impl;

import android.content.Context;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecApi;
import com.tencent.qqnt.emotion.stickerrecommended.q;
import com.tencent.qqnt.emotion.stickerrecommended.y;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes24.dex */
public class StickerRecApiImpl implements IStickerRecApi {
    static IPatchRedirector $redirector_;

    public StickerRecApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecApi
    public ProtocolDownloader getStickerRecDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProtocolDownloader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new q();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecApi
    public NewIntent getStickerRecIntent(Context context, byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (NewIntent) iPatchRedirector.redirect((short) 3, this, context, bArr, str);
        }
        NewIntent newIntent = new NewIntent(context, y.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, bArr);
        newIntent.putExtra("key_cmd", str);
        return newIntent;
    }
}

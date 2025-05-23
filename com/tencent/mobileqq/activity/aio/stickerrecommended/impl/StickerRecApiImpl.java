package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.content.Context;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi;
import com.tencent.mobileqq.activity.aio.stickerrecommended.i;
import com.tencent.mobileqq.activity.aio.stickerrecommended.q;
import com.tencent.mobileqq.transfile.ProtoServlet;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StickerRecApiImpl implements IStickerRecApi {
    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi
    public ProtocolDownloader getStickerRecDownloader() {
        return new i();
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi
    public NewIntent getStickerRecIntent(Context context, byte[] bArr, String str) {
        NewIntent newIntent = new NewIntent(context, q.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, bArr);
        newIntent.putExtra("key_cmd", str);
        return newIntent;
    }
}

package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf$Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StUpdateBookShelfReadTimeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BookShelfUpdateServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_CATEGORY = "key_category";
    public static final String KEY_CONTENT_ID = "key_contentId";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "BookShelfUpdateServlet";

    public BookShelfUpdateServlet() {
        this.observerId = 1082;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MiniBookShelf$StUpdateBookShelfReadTimeRsp onResponse = BookShelfUpdateRequest.onResponse(bArr);
        MiniBookShelf$Information miniBookShelf$Information = onResponse != null ? onResponse.updateInfo.get() : null;
        if (miniBookShelf$Information != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("contendId", miniBookShelf$Information.contentId.get());
                jSONObject.putOpt("status", Integer.valueOf(miniBookShelf$Information.status.get()));
                jSONObject.putOpt("msg", miniBookShelf$Information.f24952msg.get());
                jSONObject.putOpt("exist", Integer.valueOf(miniBookShelf$Information.existStatus.get()));
            } catch (Throwable th5) {
                QLog.i(TAG, 1, "", th5);
            }
            bundle.putString("key_result_data", jSONObject.toString());
            notifyObserver(intent, 1082, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1082, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra("key_category");
        String stringExtra3 = intent.getStringExtra(KEY_CONTENT_ID);
        byte[] encode = new BookShelfUpdateRequest(stringExtra, stringExtra2, stringExtra3).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}

package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf$Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StQueryBookShelfRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BookShelfQueryServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_CONTENT_ID_LIST = "key_contentIds";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "BookShelfQueryServlet";

    public BookShelfQueryServlet() {
        this.observerId = 1081;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MiniBookShelf$StQueryBookShelfRsp onResponse = BookShelfQueryRequest.onResponse(bArr);
        List<MiniBookShelf$Information> list = onResponse != null ? onResponse.bookInfo.get() : null;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < list.size(); i3++) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("contentId", list.get(i3).contentId.get());
                    jSONObject.putOpt("status", Integer.valueOf(list.get(i3).status.get()));
                    jSONObject.putOpt("msg", list.get(i3).f24952msg.get());
                    jSONObject.putOpt("exist", Integer.valueOf(list.get(i3).existStatus.get()));
                    jSONArray.mo162put(jSONObject);
                } catch (Throwable th5) {
                    QLog.i(TAG, 1, "", th5);
                }
            }
            bundle.putString("key_result_data", jSONArray.toString());
            notifyObserver(intent, 1081, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1081, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_contentIds");
        byte[] encode = new BookShelfQueryRequest(stringExtra, stringArrayListExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_book_shelf.QueryBookShelf");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}

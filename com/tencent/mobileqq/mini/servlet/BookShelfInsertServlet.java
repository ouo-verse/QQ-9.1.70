package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf$Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StInsertBookShelfRsp;
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
public class BookShelfInsertServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_CATEGORY = "key_category";
    public static final String KEY_CONTENT_ID_LIST = "key_contentIds";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "BookShelfInsertServlet";

    public BookShelfInsertServlet() {
        this.observerId = 1080;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MiniBookShelf$StInsertBookShelfRsp onResponse = BookShelfInsertRequest.onResponse(bArr);
        List<MiniBookShelf$Information> list = onResponse != null ? onResponse.info.get() : null;
        if (list != null && list.size() > 0) {
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
            notifyObserver(intent, 1080, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1080, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra("key_category");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_contentIds");
        byte[] encode = new BookShelfInsertRequest(stringExtra, stringExtra2, stringArrayListExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_book_shelf.InsertBookShelf");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}

package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf$Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StQueryBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StQueryBookShelfRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BookShelfQueryRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.QueryBookShelf";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "BookShelfQueryRequest";
    private MiniBookShelf$StQueryBookShelfReq req;

    public BookShelfQueryRequest(String str, ArrayList<String> arrayList) {
        MiniBookShelf$StQueryBookShelfReq miniBookShelf$StQueryBookShelfReq = new MiniBookShelf$StQueryBookShelfReq();
        this.req = miniBookShelf$StQueryBookShelfReq;
        miniBookShelf$StQueryBookShelfReq.appid.set(str);
        if (arrayList != null) {
            this.req.contentIds.addAll(arrayList);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "QueryBookShelf";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public String getCmdString() {
        return "LightAppSvc.mini_book_shelf.QueryBookShelf";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_book_shelf";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        if (bArr == null) {
            return null;
        }
        try {
            MiniBookShelf$StQueryBookShelfRsp miniBookShelf$StQueryBookShelfRsp = new MiniBookShelf$StQueryBookShelfRsp();
            miniBookShelf$StQueryBookShelfRsp.mergeFrom(bArr);
            List<MiniBookShelf$Information> list = miniBookShelf$StQueryBookShelfRsp.bookInfo.get();
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("contendId", list.get(i3).contentId.get());
                        jSONObject2.putOpt("status", Integer.valueOf(list.get(i3).status.get()));
                        jSONObject2.putOpt("msg", list.get(i3).f24952msg.get());
                        jSONObject2.putOpt("exist", Integer.valueOf(list.get(i3).existStatus.get()));
                        jSONArray.mo162put(jSONObject2);
                    } catch (Throwable th5) {
                        QMLog.i("BookShelfQueryRequest", "", th5);
                    }
                }
                jSONObject.putOpt("key_result_data", jSONArray);
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("BookShelfQueryRequest", "onResponse fail." + e16);
            return null;
        }
    }
}

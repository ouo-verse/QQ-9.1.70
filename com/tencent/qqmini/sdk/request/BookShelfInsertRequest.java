package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf$Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StInsertBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StInsertBookShelfRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BookShelfInsertRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.InsertBookShelf";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "BookShelfInsertRequest";
    private MiniBookShelf$StInsertBookShelfReq req;

    public BookShelfInsertRequest(String str, String str2, ArrayList<String> arrayList) {
        MiniBookShelf$StInsertBookShelfReq miniBookShelf$StInsertBookShelfReq = new MiniBookShelf$StInsertBookShelfReq();
        this.req = miniBookShelf$StInsertBookShelfReq;
        miniBookShelf$StInsertBookShelfReq.appid.set(str);
        this.req.category.set(str2);
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
        return "InsertBookShelf";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public String getCmdString() {
        return "LightAppSvc.mini_book_shelf.InsertBookShelf";
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
            MiniBookShelf$StInsertBookShelfRsp miniBookShelf$StInsertBookShelfRsp = new MiniBookShelf$StInsertBookShelfRsp();
            miniBookShelf$StInsertBookShelfRsp.mergeFrom(bArr);
            List<MiniBookShelf$Information> list = miniBookShelf$StInsertBookShelfRsp.info.get();
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
                        QMLog.i("BookShelfInsertRequest", "", th5);
                    }
                }
                jSONObject.putOpt("key_result_data", jSONArray);
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("BookShelfInsertRequest", "onResponse fail." + e16);
            return null;
        }
    }
}

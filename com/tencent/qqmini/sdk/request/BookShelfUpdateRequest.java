package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf$Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StUpdateBookShelfReadTimeReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StUpdateBookShelfReadTimeRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BookShelfUpdateRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "BookShelfUpdateRequest";
    private MiniBookShelf$StUpdateBookShelfReadTimeReq req;

    public BookShelfUpdateRequest(String str, String str2, String str3) {
        MiniBookShelf$StUpdateBookShelfReadTimeReq miniBookShelf$StUpdateBookShelfReadTimeReq = new MiniBookShelf$StUpdateBookShelfReadTimeReq();
        this.req = miniBookShelf$StUpdateBookShelfReadTimeReq;
        miniBookShelf$StUpdateBookShelfReadTimeReq.appid.set(str);
        this.req.category.set(str2);
        this.req.contentId.set(str3);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "UpdateBookShelfReadTime";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public String getCmdString() {
        return "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
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
            MiniBookShelf$StUpdateBookShelfReadTimeRsp miniBookShelf$StUpdateBookShelfReadTimeRsp = new MiniBookShelf$StUpdateBookShelfReadTimeRsp();
            miniBookShelf$StUpdateBookShelfReadTimeRsp.mergeFrom(bArr);
            MiniBookShelf$Information miniBookShelf$Information = miniBookShelf$StUpdateBookShelfReadTimeRsp.updateInfo.get();
            if (miniBookShelf$Information != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("contendId", miniBookShelf$Information.contentId.get());
                    jSONObject2.putOpt("status", Integer.valueOf(miniBookShelf$Information.status.get()));
                    jSONObject2.putOpt("msg", miniBookShelf$Information.f24952msg.get());
                    jSONObject2.putOpt("exist", Integer.valueOf(miniBookShelf$Information.existStatus.get()));
                } catch (Throwable th5) {
                    QMLog.i("BookShelfUpdateRequest", "", th5);
                }
                jSONObject.putOpt("key_result_data", jSONObject2);
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("BookShelfUpdateRequest", "onResponse fail." + e16);
            return null;
        }
    }
}

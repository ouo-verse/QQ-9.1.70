package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf$StUpdateBookShelfReadTimeReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StUpdateBookShelfReadTimeRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BookShelfUpdateRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
    public static final String TAG = "BookShelfUpdateRequest";
    private MiniBookShelf$StUpdateBookShelfReadTimeReq req;

    public BookShelfUpdateRequest(String str, String str2, String str3) {
        MiniBookShelf$StUpdateBookShelfReadTimeReq miniBookShelf$StUpdateBookShelfReadTimeReq = new MiniBookShelf$StUpdateBookShelfReadTimeReq();
        this.req = miniBookShelf$StUpdateBookShelfReadTimeReq;
        miniBookShelf$StUpdateBookShelfReadTimeReq.appid.set(str);
        this.req.category.set(str2);
        this.req.contentId.set(str3);
    }

    public static MiniBookShelf$StUpdateBookShelfReadTimeRsp onResponse(byte[] bArr) {
        try {
            MiniBookShelf$StUpdateBookShelfReadTimeRsp miniBookShelf$StUpdateBookShelfReadTimeRsp = new MiniBookShelf$StUpdateBookShelfReadTimeRsp();
            miniBookShelf$StUpdateBookShelfReadTimeRsp.mergeFrom(bArr);
            return miniBookShelf$StUpdateBookShelfReadTimeRsp;
        } catch (Exception e16) {
            QLog.d("BookShelfUpdateRequest", 1, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}

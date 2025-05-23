package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf$StInsertBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StInsertBookShelfRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BookShelfInsertRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.InsertBookShelf";
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

    public static MiniBookShelf$StInsertBookShelfRsp onResponse(byte[] bArr) {
        try {
            MiniBookShelf$StInsertBookShelfRsp miniBookShelf$StInsertBookShelfRsp = new MiniBookShelf$StInsertBookShelfRsp();
            miniBookShelf$StInsertBookShelfRsp.mergeFrom(bArr);
            return miniBookShelf$StInsertBookShelfRsp;
        } catch (Exception e16) {
            QLog.d("BookShelfInsertRequest", 1, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}

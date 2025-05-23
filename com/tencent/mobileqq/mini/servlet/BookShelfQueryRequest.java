package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf$StQueryBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf$StQueryBookShelfRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BookShelfQueryRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.QueryBookShelf";
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

    public static MiniBookShelf$StQueryBookShelfRsp onResponse(byte[] bArr) {
        try {
            MiniBookShelf$StQueryBookShelfRsp miniBookShelf$StQueryBookShelfRsp = new MiniBookShelf$StQueryBookShelfRsp();
            miniBookShelf$StQueryBookShelfRsp.mergeFrom(bArr);
            return miniBookShelf$StQueryBookShelfRsp;
        } catch (Exception e16) {
            QLog.d("BookShelfQueryRequest", 1, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}

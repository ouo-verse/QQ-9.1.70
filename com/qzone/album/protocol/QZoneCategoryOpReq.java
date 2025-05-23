package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.CategoryOpReq;
import NS_MOBILE_PHOTO.CategoryOpRsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCategoryOpReq extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.CategoryOperator";
    public int opType;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f43901a;

        /* renamed from: b, reason: collision with root package name */
        public String f43902b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, String> f43903c;

        /* renamed from: d, reason: collision with root package name */
        public PhotoCategorySummaryInfo f43904d;
    }

    public QZoneCategoryOpReq(CategoryOpReq categoryOpReq) {
        super(FIELD_CMD);
        this.opType = 0;
        this.req = categoryOpReq;
        this.opType = categoryOpReq.f25024op;
    }

    public int getOpType() {
        return this.opType;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "CategoryOperator";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof CategoryOpRsp)) {
            return null;
        }
        a aVar = new a();
        CategoryOpRsp categoryOpRsp = (CategoryOpRsp) jceStruct;
        aVar.f43901a = categoryOpRsp.ret;
        aVar.f43903c = categoryOpRsp.oldkey_2_newkey;
        aVar.f43902b = categoryOpRsp.f25025msg;
        return aVar;
    }
}

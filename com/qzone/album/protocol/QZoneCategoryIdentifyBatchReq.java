package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.BatchGetSimilarGroupidReq;
import NS_MOBILE_PHOTO.BatchGetSimilarGroupidRsp;
import NS_MOBILE_PHOTO.PhotoInfos;
import NS_MOBILE_PHOTO.cluster_search_result;
import com.qq.taf.jce.JceStruct;
import com.qzone.proxy.feedcomponent.util.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCategoryIdentifyBatchReq extends AbsCompatRequest<a> {
    private static final String CMD = "asy_photo.BatchGetSimilarGroupid";
    private static final String TAG = "QZoneCategoryIdentifyBa";
    private static final String UIN_KEY = "BatchGetSimilarGroupid";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, ArrayList<cluster_search_result>> f43897a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f43898b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, Integer> f43899c;
    }

    public QZoneCategoryIdentifyBatchReq(long j3, ArrayList<float[]> arrayList, boolean z16) {
        super(CMD);
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            float[] fArr = arrayList.get(i3);
            ArrayList<Float> arrayList2 = new ArrayList<>(fArr.length);
            for (float f16 : fArr) {
                arrayList2.add(Float.valueOf(f16));
            }
            PhotoInfos photoInfos = new PhotoInfos();
            photoInfos.feature = arrayList2;
            photoInfos.mode = 1;
            photoInfos.img = "";
            hashMap.put(String.valueOf(i3), photoInfos);
        }
        j.f(TAG, "feature size = " + hashMap.size());
        this.req = new BatchGetSimilarGroupidReq(j3, hashMap, z16);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UIN_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        a aVar = new a();
        BatchGetSimilarGroupidRsp batchGetSimilarGroupidRsp = (BatchGetSimilarGroupidRsp) jceStruct;
        if (batchGetSimilarGroupidRsp.ret == 0) {
            aVar.f43897a = batchGetSimilarGroupidRsp.results;
            aVar.f43898b = batchGetSimilarGroupidRsp.new_groupids;
            aVar.f43899c = batchGetSimilarGroupidRsp.fails;
        }
        return aVar;
    }
}

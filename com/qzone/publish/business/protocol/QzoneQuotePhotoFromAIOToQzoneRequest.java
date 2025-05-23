package com.qzone.publish.business.protocol;

import NS_MOBILE_QUN.quote_photo_dst;
import NS_MOBILE_QUN.quote_photo_src;
import NS_MOBILE_QUN.quote_photo_universal_req;
import NS_MOBILE_QUN.s_quote_photo_info;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.image.NetImageInfo;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class QzoneQuotePhotoFromAIOToQzoneRequest extends QZoneRequest {
    private static final String CMD_STRING = "quoteToQzoneFromAIO";
    private String mAlbumId;
    private String mAlbumName;
    private long mBatchId;
    private String mDescription;
    private ArrayList<NetImageInfo> mImagInfos;
    private long mSrcType;
    private long mSrcUin;

    public QzoneQuotePhotoFromAIOToQzoneRequest(String str, String str2, long j3, String str3, ArrayList<NetImageInfo> arrayList, long j16, long j17) {
        super(CMD_STRING);
        this.mAlbumId = str;
        this.mAlbumName = str2;
        this.mBatchId = j3;
        this.mDescription = str3;
        this.mImagInfos = arrayList;
        this.mSrcUin = j16;
        this.mSrcType = j17;
        setRequest();
    }

    private quote_photo_dst getQuotePhotoDst() {
        String str;
        quote_photo_dst quote_photo_dstVar = new quote_photo_dst();
        quote_photo_dstVar.dst_type = 3;
        quote_photo_dstVar.albumid = this.mAlbumId;
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhoneAlbum", "\u624b\u673a\u76f8\u518c");
        if (TextUtils.isEmpty(this.mAlbumId) && (str = this.mAlbumName) != null && str.equals(config)) {
            quote_photo_dstVar.albumhandset = 1L;
        }
        quote_photo_dstVar.batchid = this.mBatchId;
        quote_photo_dstVar.desc = this.mDescription;
        return quote_photo_dstVar;
    }

    private ArrayList<s_quote_photo_info> getQuotePhotoInfos() {
        ArrayList<NetImageInfo> arrayList = this.mImagInfos;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<s_quote_photo_info> arrayList2 = new ArrayList<>();
        Iterator<NetImageInfo> it = this.mImagInfos.iterator();
        while (it.hasNext()) {
            NetImageInfo next = it.next();
            s_quote_photo_info s_quote_photo_infoVar = new s_quote_photo_info();
            s_quote_photo_infoVar.url = next.mBigPath;
            s_quote_photo_infoVar.uuid = next.mUuid;
            s_quote_photo_infoVar.msgtime = next.mMsgTime;
            s_quote_photo_infoVar.chatSrcUin = LoginData.getInstance().getUin();
            s_quote_photo_infoVar.chatDstUin = LoginData.getInstance().getUin();
            s_quote_photo_infoVar.groupUin = next.mTroopCode;
            s_quote_photo_infoVar.qunPicFileID = next.mFileid;
            arrayList2.add(s_quote_photo_infoVar);
        }
        return arrayList2;
    }

    private quote_photo_src getQuotePhotoSrc() {
        quote_photo_src quote_photo_srcVar = new quote_photo_src();
        long j3 = this.mSrcType;
        if (j3 == 1) {
            quote_photo_srcVar.src_type = 1;
        } else if (j3 == 2) {
            quote_photo_srcVar.src_type = 2;
        } else {
            quote_photo_srcVar.src_type = 2;
        }
        return quote_photo_srcVar;
    }

    private void setRequest() {
        quote_photo_universal_req quote_photo_universal_reqVar = new quote_photo_universal_req();
        quote_photo_src quotePhotoSrc = getQuotePhotoSrc();
        if (quotePhotoSrc != null) {
            quote_photo_universal_reqVar.quote_src = quotePhotoSrc;
        }
        quote_photo_dst quotePhotoDst = getQuotePhotoDst();
        if (quotePhotoDst != null) {
            quote_photo_universal_reqVar.quote_dst = quotePhotoDst;
        }
        ArrayList<s_quote_photo_info> quotePhotoInfos = getQuotePhotoInfos();
        if (quotePhotoInfos != null && quotePhotoInfos.size() > 0) {
            quote_photo_universal_reqVar.photos = quotePhotoInfos;
        }
        this.req = quote_photo_universal_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return getRequestCmd();
    }
}

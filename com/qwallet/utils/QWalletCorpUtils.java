package com.qwallet.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.zxing.common.BitMatrix;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tenpay.sdk.util.QRCodeUtils;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qwallet.plugin.ipc.BaseResp;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletCorpUtils {
    static final int REQ_ID_DELETEOB = 8;
    static final int REQ_ID_DNS = 18;
    static final int REQ_ID_GETFACEFILE = 1;
    static final int REQ_ID_GETQRCODE = 2;
    static final int REQ_ID_GETQRCODEGET = 4;
    static final int REQ_ID_GETQRCODEWIDTH = 3;
    static final int REQ_ID_GET_RESOURCE_ARRAY = 7;
    static final int REQ_ID_GET_TROOP_NICK = 6;
    static final int REQ_ID_OPEN_SENDHB = 17;

    public QWalletCorpUtils(Integer num, ResultReceiver resultReceiver, Bundle bundle) {
        int intValue = num.intValue();
        if (intValue == 1) {
            reqFaceFilePath(resultReceiver, bundle);
        } else if (intValue == 8) {
            reqDeleteOB(resultReceiver, bundle);
        } else {
            if (intValue != 17) {
                return;
            }
            reqSendHbPage(resultReceiver, bundle);
        }
    }

    public static String a(String str) {
        if (str.equals("marblema-test")) {
            return "marblema-test-return";
        }
        try {
            return SecurityUtile.decode(str);
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private void reqDeleteOB(ResultReceiver resultReceiver, Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 6;
        QWalletUtils.u(corpReq);
    }

    private void reqFaceFilePath(final ResultReceiver resultReceiver, Bundle bundle) {
        final String string = bundle.getString("uin");
        final int i3 = bundle.getInt("faceType", 1);
        final int i16 = bundle.getInt(QCircleLpReportDc010001.KEY_SUBTYPE, 200);
        if (i3 == 32) {
            CorpReq corpReq = new CorpReq();
            CorpReq.corpReqType = 2;
            corpReq.fromReceiver = new ResultReceiver(new Handler()) { // from class: com.qwallet.utils.QWalletCorpUtils.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i17, Bundle bundle2) {
                    BaseResp resp = BaseResp.getResp(bundle2);
                    if (resp != null && (resp instanceof CorpResp)) {
                        CorpReq corpReq2 = new CorpReq();
                        CorpReq.corpReqType = 1;
                        if (((CorpResp) resp).isFriend) {
                            corpReq2.faceType = 1;
                        } else {
                            corpReq2.faceType = i3;
                        }
                        corpReq2.fromReceiver = resultReceiver;
                        corpReq2.subType = i16;
                        corpReq2.uin = string;
                        QWalletUtils.u(corpReq2);
                    }
                }
            };
            corpReq.faceType = i3;
            corpReq.subType = i16;
            corpReq.uin = string;
            QWalletUtils.u(corpReq);
            return;
        }
        CorpReq corpReq2 = new CorpReq();
        CorpReq.corpReqType = 1;
        corpReq2.fromReceiver = resultReceiver;
        corpReq2.faceType = i3;
        corpReq2.subType = i16;
        corpReq2.uin = string;
        QWalletUtils.u(corpReq2);
    }

    private void reqSendHbPage(ResultReceiver resultReceiver, Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 13;
        corpReq.fromReceiver = resultReceiver;
        corpReq.data = bundle;
        QWalletUtils.u(corpReq);
    }

    private void respFaceFilePath(Bundle bundle, Bundle bundle2) {
        BaseResp resp = BaseResp.getResp(bundle);
        if (resp != null && (resp instanceof CorpResp)) {
            CorpResp corpResp = (CorpResp) resp;
            if (corpResp.corpReqType == 1) {
                bundle2.putString("faceFilePath", corpResp.faceFilePath);
                bundle2.putString(PhotoCategorySummaryInfo.FACEUIN, corpResp.memUin);
            }
        }
    }

    public QWalletCorpUtils(Integer num, Bundle bundle, Bundle bundle2) {
        if (num.intValue() != 1) {
            return;
        }
        respFaceFilePath(bundle, bundle2);
    }

    public QWalletCorpUtils(Integer num, Bundle bundle, List<Object> list) {
        if (num.intValue() != 2) {
            return;
        }
        list.add(QRCodeUtils.encode(bundle.getString("data"), bundle.getInt("size", -1)));
    }

    public QWalletCorpUtils(Integer num, List<Object> list, List<Object> list2) {
        int intValue = num.intValue();
        if (intValue == 3) {
            list2.add(Integer.valueOf(((BitMatrix) list.get(0)).getWidth()));
        } else {
            if (intValue != 4) {
                return;
            }
            list2.add(Boolean.valueOf(((BitMatrix) list.get(0)).get(((Integer) list.get(1)).intValue(), ((Integer) list.get(2)).intValue())));
        }
    }
}

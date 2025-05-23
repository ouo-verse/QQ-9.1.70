package com.tencent.biz.pubaccount.subscript;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439$ArticleInfo;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439$ReqBody;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439$RspBody;
import tencent.im.oidb.cmd0x439.oidb_cmd0x439$SubscribeInfo;
import tencent.im.oidb.cmd0x472.Oidb_0x472$ArticleSummary;
import tencent.im.oidb.cmd0x472.Oidb_0x472$RspBody;
import tencent.im.oidb.cmd0x472.Oidb_0x472$RspChannelArticle;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes4.dex */
public class SubscriptHandler extends BusinessHandler {
    public SubscriptHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
    }

    public static ReadInJoyArticle D2(Oidb_0x472$ArticleSummary oidb_0x472$ArticleSummary, int i3) {
        if (oidb_0x472$ArticleSummary == null) {
            return null;
        }
        ReadInJoyArticle readInJoyArticle = new ReadInJoyArticle();
        readInJoyArticle.mChannelID = i3;
        if (oidb_0x472$ArticleSummary.uint64_article_id.has()) {
            readInJoyArticle.mArticleID = oidb_0x472$ArticleSummary.uint64_article_id.get();
        }
        if (oidb_0x472$ArticleSummary.bytes_article_title.has() && oidb_0x472$ArticleSummary.bytes_article_title.get() != null) {
            readInJoyArticle.mTitle = oidb_0x472$ArticleSummary.bytes_article_title.get().toStringUtf8();
        }
        if (oidb_0x472$ArticleSummary.bytes_article_summary.has() && oidb_0x472$ArticleSummary.bytes_article_summary.get() != null) {
            readInJoyArticle.mSummary = oidb_0x472$ArticleSummary.bytes_article_summary.get().toStringUtf8();
        }
        if (oidb_0x472$ArticleSummary.bytes_first_page_pic_url.has() && oidb_0x472$ArticleSummary.bytes_first_page_pic_url.get() != null) {
            readInJoyArticle.mFirstPagePicUrl = oidb_0x472$ArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
        }
        return readInJoyArticle;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        Exception e16;
        List<Oidb_0x472$ArticleSummary> list;
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z18 = true;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubscriptHandler", 2, "handleGetReadinjoyRecommentList onReceive :" + z16);
        }
        ArrayList arrayList = null;
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e("SubscriptHandler", 2, "result: " + i3);
                    }
                    if (z17) {
                        byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                        Oidb_0x472$RspBody oidb_0x472$RspBody = new Oidb_0x472$RspBody();
                        oidb_0x472$RspBody.mergeFrom(byteArray);
                        if (oidb_0x472$RspBody.rspChannelArticle.has()) {
                            try {
                                Oidb_0x472$RspChannelArticle oidb_0x472$RspChannelArticle = oidb_0x472$RspBody.rspChannelArticle.get();
                                if (oidb_0x472$RspChannelArticle != null) {
                                    long j3 = oidb_0x472$RspChannelArticle.uint64_channel_id.get();
                                    if (j3 == 0 && (list = oidb_0x472$RspChannelArticle.rpt_article_list.get()) != null && !list.isEmpty()) {
                                        ArrayList arrayList2 = new ArrayList(list.size());
                                        try {
                                            Iterator<Oidb_0x472$ArticleSummary> it = list.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(D2(it.next(), (int) j3));
                                            }
                                            arrayList = arrayList2;
                                            z16 = z18;
                                        } catch (Exception e17) {
                                            e16 = e17;
                                            arrayList = arrayList2;
                                            z17 = false;
                                            if (QLog.isColorLevel()) {
                                                QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail: ", e16);
                                            }
                                            z16 = z17;
                                            if (!z16) {
                                            }
                                            super.notifyUI(2, z16, arrayList);
                                        }
                                    }
                                }
                                z18 = false;
                                z16 = z18;
                            } catch (Exception e18) {
                                e16 = e18;
                            }
                        }
                    }
                    z18 = z17;
                    z16 = z18;
                } catch (Exception e19) {
                    e16 = e19;
                }
            } catch (Exception e26) {
                z17 = z16;
                e16 = e26;
            }
        }
        if (!z16) {
            arrayList = new ArrayList(0);
        }
        super.notifyUI(2, z16, arrayList);
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        ArrayList arrayList;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubscriptHandler", 2, "handleGetRecommendList onReceive :" + z16);
        }
        if (!z16) {
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                oidb_cmd0x439$RspBody oidb_cmd0x439_rspbody = new oidb_cmd0x439$RspBody();
                oidb_cmd0x439_rspbody.mergeFrom(byteArray);
                String str = "";
                if (oidb_cmd0x439_rspbody.bytes_subscribe_detail_url_pre.has() && oidb_cmd0x439_rspbody.bytes_subscribe_detail_url_pre.get() != null) {
                    str = oidb_cmd0x439_rspbody.bytes_subscribe_detail_url_pre.get().toStringUtf8();
                }
                if (oidb_cmd0x439_rspbody.rpt_msg_subscribe_info.has() && oidb_cmd0x439_rspbody.rpt_msg_subscribe_info.get() != null) {
                    List<oidb_cmd0x439$SubscribeInfo> list = oidb_cmd0x439_rspbody.rpt_msg_subscribe_info.get();
                    arrayList = new ArrayList(list.size());
                    for (oidb_cmd0x439$SubscribeInfo oidb_cmd0x439_subscribeinfo : list) {
                        d dVar = new d();
                        if (oidb_cmd0x439_subscribeinfo.uint64_subscribe_id.has()) {
                            long j3 = oidb_cmd0x439_subscribeinfo.uint64_subscribe_id.get();
                            dVar.f80098a = j3;
                            if (j3 > 0 && !TextUtils.isEmpty(str)) {
                                dVar.f80104g = str + dVar.f80098a;
                            }
                        }
                        if (oidb_cmd0x439_subscribeinfo.bytes_subscribe_name.has() && oidb_cmd0x439_subscribeinfo.bytes_subscribe_name.get() != null) {
                            dVar.f80099b = oidb_cmd0x439_subscribeinfo.bytes_subscribe_name.get().toStringUtf8();
                        }
                        if (oidb_cmd0x439_subscribeinfo.rpt_article_list.has() && oidb_cmd0x439_subscribeinfo.rpt_article_list.get() != null) {
                            List<oidb_cmd0x439$ArticleInfo> list2 = oidb_cmd0x439_subscribeinfo.rpt_article_list.get();
                            if (!list2.isEmpty()) {
                                ReadInJoyArticle readInJoyArticle = new ReadInJoyArticle();
                                oidb_cmd0x439$ArticleInfo oidb_cmd0x439_articleinfo = list2.get(0);
                                if (oidb_cmd0x439_articleinfo.uint64_article_id.has()) {
                                    readInJoyArticle.mArticleID = oidb_cmd0x439_articleinfo.uint64_article_id.get();
                                }
                                if (oidb_cmd0x439_articleinfo.bytes_article_subject.has() && oidb_cmd0x439_articleinfo.bytes_article_subject.get() != null) {
                                    readInJoyArticle.mTitle = oidb_cmd0x439_articleinfo.bytes_article_subject.get().toStringUtf8();
                                }
                                if (oidb_cmd0x439_articleinfo.bytes_article_url.has() && oidb_cmd0x439_articleinfo.bytes_article_url.get() != null) {
                                    readInJoyArticle.mArticleUrl = oidb_cmd0x439_articleinfo.bytes_article_url.get().toStringUtf8();
                                }
                                if (oidb_cmd0x439_articleinfo.bytes_article_sum_pic.has() && oidb_cmd0x439_articleinfo.bytes_article_sum_pic.get() != null) {
                                    readInJoyArticle.mFirstPagePicUrl = oidb_cmd0x439_articleinfo.bytes_article_sum_pic.get().toStringUtf8();
                                }
                                dVar.f80102e = readInJoyArticle;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("SubscriptHandler", 2, "handleGetRecommendList create SubscriptRecommendAccountInfo id: " + dVar.f80098a + " | name: " + dVar.f80099b + " | article: " + dVar.f80102e.mTitle);
                        }
                        arrayList.add(dVar);
                    }
                    z17 = true;
                } else {
                    arrayList = null;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    super.notifyUI(1, z17, arrayList);
                } else if (QLog.isColorLevel()) {
                    QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail, list is null");
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SubscriptHandler", 2, "handleGetRecommendList onReceive fail: ", e16);
            }
        }
    }

    public void E2(String str) {
        int i3 = 4;
        if (QLog.isDevelopLevel()) {
            QLog.d("SubscriptHandler", 4, "getRecommendListAsync() start uinStr: " + str);
        }
        oidb_cmd0x439$ReqBody oidb_cmd0x439_reqbody = new oidb_cmd0x439$ReqBody();
        oidb_cmd0x439_reqbody.uint32_want_count.set(0);
        int i16 = 1;
        oidb_cmd0x439_reqbody.uint32_req_subscribe_info.set(1);
        oidb_cmd0x439_reqbody.uint32_req_article_info.set(1);
        oidb_cmd0x439_reqbody.uint32_version.set(1);
        oidb_cmd0x439_reqbody.uint32_comefrom.set(2);
        int b16 = com.tencent.mqpsdk.util.a.b(null);
        if (b16 != 1) {
            if (b16 != 2) {
                i16 = 3;
                if (b16 != 3) {
                    if (b16 != 4) {
                        i3 = 0;
                    }
                } else {
                    i3 = 2;
                }
            }
            i3 = i16;
        }
        oidb_cmd0x439_reqbody.uint32_network_type.set(i3);
        super.sendPbReq(super.makeOIDBPkg("OidbSvc.1081", 1081, 0, oidb_cmd0x439_reqbody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.1081".equalsIgnoreCase(serviceCmd)) {
            G2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x472".equalsIgnoreCase(serviceCmd)) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}

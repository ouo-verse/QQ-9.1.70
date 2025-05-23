package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ab;
import com.tencent.mobileqq.shortvideo.p;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.shortvideo.y;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l extends com.tencent.mobileqq.multimsg.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final String f251648b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends ab.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ArrayList<Integer> f251649a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f251650b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ HashMap f251651c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f251652d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f251653e;

        a(ArrayList arrayList, HashMap hashMap, d dVar, h hVar) {
            this.f251650b = arrayList;
            this.f251651c = hashMap;
            this.f251652d = dVar;
            this.f251653e = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, l.this, arrayList, hashMap, dVar, hVar);
            } else {
                this.f251649a = null;
            }
        }

        private void d(int i3) {
            if (this.f251649a == null) {
                this.f251649a = new ArrayList<>();
            }
            this.f251649a.add(Integer.valueOf(i3));
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void b(int i3, ArrayList<y> arrayList) {
            boolean z16;
            boolean z17;
            boolean z18;
            m.a aVar;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
                return;
            }
            if (i3 == 0 && arrayList != null && arrayList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult success[" + arrayList.size() + "]");
                }
                int i16 = 0;
                z17 = false;
                for (int i17 = 0; i17 < this.f251650b.size(); i17++) {
                    MessageRecord messageRecord = (MessageRecord) this.f251650b.get(i17);
                    if (i16 >= arrayList.size()) {
                        QLog.e("VideoMultiMsgProcessor", 1, "MultiForwardVideo: error index!");
                    } else {
                        y yVar = arrayList.get(i16);
                        if (yVar != null) {
                            int i18 = yVar.f288328a;
                            if (i18 == 0 && (obj = yVar.f288331d) != null && (obj instanceof im_msg_body$RichText)) {
                                ((MessageForShortVideo) messageRecord).richText = (im_msg_body$RichText) obj;
                            } else if (i18 == -1 && (aVar = yVar.f288329b) != null) {
                                if ("cancel".equals(aVar.f258737b)) {
                                    d(1);
                                } else {
                                    d(yVar.f288329b.f258738c);
                                    if (!l.this.b(yVar.f288329b.f258738c)) {
                                        MessageRecord c16 = l.this.f251587a.getMultiMessageProxy().c(messageRecord, l.f251648b, true);
                                        QLog.e("VideoMultiMsgProcessor", 1, String.format("MultiForwardVideo errCode:%d, errStr:%s, update:%s, uniseq:%d", Integer.valueOf(yVar.f288329b.f258738c), yVar.f288329b.f258737b, Boolean.valueOf(l.this.f251587a.getMultiMessageProxy().C(this.f251651c, c16)), Long.valueOf(c16.uniseq)));
                                    }
                                }
                                z17 = true;
                            }
                        }
                        i16++;
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("totalCount", String.valueOf(arrayList.size()));
                ArrayList<Integer> arrayList2 = this.f251649a;
                if (arrayList2 != null) {
                    hashMap.put("errCount", String.valueOf(arrayList2.size()));
                    hashMap.put("errCodeStr", Arrays.asList(this.f251649a).toString());
                    hashMap.put("errCode", String.valueOf(this.f251649a.get(0)));
                } else {
                    hashMap.put("errCount", "0");
                    hashMap.put("errCode", "0");
                }
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (this.f251649a == null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                statisticCollector.collectPerformance(null, "MultiMsgVideoSendResult", z18, 0L, arrayList.size(), hashMap, null);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoMultiMsgProcessor", 2, "onMultiForwardVideoUploadResult failed!");
                }
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(BaseApplication.getContext());
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector2.collectPerformance(null, "MultiMsgVideoSendFail", z16, 0L, 0L, null, null);
                z17 = false;
            }
            if (z17) {
                this.f251652d.c(1, 8, this.f251653e);
            } else {
                this.f251652d.c(0, 8, this.f251653e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73192);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f251648b = HardCodeUtil.qqStr(R.string.v5b);
        }
    }

    public l(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void d(HashMap<String, ArrayList<MessageRecord>> hashMap, ArrayList<MessageForShortVideo> arrayList, ArrayList<p> arrayList2, v vVar, h hVar, d dVar) {
        if (vVar == null) {
            vVar = com.tencent.mobileqq.shortvideo.h.b(5, 5);
        }
        vVar.f(arrayList2);
        vVar.h(new a(arrayList, hashMap, dVar, hVar));
        com.tencent.mobileqq.shortvideo.l.e(vVar, this.f251587a);
    }

    @Override // com.tencent.mobileqq.multimsg.a, com.tencent.mobileqq.multimsg.c
    public void a(h hVar, HashMap<String, ArrayList<MessageRecord>> hashMap, d dVar) {
        MessageForShortVideo messageForShortVideo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, hVar, hashMap, dVar);
            return;
        }
        ArrayList<p> arrayList = new ArrayList<>();
        ArrayList<MessageForShortVideo> arrayList2 = new ArrayList<>();
        Iterator<String> it = hashMap.keySet().iterator();
        v vVar = null;
        while (it.hasNext()) {
            Iterator<MessageRecord> it5 = hashMap.get(it.next()).iterator();
            while (it5.hasNext()) {
                MessageRecord next = it5.next();
                if (!(next instanceof MessageForShortVideo)) {
                    if (next instanceof MessageForReplyText) {
                        MessageForReplyText messageForReplyText = (MessageForReplyText) next;
                        if (messageForReplyText.getSourceMessage() != null && (messageForReplyText.getSourceMessage() instanceof MessageForShortVideo)) {
                        }
                    }
                }
                if (next instanceof MessageForReplyText) {
                    if (QLog.isColorLevel()) {
                        QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]MessageForReplyText source");
                    }
                    MessageRecord sourceMessage = ((MessageForReplyText) next).getSourceMessage();
                    sourceMessage.createMessageUniseq();
                    messageForShortVideo = (MessageForShortVideo) sourceMessage;
                } else {
                    messageForShortVideo = (MessageForShortVideo) next;
                }
                messageForShortVideo.videoFileName = ShortVideoUtils.findVideoPathIfExists(messageForShortVideo);
                if (vVar == null) {
                    vVar = com.tencent.mobileqq.shortvideo.h.b(5, 5);
                }
                p a16 = com.tencent.mobileqq.shortvideo.l.a(5, messageForShortVideo, vVar);
                if (a16 != null) {
                    arrayList.add(a16);
                    arrayList2.add(messageForShortVideo);
                } else if (QLog.isColorLevel()) {
                    QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
                }
            }
        }
        if (arrayList.size() > 0 && arrayList2.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload videos, count is [" + arrayList.size() + "], goto requestUploadVideos");
            }
            d(hashMap, arrayList2, arrayList, vVar, hVar, dVar);
            return;
        }
        dVar.c(0, 8, hVar);
    }
}

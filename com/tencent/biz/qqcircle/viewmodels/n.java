package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class n extends a {
    private static int M;
    private static String N;
    private final MutableLiveData<String> C;
    private final MutableLiveData<String> D;
    private final MutableLiveData<Integer> E;
    private final MutableLiveData<Boolean> F;
    private final HashMap<String, Integer> G;
    private final MutableLiveData<UIStateData<List<FeedCloudMeta$StComment>>> H;
    private final MutableLiveData<Boolean> I;
    private final MutableLiveData<FeedCloudMeta$StFeed> J;
    private final MutableLiveData<UIStateData<List<QFSCommentItemInfo>>> K;
    private final MutableLiveData<Boolean> L;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f92872m;

    public n() {
        Boolean bool = Boolean.FALSE;
        this.f92872m = new MutableLiveData<>(bool);
        this.C = new MutableLiveData<>("");
        this.D = new MutableLiveData<>("");
        this.E = new MutableLiveData<>(0);
        this.F = new MutableLiveData<>(bool);
        this.G = new HashMap<>();
        this.H = new MutableLiveData<>(UIStateData.obtainEmpty());
        this.I = new MutableLiveData<>(bool);
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>(UIStateData.obtainEmpty());
        this.L = new MutableLiveData<>(bool);
    }

    private <T> UIStateData<List<T>> L1(UIStateData<List<T>> uIStateData, T t16, int i3) {
        if (uIStateData != null && uIStateData.getData() != null && i3 <= uIStateData.getData().size()) {
            uIStateData.getData().add(i3, t16);
            uIStateData.setPos(i3).setMsg("add_fake_comment").setState(8);
        }
        return uIStateData;
    }

    private void P1(List<FeedCloudMeta$StComment> list, List<QFSCommentItemInfo> list2, int i3) {
        if (list != null && list2 != null) {
            if (!com.tencent.biz.qqcircle.helpers.h.a().c()) {
                QLog.e("QFSCommentBlockViewModel", 1, "[showFeedbackCard] resDownload error. ");
                com.tencent.biz.qqcircle.helpers.h.a().d();
                return;
            }
            int i16 = M;
            com.tencent.biz.qqcircle.helpers.g gVar = com.tencent.biz.qqcircle.helpers.g.f84619a;
            if (i16 < gVar.c() || !gVar.a(this.contextHashCode)) {
                return;
            }
            int size = list.size();
            int i17 = size - i3;
            int d16 = gVar.d();
            if (size >= d16 && i17 < d16) {
                QLog.e("QFSCommentBlockViewModel", 1, "[tryAddFeedBackCard] real add");
                FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
                feedCloudMeta$StComment.f398447id.set("feedback_card_id");
                list.add(d16, feedCloudMeta$StComment);
                list2.add(d16, new QFSCommentItemInfo(feedCloudMeta$StComment));
            }
        }
    }

    private int T1(String str, QFSCommentItemInfo qFSCommentItemInfo) {
        String str2;
        if (qFSCommentItemInfo.replyItemList == null) {
            QLog.e("QFSCommentBlockViewModel", 1, "[deleteCacheReply] comment is null.");
            return -1;
        }
        for (int i3 = 0; i3 < qFSCommentItemInfo.replyItemList.size(); i3++) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.replyItemList.get(i3).reply;
            if (feedCloudMeta$StReply != null && str.equals(feedCloudMeta$StReply.f398460id.get())) {
                FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
                if (feedCloudMeta$StComment != null) {
                    str2 = feedCloudMeta$StComment.f398447id.get();
                } else {
                    str2 = "";
                }
                qFSCommentItemInfo.removeReplyItemInfo(str, j2(str2));
                return i3;
            }
        }
        return -1;
    }

    private void X1(String str, QFSCommentItemInfo qFSCommentItemInfo) {
        if (qFSCommentItemInfo.comment == null) {
            QLog.e("QFSCommentBlockViewModel", 1, "[deleteSourceReply] comment is null.");
            return;
        }
        for (int i3 = 0; i3 < qFSCommentItemInfo.comment.vecReply.get().size(); i3++) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.comment.vecReply.get(i3);
            if (feedCloudMeta$StReply != null && str.equals(feedCloudMeta$StReply.f398460id.get())) {
                qFSCommentItemInfo.comment.vecReply.remove(i3);
                qFSCommentItemInfo.comment.replyCount.set(qFSCommentItemInfo.comment.replyCount.get() - 1);
                return;
            }
        }
    }

    private int i2(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return 0;
        }
        return feedCloudMeta$StComment.replyCount.get();
    }

    private int j2(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || !this.G.containsKey(str) || (num = this.G.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    private List<QFSCommentItemInfo> s2(List<FeedCloudMeta$StComment> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
            QFSCommentItemInfo qFSCommentItemInfo = new QFSCommentItemInfo(feedCloudMeta$StComment);
            int size = feedCloudMeta$StComment.vecReply.size();
            this.G.put(feedCloudMeta$StComment.f398447id.get(), Integer.valueOf(size));
            for (int i3 = 0; i3 < size; i3++) {
                qFSCommentItemInfo.addReplyItemInfo(5, feedCloudMeta$StComment.vecReply.get(i3));
            }
            if (size < i2(feedCloudMeta$StComment)) {
                qFSCommentItemInfo.addReplyItemInfo(6, i2(feedCloudMeta$StComment) - size);
            }
            arrayList.add(qFSCommentItemInfo);
        }
        return arrayList;
    }

    public void M1(boolean z16, int i3, List<FeedCloudMeta$StComment> list) {
        int size = list.size();
        List<QFSCommentItemInfo> s26 = s2(list);
        if (z16) {
            UIStateData<List<FeedCloudMeta$StComment>> value = this.H.getValue();
            if (value != null && !RFSafeListUtils.isEmpty(value.getData())) {
                this.H.getValue().getData().addAll(list);
                list = this.H.getValue().getData();
            }
            UIStateData<List<QFSCommentItemInfo>> value2 = this.K.getValue();
            if (value2 != null && !RFSafeListUtils.isEmpty(value2.getData())) {
                this.K.getValue().getData().addAll(s26);
                s26 = this.K.getValue().getData();
            }
        }
        P1(list, s26, size);
        this.H.setValue(UIStateData.obtainSuccess(false).setPos(i3).setData(z16, list));
        this.K.setValue(UIStateData.obtainSuccess(false).setPos(i3).setData(z16, s26));
    }

    public void N1(FeedCloudMeta$StComment feedCloudMeta$StComment, com.tencent.biz.qqcircle.comment.effect.d dVar) {
        boolean l26 = l2();
        this.H.setValue(L1(e2().getValue(), feedCloudMeta$StComment, l26 ? 1 : 0));
        this.K.setValue(L1(c2().getValue(), new QFSCommentItemInfo(feedCloudMeta$StComment, dVar), l26 ? 1 : 0));
    }

    public void O1(String str, String str2, FeedCloudMeta$StReply feedCloudMeta$StReply, com.tencent.biz.qqcircle.comment.effect.d dVar) {
        List<QFSCommentItemInfo> data;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UIStateData<List<QFSCommentItemInfo>> value = this.K.getValue();
        if (value == null) {
            data = new ArrayList<>();
        } else {
            data = value.getData();
        }
        if (RFSafeListUtils.isEmpty(data)) {
            QLog.e("QFSCommentBlockViewModel", 1, "[addFakeReply] commentData is empty. ");
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < data.size()) {
                QFSCommentItemInfo qFSCommentItemInfo = data.get(i3);
                FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
                if (feedCloudMeta$StComment != null && str.equals(feedCloudMeta$StComment.f398447id.get())) {
                    qFSCommentItemInfo.addFakeReply(str2, feedCloudMeta$StReply, dVar).mDefaultExpanded = true;
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1 && value != null) {
            value.setPos(i3).setMsg("add_fake_reply").setState(8);
            this.K.setValue(value);
        }
    }

    public void Q1(String str) {
        UIStateData<List<QFSCommentItemInfo>> value;
        if (!TextUtils.isEmpty(str) && (value = this.K.getValue()) != null && !RFSafeListUtils.isEmpty(value.getData())) {
            List<QFSCommentItemInfo> data = value.getData();
            int i3 = 0;
            while (true) {
                if (i3 < data.size()) {
                    QFSCommentItemInfo qFSCommentItemInfo = data.get(i3);
                    if (qFSCommentItemInfo != null && qFSCommentItemInfo.comment.f398447id.get().equals(str)) {
                        qFSCommentItemInfo.comment.typeFlag.set(0);
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                value.setMsg("cancel_sticky_comment").setPos(i3).setState(7);
                this.K.setValue(value);
            }
        }
    }

    public void R1() {
        this.L.postValue(Boolean.valueOf(ud2.a.f438849a.b()));
    }

    public void S1() {
        if (this.H.getValue() != null && this.H.getValue().getData() != null) {
            this.H.getValue().getData().clear();
        }
        if (this.K.getValue() != null && this.K.getValue().getData() != null) {
            this.K.getValue().getData().clear();
        }
    }

    public void U1(String str) {
        UIStateData<List<QFSCommentItemInfo>> value;
        if (!TextUtils.isEmpty(str) && (value = this.K.getValue()) != null && !RFSafeListUtils.isEmpty(value.getData())) {
            List<QFSCommentItemInfo> data = value.getData();
            int i3 = 0;
            while (true) {
                if (i3 < data.size()) {
                    FeedCloudMeta$StComment feedCloudMeta$StComment = data.get(i3).comment;
                    if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.f398447id.get().equals(str)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                RFSafeListUtils.remove(data, i3);
                value.setMsg("delete_comment").setPos(i3).setState(6);
                this.K.setValue(value);
                return;
            }
            QLog.e("QFSCommentBlockViewModel", 1, "[deleteComment] can not find comment.");
        }
    }

    public void W1(String str, String str2) {
        UIStateData<List<QFSCommentItemInfo>> value;
        int i3;
        List<QFSReplyItemInfo> list;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (value = this.K.getValue()) != null && !RFSafeListUtils.isEmpty(value.getData())) {
            List<QFSCommentItemInfo> data = value.getData();
            int i16 = 0;
            while (true) {
                if (i16 < data.size()) {
                    QFSCommentItemInfo qFSCommentItemInfo = data.get(i16);
                    FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
                    if (feedCloudMeta$StComment != null && str.equals(feedCloudMeta$StComment.f398447id.get()) && (list = qFSCommentItemInfo.replyItemList) != null && list.size() > 0) {
                        X1(str2, qFSCommentItemInfo);
                        i3 = T1(str2, qFSCommentItemInfo);
                        break;
                    }
                    i16++;
                } else {
                    i3 = -1;
                    i16 = -1;
                    break;
                }
            }
            if (i16 != -1) {
                value.setPos(i16).setType(i3).setMsg(QCircleDaTongConstant.ElementParamValue.DELETE_REPLY).setState(6);
                this.K.setValue(value);
            }
        }
    }

    public MutableLiveData<Boolean> Z1() {
        return this.f92872m;
    }

    public MutableLiveData<Integer> a2() {
        return this.E;
    }

    public MutableLiveData<FeedCloudMeta$StFeed> b2() {
        return this.J;
    }

    public LiveData<UIStateData<List<QFSCommentItemInfo>>> c2() {
        return this.K;
    }

    public MutableLiveData<String> d2() {
        return this.D;
    }

    public LiveData<UIStateData<List<FeedCloudMeta$StComment>>> e2() {
        return this.H;
    }

    public LiveData<Boolean> f2() {
        return this.L;
    }

    public MutableLiveData<Boolean> g2() {
        return this.I;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentBlockViewModel";
    }

    public LiveData<String> h2() {
        return this.C;
    }

    public MutableLiveData<Boolean> k2() {
        return this.F;
    }

    public boolean l2() {
        UIStateData<List<FeedCloudMeta$StComment>> value = e2().getValue();
        if (value == null || RFSafeListUtils.isEmpty(value.getData()) || value.getData().get(0).typeFlag.get() != 1) {
            return false;
        }
        return true;
    }

    public void m2() {
        ud2.a.f438849a.g();
        R1();
    }

    public void n2(String str) {
        ud2.a.f438849a.h(str);
        R1();
    }

    public void o2(String str) {
        if (!TextUtils.equals(N, str)) {
            M++;
        }
        N = str;
    }

    public void p2() {
        this.H.setValue(UIStateData.obtainEmpty());
        this.K.setValue(UIStateData.obtainEmpty());
    }

    public void q2(String str) {
        this.C.setValue(str);
    }

    public void r2(String str) {
        QFSCommentItemInfo qFSCommentItemInfo;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UIStateData<List<QFSCommentItemInfo>> value = this.K.getValue();
        UIStateData<List<FeedCloudMeta$StComment>> value2 = e2().getValue();
        if (value != null && !RFSafeListUtils.isEmpty(value.getData()) && value2 != null && !RFSafeListUtils.isEmpty(value2.getData())) {
            List<QFSCommentItemInfo> data = value.getData();
            List<FeedCloudMeta$StComment> data2 = value2.getData();
            if (data.get(0).comment == null) {
                QLog.e("QFSCommentBlockViewModel", 1, "[stickyComment] comment is null.");
                return;
            }
            if (data.get(0).comment.typeFlag.get() == 1) {
                data.get(0).comment.typeFlag.set(0);
            }
            int i3 = 0;
            while (true) {
                if (i3 < data.size()) {
                    qFSCommentItemInfo = data.get(i3);
                    if (qFSCommentItemInfo.comment.f398447id.get().equals(str)) {
                        qFSCommentItemInfo.comment.typeFlag.set(1);
                        break;
                    }
                    i3++;
                } else {
                    qFSCommentItemInfo = null;
                    i3 = -1;
                    break;
                }
            }
            QLog.d("QFSCommentBlockViewModel", 1, "[stickyComment] remove index: " + i3 + ", comment id: " + str);
            if (i3 != -1) {
                RFSafeListUtils.remove(data, i3);
                RFSafeListUtils.remove(data2, i3);
                data.add(0, qFSCommentItemInfo);
                data2.add(0, qFSCommentItemInfo.comment);
            }
            value.setMsg("sticky_comment").setPos(i3).setState(7);
            this.K.setValue(value);
            this.H.setValue(value2);
        }
    }

    public void t2(String str, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        UIStateData<List<FeedCloudMeta$StComment>> value;
        UIStateData<List<QFSCommentItemInfo>> value2;
        if (!TextUtils.isEmpty(str) && (value = this.H.getValue()) != null && !RFSafeListUtils.isEmpty(value.getData())) {
            List<FeedCloudMeta$StComment> data = value.getData();
            int i3 = 0;
            while (true) {
                if (i3 < data.size()) {
                    if (str.equals(data.get(i3).f398447id.get())) {
                        data.set(i3, feedCloudMeta$StComment);
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1 && (value2 = this.K.getValue()) != null && !RFSafeListUtils.isEmpty(value2.getData()) && i3 < value2.getData().size()) {
                value2.getData().get(i3).comment = feedCloudMeta$StComment;
                value2.setPos(i3).setState(7);
            }
        }
    }
}

package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.immersive.personal.bean.l;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleProfile$SetProfileReq;
import qqcircle.QQCircleProfile$SetProfileRsp;

/* loaded from: classes5.dex */
public class QCircleSetProfileRequest extends QCircleBaseRequest {
    private QQCircleProfile$SetProfileReq mReq;

    public QCircleSetProfileRequest() {
        this.mReq = new QQCircleProfile$SetProfileReq();
    }

    private void a(Object obj) {
        ArrayList<Long> arrayList;
        if (!(obj instanceof QFSPersonalEditViewModel.Group) || (arrayList = ((QFSPersonalEditViewModel.Group) obj).idList) == null) {
            return;
        }
        this.mReq.groupIDList.set(arrayList);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SetProfile";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    public void setPattonType(int i3) {
        List<Integer> list = this.mReq.infoTypes.get();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(10012);
        this.mReq.pattonType.set(i3);
        this.mReq.infoTypes.set(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleProfile$SetProfileRsp> messageMicro = new MessageMicro<QQCircleProfile$SetProfileRsp>() { // from class: qqcircle.QQCircleProfile$SetProfileRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, QQCircleProfile$SetProfileRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }

    public QCircleSetProfileRequest(String str, List<FeedCloudMeta$StTagInfo> list) {
        this.mReq = new QQCircleProfile$SetProfileReq();
        ArrayList arrayList = new ArrayList();
        arrayList.add(10008);
        arrayList.add(10011);
        this.mReq.infoTypes.set(arrayList);
        this.mReq.sign.set(str);
        if (list != null) {
            this.mReq.showTagList.set(list);
        }
    }

    public QCircleSetProfileRequest(String str, List<FeedCloudMeta$StTagInfo> list, List<Long> list2) {
        this(str, list);
        this.mReq.infoTypes.get().add(10015);
        if (list2 != null) {
            this.mReq.groupIDList.set(list2);
        }
    }

    public QCircleSetProfileRequest(int i3, Object obj) {
        QQCircleProfile$SetProfileReq qQCircleProfile$SetProfileReq = new QQCircleProfile$SetProfileReq();
        this.mReq = qQCircleProfile$SetProfileReq;
        qQCircleProfile$SetProfileReq.infoTypes.add(Integer.valueOf(i3));
        if (i3 == 10008) {
            this.mReq.sign.set(((QFSPersonalEditViewModel.FrequencyItem) obj).showText);
            return;
        }
        if (i3 == 10021) {
            this.mReq.guildId.set(((l) obj).a());
            return;
        }
        if (i3 == 10023) {
            this.mReq.hideSchool.set(((Integer) obj).intValue());
            return;
        }
        if (i3 != 10025) {
            switch (i3) {
                case 10001:
                    this.mReq.nick.set(((QFSPersonalEditViewModel.FrequencyItem) obj).showText);
                    return;
                case 10002:
                    this.mReq.gender.set(((Integer) obj).intValue());
                    return;
                case 10003:
                    QFSPersonalEditViewModel.e eVar = (QFSPersonalEditViewModel.e) obj;
                    this.mReq.location.set(eVar.f89126a);
                    this.mReq.locationCode.set(eVar.f89127b);
                    return;
                default:
                    switch (i3) {
                        case 10015:
                            a(obj);
                            return;
                        case 10016:
                            this.mReq.company.set((String) obj);
                            return;
                        case 10017:
                            this.mReq.constellation.set(((Integer) obj).intValue());
                            return;
                        case 10018:
                            this.mReq.school.set((String) obj);
                            return;
                        default:
                            return;
                    }
            }
        }
        this.mReq.logo.set(((QFSPersonalEditViewModel.FrequencyItem) obj).showText);
    }

    public QCircleSetProfileRequest(int i3, int i16) {
        QQCircleProfile$SetProfileReq qQCircleProfile$SetProfileReq = new QQCircleProfile$SetProfileReq();
        this.mReq = qQCircleProfile$SetProfileReq;
        qQCircleProfile$SetProfileReq.infoTypes.add(Integer.valueOf(i3));
        if (i3 != 10023) {
            return;
        }
        this.mReq.hideSchool.set(i16);
    }
}

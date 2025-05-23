package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public static AIORichMediaData a(AIOBrowserBaseData aIOBrowserBaseData) {
        if (aIOBrowserBaseData == null) {
            return null;
        }
        if (aIOBrowserBaseData instanceof AIOPictureData) {
            return h((AIOPictureData) aIOBrowserBaseData);
        }
        if (aIOBrowserBaseData instanceof AIOFilePictureData) {
            return c((AIOFilePictureData) aIOBrowserBaseData);
        }
        if (aIOBrowserBaseData instanceof AIOVideoData) {
            return j((AIOVideoData) aIOBrowserBaseData);
        }
        if (!(aIOBrowserBaseData instanceof AIOFileVideoData)) {
            return null;
        }
        return e((AIOFileVideoData) aIOBrowserBaseData);
    }

    public static AIOBrowserBaseData[] b(AIORichMediaData[] aIORichMediaDataArr) {
        if (aIORichMediaDataArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AIORichMediaData aIORichMediaData : aIORichMediaDataArr) {
            AIOBrowserBaseData g16 = g(aIORichMediaData);
            if (g16 != null) {
                arrayList.add(g16);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return (AIOBrowserBaseData[]) arrayList.toArray(new AIOBrowserBaseData[arrayList.size()]);
    }

    public static AIOFilePicData c(AIOFilePictureData aIOFilePictureData) {
        AIOFilePicData aIOFilePicData = new AIOFilePicData();
        aIOFilePicData.f179628d = aIOFilePictureData.msgId;
        aIOFilePicData.f179629e = aIOFilePictureData.subId;
        aIOFilePicData.f179630f = aIOFilePictureData.time;
        aIOFilePicData.f179631h = aIOFilePictureData.size;
        aIOFilePicData.f179632i = aIOFilePictureData.shmsgseq;
        aIOFilePicData.f179633m = aIOFilePictureData.istroop;
        aIOFilePicData.C = aIOFilePictureData.isMultiMsg;
        aIOFilePicData.G = aIOFilePictureData.f281831d;
        aIOFilePicData.H = aIOFilePictureData.f281832e;
        aIOFilePicData.I = aIOFilePictureData.f281833f;
        aIOFilePicData.J = aIOFilePictureData.f281834h;
        aIOFilePicData.K = aIOFilePictureData.f281835i;
        aIOFilePicData.V = aIOFilePictureData.H;
        aIOFilePicData.Q = aIOFilePictureData.E;
        aIOFilePicData.R = aIOFilePictureData.F;
        aIOFilePicData.T = aIOFilePictureData.G;
        aIOFilePicData.X = aIOFilePictureData.I;
        aIOFilePicData.Z = aIOFilePictureData.J;
        return aIOFilePicData;
    }

    public static AIOFilePictureData d(AIOFilePicData aIOFilePicData) {
        AIOFilePictureData aIOFilePictureData = new AIOFilePictureData();
        aIOFilePictureData.msgId = aIOFilePicData.f179628d;
        aIOFilePictureData.subId = aIOFilePicData.f179629e;
        aIOFilePictureData.time = aIOFilePicData.f179630f;
        aIOFilePictureData.size = aIOFilePicData.f179631h;
        aIOFilePictureData.shmsgseq = aIOFilePicData.f179632i;
        aIOFilePictureData.istroop = aIOFilePicData.f179633m;
        aIOFilePictureData.isMultiMsg = aIOFilePicData.C;
        aIOFilePictureData.isInMixedMsg = aIOFilePicData.D;
        aIOFilePictureData.isMsgSeqReady = aIOFilePicData.E;
        aIOFilePictureData.f281831d = aIOFilePicData.G;
        aIOFilePictureData.f281832e = aIOFilePicData.H;
        aIOFilePictureData.f281833f = aIOFilePicData.I;
        aIOFilePictureData.f281834h = aIOFilePicData.J;
        aIOFilePictureData.f281835i = aIOFilePicData.K;
        aIOFilePictureData.H = aIOFilePicData.V;
        aIOFilePictureData.E = aIOFilePicData.Q;
        aIOFilePictureData.F = aIOFilePicData.R;
        aIOFilePictureData.G = aIOFilePicData.T;
        aIOFilePictureData.I = aIOFilePicData.X;
        aIOFilePictureData.J = aIOFilePicData.Z;
        aIOFilePictureData.K = aIOFilePicData.f179567a0;
        aIOFilePictureData.L = aIOFilePicData.f179568b0;
        aIOFilePictureData.M = aIOFilePicData.f179569c0;
        return aIOFilePictureData;
    }

    public static com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData e(AIOFileVideoData aIOFileVideoData) {
        com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData aIOFileVideoData2 = new com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData();
        aIOFileVideoData2.f179628d = aIOFileVideoData.msgId;
        aIOFileVideoData2.f179629e = aIOFileVideoData.subId;
        aIOFileVideoData2.f179630f = aIOFileVideoData.time;
        aIOFileVideoData2.f179631h = aIOFileVideoData.size;
        aIOFileVideoData2.f179632i = aIOFileVideoData.shmsgseq;
        aIOFileVideoData2.f179633m = aIOFileVideoData.istroop;
        aIOFileVideoData2.C = aIOFileVideoData.isMultiMsg;
        aIOFileVideoData2.G = aIOFileVideoData.f281838e;
        aIOFileVideoData2.F = aIOFileVideoData.f281837d;
        aIOFileVideoData2.H = aIOFileVideoData.f281839f;
        aIOFileVideoData2.I = aIOFileVideoData.f281840h;
        aIOFileVideoData2.J = aIOFileVideoData.f281841i;
        aIOFileVideoData2.K = aIOFileVideoData.f281842m;
        return aIOFileVideoData2;
    }

    public static AIOFileVideoData f(com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData aIOFileVideoData) {
        AIOFileVideoData aIOFileVideoData2 = new AIOFileVideoData();
        aIOFileVideoData2.msgId = aIOFileVideoData.f179628d;
        aIOFileVideoData2.subId = aIOFileVideoData.f179629e;
        aIOFileVideoData2.time = aIOFileVideoData.f179630f;
        aIOFileVideoData2.size = aIOFileVideoData.f179631h;
        aIOFileVideoData2.shmsgseq = aIOFileVideoData.f179632i;
        aIOFileVideoData2.istroop = aIOFileVideoData.f179633m;
        aIOFileVideoData2.isMultiMsg = aIOFileVideoData.C;
        aIOFileVideoData2.isInMixedMsg = aIOFileVideoData.D;
        aIOFileVideoData2.isMsgSeqReady = aIOFileVideoData.E;
        aIOFileVideoData2.f281838e = aIOFileVideoData.G;
        aIOFileVideoData2.f281837d = aIOFileVideoData.F;
        aIOFileVideoData2.f281839f = aIOFileVideoData.H;
        aIOFileVideoData2.f281840h = aIOFileVideoData.I;
        aIOFileVideoData2.f281841i = aIOFileVideoData.J;
        aIOFileVideoData2.f281842m = aIOFileVideoData.K;
        aIOFileVideoData2.I = aIOFileVideoData.P;
        aIOFileVideoData2.P = aIOFileVideoData.U;
        aIOFileVideoData2.Q = aIOFileVideoData.V;
        aIOFileVideoData2.R = aIOFileVideoData.W;
        aIOFileVideoData2.S = aIOFileVideoData.X;
        aIOFileVideoData2.T = aIOFileVideoData.Y;
        return aIOFileVideoData2;
    }

    public static AIOBrowserBaseData g(AIORichMediaData aIORichMediaData) {
        if (aIORichMediaData == null) {
            return null;
        }
        if (aIORichMediaData instanceof AIOImageData) {
            return i((AIOImageData) aIORichMediaData);
        }
        if (aIORichMediaData instanceof AIOFilePicData) {
            return d((AIOFilePicData) aIORichMediaData);
        }
        if (aIORichMediaData instanceof AIOShortVideoData) {
            return k((AIOShortVideoData) aIORichMediaData);
        }
        if (!(aIORichMediaData instanceof com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData)) {
            return null;
        }
        return f((com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData) aIORichMediaData);
    }

    public static AIOImageData h(AIOPictureData aIOPictureData) {
        AIOImageData aIOImageData = new AIOImageData();
        aIOImageData.f179628d = aIOPictureData.msgId;
        aIOImageData.f179629e = aIOPictureData.subId;
        aIOImageData.f179630f = aIOPictureData.time;
        aIOImageData.f179631h = aIOPictureData.size;
        aIOImageData.f179632i = aIOPictureData.shmsgseq;
        aIOImageData.f179633m = aIOPictureData.istroop;
        aIOImageData.C = aIOPictureData.isMultiMsg;
        aIOImageData.F = aIOPictureData.thumbImageFile;
        aIOImageData.G = aIOPictureData.largeImageFile;
        aIOImageData.H = aIOPictureData.originImageFile;
        aIOImageData.I = aIOPictureData.mDisplayFile;
        aIOImageData.U = aIOPictureData.uuid;
        aIOImageData.V = aIOPictureData.timestamp;
        aIOImageData.W = aIOPictureData.groupFileID;
        aIOImageData.N = aIOPictureData.mIsPart;
        aIOImageData.Y = aIOPictureData.mBusinessType;
        aIOImageData.f179570a0 = aIOPictureData.isPicFile;
        aIOImageData.f179573d0 = aIOPictureData.filePath;
        aIOImageData.X = aIOPictureData.md5;
        aIOImageData.f179577h0 = aIOPictureData.picServerUrl;
        aIOImageData.f179578i0 = aIOPictureData.sendUin;
        aIOImageData.f179579j0 = aIOPictureData.isFromFile;
        aIOImageData.f179580k0 = aIOPictureData.imageBizType;
        aIOImageData.f179581l0 = aIOPictureData.isSend;
        aIOImageData.f179582m0 = aIOPictureData.friendUin;
        aIOImageData.f179583n0 = aIOPictureData.isAnonymousMsg;
        aIOImageData.f179584o0 = aIOPictureData.anId;
        aIOImageData.f179585p0 = aIOPictureData.content;
        aIOImageData.f179586q0 = aIOPictureData.templateId;
        aIOImageData.f179587r0 = aIOPictureData.templateName;
        return aIOImageData;
    }

    public static AIOPictureData i(AIOImageData aIOImageData) {
        AIOPictureData aIOPictureData = new AIOPictureData();
        aIOPictureData.msgId = aIOImageData.f179628d;
        aIOPictureData.subId = aIOImageData.f179629e;
        aIOPictureData.time = aIOImageData.f179630f;
        aIOPictureData.size = aIOImageData.f179631h;
        aIOPictureData.shmsgseq = aIOImageData.f179632i;
        aIOPictureData.istroop = aIOImageData.f179633m;
        aIOPictureData.isMultiMsg = aIOImageData.C;
        aIOPictureData.isInMixedMsg = aIOImageData.D;
        aIOPictureData.isMsgSeqReady = aIOImageData.E;
        aIOPictureData.thumbImageFile = aIOImageData.F;
        aIOPictureData.largeImageFile = aIOImageData.G;
        aIOPictureData.originImageFile = aIOImageData.H;
        aIOPictureData.mDisplayFile = aIOImageData.I;
        aIOPictureData.uuid = aIOImageData.U;
        aIOPictureData.timestamp = aIOImageData.V;
        aIOPictureData.groupFileID = aIOImageData.W;
        aIOPictureData.mIsPart = aIOImageData.N;
        aIOPictureData.mBusinessType = aIOImageData.Y;
        aIOPictureData.isPicFile = aIOImageData.f179570a0;
        aIOPictureData.filePath = aIOImageData.f179573d0;
        aIOPictureData.md5 = aIOImageData.X;
        aIOPictureData.picServerUrl = aIOImageData.f179577h0;
        aIOPictureData.sendUin = aIOImageData.f179578i0;
        aIOPictureData.isFromFile = aIOImageData.f179579j0;
        aIOPictureData.imageBizType = aIOImageData.f179580k0;
        aIOPictureData.isSend = aIOImageData.f179581l0;
        aIOPictureData.friendUin = aIOImageData.f179582m0;
        aIOPictureData.isAnonymousMsg = aIOImageData.f179583n0;
        aIOPictureData.anId = aIOImageData.f179584o0;
        aIOPictureData.content = aIOImageData.f179585p0;
        aIOPictureData.templateId = aIOImageData.f179586q0;
        aIOPictureData.templateName = aIOImageData.f179587r0;
        return aIOPictureData;
    }

    public static AIOShortVideoData j(AIOVideoData aIOVideoData) {
        AIOShortVideoData aIOShortVideoData = new AIOShortVideoData();
        aIOShortVideoData.f179628d = aIOVideoData.msgId;
        aIOShortVideoData.f179629e = aIOVideoData.subId;
        aIOShortVideoData.f179630f = aIOVideoData.time;
        aIOShortVideoData.f179631h = aIOVideoData.size;
        aIOShortVideoData.f179632i = aIOVideoData.shmsgseq;
        aIOShortVideoData.f179633m = aIOVideoData.istroop;
        aIOShortVideoData.C = aIOVideoData.isMultiMsg;
        aIOShortVideoData.F = aIOVideoData.f281843d;
        aIOShortVideoData.G = aIOVideoData.f281844e;
        aIOShortVideoData.H = aIOVideoData.f281845f;
        aIOShortVideoData.I = aIOVideoData.f281846h;
        aIOShortVideoData.L = aIOVideoData.C;
        aIOShortVideoData.M = aIOVideoData.D;
        aIOShortVideoData.N = aIOVideoData.E;
        aIOShortVideoData.R = aIOVideoData.F;
        aIOShortVideoData.V = aIOVideoData.G;
        aIOShortVideoData.Y = aIOVideoData.M;
        aIOShortVideoData.Z = aIOVideoData.N;
        return aIOShortVideoData;
    }

    public static AIOVideoData k(AIOShortVideoData aIOShortVideoData) {
        AIOVideoData aIOVideoData = new AIOVideoData();
        aIOVideoData.msgId = aIOShortVideoData.f179628d;
        aIOVideoData.subId = aIOShortVideoData.f179629e;
        aIOVideoData.time = aIOShortVideoData.f179630f;
        aIOVideoData.size = aIOShortVideoData.f179631h;
        aIOVideoData.shmsgseq = aIOShortVideoData.f179632i;
        aIOVideoData.istroop = aIOShortVideoData.f179633m;
        aIOVideoData.isMultiMsg = aIOShortVideoData.C;
        aIOVideoData.isInMixedMsg = aIOShortVideoData.D;
        aIOVideoData.isMsgSeqReady = aIOShortVideoData.E;
        aIOVideoData.f281843d = aIOShortVideoData.F;
        aIOVideoData.f281844e = aIOShortVideoData.G;
        aIOVideoData.f281845f = aIOShortVideoData.H;
        aIOVideoData.f281846h = aIOShortVideoData.I;
        aIOVideoData.C = aIOShortVideoData.L;
        aIOVideoData.D = aIOShortVideoData.M;
        aIOVideoData.E = aIOShortVideoData.N;
        aIOVideoData.F = aIOShortVideoData.R;
        aIOVideoData.G = aIOShortVideoData.V;
        aIOVideoData.M = aIOShortVideoData.Y;
        aIOVideoData.N = aIOShortVideoData.Z;
        return aIOVideoData;
    }
}

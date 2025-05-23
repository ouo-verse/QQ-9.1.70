package com.tencent.qqnt.aio.adapter.richmedia.provider;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.h;
import com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RMReqExParams;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoPlayUrlInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoPlayUrlResult;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IRichMediaService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017JL\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J8\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ,\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richmedia/provider/g;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "triggerType", "downSourceType", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "videoCodecFormat", "b", "a", "l", "curType", "Landroid/content/Intent;", tl.h.F, "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g implements h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MsgRecord msgRecord, MsgElement msgElement, i iVar, int i3, String str, VideoPlayUrlResult videoPlayUrlResult) {
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        ArrayList arrayList = new ArrayList();
        if (videoPlayUrlResult != null) {
            ArrayList<VideoPlayUrlInfo> arrayList2 = videoPlayUrlResult.v4IpUrl;
            if (arrayList2 != null) {
                Iterator<VideoPlayUrlInfo> it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().url);
                }
            }
            ArrayList<VideoPlayUrlInfo> arrayList3 = videoPlayUrlResult.domainUrl;
            if (arrayList3 != null) {
                Iterator<VideoPlayUrlInfo> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    arrayList.add(it5.next().url);
                }
            }
            ArrayList<VideoPlayUrlInfo> arrayList4 = videoPlayUrlResult.v6IpUrl;
            if (arrayList4 != null) {
                Iterator<VideoPlayUrlInfo> it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    arrayList.add(it6.next().url);
                }
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i("AIOVideoProvider", 1, "getVideoUrl FAIL. result: " + i3 + ", errMsg: " + str + ", msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId + ". download media.");
            return;
        }
        QLog.i("AIOVideoProvider", 1, "getVideoUrl. msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId + ". url list size: " + arrayList.size());
        if (iVar != null) {
            VideoElement videoElement = msgElement.videoElement;
            Intrinsics.checkNotNullExpressionValue(videoElement, "msgElement.videoElement");
            String e16 = aj.e(videoElement);
            if (e16 == null) {
                e16 = "";
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            iVar.b(e16, (String[]) array, "");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        MsgElement msgElement2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null) {
            msgElement2 = qu3.i.f429570a.m(msgRecord);
            if (msgElement2 == null) {
                return;
            }
        } else {
            msgElement2 = msgElement;
        }
        QLog.i("AIOVideoProvider", 1, "cancel, msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + (msgElement != null ? Long.valueOf(msgElement.elementId) : null));
        if (type == 0) {
            j(msgRecord, msgElement2.elementId, 2, 0);
        } else {
            if (type != 1) {
                return;
            }
            j(msgRecord, msgElement2.elementId, 1, 0);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void b(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, int triggerType, int downSourceType, VideoCodecFormatType videoCodecFormat, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(videoCodecFormat, "videoCodecFormat");
        if (msgElement == null && (msgElement = qu3.i.f429570a.m(msgRecord)) == null) {
            return;
        }
        MsgElement msgElement2 = msgElement;
        if (type == 0) {
            k(msgRecord, msgElement2, 2, 0);
        } else {
            if (type != 1) {
                return;
            }
            l(msgRecord, msgElement2, triggerType, downSourceType, videoCodecFormat, cb5);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public List<AIORichMediaData> c(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement, int subId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList arrayList = new ArrayList();
        if (msgElement == null && (msgElement = qu3.i.f429570a.m(msgRecord)) == null) {
            return arrayList;
        }
        VideoElement videoElement = msgElement.videoElement;
        AIOShortVideoData aIOShortVideoData = new AIOShortVideoData();
        ru3.c.f432503a.a(msgRecord, aIOShortVideoData);
        aIOShortVideoData.R = msgRecord.senderUid;
        aIOShortVideoData.T = msgRecord.peerUid;
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2) {
            aIOShortVideoData.U = 1;
        }
        aIOShortVideoData.f179631h = videoElement.fileSize;
        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
        aIOShortVideoData.G = aj.e(videoElement);
        aIOShortVideoData.H = videoElement.fileTime;
        aIOShortVideoData.I = videoElement.busiType;
        aIOShortVideoData.L = videoElement.thumbWidth;
        aIOShortVideoData.M = videoElement.thumbHeight;
        Integer num = videoElement.invalidState;
        Intrinsics.checkNotNullExpressionValue(num, "videoElement.invalidState");
        aIOShortVideoData.V = num.intValue();
        aIOShortVideoData.f179629e = subId;
        aIOShortVideoData.F = aj.f(videoElement);
        arrayList.add(aIOShortVideoData);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean d(ChatMessage chatMessage, MsgRecord msgRecord, QBaseActivity qBaseActivity, AppRuntime appRuntime) {
        return h.a.f(this, chatMessage, msgRecord, qBaseActivity, appRuntime);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean e(int i3, int i16) {
        return h.a.a(this, i3, i16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public int f(MsgRecord msgRecord, int i3, boolean z16) {
        return h.a.e(this, msgRecord, i3, z16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    @Deprecated(message = "\u8fd9\u4e2a\u63a5\u53e3\u9891\u9053\u8fd8\u5728\u4f7f\u7528\uff0c\u6682\u65f6\u4e0d\u80fd\u53bb\u6389\uff0c\u540e\u9762\u7684\u8c03\u7528\u90fd\u7528\u4e0b\u9762\u7684download\u63a5\u53e3")
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = qu3.i.f429570a.m(msgRecord)) == null) {
            return;
        }
        MsgElement msgElement2 = msgElement;
        if (type == 0) {
            k(msgRecord, msgElement2, 2, 0);
        } else {
            if (type != 1) {
                return;
            }
            l(msgRecord, msgElement2, 1, 0, VideoCodecFormatType.KCODECFORMATH264, cb5);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = qu3.i.f429570a.m(msgRecord)) == null) {
            return null;
        }
        VideoElement videoElement = msgElement.videoElement;
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 21);
        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
        String f16 = aj.f(videoElement);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, f16);
        bundle.putString(ShortVideoConstants.THUMBFILE_SEND_PATH, f16);
        bundle.putString(ShortVideoConstants.FROM_UIN, msgRecord.peerUid);
        bundle.putInt(ShortVideoConstants.FROM_BUSI_TYPE, videoElement.busiType);
        bundle.putInt(ShortVideoConstants.FILE_SEND_SIZE, (int) videoElement.fileSize);
        bundle.putInt(ShortVideoConstants.FILE_SEND_DURATION, videoElement.fileTime);
        bundle.putString("file_name", videoElement.fileName);
        bundle.putInt(ShortVideoConstants.FILE_FORMAT, videoElement.fileFormat);
        bundle.putBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        String e16 = aj.e(videoElement);
        bundle.putString("file_send_path", e16);
        bundle.putString(ShortVideoConstants.FILE_SHORTVIDEO_MD5, videoElement.videoMd5);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_WIDTH, videoElement.thumbWidth);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, videoElement.thumbHeight);
        bundle.putString(ShortVideoConstants.THUMBFILE_MD5, videoElement.thumbMd5);
        bundle.putInt(ShortVideoConstants.FILE_THUMB_SIZE, videoElement.thumbSize);
        if (FileUtils.fileExistsAndNotEmpty(e16)) {
            bundle.putBoolean("k_dataline", true);
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, e16);
            bundle.putBoolean("direct_send_if_dataline_forward", true);
        }
        Intent putExtras = new Intent().putExtras(bundle);
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent().putExtras(bundle)");
        putExtras.putExtra(ShortVideoConstants.FROM_UIN_TYPE, curType);
        putExtras.putExtra("extra.MSG_ID", msgRecord.msgId);
        return putExtras;
    }

    public void j(MsgRecord msgRecord, long j3, int i3, int i16) {
        h.a.b(this, msgRecord, j3, i3, i16);
    }

    public void k(MsgRecord msgRecord, MsgElement msgElement, int i3, int i16) {
        h.a.d(this, msgRecord, msgElement, i3, i16);
    }

    public final void l(final MsgRecord msgRecord, final MsgElement msgElement, int triggerType, int downSourceType, VideoCodecFormatType videoCodecFormat, final i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(videoCodecFormat, "videoCodecFormat");
        QLog.i("AIOVideoProvider", 1, "getVideoUrl, msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId + "\uff0c videoCodecFormat: " + videoCodecFormat);
        ((IRichMediaService) QRoute.api(IRichMediaService.class)).getVideoPlayUrlV2(new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId), msgRecord.msgId, msgElement.elementId, videoCodecFormat, new RMReqExParams(downSourceType, triggerType), new IVideoPlayUrlCallback() { // from class: com.tencent.qqnt.aio.adapter.richmedia.provider.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback
            public final void onResult(int i3, String str, VideoPlayUrlResult videoPlayUrlResult) {
                g.m(MsgRecord.this, msgElement, cb5, i3, str, videoPlayUrlResult);
            }
        });
    }
}

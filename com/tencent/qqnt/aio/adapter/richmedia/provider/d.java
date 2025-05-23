package com.tencent.qqnt.aio.adapter.richmedia.provider;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.h;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0016\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richmedia/provider/d;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "", "path", "", "j", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "a", "curType", "Landroid/content/Intent;", tl.h.F, "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements h {
    private final boolean j(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = qu3.i.f429570a.k(msgRecord)) == null) {
            return;
        }
        int i3 = type == 1 ? 2 : 1;
        i(msgRecord, msgElement.elementId, i3, i3 == 2 ? 720 : 0);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void b(MsgRecord msgRecord, int i3, int i16, MsgElement msgElement, int i17, int i18, VideoCodecFormatType videoCodecFormatType, i iVar) {
        h.a.c(this, msgRecord, i3, i16, msgElement, i17, i18, videoCodecFormatType, iVar);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public List<AIORichMediaData> c(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement, int subId) {
        String b16;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList arrayList = new ArrayList();
        if (msgElement == null && (msgElement = qu3.i.f429570a.k(msgRecord)) == null) {
            return arrayList;
        }
        PicElement picElement = msgElement.picElement;
        AIOImageData aIOImageData = new AIOImageData();
        ru3.c.f432503a.a(msgRecord, aIOImageData);
        aIOImageData.f179578i0 = msgRecord.senderUid;
        aIOImageData.f179582m0 = msgRecord.peerUid;
        int i3 = msgRecord.sendType;
        aIOImageData.Q = i3 == 1;
        aIOImageData.f179581l0 = i3 == 1 || i3 == 2;
        aIOImageData.f179631h = picElement.fileSize;
        aIOImageData.S = picElement.picWidth;
        aIOImageData.T = picElement.picHeight;
        aIOImageData.X = picElement.md5HexStr;
        Integer num = picElement.picType;
        Intrinsics.checkNotNullExpressionValue(num, "picElement.picType");
        aIOImageData.P = num.intValue();
        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
        String d16 = defpackage.g.d(picElement, 720);
        if (!TextUtils.isEmpty(d16)) {
            aIOImageData.F = d16;
        } else {
            d16 = aj.b(picElement, 720);
            if (FileUtils.fileExists(d16)) {
                defpackage.g.f(picElement, 720, d16);
                b16 = d16;
            } else {
                b16 = aj.b(picElement, 198);
            }
            aIOImageData.F = b16;
        }
        String a16 = aj.a(picElement);
        if (msgRecord.chatType != 3) {
            if (picElement.original && !MsgExtKt.u(picElement)) {
                aIOImageData.G = d16;
                aIOImageData.H = a16;
            } else {
                aIOImageData.G = a16;
            }
        }
        aIOImageData.I = a16;
        aIOImageData.f179629e = subId;
        aIOImageData.U = picElement.fileName;
        String str = picElement.fileUuid;
        Intrinsics.checkNotNullExpressionValue(str, "picElement.fileUuid");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            aIOImageData.W = longOrNull.longValue();
        }
        Integer num2 = picElement.invalidState;
        aIOImageData.M = num2 == null || num2.intValue() != 0;
        arrayList.add(aIOImageData);
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
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = qu3.i.f429570a.k(msgRecord)) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOPicProvider", 2, "[download] msgSeq: " + msgRecord.msgSeq + ", type: " + type + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId);
        }
        if (type == 1) {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElem.picElement");
            String b16 = aj.b(picElement, 720);
            if (b16 != null && j(b16)) {
                if (cb5 != null) {
                    cb5.a(1, b16);
                    return;
                }
                return;
            }
        } else if (type == 2) {
            PicElement picElement2 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "picMsgElem.picElement");
            String b17 = aj.b(picElement2, 720);
            if (b17 != null && j(b17)) {
                if (cb5 != null) {
                    cb5.a(1, b17);
                    return;
                }
                return;
            }
        } else if (type == 4) {
            PicElement picElement3 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement3, "picMsgElem.picElement");
            String a16 = aj.a(picElement3);
            if (a16 == null) {
                a16 = "";
            }
            if (j(a16)) {
                if (cb5 != null) {
                    cb5.a(1, a16);
                    return;
                }
                return;
            }
        }
        int i3 = (type == 1 || type == 2) ? 2 : 1;
        k(msgRecord, msgElement, i3, i3 != 2 ? 0 : 720);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return null;
    }

    public void i(MsgRecord msgRecord, long j3, int i3, int i16) {
        h.a.b(this, msgRecord, j3, i3, i16);
    }

    public void k(MsgRecord msgRecord, MsgElement msgElement, int i3, int i16) {
        h.a.d(this, msgRecord, msgElement, i3, i16);
    }
}

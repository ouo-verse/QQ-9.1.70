package com.tencent.biz.richframework.publish.nt;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaAppType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e\u00a8\u0006\u001f"}, d2 = {"com/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType", "", "Lcom/tencent/biz/richframework/publish/nt/NTBatchUploadConstants$AppType;", "", WidgetCacheConstellationData.NUM, "I", "getNum", "()I", "setNum", "(I)V", "<init>", "(Ljava/lang/String;II)V", "APP_TYPE_QQ_AIO_CHAT", "APP_TYPE_CHANNEL_AIO_CHAT", "APP_TYPE_M86_AIO_CHAT", "APP_TYPE_M86_EMOJI_COLLECTION", "APP_TYPE_M86_PHOTOS", "APP_TYPE_M86_PLAZA", "APP_TYPE_ARK_SHARE", "APP_TYPE_ACG_AIO_CHAT", "APP_TYPE_ACG_EMOJI_COLLECTION", "APP_TYPE_ACG_PHOTOS", "APP_TYPE_ACG_PLAZA", "APP_TYPE_QQ_LPLAN", "APP_TYPE_M86_AIGC", "APP_TYPE_QQ_EMOJI_AIGC", "APP_TYPE_QZONE_PHOTOS", "APP_TYPE_QZONE_INTIMATE_SPACE_PHOTOS", "APP_TYPE_QZONE_SHUOSHUO_COMMENT", "APP_TYPE_QZONE_INTIMATE_SPACE_ARK_SHARE", "APP_TYPE_SAFE_SCAN_QRCODE", "rfw-upload_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public enum NTBatchUploadConstants$AppType {
    APP_TYPE_QQ_AIO_CHAT(RichMediaAppType.KAPPTYPEQQAIOCHAT.ordinal()),
    APP_TYPE_CHANNEL_AIO_CHAT(RichMediaAppType.KAPPTYPECHANNELAIOCHAT.ordinal()),
    APP_TYPE_M86_AIO_CHAT(RichMediaAppType.KAPPTYPEM86AIOCHAT.ordinal()),
    APP_TYPE_M86_EMOJI_COLLECTION(RichMediaAppType.KAPPTYPEM86EMOJICOLLECTION.ordinal()),
    APP_TYPE_M86_PHOTOS(RichMediaAppType.KAPPTYPEM86PHOTOS.ordinal()),
    APP_TYPE_M86_PLAZA(RichMediaAppType.KAPPTYPEM86PLAZA.ordinal()),
    APP_TYPE_ARK_SHARE(RichMediaAppType.KAPPTYPEARKSHARE.ordinal()),
    APP_TYPE_ACG_AIO_CHAT(RichMediaAppType.KAPPTYPEACGAIOCHAT.ordinal()),
    APP_TYPE_ACG_EMOJI_COLLECTION(RichMediaAppType.KAPPTYPEACGEMOJICOLLECTION.ordinal()),
    APP_TYPE_ACG_PHOTOS(RichMediaAppType.KAPPTYPEACGPHOTOS.ordinal()),
    APP_TYPE_ACG_PLAZA(RichMediaAppType.KAPPTYPEACGPLAZA.ordinal()),
    APP_TYPE_QQ_LPLAN(RichMediaAppType.KAPPTYPEQQLPLAN.ordinal()),
    APP_TYPE_M86_AIGC(RichMediaAppType.KAPPTYPEM86AIGC.ordinal()),
    APP_TYPE_QQ_EMOJI_AIGC(RichMediaAppType.KAPPTYPEQQEMOJIAIGC.ordinal()),
    APP_TYPE_QZONE_PHOTOS(RichMediaAppType.KAPPTYPEQZONEPHOTOS.ordinal()),
    APP_TYPE_QZONE_INTIMATE_SPACE_PHOTOS(RichMediaAppType.KAPPTYPEQZONEINTIMATESPACEPHOTOS.ordinal()),
    APP_TYPE_QZONE_SHUOSHUO_COMMENT(RichMediaAppType.KAPPTYPEQZONESHUOSHUOCOMMENT.ordinal()),
    APP_TYPE_QZONE_INTIMATE_SPACE_ARK_SHARE(RichMediaAppType.KAPPTYPEQZONEINTIMATESPACEARKSHARE.ordinal()),
    APP_TYPE_SAFE_SCAN_QRCODE(18);

    private int num;

    NTBatchUploadConstants$AppType(int i3) {
        this.num = i3;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setNum(int i3) {
        this.num = i3;
    }
}

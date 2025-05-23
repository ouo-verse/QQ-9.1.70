package com.tencent.qqnt.aio.api;

import android.net.Uri;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&JF\u0010\u0014\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0010j\b\u0012\u0004\u0012\u00020\u000e`\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&JT\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J>\u0010!\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0019H&J@\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002H&J@\u0010'\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002H&J \u0010(\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H&J \u0010+\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H&J \u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H&J\u0018\u00101\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H&J(\u00103\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J(\u00103\u001a\u00020\u00072\u0006\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/api/IMsgSendHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "peerUid", "", "chatType", "content", "", "syncSendText", "sendText", "", "rootMsgIds", "", "forwardMsgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "srcContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dstContacts", "comment", "forward", "path", "", CustomImageProps.QUALITY, QCircleLpReportDc010001.KEY_SUBTYPE, "", "maxPicSize", "md5", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "sendPic", "Landroid/net/Uri;", "imageUri", "sendPicByUri", "origPath", "businessType", "thumbPath", "sendVideo", "mediaUri", "sendVideoByUri", "sendFile", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "sendArk", "sendArkWithMsgId", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "reSendMsg", "atUid", "sendAtTextMsg", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "atTextElement", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMsgSendHelper extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IMsgSendHelper iMsgSendHelper, String str, int i3, Uri uri, boolean z16, int i16, float f16, int i17, Object obj) {
            boolean z17;
            int i18;
            float f17;
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    z17 = false;
                } else {
                    z17 = z16;
                }
                if ((i17 & 16) != 0) {
                    i18 = 0;
                } else {
                    i18 = i16;
                }
                if ((i17 & 32) != 0) {
                    f17 = 300.0f;
                } else {
                    f17 = f16;
                }
                iMsgSendHelper.sendPicByUri(str, i3, uri, z17, i18, f17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPicByUri");
        }

        public static /* synthetic */ void b(IMsgSendHelper iMsgSendHelper, String str, int i3, Uri uri, int i16, boolean z16, String str2, int i17, Object obj) {
            int i18;
            boolean z17;
            String str3;
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    i18 = 0;
                } else {
                    i18 = i16;
                }
                if ((i17 & 16) != 0) {
                    z17 = false;
                } else {
                    z17 = z16;
                }
                if ((i17 & 32) != 0) {
                    str3 = null;
                } else {
                    str3 = str2;
                }
                iMsgSendHelper.sendVideoByUri(str, i3, uri, i18, z17, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendVideoByUri");
        }
    }

    void forward(@Nullable long[] rootMsgIds, long forwardMsgId, @NotNull Contact srcContact, @NotNull ArrayList<Contact> dstContacts, @Nullable String comment);

    void reSendMsg(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem);

    void sendArk(@NotNull String peerUid, int chatType, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel);

    long sendArkWithMsgId(@NotNull String peerUid, int chatType, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel);

    void sendAtTextMsg(@NotNull AIOElementType.h atTextElement, @NotNull String peerUid, int chatType, @NotNull String content);

    void sendAtTextMsg(@NotNull String peerUid, @NotNull String atUid, int chatType, @NotNull String content);

    void sendFile(@NotNull String peerUid, int chatType, @NotNull String path);

    void sendPic(@NotNull String peerUid, int chatType, @NotNull String path, boolean quality, int subType, float maxPicSize, @NotNull String md5, @Nullable com.tencent.qqnt.msg.data.g picExtBizInfo);

    void sendPicByUri(@NotNull String peerUid, int chatType, @NotNull Uri imageUri, boolean quality, int subType, float maxPicSize);

    void sendText(@NotNull String peerUid, int chatType, @NotNull String content);

    void sendVideo(@NotNull String peerUid, int chatType, @NotNull String origPath, int businessType, boolean quality, @Nullable String thumbPath);

    void sendVideoByUri(@NotNull String peerUid, int chatType, @NotNull Uri mediaUri, int businessType, boolean quality, @Nullable String thumbPath);

    void syncSendText(@NotNull String peerUid, int chatType, @NotNull String content);
}

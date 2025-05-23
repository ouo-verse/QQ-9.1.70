package com.tencent.qqnt.msg.api;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.d;
import com.tencent.qqnt.msg.data.g;
import com.tencent.qqnt.msg.e;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\bg\u0018\u0000 `2\u00020\u0001:\u0001aJ0\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H&J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH&J0\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH&J\u001a\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&J \u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0012H&J \u0010#\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0012H&J0\u0010&\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\nH&J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0012H&J \u0010-\u001a\u00020\f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH&J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\nH&J_\u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\b\u0002\u00103\u001a\u00020\u001f2\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604\u00a2\u0006\u0002\b7H&J\u0010\u0010&\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\nH&J0\u0010(\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00122\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u0002090\u0002j\b\u0012\u0004\u0012\u000209`\u0004H&J\u0010\u0010-\u001a\u00020\f2\u0006\u0010*\u001a\u00020)H&J,\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120=2\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00122\u0006\u00100\u001a\u00020/H&J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\fH&J~\u0010M\u001a\u00020\u00062\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0002j\b\u0012\u0004\u0012\u00020\f`\u00042\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020)2\b\b\u0002\u0010G\u001a\u00020\n2\b\b\u0002\u0010H\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020JH&Jf\u0010M\u001a\u00020\u00062\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0002j\b\u0012\u0004\u0012\u00020\f`\u00042\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020)2\b\b\u0002\u0010G\u001a\u00020\n2\b\b\u0002\u0010H\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)H&J(\u0010P\u001a\u00020\f2\u0006\u0010N\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\u001fH&J\u0010\u0010S\u001a\u00020\f2\u0006\u0010R\u001a\u00020QH&J\u001c\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120=2\u0006\u0010\u001c\u001a\u00020\nH&J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\fH&J\u0010\u0010W\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\fH&J\u0010\u0010X\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\fH&J\u0010\u0010Y\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\fH&J\u0010\u0010[\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\u0003H&J\u0018\u0010[\u001a\u00020^2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\\H&J\u0010\u0010_\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0012H&J\u0010\u0010_\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\u0003H&\u00a8\u0006b"}, d2 = {"Lcom/tencent/qqnt/msg/api/IMsgUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "mrList", "Lcom/tencent/qqnt/msg/d;", "transformMrListToMsgItemList", "mr", "transformToIMsgRecord", "", "content", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "createTextElement", "Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "textElement", "name", "uid", "", "type", "createAtTextElement", "faceType", "index", "desc", "createFaceElement", "faceIndex", "packId", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "path", "createFileElement", "origPath", "", CustomImageProps.QUALITY, QCircleLpReportDc010001.KEY_SUBTYPE, "createPicElement", "createPicElementForGuild", "subBusiType", "thumbPath", "createVideoElement", "duration", "createPttElement", "", "msgId", "senderUidStr", "sourceMsgText", "createReplyElement", "textSummary", "", "maxPicSize", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "isFlashPic", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "", "Lkotlin/ExtensionFunctionType;", "extPicElement", "", "audioData", "width", "height", "Lkotlin/Pair;", "scaleSize", DTConstants.TAG.ELEMENT, "getElementContent", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "sendUid", "sendNickName", QQBrowserActivity.KEY_MSG_TYPE, "sendType", "msgSeq", "peerUid", "msgTime", "roleType", "Lcom/tencent/qqnt/kernel/nativeinterface/FromRoleInfo;", "fromChannelRoleInfo", "fromGuildRoleInfo", "createMsgItem", "id", "isClip", "createGiphyElement", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "createArkElement", "getPicSizeByPath", "elem", "isTextElem", "isPictureElem", "isVideoElem", "isArkElem", QQPermissionConstants.Permission.AUIDO_GROUP, "getElementSummary", "Lcom/tencent/qqnt/msg/e;", "summaryDecoder", "", "msgTypeToString", "Companion", "a", "msg_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IMsgUtilApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final int BUSI_TYPE_GUILD_VIDEO = 4601;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int VIDEO_BUSI_TYPE_LONGVID = 4601;
    public static final int VIDEO_BUSI_TYPE_SHORTVID = 4602;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/msg/api/IMsgUtilApi$a;", "", "<init>", "()V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.api.IMsgUtilApi$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f359553a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37981);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f359553a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class b {
        public static /* synthetic */ d a(IMsgUtilApi iMsgUtilApi, ArrayList arrayList, String str, String str2, int i3, int i16, long j3, String str3, long j16, long j17, int i17, Object obj) {
            String str4;
            long j18;
            long j19;
            if (obj == null) {
                if ((i17 & 64) != 0) {
                    str4 = "";
                } else {
                    str4 = str3;
                }
                if ((i17 & 128) != 0) {
                    j18 = 0;
                } else {
                    j18 = j16;
                }
                if ((i17 & 256) != 0) {
                    j19 = 0;
                } else {
                    j19 = j17;
                }
                return iMsgUtilApi.createMsgItem(arrayList, str, str2, i3, i16, j3, str4, j18, j19);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMsgItem");
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(37988), (Class<?>) IMsgUtilApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f359553a;
        }
    }

    @NotNull
    MsgElement createArkElement(@NotNull com.tencent.qqnt.msg.data.a arkMsgModel);

    @NotNull
    MsgElement createAtTextElement(@NotNull String name, @NotNull String uid, int type);

    @NotNull
    MsgElement createFaceElement(int faceType, int index, @NotNull String desc);

    @NotNull
    MsgElement createFaceElement(int faceType, int faceIndex, @NotNull String packId, int imageType, @NotNull String desc);

    @NotNull
    MsgElement createFileElement(@NotNull String path);

    @NotNull
    MsgElement createFileElement(@NotNull String path, int type);

    @NotNull
    MsgElement createGiphyElement(@NotNull String id5, int width, int height, boolean isClip);

    @NotNull
    d createMsgItem(@NotNull ArrayList<MsgElement> elements, @NotNull String sendUid, @NotNull String sendNickName, int msgType, int sendType, long msgSeq, @NotNull String peerUid, long msgTime, long msgId);

    @NotNull
    d createMsgItem(@NotNull ArrayList<MsgElement> elements, @NotNull String sendUid, @NotNull String sendNickName, int msgType, int sendType, long msgSeq, @NotNull String peerUid, long msgTime, long msgId, int roleType, @NotNull FromRoleInfo fromChannelRoleInfo, @NotNull FromRoleInfo fromGuildRoleInfo);

    @NotNull
    MsgElement createPicElement(@NotNull String origPath, boolean quality, int subType);

    @NotNull
    MsgElement createPicElement(@NotNull String origPath, boolean quality, int subType, @Nullable String textSummary, float maxPicSize, @Nullable g picExtBizInfo, boolean isFlashPic, @NotNull Function1<? super PicElement, Unit> extPicElement);

    @NotNull
    MsgElement createPicElementForGuild(@NotNull String origPath, boolean quality, int subType);

    @NotNull
    MsgElement createPttElement(@NotNull String origPath, int duration);

    @NotNull
    MsgElement createPttElement(@NotNull String origPath, int duration, @NotNull ArrayList<Byte> audioData);

    @NotNull
    MsgElement createReplyElement(long msgId);

    @NotNull
    MsgElement createReplyElement(long msgId, @NotNull String senderUidStr, @NotNull String sourceMsgText);

    @NotNull
    MsgElement createTextElement(@NotNull TextElement textElement);

    @NotNull
    MsgElement createTextElement(@NotNull String content);

    @NotNull
    MsgElement createVideoElement(@NotNull String origPath);

    @NotNull
    MsgElement createVideoElement(@NotNull String origPath, int subBusiType, boolean quality, @Nullable String thumbPath);

    @NotNull
    String getElementContent(@NotNull MsgElement element);

    @NotNull
    CharSequence getElementSummary(@NotNull MsgRecord record, @NotNull e summaryDecoder);

    @NotNull
    String getElementSummary(@NotNull MsgRecord record);

    @NotNull
    Pair<Integer, Integer> getPicSizeByPath(@NotNull String path);

    boolean isArkElem(@NotNull MsgElement elem);

    boolean isPictureElem(@NotNull MsgElement elem);

    boolean isTextElem(@NotNull MsgElement elem);

    boolean isVideoElem(@NotNull MsgElement elem);

    @NotNull
    String msgTypeToString(int msgType);

    @NotNull
    String msgTypeToString(@NotNull MsgRecord record);

    @NotNull
    Pair<Integer, Integer> scaleSize(int width, int height, float maxPicSize);

    @NotNull
    ArrayList<d> transformMrListToMsgItemList(@NotNull ArrayList<MsgRecord> mrList);

    @NotNull
    d transformToIMsgRecord(@NotNull MsgRecord mr5);
}

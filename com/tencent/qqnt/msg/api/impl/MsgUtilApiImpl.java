package com.tencent.qqnt.msg.api.impl;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.MsgUtil;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.msg.data.g;
import com.tencent.qqnt.msg.e;
import com.tencent.qqnt.msg.m;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b`\u0010aJ0\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J]\u0010*\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u001c2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%\u00a2\u0006\u0002\b(H\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\nH\u0016J0\u0010/\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00122\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020-0\u0002j\b\u0012\u0004\u0012\u00020-`\u0004H\u0016J\u0010\u00102\u001a\u00020\f2\u0006\u00101\u001a\u000200H\u0016J,\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012052\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\fH\u0016Jx\u0010E\u001a\u00020\u00062\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0002j\b\u0012\u0004\u0012\u00020\f`\u00042\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010A\u001a\u00020\u00122\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020BH\u0016J(\u0010H\u001a\u00020\f2\u0006\u0010F\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u001cH\u0016J\u0010\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020IH\u0016J\u001c\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012052\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\fH\u0016J\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\fH\u0016J\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\fH\u0016J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\fH\u0016J\u0010\u0010S\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0003H\u0016J\u0018\u0010S\u001a\u00020V2\u0006\u0010R\u001a\u00020\u00032\u0006\u0010U\u001a\u00020TH\u0016J\u0010\u0010W\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0012H\u0016J\u0010\u0010W\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0003H\u0016J0\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010*\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J \u0010[\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J*\u0010+\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010]\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0012H\u0016J \u00102\u001a\u00020\f2\u0006\u00101\u001a\u0002002\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\nH\u0016J`\u0010E\u001a\u00020\u00062\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0002j\b\u0012\u0004\u0012\u00020\f`\u00042\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016\u00a8\u0006b"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/MsgUtilApiImpl;", "Lcom/tencent/qqnt/msg/api/IMsgUtilApi;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "mrList", "Lcom/tencent/qqnt/msg/d;", "transformMrListToMsgItemList", "mr", "transformToIMsgRecord", "", "content", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "createTextElement", "Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "textElement", "name", "uid", "", "type", "createAtTextElement", "faceType", "index", "desc", "createFaceElement", "path", "createFileElement", "origPath", "", CustomImageProps.QUALITY, QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "", "maxPicSize", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "isFlashPic", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "", "Lkotlin/ExtensionFunctionType;", "extPicElement", "createPicElement", "createVideoElement", "duration", "", "audioData", "createPttElement", "", "msgId", "createReplyElement", "width", "height", "Lkotlin/Pair;", "scaleSize", DTConstants.TAG.ELEMENT, "getElementContent", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "sendUid", "sendNickName", QQBrowserActivity.KEY_MSG_TYPE, "sendType", "msgSeq", "peerUid", "msgTime", "roleType", "Lcom/tencent/qqnt/kernel/nativeinterface/FromRoleInfo;", "fromChannelRoleInfo", "fromGuildRoleInfo", "createMsgItem", "id", "isClip", "createGiphyElement", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "createArkElement", "getPicSizeByPath", "elem", "isTextElem", "isPictureElem", "isVideoElem", "isArkElem", QQPermissionConstants.Permission.AUIDO_GROUP, "getElementSummary", "Lcom/tencent/qqnt/msg/e;", "summaryDecoder", "", "msgTypeToString", "faceIndex", "packId", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "createPicElementForGuild", "subBusiType", "thumbPath", "senderUidStr", "sourceMsgText", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgUtilApiImpl implements IMsgUtilApi {
    static IPatchRedirector $redirector_;

    public MsgUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createArkElement(@NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (MsgElement) iPatchRedirector.redirect((short) 17, (Object) this, (Object) arkMsgModel);
        }
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        return MsgUtil.f359547a.d(arkMsgModel);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createAtTextElement(@NotNull String name, @NotNull String uid, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MsgElement) iPatchRedirector.redirect((short) 6, this, name, uid, Integer.valueOf(type));
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uid, "uid");
        return MsgUtil.f359547a.e(name, uid, type);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createFaceElement(int faceType, int index, @NotNull String desc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MsgElement) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(faceType), Integer.valueOf(index), desc);
        }
        Intrinsics.checkNotNullParameter(desc, "desc");
        return MsgUtil.f359547a.g(faceType, index, desc);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createFileElement(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MsgElement) iPatchRedirector.redirect((short) 8, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        return MsgUtil.f359547a.i(path);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createGiphyElement(@NotNull String id5, int width, int height, boolean isClip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MsgElement) iPatchRedirector.redirect((short) 16, this, id5, Integer.valueOf(width), Integer.valueOf(height), Boolean.valueOf(isClip));
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        return MsgUtil.f359547a.l(id5, width, height, isClip);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public com.tencent.qqnt.msg.d createMsgItem(@NotNull ArrayList<MsgElement> elements, @NotNull String sendUid, @NotNull String sendNickName, int msgType, int sendType, long msgSeq, @NotNull String peerUid, long msgTime, long msgId, int roleType, @NotNull FromRoleInfo fromChannelRoleInfo, @NotNull FromRoleInfo fromGuildRoleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.qqnt.msg.d) iPatchRedirector.redirect((short) 15, this, elements, sendUid, sendNickName, Integer.valueOf(msgType), Integer.valueOf(sendType), Long.valueOf(msgSeq), peerUid, Long.valueOf(msgTime), Long.valueOf(msgId), Integer.valueOf(roleType), fromChannelRoleInfo, fromGuildRoleInfo);
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(sendUid, "sendUid");
        Intrinsics.checkNotNullParameter(sendNickName, "sendNickName");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(fromChannelRoleInfo, "fromChannelRoleInfo");
        Intrinsics.checkNotNullParameter(fromGuildRoleInfo, "fromGuildRoleInfo");
        return MsgUtil.f359547a.n(elements, sendUid, sendNickName, msgType, sendType, msgSeq, peerUid, msgTime, msgId, roleType, fromChannelRoleInfo, fromGuildRoleInfo);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createPicElement(@NotNull String origPath, boolean quality, int subType, @Nullable String textSummary, float maxPicSize, @Nullable g picExtBizInfo, boolean isFlashPic, @NotNull Function1<? super PicElement, Unit> extPicElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MsgElement) iPatchRedirector.redirect((short) 9, this, origPath, Boolean.valueOf(quality), Integer.valueOf(subType), textSummary, Float.valueOf(maxPicSize), picExtBizInfo, Boolean.valueOf(isFlashPic), extPicElement);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        Intrinsics.checkNotNullParameter(extPicElement, "extPicElement");
        return MsgUtil.f359547a.p(origPath, quality, subType, textSummary, maxPicSize, picExtBizInfo, isFlashPic, extPicElement);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createPicElementForGuild(@NotNull String origPath, boolean quality, int subType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (MsgElement) iPatchRedirector.redirect((short) 30, this, origPath, Boolean.valueOf(quality), Integer.valueOf(subType));
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        return MsgUtil.f359547a.q(origPath, quality, subType);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createPttElement(@NotNull String origPath, int duration, @NotNull ArrayList<Byte> audioData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MsgElement) iPatchRedirector.redirect((short) 11, this, origPath, Integer.valueOf(duration), audioData);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        return MsgUtil.f359547a.s(origPath, duration, audioData);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createReplyElement(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? MsgUtil.f359547a.t(msgId) : (MsgElement) iPatchRedirector.redirect((short) 12, (Object) this, msgId);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createTextElement(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgElement) iPatchRedirector.redirect((short) 4, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        return MsgUtil.f359547a.w(content);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createVideoElement(@NotNull String origPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MsgElement) iPatchRedirector.redirect((short) 10, (Object) this, (Object) origPath);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        return MsgUtil.f359547a.x(origPath);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public String getElementContent(@NotNull MsgElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        return m.a(element);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public String getElementSummary(@NotNull MsgRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) record);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        return MsgUtil.f359547a.B(record);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public Pair<Integer, Integer> getPicSizeByPath(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Pair) iPatchRedirector.redirect((short) 18, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        return MsgUtil.f359547a.E(path);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    public boolean isArkElem(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        return MsgUtil.f359547a.H(elem);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    public boolean isPictureElem(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        return MsgUtil.f359547a.J(elem);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    public boolean isTextElem(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        return MsgUtil.f359547a.K(elem);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    public boolean isVideoElem(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        return MsgUtil.f359547a.L(elem);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public String msgTypeToString(int msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, msgType);
        }
        if (msgType == 31) {
            return "markdown";
        }
        switch (msgType) {
            case 0:
                return "unknown";
            case 1:
                return "null";
            case 2:
                return "mix";
            case 3:
                return "file";
            case 4:
                return "struct";
            case 5:
                return "gray-tips";
            case 6:
                return "ptt";
            case 7:
                return "video";
            case 8:
                return "multi-forward";
            case 9:
                return "reply";
            case 10:
                return QCircleDaTongConstant.ElementParamValue.WALLET;
            case 11:
                return "ark";
            case 12:
                return PoiListCacheRecord.TIMESTAMP_TYPE;
            case 13:
                return "giphy";
            case 14:
                return QCircleDaTongConstant.ElementParamValue.GIFT;
            case 15:
                return "text-gift";
            case 16:
                return WadlProxyConsts.CHANNEL;
            case 17:
                return "market-face";
            case 18:
                return "game-result";
            case 19:
                return "av-record";
            default:
                switch (msgType) {
                    case 21:
                        return "online-file";
                    case 22:
                        return WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY;
                    case 23:
                        return "tofu";
                    case 24:
                        return "face-bubble";
                    case 25:
                        return "share-location";
                    default:
                        return "unknown(" + msgType + ")";
                }
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public Pair<Integer, Integer> scaleSize(int width, int height, float maxPicSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(maxPicSize));
        }
        return MsgUtil.f359547a.N(width, height, maxPicSize);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public ArrayList<com.tencent.qqnt.msg.d> transformMrListToMsgItemList(@NotNull ArrayList<MsgRecord> mrList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mrList);
        }
        Intrinsics.checkNotNullParameter(mrList, "mrList");
        return m.b(mrList);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public com.tencent.qqnt.msg.d transformToIMsgRecord(@NotNull MsgRecord mr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.msg.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mr5);
        }
        Intrinsics.checkNotNullParameter(mr5, "mr");
        return m.c(mr5);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createFaceElement(int faceType, int faceIndex, @NotNull String packId, int imageType, @NotNull String desc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (MsgElement) iPatchRedirector.redirect((short) 27, this, Integer.valueOf(faceType), Integer.valueOf(faceIndex), packId, Integer.valueOf(imageType), desc);
        }
        Intrinsics.checkNotNullParameter(packId, "packId");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return MsgUtil.f359547a.h(faceType, faceIndex, packId, imageType, desc);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createFileElement(@NotNull String path, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (MsgElement) iPatchRedirector.redirect((short) 28, (Object) this, (Object) path, type);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        return MsgUtil.f359547a.j(path, type);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public com.tencent.qqnt.msg.d createMsgItem(@NotNull ArrayList<MsgElement> elements, @NotNull String sendUid, @NotNull String sendNickName, int msgType, int sendType, long msgSeq, @NotNull String peerUid, long msgTime, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (com.tencent.qqnt.msg.d) iPatchRedirector.redirect((short) 34, this, elements, sendUid, sendNickName, Integer.valueOf(msgType), Integer.valueOf(sendType), Long.valueOf(msgSeq), peerUid, Long.valueOf(msgTime), Long.valueOf(msgId));
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(sendUid, "sendUid");
        Intrinsics.checkNotNullParameter(sendNickName, "sendNickName");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return MsgUtil.f359547a.m(elements, sendUid, sendNickName, msgType, sendType, msgSeq, peerUid, msgTime, msgId);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createPicElement(@NotNull String origPath, boolean quality, int subType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (MsgElement) iPatchRedirector.redirect((short) 29, this, origPath, Boolean.valueOf(quality), Integer.valueOf(subType));
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        return MsgUtil.f359547a.o(origPath, quality, subType);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createPttElement(@NotNull String origPath, int duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (MsgElement) iPatchRedirector.redirect((short) 32, (Object) this, (Object) origPath, duration);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        return MsgUtil.f359547a.r(origPath, duration);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createReplyElement(long msgId, @NotNull String senderUidStr, @NotNull String sourceMsgText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (MsgElement) iPatchRedirector.redirect((short) 33, this, Long.valueOf(msgId), senderUidStr, sourceMsgText);
        }
        Intrinsics.checkNotNullParameter(senderUidStr, "senderUidStr");
        Intrinsics.checkNotNullParameter(sourceMsgText, "sourceMsgText");
        return MsgUtil.f359547a.u(msgId, senderUidStr, sourceMsgText);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createTextElement(@NotNull TextElement textElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MsgElement) iPatchRedirector.redirect((short) 5, (Object) this, (Object) textElement);
        }
        Intrinsics.checkNotNullParameter(textElement, "textElement");
        return MsgUtil.f359547a.v(textElement);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public MsgElement createVideoElement(@NotNull String origPath, int subBusiType, boolean quality, @Nullable String thumbPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (MsgElement) iPatchRedirector.redirect((short) 31, this, origPath, Integer.valueOf(subBusiType), Boolean.valueOf(quality), thumbPath);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        return MsgUtil.f359547a.y(origPath, subBusiType, quality, thumbPath);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public CharSequence getElementSummary(@NotNull MsgRecord record, @NotNull e summaryDecoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (CharSequence) iPatchRedirector.redirect((short) 24, (Object) this, (Object) record, (Object) summaryDecoder);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(summaryDecoder, "summaryDecoder");
        return MsgUtil.f359547a.A(record, summaryDecoder);
    }

    @Override // com.tencent.qqnt.msg.api.IMsgUtilApi
    @NotNull
    public String msgTypeToString(@NotNull MsgRecord record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) record);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        return msgTypeToString(record.msgType);
    }
}

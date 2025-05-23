package com.tencent.qqnt.msg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOIncompatiblePicAdapterApi;
import com.tencent.qqnt.compress.api.IPicCompressApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GiphyElement;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentityBytes;
import com.tencent.qqnt.kernel.nativeinterface.GuildMedal;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiTransInfo;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.common.nt_msg_common$Msg;
import tencent.im.msg.element_ext_buf_for_ui$ElementExtBufForUI;
import tencent.im.msg.nt_sys_msg_common$Msg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001e\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\rJ.\u0010)\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\rJ\u0016\u0010*\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010-\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0006J\u001e\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0006J&\u00103\u001a\u00020\t2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u000bJ\u000e\u00104\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rJ[\u0010?\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\r2\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020\u000b2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00020;\u00a2\u0006\u0002\b=J\u000e\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020@J\u001a\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060C2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010E\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rJ(\u0010H\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010\rJ.\u0010N\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u00062\u0016\u0010M\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LJ\u0016\u0010O\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0006J\u000e\u0010R\u001a\u00020\t2\u0006\u0010Q\u001a\u00020PJ\u001e\u0010U\u001a\u00020\t2\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\rJ*\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060C2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u000206J\u0082\u0001\u0010d\u001a\u00020c2\u0016\u0010W\u001a\u0012\u0012\u0004\u0012\u00020\t0Jj\b\u0012\u0004\u0012\u00020\t`L2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010Z\u001a\u00020\u00062\b\b\u0002\u0010[\u001a\u00020\u00062\b\b\u0002\u0010\\\u001a\u00020P2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020P2\u0006\u0010_\u001a\u00020\u00062\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`Jj\u0010e\u001a\u00020c2\u0016\u0010W\u001a\u0012\u0012\u0004\u0012\u00020\t0Jj\b\u0012\u0004\u0012\u00020\t`L2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010Z\u001a\u00020\u00062\b\b\u0002\u0010[\u001a\u00020\u00062\b\b\u0002\u0010\\\u001a\u00020P2\b\b\u0002\u0010]\u001a\u00020\r2\b\b\u0002\u0010^\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020PJ \u0010h\u001a\u0004\u0018\u00010g2\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LJ \u0010j\u001a\u0004\u0018\u00010i2\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`LJ\u000e\u0010l\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\tJ\u000e\u0010n\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\tJ\u000e\u0010o\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\r2\u0006\u0010q\u001a\u00020pJ\u0016\u0010v\u001a\u00020u2\u0006\u0010q\u001a\u00020p2\u0006\u0010t\u001a\u00020sR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010xR7\u0010\u007f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060zj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006`{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010|\u001a\u0004\b}\u0010~R\u001e\u0010\u0082\u0001\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\bB\u0010|\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/qqnt/msg/MsgUtil;", "", "", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", DTConstants.TAG.ELEMENT, "", "type", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "f", "", "I", "", "path", "D", BdhLogUtil.LogTag.Tag_Conn, "origPath", "elementType", "elementSubType", "a", "thumbSpec", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", "arkElement", "M", "content", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "textElement", "v", "name", "uid", "e", "faceType", "index", "desc", "g", "faceIndex", "packId", NodeProps.CUSTOM_PROP_IMAGE_TYPE, tl.h.F, "j", CustomImageProps.QUALITY, QCircleLpReportDc010001.KEY_SUBTYPE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "id", "width", "height", "isClip", "l", "i", "textSummary", "", "maxPicSize", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "isFlashPic", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "Lkotlin/ExtensionFunctionType;", "picExt", "p", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "d", "Lkotlin/Pair;", "E", HippyTKDListViewAdapter.X, "subBusiType", "thumbPath", "y", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", ReportConstant.COSTREPORT_PREFIX, "r", "", "msgId", "t", "senderUidStr", "sourceMsgText", "u", "N", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "sendUid", "sendNickName", QQBrowserActivity.KEY_MSG_TYPE, "sendType", "msgSeq", "peerUid", "msgTime", "roleType", "Lcom/tencent/qqnt/kernel/nativeinterface/FromRoleInfo;", "fromChannelRoleInfo", "fromGuildRoleInfo", "Lcom/tencent/qqnt/msg/d;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgBuf", "Ltencent/im/common/nt_msg_common$Msg;", "c", "Ltencent/im/msg/nt_sys_msg_common$Msg;", "b", "elem", "K", "J", "L", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "B", "Lcom/tencent/qqnt/msg/e;", "summaryDecoder", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/msg/c;", "Lcom/tencent/qqnt/msg/c;", "sCompressModule", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lkotlin/Lazy;", UserInfo.SEX_FEMALE, "()Ljava/util/HashMap;", "picTypeMap", "getPicCompressLongEdge", "()I", "picCompressLongEdge", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MsgUtil f359547a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Service/Msg/Inject_CompressModule.yml", version = 1)
    @Nullable
    private static c sCompressModule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy picTypeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy picCompressLongEdge;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList f359551e;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f359551e = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.m.class);
        MsgUtil msgUtil = new MsgUtil();
        f359547a = msgUtil;
        msgUtil.G();
        lazy = LazyKt__LazyJVMKt.lazy(MsgUtil$picTypeMap$2.INSTANCE);
        picTypeMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(MsgUtil$picCompressLongEdge$2.INSTANCE);
        picCompressLongEdge = lazy2;
    }

    MsgUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String C(String path) {
        int lastIndexOf$default;
        if (!TextUtils.isEmpty(path)) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null);
            String substring = path.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    private final int D(String path) {
        String e16 = com.tencent.qqnt.util.file.a.e(path);
        if (QLog.isColorLevel()) {
            QLog.d("MsgUtil", 2, "getImageType fileType: " + e16);
        }
        Integer num = F().get(e16);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final HashMap<String, Integer> F() {
        return (HashMap) picTypeMap.getValue();
    }

    @QAutoInitMethod
    private final void G() {
        sCompressModule = (c) com.tencent.mobileqq.qroute.utils.b.a(f359551e);
    }

    private final boolean I() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("multi_forward_picture_switch", true);
    }

    private final String M(ArkElement arkElement) {
        String str;
        try {
            if (arkElement != null) {
                str = arkElement.bytesData;
            } else {
                str = null;
            }
            String optString = new JSONObject(str).optString("prompt");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonRoot.optString(\"prompt\")");
            return optString;
        } catch (Exception e16) {
            QLog.e("MsgExt", 4, String.valueOf(e16));
            return "[Ark]";
        }
    }

    private final String a(String origPath, int elementType, int elementSubType) {
        String str;
        String r16 = cq.r(origPath);
        w e16 = f.e();
        if (e16 != null) {
            str = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(elementType, elementSubType, r16, C(origPath), 1, 0, null, "", true));
        } else {
            str = null;
        }
        if (!cq.n(str)) {
            com.tencent.qqnt.util.file.a.b(origPath, str);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final MsgElement f() {
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 0;
        return msgElement;
    }

    private final void k(FileElement element, int type) {
        HashMap<Integer, String> hashMapOf;
        HashMap<Integer, String> hashMapOf2;
        if (type != 0) {
            if (type == 2) {
                c cVar = sCompressModule;
                Intrinsics.checkNotNull(cVar);
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(currentTimeMillis);
                String a16 = cVar.a(sb5.toString(), "jpg");
                FileOutputStream fileOutputStream = new FileOutputStream(a16);
                try {
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(element.filePath);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                        if (frameAtTime != null) {
                            frameAtTime.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e16) {
                        QLog.e("MsgUtil", 1, e16, new Object[0]);
                    }
                    fileOutputStream.close();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    BitmapFactory.decodeFile(a16, options);
                    element.picHeight = Integer.valueOf(options.outHeight);
                    element.picWidth = Integer.valueOf(options.outWidth);
                    hashMapOf2 = MapsKt__MapsKt.hashMapOf(new Pair(750, a16));
                    element.picThumbPath = hashMapOf2;
                    return;
                } catch (Throwable th5) {
                    fileOutputStream.close();
                    throw th5;
                }
            }
            return;
        }
        c cVar2 = sCompressModule;
        Intrinsics.checkNotNull(cVar2);
        String str = element.filePath;
        Intrinsics.checkNotNullExpressionValue(str, "element.filePath");
        String b16 = cVar2.b(str);
        Pair<Integer, Integer> E = E(b16);
        int intValue = E.component1().intValue();
        element.picHeight = Integer.valueOf(E.component2().intValue());
        element.picWidth = Integer.valueOf(intValue);
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(750, b16));
        element.picThumbPath = hashMapOf;
    }

    private final String z(String origPath, int elementType, int thumbSpec) {
        String str;
        String r16 = cq.r(origPath);
        w e16 = f.e();
        if (e16 != null) {
            str = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(elementType, 1, r16, C(origPath), 2, thumbSpec, null, "", true));
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgUtil", 2, "generateThumbFile thumbPath: " + str);
        }
        if (cq.n(str)) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        if (elementType == 5) {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(origPath);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    if (frameAtTime != null) {
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e17) {
                    QLog.e("MsgUtil", 1, e17, new Object[0]);
                }
            } finally {
                fileOutputStream.close();
            }
        } else {
            com.tencent.qqnt.util.file.a.b(origPath, str);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r2 == null) goto L26;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence A(@NotNull MsgRecord record, @NotNull e summaryDecoder) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (CharSequence) iPatchRedirector.redirect((short) 33, (Object) this, (Object) record, (Object) summaryDecoder);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(summaryDecoder, "summaryDecoder");
        if (record.elements.size() == 0) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<MsgElement> arrayList = record.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "record.elements");
        for (MsgElement element : arrayList) {
            Intrinsics.checkNotNullExpressionValue(element, "element");
            CharSequence a16 = summaryDecoder.a(element);
            if (a16 != null) {
                spannableStringBuilder.append(a16);
            } else if (element.elementType == 6) {
                spannableStringBuilder.append((CharSequence) "[\u8868\u60c5]");
            } else {
                MsgUtil msgUtil = f359547a;
                if (msgUtil.K(element)) {
                    String content = element.textElement.content;
                    if (content != null) {
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        str = StringsKt__StringsJVMKt.replace$default(content, "\r", "\n", false, 4, (Object) null);
                    }
                    str = "";
                    spannableStringBuilder.append((CharSequence) str);
                } else if (msgUtil.J(element)) {
                    spannableStringBuilder.append((CharSequence) GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
                } else if (msgUtil.L(element)) {
                    spannableStringBuilder.append((CharSequence) "[\u89c6\u9891]");
                } else if (msgUtil.H(element)) {
                    spannableStringBuilder.append((CharSequence) msgUtil.M(element.arkElement));
                } else if (element.elementType == 3) {
                    spannableStringBuilder.append((CharSequence) GuildMsgElementApiImpl.DESC_ELEMENT_FILE);
                    spannableStringBuilder.append((CharSequence) element.fileElement.fileName);
                }
            }
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0075, code lost:
    
        if (r2 == null) goto L23;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String B(@NotNull MsgRecord record) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this, (Object) record);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        if (record.elements.size() == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        ArrayList<MsgElement> arrayList = record.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "record.elements");
        for (MsgElement element : arrayList) {
            if (element.elementType == 6) {
                sb5.append("[\u8868\u60c5]");
            } else {
                MsgUtil msgUtil = f359547a;
                Intrinsics.checkNotNullExpressionValue(element, "element");
                if (msgUtil.K(element)) {
                    String content = element.textElement.content;
                    if (content != null) {
                        Intrinsics.checkNotNullExpressionValue(content, "content");
                        str = StringsKt__StringsJVMKt.replace$default(content, "\r", "\n", false, 4, (Object) null);
                    }
                    str = "";
                    sb5.append(str);
                } else if (msgUtil.J(element)) {
                    sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
                } else if (msgUtil.L(element)) {
                    sb5.append("[\u89c6\u9891]");
                } else if (msgUtil.H(element)) {
                    sb5.append(msgUtil.M(element.arkElement));
                } else if (element.elementType == 3) {
                    sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_FILE);
                    sb5.append(element.fileElement.fileName);
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @NotNull
    public final Pair<Integer, Integer> E(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Pair) iPatchRedirector.redirect((short) 14, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        int i3 = 0;
        try {
            i3 = new android.media.ExifInterface(path).getAttributeInt("Orientation", 0);
        } catch (Exception unused) {
        }
        if (i3 != 6 && i3 != 8) {
            return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
        return new Pair<>(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
    }

    public final boolean H(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 10) {
            return true;
        }
        return false;
    }

    public final boolean J(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 2) {
            return true;
        }
        return false;
    }

    public final boolean K(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        int i3 = elem.elementType;
        if (i3 == 1 || i3 == 6) {
            return true;
        }
        return false;
    }

    public final boolean L(@NotNull MsgElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) elem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 5) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Pair<Integer, Integer> N(int width, int height, float maxPicSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Pair) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(maxPicSize));
        }
        float f16 = width;
        if (f16 > maxPicSize || height > maxPicSize) {
            float f17 = height;
            float max = Math.max(f16 / maxPicSize, f17 / maxPicSize);
            height = (int) (f17 / max);
            width = (int) (f16 / max);
        }
        if (width <= 0) {
            width = (int) maxPicSize;
        }
        if (height <= 0) {
            height = (int) maxPicSize;
        }
        return new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
    }

    @Nullable
    public final nt_sys_msg_common$Msg b(@NotNull ArrayList<Byte> msgBuf) {
        byte[] byteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (nt_sys_msg_common$Msg) iPatchRedirector.redirect((short) 27, (Object) this, (Object) msgBuf);
        }
        Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
        nt_sys_msg_common$Msg nt_sys_msg_common_msg = new nt_sys_msg_common$Msg();
        try {
            byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
            nt_sys_msg_common_msg.mergeFrom(byteArray);
            return nt_sys_msg_common_msg;
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgUtil", 2, "convertC2cGroupMsgCommPB fail", e16);
                return null;
            }
            return null;
        }
    }

    @Nullable
    public final nt_msg_common$Msg c(@NotNull ArrayList<Byte> msgBuf) {
        byte[] byteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (nt_msg_common$Msg) iPatchRedirector.redirect((short) 26, (Object) this, (Object) msgBuf);
        }
        Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
        nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
        try {
            byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
            nt_msg_common_msg.mergeFrom(byteArray);
            return nt_msg_common_msg;
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgUtil", 2, "convertMsgCommPB fail", e16);
                return null;
            }
            return null;
        }
    }

    @NotNull
    public final MsgElement d(@NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MsgElement) iPatchRedirector.redirect((short) 13, (Object) this, (Object) arkMsgModel);
        }
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        ArkElement arkElement = new ArkElement(arkMsgModel.r(), null, null);
        if (QLog.isColorLevel()) {
            QLog.d("MsgUtil", 2, "createArkElement " + arkElement);
        }
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 10;
        msgElement.arkElement = arkElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement e(@NotNull String name, @NotNull String uid, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgElement) iPatchRedirector.redirect((short) 4, this, name, uid, Integer.valueOf(type));
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uid, "uid");
        TextElement textElement = new TextElement();
        textElement.content = name;
        textElement.atNtUid = uid;
        textElement.atType = type;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 1;
        msgElement.textElement = textElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement g(int faceType, int index, @NotNull String desc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MsgElement) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(faceType), Integer.valueOf(index), desc);
        }
        Intrinsics.checkNotNullParameter(desc, "desc");
        FaceElement faceElement = new FaceElement();
        faceElement.faceType = faceType;
        faceElement.faceIndex = index;
        faceElement.faceText = desc;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 6;
        msgElement.faceElement = faceElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement h(int faceType, int faceIndex, @NotNull String packId, int imageType, @NotNull String desc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MsgElement) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(faceType), Integer.valueOf(faceIndex), packId, Integer.valueOf(imageType), desc);
        }
        Intrinsics.checkNotNullParameter(packId, "packId");
        Intrinsics.checkNotNullParameter(desc, "desc");
        FaceElement faceElement = new FaceElement();
        faceElement.faceText = desc;
        faceElement.faceType = faceType;
        if (faceType == 4) {
            faceElement.faceIndex = a.f359552a.a(Integer.parseInt(packId), faceIndex);
            faceElement.imageType = Integer.valueOf(imageType);
        } else {
            faceElement.faceIndex = faceIndex;
        }
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 6;
        msgElement.faceElement = faceElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement i(@NotNull String path) {
        int lastIndexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MsgElement) iPatchRedirector.redirect((short) 11, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        String r16 = cq.r(path);
        long v3 = cq.v(path);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null);
        String substring = path.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        FileElement fileElement = new FileElement();
        fileElement.fileMd5 = r16;
        fileElement.fileName = substring;
        fileElement.filePath = path;
        fileElement.fileSize = v3;
        fileElement.picWidth = 0;
        fileElement.picHeight = 0;
        fileElement.videoDuration = 0;
        fileElement.picThumbPath = new HashMap<>();
        fileElement.expireTime = 0L;
        fileElement.fileSha = "";
        fileElement.fileSha3 = "";
        fileElement.file10MMd5 = "";
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 3;
        msgElement.fileElement = fileElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement j(@NotNull String path, int type) {
        int lastIndexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MsgElement) iPatchRedirector.redirect((short) 7, (Object) this, (Object) path, type);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        String r16 = cq.r(path);
        long v3 = cq.v(path);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null);
        String substring = path.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        FileElement fileElement = new FileElement();
        fileElement.fileMd5 = r16;
        fileElement.fileName = substring;
        fileElement.filePath = path;
        fileElement.fileSize = v3;
        fileElement.picWidth = 0;
        fileElement.picHeight = 0;
        fileElement.videoDuration = 0;
        fileElement.picThumbPath = new HashMap<>();
        fileElement.expireTime = 0L;
        fileElement.fileSha = "";
        fileElement.fileSha3 = "";
        fileElement.file10MMd5 = "";
        if (sCompressModule != null) {
            k(fileElement, type);
        }
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 3;
        msgElement.fileElement = fileElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement l(@NotNull String id5, int width, int height, boolean isClip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MsgElement) iPatchRedirector.redirect((short) 10, this, id5, Integer.valueOf(width), Integer.valueOf(height), Boolean.valueOf(isClip));
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        GiphyElement giphyElement = new GiphyElement(id5, isClip, width, height);
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 15;
        msgElement.giphyElement = giphyElement;
        return msgElement;
    }

    @NotNull
    public final d m(@NotNull ArrayList<MsgElement> elements, @NotNull String sendUid, @NotNull String sendNickName, int msgType, int sendType, long msgSeq, @NotNull String peerUid, long msgTime, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (d) iPatchRedirector.redirect((short) 25, this, elements, sendUid, sendNickName, Integer.valueOf(msgType), Integer.valueOf(sendType), Long.valueOf(msgSeq), peerUid, Long.valueOf(msgTime), Long.valueOf(msgId));
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(sendUid, "sendUid");
        Intrinsics.checkNotNullParameter(sendNickName, "sendNickName");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        GuildMedal guildMedal = new GuildMedal();
        guildMedal.startTime = 0L;
        guildMedal.endTime = 0L;
        guildMedal.url = "";
        guildMedal.desc = "";
        Unit unit = Unit.INSTANCE;
        return j.INSTANCE.a(new MsgRecord(msgId, 0L, msgSeq, 0L, 0, msgType, 0, sendType, sendUid, peerUid, "", "", 0L, 0L, 0L, msgTime, new byte[0], 0, "", "", sendNickName, "", "", elements, new ArrayList(), new ArrayList(), 0L, 0, new ArrayList(), "", new FreqLimitInfo(0, 0, 0L), false, "", "", "", 0L, 0L, new GuildClientIdentity(0, "", new GuildClientIdentityBytes()), false, 0, 0, new FromRoleInfo(), new FromRoleInfo(), new FromRoleInfo(), 0L, false, new byte[0], 0L, 0, new FoldingInfo(), new MultiTransInfo(), 0L, 0L, new HashMap(), new AnonymousExtInfo(), 0, 0, new byte[0], guildMedal, 0, new byte[0]));
    }

    @NotNull
    public final d n(@NotNull ArrayList<MsgElement> elements, @NotNull String sendUid, @NotNull String sendNickName, int msgType, int sendType, long msgSeq, @NotNull String peerUid, long msgTime, long msgId, int roleType, @NotNull FromRoleInfo fromChannelRoleInfo, @NotNull FromRoleInfo fromGuildRoleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (d) iPatchRedirector.redirect((short) 24, this, elements, sendUid, sendNickName, Integer.valueOf(msgType), Integer.valueOf(sendType), Long.valueOf(msgSeq), peerUid, Long.valueOf(msgTime), Long.valueOf(msgId), Integer.valueOf(roleType), fromChannelRoleInfo, fromGuildRoleInfo);
        }
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(sendUid, "sendUid");
        Intrinsics.checkNotNullParameter(sendNickName, "sendNickName");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(fromChannelRoleInfo, "fromChannelRoleInfo");
        Intrinsics.checkNotNullParameter(fromGuildRoleInfo, "fromGuildRoleInfo");
        GuildMedal guildMedal = new GuildMedal();
        guildMedal.startTime = 0L;
        guildMedal.endTime = 0L;
        guildMedal.url = "";
        guildMedal.desc = "";
        Unit unit = Unit.INSTANCE;
        return j.INSTANCE.a(new MsgRecord(msgId, 0L, msgSeq, 0L, 0, msgType, 0, sendType, sendUid, peerUid, "", "", 0L, 0L, 0L, msgTime, new byte[0], 0, "", "", sendNickName, "", "", elements, new ArrayList(), new ArrayList(), 0L, 0, new ArrayList(), "", new FreqLimitInfo(0, 0, 0L), false, "", "", "", 0L, 0L, new GuildClientIdentity(0, "", new GuildClientIdentityBytes()), false, 0, roleType, fromChannelRoleInfo, fromGuildRoleInfo, new FromRoleInfo(), 0L, false, new byte[0], 0L, 0, new FoldingInfo(), new MultiTransInfo(), 0L, 0L, new HashMap(), new AnonymousExtInfo(), 0, 0, new byte[0], guildMedal, 0, new byte[0]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (com.tencent.qqnt.kernel.nativeinterface.cq.n(r3) != false) goto L20;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MsgElement o(@NotNull String origPath, boolean quality, int subType) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MsgElement) iPatchRedirector.redirect((short) 9, this, origPath, Boolean.valueOf(quality), Integer.valueOf(subType));
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        if (!quality) {
            c cVar = sCompressModule;
            if (cVar == null || (str = cVar.b(origPath)) == null) {
                str = origPath;
            }
        }
        str = origPath;
        String r16 = cq.r(str);
        w e16 = f.e();
        String str3 = null;
        if (e16 != null) {
            str2 = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r16, C(str), 1, 0, null, "", true));
        } else {
            str2 = null;
        }
        w e17 = f.e();
        if (e17 != null) {
            str3 = e17.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r16, C(str), 2, 720, null, "", true));
        }
        com.tencent.qqnt.util.file.a.b(str, str2);
        com.tencent.qqnt.util.file.a.b(str, str3);
        Pair<Integer, Integer> E = E(origPath);
        int intValue = E.component1().intValue();
        int intValue2 = E.component2().intValue();
        PicElement picElement = new PicElement();
        picElement.sourcePath = str;
        picElement.picSubType = subType;
        MsgUtil msgUtil = f359547a;
        picElement.fileName = msgUtil.C(str);
        picElement.fileSize = cq.v(str);
        picElement.picWidth = intValue;
        picElement.picHeight = intValue2;
        picElement.original = quality;
        picElement.md5HexStr = r16;
        picElement.picType = Integer.valueOf(msgUtil.D(origPath));
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 2;
        msgElement.picElement = picElement;
        return msgElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0151  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MsgElement p(@NotNull String origPath, boolean quality, int subType, @Nullable String textSummary, float maxPicSize, @Nullable com.tencent.qqnt.msg.data.g picExtBizInfo, boolean isFlashPic, @NotNull Function1<? super PicElement, Unit> picExt) {
        String generateCompatiblePic;
        String str;
        String richMediaFilePathForMobileQQSend;
        String str2;
        String str3;
        String str4;
        String str5;
        String richMediaFilePathForMobileQQSend2;
        String str6;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MsgElement) iPatchRedirector.redirect((short) 12, this, origPath, Boolean.valueOf(quality), Integer.valueOf(subType), textSummary, Float.valueOf(maxPicSize), picExtBizInfo, Boolean.valueOf(isFlashPic), picExt);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        Intrinsics.checkNotNullParameter(picExt, "picExt");
        w e16 = f.e();
        if (e16 == null) {
            QLog.w("MsgUtil", 1, "[createPicElement] msg service is null");
            return f();
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        String compressPic = ((IPicCompressApi) companion.a(IPicCompressApi.class)).compressPic(quality, origPath);
        if (!cq.n(compressPic) && I()) {
            QLog.e("MsgUtil", 1, "compressedPath=" + ((Object) compressPic) + ", origPath=" + origPath);
            compressPic = origPath;
        }
        if (quality) {
            try {
                generateCompatiblePic = ((IAIOIncompatiblePicAdapterApi) companion.a(IAIOIncompatiblePicAdapterApi.class)).generateCompatiblePic(compressPic);
            } catch (Throwable unused) {
            }
            if (!Intrinsics.areEqual(compressPic, generateCompatiblePic)) {
                if (cq.n(generateCompatiblePic)) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgUtil", 2, "[createPicElement] generated a new compatible pic success!");
                        }
                        str = generateCompatiblePic;
                    } catch (Throwable unused2) {
                        compressPic = generateCompatiblePic;
                        QLog.e("MsgUtil", 2, "[createPicElement] generateCompatiblePic error!", compressPic);
                        str = compressPic;
                        String r16 = cq.r(str);
                        String str7 = str;
                        richMediaFilePathForMobileQQSend = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r16, C(str), 1, 0, null, "", true));
                        if (TextUtils.isEmpty(richMediaFilePathForMobileQQSend)) {
                        }
                        IPicCompressApi iPicCompressApi = (IPicCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicCompressApi.class);
                        if (TextUtils.isEmpty(str3)) {
                        }
                        str5 = origPath;
                        String generateThumbPic = iPicCompressApi.generateThumbPic(str5);
                        String r17 = cq.r(generateThumbPic);
                        String str8 = str4;
                        String str9 = str3;
                        String str10 = str2;
                        richMediaFilePathForMobileQQSend2 = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r17, C(generateThumbPic), 2, 720, null, "", true));
                        if (TextUtils.isEmpty(richMediaFilePathForMobileQQSend2)) {
                        }
                        if (!MsgExtKt.v(subType)) {
                        }
                        z16 = quality;
                        Pair<Integer, Integer> E = E(str9);
                        int intValue = E.component1().intValue();
                        int intValue2 = E.component2().intValue();
                        PicElement picElement = new PicElement();
                        picElement.sourcePath = str9;
                        picElement.picSubType = subType;
                        picElement.summary = textSummary;
                        MsgUtil msgUtil = f359547a;
                        picElement.fileName = msgUtil.C(str9);
                        picElement.fileSize = cq.v(str9);
                        picElement.picWidth = intValue;
                        picElement.picHeight = intValue2;
                        picElement.original = z16;
                        picElement.md5HexStr = str10;
                        picElement.picType = Integer.valueOf(msgUtil.D(str9));
                        picElement.isFlashPic = Boolean.valueOf(isFlashPic);
                        picExt.invoke(picElement);
                        if (QLog.isColorLevel()) {
                        }
                        if (picExtBizInfo != null) {
                        }
                        MsgElement msgElement = new MsgElement();
                        msgElement.elementType = 2;
                        msgElement.picElement = picElement;
                        return msgElement;
                    }
                    String r162 = cq.r(str);
                    String str72 = str;
                    richMediaFilePathForMobileQQSend = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r162, C(str), 1, 0, null, "", true));
                    if (TextUtils.isEmpty(richMediaFilePathForMobileQQSend)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("ntOrigPath is empty! subType=");
                        sb5.append(subType);
                        sb5.append(", compressedPathMd5=");
                        str2 = r162;
                        sb5.append(str2);
                        sb5.append(", compressedPath=");
                        str3 = str72;
                        sb5.append((Object) str3);
                        str4 = "MsgUtil";
                        QLog.e(str4, 1, sb5.toString());
                    } else {
                        str2 = r162;
                        str3 = str72;
                        str4 = "MsgUtil";
                        if (!Intrinsics.areEqual(str3, richMediaFilePathForMobileQQSend) && !Intrinsics.areEqual(str2, cq.r(richMediaFilePathForMobileQQSend))) {
                            com.tencent.qqnt.util.file.a.b(str3, richMediaFilePathForMobileQQSend);
                        }
                    }
                    IPicCompressApi iPicCompressApi2 = (IPicCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicCompressApi.class);
                    if (TextUtils.isEmpty(str3) && new File(str3).exists()) {
                        str5 = str3;
                    } else {
                        str5 = origPath;
                    }
                    String generateThumbPic2 = iPicCompressApi2.generateThumbPic(str5);
                    String r172 = cq.r(generateThumbPic2);
                    String str82 = str4;
                    String str92 = str3;
                    String str102 = str2;
                    richMediaFilePathForMobileQQSend2 = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r172, C(generateThumbPic2), 2, 720, null, "", true));
                    if (TextUtils.isEmpty(richMediaFilePathForMobileQQSend2)) {
                        str6 = str82;
                        QLog.e(str6, 1, "ntThumbPath is empty!");
                    } else {
                        str6 = str82;
                        if (!Intrinsics.areEqual(generateThumbPic2, richMediaFilePathForMobileQQSend2) && !Intrinsics.areEqual(r172, cq.r(richMediaFilePathForMobileQQSend2))) {
                            com.tencent.qqnt.util.file.a.b(generateThumbPic2, richMediaFilePathForMobileQQSend2);
                        }
                    }
                    if (!MsgExtKt.v(subType) && subType != 11) {
                        z16 = false;
                    } else {
                        z16 = quality;
                    }
                    Pair<Integer, Integer> E2 = E(str92);
                    int intValue3 = E2.component1().intValue();
                    int intValue22 = E2.component2().intValue();
                    PicElement picElement2 = new PicElement();
                    picElement2.sourcePath = str92;
                    picElement2.picSubType = subType;
                    picElement2.summary = textSummary;
                    MsgUtil msgUtil2 = f359547a;
                    picElement2.fileName = msgUtil2.C(str92);
                    picElement2.fileSize = cq.v(str92);
                    picElement2.picWidth = intValue3;
                    picElement2.picHeight = intValue22;
                    picElement2.original = z16;
                    picElement2.md5HexStr = str102;
                    picElement2.picType = Integer.valueOf(msgUtil2.D(str92));
                    picElement2.isFlashPic = Boolean.valueOf(isFlashPic);
                    picExt.invoke(picElement2);
                    if (QLog.isColorLevel()) {
                        QLog.d(str6, 2, "[createPicElement] picSubType=" + picElement2.picSubType + " original=" + picElement2.original + " sourcePath=" + picElement2.sourcePath);
                    }
                    if (picExtBizInfo != null) {
                        picElement2.emojiFrom = picExtBizInfo.c();
                        picElement2.emojiWebUrl = picExtBizInfo.e();
                        picElement2.emojiAd = picExtBizInfo.b();
                        picElement2.emojiMall = picExtBizInfo.d();
                        picElement2.emojiZplan = picExtBizInfo.f();
                        picElement2.picSubSubType = picExtBizInfo.g();
                        picElement2.templateID = picExtBizInfo.a();
                    }
                    MsgElement msgElement2 = new MsgElement();
                    msgElement2.elementType = 2;
                    msgElement2.picElement = picElement2;
                    return msgElement2;
                }
            }
        }
        str = compressPic;
        String r1622 = cq.r(str);
        String str722 = str;
        richMediaFilePathForMobileQQSend = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r1622, C(str), 1, 0, null, "", true));
        if (TextUtils.isEmpty(richMediaFilePathForMobileQQSend)) {
        }
        IPicCompressApi iPicCompressApi22 = (IPicCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicCompressApi.class);
        if (TextUtils.isEmpty(str3)) {
        }
        str5 = origPath;
        String generateThumbPic22 = iPicCompressApi22.generateThumbPic(str5);
        String r1722 = cq.r(generateThumbPic22);
        String str822 = str4;
        String str922 = str3;
        String str1022 = str2;
        richMediaFilePathForMobileQQSend2 = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(2, subType, r1722, C(generateThumbPic22), 2, 720, null, "", true));
        if (TextUtils.isEmpty(richMediaFilePathForMobileQQSend2)) {
        }
        if (!MsgExtKt.v(subType)) {
        }
        z16 = quality;
        Pair<Integer, Integer> E22 = E(str922);
        int intValue32 = E22.component1().intValue();
        int intValue222 = E22.component2().intValue();
        PicElement picElement22 = new PicElement();
        picElement22.sourcePath = str922;
        picElement22.picSubType = subType;
        picElement22.summary = textSummary;
        MsgUtil msgUtil22 = f359547a;
        picElement22.fileName = msgUtil22.C(str922);
        picElement22.fileSize = cq.v(str922);
        picElement22.picWidth = intValue32;
        picElement22.picHeight = intValue222;
        picElement22.original = z16;
        picElement22.md5HexStr = str1022;
        picElement22.picType = Integer.valueOf(msgUtil22.D(str922));
        picElement22.isFlashPic = Boolean.valueOf(isFlashPic);
        picExt.invoke(picElement22);
        if (QLog.isColorLevel()) {
        }
        if (picExtBizInfo != null) {
        }
        MsgElement msgElement22 = new MsgElement();
        msgElement22.elementType = 2;
        msgElement22.picElement = picElement22;
        return msgElement22;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MsgElement q(@NotNull String origPath, boolean quality, int subType) {
        String str;
        w e16;
        String str2;
        String str3;
        String str4;
        w e17;
        String str5;
        String str6;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MsgElement) iPatchRedirector.redirect((short) 8, this, origPath, Boolean.valueOf(quality), Integer.valueOf(subType));
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        if (!quality) {
            c cVar = sCompressModule;
            if (cVar == null || (str7 = cVar.b(origPath)) == null) {
                str7 = origPath;
            }
            if (cq.n(str7)) {
                str = str7;
                String r16 = cq.r(str);
                e16 = f.e();
                String str8 = null;
                if (e16 == null) {
                    str2 = r16;
                    str3 = str;
                    str4 = e16.getRichMediaFilePathForGuild(new RichMediaFilePathInfo(2, subType, r16, C(str), 1, 0, null, "", true));
                } else {
                    str2 = r16;
                    str3 = str;
                    str4 = null;
                }
                e17 = f.e();
                if (e17 != null) {
                    str8 = e17.getRichMediaFilePathForGuild(new RichMediaFilePathInfo(2, subType, str2, C(str3), 2, 720, null, "", true));
                }
                str5 = str8;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[createPicElementForGuild] originPath: ");
                sb5.append(origPath);
                sb5.append(", quality: ");
                sb5.append(quality);
                sb5.append(", subType: ");
                str6 = str3;
                sb5.append(subType);
                sb5.append(", sendPicPath: ");
                sb5.append(str6);
                sb5.append(", ntOrigPath: ");
                sb5.append(str4);
                sb5.append(", ntThumbPath: ");
                sb5.append(str5);
                QLog.i("MsgUtil", 1, sb5.toString());
                if (!Intrinsics.areEqual(str6, str4) && !TextUtils.isEmpty(str4)) {
                    com.tencent.qqnt.util.file.a.b(str6, str4);
                }
                if (!Intrinsics.areEqual(str6, str5) && !TextUtils.isEmpty(str5)) {
                    com.tencent.qqnt.util.file.a.b(str6, str5);
                }
                Pair<Integer, Integer> E = E(origPath);
                int intValue = E.component1().intValue();
                int intValue2 = E.component2().intValue();
                PicElement picElement = new PicElement();
                picElement.sourcePath = str6;
                picElement.picSubType = subType;
                MsgUtil msgUtil = f359547a;
                picElement.fileName = msgUtil.C(str6);
                picElement.fileSize = cq.v(str6);
                picElement.picWidth = intValue;
                picElement.picHeight = intValue2;
                picElement.original = quality;
                picElement.md5HexStr = str2;
                picElement.picType = Integer.valueOf(msgUtil.D(origPath));
                MsgElement msgElement = new MsgElement();
                msgElement.elementType = 2;
                msgElement.picElement = picElement;
                return msgElement;
            }
        }
        str = origPath;
        String r162 = cq.r(str);
        e16 = f.e();
        String str82 = null;
        if (e16 == null) {
        }
        e17 = f.e();
        if (e17 != null) {
        }
        str5 = str82;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("[createPicElementForGuild] originPath: ");
        sb52.append(origPath);
        sb52.append(", quality: ");
        sb52.append(quality);
        sb52.append(", subType: ");
        str6 = str3;
        sb52.append(subType);
        sb52.append(", sendPicPath: ");
        sb52.append(str6);
        sb52.append(", ntOrigPath: ");
        sb52.append(str4);
        sb52.append(", ntThumbPath: ");
        sb52.append(str5);
        QLog.i("MsgUtil", 1, sb52.toString());
        if (!Intrinsics.areEqual(str6, str4)) {
            com.tencent.qqnt.util.file.a.b(str6, str4);
        }
        if (!Intrinsics.areEqual(str6, str5)) {
            com.tencent.qqnt.util.file.a.b(str6, str5);
        }
        Pair<Integer, Integer> E2 = E(origPath);
        int intValue3 = E2.component1().intValue();
        int intValue22 = E2.component2().intValue();
        PicElement picElement2 = new PicElement();
        picElement2.sourcePath = str6;
        picElement2.picSubType = subType;
        MsgUtil msgUtil2 = f359547a;
        picElement2.fileName = msgUtil2.C(str6);
        picElement2.fileSize = cq.v(str6);
        picElement2.picWidth = intValue3;
        picElement2.picHeight = intValue22;
        picElement2.original = quality;
        picElement2.md5HexStr = str2;
        picElement2.picType = Integer.valueOf(msgUtil2.D(origPath));
        MsgElement msgElement2 = new MsgElement();
        msgElement2.elementType = 2;
        msgElement2.picElement = picElement2;
        return msgElement2;
    }

    @NotNull
    public final MsgElement r(@NotNull String origPath, int time) {
        String str;
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (MsgElement) iPatchRedirector.redirect((short) 18, (Object) this, (Object) origPath, time);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        String r16 = cq.r(origPath);
        w e16 = f.e();
        if (e16 == null || (str = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(4, 0, r16, C(origPath), 1, 0, null, "", true))) == null) {
            str = "";
        }
        if (!cq.n(str)) {
            com.tencent.qqnt.util.file.a.b(origPath, str);
        }
        PttElement pttElement = new PttElement();
        pttElement.fileName = f359547a.C(str);
        pttElement.filePath = str;
        pttElement.md5HexStr = cq.r(str);
        pttElement.fileSize = cq.v(str);
        roundToInt = MathKt__MathJVMKt.roundToInt(time / 1000.0f);
        pttElement.duration = roundToInt;
        pttElement.formatType = 1;
        pttElement.voiceType = 2;
        pttElement.voiceChangeType = 0;
        pttElement.canConvert2Text = false;
        pttElement.fileId = 0;
        pttElement.fileUuid = "";
        pttElement.text = "";
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 4;
        msgElement.pttElement = pttElement;
        return msgElement;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
    
        if (r15 == null) goto L14;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MsgElement s(@NotNull String origPath, int time, @NotNull ArrayList<Byte> audioData) {
        String str;
        String str2;
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (MsgElement) iPatchRedirector.redirect((short) 17, this, origPath, Integer.valueOf(time), audioData);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        String r16 = cq.r(origPath);
        w e16 = f.e();
        if (e16 != null) {
            str = "";
            str2 = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(4, 3, r16, C(origPath), 1, 0, null, "", true));
        } else {
            str = "";
        }
        str2 = str;
        if (!cq.n(str2)) {
            com.tencent.qqnt.util.file.a.b(origPath, str2);
        }
        PttElement pttElement = new PttElement();
        pttElement.fileName = f359547a.C(str2);
        pttElement.filePath = str2;
        pttElement.md5HexStr = cq.r(str2);
        pttElement.fileSize = cq.v(str2);
        roundToInt = MathKt__MathJVMKt.roundToInt(time / 1000.0f);
        pttElement.duration = roundToInt;
        pttElement.formatType = 1;
        pttElement.voiceType = 2;
        pttElement.voiceChangeType = 0;
        pttElement.canConvert2Text = false;
        pttElement.fileId = 0;
        String str3 = str;
        pttElement.fileUuid = str3;
        pttElement.text = str3;
        pttElement.waveAmplitudes = audioData;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 4;
        msgElement.pttElement = pttElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement t(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (MsgElement) iPatchRedirector.redirect((short) 19, (Object) this, msgId);
        }
        ReplyElement replyElement = new ReplyElement();
        replyElement.replayMsgId = msgId;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 7;
        msgElement.replyElement = replyElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement u(long msgId, @NotNull String senderUidStr, @NotNull String sourceMsgText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (MsgElement) iPatchRedirector.redirect((short) 20, this, Long.valueOf(msgId), senderUidStr, sourceMsgText);
        }
        Intrinsics.checkNotNullParameter(senderUidStr, "senderUidStr");
        Intrinsics.checkNotNullParameter(sourceMsgText, "sourceMsgText");
        ReplyElement replyElement = new ReplyElement();
        replyElement.replayMsgId = msgId;
        replyElement.senderUidStr = senderUidStr;
        replyElement.sourceMsgText = sourceMsgText;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 7;
        msgElement.replyElement = replyElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement v(@NotNull TextElement textElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgElement) iPatchRedirector.redirect((short) 3, (Object) this, (Object) textElement);
        }
        Intrinsics.checkNotNullParameter(textElement, "textElement");
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 1;
        msgElement.textElement = textElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement w(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        TextElement textElement = new TextElement();
        textElement.content = content;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 1;
        msgElement.textElement = textElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement x(@NotNull String origPath) {
        HashMap<Integer, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MsgElement) iPatchRedirector.redirect((short) 15, (Object) this, (Object) origPath);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        String a16 = a(origPath, 5, 2);
        String z16 = z(origPath, 5, 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.decodeFile(z16, options);
        VideoElement videoElement = new VideoElement();
        videoElement.filePath = a16;
        videoElement.videoMd5 = cq.r(a16);
        videoElement.fileTime = 0;
        videoElement.fileSize = cq.v(a16);
        videoElement.fileName = f359547a.C(a16);
        videoElement.fileFormat = 2;
        videoElement.thumbSize = (int) cq.v(z16);
        videoElement.thumbWidth = options.outWidth;
        videoElement.thumbHeight = options.outHeight;
        videoElement.thumbMd5 = cq.r(z16);
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(0, z16));
        videoElement.thumbPath = hashMapOf;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 5;
        msgElement.videoElement = videoElement;
        return msgElement;
    }

    @NotNull
    public final MsgElement y(@NotNull String origPath, int subBusiType, boolean quality, @Nullable String thumbPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MsgElement) iPatchRedirector.redirect((short) 16, this, origPath, Integer.valueOf(subBusiType), Boolean.valueOf(quality), thumbPath);
        }
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        if (thumbPath == null) {
            c cVar = sCompressModule;
            if (cVar != null) {
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(currentTimeMillis);
                thumbPath = cVar.a(sb5.toString(), "jpg");
                if (thumbPath != null) {
                    FileOutputStream fileOutputStream = new FileOutputStream(thumbPath);
                    try {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(origPath);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                            if (frameAtTime != null) {
                                frameAtTime.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Exception e16) {
                            QLog.e("MsgUtil", 1, e16, new Object[0]);
                        }
                    } finally {
                        fileOutputStream.close();
                    }
                }
            }
            thumbPath = null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.decodeFile(thumbPath, options);
        String r16 = cq.r(thumbPath);
        element_ext_buf_for_ui$ElementExtBufForUI element_ext_buf_for_ui_elementextbufforui = new element_ext_buf_for_ui$ElementExtBufForUI();
        element_ext_buf_for_ui_elementextbufforui.sourcePath.set(origPath);
        element_ext_buf_for_ui_elementextbufforui.thumbPath.set(thumbPath);
        element_ext_buf_for_ui_elementextbufforui.thumbHeight.set(options.outHeight);
        element_ext_buf_for_ui_elementextbufforui.thumbWidth.set(options.outWidth);
        element_ext_buf_for_ui_elementextbufforui.thumbMd5.set(r16);
        element_ext_buf_for_ui_elementextbufforui.thumbSize.set(cq.v(thumbPath));
        element_ext_buf_for_ui_elementextbufforui.quality.set(quality);
        VideoElement videoElement = new VideoElement();
        videoElement.busiType = 4601;
        videoElement.subBusiType = subBusiType;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 5;
        msgElement.videoElement = videoElement;
        msgElement.extBufForUI = element_ext_buf_for_ui_elementextbufforui.toByteArray();
        return msgElement;
    }
}

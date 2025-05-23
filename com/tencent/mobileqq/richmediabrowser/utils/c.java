package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.Html;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002\u00a2\u0006\u0004\b^\u0010_J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0007J(\u0010!\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0007J\b\u0010\"\u001a\u00020\u0006H\u0002J \u0010%\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020#H\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020#0(2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00182\u0006\u0010$\u001a\u00020#H\u0002J<\u0010/\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002JJ\u00105\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0002J\u001e\u00106\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0002J.\u00107\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0002J\u0016\u00108\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0007J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010:\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0017J\u001e\u0010;\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0007J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010>\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010C\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\n\u0010B\u001a\u00060@j\u0002`AH\u0002J.\u0010E\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010$\u001a\u00020#2\u0006\u0010D\u001a\u00020\fJ\u001a\u0010F\u001a\u0004\u0018\u00010-2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0010\u001a\u00020\fJ.\u0010G\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f0(J\u000e\u0010H\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ*\u0010I\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0(2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f0(J\u000e\u0010J\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010L\u001a\u00020\u00062\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018R\u0014\u0010N\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010MR\u0017\u0010Q\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010M\u001a\u0004\bO\u0010PR\u001a\u0010S\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010M\u001a\u0004\bR\u0010PR\u0016\u0010T\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010MR\u0016\u0010U\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010MR\u0016\u0010V\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010MR\u0016\u0010W\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010MR\u0016\u0010X\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010MR\u0016\u0010Y\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010MR\u0016\u0010Z\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010MR\u0016\u0010[\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010MR\u0016\u0010\\\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010MR\u0016\u0010]\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010M\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/richmediabrowser/utils/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/richmediabrowser/utils/c$a;", "forwardData", "", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "l", "", "path", "", "d", WadlProxyConsts.PARAM_FILENAME, "md5", "p", "picElement", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "videoElement", "r", "", "chatMessageList", "c", "v", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "multiMsgList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "Landroid/content/Intent;", "intent", "D", "Landroid/content/pm/ResolveInfo;", "resInfo", "", DomainData.DOMAIN_NAME, "sourcePathList", "mailTempPathList", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "patchUris", "e", "msg", "picPathList", "picRenamePathList", "videoPathList", "videoRenamePathList", "k", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "u", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", ReportConstant.COSTREPORT_PREFIX, "o", RemoteMessageConst.MessageBody.MSG_CONTENT, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "a", "subject", "B", "g", BdhLogUtil.LogTag.Tag_Conn, "i", "j", "y", TabPreloadItem.TAB_NAME_MESSAGE, "E", "Ljava/lang/String;", "TEMP_MAIL_FILE_PATH", "getCHAT_TXT_FILENAME", "()Ljava/lang/String;", "CHAT_TXT_FILENAME", "getMAIL_MESSAGE_TYPE", "MAIL_MESSAGE_TYPE", "REPORT_DIALOG_NOT_SUPPORT", "REPORT_MULTI_DELETE", "REPORT_MULTI_FORWARD", "REPORT_MULTI_SEND_WEIXIN", "REPORT_MULTI_SEND_MAIL", "REPORT_MULTI_WEIYUN", "REPORT_MULTI_CLIPBOARD", "REPORT_MULTI_QZONE_ABLUM", "REPORT_ACTIONSHEET_SHOW", "REPORT_COMPLAINT_CLICK", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f281913a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String TEMP_MAIL_FILE_PATH = AppConstants.SDCARD_PATH + "TempMail" + File.separator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CHAT_TXT_FILENAME;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MAIL_MESSAGE_TYPE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_DIALOG_NOT_SUPPORT;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_DELETE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_FORWARD;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_SEND_WEIXIN;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_SEND_MAIL;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_WEIYUN;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_CLIPBOARD;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_MULTI_QZONE_ABLUM;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_ACTIONSHEET_SHOW;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static String REPORT_COMPLAINT_CLICK;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014R\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/richmediabrowser/utils/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "myUin", "b", "f", IProfileProtocolConst.PARAM_TROOP_CODE, "id", "d", "I", "()I", "chatType", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "e", "Ljava/util/List;", "()Ljava/util/List;", "picMsgList", "requestCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.richmediabrowser.utils.c$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class QzoneAlbumNTForwardData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String myUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String troopCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String id;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int chatType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<AIOMsgItem> picMsgList;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int requestCode;

        /* JADX WARN: Multi-variable type inference failed */
        public QzoneAlbumNTForwardData(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable List<? extends AIOMsgItem> list, int i16) {
            this.myUin = str;
            this.troopCode = str2;
            this.id = str3;
            this.chatType = i3;
            this.picMsgList = list;
            this.requestCode = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getChatType() {
            return this.chatType;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getMyUin() {
            return this.myUin;
        }

        @Nullable
        public final List<AIOMsgItem> d() {
            return this.picMsgList;
        }

        /* renamed from: e, reason: from getter */
        public final int getRequestCode() {
            return this.requestCode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QzoneAlbumNTForwardData)) {
                return false;
            }
            QzoneAlbumNTForwardData qzoneAlbumNTForwardData = (QzoneAlbumNTForwardData) other;
            if (Intrinsics.areEqual(this.myUin, qzoneAlbumNTForwardData.myUin) && Intrinsics.areEqual(this.troopCode, qzoneAlbumNTForwardData.troopCode) && Intrinsics.areEqual(this.id, qzoneAlbumNTForwardData.id) && this.chatType == qzoneAlbumNTForwardData.chatType && Intrinsics.areEqual(this.picMsgList, qzoneAlbumNTForwardData.picMsgList) && this.requestCode == qzoneAlbumNTForwardData.requestCode) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getTroopCode() {
            return this.troopCode;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.myUin;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.troopCode;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.id;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (((i17 + hashCode3) * 31) + this.chatType) * 31;
            List<AIOMsgItem> list = this.picMsgList;
            if (list != null) {
                i3 = list.hashCode();
            }
            return ((i18 + i3) * 31) + this.requestCode;
        }

        @NotNull
        public String toString() {
            return "QzoneAlbumNTForwardData(myUin=" + this.myUin + ", troopCode=" + this.troopCode + ", id=" + this.id + ", chatType=" + this.chatType + ", picMsgList=" + this.picMsgList + ", requestCode=" + this.requestCode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/richmediabrowser/utils/c$b", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "o1", "o2", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements Comparator<AIOMsgItem> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@Nullable AIOMsgItem o16, @Nullable AIOMsgItem o26) {
            if (o16 == null || o26 == null) {
                return 0;
            }
            if (o16.getMsgRecord().msgSeq > o26.getMsgRecord().msgSeq) {
                return 1;
            }
            if (o16.getMsgRecord().msgSeq >= o26.getMsgRecord().msgSeq) {
                return 0;
            }
            return -1;
        }
    }

    static {
        String qqStr = HardCodeUtil.qqStr(R.string.jae);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_aioshare_a2dc77a3)");
        CHAT_TXT_FILENAME = qqStr;
        MAIL_MESSAGE_TYPE = "message/rfc822";
        REPORT_DIALOG_NOT_SUPPORT = "0X8007F0A ";
        REPORT_MULTI_DELETE = "0X8007F0B ";
        REPORT_MULTI_FORWARD = "0X8007F0C ";
        REPORT_MULTI_SEND_WEIXIN = "0X8007F0D ";
        REPORT_MULTI_SEND_MAIL = "0X8007F0E ";
        REPORT_MULTI_WEIYUN = "0X8007F0F ";
        REPORT_MULTI_CLIPBOARD = "0X8007F10 ";
        REPORT_MULTI_QZONE_ABLUM = "0X800A77E";
        REPORT_ACTIONSHEET_SHOW = "0X800B761";
        REPORT_COMPLAINT_CLICK = "0X800B762";
    }

    c() {
    }

    @JvmStatic
    public static final void A(@Nullable Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull List<? extends AIOMsgItem> multiMsgList) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(multiMsgList, "multiMsgList");
        if (!multiMsgList.isEmpty() && context != null) {
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.putExtra("big_brother_source_key", "biz_src_jc_ac");
            intent.setType(MAIL_MESSAGE_TYPE);
            c cVar = f281913a;
            String h16 = cVar.h(aioContext, multiMsgList);
            intent.putExtra("android.intent.extra.SUBJECT", h16);
            cVar.x();
            cVar.B(context, multiMsgList, intent, h16);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            cVar.D(context, aioContext, intent);
            return;
        }
        QLog.i("AIOGalleryUtilsNT", 1, "multiMsgList is empty, or context is null");
    }

    private final void D(Context context, com.tencent.aio.api.runtime.a aioContext, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 0);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q\u2026tentActivities(intent, 0)");
            if (!queryIntentActivities.isEmpty()) {
                List<Intent> n3 = n(queryIntentActivities, intent);
                try {
                    Intent createChooser = Intent.createChooser(n3.remove(0), HardCodeUtil.qqStr(R.string.jac));
                    if (createChooser == null) {
                        return;
                    }
                    Object[] array = n3.toArray(new Parcelable[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
                    createChooser.putExtra("big_brother_source_key", "biz_src_jc_ac");
                    context.startActivity(createChooser);
                } catch (Exception e16) {
                    QLog.e("AIOGalleryUtilsNT", 1, "realSendToMail error_1, ", e16);
                    if (e16 instanceof ClassCastException) {
                        ArrayList<CharSequence> arrayList = new ArrayList<>();
                        arrayList.add(intent.getCharSequenceExtra("android.intent.extra.TEXT"));
                        intent.removeExtra("android.intent.extra.TEXT");
                        intent.putCharSequenceArrayListExtra("android.intent.extra.TEXT", arrayList);
                        context.startActivity(Intent.createChooser(intent, HardCodeUtil.qqStr(R.string.jaa)));
                    }
                }
            }
            aioContext.e().h(new MultiSelectEvent.SetSelectMode(false));
            aioContext.e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent("AIOGalleryUtilsNT", false));
        } catch (Exception e17) {
            QLog.e("AIOGalleryUtilsNT", 1, "realSendToMail error_2, ", e17);
        }
    }

    private final void a(com.tencent.aio.api.runtime.a context, String msgContent, AIOMsgItem msgItem, StringBuilder sb5) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        simpleDateFormat.applyPattern("HH:mm:ss");
        String format = simpleDateFormat.format(Long.valueOf(msgItem.getMsgRecord().msgTime * 1000));
        sb5.append(y(msgItem));
        sb5.append(" ");
        sb5.append(format);
        sb5.append("\n");
        sb5.append(msgContent);
        sb5.append("\n");
    }

    @JvmStatic
    public static final boolean b(@NotNull List<? extends AIOMsgItem> chatMessageList) {
        Intrinsics.checkNotNullParameter(chatMessageList, "chatMessageList");
        Iterator<? extends AIOMsgItem> it = chatMessageList.iterator();
        while (it.hasNext()) {
            if (!u(it.next())) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean c(@NotNull List<? extends AIOMsgItem> chatMessageList) {
        Intrinsics.checkNotNullParameter(chatMessageList, "chatMessageList");
        Iterator<? extends AIOMsgItem> it = chatMessageList.iterator();
        while (it.hasNext()) {
            if (!v(it.next())) {
                return false;
            }
        }
        return true;
    }

    private final boolean d(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    private final void e(List<String> sourcePathList, List<String> mailTempPathList, Context context, ArrayList<Uri> patchUris) {
        Uri g16;
        if (!sourcePathList.isEmpty()) {
            for (String str : sourcePathList) {
                if (FileUtils.copyFile(str, TEMP_MAIL_FILE_PATH + ((Object) mailTempPathList.get(sourcePathList.indexOf(str)))) && (g16 = g(context, mailTempPathList.get(sourcePathList.indexOf(str)))) != null) {
                    patchUris.add(g16);
                }
            }
        }
    }

    @JvmStatic
    public static final void f(@Nullable Activity activity, @NotNull QzoneAlbumNTForwardData forwardData) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(forwardData, "forwardData");
        if (forwardData.d() != null && !forwardData.d().isEmpty()) {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = forwardData.getMyUin();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (forwardData.getChatType() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (forwardData.getChatType() != 1 && forwardData.getChatType() != 3000) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            for (AIOMsgItem aIOMsgItem : forwardData.d()) {
                c cVar = f281913a;
                PicElement l3 = cVar.l(aIOMsgItem);
                if (l3 == null) {
                    QLog.i("AIOGalleryUtilsNT", 2, "picElement is null ");
                } else {
                    String m3 = cVar.m(l3);
                    if (!TextUtils.isEmpty(m3) && m3 != null) {
                        arrayList.add(m3);
                        arrayList3.add(Long.valueOf(aIOMsgItem.getMsgRecord().msgTime));
                        if (z16) {
                            try {
                                String str = l3.fileName;
                                Intrinsics.checkNotNullExpressionValue(str, "picElement.fileName");
                                String str2 = l3.md5HexStr;
                                Intrinsics.checkNotNullExpressionValue(str2, "picElement.md5HexStr");
                                arrayList2.add(p(str, str2));
                                arrayList4.add(Long.valueOf(l3.fileUuid));
                            } catch (NumberFormatException unused) {
                                QLog.e("AIOGalleryUtilsNT", 1, "createMessageRecord: convert fileUUid failed: " + l3.fileUuid);
                            }
                        } else {
                            arrayList2.add(l3.fileUuid);
                        }
                    } else {
                        QLog.e("AIOGalleryUtilsNT", 2, "pic source path is empty or not exit path = " + m3);
                    }
                }
            }
            QZoneHelper.forwardToQzoneAlbum(activity, userInfo, z16, forwardData.getId(), forwardData.getTroopCode(), i3, (ArrayList<String>) arrayList, (ArrayList<String>) arrayList2, (ArrayList<Long>) arrayList3, (ArrayList<Long>) arrayList4, forwardData.getRequestCode());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryUtilsNT", 2, "forwardToQzoneAlbum, picMsgList is empty");
        }
    }

    private final String h(com.tencent.aio.api.runtime.a aioContext, List<? extends AIOMsgItem> multiMsgList) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface) || multiMsgList.isEmpty()) {
            return "";
        }
        AIOMsgItem aIOMsgItem = multiMsgList.get(0);
        String g16 = aioContext.g().r().c().g();
        int i3 = aIOMsgItem.getMsgRecord().chatType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String qqStr = HardCodeUtil.qqStr(R.string.cda);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026g_forward_wx_title_group)");
                String format = String.format(qqStr, Arrays.copyOf(new Object[]{g16}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String qqStr2 = HardCodeUtil.qqStr(R.string.cda);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026g_forward_wx_title_group)");
            String format2 = String.format(qqStr2, Arrays.copyOf(new Object[]{g16}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String qqStr3 = HardCodeUtil.qqStr(R.string.cd7);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(com.tencent.mobile\u2026msg_forward_mail_subject)");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String format3 = String.format(qqStr3, Arrays.copyOf(new Object[]{ac.B(qQAppInterface, qQAppInterface.getCurrentUin()), g16}, 2));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        return format3;
    }

    private final String k(AIOMsgItem msg2, List<String> picPathList, List<String> picRenamePathList, List<String> videoPathList, List<String> videoRenamePathList) {
        MarkdownElement markdownElement;
        ReplyElement replyElement;
        if (com.tencent.mobileqq.aio.utils.d.Z(msg2)) {
            return o(msg2);
        }
        if (com.tencent.mobileqq.aio.utils.d.L(msg2)) {
            return C(l(msg2), picPathList, picRenamePathList);
        }
        if (msg2.getMsgRecord().msgType == 7) {
            return q(msg2, videoPathList, videoRenamePathList);
        }
        if (com.tencent.mobileqq.aio.utils.d.E(msg2)) {
            return j(msg2, picPathList, picRenamePathList);
        }
        if (com.tencent.mobileqq.aio.utils.d.u(msg2.getMsgRecord())) {
            String n3 = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msg2.getMsgRecord()).n();
            if (TextUtils.isEmpty(n3)) {
                return HardCodeUtil.qqStr(R.string.ja9);
            }
            return n3;
        }
        if (com.tencent.mobileqq.aio.utils.d.H(msg2)) {
            return HardCodeUtil.qqStr(R.string.jaj);
        }
        if (msg2.getMsgRecord().msgType == 9) {
            ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
            String str = "";
            for (MsgElement msgElement : arrayList) {
                if (msgElement != null && (replyElement = msgElement.replyElement) != null) {
                    Intrinsics.checkNotNullExpressionValue(replyElement, "replyElement");
                    str = f281913a.o(msg2);
                }
            }
            return str;
        }
        if (com.tencent.mobileqq.aio.utils.d.R(msg2)) {
            ArrayList<MsgElement> arrayList2 = msg2.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msg.msgRecord.elements");
            for (MsgElement msgElement2 : arrayList2) {
                if (msgElement2 != null && (markdownElement = msgElement2.markdownElement) != null) {
                    Intrinsics.checkNotNullExpressionValue(markdownElement, "markdownElement");
                    return markdownElement.mdSummary;
                }
            }
            return null;
        }
        return null;
    }

    private final PicElement l(AIOMsgItem msgItem) {
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            return msgItem.getMsgRecord().elements.get(0).picElement;
        }
        return null;
    }

    private final String m(PicElement picElement) {
        if (picElement == null) {
            return null;
        }
        String a16 = aj.a(picElement);
        if (d(a16)) {
            return a16;
        }
        String b16 = aj.b(picElement, 0);
        if (d(b16)) {
            return b16;
        }
        String b17 = aj.b(picElement, 720);
        if (d(b17)) {
            return b17;
        }
        String b18 = aj.b(picElement, 198);
        if (!d(b18)) {
            return null;
        }
        return b18;
    }

    private final List<Intent> n(List<? extends ResolveInfo> resInfo, Intent intent) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : resInfo) {
            String str = resolveInfo.activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "info.activityInfo.packageName");
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "mail", false, 2, (Object) null);
            if (!contains$default) {
                String str2 = resolveInfo.activityInfo.name;
                Intrinsics.checkNotNullExpressionValue(str2, "info.activityInfo.name");
                String lowerCase2 = str2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "mail", false, 2, (Object) null);
                if (contains$default5) {
                }
            }
            if (Intrinsics.areEqual(resolveInfo.activityInfo.packageName, AppConstants.QQMAIL_PACKAGE_NAME)) {
                String str3 = resolveInfo.activityInfo.name;
                Intrinsics.checkNotNullExpressionValue(str3, "info.activityInfo.name");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "LaunchComposeNote", false, 2, (Object) null);
                if (!contains$default2) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent.setPackage(null);
                    intent.setComponent(componentName);
                    Object clone = intent.clone();
                    Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type android.content.Intent");
                    arrayList.add((Intent) clone);
                }
            } else {
                String str4 = resolveInfo.activityInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(str4, "info.activityInfo.packageName");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) QQPermissionConstants.Permission.BLUE_TOOTH_GROUP, false, 2, (Object) null);
                if (!contains$default3) {
                    String str5 = resolveInfo.activityInfo.name;
                    Intrinsics.checkNotNullExpressionValue(str5, "info.activityInfo.name");
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) str5, (CharSequence) QQPermissionConstants.Permission.BLUE_TOOTH_GROUP, false, 2, (Object) null);
                    if (!contains$default4) {
                        intent.setComponent(null);
                        intent.setPackage(resolveInfo.activityInfo.packageName);
                        Object clone2 = intent.clone();
                        Intrinsics.checkNotNull(clone2, "null cannot be cast to non-null type android.content.Intent");
                        arrayList.add((Intent) clone2);
                    }
                }
            }
        }
        return arrayList;
    }

    private final String o(AIOMsgItem msgItem) {
        List filterNotNull;
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = msgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) api;
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            MsgElement checkedMsgElement = (MsgElement) it5.next();
            Intrinsics.checkNotNullExpressionValue(checkedMsgElement, "checkedMsgElement");
            sb5.append(iGuildMsgElementApi.getElementContent(checkedMsgElement));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r7, ".", 0, false, 6, (java.lang.Object) null);
     */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String p(@NotNull String fileName, @NotNull String md5) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(md5, "md5");
        if (!TextUtils.isEmpty(fileName) && !TextUtils.isEmpty(md5)) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = md5.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) fileName, (CharSequence) lowerCase, false, 2, (Object) null);
            if (!contains$default) {
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = md5.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) fileName, (CharSequence) upperCase, false, 2, (Object) null);
                if (!contains$default2) {
                    contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) fileName, (CharSequence) "-", false, 2, (Object) null);
                    if (!contains$default3 && lastIndexOf$default >= 0 && lastIndexOf$default < fileName.length()) {
                        String substring = fileName.substring(lastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return md5 + substring;
                    }
                    return fileName;
                }
                return fileName;
            }
            return fileName;
        }
        return fileName;
    }

    private final String q(AIOMsgItem msg2, List<String> videoPathList, List<String> videoRenamePathList) {
        VideoElement videoElement;
        MsgElement firstTypeElement = msg2.getFirstTypeElement(5);
        if (firstTypeElement != null) {
            videoElement = firstTypeElement.videoElement;
        } else {
            videoElement = null;
        }
        String r16 = r(videoElement);
        if (TextUtils.isEmpty(r16)) {
            QLog.e("AIOGalleryUtilsNT", 1, "getVideoMsgPath null, ", msg2.toString());
            return null;
        }
        videoPathList.add(r16);
        String str = HardCodeUtil.qqStr(R.string.ja_) + videoPathList.size() + ".mp4";
        videoRenamePathList.add(str);
        return str + HardCodeUtil.qqStr(R.string.jag);
    }

    private final String r(VideoElement videoElement) {
        if (videoElement == null) {
            return "";
        }
        String e16 = aj.e(videoElement);
        if (e16 == null) {
            e16 = "";
        }
        if (d(e16)) {
            return e16;
        }
        if (!d(videoElement.fileName)) {
            return "";
        }
        String str = videoElement.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "videoElement.fileName");
        return str;
    }

    private final boolean s(AIOMsgItem msgItem) {
        if ((msgItem.getMsgRecord().msgType != 2 && msgItem.getMsgRecord().msgType != 31) || msgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 == 14 || i3 == 17) {
                return true;
            }
        }
        return false;
    }

    private final boolean t(AIOMsgItem msgItem) {
        int viewType = msgItem.getViewType();
        if (viewType != 2 && viewType != 3 && viewType != 60 && viewType != 61 && viewType != 62 && viewType != 63) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean u(@NotNull AIOMsgItem msgItem) {
        PicElement picElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            MsgElement firstTypeElement = msgItem.getFirstTypeElement(2);
            if (firstTypeElement != null) {
                picElement = firstTypeElement.picElement;
            } else {
                picElement = null;
            }
            if (w(picElement) || com.tencent.mobileqq.aio.utils.d.y(msgItem)) {
                return false;
            }
        } else if (com.tencent.mobileqq.aio.utils.d.u(msgItem.getMsgRecord()) || com.tencent.mobileqq.aio.utils.d.I(msgItem.getMsgRecord()) || msgItem.getMsgRecord().msgType == 17 || msgItem.getMsgRecord().msgType == 6 || msgItem.getMsgRecord().msgType == 10 || msgItem.getMsgRecord().msgType == 3) {
            return false;
        }
        return msgItem.e2();
    }

    @JvmStatic
    public static final boolean v(@NotNull AIOMsgItem msgItem) {
        PicElement picElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            MsgElement firstTypeElement = msgItem.getFirstTypeElement(2);
            if (firstTypeElement != null) {
                picElement = firstTypeElement.picElement;
            } else {
                picElement = null;
            }
            if (w(picElement) || com.tencent.mobileqq.aio.utils.d.y(msgItem)) {
                return false;
            }
        } else {
            if (com.tencent.mobileqq.aio.utils.d.I(msgItem.getMsgRecord())) {
                return true;
            }
            if (com.tencent.mobileqq.aio.utils.d.u(msgItem.getMsgRecord()) || com.tencent.mobileqq.aio.utils.d.q(msgItem) || msgItem.getMsgRecord().msgType == 17 || msgItem.getMsgRecord().msgType == 6 || msgItem.getMsgRecord().msgType == 10 || msgItem.getMsgRecord().msgType == 3) {
                return false;
            }
        }
        return msgItem.e2();
    }

    @JvmStatic
    public static boolean w(@Nullable PicElement picElement) {
        if (picElement == null || picElement.picSubType != 4 || TextUtils.isEmpty(picElement.summary)) {
            return false;
        }
        return true;
    }

    private final void x() {
        String str = TEMP_MAIL_FILE_PATH;
        FileUtils.delete(str, true);
        File file = new File(str);
        if (file.isDirectory() && !file.exists()) {
            file.mkdirs();
        }
    }

    @JvmStatic
    public static final void z(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull List<? extends AIOMsgItem> multiMsgList) {
        ReplyElement replyElement;
        ArkElement arkElement;
        String str;
        TextElement textElement;
        MarkdownElement markdownElement;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(multiMsgList, "multiMsgList");
        ArrayList arrayList = new ArrayList(multiMsgList);
        f281913a.E(arrayList);
        StringBuilder sb5 = new StringBuilder();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AIOMsgItem msgItem = (AIOMsgItem) arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
            if (com.tencent.mobileqq.aio.utils.d.Z(msgItem)) {
                str = f281913a.o(msgItem);
            } else if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
                str = HardCodeUtil.qqStr(R.string.f139480bd);
            } else if (msgItem.getMsgRecord().msgType == 7) {
                str = HardCodeUtil.qqStr(R.string.f139500bf);
            } else if (msgItem.getMsgRecord().msgType == 3) {
                str = HardCodeUtil.qqStr(R.string.f139470bc);
            } else {
                c cVar = f281913a;
                if (cVar.t(msgItem)) {
                    str = cVar.i(msgItem);
                } else {
                    String str2 = null;
                    if (cVar.s(msgItem)) {
                        if (com.tencent.mobileqq.aio.utils.d.R(msgItem)) {
                            ArrayList<MsgElement> arrayList2 = msgItem.getMsgRecord().elements;
                            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgItem.msgRecord.elements");
                            for (MsgElement msgElement : arrayList2) {
                                if (msgElement != null && (markdownElement = msgElement.markdownElement) != null) {
                                    Intrinsics.checkNotNullExpressionValue(markdownElement, "markdownElement");
                                    str2 = markdownElement.mdSummary;
                                }
                            }
                        } else {
                            ArrayList<MsgElement> arrayList3 = msgItem.getMsgRecord().elements;
                            Intrinsics.checkNotNullExpressionValue(arrayList3, "msgItem.msgRecord.elements");
                            String str3 = null;
                            for (MsgElement msgElement2 : arrayList3) {
                                if (msgElement2 != null && (textElement = msgElement2.textElement) != null) {
                                    Intrinsics.checkNotNullExpressionValue(textElement, "textElement");
                                    String str4 = textElement.content;
                                    if (str4 == null) {
                                        str4 = null;
                                    }
                                    str3 = ((Object) str3) + str4;
                                }
                            }
                            str = str3;
                        }
                    } else if (msgItem.getMsgRecord().msgType == 11) {
                        ArrayList<MsgElement> arrayList4 = msgItem.getMsgRecord().elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList4, "msgItem.msgRecord.elements");
                        for (MsgElement msgElement3 : arrayList4) {
                            if (msgElement3 != null && (arkElement = msgElement3.arkElement) != null) {
                                Intrinsics.checkNotNullExpressionValue(arkElement, "arkElement");
                                str2 = new JSONObject(msgElement3.arkElement.bytesData).optString("prompt");
                            }
                        }
                    } else if (msgItem.getMsgRecord().msgType == 9) {
                        ArrayList<MsgElement> arrayList5 = msgItem.getMsgRecord().elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList5, "msgItem.msgRecord.elements");
                        for (MsgElement msgElement4 : arrayList5) {
                            if (msgElement4 != null && (replyElement = msgElement4.replyElement) != null) {
                                Intrinsics.checkNotNullExpressionValue(replyElement, "replyElement");
                                str2 = f281913a.o(msgItem);
                            }
                        }
                    }
                    str = str2;
                }
            }
            if (str != null) {
                f281913a.a(aioContext, str, msgItem, sb5);
                if (i3 != arrayList.size() - 1) {
                    sb5.append("\n");
                }
            }
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Resources resources = mobileQQ.getResources();
        if (resources == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            QQToast.makeText(mobileQQ, HardCodeUtil.qqStr(R.string.f139310ax), 0).show(resources.getDimensionPixelSize(ImmersiveUtils.getStatusBarHeight(mobileQQ) + R.dimen.f158964cd4));
            return;
        }
        Object systemService = zp0.b.f452962a.j().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("simple text", sb5.toString()));
        QQToast.makeText(mobileQQ, HardCodeUtil.qqStr(R.string.f139260as), 0).show(resources.getDimensionPixelSize(ImmersiveUtils.getStatusBarHeight(mobileQQ) + R.dimen.f158964cd4));
        aioContext.e().h(new MultiSelectEvent.SetSelectMode(false));
        aioContext.e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent("AIOGalleryUtilsNT", false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x025b A[Catch: IOException -> 0x020e, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x020e, blocks: (B:43:0x025b, B:78:0x0209), top: B:6:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x026d  */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.tencent.mobileqq.richmediabrowser.utils.c] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(@Nullable Context context, @NotNull List<? extends AIOMsgItem> multiMsgList, @NotNull Intent intent, @NotNull String subject) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Uri g16;
        List<String> list;
        c cVar;
        Intent intent2;
        BufferedWriter bufferedWriter;
        String str;
        String str2;
        List<String> list2;
        c cVar2;
        Intent intent3;
        Intent intent4;
        BufferedWriter bufferedWriter2;
        c cVar3;
        List<String> list3;
        StringBuilder sb5;
        String trimIndent;
        long j3;
        String str3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Intrinsics.checkNotNullParameter(multiMsgList, "multiMsgList");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(subject, "subject");
        if (multiMsgList.isEmpty()) {
            return;
        }
        AIOMsgItem aIOMsgItem = multiMsgList.get(0);
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ?? arrayList8 = new ArrayList();
        try {
            try {
                str = TEMP_MAIL_FILE_PATH;
                str2 = CHAT_TXT_FILENAME;
                list2 = arrayList8;
                try {
                    FileUtils.createFile(str + str2);
                } catch (Throwable th5) {
                    th = th5;
                    arrayList = arrayList7;
                    cVar2 = this;
                    intent3 = intent;
                }
            } catch (Throwable th6) {
                th = th6;
                list = arrayList8;
                arrayList = arrayList7;
                arrayList2 = arrayList6;
                cVar = this;
                intent2 = intent;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(str + str2));
            try {
                sb5 = new StringBuilder();
                sb5.append("<html><body><p>Dear:</p>");
                sb5.append("<p>");
                sb5.append((String) subject);
                sb5.append("\u5982\u4e0b\uff1a</p>");
                trimIndent = StringsKt__IndentKt.trimIndent(((String) subject) + "\u5982\u4e0b\uff1a");
                bufferedWriter3.write(trimIndent);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
                simpleDateFormat.applyPattern(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                ArrayList arrayList9 = arrayList6;
                long j16 = 1000;
                try {
                    String format = simpleDateFormat.format(Long.valueOf(aIOMsgItem.getMsgRecord().msgTime * j16));
                    sb5.append("<p><font color=\"#999999\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014&nbsp;");
                    sb5.append(format);
                    sb5.append("&nbsp;\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014</font></p>");
                    bufferedWriter3.write("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014 " + format + " \u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\n\n");
                    String str4 = format;
                    for (AIOMsgItem aIOMsgItem2 : multiMsgList) {
                        try {
                            j3 = j16;
                            str3 = str4;
                            BufferedWriter bufferedWriter4 = bufferedWriter3;
                            list3 = list2;
                            arrayList3 = arrayList7;
                            arrayList = arrayList7;
                            arrayList4 = arrayList9;
                            arrayList2 = arrayList9;
                            bufferedWriter2 = bufferedWriter4;
                        } catch (Throwable th7) {
                            th = th7;
                            arrayList = arrayList7;
                            list3 = list2;
                            arrayList2 = arrayList9;
                            bufferedWriter2 = bufferedWriter3;
                        }
                        try {
                            String k3 = k(aIOMsgItem2, arrayList5, arrayList3, arrayList4, list3);
                            if (k3 != null) {
                                simpleDateFormat.applyPattern(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                                String format2 = simpleDateFormat.format(Long.valueOf(aIOMsgItem2.getMsgRecord().msgTime * j3));
                                if (!Intrinsics.areEqual(format2, str3)) {
                                    sb5.append("<p><font color=\"#999999\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014&nbsp;");
                                    sb5.append(format2);
                                    sb5.append("&nbsp;\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014</font></p>");
                                    bufferedWriter2.write("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014 " + format2 + " \u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\n\n");
                                    str4 = format2;
                                } else {
                                    str4 = str3;
                                }
                                simpleDateFormat.applyPattern("HH:mm:ss");
                                String format3 = simpleDateFormat.format(Long.valueOf(aIOMsgItem2.getMsgRecord().msgTime * j3));
                                sb5.append("<p><font color=\"#999999\">");
                                cVar3 = this;
                                try {
                                    sb5.append(cVar3.y(aIOMsgItem2));
                                    sb5.append("&nbsp;");
                                    sb5.append(format3);
                                    sb5.append("</font><br/>");
                                    sb5.append(k3);
                                    sb5.append("</p>");
                                    bufferedWriter2.write(cVar3.y(aIOMsgItem2) + "  " + format3 + " \n");
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(k3);
                                    sb6.append(" \n\n");
                                    bufferedWriter2.write(sb6.toString());
                                } catch (Throwable th8) {
                                    th = th8;
                                    intent4 = intent;
                                    bufferedWriter = bufferedWriter2;
                                    aIOMsgItem = intent4;
                                    arrayList8 = cVar3;
                                    subject = list3;
                                    try {
                                        QLog.e("AIOGalleryUtilsNT", 1, "setEmailHtmlSubjectAndBody fail. ", th);
                                        if (bufferedWriter != null) {
                                        }
                                        ArrayList arrayList10 = new ArrayList();
                                        g16 = arrayList8.g(context, CHAT_TXT_FILENAME);
                                        if (g16 != null) {
                                        }
                                        arrayList8.e(arrayList5, arrayList, context, arrayList10);
                                        arrayList8.e(arrayList2, subject, context, arrayList10);
                                        aIOMsgItem.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList10);
                                    } finally {
                                    }
                                }
                            } else {
                                str4 = str3;
                            }
                            bufferedWriter3 = bufferedWriter2;
                            arrayList9 = arrayList2;
                            j16 = j3;
                            arrayList7 = arrayList;
                            list2 = list3;
                        } catch (Throwable th9) {
                            th = th9;
                            list3 = list3;
                            cVar3 = this;
                            intent4 = intent;
                            bufferedWriter = bufferedWriter2;
                            aIOMsgItem = intent4;
                            arrayList8 = cVar3;
                            subject = list3;
                            QLog.e("AIOGalleryUtilsNT", 1, "setEmailHtmlSubjectAndBody fail. ", th);
                            if (bufferedWriter != null) {
                            }
                            ArrayList arrayList102 = new ArrayList();
                            g16 = arrayList8.g(context, CHAT_TXT_FILENAME);
                            if (g16 != null) {
                            }
                            arrayList8.e(arrayList5, arrayList, context, arrayList102);
                            arrayList8.e(arrayList2, subject, context, arrayList102);
                            aIOMsgItem.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList102);
                        }
                    }
                    arrayList = arrayList7;
                    list3 = list2;
                    arrayList2 = arrayList9;
                    bufferedWriter2 = bufferedWriter3;
                    cVar3 = this;
                    sb5.append("</body></html>");
                    intent4 = intent;
                } catch (Throwable th10) {
                    th = th10;
                    intent4 = intent;
                    arrayList = arrayList7;
                    list3 = list2;
                    arrayList2 = arrayList9;
                    bufferedWriter2 = bufferedWriter3;
                    cVar3 = this;
                }
            } catch (Throwable th11) {
                th = th11;
                intent4 = intent;
                bufferedWriter2 = bufferedWriter3;
                arrayList = arrayList7;
                cVar3 = this;
                list3 = list2;
                arrayList2 = arrayList6;
            }
        } catch (Throwable th12) {
            th = th12;
            intent3 = intent;
            arrayList = arrayList7;
            cVar2 = this;
            list = list2;
            arrayList2 = arrayList6;
            intent2 = intent3;
            cVar = cVar2;
            bufferedWriter = null;
            aIOMsgItem = intent2;
            arrayList8 = cVar;
            subject = list;
            QLog.e("AIOGalleryUtilsNT", 1, "setEmailHtmlSubjectAndBody fail. ", th);
            if (bufferedWriter != null) {
            }
            ArrayList arrayList1022 = new ArrayList();
            g16 = arrayList8.g(context, CHAT_TXT_FILENAME);
            if (g16 != null) {
            }
            arrayList8.e(arrayList5, arrayList, context, arrayList1022);
            arrayList8.e(arrayList2, subject, context, arrayList1022);
            aIOMsgItem.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList1022);
        }
        try {
            intent4.putExtra("android.intent.extra.TEXT", Html.fromHtml(sb5.toString()));
            bufferedWriter2.flush();
            bufferedWriter2.close();
            aIOMsgItem = intent4;
            arrayList8 = cVar3;
            subject = list3;
        } catch (Throwable th13) {
            th = th13;
            bufferedWriter = bufferedWriter2;
            aIOMsgItem = intent4;
            arrayList8 = cVar3;
            subject = list3;
            QLog.e("AIOGalleryUtilsNT", 1, "setEmailHtmlSubjectAndBody fail. ", th);
            if (bufferedWriter != null) {
                bufferedWriter.close();
                aIOMsgItem = aIOMsgItem;
                arrayList8 = arrayList8;
                subject = subject;
            }
            ArrayList arrayList10222 = new ArrayList();
            g16 = arrayList8.g(context, CHAT_TXT_FILENAME);
            if (g16 != null) {
            }
            arrayList8.e(arrayList5, arrayList, context, arrayList10222);
            arrayList8.e(arrayList2, subject, context, arrayList10222);
            aIOMsgItem.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList10222);
        }
        ArrayList arrayList102222 = new ArrayList();
        g16 = arrayList8.g(context, CHAT_TXT_FILENAME);
        if (g16 != null) {
            arrayList102222.add(g16);
        }
        arrayList8.e(arrayList5, arrayList, context, arrayList102222);
        arrayList8.e(arrayList2, subject, context, arrayList102222);
        aIOMsgItem.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList102222);
    }

    @Nullable
    public final String C(@Nullable PicElement picElement, @NotNull List<String> picPathList, @NotNull List<String> picRenamePathList) {
        Intrinsics.checkNotNullParameter(picPathList, "picPathList");
        Intrinsics.checkNotNullParameter(picRenamePathList, "picRenamePathList");
        String m3 = m(picElement);
        if (m3 == null) {
            QLog.e("AIOGalleryUtilsNT", 1, "getPicMsgPath null ", String.valueOf(picElement));
            return null;
        }
        picPathList.add(m3);
        String estimateFileType = FileUtils.estimateFileType(m3);
        String str = HardCodeUtil.qqStr(R.string.jai) + picPathList.size() + "." + estimateFileType;
        String str2 = str + HardCodeUtil.qqStr(R.string.jad);
        picRenamePathList.add(str);
        return str2;
    }

    public final void E(@Nullable List<? extends AIOMsgItem> msgList) {
        if (msgList != null && (!msgList.isEmpty())) {
            Collections.sort(msgList, new b());
        }
    }

    @Nullable
    public final Uri g(@Nullable Context context, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (context == null) {
            return null;
        }
        File file = new File(TEMP_MAIL_FILE_PATH + fileName);
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, "com.tencent.mobileqq.fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    @NotNull
    public final String i(@NotNull AIOMsgItem msgItem) {
        ArrayList<MsgElement> arrayListOf;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        StringBuilder sb5 = new StringBuilder();
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            int i3 = next.elementType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                            }
                        } else {
                            sb5.append(HardCodeUtil.qqStr(R.string.f139500bf));
                        }
                    } else {
                        sb5.append(HardCodeUtil.qqStr(R.string.f139470bc));
                    }
                } else {
                    sb5.append(zp0.b.f452962a.j().getString(R.string.f139480bd));
                }
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(next);
            sb5.append(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseMsgElementToChosenStr(arrayListOf).toString());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "tempSb.toString()");
        return sb6;
    }

    @NotNull
    public final String j(@NotNull AIOMsgItem msgItem, @NotNull List<String> picPathList, @NotNull List<String> picRenamePathList) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(picPathList, "picPathList");
        Intrinsics.checkNotNullParameter(picRenamePathList, "picRenamePathList");
        StringBuilder sb5 = new StringBuilder();
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement element = it.next();
            int i3 = element.elementType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 6) {
                    }
                } else {
                    sb5.append(C(element.picElement, picPathList, picRenamePathList));
                }
            }
            IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
            Intrinsics.checkNotNullExpressionValue(element, "element");
            sb5.append(iGuildMsgElementApi.getElementContent(element));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "tempSb.toString()");
        return sb6;
    }

    @NotNull
    public final String y(@NotNull AIOMsgItem msgItem) {
        String nickname;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!TextUtils.isEmpty(msgItem.getMsgRecord().sendMemberName)) {
            nickname = msgItem.getMsgRecord().sendMemberName;
        } else {
            nickname = msgItem.getMsgRecord().sendNickName;
        }
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        return nickname;
    }
}

package com.tencent.biz.qrcode.fragment.viewmodel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.qrcode.mgr.MyQRCodeManager;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.pb.qid.QidProfile$GetProfileSSOReq;
import com.tencent.pb.qid.QidProfile$GetProfileSSORsp;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0002\u008b\u0001\u0018\u0000 \u009d\u00012\u00020\u0001:\u0004\u009e\u0001\u009f\u0001B\t\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\"\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\u0011J(\u0010 \u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fJ\u0016\u0010\"\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0002J\u0016\u0010$\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%J\u0006\u0010(\u001a\u00020\u0011J(\u0010,\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0007J\u000e\u0010-\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010.\u001a\u00020\u0011J\u0010\u0010/\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0004J\u000e\u00100\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u00101\u001a\u00020\u0011J\u0016\u00105\u001a\u00020\u00112\u0006\u00102\u001a\u00020\f2\u0006\u00104\u001a\u000203J$\u00108\u001a\u00020\u00112\u0006\u0010&\u001a\u00020%2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001106H\u0007J\u0006\u00109\u001a\u00020\fJ\u0006\u0010:\u001a\u00020\fR\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0006\u00a2\u0006\f\n\u0004\bO\u0010K\u001a\u0004\bP\u0010MR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0006\u00a2\u0006\f\n\u0004\bR\u0010K\u001a\u0004\bS\u0010MR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0006\u00a2\u0006\f\n\u0004\bU\u0010K\u001a\u0004\bV\u0010MR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0006\u00a2\u0006\f\n\u0004\bX\u0010K\u001a\u0004\bY\u0010MR\"\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010C\u001a\u0004\b\\\u0010E\"\u0004\b]\u0010GR$\u0010a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010<\u001a\u0004\b_\u0010>\"\u0004\b`\u0010@R$\u0010e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010<\u001a\u0004\bc\u0010>\"\u0004\bd\u0010@R\u001f\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0I8\u0006\u00a2\u0006\f\n\u0004\bg\u0010K\u001a\u0004\bh\u0010MR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0006\u00a2\u0006\f\n\u0004\bj\u0010K\u001a\u0004\bk\u0010MR\u001f\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0I8\u0006\u00a2\u0006\f\n\u0004\bm\u0010K\u001a\u0004\bn\u0010MR\u001f\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0I8\u0006\u00a2\u0006\f\n\u0004\bp\u0010K\u001a\u0004\bq\u0010MR\u001f\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010s0I8\u0006\u00a2\u0006\f\n\u0004\bt\u0010K\u001a\u0004\bu\u0010MR\u001f\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010w0I8\u0006\u00a2\u0006\f\n\u0004\bx\u0010K\u001a\u0004\by\u0010MR\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R*\u0010\u0084\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u00010\u007fj\n\u0012\u0005\u0012\u00030\u0080\u0001`\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001d\u0010\u008a\u0001\u001a\u00030\u0085\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R&\u0010\u009a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0097\u0001\u0010<\u001a\u0005\b\u0098\u0001\u0010>\"\u0005\b\u0099\u0001\u0010@\u00a8\u0006\u00a0\u0001"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "filePathTmp", "", "uinType", "uin", "Landroid/content/Intent;", "l2", "defaultSharePath", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "useBottomPreviewFS", "W2", "wechatFriend", "g3", "", "i3", "I2", "key", "e2", "init", "m3", Constants.BASE_IN_PLUGIN_VERSION, "H2", "B2", "x2", "getLogTag", "isLight", "u2", "c2", "c3", "channelId", "V2", "selectedChannel", "l3", "Landroid/content/Context;", "context", "k2", "C2", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "f2", "R2", "J2", "K2", "d2", "E2", "isSuccess", "", "obj", "v2", "Lkotlin/Function1;", "cb", NowProxyConstants.AccountInfoKey.A2, "z2", "w2", "i", "Ljava/lang/String;", "m2", "()Ljava/lang/String;", "P2", "(Ljava/lang/String;)V", "mFrom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getMReportFlag", "()I", "Q2", "(I)V", "mReportFlag", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "o2", "()Landroidx/lifecycle/MutableLiveData;", "needToChangeToQID", "D", "getShotFinished", "shotFinished", "E", ICustomDataEditor.STRING_PARAM_2, HippyReporter.RemoveEngineReason.THEME_CHANGED, UserInfo.SEX_FEMALE, "y2", "isConfigurationChanged", "G", "q2", "shareBitmapTrigger", "H", ICustomDataEditor.NUMBER_PARAM_2, "setMSwitchState", "mSwitchState", "i2", "N2", "curName", "J", "j2", "O2", "curUin", "Landroid/graphics/Bitmap;", "K", "g2", "cardCache", "L", SemanticAttributes.DbSystemValues.H2, "cardCacheTrigger", "M", "getUserProfilePartCache", "userProfilePartCache", "N", "r2", "shareCache", "Lcom/tencent/biz/qrcode/mgr/d;", "P", "p2", "qrCodeData", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "t2", "toastData", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/HashSet;", "showedMsgTime", "Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$a;", "T", "Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$a;", "getCallback", "()Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$a;", "callback", "com/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$d", "U", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$d;", "newFriendListener", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "V", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "getWxShareListener", "()Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "setWxShareListener", "(Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;)V", "wxShareListener", "W", "getMWXTransaction", "setMWXTransaction", "mWXTransaction", "<init>", "()V", "X", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRDisplayMyCardViewModel extends BaseViewModel {

    /* renamed from: C */
    @NotNull
    private final MutableLiveData<Boolean> needToChangeToQID;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> shotFinished;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> com.tencent.hippy.qq.utils.HippyReporter.RemoveEngineReason.THEME_CHANGED java.lang.String;

    /* renamed from: F */
    @NotNull
    private final MutableLiveData<Boolean> isConfigurationChanged;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> shareBitmapTrigger;

    /* renamed from: H, reason: from kotlin metadata */
    private int mSwitchState;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String curName;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String curUin;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Bitmap> cardCache;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> cardCacheTrigger;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Bitmap> userProfilePartCache;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Bitmap> shareCache;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.biz.qrcode.mgr.d> qrCodeData;

    /* renamed from: Q */
    @NotNull
    private final MutableLiveData<NewFriendToastMessage> toastData;

    /* renamed from: R */
    @NotNull
    private final MMKVOptionEntity mEntity;

    /* renamed from: S */
    @NotNull
    private final HashSet<Long> showedMsgTime;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MyQRCodeManager.a callback;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final d newFriendListener;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private WXShareHelper.a wxShareListener;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String mWXTransaction;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private String mFrom = "";

    /* renamed from: m */
    private int mReportFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", IMiniCardBeancurd.SIGN_PLAIN_TEXT, "clickText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel$b, reason: from toString */
    /* loaded from: classes5.dex */
    public static final /* data */ class NewFriendToastMessage {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        @NotNull
        private final String plainText;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @NotNull
        private final String clickText;

        public NewFriendToastMessage(@NotNull String plainText, @NotNull String clickText) {
            Intrinsics.checkNotNullParameter(plainText, "plainText");
            Intrinsics.checkNotNullParameter(clickText, "clickText");
            this.plainText = plainText;
            this.clickText = clickText;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getClickText() {
            return this.clickText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getPlainText() {
            return this.plainText;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewFriendToastMessage)) {
                return false;
            }
            NewFriendToastMessage newFriendToastMessage = (NewFriendToastMessage) other;
            if (Intrinsics.areEqual(this.plainText, newFriendToastMessage.plainText) && Intrinsics.areEqual(this.clickText, newFriendToastMessage.clickText)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.plainText.hashCode() * 31) + this.clickText.hashCode();
        }

        @NotNull
        public String toString() {
            return "NewFriendToastMessage(plainText=" + this.plainText + ", clickText=" + this.clickText + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$c", "Lcom/tencent/biz/qrcode/mgr/MyQRCodeManager$a;", "Lcom/tencent/biz/qrcode/mgr/d;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements MyQRCodeManager.a {
        c() {
        }

        @Override // com.tencent.biz.qrcode.mgr.MyQRCodeManager.a
        public void a(@Nullable com.tencent.biz.qrcode.mgr.d data) {
            QRDisplayMyCardViewModel.this.p2().postValue(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class e extends QQPermission.BasePermissionsListener {

        /* renamed from: b */
        final /* synthetic */ QBaseActivity f94897b;

        e(QBaseActivity qBaseActivity) {
            this.f94897b = qBaseActivity;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QRDisplayMyCardViewModel qRDisplayMyCardViewModel = QRDisplayMyCardViewModel.this;
            QBaseActivity activity = this.f94897b;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            qRDisplayMyCardViewModel.K2(activity);
        }
    }

    public QRDisplayMyCardViewModel() {
        Boolean bool = Boolean.FALSE;
        this.needToChangeToQID = new MutableLiveData<>(bool);
        this.shotFinished = new MutableLiveData<>(bool);
        this.com.tencent.hippy.qq.utils.HippyReporter.RemoveEngineReason.THEME_CHANGED java.lang.String = new MutableLiveData<>(bool);
        this.isConfigurationChanged = new MutableLiveData<>(bool);
        this.shareBitmapTrigger = new MutableLiveData<>(bool);
        this.mSwitchState = -1;
        this.cardCache = new MutableLiveData<>(null);
        this.cardCacheTrigger = new MutableLiveData<>(bool);
        this.userProfilePartCache = new MutableLiveData<>(null);
        this.shareCache = new MutableLiveData<>(null);
        this.qrCodeData = new MutableLiveData<>(null);
        this.toastData = new MutableLiveData<>(null);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.mEntity = from;
        this.showedMsgTime = new HashSet<>();
        this.callback = new c();
        this.newFriendListener = new d();
        this.mWXTransaction = String.valueOf(System.currentTimeMillis());
    }

    public static final void F2(QRDisplayMyCardViewModel this$0, int i3, final boolean z16, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.G2(QRDisplayMyCardViewModel.this, z16, obj);
            }
        });
    }

    public static final void G2(QRDisplayMyCardViewModel this$0, boolean z16, Object data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.v2(z16, data);
    }

    private final void I2() {
        this.mEntity.encodeBool(e2("qrcode_has_click_aigc_button"), true);
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x008d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:142), block:B:67:0x008d */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0126 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void L2(QRDisplayMyCardViewModel this$0, final Activity activity) {
        OutputStream outputStream;
        OutputStream outputStream2;
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Bitmap value = this$0.shareCache.getValue();
        final boolean z16 = false;
        final Uri uri = null;
        OutputStream outputStream3 = null;
        uri = null;
        if (value != null && !value.isRecycled()) {
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = activity.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "activity.contentResolver");
            String str = "qrcode_" + String.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            Uri insert = contentResolver.insert(uri2, contentValues);
            try {
                if (insert != null) {
                    try {
                        outputStream2 = contentResolver.openOutputStream(insert);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        outputStream2 = null;
                        QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal, error = " + e);
                        if (outputStream2 != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    } catch (IllegalStateException e17) {
                        e = e17;
                        outputStream2 = null;
                        QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal, error = " + e);
                        if (outputStream2 != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        outputStream2 = null;
                        QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal, error = " + e);
                        if (outputStream2 != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    } catch (Throwable th5) {
                        th = th5;
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e19) {
                                QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal finally, error = " + e19);
                            }
                        }
                        throw th;
                    }
                } else {
                    outputStream2 = null;
                }
                if (outputStream2 != null) {
                    try {
                        z16 = value.compress(Bitmap.CompressFormat.JPEG, 75, outputStream2);
                    } catch (FileNotFoundException e26) {
                        e = e26;
                        QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal, error = " + e);
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e27) {
                                e = e27;
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeReal finally, error = ");
                                sb5.append(e);
                                QLog.e("QRDisplayMyCardViewModel", 1, sb5.toString());
                                if (!z16) {
                                }
                                uri = insert;
                                activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QRDisplayMyCardViewModel.M2(z16, uri, activity);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    } catch (IllegalStateException e28) {
                        e = e28;
                        QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal, error = " + e);
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e29) {
                                e = e29;
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeReal finally, error = ");
                                sb5.append(e);
                                QLog.e("QRDisplayMyCardViewModel", 1, sb5.toString());
                                if (!z16) {
                                    py3.b.e(contentResolver, insert, null, null);
                                }
                                uri = insert;
                                activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QRDisplayMyCardViewModel.M2(z16, uri, activity);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    } catch (OutOfMemoryError e36) {
                        e = e36;
                        QLog.e("QRDisplayMyCardViewModel", 1, "saveQRCodeReal, error = " + e);
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e37) {
                                e = e37;
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeReal finally, error = ");
                                sb5.append(e);
                                QLog.e("QRDisplayMyCardViewModel", 1, sb5.toString());
                                if (!z16) {
                                }
                                uri = insert;
                                activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        QRDisplayMyCardViewModel.M2(z16, uri, activity);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    }
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e38) {
                        e = e38;
                        sb5 = new StringBuilder();
                        sb5.append("saveQRCodeReal finally, error = ");
                        sb5.append(e);
                        QLog.e("QRDisplayMyCardViewModel", 1, sb5.toString());
                        if (!z16) {
                        }
                        uri = insert;
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                QRDisplayMyCardViewModel.M2(z16, uri, activity);
                            }
                        });
                    }
                }
                if (!z16 && insert != null) {
                    py3.b.e(contentResolver, insert, null, null);
                }
                uri = insert;
            } catch (Throwable th6) {
                th = th6;
                outputStream3 = outputStream;
            }
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.k
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.M2(z16, uri, activity);
            }
        });
    }

    public static final void M2(boolean z16, Uri uri, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (z16) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            activity.sendBroadcast(intent);
            com.tencent.biz.qrcode.util.h.T(2, R.string.cwj);
            return;
        }
        com.tencent.biz.qrcode.util.h.T(1, R.string.f216945zo);
    }

    public static final void S2(QRDisplayMyCardViewModel this$0, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            final String P = com.tencent.biz.qrcode.util.h.P(activity, "temp_qrcode_share_" + this$0.curUin + ".png", this$0.shareCache.getValue());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.d
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayMyCardViewModel.U2(activity, P);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.c
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayMyCardViewModel.T2(activity);
                }
            });
        }
    }

    public static final void T2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (activity.isFinishing()) {
            return;
        }
        com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
    }

    public static final void U2(Activity activity, String str) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzx);
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.b1p);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.extension_qrcode_share_user_text)");
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            userInfo.qzone_uin = qQAppInterface.getAccount();
            userInfo.nickname = ac.f(qQAppInterface, qQAppInterface.getAccount());
            QZoneHelper.forwardToPublishMood(activity, userInfo, str, HardCodeUtil.qqStr(R.string.b1o), qqStr, 1);
        }
    }

    private final boolean W2(final String defaultSharePath, final Activity r46, final boolean useBottomPreviewFS) {
        try {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.h
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayMyCardViewModel.a3(r46, defaultSharePath, this, useBottomPreviewFS);
                }
            }, 8, null, true);
            return false;
        } catch (OutOfMemoryError unused) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
            return true;
        }
    }

    static /* synthetic */ boolean Y2(QRDisplayMyCardViewModel qRDisplayMyCardViewModel, String str, Activity activity, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return qRDisplayMyCardViewModel.W2(str, activity, z16);
    }

    public static final void a3(final Activity activity, String defaultSharePath, QRDisplayMyCardViewModel this$0, final boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(defaultSharePath, "$defaultSharePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String P = com.tencent.biz.qrcode.util.h.P(activity, defaultSharePath, this$0.shareCache.getValue());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.n
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.b3(activity, P, z16);
            }
        });
    }

    public static final void b3(Activity activity, String str, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (activity.isFinishing()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        if (z16) {
            bundle.putBoolean(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivity(activity, intent, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
    }

    public static /* synthetic */ void d3(QRDisplayMyCardViewModel qRDisplayMyCardViewModel, Activity activity, int i3, String str, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        qRDisplayMyCardViewModel.c3(activity, i3, str, z16);
    }

    private final String e2(String key) {
        return "QQMutualMark_" + key + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static final void e3(final Activity activity, String fileName, final QRDisplayMyCardViewModel this$0, final int i3, final String uin, final boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(fileName, "$fileName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        final String P = com.tencent.biz.qrcode.util.h.P(activity, fileName, this$0.shareCache.getValue());
        if (P == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.m
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.f3(activity, this$0, P, i3, uin, z16);
            }
        });
    }

    public static final void f3(Activity activity, QRDisplayMyCardViewModel this$0, String filePathTmp, int i3, String uin, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(filePathTmp, "$filePathTmp");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (activity.isFinishing()) {
            return;
        }
        Intent l26 = this$0.l2(filePathTmp, i3, uin);
        if (z16) {
            l26.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        }
        ForwardBaseOption.startForwardActivityForResult(activity, l26, (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_gxl_ctcshare");
    }

    private final boolean g3(String defaultSharePath, Activity r65, boolean wechatFriend) {
        int i3;
        try {
            if (!WXShareHelper.b0().e0()) {
                i3 = R.string.f173257ih1;
            } else if (!WXShareHelper.b0().f0()) {
                i3 = R.string.f173258ih2;
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                com.tencent.biz.qrcode.util.h.T(0, i3);
                return true;
            }
            if (this.wxShareListener == null) {
                this.wxShareListener = new WXShareHelper.a() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.l
                    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                    public final void onWXShareResp(BaseResp baseResp) {
                        QRDisplayMyCardViewModel.h3(QRDisplayMyCardViewModel.this, baseResp);
                    }
                };
                WXShareHelper.b0().A(this.wxShareListener);
            }
            i3(defaultSharePath, r65, wechatFriend);
            return false;
        } catch (OutOfMemoryError unused) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
            return true;
        }
    }

    public static final void h3(QRDisplayMyCardViewModel this$0, BaseResp baseResp) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.mWXTransaction;
        if (str != null && Intrinsics.areEqual(str, baseResp.transaction) && (i3 = baseResp.errCode) != -2) {
            if (i3 != 0) {
                com.tencent.biz.qrcode.util.h.T(1, R.string.hit);
            } else {
                com.tencent.biz.qrcode.util.h.T(2, R.string.hj9);
            }
        }
    }

    private final void i3(final String defaultSharePath, final Activity r36, final boolean wechatFriend) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.j3(defaultSharePath, r36, this, wechatFriend);
            }
        }, 64, null, true);
    }

    public static final void j3(String defaultSharePath, final Activity activity, final QRDisplayMyCardViewModel this$0, final boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(defaultSharePath, "$defaultSharePath");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            z17 = true;
        } else {
            z17 = peekAppRuntime instanceof QQAppInterface;
        }
        if (!z17) {
            return;
        }
        final String P = com.tencent.biz.qrcode.util.h.P(activity, defaultSharePath, this$0.shareCache.getValue());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.e
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.k3(activity, P, z16, this$0);
            }
        });
    }

    public static final void k3(Activity activity, String str, boolean z16, QRDisplayMyCardViewModel this$0) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzx);
        } else if (z16) {
            WXShareHelper.b0().u0(str, this$0.shareCache.getValue(), 0);
        } else {
            WXShareHelper.b0().u0(str, this$0.shareCache.getValue(), 1);
        }
    }

    private final Intent l2(String filePathTmp, int uinType, String uin) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePathTmp);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", uinType);
        bundle.putString("key_direct_show_uin", uin);
        if (6000 == uinType && AppConstants.DATALINE_PC_UIN == uin) {
            bundle.putBoolean("filepath_copy", true);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        return intent;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void A2(@NotNull Context context, @NotNull final Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!QQTheme.isVasTheme()) {
            cb5.invoke(Boolean.FALSE);
            return;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            Drawable drawable = resources.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg, null);
            if (drawable instanceof SkinnableBitmapDrawable) {
                Bitmap bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                com.tencent.mobileqq.component.qrcode.utils.c cVar = com.tencent.mobileqq.component.qrcode.utils.c.f201870a;
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                cVar.f(bitmap, new Function1<Integer, Unit>() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel$isVasThemeLight$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        if (com.tencent.mobileqq.component.qrcode.utils.c.f201870a.c(i3)) {
                            cb5.invoke(Boolean.TRUE);
                        } else {
                            cb5.invoke(Boolean.FALSE);
                        }
                    }
                });
            }
        }
    }

    public final void B2(@NotNull Activity r26) {
        Intrinsics.checkNotNullParameter(r26, "activity");
        I2();
        MyQRCodeManager.f94961a.A(r26);
    }

    public final void C2() {
        if (this.wxShareListener != null) {
            WXShareHelper.b0().q0(this.wxShareListener);
        }
        this.wxShareListener = null;
    }

    public final void D2() {
        MyQRCodeManager.f94961a.E();
    }

    public final void E2() {
        if (!QVipQidProcessor.get().isQidProfileEnable()) {
            QLog.e("QRDisplayMyCardViewModel", 1, "[requestQidProfile] qidProfileEnable is false, not get manager or manager value false!");
        } else {
            com.tencent.mobileqq.vip.n.request(QidCardManager.CMD_GET_QID_PROFILE, new QidProfile$GetProfileSSOReq(), QidProfile$GetProfileSSORsp.class, new BusinessObserver() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    QRDisplayMyCardViewModel.F2(QRDisplayMyCardViewModel.this, i3, z16, obj);
                }
            });
        }
    }

    public final void H2() {
        MyQRCodeManager.f94961a.F();
    }

    public final void J2() {
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY);
        QBaseActivity activity = QBaseActivity.sTopActivity;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, businessConfig);
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            K2(activity);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new e(activity));
        }
    }

    protected final void K2(@NotNull final Activity r56) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(r56, "activity");
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.g
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.L2(QRDisplayMyCardViewModel.this, r56);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(qQAppInterface, "", null, 1);
    }

    public final void N2(@Nullable String str) {
        this.curName = str;
    }

    public final void O2(@Nullable String str) {
        this.curUin = str;
    }

    public final void P2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFrom = str;
    }

    public final void Q2(int i3) {
        this.mReportFlag = i3;
    }

    public final void R2(@NotNull final Activity r56) {
        Intrinsics.checkNotNullParameter(r56, "activity");
        QQAppInterface qQAppInterface = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.i
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardViewModel.S2(QRDisplayMyCardViewModel.this, r56);
            }
        }, 64, null, true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        }
        if (qQAppInterface != null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).reportButtonClick(qQAppInterface, "", "shareConsumerQRcard", 1);
        }
    }

    public final void V2(@NotNull Activity r56, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(r56, "activity");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.biz.qrcode.util.h.T(0, R.string.b3j);
            if (QLog.isColorLevel()) {
                QLog.i("QRDisplayMyCardViewModel", 2, "tryToGetShareLink: net is not supported");
                return;
            }
            return;
        }
        String str = "temp_qrcode_share_" + this.curUin + ".png";
        switch (channelId.hashCode()) {
            case -791575966:
                if (channelId.equals("weixin")) {
                    g3(str, r56, true);
                    return;
                }
                return;
            case -393543490:
                if (channelId.equals("qqfriend")) {
                    W2(str, r56, true);
                    return;
                }
                return;
            case -304161157:
                if (channelId.equals("qzoneshuoshuo")) {
                    R2(r56);
                    return;
                }
                return;
            case 3367071:
                if (channelId.equals("mypc")) {
                    String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                    Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                    c3(r56, 6000, DATALINE_PC_UIN, true);
                    return;
                }
                return;
            case 154627506:
                if (channelId.equals("weixincircle")) {
                    g3(str, r56, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void c2() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        String str = this.curUin;
        if (str != null) {
            com.tencent.biz.qrcode.util.h.R(qQAppInterface, str, 2);
        }
        this.needToChangeToQID.postValue(Boolean.TRUE);
    }

    public final void c3(@NotNull final Activity r112, final int uinType, @NotNull final String uin, final boolean useBottomPreviewFS) {
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(uin, "uin");
        try {
            final String str = "temp_qrcode_share_" + uin + ".png";
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.viewmodel.j
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayMyCardViewModel.e3(r112, str, this, uinType, uin, useBottomPreviewFS);
                }
            }, 8, null, true);
        } catch (OutOfMemoryError unused) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
        }
    }

    public final void d2(@NotNull Activity r56) {
        String str;
        Intrinsics.checkNotNullParameter(r56, "activity");
        com.tencent.biz.qrcode.mgr.d value = this.qrCodeData.getValue();
        String str2 = null;
        if (value != null) {
            str = value.getShortChain();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.biz.qrcode.mgr.d value2 = this.qrCodeData.getValue();
        if (value2 != null) {
            str2 = value2.getShortChain();
        }
        String str3 = "\u70b9\u51fb\u94fe\u63a5\u52a0\u6211\u4e3aQQ\u597d\u53cb\uff1a" + str2;
        if (QLog.isColorLevel()) {
            QLog.i("QRDisplayMyCardViewModel", 2, "copyTroopLink.text:" + str3);
        }
        Object systemService = r56.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("my_qr_url", str3));
        com.tencent.biz.qrcode.util.h.T(2, R.string.f170327mg);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f2(@NotNull Activity r18, int requestCode, int r202, @Nullable Intent data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(r18, "activity");
        if (r202 == -1) {
            if (requestCode != 1) {
                if (requestCode != 2) {
                    if (requestCode == 21) {
                        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(r18), null);
                        if (data != null) {
                            m3.putExtras(new Bundle(data.getExtras()));
                            ArrayList parcelableArrayListExtra = m3.getParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
                            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (z16) {
                                r18.startActivity(m3);
                                r18.finish();
                            }
                        }
                    }
                } else {
                    Intent aliasIntent = SplashActivity.getAliasIntent(r18);
                    if (data != null) {
                        data.putExtras(data);
                    }
                    SessionInfo n06 = ForwardUtils.n0(aliasIntent);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (!(peekAppRuntime instanceof QQAppInterface)) {
                        return;
                    } else {
                        ForwardUtils.p((QQAppInterface) peekAppRuntime, r18, n06, aliasIntent);
                    }
                }
            } else {
                com.tencent.biz.qrcode.util.h.T(2, R.string.f172952g24);
                if (QLog.isColorLevel()) {
                    QLog.i("QRDisplayMyCardViewModel", 2, "shareQRCode success");
                }
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!(peekAppRuntime2 instanceof QQAppInterface)) {
                    return;
                }
                if ((this.mReportFlag & 1) != 0) {
                    ReportController.o(peekAppRuntime2, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
                }
                if (requestCode != 1) {
                    E2();
                    return;
                }
                return;
            }
        }
        if (requestCode != 1) {
        }
    }

    @NotNull
    public final MutableLiveData<Bitmap> g2() {
        return this.cardCache;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QRDisplayMyCardViewModel";
    }

    @NotNull
    public final MutableLiveData<Boolean> h2() {
        return this.cardCacheTrigger;
    }

    @Nullable
    /* renamed from: i2, reason: from getter */
    public final String getCurName() {
        return this.curName;
    }

    public final void init() {
        AppRuntime peekAppRuntime;
        INewFriendService iNewFriendService;
        MyQRCodeManager myQRCodeManager = MyQRCodeManager.f94961a;
        myQRCodeManager.D(this.callback);
        com.tencent.biz.qrcode.mgr.d r16 = myQRCodeManager.r();
        if (r16 != null) {
            QLog.i("QRDisplayMyCardViewModel", 1, "init set Value.");
            this.qrCodeData.setValue(r16);
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iNewFriendService = (INewFriendService) peekAppRuntime.getRuntimeService(INewFriendService.class, "")) != null) {
            iNewFriendService.addListener(this.newFriendListener);
        }
    }

    @Nullable
    /* renamed from: j2, reason: from getter */
    public final String getCurUin() {
        return this.curUin;
    }

    @NotNull
    public final Intent k2(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        try {
            String P = com.tencent.biz.qrcode.util.h.P(context, "temp_qrcode_share_" + this.curUin + ".png", this.shareCache.getValue());
            intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, P);
            intent.putExtra(AppConstants.Key.FORWARD_THUMB, P);
            intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, P);
            intent.putExtra(AppConstants.Key.FORWARD_EXTRA, P);
        } catch (OutOfMemoryError unused) {
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
        }
        return intent;
    }

    public final void l3(@NotNull Activity r112, int selectedChannel) {
        Intrinsics.checkNotNullParameter(r112, "activity");
        boolean z16 = false;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.biz.qrcode.util.h.T(0, R.string.b3j);
            if (QLog.isColorLevel()) {
                QLog.i("QRDisplayMyCardViewModel", 2, "tryToGetShareLink: net is not supported");
                return;
            }
            return;
        }
        String str = "temp_qrcode_share_" + this.curUin + ".png";
        if (selectedChannel != 2) {
            if (selectedChannel != 3) {
                if (selectedChannel == 9 || selectedChannel == 10) {
                    if (selectedChannel == 9) {
                        z16 = true;
                    }
                    g3(str, r112, z16);
                    return;
                }
                return;
            }
            R2(r112);
            return;
        }
        Y2(this, str, r112, false, 4, null);
    }

    @NotNull
    /* renamed from: m2, reason: from getter */
    public final String getMFrom() {
        return this.mFrom;
    }

    public final void m3() {
        INewFriendService iNewFriendService;
        AppRuntime peekAppRuntime;
        MyQRCodeManager.f94961a.P(this.callback);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            iNewFriendService = (INewFriendService) peekAppRuntime.getRuntimeService(INewFriendService.class, "");
        } else {
            iNewFriendService = null;
        }
        if (iNewFriendService == null) {
            return;
        }
        iNewFriendService.removeListener(this.newFriendListener);
    }

    /* renamed from: n2, reason: from getter */
    public final int getMSwitchState() {
        return this.mSwitchState;
    }

    @NotNull
    public final MutableLiveData<Boolean> o2() {
        return this.needToChangeToQID;
    }

    @NotNull
    public final MutableLiveData<com.tencent.biz.qrcode.mgr.d> p2() {
        return this.qrCodeData;
    }

    @NotNull
    public final MutableLiveData<Boolean> q2() {
        return this.shareBitmapTrigger;
    }

    @NotNull
    public final MutableLiveData<Bitmap> r2() {
        return this.shareCache;
    }

    @NotNull
    public final MutableLiveData<Boolean> s2() {
        return this.com.tencent.hippy.qq.utils.HippyReporter.RemoveEngineReason.THEME_CHANGED java.lang.String;
    }

    @NotNull
    public final MutableLiveData<NewFriendToastMessage> t2() {
        return this.toastData;
    }

    public final int u2(boolean isLight) {
        if (isLight) {
            return Color.parseColor("#D9FFFFFF");
        }
        return Color.parseColor("#D9000000");
    }

    public final void v2(boolean isSuccess, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (isSuccess && (obj instanceof QidProfile$GetProfileSSORsp)) {
            QidProfile$GetProfileSSORsp qidProfile$GetProfileSSORsp = (QidProfile$GetProfileSSORsp) obj;
            if (qidProfile$GetProfileSSORsp.is_set.get() == 0) {
                this.mSwitchState = 0;
                return;
            } else {
                if (qidProfile$GetProfileSSORsp.is_set.get() == 1) {
                    this.mSwitchState = 1;
                    return;
                }
                return;
            }
        }
        QLog.e("QRDisplayMyCardViewModel", 1, "QID_QR,pb request,error:" + isSuccess);
    }

    public final boolean w2() {
        return this.mEntity.decodeBool(e2("qrcode_has_click_aigc_button"), false);
    }

    public final boolean x2() {
        boolean z16;
        if (!com.tencent.biz.qrcode.util.f.a()) {
            return false;
        }
        com.tencent.biz.qrcode.mgr.d value = this.qrCodeData.getValue();
        if (value != null && value.getStyle() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @NotNull
    public final MutableLiveData<Boolean> y2() {
        return this.isConfigurationChanged;
    }

    public final boolean z2() {
        String e26 = e2("qrcode_first_open_page");
        boolean decodeBool = this.mEntity.decodeBool(e26, true);
        if (decodeBool) {
            this.mEntity.encodeBool(e26, false);
        }
        return decodeBool;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel$d", "Lnb2/a;", "", "count", "", "onUnreadChanged", "onContactCountChanged", "onMayKnowStatesChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d implements nb2.a {
        d() {
        }

        @Override // nb2.a
        public void onUnreadChanged(int count) {
            AppRuntime peekAppRuntime;
            INewFriendService iNewFriendService;
            structmsg$StructMsg structmsg_structmsg;
            boolean z16;
            boolean z17;
            PBUInt32Field pBUInt32Field;
            boolean z18;
            PBUInt32Field pBUInt32Field2;
            PBUInt32Field pBUInt32Field3;
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iNewFriendService = (INewFriendService) peekAppRuntime.getRuntimeService(INewFriendService.class, "")) != null) {
                boolean z19 = false;
                for (Object obj : iNewFriendService.getAllUnreadMsg()) {
                    if (obj instanceof com.tencent.mobileqq.newfriend.msg.c) {
                        MessageForSystemMsg messageForSystemMsg = ((com.tencent.mobileqq.newfriend.msg.c) obj).f254022d;
                        if (messageForSystemMsg != null) {
                            structmsg_structmsg = messageForSystemMsg.getSystemMsg();
                        } else {
                            structmsg_structmsg = null;
                        }
                        if (structmsg_structmsg != null) {
                            QLog.i("QRDisplayMyCardViewModel", 1, "onUnreadChanged msgTime " + structmsg_structmsg.msg_time.get());
                            structmsg$SystemMsg structmsg_systemmsg = structmsg_structmsg.f436065msg;
                            if (structmsg_systemmsg != null && (pBUInt32Field3 = structmsg_systemmsg.src_id) != null && pBUInt32Field3.get() == 3002) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                structmsg$SystemMsg structmsg_systemmsg2 = structmsg_structmsg.f436065msg;
                                if (structmsg_systemmsg2 != null && (pBUInt32Field2 = structmsg_systemmsg2.src_id) != null && pBUInt32Field2.get() == 2002) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                }
                            }
                            structmsg$SystemMsg structmsg_systemmsg3 = structmsg_structmsg.f436065msg;
                            if (structmsg_systemmsg3 != null && (pBUInt32Field = structmsg_systemmsg3.sub_src_id) != null && pBUInt32Field.get() == 11) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !QRDisplayMyCardViewModel.this.showedMsgTime.contains(Long.valueOf(structmsg_structmsg.msg_time.get()))) {
                                QRDisplayMyCardViewModel.this.showedMsgTime.add(Long.valueOf(structmsg_structmsg.msg_time.get()));
                                z19 = true;
                            }
                        }
                    }
                }
                if (z19) {
                    QLog.i("QRDisplayMyCardViewModel", 1, "onUnreadChanged and toast " + count);
                    QRDisplayMyCardViewModel.this.t2().postValue(new NewFriendToastMessage(count + "\u4e2a\u65b0\u670b\u53cb\u7533\u8bf7", "\u53bb\u6dfb\u52a0"));
                }
            }
        }

        @Override // nb2.a
        public void onContactCountChanged() {
        }

        @Override // nb2.a
        public void onMayKnowStatesChanged() {
        }
    }
}

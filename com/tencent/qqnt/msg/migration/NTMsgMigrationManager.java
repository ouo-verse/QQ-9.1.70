package com.tencent.qqnt.msg.migration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.home.parts.MigrationTipType;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportParseMsgs;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportQueryParam;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportSessionInfo;
import com.tencent.qqnt.kernel.nativeinterface.AndroidImportTableInfo;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DataLineImportInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataLineImportMsgRecords;
import com.tencent.qqnt.kernel.nativeinterface.DataLineImportQueryParam;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOSDbMsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ImportMsgPbRecord;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.ImportRecentUser;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00c9\u00012\u00020\u0001:\u0001nB\u000b\b\u0002\u00a2\u0006\u0006\b\u00c7\u0001\u0010\u00c8\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\"\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eH\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eH\u0002J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eH\u0002J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u000eH\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\b\u0010:\u001a\u00020\u0004H\u0002J\b\u0010;\u001a\u00020\u000eH\u0002J\u0006\u0010<\u001a\u00020\u0004J\u0006\u0010=\u001a\u00020\u0004J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AJ\u000e\u0010D\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AJ\u0006\u0010E\u001a\u00020\u0004J\u0006\u0010F\u001a\u00020\u0004J\u0018\u0010K\u001a\u00020\u00042\u0006\u0010H\u001a\u00020G2\b\u0010J\u001a\u0004\u0018\u00010IJ\u000e\u0010L\u001a\u00020\u00042\u0006\u0010H\u001a\u00020GJ\u0006\u0010M\u001a\u00020\u0004J\"\u0010P\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010N\u001a\u00020\u000e2\b\b\u0002\u0010O\u001a\u00020\u000eJ\u000e\u0010Q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010R\u001a\u00020\u000eJ\u000e\u0010S\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010U\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010T\u001a\u00020\u000eJ\u000e\u0010V\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010W\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010T\u001a\u00020\u000eJ\u0016\u0010X\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eJ\u0016\u0010Y\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eJ\u0016\u0010Z\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eJ\u0016\u0010[\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eJ\u0016\u0010\\\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010]\u001a\u00020\u000eJ\u001a\u0010a\u001a\u00020`2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010_\u001a\u0004\u0018\u00010^J\u000e\u0010b\u001a\u00020\u00042\u0006\u0010H\u001a\u00020GJ\u0006\u0010c\u001a\u00020\u0004J\u0006\u0010d\u001a\u00020\u0004J\u0006\u0010e\u001a\u00020\u0004J\u0006\u0010f\u001a\u00020\u0004J\u0006\u0010g\u001a\u00020\u0002J\u000e\u0010h\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010k\u001a\u00020\u00042\u0006\u0010j\u001a\u00020iJ\u000e\u0010m\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u0002R\u0016\u0010p\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010oR\u0016\u0010t\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010oR\"\u0010z\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010o\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R#\u0010\u0080\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b}\u0010o\u001a\u0004\b~\u0010w\"\u0004\b\u007f\u0010yR)\u0010\u0087\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0082\u0001\u0010@\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R(\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R&\u0010\u0091\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008e\u0001\u0010o\u001a\u0005\b\u008f\u0001\u0010w\"\u0005\b\u0090\u0001\u0010yR(\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R&\u0010\u009b\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0098\u0001\u0010o\u001a\u0005\b\u0099\u0001\u0010w\"\u0005\b\u009a\u0001\u0010yR&\u0010\u009f\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009c\u0001\u0010o\u001a\u0005\b\u009d\u0001\u0010w\"\u0005\b\u009e\u0001\u0010yR\u0018\u0010\u00a1\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010oR\u0019\u0010\u00a3\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a2\u0001\u0010@R\u001c\u0010\u00a7\u0001\u001a\u0005\u0018\u00010\u00a4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u001c\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a6\u0001R,\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001e\u0010\u00b5\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R \u0010\u00ba\u0001\u001a\u00030\u00b6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001\u001a\u0005\bo\u0010\u00b9\u0001R\u001c\u0010\u00be\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u001c\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00bf\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u001c\u0010\u00c6\u0001\u001a\u0005\u0018\u00010\u00c3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001\u00a8\u0006\u00ca\u0001"}, d2 = {"Lcom/tencent/qqnt/msg/migration/NTMsgMigrationManager;", "", "", "uin", "", "p1", "r0", "Lcom/tencent/qqnt/kernel/nativeinterface/ImportOldDbMsgNotifyInfo;", "notifyInfo", "l0", "curUin", "", MessageRoamJsPlugin.USERTYPE, "y0", "", "C0", "charging", "J0", "t0", "L", "Q0", "", "progress", "P0", "R0", "isLowMem", "O0", "fromRetry", "u1", "x1", "K0", "tipLevel", "updateNormalRetryCount", "Z0", BdhLogUtil.LogTag.Tag_Req, "x0", "r1", "E1", "V", Constants.APK_CERTIFICATE, "a0", "M", "T", "value", "h1", "o0", "i1", "j1", "k1", "u0", "n0", "m0", "p0", "E0", "q0", "needDelayStop", "A0", "W0", "V0", "Y", "N", "P", "k0", "s0", "J", "Lcom/tencent/qqnt/msg/migration/a;", "listener", "K", "X0", "c1", "b1", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "app", "i0", "j0", "A1", "isFirstUpgrade", "fromClickTipBar", "G0", "F1", "D0", "U0", "enable", "d1", "U", "e1", "m1", "g1", "f1", "l1", ICustomDataEditor.NUMBER_PARAM_1, "F0", "Landroid/view/View$OnClickListener;", "onClickListener", "Landroid/text/SpannableString;", "e0", "q1", ExifInterface.LATITUDE_SOUTH, "M0", "T0", "S0", "c0", "d0", "Lcom/tencent/mobileqq/activity/home/parts/a;", "tipData", "L0", "tag", "Y0", "a", "Z", "isInCheckingNetWork", "b", "mLastSetPowerStatus", "c", "isMigrateSucc", "d", "w0", "()Z", "setInit", "(Z)V", "isInit", "e", "Ljava/lang/String;", "f", "v0", "setInMigrating", "isInMigrating", "", "g", "getLastTriggerMills", "()J", "setLastTriggerMills", "(J)V", "lastTriggerMills", tl.h.F, UserInfo.SEX_FEMALE, "b0", "()F", HippyQQPagView.FunctionName.SET_PROGRESS, "(F)V", "i", "g0", "setUpdateBanner", "updateBanner", "j", "I", "h0", "()I", "o1", "(I)V", "k", "getNeedShowTipInSearch", "setNeedShowTipInSearch", "needShowTipInSearch", "l", "getNeedContinueMigration", "setNeedContinueMigration", "needContinueMigration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "useSpeedTipBar", DomainData.DOMAIN_NAME, "lastGotoDetailPageTime", "Ljava/lang/Runnable;", "o", "Ljava/lang/Runnable;", "delayStopImportJob", "p", "delayRetryImportJob", "Lcom/tencent/mobileqq/activity/home/parts/MigrationTipType;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/activity/home/parts/MigrationTipType;", "W", "()Lcom/tencent/mobileqq/activity/home/parts/MigrationTipType;", "setCurShowTipType", "(Lcom/tencent/mobileqq/activity/home/parts/MigrationTipType;)V", "curShowTipType", "", "r", "Ljava/util/List;", "listeners", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "t", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "kernelListener", "Landroid/content/BroadcastReceiver;", "u", "Landroid/content/BroadcastReceiver;", "powerStatusListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgImportToolListener;", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgImportToolListener;", "kernelMsgImportToolListener", "<init>", "()V", "w", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTMsgMigrationManager {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private static final Lazy<NTMsgMigrationManager> f359654x;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isInCheckingNetWork;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mLastSetPowerStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isMigrateSucc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInMigrating;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile long lastTriggerMills;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean updateBanner;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int userType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean needShowTipInSearch;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean needContinueMigration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean useSpeedTipBar;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long lastGotoDetailPageTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable delayStopImportJob;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable delayRetryImportJob;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile MigrationTipType curShowTipType;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> listeners;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mmkv;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IKernelMsgListener kernelListener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BroadcastReceiver powerStatusListener;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IKernelMsgImportToolListener kernelMsgImportToolListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\fR\u0014\u0010\u001f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\f\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/msg/migration/NTMsgMigrationManager$a;", "", "Lcom/tencent/qqnt/msg/migration/NTMsgMigrationManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/msg/migration/NTMsgMigrationManager;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "KEY_MIGRATION_USER_TYPE", "Ljava/lang/String;", "KEY_NT_MSG_MIGRATION_AUTO_MIGRATION_IN_CHARGE", "KEY_NT_MSG_MIGRATION_BACK_MIGRATION", "KEY_NT_MSG_MIGRATION_CHARGE_QUICKEN", "KEY_NT_MSG_MIGRATION_FEATURE_SWITCH", "KEY_NT_MSG_MIGRATION_FIRST_RETRY_TIME", "KEY_NT_MSG_MIGRATION_HAS_CLOSE_FAIL_TIPBAR", "KEY_NT_MSG_MIGRATION_HAS_CLOSE_LOW_MEM_TIPBAR", "KEY_NT_MSG_MIGRATION_HAS_SHOW_BACK_MIGRATION_DIALOG", "KEY_NT_MSG_MIGRATION_HAS_SHOW_FAIL_DIALOG", "KEY_NT_MSG_MIGRATION_HAS_SHOW_LOW_MEM_DIALOG", "KEY_NT_MSG_MIGRATION_HAS_SHOW_LOW_MEM_TIP", "KEY_NT_MSG_MIGRATION_HAS_SHOW_LOW_MEM_TIPBAR", "KEY_NT_MSG_MIGRATION_IS_FIRST_UPGRADE", "KEY_NT_MSG_MIGRATION_NEED_SHOW_SPEEDUP", "KEY_NT_MSG_MIGRATION_NORMAL_RETRY_COUNT", "KEY_NT_MSG_MIGRATION_RETRY_COUNT", "KEY_NT_MSG_MIGRATION_RETRY_TIME", "MIGRATION_DETAIL_URL", "TAG", "TAG_PREFIX", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final NTMsgMigrationManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (NTMsgMigrationManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (NTMsgMigrationManager) NTMsgMigrationManager.f359654x.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359677a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64053);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MigrationTipType.values().length];
            try {
                iArr[MigrationTipType.Progress.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MigrationTipType.Fail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MigrationTipType.LowMem.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f359677a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000k\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u000f\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J@\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0012j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`\u00142\u001e\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`\u0014H\u0016J\u000f\u0010\u0018\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001bH\u0016J@\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u0012j\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u0001`\u00142\u001e\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`\u0014H\u0016J\u0018\u0010!\u001a\u0012\u0012\u0004\u0012\u00020 0\u0012j\b\u0012\u0004\u0012\u00020 `\u0014H\u0016\u00a8\u0006\""}, d2 = {"com/tencent/qqnt/msg/migration/NTMsgMigrationManager$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgImportToolListener;", "", ReportPlugin.KEY_TABLE_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportTableInfo;", "getAndroidImportTableInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportSessionInfo;", "getAndroidImportSessionInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportQueryParam;", "queryParam", "Lcom/tencent/qqnt/kernel/nativeinterface/AndroidImportParseMsgs;", "getAndroidImportParseMsgs", "", "isHasMsgRecordToImport", "()Ljava/lang/Boolean;", "", "getAndroidFreeDiskSize", "()Ljava/lang/Long;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOSDbMsgRecord;", "Lkotlin/collections/ArrayList;", "records", "Lcom/tencent/qqnt/kernel/nativeinterface/ImportMsgPbRecord;", "parseiOSDbMsgRecords", "isHasDataLineMsgToImport", "Lcom/tencent/qqnt/kernel/nativeinterface/DataLineImportInfo;", "getDataLineImportInfosByTableName", "Lcom/tencent/qqnt/kernel/nativeinterface/DataLineImportQueryParam;", "Lcom/tencent/qqnt/kernel/nativeinterface/DataLineImportMsgRecords;", "getDataLineImportMsgRecords", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "parseiOSSpecialMsgRecords", "Lcom/tencent/qqnt/kernel/nativeinterface/ImportRecentUser;", "getiOSRecentUserDatas", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements IKernelMsgImportToolListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public Long getAndroidFreeDiskSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Long) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return Long.valueOf(cu.c());
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public AndroidImportParseMsgs getAndroidImportParseMsgs(@NotNull AndroidImportQueryParam queryParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AndroidImportParseMsgs) iPatchRedirector.redirect((short) 4, (Object) this, (Object) queryParam);
            }
            Intrinsics.checkNotNullParameter(queryParam, "queryParam");
            return r.f359707a.b(queryParam);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public AndroidImportSessionInfo getAndroidImportSessionInfos() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AndroidImportSessionInfo) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return r.f359707a.c();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public AndroidImportTableInfo getAndroidImportTableInfos(@NotNull String tableName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AndroidImportTableInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tableName);
            }
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            return r.f359707a.d(tableName);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public DataLineImportInfo getDataLineImportInfosByTableName(@NotNull String tableName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (DataLineImportInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) tableName);
            }
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            QLog.i("NTMsgMigration.Manager", 1, "getDataLineImportInfosByTableName " + tableName);
            return DataLineNTMsgMigrationUtil.f(tableName);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public DataLineImportMsgRecords getDataLineImportMsgRecords(@NotNull DataLineImportQueryParam queryParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (DataLineImportMsgRecords) iPatchRedirector.redirect((short) 10, (Object) this, (Object) queryParam);
            }
            Intrinsics.checkNotNullParameter(queryParam, "queryParam");
            QLog.i("NTMsgMigration.Manager", 1, "getDataLineImportMsgRecords " + queryParam);
            return DataLineNTMsgMigrationUtil.g(queryParam);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public ArrayList<ImportRecentUser> getiOSRecentUserDatas() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return new ArrayList<>();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public Boolean isHasDataLineMsgToImport() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Boolean) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            QLog.i("NTMsgMigration.Manager", 1, "isHasDataLineMsgToImport");
            return Boolean.valueOf(DataLineNTMsgMigrationUtil.j());
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @NotNull
        public Boolean isHasMsgRecordToImport() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Boolean) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return Boolean.valueOf(r.f359707a.q());
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @Nullable
        public ArrayList<ImportMsgPbRecord> parseiOSDbMsgRecords(@Nullable ArrayList<IOSDbMsgRecord> records) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this, (Object) records);
            }
            return null;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener
        @Nullable
        public ArrayList<MsgRecord> parseiOSSpecialMsgRecords(@Nullable ArrayList<IOSDbMsgRecord> records) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) records);
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/msg/migration/NTMsgMigrationManager$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/ImportOldDbMsgNotifyInfo;", "notifyInfo", "", "onImportOldDbProgressUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onImportOldDbProgressUpdate(@NotNull ImportOldDbMsgNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
            ax.p(this, notifyInfo);
            NTMsgMigrationManager.this.l0(notifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    static {
        Lazy<NTMsgMigrationManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64085);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 57)) {
            redirector.redirect((short) 57);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(NTMsgMigrationManager$Companion$instance$2.INSTANCE);
        f359654x = lazy;
    }

    public /* synthetic */ NTMsgMigrationManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
            return;
        }
        iPatchRedirector.redirect((short) 56, (Object) this, (Object) defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(boolean needDelayStop) {
        String str;
        IFeatureRuntimeService iFeatureRuntimeService;
        int i3;
        QLog.d("NTMsgMigration.Manager", 1, "keepImportBackground needDelayStop: " + needDelayStop + " isInMigration: " + this.isInMigrating);
        if (!this.isInMigrating) {
            return;
        }
        W0();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, String> map = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (U(str)) {
            QLog.d("NTMsgMigration.Manager", 1, "keepImportBackground BackMigration enable. return");
            return;
        }
        if (!needDelayStop) {
            return;
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime2.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            map = iFeatureRuntimeService.isEnabledWithDataSet("android_nt_migration", "");
        }
        if (map != null && !map.isEmpty()) {
            QLog.i("NTMsgMigration.Manager", 1, "keepImportBackground start delayStopImportJob");
            String str2 = map.get("backMigrateTime");
            if (str2 != null) {
                i3 = Integer.parseInt(str2);
            } else {
                i3 = 5;
            }
            this.delayStopImportJob = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.msg.migration.p
                @Override // java.lang.Runnable
                public final void run() {
                    NTMsgMigrationManager.B0(NTMsgMigrationManager.this);
                }
            }, 32, null, true, i3 * 60 * 1000);
            return;
        }
        QLog.e("NTMsgMigration.Manager", 1, "feature switch dataset is null ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(NTMsgMigrationManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("NTMsgMigration.Manager", 1, "process stop background migration " + this$0.isInMigrating);
        if (!this$0.isInMigrating) {
            return;
        }
        this$0.needContinueMigration = true;
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.stopImportOldDbMsgAndroid();
        }
        this$0.isInMigrating = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1() {
        QQToast.makeText(BaseApplication.context, R.string.f171842ou, 0).show();
    }

    private final boolean C0() {
        IFeatureRuntimeService iFeatureRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        boolean z16 = false;
        if (iFeatureRuntimeService != null) {
            z16 = iFeatureRuntimeService.isFeatureSwitchEnable("msg_migration_charge_quicken", false);
        }
        QLog.d("NTMsgMigration.Manager", 1, "needChargeQuicken feature switch: " + z16 + " ");
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1() {
        QQToast.makeText(BaseApplication.context, R.string.f171992p9, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1() {
        QQToast.makeText(BaseApplication.context, R.string.f171872ox, 0).show();
    }

    private final boolean E0(String uin) {
        return Z().decodeBool("nt_msg_migration_need_show_speedup" + uin, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(String uin) {
        int decodeInt = Z().decodeInt("nt_msg_migration_retry_count" + uin, 0);
        int i3 = decodeInt + 1;
        Z().encodeInt("nt_msg_migration_retry_count" + uin, i3);
        QLog.d("NTMsgMigration.Manager", 1, "updateAllRetryCount " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(String uin) {
        int decodeInt = Z().decodeInt("nt_msg_migration_all_retry_count" + uin, 0);
        int i3 = decodeInt + 1;
        Z().encodeInt("nt_msg_migration_all_retry_count" + uin, i3);
        QLog.d("NTMsgMigration.Manager", 1, "updateNormalRetryCount " + i3);
    }

    public static /* synthetic */ void H0(NTMsgMigrationManager nTMsgMigrationManager, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        nTMsgMigrationManager.G0(str, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(NTMsgMigrationManager this$0, boolean z16, boolean z17, String uin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (!this$0.isInit) {
            QLog.i("NTMsgMigration.Manager", 1, "newMigration not init");
            if (z16) {
                this$0.K0();
            }
        }
        if (this$0.isInMigrating) {
            QLog.i("NTMsgMigration.Manager", 1, "newMigration in migrating");
            return;
        }
        if (!z17) {
            this$0.m1(uin, false);
        }
        this$0.U0(uin);
        this$0.F1(uin);
        this$0.x1(uin, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(boolean charging) {
        String str;
        if (!this.isInMigrating) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        boolean U = U(str);
        QLog.d("NTMsgMigration.Manager", 1, "notifyKernelPowerStatus charging: " + charging + ", enableBack: " + U);
        if (U) {
            if (!this.mLastSetPowerStatus) {
                QLog.d("NTMsgMigration.Manager", 1, "setPowerStatus true");
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.setPowerStatus(true);
                }
                this.mLastSetPowerStatus = true;
                return;
            }
            return;
        }
        if (C0() && this.mLastSetPowerStatus != charging) {
            QLog.d("NTMsgMigration.Manager", 1, "setPowerStatus " + charging);
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                e17.setPowerStatus(charging);
            }
            this.mLastSetPowerStatus = charging;
        }
    }

    private final void K0() {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$notifyOnIntercept$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                list = NTMsgMigrationManager.this.listeners;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(String uin) {
        QLog.d("NTMsgMigration.Manager", 1, "autoStartInCharging");
        H0(this, uin, false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(String uin) {
        IFeatureRuntimeService iFeatureRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, String> map = null;
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            map = iFeatureRuntimeService.isEnabledWithDataSet("android_nt_migration", "");
        }
        QLog.i("NTMsgMigration.Manager", 1, "canRetryAutoMigrate " + map);
        float f16 = 3.0f;
        int i3 = 10;
        if (map != null && (!map.isEmpty())) {
            String str = map.get("autoRetryCount");
            if (str != null) {
                i3 = Integer.parseInt(str);
            }
            String str2 = map.get("retryDaysAndroid");
            if (str2 != null) {
                f16 = Float.parseFloat(str2);
            }
        }
        long decodeLong = Z().decodeLong("key_nt_msg_migration_first_retry_time" + uin, 0L);
        if (decodeLong != 0) {
            float f17 = 60;
            if (((float) (System.currentTimeMillis() - decodeLong)) > 24 * f16 * f17 * f17 * 1000) {
                QLog.i("NTMsgMigration.Manager", 1, "canRetryAutoMigrate beyond " + f16 + " days");
                return false;
            }
        }
        int a06 = a0(uin);
        QLog.i("NTMsgMigration.Manager", 1, "canRetryAutoMigrate now retry times: " + a06 + " maxCount: " + i3);
        if (a06 < i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(NTMsgMigrationManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(NTMsgMigrationManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isInit) {
            QLog.e("NTMsgMigration.Manager", 1, "checkMsgMigrationPrompt has init. call clear.");
            this$0.S();
        }
        this$0.P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(String uin, boolean isLowMem) {
        MigrationTipType migrationTipType;
        QLog.d("NTMsgMigration.Manager", 1, "onMigrateFail isLowMem:" + isLowMem);
        this.isInMigrating = false;
        this.needContinueMigration = false;
        W0();
        if (isLowMem && n0(uin)) {
            QLog.d("NTMsgMigration.Manager", 1, "onMigrateFail not show tipbar");
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).d(isLowMem, false);
            }
            this.curShowTipType = null;
            return;
        }
        if (!isLowMem && m0(uin)) {
            QLog.d("NTMsgMigration.Manager", 1, "onMigrateFail not show tipbar");
            Iterator<T> it5 = this.listeners.iterator();
            while (it5.hasNext()) {
                ((a) it5.next()).d(isLowMem, false);
            }
            this.curShowTipType = null;
            return;
        }
        boolean x06 = x0(uin);
        QLog.d("NTMsgMigration.Manager", 1, "onMigrateFail show tipbar:" + x06);
        Iterator<T> it6 = this.listeners.iterator();
        while (it6.hasNext()) {
            ((a) it6.next()).d(isLowMem, x06);
        }
        if (x06) {
            if (isLowMem) {
                migrationTipType = MigrationTipType.LowMem;
            } else {
                migrationTipType = MigrationTipType.Fail;
            }
            this.curShowTipType = migrationTipType;
        } else {
            this.curShowTipType = null;
        }
        if (x06 && isLowMem) {
            l1(uin, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(float progress) {
        boolean z16;
        MigrationTipType migrationTipType;
        this.progress = progress;
        if (this.useSpeedTipBar && E0(this.curUin)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            INSTANCE.a().updateBanner = true;
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(progress, z16);
        }
        if (z16) {
            migrationTipType = MigrationTipType.ProgressWithSpeedTip;
        } else {
            migrationTipType = MigrationTipType.Progress;
        }
        this.curShowTipType = migrationTipType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final NTMsgMigrationManager this$0, int i3, String str, int i16) {
        boolean z16;
        String str2;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NTMsgMigration.Manager", 1, "checkMsgMigrationPrompt canImportOldDbMsg " + i3 + " " + str + " tipLevel=" + i16);
        if (i3 != 2 && i3 != 3) {
            this$0.userType = i16;
            if (i16 != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this$0.needShowTipInSearch = z16;
            AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
            if (peekAppRuntime != null) {
                str2 = peekAppRuntime.getCurrentAccountUin();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                return;
            }
            this$0.updateBanner = this$0.x0(str2);
            if (i3 == 1) {
                if (!this$0.x0(str2)) {
                    if (this$0.M(str2)) {
                        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$checkMsgMigrationPromptInSubThread$1$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                                if (qBaseActivity != null) {
                                    NTMsgMigrationManager.this.q1(qBaseActivity);
                                }
                            }
                        });
                    }
                } else {
                    this$0.p1(str2);
                }
                if (this$0.M(str2)) {
                    this$0.E1(str2);
                    this$0.G1(str2);
                    return;
                }
                return;
            }
            if (i3 != 0 && i3 != 6) {
                if (this$0.p0(str2)) {
                    QLog.d("NTMsgMigration.Manager", 1, "checkMsgMigrationPrompt hasShowLowMemTipBar");
                    return;
                } else if (i3 == 4) {
                    this$0.Z0(str2, i16, false);
                    return;
                } else {
                    if (i3 == 5) {
                        v1(this$0, str2, false, 2, null);
                        return;
                    }
                    return;
                }
            }
            if (i3 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            H0(this$0, str2, z17, false, 4, null);
            return;
        }
        this$0.needShowTipInSearch = false;
        this$0.isMigrateSucc = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        boolean z16;
        MigrationTipType migrationTipType;
        QLog.d("NTMsgMigration.Manager", 1, "onMigrateStart");
        if (this.useSpeedTipBar && E0(this.curUin)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            INSTANCE.a().updateBanner = true;
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z16);
        }
        if (z16) {
            migrationTipType = MigrationTipType.ProgressWithSpeedTip;
        } else {
            migrationTipType = MigrationTipType.Progress;
        }
        this.curShowTipType = migrationTipType;
    }

    private final void R(final String uin) {
        IFeatureRuntimeService iFeatureRuntimeService;
        if (!x0(uin)) {
            QLog.i("NTMsgMigration.Manager", 1, "checkShowEnableBackMigrationDialog not StrongNotify");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, String> map = null;
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            map = iFeatureRuntimeService.isEnabledWithDataSet("android_nt_migration", "");
        }
        QLog.i("NTMsgMigration.Manager", 1, "checkShowEnableBackMigrationDialog " + map);
        int i3 = 10;
        boolean z16 = false;
        if (map != null && (!map.isEmpty())) {
            String str = map.get("backMigrateCount");
            if (str != null) {
                i3 = Integer.parseInt(str);
            }
            String str2 = map.get("backMigrateEnable");
            if (str2 != null) {
                z16 = Boolean.parseBoolean(str2);
            }
        }
        if (this.useSpeedTipBar) {
            int V = V(uin);
            QLog.d("NTMsgMigration.Manager", 1, "checkShowEnableBackMigrationDialog allRetryCount=" + V);
            if (V >= i3) {
                d1(uin, true);
                n1(uin, true);
                return;
            }
            return;
        }
        if (!z16 || U(uin)) {
            return;
        }
        int V2 = V(uin);
        QLog.d("NTMsgMigration.Manager", 1, "checkShowEnableBackMigrationDialog allRetryCount=" + V2);
        if (V2 >= i3) {
            d1(uin, true);
            if (o0(uin)) {
                QLog.d("NTMsgMigration.Manager", 1, "checkShowEnableBackMigrationDialog has show");
            } else {
                PostUtilKt.b(new Function0<Unit>(uin) { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$checkShowEnableBackMigrationDialog$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $uin;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$uin = uin;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this, (Object) uin);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            NTMsgMigrationManager.this.r1(this.$uin);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(String uin) {
        QLog.d("NTMsgMigration.Manager", 1, "onMigrateSuccess");
        this.isInMigrating = false;
        this.needShowTipInSearch = false;
        this.needContinueMigration = false;
        this.isMigrateSucc = true;
        this.curShowTipType = null;
        W0();
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T(String uin) {
        return Z().decodeBool("key_nt_msg_migration_auto_migration_in_charge" + uin, false);
    }

    private final int V(String uin) {
        return Z().decodeInt("nt_msg_migration_retry_count" + uin, 0);
    }

    private final void V0() {
        Runnable runnable = this.delayRetryImportJob;
        if (runnable != null) {
            try {
                ThreadManagerV2.removeJob(runnable, 32);
            } catch (Exception unused) {
                QLog.e("NTMsgMigration.Manager", 1, "removeDelayRetryImportJob Exception");
            }
        }
        this.delayRetryImportJob = null;
    }

    private final void W0() {
        Runnable runnable = this.delayStopImportJob;
        if (runnable != null) {
            try {
                ThreadManagerV2.removeJob(runnable, 32);
            } catch (Exception unused) {
                QLog.e("NTMsgMigration.Manager", 1, "removeDelayStopImportJob Exception");
            }
        }
        this.delayStopImportJob = null;
    }

    @NotNull
    public static final NTMsgMigrationManager X() {
        return INSTANCE.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Y() {
        int i3;
        boolean isCharging;
        int intProperty;
        try {
            Object systemService = BaseApplication.getContext().getSystemService("batterymanager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
            BatteryManager batteryManager = (BatteryManager) systemService;
            isCharging = batteryManager.isCharging();
            intProperty = SystemMethodProxy.getIntProperty(batteryManager, 6);
            if (intProperty != 2 && intProperty != 5 && !isCharging) {
                i3 = 0;
            } else {
                i3 = 1;
            }
        } catch (Throwable th5) {
            th = th5;
            i3 = 0;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("NTMsgMigration.Manager", 1, "getLocalPowerConnectStatus isCharging: " + isCharging + ", chargeStatus: " + intProperty + ", ret: " + i3);
            }
        } catch (Throwable th6) {
            th = th6;
            QLog.e("NTMsgMigration.Manager", 1, "getLocalPower t:", th);
            if (i3 != 1) {
            }
        }
        if (i3 != 1) {
            return true;
        }
        return false;
    }

    private final MMKVOptionEntity Z() {
        return (MMKVOptionEntity) this.mmkv.getValue();
    }

    private final void Z0(final String uin, int tipLevel, boolean updateNormalRetryCount) {
        QLog.i("NTMsgMigration.Manager", 1, "retryMigration uin: " + uin + " tipLevel: " + tipLevel);
        if (!this.isInit) {
            QLog.i("NTMsgMigration.Manager", 1, "retryMigration not init");
            return;
        }
        if (!M(uin)) {
            QLog.i("NTMsgMigration.Manager", 1, "retryMigration can not retry");
            PostUtilKt.b(new Function0<Unit>(uin) { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$retryMigration$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $uin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$uin = uin;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this, (Object) uin);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        NTMsgMigrationManager.this.O0(this.$uin, false);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
            if (x0(uin)) {
                d1(uin, true);
                if (this.useSpeedTipBar) {
                    n1(uin, true);
                    return;
                }
                return;
            }
            return;
        }
        R(uin);
        u1(uin, true);
        E1(uin);
        if (updateNormalRetryCount) {
            G1(uin);
        }
    }

    private final int a0(String uin) {
        return Z().decodeInt("nt_msg_migration_all_retry_count" + uin, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a1(NTMsgMigrationManager nTMsgMigrationManager, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        nTMsgMigrationManager.Z0(str, i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(NTMsgMigrationManager this$0, View.OnClickListener onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A1();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h1(String uin, boolean value) {
        Z().encodeBool("nt_msg_migration_has_show_back_migr" + uin, value);
    }

    private final void i1(String uin, boolean value) {
        Z().encodeBool("nt_msg_migration_has_show_fail" + uin, value);
    }

    private final void j1(String uin, boolean value) {
        Z().encodeBool("nt_msg_migration_has_show_low_mem" + uin, value);
    }

    private final void k1(String uin, boolean value) {
        Z().encodeBool("nt_msg_migration_has_show_low_mem_tip" + uin, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(final ImportOldDbMsgNotifyInfo notifyInfo) {
        QLog.d("NTMsgMigration.Manager", 1, "handleMigrationResult result=" + notifyInfo.result + ", progress=" + notifyInfo.progress);
        PostUtilKt.b(new Function0<Unit>(notifyInfo) { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$handleMigrationResult$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ImportOldDbMsgNotifyInfo $notifyInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$notifyInfo = notifyInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this, (Object) notifyInfo);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                String str3;
                boolean x06;
                String str4;
                String str5;
                String str6;
                QBaseActivity qBaseActivity;
                String str7;
                String str8;
                String str9;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                str = NTMsgMigrationManager.this.curUin;
                if (TextUtils.isEmpty(str)) {
                    QLog.e("NTMsgMigration.Manager", 1, "handleMigrationResult uin is null");
                    return;
                }
                ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo = this.$notifyInfo;
                int i3 = importOldDbMsgNotifyInfo.result;
                if (i3 == 0) {
                    float f16 = importOldDbMsgNotifyInfo.progress;
                    NTMsgMigrationManager.this.P0(f16);
                    if (f16 == 100.0f) {
                        NTMsgMigrationManager nTMsgMigrationManager = NTMsgMigrationManager.this;
                        str2 = nTMsgMigrationManager.curUin;
                        nTMsgMigrationManager.R0(str2);
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    NTMsgMigrationManager nTMsgMigrationManager2 = NTMsgMigrationManager.this;
                    str3 = nTMsgMigrationManager2.curUin;
                    x06 = nTMsgMigrationManager2.x0(str3);
                    if (!x06 && (qBaseActivity = QBaseActivity.sTopActivity) != null) {
                        NTMsgMigrationManager.this.q1(qBaseActivity);
                    }
                    NTMsgMigrationManager nTMsgMigrationManager3 = NTMsgMigrationManager.this;
                    str4 = nTMsgMigrationManager3.curUin;
                    nTMsgMigrationManager3.O0(str4, true);
                    NTMsgMigrationManager nTMsgMigrationManager4 = NTMsgMigrationManager.this;
                    str5 = nTMsgMigrationManager4.curUin;
                    nTMsgMigrationManager4.E1(str5);
                    NTMsgMigrationManager nTMsgMigrationManager5 = NTMsgMigrationManager.this;
                    str6 = nTMsgMigrationManager5.curUin;
                    nTMsgMigrationManager5.G1(str6);
                    return;
                }
                if (i3 == 2 || i3 == 4 || i3 == 7) {
                    NTMsgMigrationManager.this.P0(100.0f);
                    NTMsgMigrationManager nTMsgMigrationManager6 = NTMsgMigrationManager.this;
                    str7 = nTMsgMigrationManager6.curUin;
                    nTMsgMigrationManager6.R0(str7);
                    return;
                }
                if (i3 == 5) {
                    NTMsgMigrationManager nTMsgMigrationManager7 = NTMsgMigrationManager.this;
                    str9 = nTMsgMigrationManager7.curUin;
                    nTMsgMigrationManager7.y0(str9, NTMsgMigrationManager.this.h0());
                } else {
                    NTMsgMigrationManager nTMsgMigrationManager8 = NTMsgMigrationManager.this;
                    str8 = nTMsgMigrationManager8.curUin;
                    NTMsgMigrationManager.a1(nTMsgMigrationManager8, str8, NTMsgMigrationManager.this.h0(), false, 4, null);
                }
            }
        });
    }

    private final boolean m0(String uin) {
        boolean decodeBool = Z().decodeBool("nt_msg_migration_has_close_fail_tipbar" + uin, false);
        QLog.d("NTMsgMigration.Manager", 1, "hasCloseFailTipBar " + decodeBool);
        return decodeBool;
    }

    private final boolean n0(String uin) {
        boolean decodeBool = Z().decodeBool("nt_msg_migration_has_close_low_mem_tipbar" + uin, false);
        QLog.d("NTMsgMigration.Manager", 1, "hasCloseLowMemTipBar " + decodeBool);
        return decodeBool;
    }

    private final boolean o0(String uin) {
        return Z().decodeBool("nt_msg_migration_has_show_back_migr" + uin, false);
    }

    private final boolean p0(String uin) {
        boolean decodeBool = Z().decodeBool("nt_msg_migration_has_show_low_mem_tipbar" + uin, false);
        QLog.d("NTMsgMigration.Manager", 1, "hasShowLowMemTipBar " + decodeBool);
        return decodeBool;
    }

    private final void p1(final String uin) {
        PostUtilKt.b(new Function0<Unit>(uin) { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$showLowMemTipBar$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$uin = uin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this, (Object) uin);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    NTMsgMigrationManager.this.O0(this.$uin, true);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private final void q0(String uin) {
        IFeatureRuntimeService iFeatureRuntimeService;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, String> map = null;
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            map = iFeatureRuntimeService.isEnabledWithDataSet("android_nt_migration", "");
        }
        QLog.d("NTMsgMigration.Manager", 1, "initConfig " + map);
        if (map != null && (!map.isEmpty())) {
            String str = map.get("useSpeedTipBar");
            if (str != null) {
                z16 = Boolean.parseBoolean(str);
            } else {
                z16 = true;
            }
            this.useSpeedTipBar = z16;
        }
        QLog.d("NTMsgMigration.Manager", 1, "initConfig useSpeedTipBar:" + this.useSpeedTipBar + ", needShowSpeedUp:" + E0(uin));
    }

    private final void r0() {
        QLog.d("NTMsgMigration.Manager", 1, "initKernelListener");
        r.f359707a.p();
        this.kernelListener = new d();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            IKernelMsgListener iKernelMsgListener = this.kernelListener;
            Intrinsics.checkNotNull(iKernelMsgListener);
            e16.addMsgListener(iKernelMsgListener);
        }
        J();
        w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 != null) {
            e17.importDataLineMsg();
        }
        QLog.i("NTMsgMigration.Manager", 1, "startMigration importDataLineMsg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(final String uin) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        QLog.d("NTMsgMigration.Manager", 1, "showOpenBackMigrateDialog " + qBaseActivity);
        if (qBaseActivity != null) {
            if (!qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed()) {
                h1(uin, true);
                try {
                    DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, qBaseActivity.getString(R.string.f171882oy), qBaseActivity.getString(R.string.cancel), qBaseActivity.getString(R.string.f171892oz), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.msg.migration.g
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            NTMsgMigrationManager.s1(NTMsgMigrationManager.this, uin, dialogInterface, i3);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.msg.migration.h
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            NTMsgMigrationManager.t1(dialogInterface, i3);
                        }
                    }).show();
                } catch (Exception e16) {
                    QLog.d("NTMsgMigration.Manager", 1, "showOpenBackMigrateDialog error", e16);
                }
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C500", "0X800C500", 0, 0, "", "", "", "");
                return;
            }
            QLog.d("NTMsgMigration.Manager", 1, "showOpenBackMigrateDialog isFinishing");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(final NTMsgMigrationManager this$0, String uin, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        QLog.d("NTMsgMigration.Manager", 1, "showOpenBackMigrateDialog click open");
        this$0.e1(uin, true);
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$showOpenBackMigrateDialog$1$dialog$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                list = NTMsgMigrationManager.this.listeners;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).e(true);
                }
            }
        });
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C501", "0X800C501", 1, 0, "", "", "", "");
    }

    private final void t0() {
        QLog.d("NTMsgMigration.Manager", 1, "initPowerStatusListener");
        this.powerStatusListener = new BroadcastReceiver() { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$initPowerStatusListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                boolean z16;
                boolean z17;
                String str;
                boolean z18;
                boolean M;
                boolean T;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (intent != null) {
                    String action = intent.getAction();
                    z16 = NTMsgMigrationManager.this.isMigrateSucc;
                    QLog.i("NTMsgMigration.Manager", 1, "powerStatusListener onReceive action=" + action + " isMigrateSucc=" + z16 + " isInMigrating=" + NTMsgMigrationManager.this.v0() + " isInit=" + NTMsgMigrationManager.this.w0());
                    if (NTMsgMigrationManager.this.w0()) {
                        z17 = NTMsgMigrationManager.this.isMigrateSucc;
                        if (!z17) {
                            if (TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED")) {
                                NTMsgMigrationManager.this.J0(true);
                                if (NTMsgMigrationManager.this.v0()) {
                                    NTMsgMigrationManager.this.A0(false);
                                    return;
                                }
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    str = peekAppRuntime.getCurrentAccountUin();
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    z18 = NTMsgMigrationManager.this.isInCheckingNetWork;
                                    if (!z18) {
                                        M = NTMsgMigrationManager.this.M(str);
                                        if (!M) {
                                            T = NTMsgMigrationManager.this.T(str);
                                            if (T) {
                                                QLog.i("NTMsgMigration.Manager", 1, "powerStatusListener in charging. auto start new migration");
                                                NTMsgMigrationManager.this.L(str);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                NTMsgMigrationManager.this.J0(false);
                                if (!QBaseActivity.mAppForground && NTMsgMigrationManager.this.v0()) {
                                    NTMsgMigrationManager.this.A0(true);
                                }
                            }
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        try {
            BaseApplication.getContext().registerReceiver(this.powerStatusListener, intentFilter);
        } catch (Exception e16) {
            QLog.e("NTMsgMigration.Manager", 1, "registerReceiver error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(DialogInterface dialogInterface, int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C501", "0X800C501", 2, 0, "", "", "", "");
    }

    private final boolean u0(String uin) {
        boolean decodeBool = Z().decodeBool("nt_msg_migration_is_first_upgrade" + uin, true);
        QLog.d("NTMsgMigration.Manager", 1, "isFirstUpgrade " + decodeBool);
        return decodeBool;
    }

    private final void u1(final String uin, final boolean fromRetry) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qqnt.msg.migration.o
            @Override // java.lang.Runnable
            public final void run() {
                NTMsgMigrationManager.w1(NTMsgMigrationManager.this, uin, fromRetry);
            }
        });
    }

    static /* synthetic */ void v1(NTMsgMigrationManager nTMsgMigrationManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        nTMsgMigrationManager.u1(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(NTMsgMigrationManager this$0, String uin, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        this$0.x1(uin, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x0(String uin) {
        if (this.userType != 3 && u0(uin)) {
            return false;
        }
        return true;
    }

    private final void x1(String uin, boolean fromRetry) {
        QLog.d("NTMsgMigration.Manager", 1, "startMigration uin=" + uin + ", isInMigrating=" + this.isInMigrating + ", fromRetry=" + fromRetry);
        if (!this.isInit) {
            QLog.d("NTMsgMigration.Manager", 1, "startMigration not init");
        }
        if (!fromRetry && this.isInMigrating) {
            return;
        }
        V0();
        W0();
        this.isInCheckingNetWork = false;
        this.curUin = uin;
        this.isInMigrating = true;
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$startMigrationInSubThread$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    NTMsgMigrationManager.this.Q0();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        J0(Y());
        if (Z().decodeLong("key_nt_msg_migration_first_retry_time" + uin, 0L) == 0) {
            QLog.d("NTMsgMigration.Manager", 1, "startMigration record migration first time=" + System.currentTimeMillis());
            Z().encodeLong("key_nt_msg_migration_first_retry_time" + uin, System.currentTimeMillis());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.msg.migration.m
            @Override // java.lang.Runnable
            public final void run() {
                NTMsgMigrationManager.y1(NTMsgMigrationManager.this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(final String curUin, final int userType) {
        this.isInCheckingNetWork = true;
        if (AppNetConnInfo.isNetSupport()) {
            QLog.d("NTMsgMigration.Manager", 1, "judgeHasNetwork network connect, retry");
            this.isInCheckingNetWork = false;
            a1(this, curUin, userType, false, 4, null);
        } else {
            QLog.d("NTMsgMigration.Manager", 1, "judgeHasNetwork network not connect, delay try");
            V0();
            this.delayRetryImportJob = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.msg.migration.f
                @Override // java.lang.Runnable
                public final void run() {
                    NTMsgMigrationManager.z0(NTMsgMigrationManager.this, curUin, userType);
                }
            }, 16, null, true, 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(NTMsgMigrationManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.importOldDbMsg(new IOperateCallback() { // from class: com.tencent.qqnt.msg.migration.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTMsgMigrationManager.z1(i3, str);
                }
            });
        }
        if (!QBaseActivity.mAppForground) {
            QLog.d("NTMsgMigration.Manager", 1, "startMigration in background");
            if (this$0.delayStopImportJob == null) {
                if (!this$0.C0() || !this$0.Y()) {
                    QLog.d("NTMsgMigration.Manager", 1, "startMigration start delay stop job");
                    this$0.A0(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(NTMsgMigrationManager this$0, String curUin, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(curUin, "$curUin");
        QLog.d("NTMsgMigration.Manager", 1, "judgeHasNetwork executeDelay rejudge");
        this$0.y0(curUin, i3);
        this$0.delayRetryImportJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(int i3, String str) {
        QLog.d("NTMsgMigration.Manager", 1, "startMigration importOldDbMsg result=" + i3 + " errmsg=" + str);
    }

    public final void A1() {
        String currentUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("NTMsgMigration.Manager", 1, "triggerMigrationFromHistoryTip:: isInMigrating: " + this.isInMigrating + ", isMigrateSucc: " + this.isMigrateSucc + ", lastTriggerMills: " + this.lastTriggerMills + ", curTriggerMills: " + currentTimeMillis + " timeInterval: " + Math.abs(currentTimeMillis - this.lastTriggerMills));
        if (Math.abs(currentTimeMillis - this.lastTriggerMills) < 500) {
            return;
        }
        this.lastTriggerMills = currentTimeMillis;
        if (this.isMigrateSucc) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.msg.migration.i
                @Override // java.lang.Runnable
                public final void run() {
                    NTMsgMigrationManager.B1();
                }
            });
            return;
        }
        if (this.isInMigrating) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.msg.migration.j
                @Override // java.lang.Runnable
                public final void run() {
                    NTMsgMigrationManager.C1();
                }
            });
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (currentUin = peekAppRuntime.getCurrentUin()) != null) {
            H0(this, currentUin, false, false, 6, null);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.msg.migration.k
                @Override // java.lang.Runnable
                public final void run() {
                    NTMsgMigrationManager.D1();
                }
            });
        }
    }

    public final boolean D0() {
        IFeatureRuntimeService iFeatureRuntimeService;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, String> map = null;
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            map = iFeatureRuntimeService.isEnabledWithDataSet("android_nt_migration", "");
        }
        QLog.i("NTMsgMigration.Manager", 1, "needShowBackMigrateItem " + map);
        if (map != null && (!map.isEmpty())) {
            String str = map.get("backMigrateShow");
            if (str != null) {
                z17 = Boolean.parseBoolean(str);
            } else {
                z17 = false;
            }
            String str2 = map.get("backMigrateEnable");
            if (str2 != null) {
                z16 = Boolean.parseBoolean(str2);
            } else {
                z16 = false;
            }
        } else {
            z16 = false;
            z17 = false;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    public final boolean F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        QLog.i("NTMsgMigration.Manager", 1, "needShowTip: " + this.needShowTipInSearch);
        return this.needShowTipInSearch;
    }

    public final void F1(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) uin);
        } else {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.updateBanner = x0(uin);
        }
    }

    public final void G0(@NotNull final String uin, final boolean isFirstUpgrade, final boolean fromClickTipBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, uin, Boolean.valueOf(isFirstUpgrade), Boolean.valueOf(fromClickTipBar));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("NTMsgMigration.Manager", 1, "newMigration " + uin + " " + isFirstUpgrade);
        if (uin.length() == 0) {
            z16 = true;
        }
        if (z16) {
            if (fromClickTipBar) {
                K0();
                return;
            }
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qqnt.msg.migration.l
            @Override // java.lang.Runnable
            public final void run() {
                NTMsgMigrationManager.I0(NTMsgMigrationManager.this, fromClickTipBar, isFirstUpgrade, uin);
            }
        });
    }

    public final void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.kernelMsgImportToolListener != null) {
            return;
        }
        this.kernelMsgImportToolListener = new c();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            IKernelMsgImportToolListener iKernelMsgImportToolListener = this.kernelMsgImportToolListener;
            Intrinsics.checkNotNull(iKernelMsgImportToolListener, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.IKernelMsgImportToolListener");
            e16.B(iKernelMsgImportToolListener);
        }
    }

    public final void K(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.listeners.contains(listener)) {
            QLog.d("NTMsgMigration.Manager", 1, "addListener " + listener);
            this.listeners.add(listener);
        }
    }

    public final void L0(@NotNull com.tencent.mobileqq.activity.home.parts.a tipData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) tipData);
            return;
        }
        Intrinsics.checkNotNullParameter(tipData, "tipData");
        QLog.d("NTMsgMigration.Manager", 1, "onClickCloseTip " + tipData);
        int i3 = b.f359677a[tipData.b().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    String it = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    g1(it, true);
                    return;
                }
                return;
            }
            String it5 = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            f1(it5, true);
            return;
        }
        INSTANCE.a().updateBanner = false;
    }

    public final void M0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, "onLogout");
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.qqnt.msg.migration.NTMsgMigrationManager$onLogout$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTMsgMigrationManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                list = NTMsgMigrationManager.this.listeners;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).c();
                }
            }
        });
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qqnt.msg.migration.n
            @Override // java.lang.Runnable
            public final void run() {
                NTMsgMigrationManager.N0(NTMsgMigrationManager.this);
            }
        });
    }

    public final void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qqnt.msg.migration.q
                @Override // java.lang.Runnable
                public final void run() {
                    NTMsgMigrationManager.O(NTMsgMigrationManager.this);
                }
            });
        }
    }

    public final void P() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, "checkMsgMigrationPromptInSubThread");
        if (!this.isInit) {
            s0();
        }
        if (this.isInMigrating) {
            QLog.i("NTMsgMigration.Manager", 1, "checkMsgMigrationPrompt repeated");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        this.curUin = str;
        q0(str);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.canImportOldDbMsg(new ICanImportCallback() { // from class: com.tencent.qqnt.msg.migration.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
                public final void onResult(int i3, String str2, int i16) {
                    NTMsgMigrationManager.Q(NTMsgMigrationManager.this, i3, str2, i16);
                }
            });
        }
    }

    public final void S() {
        w e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, QCircleLpReportDc05507.KEY_CLEAR);
        r.f359707a.a();
        this.isInMigrating = false;
        IKernelMsgListener iKernelMsgListener = this.kernelListener;
        if (iKernelMsgListener != null && (e16 = com.tencent.qqnt.msg.f.e()) != null) {
            e16.removeMsgListener(iKernelMsgListener);
        }
        BroadcastReceiver broadcastReceiver = this.powerStatusListener;
        if (broadcastReceiver != null) {
            try {
                BaseApplication.getContext().unregisterReceiver(broadcastReceiver);
            } catch (Exception e17) {
                QLog.e("NTMsgMigration.Manager", 1, "clear unregisterReceiver error", e17);
            }
        }
        this.powerStatusListener = null;
        W0();
        V0();
        this.userType = 0;
        this.needShowTipInSearch = false;
        this.progress = 0.0f;
        this.curUin = "";
        this.isInit = false;
        this.kernelListener = null;
        this.kernelMsgImportToolListener = null;
        this.updateBanner = false;
        this.needContinueMigration = false;
        this.isMigrateSucc = false;
        this.mLastSetPowerStatus = false;
        this.isInCheckingNetWork = false;
        this.curShowTipType = null;
    }

    public final void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        QLog.i("NTMsgMigration.Manager", 1, "process to back isInMigrating: " + this.isInMigrating + ", isMigrateSucc:" + this.isMigrateSucc + " ");
        if (this.isInit && !this.isMigrateSucc && this.isInMigrating) {
            if (!C0() || !Y()) {
                A0(true);
            }
        }
    }

    public final void T0() {
        AppRuntime peekAppRuntime;
        String currentAccountUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, "onRunningForeground needContineMigration: " + this.needContinueMigration + " isMigrateSucc:" + this.isMigrateSucc + " isInMigrating:" + this.isInMigrating);
        if (this.isInit && !this.isMigrateSucc) {
            A0(false);
            if (this.needContinueMigration && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (currentAccountUin = peekAppRuntime.getCurrentAccountUin()) != null) {
                v1(this, currentAccountUin, false, 2, null);
            }
        }
    }

    public final boolean U(@NotNull String uin) {
        IFeatureRuntimeService iFeatureRuntimeService;
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, String> map = null;
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService != null) {
            map = iFeatureRuntimeService.isEnabledWithDataSet("android_nt_migration", "");
        }
        QLog.i("NTMsgMigration.Manager", 1, "enableBackMigration " + map);
        if (map != null && (!map.isEmpty()) && (str = map.get("backMigrateEnable")) != null) {
            z16 = Boolean.parseBoolean(str);
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("NTMsgMigration.Manager", 1, "enableBackMigration disable");
            return false;
        }
        return Z().decodeBool("key_nt_msg_migration_back_migration" + uin, false);
    }

    public final void U0(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "rebootRetryAutoMigrate");
        this.curShowTipType = null;
        Z().encodeLong("key_nt_msg_migration_first_retry_time" + uin, 0L);
        Z().encodeInt("nt_msg_migration_retry_count" + uin, 0);
        Z().encodeInt("nt_msg_migration_all_retry_count" + uin, 0);
        h1(uin, false);
        i1(uin, false);
        j1(uin, false);
        k1(uin, false);
        f1(uin, false);
        g1(uin, false);
        l1(uin, false);
    }

    @Nullable
    public final MigrationTipType W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (MigrationTipType) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.curShowTipType;
    }

    public final void X0(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("NTMsgMigration.Manager", 1, "removeListener " + listener);
        this.listeners.remove(listener);
    }

    public final void Y0(@NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) tag);
        } else {
            Intrinsics.checkNotNullParameter(tag, "tag");
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", tag, tag, this.userType, 0, "", "", "", "");
        }
    }

    public final float b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.progress;
    }

    public final void b1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            QLog.d("NTMsgMigration.Manager", 1, "retryMigrationFromFailDialog");
            H0(this, this.curUin, false, false, 6, null);
        }
    }

    @NotNull
    public final String c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (String) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return d0(this.progress);
    }

    public final void c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            QLog.d("NTMsgMigration.Manager", 1, "retryMigrationFromTipBar");
            H0(this, this.curUin, false, true, 2, null);
        }
    }

    @NotNull
    public final String d0(float progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, this, Float.valueOf(progress));
        }
        if (this.userType == 3) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(" %.2f%%", Arrays.copyOf(new Object[]{Float.valueOf(progress)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(" %.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(progress)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    public final void d1(@NotNull String uin, boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, uin, Boolean.valueOf(enable));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setEnableAutoMigrationInCharging " + enable);
        Z().encodeBool("key_nt_msg_migration_auto_migration_in_charge" + uin, enable);
    }

    @NotNull
    public final SpannableString e0(@Nullable Context context, @Nullable final View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (SpannableString) iPatchRedirector.redirect((short) 45, (Object) this, (Object) context, (Object) onClickListener);
        }
        if (context == null) {
            QLog.e("NTMsgMigration.Manager", 1, "getTipSpannableString, but context is null.");
            return new SpannableString("");
        }
        String string = context.getResources().getString(R.string.f171902p0);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026sg_migration_content_tip)");
        String string2 = context.getResources().getString(R.string.f172002p_);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026t_msg_migration_jump_tip)");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(string2, new View.OnClickListener() { // from class: com.tencent.qqnt.msg.migration.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NTMsgMigrationManager.f0(NTMsgMigrationManager.this, onClickListener, view);
            }
        }, true));
        SpannableString buildSpannable = RichTextHelper.buildSpannable(string, context, false, arrayList);
        Intrinsics.checkNotNullExpressionValue(buildSpannable, "buildSpannable(contentSt\u2026 false, richTextDataList)");
        return buildSpannable;
    }

    public final void e1(@NotNull String uin, boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, uin, Boolean.valueOf(enable));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setEnableBackMigration " + enable);
        Z().encodeBool("key_nt_msg_migration_back_migration" + uin, enable);
        if (this.isInMigrating) {
            if (enable) {
                J0(true);
            } else {
                J0(Y());
            }
        }
    }

    public final void f1(@NotNull String uin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, uin, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setHasCloseFailTipBar " + value);
        Z().encodeBool("nt_msg_migration_has_close_fail_tipbar" + uin, value);
    }

    public final boolean g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.updateBanner;
    }

    public final void g1(@NotNull String uin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, uin, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setHasCloseLowMemTipBar " + value);
        Z().encodeBool("nt_msg_migration_has_close_low_mem_tipbar" + uin, value);
    }

    public final int h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.userType;
    }

    public final void i0(@NotNull Context context, @Nullable AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) context, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("NTMsgMigration.Manager", 1, "gotoClear");
        if (app == null) {
            QLog.e("NTMsgMigration.Manager", 1, "gotoClear app is null");
            return;
        }
        m1(this.curUin, false);
        U0(this.curUin);
        GeneralSettingActivity.x3(context, app);
    }

    public final void j0(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("NTMsgMigration.Manager", 1, "gotoDetailPage");
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.lastGotoDetailPageTime) < 1000) {
            return;
        }
        this.lastGotoDetailPageTime = currentTimeMillis;
        Intent intent = new Intent();
        intent.putExtra("url", "https://ti.qq.com/nt-migration/android.html?userType=" + this.userType);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("migration_user_type", this.userType);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public final void k0(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "handleLowMemInHistorySetting");
        p1(uin);
        E1(uin);
        G1(uin);
    }

    public final void l1(@NotNull String uin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, uin, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setHasShowLowMemTipBar " + value);
        Z().encodeBool("nt_msg_migration_has_show_low_mem_tipbar" + uin, value);
    }

    public final void m1(@NotNull String uin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, uin, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setIsFirstUpgrade " + value);
        Z().encodeBool("nt_msg_migration_is_first_upgrade" + uin, value);
    }

    public final void n1(@NotNull String uin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, uin, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("NTMsgMigration.Manager", 1, "setNeedShowSpeedUp " + value);
        Z().encodeBool("nt_msg_migration_need_show_speedup" + uin, value);
    }

    public final void o1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.userType = i3;
        }
    }

    public final void q1(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("NTMsgMigration.Manager", 1, "showLowMemToast " + this.userType);
        QQToast.makeText(context, 1, R.string.f171982p8, 0).show();
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C4D7", "0X800C4D7", INSTANCE.a().userType, 0, "", "", "", "");
    }

    public final void s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, "initListener");
        if (this.isInit) {
            QLog.d("NTMsgMigration.Manager", 1, "initListener has init");
            return;
        }
        this.isInit = true;
        r0();
        t0();
    }

    public final boolean v0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isInMigrating;
    }

    public final boolean w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isInit;
    }

    NTMsgMigrationManager() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.curUin = "";
        this.useSpeedTipBar = true;
        this.listeners = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(NTMsgMigrationManager$mmkv$2.INSTANCE);
        this.mmkv = lazy;
    }
}

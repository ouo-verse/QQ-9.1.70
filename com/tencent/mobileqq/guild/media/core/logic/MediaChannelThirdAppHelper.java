package com.tencent.mobileqq.guild.media.core.logic;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.guild.media.core.MediaBusinessType;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.PreloadFrom;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AppAuthResult;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AppInfo;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.EntryType;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenJsMethodProvider;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.OpenPluginRuntime;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d;
import com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebJsReportTask;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.dz;
import com.tencent.mobileqq.qqguildsdk.data.es;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateLobbyRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEncryptTextRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppAuthStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAReportExecuteRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cv;
import com.tencent.mobileqq.qqguildsdk.data.genc.df;
import com.tencent.mobileqq.qqguildsdk.data.genc.dq;
import com.tencent.mobileqq.qqguildsdk.data.genc.dr;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.a;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wh2.dp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\f\u00bc\u0001\u00c0\u0001\u00c4\u0001\u00c8\u0001\u00cb\u0001\u00ce\u0001\u0018\u0000 \u00d8\u00012\u00020\u0001:\u0002\u00d9\u0001B\u0013\u0012\b\u0010\u0092\u0001\u001a\u00030\u008f\u0001\u00a2\u0006\u0006\b\u00d6\u0001\u0010\u00d7\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJp\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112`\u0010\u001b\u001a\\\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00020\u0013Jr\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00112b\u0010\u001b\u001a^\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013J\b\u0010\"\u001a\u0004\u0018\u00010!J\b\u0010$\u001a\u0004\u0018\u00010#J\b\u0010&\u001a\u0004\u0018\u00010%J\u0006\u0010'\u001a\u00020\u0011J)\u0010*\u001a\u00020\u00022!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00020(J\u0006\u0010+\u001a\u00020\u0011J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010-J\u0006\u00100\u001a\u00020\u0002J\u0006\u00101\u001a\u00020\u0011J\u0006\u00102\u001a\u00020\u0011J\u0016\u00106\u001a\u00020\u00022\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203J\u0006\u00107\u001a\u00020\u0002J\u001c\u0010:\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u0001082\b\b\u0002\u00109\u001a\u00020\tJ\u0006\u0010;\u001a\u00020\tJ\b\u0010<\u001a\u00020\u0002H\u0002J\b\u0010=\u001a\u00020\u0002H\u0002J\b\u0010>\u001a\u00020\u0002H\u0002J\b\u0010?\u001a\u00020\u0002H\u0002J\b\u0010@\u001a\u00020\u0002H\u0002J\u0010\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020AH\u0002J\u001c\u0010F\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010%2\b\u0010E\u001a\u0004\u0018\u00010#H\u0002J\b\u0010G\u001a\u00020\u0002H\u0002J\u0010\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u00020HH\u0002J\b\u0010K\u001a\u00020\u0002H\u0002J\b\u0010L\u001a\u00020\u0002H\u0002J/\u0010P\u001a\u00020O2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010M\u001a\u00020\u00142\b\b\u0002\u0010N\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010QJ\u0013\u0010R\u001a\u00020OH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010SJ\u0018\u0010T\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010.\u001a\u00020-H\u0002J$\u0010X\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\u0010W\u001a\u0004\u0018\u00010VH\u0002J\u008a\u0001\u0010[\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020Y2`\u0010\u001b\u001a\\\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00020\u0013H\u0002J \u0010]\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020VH\u0002J\u0018\u0010^\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0010\u0010`\u001a\u00020\u00022\u0006\u0010_\u001a\u00020\u0014H\u0002J\u0010\u0010a\u001a\u00020\u00022\u0006\u0010B\u001a\u00020AH\u0002J\u0010\u0010c\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\tH\u0002J(\u0010g\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u00112\u0006\u0010e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010f\u001a\u000203H\u0002J\u0010\u0010j\u001a\u00020\u00022\u0006\u0010i\u001a\u00020hH\u0002J\u0010\u0010k\u001a\u00020\u00022\u0006\u0010i\u001a\u00020hH\u0002J\u0018\u0010l\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010.\u001a\u00020-H\u0002J\u0010\u0010n\u001a\u0002032\u0006\u0010m\u001a\u00020\u0011H\u0002J\b\u0010o\u001a\u00020\tH\u0002J\u001c\u0010p\u001a\u00020\t2\b\u0010d\u001a\u0004\u0018\u00010\u00112\b\u0010e\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010q\u001a\u00020\u0002H\u0002J\u0010\u0010s\u001a\u00020!2\u0006\u0010E\u001a\u00020rH\u0002J\u001c\u0010v\u001a\u00020\t2\b\u0010t\u001a\u0004\u0018\u00010#2\b\u0010u\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010w\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010y\u001a\u00020\u00112\b\u0010x\u001a\u0004\u0018\u00010%H\u0002J\b\u0010z\u001a\u00020\u0002H\u0002J\b\u0010{\u001a\u00020\u0002H\u0002J@\u0010\u0081\u0001\u001a\u00020\u00022\u0006\u0010|\u001a\u00020\u00112\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020~0}2\b\b\u0002\u00109\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u0001082\t\b\u0002\u0010\u0080\u0001\u001a\u00020\tH\u0002J4\u0010\u0084\u0001\u001a\u0013\u0012\u0004\u0012\u00020~0}j\t\u0012\u0004\u0012\u00020~`\u0082\u00012\u0018\u0010\u0083\u0001\u001a\u0013\u0012\u0004\u0012\u00020~0}j\t\u0012\u0004\u0012\u00020~`\u0082\u0001H\u0002J\t\u0010\u0085\u0001\u001a\u00020\tH\u0002J6\u0010\u0086\u0001\u001a\u00020\u00022\u0006\u0010|\u001a\u00020\u00112\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020~0}2\b\b\u0002\u00109\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u000108H\u0002J+\u0010\u0088\u0001\u001a\u00020\u00022\u0006\u0010|\u001a\u00020\u00112\u0018\u0010\u0087\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u00110}j\t\u0012\u0004\u0012\u00020\u0011`\u0082\u0001H\u0002J%\u0010\u008b\u0001\u001a\u00020\u00022\u0007\u0010\u0089\u0001\u001a\u00020~2\u0007\u0010\u008a\u0001\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0002J\u001c\u0010\u008c\u0001\u001a\u00020\u00022\u0007\u0010\u0089\u0001\u001a\u00020~2\b\b\u0002\u00109\u001a\u00020\tH\u0002J\u001c\u0010\u008e\u0001\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00142\t\b\u0002\u0010\u008d\u0001\u001a\u00020\tH\u0002R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u00a1\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u0019\u0010\u00a3\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a0\u0001R\u0019\u0010\u00a5\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a0\u0001R\u001c\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0019\u0010\u00ab\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u009d\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u009d\u0001RY\u0010\u00b1\u0001\u001aB\u0012\u0004\u0012\u00020\u0011\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020~0}j\t\u0012\u0004\u0012\u00020~`\u0082\u00010\u00ae\u0001j \u0012\u0004\u0012\u00020\u0011\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020~0}j\t\u0012\u0004\u0012\u00020~`\u0082\u0001`\u00af\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00b0\u0001R\u001c\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001b\u0010\u00b8\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001b\u0010\u00bb\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0018\u0010\u00bf\u0001\u001a\u00030\u00bc\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u0018\u0010\u00c3\u0001\u001a\u00030\u00c0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u0018\u0010\u00c7\u0001\u001a\u00030\u00c4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001R\u0017\u0010\u00ca\u0001\u001a\u00030\u00c8\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0003\u0010\u00c9\u0001R\u0017\u0010\u00cd\u0001\u001a\u00030\u00cb\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0004\u0010\u00cc\u0001R\u0018\u0010\u00d1\u0001\u001a\u00030\u00ce\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cf\u0001\u0010\u00d0\u0001R\u0018\u0010\u00d5\u0001\u001a\u00030\u00d2\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00da\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper;", "Lcom/tencent/mobileqq/guild/media/core/d;", "", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "f2", "H2", "E0", "u", "", "v1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebJsReportTask;", "w1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/a;", "B1", ICustomDataEditor.NUMBER_PARAM_1, "m1", "", "appId", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "isAuth", "authCode", "callback", ICustomDataEditor.NUMBER_PARAM_2, "inputText", "isPass", "encryptedText", ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "C1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "A1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;", "u1", "E1", "Lkotlin/Function1;", "openId", "x1", Constants.BASE_IN_PLUGIN_ID, QzoneIPCModule.RESULT_CODE, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;", "appAuthResult", "W1", "o1", "z1", "y1", "", "webViewLoadTime", "h5LoadingTime", "l2", "j1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/a;", "isFromMiniApp", "f1", "i1", "N1", "O1", "V1", "e2", "P1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "bizNode", NowProxyConstants.AccountInfoKey.A2, "lobbyStateInfo", "appInfo", Constants.BASE_IN_PLUGIN_VERSION, "y2", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyRoomInfo;", "lobbyInfo", "B2", "q1", "C2", "appCapacity", "type", "Lcom/tencent/mobileqq/guild/media/core/a;", "u2", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w2", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreateLobbyRsp;", "switchLobbyRsp", "M1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppAuthStatusRsp;", "lobbyAppAuthStatusRsp", "F1", "createLobbyRsp", "L1", Constants.APK_CERTIFICATE, "updateTheme", "J1", "I1", "enableMic", "T1", "guildId", "channelId", "lobbyId", "t1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "K1", "H1", Constants.MMCCID, "source", "d1", "l1", "e1", "U1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/b;", "p1", "tempThirdAppInfo", "tempLobbyRoomInfo", "k1", "S1", "roomInfo", "R1", "F2", "m2", "instrTraceId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPAInstructionInfo;", "instructionList", "isClosedMask", "p2", "Lkotlin/collections/ArrayList;", "instructions", "g2", "Q1", "r1", "ruleNameList", "j2", "instruction", "needExitChannel", "b2", "X1", "isClick", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/guild/media/core/f;", "f", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", tl.h.F, "Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "appPreloadInfo", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "thirdAppInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;", "lobbyRoomInfo", BdhLogUtil.LogTag.Tag_Conn, "Z", "thirdAppTalkPermission", "D", "J", "thirdAppStartTime", "E", "thirdAppStartRequestBeginTime", UserInfo.SEX_FEMALE, "thirdAppStartRequestUseTime", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "G", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "H", "isPreventAddictionLimit", "I", "hasOpenedMask", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "instructionsCache", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/k;", "K", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/k;", "webJSHandler", "L", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebJsReportTask;", "webJsReportTask", "M", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/a;", "thirdAppLoadReportTask", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$f", "N", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$f;", "observer", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$e", "P", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$e;", "multiGroupCanTalkUpdateEvent", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$b;", "bizNodeUpdateObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$j", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$j;", "switchThemeObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$k", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$k;", "webViewStatusListener", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$d", "T", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$d;", "maskViewTouchListener", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "O", "()Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "businessType", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelThirdAppHelper extends com.tencent.mobileqq.guild.media.core.d {

    @NotNull
    private static final List<Integer> V;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean thirdAppTalkPermission;

    /* renamed from: D, reason: from kotlin metadata */
    private long thirdAppStartTime;

    /* renamed from: E, reason: from kotlin metadata */
    private long thirdAppStartRequestBeginTime;

    /* renamed from: F, reason: from kotlin metadata */
    private long thirdAppStartRequestUseTime;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog dialog;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPreventAddictionLimit;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hasOpenedMask;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, ArrayList<IGProPAInstructionInfo>> instructionsCache;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.container.webview.k webJSHandler;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private GuildMediaWebJsReportTask webJsReportTask;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final f observer;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e multiGroupCanTalkUpdateEvent;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final b bizNodeUpdateObserver;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final j switchThemeObserver;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final k webViewStatusListener;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final d maskViewTouchListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.e appPreloadInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProLobbyAppInfo thirdAppInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProLobbyStateInfo lobbyRoomInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/e;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.e> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.e event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getBizNode().getNodeType() == 6) {
                boolean a16 = com.tencent.mobileqq.guild.media.core.m.a(MediaChannelThirdAppHelper.this.mediaChannelCore.v0());
                MediaChannelThirdAppHelper.this.I1(event.getBizNode());
                boolean a17 = com.tencent.mobileqq.guild.media.core.m.a(MediaChannelThirdAppHelper.this.mediaChannelCore.v0());
                if (a16 != a17) {
                    MediaChannelThirdAppHelper.this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.au());
                }
                Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[onPushLobbyAppInfoChange] disableVoiceAnimation " + a17);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d
        @NotNull
        public EntryType a() {
            return d.a.a(this);
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d
        public void b(@NotNull ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[sendMediaWebEvent] intent " + intent);
            MediaChannelThirdAppHelper.this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.aa(intent));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/az;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.az> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.az event) {
            Object first;
            Object first2;
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[onEventReceive] ThirdAppMaskViewTouchEvent");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
            }
            if (!MediaChannelThirdAppHelper.this.instructionsCache.isEmpty()) {
                Set entrySet = MediaChannelThirdAppHelper.this.instructionsCache.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "instructionsCache.entries");
                first = CollectionsKt___CollectionsKt.first(entrySet);
                Object key = ((Map.Entry) first).getKey();
                Intrinsics.checkNotNullExpressionValue(key, "instructionsCache.entries.first().key");
                String str = (String) key;
                Set entrySet2 = MediaChannelThirdAppHelper.this.instructionsCache.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet2, "instructionsCache.entries");
                first2 = CollectionsKt___CollectionsKt.first(entrySet2);
                Object value = ((Map.Entry) first2).getValue();
                Intrinsics.checkNotNullExpressionValue(value, "instructionsCache.entries.first().value");
                MediaChannelThirdAppHelper.s1(MediaChannelThirdAppHelper.this, str, (ArrayList) value, false, null, 12, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ae;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.ae> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.ae event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!MediaChannelThirdAppHelper.this.Q()) {
                return;
            }
            Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[MultiGroupCanTalkEvent.onEventReceive] isOpenMic " + event.getCanTalk());
            MediaChannelThirdAppHelper.this.T1(event.getCanTalk());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014JF\u0010\u0016\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "onPushAVUserStateChange", AppConstants.Key.COLUMN_MSG_DATA, "onPushAVChannelAppMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/dz;", "info", "doOnPushPreventAddictionInstructions", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "playerList", "viewerList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "onAVUserInfoChangeNotifyForAll", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f extends GPServiceObserver {
        f() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void doOnPushPreventAddictionInstructions(@Nullable dz info) {
            Long l3;
            Integer num;
            ArrayList<IGProPAInstructionInfo> instructions;
            Long l16 = null;
            if (info != null) {
                l3 = Long.valueOf(info.getUin());
            } else {
                l3 = null;
            }
            if (info != null && (instructions = info.getInstructions()) != null) {
                num = Integer.valueOf(instructions.size());
            } else {
                num = null;
            }
            if (info != null) {
                l16 = Long.valueOf(info.a());
            }
            QLog.i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "doOnPushPreventAddictionInstructions, uin: " + l3 + ",instructions: " + num + ", closeMask: " + l16);
            if (info == null) {
                return;
            }
            if (info.a() == 1) {
                MediaChannelThirdAppHelper.this.hasOpenedMask = false;
                com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.as(false));
                MediaChannelThirdAppHelper mediaChannelThirdAppHelper = MediaChannelThirdAppHelper.this;
                mediaChannelThirdAppHelper.D2(mediaChannelThirdAppHelper.lobbyRoomInfo, MediaChannelThirdAppHelper.this.thirdAppInfo);
                MediaChannelThirdAppHelper mediaChannelThirdAppHelper2 = MediaChannelThirdAppHelper.this;
                String instrTraceId = info.getInstrTraceId();
                Intrinsics.checkNotNullExpressionValue(instrTraceId, "info.instrTraceId");
                ArrayList<IGProPAInstructionInfo> instructions2 = info.getInstructions();
                Intrinsics.checkNotNullExpressionValue(instructions2, "info.instructions");
                MediaChannelThirdAppHelper.q2(mediaChannelThirdAppHelper2, instrTraceId, instructions2, true, null, false, 24, null);
                return;
            }
            MediaChannelThirdAppHelper mediaChannelThirdAppHelper3 = MediaChannelThirdAppHelper.this;
            String instrTraceId2 = info.getInstrTraceId();
            Intrinsics.checkNotNullExpressionValue(instrTraceId2, "info.instrTraceId");
            ArrayList<IGProPAInstructionInfo> instructions3 = info.getInstructions();
            Intrinsics.checkNotNullExpressionValue(instructions3, "info.instructions");
            MediaChannelThirdAppHelper.q2(mediaChannelThirdAppHelper3, instrTraceId2, instructions3, false, null, false, 28, null);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAVUserInfoChangeNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> playerList, @Nullable ArrayList<IGProUserInfo> viewerList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onAVUserInfoChangeNotifyForAll");
            MediaChannelThirdAppHelper mediaChannelThirdAppHelper = MediaChannelThirdAppHelper.this;
            mediaChannelThirdAppHelper.D2(mediaChannelThirdAppHelper.lobbyRoomInfo, MediaChannelThirdAppHelper.this.thirdAppInfo);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (!TextUtils.equals(MediaChannelThirdAppHelper.this.mediaChannelCore.E(), channelUin) || !MediaChannelThirdAppHelper.this.Q()) {
                return;
            }
            Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onChannelInfoUpdated: channelId[" + channelUin + "]");
            MediaChannelThirdAppHelper.this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ax());
            GuildMediaUtils.k(MediaChannelThirdAppHelper.this.mediaChannelCore.getGuildID(), MediaChannelThirdAppHelper.this.mediaChannelCore.E());
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushAVChannelAppMsg(@Nullable String msgData) {
            if (TextUtils.isEmpty(msgData)) {
                return;
            }
            Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onPushAVChannelAppMsg: msgData[" + msgData + "]");
            ((IMsgService) QRoute.api(IMsgService.class)).addLocalGrayTipMsg(new Contact(4, MediaChannelThirdAppHelper.this.mediaChannelCore.E(), MediaChannelThirdAppHelper.this.mediaChannelCore.getGuildID()), new LocalGrayTipElement(5, null, null, msgData), true, null);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushAVUserStateChange(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
            String str;
            String str2;
            Long l3;
            Integer num;
            es userCtlInfo;
            es userCtlInfo2;
            String str3 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
            MediaChannelThirdAppHelper mediaChannelThirdAppHelper = MediaChannelThirdAppHelper.this;
            Integer num2 = null;
            if (userStateInfo != null) {
                str = userStateInfo.getGuildId();
            } else {
                str = null;
            }
            String valueOf = String.valueOf(str);
            if (userStateInfo != null) {
                str2 = userStateInfo.getChannelId();
            } else {
                str2 = null;
            }
            if (!mediaChannelThirdAppHelper.e1(valueOf, String.valueOf(str2))) {
                return;
            }
            if (userStateInfo != null) {
                l3 = Long.valueOf(userStateInfo.getTinyId());
            } else {
                l3 = null;
            }
            if (!TextUtils.equals(String.valueOf(l3), str3) || !MediaChannelThirdAppHelper.this.Q()) {
                return;
            }
            Logger.a d16 = Logger.f235387a.d();
            if (userStateInfo != null && (userCtlInfo2 = userStateInfo.getUserCtlInfo()) != null) {
                num = Integer.valueOf(userCtlInfo2.b());
            } else {
                num = null;
            }
            d16.i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onPushAVUserStateChange: state[" + num + "]");
            if (userStateInfo != null && (userCtlInfo = userStateInfo.getUserCtlInfo()) != null) {
                num2 = Integer.valueOf(userCtlInfo.b());
            }
            if (num2 != null && num2.intValue() == 7) {
                MediaChannelThirdAppHelper.this.K1(userStateInfo);
            } else if (num2 != null && num2.intValue() == 5) {
                MediaChannelThirdAppHelper.this.H1(userStateInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$g", "Lcom/tencent/mobileqq/guild/media/core/b;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.b {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.b
        public void a(boolean isSuccess, @Nullable IGProSecurityResult securityResult) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[reEnterTRTC] result " + isSuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onDeleteLobby"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class h implements wh2.u {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<CommonRsp> f228261b;

        /* JADX WARN: Multi-variable type inference failed */
        h(Continuation<? super CommonRsp> continuation) {
            this.f228261b = continuation;
        }

        @Override // wh2.u
        public final void onDeleteLobby(int i3, String errMsg) {
            MediaChannelThirdAppHelper mediaChannelThirdAppHelper = MediaChannelThirdAppHelper.this;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            mediaChannelThirdAppHelper.G1(i3, errMsg);
            Continuation<CommonRsp> continuation = this.f228261b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, errMsg)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreateLobbyRsp;", "createLobbyRsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreateLobbyRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i implements wh2.p {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<CommonRsp> f228263b;

        /* JADX WARN: Multi-variable type inference failed */
        i(Continuation<? super CommonRsp> continuation) {
            this.f228263b = continuation;
        }

        @Override // wh2.p
        public final void a(int i3, String errMsg, IGProCreateLobbyRsp createLobbyRsp) {
            MediaChannelThirdAppHelper mediaChannelThirdAppHelper = MediaChannelThirdAppHelper.this;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Intrinsics.checkNotNullExpressionValue(createLobbyRsp, "createLobbyRsp");
            mediaChannelThirdAppHelper.L1(i3, errMsg, createLobbyRsp);
            Continuation<CommonRsp> continuation = this.f228263b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, errMsg)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$j", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        j() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelThirdAppHelper.this.J1(event.getNewThemeType());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper$k", "Lcom/tencent/mobileqq/remoteweb/a;", "", "durationMs", "", "onServiceDisconnected", "", "webPageId", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "startTime", "onReportTimeCost", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k implements com.tencent.mobileqq.remoteweb.a {
        k() {
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onFailed(@NotNull String str, int i3, @Nullable String str2) {
            a.C8510a.a(this, str, i3, str2);
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onReportTimeCost(@NotNull String webPageId, @NotNull RemoteWebTimeCost type, long startTime) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(type, "type");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, webPageId + " [onReportTimeCost] " + type + ", startTime " + startTime);
            GuildMediaWebJsReportTask guildMediaWebJsReportTask = MediaChannelThirdAppHelper.this.webJsReportTask;
            if (guildMediaWebJsReportTask != null) {
                guildMediaWebJsReportTask.g(type);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onServiceConnected() {
            a.C8510a.c(this);
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onServiceDisconnected(long durationMs) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onServiceDisconnected " + durationMs;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
            }
            GuildMediaWebJsReportTask guildMediaWebJsReportTask = MediaChannelThirdAppHelper.this.webJsReportTask;
            if (guildMediaWebJsReportTask != null) {
                GuildMediaWebJsReportTask.i(guildMediaWebJsReportTask, "media_web_service_disconnection", null, 2, null);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent) {
            a.C8510a.e(this, str, remoteWebViewEvent);
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent, @NotNull Bundle bundle) {
            a.C8510a.f(this, str, remoteWebViewEvent, bundle);
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 7, 3});
        V = listOf;
    }

    public MediaChannelThirdAppHelper(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        this.instructionsCache = new HashMap<>();
        this.observer = new f();
        this.multiGroupCanTalkUpdateEvent = new e();
        this.bizNodeUpdateObserver = new b();
        this.switchThemeObserver = new j();
        this.webViewStatusListener = new k();
        this.maskViewTouchListener = new d();
    }

    private final void A2(IGProBusinessNode bizNode) {
        if (bizNode.getLobbyRoomInfo() != null) {
            if (bizNode.getLobbyRoomInfo().getLobbyAppInfo().getAntiAddiction() == 1) {
                QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "need check anti-addiction");
                g1(this, null, false, 3, null);
            }
            D2(bizNode.getLobbyRoomInfo().getLobbyStateInfo(), bizNode.getLobbyRoomInfo().getLobbyAppInfo());
            IGProLobbyRoomInfo lobbyRoomInfo = bizNode.getLobbyRoomInfo();
            Intrinsics.checkNotNullExpressionValue(lobbyRoomInfo, "bizNode.lobbyRoomInfo");
            B2(lobbyRoomInfo);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "resetMediaThirdAppInfo: error. info is null. appInfo[" + this.thirdAppInfo + "] roomInfo[" + this.lobbyRoomInfo + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
        }
    }

    private final void B2(IGProLobbyRoomInfo lobbyInfo) {
        Boolean bool;
        this.thirdAppInfo = lobbyInfo.getLobbyAppInfo();
        IGProLobbyStateInfo lobbyStateInfo = lobbyInfo.getLobbyStateInfo();
        this.lobbyRoomInfo = lobbyStateInfo;
        Boolean bool2 = null;
        if (this.thirdAppInfo != null && lobbyStateInfo != null) {
            Logger.a d16 = Logger.f235387a.d();
            String S1 = S1(this.thirdAppInfo);
            String R1 = R1(this.lobbyRoomInfo);
            IGProLobbyStateInfo iGProLobbyStateInfo = this.lobbyRoomInfo;
            if (iGProLobbyStateInfo != null) {
                bool2 = Boolean.valueOf(iGProLobbyStateInfo.getDisableVoiceAnimation());
            }
            d16.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "resetMediaThirdAppInfo: update info. appInfo[" + S1 + "] roomInfo[" + R1 + "]disableVoiceAnimation[" + bool2 + "]");
            V1();
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ax());
            e12.a<Boolean> g16 = this.mediaChannelCore.o0().g();
            IGProLobbyStateInfo iGProLobbyStateInfo2 = this.lobbyRoomInfo;
            if (iGProLobbyStateInfo2 != null) {
                bool = Boolean.valueOf(iGProLobbyStateInfo2.getDisableVoiceAnimation());
            } else {
                bool = Boolean.FALSE;
            }
            g16.setValue(bool);
            String appId = lobbyInfo.getLobbyAppInfo().getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "lobbyInfo.lobbyAppInfo.appId");
            com.tencent.mobileqq.guild.util.bw.K1(appId);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "resetMediaThirdAppInfo: error. info is null. appInfo[" + this.thirdAppInfo + "] roomInfo[" + this.lobbyRoomInfo + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
        }
    }

    private final void C2() {
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "resetThirdAppInfo:");
        m2();
        TRTCAudioRoomLocalNew.INSTANCE.a().h();
        y2();
        GuildMediaWebJsReportTask guildMediaWebJsReportTask = this.webJsReportTask;
        if (guildMediaWebJsReportTask != null) {
            guildMediaWebJsReportTask.l();
        }
        com.tencent.mobileqq.guild.media.thirdapp.container.report.a aVar = this.thirdAppLoadReportTask;
        if (aVar != null) {
            aVar.f();
        }
        this.webJsReportTask = null;
        this.appPreloadInfo = null;
        this.thirdAppInfo = null;
        this.lobbyRoomInfo = null;
        this.thirdAppTalkPermission = false;
        this.thirdAppStartTime = 0L;
        this.instructionsCache.clear();
        this.mediaChannelCore.o0().g().setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2(final IGProLobbyStateInfo lobbyStateInfo, final IGProLobbyAppInfo appInfo) {
        if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 6 && lobbyStateInfo != null && appInfo != null) {
            IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.l().getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface().getRuntim\u2026va, ProcessConstant.MAIN)");
            final IGPSService iGPSService = (IGPSService) runtimeService;
            iGPSService.getChannelHeartbeat(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), new vh2.aw() { // from class: com.tencent.mobileqq.guild.media.core.logic.bk
                @Override // vh2.aw
                public final void a(int i3, cv cvVar) {
                    MediaChannelThirdAppHelper.E2(IGProLobbyStateInfo.this, appInfo, this, iGPSService, i3, cvVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(IGProLobbyStateInfo iGProLobbyStateInfo, IGProLobbyAppInfo iGProLobbyAppInfo, MediaChannelThirdAppHelper this$0, IGPSService gpsService, int i3, cv cvVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gpsService, "$gpsService");
        if (i3 != 0) {
            return;
        }
        long lobbyId = iGProLobbyStateInfo.getLobbyId();
        String appId = iGProLobbyAppInfo.getAppId();
        int lobbyRoomStatus = iGProLobbyStateInfo.getLobbyRoomStatus();
        boolean z16 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228100h;
        int antiAddiction = iGProLobbyAppInfo.getAntiAddiction();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("lobby_id", Long.valueOf(lobbyId));
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        linkedHashMap.put("app_id", appId);
        linkedHashMap.put("lobby_status", Integer.valueOf(lobbyRoomStatus));
        linkedHashMap.put("is_playing", Integer.valueOf(z16 ? 1 : 0));
        ArrayList<df> kvInfoList = cvVar.f();
        Intrinsics.checkNotNullExpressionValue(kvInfoList, "kvInfoList");
        Iterator<df> it = kvInfoList.iterator();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().a(), "lobby_info")) {
                    break;
                } else {
                    i17++;
                }
            } else {
                i17 = -1;
                break;
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(linkedHashMap);
        linkedHashMap2.put("is_anti_addiction", Integer.valueOf(antiAddiction));
        if (i17 == -1) {
            df dfVar = new df();
            dfVar.c("lobby_info");
            String jSONObject = new JSONObject(linkedHashMap2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(lobbyParams as Map<*, *>).toString()");
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            dfVar.d(bytes);
            kvInfoList.add(dfVar);
        } else {
            df dfVar2 = kvInfoList.get(i17);
            String jSONObject2 = new JSONObject(linkedHashMap2).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject(lobbyParams as Map<*, *>).toString()");
            byte[] bytes2 = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            dfVar2.d(bytes2);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        if (iGProLobbyAppInfo.getAntiAddiction() == 1) {
            linkedHashMap3.putAll(linkedHashMap);
            linkedHashMap3.put("timestamp", Long.valueOf(NetConnInfoCenter.getServerTime()));
            linkedHashMap3.put("anti_addiction_mode", Integer.valueOf(iGProLobbyAppInfo.getAntiAddictionMode()));
            linkedHashMap3.put("has_opened_mask", Integer.valueOf(this$0.hasOpenedMask ? 1 : 0));
            Iterator<df> it5 = kvInfoList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    if (Intrinsics.areEqual(it5.next().a(), "anti_addiction_info")) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 == -1) {
                df dfVar3 = new df();
                dfVar3.c("anti_addiction_info");
                String jSONObject3 = new JSONObject(linkedHashMap3).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject(antiAddiction\u2026 as Map<*, *>).toString()");
                byte[] bytes3 = jSONObject3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                dfVar3.d(bytes3);
                kvInfoList.add(dfVar3);
            } else {
                df dfVar4 = kvInfoList.get(i16);
                String jSONObject4 = new JSONObject(linkedHashMap3).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject(antiAddiction\u2026 as Map<*, *>).toString()");
                byte[] bytes4 = jSONObject4.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes4, "this as java.lang.String).getBytes(charset)");
                dfVar4.d(bytes4);
            }
        }
        QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "setHeartBeat, channelId: " + com.tencent.mobileqq.guild.media.core.j.a().E() + ", antiAddiction: " + iGProLobbyAppInfo.getAntiAddiction() + ", lobbyParams: " + linkedHashMap2 + ", antiAddictionParams: " + linkedHashMap3);
        cvVar.m(kvInfoList);
        gpsService.setChannelHeartbeat(cvVar);
    }

    private final void F1(String appId, int result, String errMsg, IGProLobbyAppAuthStatusRsp lobbyAppAuthStatusRsp, Function4<? super Integer, ? super String, ? super Boolean, ? super String, Unit> callback) {
        boolean z16 = true;
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleCheckLobbyAppAuthStatus: result[" + result + "] errMsg[" + errMsg + "]");
        if (lobbyAppAuthStatusRsp.getAuthStatus() != 1) {
            z16 = false;
        }
        Integer valueOf = Integer.valueOf(result);
        Boolean valueOf2 = Boolean.valueOf(z16);
        String authCode = lobbyAppAuthStatusRsp.getAuthCode();
        Intrinsics.checkNotNullExpressionValue(authCode, "lobbyAppAuthStatusRsp.authCode");
        callback.invoke(valueOf, errMsg, valueOf2, authCode);
    }

    private final void F2() {
        this.thirdAppStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(int result, String errMsg) {
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleCloseThirdAppResult: result[" + result + "] errMsg[" + errMsg + "]");
        if (result != 0) {
            MediaChannelUtils.T(MediaChannelUtils.f228046a, result, errMsg, null, null, 12, null);
            return;
        }
        Integer value = this.mediaChannelCore.o0().M().getValue();
        if (value == null) {
            value = 1;
        }
        int intValue = value.intValue();
        if (intValue == 6) {
            this.mediaChannelCore.getEventBus().i(new SwitchThemeEvent(intValue, 1));
        }
        this.mediaChannelCore.o0().M().setValue(1);
        q1();
        C2();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.at());
    }

    private final void G2(String appId, AppAuthResult appAuthResult) {
        com.tencent.mobileqq.guild.media.core.n o06 = this.mediaChannelCore.o0();
        Integer value = o06.M().getValue();
        if (value == null) {
            value = 1;
        }
        CorountineFunKt.e(this.mediaChannelCore.getCoroutineScope(), "startThirdApp", null, null, null, new MediaChannelThirdAppHelper$startThirdApp$1(this, appId, appAuthResult, o06, value.intValue(), null), 14, null);
        Integer value2 = o06.M().getValue();
        if (value2 == null || value2.intValue() != 6) {
            com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.mediaChannelCore.getEventBus();
            Integer value3 = o06.M().getValue();
            Intrinsics.checkNotNull(value3);
            eventBus.i(new SwitchThemeEvent(value3.intValue(), 6));
        }
        o06.M().setValue(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(IGProAVUserStateChangeInfo userStateInfo) {
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleOnCancelThirdAppTalkPermission:");
        if (!m1()) {
            logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleOnCancelThirdAppTalkPermission: error, app had not control mic right.");
            return;
        }
        if (userStateInfo.getIGProAVShowMsgInfo() != null && !TextUtils.isEmpty(userStateInfo.getIGProAVShowMsgInfo().getShowMsg())) {
            QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), userStateInfo.getIGProAVShowMsgInfo().getShowMsg(), 0).show();
        }
        T1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(IGProBusinessNode bizNode) {
        Boolean bool;
        if (bizNode.getLobbyRoomInfo() != null) {
            IGProLobbyAppInfo lobbyAppInfo = bizNode.getLobbyRoomInfo().getLobbyAppInfo();
            IGProLobbyStateInfo lobbyStateInfo = bizNode.getLobbyRoomInfo().getLobbyStateInfo();
            if (k1(lobbyAppInfo, lobbyStateInfo)) {
                Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleOnLobbyAppInfoChanged: same info.");
                this.thirdAppInfo = lobbyAppInfo;
                this.lobbyRoomInfo = lobbyStateInfo;
                e12.a<Boolean> g16 = this.mediaChannelCore.o0().g();
                IGProLobbyStateInfo iGProLobbyStateInfo = this.lobbyRoomInfo;
                if (iGProLobbyStateInfo != null) {
                    bool = Boolean.valueOf(iGProLobbyStateInfo.getDisableVoiceAnimation());
                } else {
                    bool = Boolean.FALSE;
                }
                g16.setValue(bool);
                this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ax());
                D2(this.lobbyRoomInfo, this.thirdAppInfo);
                return;
            }
            C2();
            A2(bizNode);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("handleOnLobbyAppInfoChanged: bizNode is null!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(int updateTheme) {
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleOnMediaChannelThemeChanged: type[" + updateTheme + "]");
        if (updateTheme != 6) {
            q1();
            C2();
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ax());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(IGProAVUserStateChangeInfo userStateInfo) {
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleOnObtainThirdAppTalkPermission:");
        if (!m1()) {
            logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleOnObtainThirdAppTalkPermission: error, app had not control mic right.");
            return;
        }
        if (userStateInfo.getIGProAVShowMsgInfo() != null && !TextUtils.isEmpty(userStateInfo.getIGProAVShowMsgInfo().getShowMsg())) {
            QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), userStateInfo.getIGProAVShowMsgInfo().getShowMsg(), 0).show();
        }
        T1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(int result, String errMsg, IGProCreateLobbyRsp createLobbyRsp) {
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleStartThirdAppResult: result[" + result + "] errMsg[" + errMsg + "]");
        if (result != 0) {
            MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
            String string = BaseApplication.context.getString(R.string.f1499813r);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026hird_app_start_error_tip)");
            MediaChannelUtils.T(mediaChannelUtils, result, string, null, errMsg, 4, null);
            return;
        }
        this.thirdAppStartRequestBeginTime = 0L;
        this.thirdAppStartRequestUseTime = System.currentTimeMillis() - this.thirdAppStartRequestBeginTime;
        logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleStartThirdAppResult: current[" + System.currentTimeMillis() + "] begin[" + this.thirdAppStartRequestBeginTime + "]");
        if (k1(createLobbyRsp.getLobbyRoomInfo().getLobbyAppInfo(), createLobbyRsp.getLobbyRoomInfo().getLobbyStateInfo())) {
            logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleStartThirdAppResult: same info, ignore.");
            return;
        }
        this.thirdAppInfo = createLobbyRsp.getLobbyRoomInfo().getLobbyAppInfo();
        this.lobbyRoomInfo = createLobbyRsp.getLobbyRoomInfo().getLobbyStateInfo();
        Logger.b bVar = new Logger.b();
        String str = "handleStartThirdAppResult: update info. appInfo[" + S1(this.thirdAppInfo) + "] roomInfo[" + R1(this.lobbyRoomInfo) + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
        }
        com.tencent.mobileqq.guild.media.core.n o06 = this.mediaChannelCore.o0();
        Integer value = o06.M().getValue();
        if (value == null || value.intValue() != 6) {
            com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.mediaChannelCore.getEventBus();
            Integer value2 = o06.M().getValue();
            Intrinsics.checkNotNull(value2);
            eventBus.i(new SwitchThemeEvent(value2.intValue(), 6));
        }
        o06.M().setValue(6);
        U1();
        V1();
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ax());
        this.mediaChannelCore.B0().T();
    }

    private final void M1(int result, String errMsg, IGProCreateLobbyRsp switchLobbyRsp) {
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "handleSwitchThirdAppResult: result[" + result + "] errMsg[" + errMsg + "]");
        if (result == 0 && switchLobbyRsp != null) {
            C2();
            IGProLobbyRoomInfo lobbyRoomInfo = switchLobbyRsp.getLobbyRoomInfo();
            Intrinsics.checkNotNullExpressionValue(lobbyRoomInfo, "switchLobbyRsp.lobbyRoomInfo");
            B2(lobbyRoomInfo);
            return;
        }
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        String string = BaseApplication.context.getString(R.string.f1499813r);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026hird_app_start_error_tip)");
        if (errMsg == null) {
            errMsg = "";
        }
        MediaChannelUtils.T(mediaChannelUtils, result, string, null, errMsg, 4, null);
        this.appPreloadInfo = null;
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.av());
    }

    private final void N1() {
        com.tencent.mobileqq.guild.media.thirdapp.container.report.a aVar = new com.tencent.mobileqq.guild.media.thirdapp.container.report.a();
        this.thirdAppLoadReportTask = aVar;
        aVar.p();
    }

    private final void O1() {
        if (this.webJSHandler != null) {
            return;
        }
        this.webJSHandler = new com.tencent.mobileqq.guild.media.thirdapp.container.webview.k(new GuildOpenJsMethodProvider().d(), new OpenPluginRuntime(new GuildOpenContainerLauncher.StartParams(null, null, this.mediaChannelCore.getGuildID(), this.mediaChannelCore.E(), null, 0L, null, null, 243, null), new WeakReference(com.tencent.mobileqq.guild.util.ch.m()), new WeakReference(QBaseActivity.sTopActivity), new c()));
        GuildMediaWebIPCServer a16 = GuildMediaWebIPCServer.INSTANCE.a();
        com.tencent.mobileqq.guild.media.thirdapp.container.webview.k kVar = this.webJSHandler;
        Intrinsics.checkNotNull(kVar);
        a16.h(kVar);
    }

    private final void P1() {
        Object obj;
        boolean z16;
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "initMediaThirdAppInfo:");
        ArrayList<IGProBusinessNode> value = this.mediaChannelCore.v0().P().getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((IGProBusinessNode) obj).getNodeType() == 6) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProBusinessNode iGProBusinessNode = (IGProBusinessNode) obj;
            if (iGProBusinessNode != null) {
                A2(iGProBusinessNode);
            }
        }
    }

    private final boolean Q1() {
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo == null || iGProLobbyAppInfo.getAntiAddictionMode() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String R1(IGProLobbyStateInfo roomInfo) {
        if (roomInfo == null) {
            return "";
        }
        return "id[" + roomInfo.getAppId() + " roomId[" + roomInfo.getLobbyId() + "] type[" + roomInfo.getLobbyType() + "] capacity[" + roomInfo.getLobbyRoomCapacity() + "] count[" + roomInfo.getLobbyRoomCurrUserNum() + "] status[" + roomInfo.getLobbyRoomStatus() + "]]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String S1(IGProLobbyAppInfo appInfo) {
        if (appInfo == null) {
            return "";
        }
        return "id[" + appInfo.getAppId() + " title[" + appInfo.getAppName() + "] screenMode[" + appInfo.getScreenMode() + "] antiAddictionMode[" + appInfo.getAntiAddictionMode() + "] permission[" + appInfo.getPermissionRequired() + "] url[" + appInfo.getH5Url() + "]]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(boolean enableMic) {
        this.thirdAppTalkPermission = enableMic;
        U1();
    }

    private final void U1() {
        this.mediaChannelCore.C().S0(MediaChannelPermissionHelper.PermissionChangeType.THIRD_APP);
        this.mediaChannelCore.l0().e();
    }

    private final void V1() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[onLoadThirdAppSuccess] appPreloadInfo " + this.appPreloadInfo);
        String str = null;
        this.appPreloadInfo = null;
        if (m1() && com.tencent.mobileqq.guild.media.core.m.m(this.mediaChannelCore.v0())) {
            com.tencent.mobileqq.guild.util.ch.f1("\u7531\u4e8e\u5e94\u7528\u89c4\u5219\uff0c\u4f60\u5df2\u81ea\u52a8\u4e0b\u9ea6\u3002");
        }
        F2();
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo != null) {
            str = iGProLobbyAppInfo.getH5Url();
        }
        if (str == null) {
            str = "";
        }
        GuildMediaWebJsReportTask guildMediaWebJsReportTask = new GuildMediaWebJsReportTask();
        this.webJsReportTask = guildMediaWebJsReportTask;
        guildMediaWebJsReportTask.p(E1(), str);
        N1();
        e2();
    }

    private final void X1(final IGProPAInstructionInfo instruction, final boolean isFromMiniApp) {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        boolean z16 = true;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            QQCustomDialog qQCustomDialog = this.dialog;
            if (qQCustomDialog == null || !qQCustomDialog.isShowing()) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            QQCustomDialog createForceDialog = DialogUtil.createForceDialog(qBaseActivity, 230, instruction.getTitle(), instruction.getMsg(), qBaseActivity.getString(R.string.cancel), "\u5b9e\u540d\u8ba4\u8bc1", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.bp
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelThirdAppHelper.Y1(MediaChannelThirdAppHelper.this, instruction, qBaseActivity, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.bq
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelThirdAppHelper.Z1(isFromMiniApp, this, instruction, dialogInterface, i3);
                }
            });
            this.dialog = createForceDialog;
            if (createForceDialog != null) {
                createForceDialog.show();
            }
            QQCustomDialog qQCustomDialog2 = this.dialog;
            if (qQCustomDialog2 != null) {
                qQCustomDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.br
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MediaChannelThirdAppHelper.a2(MediaChannelThirdAppHelper.this, dialogInterface);
                    }
                });
            }
            if (this.dialog != null) {
                i2(this, instruction.getType(), false, 2, null);
                return;
            }
            return;
        }
        QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "openTipsDialog: activity is null, do nothing.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y1(MediaChannelThirdAppHelper this$0, IGProPAInstructionInfo instruction, QBaseActivity qBaseActivity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instruction, "$instruction");
        if (BaseApplication.context != null) {
            cx.a(qBaseActivity, instruction.getUrl());
        }
        this$0.h2(instruction.getType(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(boolean z16, MediaChannelThirdAppHelper this$0, IGProPAInstructionInfo instruction, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instruction, "$instruction");
        if (!z16 && !this$0.Q1()) {
            com.tencent.mobileqq.guild.media.core.j.a().D("\u5df2\u9000\u51fa\u5b50\u9891\u9053", "\u672a\u901a\u8fc7\u9632\u6c89\u8ff7\u5b9e\u540d\u8ba4\u8bc1\uff0c\u9700\u8981\u9000\u623f");
        }
        this$0.h2(instruction.getType(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(MediaChannelThirdAppHelper this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialog = null;
    }

    private final void b2(final IGProPAInstructionInfo instruction, final boolean needExitChannel, final boolean isFromMiniApp) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            QQCustomDialog createForceDialog = DialogUtil.createForceDialog(qBaseActivity, 230, instruction.getTitle(), instruction.getMsg(), null, qBaseActivity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.bt
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelThirdAppHelper.c2(needExitChannel, isFromMiniApp, this, instruction, dialogInterface, i3);
                }
            }, null);
            this.dialog = createForceDialog;
            if (createForceDialog != null) {
                createForceDialog.show();
            }
            QQCustomDialog qQCustomDialog = this.dialog;
            if (qQCustomDialog != null) {
                qQCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.bu
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MediaChannelThirdAppHelper.d2(MediaChannelThirdAppHelper.this, dialogInterface);
                    }
                });
            }
            if (this.dialog != null) {
                i2(this, instruction.getType(), false, 2, null);
                return;
            }
            return;
        }
        QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "openTipsDialog: activity is null, do nothing.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(boolean z16, boolean z17, MediaChannelThirdAppHelper this$0, IGProPAInstructionInfo instruction, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instruction, "$instruction");
        if (z16 && !z17) {
            com.tencent.mobileqq.guild.media.core.j.a().D("\u5df2\u9000\u51fa\u5b50\u9891\u9053", "\u9632\u6c89\u8ff7\u9650\u5236\uff0c\u9700\u8981\u9000\u623f");
        }
        this$0.h2(instruction.getType(), true);
    }

    private final long d1(String source) {
        try {
            return Long.parseLong(source);
        } catch (NumberFormatException unused) {
            Logger logger = Logger.f235387a;
            Throwable th5 = new Throwable("changeStringToLong");
            Logger.b bVar = new Logger.b();
            String str = "changeStringToLong: error! source[" + source + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), th5);
            }
            return -1000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(MediaChannelThirdAppHelper this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e1(String guildId, String channelId) {
        if (!TextUtils.equals(guildId, this.mediaChannelCore.getGuildID()) || !TextUtils.equals(channelId, this.mediaChannelCore.E())) {
            return false;
        }
        return true;
    }

    private final void e2() {
        if (com.tencent.mobileqq.guild.media.core.j.a().i0(com.tencent.mobileqq.guild.media.core.m.b(this.mediaChannelCore.v0()))) {
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[reEnterTRTC] ");
        this.mediaChannelCore.Q().L0(new g());
    }

    public static /* synthetic */ void g1(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, com.tencent.mobileqq.guild.media.thirdapp.container.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        mediaChannelThirdAppHelper.f1(aVar, z16);
    }

    private final ArrayList<IGProPAInstructionInfo> g2(ArrayList<IGProPAInstructionInfo> instructions) {
        Object obj;
        ArrayList<IGProPAInstructionInfo> arrayList = new ArrayList<>();
        Iterator<IGProPAInstructionInfo> it = instructions.iterator();
        while (it.hasNext()) {
            IGProPAInstructionInfo next = it.next();
            Iterator<T> it5 = arrayList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((IGProPAInstructionInfo) obj).getRuleName(), next.getRuleName())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((IGProPAInstructionInfo) obj) == null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(MediaChannelThirdAppHelper this$0, com.tencent.mobileqq.guild.media.thirdapp.container.a aVar, boolean z16, int i3, String str, IGProPreventAddictionCheckRsp iGProPreventAddictionCheckRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "checkPreventAddiction error: " + i3 + ", " + str);
            if (aVar != null) {
                aVar.onResult(true, "");
            }
            this$0.isPreventAddictionLimit = false;
            return;
        }
        if (iGProPreventAddictionCheckRsp.getInstructions().isEmpty()) {
            QLog.i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "no need to check prevent addiction");
            if (aVar != null) {
                aVar.onResult(true, "");
            }
            this$0.isPreventAddictionLimit = false;
            return;
        }
        this$0.isPreventAddictionLimit = true;
        String instrTraceId = iGProPreventAddictionCheckRsp.getInstrTraceId();
        Intrinsics.checkNotNullExpressionValue(instrTraceId, "checkRsp.instrTraceId");
        ArrayList<IGProPAInstructionInfo> instructions = iGProPreventAddictionCheckRsp.getInstructions();
        Intrinsics.checkNotNullExpressionValue(instructions, "checkRsp.instructions");
        q2(this$0, instrTraceId, instructions, z16, aVar, false, 16, null);
    }

    private final void h2(int type, boolean isClick) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        ViewGroup viewGroup5;
        String str;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            FrameLayout frameLayout = (FrameLayout) qBaseActivity.findViewById(R.id.wpt);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_popup_type", Integer.valueOf(type));
            QQCustomDialog qQCustomDialog = this.dialog;
            ViewGroup viewGroup6 = null;
            if (qQCustomDialog != null) {
                viewGroup = qQCustomDialog.getRootView();
            } else {
                viewGroup = null;
            }
            VideoReport.setElementId(viewGroup, "em_sgrp_anti_addiction_popup");
            QQCustomDialog qQCustomDialog2 = this.dialog;
            if (qQCustomDialog2 != null) {
                viewGroup2 = qQCustomDialog2.getRootView();
            } else {
                viewGroup2 = null;
            }
            VideoReport.setLogicParent(viewGroup2, frameLayout);
            QQCustomDialog qQCustomDialog3 = this.dialog;
            if (qQCustomDialog3 != null) {
                viewGroup3 = qQCustomDialog3.getRootView();
            } else {
                viewGroup3 = null;
            }
            VideoReport.setElementParams(viewGroup3, hashMap);
            QQCustomDialog qQCustomDialog4 = this.dialog;
            if (qQCustomDialog4 != null) {
                viewGroup4 = qQCustomDialog4.getRootView();
            } else {
                viewGroup4 = null;
            }
            VideoReport.setElementExposePolicy(viewGroup4, ExposurePolicy.REPORT_NONE);
            QQCustomDialog qQCustomDialog5 = this.dialog;
            if (qQCustomDialog5 != null) {
                viewGroup5 = qQCustomDialog5.getRootView();
            } else {
                viewGroup5 = null;
            }
            VideoReport.setElementClickPolicy(viewGroup5, ClickPolicy.REPORT_NONE);
            if (isClick) {
                str = "clck";
            } else {
                str = "imp";
            }
            QQCustomDialog qQCustomDialog6 = this.dialog;
            if (qQCustomDialog6 != null) {
                viewGroup6 = qQCustomDialog6.getRootView();
            }
            VideoReport.reportEvent(str, viewGroup6, hashMap);
            return;
        }
        QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "reportAntiAddictionPop: activity is null, do nothing.");
    }

    static /* synthetic */ void i2(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        mediaChannelThirdAppHelper.h2(i3, z16);
    }

    private final void j2(String instrTraceId, ArrayList<String> ruleNameList) {
        dq dqVar = new dq();
        dqVar.e(instrTraceId);
        dqVar.f(ruleNameList);
        dqVar.d(NetConnInfoCenter.getServerTime());
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime().getRuntimeS\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).reportPreventAddictionInstructions(dqVar, new dp() { // from class: com.tencent.mobileqq.guild.media.core.logic.bv
            @Override // wh2.dp
            public final void a(int i3, String str, IGProPAReportExecuteRsp iGProPAReportExecuteRsp) {
                MediaChannelThirdAppHelper.k2(i3, str, iGProPAReportExecuteRsp);
            }
        });
    }

    private final boolean k1(IGProLobbyAppInfo tempThirdAppInfo, IGProLobbyStateInfo tempLobbyRoomInfo) {
        String str;
        long j3;
        long j16;
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        String str2 = null;
        if (iGProLobbyAppInfo != null) {
            str = iGProLobbyAppInfo.getAppId();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        IGProLobbyStateInfo iGProLobbyStateInfo = this.lobbyRoomInfo;
        if (iGProLobbyStateInfo != null) {
            j3 = iGProLobbyStateInfo.getLobbyId();
        } else {
            j3 = 0;
        }
        if (tempThirdAppInfo != null) {
            str2 = tempThirdAppInfo.getAppId();
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (tempLobbyRoomInfo != null) {
            j16 = tempLobbyRoomInfo.getLobbyId();
        } else {
            j16 = 0;
        }
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "checkSameThirdAppInfo: curAppId[" + str + "] curLobbyId[" + j3 + "] tempAppId[" + str3 + "] tempLobbyId[" + j16 + "]");
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str3, str) && j3 != 0 && j3 == j16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(int i3, String str, IGProPAReportExecuteRsp iGProPAReportExecuteRsp) {
        QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "reportPreventAddictionInstructions result: " + i3 + ", " + str + ", " + iGProPAReportExecuteRsp);
    }

    private final boolean l1() {
        if (this.thirdAppInfo == null) {
            return false;
        }
        return true;
    }

    private final void m2() {
        String str;
        String str2;
        String str3;
        if (this.thirdAppInfo == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.thirdAppStartTime;
        if (currentTimeMillis <= 0) {
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        String E = this.mediaChannelCore.E();
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        String str4 = null;
        if (iGProLobbyAppInfo != null) {
            str = iGProLobbyAppInfo.getAppId();
        } else {
            str = null;
        }
        int i3 = 1;
        d16.i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "reportThirdAppRunningDuration: channelId[" + E + "] appId[" + str + "] time[" + currentTimeMillis + "]");
        int h16 = com.tencent.mobileqq.guild.media.z.h(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.E());
        if (!this.mediaChannelCore.getSelfUserInfo().f228100h) {
            i3 = 2;
        }
        HashMap hashMap = new HashMap();
        IGProLobbyAppInfo iGProLobbyAppInfo2 = this.thirdAppInfo;
        if (iGProLobbyAppInfo2 != null) {
            str2 = iGProLobbyAppInfo2.getAppId();
        } else {
            str2 = null;
        }
        String str5 = "";
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("sgrp_appid", str2);
        IGProLobbyAppInfo iGProLobbyAppInfo3 = this.thirdAppInfo;
        if (iGProLobbyAppInfo3 != null) {
            str3 = iGProLobbyAppInfo3.getAppName();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("sgrp_app_name", str3);
        hashMap.put("sgrp_channel_id", this.mediaChannelCore.getGuildID());
        hashMap.put("sgrp_sub_channel_id", this.mediaChannelCore.E());
        IGProChannelInfo channelInfo = this.mediaChannelCore.getChannelInfo();
        if (channelInfo != null) {
            str4 = channelInfo.getChannelName();
        }
        if (str4 != null) {
            str5 = str4;
        }
        hashMap.put("sgrp_sub_channel_name", str5);
        hashMap.put("sgrp_user_type", Integer.valueOf(h16));
        hashMap.put("sgrp_subchannel_session_id", this.mediaChannelCore.v0().L());
        hashMap.put("duration", Float.valueOf(((float) currentTimeMillis) / 1000.0f));
        hashMap.put("sgrp_isplay_appgame", Integer.valueOf(i3));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_sgrp_avchannel_appgame", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(MediaChannelThirdAppHelper this$0, String appId, Function4 callback, int i3, String errMsg, IGProLobbyAppAuthStatusRsp lobbyAppAuthStatusRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(lobbyAppAuthStatusRsp, "lobbyAppAuthStatusRsp");
        this$0.F1(appId, i3, errMsg, lobbyAppAuthStatusRsp, callback);
    }

    private final com.tencent.mobileqq.guild.media.thirdapp.e p1(AppInfo appInfo) {
        return new com.tencent.mobileqq.guild.media.thirdapp.e(PreloadFrom.START_APP, appInfo.getUrl(), appInfo.getTitle(), appInfo.getIconUrl(), appInfo.getAppId(), appInfo.getScreenMode(), appInfo.getPerLoadingMaterialType(), appInfo.getPerLoadingMaterialUrl());
    }

    private final void p2(String instrTraceId, ArrayList<IGProPAInstructionInfo> instructionList, boolean isFromMiniApp, com.tencent.mobileqq.guild.media.thirdapp.container.a callback, boolean isClosedMask) {
        boolean z16;
        if (Q1() && !isClosedMask) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.instructionsCache.clear();
        ArrayList<IGProPAInstructionInfo> g26 = g2(instructionList);
        ArrayList<IGProPAInstructionInfo> arrayList = new ArrayList<>();
        Iterator<IGProPAInstructionInfo> it = g26.iterator();
        while (it.hasNext()) {
            IGProPAInstructionInfo next = it.next();
            if (V.contains(Integer.valueOf(next.getType()))) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "no instruction need to be executed.");
            return;
        }
        if (z16) {
            QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "open anti-addiction mask view: " + this.instructionsCache.size());
            this.instructionsCache.put(instrTraceId, arrayList);
            this.hasOpenedMask = true;
            D2(this.lobbyRoomInfo, this.thirdAppInfo);
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.as(true));
            return;
        }
        this.hasOpenedMask = false;
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.as(false));
        r1(instrTraceId, g26, isFromMiniApp, callback);
    }

    private final void q1() {
        String E1 = E1();
        boolean z16 = true;
        Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "destroyWebView webPageId " + E1);
        if (E1.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        GuildMediaWebJsReportTask guildMediaWebJsReportTask = this.webJsReportTask;
        if (guildMediaWebJsReportTask != null) {
            GuildMediaWebJsReportTask.i(guildMediaWebJsReportTask, "media_web_manual_destroy_web", null, 2, null);
        }
        RemoteWebRenderIPCServer.D(RemoteWebRenderIPCServer.INSTANCE.a(), E1, null, 2, null);
    }

    static /* synthetic */ void q2(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, String str, ArrayList arrayList, boolean z16, com.tencent.mobileqq.guild.media.thirdapp.container.a aVar, boolean z17, int i3, Object obj) {
        boolean z18;
        boolean z19;
        if ((i3 & 4) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i3 & 8) != 0) {
            aVar = null;
        }
        com.tencent.mobileqq.guild.media.thirdapp.container.a aVar2 = aVar;
        if ((i3 & 16) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        mediaChannelThirdAppHelper.p2(str, arrayList, z18, aVar2, z19);
    }

    private final void r1(String instrTraceId, ArrayList<IGProPAInstructionInfo> instructions, boolean isFromMiniApp, com.tencent.mobileqq.guild.media.thirdapp.container.a callback) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<IGProPAInstructionInfo> it = instructions.iterator();
        while (it.hasNext()) {
            IGProPAInstructionInfo instruction = it.next();
            QLog.d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "executeInstructions, instrTraceId: " + instrTraceId + ", instruction: " + instruction);
            int type = instruction.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 7) {
                        }
                    } else {
                        arrayList.add(instruction.getRuleName());
                        Intrinsics.checkNotNullExpressionValue(instruction, "instruction");
                        X1(instruction, isFromMiniApp);
                    }
                }
                arrayList.add(instruction.getRuleName());
                Intrinsics.checkNotNullExpressionValue(instruction, "instruction");
                b2(instruction, !Q1(), isFromMiniApp);
            } else {
                arrayList.add(instruction.getRuleName());
                Intrinsics.checkNotNullExpressionValue(instruction, "instruction");
                b2(instruction, false, isFromMiniApp);
            }
        }
        if (!arrayList.isEmpty()) {
            if (callback != null) {
                callback.onResult(false, "");
            }
            j2(instrTraceId, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r2(Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        long j3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime().getRuntimeS\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        long d16 = d1(this.mediaChannelCore.getGuildID());
        long d17 = d1(this.mediaChannelCore.E());
        IGProLobbyStateInfo iGProLobbyStateInfo = this.lobbyRoomInfo;
        if (iGProLobbyStateInfo != null) {
            j3 = iGProLobbyStateInfo.getLobbyId();
        } else {
            j3 = 0;
        }
        iGPSService.closeAVLobbyApp(d16, d17, j3, new h(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    static /* synthetic */ void s1(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, String str, ArrayList arrayList, boolean z16, com.tencent.mobileqq.guild.media.thirdapp.container.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            aVar = null;
        }
        mediaChannelThirdAppHelper.r1(str, arrayList, z16, aVar);
    }

    private final String t1(String guildId, String channelId, String appId, long lobbyId) {
        return guildId + "_" + channelId + "_" + appId + "_" + lobbyId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(Function4 function4, int i3, String errMsg, IGProEncryptTextRsp iGProEncryptTextRsp) {
        if (function4 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Boolean valueOf2 = Boolean.valueOf(iGProEncryptTextRsp.getIsPassed());
            String encryptedText = iGProEncryptTextRsp.getEncryptedText();
            Intrinsics.checkNotNullExpressionValue(encryptedText, "encryptTextRsp.encryptedText");
            function4.invoke(valueOf, errMsg, valueOf2, encryptedText);
        }
    }

    private final Object u2(String str, int i3, int i16, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "requestThirdAppStart: channelId[" + this.mediaChannelCore.E() + "] appId[" + str + "]";
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
        }
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime().getRuntimeS\u2026va, ProcessConstant.MAIN)");
        com.tencent.mobileqq.qqguildsdk.data.genc.ad adVar = new com.tencent.mobileqq.qqguildsdk.data.genc.ad();
        adVar.g(str);
        adVar.k(d1(this.mediaChannelCore.getGuildID()));
        adVar.i(d1(this.mediaChannelCore.E()));
        adVar.l(i16);
        adVar.h(i3);
        adVar.j(new ArrayList<>());
        this.thirdAppStartRequestUseTime = 0L;
        this.thirdAppStartRequestBeginTime = System.currentTimeMillis();
        ((IGPSService) runtimeService).openAVLobbyApp(adVar, new i(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object v2(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, String str, int i3, int i16, Continuation continuation, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return mediaChannelThirdAppHelper.u2(str, i3, i16, continuation);
    }

    private final void w2(String appId, AppAuthResult appAuthResult) {
        long j3;
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "requestThirdAppSwitch: channelId[" + this.mediaChannelCore.E() + "] appId[" + appId + "]");
        if (this.lobbyRoomInfo == null) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("requestThirdAppSwitch: last lobby room is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
            }
            return;
        }
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime().getRuntimeS\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        com.tencent.mobileqq.qqguildsdk.data.genc.ad adVar = new com.tencent.mobileqq.qqguildsdk.data.genc.ad();
        adVar.g(appId);
        adVar.k(d1(this.mediaChannelCore.getGuildID()));
        adVar.i(d1(this.mediaChannelCore.E()));
        adVar.l(0);
        adVar.h(appAuthResult.getAppInfo().getCapacity());
        adVar.j(new ArrayList<>());
        com.tencent.mobileqq.qqguildsdk.data.genc.es esVar = new com.tencent.mobileqq.qqguildsdk.data.genc.es();
        IGProLobbyStateInfo iGProLobbyStateInfo = this.lobbyRoomInfo;
        if (iGProLobbyStateInfo != null) {
            j3 = iGProLobbyStateInfo.getLobbyId();
        } else {
            j3 = 0;
        }
        esVar.d(j3);
        esVar.c(adVar);
        iGPSService.switchAVLobbyApp(esVar, new wh2.p() { // from class: com.tencent.mobileqq.guild.media.core.logic.bl
            @Override // wh2.p
            public final void a(int i3, String str, IGProCreateLobbyRsp iGProCreateLobbyRsp) {
                MediaChannelThirdAppHelper.x2(MediaChannelThirdAppHelper.this, i3, str, iGProCreateLobbyRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(MediaChannelThirdAppHelper this$0, int i3, String str, IGProCreateLobbyRsp iGProCreateLobbyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M1(i3, str, iGProCreateLobbyRsp);
    }

    private final void y2() {
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface().getRuntim\u2026va, ProcessConstant.MAIN)");
        final IGPSService iGPSService = (IGPSService) runtimeService;
        iGPSService.getChannelHeartbeat(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), new vh2.aw() { // from class: com.tencent.mobileqq.guild.media.core.logic.bs
            @Override // vh2.aw
            public final void a(int i3, cv cvVar) {
                MediaChannelThirdAppHelper.z2(IGPSService.this, i3, cvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(IGPSService gpsService, int i3, cv cvVar) {
        Intrinsics.checkNotNullParameter(gpsService, "$gpsService");
        if (i3 != 0) {
            return;
        }
        ArrayList<df> arrayList = new ArrayList<>();
        Iterator<df> it = cvVar.f().iterator();
        while (it.hasNext()) {
            df next = it.next();
            if (!Intrinsics.areEqual("anti_addiction_info", next.a()) && !Intrinsics.areEqual("lobby_info", next.a())) {
                arrayList.add(next);
            }
        }
        cvVar.m(arrayList);
        gpsService.setChannelHeartbeat(cvVar);
    }

    @Nullable
    /* renamed from: A1, reason: from getter */
    public final IGProLobbyAppInfo getThirdAppInfo() {
        return this.thirdAppInfo;
    }

    @Nullable
    /* renamed from: B1, reason: from getter */
    public final com.tencent.mobileqq.guild.media.thirdapp.container.report.a getThirdAppLoadReportTask() {
        return this.thirdAppLoadReportTask;
    }

    @Nullable
    /* renamed from: C1, reason: from getter */
    public final com.tencent.mobileqq.guild.media.thirdapp.e getAppPreloadInfo() {
        return this.appPreloadInfo;
    }

    @NotNull
    public final String D1() {
        String appName;
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo == null && this.appPreloadInfo == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getThirdAppTitle: third app info is null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
            }
            return "";
        }
        if (iGProLobbyAppInfo != null && (appName = iGProLobbyAppInfo.getAppName()) != null) {
            return appName;
        }
        com.tencent.mobileqq.guild.media.thirdapp.e eVar = this.appPreloadInfo;
        if (eVar == null) {
            return "";
        }
        return eVar.getTitle();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        f2();
        P1();
        GuildMediaUtils.k(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.E());
        this.mediaChannelCore.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.e.class, this.bizNodeUpdateObserver);
        this.mediaChannelCore.getEventBus().V(SwitchThemeEvent.class, this.switchThemeObserver);
        this.mediaChannelCore.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.ae.class, this.multiGroupCanTalkUpdateEvent);
        this.mediaChannelCore.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.az.class, this.maskViewTouchListener);
        RemoteWebRenderIPCServer.INSTANCE.a().w(this.webViewStatusListener);
        O1();
    }

    @NotNull
    public final String E1() {
        IGProLobbyStateInfo iGProLobbyStateInfo;
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo == null || (iGProLobbyStateInfo = this.lobbyRoomInfo) == null) {
            return "";
        }
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        String appId = iGProLobbyAppInfo.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "appInfo.appId");
        return t1(guildID, E, appId, iGProLobbyStateInfo.getLobbyId());
    }

    public void H2() {
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    @NotNull
    public MediaBusinessType O() {
        return MediaBusinessType.MEDIA_THIRD_APP;
    }

    public final void W1(int resultCode, @Nullable AppAuthResult appAuthResult) {
        AppInfo appInfo;
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onRequestAppPermissionResult: resultCode[" + resultCode + "]");
        if (resultCode != 0) {
            if (resultCode == 9999) {
                logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onRequestAppPermissionResult: user cancel app auth.");
                return;
            }
            return;
        }
        String str = null;
        if (appAuthResult != null) {
            appInfo = appAuthResult.getAppInfo();
        } else {
            appInfo = null;
        }
        if (appInfo == null) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("onRequestAppPermissionResult: appInfo is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
            }
            return;
        }
        String appId = appAuthResult.getAppInfo().getAppId();
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo != null) {
            str = iGProLobbyAppInfo.getAppId();
        }
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, appId)) {
            this.appPreloadInfo = p1(appAuthResult.getAppInfo());
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.aw());
            w2(appId, appAuthResult);
        } else {
            if (!TextUtils.isEmpty(appId)) {
                this.appPreloadInfo = p1(appAuthResult.getAppInfo());
                this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.aw());
                G2(appId, appAuthResult);
                return;
            }
            logger.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onRequestAppPermissionResult: appId is null");
        }
    }

    public final void f1(@Nullable final com.tencent.mobileqq.guild.media.thirdapp.container.a callback, final boolean isFromMiniApp) {
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime().getRuntimeS\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).checkPreventAddiction(new dr(), new wh2.dq() { // from class: com.tencent.mobileqq.guild.media.core.logic.bn
            @Override // wh2.dq
            public final void a(int i3, String str, IGProPreventAddictionCheckRsp iGProPreventAddictionCheckRsp) {
                MediaChannelThirdAppHelper.h1(MediaChannelThirdAppHelper.this, callback, isFromMiniApp, i3, str, iGProPreventAddictionCheckRsp);
            }
        });
    }

    public void f2() {
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
    }

    /* renamed from: i1, reason: from getter */
    public final boolean getIsPreventAddictionLimit() {
        return this.isPreventAddictionLimit;
    }

    public final void j1() {
        Object obj;
        boolean z16;
        ArrayList<IGProBusinessNode> value = this.mediaChannelCore.v0().P().getValue();
        if (value != null && (!value.isEmpty())) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((IGProBusinessNode) obj).getNodeType() == 6) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProBusinessNode iGProBusinessNode = (IGProBusinessNode) obj;
            if (iGProBusinessNode != null && iGProBusinessNode.getLobbyRoomInfo() != null && iGProBusinessNode.getLobbyRoomInfo().getLobbyAppInfo().getAntiAddiction() == 1) {
                g1(this, null, false, 3, null);
            }
        }
    }

    public final void l2(long webViewLoadTime, long h5LoadingTime) {
        String str;
        String str2;
        String str3;
        if (this.thirdAppInfo == null) {
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        String E = this.mediaChannelCore.E();
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        String str4 = null;
        if (iGProLobbyAppInfo != null) {
            str = iGProLobbyAppInfo.getAppId();
        } else {
            str = null;
        }
        d16.i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "reportThirdAppLoadingDuration: channelId[" + E + "] appId[" + str + "] requestTime[" + this.thirdAppStartRequestUseTime + "] webViewTime[" + webViewLoadTime + "] h5Time[" + h5LoadingTime + "]");
        int h16 = com.tencent.mobileqq.guild.media.z.h(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.E());
        boolean equals = TextUtils.equals(String.valueOf(this.mediaChannelCore.v0().S().getValue()), com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a);
        HashMap hashMap = new HashMap();
        IGProLobbyAppInfo iGProLobbyAppInfo2 = this.thirdAppInfo;
        if (iGProLobbyAppInfo2 != null) {
            str2 = iGProLobbyAppInfo2.getAppId();
        } else {
            str2 = null;
        }
        String str5 = "";
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("sgrp_appid", str2);
        IGProLobbyAppInfo iGProLobbyAppInfo3 = this.thirdAppInfo;
        if (iGProLobbyAppInfo3 != null) {
            str3 = iGProLobbyAppInfo3.getAppName();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("sgrp_app_name", str3);
        hashMap.put("sgrp_channel_id", this.mediaChannelCore.getGuildID());
        hashMap.put("sgrp_sub_channel_id", this.mediaChannelCore.E());
        IGProChannelInfo channelInfo = this.mediaChannelCore.getChannelInfo();
        if (channelInfo != null) {
            str4 = channelInfo.getChannelName();
        }
        if (str4 != null) {
            str5 = str4;
        }
        hashMap.put("sgrp_sub_channel_name", str5);
        hashMap.put("sgrp_user_type", Integer.valueOf(h16));
        hashMap.put("request_duration", Float.valueOf(((float) this.thirdAppStartRequestUseTime) / 1000.0f));
        hashMap.put("webview_duration", Float.valueOf(((float) webViewLoadTime) / 1000.0f));
        hashMap.put("h5_duration", Float.valueOf(((float) h5LoadingTime) / 1000.0f));
        hashMap.put("sgrp_is_organize_appgame", Integer.valueOf(equals ? 1 : 0));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_sgrp_avchannel_appload_animation_time", hashMap);
        this.thirdAppStartRequestUseTime = 0L;
        this.thirdAppStartRequestBeginTime = 0L;
    }

    public final boolean m1() {
        long j3;
        if (!l1()) {
            return false;
        }
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo != null) {
            j3 = iGProLobbyAppInfo.getPermissionRequired();
        } else {
            j3 = 0;
        }
        if ((j3 & 1) != 1) {
            return false;
        }
        return true;
    }

    public final boolean n1() {
        if (Q() && m1() && this.thirdAppTalkPermission) {
            return true;
        }
        return false;
    }

    public final void n2(@NotNull final String appId, @NotNull final Function4<? super Integer, ? super String, ? super Boolean, ? super String, Unit> callback) {
        String str;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IGProLobbyAppInfo iGProLobbyAppInfo = this.thirdAppInfo;
        if (iGProLobbyAppInfo != null) {
            str = iGProLobbyAppInfo.getAppId();
        } else {
            str = null;
        }
        if (!TextUtils.equals(appId, str)) {
            return;
        }
        long d16 = d1(this.mediaChannelCore.getGuildID());
        long d17 = d1(this.mediaChannelCore.E());
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime()\n           \u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).checkLobbyAppAuthStatus(appId, d16, d17, new wh2.k() { // from class: com.tencent.mobileqq.guild.media.core.logic.bm
            @Override // wh2.k
            public final void a(int i3, String str2, IGProLobbyAppAuthStatusRsp iGProLobbyAppAuthStatusRsp) {
                MediaChannelThirdAppHelper.o2(MediaChannelThirdAppHelper.this, appId, callback, i3, str2, iGProLobbyAppAuthStatusRsp);
            }
        });
    }

    public final void o1() {
        CorountineFunKt.e(this.mediaChannelCore.getCoroutineScope(), "closeThirdApp", null, null, null, new MediaChannelThirdAppHelper$closeThirdApp$1(this, null), 14, null);
    }

    public final void s2(@NotNull String inputText, @Nullable final Function4<? super Integer, ? super String, ? super Boolean, ? super String, Unit> callback) {
        String appId;
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        String str = "";
        if (TextUtils.isEmpty(inputText)) {
            if (callback != null) {
                callback.invoke(0, "", Boolean.TRUE, "");
                return;
            }
            return;
        }
        if (this.lobbyRoomInfo == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("requestThirdAppInputTextCheck: last lobby room is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
            }
            return;
        }
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime()\n           \u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        com.tencent.mobileqq.qqguildsdk.data.genc.ah ahVar = new com.tencent.mobileqq.qqguildsdk.data.genc.ah();
        IGProLobbyStateInfo iGProLobbyStateInfo = this.lobbyRoomInfo;
        if (iGProLobbyStateInfo != null && (appId = iGProLobbyStateInfo.getAppId()) != null) {
            str = appId;
        }
        ahVar.c(str);
        ahVar.d(inputText);
        iGPSService.checkAndEncryptText(ahVar, new wh2.h() { // from class: com.tencent.mobileqq.guild.media.core.logic.bo
            @Override // wh2.h
            public final void a(int i3, String str2, IGProEncryptTextRsp iGProEncryptTextRsp) {
                MediaChannelThirdAppHelper.t2(Function4.this, i3, str2, iGProEncryptTextRsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        Logger.f235387a.d().i("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "onExitChannel:");
        H2();
        q1();
        C2();
        com.tencent.mobileqq.guild.media.thirdapp.c.f229224a.a();
        this.mediaChannelCore.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.e.class, this.bizNodeUpdateObserver);
        this.mediaChannelCore.getEventBus().j(SwitchThemeEvent.class, this.switchThemeObserver);
        this.mediaChannelCore.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.ae.class, this.multiGroupCanTalkUpdateEvent);
        this.mediaChannelCore.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.az.class, this.maskViewTouchListener);
        RemoteWebRenderIPCServer.INSTANCE.a().f0(this.webViewStatusListener);
        com.tencent.mobileqq.guild.media.thirdapp.container.webview.k kVar = this.webJSHandler;
        if (kVar != null) {
            kVar.e();
            GuildMediaWebIPCServer.INSTANCE.a().r(kVar);
        }
        this.webJSHandler = null;
        GuildMediaWebIPCServer.INSTANCE.a().destroy();
    }

    @Nullable
    /* renamed from: u1, reason: from getter */
    public final IGProLobbyStateInfo getLobbyRoomInfo() {
        return this.lobbyRoomInfo;
    }

    /* renamed from: v1, reason: from getter */
    public final boolean getHasOpenedMask() {
        return this.hasOpenedMask;
    }

    @Nullable
    /* renamed from: w1, reason: from getter */
    public final GuildMediaWebJsReportTask getWebJsReportTask() {
        return this.webJsReportTask;
    }

    public final void x1(@NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.thirdAppInfo != null && this.lobbyRoomInfo != null) {
            CorountineFunKt.e(this.mediaChannelCore.getCoroutineScope(), "getOpenId", null, null, null, new MediaChannelThirdAppHelper$getOpenId$2(this, callback, null), 14, null);
            return;
        }
        callback.invoke("");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("[getOpenId] appInfo or roomInfo is null!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, (String) it.next(), null);
        }
    }

    @NotNull
    public final String y1() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getFullGuildUserUserAvatarUrl(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.v0().getSelfUserInfo().f228093a, 0);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String z1() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getGuildUserDisplayName(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.v0().getSelfUserInfo().f228093a);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void R() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void S() {
    }
}

package com.tencent.qqnt.kernel.api.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.frequencycontrol.FrequencyControlDispatcherInject;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.DeviceType;
import com.tencent.qqnt.kernel.nativeinterface.IDependsAdapter;
import com.tencent.qqnt.kernel.nativeinterface.IDispatcherAdapter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAlbumService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBaseEmojiService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBatchUploadService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelEmojiService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupSchoolService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelPersonalAlbumService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQRService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSessionListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.InitSessionConfig;
import com.tencent.qqnt.kernel.nativeinterface.InitSessionDesktopPathConfig;
import com.tencent.qqnt.kernel.nativeinterface.InitSessionMobilePathConfig;
import com.tencent.qqnt.kernel.nativeinterface.MsfChangeReasonType;
import com.tencent.qqnt.kernel.nativeinterface.MsfStatusType;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import com.tencent.qqnt.kernel.nativeinterface.OpentelemetryInit;
import com.tencent.qqnt.kernel.nativeinterface.PlatformType;
import com.tencent.qqnt.kernel.nativeinterface.RDeliveryConfig;
import com.tencent.qqnt.kernel.nativeinterface.RegisterInfo;
import com.tencent.qqnt.kernel.nativeinterface.RegisterRes;
import com.tencent.qqnt.kernel.nativeinterface.UnregisterInfo;
import com.tencent.qqnt.ntstartup.nativeinterface.IQQNTStartupSessionWrapper;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c3\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0012\u0018\u0000 \u00f2\u00012\u00020\u0001:\u0002\u00f3\u0001B\t\u00a2\u0006\u0006\b\u00f0\u0001\u0010\u00f1\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u0002*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\f\u0010\u0016\u001a\u00020\u0002*\u00020\u0006H\u0002J\u001a\u0010\u0016\u001a\u00020\u0002*\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0002J\f\u0010\u0019\u001a\u00020\u0002*\u00020\u0006H\u0002J-\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u0002H\u0007J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\n\u0010+\u001a\u0004\u0018\u00010*H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016J\n\u0010?\u001a\u0004\u0018\u00010>H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0016J\n\u0010C\u001a\u0004\u0018\u00010BH\u0016J\n\u0010E\u001a\u0004\u0018\u00010DH\u0016J\n\u0010G\u001a\u0004\u0018\u00010FH\u0016J\n\u0010I\u001a\u0004\u0018\u00010HH\u0016J\n\u0010K\u001a\u0004\u0018\u00010JH\u0016J\n\u0010M\u001a\u0004\u0018\u00010LH\u0016J\n\u0010O\u001a\u0004\u0018\u00010NH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010PH\u0016J\n\u0010S\u001a\u0004\u0018\u00010RH\u0016J\n\u0010U\u001a\u0004\u0018\u00010TH\u0016J\n\u0010W\u001a\u0004\u0018\u00010VH\u0016J\n\u0010Y\u001a\u0004\u0018\u00010XH\u0016J\n\u0010[\u001a\u0004\u0018\u00010ZH\u0016J\n\u0010]\u001a\u0004\u0018\u00010\\H\u0016J\n\u0010_\u001a\u0004\u0018\u00010^H\u0016J\u0010\u0010a\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u0004H\u0016J\n\u0010c\u001a\u0004\u0018\u00010bH\u0016J\n\u0010e\u001a\u0004\u0018\u00010dH\u0016J\u0012\u0010f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010h\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u0002\u0018\u00010gH\u0016J\u0010\u0010k\u001a\u00020\u00022\u0006\u0010j\u001a\u00020iH\u0016J\b\u0010l\u001a\u00020iH\u0016J\b\u0010m\u001a\u00020iH\u0016J\b\u0010n\u001a\u00020\u0002H\u0016J \u0010u\u001a\u00020\u00022\u0006\u0010p\u001a\u00020o2\u0006\u0010r\u001a\u00020q2\u0006\u0010t\u001a\u00020sH\u0016J\u0010\u0010w\u001a\u00020\u00022\u0006\u0010p\u001a\u00020vH\u0016J\u0010\u0010z\u001a\u00020\u00022\u0006\u0010y\u001a\u00020xH\u0016J\u0018\u0010\u007f\u001a\u00020\u00022\u0006\u0010|\u001a\u00020{2\u0006\u0010~\u001a\u00020}H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020i2\u0007\u0010\u0080\u0001\u001a\u00020iH\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0002H\u0016J\u000b\u0010\u0083\u0001\u001a\u00020\u0002*\u00020\u0006J\u001f\u0010\u0086\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0084\u0001j\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0085\u0001H\u0016R\u0019\u0010\u0087\u0001\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u001e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020$0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001f\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0097\u0001R\u001e\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020(0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u0097\u0001R\u001e\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020.0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0097\u0001R\u001e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u0097\u0001R\u001f\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009d\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u0097\u0001R\u001e\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u0002000\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0097\u0001R\u001f\u0010\u00a1\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a0\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0097\u0001R\u001f\u0010\u00a3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a2\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u0097\u0001R\u001f\u0010\u00a5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a4\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u0097\u0001R\u001f\u0010\u00a7\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a6\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u0097\u0001R\u001f\u0010\u00a9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a8\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u0097\u0001R\u001f\u0010\u00ab\u0001\u001a\n\u0012\u0005\u0012\u00030\u00aa\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u0097\u0001R\u001f\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ac\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u0097\u0001R\u001f\u0010\u00af\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ae\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u0097\u0001R\u001f\u0010\u00b1\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b0\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u0097\u0001R\u001f\u0010\u00b3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b2\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u0097\u0001R\u001f\u0010\u00b5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b4\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u0097\u0001R\u001f\u0010\u00b7\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b6\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u0097\u0001R\u001f\u0010\u00b9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b8\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u0097\u0001R\u001f\u0010\u00bb\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ba\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u0097\u0001R\u001f\u0010\u00bd\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bc\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u0097\u0001R\u001f\u0010\u00bf\u0001\u001a\n\u0012\u0005\u0012\u00030\u00be\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u0097\u0001R\u001f\u0010\u00c1\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c0\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u0097\u0001R\u001e\u0010\u00c2\u0001\u001a\t\u0012\u0004\u0012\u00020X0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c2\u0001\u0010\u0097\u0001R\u001e\u0010\u00c3\u0001\u001a\t\u0012\u0004\u0012\u00020Z0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u0097\u0001R\u001f\u0010\u00c5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c4\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u0097\u0001R\u001e\u0010\u00c6\u0001\u001a\t\u0012\u0004\u0012\u00020\\0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u0097\u0001R\u001e\u0010\u00c7\u0001\u001a\t\u0012\u0004\u0012\u00020^0\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c7\u0001\u0010\u0097\u0001R\u001f\u0010\u00c9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c8\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c9\u0001\u0010\u0097\u0001R(\u0010\u00d0\u0001\u001a\n\u0012\u0005\u0012\u00030\u00cb\u00010\u00ca\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u001f\u0010\u00d2\u0001\u001a\n\u0012\u0005\u0012\u00030\u00d1\u00010\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u0097\u0001R\u0017\u0010m\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bm\u0010\u0088\u0001R'\u0010\u00d3\u0001\u001a\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u0002\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d3\u0001\u0010\u00d4\u0001R\u0018\u0010\u00d6\u0001\u001a\u00030\u00d5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00d7\u0001R,\u0010\u00d9\u0001\u001a\u0005\u0018\u00010\u00d8\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0006\b\u00d9\u0001\u0010\u00da\u0001\u001a\u0006\b\u00db\u0001\u0010\u00dc\u0001\"\u0006\b\u00dd\u0001\u0010\u00de\u0001R,\u0010\u00e0\u0001\u001a\u0005\u0018\u00010\u00df\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0006\b\u00e0\u0001\u0010\u00e1\u0001\u001a\u0006\b\u00e2\u0001\u0010\u00e3\u0001\"\u0006\b\u00e4\u0001\u0010\u00e5\u0001R!\u0010\u00e7\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e6\u00010\u0084\u00018\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0006\b\u00e7\u0001\u0010\u00e8\u0001R\u001c\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u00e9\u00018\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001R\u001c\u0010\u00ed\u0001\u001a\u0005\u0018\u00010\u00ec\u00018\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0006\b\u00ed\u0001\u0010\u00ee\u0001R\u0017\u0010`\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b`\u0010\u00ef\u0001\u00a8\u0006\u00f4\u0001"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/KernelServiceImpl;", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "", "checkCallerThread", "", "getHighPriorityGroupUin", "Lmqq/app/AppRuntime;", "Lcom/tencent/qqnt/kernel/api/u;", "listener", "startSession", "initMSFCmdRegister", "", "accountUin", "Lcom/tencent/qqnt/kernel/nativeinterface/InitSessionMobilePathConfig;", "getInitSessionMobilePathConfig", "initService", "Lkotlin/Function0;", "complete", "com/tencent/qqnt/kernel/api/impl/KernelServiceImpl$b", "getIKernelSessionListener", "(Lkotlin/jvm/functions/Function0;)Lcom/tencent/qqnt/kernel/api/impl/KernelServiceImpl$b;", "destroy", "registProxyMessagePush", "", "cmds", "unregistProxyMessagePush", "T", "method", WidgetCacheConstellationData.WORK, "check", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDependsAdapter;", "getIDependsAdapter", "initInject", "appRuntime", "onCreate", "Lcom/tencent/qqnt/kernel/api/impl/BuddyService;", "getBuddyService", "Lcom/tencent/qqnt/kernel/api/f;", "getAddOrDelBuddyService", "Lcom/tencent/qqnt/kernel/api/impl/GroupService;", "getGroupService", "Lcom/tencent/qqnt/kernel/api/impl/MsgService;", "getMsgService", "Lcom/tencent/qqnt/kernel/api/t;", "getGuildMsgService", "Lcom/tencent/qqnt/kernel/api/impl/RecentContactService;", "getRecentContactService", "Lcom/tencent/qqnt/kernel/api/impl/ProfileService;", "getProfileService", "Lcom/tencent/qqnt/kernel/api/ae;", "getSearchService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "getSettingService", "Lcom/tencent/qqnt/kernel/api/h;", "getAvatarService", "Lcom/tencent/qqnt/kernel/api/ab;", "getRichMediaService", "Lcom/tencent/qqnt/kernel/api/i;", "getBaseEmojiService", "Lcom/tencent/qqnt/kernel/api/ag;", "getUixConvertService", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "getWrapperSession", "Lcom/tencent/qqnt/kernel/api/af;", "getStorageCleanService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQRService;", "getQRService", "Lcom/tencent/qqnt/kernel/api/x;", "getNearbyProService", "Lcom/tencent/qqnt/kernel/api/g;", "getAlbumService", "Lcom/tencent/qqnt/kernel/api/z;", "getQZAlbumxService", "Lcom/tencent/qqnt/kernel/api/e;", "getAVSDKService", "Lcom/tencent/qqnt/kernel/api/ac;", "getRobotService", "Lcom/tencent/qqnt/kernel/api/r;", "getGroupSchoolService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessService;", "getLiteBusinessService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupTabService;", "getGroupTabService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelOnlineStatusService;", "getOnlineStatusService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelUnifySearchService;", "getUnifySearchService", "Lcom/tencent/qqnt/kernel/api/impl/EmojiService;", "getEmojiService", "Lcom/tencent/qqnt/kernel/api/impl/BdhUploadService;", "getBdhUploadService", "Lcom/tencent/qqnt/kernel/api/impl/qc;", "getWifiPhotoHostService", "Lcom/tencent/qqnt/kernel/api/impl/ha;", "getFileBridgeService", "groupUin", "setHighPriorityGroupUin", "Lcom/tencent/qqnt/kernel/api/k;", "getBatchUploadService", "Lcom/tencent/qqnt/kernel/api/q;", "getFlashTransferService", "start", "Lkotlin/Function1;", "setSessionDestroyListener", "", "useUid", "init", "isInit", "isDestroy", "initSdkStatusStaticCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/MsfStatusType;", "status", "Lcom/tencent/qqnt/kernel/nativeinterface/MsfChangeReasonType;", "reason", "", "connSeq", "setOnMsfStatusChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "setOnNetworkChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterInfo;", "registerInfo", "onLine", "Lcom/tencent/qqnt/kernel/nativeinterface/UnregisterInfo;", "unregisterInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "offLine", "userTrigger", "offLineSync", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "registerCmdCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheErrLog", "isInitComplete", "Z", "Lcom/tencent/qqnt/kernel/api/impl/py;", "serviceContent", "Lcom/tencent/qqnt/kernel/api/impl/py;", "wrapperSession", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "Lcom/tencent/qqnt/ntstartup/nativeinterface/IQQNTStartupSessionWrapper;", "startupSessionWrapper", "Lcom/tencent/qqnt/ntstartup/nativeinterface/IQQNTStartupSessionWrapper;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hadStartNT", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNTStartFinish", "Lcom/tencent/qqnt/kernel/utils/d;", "buddyService", "Lcom/tencent/qqnt/kernel/utils/d;", "Lcom/tencent/qqnt/kernel/api/impl/AddBuddyService;", "addBuddyService", "groupService", "recentContactService", "msgService", "Lcom/tencent/qqnt/kernel/api/impl/GuildMsgService;", "guildMsgService", "profileService", "Lcom/tencent/qqnt/kernel/api/impl/SearchService;", "searchService", "Lcom/tencent/qqnt/kernel/api/impl/c;", "avatarService", "Lcom/tencent/qqnt/kernel/api/impl/lm;", "richMediaService", "Lcom/tencent/qqnt/kernel/api/impl/BaseEmojiService;", "baseEmojiService", "Lcom/tencent/qqnt/kernel/api/impl/is;", "liteBusinessService", "Lcom/tencent/qqnt/kernel/api/impl/hv;", "groupTabService", "Lcom/tencent/qqnt/kernel/api/impl/pz;", "settingService", "Lcom/tencent/qqnt/kernel/api/impl/lc;", "onlineStatusService", "Lcom/tencent/qqnt/kernel/api/impl/qa;", "uixConvertService", "Lcom/tencent/qqnt/kernel/api/impl/StorageCleanService;", "storageCleanService", "Lcom/tencent/qqnt/kernel/api/impl/li;", "qrService", "Lcom/tencent/qqnt/kernel/api/impl/RobotService;", "robotService", "Lcom/tencent/qqnt/kernel/api/impl/GroupSchoolService;", "groupSchoolService", "Lcom/tencent/qqnt/kernel/api/impl/lb;", "nearByProService", "Lcom/tencent/qqnt/kernel/api/impl/b;", "albumService", "Lcom/tencent/qqnt/kernel/api/impl/lj;", "qzAlbumService", "Lcom/tencent/qqnt/kernel/api/impl/a;", "avSdkService", "emojiService", "bdhUploadService", "Lcom/tencent/qqnt/kernel/api/impl/qb;", "unifySearchService", "wifiPhotoHostService", "fileBridgeService", "Lcom/tencent/qqnt/kernel/api/impl/gq;", "batchUploadService", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqnt/kernel/api/ad;", "sdkStatusStaticCallbackList$delegate", "Lkotlin/Lazy;", "getSdkStatusStaticCallbackList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "sdkStatusStaticCallbackList", "Lcom/tencent/qqnt/kernel/api/impl/FlashTransferService;", "flashTransferService", "onSessionDestroyListener", "Lkotlin/jvm/functions/Function1;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "guardCallback", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "Lcom/tencent/mobileqq/inject/b;", "sAppSetting", "Lcom/tencent/mobileqq/inject/b;", "getSAppSetting", "()Lcom/tencent/mobileqq/inject/b;", "setSAppSetting", "(Lcom/tencent/mobileqq/inject/b;)V", "Ldx3/g;", "sSenderModule", "Ldx3/g;", "getSSenderModule", "()Ldx3/g;", "setSSenderModule", "(Ldx3/g;)V", "Lcom/tencent/qqnt/kernel/api/v;", "onlineCallback", "Ljava/util/ArrayList;", "Ldx3/f;", "sRelationModule", "Ldx3/f;", "Ldx3/b;", "sBusinessModule", "Ldx3/b;", "J", "<init>", "()V", "Companion", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class KernelServiceImpl implements IKernelService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean ENABLE_THREAD_CHECK = false;

    @NotNull
    private static final String LOG_TAG = "KernelService";

    @NotNull
    private static final String OFFLINE_CMD = "trpc.qq_new_tech.status_svc.StatusService.UnRegister";

    @NotNull
    private static final String SUB_TAG_Wrapper = "KernelServiceImpl";

    @NotNull
    private static final String SYS_PATH_SUFFIX = "/databases";

    @NotNull
    private static String currentUin;

    @Nullable
    private static String kernelPath;

    @NotNull
    private static final Lazy<Handler> kernelSendPackageHandler$delegate;
    private static final HandlerThread kernelSendPackageHandlerThread;
    private static ArrayList onlineCallback_AutoGenClazzList_QAutoInjectTransform;

    @Nullable
    private static dx3.a sAccountModule;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_AccountModule.yml", version = 2)
    @NotNull
    private static ArrayList<Class<dx3.a>> sAccountModuleList;
    private static ArrayList sAppSetting_AutoGenClazzList_QAutoInjectTransform;
    private static ArrayList sBusinessModule_AutoGenClazzList_QAutoInjectTransform;
    private static ArrayList sRelationModule_AutoGenClazzList_QAutoInjectTransform;
    private static ArrayList sSenderModule_AutoGenClazzList_QAutoInjectTransform;
    private static boolean supportUid;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<AddBuddyService> addBuddyService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<com.tencent.qqnt.kernel.api.impl.b> albumService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<a> avSdkService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<com.tencent.qqnt.kernel.api.impl.c> avatarService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<BaseEmojiService> baseEmojiService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<gq> batchUploadService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<BdhUploadService> bdhUploadService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<BuddyService> buddyService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<EmojiService> emojiService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<ha> fileBridgeService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<FlashTransferService> flashTransferService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<GroupSchoolService> groupSchoolService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<GroupService> groupService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<hv> groupTabService;
    private long groupUin;

    @NotNull
    private final IGuardInterface guardCallback;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<GuildMsgService> guildMsgService;

    @NotNull
    private final AtomicBoolean hadStartNT;
    private volatile boolean isDestroy;
    private boolean isInitComplete;

    @NotNull
    private final AtomicBoolean isNTStartFinish;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<is> liteBusinessService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<MsgService> msgService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<lb> nearByProService;

    @Nullable
    private Function1<? super IQQNTWrapperSession, Unit> onSessionDestroyListener;

    @QAutoInject(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_OnlineCallback.yml", version = 1)
    @NotNull
    private ArrayList<com.tencent.qqnt.kernel.api.v> onlineCallback;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<lc> onlineStatusService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<ProfileService> profileService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<li> qrService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<lj> qzAlbumService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<RecentContactService> recentContactService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<lm> richMediaService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<RobotService> robotService;

    @QAutoInject(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_AppSetting.yml", version = 1)
    @Nullable
    private com.tencent.mobileqq.inject.b sAppSetting;

    @QAutoInject(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_BusinessModule.yml", version = 1)
    @Nullable
    private dx3.b sBusinessModule;

    @QAutoInject(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_InitialRelation.yml", version = 1)
    @Nullable
    private dx3.f sRelationModule;

    @QAutoInject(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_SenderModule.yml", version = 1)
    @Nullable
    private dx3.g sSenderModule;

    /* renamed from: sdkStatusStaticCallbackList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sdkStatusStaticCallbackList;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<SearchService> searchService;
    private volatile py serviceContent;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<pz> settingService;

    @Nullable
    private volatile IQQNTStartupSessionWrapper startupSessionWrapper;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<StorageCleanService> storageCleanService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<qa> uixConvertService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<qb> unifySearchService;

    @NotNull
    private final com.tencent.qqnt.kernel.utils.d<qc> wifiPhotoHostService;

    @Nullable
    private volatile IQQNTWrapperSession wrapperSession;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0011R\u0014\u0010&\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0011R\u0014\u0010'\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0011R\u0014\u0010(\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0011R\u001c\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/KernelServiceImpl$a;", "", "", "", "i", "j", "Lmqq/app/AppRuntime;", "app", "", tl.h.F, "Landroid/os/Handler;", "kernelSendPackageHandler$delegate", "Lkotlin/Lazy;", "e", "()Landroid/os/Handler;", "kernelSendPackageHandler", PanoramaConfig.KEY_CURRENT_UIN, "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setCurrentUin", "(Ljava/lang/String;)V", "", "supportUid", "Z", "g", "()Z", "setSupportUid", "(Z)V", "Ldx3/a;", "sAccountModule", "Ldx3/a;", "f", "()Ldx3/a;", "setSAccountModule", "(Ldx3/a;)V", "ENABLE_THREAD_CHECK", "LOG_TAG", "OFFLINE_CMD", "SUB_TAG_Wrapper", "SYS_PATH_SUFFIX", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "kernelSendPackageHandlerThread", "Landroid/os/HandlerThread;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return;
            }
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Handler e() {
            return (Handler) KernelServiceImpl.kernelSendPackageHandler$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i(byte[] bArr) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb5.append(hexString);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String j(String str) {
            if (str == null) {
                return "";
            }
            return str;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return KernelServiceImpl.currentUin;
            }
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Nullable
        public final dx3.a f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return KernelServiceImpl.sAccountModule;
            }
            return (dx3.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return KernelServiceImpl.supportUid;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }

        @NotNull
        public final List<String> h(@NotNull AppRuntime app) {
            List<String> listOf;
            List<String> listOf2;
            List<String> c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (List) iPatchRedirector.redirect((short) 12, (Object) this, (Object) app);
            }
            Intrinsics.checkNotNullParameter(app, "app");
            try {
                dx3.a f16 = f();
                if (f16 == null || (c16 = f16.c(d(), app)) == null) {
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"", "", ""});
                    return listOf2;
                }
                return c16;
            } catch (IllegalStateException e16) {
                KernelSetterImpl.INSTANCE.j("getTicket", e16.toString());
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"", "", ""});
                return listOf;
            }
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
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/kernel/api/impl/KernelServiceImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSessionListener;", "", "result", "", "sessionId", "uid", "", "onSessionInitComplete", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterRes;", "registerRes", "onUserOnlineResult", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelSessionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f357248b;

        b(Function0<Unit> function0) {
            this.f357248b = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this, (Object) function0);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSessionListener
        public /* synthetic */ void onNTSessionCreate(int i3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.bo.a(this, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSessionListener
        public /* synthetic */ void onOpentelemetryInit(OpentelemetryInit opentelemetryInit) {
            com.tencent.qqnt.kernel.nativeinterface.bo.b(this, opentelemetryInit);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSessionListener
        public void onSessionInitComplete(int result, @Nullable String sessionId, @Nullable String uid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                KernelServiceImpl.this.initService();
                KLog.i(KLog.f359087a, KernelServiceImpl.SUB_TAG_Wrapper, new Object[]{"NTSDKInit onSessionInitComplete NT result:" + result + " sessionId:" + sessionId + " uid:" + uid}, null, 4, null);
                try {
                    KernelServiceImpl.this.setOnNetworkChanged(com.tencent.qqnt.kernel.utils.g.a());
                    this.f357248b.invoke();
                    return;
                } catch (Throwable th5) {
                    KLog.i(KLog.f359087a, KernelServiceImpl.SUB_TAG_Wrapper, new Object[]{"NTSDKInit run complete error: " + QLog.getStackTraceString(th5)}, null, 4, null);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), sessionId, uid);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSessionListener
        public void onUserOnlineResult(int result, @Nullable String errMsg, @Nullable RegisterRes registerRes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(result), errMsg, registerRes);
            } else {
                com.tencent.qqnt.kernel.nativeinterface.bo.d(this, result, errMsg, registerRes);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/kernel/api/impl/KernelServiceImpl$c", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements IGuardInterface {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QLog.i(KernelServiceImpl.SUB_TAG_Wrapper, 1, "onApplicationBackground: " + KernelServiceImpl.this.wrapperSession);
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                if (iQQNTWrapperSession != null) {
                    iQQNTWrapperSession.switchToBackGround();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QLog.i(KernelServiceImpl.SUB_TAG_Wrapper, 1, "onApplicationForeground: " + KernelServiceImpl.this.wrapperSession);
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                if (iQQNTWrapperSession != null) {
                    iQQNTWrapperSession.switchToFront();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, tick);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, isEnabled);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/kernel/api/impl/KernelServiceImpl$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IDispatcherAdapter;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "cmd", "", "pbBuffer", "", "dispatchRequest", "dispatchCall", "", "jsonStr", "dispatchCallWithJson", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements IDispatcherAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IDispatcherAdapter
        public void dispatchCall(int cmd, @NotNull byte[] pbBuffer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, cmd, (Object) pbBuffer);
            } else {
                Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
                FrequencyControlDispatcherInject.f359076a.b(cmd, pbBuffer);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IDispatcherAdapter
        public void dispatchCallWithJson(int cmd, @Nullable String jsonStr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, cmd, (Object) jsonStr);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IDispatcherAdapter
        public void dispatchRequest(long requestId, int cmd, @NotNull byte[] pbBuffer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
            } else {
                Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
                FrequencyControlDispatcherInject.f359076a.c(requestId, cmd, pbBuffer);
            }
        }
    }

    static {
        Lazy<Handler> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48919);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 55)) {
            redirector.redirect((short) 55);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sAppSetting_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        ArrayList arrayList2 = new ArrayList();
        sRelationModule_AutoGenClazzList_QAutoInjectTransform = arrayList2;
        arrayList2.add(com.tencent.mobileqq.injector.af.class);
        ArrayList arrayList3 = new ArrayList();
        onlineCallback_AutoGenClazzList_QAutoInjectTransform = arrayList3;
        arrayList3.add(nc2.a.class);
        onlineCallback_AutoGenClazzList_QAutoInjectTransform.add(oc2.a.class);
        ArrayList arrayList4 = new ArrayList();
        sSenderModule_AutoGenClazzList_QAutoInjectTransform = arrayList4;
        arrayList4.add(com.tencent.mobileqq.injector.ag.class);
        ArrayList arrayList5 = new ArrayList();
        sBusinessModule_AutoGenClazzList_QAutoInjectTransform = arrayList5;
        arrayList5.add(com.tencent.mobileqq.injector.h.class);
        INSTANCE = new Companion(null);
        currentUin = "";
        supportUid = true;
        ArrayList<Class<dx3.a>> arrayList6 = new ArrayList<>();
        sAccountModuleList = arrayList6;
        arrayList6.add(com.tencent.mobileqq.injector.c.class);
        kernelSendPackageHandlerThread = ThreadManagerV2.newFreeHandlerThread("kernel_send_package", 5);
        lazy = LazyKt__LazyJVMKt.lazy(KernelServiceImpl$Companion$kernelSendPackageHandler$2.INSTANCE);
        kernelSendPackageHandler$delegate = lazy;
        if (sAccountModuleList.size() > 0) {
            sAccountModule = sAccountModuleList.get(0).newInstance();
        }
    }

    public KernelServiceImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hadStartNT = new AtomicBoolean(false);
        this.isNTStartFinish = new AtomicBoolean(false);
        this.buddyService = com.tencent.qqnt.kernel.utils.e.a(new Function0<BuddyService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$buddyService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BuddyService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (BuddyService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBuddyService iKernelBuddyService = (IKernelBuddyService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getBuddyService", new Function0<IKernelBuddyService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$buddyService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelBuddyService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelBuddyService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getBuddyService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new BuddyService(iKernelBuddyService, pyVar);
            }
        });
        this.addBuddyService = com.tencent.qqnt.kernel.utils.e.a(new Function0<AddBuddyService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$addBuddyService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AddBuddyService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AddBuddyService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelAddBuddyService iKernelAddBuddyService = (IKernelAddBuddyService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getAddOrDelBuddyService", new Function0<IKernelAddBuddyService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$addBuddyService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelAddBuddyService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelAddBuddyService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getAddBuddyService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new AddBuddyService(iKernelAddBuddyService, pyVar);
            }
        });
        this.groupService = com.tencent.qqnt.kernel.utils.e.a(new Function0<GroupService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$groupService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GroupService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GroupService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelGroupService iKernelGroupService = (IKernelGroupService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getGroupService", new Function0<IKernelGroupService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$groupService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelGroupService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelGroupService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getGroupService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new GroupService(iKernelGroupService, pyVar);
            }
        });
        this.recentContactService = com.tencent.qqnt.kernel.utils.e.a(new Function0<RecentContactService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$recentContactService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RecentContactService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RecentContactService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelRecentContactService iKernelRecentContactService = (IKernelRecentContactService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getRecentContactService", new Function0<IKernelRecentContactService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$recentContactService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelRecentContactService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelRecentContactService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getRecentContactService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new RecentContactService(iKernelRecentContactService, pyVar);
            }
        });
        this.msgService = com.tencent.qqnt.kernel.utils.e.a(new Function0<MsgService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$msgService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final MsgService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MsgService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelMsgService iKernelMsgService = (IKernelMsgService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getMsgService", new Function0<IKernelMsgService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$msgService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelMsgService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelMsgService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getMsgService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new MsgService(iKernelMsgService, pyVar);
            }
        });
        this.guildMsgService = com.tencent.qqnt.kernel.utils.e.a(new Function0<GuildMsgService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$guildMsgService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildMsgService invoke() {
                py pyVar;
                com.tencent.qqnt.kernel.utils.o oVar = com.tencent.qqnt.kernel.utils.o.f359277a;
                final KernelServiceImpl kernelServiceImpl = KernelServiceImpl.this;
                IKernelGuildMsgService iKernelGuildMsgService = (IKernelGuildMsgService) oVar.a("getGuildMsgService", new Function0<IKernelGuildMsgService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$guildMsgService$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelGuildMsgService invoke() {
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getGuildMsgService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new GuildMsgService(iKernelGuildMsgService, pyVar);
            }
        });
        this.profileService = com.tencent.qqnt.kernel.utils.e.a(new Function0<ProfileService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$profileService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ProfileService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ProfileService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelProfileService iKernelProfileService = (IKernelProfileService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getProfileService", new Function0<IKernelProfileService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$profileService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelProfileService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelProfileService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getProfileService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new ProfileService(iKernelProfileService, pyVar);
            }
        });
        this.searchService = com.tencent.qqnt.kernel.utils.e.a(new Function0<SearchService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$searchService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SearchService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SearchService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSearchService iKernelSearchService = (IKernelSearchService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getSearchService", new Function0<IKernelSearchService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$searchService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelSearchService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelSearchService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getSearchService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new SearchService(iKernelSearchService, pyVar);
            }
        });
        this.avatarService = com.tencent.qqnt.kernel.utils.e.a(new Function0<com.tencent.qqnt.kernel.api.impl.c>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$avatarService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final c invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelAvatarService iKernelAvatarService = (IKernelAvatarService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getAvatarService", new Function0<IKernelAvatarService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$avatarService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelAvatarService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelAvatarService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getAvatarService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new c(iKernelAvatarService, pyVar);
            }
        });
        this.richMediaService = com.tencent.qqnt.kernel.utils.e.a(new Function0<lm>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$richMediaService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lm invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (lm) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelRichMediaService iKernelRichMediaService = (IKernelRichMediaService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getRichMediaService", new Function0<IKernelRichMediaService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$richMediaService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelRichMediaService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelRichMediaService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getRichMediaService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new lm(iKernelRichMediaService, pyVar);
            }
        });
        this.baseEmojiService = com.tencent.qqnt.kernel.utils.e.a(new Function0<BaseEmojiService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$baseEmojiService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BaseEmojiService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (BaseEmojiService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBaseEmojiService iKernelBaseEmojiService = (IKernelBaseEmojiService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getBaseEmojiService", new Function0<IKernelBaseEmojiService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$baseEmojiService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelBaseEmojiService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelBaseEmojiService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getBaseEmojiService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new BaseEmojiService(iKernelBaseEmojiService, pyVar);
            }
        });
        this.liteBusinessService = com.tencent.qqnt.kernel.utils.e.a(new Function0<is>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$liteBusinessService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final is invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (is) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelLiteBusinessService iKernelLiteBusinessService = (IKernelLiteBusinessService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getLiteBusinessService", new Function0<IKernelLiteBusinessService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$liteBusinessService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelLiteBusinessService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelLiteBusinessService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getLiteBusinessService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new is(iKernelLiteBusinessService, pyVar);
            }
        });
        this.groupTabService = com.tencent.qqnt.kernel.utils.e.a(new Function0<hv>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$groupTabService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final hv invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (hv) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelGroupTabService iKernelGroupTabService = (IKernelGroupTabService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getGroupTabService", new Function0<IKernelGroupTabService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$groupTabService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelGroupTabService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelGroupTabService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getGroupTabService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new hv(iKernelGroupTabService, pyVar);
            }
        });
        this.settingService = com.tencent.qqnt.kernel.utils.e.a(new Function0<pz>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$settingService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final pz invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (pz) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelSettingService iKernelSettingService = (IKernelSettingService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getSettingService", new Function0<IKernelSettingService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$settingService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelSettingService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelSettingService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getSettingService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new pz(iKernelSettingService, pyVar);
            }
        });
        this.onlineStatusService = com.tencent.qqnt.kernel.utils.e.a(new Function0<lc>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$onlineStatusService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lc invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (lc) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                Intrinsics.checkNotNull(iQQNTWrapperSession);
                py pyVar2 = null;
                if (iQQNTWrapperSession.getOnlineStatusService() == null) {
                    return null;
                }
                Object invoke = com.tencent.qqnt.kernel.utils.o.f359277a.a("getGroupTabService", new Function0<IKernelOnlineStatusService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$onlineStatusService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelOnlineStatusService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelOnlineStatusService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession2 = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession2);
                        return iQQNTWrapperSession2.getOnlineStatusService();
                    }
                });
                Intrinsics.checkNotNullExpressionValue(invoke, "invoke");
                IKernelOnlineStatusService iKernelOnlineStatusService = (IKernelOnlineStatusService) invoke;
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                } else {
                    pyVar2 = pyVar;
                }
                return new lc(iKernelOnlineStatusService, pyVar2);
            }
        });
        this.uixConvertService = com.tencent.qqnt.kernel.utils.e.a(new Function0<qa>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$uixConvertService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final qa invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (qa) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new qa(pyVar);
            }
        });
        this.storageCleanService = com.tencent.qqnt.kernel.utils.e.a(new Function0<StorageCleanService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$storageCleanService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final StorageCleanService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (StorageCleanService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelStorageCleanService iKernelStorageCleanService = (IKernelStorageCleanService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getStorageCleanService", new Function0<IKernelStorageCleanService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$storageCleanService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelStorageCleanService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelStorageCleanService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getStorageCleanService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new StorageCleanService(iKernelStorageCleanService, pyVar);
            }
        });
        this.qrService = com.tencent.qqnt.kernel.utils.e.a(new Function0<li>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$qrService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final li invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (li) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelQRService iKernelQRService = (IKernelQRService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getQrService", new Function0<IKernelQRService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$qrService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelQRService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelQRService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getQRService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new li(iKernelQRService, pyVar);
            }
        });
        this.robotService = com.tencent.qqnt.kernel.utils.e.a(new Function0<RobotService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$robotService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RobotService invoke() {
                py pyVar;
                com.tencent.qqnt.kernel.utils.o oVar = com.tencent.qqnt.kernel.utils.o.f359277a;
                final KernelServiceImpl kernelServiceImpl = KernelServiceImpl.this;
                IKernelRobotService iKernelRobotService = (IKernelRobotService) oVar.a("getRobotService", new Function0<IKernelRobotService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$robotService$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelRobotService invoke() {
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getRobotService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new RobotService(iKernelRobotService, pyVar);
            }
        });
        this.groupSchoolService = com.tencent.qqnt.kernel.utils.e.a(new Function0<GroupSchoolService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$groupSchoolService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GroupSchoolService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GroupSchoolService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelGroupSchoolService iKernelGroupSchoolService = (IKernelGroupSchoolService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getGroupSchoolService", new Function0<IKernelGroupSchoolService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$groupSchoolService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelGroupSchoolService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelGroupSchoolService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getGroupSchoolService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new GroupSchoolService(iKernelGroupSchoolService, pyVar);
            }
        });
        this.nearByProService = com.tencent.qqnt.kernel.utils.e.a(new Function0<lb>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$nearByProService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lb invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (lb) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelNearbyProService iKernelNearbyProService = (IKernelNearbyProService) com.tencent.qqnt.kernel.utils.o.f359277a.a("nearbyProService", new Function0<IKernelNearbyProService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$nearByProService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelNearbyProService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelNearbyProService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getNearbyProService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new lb(iKernelNearbyProService, pyVar);
            }
        });
        this.albumService = com.tencent.qqnt.kernel.utils.e.a(new Function0<com.tencent.qqnt.kernel.api.impl.b>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$albumService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final b invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelAlbumService iKernelAlbumService = (IKernelAlbumService) com.tencent.qqnt.kernel.utils.o.f359277a.a("albumService", new Function0<IKernelAlbumService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$albumService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelAlbumService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelAlbumService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getAlbumService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new b(iKernelAlbumService, pyVar);
            }
        });
        this.qzAlbumService = com.tencent.qqnt.kernel.utils.e.a(new Function0<lj>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$qzAlbumService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lj invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (lj) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelPersonalAlbumService iKernelPersonalAlbumService = (IKernelPersonalAlbumService) com.tencent.qqnt.kernel.utils.o.f359277a.a("qzAlbumService", new Function0<IKernelPersonalAlbumService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$qzAlbumService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelPersonalAlbumService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelPersonalAlbumService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getPersonalAlbumService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new lj(iKernelPersonalAlbumService, pyVar);
            }
        });
        this.avSdkService = com.tencent.qqnt.kernel.utils.e.a(new Function0<a>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$avSdkService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final a invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelAVSDKService iKernelAVSDKService = (IKernelAVSDKService) com.tencent.qqnt.kernel.utils.o.f359277a.a("avSDkService", new Function0<IKernelAVSDKService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$avSdkService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelAVSDKService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelAVSDKService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getAVSDKService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new a(iKernelAVSDKService, pyVar);
            }
        });
        this.emojiService = com.tencent.qqnt.kernel.utils.e.a(new Function0<EmojiService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$emojiService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final EmojiService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (EmojiService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelEmojiService iKernelEmojiService = (IKernelEmojiService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getEmojiService", new Function0<IKernelEmojiService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$emojiService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelEmojiService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelEmojiService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getEmojiService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new EmojiService(iKernelEmojiService, pyVar);
            }
        });
        this.bdhUploadService = com.tencent.qqnt.kernel.utils.e.a(new Function0<BdhUploadService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$bdhUploadService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BdhUploadService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (BdhUploadService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBdhUploadService iKernelBdhUploadService = (IKernelBdhUploadService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getBdhUploadService", new Function0<IKernelBdhUploadService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$bdhUploadService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelBdhUploadService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelBdhUploadService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getBdhUploadService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new BdhUploadService(iKernelBdhUploadService, pyVar);
            }
        });
        this.unifySearchService = com.tencent.qqnt.kernel.utils.e.a(new Function0<qb>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$unifySearchService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final qb invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (qb) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                Intrinsics.checkNotNull(iQQNTWrapperSession);
                py pyVar2 = null;
                if (iQQNTWrapperSession.getUnifySearchService() != null) {
                    Object invoke = com.tencent.qqnt.kernel.utils.o.f359277a.a("getUnifySearchService", new Function0<IKernelUnifySearchService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$unifySearchService$1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                            }
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final IKernelUnifySearchService invoke() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                return (IKernelUnifySearchService) iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                            IQQNTWrapperSession iQQNTWrapperSession2 = KernelServiceImpl.this.wrapperSession;
                            Intrinsics.checkNotNull(iQQNTWrapperSession2);
                            return iQQNTWrapperSession2.getUnifySearchService();
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(invoke, "invoke");
                    IKernelUnifySearchService iKernelUnifySearchService = (IKernelUnifySearchService) invoke;
                    pyVar = KernelServiceImpl.this.serviceContent;
                    if (pyVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    } else {
                        pyVar2 = pyVar;
                    }
                    return new qb(iKernelUnifySearchService, pyVar2);
                }
                KLog kLog = KLog.f359087a;
                IQQNTWrapperSession iQQNTWrapperSession2 = KernelServiceImpl.this.wrapperSession;
                Intrinsics.checkNotNull(iQQNTWrapperSession2);
                KLog.g(kLog, "KernelServiceImpl", new Object[]{"getUnifySearchService " + iQQNTWrapperSession2.getUnifySearchService()}, null, 4, null);
                return null;
            }
        });
        this.wifiPhotoHostService = com.tencent.qqnt.kernel.utils.e.a(new Function0<qc>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$wifiPhotoHostService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final qc invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (qc) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelWiFiPhotoHostService iKernelWiFiPhotoHostService = (IKernelWiFiPhotoHostService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getWifiPhotoHostService", new Function0<IKernelWiFiPhotoHostService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$wifiPhotoHostService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelWiFiPhotoHostService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelWiFiPhotoHostService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getWiFiPhotoHostService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new qc(iKernelWiFiPhotoHostService, pyVar);
            }
        });
        this.fileBridgeService = com.tencent.qqnt.kernel.utils.e.a(new Function0<ha>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$fileBridgeService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ha invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ha) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFileBridgeClientService iKernelFileBridgeClientService = (IKernelFileBridgeClientService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getFileBridgeService", new Function0<IKernelFileBridgeClientService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$fileBridgeService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelFileBridgeClientService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelFileBridgeClientService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getFileBridgeClientService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new ha(iKernelFileBridgeClientService, pyVar);
            }
        });
        this.batchUploadService = com.tencent.qqnt.kernel.utils.e.a(new Function0<gq>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$batchUploadService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final gq invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (gq) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBatchUploadService iKernelBatchUploadService = (IKernelBatchUploadService) com.tencent.qqnt.kernel.utils.o.f359277a.a("batchUploadService", new Function0<IKernelBatchUploadService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$batchUploadService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IKernelBatchUploadService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelBatchUploadService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        Intrinsics.checkNotNull(iQQNTWrapperSession);
                        return iQQNTWrapperSession.getBatchUploadService();
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new gq(iKernelBatchUploadService, pyVar);
            }
        });
        lazy = LazyKt__LazyJVMKt.lazy(KernelServiceImpl$sdkStatusStaticCallbackList$2.INSTANCE);
        this.sdkStatusStaticCallbackList = lazy;
        this.flashTransferService = com.tencent.qqnt.kernel.utils.e.a(new Function0<FlashTransferService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$flashTransferService$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final FlashTransferService invoke() {
                py pyVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FlashTransferService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService iKernelFlashTransferService = (IKernelFlashTransferService) com.tencent.qqnt.kernel.utils.o.f359277a.a("getFlashTransferService", new Function0<IKernelFlashTransferService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$flashTransferService$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final IKernelFlashTransferService invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (IKernelFlashTransferService) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            return iQQNTWrapperSession.getFlashTransferService();
                        }
                        return null;
                    }
                });
                pyVar = KernelServiceImpl.this.serviceContent;
                if (pyVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar = null;
                }
                return new FlashTransferService(iKernelFlashTransferService, pyVar);
            }
        });
        this.guardCallback = new c();
        this.onlineCallback = new ArrayList<>();
        initInject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T check(String method, final Function0<? extends T> work) {
        py pyVar = this.serviceContent;
        if (pyVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            pyVar = null;
        }
        return (T) pyVar.e().a(SUB_TAG_Wrapper, method, new Function0<T>(work) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$check$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<T> $work;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.$work = work;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) work);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (T) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.$work.invoke();
            }
        });
    }

    private final void destroy() {
        KLog.i(KLog.f359087a, SUB_TAG_Wrapper, new Object[]{"NTSDKInit destroy\uff1a" + Log.getStackTraceString(new Exception("session destroy stack"))}, null, 4, null);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.guardCallback);
        }
        py pyVar = this.serviceContent;
        py pyVar2 = null;
        if (pyVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            pyVar = null;
        }
        pyVar.h(null);
        this.isInitComplete = false;
        IQQNTStartupSessionWrapper iQQNTStartupSessionWrapper = this.startupSessionWrapper;
        if (iQQNTStartupSessionWrapper != null) {
            iQQNTStartupSessionWrapper.stop();
        }
        IQQNTWrapperSession iQQNTWrapperSession = this.wrapperSession;
        if (iQQNTWrapperSession != null) {
            Function1<? super IQQNTWrapperSession, Unit> function1 = this.onSessionDestroyListener;
            if (function1 != null) {
                function1.invoke(iQQNTWrapperSession);
            }
            iQQNTWrapperSession.setOnMsfStatusChanged(MsfStatusType.KDISCONNECTED, MsfChangeReasonType.KUSERLOGINOUT, 0);
            Iterator<T> it = getSdkStatusStaticCallbackList().iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.kernel.api.ad) it.next()).c();
            }
        }
        dx3.b bVar = this.sBusinessModule;
        if (bVar != null) {
            bVar.stop();
        }
        getSdkStatusStaticCallbackList().clear();
        this.startupSessionWrapper = null;
        this.wrapperSession = null;
        this.buddyService.clear();
        this.groupService.clear();
        this.groupTabService.clear();
        this.liteBusinessService.clear();
        this.recentContactService.clear();
        this.msgService.clear();
        this.guildMsgService.clear();
        this.profileService.clear();
        this.searchService.clear();
        this.avatarService.clear();
        this.richMediaService.clear();
        this.baseEmojiService.clear();
        this.liteBusinessService.clear();
        this.uixConvertService.clear();
        this.storageCleanService.clear();
        this.qrService.clear();
        this.robotService.clear();
        this.groupSchoolService.clear();
        this.nearByProService.clear();
        this.albumService.clear();
        this.qzAlbumService.clear();
        this.avSdkService.clear();
        this.onlineStatusService.clear();
        py pyVar3 = this.serviceContent;
        if (pyVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
        } else {
            pyVar2 = pyVar3;
        }
        pyVar2.g();
        this.addBuddyService.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHighPriorityGroupUin() {
        long j3 = this.groupUin;
        this.groupUin = 0L;
        return j3;
    }

    private final IDependsAdapter getIDependsAdapter() {
        return new KernelServiceImpl$getIDependsAdapter$1(this);
    }

    private final b getIKernelSessionListener(Function0<Unit> complete) {
        return new b(complete);
    }

    private final InitSessionMobilePathConfig getInitSessionMobilePathConfig(String accountUin) {
        String str;
        String str2;
        String str3;
        String str4;
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
        if (sDKPrivatePath == null) {
            sDKPrivatePath = "";
        }
        String sDKPrivatePath2 = VFSAssistantUtils.getSDKPrivatePath(com.tencent.mobileqq.vfs.d.f312453c);
        if (sDKPrivatePath2 == null) {
            str = "";
        } else {
            str = sDKPrivatePath2;
        }
        String str5 = sDKPrivatePath + "shortvideo";
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        String str6 = AppConstants.SDCARD_FILE_SAVE_PATH;
        if (str6 == null) {
            str3 = "";
        } else {
            str3 = str6;
        }
        String str7 = sDKPrivatePath + accountUin + File.separator + "ptt";
        if (str7 == null) {
            str4 = "";
        } else {
            str4 = str7;
        }
        InitSessionMobilePathConfig initSessionMobilePathConfig = new InitSessionMobilePathConfig(str, str2, str4, str3, "");
        KLog.i(KLog.f359087a, SUB_TAG_Wrapper, new Object[]{"initSessionMobilePathConfig=" + initSessionMobilePathConfig}, null, 4, null);
        return initSessionMobilePathConfig;
    }

    private final CopyOnWriteArrayList<com.tencent.qqnt.kernel.api.ad> getSdkStatusStaticCallbackList() {
        return (CopyOnWriteArrayList) this.sdkStatusStaticCallbackList.getValue();
    }

    private final void initMSFCmdRegister() {
        com.tencent.qqnt.kernel.msf.b.INSTANCE.e(this.wrapperSession);
        py pyVar = this.serviceContent;
        if (pyVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            pyVar = null;
        }
        AppRuntime c16 = pyVar.c();
        if (c16 != null) {
            registProxyMessagePush(c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initService() {
        if (this.hadStartNT.compareAndSet(false, true)) {
            final IQQNTStartupSessionWrapper iQQNTStartupSessionWrapper = this.startupSessionWrapper;
            if (iQQNTStartupSessionWrapper != null) {
                com.tencent.mobileqq.startup.a.f289678s = SystemClock.elapsedRealtime();
                com.tencent.mobileqq.startup.a.f289679t = 0L;
                com.tencent.mobileqq.startup.a.f289680u = 0L;
                com.tencent.qqnt.kernel.utils.o oVar = com.tencent.qqnt.kernel.utils.o.f359277a;
                oVar.a("startNT", new Function0<Integer>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$initService$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) IQQNTStartupSessionWrapper.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Integer invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Integer.valueOf(IQQNTStartupSessionWrapper.this.start()) : (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                });
                this.isNTStartFinish.set(true);
                com.tencent.mobileqq.startup.a.f289679t = SystemClock.elapsedRealtime();
                KLog.i(KLog.f359087a, SUB_TAG_Wrapper, new Object[]{"NT initService cost=" + (com.tencent.mobileqq.startup.a.f289679t - com.tencent.mobileqq.startup.a.f289678s) + " ms"}, null, 4, null);
                oVar.a("getRecentContactService", new Function0<RecentContactService>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$initService$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final RecentContactService invoke() {
                        com.tencent.qqnt.kernel.utils.d dVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (RecentContactService) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        dVar = KernelServiceImpl.this.recentContactService;
                        return (RecentContactService) dVar.getValue();
                    }
                });
            }
            dx3.b bVar = this.sBusinessModule;
            if (bVar != null) {
                bVar.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registProxyMessagePush(AppRuntime appRuntime) {
        String[] strArr;
        Set<String> plus;
        CopyOnWriteArraySet<String> b16 = com.tencent.qqnt.kernel.msf.b.INSTANCE.b();
        dx3.g gVar = this.sSenderModule;
        if (gVar == null || (strArr = gVar.c()) == null) {
            strArr = new String[0];
        }
        plus = SetsKt___SetsKt.plus((Set) b16, (Object[]) strArr);
        registProxyMessagePush(appRuntime, plus);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void startSession(AppRuntime appRuntime, final com.tencent.qqnt.kernel.api.u uVar) {
        String valueOf;
        String str;
        com.tencent.mobileqq.inject.b bVar;
        String str2;
        com.tencent.mobileqq.inject.b bVar2;
        boolean z16;
        DeviceType deviceType;
        IQQNTStartupSessionWrapper d16;
        HashMap<String, String> hashMap;
        IQQNTWrapperSession iQQNTWrapperSession;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        com.tencent.mobileqq.inject.b bVar3;
        Integer num;
        dx3.f fVar;
        boolean z17;
        HashMap<String, String> hashMap2;
        py pyVar;
        py pyVar2;
        dx3.a aVar;
        GuardManager guardManager;
        dx3.b bVar4;
        String str11;
        boolean z18;
        int lastIndexOf$default;
        com.tencent.qqnt.kernel.utils.h.f359261a.b();
        String currentUin2 = appRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin2, "this.currentUin");
        currentUin = currentUin2;
        if (kernelPath == null) {
            String it = appRuntime.getApp().getFilesDir().getPath();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) it, "/", 0, false, 6, (Object) null);
            String substring = it.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            kernelPath = substring + SYS_PATH_SUFFIX;
        }
        String str12 = kernelPath;
        Companion companion = INSTANCE;
        List<String> h16 = companion.h(appRuntime);
        final WeakReference weakReference = new WeakReference(appRuntime);
        if (supportUid) {
            String currentUid = appRuntime.getCurrentUid();
            if (currentUid != null && currentUid.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18) {
                valueOf = companion.j(appRuntime.getCurrentUid());
                str = "gpro_v1-6_" + valueOf + DBBackupServiceImpl.DB_FILE_SUFFIX;
                bVar = this.sAppSetting;
                if (bVar == null) {
                    str2 = bVar.getReportVersionName();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "1.1";
                }
                String str13 = str2;
                bVar2 = this.sAppSetting;
                if (bVar2 == null) {
                    z16 = bVar2.h(appRuntime.getApplicationContext());
                } else {
                    z16 = false;
                }
                if (!z16) {
                    deviceType = DeviceType.KPAD;
                } else {
                    deviceType = DeviceType.KPHONE;
                }
                DeviceType deviceType2 = deviceType;
                d16 = com.tencent.qqnt.ntstartup.nativeinterface.a.d();
                if (d16 == null) {
                    hashMap = d16.getSessionIdList();
                } else {
                    hashMap = null;
                }
                if (hashMap == null && (str11 = hashMap.get(StartupSessionConstant.KNTMODULENAME)) != null) {
                    iQQNTWrapperSession = com.tencent.qqnt.kernel.nativeinterface.cl.i0(str11);
                } else {
                    iQQNTWrapperSession = null;
                }
                initMSFCmdRegister();
                Intrinsics.checkNotNull(iQQNTWrapperSession);
                long longAccountUin = appRuntime.getLongAccountUin();
                if (valueOf == null) {
                    valueOf = "";
                }
                if (str12 != null) {
                    str3 = "";
                } else {
                    str3 = str12;
                }
                if (str12 != null) {
                    str4 = "";
                } else {
                    str4 = str12;
                }
                if (str == null) {
                    str = "";
                }
                str5 = h16.get(0);
                if (str5 == null) {
                    str5 = "";
                }
                str6 = h16.get(1);
                if (str6 == null) {
                    str6 = "";
                }
                str7 = h16.get(2);
                if (str7 == null) {
                    str7 = "";
                }
                PlatformType platformType = PlatformType.KANDROID;
                RDeliveryConfig rDeliveryConfig = new RDeliveryConfig("", 0, "", "", 0, "", "", "", "", "", "", "", new ArrayList());
                str8 = AppConstants.SDCARD_FILE_SAVE_PATH;
                if (str8 != null) {
                    str9 = "";
                } else {
                    str9 = str8;
                }
                if (str8 != null) {
                    str10 = "";
                } else {
                    str10 = str8;
                }
                InitSessionDesktopPathConfig initSessionDesktopPathConfig = new InitSessionDesktopPathConfig();
                String currentUin3 = appRuntime.getCurrentUin();
                Intrinsics.checkNotNullExpressionValue(currentUin3, "currentUin");
                InitSessionMobilePathConfig initSessionMobilePathConfig = getInitSessionMobilePathConfig(currentUin3);
                bVar3 = this.sAppSetting;
                if (bVar3 == null) {
                    num = Integer.valueOf(bVar3.getAppId());
                } else {
                    num = null;
                }
                String valueOf2 = String.valueOf(num);
                fVar = this.sRelationModule;
                if (fVar == null) {
                    z17 = fVar.refreshAndCheckIsNtDataService();
                } else {
                    z17 = false;
                }
                IQQNTWrapperSession iQQNTWrapperSession2 = iQQNTWrapperSession;
                hashMap2 = hashMap;
                iQQNTWrapperSession2.init(new InitSessionConfig(longAccountUin, valueOf, str3, str4, str, str13, str5, str6, str7, "", platformType, deviceType2, "", rDeliveryConfig, str9, str10, initSessionDesktopPathConfig, initSessionMobilePathConfig, valueOf2, null, "", z17), getIDependsAdapter(), new d(), getIKernelSessionListener(new Function0<Unit>(weakReference, uVar, this) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$startSession$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ WeakReference<AppRuntime> $appRef;
                    final /* synthetic */ com.tencent.qqnt.kernel.api.u $listener;
                    final /* synthetic */ KernelServiceImpl this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$appRef = weakReference;
                        this.$listener = uVar;
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, weakReference, uVar, this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        py pyVar3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        AppRuntime appRuntime2 = this.$appRef.get();
                        if (appRuntime2 != null) {
                            com.tencent.qqnt.kernel.api.u uVar2 = this.$listener;
                            KernelServiceImpl kernelServiceImpl = this.this$0;
                            if (uVar2 != null) {
                                uVar2.a(appRuntime2);
                            }
                            pyVar3 = kernelServiceImpl.serviceContent;
                            if (pyVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                                pyVar3 = null;
                            }
                            pyVar3.h("0");
                            kernelServiceImpl.isInitComplete = true;
                            com.tencent.qqnt.kernel.utils.h.f359261a.a();
                        }
                    }
                }));
                this.wrapperSession = iQQNTWrapperSession2;
                pyVar = this.serviceContent;
                if (pyVar != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                    pyVar2 = null;
                } else {
                    pyVar2 = pyVar;
                }
                pyVar2.h(iQQNTWrapperSession2.getSessionId());
                KLog.i(KLog.f359087a, SUB_TAG_Wrapper, new Object[]{TuplesKt.to("method", "startSession"), TuplesKt.to("curSessionId", iQQNTWrapperSession2.getSessionId()), TuplesKt.to("path", str12)}, null, 4, null);
                if (hashMap2 != null && (bVar4 = this.sBusinessModule) != null) {
                    bVar4.initBusinessModule(hashMap2);
                }
                this.startupSessionWrapper = d16;
                initService();
                if (uVar != null) {
                    uVar.b(appRuntime);
                }
                IKernelService.b.a(this, MsfStatusType.KCONNECTED, MsfChangeReasonType.KUSERLOGININ, 0, 4, null);
                aVar = sAccountModule;
                if (aVar != null) {
                    aVar.a(appRuntime, iQQNTWrapperSession2);
                }
                guardManager = GuardManager.sInstance;
                if (guardManager == null) {
                    guardManager.registerCallBack(this.guardCallback);
                    return;
                }
                return;
            }
        }
        valueOf = String.valueOf(appRuntime.getLongAccountUin());
        str = "gpro_v1-6_" + valueOf + DBBackupServiceImpl.DB_FILE_SUFFIX;
        bVar = this.sAppSetting;
        if (bVar == null) {
        }
        if (str2 == null) {
        }
        String str132 = str2;
        bVar2 = this.sAppSetting;
        if (bVar2 == null) {
        }
        if (!z16) {
        }
        DeviceType deviceType22 = deviceType;
        d16 = com.tencent.qqnt.ntstartup.nativeinterface.a.d();
        if (d16 == null) {
        }
        if (hashMap == null) {
        }
        iQQNTWrapperSession = null;
        initMSFCmdRegister();
        Intrinsics.checkNotNull(iQQNTWrapperSession);
        long longAccountUin2 = appRuntime.getLongAccountUin();
        if (valueOf == null) {
        }
        if (str12 != null) {
        }
        if (str12 != null) {
        }
        if (str == null) {
        }
        str5 = h16.get(0);
        if (str5 == null) {
        }
        str6 = h16.get(1);
        if (str6 == null) {
        }
        str7 = h16.get(2);
        if (str7 == null) {
        }
        PlatformType platformType2 = PlatformType.KANDROID;
        RDeliveryConfig rDeliveryConfig2 = new RDeliveryConfig("", 0, "", "", 0, "", "", "", "", "", "", "", new ArrayList());
        str8 = AppConstants.SDCARD_FILE_SAVE_PATH;
        if (str8 != null) {
        }
        if (str8 != null) {
        }
        InitSessionDesktopPathConfig initSessionDesktopPathConfig2 = new InitSessionDesktopPathConfig();
        String currentUin32 = appRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin32, "currentUin");
        InitSessionMobilePathConfig initSessionMobilePathConfig2 = getInitSessionMobilePathConfig(currentUin32);
        bVar3 = this.sAppSetting;
        if (bVar3 == null) {
        }
        String valueOf22 = String.valueOf(num);
        fVar = this.sRelationModule;
        if (fVar == null) {
        }
        IQQNTWrapperSession iQQNTWrapperSession22 = iQQNTWrapperSession;
        hashMap2 = hashMap;
        iQQNTWrapperSession22.init(new InitSessionConfig(longAccountUin2, valueOf, str3, str4, str, str132, str5, str6, str7, "", platformType2, deviceType22, "", rDeliveryConfig2, str9, str10, initSessionDesktopPathConfig2, initSessionMobilePathConfig2, valueOf22, null, "", z17), getIDependsAdapter(), new d(), getIKernelSessionListener(new Function0<Unit>(weakReference, uVar, this) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$startSession$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ WeakReference<AppRuntime> $appRef;
            final /* synthetic */ com.tencent.qqnt.kernel.api.u $listener;
            final /* synthetic */ KernelServiceImpl this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$appRef = weakReference;
                this.$listener = uVar;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, weakReference, uVar, this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                py pyVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime appRuntime2 = this.$appRef.get();
                if (appRuntime2 != null) {
                    com.tencent.qqnt.kernel.api.u uVar2 = this.$listener;
                    KernelServiceImpl kernelServiceImpl = this.this$0;
                    if (uVar2 != null) {
                        uVar2.a(appRuntime2);
                    }
                    pyVar3 = kernelServiceImpl.serviceContent;
                    if (pyVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                        pyVar3 = null;
                    }
                    pyVar3.h("0");
                    kernelServiceImpl.isInitComplete = true;
                    com.tencent.qqnt.kernel.utils.h.f359261a.a();
                }
            }
        }));
        this.wrapperSession = iQQNTWrapperSession22;
        pyVar = this.serviceContent;
        if (pyVar != null) {
        }
        pyVar2.h(iQQNTWrapperSession22.getSessionId());
        KLog.i(KLog.f359087a, SUB_TAG_Wrapper, new Object[]{TuplesKt.to("method", "startSession"), TuplesKt.to("curSessionId", iQQNTWrapperSession22.getSessionId()), TuplesKt.to("path", str12)}, null, 4, null);
        if (hashMap2 != null) {
            bVar4.initBusinessModule(hashMap2);
        }
        this.startupSessionWrapper = d16;
        initService();
        if (uVar != null) {
        }
        IKernelService.b.a(this, MsfStatusType.KCONNECTED, MsfChangeReasonType.KUSERLOGININ, 0, 4, null);
        aVar = sAccountModule;
        if (aVar != null) {
        }
        guardManager = GuardManager.sInstance;
        if (guardManager == null) {
        }
    }

    private final void unregistProxyMessagePush(AppRuntime appRuntime) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.qqnt.kernel.msf.b.class);
        newIntent.putExtra("action", 1026);
        com.tencent.mobileqq.inject.b bVar = this.sAppSetting;
        Intrinsics.checkNotNull(bVar);
        newIntent.putExtra("appid", bVar.getAppId());
        newIntent.putExtra("processName", appRuntime.getApplication().getQQProcessName());
        newIntent.runNow = true;
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.e getAVSDKService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (com.tencent.qqnt.kernel.api.e) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.e) this.avSdkService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.f getAddOrDelBuddyService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.kernel.api.f) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.f) this.addBuddyService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.g getAlbumService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (com.tencent.qqnt.kernel.api.g) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.g) this.albumService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.h getAvatarService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.qqnt.kernel.api.h) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.h) this.avatarService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.i getBaseEmojiService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.qqnt.kernel.api.i) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.i) this.baseEmojiService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.k getBatchUploadService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (com.tencent.qqnt.kernel.api.k) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.k) this.batchUploadService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public ArrayList<String> getCacheErrLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (ArrayList) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        return (ArrayList) check("getCacheErrLog", new Function0<ArrayList<String>>() { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$getCacheErrLog$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ArrayList<String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                if (iQQNTWrapperSession != null) {
                    return iQQNTWrapperSession.getCacheErrLog();
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.q getFlashTransferService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (com.tencent.qqnt.kernel.api.q) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.q) this.flashTransferService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.r getGroupSchoolService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (com.tencent.qqnt.kernel.api.r) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.r) this.groupSchoolService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IKernelGroupTabService getGroupTabService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (IKernelGroupTabService) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (IKernelGroupTabService) this.groupTabService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.t getGuildMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.qqnt.kernel.api.t) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.t) this.guildMsgService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IKernelLiteBusinessService getLiteBusinessService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (IKernelLiteBusinessService) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (IKernelLiteBusinessService) this.liteBusinessService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.x getNearbyProService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (com.tencent.qqnt.kernel.api.x) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.x) this.nearByProService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IKernelOnlineStatusService getOnlineStatusService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (IKernelOnlineStatusService) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (IKernelOnlineStatusService) this.onlineStatusService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IKernelQRService getQRService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (IKernelQRService) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (IKernelQRService) this.qrService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.z getQZAlbumxService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (com.tencent.qqnt.kernel.api.z) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.z) this.qzAlbumService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.ab getRichMediaService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.qqnt.kernel.api.ab) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.ab) this.richMediaService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.ac getRobotService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (com.tencent.qqnt.kernel.api.ac) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.ac) this.robotService.getValue();
        }
        return null;
    }

    @Nullable
    public final com.tencent.mobileqq.inject.b getSAppSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.inject.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sAppSetting;
    }

    @Nullable
    public final dx3.g getSSenderModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (dx3.g) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sSenderModule;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.ae getSearchService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.qqnt.kernel.api.ae) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.ae) this.searchService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IKernelSettingService getSettingService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IKernelSettingService) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (IKernelSettingService) this.settingService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.af getStorageCleanService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (com.tencent.qqnt.kernel.api.af) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.af) this.storageCleanService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public com.tencent.qqnt.kernel.api.ag getUixConvertService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.qqnt.kernel.api.ag) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.ag) this.uixConvertService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IKernelUnifySearchService getUnifySearchService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (IKernelUnifySearchService) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession != null && this.isNTStartFinish.get()) {
            return (IKernelUnifySearchService) this.unifySearchService.getValue();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public IQQNTWrapperSession getWrapperSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (IQQNTWrapperSession) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.wrapperSession;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void init(boolean useUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, useUid);
        } else {
            supportUid = useUid;
        }
    }

    @QAutoInitMethod
    public final void initInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(sAppSetting_AutoGenClazzList_QAutoInjectTransform);
        this.sRelationModule = (dx3.f) com.tencent.mobileqq.qroute.utils.b.a(sRelationModule_AutoGenClazzList_QAutoInjectTransform);
        com.tencent.mobileqq.qroute.utils.b.c(onlineCallback_AutoGenClazzList_QAutoInjectTransform, this.onlineCallback);
        this.sSenderModule = (dx3.g) com.tencent.mobileqq.qroute.utils.b.a(sSenderModule_AutoGenClazzList_QAutoInjectTransform);
        this.sBusinessModule = (dx3.b) com.tencent.mobileqq.qroute.utils.b.a(sBusinessModule_AutoGenClazzList_QAutoInjectTransform);
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void initSdkStatusStaticCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        for (com.tencent.qqnt.kernel.api.ad adVar : getSdkStatusStaticCallbackList()) {
            py pyVar = this.serviceContent;
            if (pyVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                pyVar = null;
            }
            adVar.a(pyVar.c());
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public boolean isDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return this.isDestroy;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public boolean isInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.isInitComplete;
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void offLine(@NotNull final UnregisterInfo unregisterInfo, @NotNull final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) unregisterInfo, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(unregisterInfo, "unregisterInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        check("offLine", new Function0<Unit>(unregisterInfo, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$offLine$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $cb;
            final /* synthetic */ UnregisterInfo $unregisterInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$unregisterInfo = unregisterInfo;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, KernelServiceImpl.this, unregisterInfo, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                KernelServiceImpl.this.initService();
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                if (iQQNTWrapperSession == null) {
                    return null;
                }
                iQQNTWrapperSession.offLine(this.$unregisterInfo, this.$cb);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public boolean offLineSync(final boolean userTrigger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, userTrigger)).booleanValue();
        }
        Boolean bool = (Boolean) check("offLineSync", new Function0<Boolean>(userTrigger) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$offLineSync$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $userTrigger;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$userTrigger = userTrigger;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, KernelServiceImpl.this, Boolean.valueOf(userTrigger));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Boolean invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                KernelServiceImpl.this.initService();
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                if (iQQNTWrapperSession != null) {
                    return Boolean.valueOf(iQQNTWrapperSession.offLineSync(this.$userTrigger));
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        this.serviceContent = new py(appRuntime);
        if (appRuntime != null) {
            appRuntime.addWithoutPostObserver(com.tencent.qqnt.kernel.msf.e.class);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        } else {
            this.isDestroy = true;
            destroy();
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void onLine(@NotNull final RegisterInfo registerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) registerInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(registerInfo, "registerInfo");
        KLog.i(KLog.f359087a, SUB_TAG_Wrapper, new Object[]{"onLine\uff1a" + registerInfo}, null, 4, null);
        check("onLine", new Function0<Unit>(registerInfo) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$onLine$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ RegisterInfo $registerInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$registerInfo = registerInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this, (Object) registerInfo);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                KernelServiceImpl.this.initService();
                IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                if (iQQNTWrapperSession == null) {
                    return null;
                }
                iQQNTWrapperSession.onLine(this.$registerInfo);
                return Unit.INSTANCE;
            }
        });
    }

    public final void registerCmdCallback(@NotNull AppRuntime appRuntime) {
        String[] strArr;
        Set plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "<this>");
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.qqnt.kernel.msf.b.class);
        newIntent.putExtra("action", 1040);
        CopyOnWriteArraySet<String> b16 = com.tencent.qqnt.kernel.msf.b.INSTANCE.b();
        dx3.g gVar = this.sSenderModule;
        if (gVar == null || (strArr = gVar.c()) == null) {
            strArr = new String[0];
        }
        plus = SetsKt___SetsKt.plus((Set) b16, (Object[]) strArr);
        Object[] array = plus.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        newIntent.putExtra("pushCommands", (String[]) array);
        newIntent.runNow = true;
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void setHighPriorityGroupUin(long groupUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, groupUin);
            return;
        }
        this.groupUin = groupUin;
        if (QLog.isDevelopLevel()) {
            QLog.d(LOG_TAG, 4, "setHighPriorityGroupUin: " + groupUin);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void setOnMsfStatusChanged(@NotNull final MsfStatusType status, @NotNull final MsfChangeReasonType reason, final int connSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, status, reason, Integer.valueOf(connSeq));
            return;
        }
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        check("setOnMsfStatusChanged", new Function0<Unit>(connSeq, this, reason) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$setOnMsfStatusChanged$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $connSeq;
            final /* synthetic */ MsfChangeReasonType $reason;
            final /* synthetic */ KernelServiceImpl this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$connSeq = connSeq;
                this.this$0 = this;
                this.$reason = reason;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsfStatusType.this, Integer.valueOf(connSeq), this, reason);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QLog.i("KernelServiceImpl", 1, "setOnMsfStatusChanged: " + MsfStatusType.this + ", connSeq: " + this.$connSeq);
                GuardManager guardManager = GuardManager.sInstance;
                if (guardManager != null) {
                    if (guardManager.isApplicationForeground()) {
                        IQQNTWrapperSession iQQNTWrapperSession = this.this$0.wrapperSession;
                        if (iQQNTWrapperSession != null) {
                            iQQNTWrapperSession.switchToFront();
                        }
                    } else {
                        IQQNTWrapperSession iQQNTWrapperSession2 = this.this$0.wrapperSession;
                        if (iQQNTWrapperSession2 != null) {
                            iQQNTWrapperSession2.switchToBackGround();
                        }
                    }
                }
                IQQNTWrapperSession iQQNTWrapperSession3 = this.this$0.wrapperSession;
                if (iQQNTWrapperSession3 == null) {
                    return null;
                }
                iQQNTWrapperSession3.setOnMsfStatusChanged(MsfStatusType.this, this.$reason, this.$connSeq);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void setOnNetworkChanged(@NotNull final NetStatusType status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) status);
        } else {
            Intrinsics.checkNotNullParameter(status, "status");
            check("setOnNetworkChanged", new Function0<Unit>(status) { // from class: com.tencent.qqnt.kernel.api.impl.KernelServiceImpl$setOnNetworkChanged$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ NetStatusType $status;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$status = status;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelServiceImpl.this, (Object) status);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IQQNTWrapperSession iQQNTWrapperSession = KernelServiceImpl.this.wrapperSession;
                    if (iQQNTWrapperSession == null) {
                        return null;
                    }
                    iQQNTWrapperSession.setOnNetworkChanged(this.$status);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void setSAppSetting(@Nullable com.tencent.mobileqq.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.sAppSetting = bVar;
        }
    }

    public final void setSSenderModule(@Nullable dx3.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
        } else {
            this.sSenderModule = gVar;
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void setSessionDestroyListener(@Nullable Function1<? super IQQNTWrapperSession, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) listener);
        } else {
            this.onSessionDestroyListener = listener;
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IKernelService
    public void start(@Nullable com.tencent.qqnt.kernel.api.u listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) listener);
            return;
        }
        if (this.wrapperSession != null) {
            return;
        }
        py pyVar = this.serviceContent;
        if (pyVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            pyVar = null;
        }
        AppRuntime c16 = pyVar.c();
        if (c16 != null) {
            startSession(c16, listener);
        }
    }

    private final void registProxyMessagePush(AppRuntime appRuntime, Set<String> set) {
        NewIntent newIntent = new NewIntent(appRuntime.getApp().getApplicationContext(), com.tencent.qqnt.kernel.msf.b.class);
        newIntent.putExtra("action", 1025);
        com.tencent.mobileqq.inject.b bVar = this.sAppSetting;
        Intrinsics.checkNotNull(bVar);
        newIntent.putExtra("appid", bVar.getAppId());
        newIntent.putExtra("processName", appRuntime.getApplication().getQQProcessName());
        newIntent.putExtra("broadcastName", BaseApplicationImpl.bootBroadcastName);
        Object[] array = set.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        newIntent.putExtra("commands", (String[]) array);
        appRuntime.startServlet(newIntent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public BdhUploadService getBdhUploadService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (BdhUploadService) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (BdhUploadService) this.bdhUploadService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public BuddyService getBuddyService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BuddyService) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (BuddyService) this.buddyService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public EmojiService getEmojiService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (EmojiService) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (EmojiService) this.emojiService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public ha getFileBridgeService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ha) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (ha) this.fileBridgeService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public GroupService getGroupService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (GroupService) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (GroupService) this.groupService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public MsgService getMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MsgService) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (MsgService) this.msgService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public ProfileService getProfileService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ProfileService) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (ProfileService) this.profileService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public RecentContactService getRecentContactService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (RecentContactService) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (RecentContactService) this.recentContactService.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.api.IKernelService
    @Nullable
    public qc getWifiPhotoHostService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (qc) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        checkCallerThread();
        if (this.wrapperSession == null || !this.isNTStartFinish.get()) {
            return null;
        }
        return (qc) this.wifiPhotoHostService.getValue();
    }

    private final void checkCallerThread() {
    }
}

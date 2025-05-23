package com.tencent.mobileqq.zootopia.download;

import android.app.Activity;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaExtraData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager;
import com.tencent.mobileqq.zootopia.download.notification.ZPlanModDownloadNotification;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper;
import com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanFloatWindowManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.utils.ZplanImageDownloader;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import pb3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J<\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0006H\u0002J0\u0010\u0012\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\"\u0010\u001b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J4\u0010!\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002J\u0012\u0010'\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J.\u0010.\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002J\u001c\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u0002002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0010\u00103\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0002J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u00107\u001a\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f05H\u0002J\b\u00108\u001a\u00020\u0002H\u0002J\b\u00109\u001a\u00020\u0002H\u0002J\b\u0010:\u001a\u00020\u0002H\u0002J\u0018\u0010=\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0004H\u0002J\b\u0010>\u001a\u00020\u0002H\u0002J\u0016\u0010@\u001a\u00020\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\t05H\u0002J\u0016\u0010A\u001a\u00020\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\t05H\u0002J\u0016\u0010B\u001a\u00020\u00042\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\t05H\u0002J8\u0010G\u001a\u00020\u00042.\u0010F\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040D0Cj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040D`EH\u0002J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH\u0002J\u0010\u0010J\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010M\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010N\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0006H\u0002J\"\u0010Q\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u00062\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0006J.\u0010S\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u0010R\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020\u0004J.\u0010U\u001a\u00020\u00022\u0006\u00101\u001a\u0002002\b\b\u0002\u0010T\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020\u0004J\u0006\u0010V\u001a\u00020\u0004J\u000e\u0010W\u001a\u00020\u00042\u0006\u00101\u001a\u000200J\u0016\u0010Z\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020XJ\u0018\u0010\\\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010[\u001a\u00020\u0004J\u000e\u0010]\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006J$\u0010`\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010_\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00020^J \u0010a\u001a\u00020\u00022\u0018\u0010_\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f05\u0012\u0004\u0012\u00020\u00020^J \u0010c\u001a\u00020\u00022\u0018\u0010_\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020b05\u0012\u0004\u0012\u00020\u00020^J$\u0010d\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010_\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010b\u0012\u0004\u0012\u00020\u00020^J,\u0010f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00042\u0014\u0010_\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010b\u0012\u0004\u0012\u00020\u00020^J\u0006\u0010g\u001a\u00020\u000bJ\u000e\u0010i\u001a\u00020\u00022\u0006\u0010L\u001a\u00020hJ\u000e\u0010j\u001a\u00020\u00022\u0006\u0010L\u001a\u00020hJ\u0006\u0010k\u001a\u00020\u0002J\u0016\u0010m\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006J\u000e\u0010n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010p\u001a\u00020\u00022\u0006\u0010L\u001a\u00020oJ\u000e\u0010q\u001a\u00020\u00022\u0006\u0010L\u001a\u00020oJ\u001a\u0010r\u001a\u00020\u00022\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020^J\u000e\u0010s\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010t\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010u\u001a\u00020\u0004R\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020o0z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u0081\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R,\u0010\u0085\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010z0\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R'\u0010\u008c\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00060Cj\b\u0012\u0004\u0012\u00020\u0006`E8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010\u008e\u0001\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u0080\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010fR\u0018\u0010\u0092\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010fR>\u0010F\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040D0Cj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040D`E8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u008b\u0001R\u0017\u0010\u0095\u0001\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0080\u0001R(\u0010\u009b\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0096\u0001\u0010f\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\u00a3\u0001\u001a\u00030\u00a0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R5\u0010\u00a8\u0001\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020X0\u00a4\u0001j\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020X`\u00a5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u0018\u0010\u00aa\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a9\u0001\u0010fR\u0014\u0010\u00ad\u0001\u001a\u00020\u000b8F\u00a2\u0006\b\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u00a8\u0006\u00b0\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadManager;", "", "", "g0", "", "isTaskFinished", "", "dtEventKey", "id", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "errorCode", "subErrorCode", "G0", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "data", "", "L", "Q0", "R0", "t0", "C0", ExifInterface.LATITUDE_SOUTH, VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "progress", "r0", "q0", "isSuccess", ImageTaskConst.FAIL_CODE, "failMsg", "isDownloadMod", "p0", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "M", "l0", "e0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mapId", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", "Lcom/tencent/mobileqq/zootopia/download/w;", "mapDownloadListener", "shouldOverride4gDialog", "B0", "A0", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "T", "P0", "O", "", "downloadingList", "S0", "u0", "v0", "w0", "downloadTask", "needResumeWhenNetReady", "z0", "J", "taskList", "j0", "n0", "h0", "Ljava/util/HashSet;", "Lkotlin/Pair;", "Lkotlin/collections/HashSet;", "netResumeSet", "i0", "originNotifyDownloadingCount", "U", "J0", "modId", "listener", "I", "F0", "mapName", "hintTxt", "d0", "forceReDownload", "N0", "withoutCheck", "L0", "m0", "P", "", "size", "o0", "startNext", "x0", "I0", "Lkotlin/Function1;", "callback", "c0", "W", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "V", "Y", "forceSearchDb", "Z", "a0", "Lcom/tencent/mobileqq/zootopia/download/ah;", "G", "D0", "T0", "version", "V0", "N", "Lpb3/a;", "H", "E0", "K", "f0", "U0", "k0", "Lcom/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy;", "b", "Lcom/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy;", "downloadManagerProxy", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/lang/Object;", "d", "Ljava/lang/Object;", "modDownloadListenerLock", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "modDownloadListenerMap", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", "f", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", "mapStatusService", "g", "Ljava/util/HashSet;", "downloadingSet", tl.h.F, "downloadCountLock", "i", "isRegisterReceiver", "j", "haveTryResume", "k", "l", "netLock", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b0", "()Z", "K0", "(Z)V", "needCheckerNet", "Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadReceiver;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadReceiver;", "receiver", "Lid3/d;", "o", "Lid3/d;", "reporter", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "p", "Ljava/util/HashMap;", "costHashMap", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isManualPause", "X", "()I", "currentDownloadCount", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZootopiaDownloadManager f327992a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanModDownloadManagerProxy downloadManagerProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<pb3.a> listeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Object modDownloadListenerLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<w>> modDownloadListenerMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ZootopiaMapStatusService mapStatusService;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<String> downloadingSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Object downloadCountLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isRegisterReceiver;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean haveTryResume;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final HashSet<Pair<String, Boolean>> netResumeSet;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final Object netLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean needCheckerNet;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final ZootopiaDownloadReceiver receiver;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final id3.d reporter;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Long> costHashMap;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static boolean isManualPause;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadManager$a", "Lcom/tencent/mobileqq/zootopia/download/ui/b;", "", "p0", "", "onNetWifi2Mobile", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "onNetNone2Mobile", "onNetNone2Wifi", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends com.tencent.mobileqq.zootopia.download.ui.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            ZootopiaDownloadManager.f327992a.u0();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String p06) {
            QLog.i("Zootopia_DownloadManager", 1, "NetChangeCallback# onNetMobile2Wifi - " + p06);
            ZootopiaDownloadManager.f327992a.w0();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String p06) {
            QLog.i("Zootopia_DownloadManager", 1, "NetChangeCallback# onNetNone2Mobile - " + p06);
            ZootopiaDownloadManager.f327992a.w0();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String p06) {
            QLog.i("Zootopia_DownloadManager", 1, "NetChangeCallback# onNetNone2Wifi - " + p06);
            ZootopiaDownloadManager.f327992a.w0();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String p06) {
            QLog.i("Zootopia_DownloadManager", 1, "NetChangeCallback# onNetWifi2Mobile - " + p06);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaDownloadManager.a.b();
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            QLog.i("Zootopia_DownloadManager", 1, "NetChangeCallback# onNetMobile2None");
            ZootopiaDownloadManager.f327992a.v0();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            QLog.i("Zootopia_DownloadManager", 1, "NetChangeCallback# onNetWifi2None");
            ZootopiaDownloadManager.f327992a.v0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadManager$b", "Lcom/tencent/mobileqq/zootopia/download/normal/g;", "", "count", "", "onDownloadingCountChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.download.normal.g {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.download.normal.g
        public void onDownloadingCountChanged(int count) {
            Iterator it = ZootopiaDownloadManager.listeners.iterator();
            while (it.hasNext()) {
                ((pb3.a) it.next()).onDownloadingCountChanged(ZootopiaDownloadManager.f327992a.U(count));
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328009a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_NEED_UPDATE_QQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_HIGHER_QQ_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_MAINTAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_OFF_SHELF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_PHONE_MODEL_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f328009a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadManager$d", "Lti3/a;", "", "downloadText", "launchText", "", "c", "modConfigJson", "", FavEmoConstant.ROAMING_TYPE_PANEL, "b", "progressTitle", "", "progress", "onProgress", "", "errorCode", "errorMessage", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ti3.a {
        d() {
        }

        @Override // ti3.a
        public void a(int errorCode, String errorMessage) {
            QLog.e("Zootopia_DownloadManager", 4, "onCheckFailed :: errorCode == " + errorCode + " , errorMessage == " + errorMessage);
        }

        @Override // ti3.a
        public void b(String modConfigJson, boolean needDownload) {
            Intrinsics.checkNotNullParameter(modConfigJson, "modConfigJson");
            QLog.i("Zootopia_DownloadManager", 1, "startDownloadCommonMod :: onCheckComplete , modConfigJson == " + modConfigJson);
        }

        @Override // ti3.a
        public void c(String downloadText, String launchText) {
            Intrinsics.checkNotNullParameter(downloadText, "downloadText");
            Intrinsics.checkNotNullParameter(launchText, "launchText");
            QLog.i("Zootopia_DownloadManager", 1, "startDownloadCommonMod :: onProgressConfig , downloadText == " + downloadText);
        }

        @Override // ti3.a
        public void onProgress(String progressTitle, float progress) {
            Intrinsics.checkNotNullParameter(progressTitle, "progressTitle");
            QLog.i("Zootopia_DownloadManager", 4, "startDownloadCommonMod :: onProgress , progress == " + progress);
        }
    }

    static {
        ZootopiaDownloadManager zootopiaDownloadManager = new ZootopiaDownloadManager();
        f327992a = zootopiaDownloadManager;
        ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = new ZPlanModDownloadManagerProxy();
        downloadManagerProxy = zPlanModDownloadManagerProxy;
        listeners = new CopyOnWriteArrayList<>();
        modDownloadListenerLock = new Object();
        modDownloadListenerMap = new ConcurrentHashMap<>();
        mapStatusService = new ZootopiaMapStatusService();
        downloadingSet = new HashSet<>();
        downloadCountLock = new Object();
        netResumeSet = new HashSet<>();
        netLock = new Object();
        needCheckerNet = true;
        receiver = new ZootopiaDownloadReceiver();
        reporter = new id3.d(null, 1, null);
        costHashMap = new HashMap<>();
        QLog.i("Zootopia_DownloadManager", 1, "init ZootopiaDownloadManager");
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, new a());
        zootopiaDownloadManager.g0();
        zPlanModDownloadManagerProxy.E(new b());
        zPlanModDownloadManagerProxy.F(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String id5) {
                Intrinsics.checkNotNullParameter(id5, "id");
                QLog.e("Zootopia_DownloadManager", 1, "notify taskDeletedListener - " + id5);
                Iterator it = ZootopiaDownloadManager.listeners.iterator();
                while (it.hasNext()) {
                    ((pb3.a) it.next()).onTaskDelete(id5);
                }
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new ZootopiaDownloadManagerInitEvent());
    }

    ZootopiaDownloadManager() {
    }

    private final void A0(ZootopiaMapStatusService.MapStatusInfoResult result) {
        String str;
        String str2;
        ZootopiaExtraData extraData;
        ZootopiaMapLoadingParams loadingParams;
        ZootopiaDownloadData data = result.getData();
        pu4.g loadingBackgroundMaterial = (data == null || (extraData = data.getExtraData()) == null || (loadingParams = extraData.getLoadingParams()) == null) ? null : loadingParams.loadingBackgroundMaterial();
        QLog.d("Zootopia_DownloadManager", 1, "preloadModPng, " + loadingBackgroundMaterial);
        if (loadingBackgroundMaterial != null && (str2 = loadingBackgroundMaterial.f427434a) != null) {
            ZplanImageDownloader.f373239a.g(str2);
        }
        if (loadingBackgroundMaterial == null || (str = loadingBackgroundMaterial.f427436c) == null) {
            return;
        }
        ZplanImageDownloader.f373239a.g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        if (S()) {
            QLog.e("Zootopia_DownloadManager", 1, "registerReceiver but not main process");
            return;
        }
        if (isRegisterReceiver) {
            return;
        }
        QLog.i("Zootopia_DownloadManager", 1, "registerReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("zootopia_download_receiver");
        BaseApplication.context.registerReceiver(receiver, intentFilter);
        isRegisterReceiver = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(String modId) {
        QLog.i("Zootopia_DownloadManager", 1, "removeSingleModDownloadListener - " + modId);
        synchronized (modDownloadListenerLock) {
            modDownloadListenerMap.remove(modId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(final boolean isTaskFinished, final String dtEventKey, String id5, final x task, final int errorCode, final String subErrorCode) {
        QLog.i("Zootopia_DownloadManager", 1, "download DTReport " + dtEventKey + " - id= " + id5 + " - isSilent: " + task.getIsSilentDownload());
        c0(id5, new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$report$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                Map<String, Object> mutableMapOf;
                Map<? extends String, ? extends Object> L;
                id3.d dVar;
                if (zootopiaResData == null) {
                    return;
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("mapId", Integer.valueOf(zootopiaResData.getId())), new Pair("version", zootopiaResData.getVersion()), new Pair("beginTime", Long.valueOf(zootopiaResData.getStartTime())), new Pair("completeTime", Long.valueOf(zootopiaResData.getCompleteTime())), new Pair("url", zootopiaResData.getUrl()), new Pair("errCode", Integer.valueOf(errorCode)), new Pair("subErrCode", subErrorCode));
                L = ZootopiaDownloadManager.f327992a.L(zootopiaResData, task, errorCode);
                mutableMapOf.putAll(L);
                HashMap<String, Object> d16 = com.tencent.sqshow.zootopia.report.a.f372690a.d(zootopiaResData.getId(), isTaskFinished);
                if (d16.size() > 0) {
                    mutableMapOf.putAll(d16);
                }
                ZootopiaDownloadManager.isManualPause = false;
                dVar = ZootopiaDownloadManager.reporter;
                dVar.d(dtEventKey, mutableMapOf);
            }
        });
    }

    private final void I(String modId, w listener) {
        if (TextUtils.isEmpty(modId) || listener == null) {
            return;
        }
        synchronized (modDownloadListenerLock) {
            ConcurrentHashMap<String, CopyOnWriteArrayList<w>> concurrentHashMap = modDownloadListenerMap;
            CopyOnWriteArrayList<w> copyOnWriteArrayList = concurrentHashMap.get(modId);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                concurrentHashMap.put(modId, copyOnWriteArrayList);
                QLog.i("Zootopia_DownloadManager", 1, "addSingleModDownloadListener newListenerList - " + modId);
            } else {
                QLog.i("Zootopia_DownloadManager", 1, "addSingleModDownloadListener listenerList already exist!!! - " + modId);
            }
            if (!copyOnWriteArrayList.contains(listener)) {
                copyOnWriteArrayList.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void J() {
        K(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$ask4gOnResumeNet$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Object obj;
                HashSet<Pair> hashSet;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy;
                HashSet hashSet2;
                if (AppNetConnInfo.isWifiConn() || AppNetConnInfo.isMobileConn()) {
                    obj = ZootopiaDownloadManager.netLock;
                    synchronized (obj) {
                        if (z16) {
                            hashSet = ZootopiaDownloadManager.netResumeSet;
                            for (Pair pair : hashSet) {
                                zPlanModDownloadManagerProxy = ZootopiaDownloadManager.downloadManagerProxy;
                                zPlanModDownloadManagerProxy.D((String) pair.getFirst());
                            }
                        }
                        hashSet2 = ZootopiaDownloadManager.netResumeSet;
                        hashSet2.clear();
                        Unit unit = Unit.INSTANCE;
                    }
                    return;
                }
                QLog.e("Zootopia_DownloadManager", 1, "onResumeNet askNeed4GDownload over but not net");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(String id5) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("mod_has_interrupted_" + id5, true);
        QLog.i("Zootopia_DownloadManager", 1, "saveWhenModManualInterrupted - " + id5);
    }

    private final boolean M(MapStatus mapStatus) {
        return mapStatus == MapStatus.MAP_STATUS_INIT || mapStatus == MapStatus.MAP_STATUS_UPDATE || mapStatus == MapStatus.MAP_STATUS_PAUSE || mapStatus == MapStatus.MAP_STATUS_DOWNLOAD_INTERRUPT || mapStatus == MapStatus.MAP_STATUS_CAN_APPOINTMENT || mapStatus == MapStatus.MAP_STATUS_APPOINTED || mapStatus == MapStatus.MAP_STATUS_DOWNLOAD_FAILED;
    }

    private final boolean O(String id5) {
        if (m0()) {
            return true;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        QLog.i("Zootopia_DownloadManager", 1, "download but no net " + id5 + " " + (qBaseActivity != null ? Boolean.valueOf(qBaseActivity.isFinishing()) : null));
        if (qBaseActivity == null || qBaseActivity.isFinishing()) {
            return false;
        }
        DownloadDialogUtils.q(DownloadDialogUtils.f327978a, qBaseActivity, null, null, null, 14, null);
        return false;
    }

    private final void P0(ZootopiaDownloadParams downloadParams) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100233", false)) {
            QLog.i("Zootopia_DownloadManager", 1, "startDownloadCommonMod :: intercept , switch is false");
        } else {
            QLog.i("Zootopia_DownloadManager", 1, "startDownloadCommonMod :: start ");
            ((si3.b) vb3.a.f441346a.a(si3.b.class)).H0(Integer.parseInt(downloadParams.getSummaryData().getId()), downloadParams.getVersion(), new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(String id5) {
        synchronized (downloadCountLock) {
            HashSet<String> hashSet = downloadingSet;
            if (!hashSet.contains(id5)) {
                hashSet.add(id5);
                f327992a.t0();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(String id5) {
        synchronized (downloadCountLock) {
            HashSet<String> hashSet = downloadingSet;
            if (hashSet.contains(id5)) {
                hashSet.remove(id5);
                f327992a.t0();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean S() {
        return MobileQQ.sProcessId != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int U(int originNotifyDownloadingCount) {
        int size = downloadingSet.size();
        QLog.i("Zootopia_DownloadManager", 1, "fixDownloadingCount, originNotifyDownloadingCount= " + originNotifyDownloadingCount + ", downloadingSetSize= " + size);
        return Math.min(originNotifyDownloadingCount, size);
    }

    private final boolean e0(MapStatus mapStatus) {
        return mapStatus == MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE || mapStatus == MapStatus.MAP_STATUS_ONLY_DOWNLOAD;
    }

    private final void g0() {
        W(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadManager$initDownloadingCount$1$a", "Lpb3/a;", "", "id", "", "onTaskDelete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements pb3.a {
                a() {
                }

                @Override // pb3.a
                public void onDownloadCountChanged(int i3) {
                    a.C10996a.a(this, i3);
                }

                @Override // pb3.a
                public void onDownloadingCountChanged(int i3) {
                    a.C10996a.b(this, i3);
                }

                @Override // pb3.a
                public void onTaskDelete(String id5) {
                    Intrinsics.checkNotNullParameter(id5, "id");
                    ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
                    zootopiaDownloadManager.R0(id5);
                    zootopiaDownloadManager.J0(id5);
                    ZootopiaDownloadReporter.f328017a.a();
                    ZPlanFloatWindowManager.f335646d.b(id5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaResData> list) {
                invoke2((List<ZootopiaResData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ZootopiaResData> it) {
                HashSet hashSet;
                Intrinsics.checkNotNullParameter(it, "it");
                ArrayList<ZootopiaResData> arrayList = new ArrayList();
                for (Object obj : it) {
                    ZootopiaResData zootopiaResData = (ZootopiaResData) obj;
                    if ((zootopiaResData.getDownloadStatus() == 5 || zootopiaResData.isSilentDownload()) ? false : true) {
                        arrayList.add(obj);
                    }
                }
                for (ZootopiaResData zootopiaResData2 : arrayList) {
                    hashSet = ZootopiaDownloadManager.downloadingSet;
                    hashSet.add(String.valueOf(zootopiaResData2.getId()));
                }
                ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
                zootopiaDownloadManager.t0();
                zootopiaDownloadManager.G(new ah() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1.3
                    private final void k(x xVar, Function1<? super w, Unit> function1) {
                        Object obj2;
                        ConcurrentHashMap concurrentHashMap;
                        ArrayList arrayList2 = new ArrayList();
                        obj2 = ZootopiaDownloadManager.modDownloadListenerLock;
                        synchronized (obj2) {
                            concurrentHashMap = ZootopiaDownloadManager.modDownloadListenerMap;
                            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap.get(xVar.getId());
                            if (copyOnWriteArrayList != null) {
                                Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "modDownloadListenerMap[this.getTaskId()]");
                                Iterator it5 = copyOnWriteArrayList.iterator();
                                while (it5.hasNext()) {
                                    arrayList2.add((w) it5.next());
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        Iterator it6 = arrayList2.iterator();
                        while (it6.hasNext()) {
                            function1.invoke((w) it6.next());
                        }
                    }

                    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                    public void b(final x task) {
                        HashMap hashMap;
                        Intrinsics.checkNotNullParameter(task, "task");
                        hashMap = ZootopiaDownloadManager.costHashMap;
                        hashMap.put(task.getId(), Long.valueOf(System.currentTimeMillis()));
                        if (!task.getIsSilentDownload() && task.e()) {
                            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.d(task.getId());
                        }
                        if (!task.getIsSilentDownload()) {
                            ZootopiaDownloadManager.f327992a.Q0(task.getId());
                        }
                        ZootopiaDownloadManager zootopiaDownloadManager2 = ZootopiaDownloadManager.f327992a;
                        zootopiaDownloadManager2.r0(task, 2, task.getCurProgress());
                        zootopiaDownloadManager2.C0();
                        ZootopiaDownloadManager.H0(zootopiaDownloadManager2, false, "ev_zplan_mod_download_begin", task.getId(), task, 0, null, 48, null);
                        ZootopiaDownloadReporter.f328017a.a();
                        k(task, new Function1<w, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1$3$onStartDownload$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(w listener) {
                                Intrinsics.checkNotNullParameter(listener, "listener");
                                listener.a(x.this.getId(), x.this);
                            }
                        });
                    }

                    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                    public void c(final x task) {
                        Intrinsics.checkNotNullParameter(task, "task");
                        if (!task.getIsSilentDownload()) {
                            ZootopiaDownloadManager.f327992a.p0(task.getId(), true, 0, "", task.e());
                        }
                        ZootopiaDownloadManager zootopiaDownloadManager2 = ZootopiaDownloadManager.f327992a;
                        zootopiaDownloadManager2.r0(task, 5, 100.0f);
                        zootopiaDownloadManager2.R0(task.getId());
                        ZootopiaDownloadManager.H0(zootopiaDownloadManager2, true, "ev_zplan_mod_download_success", task.getId(), task, 0, null, 48, null);
                        ZootopiaDownloadReporter.f328017a.a();
                        k(task, new Function1<w, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1$3$onComplete$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(w listener) {
                                Intrinsics.checkNotNullParameter(listener, "listener");
                                listener.g(x.this.getId(), x.this);
                            }
                        });
                        zootopiaDownloadManager2.F0(task.getId());
                    }

                    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                    public void d(final x task) {
                        Intrinsics.checkNotNullParameter(task, "task");
                        if (!task.getIsSilentDownload()) {
                            ZootopiaDownloadManager.f327992a.Q0(task.getId());
                        }
                        k(task, new Function1<w, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1$3$onWaitingDownload$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(w listener) {
                                Intrinsics.checkNotNullParameter(listener, "listener");
                                listener.h(x.this.getId(), x.this);
                            }
                        });
                    }

                    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                    public void e(final x task) {
                        Intrinsics.checkNotNullParameter(task, "task");
                        super.e(task);
                        ZootopiaDownloadManager zootopiaDownloadManager2 = ZootopiaDownloadManager.f327992a;
                        ZootopiaDownloadManager.s0(zootopiaDownloadManager2, task, 4, 0.0f, 4, null);
                        ZootopiaDownloadManager.H0(zootopiaDownloadManager2, false, "ev_zplan_mod_download_pause", task.getId(), task, 0, null, 48, null);
                        if (!task.getIsSilentDownload() && task.e()) {
                            zootopiaDownloadManager2.q0(task.getId());
                        }
                        k(task, new Function1<w, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1$3$onPause$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(w listener) {
                                Intrinsics.checkNotNullParameter(listener, "listener");
                                listener.e(x.this.getId(), x.this);
                            }
                        });
                    }

                    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                    public void f(final float progress, final x task) {
                        Intrinsics.checkNotNullParameter(task, "task");
                        super.f(progress, task);
                        ZootopiaDownloadManager.f327992a.r0(task, 2, progress);
                        k(task, new Function1<w, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1$3$onProgress$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(w listener) {
                                Intrinsics.checkNotNullParameter(listener, "listener");
                                listener.c(x.this.getId(), progress, x.this);
                            }
                        });
                    }

                    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                    public void h(int code, final x task) {
                        Intrinsics.checkNotNullParameter(task, "task");
                        if (!task.getIsSilentDownload()) {
                            ZootopiaDownloadManager.f327992a.p0(task.getId(), false, code, task.getDownloadFailInfo(), task.e());
                        }
                        ZootopiaDownloadManager zootopiaDownloadManager2 = ZootopiaDownloadManager.f327992a;
                        ZootopiaDownloadManager.s0(zootopiaDownloadManager2, task, 6, 0.0f, 4, null);
                        zootopiaDownloadManager2.G0(true, "ev_zplan_mod_download_fail", task.getId(), task, code, "");
                        k(task, new Function1<w, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$initDownloadingCount$1$3$onFailed$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(w listener) {
                                Intrinsics.checkNotNullParameter(listener, "listener");
                                listener.f(x.this.getId(), x.this.getDownloadFailCode(), x.this.getDownloadFailInfo(), x.this);
                            }
                        });
                        zootopiaDownloadManager2.F0(task.getId());
                    }
                });
                zootopiaDownloadManager.H(new a());
            }
        });
    }

    private final boolean i0(HashSet<Pair<String, Boolean>> netResumeSet2) {
        Object obj;
        if (!(!netResumeSet2.isEmpty())) {
            return false;
        }
        Iterator<T> it = netResumeSet2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((Boolean) ((Pair) obj).getSecond()).booleanValue()) {
                break;
            }
        }
        return ((Pair) obj) == null;
    }

    private final boolean j0(List<? extends x> taskList) {
        return n0(taskList) || h0(taskList);
    }

    private final boolean l0(MapStatus mapStatus) {
        return mapStatus == MapStatus.MAP_STATUS_LOADING || mapStatus == MapStatus.MAP_STATUS_UNZIPPING || mapStatus == MapStatus.MAP_STATUS_WAITING_DOWNLOAD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(final String id5, final boolean isSuccess, final int failCode, final String failMsg, final boolean isDownloadMod) {
        QLog.i("Zootopia_DownloadManager", 1, "notifyDownloadFinish_" + id5 + ", failCode= " + failCode + " downloadManagerPage.isShow= " + ZootopiaDownloadManagerFragment.INSTANCE.a());
        Y(id5, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$notifyDownloadFinish$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                HashMap hashMap;
                if (zootopiaDownloadData != null) {
                    hashMap = ZootopiaDownloadManager.costHashMap;
                    Long l3 = (Long) hashMap.get(String.valueOf(zootopiaDownloadData.getResData().getId()));
                    if (l3 == null) {
                        l3 = 0L;
                    }
                    long longValue = l3.longValue();
                    if (isDownloadMod) {
                        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.c(zootopiaDownloadData.getResData().getId(), System.currentTimeMillis() - longValue, zootopiaDownloadData.getResData().getUrl(), failCode, failMsg);
                    }
                    ZootopiaMapLoadingParams loadingParams = zootopiaDownloadData.getExtraData().getLoadingParams();
                    boolean z16 = false;
                    if (loadingParams != null && loadingParams.getIsUseNewLoading()) {
                        z16 = true;
                    }
                    if (z16) {
                        if (((com.tencent.mobileqq.zplan.authorize.impl.helper.e) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.authorize.impl.helper.e.class)).canAutoLaunch(id5)) {
                            QLog.i("Zootopia_DownloadManager", 1, "notifyDownloadFinish_" + id5 + " autoLaunch START status = " + zootopiaDownloadData.getResData().getDownloadStatus());
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE, "4");
                            hashMap2.put("need_relaunch_by_scheme", Boolean.TRUE);
                            si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
                            int parseInt = Integer.parseInt(id5);
                            ZootopiaSource b16 = com.tencent.sqshow.zootopia.utils.ag.f373258a.b();
                            if (b16 == null) {
                                b16 = ZootopiaSource.INSTANCE.g();
                            }
                            final String str = id5;
                            cVar.u(parseInt, b16, hashMap2, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$notifyDownloadFinish$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                                    invoke2(enterModCheckResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(EnterModCheckResult result) {
                                    Intrinsics.checkNotNullParameter(result, "result");
                                    QLog.i("Zootopia_DownloadManager", 1, "notifyDownloadFinish_" + str + " autoLaunch resultCode=" + result.getResultCode() + ", isPassed= " + result.isPassed() + ", isProcessedInner= " + result.getProcessInner());
                                }
                            });
                            return;
                        }
                        QLog.i("Zootopia_DownloadManager", 1, "notifyDownloadFinish_" + id5 + ", floating is showing");
                        return;
                    }
                    v.f328299a.l(zootopiaDownloadData, isSuccess, Integer.valueOf(failCode));
                    return;
                }
                QLog.e("Zootopia_DownloadManager", 1, "notifyDownloadFinish but getData = null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(String id5) {
        QLog.d("Zootopia_DownloadManager", 1, "notifyDownloadPause id: " + id5);
        try {
            f.a.a((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class), Integer.parseInt(id5), false, 2, null);
        } catch (NumberFormatException e16) {
            QLog.d("Zootopia_DownloadManager", 1, "notifyDownloadPause: " + e16 + ", can ignore");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(x task, int downloadStatus, float progress) {
        if (task.getIsSilentDownload() && task.getNeedNotification()) {
            ZPlanModDownloadNotification.f328166a.f(task, downloadStatus, progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        int size = downloadingSet.size();
        QLog.i("Zootopia_DownloadManager", 1, "onDownloadCountChanged " + size);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((pb3.a) it.next()).onDownloadCountChanged(size);
        }
        if (size > 0) {
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        QLog.i("Zootopia_DownloadManager", 1, "onNetWifi2Mobile needCheck " + needCheckerNet);
        if (needCheckerNet) {
            List<x> v3 = downloadManagerProxy.v();
            final ArrayList<x> arrayList = new ArrayList();
            for (Object obj : v3) {
                x xVar = (x) obj;
                if (xVar.getDownloadStatus() == 2 || xVar.getDownloadStatus() == 1) {
                    arrayList.add(obj);
                }
            }
            QLog.i("Zootopia_DownloadManager", 1, "onNetWifi2Mobile downloadingCount is " + arrayList.size());
            if (!arrayList.isEmpty()) {
                if (j0(arrayList)) {
                    if (!ModSilentDownloadHelper.f334775a.p()) {
                        QLog.i("Zootopia_DownloadManager", 1, "onNetWifi2Mobile allSilentDownload, pause directly");
                        for (x xVar2 : arrayList) {
                            f327992a.z0(xVar2, xVar2.getIsSilentDownload());
                        }
                        return;
                    }
                    QLog.i("Zootopia_DownloadManager", 1, "onNetWifi2Mobile allSilentDownload, keep download");
                    return;
                }
                K(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$onNetWifi2Mobile$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (!AppNetConnInfo.isMobileConn()) {
                            QLog.e("Zootopia_DownloadManager", 1, "onNetWifi2Mobile askNeed4GDownload over but net is " + AppNetConnInfo.getConnInfo());
                            return;
                        }
                        if (z16) {
                            return;
                        }
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            ZootopiaDownloadManager.f327992a.z0((x) it.next(), false);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        r2.add(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v0() {
        synchronized (netLock) {
            List<x> v3 = downloadManagerProxy.v();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = v3.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                x xVar = (x) next;
                if (xVar.getDownloadStatus() != 2 && xVar.getDownloadStatus() != 1) {
                    z16 = false;
                }
            }
            QLog.i("Zootopia_DownloadManager", 1, "onNoNet downloadingCount is " + arrayList.size());
            if (!arrayList.isEmpty()) {
                if (!f327992a.j0(arrayList)) {
                    QQToastUtil.showQQToast(1, R.string.f169773xj0);
                }
                netResumeSet.clear();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    f327992a.z0((x) it5.next(), true);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w0() {
        boolean z16;
        synchronized (netLock) {
            HashSet<Pair<String, Boolean>> hashSet = netResumeSet;
            QLog.i("Zootopia_DownloadManager", 1, "onResumeNet count " + hashSet.size() + " needCheck " + needCheckerNet + " isMobile " + AppNetConnInfo.isMobileConn());
            if (hashSet.isEmpty() && needCheckerNet && AppNetConnInfo.isMobileConn()) {
                List<x> v3 = downloadManagerProxy.v();
                ArrayList<x> arrayList = new ArrayList();
                for (Object obj : v3) {
                    x xVar = (x) obj;
                    if (xVar.getDownloadStatus() != 2 && xVar.getDownloadStatus() != 1) {
                        z16 = false;
                        if (!z16) {
                            arrayList.add(obj);
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
                QLog.i("Zootopia_DownloadManager", 1, "onResumeNet mobile, cur downloadingCount is " + arrayList.size());
                if (!arrayList.isEmpty()) {
                    if (f327992a.j0(arrayList)) {
                        if (!ModSilentDownloadHelper.f334775a.p()) {
                            QLog.i("Zootopia_DownloadManager", 1, "onResumeNet mobile allSilentDownload, pause directly");
                            for (x xVar2 : arrayList) {
                                f327992a.z0(xVar2, xVar2.getIsSilentDownload());
                            }
                        } else {
                            QLog.i("Zootopia_DownloadManager", 1, "onResumeNet mobile allSilentDownload, keep download");
                        }
                    } else {
                        for (x xVar3 : arrayList) {
                            f327992a.z0(xVar3, xVar3.getIsSilentDownload());
                        }
                    }
                }
                return;
            }
            if (hashSet.isEmpty()) {
                return;
            }
            if (needCheckerNet && AppNetConnInfo.isMobileConn()) {
                ZootopiaDownloadManager zootopiaDownloadManager = f327992a;
                if (zootopiaDownloadManager.i0(hashSet)) {
                    if (ModSilentDownloadHelper.f334775a.p()) {
                        QLog.e("Zootopia_DownloadManager", 1, "onResumeNet isAllSilentDownload, direct resume");
                    } else {
                        QLog.e("Zootopia_DownloadManager", 1, "onResumeNet isAllSilentDownload, keep pause");
                        return;
                    }
                } else {
                    zootopiaDownloadManager.J();
                    return;
                }
            }
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                downloadManagerProxy.D((String) ((Pair) it.next()).getFirst());
            }
            netResumeSet.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void D0(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        downloadManagerProxy.C(listener);
    }

    public final void E0(pb3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final void G(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        downloadManagerProxy.i(listener);
    }

    public final void H(pb3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<pb3.a> copyOnWriteArrayList = listeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void I0(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        downloadManagerProxy.D(id5);
    }

    public final void K(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DownloadDialogUtils.g(DownloadDialogUtils.f327978a, qBaseActivity, null, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$askNeed4GDownload$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, boolean z17) {
                    QLog.i("Zootopia_DownloadManager", 1, "askNeed4gDownload result " + z16 + " " + z17);
                    ZootopiaDownloadManager.f327992a.K0(z17 ^ true);
                    callback.invoke(Boolean.valueOf(z16));
                }
            }, 2, null);
        } else {
            QLog.e("Zootopia_DownloadManager", 1, "onNetWifi2Mobile activity status error");
        }
    }

    public final void K0(boolean z16) {
        needCheckerNet = z16;
    }

    public final void L0(final ZootopiaDownloadParams downloadParams, boolean withoutCheck, final w mapDownloadListener, boolean shouldOverride4gDialog) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        final String id5 = downloadParams.getSummaryData().getId();
        if (TextUtils.isEmpty(downloadParams.getUrl())) {
            QLog.e("Zootopia_DownloadManager", 1, "startDownload but url empty - " + downloadParams, new Throwable());
            if (mapDownloadListener != null) {
                mapDownloadListener.d(id5, -87602, "url empty");
                return;
            }
            return;
        }
        if (withoutCheck) {
            T(downloadParams, mapDownloadListener);
            return;
        }
        if (!O(downloadParams.getSummaryData().getId()) || !P(downloadParams)) {
            if (mapDownloadListener != null) {
                mapDownloadListener.d(id5, -87603, "net or size invalid");
                return;
            }
            return;
        }
        boolean c16 = com.tencent.mobileqq.zootopia.utils.m.f329564a.c();
        QLog.i("Zootopia_DownloadManager", 1, "startDownload isMobile " + c16 + " needCheck " + needCheckerNet);
        if (c16 && needCheckerNet && !shouldOverride4gDialog) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                DownloadDialogUtils.f327978a.f(qBaseActivity, "", new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$startDownload$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                        invoke(bool.booleanValue(), bool2.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, boolean z17) {
                        QLog.i("Zootopia_DownloadManager", 1, "ask4gDownload result: " + z16 + " " + z17);
                        if (!z16) {
                            w wVar = w.this;
                            if (wVar != null) {
                                wVar.d(id5, -87604, "network mobile");
                                return;
                            }
                            return;
                        }
                        ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
                        zootopiaDownloadManager.K0(!z17);
                        zootopiaDownloadManager.T(downloadParams, w.this);
                    }
                });
                return;
            }
            QLog.e("Zootopia_DownloadManager", 1, "startDownload need checkNet but activity status error");
        }
        T(downloadParams, mapDownloadListener);
    }

    public final void N(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        downloadManagerProxy.j(id5);
    }

    public final void N0(final String mapId, boolean forceReDownload, final w mapDownloadListener, final boolean shouldOverride4gDialog) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Function1<ZootopiaDownloadData, Unit> function1 = new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$startDownloadByMapId$localDownloadDataCallback$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadManager$startDownloadByMapId$localDownloadDataCallback$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<ZootopiaMapStatusService.MapStatusInfoResult> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f328010d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ w f328011e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f328012f;

                a(String str, w wVar, boolean z16) {
                    this.f328010d = str;
                    this.f328011e = wVar;
                    this.f328012f = z16;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(ZootopiaMapStatusService.MapStatusInfoResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZootopiaDownloadManager.f327992a.B0(this.f328010d, result, this.f328011e, this.f328012f);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    QLog.e("Zootopia_DownloadManager", 1, "startDownloadByMapId-" + this.f328010d + ", queryMapVerStatus error:" + error + ", message:" + message);
                    ZootopiaDownloadManager.f327992a.Q(null);
                    w wVar = this.f328011e;
                    if (wVar != null) {
                        String str = this.f328010d;
                        if (message == null) {
                            message = "";
                        }
                        wVar.d(str, error, "queryMapVerStatus, " + message);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZootopiaMapStatusService zootopiaMapStatusService;
                Integer intOrNull;
                zootopiaMapStatusService = ZootopiaDownloadManager.mapStatusService;
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(mapId);
                zootopiaMapStatusService.c(intOrNull != null ? intOrNull.intValue() : 0, zootopiaDownloadData, new a(mapId, mapDownloadListener, shouldOverride4gDialog));
            }
        };
        if (forceReDownload) {
            function1.invoke(null);
        } else {
            Y(mapId, function1);
        }
    }

    public final boolean P(ZootopiaDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        if (o0(downloadParams.getSummaryData().getId(), downloadParams.getSize())) {
            return true;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null || qBaseActivity.isFinishing()) {
            return false;
        }
        DownloadDialogUtils.o(DownloadDialogUtils.f327978a, qBaseActivity, null, 2, null);
        return false;
    }

    public final synchronized void T0() {
        if (haveTryResume) {
            return;
        }
        haveTryResume = true;
        downloadManagerProxy.p(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$tryResumeDownloadTask$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaResData> list) {
                invoke2((List<ZootopiaResData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ZootopiaResData> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ArrayList arrayList = new ArrayList();
                Iterator<T> it5 = it.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (((ZootopiaResData) next).getDownloadStatus() == 8) {
                        arrayList.add(next);
                    }
                }
                QLog.i("Zootopia_DownloadManager", 1, "tryResumeDownloadTask downloading count is " + arrayList.size());
                if (!arrayList.isEmpty()) {
                    ZootopiaDownloadManager.f327992a.S0(arrayList);
                }
            }
        });
    }

    public final void U0(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        downloadManagerProxy.O(mapId);
    }

    public final void V(Function1<? super List<ZootopiaDownloadData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        downloadManagerProxy.n(callback);
    }

    public final void V0(String id5, String version) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.i("Zootopia_DownloadManager", 1, "update Mod version " + id5 + " - " + version);
        ZPlanModDownloadManagerProxy.M(downloadManagerProxy, id5, null, null, null, version, 14, null);
    }

    public final void W(Function1<? super List<ZootopiaResData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        downloadManagerProxy.p(callback);
    }

    public final int X() {
        return downloadingSet.size();
    }

    public final void Y(String id5, Function1<? super ZootopiaDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        downloadManagerProxy.q(id5, callback);
    }

    public final void Z(String id5, boolean forceSearchDb, Function1<? super ZootopiaDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        downloadManagerProxy.r(id5, forceSearchDb, callback);
    }

    public final int a0() {
        return U(downloadManagerProxy.t());
    }

    public final boolean b0() {
        return needCheckerNet;
    }

    public final void c0(String id5, Function1<? super ZootopiaResData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        downloadManagerProxy.w(id5, callback);
    }

    public final void d0(final int mapId, String mapName, String hintTxt) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        N(String.valueOf(mapId));
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing()) {
            DownloadDialogUtils.f327978a.k(topActivity, mapName, hintTxt, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager$handleFileBroken$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        ZootopiaDownloadManager.O0(ZootopiaDownloadManager.f327992a, String.valueOf(mapId), true, null, false, 12, null);
                    }
                }
            });
            return;
        }
        QLog.e("Zootopia_DownloadManager", 1, "handlerFileBrokenError mapId " + mapId + " but activity is invalid");
    }

    public final boolean f0(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("mod_has_interrupted_" + id5, false);
    }

    public final boolean k0() {
        int t16 = downloadManagerProxy.t();
        QLog.i("Zootopia_DownloadManager", 1, "isDownloadingModRes mainPakDownloadingCount= " + t16);
        return t16 > 0 || ZPlanModHotPatchManager.f328077a.A();
    }

    public final boolean m0() {
        return AppNetConnInfo.isMobileConn() || AppNetConnInfo.isWifiConn();
    }

    public final boolean o0(String id5, long size) {
        Intrinsics.checkNotNullParameter(id5, "id");
        v vVar = v.f328299a;
        long b16 = vVar.b(v.h(vVar, id5, false, 2, null));
        QLog.i("Zootopia_DownloadManager", 1, "checkSize available size " + b16 + " fileSize " + size);
        return b16 >= size;
    }

    public final void x0(String id5, boolean startNext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        isManualPause = true;
        downloadManagerProxy.y(id5, startNext);
        J0(id5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(List<ZootopiaResData> downloadingList) {
        QLog.i("Zootopia_DownloadManager", 1, "not resume downloadingTask");
        Iterator<T> it = downloadingList.iterator();
        while (it.hasNext()) {
            ZPlanModDownloadManagerProxy.M(downloadManagerProxy, String.valueOf(((ZootopiaResData) it.next()).getId()), 4, null, null, null, 28, null);
        }
    }

    private final boolean h0(List<? extends x> taskList) {
        Object obj;
        if (!(!taskList.isEmpty())) {
            return false;
        }
        Iterator<T> it = taskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((x) obj).getIsPlayDownloadTogether()) {
                break;
            }
        }
        return ((x) obj) == null;
    }

    private final boolean n0(List<? extends x> taskList) {
        Object obj;
        if (!(!taskList.isEmpty())) {
            return false;
        }
        Iterator<T> it = taskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((x) obj).getIsSilentDownload()) {
                break;
            }
        }
        return ((x) obj) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<? extends String, Object> L(ZootopiaResData data, x task, int errorCode) {
        Object obj;
        Object obj2;
        Object obj3;
        String str;
        Object obj4;
        HashMap hashMapOf;
        ZootopiaDownloadTask zootopiaDownloadTask = task instanceof ZootopiaDownloadTask ? (ZootopiaDownloadTask) task : null;
        int i3 = (zootopiaDownloadTask == null || !zootopiaDownloadTask.getIsAutoDownload()) ? 0 : 1;
        boolean isSilentDownload = task.getIsSilentDownload();
        boolean z16 = task instanceof ZootopiaDownloadTask;
        ZootopiaDownloadTask zootopiaDownloadTask2 = z16 ? (ZootopiaDownloadTask) task : null;
        int i16 = (zootopiaDownloadTask2 == null || !zootopiaDownloadTask2.n0()) ? 0 : 1;
        ZootopiaDownloadTask zootopiaDownloadTask3 = z16 ? (ZootopiaDownloadTask) task : null;
        int i17 = (zootopiaDownloadTask3 == null || !zootopiaDownloadTask3.getIsResumeStart()) ? 0 : 1;
        String str2 = "1";
        if (((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat()) {
            obj = "1";
        } else {
            obj = "0";
        }
        if (isManualPause) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        ZootopiaDownloadTask zootopiaDownloadTask4 = z16 ? (ZootopiaDownloadTask) task : null;
        Object obj5 = "";
        if (zootopiaDownloadTask4 == null) {
            obj3 = "";
        } else {
            obj3 = Long.valueOf(zootopiaDownloadTask4.h0() / 1024);
        }
        ZootopiaDownloadTask zootopiaDownloadTask5 = z16 ? (ZootopiaDownloadTask) task : null;
        if (zootopiaDownloadTask5 == null || (str = zootopiaDownloadTask5.g0()) == null) {
            str = "";
        }
        ZootopiaDownloadTask zootopiaDownloadTask6 = z16 ? (ZootopiaDownloadTask) task : null;
        if (zootopiaDownloadTask6 != null) {
            obj5 = Long.valueOf(zootopiaDownloadTask6.getDownloadCost());
        }
        Pair[] pairArr = new Pair[15];
        pairArr[0] = new Pair("zplan_map_id", Integer.valueOf(data.getId()));
        pairArr[1] = new Pair("zplan_is_autodownload", Integer.valueOf(i3));
        pairArr[2] = new Pair("zplan_is_silence", Integer.valueOf(isSilentDownload ? 1 : 0));
        pairArr[3] = new Pair("zplan_is_update", Integer.valueOf(i16));
        pairArr[4] = new Pair("zplan_error_code", Integer.valueOf(errorCode));
        pairArr[5] = new Pair("zplan_download_size", Long.valueOf(data.getSize() / 1024));
        pairArr[6] = new Pair("zplan_mod_version", data.getVersion());
        pairArr[7] = new Pair("zplan_is_continue", Integer.valueOf(i17));
        pairArr[8] = new Pair("zplan_is_floating", obj);
        pairArr[9] = new Pair("zplan_is_clickpause", obj2);
        pairArr[10] = new Pair("zplan_pkg_size", obj3);
        pairArr[11] = new Pair("zplan_download_type", str);
        pairArr[12] = new Pair("zplan_download_lvtm", obj5);
        if (ux4.b.f440566e.f()) {
            obj4 = "1";
        } else {
            obj4 = "0";
        }
        pairArr[13] = new Pair("zplan_is_play", obj4);
        if (!task.getIsPlayDownloadTogether()) {
            str2 = "0";
        }
        pairArr[14] = new Pair("zplan_is_cloud_mod", str2);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(int i3) {
        if (i3 > 0) {
            QQToastUtil.showQQToast(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(ZootopiaDownloadParams downloadParams, w mapDownloadListener) {
        if (mapDownloadListener != null) {
            mapDownloadListener.b(downloadParams.getSummaryData().getId());
        }
        I(downloadParams.getSummaryData().getId(), mapDownloadListener);
        downloadManagerProxy.G(downloadParams);
        P0(downloadParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(x downloadTask, boolean needResumeWhenNetReady) {
        if (needResumeWhenNetReady) {
            netResumeSet.add(new Pair<>(downloadTask.getId(), Boolean.valueOf(downloadTask.getIsSilentDownload())));
        }
        downloadManagerProxy.y(downloadTask.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(String mapId, ZootopiaMapStatusService.MapStatusInfoResult result, w mapDownloadListener, boolean shouldOverride4gDialog) {
        MapStatus mapStatus = result.getMapStatus();
        QLog.i("Zootopia_DownloadManager", 1, "realStartDownloadByMapId-" + mapId + ", mapStatus= " + mapStatus);
        if (M(mapStatus)) {
            ZootopiaDownloadParams b16 = com.tencent.mobileqq.zootopia.download.c.b(com.tencent.mobileqq.zootopia.download.c.f328029a, result.getMapVerStatusRsp(), false, false, false, 14, null);
            if (b16 != null) {
                M0(this, b16, false, mapDownloadListener, shouldOverride4gDialog, 2, null);
                A0(result);
                return;
            } else {
                if (mapDownloadListener != null) {
                    mapDownloadListener.d(mapId, -87601, "downloadParams is null");
                    return;
                }
                return;
            }
        }
        if (l0(mapStatus)) {
            if (mapDownloadListener != null) {
                mapDownloadListener.b(mapId);
            }
            I(mapId, mapDownloadListener);
        } else {
            if (e0(mapStatus)) {
                if (mapDownloadListener != null) {
                    mapDownloadListener.b(mapId);
                }
                if (mapDownloadListener != null) {
                    mapDownloadListener.g(mapId, null);
                    return;
                }
                return;
            }
            Q(mapStatus);
            if (mapDownloadListener != null) {
                mapDownloadListener.d(mapId, -87605, "invalid MapStatus - " + mapStatus);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(MapStatus mapStatus) {
        final int i3 = R.string.xj5;
        if (mapStatus != null) {
            int i16 = c.f328009a[mapStatus.ordinal()];
            if (i16 == 1 || i16 == 2) {
                i3 = R.string.xj7;
            } else if (i16 == 3) {
                i3 = R.string.xix;
            } else if (i16 == 4) {
                i3 = R.string.f169775xj2;
            } else if (i16 == 5) {
                i3 = R.string.xjv;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ab
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDownloadManager.R(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s0(ZootopiaDownloadManager zootopiaDownloadManager, x xVar, int i3, float f16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            f16 = 0.0f;
        }
        zootopiaDownloadManager.r0(xVar, i3, f16);
    }

    public static /* synthetic */ void y0(ZootopiaDownloadManager zootopiaDownloadManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        zootopiaDownloadManager.x0(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void H0(ZootopiaDownloadManager zootopiaDownloadManager, boolean z16, String str, String str2, x xVar, int i3, String str3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 32) != 0) {
            str3 = "";
        }
        zootopiaDownloadManager.G0(z16, str, str2, xVar, i17, str3);
    }

    public static /* synthetic */ void M0(ZootopiaDownloadManager zootopiaDownloadManager, ZootopiaDownloadParams zootopiaDownloadParams, boolean z16, w wVar, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            wVar = null;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        zootopiaDownloadManager.L0(zootopiaDownloadParams, z16, wVar, z17);
    }

    public static /* synthetic */ void O0(ZootopiaDownloadManager zootopiaDownloadManager, String str, boolean z16, w wVar, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            wVar = null;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        zootopiaDownloadManager.N0(str, z16, wVar, z17);
    }
}

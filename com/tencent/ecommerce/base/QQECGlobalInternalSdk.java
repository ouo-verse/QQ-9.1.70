package com.tencent.ecommerce.base;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.account.api.IECAccountManager;
import com.tencent.ecommerce.base.account.api.IECFaceVerification;
import com.tencent.ecommerce.base.account.api.INVViewModelInitialization;
import com.tencent.ecommerce.base.compress.IECCompressOperator;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.api.IECRemoteConfig;
import com.tencent.ecommerce.base.device.api.IECDeviceInfo;
import com.tencent.ecommerce.base.event.api.IECEventDispatcherDelegate;
import com.tencent.ecommerce.base.imageloader.api.IECApngLoader;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader;
import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import com.tencent.ecommerce.base.logger.api.IECLog;
import com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher;
import com.tencent.ecommerce.base.network.api.IECHttpDownloader;
import com.tencent.ecommerce.base.network.api.IECSender;
import com.tencent.ecommerce.base.nightmode.api.IECNightManager;
import com.tencent.ecommerce.base.offline.api.IECOfflineManager;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry;
import com.tencent.ecommerce.base.pageopener.api.IECMediaSelector;
import com.tencent.ecommerce.base.permission.api.IPermission;
import com.tencent.ecommerce.base.photobrowser.api.IECPhotoBrowser;
import com.tencent.ecommerce.base.plugin.IECActivityDelegate;
import com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate;
import com.tencent.ecommerce.base.preload.api.IECImagePreloadManager;
import com.tencent.ecommerce.base.publicaccount.api.IECPublicAccountManager;
import com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequest;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.api.IECMobileReportManager;
import com.tencent.ecommerce.base.rmonitor.api.IECRMonitorManager;
import com.tencent.ecommerce.base.router.api.IECScheme;
import com.tencent.ecommerce.base.runtime.api.IECRuntime;
import com.tencent.ecommerce.base.searchbar.IECSearchBarCreator;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.base.somanager.api.IECSoManager;
import com.tencent.ecommerce.base.threadpool.api.IECThreadPoolProxy;
import com.tencent.ecommerce.base.ticket.api.IECTicketManager;
import com.tencent.ecommerce.base.ui.api.IECRenderViewRegister;
import com.tencent.ecommerce.base.ui.api.IECSkinApi;
import com.tencent.ecommerce.base.ui.api.IECToast;
import com.tencent.ecommerce.base.uploader.IECUploaderFactory;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.base.wx.api.IECWXAuthApi;
import com.tencent.ecommerce.biz.consumer.IECGameProxy;
import com.tencent.ecommerce.biz.game.api.IECGameApi;
import com.tencent.ecommerce.biz.guild.api.IECGuildApi;
import com.tencent.ecommerce.biz.hippy.api.IECHippyProxy;
import com.tencent.ecommerce.biz.hr.api.IKuiklyImageFetcher;
import com.tencent.ecommerce.biz.live.IECLiveNumberFontLoader;
import com.tencent.ecommerce.biz.lucy.ILucyApi;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.ecommerce.biz.pay.api.IECVasRechargeApi;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.ecommerce.biz.qtroop.api.IECQTroopServiceApi;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.ecommerce.biz.taskcenter.bizmodule.api.IECBizModuleProxy;
import com.tencent.ecommerce.biz.vibration.api.IECVibrationApi;
import com.tencent.ecommerce.biz.wallet.IWallet;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f4\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u00a0\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u00108\u001a\u000203\u0012\u0006\u0010>\u001a\u000209\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010E\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010T\u001a\u00020O\u0012\u0006\u0010Z\u001a\u00020U\u0012\u0006\u0010_\u001a\u00020[\u0012\u0006\u0010e\u001a\u00020`\u0012\u0006\u0010j\u001a\u00020f\u0012\u0006\u0010o\u001a\u00020k\u0012\u0006\u0010u\u001a\u00020p\u0012\u0006\u0010z\u001a\u00020v\u0012\u0006\u0010~\u001a\u00020{\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f\u0012\f\b\u0002\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\b\u0010\u008b\u0001\u001a\u00030\u0088\u0001\u0012\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\b\u0010\u0096\u0001\u001a\u00030\u0092\u0001\u0012\b\u0010\u009b\u0001\u001a\u00030\u0097\u0001\u0012\f\b\u0002\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009c\u0001\u0012\f\b\u0002\u0010\u00a5\u0001\u001a\u0005\u0018\u00010\u00a2\u0001\u0012\b\u0010\u00ab\u0001\u001a\u00030\u00a6\u0001\u0012\b\u0010\u00b3\u0001\u001a\u00030\u00ac\u0001\u0012\f\b\u0002\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b4\u0001\u0012\b\u0010\u00bd\u0001\u001a\u00030\u00b9\u0001\u0012\b\u0010\u00c2\u0001\u001a\u00030\u00be\u0001\u0012\b\u0010\u00c8\u0001\u001a\u00030\u00c3\u0001\u0012\b\u0010\u00cd\u0001\u001a\u00030\u00c9\u0001\u0012\b\u0010\u00d1\u0001\u001a\u00030\u00ce\u0001\u0012\b\u0010\u00d5\u0001\u001a\u00030\u00d2\u0001\u0012\f\b\u0002\u0010\u00da\u0001\u001a\u0005\u0018\u00010\u00d6\u0001\u0012\f\b\u0002\u0010\u00df\u0001\u001a\u0005\u0018\u00010\u00db\u0001\u0012\f\b\u0002\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e0\u0001\u0012\f\b\u0002\u0010\u00e9\u0001\u001a\u0005\u0018\u00010\u00e5\u0001\u0012\f\b\u0002\u0010\u00ed\u0001\u001a\u0005\u0018\u00010\u00ea\u0001\u0012\f\b\u0002\u0010\u00f2\u0001\u001a\u0005\u0018\u00010\u00ee\u0001\u0012\f\b\u0002\u0010\u00f6\u0001\u001a\u0005\u0018\u00010\u00f3\u0001\u0012\f\b\u0002\u0010\u00fb\u0001\u001a\u0005\u0018\u00010\u00f7\u0001\u0012\f\b\u0002\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u00fc\u0001\u0012\f\b\u0002\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u0002\u0012\f\b\u0002\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0084\u0002\u0012\f\b\u0002\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u0088\u0002\u0012\f\b\u0002\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008c\u0002\u0012\f\b\u0002\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0091\u0002\u0012\f\b\u0002\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0095\u0002\u0012\f\b\u0002\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009a\u0002\u0012\f\b\u0002\u0010\u00a1\u0002\u001a\u0005\u0018\u00010\u009e\u0002\u0012\f\b\u0002\u0010\u00a5\u0002\u001a\u0005\u0018\u00010\u00a2\u0002\u0012\f\b\u0002\u0010\u00aa\u0002\u001a\u0005\u0018\u00010\u00a6\u0002\u0012\f\b\u0002\u0010\u00af\u0002\u001a\u0005\u0018\u00010\u00ab\u0002\u0012\f\b\u0002\u0010\u00b4\u0002\u001a\u0005\u0018\u00010\u00b0\u0002\u00a2\u0006\u0006\b\u00b5\u0002\u0010\u00b6\u0002J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010D\u001a\u0004\u0018\u00010?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010J\u001a\u0004\u0018\u00010E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010N\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\b6\u0010L\u001a\u0004\b\n\u0010MR\u0017\u0010T\u001a\u00020O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010Z\u001a\u00020U8\u0006\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0017\u0010_\u001a\u00020[8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b(\u0010^R\u0017\u0010e\u001a\u00020`8\u0006\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0017\u0010j\u001a\u00020f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010g\u001a\u0004\bh\u0010iR\u0017\u0010o\u001a\u00020k8\u0006\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\b@\u0010nR\u0017\u0010u\u001a\u00020p8\u0006\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0017\u0010z\u001a\u00020v8\u0006\u00a2\u0006\f\n\u0004\bw\u0010x\u001a\u0004\bP\u0010yR\u0017\u0010~\u001a\u00020{8\u0006\u00a2\u0006\f\n\u0004\b$\u0010|\u001a\u0004\b\u0016\u0010}R\u001c\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0006\u00a2\u0006\u000e\n\u0005\b\u0018\u0010\u0080\u0001\u001a\u0005\b\\\u0010\u0081\u0001R\u001e\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006\u00a2\u0006\u000f\n\u0005\bh\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u0085\u0001\u0010\u0089\u0001\u001a\u0005\b4\u0010\u008a\u0001R\u001f\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0096\u0001\u001a\u00030\u0092\u00018\u0006\u00a2\u0006\u000f\n\u0005\bc\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001d\u0010\u009b\u0001\u001a\u00030\u0097\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u0098\u0001\u0010\u009a\u0001R\u001f\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001d\u0010\u00a5\u0001\u001a\u0005\u0018\u00010\u00a2\u00018\u0006\u00a2\u0006\u000e\n\u0005\bB\u0010\u00a3\u0001\u001a\u0005\b\u001c\u0010\u00a4\u0001R\u001d\u0010\u00ab\u0001\u001a\u00030\u00a6\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R(\u0010\u00b3\u0001\u001a\u00030\u00ac\u00018\u0006X\u0087\u0004\u00a2\u0006\u0018\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001\u0012\u0006\b\u00b1\u0001\u0010\u00b2\u0001\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001f\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00b7\u0001R\u001c\u0010\u00bd\u0001\u001a\u00030\u00b9\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001\u001a\u0005\ba\u0010\u00bc\u0001R\u001c\u0010\u00c2\u0001\u001a\u00030\u00be\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001\u001a\u0005\bq\u0010\u00c1\u0001R\u001d\u0010\u00c8\u0001\u001a\u00030\u00c3\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u001d\u0010\u00cd\u0001\u001a\u00030\u00c9\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001\u001a\u0006\b\u009d\u0001\u0010\u00cc\u0001R\u001d\u0010\u00d1\u0001\u001a\u00030\u00ce\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u00cf\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00d0\u0001R\u001b\u0010\u00d5\u0001\u001a\u00030\u00d2\u00018\u0006\u00a2\u0006\u000e\n\u0005\bX\u0010\u00d3\u0001\u001a\u0005\bw\u0010\u00d4\u0001R\u001e\u0010\u00da\u0001\u001a\u0005\u0018\u00010\u00d6\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u00d7\u0001\u0010\u00d8\u0001\u001a\u0005\b\u0010\u0010\u00d9\u0001R\u001e\u0010\u00df\u0001\u001a\u0005\u0018\u00010\u00db\u00018\u0006\u00a2\u0006\u000f\n\u0005\b\u001e\u0010\u00dc\u0001\u001a\u0006\b\u00dd\u0001\u0010\u00de\u0001R\u001f\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e0\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e1\u0001\u0010\u00e2\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00e3\u0001R\u001e\u0010\u00e9\u0001\u001a\u0005\u0018\u00010\u00e5\u00018\u0006\u00a2\u0006\u000f\n\u0005\b\f\u0010\u00e6\u0001\u001a\u0006\b\u00e7\u0001\u0010\u00e8\u0001R\u001d\u0010\u00ed\u0001\u001a\u0005\u0018\u00010\u00ea\u00018\u0006\u00a2\u0006\u000e\n\u0005\b*\u0010\u00eb\u0001\u001a\u0005\bF\u0010\u00ec\u0001R\u001f\u0010\u00f2\u0001\u001a\u0005\u0018\u00010\u00ee\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ef\u0001\u0010\u00f0\u0001\u001a\u0006\b\u008d\u0001\u0010\u00f1\u0001R\u001e\u0010\u00f6\u0001\u001a\u0005\u0018\u00010\u00f3\u00018\u0006\u00a2\u0006\u000f\n\u0005\bs\u0010\u00f4\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00f5\u0001R\u001f\u0010\u00fb\u0001\u001a\u0005\u0018\u00010\u00f7\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00af\u0001\u0010\u00f8\u0001\u001a\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u001f\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u00fc\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00dd\u0001\u0010\u00fd\u0001\u001a\u0006\b\u00ba\u0001\u0010\u00fe\u0001R\u001e\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0006\u00a2\u0006\u000f\n\u0006\b\u00a9\u0001\u0010\u0081\u0002\u001a\u0005\b\"\u0010\u0082\u0002R\u001d\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0084\u00028\u0006\u00a2\u0006\u000e\n\u0005\b0\u0010\u0085\u0002\u001a\u0005\bl\u0010\u0086\u0002R\u001e\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0006\u00a2\u0006\u000f\n\u0005\bR\u0010\u0089\u0002\u001a\u0006\b\u00ef\u0001\u0010\u008a\u0002R\u001e\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0006\u00a2\u0006\u000f\n\u0005\b<\u0010\u008d\u0002\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001f\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u008e\u0002\u0010\u0092\u0002\u001a\u0006\b\u00bf\u0001\u0010\u0093\u0002R\u001e\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0006\u00a2\u0006\u000f\n\u0006\b\u0096\u0002\u0010\u0097\u0002\u001a\u0005\b:\u0010\u0098\u0002R\u001f\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009a\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00e7\u0001\u0010\u009b\u0002\u001a\u0006\b\u00c4\u0001\u0010\u009c\u0002R\u001d\u0010\u00a1\u0002\u001a\u0005\u0018\u00010\u009e\u00028\u0006\u00a2\u0006\u000e\n\u0005\bH\u0010\u009f\u0002\u001a\u0005\b.\u0010\u00a0\u0002R\u001f\u0010\u00a5\u0002\u001a\u0005\u0018\u00010\u00a2\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00f9\u0001\u0010\u00a3\u0002\u001a\u0006\b\u00e1\u0001\u0010\u00a4\u0002R\u001e\u0010\u00aa\u0002\u001a\u0005\u0018\u00010\u00a6\u00028\u0006\u00a2\u0006\u000f\n\u0006\b\u00a7\u0002\u0010\u00a8\u0002\u001a\u0005\bV\u0010\u00a9\u0002R\u001f\u0010\u00af\u0002\u001a\u0005\u0018\u00010\u00ab\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00ac\u0002\u0010\u00ad\u0002\u001a\u0006\b\u0096\u0002\u0010\u00ae\u0002R\u001f\u0010\u00b4\u0002\u001a\u0005\u0018\u00010\u00b0\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00b1\u0002\u0010\u00b2\u0002\u001a\u0006\b\u00d7\u0001\u0010\u00b3\u0002\u00a8\u0006\u00b7\u0002"}, d2 = {"Lcom/tencent/ecommerce/base/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "a", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "P", "()Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "runtime", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "b", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/ecommerce/base/logger/api/IECLog;", "logger", "Lcom/tencent/ecommerce/base/network/api/IECSender;", "c", "Lcom/tencent/ecommerce/base/network/api/IECSender;", "v", "()Lcom/tencent/ecommerce/base/network/api/IECSender;", "network", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "d", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "N", "()Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "reporter", "Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "e", "Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "u", "()Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "mobileReporter", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", "f", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/ecommerce/base/router/api/IECScheme;", ZPlanPublishSource.FROM_SCHEME, "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "g", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "W", "()Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "ticket", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", h.F, "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "l", "()Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "imageLoader", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "i", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "Y", "()Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "uploaderFactory", "Lcom/tencent/ecommerce/base/permission/api/IPermission;", "j", "Lcom/tencent/ecommerce/base/permission/api/IPermission;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/ecommerce/base/permission/api/IPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/ecommerce/biz/wallet/IWallet;", "k", "Lcom/tencent/ecommerce/biz/wallet/IWallet;", "c0", "()Lcom/tencent/ecommerce/biz/wallet/IWallet;", QCircleDaTongConstant.ElementParamValue.WALLET, "Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "()Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "accountManager", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "X", "()Lcom/tencent/ecommerce/base/ui/api/IECToast;", "toast", "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "L", "()Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "remoteConfig", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "o", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "()Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "faceVerification", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "p", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "openTelemetry", "Lcom/tencent/ecommerce/base/nightmode/api/IECNightManager;", "Lcom/tencent/ecommerce/base/nightmode/api/IECNightManager;", "w", "()Lcom/tencent/ecommerce/base/nightmode/api/IECNightManager;", "nightManager", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "r", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "()Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "hippyProxy", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", ExifInterface.LATITUDE_SOUTH, "()Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "shareProxy", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "t", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "()Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "imagePreloadManager", "Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;", "Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;", "()Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;", "bizModuleProxy", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "()Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "localMMKVConfig", "Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;", "Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;", HippyTKDListViewAdapter.X, "()Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;", "nvViewModelInitialization", "Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "()Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "gameProxy", "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "y", "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "K", "()Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "rMonitorManager", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "getApngLoader", "()Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "apngLoader", "Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "()Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "pagSoLoader", "Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;", "B", "Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;", "getLiveNumberFontLoader", "()Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;", "liveNumberFontLoader", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "()Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "deviceInfo", "Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "D", "Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "V", "()Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "threadPool", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "E", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "T", "()Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "getSkinApi$annotations", "()V", "skinApi", "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "()Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "photoBrowser", "Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "G", "Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "()Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "locationService", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "H", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "()Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "mediaSelector", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "I", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "getCompressOperator", "()Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "compressOperator", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "J", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "()Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "payApi", "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "()Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "publicAccountManager", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "()Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "miniAppLauncher", "Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;", "M", "Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;", "()Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;", "activityDelegate", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "U", "()Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "soManagerDelegate", "Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "O", "Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "()Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "pluginServiceDelegate", "Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;", "Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;", "b0", "()Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;", "videoControl", "Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "()Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "httpDownloader", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", "()Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", "offlineManager", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "()Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "qqLiveSSORequest", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "d0", "()Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "wxAuthApi", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "()Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "qCircleApi", "Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;", "Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;", "()Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;", "eventDispatcherDelegate", "Lcom/tencent/ecommerce/biz/lucy/ILucyApi;", "Lcom/tencent/ecommerce/biz/lucy/ILucyApi;", "()Lcom/tencent/ecommerce/biz/lucy/ILucyApi;", "lucyApi", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;", "()Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;", "searchBarCreator", "Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "Z", "()Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "vasPay", "Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "()Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "qTroopService", "Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "a0", "Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "()Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "guildApi", "Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "()Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "qqApi", "Lcom/tencent/ecommerce/biz/game/api/IECGameApi;", "Lcom/tencent/ecommerce/biz/game/api/IECGameApi;", "()Lcom/tencent/ecommerce/biz/game/api/IECGameApi;", "gameApi", "Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;", "Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;", "()Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;", "resourceApi", "Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "e0", "Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "()Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "kuiklyImageFetcher", "Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;", "f0", "Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;", "()Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;", "vibrationApi", "Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "g0", "Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "()Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "renderViewRegister", "<init>", "(Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;Lcom/tencent/ecommerce/base/logger/api/IECLog;Lcom/tencent/ecommerce/base/network/api/IECSender;Lcom/tencent/ecommerce/base/report/api/IECDataReport;Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;Lcom/tencent/ecommerce/base/router/api/IECScheme;Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;Lcom/tencent/ecommerce/base/permission/api/IPermission;Lcom/tencent/ecommerce/biz/wallet/IWallet;Lcom/tencent/ecommerce/base/account/api/IECAccountManager;Lcom/tencent/ecommerce/base/ui/api/IECToast;Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;Lcom/tencent/ecommerce/base/nightmode/api/IECNightManager;Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;Lcom/tencent/ecommerce/base/share/api/IECShareProxy;Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;Lcom/tencent/ecommerce/base/compress/IECCompressOperator;Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;Lcom/tencent/ecommerce/biz/lucy/ILucyApi;Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;Lcom/tencent/ecommerce/biz/game/api/IECGameApi;Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class QQECGlobalInternalSdk {

    /* renamed from: A, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECPagSoLoader pagSoLoader;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECLiveNumberFontLoader liveNumberFontLoader;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECDeviceInfo deviceInfo;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECThreadPoolProxy threadPool;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECSkinApi skinApi;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECPhotoBrowser photoBrowser;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECLocationServiceProxy locationService;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECMediaSelector mediaSelector;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECCompressOperator compressOperator;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECPayApi payApi;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECPublicAccountManager publicAccountManager;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    @NotNull
    private final IECMiniAppLauncher miniAppLauncher;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECActivityDelegate activityDelegate;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECSoManager soManagerDelegate;

    /* renamed from: O, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECPluginServiceDelegate pluginServiceDelegate;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECVideoControlDelegate videoControl;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECHttpDownloader httpDownloader;

    /* renamed from: R, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECOfflineManager offlineManager;

    /* renamed from: S, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECQQLiveSSORequest qqLiveSSORequest;

    /* renamed from: T, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECWXAuthApi wxAuthApi;

    /* renamed from: U, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECQCircleApi qCircleApi;

    /* renamed from: V, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECEventDispatcherDelegate eventDispatcherDelegate;

    /* renamed from: W, reason: from kotlin metadata and from toString */
    @Nullable
    private final ILucyApi lucyApi;

    /* renamed from: X, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECSearchBarCreator searchBarCreator;

    /* renamed from: Y, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECVasRechargeApi vasPay;

    /* renamed from: Z, reason: from kotlin metadata and from toString */
    @Nullable
    private final IECQTroopServiceApi qTroopService;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECRuntime runtime;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECGuildApi guildApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECLog logger;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECQQApi qqApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECSender network;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECGameApi gameApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECDataReport reporter;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECResourceApi resourceApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECMobileReportManager mobileReporter;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IKuiklyImageFetcher kuiklyImageFetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECScheme scheme;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECVibrationApi vibrationApi;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECTicketManager ticket;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECRenderViewRegister renderViewRegister;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECImageLoader imageLoader;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECUploaderFactory uploaderFactory;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IPermission permission;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IWallet wallet;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECAccountManager accountManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECToast toast;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECRemoteConfig remoteConfig;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECFaceVerification faceVerification;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECOpenTelemetry openTelemetry;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECNightManager nightManager;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECHippyProxy hippyProxy;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECShareProxy shareProxy;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECImagePreloadManager imagePreloadManager;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECBizModuleProxy bizModuleProxy;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECLocalConfig localMMKVConfig;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final INVViewModelInitialization nvViewModelInitialization;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECGameProxy gameProxy;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IECRMonitorManager rMonitorManager;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IECApngLoader apngLoader;

    public QQECGlobalInternalSdk(@NotNull IECRuntime iECRuntime, @NotNull IECLog iECLog, @NotNull IECSender iECSender, @NotNull IECDataReport iECDataReport, @NotNull IECMobileReportManager iECMobileReportManager, @NotNull IECScheme iECScheme, @NotNull IECTicketManager iECTicketManager, @NotNull IECImageLoader iECImageLoader, @NotNull IECUploaderFactory iECUploaderFactory, @Nullable IPermission iPermission, @Nullable IWallet iWallet, @NotNull IECAccountManager iECAccountManager, @NotNull IECToast iECToast, @NotNull IECRemoteConfig iECRemoteConfig, @NotNull IECFaceVerification iECFaceVerification, @NotNull IECOpenTelemetry iECOpenTelemetry, @NotNull IECNightManager iECNightManager, @NotNull IECHippyProxy iECHippyProxy, @NotNull IECShareProxy iECShareProxy, @NotNull IECImagePreloadManager iECImagePreloadManager, @NotNull IECBizModuleProxy iECBizModuleProxy, @Nullable IECLocalConfig iECLocalConfig, @Nullable INVViewModelInitialization iNVViewModelInitialization, @NotNull IECGameProxy iECGameProxy, @Nullable IECRMonitorManager iECRMonitorManager, @NotNull IECApngLoader iECApngLoader, @NotNull IECPagSoLoader iECPagSoLoader, @Nullable IECLiveNumberFontLoader iECLiveNumberFontLoader, @Nullable IECDeviceInfo iECDeviceInfo, @NotNull IECThreadPoolProxy iECThreadPoolProxy, @NotNull IECSkinApi iECSkinApi, @Nullable IECPhotoBrowser iECPhotoBrowser, @NotNull IECLocationServiceProxy iECLocationServiceProxy, @NotNull IECMediaSelector iECMediaSelector, @NotNull IECCompressOperator iECCompressOperator, @NotNull IECPayApi iECPayApi, @NotNull IECPublicAccountManager iECPublicAccountManager, @NotNull IECMiniAppLauncher iECMiniAppLauncher, @Nullable IECActivityDelegate iECActivityDelegate, @Nullable IECSoManager iECSoManager, @Nullable IECPluginServiceDelegate iECPluginServiceDelegate, @Nullable IECVideoControlDelegate iECVideoControlDelegate, @Nullable IECHttpDownloader iECHttpDownloader, @Nullable IECOfflineManager iECOfflineManager, @Nullable IECQQLiveSSORequest iECQQLiveSSORequest, @Nullable IECWXAuthApi iECWXAuthApi, @Nullable IECQCircleApi iECQCircleApi, @Nullable IECEventDispatcherDelegate iECEventDispatcherDelegate, @Nullable ILucyApi iLucyApi, @Nullable IECSearchBarCreator iECSearchBarCreator, @Nullable IECVasRechargeApi iECVasRechargeApi, @Nullable IECQTroopServiceApi iECQTroopServiceApi, @Nullable IECGuildApi iECGuildApi, @Nullable IECQQApi iECQQApi, @Nullable IECGameApi iECGameApi, @Nullable IECResourceApi iECResourceApi, @Nullable IKuiklyImageFetcher iKuiklyImageFetcher, @Nullable IECVibrationApi iECVibrationApi, @Nullable IECRenderViewRegister iECRenderViewRegister) {
        this.runtime = iECRuntime;
        this.logger = iECLog;
        this.network = iECSender;
        this.reporter = iECDataReport;
        this.mobileReporter = iECMobileReportManager;
        this.scheme = iECScheme;
        this.ticket = iECTicketManager;
        this.imageLoader = iECImageLoader;
        this.uploaderFactory = iECUploaderFactory;
        this.permission = iPermission;
        this.wallet = iWallet;
        this.accountManager = iECAccountManager;
        this.toast = iECToast;
        this.remoteConfig = iECRemoteConfig;
        this.faceVerification = iECFaceVerification;
        this.openTelemetry = iECOpenTelemetry;
        this.nightManager = iECNightManager;
        this.hippyProxy = iECHippyProxy;
        this.shareProxy = iECShareProxy;
        this.imagePreloadManager = iECImagePreloadManager;
        this.bizModuleProxy = iECBizModuleProxy;
        this.localMMKVConfig = iECLocalConfig;
        this.nvViewModelInitialization = iNVViewModelInitialization;
        this.gameProxy = iECGameProxy;
        this.rMonitorManager = iECRMonitorManager;
        this.apngLoader = iECApngLoader;
        this.pagSoLoader = iECPagSoLoader;
        this.liveNumberFontLoader = iECLiveNumberFontLoader;
        this.deviceInfo = iECDeviceInfo;
        this.threadPool = iECThreadPoolProxy;
        this.skinApi = iECSkinApi;
        this.photoBrowser = iECPhotoBrowser;
        this.locationService = iECLocationServiceProxy;
        this.mediaSelector = iECMediaSelector;
        this.compressOperator = iECCompressOperator;
        this.payApi = iECPayApi;
        this.publicAccountManager = iECPublicAccountManager;
        this.miniAppLauncher = iECMiniAppLauncher;
        this.activityDelegate = iECActivityDelegate;
        this.soManagerDelegate = iECSoManager;
        this.pluginServiceDelegate = iECPluginServiceDelegate;
        this.videoControl = iECVideoControlDelegate;
        this.httpDownloader = iECHttpDownloader;
        this.offlineManager = iECOfflineManager;
        this.qqLiveSSORequest = iECQQLiveSSORequest;
        this.wxAuthApi = iECWXAuthApi;
        this.qCircleApi = iECQCircleApi;
        this.eventDispatcherDelegate = iECEventDispatcherDelegate;
        this.lucyApi = iLucyApi;
        this.searchBarCreator = iECSearchBarCreator;
        this.vasPay = iECVasRechargeApi;
        this.qTroopService = iECQTroopServiceApi;
        this.guildApi = iECGuildApi;
        this.qqApi = iECQQApi;
        this.gameApi = iECGameApi;
        this.resourceApi = iECResourceApi;
        this.kuiklyImageFetcher = iKuiklyImageFetcher;
        this.vibrationApi = iECVibrationApi;
        this.renderViewRegister = iECRenderViewRegister;
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final IECPagSoLoader getPagSoLoader() {
        return this.pagSoLoader;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final IECPayApi getPayApi() {
        return this.payApi;
    }

    @Nullable
    /* renamed from: C, reason: from getter */
    public final IPermission getPermission() {
        return this.permission;
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final IECPhotoBrowser getPhotoBrowser() {
        return this.photoBrowser;
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final IECPluginServiceDelegate getPluginServiceDelegate() {
        return this.pluginServiceDelegate;
    }

    @NotNull
    /* renamed from: F, reason: from getter */
    public final IECPublicAccountManager getPublicAccountManager() {
        return this.publicAccountManager;
    }

    @Nullable
    /* renamed from: G, reason: from getter */
    public final IECQCircleApi getQCircleApi() {
        return this.qCircleApi;
    }

    @Nullable
    /* renamed from: H, reason: from getter */
    public final IECQTroopServiceApi getQTroopService() {
        return this.qTroopService;
    }

    @Nullable
    /* renamed from: I, reason: from getter */
    public final IECQQApi getQqApi() {
        return this.qqApi;
    }

    @Nullable
    /* renamed from: J, reason: from getter */
    public final IECQQLiveSSORequest getQqLiveSSORequest() {
        return this.qqLiveSSORequest;
    }

    @Nullable
    /* renamed from: K, reason: from getter */
    public final IECRMonitorManager getRMonitorManager() {
        return this.rMonitorManager;
    }

    @NotNull
    /* renamed from: L, reason: from getter */
    public final IECRemoteConfig getRemoteConfig() {
        return this.remoteConfig;
    }

    @Nullable
    /* renamed from: M, reason: from getter */
    public final IECRenderViewRegister getRenderViewRegister() {
        return this.renderViewRegister;
    }

    @NotNull
    /* renamed from: N, reason: from getter */
    public final IECDataReport getReporter() {
        return this.reporter;
    }

    @Nullable
    /* renamed from: O, reason: from getter */
    public final IECResourceApi getResourceApi() {
        return this.resourceApi;
    }

    @NotNull
    /* renamed from: P, reason: from getter */
    public final IECRuntime getRuntime() {
        return this.runtime;
    }

    @NotNull
    /* renamed from: Q, reason: from getter */
    public final IECScheme getScheme() {
        return this.scheme;
    }

    @Nullable
    /* renamed from: R, reason: from getter */
    public final IECSearchBarCreator getSearchBarCreator() {
        return this.searchBarCreator;
    }

    @NotNull
    /* renamed from: S, reason: from getter */
    public final IECShareProxy getShareProxy() {
        return this.shareProxy;
    }

    @NotNull
    /* renamed from: T, reason: from getter */
    public final IECSkinApi getSkinApi() {
        return this.skinApi;
    }

    @Nullable
    /* renamed from: U, reason: from getter */
    public final IECSoManager getSoManagerDelegate() {
        return this.soManagerDelegate;
    }

    @NotNull
    /* renamed from: V, reason: from getter */
    public final IECThreadPoolProxy getThreadPool() {
        return this.threadPool;
    }

    @NotNull
    /* renamed from: W, reason: from getter */
    public final IECTicketManager getTicket() {
        return this.ticket;
    }

    @NotNull
    /* renamed from: X, reason: from getter */
    public final IECToast getToast() {
        return this.toast;
    }

    @NotNull
    /* renamed from: Y, reason: from getter */
    public final IECUploaderFactory getUploaderFactory() {
        return this.uploaderFactory;
    }

    @Nullable
    /* renamed from: Z, reason: from getter */
    public final IECVasRechargeApi getVasPay() {
        return this.vasPay;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final IECAccountManager getAccountManager() {
        return this.accountManager;
    }

    @Nullable
    /* renamed from: a0, reason: from getter */
    public final IECVibrationApi getVibrationApi() {
        return this.vibrationApi;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final IECActivityDelegate getActivityDelegate() {
        return this.activityDelegate;
    }

    @Nullable
    /* renamed from: b0, reason: from getter */
    public final IECVideoControlDelegate getVideoControl() {
        return this.videoControl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IECBizModuleProxy getBizModuleProxy() {
        return this.bizModuleProxy;
    }

    @Nullable
    /* renamed from: c0, reason: from getter */
    public final IWallet getWallet() {
        return this.wallet;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final IECDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Nullable
    /* renamed from: d0, reason: from getter */
    public final IECWXAuthApi getWxAuthApi() {
        return this.wxAuthApi;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final IECEventDispatcherDelegate getEventDispatcherDelegate() {
        return this.eventDispatcherDelegate;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof QQECGlobalInternalSdk) {
                QQECGlobalInternalSdk qQECGlobalInternalSdk = (QQECGlobalInternalSdk) other;
                if (!Intrinsics.areEqual(this.runtime, qQECGlobalInternalSdk.runtime) || !Intrinsics.areEqual(this.logger, qQECGlobalInternalSdk.logger) || !Intrinsics.areEqual(this.network, qQECGlobalInternalSdk.network) || !Intrinsics.areEqual(this.reporter, qQECGlobalInternalSdk.reporter) || !Intrinsics.areEqual(this.mobileReporter, qQECGlobalInternalSdk.mobileReporter) || !Intrinsics.areEqual(this.scheme, qQECGlobalInternalSdk.scheme) || !Intrinsics.areEqual(this.ticket, qQECGlobalInternalSdk.ticket) || !Intrinsics.areEqual(this.imageLoader, qQECGlobalInternalSdk.imageLoader) || !Intrinsics.areEqual(this.uploaderFactory, qQECGlobalInternalSdk.uploaderFactory) || !Intrinsics.areEqual(this.permission, qQECGlobalInternalSdk.permission) || !Intrinsics.areEqual(this.wallet, qQECGlobalInternalSdk.wallet) || !Intrinsics.areEqual(this.accountManager, qQECGlobalInternalSdk.accountManager) || !Intrinsics.areEqual(this.toast, qQECGlobalInternalSdk.toast) || !Intrinsics.areEqual(this.remoteConfig, qQECGlobalInternalSdk.remoteConfig) || !Intrinsics.areEqual(this.faceVerification, qQECGlobalInternalSdk.faceVerification) || !Intrinsics.areEqual(this.openTelemetry, qQECGlobalInternalSdk.openTelemetry) || !Intrinsics.areEqual(this.nightManager, qQECGlobalInternalSdk.nightManager) || !Intrinsics.areEqual(this.hippyProxy, qQECGlobalInternalSdk.hippyProxy) || !Intrinsics.areEqual(this.shareProxy, qQECGlobalInternalSdk.shareProxy) || !Intrinsics.areEqual(this.imagePreloadManager, qQECGlobalInternalSdk.imagePreloadManager) || !Intrinsics.areEqual(this.bizModuleProxy, qQECGlobalInternalSdk.bizModuleProxy) || !Intrinsics.areEqual(this.localMMKVConfig, qQECGlobalInternalSdk.localMMKVConfig) || !Intrinsics.areEqual(this.nvViewModelInitialization, qQECGlobalInternalSdk.nvViewModelInitialization) || !Intrinsics.areEqual(this.gameProxy, qQECGlobalInternalSdk.gameProxy) || !Intrinsics.areEqual(this.rMonitorManager, qQECGlobalInternalSdk.rMonitorManager) || !Intrinsics.areEqual(this.apngLoader, qQECGlobalInternalSdk.apngLoader) || !Intrinsics.areEqual(this.pagSoLoader, qQECGlobalInternalSdk.pagSoLoader) || !Intrinsics.areEqual(this.liveNumberFontLoader, qQECGlobalInternalSdk.liveNumberFontLoader) || !Intrinsics.areEqual(this.deviceInfo, qQECGlobalInternalSdk.deviceInfo) || !Intrinsics.areEqual(this.threadPool, qQECGlobalInternalSdk.threadPool) || !Intrinsics.areEqual(this.skinApi, qQECGlobalInternalSdk.skinApi) || !Intrinsics.areEqual(this.photoBrowser, qQECGlobalInternalSdk.photoBrowser) || !Intrinsics.areEqual(this.locationService, qQECGlobalInternalSdk.locationService) || !Intrinsics.areEqual(this.mediaSelector, qQECGlobalInternalSdk.mediaSelector) || !Intrinsics.areEqual(this.compressOperator, qQECGlobalInternalSdk.compressOperator) || !Intrinsics.areEqual(this.payApi, qQECGlobalInternalSdk.payApi) || !Intrinsics.areEqual(this.publicAccountManager, qQECGlobalInternalSdk.publicAccountManager) || !Intrinsics.areEqual(this.miniAppLauncher, qQECGlobalInternalSdk.miniAppLauncher) || !Intrinsics.areEqual(this.activityDelegate, qQECGlobalInternalSdk.activityDelegate) || !Intrinsics.areEqual(this.soManagerDelegate, qQECGlobalInternalSdk.soManagerDelegate) || !Intrinsics.areEqual(this.pluginServiceDelegate, qQECGlobalInternalSdk.pluginServiceDelegate) || !Intrinsics.areEqual(this.videoControl, qQECGlobalInternalSdk.videoControl) || !Intrinsics.areEqual(this.httpDownloader, qQECGlobalInternalSdk.httpDownloader) || !Intrinsics.areEqual(this.offlineManager, qQECGlobalInternalSdk.offlineManager) || !Intrinsics.areEqual(this.qqLiveSSORequest, qQECGlobalInternalSdk.qqLiveSSORequest) || !Intrinsics.areEqual(this.wxAuthApi, qQECGlobalInternalSdk.wxAuthApi) || !Intrinsics.areEqual(this.qCircleApi, qQECGlobalInternalSdk.qCircleApi) || !Intrinsics.areEqual(this.eventDispatcherDelegate, qQECGlobalInternalSdk.eventDispatcherDelegate) || !Intrinsics.areEqual(this.lucyApi, qQECGlobalInternalSdk.lucyApi) || !Intrinsics.areEqual(this.searchBarCreator, qQECGlobalInternalSdk.searchBarCreator) || !Intrinsics.areEqual(this.vasPay, qQECGlobalInternalSdk.vasPay) || !Intrinsics.areEqual(this.qTroopService, qQECGlobalInternalSdk.qTroopService) || !Intrinsics.areEqual(this.guildApi, qQECGlobalInternalSdk.guildApi) || !Intrinsics.areEqual(this.qqApi, qQECGlobalInternalSdk.qqApi) || !Intrinsics.areEqual(this.gameApi, qQECGlobalInternalSdk.gameApi) || !Intrinsics.areEqual(this.resourceApi, qQECGlobalInternalSdk.resourceApi) || !Intrinsics.areEqual(this.kuiklyImageFetcher, qQECGlobalInternalSdk.kuiklyImageFetcher) || !Intrinsics.areEqual(this.vibrationApi, qQECGlobalInternalSdk.vibrationApi) || !Intrinsics.areEqual(this.renderViewRegister, qQECGlobalInternalSdk.renderViewRegister)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final IECFaceVerification getFaceVerification() {
        return this.faceVerification;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final IECGameApi getGameApi() {
        return this.gameApi;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final IECGameProxy getGameProxy() {
        return this.gameProxy;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        int i77;
        int i78;
        int i79;
        int i85;
        int i86;
        int i87;
        int i88;
        int i89;
        int i95;
        int i96;
        int i97;
        int i98;
        int i99;
        int i100;
        int i101;
        int i102;
        int i103;
        int i104;
        int i105;
        int i106;
        int i107;
        int i108;
        int i109;
        int i110;
        int i111;
        int i112;
        int i113;
        int i114;
        int i115;
        int i116;
        IECRuntime iECRuntime = this.runtime;
        int i117 = 0;
        if (iECRuntime != null) {
            i3 = iECRuntime.hashCode();
        } else {
            i3 = 0;
        }
        int i118 = i3 * 31;
        IECLog iECLog = this.logger;
        if (iECLog != null) {
            i16 = iECLog.hashCode();
        } else {
            i16 = 0;
        }
        int i119 = (i118 + i16) * 31;
        IECSender iECSender = this.network;
        if (iECSender != null) {
            i17 = iECSender.hashCode();
        } else {
            i17 = 0;
        }
        int i120 = (i119 + i17) * 31;
        IECDataReport iECDataReport = this.reporter;
        if (iECDataReport != null) {
            i18 = iECDataReport.hashCode();
        } else {
            i18 = 0;
        }
        int i121 = (i120 + i18) * 31;
        IECMobileReportManager iECMobileReportManager = this.mobileReporter;
        if (iECMobileReportManager != null) {
            i19 = iECMobileReportManager.hashCode();
        } else {
            i19 = 0;
        }
        int i122 = (i121 + i19) * 31;
        IECScheme iECScheme = this.scheme;
        if (iECScheme != null) {
            i26 = iECScheme.hashCode();
        } else {
            i26 = 0;
        }
        int i123 = (i122 + i26) * 31;
        IECTicketManager iECTicketManager = this.ticket;
        if (iECTicketManager != null) {
            i27 = iECTicketManager.hashCode();
        } else {
            i27 = 0;
        }
        int i124 = (i123 + i27) * 31;
        IECImageLoader iECImageLoader = this.imageLoader;
        if (iECImageLoader != null) {
            i28 = iECImageLoader.hashCode();
        } else {
            i28 = 0;
        }
        int i125 = (i124 + i28) * 31;
        IECUploaderFactory iECUploaderFactory = this.uploaderFactory;
        if (iECUploaderFactory != null) {
            i29 = iECUploaderFactory.hashCode();
        } else {
            i29 = 0;
        }
        int i126 = (i125 + i29) * 31;
        IPermission iPermission = this.permission;
        if (iPermission != null) {
            i36 = iPermission.hashCode();
        } else {
            i36 = 0;
        }
        int i127 = (i126 + i36) * 31;
        IWallet iWallet = this.wallet;
        if (iWallet != null) {
            i37 = iWallet.hashCode();
        } else {
            i37 = 0;
        }
        int i128 = (i127 + i37) * 31;
        IECAccountManager iECAccountManager = this.accountManager;
        if (iECAccountManager != null) {
            i38 = iECAccountManager.hashCode();
        } else {
            i38 = 0;
        }
        int i129 = (i128 + i38) * 31;
        IECToast iECToast = this.toast;
        if (iECToast != null) {
            i39 = iECToast.hashCode();
        } else {
            i39 = 0;
        }
        int i130 = (i129 + i39) * 31;
        IECRemoteConfig iECRemoteConfig = this.remoteConfig;
        if (iECRemoteConfig != null) {
            i46 = iECRemoteConfig.hashCode();
        } else {
            i46 = 0;
        }
        int i131 = (i130 + i46) * 31;
        IECFaceVerification iECFaceVerification = this.faceVerification;
        if (iECFaceVerification != null) {
            i47 = iECFaceVerification.hashCode();
        } else {
            i47 = 0;
        }
        int i132 = (i131 + i47) * 31;
        IECOpenTelemetry iECOpenTelemetry = this.openTelemetry;
        if (iECOpenTelemetry != null) {
            i48 = iECOpenTelemetry.hashCode();
        } else {
            i48 = 0;
        }
        int i133 = (i132 + i48) * 31;
        IECNightManager iECNightManager = this.nightManager;
        if (iECNightManager != null) {
            i49 = iECNightManager.hashCode();
        } else {
            i49 = 0;
        }
        int i134 = (i133 + i49) * 31;
        IECHippyProxy iECHippyProxy = this.hippyProxy;
        if (iECHippyProxy != null) {
            i56 = iECHippyProxy.hashCode();
        } else {
            i56 = 0;
        }
        int i135 = (i134 + i56) * 31;
        IECShareProxy iECShareProxy = this.shareProxy;
        if (iECShareProxy != null) {
            i57 = iECShareProxy.hashCode();
        } else {
            i57 = 0;
        }
        int i136 = (i135 + i57) * 31;
        IECImagePreloadManager iECImagePreloadManager = this.imagePreloadManager;
        if (iECImagePreloadManager != null) {
            i58 = iECImagePreloadManager.hashCode();
        } else {
            i58 = 0;
        }
        int i137 = (i136 + i58) * 31;
        IECBizModuleProxy iECBizModuleProxy = this.bizModuleProxy;
        if (iECBizModuleProxy != null) {
            i59 = iECBizModuleProxy.hashCode();
        } else {
            i59 = 0;
        }
        int i138 = (i137 + i59) * 31;
        IECLocalConfig iECLocalConfig = this.localMMKVConfig;
        if (iECLocalConfig != null) {
            i65 = iECLocalConfig.hashCode();
        } else {
            i65 = 0;
        }
        int i139 = (i138 + i65) * 31;
        INVViewModelInitialization iNVViewModelInitialization = this.nvViewModelInitialization;
        if (iNVViewModelInitialization != null) {
            i66 = iNVViewModelInitialization.hashCode();
        } else {
            i66 = 0;
        }
        int i140 = (i139 + i66) * 31;
        IECGameProxy iECGameProxy = this.gameProxy;
        if (iECGameProxy != null) {
            i67 = iECGameProxy.hashCode();
        } else {
            i67 = 0;
        }
        int i141 = (i140 + i67) * 31;
        IECRMonitorManager iECRMonitorManager = this.rMonitorManager;
        if (iECRMonitorManager != null) {
            i68 = iECRMonitorManager.hashCode();
        } else {
            i68 = 0;
        }
        int i142 = (i141 + i68) * 31;
        IECApngLoader iECApngLoader = this.apngLoader;
        if (iECApngLoader != null) {
            i69 = iECApngLoader.hashCode();
        } else {
            i69 = 0;
        }
        int i143 = (i142 + i69) * 31;
        IECPagSoLoader iECPagSoLoader = this.pagSoLoader;
        if (iECPagSoLoader != null) {
            i75 = iECPagSoLoader.hashCode();
        } else {
            i75 = 0;
        }
        int i144 = (i143 + i75) * 31;
        IECLiveNumberFontLoader iECLiveNumberFontLoader = this.liveNumberFontLoader;
        if (iECLiveNumberFontLoader != null) {
            i76 = iECLiveNumberFontLoader.hashCode();
        } else {
            i76 = 0;
        }
        int i145 = (i144 + i76) * 31;
        IECDeviceInfo iECDeviceInfo = this.deviceInfo;
        if (iECDeviceInfo != null) {
            i77 = iECDeviceInfo.hashCode();
        } else {
            i77 = 0;
        }
        int i146 = (i145 + i77) * 31;
        IECThreadPoolProxy iECThreadPoolProxy = this.threadPool;
        if (iECThreadPoolProxy != null) {
            i78 = iECThreadPoolProxy.hashCode();
        } else {
            i78 = 0;
        }
        int i147 = (i146 + i78) * 31;
        IECSkinApi iECSkinApi = this.skinApi;
        if (iECSkinApi != null) {
            i79 = iECSkinApi.hashCode();
        } else {
            i79 = 0;
        }
        int i148 = (i147 + i79) * 31;
        IECPhotoBrowser iECPhotoBrowser = this.photoBrowser;
        if (iECPhotoBrowser != null) {
            i85 = iECPhotoBrowser.hashCode();
        } else {
            i85 = 0;
        }
        int i149 = (i148 + i85) * 31;
        IECLocationServiceProxy iECLocationServiceProxy = this.locationService;
        if (iECLocationServiceProxy != null) {
            i86 = iECLocationServiceProxy.hashCode();
        } else {
            i86 = 0;
        }
        int i150 = (i149 + i86) * 31;
        IECMediaSelector iECMediaSelector = this.mediaSelector;
        if (iECMediaSelector != null) {
            i87 = iECMediaSelector.hashCode();
        } else {
            i87 = 0;
        }
        int i151 = (i150 + i87) * 31;
        IECCompressOperator iECCompressOperator = this.compressOperator;
        if (iECCompressOperator != null) {
            i88 = iECCompressOperator.hashCode();
        } else {
            i88 = 0;
        }
        int i152 = (i151 + i88) * 31;
        IECPayApi iECPayApi = this.payApi;
        if (iECPayApi != null) {
            i89 = iECPayApi.hashCode();
        } else {
            i89 = 0;
        }
        int i153 = (i152 + i89) * 31;
        IECPublicAccountManager iECPublicAccountManager = this.publicAccountManager;
        if (iECPublicAccountManager != null) {
            i95 = iECPublicAccountManager.hashCode();
        } else {
            i95 = 0;
        }
        int i154 = (i153 + i95) * 31;
        IECMiniAppLauncher iECMiniAppLauncher = this.miniAppLauncher;
        if (iECMiniAppLauncher != null) {
            i96 = iECMiniAppLauncher.hashCode();
        } else {
            i96 = 0;
        }
        int i155 = (i154 + i96) * 31;
        IECActivityDelegate iECActivityDelegate = this.activityDelegate;
        if (iECActivityDelegate != null) {
            i97 = iECActivityDelegate.hashCode();
        } else {
            i97 = 0;
        }
        int i156 = (i155 + i97) * 31;
        IECSoManager iECSoManager = this.soManagerDelegate;
        if (iECSoManager != null) {
            i98 = iECSoManager.hashCode();
        } else {
            i98 = 0;
        }
        int i157 = (i156 + i98) * 31;
        IECPluginServiceDelegate iECPluginServiceDelegate = this.pluginServiceDelegate;
        if (iECPluginServiceDelegate != null) {
            i99 = iECPluginServiceDelegate.hashCode();
        } else {
            i99 = 0;
        }
        int i158 = (i157 + i99) * 31;
        IECVideoControlDelegate iECVideoControlDelegate = this.videoControl;
        if (iECVideoControlDelegate != null) {
            i100 = iECVideoControlDelegate.hashCode();
        } else {
            i100 = 0;
        }
        int i159 = (i158 + i100) * 31;
        IECHttpDownloader iECHttpDownloader = this.httpDownloader;
        if (iECHttpDownloader != null) {
            i101 = iECHttpDownloader.hashCode();
        } else {
            i101 = 0;
        }
        int i160 = (i159 + i101) * 31;
        IECOfflineManager iECOfflineManager = this.offlineManager;
        if (iECOfflineManager != null) {
            i102 = iECOfflineManager.hashCode();
        } else {
            i102 = 0;
        }
        int i161 = (i160 + i102) * 31;
        IECQQLiveSSORequest iECQQLiveSSORequest = this.qqLiveSSORequest;
        if (iECQQLiveSSORequest != null) {
            i103 = iECQQLiveSSORequest.hashCode();
        } else {
            i103 = 0;
        }
        int i162 = (i161 + i103) * 31;
        IECWXAuthApi iECWXAuthApi = this.wxAuthApi;
        if (iECWXAuthApi != null) {
            i104 = iECWXAuthApi.hashCode();
        } else {
            i104 = 0;
        }
        int i163 = (i162 + i104) * 31;
        IECQCircleApi iECQCircleApi = this.qCircleApi;
        if (iECQCircleApi != null) {
            i105 = iECQCircleApi.hashCode();
        } else {
            i105 = 0;
        }
        int i164 = (i163 + i105) * 31;
        IECEventDispatcherDelegate iECEventDispatcherDelegate = this.eventDispatcherDelegate;
        if (iECEventDispatcherDelegate != null) {
            i106 = iECEventDispatcherDelegate.hashCode();
        } else {
            i106 = 0;
        }
        int i165 = (i164 + i106) * 31;
        ILucyApi iLucyApi = this.lucyApi;
        if (iLucyApi != null) {
            i107 = iLucyApi.hashCode();
        } else {
            i107 = 0;
        }
        int i166 = (i165 + i107) * 31;
        IECSearchBarCreator iECSearchBarCreator = this.searchBarCreator;
        if (iECSearchBarCreator != null) {
            i108 = iECSearchBarCreator.hashCode();
        } else {
            i108 = 0;
        }
        int i167 = (i166 + i108) * 31;
        IECVasRechargeApi iECVasRechargeApi = this.vasPay;
        if (iECVasRechargeApi != null) {
            i109 = iECVasRechargeApi.hashCode();
        } else {
            i109 = 0;
        }
        int i168 = (i167 + i109) * 31;
        IECQTroopServiceApi iECQTroopServiceApi = this.qTroopService;
        if (iECQTroopServiceApi != null) {
            i110 = iECQTroopServiceApi.hashCode();
        } else {
            i110 = 0;
        }
        int i169 = (i168 + i110) * 31;
        IECGuildApi iECGuildApi = this.guildApi;
        if (iECGuildApi != null) {
            i111 = iECGuildApi.hashCode();
        } else {
            i111 = 0;
        }
        int i170 = (i169 + i111) * 31;
        IECQQApi iECQQApi = this.qqApi;
        if (iECQQApi != null) {
            i112 = iECQQApi.hashCode();
        } else {
            i112 = 0;
        }
        int i171 = (i170 + i112) * 31;
        IECGameApi iECGameApi = this.gameApi;
        if (iECGameApi != null) {
            i113 = iECGameApi.hashCode();
        } else {
            i113 = 0;
        }
        int i172 = (i171 + i113) * 31;
        IECResourceApi iECResourceApi = this.resourceApi;
        if (iECResourceApi != null) {
            i114 = iECResourceApi.hashCode();
        } else {
            i114 = 0;
        }
        int i173 = (i172 + i114) * 31;
        IKuiklyImageFetcher iKuiklyImageFetcher = this.kuiklyImageFetcher;
        if (iKuiklyImageFetcher != null) {
            i115 = iKuiklyImageFetcher.hashCode();
        } else {
            i115 = 0;
        }
        int i174 = (i173 + i115) * 31;
        IECVibrationApi iECVibrationApi = this.vibrationApi;
        if (iECVibrationApi != null) {
            i116 = iECVibrationApi.hashCode();
        } else {
            i116 = 0;
        }
        int i175 = (i174 + i116) * 31;
        IECRenderViewRegister iECRenderViewRegister = this.renderViewRegister;
        if (iECRenderViewRegister != null) {
            i117 = iECRenderViewRegister.hashCode();
        }
        return i175 + i117;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final IECGuildApi getGuildApi() {
        return this.guildApi;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final IECHippyProxy getHippyProxy() {
        return this.hippyProxy;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final IECHttpDownloader getHttpDownloader() {
        return this.httpDownloader;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final IECImageLoader getImageLoader() {
        return this.imageLoader;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final IECImagePreloadManager getImagePreloadManager() {
        return this.imagePreloadManager;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final IKuiklyImageFetcher getKuiklyImageFetcher() {
        return this.kuiklyImageFetcher;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final IECLocalConfig getLocalMMKVConfig() {
        return this.localMMKVConfig;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final IECLocationServiceProxy getLocationService() {
        return this.locationService;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final IECLog getLogger() {
        return this.logger;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final ILucyApi getLucyApi() {
        return this.lucyApi;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final IECMediaSelector getMediaSelector() {
        return this.mediaSelector;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final IECMiniAppLauncher getMiniAppLauncher() {
        return this.miniAppLauncher;
    }

    @NotNull
    public String toString() {
        return "QQECGlobalInternalSdk(runtime=" + this.runtime + ", logger=" + this.logger + ", network=" + this.network + ", reporter=" + this.reporter + ", mobileReporter=" + this.mobileReporter + ", scheme=" + this.scheme + ", ticket=" + this.ticket + ", imageLoader=" + this.imageLoader + ", uploaderFactory=" + this.uploaderFactory + ", permission=" + this.permission + ", wallet=" + this.wallet + ", accountManager=" + this.accountManager + ", toast=" + this.toast + ", remoteConfig=" + this.remoteConfig + ", faceVerification=" + this.faceVerification + ", openTelemetry=" + this.openTelemetry + ", nightManager=" + this.nightManager + ", hippyProxy=" + this.hippyProxy + ", shareProxy=" + this.shareProxy + ", imagePreloadManager=" + this.imagePreloadManager + ", bizModuleProxy=" + this.bizModuleProxy + ", localMMKVConfig=" + this.localMMKVConfig + ", nvViewModelInitialization=" + this.nvViewModelInitialization + ", gameProxy=" + this.gameProxy + ", rMonitorManager=" + this.rMonitorManager + ", apngLoader=" + this.apngLoader + ", pagSoLoader=" + this.pagSoLoader + ", liveNumberFontLoader=" + this.liveNumberFontLoader + ", deviceInfo=" + this.deviceInfo + ", threadPool=" + this.threadPool + ", skinApi=" + this.skinApi + ", photoBrowser=" + this.photoBrowser + ", locationService=" + this.locationService + ", mediaSelector=" + this.mediaSelector + ", compressOperator=" + this.compressOperator + ", payApi=" + this.payApi + ", publicAccountManager=" + this.publicAccountManager + ", miniAppLauncher=" + this.miniAppLauncher + ", activityDelegate=" + this.activityDelegate + ", soManagerDelegate=" + this.soManagerDelegate + ", pluginServiceDelegate=" + this.pluginServiceDelegate + ", videoControl=" + this.videoControl + ", httpDownloader=" + this.httpDownloader + ", offlineManager=" + this.offlineManager + ", qqLiveSSORequest=" + this.qqLiveSSORequest + ", wxAuthApi=" + this.wxAuthApi + ", qCircleApi=" + this.qCircleApi + ", eventDispatcherDelegate=" + this.eventDispatcherDelegate + ", lucyApi=" + this.lucyApi + ", searchBarCreator=" + this.searchBarCreator + ", vasPay=" + this.vasPay + ", qTroopService=" + this.qTroopService + ", guildApi=" + this.guildApi + ", qqApi=" + this.qqApi + ", gameApi=" + this.gameApi + ", resourceApi=" + this.resourceApi + ", kuiklyImageFetcher=" + this.kuiklyImageFetcher + ", vibrationApi=" + this.vibrationApi + ", renderViewRegister=" + this.renderViewRegister + ")";
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final IECMobileReportManager getMobileReporter() {
        return this.mobileReporter;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final IECSender getNetwork() {
        return this.network;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final IECNightManager getNightManager() {
        return this.nightManager;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final INVViewModelInitialization getNvViewModelInitialization() {
        return this.nvViewModelInitialization;
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final IECOfflineManager getOfflineManager() {
        return this.offlineManager;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final IECOpenTelemetry getOpenTelemetry() {
        return this.openTelemetry;
    }
}

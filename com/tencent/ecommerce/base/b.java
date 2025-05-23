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
import com.tencent.ecommerce.base.threadpool.api.ECDefaultThreadPool;
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
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;
import zf0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e2\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u00f8\u0001\u0010\u00f9\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+J\u000e\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.J\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u000201J\u000e\u00106\u001a\u00020\u00002\u0006\u00105\u001a\u000204J\u000e\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u000207J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010D\u001a\u00020CJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010G\u001a\u00020FJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010J\u001a\u00020IJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010M\u001a\u00020LJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010P\u001a\u00020OJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UJ\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020XJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[J\u000e\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u00020^J\u000e\u0010c\u001a\u00020\u00002\u0006\u0010b\u001a\u00020aJ\u000e\u0010f\u001a\u00020\u00002\u0006\u0010e\u001a\u00020dJ\u000e\u0010i\u001a\u00020\u00002\u0006\u0010h\u001a\u00020gJ\u000e\u0010l\u001a\u00020\u00002\u0006\u0010k\u001a\u00020jJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010n\u001a\u00020mJ\u000e\u0010r\u001a\u00020\u00002\u0006\u0010q\u001a\u00020pJ\u000e\u0010t\u001a\u00020\u00002\u0006\u0010q\u001a\u00020sJ\u000e\u0010v\u001a\u00020\u00002\u0006\u0010q\u001a\u00020uJ\u000e\u0010y\u001a\u00020\u00002\u0006\u0010x\u001a\u00020wJ\u000e\u0010|\u001a\u00020\u00002\u0006\u0010{\u001a\u00020zJ\u000e\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020}J\u0011\u0010\u0082\u0001\u001a\u00020\u00002\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001J\u0011\u0010\u0085\u0001\u001a\u00020\u00002\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\u00002\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u00002\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001J\u0011\u0010\u008e\u0001\u001a\u00020\u00002\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001J\u0011\u0010\u0091\u0001\u001a\u00020\u00002\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\u00002\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001J\u0011\u0010\u0097\u0001\u001a\u00020\u00002\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001J\u0011\u0010\u009a\u0001\u001a\u00020\u00002\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001J\u0011\u0010\u009d\u0001\u001a\u00020\u00002\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001J\u0011\u0010\u00a0\u0001\u001a\u00020\u00002\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001J\u0011\u0010\u00a3\u0001\u001a\u00020\u00002\b\u0010\u00a2\u0001\u001a\u00030\u00a1\u0001J\u0011\u0010\u00a6\u0001\u001a\u00020\u00002\b\u0010\u00a5\u0001\u001a\u00030\u00a4\u0001J\u0011\u0010\u00a9\u0001\u001a\u00020\u00002\b\u0010\u00a8\u0001\u001a\u00030\u00a7\u0001J\b\u0010\u00ab\u0001\u001a\u00030\u00aa\u0001R\u0018\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0017\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b$\u0010\u00ad\u0001R\u0017\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\br\u0010\u00ae\u0001R\u0017\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bN\u0010\u00af\u0001R\u0018\u0010\u00b1\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b?\u0010\u00b0\u0001R\u0017\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\r\u0010\u00b2\u0001R\u0017\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b]\u0010\u00b3\u0001R\u0017\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bf\u0010\u00b4\u0001R\u0017\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bc\u0010\u00b5\u0001R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bl\u0010\u00b6\u0001R\u001a\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u00b7\u0001R\u0017\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b-\u0010\u00b8\u0001R\u0018\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u00b9\u0001R\u0017\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bH\u0010\u00ba\u0001R\u0018\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u00bb\u0001R\u0017\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b6\u0010\u00bc\u0001R\u0017\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b|\u0010\u00bd\u0001R\u0019\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0018\u0010\u00be\u0001R\u0017\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u00bf\u0001R\u001a\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00c0\u0001R\u0017\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bT\u0010\u00c1\u0001R\u0019\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bB\u0010\u00c2\u0001R\u0019\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b`\u0010\u00c3\u0001R\u0017\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0007\u0010\u00c4\u0001R\u0019\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bo\u0010\u00c5\u0001R\u0017\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u000f\u0010\u00c6\u0001R\u0019\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bE\u0010\u00c7\u0001R\u0019\u0010\u00ca\u0001\u001a\u00030\u00c8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\n\u0010\u00c9\u0001R\u0019\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b3\u0010\u00cb\u0001R\u0019\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u00cc\u0001R\u0017\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b0\u0010\u00cd\u0001R\u0017\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bQ\u0010\u00ce\u0001R\u0018\u0010\u00d0\u0001\u001a\u00020d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bW\u0010\u00cf\u0001R\u0017\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u00d1\u0001R\u0017\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bZ\u0010\u00d2\u0001R\u0017\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bv\u0010\u00d3\u0001R\u0017\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bi\u0010\u00d4\u0001R\u001b\u0010\u00d6\u0001\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u00d5\u0001R\u001b\u0010\u00d8\u0001\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u00d7\u0001R\u001b\u0010\u00da\u0001\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u00d9\u0001R\u001b\u0010\u00dc\u0001\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00db\u0001R\u0017\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bK\u0010\u00dd\u0001R\u0019\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b*\u0010\u00de\u0001R\u001a\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00df\u0001R\u001c\u0010\u00e1\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u00e0\u0001R\u001b\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0004\u0010\u00e2\u0001R\u001b\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0012\u0010\u00e3\u0001R\u001c\u0010\u00e5\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u00e4\u0001R\u001b\u0010\u00e8\u0001\u001a\u0005\u0018\u00010\u00e6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u00e7\u0001R\u001b\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bt\u0010\u00e9\u0001R\u001b\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0015\u0010\u00eb\u0001R\u001b\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b'\u0010\u00ec\u0001R\u001b\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001b\u0010\u00ed\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u00ee\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00ef\u0001R\u001b\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\by\u0010\u00f0\u0001R\u001c\u0010\u00f2\u0001\u001a\u0005\u0018\u00010\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u00f1\u0001R\u001b\u0010\u00f4\u0001\u001a\u0005\u0018\u00010\u00a4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b!\u0010\u00f3\u0001R\u001c\u0010\u00f7\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001\u00a8\u0006\u00fa\u0001"}, d2 = {"Lcom/tencent/ecommerce/base/b;", "", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "runtime", "T", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "logger", HippyTKDListViewAdapter.X, "Lcom/tencent/ecommerce/base/network/api/IECSender;", "network", "B", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "reporter", "f", "Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/ecommerce/base/router/api/IECScheme;", ZPlanPublishSource.FROM_SCHEME, "U", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "ticket", "Y", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "imageLoader", "r", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "uploaderFactory", "a0", "Lcom/tencent/ecommerce/base/permission/api/IPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "H", "Lcom/tencent/ecommerce/biz/wallet/IWallet;", QCircleDaTongConstant.ElementParamValue.WALLET, "f0", "Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "accountManager", "b", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "toast", "Z", "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "remoteConfig", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "faceVerification", "l", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "openTelemetry", "E", "Lcom/tencent/ecommerce/base/nightmode/api/IECNightManager;", "nightManager", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "hippyProxy", "p", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "shareProxy", "W", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "imagePreloadManager", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;", "bizModuleProxy", "e", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "localMMKVConfig", "v", "Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;", "nvViewModelInitialization", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "gameProxy", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "rMonitorManager", "P", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "apngLoader", "d", "Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "pagSoLoader", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;", "liveNumberFontLoader", "u", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "payApi", "G", "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "photoBrowser", "I", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "deviceInfo", "g", "Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "locationService", "w", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "mediaSelector", "i", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", JsonRuleKey.OPERATOR, h.F, "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "publicAccountManager", "K", "Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "threadPool", "j", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "miniAppLauncher", "y", "Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;", "delegate", "c", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "X", "Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "J", "Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;", "videoEvent", "d0", "Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "httpDownloader", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", "offlineManager", "D", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "qqliveSSORequest", "N", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "wxAuthApi", "e0", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "qCircleApi", "L", "Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "guildApi", "o", "Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "qqApi", "M", "Lcom/tencent/ecommerce/biz/game/api/IECGameApi;", "gameApi", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;", "resourceApi", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;", "creator", "V", "Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;", "eventDelegate", "k", "Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "vasPay", "b0", "Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "qTroopService", "O", "Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "imageFetcher", "t", "Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;", DTConstants.TAG.API, "c0", "Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "register", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/a;", "a", "Lcom/tencent/ecommerce/base/runtime/api/IECRuntime;", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "Lcom/tencent/ecommerce/base/network/api/IECSender;", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "mobileReporter", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "Lcom/tencent/ecommerce/base/permission/api/IPermission;", "Lcom/tencent/ecommerce/biz/wallet/IWallet;", "Lcom/tencent/ecommerce/base/account/api/IECAccountManager;", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "Lcom/tencent/ecommerce/base/nightmode/api/IECNightManager;", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "Lcom/tencent/ecommerce/base/account/api/INVViewModelInitialization;", "Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "Lcom/tencent/ecommerce/biz/live/IECLiveNumberFontLoader;", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "skinApi", "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "Lcom/tencent/ecommerce/base/compress/IECCompressOperator;", "compressOperator", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "Lcom/tencent/ecommerce/base/plugin/IECActivityDelegate;", "activityDelegate", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "soManagerDelegate", "Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "pluginServiceDelegate", "Lcom/tencent/ecommerce/base/videnevent/api/IECVideoControlDelegate;", "videoControl", "Lcom/tencent/ecommerce/base/imageloader/api/IECPagSoLoader;", "Lcom/tencent/ecommerce/base/network/api/IECHttpDownloader;", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequest;", "qqLiveSSORequest", "Lcom/tencent/ecommerce/base/wx/api/IECWXAuthApi;", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "Lcom/tencent/ecommerce/base/event/api/IECEventDispatcherDelegate;", "eventDispatcherDelegate", "Lcom/tencent/ecommerce/biz/lucy/ILucyApi;", "Lcom/tencent/ecommerce/biz/lucy/ILucyApi;", "lucyApi", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBarCreator;", "searchBarCreator", "Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "Lcom/tencent/ecommerce/biz/game/api/IECGameApi;", "Lcom/tencent/ecommerce/biz/res/api/IECResourceApi;", "Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "kuiklyImageFetcher", "Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;", "vibrationApi", "g0", "Lcom/tencent/ecommerce/base/ui/api/IECRenderViewRegister;", "renderViewRegister", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: A, reason: from kotlin metadata */
    private IECLiveNumberFontLoader liveNumberFontLoader;

    /* renamed from: L, reason: from kotlin metadata */
    private IECActivityDelegate activityDelegate;

    /* renamed from: M, reason: from kotlin metadata */
    private IECSoManager soManagerDelegate;

    /* renamed from: N, reason: from kotlin metadata */
    private IECPluginServiceDelegate pluginServiceDelegate;

    /* renamed from: O, reason: from kotlin metadata */
    private IECVideoControlDelegate videoControl;

    /* renamed from: Q, reason: from kotlin metadata */
    private IECHttpDownloader httpDownloader;

    /* renamed from: R, reason: from kotlin metadata */
    private IECOfflineManager offlineManager;

    /* renamed from: S, reason: from kotlin metadata */
    private IECQQLiveSSORequest qqLiveSSORequest;

    /* renamed from: T, reason: from kotlin metadata */
    private IECWXAuthApi wxAuthApi;

    /* renamed from: U, reason: from kotlin metadata */
    private IECQCircleApi qCircleApi;

    /* renamed from: V, reason: from kotlin metadata */
    private IECEventDispatcherDelegate eventDispatcherDelegate;

    /* renamed from: W, reason: from kotlin metadata */
    private ILucyApi lucyApi;

    /* renamed from: X, reason: from kotlin metadata */
    private IECSearchBarCreator searchBarCreator;

    /* renamed from: Y, reason: from kotlin metadata */
    private IECVasRechargeApi vasPay;

    /* renamed from: Z, reason: from kotlin metadata */
    private IECQTroopServiceApi qTroopService;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private IECGuildApi guildApi;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private IECQQApi qqApi;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private IECGameApi gameApi;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private IECResourceApi resourceApi;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private IKuiklyImageFetcher kuiklyImageFetcher;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private IECVibrationApi vibrationApi;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private IECRenderViewRegister renderViewRegister;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private IPermission permission;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IWallet wallet;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private IECHippyProxy hippyProxy;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private IECShareProxy shareProxy;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private IECLocalConfig localMMKVConfig;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private INVViewModelInitialization nvViewModelInitialization;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private IECRMonitorManager rMonitorManager;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IECRuntime runtime = new vg0.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private IECLog logger = new bg0.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private IECSender network = new com.tencent.ecommerce.base.network.api.a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IECDataReport reporter = new sg0.a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IECMobileReportManager mobileReporter = new sg0.b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IECScheme scheme = new tg0.a();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private IECTicketManager ticket = new yg0.a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IECImageLoader imageLoader = new zf0.b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IECUploaderFactory uploaderFactory = new com.tencent.ecommerce.base.uploader.a();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private IECAccountManager accountManager = new wf0.b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IECToast toast = new com.tencent.ecommerce.base.ui.api.a();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private IECRemoteConfig remoteConfig = new xf0.a();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private IECFaceVerification faceVerification = wf0.a.f445555a;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private IECOpenTelemetry openTelemetry = new com.tencent.ecommerce.base.opentelemtry.api.a();

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private IECNightManager nightManager = new gg0.a();

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private IECImagePreloadManager imagePreloadManager = new mg0.a();

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private IECBizModuleProxy bizModuleProxy = new gj0.a();

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private IECGameProxy gameProxy = new com.tencent.ecommerce.biz.consumer.a();

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private IECApngLoader apngLoader = new zf0.a();

    /* renamed from: B, reason: from kotlin metadata */
    private IECSkinApi skinApi = com.tencent.ecommerce.base.ui.api.b.f101143b;

    /* renamed from: C, reason: from kotlin metadata */
    private IECPhotoBrowser photoBrowser = new kg0.a();

    /* renamed from: D, reason: from kotlin metadata */
    private IECDeviceInfo deviceInfo = new yf0.a();

    /* renamed from: E, reason: from kotlin metadata */
    private IECLocationServiceProxy locationService = new IECLocationServiceProxy.c();

    /* renamed from: F, reason: from kotlin metadata */
    private IECMediaSelector mediaSelector = new ig0.a();

    /* renamed from: G, reason: from kotlin metadata */
    private IECCompressOperator compressOperator = new IECCompressOperator.a();

    /* renamed from: H, reason: from kotlin metadata */
    private IECPayApi payApi = new ni0.a();

    /* renamed from: I, reason: from kotlin metadata */
    private IECPublicAccountManager publicAccountManager = new og0.a();

    /* renamed from: J, reason: from kotlin metadata */
    private IECThreadPoolProxy threadPool = new ECDefaultThreadPool();

    /* renamed from: K, reason: from kotlin metadata */
    private IECMiniAppLauncher miniAppLauncher = new com.tencent.ecommerce.base.miniapp.api.a();

    /* renamed from: P, reason: from kotlin metadata */
    private IECPagSoLoader pagSoLoader = new c();

    @NotNull
    public final b A(@NotNull INVViewModelInitialization nvViewModelInitialization) {
        this.nvViewModelInitialization = nvViewModelInitialization;
        return this;
    }

    @NotNull
    public final b B(@NotNull IECSender network) {
        this.network = network;
        return this;
    }

    @NotNull
    public final b C(@NotNull IECNightManager nightManager) {
        this.nightManager = nightManager;
        return this;
    }

    @NotNull
    public final b D(@NotNull IECOfflineManager offlineManager) {
        this.offlineManager = offlineManager;
        return this;
    }

    @NotNull
    public final b E(@NotNull IECOpenTelemetry openTelemetry) {
        this.openTelemetry = openTelemetry;
        return this;
    }

    @NotNull
    public final b F(@NotNull IECPagSoLoader pagSoLoader) {
        this.pagSoLoader = pagSoLoader;
        return this;
    }

    @NotNull
    public final b G(@NotNull IECPayApi payApi) {
        this.payApi = payApi;
        return this;
    }

    @NotNull
    public final b H(@NotNull IPermission permission) {
        this.permission = permission;
        return this;
    }

    @NotNull
    public final b I(@NotNull IECPhotoBrowser photoBrowser) {
        this.photoBrowser = photoBrowser;
        return this;
    }

    @NotNull
    public final b J(@NotNull IECPluginServiceDelegate delegate) {
        this.pluginServiceDelegate = delegate;
        return this;
    }

    @NotNull
    public final b K(@NotNull IECPublicAccountManager publicAccountManager) {
        this.publicAccountManager = publicAccountManager;
        return this;
    }

    @NotNull
    public final b L(@NotNull IECQCircleApi qCircleApi) {
        this.qCircleApi = qCircleApi;
        return this;
    }

    @NotNull
    public final b M(@NotNull IECQQApi qqApi) {
        this.qqApi = qqApi;
        return this;
    }

    @NotNull
    public final b N(@NotNull IECQQLiveSSORequest qqliveSSORequest) {
        this.qqLiveSSORequest = qqliveSSORequest;
        return this;
    }

    @NotNull
    public final b O(@NotNull IECQTroopServiceApi qTroopService) {
        this.qTroopService = qTroopService;
        return this;
    }

    @NotNull
    public final b P(@NotNull IECRMonitorManager rMonitorManager) {
        this.rMonitorManager = rMonitorManager;
        return this;
    }

    @NotNull
    public final b Q(@NotNull IECRemoteConfig remoteConfig) {
        this.remoteConfig = remoteConfig;
        return this;
    }

    @NotNull
    public final b R(@NotNull IECRenderViewRegister register) {
        this.renderViewRegister = register;
        return this;
    }

    @NotNull
    public final b S(@NotNull IECResourceApi resourceApi) {
        this.resourceApi = resourceApi;
        return this;
    }

    @NotNull
    public final b T(@NotNull IECRuntime runtime) {
        this.runtime = runtime;
        return this;
    }

    @NotNull
    public final b U(@NotNull IECScheme scheme) {
        this.scheme = scheme;
        return this;
    }

    @NotNull
    public final b V(@NotNull IECSearchBarCreator creator) {
        this.searchBarCreator = creator;
        return this;
    }

    @NotNull
    public final b W(@NotNull IECShareProxy shareProxy) {
        this.shareProxy = shareProxy;
        return this;
    }

    @NotNull
    public final b X(@NotNull IECSoManager delegate) {
        this.soManagerDelegate = delegate;
        return this;
    }

    @NotNull
    public final b Y(@NotNull IECTicketManager ticket) {
        this.ticket = ticket;
        return this;
    }

    @NotNull
    public final b Z(@NotNull IECToast toast) {
        this.toast = toast;
        return this;
    }

    @NotNull
    public final QQECGlobalInternalSdk a() {
        IECNightManager iECNightManager = this.nightManager;
        IECRuntime iECRuntime = this.runtime;
        IECLog iECLog = this.logger;
        IECSender iECSender = this.network;
        IECDataReport iECDataReport = this.reporter;
        IECMobileReportManager iECMobileReportManager = this.mobileReporter;
        IECScheme iECScheme = this.scheme;
        IECTicketManager iECTicketManager = this.ticket;
        IECImageLoader iECImageLoader = this.imageLoader;
        IECUploaderFactory iECUploaderFactory = this.uploaderFactory;
        IPermission iPermission = this.permission;
        IWallet iWallet = this.wallet;
        IECAccountManager iECAccountManager = this.accountManager;
        IECToast iECToast = this.toast;
        IECRemoteConfig iECRemoteConfig = this.remoteConfig;
        IECFaceVerification iECFaceVerification = this.faceVerification;
        IECOpenTelemetry iECOpenTelemetry = this.openTelemetry;
        IECHippyProxy iECHippyProxy = this.hippyProxy;
        if (iECHippyProxy == null) {
            iECHippyProxy = new ai0.a();
        }
        IECHippyProxy iECHippyProxy2 = iECHippyProxy;
        IECShareProxy iECShareProxy = this.shareProxy;
        if (iECShareProxy == null) {
            iECShareProxy = new com.tencent.ecommerce.base.share.api.a();
        }
        IECShareProxy iECShareProxy2 = iECShareProxy;
        IECImagePreloadManager iECImagePreloadManager = this.imagePreloadManager;
        IECBizModuleProxy iECBizModuleProxy = this.bizModuleProxy;
        IECLocalConfig iECLocalConfig = this.localMMKVConfig;
        INVViewModelInitialization iNVViewModelInitialization = this.nvViewModelInitialization;
        IECGameProxy iECGameProxy = this.gameProxy;
        IECRMonitorManager iECRMonitorManager = this.rMonitorManager;
        IECApngLoader iECApngLoader = this.apngLoader;
        IECPagSoLoader iECPagSoLoader = this.pagSoLoader;
        IECLiveNumberFontLoader iECLiveNumberFontLoader = this.liveNumberFontLoader;
        IECSkinApi iECSkinApi = this.skinApi;
        IECPhotoBrowser iECPhotoBrowser = this.photoBrowser;
        return new QQECGlobalInternalSdk(iECRuntime, iECLog, iECSender, iECDataReport, iECMobileReportManager, iECScheme, iECTicketManager, iECImageLoader, iECUploaderFactory, iPermission, iWallet, iECAccountManager, iECToast, iECRemoteConfig, iECFaceVerification, iECOpenTelemetry, iECNightManager, iECHippyProxy2, iECShareProxy2, iECImagePreloadManager, iECBizModuleProxy, iECLocalConfig, iNVViewModelInitialization, iECGameProxy, iECRMonitorManager, iECApngLoader, iECPagSoLoader, iECLiveNumberFontLoader, this.deviceInfo, this.threadPool, iECSkinApi, iECPhotoBrowser, this.locationService, this.mediaSelector, this.compressOperator, this.payApi, this.publicAccountManager, this.miniAppLauncher, this.activityDelegate, this.soManagerDelegate, this.pluginServiceDelegate, this.videoControl, this.httpDownloader, this.offlineManager, this.qqLiveSSORequest, this.wxAuthApi, this.qCircleApi, this.eventDispatcherDelegate, this.lucyApi, this.searchBarCreator, this.vasPay, this.qTroopService, this.guildApi, this.qqApi, this.gameApi, this.resourceApi, this.kuiklyImageFetcher, this.vibrationApi, this.renderViewRegister);
    }

    @NotNull
    public final b a0(@NotNull IECUploaderFactory uploaderFactory) {
        this.uploaderFactory = uploaderFactory;
        return this;
    }

    @NotNull
    public final b b(@NotNull IECAccountManager accountManager) {
        this.accountManager = accountManager;
        return this;
    }

    @NotNull
    public final b b0(@NotNull IECVasRechargeApi vasPay) {
        this.vasPay = vasPay;
        return this;
    }

    @NotNull
    public final b c(@NotNull IECActivityDelegate delegate) {
        this.activityDelegate = delegate;
        return this;
    }

    @NotNull
    public final b c0(@NotNull IECVibrationApi api) {
        this.vibrationApi = api;
        return this;
    }

    @NotNull
    public final b d(@NotNull IECApngLoader apngLoader) {
        this.apngLoader = apngLoader;
        return this;
    }

    @NotNull
    public final b d0(@NotNull IECVideoControlDelegate videoEvent) {
        this.videoControl = videoEvent;
        return this;
    }

    @NotNull
    public final b e(@NotNull IECBizModuleProxy bizModuleProxy) {
        this.bizModuleProxy = bizModuleProxy;
        return this;
    }

    @NotNull
    public final b e0(@NotNull IECWXAuthApi wxAuthApi) {
        this.wxAuthApi = wxAuthApi;
        return this;
    }

    @NotNull
    public final b f(@NotNull IECDataReport reporter) {
        this.reporter = reporter;
        return this;
    }

    @NotNull
    public final b f0(@NotNull IWallet wallet) {
        this.wallet = wallet;
        return this;
    }

    @NotNull
    public final b g(@NotNull IECDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    @NotNull
    public final b h(@NotNull IECCompressOperator operator) {
        this.compressOperator = operator;
        return this;
    }

    @NotNull
    public final b i(@NotNull IECMediaSelector mediaSelector) {
        this.mediaSelector = mediaSelector;
        return this;
    }

    @NotNull
    public final b j(@NotNull IECThreadPoolProxy threadPool) {
        this.threadPool = threadPool;
        return this;
    }

    @NotNull
    public final b k(@NotNull IECEventDispatcherDelegate eventDelegate) {
        this.eventDispatcherDelegate = eventDelegate;
        return this;
    }

    @NotNull
    public final b l(@NotNull IECFaceVerification faceVerification) {
        this.faceVerification = faceVerification;
        return this;
    }

    @NotNull
    public final b m(@NotNull IECGameApi gameApi) {
        this.gameApi = gameApi;
        return this;
    }

    @NotNull
    public final b n(@NotNull IECGameProxy gameProxy) {
        this.gameProxy = gameProxy;
        return this;
    }

    @NotNull
    public final b o(@NotNull IECGuildApi guildApi) {
        this.guildApi = guildApi;
        return this;
    }

    @NotNull
    public final b p(@NotNull IECHippyProxy hippyProxy) {
        this.hippyProxy = hippyProxy;
        return this;
    }

    @NotNull
    public final b q(@NotNull IECHttpDownloader httpDownloader) {
        this.httpDownloader = httpDownloader;
        return this;
    }

    @NotNull
    public final b r(@NotNull IECImageLoader imageLoader) {
        this.imageLoader = imageLoader;
        return this;
    }

    @NotNull
    public final b s(@NotNull IECImagePreloadManager imagePreloadManager) {
        this.imagePreloadManager = imagePreloadManager;
        return this;
    }

    @NotNull
    public final b t(@NotNull IKuiklyImageFetcher imageFetcher) {
        this.kuiklyImageFetcher = imageFetcher;
        return this;
    }

    @NotNull
    public final b u(@NotNull IECLiveNumberFontLoader liveNumberFontLoader) {
        this.liveNumberFontLoader = liveNumberFontLoader;
        return this;
    }

    @NotNull
    public final b v(@NotNull IECLocalConfig localMMKVConfig) {
        this.localMMKVConfig = localMMKVConfig;
        return this;
    }

    @NotNull
    public final b w(@NotNull IECLocationServiceProxy locationService) {
        this.locationService = locationService;
        return this;
    }

    @NotNull
    public final b x(@NotNull IECLog logger) {
        this.logger = logger;
        return this;
    }

    @NotNull
    public final b y(@NotNull IECMiniAppLauncher miniAppLauncher) {
        this.miniAppLauncher = miniAppLauncher;
        return this;
    }

    @NotNull
    public final b z(@NotNull IECMobileReportManager reporter) {
        this.mobileReporter = reporter;
        return this;
    }
}

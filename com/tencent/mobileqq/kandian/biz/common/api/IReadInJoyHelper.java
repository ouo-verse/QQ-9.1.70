package com.tencent.mobileqq.kandian.biz.common.api;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import kotlin.Metadata;
import l52.a;
import l52.b;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00bf\u00012\u00020\u0001:\u0002\u00c0\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\u0006H&J'\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u001e\u001a\u00020\bH&J\"\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\bH&J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000eH&J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000eH&J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000eH&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH&J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH&J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH&J\u0010\u00101\u001a\u00020\u00062\u0006\u0010,\u001a\u000200H&J\u0010\u00102\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH&J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u00104\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u00107\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u00108\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u0010:\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\b\u0010;\u001a\u00020\u000eH&J\b\u0010=\u001a\u00020<H&J\b\u0010>\u001a\u00020\u000eH&J\b\u0010?\u001a\u00020\u000eH&J\b\u0010@\u001a\u00020\bH&J\n\u0010A\u001a\u0004\u0018\u00010\u0014H&J\b\u0010B\u001a\u00020\bH&J\b\u0010C\u001a\u00020\bH&J\b\u0010D\u001a\u00020\u000eH&J\b\u0010E\u001a\u00020\u000eH&J\b\u0010F\u001a\u00020\u0006H&J\b\u0010G\u001a\u00020\u000eH&J\u0012\u0010I\u001a\u00020\u000e2\b\u0010H\u001a\u0004\u0018\u00010\u0014H&J\b\u0010J\u001a\u00020\u000eH&J\b\u0010K\u001a\u00020\bH&J\b\u0010L\u001a\u00020\u000eH&J\n\u0010M\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010O\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u0014H&J\b\u0010P\u001a\u00020\u0006H&J\b\u0010Q\u001a\u00020\u0006H&J\u0012\u0010S\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010T\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010U\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u000eH&J\u0010\u0010X\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000eH&J\u0012\u0010Y\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u001c\u0010Z\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\\\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u000eH&J\u0012\u0010]\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010^\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010_\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u000eH&J\u0010\u0010b\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH&J\u0010\u0010c\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH&J\u001c\u0010d\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010e\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0014H&J\u0010\u0010g\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\u0012\u0010i\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010j\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010k\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010l\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010m\u001a\u00020\u000e2\b\u0010h\u001a\u0004\u0018\u00010\u0014H&J/\u0010o\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010n\u001a\u00020\u000eH&\u00a2\u0006\u0004\bo\u0010pJ\b\u0010q\u001a\u00020\u000eH&J\u0010\u0010r\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\b\u0010s\u001a\u00020\u000eH&J\u0012\u0010v\u001a\u00020\u00062\b\u0010u\u001a\u0004\u0018\u00010tH&J\u0010\u0010w\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\b\u0010x\u001a\u00020\u000eH&J\u0010\u0010y\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\b\u0010z\u001a\u00020\u000eH&J\u0010\u0010{\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\b\u0010|\u001a\u00020\u000eH&J\u0010\u0010}\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\b\u0010~\u001a\u00020\u000eH&J\u0010\u0010\u007f\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\t\u0010\u0080\u0001\u001a\u00020\u000eH&J\u0012\u0010\u0082\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u000eH&J\t\u0010\u0083\u0001\u001a\u00020\u000eH&J\u0012\u0010\u0084\u0001\u001a\u00020\u00062\u0007\u0010\u0081\u0001\u001a\u00020\u000eH&J\t\u0010\u0085\u0001\u001a\u00020\u000eH&J\u0012\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u0086\u0001\u001a\u00020\u000eH&J0\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010n\u001a\u00020\u000eH&\u00a2\u0006\u0005\b\u001a\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\u000eH&J\u0011\u0010\u008a\u0001\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u000eH&J\t\u0010\u008b\u0001\u001a\u00020<H&J\t\u0010\u008c\u0001\u001a\u00020\u0006H&J/\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010n\u001a\u00020\u000eH&\u00a2\u0006\u0004\b\u0017\u0010pJ\u001c\u0010\u008e\u0001\u001a\u0004\u0018\u00010\n2\u0006\u0010n\u001a\u00020\u000e2\u0007\u0010\u008d\u0001\u001a\u00020\u000eH&J\t\u0010\u008f\u0001\u001a\u00020\u000eH&J\t\u0010\u0090\u0001\u001a\u00020\u000eH&J-\u0010\u0095\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020<2\u0007\u0010\u0093\u0001\u001a\u00020\b2\u0007\u0010\u0094\u0001\u001a\u00020\bH&J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u0001H&J3\u0010\u009c\u0001\u001a\u00020\u00062\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0099\u0001\u001a\u00020\b2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001H&J\t\u0010\u009d\u0001\u001a\u00020\u000eH&J\u001e\u0010\u009f\u0001\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0014H&J\t\u0010\u00a0\u0001\u001a\u00020\u000eH&J\u0012\u0010\u00a2\u0001\u001a\u00020\u000e2\u0007\u0010\u00a1\u0001\u001a\u00020\bH&J\u0014\u0010\u00a3\u0001\u001a\u00020\u000e2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0002H&J\t\u0010\u00a4\u0001\u001a\u00020\u000eH&J\u0015\u0010\u00a7\u0001\u001a\u00020\b2\n\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a5\u0001H&J\u0011\u0010$\u001a\u00020\u00062\u0007\u0010\u00a8\u0001\u001a\u00020\bH&J\u0014\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\u0011\u0010\u00ab\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0014\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u00ac\u0001\u001a\u00020\bH&J\u0011\u0010\u00ae\u0001\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\bH&J\u0012\u0010\u00b0\u0001\u001a\u00020\u00062\u0007\u0010\u00af\u0001\u001a\u00020\u0014H&JX\u0010\u00ba\u0001\u001a\u00020\u00062\u0007\u0010\u00b1\u0001\u001a\u00020\u00142\u0007\u0010\u00b2\u0001\u001a\u00020\u00142\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0018\u0010\u00b6\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00b5\u00012\t\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H&JV\u0010\u00ba\u0001\u001a\u00020\u00062\u0007\u0010\u00b1\u0001\u001a\u00020\u00142\u0007\u0010\u00b2\u0001\u001a\u00020\u00142\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0007\u0010\u00bb\u0001\u001a\u00020\b2\u0018\u0010\u00b6\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00b5\u00012\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H&JD\u0010\u00be\u0001\u001a\u00020\u00062\u0007\u0010\u00bc\u0001\u001a\u00020\u00142\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0018\u0010\u00b6\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00b5\u00012\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00bd\u0001H&\u00a8\u0006\u00c1\u0001"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", "fromActivity", "Landroid/content/Intent;", "intent", "", "launchReadInJoyPlugin", "", "accessMode", "Landroid/content/SharedPreferences;", "getReadInJoySharedPreferences", "Landroid/content/SharedPreferences$Editor;", "editor", "", "applyFirst", "applySharedPreferences", "maybeInitializedAladdin", "initAladdin", "T", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "value", "updateReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "bidKey", "getProteusOfflineBid", "getReadInJoyMultiVideoChannelInfoVersion", "channelID", "channelName", "channelType", "updateReadInJoyMultiVideoChannelInfo", "enable", "updateSupportMultiVideoSwitch", "updateVideoStructMsgPlaySwitch", "updateKandianVideoSocialSwitch", "updateVideoChannelAutoPlaySwitchDefaultValue", "updateReadInJoyVideoJumpDefaultValue", "bitRateStr", "updateKandianConfigDefaultBitRate", "updateCUKingCardDlgSwitch", WidgetCacheConstellationData.NUM, "updateVideoChannelCoverStyle", "updateVideoDynamicRecommmendStrategy", "updateVideoDynamicRecommmendDurationLimit", "", "updateVideoDynamicRecommendDurationPercent", "updateVideoDynamicRecommendOperator", "updateWebRenderConfig", "updateWebRenderModeConfig", "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow", "updateVideoChannelFeedsClickSwitchValue", "updateViolaDynamicConfig", "updateViolaWeishiAdConfig", "updateViolaDiscoverConfig", "updateViolaMessageBoxConfig", "isInReadinjoyFolderMergerStyle", "", "getFFProbesize", "isFFProbelistSwitch", "isDownloadAsyncIo", "getDynamicBufferSwitch", "getDynamicBufferConfig", "getCameraCaptureMaxDuration", "getReadInjoyShareToWxAtSwitch", "getWebRenderConfig", "getCanLoadStartWebRenderModeConfig", "synSwitchCache", "canFreeTimeRefreshPush", "uin", "canInMessageList", "getRemoveKandianFlag", "getKandianConfigBadgeSwitch", "getKanDianReportTTSwitch", "checkLastScanTTDate", "date", "setLastScanTTDate", "updateReadinjoyFolderMergerReal", "updateReadinjoyStopFunctionSwtichReal", "setting", "updateReadInJoySmartCropSetting", "updateReadInJoyFeedsGroupSetting", "updateReadInJoyPushMsgSwitch", "flag", "updateReadInJoyIndividualPushSwitchSetting", "updateReadinjoySubscribeListPush", "findSocialFeedsWebUrlKey", "updateSocialFeedsWebJumpUrl", "can", "updateFreeTimeRefreshPush", "updateKandianMyTabPage", "updateGallerySubChannelHidden", "updateGallerySubChannelWaterFallHidden", "reportSwitch", "setKanDianReportTTSwitch", "updateKandianConfigRedShowNum", "updateKandianConfigRedThreshold", "updateSelfFragmentFeedBackConf", "updateReadinjoyFolderMergerConfig", "show", "updateOpenSimpleSwitchFm", DownloadInfo.spKey_Config, "onShareToNewsConfigChanged", "onSynchronizeToQzoneConfigChanged", "onMergeFeedsConfigChanged", "onKandianFeedsConfigChanged", "updateArkChannelConfig", "isAccountRelated", "getKDSPValueWithKey", "(Ljava/lang/String;Ljava/lang/Object;Z)Ljava/lang/Object;", "getInnerVideoInfoShowSWitcher", "updateInnerVideoInfoShowSwitcher", "getSplasDebugSWitcher", "Lorg/json/JSONObject;", "r5", "addExtraInfoInJson", "updateSplashDebugSwitcher", "getViolaDebugSWitcher", "updateViolaDebugSwitcher", "getViolaJsDebugBundleSwitcher", "updateViolaJsDebugBundleSwitcher", "getViolaJsLocalBundleSwitcher", "updateViolaJsLocalBundleSwitcher", "getViolaRecommendSwitcher", "updateViolaRecommendSwitcher", "isViolaMessageBoxInTest", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "updateVideoMessageBoxSwitcher", "isViolaColumnEntryInTest", "updateVideoColumnEntrySwitcher", "isRIJVideoEnableReprint", "enableReprint", "updateRIJVideoEnableReprint", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "isShowRecommendReasonInTitle", "updateShowRecommendReasonInTitle", "getVideoRealTimeLogDebug", "updateVideoRealTimeLogDebug", "isSupportMultiProcess", "getReadInJoySP", "getVideoStructMsgPlaySwitch", "getViolaPicDetailConfig", "source", "sourceArticleId", QCircleDaTongConstant.ElementParamValue.OPERATION, "opsource", "reportArticleByWeb", "", "getKandianLebaViewItem", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "forwardToReadInJoyFeed", "checkIsVideoFeedsGameAdComBarLocalConfigToday", "bid", "updateProteusOfflineBid", "getReadinjoyStopFunctionSwitch", "videoFromType", "isFromVideoColumn", "isInSplashActivity", "isShowMainVideoTab", "Lmqq/app/AppRuntime;", "app", "getKandianConfigAdExposureThreshold", "enableSw", "getUserConfigVersion", "()Ljava/lang/Integer;", "setUserConfigVersion", "count", "generateSocialCountLess99", "adSuperMaskServiceSetChannelId", "msg", "adSuperMaskLog", "service", "method", "", "param", "", "extra", "refer", "Ll52/a;", "callback", "ssoForward", "serializationType", "cmd", "Ll52/b;", "sendSsoCmdRequest", "Companion", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyHelper extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239284a;

    @NotNull
    public static final String HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION = "HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION";

    @NotNull
    public static final String HOT_SHORTVIDEO_MULTI_VIDEO_SWITCH_799 = "hot_shortvideo_multi_video_support_799";

    @NotNull
    public static final String READINJJOY_AD_SUPPLEMENT = "readinjjoy_ad_supplement_config";
    public static final int SERIALIZATION_TYPE_JSON = 0;
    public static final int SERIALIZATION_TYPE_PB = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyHelper$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239284a = new Companion();

        Companion() {
        }
    }

    void adSuperMaskLog(@NotNull String msg2);

    void adSuperMaskServiceSetChannelId(int channelID);

    void addExtraInfoInJson(@Nullable JSONObject r56);

    void applySharedPreferences(@Nullable SharedPreferences.Editor editor, boolean applyFirst);

    boolean canFreeTimeRefreshPush();

    boolean canInMessageList(@Nullable String uin);

    boolean checkIsVideoFeedsGameAdComBarLocalConfigToday();

    @Nullable
    String checkLastScanTTDate();

    boolean findSocialFeedsWebUrlKey(@Nullable String key);

    void forwardToReadInJoyFeed(@Nullable Activity activity, @Nullable Intent intent, int requestCode, @Nullable DialogInterface.OnDismissListener dismissListener);

    @Nullable
    String generateSocialCountLess99(int count);

    int getCameraCaptureMaxDuration();

    boolean getCanLoadStartWebRenderModeConfig();

    @Nullable
    String getDynamicBufferConfig();

    int getDynamicBufferSwitch();

    long getFFProbesize();

    boolean getInnerVideoInfoShowSWitcher();

    @Nullable
    <T> T getKDSPValueWithKey(@NotNull String key, T defaultValue, boolean isAccountRelated);

    boolean getKanDianReportTTSwitch();

    int getKandianConfigAdExposureThreshold(@Nullable AppRuntime app);

    int getKandianConfigBadgeSwitch();

    @Nullable
    Object getKandianLebaViewItem();

    @Nullable
    String getProteusOfflineBid(@Nullable String bidKey);

    int getReadInJoyMultiVideoChannelInfoVersion();

    @Nullable
    SharedPreferences getReadInJoySP(boolean isAccountRelated, boolean isSupportMultiProcess);

    @Nullable
    SharedPreferences getReadInJoySharedPreferences(int accessMode);

    <T> T getReadInJoySpValue(@Nullable String key, T defaultValue);

    <T> T getReadInJoySpValue(@Nullable String key, T defaultValue, boolean isAccountRelated);

    int getReadInjoyShareToWxAtSwitch();

    boolean getReadinjoyStopFunctionSwitch();

    boolean getRemoveKandianFlag();

    boolean getSplasDebugSWitcher();

    @Nullable
    Integer getUserConfigVersion();

    long getVideoRealTimeLogDebug();

    boolean getVideoStructMsgPlaySwitch();

    boolean getViolaDebugSWitcher();

    boolean getViolaJsDebugBundleSwitcher();

    boolean getViolaJsLocalBundleSwitcher();

    boolean getViolaPicDetailConfig();

    boolean getViolaRecommendSwitcher();

    boolean getWebRenderConfig();

    void initAladdin();

    boolean isDownloadAsyncIo();

    boolean isFFProbelistSwitch();

    boolean isFromVideoColumn(int videoFromType);

    boolean isInReadinjoyFolderMergerStyle();

    boolean isInSplashActivity(@Nullable Activity activity);

    boolean isRIJVideoEnableReprint();

    boolean isShowMainVideoTab();

    boolean isShowRecommendReasonInTitle();

    boolean isViolaColumnEntryInTest();

    boolean isViolaMessageBoxInTest();

    void launchReadInJoyPlugin(@Nullable Activity fromActivity, @Nullable Intent intent);

    void maybeInitializedAladdin();

    void onKandianFeedsConfigChanged(@Nullable String config);

    void onMergeFeedsConfigChanged(@Nullable String config);

    void onShareToNewsConfigChanged(@Nullable String config);

    void onSynchronizeToQzoneConfigChanged(@Nullable String config);

    void reportArticleByWeb(int source, long sourceArticleId, int operation, int opsource);

    void sendSsoCmdRequest(@NotNull String cmd, @Nullable byte[] param, @Nullable Map<Object, ? extends Object> extra, @Nullable b callback);

    void setKanDianReportTTSwitch(boolean reportSwitch);

    void setLastScanTTDate(@Nullable String date);

    void setUserConfigVersion(int value);

    void ssoForward(@NotNull String service, @NotNull String method, @Nullable byte[] param, int serializationType, @Nullable Map<Object, ? extends Object> extra, @Nullable a callback);

    void ssoForward(@NotNull String service, @NotNull String method, @Nullable byte[] param, @Nullable Map<Object, ? extends Object> extra, @Nullable String refer, @Nullable a callback);

    void synSwitchCache();

    boolean updateArkChannelConfig(@Nullable String config);

    void updateCUKingCardDlgSwitch(int value);

    void updateFreeTimeRefreshPush(boolean can);

    void updateGallerySubChannelHidden(@Nullable String value);

    void updateGallerySubChannelWaterFallHidden(@Nullable String value);

    void updateInnerVideoInfoShowSwitcher(boolean show);

    void updateKandianConfigDefaultBitRate(@Nullable String bitRateStr);

    void updateKandianConfigRedShowNum(int num);

    void updateKandianConfigRedThreshold(int num);

    boolean updateKandianMyTabPage(@Nullable String value);

    void updateKandianVideoSocialSwitch(boolean value);

    void updateOpenSimpleSwitchFm(boolean show);

    void updateProteusOfflineBid(@Nullable String bidKey, @Nullable String bid);

    void updateRIJVideoEnableReprint(boolean enableReprint);

    void updateReadInJoyFeedsGroupSetting(@Nullable String setting);

    void updateReadInJoyIndividualPushSwitchSetting(boolean flag);

    void updateReadInJoyMultiVideoChannelInfo(int channelID, @Nullable String channelName, int channelType);

    void updateReadInJoyPushMsgSwitch(@Nullable String setting);

    void updateReadInJoySmartCropSetting(@Nullable String setting);

    <T> void updateReadInJoySpValue(@Nullable String key, T value);

    <T> void updateReadInJoySpValue(@Nullable String key, T value, boolean isAccountRelated);

    void updateReadInJoyVideoJumpDefaultValue(int value);

    void updateReadinjoyFolderMergerConfig(@NotNull String setting);

    void updateReadinjoyFolderMergerReal();

    void updateReadinjoyStopFunctionSwtichReal();

    void updateReadinjoySubscribeListPush(boolean enable);

    void updateSelfFragmentFeedBackConf(@Nullable String key, @Nullable String value);

    void updateShowRecommendReasonInTitle(boolean show);

    void updateSocialFeedsWebJumpUrl(@Nullable String key, @Nullable String value);

    void updateSplashDebugSwitcher(boolean show);

    void updateSupportMultiVideoSwitch(int enableSw);

    void updateSupportMultiVideoSwitch(boolean enable);

    void updateVideoChannelAutoPlaySwitchDefaultValue(int value);

    void updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow(int value);

    void updateVideoChannelCoverStyle(int num);

    void updateVideoChannelFeedsClickSwitchValue(int value);

    void updateVideoColumnEntrySwitcher(boolean isTest);

    void updateVideoDynamicRecommendDurationPercent(float num);

    void updateVideoDynamicRecommendOperator(int num);

    void updateVideoDynamicRecommmendDurationLimit(int num);

    void updateVideoDynamicRecommmendStrategy(int num);

    void updateVideoMessageBoxSwitcher(boolean isTest);

    void updateVideoRealTimeLogDebug();

    void updateVideoStructMsgPlaySwitch(boolean value);

    void updateViolaDebugSwitcher(boolean show);

    void updateViolaDiscoverConfig(int value);

    void updateViolaDynamicConfig(int value);

    void updateViolaJsDebugBundleSwitcher(boolean show);

    void updateViolaJsLocalBundleSwitcher(boolean show);

    void updateViolaMessageBoxConfig(int value);

    void updateViolaRecommendSwitcher(boolean show);

    void updateViolaWeishiAdConfig(int value);

    void updateWebRenderConfig(int value);

    void updateWebRenderModeConfig(int value);
}

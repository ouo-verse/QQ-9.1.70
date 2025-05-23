package com.tencent.mobileqq.aio.msglist.holder.component.marketface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.aio.msg.n;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.c;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.view.BreathAnimationLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.view.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.c;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.structmsg.f;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ac;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.doutu.DuiButtonImageView;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.emotion.config.a;
import com.tencent.qqnt.emotion.utils.j;
import com.tencent.qqnt.emotion.widget.TriangleView;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007*\u0002\u009c\u0001\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u00a1\u0001B\u0010\u0012\u0006\u0010K\u001a\u00020D\u00a2\u0006\u0005\b\u00a0\u0001\u0010JJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002J$\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\t0+j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\t`,H\u0002J(\u00102\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\rH\u0002J\b\u00104\u001a\u000203H\u0016J&\u00107\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00106\u001a\u0002052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u00109\u001a\u000208H\u0016J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u000203H\u0016J\b\u0010B\u001a\u00020\u0006H\u0016J\n\u0010C\u001a\u0004\u0018\u000103H\u0016R\"\u0010K\u001a\u00020D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010 \u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010c\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010`\u001a\u0004\bf\u0010gR\u001b\u0010m\u001a\u00020i8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010`\u001a\u0004\bk\u0010lR\u001b\u0010p\u001a\u00020i8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010`\u001a\u0004\bo\u0010lR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010`\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010`\u001a\u0004\bx\u0010yR\u001b\u0010}\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b{\u0010`\u001a\u0004\b|\u0010tR\u001c\u0010\u0005\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b~\u0010`\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010TR \u0010\u0087\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0084\u0001\u0010`\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R \u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0089\u0001\u0010`\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u0091\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008e\u0001\u0010`\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010TR \u0010\u0098\u0001\u001a\u00030\u0094\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0095\u0001\u0010`\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001e\u0010\u009b\u0001\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0099\u0001\u0010`\u001a\u0005\b\u009a\u0001\u0010tR\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u00a8\u0006\u00a2\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/n;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/view/BreathAnimationLayout;", "voiceBarContainer", "", "m2", "", "", "payloads", "", "k2", "", "position", "l2", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "data", ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "emoticonInfo", "v2", "w2", "y2", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "u2", "isPttFileDownloaded", "x2", "q2", "soundPath", "t2", ICustomDataEditor.NUMBER_PARAM_2, "result", "resTaskType", "j2", "Lcom/tencent/qqnt/emotion/adapter/api/a;", "marketFaceInfo", "i2", "p2", "o2", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "V1", "moduleId", "itemId", "itemType", "actionId", "r2", "Landroid/view/View;", "c1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponentVM;", "S1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "D", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "E", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "Z", "enableEmotionTailView", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/vas/marketface/IMarketFaceTailConfigExt;", "H", "Lcom/tencent/mobileqq/vas/marketface/IMarketFaceTailConfigExt;", "faceTailConfigExt", "Landroid/widget/RelativeLayout;", "I", "Lkotlin/Lazy;", "T1", "()Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Lcom/tencent/image/URLImageView;", "J", "U1", "()Lcom/tencent/image/URLImageView;", "contentIv", "Landroid/widget/TextView;", "K", "Z1", "()Landroid/widget/TextView;", "tailView", "L", "X1", "ipFaceTailView", "Landroid/widget/ImageView;", "M", "W1", "()Landroid/widget/ImageView;", "gifIcon", "Lcom/tencent/qqnt/doutu/DuiButtonImageView;", "N", "Y1", "()Lcom/tencent/qqnt/doutu/DuiButtonImageView;", "rightDuiView", "P", "e2", "voiceIcon", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/view/BreathAnimationLayout;", BdhLogUtil.LogTag.Tag_Req, "voiceWaveViewInit", "Lcom/tencent/mobileqq/activity/aio/item/PttAudioWaveView;", ExifInterface.LATITUDE_SOUTH, SemanticAttributes.DbSystemValues.H2, "()Lcom/tencent/mobileqq/activity/aio/item/PttAudioWaveView;", "voiceWaveView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/view/SyncParentPressedRelativeLayout;", "T", "d2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/view/SyncParentPressedRelativeLayout;", "voiceFlagTimeContainer", "Lcom/tencent/qqnt/emotion/widget/TriangleView;", "U", "g2", "()Lcom/tencent/qqnt/emotion/widget/TriangleView;", "voicePlayerTriangleView", "V", "voicePlayerControlViewInit", "Lcom/tencent/mobileqq/activity/aio/item/PttAudioPlayView;", "W", "f2", "()Lcom/tencent/mobileqq/activity/aio/item/PttAudioPlayView;", "voicePlayerControlView", "X", "c2", "voiceDownLoadingImg", "com/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponent$b", "Y", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponent$b;", "aioPttAudioPlayerStateListener", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMarketFaceComponent extends BaseContentComponent<n> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MarketFaceElement marketFaceElement;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IPicEmoticonInfo emoticonInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String soundPath;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean enableEmotionTailView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Handler handler;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IMarketFaceTailConfigExt faceTailConfigExt;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy container;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentIv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy tailView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy ipFaceTailView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy gifIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightDuiView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceIcon;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceBarContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean voiceWaveViewInit;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceWaveView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceFlagTimeContainer;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy voicePlayerTriangleView;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean voicePlayerControlViewInit;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy voicePlayerControlView;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy voiceDownLoadingImg;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final b aioPttAudioPlayerStateListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceComponent$b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/c;", "", "msgId", "", h.F, "", "path", "", "d", "", "currentPosition", "a", "b", "duration", "g", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.aio.msglist.holder.component.ptt.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
            }
        }

        private final boolean h(long msgId) {
            if (AIOMarketFaceComponent.J1(AIOMarketFaceComponent.this).getMsgId() == msgId) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(AIOMarketFaceComponent this$0, int i3, int i16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.h2().setProgress(i3 / i16);
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void a(long msgId, @NotNull String path, int currentPosition) {
            IPicEmoticonInfo iPicEmoticonInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgId), path, Integer.valueOf(currentPosition));
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (h(msgId) && (iPicEmoticonInfo = AIOMarketFaceComponent.this.emoticonInfo) != null) {
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                if (iPicEmoticonInfo.isNewSoundType()) {
                    aIOMarketFaceComponent.a2().setVisibility(0);
                    aIOMarketFaceComponent.f2().setPlayState(false);
                } else {
                    aIOMarketFaceComponent.e2().setImageResource(R.drawable.f162106fo2);
                    aIOMarketFaceComponent.e2().setVisibility(0);
                }
                aIOMarketFaceComponent.h2().m();
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void b(long msgId, @NotNull String path) {
            IPicEmoticonInfo iPicEmoticonInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(msgId), path);
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (h(msgId) && (iPicEmoticonInfo = AIOMarketFaceComponent.this.emoticonInfo) != null) {
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                if (iPicEmoticonInfo.isNewSoundType()) {
                    aIOMarketFaceComponent.a2().setVisibility(0);
                    aIOMarketFaceComponent.f2().setPlayState(false);
                } else {
                    aIOMarketFaceComponent.e2().setImageResource(R.drawable.f162106fo2);
                    aIOMarketFaceComponent.e2().setVisibility(0);
                }
                aIOMarketFaceComponent.h2().m();
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void c(long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Boolean.valueOf(z16));
            } else {
                c.a.b(this, j3, z16);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void d(long msgId, @NotNull String path) {
            AppRuntime appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), path);
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (!h(msgId)) {
                AIOMarketFaceComponent.this.h2().m();
                AIOMarketFaceComponent.this.h2().setCanSupportSlide(false);
                return;
            }
            AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                appRuntime = mobileQQ.waitAppRuntime();
            } else {
                appRuntime = null;
            }
            aIOMarketFaceComponent.sendIntent(new d.ad(com.tencent.mobileqq.qqaudio.audioplayer.c.b(appRuntime)));
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void e(long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Float.valueOf(f16));
            } else {
                c.a.a(this, j3, f16);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ptt.c
        public void g(long msgId, @NotNull String path, final int currentPosition, final int duration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(msgId), path, Integer.valueOf(currentPosition), Integer.valueOf(duration));
                return;
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (!h(msgId) || currentPosition == 0) {
                return;
            }
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                AIOMarketFaceComponent.this.h2().setProgress(currentPosition / duration);
                return;
            }
            AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
            Handler handler = aIOMarketFaceComponent.handler;
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            aIOMarketFaceComponent.handler = handler;
            Handler handler2 = AIOMarketFaceComponent.this.handler;
            if (handler2 != null) {
                final AIOMarketFaceComponent aIOMarketFaceComponent2 = AIOMarketFaceComponent.this;
                handler2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOMarketFaceComponent.b.i(AIOMarketFaceComponent.this, currentPosition, duration);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMarketFaceComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.enableEmotionTailView = true;
        QRouteApi api = QRoute.api(IMarketFaceTailConfigExt.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMarketFaceTailConfigExt::class.java)");
        this.faceTailConfigExt = (IMarketFaceTailConfigExt) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$container$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RelativeLayout relativeLayout = new RelativeLayout(AIOMarketFaceComponent.this.getContext());
                int dip2px = ViewUtils.dip2px(8.0f);
                relativeLayout.setPadding(dip2px, dip2px, dip2px, dip2px);
                return relativeLayout;
            }
        });
        this.container = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<URLImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$contentIv$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final URLImageView invoke() {
                RelativeLayout T1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (URLImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                URLImageView uRLImageView = new URLImageView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                uRLImageView.setId(R.id.big_image_layout);
                uRLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                uRLImageView.setImageResource(R.drawable.c0i);
                T1 = aIOMarketFaceComponent.T1();
                T1.addView(uRLImageView);
                uRLImageView.setOnClickListener(aIOMarketFaceComponent);
                return uRLImageView;
            }
        });
        this.contentIv = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$tailView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                RelativeLayout T1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                textView.setId(R.id.yxc);
                textView.setClickable(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                textView.setTextSize(12.0f);
                textView.setText(R.string.f1643525l);
                Resources resources = textView.getContext().getResources();
                layoutParams.topMargin = ViewUtils.dip2px(8.0f);
                layoutParams.bottomMargin = ViewUtils.dip2px(4.0f);
                textView.setGravity(17);
                textView.setPadding(ViewUtils.dip2px(7.0f), ViewUtils.dip2px(3.0f), ViewUtils.dip2px(7.0f), ViewUtils.dip2px(3.0f));
                layoutParams.addRule(3, R.id.big_image_layout);
                layoutParams.addRule(5, R.id.big_image_layout);
                Drawable drawable = resources.getDrawable(R.drawable.f160960n00);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding(ViewUtils.dip2px(3.0f));
                T1 = aIOMarketFaceComponent.T1();
                T1.addView(textView, layoutParams);
                return textView;
            }
        });
        this.tailView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$ipFaceTailView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                RelativeLayout T1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                textView.setId(R.id.xrw);
                textView.setClickable(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                textView.setLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextSize(12.0f);
                layoutParams.topMargin = ViewUtils.dip2px(8.0f);
                layoutParams.bottomMargin = ViewUtils.dip2px(4.0f);
                textView.setGravity(17);
                textView.setPadding(ViewUtils.dip2px(5.0f), ViewUtils.dip2px(3.0f), ViewUtils.dip2px(5.0f), ViewUtils.dip2px(3.0f));
                textView.setBackgroundResource(R.drawable.j7s);
                layoutParams.addRule(3, R.id.big_image_layout);
                layoutParams.addRule(5, R.id.big_image_layout);
                textView.setCompoundDrawablePadding(ViewUtils.dip2px(3.0f));
                T1 = aIOMarketFaceComponent.T1();
                T1.addView(textView, layoutParams);
                textView.setVisibility(8);
                return textView;
            }
        });
        this.ipFaceTailView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$gifIcon$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ImageView imageView = new ImageView(AIOMarketFaceComponent.this.getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(8, R.id.big_image_layout);
                layoutParams.addRule(7, R.id.big_image_layout);
                return imageView;
            }
        });
        this.gifIcon = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<DuiButtonImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$rightDuiView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DuiButtonImageView invoke() {
                RelativeLayout T1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (DuiButtonImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                DuiButtonImageView duiButtonImageView = new DuiButtonImageView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                duiButtonImageView.setId(R.id.bqk);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(50.0f), ViewUtils.dip2px(50.0f));
                layoutParams.addRule(1, R.id.big_image_layout);
                layoutParams.addRule(8, R.id.big_image_layout);
                layoutParams.setMargins(0, 0, 0, -ViewUtils.dip2px(6.5f));
                T1 = aIOMarketFaceComponent.T1();
                T1.addView(duiButtonImageView, layoutParams);
                duiButtonImageView.setOnClickListener(aIOMarketFaceComponent);
                return duiButtonImageView;
            }
        });
        this.rightDuiView = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voiceIcon$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                RelativeLayout T1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ImageView imageView = new ImageView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                imageView.setId(R.id.kzz);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(1, R.id.big_image_layout);
                layoutParams.addRule(8, R.id.big_image_layout);
                layoutParams.leftMargin = 10;
                T1 = aIOMarketFaceComponent.T1();
                T1.addView(imageView, layoutParams);
                imageView.setOnClickListener(aIOMarketFaceComponent);
                return imageView;
            }
        });
        this.voiceIcon = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<BreathAnimationLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voiceBarContainer$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BreathAnimationLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (BreathAnimationLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                BreathAnimationLayout breathAnimationLayout = new BreathAnimationLayout(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                breathAnimationLayout.setId(R.id.f166405bq2);
                aIOMarketFaceComponent.m2(breathAnimationLayout);
                return breathAnimationLayout;
            }
        });
        this.voiceBarContainer = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<PttAudioWaveView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voiceWaveView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PttAudioWaveView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (PttAudioWaveView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                PttAudioWaveView pttAudioWaveView = new PttAudioWaveView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                pttAudioWaveView.setId(R.id.bud);
                pttAudioWaveView.setShowProgressLine(false);
                pttAudioWaveView.setMaxTopBottomPadding(4);
                pttAudioWaveView.setProgressColor(aIOMarketFaceComponent.getMContext().getResources().getColorStateList(R.color.skin_chat_buble).getDefaultColor());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(15, -1);
                layoutParams.addRule(1, R.id.brz);
                layoutParams.width = ViewUtils.dip2px(39.0f);
                layoutParams.height = ViewUtils.dip2px(45.0f);
                layoutParams.leftMargin = ViewUtils.dip2px(9.0f);
                layoutParams.rightMargin = ViewUtils.dip2px(12.0f);
                pttAudioWaveView.setLayoutParams(layoutParams);
                pttAudioWaveView.setCanSupportSlide(false);
                pttAudioWaveView.setOnClickListener(aIOMarketFaceComponent);
                aIOMarketFaceComponent.voiceWaveViewInit = true;
                return pttAudioWaveView;
            }
        });
        this.voiceWaveView = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<SyncParentPressedRelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voiceFlagTimeContainer$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SyncParentPressedRelativeLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SyncParentPressedRelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                SyncParentPressedRelativeLayout syncParentPressedRelativeLayout = new SyncParentPressedRelativeLayout(AIOMarketFaceComponent.this.getContext());
                syncParentPressedRelativeLayout.setId(R.id.bqj);
                return syncParentPressedRelativeLayout;
            }
        });
        this.voiceFlagTimeContainer = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<TriangleView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voicePlayerTriangleView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TriangleView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TriangleView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TriangleView triangleView = new TriangleView(AIOMarketFaceComponent.this.getContext());
                triangleView.setId(R.id.skb);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0f), ViewUtils.dip2px(5.0f));
                layoutParams.leftMargin = ViewUtils.dip2px(2.0f);
                layoutParams.addRule(14);
                layoutParams.addRule(10);
                triangleView.setRotation(180.0f);
                triangleView.setTranslationY(ViewUtils.dip2px(1.0f));
                triangleView.setLayoutParams(layoutParams);
                return triangleView;
            }
        });
        this.voicePlayerTriangleView = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<PttAudioPlayView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voicePlayerControlView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PttAudioPlayView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (PttAudioPlayView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                PttAudioPlayView pttAudioPlayView = new PttAudioPlayView(AIOMarketFaceComponent.this.getContext(), 10);
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                pttAudioPlayView.setThemeColor(aIOMarketFaceComponent.getMContext().getResources().getColorStateList(R.color.skin_chat_buble).getDefaultColor());
                pttAudioPlayView.setId(R.id.brz);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(15, -1);
                layoutParams.leftMargin = ViewUtils.dip2px(5.0f);
                layoutParams.width = ViewUtils.dip2px(25.0f);
                layoutParams.height = ViewUtils.dip2px(25.0f);
                pttAudioPlayView.setLayoutParams(layoutParams);
                pttAudioPlayView.setOnClickListener(aIOMarketFaceComponent);
                aIOMarketFaceComponent.voicePlayerControlViewInit = true;
                return pttAudioPlayView;
            }
        });
        this.voicePlayerControlView = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceComponent$voiceDownLoadingImg$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMarketFaceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ImageView imageView = new ImageView(AIOMarketFaceComponent.this.getContext());
                AIOMarketFaceComponent aIOMarketFaceComponent = AIOMarketFaceComponent.this;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(15, -1);
                layoutParams.leftMargin = ViewUtils.dip2px(5.0f);
                layoutParams.width = ViewUtils.dip2px(20.0f);
                layoutParams.height = ViewUtils.dip2px(20.0f);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageDrawable(aIOMarketFaceComponent.getMContext().getResources().getDrawable(R.drawable.common_loading2));
                imageView.setVisibility(4);
                return imageView;
            }
        });
        this.voiceDownLoadingImg = lazy13;
        this.aioPttAudioPlayerStateListener = new b();
    }

    public static final /* synthetic */ n J1(AIOMarketFaceComponent aIOMarketFaceComponent) {
        return aIOMarketFaceComponent.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout T1() {
        return (RelativeLayout) this.container.getValue();
    }

    private final URLImageView U1() {
        return (URLImageView) this.contentIv.getValue();
    }

    private final HashMap<String, Object> V1() {
        Object obj;
        HashMap<String, Object> hashMap = new HashMap<>();
        MarketFaceElement marketFaceElement = this.marketFaceElement;
        if (marketFaceElement != null) {
            obj = Integer.valueOf(marketFaceElement.emojiPackageId);
        } else {
            obj = "";
        }
        hashMap.put(EmotionReportDtImpl.PARAM_EXPRESSION_PACK_ID, obj);
        return hashMap;
    }

    private final ImageView W1() {
        return (ImageView) this.gifIcon.getValue();
    }

    private final TextView X1() {
        return (TextView) this.ipFaceTailView.getValue();
    }

    private final DuiButtonImageView Y1() {
        return (DuiButtonImageView) this.rightDuiView.getValue();
    }

    private final TextView Z1() {
        return (TextView) this.tailView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BreathAnimationLayout a2() {
        return (BreathAnimationLayout) this.voiceBarContainer.getValue();
    }

    private final ImageView c2() {
        return (ImageView) this.voiceDownLoadingImg.getValue();
    }

    private final SyncParentPressedRelativeLayout d2() {
        return (SyncParentPressedRelativeLayout) this.voiceFlagTimeContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView e2() {
        return (ImageView) this.voiceIcon.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PttAudioPlayView f2() {
        return (PttAudioPlayView) this.voicePlayerControlView.getValue();
    }

    private final TriangleView g2() {
        return (TriangleView) this.voicePlayerTriangleView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PttAudioWaveView h2() {
        return (PttAudioWaveView) this.voiceWaveView.getValue();
    }

    private final void i2(com.tencent.qqnt.emotion.adapter.api.a marketFaceInfo) {
        boolean z16;
        String str;
        U1().getLayoutParams().width = marketFaceInfo.c().getFirst().intValue();
        U1().getLayoutParams().height = marketFaceInfo.c().getSecond().intValue();
        IPicEmoticonInfo a16 = marketFaceInfo.a();
        this.emoticonInfo = a16;
        if (a16 != null) {
            j.Companion companion = j.INSTANCE;
            String epid = a16.getEpid();
            Intrinsics.checkNotNullExpressionValue(epid, "it.epid");
            String eid = a16.getEid();
            Intrinsics.checkNotNullExpressionValue(eid, "it.eid");
            this.soundPath = companion.d(epid, eid);
            if (a16.isSound() && !n2(this.soundPath)) {
                z16 = false;
            } else {
                z16 = true;
            }
            URLDrawable loadingDrawable = a16.getLoadingDrawable(EmotionConstants.FROM_AIO, z16);
            String str2 = "";
            if (loadingDrawable != null && loadingDrawable.getStatus() == 1) {
                if (loadingDrawable.getStateTag() instanceof Bundle) {
                    Object stateTag = loadingDrawable.getStateTag();
                    Intrinsics.checkNotNull(stateTag, "null cannot be cast to non-null type android.os.Bundle");
                    str2 = ((Bundle) stateTag).getString(EmotionConstants.DISPLAY_TYPE, "");
                    Intrinsics.checkNotNullExpressionValue(str2, "urlDrawable.stateTag as \u2026nstants.DISPLAY_TYPE, \"\")");
                }
                if (!TextUtils.isEmpty(str2) && Intrinsics.areEqual(str2, EmotionConstants.AIO_PREVIEW)) {
                    URLDrawable.removeMemoryCacheByUrl(loadingDrawable.getURL().toString());
                    loadingDrawable = a16.getLoadingDrawable(EmotionConstants.FROM_AIO, z16);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                if (a16.getEmoticon().isSound) {
                    str = EmotionConstants.BIG_SOUND;
                } else {
                    str = EmotionConstants.BIG_IMAGE;
                }
                str2 = str;
            }
            U1().setImageDrawable(loadingDrawable);
            v2(a16);
            y2(a16);
            u2(a16, loadingDrawable, str2);
            w2();
        }
    }

    private final void j2(boolean result, int resTaskType) {
        if ((resTaskType & 8) == 8) {
            x2(result);
            if (!result) {
                QQToast.makeText(getMContext(), 1, R.string.f1643425k, 0).show();
            }
        }
    }

    private final boolean k2(List<Object> payloads) {
        IPicEmoticonInfo iPicEmoticonInfo;
        IPicEmoticonInfo iPicEmoticonInfo2;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.DOUTU_STATUS_PAYLOAD) != null && (iPicEmoticonInfo2 = this.emoticonInfo) != null) {
                    v2(iPicEmoticonInfo2);
                }
                if (map.get(AIOMsgItemPayloadType.DOU_TU_PAYLOAD) != null && (iPicEmoticonInfo = this.emoticonInfo) != null) {
                    v2(iPicEmoticonInfo);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void l2(int position) {
        RelativeLayout.LayoutParams layoutParams;
        View findViewById = c1().findViewById(R.id.f164907u83);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ajr);
        }
        U1().setImageResource(R.drawable.c0i);
        Pair<Integer, Integer> i26 = q1().i2();
        String str = null;
        if (i26 != null && i26.getFirst().intValue() > 0 && i26.getSecond().intValue() > 0) {
            layoutParams = new RelativeLayout.LayoutParams(i26.getFirst().intValue(), i26.getSecond().intValue());
        } else {
            layoutParams = null;
        }
        URLImageView U1 = U1();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        U1.setLayoutParams(layoutParams);
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            U1().setContentDescription(q1().w());
        }
        Y1().setVisibility(8);
        W1().setVisibility(8);
        Z1().setVisibility(8);
        if (QLog.isDevelopLevel()) {
            int hashCode = hashCode();
            MarketFaceElement marketFaceElement = this.marketFaceElement;
            if (marketFaceElement != null) {
                str = marketFaceElement.faceName;
            }
            QLog.i("AIOMarketFaceComponent", 4, "HashCode=" + hashCode + "== bind position=" + position + " name=" + str);
        }
        MarketFaceElement marketFaceElement2 = this.marketFaceElement;
        if (marketFaceElement2 != null) {
            s2(marketFaceElement2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2(BreathAnimationLayout voiceBarContainer) {
        d2().addView(h2());
        d2().addView(f2());
        d2().addView(c2());
        RelativeLayout relativeLayout = new RelativeLayout(getMContext());
        relativeLayout.addView(g2());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0f));
        layoutParams.addRule(3, R.id.skb);
        relativeLayout.addView(d2(), layoutParams);
        voiceBarContainer.addView(relativeLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, R.id.big_image_layout);
        layoutParams2.addRule(3, R.id.big_image_layout);
        layoutParams2.bottomMargin = ViewUtils.dip2px(17.0f);
        T1().addView(voiceBarContainer, layoutParams2);
        voiceBarContainer.setOnClickListener(this);
    }

    private final boolean n2(String soundPath) {
        return AIOPttAudioPlayerManager.f191706d.o(soundPath, q1().getMsgId());
    }

    private final void o2() {
        String str = this.soundPath;
        if (str != null) {
            boolean t26 = t2(str);
            x2(new File(str).exists());
            f2().setPlayState(t26);
        }
    }

    private final void p2() {
        String str = this.soundPath;
        if (str != null) {
            t2(str);
            if (n2(str)) {
                q2();
            } else {
                e2().setImageResource(R.drawable.f162106fo2);
            }
        }
    }

    private final void q2() {
        Drawable drawable = getMContext().getResources().getDrawable(R.drawable.l_9);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        e2().setImageDrawable(animationDrawable);
        animationDrawable.start();
    }

    private final void r2(String moduleId, String itemId, String itemType, int actionId) {
        Integer num;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("touin", q1().getMsgRecord().peerUin);
            MarketFaceElement j26 = q1().j2();
            if (j26 != null) {
                num = Integer.valueOf(j26.emojiPackageId);
            } else {
                num = null;
            }
            jSONObject.put("emoji_id", num);
            this.faceTailConfigExt.reportAction(moduleId, itemId, itemType, actionId, jSONObject.toString());
        } catch (Exception e16) {
            QLog.i("AIOMarketFaceComponent", 1, "report04586", e16);
        }
    }

    private final void s2(MarketFaceElement data) {
        sendIntent(new c.f(data, 0, 2, null));
    }

    private final boolean t2(String soundPath) {
        if (new File(soundPath).exists()) {
            if (n2(soundPath)) {
                AIOPttAudioPlayerManager.f191706d.D();
            } else {
                AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
                aIOPttAudioPlayerManager.D();
                aIOPttAudioPlayerManager.y(q1().getMsgId(), soundPath, this.aioPttAudioPlayerStateListener);
                aIOPttAudioPlayerManager.w(soundPath, Integer.MIN_VALUE, 1.0f, q1().getMsgId());
                return true;
            }
        } else {
            IPicEmoticonInfo iPicEmoticonInfo = this.emoticonInfo;
            if (iPicEmoticonInfo != null) {
                Emoticon emoticon = iPicEmoticonInfo.getEmoticon();
                Intrinsics.checkNotNullExpressionValue(emoticon, "it.emoticon");
                sendIntent(new c.e(emoticon, 8));
            }
        }
        return false;
    }

    private final void u2(IPicEmoticonInfo emoticonInfo, URLDrawable urlDrawable, String showType) {
        int i3;
        W1().setVisibility(8);
        e2().setVisibility(8);
        a2().setVisibility(8);
        if (urlDrawable != null) {
            i3 = urlDrawable.getStatus();
            if (urlDrawable.getHeader("2g_use_gif") != null) {
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        if (Intrinsics.areEqual(EmotionConstants.AIO_PREVIEW, showType)) {
            if (emoticonInfo.isSound()) {
                if (emoticonInfo.isNewSoundType()) {
                    a2().setVisibility(0);
                    return;
                } else {
                    e2().setImageResource(R.drawable.f162106fo2);
                    e2().setVisibility(0);
                    return;
                }
            }
            if (i3 == 1 && emoticonInfo.getImageType() == 3) {
                W1().setImageResource(R.drawable.c0j);
                W1().setVisibility(0);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(EmotionConstants.BIG_SOUND, showType)) {
            if (n2(this.soundPath)) {
                if (emoticonInfo.isNewSoundType()) {
                    a2().setVisibility(0);
                    f2().setPlayState(true);
                    return;
                } else {
                    e2().setVisibility(0);
                    q2();
                    return;
                }
            }
            if (emoticonInfo.isNewSoundType()) {
                a2().setVisibility(0);
                f2().setPlayState(false);
            } else {
                e2().setImageResource(R.drawable.f162106fo2);
                e2().setVisibility(0);
            }
        }
    }

    private final void v2(IPicEmoticonInfo emoticonInfo) {
        if (!q1().G0() && !q1().isSelf() && !emoticonInfo.isSound() && emoticonInfo.getImageJobType() != 2 && emoticonInfo.getImageJobType() != 4 && q1().F0() && DuiButtonImageView.f355986m) {
            Y1().setMsg(q1());
            Y1().m();
            Y1().setOnClickListener(this);
            Y1().setVisibility(0);
            if (Y1().getVisibility() != 0) {
                com.tencent.mobileqq.aio.utils.b.q("em_bas_battle_chart", V1());
                ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", "0X800B547", "0X800B547", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        Y1().setVisibility(8);
        Y1().n();
        Y1().setOnClickListener(null);
    }

    private final void w2() {
        String str;
        MarketFaceElement marketFaceElement = this.marketFaceElement;
        if (marketFaceElement == null) {
            return;
        }
        if (!this.enableEmotionTailView) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOMarketFaceComponent", 2, "disable emotion tail view, return");
                return;
            }
            return;
        }
        String valueOf = String.valueOf(marketFaceElement.emojiPackageId);
        String str2 = marketFaceElement.emojiId;
        Intrinsics.checkNotNullExpressionValue(str2, "data.emojiId");
        a.b a16 = com.tencent.qqnt.emotion.config.a.INSTANCE.a().a(valueOf, str2);
        Pair<String, String> tailConfig = this.faceTailConfigExt.getTailConfig(valueOf);
        if (tailConfig != null && !TextUtils.isEmpty(tailConfig.getFirst())) {
            r2("middle", TextNode.MODE_TAIL, "4", 101);
            X1().setVisibility(0);
            X1().setOnClickListener(this);
            String first = tailConfig.getFirst();
            if (tailConfig.getFirst().length() > 6) {
                first = tailConfig.getFirst().substring(0, 6);
                Intrinsics.checkNotNullExpressionValue(first, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            X1().setText(first);
            return;
        }
        if (a16 != null) {
            str = a16.a();
        } else {
            str = null;
        }
        if (str != null) {
            Z1().setVisibility(0);
            Z1().setOnClickListener(this);
            String b16 = a16.b();
            if (TextUtils.isEmpty(b16)) {
                Z1().setText(R.string.f1643525l);
                return;
            } else {
                Z1().setText(b16);
                return;
            }
        }
        X1().setVisibility(8);
        X1().setOnClickListener(null);
        Z1().setVisibility(8);
        Z1().setOnClickListener(null);
    }

    private final void x2(boolean isPttFileDownloaded) {
        IPicEmoticonInfo iPicEmoticonInfo = this.emoticonInfo;
        if (iPicEmoticonInfo != null) {
            iPicEmoticonInfo.isNewSoundType();
        }
        h2().setProgress(0.0f);
        Object drawable = c2().getDrawable();
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.Animatable");
        Animatable animatable = (Animatable) drawable;
        if (isPttFileDownloaded) {
            if (animatable.isRunning()) {
                animatable.stop();
            }
            f2().setVisibility(0);
            c2().setVisibility(4);
            return;
        }
        if (!animatable.isRunning()) {
            animatable.start();
        }
        f2().setVisibility(4);
        c2().setVisibility(0);
    }

    private final void y2(IPicEmoticonInfo emoticonInfo) {
        if (emoticonInfo.isSound() && emoticonInfo.isNewSoundType()) {
            if (emoticonInfo.getWaveformArray() != null) {
                ViewGroup.LayoutParams layoutParams = h2().getLayoutParams();
                layoutParams.width = ViewUtils.dip2px(39.0f);
                h2().setAudioData(emoticonInfo.getWaveformArray(), layoutParams.width, emoticonInfo.getVoiceLength());
            }
            int waveBackgroundColor = emoticonInfo.getWaveBackgroundColor();
            int waveForegroundColor = emoticonInfo.getWaveForegroundColor();
            d2().setBackgroundDrawable(new f(waveBackgroundColor, 1, 1, ViewUtils.dip2px(22.0f)));
            g2().setDrawColor(waveBackgroundColor);
            g2().postInvalidate();
            h2().setProgressColor(waveForegroundColor);
            h2().postInvalidate();
            f2().setThemeColor(waveForegroundColor);
            f2().postInvalidate();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public AIOMarketFaceComponentVM createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIOMarketFaceComponentVM) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AIOMarketFaceComponentVM();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        MarketFaceElement marketFaceElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        MsgElement firstTypeElement = q1().getFirstTypeElement(11);
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        this.marketFaceElement = marketFaceElement;
        if (k2(payloads)) {
            l2(position);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return T1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return U1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOMarketFaceUIState$MarketFaceInfoUpdateState) {
            i2(((AIOMarketFaceUIState$MarketFaceInfoUpdateState) state).b());
        } else if (state instanceof AIOMarketFaceUIState$MarketFaceResDownloadState) {
            AIOMarketFaceUIState$MarketFaceResDownloadState aIOMarketFaceUIState$MarketFaceResDownloadState = (AIOMarketFaceUIState$MarketFaceResDownloadState) state;
            j2(aIOMarketFaceUIState$MarketFaceResDownloadState.getResult(), aIOMarketFaceUIState$MarketFaceResDownloadState.a());
        } else {
            super.handleUIState(state);
        }
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (u.a().b()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOMarketFaceComponent", 2, "fast click, ignore it.");
                }
            } else {
                C1();
                int id5 = v3.getId();
                if (id5 == R.id.yxc) {
                    sendIntent(new c.d(q1()));
                } else if (id5 == R.id.xrw) {
                    r2("middle", TextNode.MODE_TAIL, "4", 102);
                    sendIntent(new c.C7309c(q1()));
                } else if (id5 == R.id.big_image_layout) {
                    sendIntent(new c.a(v3, q1().getMsgRecord(), this.marketFaceElement));
                } else {
                    boolean z17 = false;
                    if (id5 == R.id.cfw || id5 == R.id.cfx) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        MarketFaceElement marketFaceElement = this.marketFaceElement;
                        if (marketFaceElement != null) {
                            sendIntent(new c.b(marketFaceElement));
                        }
                    } else if (id5 == R.id.bqk) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime instanceof BaseQQAppInterface) {
                            ((IDoutuService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(IDoutuService.class)).getDoutuMainHandler().obtainMessage(81, (Runnable) null).sendToTarget();
                        }
                        com.tencent.mobileqq.aio.utils.b.l("em_bas_battle_chart", V1());
                        ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", "0X800B548", "0X800B548", 0, 0, "", "", "", "");
                    } else if (id5 == R.id.kzz) {
                        p2();
                    } else {
                        if (id5 == R.id.brz || id5 == R.id.bud) {
                            z17 = true;
                        }
                        if (z17) {
                            o2();
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.voicePlayerControlViewInit) {
            f2().b();
        }
        if (this.voiceWaveViewInit) {
            h2().e();
        }
        if (c2().getDrawable() instanceof Animatable) {
            Object drawable = c2().getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.Animatable");
            ((Animatable) drawable).stop();
        }
        if (w1()) {
            AIOPttAudioPlayerManager.f191706d.F(q1().getMsgId());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        boolean z16;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        boolean z17 = true;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new k(getMContext(), q1(), this, null, 8, null), new ac(getMContext(), q1(), this), new af(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new aj(getMContext(), q1(), this));
        if (this.marketFaceElement != null) {
            IPicEmoticonInfo iPicEmoticonInfo = this.emoticonInfo;
            if (iPicEmoticonInfo != null && iPicEmoticonInfo.getImageJobType() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                IPicEmoticonInfo iPicEmoticonInfo2 = this.emoticonInfo;
                if (iPicEmoticonInfo2 == null || iPicEmoticonInfo2.getImageJobType() != 4) {
                    z17 = false;
                }
                if (!z17) {
                    mutableListOf.add(0, new com.tencent.qqnt.aio.menu.b(getMContext(), q1(), this));
                }
            }
            if (QLog.isColorLevel()) {
                IPicEmoticonInfo iPicEmoticonInfo3 = this.emoticonInfo;
                if (iPicEmoticonInfo3 != null) {
                    num = Integer.valueOf(iPicEmoticonInfo3.getImageJobType());
                } else {
                    num = null;
                }
                QLog.d("AIOMarketFaceComponent", 2, "magic emoticon no add expression, imageJobType:" + num);
            }
        }
        r2(QCircleDaTongConstant.ElementParamValue.LONG_PRESS, "menu", "4", 101);
        return mutableListOf;
    }
}

package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.room.displayview.horizontal.b;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.game.GameRecommendViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.BottomButtonView;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.ButtonLoadingView;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.widget.countdown.CountDownView;
import com.tencent.mobileqq.qqlive.widget.reddot.RedDotView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u00b9\u0001\u0018\u0000 \u00c3\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00c4\u0001B\t\u00a2\u0006\u0006\b\u00c1\u0001\u0010\u00c2\u0001J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J \u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0006H\u0002J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001aH\u0002J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020%H\u0002J\b\u00100\u001a\u00020\u000eH\u0014J\u001c\u00105\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u0001012\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0012\u00106\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00109\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\u0012\u0010C\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010E\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u000107H\u0016R\u0018\u0010H\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0018\u0010V\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010OR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010\\R\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010hR\u0018\u0010o\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010hR\u0018\u0010q\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010hR\u001e\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u007f\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010GR\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R!\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u0092\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R!\u0010\u0097\u0001\u001a\u00030\u0093\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u008f\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R!\u0010\u009c\u0001\u001a\u00030\u0098\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u008f\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R!\u0010\u00a1\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u008f\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001R \u0010\u00a5\u0001\u001a\u00030\u00a2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\\\u0010\u008f\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R!\u0010\u00aa\u0001\u001a\u00030\u00a6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u008f\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001R!\u0010\u00af\u0001\u001a\u00030\u00ab\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ac\u0001\u0010\u008f\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001R!\u0010\u00b4\u0001\u001a\u00030\u00b0\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b1\u0001\u0010\u008f\u0001\u001a\u0006\b\u00b2\u0001\u0010\u00b3\u0001R\u0018\u0010\u00b6\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b5\u0001\u0010\\R\u0018\u0010\u00b8\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b7\u0001\u0010\\R\u0018\u0010\u00bc\u0001\u001a\u00030\u00b9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u001a\u0010\u00c0\u0001\u001a\u0005\u0018\u00010\u00bd\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00be\u0001\u0010\u00bf\u0001\u00a8\u0006\u00c5\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Luq4/c;", "rsp", "", "Mb", "Lb", "nb", "Ob", "", "giftId", "Fb", "", "seconds", "Ib", "Kb", "Cb", "", "isPackageGift", "Db", "Hb", "Jb", "ab", "ob", "", "buttonId", "mb", "url", "Lcom/tencent/biz/ui/TouchWebView;", "bb", WadlProxyConsts.KEY_JUMP_URL, "", "webRatio", "webTrans", "Eb", "Lar4/a;", "data", "Gb", UIJsPlugin.EVENT_SHOW_TOAST, "Nb", "Pb", "Xa", "eventId", "Wa", "bubble", "Va", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "Lfp4/c;", "msgInfo", "onPush", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "v", NodeProps.ON_CLICK, "e", "Landroid/view/View;", "bottomViewStub", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvInput", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "ivGiftBulletSwitch", "i", "ivDefinition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivShare", BdhLogUtil.LogTag.Tag_Conn, "ivDanmu", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", "D", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b;", "autoCollapse", "E", "Z", "isUILandscape", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/ui/TouchWebView;", "gameWebView", "G", "Luq4/c;", "dynamicConfigRsp", "H", "hasReceiveConfig", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "I", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "button1", "J", "button2", "K", "button3", "L", "button4", "M", "button5", "", "N", "Ljava/util/List;", "buttonList", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/ButtonLoadingView;", "P", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/ButtonLoadingView;", "buttonLoadingView", "Lcom/tencent/mobileqq/qqlive/widget/countdown/CountDownView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqlive/widget/countdown/CountDownView;", "countDownView", BdhLogUtil.LogTag.Tag_Req, "redDotGuideView", "Lcom/tencent/mobileqq/qqlive/widget/reddot/RedDotView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqlive/widget/reddot/RedDotView;", "redDotView", "", "Luq4/e;", "T", "[Luq4/e;", "btnDataArray", "Lcom/tencent/mobileqq/widget/tip/a;", "U", "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "V", "Lkotlin/Lazy;", "jb", "()Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "inputViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "W", "gb", "()Lcom/tencent/mobileqq/qqlive/sail/ui/definition/a;", "definitionViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "X", "ib", "()Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "giftViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "Y", UinConfigManager.KEY_HB, "()Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "gameViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/a;", "fb", "()Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/a;", "danmuViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "a0", "lb", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "b0", "cb", "()Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "bottomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "c0", "eb", "()Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "clearScreenViewModel", "d0", "savedDanmuSwitchState", "e0", "savedGiftSwitchState", "com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart$b", "f0", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart$b;", "collapseListener", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "kb", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", "g0", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceBottomLandscapePart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView ivDanmu;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.displayview.horizontal.b autoCollapse;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isUILandscape;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TouchWebView gameWebView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private uq4.c dynamicConfigRsp;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean hasReceiveConfig;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button1;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button2;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button3;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button4;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button5;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private List<BottomButtonView> buttonList;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ButtonLoadingView buttonLoadingView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private CountDownView countDownView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private View redDotGuideView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private RedDotView redDotView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private uq4.e[] btnDataArray;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.tip.a bubbleTip;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy definitionViewModel;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy giftViewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy danmuViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomViewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clearScreenViewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean savedDanmuSwitchState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomViewStub;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean savedGiftSwitchState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvInput;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b collapseListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivGiftBulletSwitch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivDefinition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView ivShare;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart$b", "Lcom/tencent/mobileqq/qqlive/room/displayview/horizontal/b$b;", "", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements b.InterfaceC8369b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.InterfaceC8369b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQLiveAudienceBottomLandscapePart.this.Jb();
                QQLiveAudienceBottomLandscapePart.this.cb().e2(false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.InterfaceC8369b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QQLiveAudienceBottomLandscapePart.this.Hb();
                QQLiveAudienceBottomLandscapePart.this.cb().e2(true);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart$c", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ar4.a f272855a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveAudienceBottomLandscapePart f272856b;

        c(ar4.a aVar, QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart) {
            this.f272855a = aVar;
            this.f272856b = qQLiveAudienceBottomLandscapePart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) qQLiveAudienceBottomLandscapePart);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomLandscapePart", "showGuideBubbleTip onDismiss", "bubbleTip=" + this.f272855a.f26812c);
            this.f272856b.cb().P1(this.f272855a);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomLandscapePart", "showGuideBubbleTip onShow", "bubbleTip=" + this.f272855a.f26812c);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomLandscapePart$d", "Lcom/tencent/mobileqq/qqlive/widget/countdown/CountDownView$a;", "", "onFinish", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements CountDownView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownView f272857a;

        d(CountDownView countDownView) {
            this.f272857a = countDownView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) countDownView);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.countdown.CountDownView.a
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f272857a.setVisibility(4);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52516);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceBottomLandscapePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.buttonList = new ArrayList();
        this.btnDataArray = new uq4.e[0];
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.input.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$inputViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.input.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.input.a) QQLiveAudienceBottomLandscapePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.input.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.input.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.inputViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.definition.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$definitionViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.definition.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.definition.a) QQLiveAudienceBottomLandscapePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.definition.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.definition.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.definitionViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GiftViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$giftViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GiftViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GiftViewModel) QQLiveAudienceBottomLandscapePart.this.getViewModel(GiftViewModel.class) : (GiftViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.giftViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<GameRecommendViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$gameViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GameRecommendViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GameRecommendViewModel) QQLiveAudienceBottomLandscapePart.this.getViewModel(GameRecommendViewModel.class) : (GameRecommendViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.gameViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.danmu.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$danmuViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.danmu.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.danmu.a) QQLiveAudienceBottomLandscapePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.danmu.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.danmu.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.danmuViewModel = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveAudienceBottomLandscapePart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.more.b>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$bottomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (b) QQLiveAudienceBottomLandscapePart.this.getViewModel(b.class) : (b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.bottomViewModel = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$clearScreenViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) QQLiveAudienceBottomLandscapePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.clearScreenViewModel = lazy8;
        this.collapseListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ab(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Cb() {
        ButtonLoadingView buttonLoadingView = this.buttonLoadingView;
        if (buttonLoadingView != null) {
            buttonLoadingView.setVisibility(0);
        }
        ButtonLoadingView buttonLoadingView2 = this.buttonLoadingView;
        if (buttonLoadingView2 != null) {
            buttonLoadingView2.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Db(boolean isPackageGift) {
        int i3;
        ButtonLoadingView buttonLoadingView = this.buttonLoadingView;
        if (buttonLoadingView != null) {
            buttonLoadingView.setVisibility(8);
        }
        ButtonLoadingView buttonLoadingView2 = this.buttonLoadingView;
        if (buttonLoadingView2 != null) {
            buttonLoadingView2.stop();
        }
        if (!isPackageGift) {
            ok4.a g26 = ib().g2();
            if (g26 != null) {
                i3 = g26.getGiftColdDownTs();
            } else {
                i3 = 10;
            }
            Ib(i3);
        }
    }

    private final void Eb(String jumpUrl, float webRatio, boolean webTrans) {
        boolean isBlank;
        int e16;
        isBlank = StringsKt__StringsJVMKt.isBlank(jumpUrl);
        if (!isBlank) {
            Uri.Builder buildUpon = Uri.parse(jumpUrl).buildUpon();
            buildUpon.appendQueryParameter("roomId", String.valueOf(H9()));
            buildUpon.appendQueryParameter("anchorId", String.valueOf(C9()));
            String uri = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
            Bundle bundle = new Bundle();
            int i3 = getContext().getResources().getDisplayMetrics().widthPixels;
            int i16 = getContext().getResources().getDisplayMetrics().heightPixels;
            if (i3 > i16) {
                e16 = wi2.c.e(i3 * webRatio);
            } else {
                e16 = wi2.c.e(i16 * webRatio);
            }
            bundle.putInt("height_web_dialog", e16);
            bundle.putBoolean("transparent_web_bg", webTrans);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(getContext(), uri, bundle);
        }
    }

    private final void Fb(long giftId) {
        long R1 = cb().R1(giftId);
        if (giftId > 0 && R1 > 0) {
            Ib((int) R1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gb(ar4.a data) {
        com.tencent.mobileqq.qqlive.sail.ui.more.b cb5 = cb();
        String str = data.f26811b;
        Intrinsics.checkNotNullExpressionValue(str, "data.bttnId");
        BottomButtonView d26 = cb5.d2(str, this.buttonList);
        if (d26 == null) {
            return;
        }
        if (d26.getVisibility() == 8) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBottomLandscapePart", "showGuideBubbleTip", d26 + " not visible");
            return;
        }
        com.tencent.mobileqq.widget.tip.a a16 = com.tencent.mobileqq.qqlive.sail.ui.more.c.f272913a.a(d26, data);
        a16.f(new c(data, this));
        a16.s0();
        this.bubbleTip = a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hb() {
        for (BottomButtonView bottomButtonView : this.buttonList) {
            boolean z16 = false;
            if (bottomButtonView != null && bottomButtonView.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                bottomButtonView.t();
            }
        }
    }

    private final void Ib(int seconds) {
        CountDownView countDownView = this.countDownView;
        if (countDownView != null) {
            countDownView.setVisibility(0);
            countDownView.g(seconds, new d(countDownView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jb() {
        for (BottomButtonView bottomButtonView : this.buttonList) {
            boolean z16 = false;
            if (bottomButtonView != null && bottomButtonView.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                bottomButtonView.stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kb() {
        CountDownView countDownView = this.countDownView;
        if (countDownView != null) {
            countDownView.h();
        }
        CountDownView countDownView2 = this.countDownView;
        if (countDownView2 != null) {
            countDownView2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lb() {
        String str;
        com.tencent.mobileqq.qqgift.data.service.d j26 = ib().j2();
        if (j26 != null) {
            str = j26.R;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BottomButtonView d26 = cb().d2("10004", this.buttonList);
        if (d26 != null) {
            d26.r(str);
        }
        BottomButtonView d27 = cb().d2("10007", this.buttonList);
        if (d27 != null) {
            d27.r(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Mb(uq4.c rsp) {
        uq4.e[] eVarArr;
        uq4.e[] eVarArr2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (rsp != null) {
            eVarArr = rsp.f439829d;
        } else {
            eVarArr = null;
        }
        if (eVarArr != null) {
            uq4.e[] eVarArr3 = rsp.f439829d;
            Intrinsics.checkNotNullExpressionValue(eVarArr3, "rsp.interactBttn");
            ArrayList arrayList = new ArrayList();
            for (uq4.e eVar : eVarArr3) {
                if (!eVar.f439843h) {
                    arrayList.add(eVar);
                }
            }
            Object[] array = arrayList.toArray(new uq4.e[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            eVarArr2 = (uq4.e[]) array;
        } else {
            uq4.e[] b16 = com.tencent.mobileqq.qqlive.sail.ui.more.bottom.a.f272911a.b();
            ArrayList arrayList2 = new ArrayList();
            for (uq4.e eVar2 : b16) {
                if (!eVar2.f439843h) {
                    arrayList2.add(eVar2);
                }
            }
            Object[] array2 = arrayList2.toArray(new uq4.e[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            eVarArr2 = (uq4.e[]) array2;
        }
        this.btnDataArray = eVarArr2;
        int length = eVarArr2.length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            uq4.e eVar3 = eVarArr2[i3];
            int i18 = i17 + 1;
            BottomButtonView bottomButtonView = this.buttonList.get(i17);
            if (bottomButtonView != null) {
                bottomButtonView.l(i17, eVar3);
            }
            String str = eVar3.f439836a;
            Intrinsics.checkNotNullExpressionValue(str, "data.id");
            Wa(str, "ev_qqlive_abnormal_imp");
            if (Intrinsics.areEqual(eVar3.f439836a, "10004")) {
                String extData = eVar3.f439844i;
                if (extData != null) {
                    Intrinsics.checkNotNullExpressionValue(extData, "extData");
                    if (extData.length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        z18 = true;
                        if (z18) {
                            String str2 = eVar3.f439844i;
                            Intrinsics.checkNotNullExpressionValue(str2, "data.extData");
                            ib().r2(new ok4.b(str2).b());
                        }
                    }
                }
                z18 = false;
                if (z18) {
                }
            }
            if (Intrinsics.areEqual(eVar3.f439836a, "10007")) {
                String extData2 = eVar3.f439844i;
                if (extData2 != null) {
                    Intrinsics.checkNotNullExpressionValue(extData2, "extData");
                    if (extData2.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z16 = true;
                        if (!z16) {
                            String str3 = eVar3.f439844i;
                            Intrinsics.checkNotNullExpressionValue(str3, "data.extData");
                            ok4.a c16 = new ok4.a(str3).c();
                            ib().q2(c16);
                            i16 = c16.getGiftId();
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            i3++;
            i17 = i18;
        }
        nb();
        Ob();
        Fb(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nb(boolean showToast) {
        int i3;
        ImageView imageView = this.ivDanmu;
        if (imageView != null) {
            if (BusConfigHelper.f378723a.f(13, H9())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
        }
        if (fb().M1()) {
            ImageView imageView2 = this.ivDanmu;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.nsa);
            }
            if (showToast) {
                ToastUtil.a().b(R.string.f227706rr);
                return;
            }
            return;
        }
        ImageView imageView3 = this.ivDanmu;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.ns_);
        }
        if (showToast) {
            ToastUtil.a().b(R.string.f158851qq);
        }
    }

    private final void Ob() {
        BottomButtonView d26 = cb().d2("10007", this.buttonList);
        if (d26 == null) {
            return;
        }
        View view = this.redDotGuideView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.rightToRight = d26.getId();
            layoutParams2.topToTop = d26.getId();
            view.setLayoutParams(layoutParams2);
        }
        CountDownView countDownView = this.countDownView;
        if (countDownView != null) {
            ViewGroup.LayoutParams layoutParams3 = countDownView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.leftToLeft = d26.getId();
            layoutParams4.topToTop = d26.getId();
            layoutParams4.rightToRight = d26.getId();
            countDownView.setLayoutParams(layoutParams4);
        }
        ButtonLoadingView buttonLoadingView = this.buttonLoadingView;
        if (buttonLoadingView != null) {
            ViewGroup.LayoutParams layoutParams5 = buttonLoadingView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
            layoutParams6.leftToLeft = d26.getId();
            layoutParams6.topToTop = d26.getId();
            layoutParams6.rightToRight = d26.getId();
            buttonLoadingView.setLayoutParams(layoutParams6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pb(boolean showToast) {
        if (com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a.b()) {
            ImageView imageView = this.ivGiftBulletSwitch;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.nsh);
            }
            if (showToast) {
                ToastUtil.a().e(getContext().getResources().getString(R.string.f227716rs));
                return;
            }
            return;
        }
        ImageView imageView2 = this.ivGiftBulletSwitch;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.nsg);
        }
        if (showToast) {
            ToastUtil.a().e(getContext().getResources().getString(R.string.f158861qr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va(ar4.a bubble) {
        com.tencent.mobileqq.qqlive.sail.ui.more.b cb5 = cb();
        String str = bubble.f26811b;
        Intrinsics.checkNotNullExpressionValue(str, "bubble.bttnId");
        BottomButtonView d26 = cb5.d2(str, this.buttonList);
        if (d26 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(H9());
            f16.d("em_qqlive_bottom_guide_bubble");
            String str2 = bubble.f26812c;
            Intrinsics.checkNotNullExpressionValue(str2, "bubble.tips");
            f16.o(str2);
            String str3 = bubble.f26811b;
            Intrinsics.checkNotNullExpressionValue(str3, "bubble.bttnId");
            f16.k(str3);
            f16.l(String.valueOf(d26.o()));
            f16.B("1");
            aVar.i("ev_qqlive_abnormal_imp", f16.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa(String buttonId, String eventId) {
        BottomButtonView d26 = cb().d2(buttonId, this.buttonList);
        if (d26 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(H9());
            f16.d("em_qqlive_bottom_function_button");
            f16.k(buttonId);
            f16.l(String.valueOf(d26.o()));
            f16.B("1");
            aVar.i(eventId, f16.a());
        }
    }

    private final void Xa() {
        View view = this.bottomViewStub;
        if (view != null) {
            QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
            qQLiveDaTongParams.B("1");
            com.tencent.mobileqq.qqlive.sail.report.a.c(com.tencent.mobileqq.qqlive.sail.report.a.f272382a, view, "em_qqlive_bottom_bar", qQLiveDaTongParams.a(), false, null, 24, null);
        }
        TextView textView = this.tvInput;
        if (textView != null) {
            QQLiveDaTongParams qQLiveDaTongParams2 = new QQLiveDaTongParams();
            qQLiveDaTongParams2.R("em_qqlive_bottom_bar");
            com.tencent.mobileqq.qqlive.sail.report.a.c(com.tencent.mobileqq.qqlive.sail.report.a.f272382a, textView, "em_qqlive_inputbar", qQLiveDaTongParams2.a(), false, null, 24, null);
        }
        ImageView imageView = this.ivGiftBulletSwitch;
        if (imageView != null) {
            com.tencent.mobileqq.qqlive.sail.report.a.c(com.tencent.mobileqq.qqlive.sail.report.a.f272382a, imageView, "em_qqlive_gift_texiao_switch", new HashMap(), false, null, 24, null);
            VideoReport.setEventDynamicParams(imageView, new IDynamicParams() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.j
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map Ya;
                    Ya = QQLiveAudienceBottomLandscapePart.Ya(str);
                    return Ya;
                }
            });
        }
        ImageView imageView2 = this.ivDanmu;
        if (imageView2 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a.c(com.tencent.mobileqq.qqlive.sail.report.a.f272382a, imageView2, "em_qqlive_barrage_settings", new HashMap(), false, null, 24, null);
            VideoReport.setEventDynamicParams(imageView2, new IDynamicParams() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.o
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map Za;
                    Za = QQLiveAudienceBottomLandscapePart.Za(QQLiveAudienceBottomLandscapePart.this, str);
                    return Za;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Ya(String str) {
        boolean b16 = com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a.b();
        String str2 = "1";
        if (!Intrinsics.areEqual(str, "clck") ? !b16 : b16) {
            str2 = "0";
        }
        QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
        qQLiveDaTongParams.w(str2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(qQLiveDaTongParams.a());
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Za(QQLiveAudienceBottomLandscapePart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = "0";
        if (!Intrinsics.areEqual(str, "clck") ? this$0.fb().M1() : !this$0.fb().M1()) {
            str2 = "1";
        }
        QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
        qQLiveDaTongParams.p(str2);
        qQLiveDaTongParams.B("1");
        qQLiveDaTongParams.R("em_qqlive_bottom_bar");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(qQLiveDaTongParams.a());
        return linkedHashMap;
    }

    private final void ab() {
        Jb();
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar = this.autoCollapse;
        if (bVar != null) {
            bVar.m();
        }
        this.autoCollapse = null;
    }

    private final TouchWebView bb(String url) {
        if (this.gameWebView == null) {
            GameRecommendViewModel hb5 = hb();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            this.gameWebView = hb5.t2(activity, url);
        }
        return this.gameWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.more.b cb() {
        Object value = this.bottomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.more.b) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a eb() {
        Object value = this.clearScreenViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clearScreenViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.danmu.a fb() {
        Object value = this.danmuViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-danmuViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.danmu.a) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.definition.a gb() {
        Object value = this.definitionViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-definitionViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.definition.a) value;
    }

    private final GameRecommendViewModel hb() {
        Object value = this.gameViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gameViewModel>(...)");
        return (GameRecommendViewModel) value;
    }

    private final GiftViewModel ib() {
        Object value = this.giftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-giftViewModel>(...)");
        return (GiftViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.input.a jb() {
        Object value = this.inputViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.input.a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e kb() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    private final RoomViewModel lb() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mb(String buttonId) {
        uq4.e U1;
        String str;
        AudienceRoomInfo b16;
        HashMap<String, String> l3;
        boolean z16;
        boolean z17;
        long j3 = 0;
        boolean z18 = false;
        int i3 = 1;
        switch (buttonId.hashCode()) {
            case 46730162:
                if (buttonId.equals(HippyQQConstants.HIPPY_CHANNEL)) {
                    ((MorePanelViewModel) getViewModel(MorePanelViewModel.class)).a2(true);
                    return;
                }
                break;
            case 46730163:
                if (buttonId.equals("10002")) {
                    uq4.e U12 = cb().U1(buttonId, this.dynamicConfigRsp);
                    if (U12 != null) {
                        String str2 = U12.f439839d;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.jumpUrl");
                        Eb(str2, U12.f439841f, U12.f439842g);
                        return;
                    }
                    return;
                }
                break;
            case 46730164:
                if (buttonId.equals("10003")) {
                    QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                    if (c16 == null || (l3 = c16.l()) == null || (str = l3.get("qz_gdt")) == null) {
                        str = "";
                    }
                    String str3 = str;
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mobileqq.qqlive.sail.room.e kb5 = kb();
                    if (kb5 != null && (b16 = kb5.b()) != null) {
                        j3 = b16.n();
                    }
                    long j16 = (currentTimeMillis - j3) / 1000;
                    if (J9() == 1) {
                        i3 = 2;
                    }
                    cj4.c.f31003a.g(String.valueOf(C9()), H9(), j16, E9(), i3, str3);
                    return;
                }
                break;
            case 46730165:
                if (buttonId.equals("10004")) {
                    broadcastMessage("onSendGift", ib().j2());
                    return;
                }
                break;
            case 46730166:
                if (buttonId.equals("10005")) {
                    ib().s2(true);
                    return;
                }
                break;
            case 46730167:
                if (buttonId.equals("10006")) {
                    String Q1 = hb().Q1();
                    if (hb().R1() == 1) {
                        hb().k2(getActivity(), null, Q1);
                        return;
                    } else {
                        hb().k2(getActivity(), bb(Q1), Q1);
                        return;
                    }
                }
                break;
            case 46730168:
                if (buttonId.equals("10007")) {
                    ButtonLoadingView buttonLoadingView = this.buttonLoadingView;
                    if (buttonLoadingView != null && buttonLoadingView.getVisibility() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomLandscapePart", "Button in loading state.");
                        return;
                    }
                    CountDownView countDownView = this.countDownView;
                    if (countDownView != null && countDownView.getVisibility() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomLandscapePart", "Button in countdown state.");
                        return;
                    }
                    com.tencent.mobileqq.qqgift.data.service.d j26 = ib().j2();
                    if (j26 == null) {
                        return;
                    }
                    Long value = ib().h2().getValue();
                    if (value == null) {
                        value = 0L;
                    }
                    if (value.longValue() > 0) {
                        z18 = true;
                    }
                    j26.f264875d0 = z18;
                    broadcastMessage("onSendGift", j26);
                    Cb();
                    return;
                }
                break;
        }
        if (buttonId.length() > 0) {
            z18 = true;
        }
        if (z18 && (U1 = cb().U1(buttonId, this.dynamicConfigRsp)) != null) {
            String str4 = U1.f439839d;
            Intrinsics.checkNotNullExpressionValue(str4, "it.jumpUrl");
            Eb(str4, U1.f439841f, U1.f439842g);
        }
    }

    private final void nb() {
        BottomButtonView d26 = cb().d2("10004", this.buttonList);
        if (d26 != null) {
            cb().g2(d26.o(), this.btnDataArray.length);
        }
    }

    private final void ob() {
        LiveData<Boolean> M1 = jb().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                textView = QQLiveAudienceBottomLandscapePart.this.tvInput;
                if (textView != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    wi2.d.e(textView, it.booleanValue());
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.pb(Function1.this, obj);
            }
        });
        LiveData<StreamDefinition> R1 = gb().R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<StreamDefinition, Unit> function12 = new Function1<StreamDefinition, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StreamDefinition streamDefinition) {
                invoke2(streamDefinition);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StreamDefinition streamDefinition) {
                ImageView imageView;
                com.tencent.mobileqq.qqlive.sail.ui.definition.a gb5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) streamDefinition);
                    return;
                }
                imageView = QQLiveAudienceBottomLandscapePart.this.ivDefinition;
                if (imageView != null) {
                    gb5 = QQLiveAudienceBottomLandscapePart.this.gb();
                    imageView.setImageResource(gb5.P1());
                }
            }
        };
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.qb(Function1.this, obj);
            }
        });
        LiveData<c55.d> f26 = ib().f2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<c55.d, Unit> function13 = new Function1<c55.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable c55.d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                } else if (dVar != null) {
                    QQLiveAudienceBottomLandscapePart.this.startInit();
                }
            }
        };
        f26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.rb(Function1.this, obj);
            }
        });
        LiveData<Boolean> e26 = ib().e2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isDevelopLevel()) {
                    companion.d("Audience|QQLiveAudienceBottomLandscapePart", "giftEnableChanged", "roomId=" + QQLiveAudienceBottomLandscapePart.this.H9() + ", enable=" + bool);
                }
            }
        };
        e26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.sb(Function1.this, obj);
            }
        });
        LiveData<cr4.b> b26 = hb().b2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<cr4.b, Unit> function15 = new Function1<cr4.b, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cr4.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable cr4.b bVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQLiveAudienceBottomLandscapePart.this.startInit();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                }
            }
        };
        b26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.tb(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> e27 = lb().e2();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                bVar = QQLiveAudienceBottomLandscapePart.this.autoCollapse;
                if (bVar != null) {
                    bVar.l();
                }
            }
        };
        e27.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.ub(Function1.this, obj);
            }
        });
        LiveData<Boolean> L1 = eb().L1();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                com.tencent.mobileqq.qqlive.sail.ui.danmu.a fb5;
                boolean z16;
                boolean z17;
                com.tencent.mobileqq.qqlive.sail.ui.danmu.a fb6;
                com.tencent.mobileqq.qqlive.sail.ui.danmu.a fb7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.booleanValue()) {
                    fb5 = QQLiveAudienceBottomLandscapePart.this.fb();
                    z16 = QQLiveAudienceBottomLandscapePart.this.savedDanmuSwitchState;
                    fb5.N1(z16);
                    com.tencent.timi.game.liveroom.impl.room.manager.a aVar = com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a;
                    z17 = QQLiveAudienceBottomLandscapePart.this.savedGiftSwitchState;
                    aVar.c(z17);
                } else {
                    QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart = QQLiveAudienceBottomLandscapePart.this;
                    fb6 = qQLiveAudienceBottomLandscapePart.fb();
                    qQLiveAudienceBottomLandscapePart.savedDanmuSwitchState = fb6.M1();
                    QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart2 = QQLiveAudienceBottomLandscapePart.this;
                    com.tencent.timi.game.liveroom.impl.room.manager.a aVar2 = com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a;
                    qQLiveAudienceBottomLandscapePart2.savedGiftSwitchState = aVar2.b();
                    fb7 = QQLiveAudienceBottomLandscapePart.this.fb();
                    fb7.N1(false);
                    aVar2.c(false);
                }
                QQLiveAudienceBottomLandscapePart.this.Nb(false);
                QQLiveAudienceBottomLandscapePart.this.Pb(false);
            }
        };
        L1.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.vb(Function1.this, obj);
            }
        });
        LiveData<String> Z1 = cb().Z1();
        LifecycleOwner lifecycleOwner8 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function18 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                z16 = QQLiveAudienceBottomLandscapePart.this.isUILandscape;
                if (z16) {
                    QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart = QQLiveAudienceBottomLandscapePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQLiveAudienceBottomLandscapePart.mb(it);
                    QQLiveAudienceBottomLandscapePart.this.Wa(it, "ev_qqlive_abnormal_clck");
                }
            }
        };
        Z1.observe(lifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.wb(Function1.this, obj);
            }
        });
        LiveData<ar4.a> T1 = cb().T1();
        LifecycleOwner lifecycleOwner9 = getPartHost().getLifecycleOwner();
        final QQLiveAudienceBottomLandscapePart$observeData$9 qQLiveAudienceBottomLandscapePart$observeData$9 = new QQLiveAudienceBottomLandscapePart$observeData$9(this);
        T1.observe(lifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.xb(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.qqgift.data.service.d> k26 = ib().k2();
        LifecycleOwner lifecycleOwner10 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.qqgift.data.service.d, Unit> function19 = new Function1<com.tencent.mobileqq.qqgift.data.service.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$10
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqgift.data.service.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.qqgift.data.service.d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQLiveAudienceBottomLandscapePart.this.Lb();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                }
            }
        };
        k26.observe(lifecycleOwner10, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.yb(Function1.this, obj);
            }
        });
        LiveData<Long> h26 = ib().h2();
        LifecycleOwner lifecycleOwner11 = getPartHost().getLifecycleOwner();
        final Function1<Long, Unit> function110 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$11
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                RedDotView redDotView;
                CountDownView countDownView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                redDotView = QQLiveAudienceBottomLandscapePart.this.redDotView;
                if (redDotView != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    redDotView.setRedDotNum(it.longValue());
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.longValue() > 0) {
                    countDownView = QQLiveAudienceBottomLandscapePart.this.countDownView;
                    boolean z16 = false;
                    if (countDownView != null && countDownView.getVisibility() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        QQLiveAudienceBottomLandscapePart.this.Kb();
                    }
                }
            }
        };
        h26.observe(lifecycleOwner11, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.Ab(Function1.this, obj);
            }
        });
        LiveData<Boolean> l26 = ib().l2();
        LifecycleOwner lifecycleOwner12 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function111 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomLandscapePart$observeData$12
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomLandscapePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart = QQLiveAudienceBottomLandscapePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveAudienceBottomLandscapePart.Db(it.booleanValue());
            }
        };
        l26.observe(lifecycleOwner12, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomLandscapePart.Bb(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ub(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        this.hasReceiveConfig = true;
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        this.dynamicConfigRsp = busConfigHelper.k(H9());
        if (R9() && this.hasReceiveConfig && (true ^ this.buttonList.isEmpty())) {
            Mb(this.dynamicConfigRsp);
        }
        ImageView imageView = this.ivShare;
        int i16 = 8;
        if (imageView != null) {
            if (busConfigHelper.f(16, H9())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
        }
        ImageView imageView2 = this.ivDanmu;
        if (imageView2 != null) {
            if (!busConfigHelper.f(13, H9())) {
                i16 = 0;
            }
            imageView2.setVisibility(i16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ab();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        com.tencent.mobileqq.widget.tip.a aVar = this.bubbleTip;
        if (aVar != null) {
            aVar.o();
        }
        CountDownView countDownView = this.countDownView;
        boolean z16 = false;
        if (countDownView != null && countDownView.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            ok4.a g26 = ib().g2();
            long j16 = 0;
            if (g26 != null) {
                j3 = g26.getGiftId();
            } else {
                j3 = 0;
            }
            CountDownView countDownView2 = this.countDownView;
            if (countDownView2 != null) {
                j16 = countDownView2.f();
            }
            cb().i2(j3, j16);
        }
        Kb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f60092uh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3);
        } else {
            String str = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f59812tq) {
                jb().O1(true);
            } else if (num != null && num.intValue() == R.id.f59782tn) {
                gb().X1(true);
            } else if (num != null && num.intValue() == R.id.f59822tr) {
                wk4.a.h(getContext(), H9(), null);
            } else if (num != null && num.intValue() == R.id.f59772tm) {
                this.savedDanmuSwitchState = !fb().M1();
                fb().N1(this.savedDanmuSwitchState);
                Nb(true);
            } else if (num != null && num.intValue() == R.id.f59792to) {
                com.tencent.timi.game.liveroom.impl.room.manager.a aVar = com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a;
                boolean z16 = !aVar.b();
                this.savedGiftSwitchState = z16;
                aVar.c(z16);
                Pb(true);
            } else if (num != null && num.intValue() == R.id.f59842tt) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b cb5 = cb();
                BottomButtonView bottomButtonView = this.button1;
                if (bottomButtonView != null) {
                    str = bottomButtonView.m();
                }
                cb5.f2(str);
            } else if (num != null && num.intValue() == R.id.f59862tv) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b cb6 = cb();
                BottomButtonView bottomButtonView2 = this.button2;
                if (bottomButtonView2 != null) {
                    str = bottomButtonView2.m();
                }
                cb6.f2(str);
            } else if (num != null && num.intValue() == R.id.f59882tx) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b cb7 = cb();
                BottomButtonView bottomButtonView3 = this.button3;
                if (bottomButtonView3 != null) {
                    str = bottomButtonView3.m();
                }
                cb7.f2(str);
            } else if (num != null && num.intValue() == R.id.f59902tz) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b cb8 = cb();
                BottomButtonView bottomButtonView4 = this.button4;
                if (bottomButtonView4 != null) {
                    str = bottomButtonView4.m();
                }
                cb8.f2(str);
            } else if (num != null && num.intValue() == R.id.f59922u1) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b cb9 = cb();
                BottomButtonView bottomButtonView5 = this.button5;
                if (bottomButtonView5 != null) {
                    str = bottomButtonView5.m();
                }
                cb9.f2(str);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        Integer num;
        Integer num2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null && configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isUILandscape = z16;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        Integer num3 = null;
        if (companion.isDevelopLevel()) {
            long H9 = H9();
            if (configuration != null) {
                num2 = Integer.valueOf(configuration.orientation);
            } else {
                num2 = null;
            }
            companion.d("Audience|QQLiveAudienceBottomLandscapePart", "onConfigurationChanged", "roomId=" + H9 + ", orientation=" + num2);
        }
        if (configuration != null) {
            num = Integer.valueOf(configuration.orientation);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            View view = this.bottomViewStub;
            if (view != null) {
                wi2.d.e(view, false);
            }
            Jb();
            com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
            if (F9 != null) {
                F9.e(this);
            }
            com.tencent.mobileqq.widget.tip.a aVar = this.bubbleTip;
            if (aVar != null) {
                aVar.o();
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 2) {
            if (!R9()) {
                return;
            }
            startInit();
            View view2 = this.bottomViewStub;
            if (view2 != null) {
                wi2.d.e(view2, true);
            }
            Hb();
            if (this.autoCollapse == null) {
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar = new com.tencent.mobileqq.qqlive.room.displayview.horizontal.b();
                this.autoCollapse = bVar;
                bVar.n(null, this.bottomViewStub);
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar2 = this.autoCollapse;
                if (bVar2 != null) {
                    bVar2.o(this.collapseListener);
                }
            }
            com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar3 = this.autoCollapse;
            if (bVar3 != null) {
                com.tencent.mobileqq.qqlive.room.displayview.horizontal.b.q(bVar3, 0, 0, 3, null);
            }
            com.tencent.mobileqq.qqlive.sail.room.f F92 = F9();
            if (F92 != null) {
                F92.p(285, this);
            }
            nb();
            return;
        }
        if (configuration != null) {
            num3 = Integer.valueOf(configuration.orientation);
        }
        companion.w("Audience|QQLiveAudienceBottomLandscapePart", "onConfigurationChanged", "unknown orientation, " + num3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        BottomButtonView bottomButtonView;
        BottomButtonView bottomButtonView2;
        BottomButtonView bottomButtonView3;
        BottomButtonView bottomButtonView4;
        BottomButtonView bottomButtonView5;
        List<BottomButtonView> mutableListOf;
        ButtonLoadingView buttonLoadingView;
        CountDownView countDownView;
        View view2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        RedDotView redDotView = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f60092uh);
        } else {
            view = null;
        }
        this.bottomViewStub = view;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f59812tq);
        } else {
            textView = null;
        }
        this.tvInput = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f59792to);
        } else {
            imageView = null;
        }
        this.ivGiftBulletSwitch = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        Pb(false);
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f59782tn);
        } else {
            imageView2 = null;
        }
        this.ivDefinition = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView5 = this.ivDefinition;
        if (imageView5 != null) {
            imageView5.setImageResource(gb().P1());
        }
        if (rootView != null) {
            imageView3 = (ImageView) rootView.findViewById(R.id.f59822tr);
        } else {
            imageView3 = null;
        }
        this.ivShare = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ImageView imageView6 = this.ivShare;
        if (imageView6 != null) {
            if (BusConfigHelper.f378723a.f(16, H9())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView6.setVisibility(i3);
        }
        if (rootView != null) {
            imageView4 = (ImageView) rootView.findViewById(R.id.f59772tm);
        } else {
            imageView4 = null;
        }
        this.ivDanmu = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(this);
        }
        Nb(false);
        ob();
        Xa();
        if (rootView != null) {
            bottomButtonView = (BottomButtonView) rootView.findViewById(R.id.f59842tt);
        } else {
            bottomButtonView = null;
        }
        this.button1 = bottomButtonView;
        if (bottomButtonView != null) {
            bottomButtonView.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView2 = (BottomButtonView) rootView.findViewById(R.id.f59862tv);
        } else {
            bottomButtonView2 = null;
        }
        this.button2 = bottomButtonView2;
        if (bottomButtonView2 != null) {
            bottomButtonView2.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView3 = (BottomButtonView) rootView.findViewById(R.id.f59882tx);
        } else {
            bottomButtonView3 = null;
        }
        this.button3 = bottomButtonView3;
        if (bottomButtonView3 != null) {
            bottomButtonView3.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView4 = (BottomButtonView) rootView.findViewById(R.id.f59902tz);
        } else {
            bottomButtonView4 = null;
        }
        this.button4 = bottomButtonView4;
        if (bottomButtonView4 != null) {
            bottomButtonView4.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView5 = (BottomButtonView) rootView.findViewById(R.id.f59922u1);
        } else {
            bottomButtonView5 = null;
        }
        this.button5 = bottomButtonView5;
        if (bottomButtonView5 != null) {
            bottomButtonView5.setOnClickListener(this);
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.button1, this.button2, this.button3, this.button4, this.button5);
        this.buttonList = mutableListOf;
        if (rootView != null) {
            buttonLoadingView = (ButtonLoadingView) rootView.findViewById(R.id.f59962u5);
        } else {
            buttonLoadingView = null;
        }
        this.buttonLoadingView = buttonLoadingView;
        if (rootView != null) {
            countDownView = (CountDownView) rootView.findViewById(R.id.f59942u3);
        } else {
            countDownView = null;
        }
        this.countDownView = countDownView;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f59992u8);
        } else {
            view2 = null;
        }
        this.redDotGuideView = view2;
        if (rootView != null) {
            redDotView = (RedDotView) rootView.findViewById(R.id.f60002u9);
        }
        this.redDotView = redDotView;
        ButtonLoadingView buttonLoadingView2 = this.buttonLoadingView;
        if (buttonLoadingView2 != null) {
            buttonLoadingView2.setAutoStop(true);
        }
        if (R9() && this.hasReceiveConfig && (!this.buttonList.isEmpty())) {
            Mb(this.dynamicConfigRsp);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        this.savedDanmuSwitchState = fb().M1();
        this.savedGiftSwitchState = com.tencent.timi.game.liveroom.impl.room.manager.a.f377921a.b();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        ab();
        TouchWebView touchWebView = this.gameWebView;
        if (touchWebView != null) {
            touchWebView.clearView();
        }
        TouchWebView touchWebView2 = this.gameWebView;
        if (touchWebView2 != null) {
            touchWebView2.destroy();
        }
        this.gameWebView = null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        ar4.a n3 = com.tencent.mobileqq.qqlive.sail.push.a.n(msgInfo);
        if (n3 != null) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomLandscapePart", "onPush", "roomId=" + H9() + ", bubbleTips=" + n3.f26812c);
            cb().O1(n3);
        }
    }
}

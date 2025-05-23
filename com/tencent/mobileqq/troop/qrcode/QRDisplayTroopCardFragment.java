package com.tencent.mobileqq.troop.qrcode;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qrcode.util.QRCodeLoadingComponent;
import com.tencent.biz.qrcode.util.TroopQRCodeDTReportHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.addsource.TroopSourceHandler;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopSearchWay;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.protofile.source.QunJoinUrlSvrPB$ButtonItem;
import com.tencent.protofile.source.QunJoinUrlSvrPB$GetInfoRsp;
import com.tencent.protofile.source.QunSourceSvrPB$SourceItem;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00be\u00012\u00020\u0001:\u0004\u00bf\u0001\u00c0\u0001B\t\u00a2\u0006\u0006\b\u00bc\u0001\u0010\u00bd\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0003J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J#\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\b\u0010(\u001a\u00020\u0002H\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0014H\u0002J\b\u00103\u001a\u00020\u0002H\u0002J\b\u00104\u001a\u00020\u0002H\u0002J\b\u00106\u001a\u000205H\u0002J\u0012\u00109\u001a\u00020\u00022\b\u00108\u001a\u0004\u0018\u000107H\u0016J$\u0010>\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010?\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000107H\u0016J\b\u0010@\u001a\u00020\u0014H\u0016J\b\u0010A\u001a\u00020\u0002H\u0016J\u0010\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020\u0002H\u0016J\"\u0010J\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016R\u0016\u0010M\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010X\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010OR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010OR\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010OR\u0016\u0010j\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010SR\u0016\u0010l\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010OR\u0016\u0010n\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bm\u0010SR\u0016\u0010p\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010SR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010sR\u0016\u0010x\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010OR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010LR\u0018\u0010\u0088\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010OR\u0018\u0010\u008a\u0001\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010SR\u0018\u0010\u008c\u0001\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010SR\u0018\u0010\u008e\u0001\u001a\u00020q8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010sR\u0018\u0010\u0090\u0001\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010[R\u0018\u0010\u0092\u0001\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010SR\u0018\u0010\u0094\u0001\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010SR\u001a\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010\u009e\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010OR\u0018\u0010\u00a0\u0001\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010SR\u001a\u0010\u00a4\u0001\u001a\u00030\u00a1\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0017\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010LR\u001b\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a9\u0001\u0010OR\u001b\u0010\u00ac\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u001a\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ad\u0001\u0010LR!\u0010\u00b3\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00b0\u00010\u00af\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u001a\u0010\u00b7\u0001\u001a\u00030\u00b4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u0018\u0010\u00bb\u0001\u001a\u00030\u00b8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001\u00a8\u0006\u00c1\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initData", "Landroid/view/View;", "view", "initView", "Bi", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initReport", "", "qrCodeStyle", "ci", "(Ljava/lang/Integer;)V", "", AppConstants.Preferences.TROOP_NICK, "troopUin", "fi", "di", "Th", "", "isAIGCStyle", WidgetCacheLunarData.YI, "initListener", "Lcom/tencent/biz/qrcode/mgr/d;", "qrCodeData", "ni", "xi", NodeProps.VISIBLE, "qi", "maskTipsResId", "ti", "(ZLjava/lang/Integer;)V", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$BottomTipsVisibility;", "visibility", "Landroid/text/SpannableStringBuilder;", "cannotSearchTipsLayoutStr", "ri", WidgetCacheLunarData.JI, "ki", "ii", "Landroid/content/Context;", "context", "mi", "li", "setStatusBarImmersive", "Rh", "hi", "vi", "isVisible", "Ai", "pi", "zi", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay;", "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "onPostThemeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "curChain", "D", "Landroid/view/View;", "backBtn", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "troopNameTv", UserInfo.SEX_FEMALE, "troopUinTv", "G", "copyTroopUinBtn", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "H", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "troopAvatar", "I", "qrCodeLayout", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", "J", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", CommonConstant.KEY_QR_CODE, "Lcom/tencent/mobileqq/troop/qrcode/ad;", "K", "Lcom/tencent/mobileqq/troop/qrcode/ad;", "chainProcessor", "L", "maskLayer", "M", "maskTipsTv", "N", "bottomTipsLayout", "P", "bottomTipsShort", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "bottomTipsShortCannotSearch", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "saveBtnWrapper", ExifInterface.LATITUDE_SOUTH, "shareBtnWrapper", "T", "shareLayout", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard;", "U", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopShareCard;", "shareCard", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "V", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "W", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "X", "from", "Y", "sourceDescContainer", "Z", "sourceDescTextView", "a0", "sourceEditTextView", "b0", "aigcEntranceWrapper", "c0", "aigcAvatar", "d0", "aigcNameText", "e0", "aigcUinText", "Landroid/widget/ImageView;", "f0", "Landroid/widget/ImageView;", "aigcImage", "Landroidx/cardview/widget/CardView;", "g0", "Landroidx/cardview/widget/CardView;", "aigcCardView", "h0", "aigcCardLayout", "i0", "backToNormal", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager;", "j0", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager;", "viewModel", "k0", "l0", "Ljava/lang/Integer;", "reportQRCodeStyle", "m0", "n0", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay;", "troopSearchWay", "o0", "selectedSourceId", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/protofile/source/QunSourceSvrPB$SourceItem;", "p0", "Landroidx/lifecycle/MutableLiveData;", "sourceItem", "Lcom/tencent/mobileqq/troop/addsource/TroopSourceHandler;", "q0", "Lcom/tencent/mobileqq/troop/addsource/TroopSourceHandler;", "troopSourceHandler", "Lzv3/c;", "r0", "Lzv3/c;", "troopSourceDataObserver", "<init>", "()V", "s0", "BottomTipsVisibility", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRDisplayTroopCardFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String curChain;

    /* renamed from: D, reason: from kotlin metadata */
    private View backBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView troopNameTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView troopUinTv;

    /* renamed from: G, reason: from kotlin metadata */
    private View copyTroopUinBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private QQProAvatarView troopAvatar;

    /* renamed from: I, reason: from kotlin metadata */
    private View qrCodeLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private QRCodeLoadingComponent qrCode;

    /* renamed from: K, reason: from kotlin metadata */
    private ad chainProcessor;

    /* renamed from: L, reason: from kotlin metadata */
    private View maskLayer;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView maskTipsTv;

    /* renamed from: N, reason: from kotlin metadata */
    private View bottomTipsLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView bottomTipsShort;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView bottomTipsShortCannotSearch;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout saveBtnWrapper;

    /* renamed from: S, reason: from kotlin metadata */
    private LinearLayout shareBtnWrapper;

    /* renamed from: T, reason: from kotlin metadata */
    private View shareLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private QRDisplayTroopShareCard shareCard;

    /* renamed from: V, reason: from kotlin metadata */
    private TroopInfoData troopInfoData;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TroopInfo troopInfo;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String from;

    /* renamed from: Y, reason: from kotlin metadata */
    private View sourceDescContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView sourceDescTextView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView sourceEditTextView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout aigcEntranceWrapper;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView aigcAvatar;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView aigcNameText;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private TextView aigcUinText;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ImageView aigcImage;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private CardView aigcCardView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private View aigcCardLayout;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private TextView backToNormal;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private QRDisplayTroopCardManager viewModel;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer reportQRCodeStyle;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QRDisplayTroopSearchWay troopSearchWay;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String selectedSourceId;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<QunSourceSvrPB$SourceItem> sourceItem;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private TroopSourceHandler troopSourceHandler;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final zv3.c troopSourceDataObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$BottomTipsVisibility;", "", "(Ljava/lang/String;I)V", "SCAN_TIPS_VISIBLE", "CANNOT_SEARCH_TIPS_VISIBLE", "ALL_GONE", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class BottomTipsVisibility {
        private static final /* synthetic */ BottomTipsVisibility[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BottomTipsVisibility ALL_GONE;
        public static final BottomTipsVisibility CANNOT_SEARCH_TIPS_VISIBLE;
        public static final BottomTipsVisibility SCAN_TIPS_VISIBLE;

        private static final /* synthetic */ BottomTipsVisibility[] $values() {
            return new BottomTipsVisibility[]{SCAN_TIPS_VISIBLE, CANNOT_SEARCH_TIPS_VISIBLE, ALL_GONE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62041);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            SCAN_TIPS_VISIBLE = new BottomTipsVisibility("SCAN_TIPS_VISIBLE", 0);
            CANNOT_SEARCH_TIPS_VISIBLE = new BottomTipsVisibility("CANNOT_SEARCH_TIPS_VISIBLE", 1);
            ALL_GONE = new BottomTipsVisibility("ALL_GONE", 2);
            $VALUES = $values();
        }

        BottomTipsVisibility(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static BottomTipsVisibility valueOf(String str) {
            return (BottomTipsVisibility) Enum.valueOf(BottomTipsVisibility.class, str);
        }

        public static BottomTipsVisibility[] values() {
            return (BottomTipsVisibility[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$a;", "", "", "QRCODE_MASK_ALPHA", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "", "TROOP_MEMBER_TYPE_ADMIN", "I", "TROOP_MEMBER_TYPE_MEMBER", "TROOP_MEMBER_TYPE_OWNER", "TROOP_MEMBER_TYPE_STRANGER", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298113a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62056);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BottomTipsVisibility.values().length];
            try {
                iArr[BottomTipsVisibility.SCAN_TIPS_VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomTipsVisibility.CANNOT_SEARCH_TIPS_VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomTipsVisibility.ALL_GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f298113a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$c", "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopSearchWay$a;", "", "newTroopName", "", "b", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements QRDisplayTroopSearchWay.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QRDisplayTroopSearchWay f298114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QRDisplayTroopCardFragment f298115b;

        c(QRDisplayTroopSearchWay qRDisplayTroopSearchWay, QRDisplayTroopCardFragment qRDisplayTroopCardFragment) {
            this.f298114a = qRDisplayTroopSearchWay;
            this.f298115b = qRDisplayTroopCardFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qRDisplayTroopSearchWay, (Object) qRDisplayTroopCardFragment);
            }
        }

        @Override // com.tencent.mobileqq.troop.qrcode.QRDisplayTroopSearchWay.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f298115b.xi();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.qrcode.QRDisplayTroopSearchWay.a
        public void b(@Nullable String newTroopName) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newTroopName);
                return;
            }
            if (newTroopName != null && newTroopName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            TroopInfoData g16 = this.f298114a.g();
            if (g16 != null) {
                g16.troopName = newTroopName;
            }
            TextView textView = this.f298115b.troopNameTv;
            QRDisplayTroopShareCard qRDisplayTroopShareCard = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopNameTv");
                textView = null;
            }
            textView.setText(newTroopName);
            QRDisplayTroopShareCard qRDisplayTroopShareCard2 = this.f298115b.shareCard;
            if (qRDisplayTroopShareCard2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
            } else {
                qRDisplayTroopShareCard = qRDisplayTroopShareCard2;
            }
            qRDisplayTroopShareCard.U(newTroopName);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J@\u0010\r\u001a\u00020\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$d", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "", "c", "d", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "chain", "", "cb", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends QRCodeLoadingComponent.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
            }
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        public void b(@NotNull Function2<? super Boolean, ? super String, Unit> cb5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cb5);
                return;
            }
            Intrinsics.checkNotNullParameter(cb5, "cb");
            QRDisplayTroopCardManager qRDisplayTroopCardManager = QRDisplayTroopCardFragment.this.viewModel;
            if (qRDisplayTroopCardManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qRDisplayTroopCardManager = null;
            }
            qRDisplayTroopCardManager.S1(QRDisplayTroopCardFragment.this.troopUin);
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        @NotNull
        /* renamed from: c */
        public String getF94861a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return QRDisplayTroopCardFragment.this.troopUin;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        @NotNull
        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "QRDisplayTroopCardFragment";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J@\u0010\f\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$e", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "", "c", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "chain", "", "cb", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e extends QRCodeLoadingComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qrcode.mgr.d f298118b;

        e(com.tencent.biz.qrcode.mgr.d dVar) {
            this.f298118b = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this, (Object) dVar);
            }
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        public void b(@NotNull Function2<? super Boolean, ? super String, Unit> cb5) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cb5);
                return;
            }
            Intrinsics.checkNotNullParameter(cb5, "cb");
            if (this.f298118b.getShortChain().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QRCodeLoadingComponent qRCodeLoadingComponent = null;
            if (!z16) {
                QRCodeLoadingComponent qRCodeLoadingComponent2 = QRDisplayTroopCardFragment.this.qrCode;
                if (qRCodeLoadingComponent2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                } else {
                    qRCodeLoadingComponent = qRCodeLoadingComponent2;
                }
                qRCodeLoadingComponent.g();
                return;
            }
            QRDisplayTroopCardFragment.this.curChain = this.f298118b.getShortChain();
            QRCodeLoadingComponent qRCodeLoadingComponent3 = QRDisplayTroopCardFragment.this.qrCode;
            if (qRCodeLoadingComponent3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                qRCodeLoadingComponent3 = null;
            }
            QRCodeLoadingComponent.setChain$default(qRCodeLoadingComponent3, QRDisplayTroopCardFragment.this.curChain, false, 2, null);
            QRDisplayTroopShareCard qRDisplayTroopShareCard = QRDisplayTroopCardFragment.this.shareCard;
            if (qRDisplayTroopShareCard == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                qRDisplayTroopShareCard = null;
            }
            QRCodeLoadingComponent qRCodeLoadingComponent4 = QRDisplayTroopCardFragment.this.qrCode;
            if (qRCodeLoadingComponent4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            } else {
                qRCodeLoadingComponent = qRCodeLoadingComponent4;
            }
            qRDisplayTroopShareCard.Q(qRCodeLoadingComponent, QRDisplayTroopCardFragment.this.curChain, this.f298118b);
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        @NotNull
        /* renamed from: c */
        public String getF94861a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return QRDisplayTroopCardFragment.this.troopUin;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardFragment$f", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class f implements zv3.c {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
            }
        }

        @Override // zv3.c
        public void B5(@NotNull zv3.a event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if ((event instanceof com.tencent.mobileqq.troop.addsource.c) && QRDisplayTroopCardFragment.this.sourceItem.getValue() != 0) {
                QRDisplayTroopCardFragment.this.Rh();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QRDisplayTroopCardFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.curChain = "";
        this.from = "1000";
        this.troopUin = "";
        this.sourceItem = new MutableLiveData<>();
        this.troopSourceDataObserver = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ai(boolean isVisible) {
        View view = null;
        if (isVisible) {
            View view2 = this.sourceDescContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sourceDescContainer");
                view2 = null;
            }
            view2.setVisibility(0);
            TextView textView = this.bottomTipsShort;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShort");
                textView = null;
            }
            textView.setVisibility(8);
            TextView textView2 = this.bottomTipsShortCannotSearch;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
            } else {
                view = textView2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.sourceDescContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceDescContainer");
        } else {
            view = view3;
        }
        view.setVisibility(8);
        xi();
    }

    private final void Bi() {
        QRVasThemeBgCompat qRVasThemeBgCompat = QRVasThemeBgCompat.f298153a;
        View view = this.qrCodeLayout;
        QRDisplayTroopShareCard qRDisplayTroopShareCard = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeLayout");
            view = null;
        }
        qRVasThemeBgCompat.c(view);
        TextView textView = this.bottomTipsShortCannotSearch;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
            textView = null;
        }
        qRVasThemeBgCompat.b(textView);
        QRDisplayTroopShareCard qRDisplayTroopShareCard2 = this.shareCard;
        if (qRDisplayTroopShareCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
        } else {
            qRDisplayTroopShareCard = qRDisplayTroopShareCard2;
        }
        qRDisplayTroopShareCard.w();
    }

    private final QRDisplayTroopSearchWay Qh() {
        FragmentActivity activity = getActivity();
        TroopInfo troopInfo = this.troopInfo;
        TroopInfoData troopInfoData = this.troopInfoData;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData = null;
        }
        QRDisplayTroopSearchWay qRDisplayTroopSearchWay = new QRDisplayTroopSearchWay(activity, troopInfo, troopInfoData);
        qRDisplayTroopSearchWay.k(new c(qRDisplayTroopSearchWay, this));
        return qRDisplayTroopSearchWay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh() {
        TroopInfoData troopInfoData = this.troopInfoData;
        TroopSourceHandler troopSourceHandler = null;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData = null;
        }
        if (!troopInfoData.bOwner) {
            return;
        }
        TroopSourceHandler troopSourceHandler2 = this.troopSourceHandler;
        if (troopSourceHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSourceHandler");
        } else {
            troopSourceHandler = troopSourceHandler2;
        }
        troopSourceHandler.k(new com.tencent.mobileqq.troop.addsource.b() { // from class: com.tencent.mobileqq.troop.qrcode.n
            @Override // com.tencent.mobileqq.troop.addsource.b
            public final void a(QunJoinUrlSvrPB$GetInfoRsp qunJoinUrlSvrPB$GetInfoRsp) {
                QRDisplayTroopCardFragment.Sh(QRDisplayTroopCardFragment.this, qunJoinUrlSvrPB$GetInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(QRDisplayTroopCardFragment this$0, QunJoinUrlSvrPB$GetInfoRsp qunJoinUrlSvrPB$GetInfoRsp) {
        boolean z16;
        String str;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        if (qunJoinUrlSvrPB$GetInfoRsp != null) {
            List<QunSourceSvrPB$SourceItem> list = qunJoinUrlSvrPB$GetInfoRsp.items.get();
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QunJoinUrlSvrPB$ButtonItem qunJoinUrlSvrPB$ButtonItem = qunJoinUrlSvrPB$GetInfoRsp.button.get();
                TroopSourceHandler troopSourceHandler = null;
                if (qunJoinUrlSvrPB$ButtonItem != null) {
                    this$0.Ai(true);
                    TextView textView = this$0.sourceEditTextView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sourceEditTextView");
                        textView = null;
                    }
                    textView.setText(qunJoinUrlSvrPB$ButtonItem.wording.get());
                    TextView textView2 = this$0.sourceDescTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sourceDescTextView");
                        textView2 = null;
                    }
                    textView2.setText(qunJoinUrlSvrPB$ButtonItem.tip.get());
                }
                String str2 = this$0.selectedSourceId;
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    str = this$0.selectedSourceId;
                    this$0.selectedSourceId = null;
                } else {
                    QunSourceSvrPB$SourceItem value = this$0.sourceItem.getValue();
                    if (value != null && (pBStringField = value.f342212id) != null) {
                        str = pBStringField.get();
                    } else {
                        str = null;
                    }
                }
                TroopSourceHandler troopSourceHandler2 = this$0.troopSourceHandler;
                if (troopSourceHandler2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopSourceHandler");
                } else {
                    troopSourceHandler = troopSourceHandler2;
                }
                QunSourceSvrPB$SourceItem f16 = troopSourceHandler.f(str);
                if (f16 != null) {
                    this$0.sourceItem.postValue(f16);
                    return;
                } else {
                    this$0.sourceItem.postValue(qunJoinUrlSvrPB$GetInfoRsp.items.get(0));
                    return;
                }
            }
        }
        QLog.i("QRDisplayTroopCardFragment", 1, "[getSourceList] resp = " + qunJoinUrlSvrPB$GetInfoRsp);
        this$0.Ai(false);
    }

    private final void Th(View rootView, String troopNick) {
        String str;
        View findViewById = rootView.findViewById(R.id.f645636k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qr_aigc_code_layout)");
        this.aigcCardLayout = findViewById;
        View findViewById2 = rootView.findViewById(R.id.sgp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.aigc_card_view)");
        this.aigcCardView = (CardView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.xzs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.iv_aigc_head)");
        this.aigcAvatar = (QQProAvatarView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f1059367c);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_aigc_nickName)");
        this.aigcNameText = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f1059467d);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.tv_aigc_uin)");
        this.aigcUinText = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.xzt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.iv_aigc_image)");
        this.aigcImage = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.t2u);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.back_to_colorful)");
        this.backToNormal = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.sgr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.aigc_entrance_wrapper)");
        this.aigcEntranceWrapper = (LinearLayout) findViewById8;
        TextView textView = null;
        if (QRDisplayTroopCardRepo.f298123a.i()) {
            TroopInfoData troopInfoData = this.troopInfoData;
            if (troopInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                troopInfoData = null;
            }
            if (troopInfoData.isOwnerOrAdim()) {
                LinearLayout linearLayout = this.aigcEntranceWrapper;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aigcEntranceWrapper");
                    linearLayout = null;
                }
                linearLayout.setVisibility(0);
            }
        }
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(this.troopUin)).g(200).a();
        TextView textView2 = this.aigcNameText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcNameText");
            str = troopNick;
            textView2 = null;
        } else {
            str = troopNick;
        }
        textView2.setText(str);
        TextView textView3 = this.aigcUinText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcUinText");
            textView3 = null;
        }
        textView3.setText("\u7fa4\u53f7: " + this.troopUin);
        QQProAvatarView qQProAvatarView = this.aigcAvatar;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcAvatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(4, this.troopUin, a16);
        TextView textView4 = this.aigcUinText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcUinText");
        } else {
            textView = textView4;
        }
        LongClickCopyAction.attachCopyAction(textView, HardCodeUtil.qqStr(R.string.aep), this.troopUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(QRDisplayTroopCardFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ii();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(QRDisplayTroopCardFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mi(view.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(QRDisplayTroopCardFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.li();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(QRDisplayTroopCardFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(QRDisplayTroopCardFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ji();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(QRDisplayTroopCardFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ki();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ci(Integer qrCodeStyle) {
        this.reportQRCodeStyle = qrCodeStyle;
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            View view = this.rootView;
            String str = this.from;
            TroopInfoData troopInfoData = this.troopInfoData;
            if (troopInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                troopInfoData = null;
            }
            String str2 = troopInfoData.troopUin;
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "troopInfoData.troopUin ?: \"\"");
            }
            TroopQRCodeDTReportHelper.e(qBaseActivity, view, str, str2, this.reportQRCodeStyle);
        }
    }

    private final void di() {
        ae aeVar = ae.f298175a;
        TroopInfoData troopInfoData = this.troopInfoData;
        QRCodeLoadingComponent qRCodeLoadingComponent = null;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData = null;
        }
        if (!aeVar.a(troopInfoData)) {
            TroopInfoData troopInfoData2 = this.troopInfoData;
            if (troopInfoData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                troopInfoData2 = null;
            }
            if (!aeVar.b(troopInfoData2)) {
                Rh();
                QRCodeLoadingComponent qRCodeLoadingComponent2 = this.qrCode;
                if (qRCodeLoadingComponent2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                    qRCodeLoadingComponent2 = null;
                }
                qRCodeLoadingComponent2.setGetChainProcess(new d());
                QRCodeLoadingComponent qRCodeLoadingComponent3 = this.qrCode;
                if (qRCodeLoadingComponent3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                    qRCodeLoadingComponent3 = null;
                }
                qRCodeLoadingComponent3.y();
                QRCodeLoadingComponent qRCodeLoadingComponent4 = this.qrCode;
                if (qRCodeLoadingComponent4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                    qRCodeLoadingComponent4 = null;
                }
                qRCodeLoadingComponent4.A();
                QRCodeLoadingComponent qRCodeLoadingComponent5 = this.qrCode;
                if (qRCodeLoadingComponent5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                } else {
                    qRCodeLoadingComponent = qRCodeLoadingComponent5;
                }
                MutableLiveData<Boolean> v3 = qRCodeLoadingComponent.v();
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment$initQRCode$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean it) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        QRDisplayTroopCardManager qRDisplayTroopCardManager = null;
                        QRDisplayTroopShareCard qRDisplayTroopShareCard = null;
                        if (!it.booleanValue()) {
                            QRDisplayTroopCardFragment.this.curChain = "";
                            QRDisplayTroopShareCard qRDisplayTroopShareCard2 = QRDisplayTroopCardFragment.this.shareCard;
                            if (qRDisplayTroopShareCard2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                                qRDisplayTroopShareCard2 = null;
                            }
                            QRCodeLoadingComponent qRCodeLoadingComponent6 = QRDisplayTroopCardFragment.this.qrCode;
                            if (qRCodeLoadingComponent6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                                qRCodeLoadingComponent6 = null;
                            }
                            QRDisplayTroopCardManager qRDisplayTroopCardManager2 = QRDisplayTroopCardFragment.this.viewModel;
                            if (qRDisplayTroopCardManager2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                qRDisplayTroopCardManager = qRDisplayTroopCardManager2;
                            }
                            qRDisplayTroopShareCard2.Q(qRCodeLoadingComponent6, "", qRDisplayTroopCardManager.P1().getValue());
                            return;
                        }
                        QRDisplayTroopCardFragment qRDisplayTroopCardFragment = QRDisplayTroopCardFragment.this;
                        QRCodeLoadingComponent qRCodeLoadingComponent7 = qRDisplayTroopCardFragment.qrCode;
                        if (qRCodeLoadingComponent7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                            qRCodeLoadingComponent7 = null;
                        }
                        qRDisplayTroopCardFragment.curChain = qRCodeLoadingComponent7.getCurChain();
                        QRCodeLoadingComponent qRCodeLoadingComponent8 = QRDisplayTroopCardFragment.this.qrCode;
                        if (qRCodeLoadingComponent8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                            qRCodeLoadingComponent8 = null;
                        }
                        qRCodeLoadingComponent8.A();
                        QRDisplayTroopShareCard qRDisplayTroopShareCard3 = QRDisplayTroopCardFragment.this.shareCard;
                        if (qRDisplayTroopShareCard3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                            qRDisplayTroopShareCard3 = null;
                        }
                        QRCodeLoadingComponent qRCodeLoadingComponent9 = QRDisplayTroopCardFragment.this.qrCode;
                        if (qRCodeLoadingComponent9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                            qRCodeLoadingComponent9 = null;
                        }
                        String str = QRDisplayTroopCardFragment.this.curChain;
                        QRDisplayTroopCardManager qRDisplayTroopCardManager3 = QRDisplayTroopCardFragment.this.viewModel;
                        if (qRDisplayTroopCardManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            qRDisplayTroopCardManager3 = null;
                        }
                        qRDisplayTroopShareCard3.Q(qRCodeLoadingComponent9, str, qRDisplayTroopCardManager3.P1().getValue());
                        QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem = (QunSourceSvrPB$SourceItem) QRDisplayTroopCardFragment.this.sourceItem.getValue();
                        if (qunSourceSvrPB$SourceItem != null) {
                            QRDisplayTroopShareCard qRDisplayTroopShareCard4 = QRDisplayTroopCardFragment.this.shareCard;
                            if (qRDisplayTroopShareCard4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                            } else {
                                qRDisplayTroopShareCard = qRDisplayTroopShareCard4;
                            }
                            qRDisplayTroopShareCard.T(qunSourceSvrPB$SourceItem);
                        }
                    }
                };
                v3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.qrcode.m
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QRDisplayTroopCardFragment.ei(Function1.this, obj);
                    }
                });
                return;
            }
        }
        QRCodeLoadingComponent qRCodeLoadingComponent6 = this.qrCode;
        if (qRCodeLoadingComponent6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            qRCodeLoadingComponent6 = null;
        }
        QRCodeLoadingComponent.setChain$default(qRCodeLoadingComponent6, "\u65e0\u6548\u4e8c\u7ef4\u7801", false, 2, null);
        QRCodeLoadingComponent qRCodeLoadingComponent7 = this.qrCode;
        if (qRCodeLoadingComponent7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            qRCodeLoadingComponent7 = null;
        }
        qRCodeLoadingComponent7.z();
        QRCodeLoadingComponent qRCodeLoadingComponent8 = this.qrCode;
        if (qRCodeLoadingComponent8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
        } else {
            qRCodeLoadingComponent = qRCodeLoadingComponent8;
        }
        qRCodeLoadingComponent.setAlpha(0.05f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"SetTextI18n"})
    private final void fi(String troopNick, final String troopUin) {
        boolean z16;
        boolean z17 = true;
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(troopUin)).g(200).a();
        SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(troopNick, 16);
        TextView textView = this.troopNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameTv");
            textView = null;
        }
        textView.setText(spannableStringFromColorNickText);
        TextView textView2 = this.troopUinTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView2 = null;
        }
        textView2.setText("\u7fa4\u53f7: " + troopUin);
        QQProAvatarView qQProAvatarView = this.troopAvatar;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(4, troopUin, a16);
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null && !troopInfo.isNewTroop) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (troopInfo == null || troopInfo.isQidianPrivateTroop()) {
                z17 = false;
            }
            if (z17) {
                String qqStr = HardCodeUtil.qqStr(R.string.aep);
                TextView textView3 = this.troopNameTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopNameTv");
                    textView3 = null;
                }
                LongClickCopyAction attachCopyAction = LongClickCopyAction.attachCopyAction(textView3, qqStr, troopNick);
                TextView textView4 = this.troopNameTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopNameTv");
                    textView4 = null;
                }
                attachCopyAction.setCopyListener(new LongClickCopyAction.ToastCopyListener(textView4.getContext(), R.string.zov));
            }
        }
        TextView textView5 = this.troopUinTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView5 = null;
        }
        LongClickCopyAction attachCopyAction2 = LongClickCopyAction.attachCopyAction(textView5, HardCodeUtil.qqStr(R.string.aep), troopUin);
        TextView textView6 = this.troopUinTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView6 = null;
        }
        attachCopyAction2.setCopyListener(new LongClickCopyAction.ToastCopyListener(textView6.getContext(), R.string.zow));
        View view = this.copyTroopUinBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("copyTroopUinBtn");
            view = null;
        }
        TriggerRunnerKt.c(view, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QRDisplayTroopCardFragment.gi(QRDisplayTroopCardFragment.this, troopUin, view2);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(QRDisplayTroopCardFragment this$0, String troopUin, View view) {
        Object obj;
        ClipboardManager clipboardManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        FragmentActivity activity = this$0.getActivity();
        View view2 = null;
        if (activity != null) {
            obj = activity.getSystemService("clipboard");
        } else {
            obj = null;
        }
        if (obj instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) obj;
        } else {
            clipboardManager = null;
        }
        ClipData newPlainText = ClipData.newPlainText("troop_uin", troopUin);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
        }
        View view3 = this$0.copyTroopUinBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("copyTroopUinBtn");
        } else {
            view2 = view3;
        }
        QQToast.makeText(view2.getContext(), 2, R.string.zow, 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void hi(View rootView) {
        View findViewById = rootView.findViewById(R.id.f1034660o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026de_source_desc_container)");
        this.sourceDescContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f30500oi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_qrcode_card_source_desc)");
        this.sourceDescTextView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f30510oj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026de_card_source_edit_tips)");
        this.sourceEditTextView = (TextView) findViewById3;
    }

    private final void ii() {
        PBStringField pBStringField;
        QLog.i("QRDisplayTroopCardFragment", 1, "[onClickAIGCEntrance] showSourceSelector() activity = " + getQBaseActivity());
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            QRDisplayTroopCardManager qRDisplayTroopCardManager = this.viewModel;
            String str = null;
            if (qRDisplayTroopCardManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qRDisplayTroopCardManager = null;
            }
            String str2 = this.troopUin;
            QunSourceSvrPB$SourceItem value = this.sourceItem.getValue();
            if (value != null && (pBStringField = value.f342212id) != null) {
                str = pBStringField.get();
            }
            qRDisplayTroopCardManager.R1(qBaseActivity, str2, str);
        }
    }

    private final void initData() {
        Object obj;
        TroopInfoData troopInfoData;
        String str;
        String str2;
        Bundle arguments = getArguments();
        TroopInfoData troopInfoData2 = null;
        if (arguments != null) {
            obj = arguments.get("troopInfoData");
        } else {
            obj = null;
        }
        if (obj instanceof TroopInfoData) {
            troopInfoData = (TroopInfoData) obj;
        } else {
            troopInfoData = null;
        }
        boolean z16 = true;
        if (troopInfoData == null) {
            QLog.e("QRDisplayTroopCardFragment", 1, "initData troopInfoData is null");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.troopInfoData = troopInfoData;
        String str3 = "";
        ITroopInfoService iTroopInfoService = (ITroopInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        TroopInfoData troopInfoData3 = this.troopInfoData;
        if (troopInfoData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData3 = null;
        }
        this.troopInfo = iTroopInfoService.getTroopInfoFromCache(troopInfoData3.troopUin);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("my_qrcode_pg_source");
        } else {
            str = null;
        }
        if (str == null) {
            str = "1000";
        }
        this.from = str;
        TroopInfoData troopInfoData4 = this.troopInfoData;
        if (troopInfoData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData4 = null;
        }
        String str4 = troopInfoData4.troopUin;
        if (str4 == null) {
            str4 = "";
        }
        this.troopSourceHandler = new TroopSourceHandler(str4);
        TroopInfoData troopInfoData5 = this.troopInfoData;
        if (troopInfoData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData5 = null;
        }
        String str5 = troopInfoData5.troopUin;
        if (str5 != null) {
            str3 = str5;
        }
        this.chainProcessor = new ad(str3);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str2 = arguments3.getString("market_channel_source_item");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            TroopSourceHandler troopSourceHandler = this.troopSourceHandler;
            if (troopSourceHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopSourceHandler");
                troopSourceHandler = null;
            }
            this.selectedSourceId = troopSourceHandler.j(str2).f342212id.get();
        }
        ViewModel viewModel = getViewModel(QRDisplayTroopCardManager.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QRDisplayTr\u2026pCardManager::class.java)");
        this.viewModel = (QRDisplayTroopCardManager) viewModel;
        TroopInfoData troopInfoData6 = this.troopInfoData;
        if (troopInfoData6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData6 = null;
        }
        String str6 = troopInfoData6.troopUin;
        TroopInfoData troopInfoData7 = this.troopInfoData;
        if (troopInfoData7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData7 = null;
        }
        String str7 = troopInfoData7.troopName;
        TroopInfoData troopInfoData8 = this.troopInfoData;
        if (troopInfoData8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData8 = null;
        }
        boolean isOwnerOrAdim = troopInfoData8.isOwnerOrAdim();
        TroopInfoData troopInfoData9 = this.troopInfoData;
        if (troopInfoData9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData9 = null;
        }
        boolean z17 = troopInfoData9.isNewTroop;
        ae aeVar = ae.f298175a;
        TroopInfoData troopInfoData10 = this.troopInfoData;
        if (troopInfoData10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData10 = null;
        }
        boolean a16 = aeVar.a(troopInfoData10);
        TroopInfoData troopInfoData11 = this.troopInfoData;
        if (troopInfoData11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
        } else {
            troopInfoData2 = troopInfoData11;
        }
        QLog.i("QRDisplayTroopCardFragment", 1, "initData uin=" + str6 + " name=" + str7 + " isOwnerOrAdmin=" + isOwnerOrAdim + " isNewTroop=" + z17 + " isNotAllowAnybodyJoin=" + a16 + " isNotAllowMemberInviteToJoin=" + aeVar.b(troopInfoData2));
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null || !troopInfo.isNeedInterceptOnBlockTroop()) {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.troop.utils.ab.c(getContext());
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private final void initListener() {
        View view;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        TextView textView2;
        View view2 = this.backBtn;
        QRDisplayTroopCardManager qRDisplayTroopCardManager = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            view = null;
        } else {
            view = view2;
        }
        TriggerRunnerKt.c(view, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QRDisplayTroopCardFragment.Zh(QRDisplayTroopCardFragment.this, view3);
            }
        }, 1, null);
        LinearLayout linearLayout3 = this.saveBtnWrapper;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveBtnWrapper");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QRDisplayTroopCardFragment.ai(QRDisplayTroopCardFragment.this, view3);
            }
        });
        LinearLayout linearLayout4 = this.shareBtnWrapper;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareBtnWrapper");
            linearLayout = null;
        } else {
            linearLayout = linearLayout4;
        }
        TriggerRunnerKt.c(linearLayout, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QRDisplayTroopCardFragment.bi(QRDisplayTroopCardFragment.this, view3);
            }
        }, 1, null);
        LinearLayout linearLayout5 = this.aigcEntranceWrapper;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcEntranceWrapper");
            linearLayout2 = null;
        } else {
            linearLayout2 = linearLayout5;
        }
        TriggerRunnerKt.c(linearLayout2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QRDisplayTroopCardFragment.Uh(QRDisplayTroopCardFragment.this, view3);
            }
        }, 1, null);
        TextView textView3 = this.sourceEditTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceEditTextView");
            textView = null;
        } else {
            textView = textView3;
        }
        TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QRDisplayTroopCardFragment.Vh(QRDisplayTroopCardFragment.this, view3);
            }
        }, 1, null);
        TextView textView4 = this.backToNormal;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backToNormal");
            textView2 = null;
        } else {
            textView2 = textView4;
        }
        TriggerRunnerKt.c(textView2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.qrcode.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QRDisplayTroopCardFragment.Wh(QRDisplayTroopCardFragment.this, view3);
            }
        }, 1, null);
        MutableLiveData<QunSourceSvrPB$SourceItem> mutableLiveData = this.sourceItem;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<QunSourceSvrPB$SourceItem, Unit> function1 = new Function1<QunSourceSvrPB$SourceItem, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment$initListener$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
                invoke2(qunSourceSvrPB$SourceItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
                TextView textView5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) qunSourceSvrPB$SourceItem);
                    return;
                }
                QLog.i("QRDisplayTroopCardFragment", 1, "[sourceItem.observe] it = " + qunSourceSvrPB$SourceItem);
                boolean z16 = false;
                QRDisplayTroopCardFragment.this.Ai(qunSourceSvrPB$SourceItem != null);
                if (qunSourceSvrPB$SourceItem != null) {
                    final QRDisplayTroopCardFragment qRDisplayTroopCardFragment = QRDisplayTroopCardFragment.this;
                    if (qunSourceSvrPB$SourceItem.is_use_custom_qr_code.get()) {
                        String str = qunSourceSvrPB$SourceItem.custom_qr_code_url.get();
                        if (!(str == null || str.length() == 0)) {
                            z16 = true;
                        }
                    }
                    qRDisplayTroopCardFragment.yi(z16);
                    QRDisplayTroopCardManager qRDisplayTroopCardManager2 = qRDisplayTroopCardFragment.viewModel;
                    QRDisplayTroopCardManager qRDisplayTroopCardManager3 = null;
                    if (qRDisplayTroopCardManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        qRDisplayTroopCardManager2 = null;
                    }
                    qRDisplayTroopCardManager2.U1(true);
                    textView5 = qRDisplayTroopCardFragment.sourceDescTextView;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sourceDescTextView");
                        textView5 = null;
                    }
                    PBStringField pBStringField = qunSourceSvrPB$SourceItem.desc;
                    textView5.setText(pBStringField != null ? pBStringField.get() : null);
                    PBStringField pBStringField2 = qunSourceSvrPB$SourceItem.url;
                    String str2 = pBStringField2 != null ? pBStringField2.get() : null;
                    if (str2 == null) {
                        str2 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str2, "it.url?.get() ?: \"\"");
                    }
                    qRDisplayTroopCardFragment.curChain = str2;
                    QRDisplayTroopCardManager qRDisplayTroopCardManager4 = qRDisplayTroopCardFragment.viewModel;
                    if (qRDisplayTroopCardManager4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        qRDisplayTroopCardManager3 = qRDisplayTroopCardManager4;
                    }
                    qRDisplayTroopCardManager3.M1(qRDisplayTroopCardFragment.troopUin, qunSourceSvrPB$SourceItem, new Function1<com.tencent.biz.qrcode.mgr.d, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment$initListener$7$1$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.biz.qrcode.mgr.d dVar) {
                            invoke2(dVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull com.tencent.biz.qrcode.mgr.d qrCodeData) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) qrCodeData);
                            } else {
                                Intrinsics.checkNotNullParameter(qrCodeData, "qrCodeData");
                                QRDisplayTroopCardFragment.this.ni(qrCodeData);
                            }
                        }
                    });
                }
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.qrcode.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayTroopCardFragment.Xh(Function1.this, obj);
            }
        });
        QRDisplayTroopCardManager qRDisplayTroopCardManager2 = this.viewModel;
        if (qRDisplayTroopCardManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            qRDisplayTroopCardManager = qRDisplayTroopCardManager2;
        }
        MutableLiveData<com.tencent.biz.qrcode.mgr.d> P1 = qRDisplayTroopCardManager.P1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<com.tencent.biz.qrcode.mgr.d, Unit> function12 = new Function1<com.tencent.biz.qrcode.mgr.d, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment$initListener$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.biz.qrcode.mgr.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.biz.qrcode.mgr.d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                    return;
                }
                QLog.i("QRDisplayTroopCardFragment", 1, "viewModel.currentQRCodeData, qrCodeData = " + dVar);
                if (dVar != null) {
                    QRDisplayTroopCardFragment qRDisplayTroopCardFragment = QRDisplayTroopCardFragment.this;
                    QRDisplayTroopCardManager qRDisplayTroopCardManager3 = qRDisplayTroopCardFragment.viewModel;
                    if (qRDisplayTroopCardManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        qRDisplayTroopCardManager3 = null;
                    }
                    qRDisplayTroopCardFragment.yi(qRDisplayTroopCardManager3.N1(dVar));
                    qRDisplayTroopCardFragment.ni(dVar);
                }
            }
        };
        P1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.qrcode.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayTroopCardFragment.Yh(Function1.this, obj);
            }
        });
    }

    private final void initReport(View rootView) {
        LinearLayout linearLayout = this.shareBtnWrapper;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareBtnWrapper");
            linearLayout = null;
        }
        TroopQRCodeDTReportHelper.g(linearLayout);
        LinearLayout linearLayout3 = this.saveBtnWrapper;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveBtnWrapper");
            linearLayout3 = null;
        }
        TroopQRCodeDTReportHelper.f(linearLayout3);
        LinearLayout linearLayout4 = this.aigcEntranceWrapper;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcEntranceWrapper");
        } else {
            linearLayout2 = linearLayout4;
        }
        TroopQRCodeDTReportHelper.h(linearLayout2);
    }

    private final void initView(View view) {
        this.rootView = view;
        View findViewById = view.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.back_btn)");
        this.backBtn = findViewById;
        View findViewById2 = view.findViewById(R.id.f5q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.name_tv)");
        this.troopNameTv = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.kh6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.uin_tv)");
        this.troopUinTv = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.u9p);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.copy_troop_uin_btn)");
        this.copyTroopUinBtn = findViewById4;
        View findViewById5 = view.findViewById(R.id.a38);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.avatar_iv)");
        this.troopAvatar = (QQProAvatarView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f6472370);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.qr_code_mask)");
        this.maskLayer = findViewById6;
        View findViewById7 = view.findViewById(R.id.yxz);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.mask_tip)");
        this.maskTipsTv = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f111986mp);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.tv_tips_short)");
        this.bottomTipsShort = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f1064868u);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.tv_cannot_search_tips)");
        this.bottomTipsShortCannotSearch = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.tb6);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.bottom_tips_layout)");
        this.bottomTipsLayout = findViewById10;
        View findViewById11 = view.findViewById(R.id.m38);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.qr_code_layout)");
        this.qrCodeLayout = findViewById11;
        View findViewById12 = view.findViewById(R.id.h0d);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.qr_code)");
        this.qrCode = (QRCodeLoadingComponent) findViewById12;
        View findViewById13 = view.findViewById(R.id.f793649k);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.save_btn_wrapper)");
        this.saveBtnWrapper = (LinearLayout) findViewById13;
        View findViewById14 = view.findViewById(R.id.f84244lq);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.share_btn_wrapper)");
        this.shareBtnWrapper = (LinearLayout) findViewById14;
        View findViewById15 = view.findViewById(R.id.f84364m2);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.share_layout)");
        this.shareLayout = findViewById15;
        TroopInfoData troopInfoData = this.troopInfoData;
        TroopInfoData troopInfoData2 = null;
        if (troopInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData = null;
        }
        String d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.a.d(troopInfoData);
        TroopInfoData troopInfoData3 = this.troopInfoData;
        if (troopInfoData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData3 = null;
        }
        String str = troopInfoData3.troopUin;
        if (str == null) {
            str = "";
        }
        this.troopUin = str;
        QRDisplayTroopShareCard qRDisplayTroopShareCard = new QRDisplayTroopShareCard();
        View view2 = this.shareLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            view2 = null;
        }
        TroopInfoData troopInfoData4 = this.troopInfoData;
        if (troopInfoData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
        } else {
            troopInfoData2 = troopInfoData4;
        }
        qRDisplayTroopShareCard.r(view2, troopInfoData2);
        this.shareCard = qRDisplayTroopShareCard;
        Th(view, d16);
        fi(d16, this.troopUin);
        di();
        xi();
        hi(view);
        Bi();
        initListener();
    }

    private final void ji() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.e("QRDisplayTroopCardFragment", 1, "onClickSave activity is null");
            com.tencent.biz.qrcode.util.h.T(1, R.string.f224046hv);
            return;
        }
        QRDisplayTroopShareCard qRDisplayTroopShareCard = this.shareCard;
        TroopInfoData troopInfoData = null;
        if (qRDisplayTroopShareCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
            qRDisplayTroopShareCard = null;
        }
        QRDisplayTroopCardManager qRDisplayTroopCardManager = this.viewModel;
        if (qRDisplayTroopCardManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qRDisplayTroopCardManager = null;
        }
        qRDisplayTroopShareCard.P(qRDisplayTroopCardManager.P1().getValue());
        QRDisplayTroopShareCard qRDisplayTroopShareCard2 = this.shareCard;
        if (qRDisplayTroopShareCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
            qRDisplayTroopShareCard2 = null;
        }
        qRDisplayTroopShareCard2.C(qBaseActivity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            com.tencent.mobileqq.statistics.q d16 = new com.tencent.mobileqq.statistics.q(peekAppRuntime).i("P_CliOper").a("Grp_set").f("Grp_data").d("qr_save");
            String[] strArr = new String[2];
            TroopInfoData troopInfoData2 = this.troopInfoData;
            if (troopInfoData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                troopInfoData2 = null;
            }
            String str = troopInfoData2.troopUin;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin ?: \"\"");
            }
            strArr[0] = str;
            ae aeVar = ae.f298175a;
            TroopInfoData troopInfoData3 = this.troopInfoData;
            if (troopInfoData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            } else {
                troopInfoData = troopInfoData3;
            }
            strArr[1] = String.valueOf(aeVar.c(troopInfoData));
            d16.b(strArr).g();
        }
    }

    private final void ki() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.e("QRDisplayTroopCardFragment", 1, "onClickShare activity is null");
            com.tencent.biz.qrcode.util.h.T(1, R.string.f224046hv);
            return;
        }
        QRDisplayTroopShareCard qRDisplayTroopShareCard = this.shareCard;
        QRDisplayTroopShareCard qRDisplayTroopShareCard2 = null;
        if (qRDisplayTroopShareCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
            qRDisplayTroopShareCard = null;
        }
        QRDisplayTroopCardManager qRDisplayTroopCardManager = this.viewModel;
        if (qRDisplayTroopCardManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qRDisplayTroopCardManager = null;
        }
        qRDisplayTroopShareCard.P(qRDisplayTroopCardManager.P1().getValue());
        QRDisplayTroopShareCard qRDisplayTroopShareCard3 = this.shareCard;
        if (qRDisplayTroopShareCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
        } else {
            qRDisplayTroopShareCard2 = qRDisplayTroopShareCard3;
        }
        qRDisplayTroopShareCard2.H(qBaseActivity);
    }

    private final void li() {
        String str;
        PBStringField pBStringField;
        QRDisplayTroopCardRepo qRDisplayTroopCardRepo = QRDisplayTroopCardRepo.f298123a;
        String str2 = this.troopUin;
        QunSourceSvrPB$SourceItem value = this.sourceItem.getValue();
        if (value != null && (pBStringField = value.f342212id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        qRDisplayTroopCardRepo.q(str2, str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment$onclickBackToNormal$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                QLog.i("QRDisplayTroopCardFragment", 1, "[onclickBackToNormal] isSuccess = " + z16);
                if (z16) {
                    QRDisplayTroopCardManager qRDisplayTroopCardManager = QRDisplayTroopCardFragment.this.viewModel;
                    if (qRDisplayTroopCardManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        qRDisplayTroopCardManager = null;
                    }
                    qRDisplayTroopCardManager.S1(QRDisplayTroopCardFragment.this.troopUin);
                    QRDisplayTroopCardFragment.this.Rh();
                }
            }
        });
    }

    private final void mi(Context context) {
        QLog.i("QRDisplayTroopCardFragment", 1, "[onclickEditSource] go to edit");
        if (context == null) {
            QLog.i("QRDisplayTroopCardFragment", 1, "[onclickEditSource] context = null");
            return;
        }
        TroopSourceHandler troopSourceHandler = this.troopSourceHandler;
        if (troopSourceHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSourceHandler");
            troopSourceHandler = null;
        }
        if (troopSourceHandler.i()) {
            vi(context);
        } else {
            TroopSourceHandler troopSourceHandler2 = this.troopSourceHandler;
            if (troopSourceHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopSourceHandler");
                troopSourceHandler2 = null;
            }
            troopSourceHandler2.h(context);
        }
        TextView textView = this.sourceEditTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceEditTextView");
            textView = null;
        }
        VideoReport.reportEvent("clck", textView, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni(final com.tencent.biz.qrcode.mgr.d qrCodeData) {
        QLog.i("QRDisplayTroopCardFragment", 1, "\u3010refreshCardType\u3011 qrCodeData = " + qrCodeData);
        try {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.e
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayTroopCardFragment.oi(QRDisplayTroopCardFragment.this, qrCodeData);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QRDisplayTroopCardFragment", 1, "[refreshCardType] qrCodeData = " + qrCodeData + ", exception = " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(QRDisplayTroopCardFragment this$0, com.tencent.biz.qrcode.mgr.d qrCodeData) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qrCodeData, "$qrCodeData");
        QRDisplayTroopCardManager qRDisplayTroopCardManager = this$0.viewModel;
        QRCodeLoadingComponent qRCodeLoadingComponent = null;
        if (qRDisplayTroopCardManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qRDisplayTroopCardManager = null;
        }
        if (qRDisplayTroopCardManager.N1(qrCodeData)) {
            Bitmap bitmap = qrCodeData.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
            if (bitmap != null) {
                ImageView imageView = this$0.aigcImage;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aigcImage");
                    imageView = null;
                }
                imageView.setImageBitmap(bitmap);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ImageView imageView2 = this$0.aigcImage;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aigcImage");
                    imageView2 = null;
                }
                imageView2.setImageDrawable(null);
            }
            QRDisplayTroopShareCard qRDisplayTroopShareCard = this$0.shareCard;
            if (qRDisplayTroopShareCard == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                qRDisplayTroopShareCard = null;
            }
            QRCodeLoadingComponent qRCodeLoadingComponent2 = this$0.qrCode;
            if (qRCodeLoadingComponent2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            } else {
                qRCodeLoadingComponent = qRCodeLoadingComponent2;
            }
            qRDisplayTroopShareCard.Q(qRCodeLoadingComponent, this$0.curChain, qrCodeData);
        } else {
            QRCodeLoadingComponent qRCodeLoadingComponent3 = this$0.qrCode;
            if (qRCodeLoadingComponent3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                qRCodeLoadingComponent3 = null;
            }
            qRCodeLoadingComponent3.setGetChainProcess(new e(qrCodeData));
            QRCodeLoadingComponent qRCodeLoadingComponent4 = this$0.qrCode;
            if (qRCodeLoadingComponent4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                qRCodeLoadingComponent4 = null;
            }
            qRCodeLoadingComponent4.y();
            QRCodeLoadingComponent qRCodeLoadingComponent5 = this$0.qrCode;
            if (qRCodeLoadingComponent5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            } else {
                qRCodeLoadingComponent = qRCodeLoadingComponent5;
            }
            qRCodeLoadingComponent.A();
            this$0.Bi();
        }
        if (this$0.reportQRCodeStyle == null) {
            this$0.ci(Integer.valueOf(qrCodeData.getStyle()));
        }
    }

    private final void pi() {
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.mobileqq.troop.addsource.c.class, this.troopSourceDataObserver);
    }

    private final void qi(boolean visible) {
        LinearLayout linearLayout = null;
        if (visible) {
            LinearLayout linearLayout2 = this.shareBtnWrapper;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtnWrapper");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = this.saveBtnWrapper;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveBtnWrapper");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(0);
            if (QRDisplayTroopCardRepo.f298123a.i()) {
                TroopInfoData troopInfoData = this.troopInfoData;
                if (troopInfoData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                    troopInfoData = null;
                }
                if (troopInfoData.isOwnerOrAdim()) {
                    LinearLayout linearLayout4 = this.aigcEntranceWrapper;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aigcEntranceWrapper");
                    } else {
                        linearLayout = linearLayout4;
                    }
                    linearLayout.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        LinearLayout linearLayout5 = this.shareBtnWrapper;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareBtnWrapper");
            linearLayout5 = null;
        }
        linearLayout5.setVisibility(8);
        LinearLayout linearLayout6 = this.saveBtnWrapper;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveBtnWrapper");
            linearLayout6 = null;
        }
        linearLayout6.setVisibility(8);
        LinearLayout linearLayout7 = this.aigcEntranceWrapper;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcEntranceWrapper");
        } else {
            linearLayout = linearLayout7;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v26, types: [android.view.View] */
    private final void ri(BottomTipsVisibility visibility, SpannableStringBuilder cannotSearchTipsLayoutStr) {
        int i3 = b.f298113a[visibility.ordinal()];
        TextView textView = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ?? r85 = this.bottomTipsLayout;
                    if (r85 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomTipsLayout");
                    } else {
                        textView = r85;
                    }
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
            View view = this.bottomTipsLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsLayout");
                view = null;
            }
            view.setVisibility(0);
            TextView textView2 = this.bottomTipsShortCannotSearch;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.bottomTipsShortCannotSearch;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
                textView3 = null;
            }
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView4 = this.bottomTipsShortCannotSearch;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
                textView4 = null;
            }
            textView4.setHighlightColor(0);
            TextView textView5 = this.bottomTipsShort;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShort");
                textView5 = null;
            }
            textView5.setVisibility(8);
            if (cannotSearchTipsLayoutStr != null) {
                TextView textView6 = this.bottomTipsShortCannotSearch;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
                } else {
                    textView = textView6;
                }
                textView.setText(cannotSearchTipsLayoutStr);
                return;
            }
            return;
        }
        View view2 = this.bottomTipsLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTipsLayout");
            view2 = null;
        }
        view2.setVisibility(0);
        TextView textView7 = this.bottomTipsShortCannotSearch;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShortCannotSearch");
            textView7 = null;
        }
        textView7.setVisibility(8);
        TextView textView8 = this.bottomTipsShort;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomTipsShort");
        } else {
            textView = textView8;
        }
        textView.setVisibility(0);
    }

    private final void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), qBaseActivity.getWindow());
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDarkMode(QQTheme.isNowThemeIsNight());
        }
    }

    static /* synthetic */ void si(QRDisplayTroopCardFragment qRDisplayTroopCardFragment, BottomTipsVisibility bottomTipsVisibility, SpannableStringBuilder spannableStringBuilder, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            spannableStringBuilder = null;
        }
        qRDisplayTroopCardFragment.ri(bottomTipsVisibility, spannableStringBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    private final void ti(boolean visible, Integer maskTipsResId) {
        TextView textView = null;
        if (visible) {
            View view = this.maskLayer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskLayer");
                view = null;
            }
            view.setVisibility(0);
            if (maskTipsResId != null) {
                int intValue = maskTipsResId.intValue();
                TextView textView2 = this.maskTipsTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("maskTipsTv");
                } else {
                    textView = textView2;
                }
                textView.setText(intValue);
                return;
            }
            return;
        }
        ?? r36 = this.maskLayer;
        if (r36 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("maskLayer");
        } else {
            textView = r36;
        }
        textView.setVisibility(8);
    }

    static /* synthetic */ void ui(QRDisplayTroopCardFragment qRDisplayTroopCardFragment, boolean z16, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        qRDisplayTroopCardFragment.ti(z16, num);
    }

    private final void vi(Context context) {
        if (this.sourceItem.getValue() == null) {
            return;
        }
        TroopSourceHandler troopSourceHandler = this.troopSourceHandler;
        if (troopSourceHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSourceHandler");
            troopSourceHandler = null;
        }
        troopSourceHandler.l(context, this.sourceItem.getValue(), new com.tencent.mobileqq.troop.addsource.d() { // from class: com.tencent.mobileqq.troop.qrcode.d
            @Override // com.tencent.mobileqq.troop.addsource.d
            public final void a(QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
                QRDisplayTroopCardFragment.wi(QRDisplayTroopCardFragment.this, qunSourceSvrPB$SourceItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(QRDisplayTroopCardFragment this$0, QunSourceSvrPB$SourceItem qunSourceSvrPB$SourceItem) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sourceItem.postValue(qunSourceSvrPB$SourceItem);
        TextView textView = this$0.sourceDescTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceDescTextView");
            textView = null;
        }
        PBStringField pBStringField = qunSourceSvrPB$SourceItem.desc;
        if (pBStringField == null || (str = pBStringField.get()) == null) {
            str = "";
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void xi() {
        byte b16;
        byte b17;
        ae aeVar;
        TroopInfoData troopInfoData;
        BottomTipsVisibility bottomTipsVisibility;
        QRDisplayTroopSearchWay qRDisplayTroopSearchWay;
        BottomTipsVisibility bottomTipsVisibility2;
        QRDisplayTroopSearchWay qRDisplayTroopSearchWay2;
        byte b18;
        TroopInfoData troopInfoData2 = this.troopInfoData;
        String str = null;
        r2 = null;
        SpannableStringBuilder spannableStringBuilder = null;
        r2 = null;
        SpannableStringBuilder spannableStringBuilder2 = null;
        SpannableStringBuilder spannableStringBuilder3 = null;
        if (troopInfoData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
            troopInfoData2 = null;
        }
        boolean isOwnerOrAdim = troopInfoData2.isOwnerOrAdim();
        if (isOwnerOrAdim && this.troopSearchWay == null) {
            this.troopSearchWay = Qh();
        }
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null && troopInfo.mCanSearchByTroopUin) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 == false) {
            if (troopInfo != null && troopInfo.mCanSearchByKeywords) {
                b18 = true;
            } else {
                b18 = false;
            }
            if (b18 == false) {
                b17 = true;
                aeVar = ae.f298175a;
                troopInfoData = this.troopInfoData;
                if (troopInfoData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                    troopInfoData = null;
                }
                if (!aeVar.a(troopInfoData)) {
                    ti(true, Integer.valueOf(R.string.f1791838o));
                    if (b17 != false && isOwnerOrAdim) {
                        bottomTipsVisibility2 = BottomTipsVisibility.CANNOT_SEARCH_TIPS_VISIBLE;
                    } else {
                        bottomTipsVisibility2 = BottomTipsVisibility.ALL_GONE;
                    }
                    if (isOwnerOrAdim && (qRDisplayTroopSearchWay2 = this.troopSearchWay) != null) {
                        spannableStringBuilder = qRDisplayTroopSearchWay2.f();
                    }
                    ri(bottomTipsVisibility2, spannableStringBuilder);
                    qi(false);
                    return;
                }
                TroopInfoData troopInfoData3 = this.troopInfoData;
                if (troopInfoData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                    troopInfoData3 = null;
                }
                if (aeVar.b(troopInfoData3)) {
                    ti(true, Integer.valueOf(R.string.f1791938p));
                    if (isOwnerOrAdim) {
                        bottomTipsVisibility = BottomTipsVisibility.CANNOT_SEARCH_TIPS_VISIBLE;
                    } else {
                        bottomTipsVisibility = BottomTipsVisibility.ALL_GONE;
                    }
                    if (isOwnerOrAdim && (qRDisplayTroopSearchWay = this.troopSearchWay) != null) {
                        spannableStringBuilder2 = qRDisplayTroopSearchWay.f();
                    }
                    ri(bottomTipsVisibility, spannableStringBuilder2);
                    qi(false);
                    return;
                }
                TroopInfo troopInfo2 = this.troopInfo;
                if (troopInfo2 != null && !troopInfo2.mCanSearchByTroopUin && !troopInfo2.mCanSearchByKeywords) {
                    ui(this, false, null, 2, null);
                    BottomTipsVisibility bottomTipsVisibility3 = BottomTipsVisibility.CANNOT_SEARCH_TIPS_VISIBLE;
                    if (isOwnerOrAdim) {
                        QRDisplayTroopSearchWay qRDisplayTroopSearchWay3 = this.troopSearchWay;
                        if (qRDisplayTroopSearchWay3 != null) {
                            spannableStringBuilder3 = qRDisplayTroopSearchWay3.f();
                        }
                    } else {
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            str = activity.getString(R.string.f217045zy);
                        }
                        spannableStringBuilder3 = new SpannableStringBuilder(str);
                    }
                    ri(bottomTipsVisibility3, spannableStringBuilder3);
                    qi(true);
                    return;
                }
                ui(this, false, null, 2, null);
                si(this, BottomTipsVisibility.SCAN_TIPS_VISIBLE, null, 2, null);
                qi(true);
                return;
            }
        }
        b17 = false;
        aeVar = ae.f298175a;
        troopInfoData = this.troopInfoData;
        if (troopInfoData == null) {
        }
        if (!aeVar.a(troopInfoData)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi(boolean isAIGCStyle) {
        View view = null;
        if (QRDisplayTroopCardRepo.f298123a.i() && isAIGCStyle) {
            View view2 = this.aigcCardLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aigcCardLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.qrCodeLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qrCodeLayout");
                view3 = null;
            }
            view3.setVisibility(8);
            TroopInfoData troopInfoData = this.troopInfoData;
            if (troopInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoData");
                troopInfoData = null;
            }
            if (troopInfoData.isOwnerOrAdim()) {
                TextView textView = this.backToNormal;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backToNormal");
                } else {
                    view = textView;
                }
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view4 = this.aigcCardLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aigcCardLayout");
            view4 = null;
        }
        view4.setVisibility(8);
        TextView textView2 = this.backToNormal;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backToNormal");
            textView2 = null;
        }
        textView2.setVisibility(8);
        View view5 = this.qrCodeLayout;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeLayout");
        } else {
            view = view5;
        }
        view.setVisibility(0);
    }

    private final void zi() {
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.mobileqq.troop.addsource.c.class, this.troopSourceDataObserver);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            QRDisplayTroopShareCard qRDisplayTroopShareCard = this.shareCard;
            if (qRDisplayTroopShareCard == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareCard");
                qRDisplayTroopShareCard = null;
            }
            qRDisplayTroopShareCard.t(qBaseActivity, requestCode, resultCode, data);
        }
        QRDisplayTroopSearchWay qRDisplayTroopSearchWay = this.troopSearchWay;
        if (qRDisplayTroopSearchWay != null) {
            qRDisplayTroopSearchWay.i(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.curChain.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QRCodeLoadingComponent qRCodeLoadingComponent = this.qrCode;
            if (qRCodeLoadingComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                qRCodeLoadingComponent = null;
            }
            QRCodeLoadingComponent.setChain$default(qRCodeLoadingComponent, this.curChain, false, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        initData();
        pi();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.h6b, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        QRDisplayTroopShareCard qRDisplayTroopShareCard = this.shareCard;
        if (qRDisplayTroopShareCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareCard");
            qRDisplayTroopShareCard = null;
        }
        qRDisplayTroopShareCard.u();
        zi();
        QRDisplayTroopSearchWay qRDisplayTroopSearchWay = this.troopSearchWay;
        if (qRDisplayTroopSearchWay != null) {
            qRDisplayTroopSearchWay.j();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        setStatusBarImmersive();
        if (this.curChain.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QRCodeLoadingComponent qRCodeLoadingComponent = this.qrCode;
            if (qRCodeLoadingComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                qRCodeLoadingComponent = null;
            }
            QRCodeLoadingComponent.setChain$default(qRCodeLoadingComponent, this.curChain, false, 2, null);
        }
        Bi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setStatusBarImmersive();
        initView(view);
        initReport(view);
    }
}

package com.tencent.mobileqq.bizParts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsettingme.IQQSettingMeExtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.utils.dh;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.utils.fa;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.flash.VipFlashNickNameView;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tenpay.sdk.util.UinConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00f6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00aa\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00ab\u0001B\t\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a9\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u001f\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\u0012\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\b\u00104\u001a\u00020\u0005H\u0002J\b\u00105\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u000206H\u0002J\u0012\u00108\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010=\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\u0012\u0010@\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010C\u001a\u00020\u00152\b\u0010?\u001a\u0004\u0018\u00010\b2\b\u0010B\u001a\u0004\u0018\u00010AH\u0017J\u0012\u0010D\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010E\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010F\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\b\u0010G\u001a\u00020\u0005H\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010I\u001a\u00020HH\u0016R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010XR\u0018\u0010(\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010XR\u0018\u0010j\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010eR\u0018\u0010l\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010eR\u0018\u0010n\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010eR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010{\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010XR\u0018\u0010}\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010XR\u0018\u0010\u007f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010tR\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010xR\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010XR\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010tR\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010xR\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010eR\u001a\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010tR\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010xR\u0019\u0010\u0090\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0092\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u0098\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010kR\u0018\u0010\u009a\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0099\u0001\u0010kR\u0019\u0010\u009d\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010dR!\u0010\u00a3\u0001\u001a\u00030\u009e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009f\u0001\u0010\u00a0\u0001\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001c\u0010\u00a7\u0001\u001a\u0005\u0018\u00010\u00a4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u00a8\u0006\u00ac\u0001"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeProfileCardPart;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/utils/fa;", "", "Ka", "ta", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ha", "Ia", "Ja", "Ga", "Ba", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/g;", "bean", "kb", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "ob", "", "La", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/n;", "fb", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/l;", "qb", "pb", "Na", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Ma", "jb", "view", "wa", "ib", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/i;", "nb", "gb", "", "nickName", "lb", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/h;", "nicknameBean", "mb", "Fa", "xa", "Da", UinConfigManager.KEY_HB, "za", "Oa", "ra", "sb", "rb", "Landroid/graphics/Rect;", "va", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPostThemeChanged", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouch", "onPartResume", "onPartPause", "onPartDestroy", "onAccountChanged", "", "rightMargin", "b0", "Landroidx/cardview/widget/CardView;", "f", "Landroidx/cardview/widget/CardView;", "blurCardView", "Lcom/tencent/qui/quiblurview/QQBlurView;", tl.h.F, "Lcom/tencent/qui/quiblurview/QQBlurView;", "blurView", "Landroid/graphics/drawable/GradientDrawable;", "i", "Landroid/graphics/drawable/GradientDrawable;", "overLayDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "headContainer", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "D", "nickNameArea", "Lcom/tencent/mobileqq/vas/flash/VipFlashNickNameView;", "E", "Lcom/tencent/mobileqq/vas/flash/VipFlashNickNameView;", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "prettyIcon", "G", "pagLayout", "H", "vipIcon", "I", "vipPendantIcon", "J", "gameCardIcon", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "level", "L", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "headLevelRedTouch", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "M", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "headLevelRedBadge", "N", "levelAndMedalDivider", "P", "qVipMedalView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "headMedalRedTouch", BdhLogUtil.LogTag.Tag_Req, "headMedalRedBadge", ExifInterface.LATITUDE_SOUTH, "signatureContainer", "T", "signatureRedTouch", "U", "signatureRedBadge", "V", "qrCodeIcon", "W", "qrCodeRedTouch", "X", "qrCodeRedBadge", "Y", "Z", "isShowZPlanDrawer", "Lcom/tencent/image/URLDrawable;", "Lcom/tencent/image/URLDrawable;", "zPlanStaticDrawable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasUpdated", "screenHeight", "c0", "topOffset", "", "d0", "zPlanOffset", "Ljava/lang/Runnable;", "e0", "Lkotlin/Lazy;", "Aa", "()Ljava/lang/Runnable;", "runnable", "Lcom/tencent/mobileqq/av;", "f0", "Lcom/tencent/mobileqq/av;", "vipDataChangedCallback", "<init>", "()V", "g0", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes11.dex */
public final class QQSettingMeProfileCardPart extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener, fa {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QQProAvatarView avatarView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View nickNameArea;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private VipFlashNickNameView nickName;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView prettyIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View pagLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView vipIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView vipPendantIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ImageView gameCardIcon;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView level;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private RedTouch headLevelRedTouch;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TianshuRedTouch headLevelRedBadge;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View levelAndMedalDivider;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View qVipMedalView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private RedTouch headMedalRedTouch;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TianshuRedTouch headMedalRedBadge;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private View signatureContainer;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private RedTouch signatureRedTouch;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private TianshuRedTouch signatureRedBadge;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private ImageView qrCodeIcon;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private RedTouch qrCodeRedTouch;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TianshuRedTouch qrCodeRedBadge;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isShowZPlanDrawer;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private URLDrawable zPlanStaticDrawable;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean hasUpdated;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int screenHeight;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int topOffset;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float zPlanOffset;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy runnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardView blurCardView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.av vipDataChangedCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQBlurView blurView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GradientDrawable overLayDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View headContainer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeProfileCardPart$a;", "", "", "DRAWER_LEVEL_URL", "Ljava/lang/String;", "", "LEVEL_ICON_MAX_COUNT", "I", "TAG", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/bizParts/QQSettingMeProfileCardPart$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQSettingMeProfileCardPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.rb();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            } else {
                QLog.e("QQSettingMeProfileCardPart", 1, "updateZPlanStaticDrawable onLoadCanceled");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) cause);
            } else {
                QLog.e("QQSettingMeProfileCardPart", 1, "updateZPlanStaticDrawable onLoadFialed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, progress);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            QLog.i("QQSettingMeProfileCardPart", 1, "updateZPlanStaticDrawable onLoadSuccessed");
            final QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
            qQSettingMeProfileCardPart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.bizParts.bf
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeProfileCardPart.b.b(QQSettingMeProfileCardPart.this);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeProfileCardPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hasUpdated = new AtomicBoolean();
        lazy = LazyKt__LazyJVMKt.lazy(new QQSettingMeProfileCardPart$runnable$2(this));
        this.runnable = lazy;
    }

    private final Runnable Aa() {
        return (Runnable) this.runnable.getValue();
    }

    private final void Ba() {
        View view;
        final QQProAvatarView qQProAvatarView;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            view = partRootView.findViewById(R.id.unq);
        } else {
            view = null;
        }
        this.headContainer = view;
        if (AppSetting.f99565y && view != null) {
            view.setContentDescription(HardCodeUtil.qqStr(R.string.f172480r35));
        }
        View view2 = this.headContainer;
        if (view2 != null) {
            qQProAvatarView = (QQProAvatarView) view2.findViewById(R.id.unk);
        } else {
            qQProAvatarView = null;
        }
        this.avatarView = qQProAvatarView;
        if (qQProAvatarView != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            if (((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).getStrokeVisible(currentAccountUin, peekAppRuntime) == 0) {
                QQProAvatarView.setEnableFrame$default(qQProAvatarView, ex.d(3), 0, 2, null);
            } else {
                QQProAvatarView.setEnableFrame$default(qQProAvatarView, ex.d(0), 0, 2, null);
            }
            qQProAvatarView.post(new Runnable() { // from class: com.tencent.mobileqq.bizParts.ak
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeProfileCardPart.Ca(QQProAvatarView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(QQProAvatarView this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setAvatarDrawable(this_apply);
    }

    private final void Da() {
        CardView cardView;
        KeyEvent.Callback callback;
        View partRootView = getPartRootView();
        QQBlurView qQBlurView = null;
        if (partRootView != null) {
            cardView = (CardView) partRootView.findViewById(R.id.f164621t94);
        } else {
            cardView = null;
        }
        if (!(cardView instanceof CardView)) {
            cardView = null;
        }
        this.blurCardView = cardView;
        if (cardView != null) {
            cardView.setRadius(ex.d(16));
            cardView.setCardBackgroundColor(0);
            cardView.setCardElevation(0.0f);
        }
        CardView cardView2 = this.blurCardView;
        if (cardView2 != null) {
            callback = cardView2.getChildAt(0);
        } else {
            callback = null;
        }
        if (callback instanceof QQBlurView) {
            qQBlurView = (QQBlurView) callback;
        }
        this.blurView = qQBlurView;
        if (qQBlurView != null) {
            qQBlurView.l(12);
        }
        QQBlurView qQBlurView2 = this.blurView;
        if (qQBlurView2 != null) {
            qQBlurView2.m(qQBlurView2);
        }
        QQBlurView qQBlurView3 = this.blurView;
        if (qQBlurView3 != null) {
            qQBlurView3.j(getPartRootView());
        }
        QQBlurView qQBlurView4 = this.blurView;
        if (qQBlurView4 != null) {
            qQBlurView4.setDisableBlurDrawable(ex.c(R.drawable.qui_common_bg_bottom_standard_bg));
        }
        QQBlurView qQBlurView5 = this.blurView;
        if (qQBlurView5 != null) {
            qQBlurView5.y(true);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.bizParts.av
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileCardPart.Ea(QQSettingMeProfileCardPart.this);
            }
        });
        QQBlurView qQBlurView6 = this.blurView;
        if (qQBlurView6 != null) {
            qQBlurView6.setEnableBlur(false);
        }
        QQBlurView qQBlurView7 = this.blurView;
        if (qQBlurView7 != null) {
            qQBlurView7.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(QQSettingMeProfileCardPart this$0) {
        int a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (je0.a.a(this$0.getActivity())) {
            a16 = ex.a(R.color.cec);
        } else {
            a16 = ex.a(R.color.qui_common_fill_light_tertiary);
        }
        int a17 = ex.a(R.color.qui_common_bg_bottom_standard);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{a16, a17, a17});
        this$0.overLayDrawable = gradientDrawable;
        QQBlurView qQBlurView = this$0.blurView;
        if (qQBlurView != null) {
            qQBlurView.z(gradientDrawable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0076, code lost:
    
        if (r4 != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Fa() {
        boolean z16;
        RedTouch redTouch;
        boolean z17;
        boolean z18;
        VideoReport.setElementId(this.pagLayout, "em_drawer_energy_sign");
        View view = this.pagLayout;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(view, clickPolicy);
        View view2 = this.pagLayout;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(view2, exposurePolicy);
        VideoReport.setElementId(this.level, "em_drawer_qqlevel_sign");
        VideoReport.setElementClickPolicy(this.level, clickPolicy);
        TextView textView = this.level;
        ExposurePolicy exposurePolicy2 = ExposurePolicy.REPORT_FIRST;
        VideoReport.setElementExposePolicy(textView, exposurePolicy2);
        TextView textView2 = this.level;
        com.tencent.mobileqq.activity.qqsettingme.m mVar = new com.tencent.mobileqq.activity.qqsettingme.m();
        RedTouch redTouch2 = this.headLevelRedTouch;
        boolean z19 = true;
        if (redTouch2 != null) {
            if (redTouch2 != null && redTouch2.hasRedTouch()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z16 = true;
                VideoReport.setElementDynamicParams(textView2, mVar.c(z16));
                VideoReport.setElementId(this.qVipMedalView, "em_drawer_member_sign");
                VideoReport.setElementClickPolicy(this.qVipMedalView, clickPolicy);
                VideoReport.setElementExposePolicy(this.qVipMedalView, exposurePolicy2);
                View view3 = this.qVipMedalView;
                com.tencent.mobileqq.activity.qqsettingme.m mVar2 = new com.tencent.mobileqq.activity.qqsettingme.m();
                redTouch = this.headMedalRedTouch;
                if (redTouch != null) {
                    if (redTouch != null && redTouch.hasRedTouch()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z19 = false;
                VideoReport.setElementDynamicParams(view3, mVar2.c(z19));
                VideoReport.setElementId(this.qrCodeIcon, "em_bas_dimensional_code");
                VideoReport.setElementClickPolicy(this.qrCodeIcon, clickPolicy);
                VideoReport.setElementExposePolicy(this.qrCodeIcon, exposurePolicy);
                VideoReport.setElementId(this.headContainer, "em_bas_my_qq_data_card");
                VideoReport.setElementClickPolicy(this.headContainer, clickPolicy);
                VideoReport.setElementExposePolicy(this.headContainer, exposurePolicy);
                VideoReport.setElementId(this.avatarView, "em_bas_my_qq_data_card");
                VideoReport.setElementClickPolicy(this.avatarView, clickPolicy);
                VideoReport.setElementExposePolicy(this.avatarView, exposurePolicy);
                VideoReport.setElementId(this.nickNameArea, "em_bas_my_qq_data_card");
                VideoReport.setElementClickPolicy(this.nickNameArea, clickPolicy);
                VideoReport.setElementExposePolicy(this.nickNameArea, exposurePolicy);
            }
        }
        z16 = false;
        VideoReport.setElementDynamicParams(textView2, mVar.c(z16));
        VideoReport.setElementId(this.qVipMedalView, "em_drawer_member_sign");
        VideoReport.setElementClickPolicy(this.qVipMedalView, clickPolicy);
        VideoReport.setElementExposePolicy(this.qVipMedalView, exposurePolicy2);
        View view32 = this.qVipMedalView;
        com.tencent.mobileqq.activity.qqsettingme.m mVar22 = new com.tencent.mobileqq.activity.qqsettingme.m();
        redTouch = this.headMedalRedTouch;
        if (redTouch != null) {
        }
        z19 = false;
        VideoReport.setElementDynamicParams(view32, mVar22.c(z19));
        VideoReport.setElementId(this.qrCodeIcon, "em_bas_dimensional_code");
        VideoReport.setElementClickPolicy(this.qrCodeIcon, clickPolicy);
        VideoReport.setElementExposePolicy(this.qrCodeIcon, exposurePolicy);
        VideoReport.setElementId(this.headContainer, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.headContainer, clickPolicy);
        VideoReport.setElementExposePolicy(this.headContainer, exposurePolicy);
        VideoReport.setElementId(this.avatarView, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.avatarView, clickPolicy);
        VideoReport.setElementExposePolicy(this.avatarView, exposurePolicy);
        VideoReport.setElementId(this.nickNameArea, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.nickNameArea, clickPolicy);
        VideoReport.setElementExposePolicy(this.nickNameArea, exposurePolicy);
    }

    private final void Ga() {
        View view;
        VipFlashNickNameView vipFlashNickNameView;
        VipFlashNickNameView vipFlashNickNameView2;
        View view2 = this.headContainer;
        ImageView imageView = null;
        if (view2 != null) {
            view = view2.findViewById(R.id.unv);
        } else {
            view = null;
        }
        this.nickNameArea = view;
        View view3 = this.headContainer;
        if (view3 != null) {
            vipFlashNickNameView = (VipFlashNickNameView) view3.findViewById(R.id.unu);
        } else {
            vipFlashNickNameView = null;
        }
        this.nickName = vipFlashNickNameView;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
        if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.nickName, currentAccountUin, false) && (vipFlashNickNameView2 = this.nickName) != null) {
            vipFlashNickNameView2.setTextColor(ex.b(R.color.qui_common_text_primary));
        }
        View view4 = this.headContainer;
        if (view4 != null) {
            imageView = (ImageView) view4.findViewById(R.id.uny);
        }
        this.prettyIcon = imageView;
        dh.f307632a.b(this);
    }

    private final void Ha(View rootView) {
        ImageView imageView;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.un6);
        } else {
            imageView = null;
        }
        this.qrCodeIcon = imageView;
    }

    private final void Ia(View rootView) {
        View view;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f165035uo3);
        } else {
            view = null;
        }
        this.signatureContainer = view;
    }

    private final void Ja() {
        ViewGroup viewGroup;
        View view;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView;
        View view2;
        View view3 = this.headContainer;
        View view4 = null;
        if (view3 != null) {
            viewGroup = (ViewGroup) view3.findViewById(R.id.unr);
        } else {
            viewGroup = null;
        }
        if (!(viewGroup instanceof ViewGroup)) {
            viewGroup = null;
        }
        View vipView = ((IQQSettingMeExtApi) QRoute.api(IQQSettingMeExtApi.class)).getVipView(getActivity(), true);
        if (vipView != null) {
            if (viewGroup != null) {
                viewGroup.addView(vipView);
            }
            View view5 = this.headContainer;
            if (view5 != null) {
                view = view5.findViewById(R.id.unw);
            } else {
                view = null;
            }
            this.pagLayout = view;
            View view6 = this.headContainer;
            if (view6 != null) {
                imageView = (ImageView) view6.findViewById(R.id.unn);
            } else {
                imageView = null;
            }
            this.gameCardIcon = imageView;
            View view7 = this.headContainer;
            if (view7 != null) {
                imageView2 = (ImageView) view7.findViewById(R.id.uo6);
            } else {
                imageView2 = null;
            }
            this.vipIcon = imageView2;
            View view8 = this.headContainer;
            if (view8 != null) {
                imageView3 = (ImageView) view8.findViewById(R.id.uo7);
            } else {
                imageView3 = null;
            }
            this.vipPendantIcon = imageView3;
            View view9 = this.headContainer;
            if (view9 != null) {
                textView = (TextView) view9.findViewById(R.id.f165032uo0);
            } else {
                textView = null;
            }
            this.level = textView;
            View view10 = this.headContainer;
            if (view10 != null) {
                view2 = view10.findViewById(R.id.uns);
            } else {
                view2 = null;
            }
            this.levelAndMedalDivider = view2;
            View view11 = this.headContainer;
            if (view11 != null) {
                view4 = view11.findViewById(R.id.unz);
            }
            this.qVipMedalView = view4;
            TextView textView2 = this.level;
            if (textView2 != null) {
                textView2.setText("");
            }
        }
    }

    private final void Ka() {
        if (this.avatarView != null && com.tencent.mobileqq.vas.ar.INSTANCE.b("shouyouye", "", "vas_qq_setting_me_v9_vip_data").isEnable(true)) {
            com.tencent.mobileqq.av avVar = new com.tencent.mobileqq.av(this.avatarView);
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).registerVipDataChangedCallback(currentAccountUin, avVar);
            this.vipDataChangedCallback = avVar;
        }
    }

    private final boolean La() {
        return false;
    }

    private final boolean Ma(BusinessInfoCheckUpdate.AppInfo appInfo, RedTouch redTouch) {
        boolean z16;
        if (redTouch != null && redTouch.hasRedTouch()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Na(appInfo) || z16) {
            return true;
        }
        return false;
    }

    private final boolean Na(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null || appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() < 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null) {
            return false;
        }
        return true;
    }

    private final boolean Oa() {
        de deVar = de.f307628a;
        if (deVar.c() && deVar.a()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ab(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(QQSettingMeProfileCardPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fb(com.tencent.mobileqq.activity.qqsettingme.bean.n bean) {
        TextView textView;
        ImageView imageView;
        View view;
        View view2 = this.signatureContainer;
        if (view2 == null) {
            return;
        }
        ImageView imageView2 = null;
        if (view2 != null) {
            textView = (TextView) view2.findViewById(R.id.f165034uo2);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setTextColor(ex.b(R.color.qui_common_text_secondary));
        }
        View view3 = this.signatureContainer;
        if (view3 != null) {
            imageView = (ImageView) view3.findViewById(R.id.unp);
        } else {
            imageView = null;
        }
        StringBuilder sb5 = new StringBuilder(100);
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeProfileCardPart", 2, "preLoadSignature, actionText = " + bean.f184929b + ", actionId = " + bean.f184928a + ", dataText = " + bean.f184930c + ", plainText = " + bean.f184932e);
        }
        View view4 = this.signatureContainer;
        if (view4 != null) {
            imageView2 = (ImageView) view4.findViewById(R.id.f165033uo1);
        }
        if (!TextUtils.isEmpty(bean.f184929b)) {
            if (imageView2 != null) {
                imageView2.setImageBitmap(bean.f184934g);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            sb5.append(bean.f184929b);
            if (!TextUtils.isEmpty(bean.f184930c)) {
                sb5.append(bean.f184930c);
            }
            sb5.append(TokenParser.SP);
        } else {
            if (imageView2 != null) {
                imageView2.setBackgroundResource(0);
            }
            if (imageView2 != null) {
                imageView2.setPadding(0, 0, 0, 0);
            }
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.qui_edit_icon_secondary);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(bean.f184933f)) {
            if (!TextUtils.isEmpty(bean.f184931d)) {
                sb5.append(bean.f184931d);
            }
            if (!TextUtils.isEmpty(bean.f184932e)) {
                sb5.append(bean.f184932e);
            }
        } else {
            sb5.append(bean.f184933f);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        if (TextUtils.isEmpty(sb6)) {
            if (textView != null) {
                textView.setText(R.string.fru);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (com.tencent.mobileqq.utils.ah.m0()) {
                if (textView != null) {
                    textView.setText(new QQText(sb6 + TokenParser.SP, 1, 16));
                }
            } else if (textView != null) {
                textView.setText(new QQText(sb6, 1, 16));
            }
        }
        if (AppSetting.f99565y && (view = this.signatureContainer) != null) {
            view.setContentDescription("\u4e2a\u6027\u7b7e\u540d" + sb6);
        }
    }

    private final void gb() {
        if (je0.a.a(getActivity())) {
            ImageView imageView = this.prettyIcon;
            if (imageView != null) {
                imageView.setColorFilter(1996488704);
                return;
            }
            return;
        }
        ImageView imageView2 = this.prettyIcon;
        if (imageView2 != null) {
            imageView2.setColorFilter(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hb() {
        View view;
        Window window;
        URLDrawable uRLDrawable;
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (Oa()) {
            View partRootView = getPartRootView();
            View view2 = null;
            if (partRootView != null) {
                view = partRootView.findViewById(R.id.yg7);
            } else {
                view = null;
            }
            com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
            Activity activity = getActivity();
            if (activity != null) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            if (bVar.j(window)) {
                if (view != null) {
                    obj = view.getParent();
                } else {
                    obj = null;
                }
                if (obj instanceof View) {
                    view2 = (View) obj;
                }
                if (view2 != null) {
                    arrayList.add(view2.getBackground());
                }
            } else if (view != null) {
                arrayList.add(view.getBackground());
            }
            if (this.zPlanOffset < this.screenHeight / 3 && (uRLDrawable = this.zPlanStaticDrawable) != null) {
                arrayList.add(uRLDrawable);
            }
            QQBlurView qQBlurView = this.blurView;
            if (qQBlurView != null) {
                qQBlurView.setBlurSource(arrayList);
            }
        } else {
            arrayList.add(getPartRootView());
            QQBlurView qQBlurView2 = this.blurView;
            if (qQBlurView2 != null) {
                qQBlurView2.setBlurSource(arrayList);
            }
        }
        QQBlurView qQBlurView3 = this.blurView;
        if (qQBlurView3 != null) {
            qQBlurView3.setEnableBlur(za());
        }
        QQBlurView qQBlurView4 = this.blurView;
        if (qQBlurView4 != null) {
            qQBlurView4.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ib(BusinessInfoCheckUpdate.AppInfo appInfo) {
        RedTouch redPointSize;
        RedTouch topMargin;
        RedTouch rightMargin;
        PBStringField pBStringField;
        RedTouch redTouch = null;
        r1 = null;
        String str = null;
        redTouch = null;
        redTouch = null;
        redTouch = null;
        if (La()) {
            if (this.level != null && this.headLevelRedBadge == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                TextView textView = this.level;
                Intrinsics.checkNotNull(textView);
                this.headLevelRedBadge = new TianshuRedTouch(context, textView).q0(1.0f).t();
            }
            TianshuRedTouch tianshuRedTouch = this.headLevelRedBadge;
            if (tianshuRedTouch != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null) {
                    str = pBStringField.get();
                }
                tianshuRedTouch.n0(str);
                return;
            }
            return;
        }
        if (Ma(appInfo, this.headLevelRedTouch)) {
            if (this.headLevelRedTouch == null) {
                RedTouch wa5 = wa(this.level);
                if (wa5 != null && (redPointSize = wa5.setRedPointSize(12)) != null && (topMargin = redPointSize.setTopMargin(0.0f)) != null && (rightMargin = topMargin.setRightMargin(1.0f)) != null) {
                    redTouch = rightMargin.applyTo();
                }
                this.headLevelRedTouch = redTouch;
            }
            RedTouch redTouch2 = this.headLevelRedTouch;
            if (redTouch2 != null) {
                redTouch2.parseRedTouch(appInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jb(BusinessInfoCheckUpdate.AppInfo appInfo) {
        RedTouch redPointSize;
        RedTouch topMargin;
        RedTouch rightMargin;
        PBStringField pBStringField;
        RedTouch redTouch = null;
        r1 = null;
        String str = null;
        redTouch = null;
        redTouch = null;
        redTouch = null;
        if (La()) {
            if (this.qVipMedalView != null && this.headMedalRedBadge == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                View view = this.qVipMedalView;
                Intrinsics.checkNotNull(view);
                this.headMedalRedBadge = new TianshuRedTouch(context, view).r0(1.0f).q0(1.0f).t();
            }
            TianshuRedTouch tianshuRedTouch = this.headMedalRedBadge;
            if (tianshuRedTouch != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null) {
                    str = pBStringField.get();
                }
                tianshuRedTouch.n0(str);
                return;
            }
            return;
        }
        if (Ma(appInfo, this.headMedalRedTouch)) {
            if (this.headMedalRedTouch == null) {
                RedTouch wa5 = wa(this.qVipMedalView);
                if (wa5 != null && (redPointSize = wa5.setRedPointSize(12)) != null && (topMargin = redPointSize.setTopMargin(1.0f)) != null && (rightMargin = topMargin.setRightMargin(1.0f)) != null) {
                    redTouch = rightMargin.applyTo();
                }
                this.headMedalRedTouch = redTouch;
            }
            RedTouch redTouch2 = this.headMedalRedTouch;
            if (redTouch2 != null) {
                redTouch2.parseRedTouch(appInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kb(com.tencent.mobileqq.activity.qqsettingme.bean.g bean) {
        try {
            if (bean.f184893b != null && getActivity() != null && this.vipIcon != null && this.vipPendantIcon != null) {
                Resources resources = getActivity().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
                ImageView imageView = this.vipPendantIcon;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (com.tencent.mobileqq.activity.qqsettingme.utils.b.e(bean)) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(getActivity(), this.vipPendantIcon, bean.f184893b.nameplateExtId);
                }
                CharSequence charSequence = null;
                if (bean.f184901j != null && bean.f184902k != 0) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setVipCardDrawable(resources, this.vipIcon, bean.f184901j, ResourcesCompat.getDrawable(resources, bean.f184902k, null));
                    ImageView imageView2 = this.vipIcon;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    ImageView imageView3 = this.vipIcon;
                    if (imageView3 != null) {
                        imageView3.setContentDescription(HardCodeUtil.qqStr(R.string.vhq));
                    }
                    ImageView imageView4 = this.vipIcon;
                    if (imageView4 != null) {
                        imageView4.setFocusableInTouchMode(true);
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    ImageView imageView5 = this.vipIcon;
                    if (imageView5 != null) {
                        imageView5.setOnTouchListener(((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).headVipReport(peekAppRuntime, bean.f184893b.uin));
                    }
                } else {
                    ImageView imageView6 = this.vipIcon;
                    if (imageView6 != null) {
                        imageView6.setVisibility(8);
                    }
                    ImageView imageView7 = this.vipIcon;
                    if (imageView7 != null) {
                        imageView7.setOnTouchListener(null);
                    }
                }
                if (bean.f184907p) {
                    IQQSettingMeApi iQQSettingMeApi = (IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class);
                    ImageView imageView8 = this.gameCardIcon;
                    Card card = bean.f184893b;
                    URLDrawable gameCardIcon = iQQSettingMeApi.getGameCardIcon(imageView8, card.namePlateOfKingGameId, card.namePlateOfKingDan, card.namePlateOfKingDanDisplatSwitch, card.gameCardId);
                    ImageView imageView9 = this.gameCardIcon;
                    if (imageView9 != null) {
                        imageView9.setImageDrawable(gameCardIcon);
                    }
                } else {
                    ImageView imageView10 = this.gameCardIcon;
                    if (imageView10 != null) {
                        imageView10.setVisibility(8);
                    }
                }
                MedalList medalList = bean.f184894c;
                if (medalList != null && medalList.infoList.size() > 0) {
                    ((IQVipMedalViewApi) QRoute.api(IQVipMedalViewApi.class)).setData(this.qVipMedalView, bean.f184894c);
                    View view = this.qVipMedalView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                } else {
                    View view2 = this.qVipMedalView;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    View view3 = this.levelAndMedalDivider;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).parseQQLevel(resources, bean.f184904m, bean.f184893b.iQQLevel, 3));
                ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setTextForAnimation(this.level, spannableStringBuilder, TextView.BufferType.SPANNABLE);
                TextView textView = this.level;
                if (textView != null) {
                    textView.setContentDescription("\u7b49\u7ea7\uff1a" + bean.f184893b.iQQLevel);
                }
                if (AppSetting.f99565y) {
                    VipFlashNickNameView vipFlashNickNameView = this.nickName;
                    if (vipFlashNickNameView != null) {
                        charSequence = vipFlashNickNameView.getText();
                    }
                    String str = "";
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    StringBuilder sb5 = new StringBuilder(charSequence);
                    if (bean.f184895d) {
                        str = "\u4f60\u662f\u5c0a\u8d35\u7684\u8d85\u7ea7\u4f1a\u5458";
                    } else if (bean.f184896e) {
                        str = "\u4f60\u662f\u5c0a\u8d35\u7684\u4f1a\u5458";
                    }
                    sb5.append(str);
                    if (bean.f184893b.iQQLevel > 0) {
                        sb5.append(" \u7b49\u7ea7");
                        sb5.append(bean.f184893b.iQQLevel);
                    }
                    View view4 = this.headContainer;
                    if (view4 != null) {
                        view4.setContentDescription(sb5.toString());
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeProfileCardPart", 2, "updateQQLevelVipView card == null");
            }
        } catch (Throwable th5) {
            QLog.e("QQSettingMeProfileCardPart", 1, "error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lb(String nickName) {
        VipFlashNickNameView vipFlashNickNameView = this.nickName;
        if (vipFlashNickNameView != null) {
            vipFlashNickNameView.setText(nickName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mb(com.tencent.mobileqq.activity.qqsettingme.bean.h nicknameBean) {
        CharSequence charSequence;
        View view;
        VipFlashNickNameView vipFlashNickNameView;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        CharSequence charSequence2 = null;
        if (TextUtils.isEmpty(currentAccountUin)) {
            VipFlashNickNameView vipFlashNickNameView2 = this.nickName;
            if (vipFlashNickNameView2 != null) {
                vipFlashNickNameView2.setText("");
            }
            VipFlashNickNameView vipFlashNickNameView3 = this.nickName;
            if (vipFlashNickNameView3 != null) {
                vipFlashNickNameView3.setCompoundDrawables(null, null, null, null);
            }
            TextView textView = this.level;
            if (textView != null) {
                textView.setText("");
            }
            ImageView imageView = this.vipIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.vipPendantIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.prettyIcon;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
                return;
            }
            return;
        }
        VipFlashNickNameView vipFlashNickNameView4 = this.nickName;
        if (vipFlashNickNameView4 != null) {
            vipFlashNickNameView4.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
        String str = nicknameBean.f184909a;
        VipFlashNickNameView vipFlashNickNameView5 = this.nickName;
        if (vipFlashNickNameView5 != null) {
            charSequence = vipFlashNickNameView5.getText();
        } else {
            charSequence = null;
        }
        if (!Utils.p(str, charSequence) && (vipFlashNickNameView = this.nickName) != null) {
            vipFlashNickNameView.setText(nicknameBean.f184909a);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeProfileCardPart", 2, "updateLevelAndVip from updateAccountInfo");
        }
        qQSettingMeViewModel.N1("d_head_vip").e();
        if (AppSetting.f99565y && (view = this.headContainer) != null) {
            VipFlashNickNameView vipFlashNickNameView6 = this.nickName;
            if (vipFlashNickNameView6 != null) {
                charSequence2 = vipFlashNickNameView6.getText();
            }
            view.setContentDescription(charSequence2);
        }
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).updateTextColorGradientWithColor(this.nickName, currentAccountUin, ex.b(R.color.qui_common_text_primary), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nb(com.tencent.mobileqq.activity.qqsettingme.bean.i bean) {
        ImageView imageView = this.prettyIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (bean.f184913d != null) {
            ImageView imageView2 = this.prettyIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.prettyIcon;
            if (imageView3 != null) {
                imageView3.setImageDrawable(bean.f184913d);
            }
            gb();
            return;
        }
        if (!bean.f184910a || bean.f184911b == null || bean.f184912c == null) {
            return;
        }
        ImageView imageView4 = this.prettyIcon;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageView imageView5 = this.prettyIcon;
        if (imageView5 != null) {
            imageView5.setImageDrawable(bean.f184912c);
        }
        gb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ob(BusinessInfoCheckUpdate.AppInfo appInfo) {
        RedTouch redPointSize;
        RedTouch topMargin;
        RedTouch rightMargin;
        PBStringField pBStringField;
        RedTouch redTouch = null;
        r1 = null;
        String str = null;
        redTouch = null;
        redTouch = null;
        redTouch = null;
        if (La()) {
            if (this.qrCodeIcon != null && this.qrCodeRedBadge == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ImageView imageView = this.qrCodeIcon;
                Intrinsics.checkNotNull(imageView);
                this.qrCodeRedBadge = new TianshuRedTouch(context, imageView).r0(1.0f).q0(1.0f).t();
            }
            TianshuRedTouch tianshuRedTouch = this.qrCodeRedBadge;
            if (tianshuRedTouch != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null) {
                    str = pBStringField.get();
                }
                tianshuRedTouch.n0(str);
                return;
            }
            return;
        }
        if (Ma(appInfo, this.qrCodeRedTouch)) {
            if (this.qrCodeRedTouch == null) {
                RedTouch wa5 = wa(this.qrCodeIcon);
                if (wa5 != null && (redPointSize = wa5.setRedPointSize(20)) != null && (topMargin = redPointSize.setTopMargin(1.0f)) != null && (rightMargin = topMargin.setRightMargin(1.0f)) != null) {
                    redTouch = rightMargin.applyTo();
                }
                this.qrCodeRedTouch = redTouch;
            }
            RedTouch redTouch2 = this.qrCodeRedTouch;
            if (redTouch2 != null) {
                redTouch2.parseRedTouch(appInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pb(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        PBStringField pBStringField;
        if (this.signatureContainer == null) {
            return;
        }
        if (La()) {
            if (this.signatureContainer != null && this.signatureRedBadge == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                View view = this.signatureContainer;
                Intrinsics.checkNotNull(view);
                TianshuRedTouch t16 = new TianshuRedTouch(context, view).j0(10.0f).h0(8388661).t();
                this.signatureRedBadge = t16;
                if (t16 != null) {
                    t16.t();
                }
            }
            TianshuRedTouch tianshuRedTouch = this.signatureRedBadge;
            if (tianshuRedTouch != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                tianshuRedTouch.n0(str);
                return;
            }
            return;
        }
        if (Ma(appInfo, this.signatureRedTouch)) {
            if (this.signatureRedTouch == null) {
                this.signatureRedTouch = new RedTouch(getActivity(), this.signatureContainer).setLeftMargin(10).setGravity(8388627).applyTo();
            }
            RedTouch redTouch = this.signatureRedTouch;
            if (redTouch != null) {
                redTouch.parseRedTouch(appInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qb(com.tencent.mobileqq.activity.qqsettingme.bean.l bean) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        QQText qQText;
        View view;
        String str;
        String str2;
        View view2 = this.signatureContainer;
        CharSequence charSequence = null;
        if (view2 != null) {
            imageView = (ImageView) view2.findViewById(R.id.f165033uo1);
        } else {
            imageView = null;
        }
        View view3 = this.signatureContainer;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.f165034uo2);
        } else {
            textView = null;
        }
        View view4 = this.signatureContainer;
        if (view4 != null) {
            imageView2 = (ImageView) view4.findViewById(R.id.unp);
        } else {
            imageView2 = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SharedPreferences.Editor edit = peekAppRuntime.getApp().getSharedPreferences("qqsettingme_signature" + peekAppRuntime.getAccount(), 0).edit();
        Intrinsics.checkNotNullExpressionValue(edit, "app.app\n            .get\u2026VATE)\n            .edit()");
        StringBuilder sb5 = new StringBuilder(100);
        RichStatus richStatus = bean.f184922a;
        if (richStatus != null && !TextUtils.isEmpty(richStatus.actionText)) {
            if (imageView != null) {
                imageView.setImageBitmap(bean.f184923b);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            sb5.append(bean.f184922a.actionText);
            if (!TextUtils.isEmpty(bean.f184922a.dataText)) {
                sb5.append(bean.f184922a.dataText);
            }
            sb5.append(TokenParser.SP);
            edit.putInt("actionId", bean.f184922a.actionId);
            edit.putString("actionText", bean.f184922a.actionText);
            edit.putString("dataText", bean.f184922a.dataText);
        } else {
            if (imageView != null) {
                imageView.setBackgroundResource(0);
            }
            if (imageView != null) {
                imageView.setPadding(0, 0, 0, 0);
            }
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qui_edit_icon_secondary);
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        RichStatus richStatus2 = bean.f184922a;
        if (richStatus2 != null) {
            if (richStatus2.hasTopic()) {
                if (bean.f184922a.shouldShowAtHead()) {
                    String str3 = bean.f184922a.topicToPlainText();
                    sb5.append(str3);
                    edit.putString(MessageForRichState.SIGN_MSG_TOPICS, str3);
                    ArrayList<String> arrayList = bean.f184922a.plainText;
                    if (arrayList != null && arrayList.size() > 0) {
                        str2 = bean.f184922a.plainText.get(0);
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        sb5.append(str2);
                    }
                    edit.putString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, str2);
                }
                if (bean.f184922a.shouldShowMixing()) {
                    String plainText = bean.f184922a.getPlainText();
                    sb5.append(plainText);
                    edit.putString("plainMixTopic", plainText);
                }
            } else {
                ArrayList<String> arrayList2 = bean.f184922a.plainText;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    str = bean.f184922a.plainText.get(0);
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                }
                edit.putString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, str);
            }
        }
        edit.apply();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        if (TextUtils.isEmpty(sb6)) {
            if (textView != null) {
                textView.setText(R.string.fru);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else {
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            if (com.tencent.mobileqq.utils.ah.m0()) {
                qQText = new QQText(sb6 + TokenParser.SP, 1, 16);
            } else {
                qQText = new QQText(sb6, 1, 16);
            }
            if (textView != null) {
                charSequence = textView.getText();
            }
            if (!TextUtils.equals(charSequence, qQText) && textView != null) {
                textView.setText(qQText);
            }
        }
        if (AppSetting.f99565y && (view = this.signatureContainer) != null) {
            view.setContentDescription("\u4e2a\u6027\u7b7e\u540d" + sb6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.bizParts.at
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileCardPart.sa(QQSettingMeProfileCardPart.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rb() {
        if (this.hasUpdated.compareAndSet(false, true)) {
            URLDrawable uRLDrawable = this.zPlanStaticDrawable;
            if (uRLDrawable != null) {
                uRLDrawable.setBounds(va());
            }
            hb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(QQSettingMeProfileCardPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sb();
    }

    private final void sb() {
        QLog.i("QQSettingMeProfileCardPart", 1, "updateZPlanStaticDrawable");
        this.hasUpdated.set(false);
        String g16 = DrawerUtils.f306948a.g();
        if (new File(g16).exists()) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(g16, obtain);
            this.zPlanStaticDrawable = fileDrawable;
            if (fileDrawable != null) {
                fileDrawable.setURLDrawableListener(new b());
            }
        }
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.bizParts.au
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileCardPart.tb(QQSettingMeProfileCardPart.this);
            }
        });
    }

    private final void ta() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$bindContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    QQSettingMeProfileCardPart.this.isShowZPlanDrawer = true;
                } else if (num != null && num.intValue() == 0) {
                    QQSettingMeProfileCardPart.this.isShowZPlanDrawer = false;
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.ua(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(QQSettingMeProfileCardPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect va() {
        int realWidth = ScreenUtil.getRealWidth(getActivity());
        int i3 = this.screenHeight;
        int i16 = this.topOffset;
        return new Rect(0, i16, realWidth, i3 + i16);
    }

    private final RedTouch wa(View view) {
        if (view == null) {
            return null;
        }
        return new RedTouch(getActivity(), view).setGravity(8388661);
    }

    private final void xa() {
        VideoReport.reportEvent("imp", this.qrCodeIcon, null);
        VideoReport.reportEvent("imp", this.headContainer, null);
    }

    private final boolean za() {
        if (Intrinsics.areEqual(((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).R1().getValue(), Boolean.TRUE)) {
            com.tencent.qui.quiblurview.c cVar = com.tencent.qui.quiblurview.c.f363628c;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            if (cVar.b(activity)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.utils.fa
    public void b0(int rightMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, rightMargin);
            return;
        }
        QLog.i("QQSettingMeProfileCardPart", 1, "padding change to " + rightMargin);
        if (rightMargin > 0) {
            View view = this.nickNameArea;
            if (view != null) {
                view.setPadding(0, 0, rightMargin, 0);
                return;
            }
            return;
        }
        View view2 = this.nickNameArea;
        if (view2 != null) {
            view2.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onAccountChanged();
        com.tencent.mobileqq.av avVar = this.vipDataChangedCallback;
        if (avVar != null) {
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).unRegisterVipDataChangedCallback(currentAccountUin, avVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ea, code lost:
    
        if (r1 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015b, code lost:
    
        if (r1 != false) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@Nullable View v3) {
        Integer num;
        byte b16;
        byte b17;
        TextView textView;
        CharSequence charSequence;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!this.isShowZPlanDrawer && !FastClickUtils.isFastDoubleClick("QQSettingMeProfileCardPart")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.unq) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_avatar").onClick(v3);
            } else if (num != null && num.intValue() == R.id.uny) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_pretty_num").onClick(v3);
            } else {
                int i3 = 1;
                boolean z16 = true;
                int i16 = 1;
                if (num != null && num.intValue() == R.id.f165035uo3) {
                    if (this.signatureContainer != null && getActivity() != null) {
                        View view = this.signatureContainer;
                        if (view != null) {
                            textView = (TextView) view.findViewById(R.id.f165034uo2);
                        } else {
                            textView = null;
                        }
                        if (textView != null) {
                            charSequence = textView.getText();
                        } else {
                            charSequence = null;
                        }
                        if (charSequence == null) {
                            z16 = false;
                        }
                        v3.setTag(Boolean.valueOf(z16));
                    }
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_signature").onClick(v3);
                    TianshuRedTouch tianshuRedTouch = this.signatureRedBadge;
                    if (tianshuRedTouch != null) {
                        tianshuRedTouch.y(null);
                    }
                } else if (num != null && num.intValue() == R.id.unz) {
                    RedTouch redTouch = this.headMedalRedTouch;
                    if (redTouch != null) {
                        if (redTouch != null && redTouch.hasRedTouch()) {
                            b17 = true;
                        } else {
                            b17 = false;
                        }
                    }
                    i16 = 0;
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_head_vip").onClick(v3);
                    VideoReport.setElementParam(v3, "is_red_tips_em", Integer.valueOf(i16));
                    VideoReport.reportEvent("clck", v3, null);
                    TianshuRedTouch tianshuRedTouch2 = this.headMedalRedBadge;
                    if (tianshuRedTouch2 != null) {
                        tianshuRedTouch2.y(null);
                    }
                } else if (num != null && num.intValue() == R.id.f165032uo0) {
                    IVasWebUrl iVasWebUrl = (IVasWebUrl) QRoute.api(IVasWebUrl.class);
                    Activity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    if (!iVasWebUrl.gotoLevelPage(activity, QQSettingMeProfileCardPart$onClick$useNewUrl$1.INSTANCE)) {
                        Intent intent = new Intent();
                        intent.putExtra("url", "https://ti.qq.com/qqlevel/index?_wv=3&_wwv=1&tab=7&source=1");
                        RouteUtils.startActivity(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
                    }
                    RedTouch redTouch2 = this.headLevelRedTouch;
                    if (redTouch2 != null) {
                        if (redTouch2 != null && redTouch2.hasRedTouch()) {
                            b16 = true;
                        } else {
                            b16 = false;
                        }
                    }
                    i3 = 0;
                    VideoReport.setElementParam(v3, "is_red_tips_em", Integer.valueOf(i3));
                    VideoReport.reportEvent("clck", v3, null);
                    TianshuRedTouch tianshuRedTouch3 = this.headLevelRedBadge;
                    if (tianshuRedTouch3 != null) {
                        tianshuRedTouch3.y(null);
                    }
                } else if (num != null && num.intValue() == R.id.unw) {
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_head_vip").onClick(v3);
                    VideoReport.setElementParam(v3, "is_red_tips_em", 0);
                    VideoReport.reportEvent("clck", v3, null);
                } else if (num != null && num.intValue() == R.id.unn) {
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_head_vip").onClick(v3);
                } else if (num != null && num.intValue() == R.id.uo7) {
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_head_vip").onClick(v3);
                } else if (num != null && num.intValue() == R.id.un6) {
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_qrcode").onClick(v3);
                    TianshuRedTouch tianshuRedTouch4 = this.qrCodeRedBadge;
                    if (tianshuRedTouch4 != null) {
                        tianshuRedTouch4.y(null);
                    }
                } else if (num != null && num.intValue() == R.id.unv) {
                    ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_nickname").onClick(v3);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        List<View> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.screenHeight = ScreenUtil.getRealHeight(getActivity());
        Ba();
        Ga();
        Ja();
        Ia(rootView);
        Ha(rootView);
        Da();
        Fa();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.headContainer, this.nickNameArea, this.prettyIcon, this.signatureContainer, this.pagLayout, this.gameCardIcon, this.vipPendantIcon, this.level, this.qVipMedalView, this.qrCodeIcon});
        for (View view : listOf) {
            if (view != null) {
                view.setOnClickListener(this);
            }
            if (view != null) {
                view.setOnTouchListener(this);
            }
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
        ta();
        Ka();
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<Integer> mutableLiveData = qQSettingMeViewModel.W;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.topOffset = it.intValue();
                QQSettingMeProfileCardPart.this.ra();
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Pa(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData2 = qQSettingMeViewModel.X;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                URLDrawable uRLDrawable;
                Rect va5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.topOffset = it.intValue();
                uRLDrawable = QQSettingMeProfileCardPart.this.zPlanStaticDrawable;
                if (uRLDrawable == null) {
                    return;
                }
                va5 = QQSettingMeProfileCardPart.this.va();
                uRLDrawable.setBounds(va5);
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.bizParts.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Va(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> R1 = qQSettingMeViewModel.R1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileCardPart.this.hb();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        R1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.bizParts.bc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Wa(Function1.this, obj);
            }
        });
        MutableLiveData<Float> T1 = qQSettingMeViewModel.T1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Float, Unit> function14 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke2(f16);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.zPlanOffset = it.floatValue();
                QQSettingMeProfileCardPart.this.hb();
            }
        };
        T1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.bizParts.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Xa(Function1.this, obj);
            }
        });
        MutableLiveData<BusinessInfoCheckUpdate.AppInfo> mutableLiveData3 = qQSettingMeViewModel.C;
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<BusinessInfoCheckUpdate.AppInfo, Unit> function15 = new Function1<BusinessInfoCheckUpdate.AppInfo, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusinessInfoCheckUpdate.AppInfo appInfo) {
                invoke2(appInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusinessInfoCheckUpdate.AppInfo appInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileCardPart.this.ob(appInfo);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) appInfo);
                }
            }
        };
        mutableLiveData3.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.bizParts.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Ya(Function1.this, obj);
            }
        });
        MutableLiveData<BusinessInfoCheckUpdate.AppInfo> mutableLiveData4 = qQSettingMeViewModel.D;
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<BusinessInfoCheckUpdate.AppInfo, Unit> function16 = new Function1<BusinessInfoCheckUpdate.AppInfo, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusinessInfoCheckUpdate.AppInfo appInfo) {
                invoke2(appInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusinessInfoCheckUpdate.AppInfo appInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileCardPart.this.pb(appInfo);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) appInfo);
                }
            }
        };
        mutableLiveData4.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.bizParts.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Za(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.n> mutableLiveData5 = qQSettingMeViewModel.E;
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.n, Unit> function17 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.n, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.n nVar) {
                invoke2(nVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.n it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.fb(it);
            }
        };
        mutableLiveData5.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.bizParts.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.ab(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.l> mutableLiveData6 = qQSettingMeViewModel.F;
        LifecycleOwner lifecycleOwner8 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.l, Unit> function18 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.l, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.l lVar) {
                invoke2(lVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.l it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.qb(it);
            }
        };
        mutableLiveData6.observe(lifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.bizParts.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.bb(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.g> mutableLiveData7 = qQSettingMeViewModel.G;
        LifecycleOwner lifecycleOwner9 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit> function19 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.g, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$9
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.g it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.kb(it);
            }
        };
        mutableLiveData7.observe(lifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.bizParts.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.cb(Function1.this, obj);
            }
        });
        MutableLiveData<BusinessInfoCheckUpdate.AppInfo> mutableLiveData8 = qQSettingMeViewModel.H;
        LifecycleOwner lifecycleOwner10 = getPartHost().getLifecycleOwner();
        final Function1<BusinessInfoCheckUpdate.AppInfo, Unit> function110 = new Function1<BusinessInfoCheckUpdate.AppInfo, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$10
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusinessInfoCheckUpdate.AppInfo appInfo) {
                invoke2(appInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusinessInfoCheckUpdate.AppInfo appInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileCardPart.this.ib(appInfo);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) appInfo);
                }
            }
        };
        mutableLiveData8.observe(lifecycleOwner10, new Observer() { // from class: com.tencent.mobileqq.bizParts.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Qa(Function1.this, obj);
            }
        });
        MutableLiveData<BusinessInfoCheckUpdate.AppInfo> mutableLiveData9 = qQSettingMeViewModel.I;
        LifecycleOwner lifecycleOwner11 = getPartHost().getLifecycleOwner();
        final Function1<BusinessInfoCheckUpdate.AppInfo, Unit> function111 = new Function1<BusinessInfoCheckUpdate.AppInfo, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$11
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusinessInfoCheckUpdate.AppInfo appInfo) {
                invoke2(appInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusinessInfoCheckUpdate.AppInfo appInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileCardPart.this.jb(appInfo);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) appInfo);
                }
            }
        };
        mutableLiveData9.observe(lifecycleOwner11, new Observer() { // from class: com.tencent.mobileqq.bizParts.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Ra(Function1.this, obj);
            }
        });
        MutableLiveData<String> mutableLiveData10 = qQSettingMeViewModel.L;
        LifecycleOwner lifecycleOwner12 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function112 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$12
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileCardPart.this.lb(str);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                }
            }
        };
        mutableLiveData10.observe(lifecycleOwner12, new Observer() { // from class: com.tencent.mobileqq.bizParts.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Sa(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> mutableLiveData11 = qQSettingMeViewModel.M;
        LifecycleOwner lifecycleOwner13 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit> function113 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$13
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.h it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.mb(it);
            }
        };
        mutableLiveData11.observe(lifecycleOwner13, new Observer() { // from class: com.tencent.mobileqq.bizParts.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Ta(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.i> mutableLiveData12 = qQSettingMeViewModel.N;
        LifecycleOwner lifecycleOwner14 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.i, Unit> function114 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.i, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart$onPartCreate$14
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileCardPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.i iVar) {
                invoke2(iVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.i it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileCardPart qQSettingMeProfileCardPart = QQSettingMeProfileCardPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileCardPart.nb(it);
            }
        };
        mutableLiveData12.observe(lifecycleOwner14, new Observer() { // from class: com.tencent.mobileqq.bizParts.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileCardPart.Ua(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            ThreadManagerV2.getUIHandlerV2().postDelayed(Aa(), 500L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        ra();
        hb();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(Aa());
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView != null) {
            qQBlurView.onResume();
        }
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.bizParts.ar
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeProfileCardPart.eb(QQSettingMeProfileCardPart.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        int color = ContextCompat.getColor(getActivity(), R.color.qui_common_fill_light_tertiary);
        if (je0.a.a(getActivity())) {
            color = ContextCompat.getColor(getActivity(), R.color.cec);
        }
        GradientDrawable gradientDrawable = this.overLayDrawable;
        if (gradientDrawable != null) {
            gradientDrawable.setColors(new int[]{color, ContextCompat.getColor(getActivity(), R.color.qui_common_bg_bottom_standard), ContextCompat.getColor(getActivity(), R.color.qui_common_bg_bottom_standard)});
        }
        hb();
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView != null) {
            qQBlurView.invalidate();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 == null || this.isShowZPlanDrawer) {
            return false;
        }
        int id5 = v3.getId();
        boolean z36 = true;
        if (id5 == R.id.un6 || id5 == R.id.unq) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || id5 == R.id.f165035uo3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || id5 == R.id.uny) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 || id5 == R.id.unv) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19 || id5 == R.id.uo7) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26 || id5 == R.id.unn) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27 || id5 == R.id.unw) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28 || id5 == R.id.f165032uo0) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (!z29 && id5 != R.id.unz) {
            z36 = false;
        }
        if (z36) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(v3, event);
        }
        return false;
    }
}

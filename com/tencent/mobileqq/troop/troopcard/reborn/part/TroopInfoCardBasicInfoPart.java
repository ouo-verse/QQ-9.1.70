package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.android.flexbox.FlexboxLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import com.tencent.mobileqq.troop.flame.detail.view.TroopFlameNameView;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.c;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopAvatarCoverEditViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.ui.ExpandableTextViewWrapper;
import com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.troop.troopmedal.TroopMedalUpdateEventReceiver;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtMedalData;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.state.data.SquareJSConst;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u009f\u00012\u00020\u0001:\u0002\u00a0\u0001B\u0011\u0012\u0006\u0010Q\u001a\u00020L\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u001c\u001a\u00020\u0002*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J(\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0002J\u0016\u0010(\u001a\u00020\u00022\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120&H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010,\u001a\u00020+H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u0010,\u001a\u00020+2\u0006\u0010/\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0002J\b\u00103\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020\u00022\u0006\u0010:\u001a\u000209H\u0002J\u001c\u0010A\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0017H\u0016J\"\u0010H\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00182\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010J\u001a\u00020\u00022\b\u0010I\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010K\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010=H\u0016R\u0017\u0010Q\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010`R\u0016\u0010s\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010`R\u0016\u0010u\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010`R\u0016\u0010w\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010fR\u0016\u0010y\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010fR\u0016\u0010{\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010cR\u0016\u0010}\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010fR\u0018\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008b\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010fR\u001a\u0010\u008d\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u001f\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020^0&8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u008f\u0001R \u0010\u009c\u0001\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardBasicInfoPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "ra", "pa", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/d;", "avatarUIModel", "Ia", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/c$c;", "jumpType", "na", "oa", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/p;", "memberDistributionUIModel", "Oa", "", "troopCreateTime", "Sa", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtMedalData;", "medalData", "qa", "Landroid/view/View;", "", "memberCount", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/o;", "staticInfo", "Qa", "Landroid/widget/TextView;", "percentTv", "percentView", "percentViewFullWidth", "percent", "ga", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/q;", "troopTagUIModel", "Wa", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Na", "intro", "Ta", "Landroid/content/Context;", "context", "ia", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/j;", "troopLevelUIModel", LocaleUtils.L_JAPANESE, "Fa", "", "Da", "troopName", "Ua", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFlameData;", "flameData", "Ma", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/r;", "troopUinUIModel", "Xa", "Ga", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "newIntent", "onNewIntent", "onPartDestroy", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "e", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "basicInfoViewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel;", "f", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopAvatarCoverEditViewModel;", "avatarCoverEditViewModel", "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", tl.h.F, "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "troopShareUtil", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "i", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "troopAvatar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "troopLiveStatusBg", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "troopLiveStatusTv", "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameNameView;", "D", "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameNameView;", "troopNameFlameView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "qrCodeBtn", UserInfo.SEX_FEMALE, "troopMemAvatar1", "G", "troopMemAvatar2", "H", "troopMemAvatar3", "I", "troopMemberCountTv", "J", "troopUinTv", "K", "copyTroopUinBtn", "L", "troopUinDotTv", "Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper;", "M", "Lcom/tencent/mobileqq/troop/troopcard/ui/ExpandableTextViewWrapper;", "troopIntroTv", "Lcom/google/android/flexbox/FlexboxLayout;", "N", "Lcom/google/android/flexbox/FlexboxLayout;", "troopTagsContainer", "Landroidx/appcompat/widget/LinearLayoutCompat;", "P", "Landroidx/appcompat/widget/LinearLayoutCompat;", "memberDistributionLayout", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "createTimeTv", BdhLogUtil.LogTag.Tag_Req, "createTimeContainer", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "troopMemAvatars", "Lcom/tencent/mobileqq/troop/troopmedal/TroopMedalUpdateEventReceiver;", "T", "Lcom/tencent/mobileqq/troop/troopmedal/TroopMedalUpdateEventReceiver;", "medalUpdateEventReceiver", "", "U", "memberDistributionItems", "V", "Lkotlin/Lazy;", "ma", "()Z", "getTroopHeadSwitch", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "W", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardBasicInfoPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView troopLiveStatusTv;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopFlameNameView troopNameFlameView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView qrCodeBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private QQProAvatarView troopMemAvatar1;

    /* renamed from: G, reason: from kotlin metadata */
    private QQProAvatarView troopMemAvatar2;

    /* renamed from: H, reason: from kotlin metadata */
    private QQProAvatarView troopMemAvatar3;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView troopMemberCountTv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView troopUinTv;

    /* renamed from: K, reason: from kotlin metadata */
    private View copyTroopUinBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView troopUinDotTv;

    /* renamed from: M, reason: from kotlin metadata */
    private ExpandableTextViewWrapper troopIntroTv;

    /* renamed from: N, reason: from kotlin metadata */
    private FlexboxLayout troopTagsContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private LinearLayoutCompat memberDistributionLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView createTimeTv;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayoutCompat createTimeContainer;

    /* renamed from: S, reason: from kotlin metadata */
    private List<QQProAvatarView> troopMemAvatars;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final TroopMedalUpdateEventReceiver medalUpdateEventReceiver;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final List<View> memberDistributionItems;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy getTroopHeadSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TroopBasicInfoViewModel basicInfoViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TroopAvatarCoverEditViewModel avatarCoverEditViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ITroopShareUtility troopShareUtil;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView troopAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View troopLiveStatusBg;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardBasicInfoPart$a;", "", "", "PERCENT_ANIM_DURATION", "J", "", "TAG", "Ljava/lang/String;", "", "TROOP_INFO_EXPANDABLE_TEXT_VIEW_MIN_LINES", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57139);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardBasicInfoPart(@NotNull AppInterface appInterface) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.appInterface = appInterface;
        this.medalUpdateEventReceiver = new TroopMedalUpdateEventReceiver();
        this.memberDistributionItems = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(TroopInfoCardBasicInfoPart$getTroopHeadSwitch$2.INSTANCE);
        this.getTroopHeadSwitch = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Da() {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        if (troopBasicInfoViewModel.P2()) {
            com.tencent.mobileqq.troop.utils.ab.c(getActivity());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(TroopInfoCardBasicInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.Da()) {
            this$0.pa();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Fa(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.j troopLevelUIModel) {
        Uri build = Uri.parse("https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151").buildUpon().appendQueryParameter("groupuin", troopLevelUIModel.e()).appendQueryParameter("role", "1").appendQueryParameter("group_level", String.valueOf(troopLevelUIModel.d())).appendQueryParameter("group_mem_num", String.valueOf(troopLevelUIModel.b())).appendQueryParameter("group_active_num", String.valueOf(troopLevelUIModel.a())).appendQueryParameter("show_level", "1").build();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_operation_bar", true);
        bundle.putBoolean(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
        bundle.putBoolean("isScreenOrientationPortrait", true);
        String currentAccountUin = this.appInterface.getCurrentAccountUin();
        if (currentAccountUin == null) {
            currentAccountUin = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appInterface.currentAccountUin ?: \"\"");
        }
        bundle.putString("uin", currentAccountUin);
        bundle.putString("url", build.toString());
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getActivity(), IPublicAccountBrowser.ROUTE_NAME);
        activityURIRequest.extra().putAll(bundle);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    private final void Ga(final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r troopUinUIModel) {
        String string;
        String string2;
        int i3;
        boolean d16 = troopUinUIModel.d();
        boolean b16 = troopUinUIModel.b();
        if (!d16 && !b16) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (d16) {
            string = getActivity().getString(R.string.f2058056l);
        } else {
            string = getActivity().getString(R.string.f2058356o);
        }
        actionSheet.setMainTitle(string);
        if (d16) {
            string2 = getActivity().getString(R.string.f2058156m);
        } else {
            string2 = getActivity().getString(R.string.f2058256n);
        }
        if (d16) {
            i3 = 12;
        } else {
            i3 = 9;
        }
        actionSheet.addButton(new ActionMenuItem(string2, i3, 0), 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.m
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                TroopInfoCardBasicInfoPart.Ha(ActionSheet.this, troopUinUIModel, this, view, i16);
            }
        });
        if (!actionSheet.isShowing()) {
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(ActionSheet this_apply, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r troopUinUIModel, TroopInfoCardBasicInfoPart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(troopUinUIModel, "$troopUinUIModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionMenuItem actionMenuItem = this_apply.getActionMenuItem(i3);
        if (actionMenuItem == null) {
            return;
        }
        int i16 = actionMenuItem.action;
        if (i16 != 9) {
            if (i16 == 12) {
                ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(this$0.getActivity(), TroopInfoActivity.getTroopProfileExtra(troopUinUIModel.a(), 5));
            }
        } else {
            this$0.pa();
        }
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d avatarUIModel) {
        int i3;
        QQProAvatarView qQProAvatarView;
        QQProAvatarView qQProAvatarView2;
        QQProAvatarView qQProAvatarView3;
        QQProAvatarView qQProAvatarView4;
        View view = this.troopLiveStatusBg;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopLiveStatusBg");
            view = null;
        }
        int i16 = 8;
        if (avatarUIModel.d().b()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        TextView textView = this.troopLiveStatusTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopLiveStatusTv");
            textView = null;
        }
        if (avatarUIModel.d().b()) {
            i16 = 0;
        }
        textView.setVisibility(i16);
        QQProAvatarView qQProAvatarView5 = this.troopAvatar;
        if (qQProAvatarView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView5 = null;
        }
        qQProAvatarView5.x(4, avatarUIModel.f(), new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(640).a());
        final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.c a16 = com.tencent.mobileqq.troop.troopcard.reborn.uimodel.e.a(avatarUIModel);
        if (Intrinsics.areEqual(a16, c.d.f299751a)) {
            QQProAvatarView qQProAvatarView6 = this.troopAvatar;
            if (qQProAvatarView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
                qQProAvatarView4 = null;
            } else {
                qQProAvatarView4 = qQProAvatarView6;
            }
            qQProAvatarView4.setClickable(false);
            return;
        }
        if (Intrinsics.areEqual(a16, c.b.f299749a)) {
            QQProAvatarView qQProAvatarView7 = this.troopAvatar;
            if (qQProAvatarView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
                qQProAvatarView3 = null;
            } else {
                qQProAvatarView3 = qQProAvatarView7;
            }
            TriggerRunnerKt.c(qQProAvatarView3, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopInfoCardBasicInfoPart.Ja(TroopInfoCardBasicInfoPart.this, view2);
                }
            }, 1, null);
            return;
        }
        if (a16 instanceof c.C8796c) {
            QQProAvatarView qQProAvatarView8 = this.troopAvatar;
            if (qQProAvatarView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
                qQProAvatarView2 = null;
            } else {
                qQProAvatarView2 = qQProAvatarView8;
            }
            TriggerRunnerKt.c(qQProAvatarView2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopInfoCardBasicInfoPart.Ka(TroopInfoCardBasicInfoPart.this, a16, view2);
                }
            }, 1, null);
            return;
        }
        if (a16 instanceof c.a) {
            QQProAvatarView qQProAvatarView9 = this.troopAvatar;
            if (qQProAvatarView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
                qQProAvatarView = null;
            } else {
                qQProAvatarView = qQProAvatarView9;
            }
            TriggerRunnerKt.c(qQProAvatarView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopInfoCardBasicInfoPart.La(TroopInfoCardBasicInfoPart.this, a16, view2);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(TroopInfoCardBasicInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.Da()) {
            this$0.oa();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(TroopInfoCardBasicInfoPart this$0, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.c jumpType, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpType, "$jumpType");
        if (!this$0.Da()) {
            this$0.na((c.C8796c) jumpType);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(TroopInfoCardBasicInfoPart this$0, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.c jumpType, View view) {
        com.tencent.mobileqq.utils.ax b16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpType, "$jumpType");
        if (!this$0.Da() && (b16 = com.tencent.mobileqq.troop.troopcard.reborn.ktx.b.f299536a.b(((c.a) jumpType).a())) != null) {
            b16.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(GroupExtFlameData flameData) {
        ITroopFlameApi.a flameViewData = ((ITroopFlameApi) QRoute.api(ITroopFlameApi.class)).getFlameViewDataFromPB(flameData);
        TroopFlameNameView troopFlameNameView = this.troopNameFlameView;
        if (troopFlameNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
            troopFlameNameView = null;
        }
        Intrinsics.checkNotNullExpressionValue(flameViewData, "flameViewData");
        troopFlameNameView.e(flameViewData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na(List<String> uinList) {
        QQProAvatarView qQProAvatarView = this.troopMemAvatar1;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatar1");
            qQProAvatarView = null;
        }
        qQProAvatarView.setVisibility(8);
        QQProAvatarView qQProAvatarView2 = this.troopMemAvatar2;
        if (qQProAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatar2");
            qQProAvatarView2 = null;
        }
        qQProAvatarView2.setVisibility(8);
        QQProAvatarView qQProAvatarView3 = this.troopMemAvatar3;
        if (qQProAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatar3");
            qQProAvatarView3 = null;
        }
        qQProAvatarView3.setVisibility(8);
        if (uinList.size() > 3) {
            return;
        }
        int i3 = 0;
        for (Object obj : uinList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            List<QQProAvatarView> list = this.troopMemAvatars;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatars");
                list = null;
            }
            QQProAvatarView qQProAvatarView4 = list.get(i3);
            qQProAvatarView4.setVisibility(0);
            qQProAvatarView4.x(1, str, null);
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p memberDistributionUIModel) {
        LinearLayoutCompat linearLayoutCompat;
        Object orNull;
        LinearLayoutCompat linearLayoutCompat2 = null;
        if (memberDistributionUIModel == null) {
            LinearLayoutCompat linearLayoutCompat3 = this.memberDistributionLayout;
            if (linearLayoutCompat3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberDistributionLayout");
            } else {
                linearLayoutCompat2 = linearLayoutCompat3;
            }
            linearLayoutCompat2.setVisibility(8);
            return;
        }
        LinearLayoutCompat linearLayoutCompat4 = this.memberDistributionLayout;
        if (linearLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberDistributionLayout");
            linearLayoutCompat4 = null;
        }
        boolean z16 = false;
        linearLayoutCompat4.setVisibility(0);
        int i3 = 0;
        for (Object obj : memberDistributionUIModel.b()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.troop.troopcard.reborn.uimodel.o oVar = (com.tencent.mobileqq.troop.troopcard.reborn.uimodel.o) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.memberDistributionItems, i3);
            View view = (View) orNull;
            if (view != null) {
                Qa(view, memberDistributionUIModel.a(), oVar);
            }
            i3 = i16;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        if (troopBasicInfoViewModel.K2().length() > 0) {
            z16 = true;
        }
        if (z16) {
            LinearLayoutCompat linearLayoutCompat5 = this.memberDistributionLayout;
            if (linearLayoutCompat5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberDistributionLayout");
                linearLayoutCompat = null;
            } else {
                linearLayoutCompat = linearLayoutCompat5;
            }
            TriggerRunnerKt.c(linearLayoutCompat, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopInfoCardBasicInfoPart.Pa(TroopInfoCardBasicInfoPart.this, view2);
                }
            }, 1, null);
        }
        LinearLayoutCompat linearLayoutCompat6 = this.memberDistributionLayout;
        if (linearLayoutCompat6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberDistributionLayout");
        } else {
            linearLayoutCompat2 = linearLayoutCompat6;
        }
        TroopCardDtHelper.n(linearLayoutCompat2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(TroopInfoCardBasicInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopBasicInfoViewModel troopBasicInfoViewModel = this$0.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + troopBasicInfoViewModel.K2();
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this$0.getContext(), IPublicAccountBrowser.ROUTE_NAME);
        activityURIRequest.extra().putString("url", str);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Qa(View view, final int i3, final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.o oVar) {
        GradientDrawable gradientDrawable;
        TextView textView = (TextView) view.findViewById(R.id.z1v);
        TextView textView2 = (TextView) view.findViewById(R.id.z1p);
        ImageView imageView = (ImageView) view.findViewById(R.id.z1o);
        final TextView textView3 = (TextView) view.findViewById(R.id.z1u);
        TextView textView4 = (TextView) view.findViewById(R.id.z1t);
        final View findViewById = view.findViewById(R.id.z1r);
        final View findViewById2 = view.findViewById(R.id.z1s);
        Typeface createFromAsset = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
        textView.setText(oVar.b());
        textView2.setText(oVar.a() + "\u4eba");
        imageView.setImageDrawable(cn.f(ContextCompat.getDrawable(imageView.getContext(), oVar.c().getIconRes())));
        imageView.setColorFilter(oVar.c().getTextColor());
        textView3.setTextColor(oVar.c().getTextColor());
        textView4.setTextColor(oVar.c().getTextColor());
        textView4.setTypeface(Typeface.create(createFromAsset, 1));
        textView3.setTypeface(createFromAsset);
        Drawable background = findViewById.getBackground();
        if (background instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) background;
        } else {
            gradientDrawable = null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(oVar.c().getProcessColor());
        }
        findViewById2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.k
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoCardBasicInfoPart.Ra(findViewById2, this, textView3, findViewById, oVar, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(View view, TroopInfoCardBasicInfoPart this$0, TextView percentTv, View progressView, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.o staticInfo, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(staticInfo, "$staticInfo");
        int measuredWidth = view.getMeasuredWidth();
        if (measuredWidth > 0) {
            Intrinsics.checkNotNullExpressionValue(percentTv, "percentTv");
            Intrinsics.checkNotNullExpressionValue(progressView, "progressView");
            this$0.ga(percentTv, progressView, measuredWidth, (staticInfo.a() * 100) / i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa(long troopCreateTime) {
        if (troopCreateTime > 0) {
            String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(Long.valueOf(troopCreateTime * 1000));
            LinearLayoutCompat linearLayoutCompat = this.createTimeContainer;
            TextView textView = null;
            if (linearLayoutCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createTimeContainer");
                linearLayoutCompat = null;
            }
            linearLayoutCompat.setVisibility(0);
            TextView textView2 = this.createTimeTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createTimeTv");
            } else {
                textView = textView2;
            }
            textView.setText(getContext().getString(R.string.f212185mu, format));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta(String intro) {
        boolean z16;
        if (intro.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ExpandableTextViewWrapper expandableTextViewWrapper = null;
        if (z16) {
            ExpandableTextViewWrapper expandableTextViewWrapper2 = this.troopIntroTv;
            if (expandableTextViewWrapper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopIntroTv");
            } else {
                expandableTextViewWrapper = expandableTextViewWrapper2;
            }
            expandableTextViewWrapper.u(8);
            return;
        }
        ExpandableTextViewWrapper expandableTextViewWrapper3 = this.troopIntroTv;
        if (expandableTextViewWrapper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopIntroTv");
            expandableTextViewWrapper3 = null;
        }
        expandableTextViewWrapper3.u(0);
        ExpandableTextViewWrapper expandableTextViewWrapper4 = this.troopIntroTv;
        if (expandableTextViewWrapper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopIntroTv");
        } else {
            expandableTextViewWrapper = expandableTextViewWrapper4;
        }
        expandableTextViewWrapper.t(intro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua(String troopName) {
        final TroopInfo i3;
        TroopFlameNameView troopFlameNameView;
        TroopInfo i16;
        GroupExt groupExt;
        TroopFlameNameView troopFlameNameView2 = this.troopNameFlameView;
        GroupExtMedalData groupExtMedalData = null;
        if (troopFlameNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
            troopFlameNameView2 = null;
        }
        troopFlameNameView2.f(troopName);
        TroopFlameNameView troopFlameNameView3 = this.troopNameFlameView;
        if (troopFlameNameView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
            troopFlameNameView3 = null;
        }
        troopFlameNameView3.setContentDescription(HardCodeUtil.qqStr(R.string.kgk) + troopName);
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null && (i3 = D2.i()) != null) {
            TroopFlameNameView troopFlameNameView4 = this.troopNameFlameView;
            if (troopFlameNameView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
                troopFlameNameView = null;
            } else {
                troopFlameNameView = troopFlameNameView4;
            }
            TriggerRunnerKt.c(troopFlameNameView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBasicInfoPart.Va(TroopInfoCardBasicInfoPart.this, i3, view);
                }
            }, 1, null);
            if (!i3.isNewTroop && !i3.isQidianPrivateTroop()) {
                String qqStr = HardCodeUtil.qqStr(R.string.aep);
                TroopFlameNameView troopFlameNameView5 = this.troopNameFlameView;
                if (troopFlameNameView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
                    troopFlameNameView5 = null;
                }
                LongClickCopyAction.attachCopyAction(troopFlameNameView5, qqStr, troopName).setCopyListener(new LongClickCopyAction.ToastCopyListener(getContext(), R.string.zov));
            }
            TroopFlameNameView troopFlameNameView6 = this.troopNameFlameView;
            if (troopFlameNameView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
                troopFlameNameView6 = null;
            }
            com.tencent.mobileqq.troop.troopmedal.a aVar = com.tencent.mobileqq.troop.troopmedal.a.f300588a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
            if (troopBasicInfoViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                troopBasicInfoViewModel2 = null;
            }
            com.tencent.mobileqq.troop.data.v D22 = troopBasicInfoViewModel2.D2();
            if (D22 != null && (i16 = D22.i()) != null && (groupExt = i16.groupExt) != null) {
                groupExtMedalData = groupExt.groupExtMedalData;
            }
            troopFlameNameView6.g(aVar.a(context, groupExtMedalData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(TroopInfoCardBasicInfoPart this$0, TroopInfo troopInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        if (!this$0.Da()) {
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.b bVar = com.tencent.mobileqq.troop.troopcard.reborn.ktx.b.f299536a;
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            TroopBasicInfoViewModel troopBasicInfoViewModel = this$0.basicInfoViewModel;
            if (troopBasicInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                troopBasicInfoViewModel = null;
            }
            String r26 = troopBasicInfoViewModel.r2();
            if (r26 == null) {
                r26 = "";
            }
            bVar.a(activity, troopInfo, r26);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q troopTagUIModel) {
        List<String> b16 = troopTagUIModel.b();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View ja5 = ja(context, troopTagUIModel.c());
        FlexboxLayout flexboxLayout = null;
        if (b16.isEmpty() && !troopTagUIModel.a() && ja5 == null) {
            FlexboxLayout flexboxLayout2 = this.troopTagsContainer;
            if (flexboxLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
            } else {
                flexboxLayout = flexboxLayout2;
            }
            flexboxLayout.setVisibility(8);
            return;
        }
        FlexboxLayout flexboxLayout3 = this.troopTagsContainer;
        if (flexboxLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
            flexboxLayout3 = null;
        }
        flexboxLayout3.setVisibility(0);
        FlexboxLayout flexboxLayout4 = this.troopTagsContainer;
        if (flexboxLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
            flexboxLayout4 = null;
        }
        flexboxLayout4.removeAllViews();
        if (ja5 != null) {
            FlexboxLayout flexboxLayout5 = this.troopTagsContainer;
            if (flexboxLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
                flexboxLayout5 = null;
            }
            flexboxLayout5.addView(ja5);
        }
        if (troopTagUIModel.a()) {
            FlexboxLayout flexboxLayout6 = this.troopTagsContainer;
            if (flexboxLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
                flexboxLayout6 = null;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            flexboxLayout6.addView(ia(context2));
        }
        for (String str : b16) {
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(4.0f), com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(4.0f));
            TextView textView = new TextView(getContext());
            textView.setId(View.generateViewId());
            textView.setLayoutParams(layoutParams);
            textView.setPadding(com.tencent.mobileqq.utils.am.a(6.0f), com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(6.0f), com.tencent.mobileqq.utils.am.a(3.0f));
            textView.setGravity(17);
            textView.setBackground(AppCompatResources.getDrawable(textView.getContext(), R.drawable.f161912kz4));
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
            textView.setTextSize(1, 10.0f);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            FlexboxLayout flexboxLayout7 = this.troopTagsContainer;
            if (flexboxLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
                flexboxLayout7 = null;
            }
            flexboxLayout7.addView(textView);
        }
        FlexboxLayout flexboxLayout8 = this.troopTagsContainer;
        if (flexboxLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopTagsContainer");
        } else {
            flexboxLayout = flexboxLayout8;
        }
        com.tencent.mobileqq.utils.am.b(flexboxLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa(final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r troopUinUIModel) {
        int i3;
        View view;
        TextView textView;
        TextView textView2 = this.troopUinTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView2 = null;
        }
        int i16 = 0;
        if (troopUinUIModel.e()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView2.setVisibility(i3);
        TextView textView3 = this.troopUinDotTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinDotTv");
            textView3 = null;
        }
        if (!troopUinUIModel.e()) {
            i16 = 8;
        }
        textView3.setVisibility(i16);
        TextView textView4 = this.troopUinTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView4 = null;
        }
        textView4.setText("\u7fa4\u53f7\uff1a" + troopUinUIModel.a());
        TextView textView5 = this.troopUinTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView5 = null;
        }
        textView5.setClickable(troopUinUIModel.c());
        if (troopUinUIModel.c()) {
            TextView textView6 = this.troopUinTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
                textView = null;
            } else {
                textView = textView6;
            }
            TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopInfoCardBasicInfoPart.Ya(TroopInfoCardBasicInfoPart.this, troopUinUIModel, view2);
                }
            }, 1, null);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.aep);
        final String a16 = troopUinUIModel.a();
        TextView textView7 = this.troopUinTv;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinTv");
            textView7 = null;
        }
        LongClickCopyAction.attachCopyAction(textView7, qqStr, a16).setCopyListener(new LongClickCopyAction.ToastCopyListener(getContext(), R.string.zow));
        View view2 = this.copyTroopUinBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("copyTroopUinBtn");
            view = null;
        } else {
            view = view2;
        }
        TriggerRunnerKt.c(view, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TroopInfoCardBasicInfoPart.Za(TroopInfoCardBasicInfoPart.this, a16, view3);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(TroopInfoCardBasicInfoPart this$0, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r troopUinUIModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUinUIModel, "$troopUinUIModel");
        this$0.Ga(troopUinUIModel);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(TroopInfoCardBasicInfoPart this$0, String copyContent, View view) {
        ClipboardManager clipboardManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(copyContent, "$copyContent");
        Object systemService = this$0.getActivity().getSystemService("clipboard");
        if (systemService instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) systemService;
        } else {
            clipboardManager = null;
        }
        ClipData newPlainText = ClipData.newPlainText("troop_uin", copyContent);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
        }
        QQToast.makeText(this$0.getContext(), 2, R.string.zow, 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ga(final TextView percentTv, final View percentView, final int percentViewFullWidth, int percent) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, percent);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopInfoCardBasicInfoPart.ha(percentTv, percentViewFullWidth, percentView, valueAnimator);
            }
        });
        ofInt.setDuration(800L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(TextView percentTv, int i3, View percentView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(percentTv, "$percentTv");
        Intrinsics.checkNotNullParameter(percentView, "$percentView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (!Intrinsics.areEqual(percentTv.getText().toString(), String.valueOf(intValue))) {
            percentTv.setText(String.valueOf(intValue));
            ViewGroup.LayoutParams layoutParams = percentView.getLayoutParams();
            layoutParams.width = (i3 * intValue) / 100;
            percentView.setLayoutParams(layoutParams);
        }
    }

    private final View ia(Context context) {
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(4.0f), com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(4.0f));
        TextView textView = new TextView(context);
        textView.setId(View.generateViewId());
        textView.setGravity(17);
        textView.setPadding(com.tencent.mobileqq.utils.am.a(6.0f), com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(6.0f), com.tencent.mobileqq.utils.am.a(3.0f));
        textView.setTextColor(Color.parseColor("#FF5967"));
        textView.setTextSize(1, 10.0f);
        textView.setText(context.getResources().getString(R.string.f181053cq));
        textView.setContentDescription(context.getResources().getString(R.string.f181053cq));
        textView.setBackgroundResource(R.drawable.k6w);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private final View ja(Context context, final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.j troopLevelUIModel) {
        int d16 = troopLevelUIModel.d();
        if (troopLevelUIModel.c() && d16 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getActivity().getResources().getString(R.string.bxg);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026.string.info_troop_level)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(d16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(4.0f), com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(4.0f));
            TextView textView = new TextView(context);
            textView.setId(View.generateViewId());
            textView.setGravity(17);
            textView.setPadding(com.tencent.mobileqq.utils.am.a(6.0f), com.tencent.mobileqq.utils.am.a(3.0f), com.tencent.mobileqq.utils.am.a(6.0f), com.tencent.mobileqq.utils.am.a(3.0f));
            textView.setTextColor(Color.parseColor("#0099FF"));
            textView.setTextSize(1, 10.0f);
            textView.setText(format);
            textView.setContentDescription(format);
            textView.setBackgroundResource(R.drawable.lwl);
            textView.setLayoutParams(layoutParams);
            TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBasicInfoPart.la(TroopInfoCardBasicInfoPart.this, troopLevelUIModel, view);
                }
            }, 1, null);
            return textView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(TroopInfoCardBasicInfoPart this$0, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.j troopLevelUIModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopLevelUIModel, "$troopLevelUIModel");
        this$0.Fa(troopLevelUIModel);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean ma() {
        return ((Boolean) this.getTroopHeadSwitch.getValue()).booleanValue();
    }

    private final void na(c.C8796c jumpType) {
        TroopInfo i3;
        boolean z16;
        TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel;
        List listOf;
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null && (i3 = D2.i()) != null) {
            QVipBigTroopExpiredConfig config = QVipBigTroopExpiredProcessor.getConfig();
            if (i3.isOwnerOrAdmin() && i3.hadJoinTroop()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && config.mIsEnable && i3.mIsFreezed == 1 && i3.isOwnerOrAdmin()) {
                ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).freezedLiangGroup(getActivity(), i3);
                return;
            }
            TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel2 = this.avatarCoverEditViewModel;
            if (troopAvatarCoverEditViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarCoverEditViewModel");
                troopAvatarCoverEditViewModel = null;
            } else {
                troopAvatarCoverEditViewModel = troopAvatarCoverEditViewModel2;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            TroopAvatarCoverEditViewModel.TroopAvatarCoverType troopAvatarCoverType = TroopAvatarCoverEditViewModel.TroopAvatarCoverType.AVATAR;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(jumpType.a());
            TroopAvatarCoverEditViewModel.Q1(troopAvatarCoverEditViewModel, activity, troopAvatarCoverType, z16, i3, listOf, 0, null, null, 224, null);
        }
    }

    private final void oa() {
        TroopInfo i3;
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null && (i3 = D2.i()) != null) {
            if ((i3.dwGroupFlagExt & 2048) != 0) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
                createCustomDialog.setTitle((String) null);
                createCustomDialog.setMessage(getActivity().getResources().getString(R.string.bu6));
                createCustomDialog.setPositiveButton(getActivity().getResources().getString(R.string.buu), new DialogUtil.DialogOnClickAdapter());
                createCustomDialog.setPositiveButtonContentDescription(getActivity().getResources().getString(R.string.buu));
                createCustomDialog.show();
                return;
            }
            TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel2 = this.avatarCoverEditViewModel;
            if (troopAvatarCoverEditViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarCoverEditViewModel");
            } else {
                troopAvatarCoverEditViewModel = troopAvatarCoverEditViewModel2;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            troopAvatarCoverEditViewModel.T1(activity, TroopAvatarCoverEditViewModel.TroopAvatarCoverType.AVATAR);
        }
    }

    private final void pa() {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        ITroopShareUtility iTroopShareUtility = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 == null) {
            return;
        }
        ITroopShareUtility iTroopShareUtility2 = this.troopShareUtil;
        if (iTroopShareUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopShareUtil");
        } else {
            iTroopShareUtility = iTroopShareUtility2;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.a.a(iTroopShareUtility, activity, D2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(String troopUin, GroupExtMedalData medalData) {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        TroopFlameNameView troopFlameNameView = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        if (Intrinsics.areEqual(troopUin, troopBasicInfoViewModel.K2()) && medalData != null) {
            TroopFlameNameView troopFlameNameView2 = this.troopNameFlameView;
            if (troopFlameNameView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
            } else {
                troopFlameNameView = troopFlameNameView2;
            }
            com.tencent.mobileqq.troop.troopmedal.a aVar = com.tencent.mobileqq.troop.troopmedal.a.f300588a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            troopFlameNameView.g(aVar.a(context, medalData));
        }
    }

    private final void ra() {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d> z26 = troopBasicInfoViewModel.z2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d, Unit> function1 = new Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Ia(it);
            }
        };
        z26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.ua(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel3 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel3 = null;
        }
        LiveData<String> I2 = troopBasicInfoViewModel3.I2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Ua(it);
            }
        };
        I2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.va(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel4 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel4 = null;
        }
        LiveData<GroupExtFlameData> C2 = troopBasicInfoViewModel4.C2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<GroupExtFlameData, Unit> function13 = new Function1<GroupExtFlameData, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupExtFlameData groupExtFlameData) {
                invoke2(groupExtFlameData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupExtFlameData it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Ma(it);
            }
        };
        C2.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.wa(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel5 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel5 = null;
        }
        LiveData<List<String>> G2 = troopBasicInfoViewModel5.G2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends String>, Unit> function14 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Na(it);
            }
        };
        G2.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.xa(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel6 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel6 = null;
        }
        LiveData<Integer> H2 = troopBasicInfoViewModel6.H2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function15 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                textView = TroopInfoCardBasicInfoPart.this.troopMemberCountTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopMemberCountTv");
                    textView = null;
                }
                textView.setText(num + "\u4eba");
            }
        };
        H2.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.za(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel7 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel7 = null;
        }
        LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r> L2 = troopBasicInfoViewModel7.L2();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r, Unit> function16 = new Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r rVar) {
                invoke2(rVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Xa(it);
            }
        };
        L2.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.Aa(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel8 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel8 = null;
        }
        LiveData<String> E2 = troopBasicInfoViewModel8.E2();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function17 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Ta(it);
            }
        };
        E2.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.Ba(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel9 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel9 = null;
        }
        LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q> J2 = troopBasicInfoViewModel9.J2();
        LifecycleOwner lifecycleOwner8 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q, Unit> function18 = new Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q qVar) {
                invoke2(qVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Wa(it);
            }
        };
        J2.observe(lifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.Ca(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel10 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel10 = null;
        }
        LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p> F2 = troopBasicInfoViewModel10.F2();
        LifecycleOwner lifecycleOwner9 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p, Unit> function19 = new Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$9
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p pVar) {
                invoke2(pVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p pVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TroopInfoCardBasicInfoPart.this.Oa(pVar);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) pVar);
                }
            }
        };
        F2.observe(lifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.sa(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel11 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
        } else {
            troopBasicInfoViewModel2 = troopBasicInfoViewModel11;
        }
        LiveData<Long> B2 = troopBasicInfoViewModel2.B2();
        LifecycleOwner lifecycleOwner10 = getPartHost().getLifecycleOwner();
        final Function1<Long, Unit> function110 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$10
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopInfoCardBasicInfoPart troopInfoCardBasicInfoPart = TroopInfoCardBasicInfoPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardBasicInfoPart.Sa(it.longValue());
            }
        };
        B2.observe(lifecycleOwner10, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardBasicInfoPart.ta(Function1.this, obj);
            }
        });
        this.medalUpdateEventReceiver.a(new Function2<String, GroupExtMedalData, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart$initObserver$11
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardBasicInfoPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, GroupExtMedalData groupExtMedalData) {
                invoke2(str, groupExtMedalData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String troopUin, @Nullable GroupExtMedalData groupExtMedalData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) groupExtMedalData);
                } else {
                    Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                    TroopInfoCardBasicInfoPart.this.qa(troopUin, groupExtMedalData);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i("TroopInfoCardBasicInfoPart", 1, "onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel = null;
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = null;
        TroopBasicInfoViewModel troopBasicInfoViewModel3 = null;
        if (requestCode != 18) {
            if (requestCode != 20) {
                if (requestCode != 260) {
                    if (requestCode != 257) {
                        if (requestCode != 258) {
                            return;
                        }
                    } else {
                        if (resultCode == -1) {
                            TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel2 = this.avatarCoverEditViewModel;
                            if (troopAvatarCoverEditViewModel2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("avatarCoverEditViewModel");
                            } else {
                                troopAvatarCoverEditViewModel = troopAvatarCoverEditViewModel2;
                            }
                            Activity activity = getActivity();
                            Intrinsics.checkNotNullExpressionValue(activity, "activity");
                            troopAvatarCoverEditViewModel.S1(activity);
                            return;
                        }
                        if (resultCode != 0) {
                            QQToast.makeText(getContext(), 1, R.string.dpu, 0).show();
                            return;
                        }
                        return;
                    }
                }
                TroopBasicInfoViewModel troopBasicInfoViewModel4 = this.basicInfoViewModel;
                if (troopBasicInfoViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                } else {
                    troopBasicInfoViewModel2 = troopBasicInfoViewModel4;
                }
                troopBasicInfoViewModel2.l3();
                return;
            }
            if (resultCode != -1) {
                return;
            }
            TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
            TroopBasicInfoViewModel troopBasicInfoViewModel5 = this.basicInfoViewModel;
            if (troopBasicInfoViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                troopBasicInfoViewModel5 = null;
            }
            TroopInfo troopInfoFromCache = troopInfoRepo.getTroopInfoFromCache(troopBasicInfoViewModel5.K2());
            if (troopInfoFromCache != null) {
                TroopBasicInfoViewModel troopBasicInfoViewModel6 = this.basicInfoViewModel;
                if (troopBasicInfoViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                    troopBasicInfoViewModel6 = null;
                }
                troopBasicInfoViewModel6.m3(troopInfoFromCache);
            }
            TroopBasicInfoViewModel troopBasicInfoViewModel7 = this.basicInfoViewModel;
            if (troopBasicInfoViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            } else {
                troopBasicInfoViewModel3 = troopBasicInfoViewModel7;
            }
            troopBasicInfoViewModel3.l3();
            return;
        }
        if (resultCode == -1 && data != null) {
            if (!NetworkUtil.isNetworkAvailable(getContext())) {
                QQToast.makeText(getContext(), 1, R.string.ci5, 0).show();
                return;
            }
            String stringExtra = data.getStringExtra("result");
            if (stringExtra == null) {
                stringExtra = "";
            }
            TroopBasicInfoViewModel troopBasicInfoViewModel8 = this.basicInfoViewModel;
            if (troopBasicInfoViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            } else {
                troopBasicInfoViewModel = troopBasicInfoViewModel8;
            }
            troopBasicInfoViewModel.n3(stringExtra);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        List<QQProAvatarView> listOf;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.a38);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.avatar_iv)");
        this.troopAvatar = (QQProAvatarView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ym8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.live_status_bg)");
        this.troopLiveStatusBg = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ym9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.live_status_tv)");
        this.troopLiveStatusTv = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f102915z7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.troop_name_ll)");
        this.troopNameFlameView = (TroopFlameNameView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f646636u);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.qr_code_btn)");
        this.qrCodeBtn = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.z1g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.member_avatar_1)");
        this.troopMemAvatar1 = (QQProAvatarView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.z1h);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.member_avatar_2)");
        this.troopMemAvatar2 = (QQProAvatarView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.z1i);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.member_avatar_3)");
        this.troopMemAvatar3 = (QQProAvatarView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.f102605yc);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.troop_member_count_tv)");
        this.troopMemberCountTv = (TextView) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.f10397622);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.troop_uin_tv)");
        this.troopUinTv = (TextView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.u9p);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.copy_troop_uin_btn)");
        this.copyTroopUinBtn = findViewById11;
        View findViewById12 = rootView.findViewById(R.id.ukm);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.id.dot_tv)");
        this.troopUinDotTv = (TextView) findViewById12;
        View findViewById13 = rootView.findViewById(R.id.bzm);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.id.expandable_text)");
        String string = getContext().getString(R.string.f2343679r);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026troop_info_expand_string)");
        String string2 = getContext().getString(R.string.f2343579q);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026oop_info_contract_string)");
        this.troopIntroTv = new ExpandableTextViewWrapper((TextView) findViewById13, 3, string, string2, null, null, 48, null);
        View findViewById14 = rootView.findViewById(R.id.f1037161c);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.id.troop_tag_container)");
        this.troopTagsContainer = (FlexboxLayout) findViewById14;
        View findViewById15 = rootView.findViewById(R.id.f101545vh);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "rootView.findViewById(R.id.troop_create_time_tv)");
        this.createTimeTv = (TextView) findViewById15;
        View findViewById16 = rootView.findViewById(R.id.f164931ub4);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "rootView.findViewById(R.id.create_time_container)");
        this.createTimeContainer = (LinearLayoutCompat) findViewById16;
        QQProAvatarView[] qQProAvatarViewArr = new QQProAvatarView[3];
        QQProAvatarView qQProAvatarView = this.troopMemAvatar1;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatar1");
            qQProAvatarView = null;
        }
        qQProAvatarViewArr[0] = qQProAvatarView;
        QQProAvatarView qQProAvatarView2 = this.troopMemAvatar2;
        if (qQProAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatar2");
            qQProAvatarView2 = null;
        }
        qQProAvatarViewArr[1] = qQProAvatarView2;
        QQProAvatarView qQProAvatarView3 = this.troopMemAvatar3;
        if (qQProAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatar3");
            qQProAvatarView3 = null;
        }
        qQProAvatarViewArr[2] = qQProAvatarView3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) qQProAvatarViewArr);
        this.troopMemAvatars = listOf;
        View findViewById17 = rootView.findViewById(R.id.z1w);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "rootView.findViewById(R.\u2026mber_distribution_layout)");
        this.memberDistributionLayout = (LinearLayoutCompat) findViewById17;
        View distributionItem1 = rootView.findViewById(R.id.z1k);
        View distributionItem2 = rootView.findViewById(R.id.z1l);
        View distributionItem3 = rootView.findViewById(R.id.z1m);
        View distributionItem4 = rootView.findViewById(R.id.z1n);
        List<View> list = this.memberDistributionItems;
        Intrinsics.checkNotNullExpressionValue(distributionItem1, "distributionItem1");
        list.add(distributionItem1);
        List<View> list2 = this.memberDistributionItems;
        Intrinsics.checkNotNullExpressionValue(distributionItem2, "distributionItem2");
        list2.add(distributionItem2);
        List<View> list3 = this.memberDistributionItems;
        Intrinsics.checkNotNullExpressionValue(distributionItem3, "distributionItem3");
        list3.add(distributionItem3);
        List<View> list4 = this.memberDistributionItems;
        Intrinsics.checkNotNullExpressionValue(distributionItem4, "distributionItem4");
        list4.add(distributionItem4);
        ra();
        ImageView imageView2 = this.qrCodeBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeBtn");
            imageView2 = null;
        }
        TroopCardDtHelper.r(imageView2);
        TroopFlameNameView troopFlameNameView = this.troopNameFlameView;
        if (troopFlameNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopNameFlameView");
            troopFlameNameView = null;
        }
        TroopCardDtHelper.y(troopFlameNameView);
        QQProAvatarView qQProAvatarView4 = this.troopAvatar;
        if (qQProAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView4 = null;
        }
        TroopCardDtHelper.w(qQProAvatarView4);
        ImageView imageView3 = this.qrCodeBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qrCodeBtn");
            imageView = null;
        } else {
            imageView = imageView3;
        }
        TriggerRunnerKt.c(imageView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopInfoCardBasicInfoPart.Ea(TroopInfoCardBasicInfoPart.this, view);
            }
        }, 1, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@Nullable Intent newIntent) {
        String str;
        String str2;
        TroopInfo troopInfo;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel = null;
        if (newIntent != null) {
            str = newIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        } else {
            str = null;
        }
        if (newIntent != null) {
            str2 = newIntent.getStringExtra(ITroopPhotoUtilsApi.KEY_CLIP_INFO);
        } else {
            str2 = null;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null) {
            troopInfo = D2.i();
        } else {
            troopInfo = null;
        }
        if (troopInfo != null) {
            str3 = troopInfo.troopuin;
        } else {
            str3 = null;
        }
        boolean z16 = true;
        QLog.i("TroopInfoCardBasicInfoPart", 1, "onNewIntent path=" + str + " troopUin=" + str3);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16 && troopInfo != null) {
            TroopAvatarCoverEditViewModel troopAvatarCoverEditViewModel2 = this.avatarCoverEditViewModel;
            if (troopAvatarCoverEditViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarCoverEditViewModel");
            } else {
                troopAvatarCoverEditViewModel = troopAvatarCoverEditViewModel2;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            troopAvatarCoverEditViewModel.R1(activity, troopInfo, str, str2);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        TroopInfo i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QRouteApi api = QRoute.api(ITroopShareUtility.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopShareUtility::class.java)");
        this.troopShareUtil = (ITroopShareUtility) api;
        ViewModel viewModel = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.basicInfoViewModel = (TroopBasicInfoViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TroopAvatarCoverEditViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopAvatar\u2026ditViewModel::class.java)");
        this.avatarCoverEditViewModel = (TroopAvatarCoverEditViewModel) viewModel2;
        if (ma()) {
            TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
            TroopBasicInfoViewModel troopBasicInfoViewModel2 = null;
            if (troopBasicInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                troopBasicInfoViewModel = null;
            }
            com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
            boolean z16 = false;
            if (D2 != null && (i3 = D2.i()) != null && !i3.isNewTroop) {
                z16 = true;
            }
            if (z16) {
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarHandlerService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026nstant.MAIN\n            )");
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) runtimeService;
                TroopBasicInfoViewModel troopBasicInfoViewModel3 = this.basicInfoViewModel;
                if (troopBasicInfoViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                } else {
                    troopBasicInfoViewModel2 = troopBasicInfoViewModel3;
                }
                iQQAvatarHandlerService.getTroopHead(troopBasicInfoViewModel2.K2());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        ITroopShareUtility iTroopShareUtility = this.troopShareUtil;
        if (iTroopShareUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopShareUtil");
            iTroopShareUtility = null;
        }
        iTroopShareUtility.onDestroy();
        this.medalUpdateEventReceiver.b();
    }
}

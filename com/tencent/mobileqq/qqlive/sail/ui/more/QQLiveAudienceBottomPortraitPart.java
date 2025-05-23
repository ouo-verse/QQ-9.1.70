package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
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
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.game.GameRecommendViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.BottomButtonView;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.ButtonLoadingView;
import com.tencent.mobileqq.qqlive.widget.countdown.CountDownView;
import com.tencent.mobileqq.qqlive.widget.reddot.RedDotView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0097\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0098\u0001B\t\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u0014H\u0002J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0004H\u0002J\u001c\u0010.\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00100\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00101\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u00102\u001a\u00020\u0010H\u0014J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0012\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000209H\u0016J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020\u0006H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\u0012\u0010B\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u000103H\u0016R\u0018\u0010E\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010KR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010WR\u0018\u0010^\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010WR\u0018\u0010`\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010WR\u001e\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010DR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020t0s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u001d\u0010\u0081\u0001\u001a\u00020|8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0086\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0083\u0001\u0010~\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u008b\u0001\u001a\u00030\u0087\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0088\u0001\u0010~\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u0090\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008d\u0001\u0010~\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u0099\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomPortraitPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lar4/a;", "data", "", "bb", "jb", "", "giftId", "ab", "Xa", "", "isPackageGift", "Ya", "", "seconds", "eb", "gb", "", "buttonId", "Ma", "cb", "fb", WadlProxyConsts.KEY_JUMP_URL, "", "webRatio", "webTrans", "Za", "Luq4/c;", "rsp", "ib", UinConfigManager.KEY_HB, "Na", "url", "Lcom/tencent/biz/ui/TouchWebView;", "Ga", "eventId", "Fa", "bubble", "Ea", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartDestroy", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "U9", "V9", "v", NodeProps.ON_CLICK, "e", "Landroid/view/View;", "inputPlaceHolder", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "bottomBar", tl.h.F, "Z", "isUILandscape", "i", "Lcom/tencent/biz/ui/TouchWebView;", "gameWebView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Luq4/c;", "dynamicConfigRsp", BdhLogUtil.LogTag.Tag_Conn, "hasReceiveConfig", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "D", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "button1", "E", "button2", UserInfo.SEX_FEMALE, "button3", "G", "button4", "H", "button5", "", "I", "Ljava/util/List;", "buttonList", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/ButtonLoadingView;", "J", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/ButtonLoadingView;", "buttonLoadingView", "Lcom/tencent/mobileqq/qqlive/widget/countdown/CountDownView;", "K", "Lcom/tencent/mobileqq/qqlive/widget/countdown/CountDownView;", "countDownView", "L", "redDotGuideView", "Lcom/tencent/mobileqq/qqlive/widget/reddot/RedDotView;", "M", "Lcom/tencent/mobileqq/qqlive/widget/reddot/RedDotView;", "redDotView", "", "Luq4/e;", "N", "[Luq4/e;", "btnDataArray", "Lcom/tencent/mobileqq/widget/tip/a;", "P", "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Ka", "()Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "inputViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", BdhLogUtil.LogTag.Tag_Req, "Ja", "()Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "giftViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", ExifInterface.LATITUDE_SOUTH, "Ia", "()Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "gameViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "T", "Ha", "()Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "bottomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "La", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", "U", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceBottomPortraitPart extends com.tencent.mobileqq.qqlive.sail.base.c implements View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasReceiveConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button1;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button2;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button3;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button4;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private BottomButtonView button5;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<BottomButtonView> buttonList;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ButtonLoadingView buttonLoadingView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private CountDownView countDownView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View redDotGuideView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private RedDotView redDotView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private uq4.e[] btnDataArray;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.tip.a bubbleTip;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy giftViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy bottomViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View inputPlaceHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup bottomBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isUILandscape;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TouchWebView gameWebView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private uq4.c dynamicConfigRsp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomPortraitPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomPortraitPart$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ar4.a f272863a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveAudienceBottomPortraitPart f272864b;

        b(ar4.a aVar, QQLiveAudienceBottomPortraitPart qQLiveAudienceBottomPortraitPart) {
            this.f272863a = aVar;
            this.f272864b = qQLiveAudienceBottomPortraitPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) qQLiveAudienceBottomPortraitPart);
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
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomPortraitPart", "showGuideBubbleTip onDismiss", "bubbleTip=" + this.f272863a.f26812c);
            this.f272864b.Ha().P1(this.f272863a);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomPortraitPart", "showGuideBubbleTip onShow", "bubbleTip=" + this.f272863a.f26812c);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/QQLiveAudienceBottomPortraitPart$c", "Lcom/tencent/mobileqq/qqlive/widget/countdown/CountDownView$a;", "", "onFinish", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements CountDownView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownView f272865a;

        c(CountDownView countDownView) {
            this.f272865a = countDownView;
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
                this.f272865a.setVisibility(4);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAudienceBottomPortraitPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.buttonList = new ArrayList();
        this.btnDataArray = new uq4.e[0];
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.input.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$inputViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.input.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.input.a) QQLiveAudienceBottomPortraitPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.input.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.input.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.inputViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GiftViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$giftViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GiftViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GiftViewModel) QQLiveAudienceBottomPortraitPart.this.getViewModel(GiftViewModel.class) : (GiftViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.giftViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GameRecommendViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$gameViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GameRecommendViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GameRecommendViewModel) QQLiveAudienceBottomPortraitPart.this.getViewModel(GameRecommendViewModel.class) : (GameRecommendViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.gameViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.more.b>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$bottomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (b) QQLiveAudienceBottomPortraitPart.this.getViewModel(b.class) : (b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.bottomViewModel = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(ar4.a bubble) {
        com.tencent.mobileqq.qqlive.sail.ui.more.b Ha = Ha();
        String str = bubble.f26811b;
        Intrinsics.checkNotNullExpressionValue(str, "bubble.bttnId");
        BottomButtonView d26 = Ha.d2(str, this.buttonList);
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
            f16.B("0");
            aVar.i("ev_qqlive_abnormal_imp", f16.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa(String buttonId, String eventId) {
        BottomButtonView d26 = Ha().d2(buttonId, this.buttonList);
        if (d26 != null) {
            com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
            QQLiveDaTongParams f16 = aVar.f(H9());
            f16.d("em_qqlive_bottom_function_button");
            f16.k(buttonId);
            f16.l(String.valueOf(d26.o()));
            f16.B("0");
            aVar.i(eventId, f16.a());
        }
    }

    private final TouchWebView Ga(String url) {
        if (this.gameWebView == null) {
            GameRecommendViewModel Ia = Ia();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            this.gameWebView = Ia.t2(activity, url);
        }
        return this.gameWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.more.b Ha() {
        Object value = this.bottomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.more.b) value;
    }

    private final GameRecommendViewModel Ia() {
        Object value = this.gameViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gameViewModel>(...)");
        return (GameRecommendViewModel) value;
    }

    private final GiftViewModel Ja() {
        Object value = this.giftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-giftViewModel>(...)");
        return (GiftViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.input.a Ka() {
        Object value = this.inputViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.input.a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e La() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(String buttonId) {
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
                    uq4.e U12 = Ha().U1(buttonId, this.dynamicConfigRsp);
                    if (U12 != null) {
                        String str2 = U12.f439839d;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.jumpUrl");
                        Za(str2, U12.f439841f, U12.f439842g);
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
                    com.tencent.mobileqq.qqlive.sail.room.e La = La();
                    if (La != null && (b16 = La.b()) != null) {
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
                    broadcastMessage("onSendGift", Ja().j2());
                    return;
                }
                break;
            case 46730166:
                if (buttonId.equals("10005")) {
                    Ja().s2(true);
                    return;
                }
                break;
            case 46730167:
                if (buttonId.equals("10006")) {
                    String Q1 = Ia().Q1();
                    if (Ia().R1() == 1) {
                        Ia().k2(getActivity(), null, Q1);
                        return;
                    } else {
                        Ia().k2(getActivity(), Ga(Q1), Q1);
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
                        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomPortraitPart", "Button in loading state.");
                        return;
                    }
                    CountDownView countDownView = this.countDownView;
                    if (countDownView != null && countDownView.getVisibility() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomPortraitPart", "Button in countdown state.");
                        return;
                    }
                    com.tencent.mobileqq.qqgift.data.service.d j26 = Ja().j2();
                    if (j26 == null) {
                        return;
                    }
                    Long value = Ja().h2().getValue();
                    if (value == null) {
                        value = 0L;
                    }
                    if (value.longValue() > 0) {
                        z18 = true;
                    }
                    j26.f264875d0 = z18;
                    broadcastMessage("onSendGift", j26);
                    Xa();
                    return;
                }
                break;
        }
        if (buttonId.length() > 0) {
            z18 = true;
        }
        if (z18 && (U1 = Ha().U1(buttonId, this.dynamicConfigRsp)) != null) {
            String str4 = U1.f439839d;
            Intrinsics.checkNotNullExpressionValue(str4, "it.jumpUrl");
            Za(str4, U1.f439841f, U1.f439842g);
        }
    }

    private final void Na() {
        BottomButtonView d26 = Ha().d2("10004", this.buttonList);
        if (d26 != null) {
            Ha().g2(d26.o(), this.btnDataArray.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    private final void Xa() {
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
    public final void Ya(boolean isPackageGift) {
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
            ok4.a g26 = Ja().g2();
            if (g26 != null) {
                i3 = g26.getGiftColdDownTs();
            } else {
                i3 = 10;
            }
            eb(i3);
        }
    }

    private final void Za(String jumpUrl, float webRatio, boolean webTrans) {
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

    private final void ab(long giftId) {
        long R1 = Ha().R1(giftId);
        if (giftId > 0 && R1 > 0) {
            eb((int) R1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bb(ar4.a data) {
        com.tencent.mobileqq.qqlive.sail.ui.more.b Ha = Ha();
        String str = data.f26811b;
        Intrinsics.checkNotNullExpressionValue(str, "data.bttnId");
        BottomButtonView d26 = Ha.d2(str, this.buttonList);
        if (d26 == null) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a a16 = com.tencent.mobileqq.qqlive.sail.ui.more.c.f272913a.a(d26, data);
        a16.f(new b(data, this));
        a16.s0();
        this.bubbleTip = a16;
    }

    private final void cb() {
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

    private final void eb(int seconds) {
        CountDownView countDownView = this.countDownView;
        if (countDownView != null) {
            countDownView.setVisibility(0);
            countDownView.g(seconds, new c(countDownView));
        }
    }

    private final void fb() {
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
    public final void gb() {
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
    public final void hb() {
        String str;
        com.tencent.mobileqq.qqgift.data.service.d j26 = Ja().j2();
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
        BottomButtonView d26 = Ha().d2("10004", this.buttonList);
        if (d26 != null) {
            d26.r(str);
        }
        BottomButtonView d27 = Ha().d2("10007", this.buttonList);
        if (d27 != null) {
            d27.r(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
    
        if (r4 == true) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ib(uq4.c rsp) {
        uq4.e[] eVarArr;
        uq4.e[] b16;
        boolean z16;
        boolean z17;
        boolean z18;
        if (rsp != null) {
            eVarArr = rsp.f439829d;
        } else {
            eVarArr = null;
        }
        if (eVarArr != null) {
            b16 = rsp.f439829d;
            Intrinsics.checkNotNullExpressionValue(b16, "{\n            rsp.interactBttn\n        }");
        } else {
            b16 = com.tencent.mobileqq.qqlive.sail.ui.more.bottom.a.f272911a.b();
        }
        this.btnDataArray = b16;
        int length = b16.length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            uq4.e eVar = b16[i3];
            int i18 = i17 + 1;
            BottomButtonView bottomButtonView = this.buttonList.get(i17);
            if (bottomButtonView != null) {
                bottomButtonView.l(i17, eVar);
            }
            String str = eVar.f439836a;
            Intrinsics.checkNotNullExpressionValue(str, "data.id");
            Fa(str, "ev_qqlive_abnormal_imp");
            boolean z19 = true;
            if (Intrinsics.areEqual(eVar.f439836a, "10004")) {
                String extData = eVar.f439844i;
                if (extData != null) {
                    Intrinsics.checkNotNullExpressionValue(extData, "extData");
                    if (extData.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        z17 = true;
                        if (z17) {
                            String str2 = eVar.f439844i;
                            Intrinsics.checkNotNullExpressionValue(str2, "data.extData");
                            Ja().r2(new ok4.b(str2).b());
                        }
                    }
                }
                z17 = false;
                if (z17) {
                }
            }
            if (Intrinsics.areEqual(eVar.f439836a, "10007")) {
                String extData2 = eVar.f439844i;
                if (extData2 != null) {
                    Intrinsics.checkNotNullExpressionValue(extData2, "extData");
                    if (extData2.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                z19 = false;
                if (z19) {
                    String str3 = eVar.f439844i;
                    Intrinsics.checkNotNullExpressionValue(str3, "data.extData");
                    ok4.a c16 = new ok4.a(str3).c();
                    Ja().q2(c16);
                    i16 = c16.getGiftId();
                }
            }
            i3++;
            i17 = i18;
        }
        Na();
        jb();
        ab(i16);
    }

    private final void jb() {
        BottomButtonView d26 = Ha().d2("10007", this.buttonList);
        if (d26 == null) {
            return;
        }
        View view = this.redDotGuideView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.rightToRight = d26.getId();
            layoutParams2.bottomToTop = d26.getId();
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = wi2.c.b(6);
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = wi2.c.b(8);
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

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        this.hasReceiveConfig = true;
        this.dynamicConfigRsp = updater.a();
        if (R9() && this.hasReceiveConfig && (!this.buttonList.isEmpty())) {
            ib(this.dynamicConfigRsp);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.U9();
        cb();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.p(285, this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBottomPortraitPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        Unit unit;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.V9();
        fb();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveAudienceBottomPortraitPart", "onEnterRoom", "no room");
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
            ok4.a g26 = Ja().g2();
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
            Ha().i2(j3, j16);
        }
        gb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.id.f60112uj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v3);
        } else {
            String str = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f59802tp) {
                Ka().O1(true);
            } else if (num != null && num.intValue() == R.id.f59832ts) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b Ha = Ha();
                BottomButtonView bottomButtonView = this.button1;
                if (bottomButtonView != null) {
                    str = bottomButtonView.m();
                }
                Ha.h2(str);
            } else if (num != null && num.intValue() == R.id.f59852tu) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b Ha2 = Ha();
                BottomButtonView bottomButtonView2 = this.button2;
                if (bottomButtonView2 != null) {
                    str = bottomButtonView2.m();
                }
                Ha2.h2(str);
            } else if (num != null && num.intValue() == R.id.f59872tw) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b Ha3 = Ha();
                BottomButtonView bottomButtonView3 = this.button3;
                if (bottomButtonView3 != null) {
                    str = bottomButtonView3.m();
                }
                Ha3.h2(str);
            } else if (num != null && num.intValue() == R.id.f59892ty) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b Ha4 = Ha();
                BottomButtonView bottomButtonView4 = this.button4;
                if (bottomButtonView4 != null) {
                    str = bottomButtonView4.m();
                }
                Ha4.h2(str);
            } else if (num != null && num.intValue() == R.id.f59912u0) {
                com.tencent.mobileqq.qqlive.sail.ui.more.b Ha5 = Ha();
                BottomButtonView bottomButtonView5 = this.button5;
                if (bottomButtonView5 != null) {
                    str = bottomButtonView5.m();
                }
                Ha5.h2(str);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isUILandscape = z16;
            if (z16) {
                fb();
                com.tencent.mobileqq.widget.tip.a aVar = this.bubbleTip;
                if (aVar != null) {
                    aVar.o();
                }
            } else {
                cb();
            }
            ViewGroup viewGroup = this.bottomBar;
            if (viewGroup != null) {
                wi2.d.e(viewGroup, !this.isUILandscape);
            }
            if (!this.isUILandscape) {
                Na();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        View view;
        BottomButtonView bottomButtonView;
        BottomButtonView bottomButtonView2;
        BottomButtonView bottomButtonView3;
        BottomButtonView bottomButtonView4;
        BottomButtonView bottomButtonView5;
        List<BottomButtonView> mutableListOf;
        ButtonLoadingView buttonLoadingView;
        CountDownView countDownView;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        RedDotView redDotView = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f60112uj);
        } else {
            viewGroup = null;
        }
        this.bottomBar = viewGroup;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f59802tp);
        } else {
            view = null;
        }
        this.inputPlaceHolder = view;
        if (view != null) {
            view.setOnClickListener(this);
        }
        cb();
        if (rootView != null) {
            bottomButtonView = (BottomButtonView) rootView.findViewById(R.id.f59832ts);
        } else {
            bottomButtonView = null;
        }
        this.button1 = bottomButtonView;
        if (bottomButtonView != null) {
            bottomButtonView.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView2 = (BottomButtonView) rootView.findViewById(R.id.f59852tu);
        } else {
            bottomButtonView2 = null;
        }
        this.button2 = bottomButtonView2;
        if (bottomButtonView2 != null) {
            bottomButtonView2.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView3 = (BottomButtonView) rootView.findViewById(R.id.f59872tw);
        } else {
            bottomButtonView3 = null;
        }
        this.button3 = bottomButtonView3;
        if (bottomButtonView3 != null) {
            bottomButtonView3.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView4 = (BottomButtonView) rootView.findViewById(R.id.f59892ty);
        } else {
            bottomButtonView4 = null;
        }
        this.button4 = bottomButtonView4;
        if (bottomButtonView4 != null) {
            bottomButtonView4.setOnClickListener(this);
        }
        if (rootView != null) {
            bottomButtonView5 = (BottomButtonView) rootView.findViewById(R.id.f59912u0);
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
            buttonLoadingView = (ButtonLoadingView) rootView.findViewById(R.id.f59952u4);
        } else {
            buttonLoadingView = null;
        }
        this.buttonLoadingView = buttonLoadingView;
        if (rootView != null) {
            countDownView = (CountDownView) rootView.findViewById(R.id.f59932u2);
        } else {
            countDownView = null;
        }
        this.countDownView = countDownView;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f59982u7);
        } else {
            view2 = null;
        }
        this.redDotGuideView = view2;
        if (rootView != null) {
            redDotView = (RedDotView) rootView.findViewById(R.id.f59972u6);
        }
        this.redDotView = redDotView;
        ButtonLoadingView buttonLoadingView2 = this.buttonLoadingView;
        if (buttonLoadingView2 != null) {
            buttonLoadingView2.setAutoStop(true);
        }
        if (R9() && this.hasReceiveConfig && (!this.buttonList.isEmpty())) {
            ib(this.dynamicConfigRsp);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        LiveData<Boolean> N1 = Ka().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                View view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveAudienceBottomPortraitPart.this.startInit();
                view = QQLiveAudienceBottomPortraitPart.this.inputPlaceHolder;
                if (view != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    wi2.d.e(view, it.booleanValue());
                }
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Oa(Function1.this, obj);
            }
        });
        LiveData<Boolean> e26 = Ja().e2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
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
                    QQLiveAudienceBottomPortraitPart.this.startInit();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        e26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Pa(Function1.this, obj);
            }
        });
        LiveData<c55.d> f26 = Ja().f2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<c55.d, Unit> function13 = new Function1<c55.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable c55.d dVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                } else if (dVar != null) {
                    QQLiveAudienceBottomPortraitPart.this.startInit();
                }
            }
        };
        f26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Qa(Function1.this, obj);
            }
        });
        LiveData<cr4.b> b26 = Ia().b2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<cr4.b, Unit> function14 = new Function1<cr4.b, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cr4.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable cr4.b bVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQLiveAudienceBottomPortraitPart.this.startInit();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                }
            }
        };
        b26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Ra(Function1.this, obj);
            }
        });
        LiveData<String> a26 = Ha().a2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function15 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
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
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                z16 = QQLiveAudienceBottomPortraitPart.this.isUILandscape;
                if (z16) {
                    return;
                }
                QQLiveAudienceBottomPortraitPart qQLiveAudienceBottomPortraitPart = QQLiveAudienceBottomPortraitPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveAudienceBottomPortraitPart.Ma(it);
                QQLiveAudienceBottomPortraitPart.this.Fa(it, "ev_qqlive_abnormal_clck");
            }
        };
        a26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Sa(Function1.this, obj);
            }
        });
        LiveData<ar4.a> T1 = Ha().T1();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<ar4.a, Unit> function16 = new Function1<ar4.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ar4.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ar4.a it) {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                z16 = QQLiveAudienceBottomPortraitPart.this.isUILandscape;
                if (z16) {
                    return;
                }
                QQLiveAudienceBottomPortraitPart qQLiveAudienceBottomPortraitPart = QQLiveAudienceBottomPortraitPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveAudienceBottomPortraitPart.bb(it);
                QQLiveAudienceBottomPortraitPart.this.Ea(it);
            }
        };
        T1.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Ta(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.qqgift.data.service.d> k26 = Ja().k2();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.qqgift.data.service.d, Unit> function17 = new Function1<com.tencent.mobileqq.qqgift.data.service.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqgift.data.service.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.qqgift.data.service.d dVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQLiveAudienceBottomPortraitPart.this.hb();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                }
            }
        };
        k26.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Ua(Function1.this, obj);
            }
        });
        LiveData<Long> h26 = Ja().h2();
        LifecycleOwner lifecycleOwner8 = getPartHost().getLifecycleOwner();
        final Function1<Long, Unit> function18 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
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
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                redDotView = QQLiveAudienceBottomPortraitPart.this.redDotView;
                if (redDotView != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    redDotView.setRedDotNum(it.longValue());
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.longValue() > 0) {
                    countDownView = QQLiveAudienceBottomPortraitPart.this.countDownView;
                    boolean z16 = false;
                    if (countDownView != null && countDownView.getVisibility() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        QQLiveAudienceBottomPortraitPart.this.gb();
                    }
                }
            }
        };
        h26.observe(lifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Va(Function1.this, obj);
            }
        });
        LiveData<Boolean> l26 = Ja().l2();
        LifecycleOwner lifecycleOwner9 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function19 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.QQLiveAudienceBottomPortraitPart$onPartCreate$9
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveAudienceBottomPortraitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLiveAudienceBottomPortraitPart qQLiveAudienceBottomPortraitPart = QQLiveAudienceBottomPortraitPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveAudienceBottomPortraitPart.Ya(it.booleanValue());
            }
        };
        l26.observe(lifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceBottomPortraitPart.Wa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        fb();
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            fb();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        if (R9()) {
            cb();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        ar4.a n3 = com.tencent.mobileqq.qqlive.sail.push.a.n(msgInfo);
        if (n3 != null) {
            AegisLogger.INSTANCE.i("Audience|QQLiveAudienceBottomPortraitPart", "onPush", "roomId=" + H9() + ", bubbleTips=" + n3.f26812c);
            Ha().O1(n3);
        }
    }
}

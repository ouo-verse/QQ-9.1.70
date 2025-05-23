package com.tencent.mobileqq.aio.title.center;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.aa;
import com.tencent.mobileqq.aio.title.ad;
import com.tencent.mobileqq.aio.title.ae;
import com.tencent.mobileqq.aio.title.ai;
import com.tencent.mobileqq.aio.title.aj;
import com.tencent.mobileqq.aio.title.an;
import com.tencent.mobileqq.aio.title.center.CenterUIState;
import com.tencent.mobileqq.aio.title.center.a;
import com.tencent.mobileqq.aio.title.center.j;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.ao;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.CommonTextView;
import com.tencent.mobileqq.aio.widget.NTViewFlipper;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.mobileqq.widget.t;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0082\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0083\u0001B\u0017\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020T0S\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J,\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010\"\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u000202H\u0002J\b\u00105\u001a\u00020\u000eH\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u000208H\u0002J\u0012\u0010<\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010>\u001a\u00020\u000e2\u0006\u00103\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020\u0017H\u0002J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020/H\u0002J\u0010\u0010D\u001a\u00020:2\u0006\u0010C\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020\u000eH\u0016J\u0014\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030FH\u0016J\u0016\u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030I0HH\u0016J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020LH\u0016J\b\u0010P\u001a\u0004\u0018\u00010OJ\b\u0010Q\u001a\u0004\u0018\u00010OJ\b\u0010R\u001a\u00020\u000eH\u0016R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020T0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010YR\u0016\u0010^\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010YR\u0016\u0010`\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010YR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u0010f\u001a\u0004\bl\u0010mR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u000e0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010VR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010f\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010f\u001a\u0004\bx\u0010yR\u001b\u0010\u007f\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010f\u001a\u0004\b}\u0010~\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/title/center/CenterVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/center/a;", "Lcom/tencent/mobileqq/aio/title/center/CenterUIState;", "Lcom/tencent/mobileqq/aio/title/ae;", SemanticAttributes.DbCassandraConsistencyLevelValues.ONE, "Landroid/os/Bundle;", "H1", "Landroid/graphics/Point;", "E1", "", GuildMsgItem.NICK_FRIEND, "", "statusName", "", "U1", "Lcom/tencent/mobileqq/aio/title/center/CenterUIState$UpdateVIPState;", "state", "j2", "M1", "O1", "v1", SemanticAttributes.DbCassandraConsistencyLevelValues.TWO, "", "isTroopGuild", "needAnim", "Y1", "Lcom/tencent/mobileqq/aio/title/an;", "troopFlameData", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/aio/title/ai;", "subTitleData", "Z1", "N1", "K1", QQWinkConstants.TAB_SUBTITLE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "R1", "d2", "f2", "e2", "p1", Constants.APK_CERTIFICATE, "W1", "", "memberCount", "X1", "", "title", "V1", "Lcom/tencent/mobileqq/aio/title/aa;", "data", "Q1", "P1", "showEar", "S1", "Landroid/widget/ImageView;", "x1", "Landroid/view/View;", "triggerView", "T1", "Lcom/tencent/mobileqq/aio/title/aj;", "c2", "J1", "mainTitle", "l2", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "w1", "", "Ljava/lang/Class;", "getObserverStates", "I1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "Lcom/tencent/mobileqq/widget/t$a;", "y1", "F1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function0;", "Lw71/t;", "d", "Lkotlin/jvm/functions/Function0;", "getBinding", "e", "Landroid/widget/ImageView;", "mRightEarIv", "f", "mCenterRight1Iv", tl.h.F, "mCenterRight2Iv", "i", "mVipIv", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "mFlameContainerView", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", Constants.BASE_IN_PLUGIN_ID, "()Lw71/t;", "mTitleBinding", "Lcom/tencent/mobileqq/aio/title/center/MainTitleTalkbackHelper;", "D", "z1", "()Lcom/tencent/mobileqq/aio/title/center/MainTitleTalkbackHelper;", "mMainTitleTalkbackHelper", "E", "mUpdateSubTitleIConSizeRunnable", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "B1", "()Landroid/widget/TextView;", "mSubTitleTv", "Lcom/tencent/mobileqq/aio/widget/CommonTextView;", "G", "C1", "()Lcom/tencent/mobileqq/aio/widget/CommonTextView;", "mSubTitleTv2", "Lcom/tencent/mobileqq/aio/widget/NTViewFlipper;", "H", "A1", "()Lcom/tencent/mobileqq/aio/widget/NTViewFlipper;", "mSubTitleFlipper", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "I", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CenterVB extends com.tencent.aio.base.mvvm.a<a, CenterUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTitleBinding;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMainTitleTalkbackHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> mUpdateSubTitleIConSizeRunnable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mSubTitleTv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mSubTitleTv2;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mSubTitleFlipper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<t> getBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mRightEarIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mCenterRight1Iv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mCenterRight2Iv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mVipIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mFlameContainerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/title/center/CenterVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.center.CenterVB$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65180);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CenterVB(@NotNull Function0<t> getBinding) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(getBinding, "getBinding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) getBinding);
            return;
        }
        this.getBinding = getBinding;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<t>() { // from class: com.tencent.mobileqq.aio.title.center.CenterVB$mTitleBinding$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final t invoke() {
                Function0 function0;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (t) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                function0 = CenterVB.this.getBinding;
                return (t) function0.invoke();
            }
        });
        this.mTitleBinding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MainTitleTalkbackHelper>() { // from class: com.tencent.mobileqq.aio.title.center.CenterVB$mMainTitleTalkbackHelper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MainTitleTalkbackHelper invoke() {
                t D1;
                t D12;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MainTitleTalkbackHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                D1 = CenterVB.this.D1();
                CommonTextView commonTextView = D1.f444914o;
                Intrinsics.checkNotNullExpressionValue(commonTextView, "mTitleBinding.titleTv");
                D12 = CenterVB.this.D1();
                CommonTextView commonTextView2 = D12.f444913n;
                Intrinsics.checkNotNullExpressionValue(commonTextView2, "mTitleBinding.titleTailTv");
                return new MainTitleTalkbackHelper(commonTextView, commonTextView2);
            }
        });
        this.mMainTitleTalkbackHelper = lazy2;
        this.mUpdateSubTitleIConSizeRunnable = new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.title.center.CenterVB$mUpdateSubTitleIConSizeRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    CenterVB.this.e2();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.title.center.CenterVB$mSubTitleTv$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView lyricView = ((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).getLyricView(CenterVB.this.getMContext());
                lyricView.setId(R.id.f166931j64);
                if (FontSettingManager.isFontSizeLarge()) {
                    lyricView.setMaxEms(15);
                }
                return lyricView;
            }
        });
        this.mSubTitleTv = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommonTextView>() { // from class: com.tencent.mobileqq.aio.title.center.CenterVB$mSubTitleTv2$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommonTextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (CommonTextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                CommonTextView commonTextView = new CommonTextView(CenterVB.this.getMContext());
                commonTextView.setId(R.id.f9031525);
                commonTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                commonTextView.setAlpha(0.8f);
                commonTextView.setGravity(17);
                commonTextView.setEllipsize(TextUtils.TruncateAt.END);
                commonTextView.setIncludeFontPadding(false);
                commonTextView.setMaxWidth((int) TypedValue.applyDimension(1, 220.0f, commonTextView.getResources().getDisplayMetrics()));
                commonTextView.setMaxLines(1);
                commonTextView.setSingleLine(true);
                commonTextView.setTextSize(10.0f);
                commonTextView.setVisibility(8);
                return commonTextView;
            }
        });
        this.mSubTitleTv2 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<NTViewFlipper>() { // from class: com.tencent.mobileqq.aio.title.center.CenterVB$mSubTitleFlipper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CenterVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NTViewFlipper invoke() {
                TextView B1;
                CommonTextView C1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (NTViewFlipper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                NTViewFlipper nTViewFlipper = new NTViewFlipper(CenterVB.this.getMContext(), null);
                CenterVB centerVB = CenterVB.this;
                nTViewFlipper.setId(R.id.mam);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, R.id.f98175md);
                layoutParams.addRule(1, R.id.f9032526);
                layoutParams.topMargin = com.tencent.qqnt.aio.utils.l.b(2);
                nTViewFlipper.setLayoutParams(layoutParams);
                nTViewFlipper.setVisibility(8);
                nTViewFlipper.setAutoStart(false);
                nTViewFlipper.setFlipInterval(3000);
                nTViewFlipper.setInAnimation(AnimationUtils.loadAnimation(nTViewFlipper.getContext(), R.anim.f154424l));
                nTViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(nTViewFlipper.getContext(), R.anim.f154425m));
                B1 = centerVB.B1();
                nTViewFlipper.addView(B1);
                C1 = centerVB.C1();
                nTViewFlipper.addView(C1);
                return nTViewFlipper;
            }
        });
        this.mSubTitleFlipper = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NTViewFlipper A1() {
        return (NTViewFlipper) this.mSubTitleFlipper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView B1() {
        return (TextView) this.mSubTitleTv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommonTextView C1() {
        return (CommonTextView) this.mSubTitleTv2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final t D1() {
        return (t) this.mTitleBinding.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Point E1() {
        ImageView imageView = this.mCenterRight1Iv;
        if (imageView != null) {
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
            }
            if (imageView != null) {
                return null;
            }
            int[] iArr = new int[2];
            imageView.getLocationOnScreen(iArr);
            return new Point(iArr[0] + (imageView.getWidth() / 2), iArr[1] + (imageView.getHeight() / 2));
        }
        imageView = null;
        if (imageView != null) {
        }
    }

    private final void G1() {
        ImageView imageView = this.mVipIv;
        FrameLayout frameLayout = null;
        if (imageView != null) {
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                imageView = null;
            }
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mCenterRight1Iv;
        if (imageView2 != null) {
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.mCenterRight2Iv;
        if (imageView3 != null) {
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterRight2Iv");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.mRightEarIv;
        if (imageView4 != null) {
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightEarIv");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.mFlameContainerView;
        if (frameLayout2 != null) {
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlameContainerView");
                frameLayout2 = null;
            }
            frameLayout2.removeAllViews();
            FrameLayout frameLayout3 = this.mFlameContainerView;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlameContainerView");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setVisibility(8);
        }
        D1().f444917r.setVisibility(8);
        D1().f444909j.setVisibility(8);
        D1().f444913n.setVisibility(8);
        B1().setVisibility(8);
        C1().setVisibility(8);
        A1().setVisibility(8);
    }

    private final Bundle H1(ae one) {
        Y1(one, null, false, false);
        Point E1 = E1();
        if (E1 != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("mutual_mark_location", E1);
            return bundle;
        }
        Bundle EMPTY = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return EMPTY;
    }

    private final boolean J1() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_troop_title_member_merge_8983_110163808", true);
    }

    private final boolean K1(ai subTitleData) {
        if (subTitleData == null) {
            return false;
        }
        if (TextUtils.isEmpty(subTitleData.a()) && subTitleData.c() == null && subTitleData.d() == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void M1() {
        IFlashNickNameComponent iFlashNickNameComponent = (IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class);
        CommonTextView commonTextView = D1().f444914o;
        Intrinsics.checkNotNullExpressionValue(commonTextView, "mTitleBinding.titleTv");
        iFlashNickNameComponent.playNickCoverAnimation(commonTextView, false);
    }

    private final void N1(ai subTitleData) {
        if (K1(subTitleData)) {
            HashMap hashMap = new HashMap();
            Intrinsics.checkNotNull(subTitleData);
            hashMap.put("aio_business_type", subTitleData.e());
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_auxiliary_copywriting_area", hashMap);
            com.tencent.mobileqq.aio.utils.b.f194119a.c("em_bas_aio_auxiliary_copywriting_area", subTitleData.e());
            return;
        }
        if (A1().getVisibility() == 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("aio_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_auxiliary_copywriting_area", ""));
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_auxiliary_copywriting_area", hashMap2);
        }
    }

    private final void O1() {
        D1().f444914o.getPaint().setShader(null);
        D1().f444914o.setTextColor(AppCompatResources.getColorStateList(getMContext(), R.color.qui_common_text_nav_secondary));
        D1().f444914o.setTypeface(Typeface.defaultFromStyle(0));
    }

    private final void P1() {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getMContext(), R.color.qui_common_text_nav_secondary);
        D1().f444913n.setTextColor(colorStateList);
        D1().f444914o.setTextColor(colorStateList);
        B1().setTextColor(colorStateList);
        C1().setTextColor(colorStateList);
    }

    private final void Q1(aa data) {
        int i3;
        W1();
        V1(data.b());
        S1(data.a());
        P1();
        CommonTextView commonTextView = D1().f444914o;
        int i16 = 16;
        if (QQTheme.isNowSimpleUI()) {
            i3 = 16;
        } else {
            i3 = 17;
        }
        commonTextView.setTextSize(1, i3);
        CommonTextView commonTextView2 = D1().f444913n;
        if (!QQTheme.isNowSimpleUI()) {
            i16 = 17;
        }
        commonTextView2.setTextSize(1, i16);
    }

    private final void R1() {
        ViewGroup.LayoutParams layoutParams = A1().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (D1().f444909j.getVisibility() == 0) {
            layoutParams2.addRule(1, R.id.f9032526);
            layoutParams2.removeRule(5);
            layoutParams2.removeRule(14);
        } else {
            layoutParams2.addRule(5, R.id.f98175md);
            layoutParams2.removeRule(1);
            layoutParams2.removeRule(14);
        }
        ViewGroup.LayoutParams layoutParams3 = D1().f444914o.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        if (A1().getVisibility() == 0) {
            layoutParams4.topMargin = x.a(7.5f);
            layoutParams4.removeRule(15);
        } else {
            layoutParams4.topMargin = 0;
            layoutParams4.addRule(15);
        }
    }

    private final void S1(boolean showEar) {
        ImageView x16 = x1();
        if (showEar) {
            x16.setVisibility(0);
            x16.setScaleType(ImageView.ScaleType.FIT_CENTER);
            x16.setImageResource(R.drawable.qui_receiver_icon_secondary);
            x16.setAlpha(0.6f);
            x16.setContentDescription(HardCodeUtil.qqStr(R.string.ysj));
            return;
        }
        x16.setVisibility(8);
        x16.setColorFilter((ColorFilter) null);
        x16.setImageResource(0);
    }

    private final void T1(View triggerView) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        CharSequence text = B1().getText();
        boolean z26 = true;
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            CharSequence text2 = C1().getText();
            if (text2 != null && text2.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                A1().setVisibility(8);
                if (A1().isFlipping()) {
                    A1().stopFlipping();
                    return;
                }
                return;
            }
        }
        CharSequence text3 = B1().getText();
        if (text3 != null && text3.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            B1().setVisibility(8);
            C1().setVisibility(0);
            A1().setVisibility(0);
            if (A1().isFlipping()) {
                A1().stopFlipping();
                return;
            }
            return;
        }
        CharSequence text4 = C1().getText();
        if (text4 != null && text4.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            if (B1().getVisibility() != 8) {
                z26 = false;
            }
            if (z26) {
                AIOUtil.f194084a.H(A1());
            }
            C1().setVisibility(8);
            B1().setVisibility(0);
            A1().setVisibility(0);
            if (A1().isFlipping()) {
                A1().stopFlipping();
                return;
            }
            return;
        }
        A1().setVisibility(0);
        if (!Intrinsics.areEqual(A1().getCurrentView(), triggerView)) {
            A1().showNext();
        }
        if (!A1().isFlipping()) {
            A1().startFlipping();
        }
    }

    private final void U1(Object friend, String statusName) {
        ad adVar;
        KeyEvent.Callback B1 = B1();
        if (B1 instanceof ad) {
            adVar = (ad) B1;
        } else {
            adVar = null;
        }
        if (adVar != null) {
            adVar.setFriendSession(friend, statusName);
        }
    }

    private final void V1(CharSequence title) {
        D1().f444914o.setText(title);
        if (J1() && com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            z1().i(title);
        }
        l2(title);
    }

    private final void W1() {
        ViewGroup.LayoutParams layoutParams = D1().f444914o.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(15);
        layoutParams2.addRule(17, R.id.f114256su);
        layoutParams2.removeRule(14);
    }

    private final void X1(int memberCount) {
        if (memberCount > 0) {
            CommonTextView commonTextView = D1().f444913n;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(");
            sb5.append(memberCount);
            sb5.append(")");
            commonTextView.setText(sb5);
            D1().f444913n.setVisibility(0);
            D1().f444913n.setContentDescription(String.valueOf(memberCount));
        } else {
            D1().f444913n.setText("");
            D1().f444913n.setContentDescription("");
            D1().f444913n.setVisibility(8);
        }
        if (J1() && com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            z1().k(memberCount);
        }
    }

    private final void Y1(ae one, ae two, boolean isTroopGuild, boolean needAnim) {
        ImageView imageView = null;
        if (isTroopGuild) {
            ImageView imageView2 = this.mCenterRight1Iv;
            if (imageView2 != null) {
                ao aoVar = ao.f194112a;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                } else {
                    imageView = imageView2;
                }
                aoVar.b(one, imageView, needAnim);
            } else if (one != null && one.a().c()) {
                View inflate = D1().f444901b.inflate();
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.ImageView");
                ImageView imageView3 = (ImageView) inflate;
                this.mCenterRight1Iv = imageView3;
                ao aoVar2 = ao.f194112a;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                } else {
                    imageView = imageView3;
                }
                aoVar2.b(one, imageView, needAnim);
            }
        } else {
            ImageView imageView4 = this.mCenterRight1Iv;
            if (imageView4 != null) {
                ao aoVar3 = ao.f194112a;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                    imageView4 = null;
                }
                aoVar3.b(one, imageView4, needAnim);
            } else if (one != null && one.a().c()) {
                View inflate2 = D1().f444901b.inflate();
                Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.widget.ImageView");
                ImageView imageView5 = (ImageView) inflate2;
                this.mCenterRight1Iv = imageView5;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                    imageView5 = null;
                }
                AccessibilityUtil.n(imageView5, false);
                ao aoVar4 = ao.f194112a;
                ImageView imageView6 = this.mCenterRight1Iv;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                    imageView6 = null;
                }
                aoVar4.b(one, imageView6, needAnim);
            }
            ImageView imageView7 = this.mCenterRight2Iv;
            if (imageView7 != null) {
                ao aoVar5 = ao.f194112a;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight2Iv");
                } else {
                    imageView = imageView7;
                }
                aoVar5.b(two, imageView, needAnim);
            } else if (two != null && two.a().c()) {
                View inflate3 = D1().f444902c.inflate();
                Intrinsics.checkNotNull(inflate3, "null cannot be cast to non-null type android.widget.ImageView");
                ImageView imageView8 = (ImageView) inflate3;
                this.mCenterRight2Iv = imageView8;
                if (imageView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight2Iv");
                    imageView8 = null;
                }
                AccessibilityUtil.n(imageView8, false);
                ao aoVar6 = ao.f194112a;
                ImageView imageView9 = this.mCenterRight2Iv;
                if (imageView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight2Iv");
                } else {
                    imageView = imageView9;
                }
                aoVar6.b(two, imageView, needAnim);
            }
        }
        v1();
    }

    private final void Z1(ai subTitleData) {
        N1(subTitleData);
        d2(subTitleData);
        a2(subTitleData.a());
        B1().setCompoundDrawablePadding(x.a(4.0f));
        B1().setCompoundDrawables(subTitleData.c(), null, subTitleData.d(), null);
        R1();
    }

    private final void a2(String subTitle) {
        B1().setText(subTitle);
        T1(B1());
    }

    private final void c2(aj data) {
        if (data.a()) {
            C1().setText(new QQText(data.b(), 3, 12));
        } else {
            C1().setText("");
        }
        T1(C1());
        R1();
    }

    private final void d2(ai subTitleData) {
        int i3;
        ImageView imageView = D1().f444909j;
        if (subTitleData.b() != null) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        D1().f444909j.setImageDrawable(subTitleData.b());
        ViewGroup.LayoutParams layoutParams = D1().f444909j.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(5, R.id.f98175md);
        layoutParams2.removeRule(0);
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2() {
        ViewGroup.LayoutParams layoutParams = D1().f444909j.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        ImageView imageView = D1().f444909j;
        if (imageView.getWidth() != imageView.getHeight() && imageView.getHeight() > 0) {
            layoutParams2.width = imageView.getHeight();
            layoutParams2.height = imageView.getHeight();
        }
    }

    private final void f2() {
        ImageView imageView = D1().f444909j;
        if (imageView.getHeight() <= 0) {
            final Function0<Unit> function0 = this.mUpdateSubTitleIConSizeRunnable;
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.b
                @Override // java.lang.Runnable
                public final void run() {
                    CenterVB.g2(Function0.this);
                }
            });
        } else {
            e2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void h2(final an troopFlameData) {
        if (troopFlameData != null) {
            final FrameLayout frameLayout = null;
            if (this.mFlameContainerView == null) {
                CenterVB$updateTroopFlameState$1$2 centerVB$updateTroopFlameState$1$2 = new CenterVB$updateTroopFlameState$1$2(D1().f444911l.getContext());
                centerVB$updateTroopFlameState$1$2.setId(R.id.f164242sk3);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(17, R.id.f98155mb);
                layoutParams.addRule(6, R.id.f98155mb);
                layoutParams.addRule(8, R.id.f98155mb);
                centerVB$updateTroopFlameState$1$2.setLayoutParams(layoutParams);
                this.mFlameContainerView = centerVB$updateTroopFlameState$1$2;
                ViewGroup.LayoutParams layoutParams2 = D1().f444918s.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                ((RelativeLayout.LayoutParams) layoutParams2).addRule(17, R.id.f164242sk3);
                AIOTitleRelativeLayout aIOTitleRelativeLayout = D1().f444911l;
                FrameLayout frameLayout2 = this.mFlameContainerView;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFlameContainerView");
                    frameLayout2 = null;
                }
                aIOTitleRelativeLayout.addView(frameLayout2);
            }
            FrameLayout frameLayout3 = this.mFlameContainerView;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlameContainerView");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.setVisibility(0);
            frameLayout.removeAllViews();
            frameLayout.addView(troopFlameData.b());
            frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.i
                @Override // java.lang.Runnable
                public final void run() {
                    CenterVB.i2(frameLayout, troopFlameData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(FrameLayout this_apply, an data) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(data, "$data");
        float width = this_apply.getWidth();
        float height = this_apply.getHeight();
        int[] iArr = new int[2];
        this_apply.getLocationOnScreen(iArr);
        data.a().a(iArr[0], iArr[1], width, height);
    }

    private final void j2(CenterUIState.UpdateVIPState state) {
        final com.tencent.mobileqq.aio.title.ao a16 = state.a();
        com.tencent.mobileqq.aio.utils.ae a17 = a16.a();
        Resources resources = D1().f444914o.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "mTitleBinding.titleTv.resources");
        Drawable a18 = a17.a(resources);
        boolean z16 = true;
        ImageView imageView = null;
        if (a18 != null && !state.b()) {
            ImageView imageView2 = this.mVipIv;
            if (imageView2 == null) {
                View inflate = D1().f444918s.inflate();
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.ImageView");
                this.mVipIv = (ImageView) inflate;
            } else {
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                    imageView2 = null;
                }
                if (imageView2.getVisibility() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    ImageView imageView3 = this.mVipIv;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(0);
                }
            }
            ImageView imageView4 = this.mVipIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                imageView4 = null;
            }
            imageView4.setImageDrawable(a18);
            ImageView imageView5 = this.mVipIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
            } else {
                imageView = imageView5;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.center.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CenterVB.k2(com.tencent.mobileqq.aio.title.ao.this, view);
                }
            });
            CharSequence text = D1().f444914o.getText();
            Intrinsics.checkNotNullExpressionValue(text, "mTitleBinding.titleTv.text");
            l2(text);
        } else {
            ImageView imageView6 = this.mVipIv;
            if (imageView6 != null) {
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                    imageView6 = null;
                }
                if (imageView6.getVisibility() != 0) {
                    z16 = false;
                }
                if (z16) {
                    ImageView imageView7 = this.mVipIv;
                    if (imageView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                        imageView7 = null;
                    }
                    imageView7.setVisibility(8);
                    ImageView imageView8 = this.mVipIv;
                    if (imageView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                        imageView8 = null;
                    }
                    imageView8.setImageDrawable(null);
                    ImageView imageView9 = this.mVipIv;
                    if (imageView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                        imageView9 = null;
                    }
                    imageView9.setOnClickListener(null);
                }
            }
        }
        v1();
        O1();
        com.tencent.mobileqq.aio.utils.ae a19 = a16.a();
        CommonTextView commonTextView = D1().f444914o;
        Intrinsics.checkNotNullExpressionValue(commonTextView, "mTitleBinding.titleTv");
        a19.c(commonTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(com.tencent.mobileqq.aio.title.ao data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(data, "$data");
        com.tencent.mobileqq.aio.utils.ae a16 = data.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        a16.b(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void l2(CharSequence mainTitle) {
        ImageView imageView;
        boolean z16;
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && (imageView = this.mVipIv) != null) {
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                imageView = null;
            }
            if (imageView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !TextUtils.isEmpty(mainTitle)) {
                ImageView imageView3 = this.mVipIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                } else {
                    imageView2 = imageView3;
                }
                imageView2.setContentDescription(((Object) mainTitle) + "\u7684\u540d\u724c\u7ba1");
            }
        }
    }

    private final void p1() {
        G1();
        D1().f444914o.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.center.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CenterVB.q1(CenterVB.this, view);
            }
        });
        D1().f444909j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.center.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CenterVB.r1(CenterVB.this, view);
            }
        });
        A1().setMeasureAllChildren(false);
        A1().setOutAnimation(null);
        B1().setText("");
        B1().setVisibility(8);
        B1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.center.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CenterVB.s1(CenterVB.this, view);
            }
        });
        C1().setText("");
        C1().setVisibility(8);
        C1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.center.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CenterVB.u1(CenterVB.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(CenterVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.e.f193919d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_aio_name");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(CenterVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.d.f193918d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(CenterVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.c.f193917d);
        HashMap hashMap = new HashMap();
        hashMap.put("aio_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_auxiliary_copywriting_area", ""));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_auxiliary_copywriting_area", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(CenterVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.b.f193916d);
        HashMap hashMap = new HashMap();
        hashMap.put("aio_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_auxiliary_copywriting_area", ""));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_auxiliary_copywriting_area", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void v1() {
        boolean z16;
        boolean z17;
        ImageView imageView;
        boolean z18;
        ImageView imageView2 = this.mVipIv;
        boolean z19 = true;
        if (imageView2 != null) {
            ImageView imageView3 = null;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVipIv");
                imageView2 = null;
            }
            if (imageView2.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && (imageView = this.mCenterRight1Iv) != null) {
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterRight1Iv");
                } else {
                    imageView3 = imageView;
                }
                if (imageView3.getVisibility() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z16 = true;
                    if (!z16) {
                        View view = D1().f444917r;
                        Intrinsics.checkNotNullExpressionValue(view, "mTitleBinding.vipDivider");
                        if (view.getVisibility() != 0) {
                            z19 = false;
                        }
                        if (!z19) {
                            D1().f444917r.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    View view2 = D1().f444917r;
                    Intrinsics.checkNotNullExpressionValue(view2, "mTitleBinding.vipDivider");
                    if (view2.getVisibility() != 0) {
                        z19 = false;
                    }
                    if (z19) {
                        D1().f444917r.setVisibility(8);
                        return;
                    }
                    return;
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private final ImageView x1() {
        if (this.mRightEarIv == null) {
            View inflate = D1().f444904e.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) inflate;
            this.mRightEarIv = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightEarIv");
                imageView = null;
            }
            imageView.getLayoutParams().width = ViewUtils.dip2px(16.0f);
            ImageView imageView2 = this.mRightEarIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRightEarIv");
                imageView2 = null;
            }
            imageView2.getLayoutParams().height = ViewUtils.dip2px(16.0f);
        }
        ImageView imageView3 = this.mRightEarIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightEarIv");
            return null;
        }
        return imageView3;
    }

    private final MainTitleTalkbackHelper z1() {
        return (MainTitleTalkbackHelper) this.mMainTitleTalkbackHelper.getValue();
    }

    @Nullable
    public final t.a F1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (t.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        CommonTextView C1 = C1();
        if (!(C1 instanceof t.a)) {
            return null;
        }
        return C1;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CenterUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof CenterUIState.UpdateDataUIState) {
            Q1(((CenterUIState.UpdateDataUIState) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateSubTitleText) {
            a2(((CenterUIState.UpdateSubTitleText) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateSubTitle) {
            Z1(((CenterUIState.UpdateSubTitle) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateMutualMarkState) {
            CenterUIState.UpdateMutualMarkState updateMutualMarkState = (CenterUIState.UpdateMutualMarkState) state;
            Y1(updateMutualMarkState.b(), updateMutualMarkState.c(), updateMutualMarkState.d(), updateMutualMarkState.a());
            return;
        }
        if (state instanceof CenterUIState.UpdateGroupCount) {
            X1(((CenterUIState.UpdateGroupCount) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateVIPState) {
            j2((CenterUIState.UpdateVIPState) state);
            return;
        }
        if (state instanceof CenterUIState.UpdateMainTitle) {
            V1(((CenterUIState.UpdateMainTitle) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateResetSubTitleText) {
            c2(((CenterUIState.UpdateResetSubTitleText) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateEarIcon) {
            S1(((CenterUIState.UpdateEarIcon) state).a());
            return;
        }
        if (state instanceof CenterUIState.UpdateLyricsState) {
            CenterUIState.UpdateLyricsState updateLyricsState = (CenterUIState.UpdateLyricsState) state;
            U1(updateLyricsState.a(), updateLyricsState.b());
        } else if (state instanceof CenterUIState.PlayTitleCoverAnimation) {
            M1();
        } else if (state instanceof CenterUIState.UpdateTroopFlameState) {
            h2(((CenterUIState.UpdateTroopFlameState) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.bindViewAndData();
        p1();
        sendIntent(a.C7360a.f193915d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @NotNull
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof j.b) {
            Bundle bundle = new Bundle();
            bundle.putInt("title_height", D1().getRoot().getHeight());
            return bundle;
        }
        if (stateCmd instanceof j.a) {
            return H1(((j.a) stateCmd).a());
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends CenterUIState>> getObserverStates() {
        List<Class<? extends CenterUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{CenterUIState.UpdateDataUIState.class, CenterUIState.UpdateSubTitle.class, CenterUIState.UpdateGroupCount.class, CenterUIState.UpdateMutualMarkState.class, CenterUIState.UpdateMainTitle.class, CenterUIState.UpdateEarIcon.class, CenterUIState.PlayTitleCoverAnimation.class, CenterUIState.UpdateTroopFlameState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new CenterVB$onCreateView$1(this, null), 2, null);
        D1().f444911l.b(D1());
        RelativeLayout root = D1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        N1(null);
        B1().setText("");
        C1().setText("");
        T1(null);
        ImageView imageView = D1().f444909j;
        final Function0<Unit> function0 = this.mUpdateSubTitleIConSizeRunnable;
        imageView.removeCallbacks(new Runnable() { // from class: com.tencent.mobileqq.aio.title.center.h
            @Override // java.lang.Runnable
            public final void run() {
                CenterVB.L1(Function0.this);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, CenterUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new p();
    }

    @Nullable
    public final t.a y1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (t.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        KeyEvent.Callback B1 = B1();
        if (B1 instanceof t.a) {
            return (t.a) B1;
        }
        return null;
    }
}

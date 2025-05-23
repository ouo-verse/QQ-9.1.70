package com.tencent.mobileqq.troop.flame.detail.part;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.v;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import com.tencent.mobileqq.troop.flame.detail.view.TroopFlameView;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
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
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 ]2\u00020\u0001:\u0001^B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0003J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\n \u0013*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010-\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010 R\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010 R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010$R\u0016\u00106\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010$R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010$R\u0016\u0010>\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010@\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010$R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010$R\u0016\u0010H\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010$R\u0016\u0010J\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u00109R\u0016\u0010L\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u00109R\u0016\u0010N\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010$R\u0016\u0010P\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010$R\u0016\u0010R\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010$R\u0016\u0010T\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010$R\u0016\u0010V\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010CR\u0016\u0010X\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010CR\u0016\u0010Z\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010C\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/part/TroopFlameContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "X9", "initData", "Y9", "", "", "urlList", "ea", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Ljava/lang/String;", "V9", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/flame/detail/vm/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "W9", "()Lcom/tencent/mobileqq/troop/flame/detail/vm/a;", "vm", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "f", "U9", "()Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "troopInfoVm", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", tl.h.F, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "troopAvatar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "troopName", "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameView;", "flameView", BdhLogUtil.LogTag.Tag_Conn, "memberAvatar1", "D", "memberAvatar2", "E", "memberAvatar3", UserInfo.SEX_FEMALE, "Ljava/util/List;", "troopMemAvatars", "G", "troopMemberCnt", "H", "troopUinInfo", "Landroid/view/ViewGroup;", "I", "Landroid/view/ViewGroup;", "rankInfoViewGroup", "J", "activeDays", "K", "activeMembers", "L", "troopRankHint", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "troopRankHintIcon", "N", "troopRank", "P", "troopRankHintUnit", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "troopRankViewGroup", BdhLogUtil.LogTag.Tag_Req, "ruleViewGroup", ExifInterface.LATITUDE_SOUTH, "ruleDetail", "T", "minFlameRule", "U", "midFlameRule", "V", "maxFlameRule", "W", "minFlameImageView", "X", "midFlameImageView", "Y", "maxFlameImageView", "<init>", "(Ljava/lang/String;)V", "Z", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFlameContentPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private QQProAvatarView memberAvatar1;

    /* renamed from: D, reason: from kotlin metadata */
    private QQProAvatarView memberAvatar2;

    /* renamed from: E, reason: from kotlin metadata */
    private QQProAvatarView memberAvatar3;

    /* renamed from: F, reason: from kotlin metadata */
    private List<QQProAvatarView> troopMemAvatars;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView troopMemberCnt;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView troopUinInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup rankInfoViewGroup;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView activeDays;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView activeMembers;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView troopRankHint;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView troopRankHintIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView troopRank;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView troopRankHintUnit;

    /* renamed from: Q, reason: from kotlin metadata */
    private ViewGroup troopRankViewGroup;

    /* renamed from: R, reason: from kotlin metadata */
    private ViewGroup ruleViewGroup;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView ruleDetail;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView minFlameRule;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView midFlameRule;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView maxFlameRule;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView minFlameImageView;

    /* renamed from: X, reason: from kotlin metadata */
    private ImageView midFlameImageView;

    /* renamed from: Y, reason: from kotlin metadata */
    private ImageView maxFlameImageView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopInfoVm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView troopAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView troopName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TroopFlameView flameView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/part/TroopFlameContentPart$a;", "", "", "FLAME_LEVEL_1_ICON", "Ljava/lang/String;", "FLAME_LEVEL_2_ICON", "FLAME_LEVEL_3_ICON", "", "MEMBER_AVATAR_SIZE_DP", UserInfo.SEX_FEMALE, "RANK_PAGE_URL", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopFlameContentPart(@NotNull String troopUin) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
            return;
        }
        this.troopUin = troopUin;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.flame.detail.vm.a>() { // from class: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$vm$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFlameContentPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.troop.flame.detail.vm.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.troop.flame.detail.vm.a) TroopFlameContentPart.this.getViewModel(com.tencent.mobileqq.troop.flame.detail.vm.a.class) : (com.tencent.mobileqq.troop.flame.detail.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopBasicInfoViewModel>() { // from class: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$troopInfoVm$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFlameContentPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopBasicInfoViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TroopBasicInfoViewModel) TroopFlameContentPart.this.getViewModel(TroopBasicInfoViewModel.class) : (TroopBasicInfoViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.troopInfoVm = lazy2;
    }

    private final TroopBasicInfoViewModel U9() {
        return (TroopBasicInfoViewModel) this.troopInfoVm.getValue();
    }

    private final com.tencent.mobileqq.troop.flame.detail.vm.a W9() {
        return (com.tencent.mobileqq.troop.flame.detail.vm.a) this.vm.getValue();
    }

    private final void X9() {
        TextView textView = this.troopUinInfo;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUinInfo");
            textView = null;
        }
        textView.setText(getContext().getString(R.string.f2331376f, this.troopUin));
        QQProAvatarView qQProAvatarView = this.troopAvatar;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(4, this.troopUin, null);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        ImageView imageView = this.minFlameImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minFlameImageView");
            imageView = null;
        }
        imageView.setImageDrawable(URLDrawable.getDrawable("https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_rule_v1.png", obtain));
        ImageView imageView2 = this.midFlameImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("midFlameImageView");
            imageView2 = null;
        }
        imageView2.setImageDrawable(URLDrawable.getDrawable("https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_rule_v2.png", obtain));
        ImageView imageView3 = this.maxFlameImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxFlameImageView");
            imageView3 = null;
        }
        imageView3.setImageDrawable(URLDrawable.getDrawable("https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_rule_v3.png", obtain));
        com.tencent.mobileqq.troop.flame.detail.view.b bVar = com.tencent.mobileqq.troop.flame.detail.view.b.f296107a;
        TextView textView3 = this.activeDays;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeDays");
            textView3 = null;
        }
        bVar.f(textView3);
        TextView textView4 = this.activeMembers;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeMembers");
            textView4 = null;
        }
        bVar.f(textView4);
        TextView textView5 = this.troopRank;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRank");
        } else {
            textView2 = textView5;
        }
        bVar.f(textView2);
    }

    @SuppressLint({"SetTextI18n"})
    private final void Y9() {
        LiveData<com.tencent.mobileqq.troop.flame.detail.data.a> N1 = W9().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final TroopFlameContentPart$observerData$1 troopFlameContentPart$observerData$1 = new TroopFlameContentPart$observerData$1(this);
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.flame.detail.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFlameContentPart.Z9(Function1.this, obj);
            }
        });
        LiveData<String> I2 = U9().I2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$observerData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameContentPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                textView = TroopFlameContentPart.this.troopName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopName");
                    textView = null;
                }
                textView.setText(str);
            }
        };
        I2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.flame.detail.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFlameContentPart.aa(Function1.this, obj);
            }
        });
        LiveData<Integer> H2 = U9().H2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$observerData$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameContentPart.this);
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
                textView = TroopFlameContentPart.this.troopMemberCnt;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopMemberCnt");
                    textView = null;
                }
                textView.setText(num + "\u4eba");
            }
        };
        H2.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.flame.detail.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFlameContentPart.ba(Function1.this, obj);
            }
        });
        LiveData<List<String>> G2 = U9().G2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends String>, Unit> function13 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$observerData$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameContentPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> uinList) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) uinList);
                    return;
                }
                TroopFlameContentPart troopFlameContentPart = TroopFlameContentPart.this;
                Intrinsics.checkNotNullExpressionValue(uinList, "uinList");
                troopFlameContentPart.ea(uinList);
            }
        };
        G2.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.flame.detail.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFlameContentPart.ca(Function1.this, obj);
            }
        });
        LiveData<GroupExtFlameData> C2 = U9().C2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<GroupExtFlameData, Unit> function14 = new Function1<GroupExtFlameData, Unit>() { // from class: com.tencent.mobileqq.troop.flame.detail.part.TroopFlameContentPart$observerData$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFlameContentPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupExtFlameData groupExtFlameData) {
                invoke2(groupExtFlameData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupExtFlameData groupExtFlameData) {
                TroopFlameView troopFlameView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupExtFlameData);
                    return;
                }
                ITroopFlameApi.a flameViewDataFromPB = ((ITroopFlameApi) QRoute.api(ITroopFlameApi.class)).getFlameViewDataFromPB(groupExtFlameData);
                if (flameViewDataFromPB.f296043d) {
                    troopFlameView = TroopFlameContentPart.this.flameView;
                    if (troopFlameView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("flameView");
                        troopFlameView = null;
                    }
                    troopFlameView.c(flameViewDataFromPB.f296040a, flameViewDataFromPB.f296041b, flameViewDataFromPB.f296042c);
                }
            }
        };
        C2.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.troop.flame.detail.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFlameContentPart.da(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(List<String> urlList) {
        if (urlList.size() > 3) {
            return;
        }
        int i3 = 0;
        int i16 = 0;
        for (Object obj : urlList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            List<QQProAvatarView> list = this.troopMemAvatars;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopMemAvatars");
                list = null;
            }
            QQProAvatarView qQProAvatarView = list.get(i16);
            qQProAvatarView.setVisibility(i3);
            qQProAvatarView.x(1, str, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(Utils.n(18.0f, getContext().getResources())).a());
            i16 = i17;
            i3 = 0;
        }
    }

    private final void initData() {
        Long longOrNull;
        long j3;
        AppInterface appInterface;
        Y9();
        com.tencent.mobileqq.troop.flame.detail.vm.a W9 = W9();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        W9.O1(j3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("troop_uin", this.troopUin);
        v a16 = v.INSTANCE.a(bundle);
        if (a16 != null) {
            U9().O2(appInterface, a16, false);
        }
    }

    @NotNull
    public final String V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        List<QQProAvatarView> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f101245uo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troop_avatar)");
        this.troopAvatar = (QQProAvatarView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.k0j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.troop_name_tv)");
        this.troopName = (TextView) findViewById2;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f165232v94);
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TroopFlameView troopFlameView = new TroopFlameView(context);
        this.flameView = troopFlameView;
        relativeLayout.addView(troopFlameView);
        View findViewById3 = rootView.findViewById(R.id.z1g);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.member_avatar_1)");
        this.memberAvatar1 = (QQProAvatarView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.z1h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.member_avatar_2)");
        this.memberAvatar2 = (QQProAvatarView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.z1i);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.member_avatar_3)");
        this.memberAvatar3 = (QQProAvatarView) findViewById5;
        QQProAvatarView[] qQProAvatarViewArr = new QQProAvatarView[3];
        QQProAvatarView qQProAvatarView = this.memberAvatar1;
        QQProAvatarView qQProAvatarView2 = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberAvatar1");
            qQProAvatarView = null;
        }
        qQProAvatarViewArr[0] = qQProAvatarView;
        QQProAvatarView qQProAvatarView3 = this.memberAvatar2;
        if (qQProAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberAvatar2");
            qQProAvatarView3 = null;
        }
        qQProAvatarViewArr[1] = qQProAvatarView3;
        QQProAvatarView qQProAvatarView4 = this.memberAvatar3;
        if (qQProAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberAvatar3");
        } else {
            qQProAvatarView2 = qQProAvatarView4;
        }
        qQProAvatarViewArr[2] = qQProAvatarView2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) qQProAvatarViewArr);
        this.troopMemAvatars = listOf;
        View findViewById6 = rootView.findViewById(R.id.f102595yb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.troop_member_cnt_tv)");
        this.troopMemberCnt = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f10396621);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.troop_uin_info_tv)");
        this.troopUinInfo = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.sad);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.active_days_tv)");
        this.activeDays = (TextView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.saf);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.active_members_tv)");
        this.activeMembers = (TextView) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.f1034860q);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.troop_rank_hint)");
        this.troopRankHint = (TextView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.f1034960r);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.troop_rank_hint_icon)");
        this.troopRankHintIcon = (ImageView) findViewById11;
        View findViewById12 = rootView.findViewById(R.id.f1035260u);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.troop_rank_textview)");
        this.troopRank = (TextView) findViewById12;
        View findViewById13 = rootView.findViewById(R.id.f1035060s);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.troop_rank_hint_unit)");
        this.troopRankHintUnit = (TextView) findViewById13;
        View findViewById14 = rootView.findViewById(R.id.f1035360v);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.troop_rank_viewgroup)");
        this.troopRankViewGroup = (ViewGroup) findViewById14;
        View findViewById15 = rootView.findViewById(R.id.f786847q);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.rule_detail)");
        this.ruleDetail = (TextView) findViewById15;
        View findViewById16 = rootView.findViewById(R.id.z6t);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.min_flame_rule_tv)");
        this.minFlameRule = (TextView) findViewById16;
        View findViewById17 = rootView.findViewById(R.id.z6j);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(R.id.mid_flame_rule_tv)");
        this.midFlameRule = (TextView) findViewById17;
        View findViewById18 = rootView.findViewById(R.id.yyw);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.max_flame_rule_tv)");
        this.maxFlameRule = (TextView) findViewById18;
        View findViewById19 = rootView.findViewById(R.id.f165229v91);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(R.id.flame_level_1_iv)");
        this.minFlameImageView = (ImageView) findViewById19;
        View findViewById20 = rootView.findViewById(R.id.f165230v92);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(R.id.flame_level_2_iv)");
        this.midFlameImageView = (ImageView) findViewById20;
        View findViewById21 = rootView.findViewById(R.id.f165231v93);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(R.id.flame_level_3_iv)");
        this.maxFlameImageView = (ImageView) findViewById21;
        View findViewById22 = rootView.findViewById(R.id.f1034760p);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "findViewById(R.id.troop_rank_detail_viewgroup)");
        this.rankInfoViewGroup = (ViewGroup) findViewById22;
        View findViewById23 = rootView.findViewById(R.id.f1035160t);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "findViewById(R.id.troop_rank_rule_viewgroup)");
        this.ruleViewGroup = (ViewGroup) findViewById23;
        X9();
        initData();
    }
}

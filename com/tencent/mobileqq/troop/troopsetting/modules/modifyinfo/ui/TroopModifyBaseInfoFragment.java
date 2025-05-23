package com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.viewmodel.TroopModifyBaseInfoViewModel;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.widget.ap;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J&\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u001c\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0002J\f\u0010(\u001a\u00020'*\u00020$H\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0002J$\u00100\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000b0.H\u0002J\u0010\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0003H\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u000bH\u0002R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010R\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010C\u001a\u0004\bP\u0010QR\u001b\u0010W\u001a\u00020S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010C\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010C\u001a\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/ui/TroopModifyBaseInfoFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController$e;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "bundle", "Z9", "Landroid/content/Intent;", "intent", "onNewIntent", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "initNavBar", "bi", "initData", "Sh", "Oh", "Yh", "", "troopUin", "onGoPic", "Lcom/tencent/mobileqq/troop/avatar/TroopAvatarController;", "Gh", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "curTroopInfo", "Xh", "", "Th", "ci", "Landroid/graphics/Bitmap;", "bm", "Wh", "Vh", "Lkotlin/Function1;", "callback", "Ih", "resId", "Zh", "ai", "Hh", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/RelativeLayout;", "editAvatarContainer", "Lcom/tencent/mobileqq/widget/RoundImageView;", "D", "Lcom/tencent/mobileqq/widget/RoundImageView;", "avatarView", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "E", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "titleView", "Lcom/tencent/mobileqq/widget/ap;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/mobileqq/widget/ap;", "notifier", "Lcom/tencent/common/app/AppInterface;", "G", "Jh", "()Lcom/tencent/common/app/AppInterface;", "app", "H", "Ljava/lang/String;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel;", "I", "Nh", "()Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel;", "viewModel", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "J", "Lh", "()Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "faceDecoder", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarDataService;", "K", "Kh", "()Lcom/tencent/mobileqq/avatar/api/IQQAvatarDataService;", "avatarCache", "L", "Lcom/tencent/mobileqq/troop/avatar/TroopAvatarController;", "troopAvatarController", "<init>", "()V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopModifyBaseInfoFragment extends QIphoneTitleBarFragment implements TroopPhotoController.e {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RelativeLayout editAvatarContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private RoundImageView avatarView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISingleLineInputView titleView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy notifier;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy app;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy faceDecoder;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarCache;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TroopAvatarController troopAvatarController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/ui/TroopModifyBaseInfoFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "troopUin", "Landroid/os/Bundle;", "originBundle", "", "a", "BUNDLE_KEY_NEW_TROOP_NAME", "Ljava/lang/String;", "BUNDLE_KEY_TROOP_UIN", "FILE_NAME", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull Activity activity, int requestCode, @NotNull String troopUin, @Nullable Bundle originBundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(requestCode), troopUin, originBundle);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (originBundle == null) {
                originBundle = new Bundle();
            }
            originBundle.putString("bundle_key_troop_uin", troopUin);
            Intent intent = new Intent();
            intent.putExtras(originBundle);
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) TroopModifyBaseInfoFragment.class, requestCode);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopModifyBaseInfoFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ap>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$notifier$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ap invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new ap(TroopModifyBaseInfoFragment.this.getActivity()) : (ap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.notifier = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(TroopModifyBaseInfoFragment$app$2.INSTANCE);
            this.app = lazy2;
            this.troopUin = "";
            final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$special$$inlined$viewModels$default$1
                static IPatchRedirector $redirector_;

                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Fragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Fragment invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Fragment.this : (Fragment) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            };
            this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TroopModifyBaseInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$special$$inlined$viewModels$default$2
                static IPatchRedirector $redirector_;

                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Function0.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ViewModelStore invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ViewModelStore) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                    Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                    return viewModelStore;
                }
            }, null);
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<IFaceDecoder>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$faceDecoder$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final IFaceDecoder invoke() {
                    AppInterface Jh;
                    AppInterface Jh2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (IFaceDecoder) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Jh = TroopModifyBaseInfoFragment.this.Jh();
                    IQQAvatarService iQQAvatarService = (IQQAvatarService) Jh.getRuntimeService(IQQAvatarService.class, "");
                    Jh2 = TroopModifyBaseInfoFragment.this.Jh();
                    return iQQAvatarService.getInstance(Jh2);
                }
            });
            this.faceDecoder = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<IQQAvatarDataService>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$avatarCache$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final IQQAvatarDataService invoke() {
                    AppInterface Jh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (IQQAvatarDataService) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Jh = TroopModifyBaseInfoFragment.this.Jh();
                    IRuntimeService runtimeService = Jh.getRuntimeService(IQQAvatarDataService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026va, ProcessConstant.MAIN)");
                    return (IQQAvatarDataService) runtimeService;
                }
            });
            this.avatarCache = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final TroopAvatarController Gh(String troopUin, TroopPhotoController.e onGoPic) {
        TroopAvatarController troopAvatarController = this.troopAvatarController;
        if (troopAvatarController != null) {
            troopAvatarController.C();
        }
        TroopAvatarController troopAvatarController2 = new TroopAvatarController(getActivity(), getActivity(), Jh(), BundleKt.bundleOf(TuplesKt.to("troopUin", troopUin), TuplesKt.to("type", 1)));
        troopAvatarController2.N(onGoPic);
        this.troopAvatarController = troopAvatarController2;
        return troopAvatarController2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh() {
        if (Mh().c()) {
            Mh().b();
        }
    }

    private final void Ih(String troopUin, Function1<? super Bitmap, Unit> callback) {
        Bitmap decodeResource;
        TroopInfo W1 = Nh().W1();
        boolean z16 = false;
        if (W1 != null && !W1.hasSetNewTroopHead) {
            z16 = true;
        }
        if (z16 && (decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.myo, null)) != null) {
            callback.invoke(decodeResource);
        } else {
            com.tencent.mobileqq.troop.troopsetting.modules.base.h.f301151a.b(Lh(), troopUin, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppInterface Jh() {
        return (AppInterface) this.app.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQQAvatarDataService Kh() {
        return (IQQAvatarDataService) this.avatarCache.getValue();
    }

    private final IFaceDecoder Lh() {
        Object value = this.faceDecoder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-faceDecoder>(...)");
        return (IFaceDecoder) value;
    }

    private final ap Mh() {
        return (ap) this.notifier.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopModifyBaseInfoViewModel Nh() {
        return (TroopModifyBaseInfoViewModel) this.viewModel.getValue();
    }

    private final void Oh() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.upv);
        RelativeLayout it = (RelativeLayout) findViewById;
        it.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopModifyBaseInfoFragment.Ph(TroopModifyBaseInfoFragment.this, view);
            }
        });
        g gVar = g.f301198a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        gVar.c(it);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026tAvatarView(it)\n        }");
        this.editAvatarContainer = it;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.y_8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.iv_troop_avatar)");
        this.avatarView = (RoundImageView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TroopModifyBaseInfoFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Yh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(TroopModifyBaseInfoFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bi();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Sh() {
        int i3;
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.y_a);
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) findViewById;
        qUISingleLineInputView.setPromptText(getString(R.string.f234957ac));
        qUISingleLineInputView.setMaxWordCount(96);
        qUISingleLineInputView.setInputViewWordCountCalculator(new com.tencent.mobileqq.troop.troopsetting.modules.base.ui.a());
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026untCalculator()\n        }");
        this.titleView = qUISingleLineInputView;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            qUISingleLineInputView = null;
        }
        QUISingleLineInputView qUISingleLineInputView3 = this.titleView;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView3;
        }
        CharSequence d16 = qUISingleLineInputView2.d();
        if (d16 != null) {
            i3 = d16.length();
        } else {
            i3 = 0;
        }
        qUISingleLineInputView.setTextSelection(i3);
    }

    private final boolean Th(TroopInfo troopInfo) {
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && troopInfo.mIsFreezed == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(TroopModifyBaseInfoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.titleView;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.q();
        QUISingleLineInputView qUISingleLineInputView3 = this$0.titleView;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView3;
        }
        qUISingleLineInputView2.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(String troopUin) {
        Ih(troopUin, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$refreshAvatarImage$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap it) {
                RoundImageView roundImageView;
                AppInterface Jh;
                RoundImageView roundImageView2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                roundImageView = TroopModifyBaseInfoFragment.this.avatarView;
                RoundImageView roundImageView3 = null;
                if (roundImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                    roundImageView = null;
                }
                roundImageView.setImageBitmap(it);
                IThemeUtilApi iThemeUtilApi = (IThemeUtilApi) QRoute.api(IThemeUtilApi.class);
                Jh = TroopModifyBaseInfoFragment.this.Jh();
                if (iThemeUtilApi.isInNightMode(Jh)) {
                    roundImageView2 = TroopModifyBaseInfoFragment.this.avatarView;
                    if (roundImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                    } else {
                        roundImageView3 = roundImageView2;
                    }
                    roundImageView3.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                }
            }
        });
    }

    private final String Wh(Bitmap bm5) {
        File externalCacheDir;
        Context context = getContext();
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return "";
        }
        String str = externalCacheDir + File.separator + "qq_troop_default_avatar.png";
        File file = new File(str);
        if (!file.exists()) {
            try {
                BaseImageUtil.saveBitmapToFile(bm5, file);
            } catch (IOException e16) {
                QLog.e("TroopModifyBaseInfoFragment", 1, "updateAndSetDefaultAvatar: " + e16);
                return "";
            }
        }
        return str;
    }

    private final void Xh(TroopInfo curTroopInfo) {
        if (Th(curTroopInfo)) {
            return;
        }
        Z9(BundleKt.bundleOf(TuplesKt.to("IS_COVER", Boolean.FALSE), TuplesKt.to("IS_EDIT", Boolean.TRUE)));
    }

    private final void Yh() {
        TroopInfo W1 = Nh().W1();
        if (W1 == null) {
            return;
        }
        if (!W1.hasSetNewTroopHead) {
            Gh(this.troopUin, this).H();
        } else {
            Xh(W1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(int resId) {
        String string = getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(resId)");
        QQToast.makeText(getContext(), 1, string, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai() {
        Mh().e(0, getString(R.string.f2324474k), 0);
    }

    private final void bi() {
        boolean isBlank;
        if (!AppNetConnInfo.isNetSupport()) {
            Zh(R.string.ci5);
            return;
        }
        QUISingleLineInputView qUISingleLineInputView = this.titleView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            qUISingleLineInputView = null;
        }
        CharSequence d16 = qUISingleLineInputView.d();
        if (d16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(d16.toString());
            if (!isBlank) {
                Nh().c2(d16.toString(), new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$submitBaseInfo$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TroopModifyBaseInfoViewModel Nh;
                        TroopInfo c16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        Nh = TroopModifyBaseInfoFragment.this.Nh();
                        h value = Nh.X1().getValue();
                        String str = (value == null || (c16 = value.c()) == null) ? null : c16.troopname;
                        if (str == null) {
                            str = "";
                        }
                        FragmentActivity activity = TroopModifyBaseInfoFragment.this.getActivity();
                        if (activity != null) {
                            Intent intent = new Intent();
                            Bundle arguments = TroopModifyBaseInfoFragment.this.getArguments();
                            if (arguments != null) {
                                intent.putExtras(arguments);
                            }
                            intent.putExtra("bundle_key_new_troop_name", str);
                            Unit unit = Unit.INSTANCE;
                            activity.setResult(-1, intent);
                        }
                        FragmentActivity activity2 = TroopModifyBaseInfoFragment.this.getActivity();
                        if (activity2 != null) {
                            activity2.finish();
                        }
                    }
                });
                return;
            }
        }
        Zh(R.string.f235327bc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci() {
        QLog.d("TroopModifyBaseInfoFragment", 1, "uploadAndSetDefaultAvatar");
        final Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.myo);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopModifyBaseInfoFragment.di(TroopModifyBaseInfoFragment.this, decodeResource);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(final TroopModifyBaseInfoFragment this$0, final Bitmap bm5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(bm5, "bm");
        final String Wh = this$0.Wh(bm5);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.f
            @Override // java.lang.Runnable
            public final void run() {
                TroopModifyBaseInfoFragment.ei(Wh, this$0, bm5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(String filePath, final TroopModifyBaseInfoFragment this$0, final Bitmap bitmap) {
        boolean z16;
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (filePath.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this$0.Nh().d2(new Function0<Unit>(bitmap) { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$uploadAndSetDefaultAvatar$1$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bitmap $bm;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$bm = bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this, (Object) bitmap);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IQQAvatarDataService Kh;
                    String str;
                    QUISingleLineInputView qUISingleLineInputView;
                    boolean isBlank;
                    TroopModifyBaseInfoViewModel Nh;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Kh = TroopModifyBaseInfoFragment.this.Kh();
                    Bitmap bm5 = this.$bm;
                    Intrinsics.checkNotNullExpressionValue(bm5, "bm");
                    str = TroopModifyBaseInfoFragment.this.troopUin;
                    com.tencent.mobileqq.troop.troopsetting.modules.base.h.d(Kh, bm5, str);
                    qUISingleLineInputView = TroopModifyBaseInfoFragment.this.titleView;
                    if (qUISingleLineInputView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                        qUISingleLineInputView = null;
                    }
                    CharSequence d16 = qUISingleLineInputView.d();
                    if (d16 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(d16.toString());
                        if (!isBlank) {
                            Nh = TroopModifyBaseInfoFragment.this.Nh();
                            Nh.a2(d16.toString());
                            return;
                        }
                    }
                    TroopModifyBaseInfoFragment.this.Zh(R.string.f234937aa);
                }
            });
            TroopAvatarController Gh = this$0.Gh(this$0.troopUin, null);
            Gh.c(this$0.Nh().T1());
            Gh.U();
            Gh.d();
            Gh.K(false);
            Gh.G(filePath, "");
            return;
        }
        this$0.Zh(R.string.f234937aa);
    }

    private final void initData() {
        LiveData<h> X1 = Nh().X1();
        final Function1<h, Unit> function1 = new Function1<h, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(h hVar) {
                QUISingleLineInputView qUISingleLineInputView;
                TroopModifyBaseInfoViewModel Nh;
                String U1;
                QUISingleLineInputView qUISingleLineInputView2;
                QUISingleLineInputView qUISingleLineInputView3;
                QUISingleLineInputView qUISingleLineInputView4;
                QUISingleLineInputView qUISingleLineInputView5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
                    return;
                }
                if (hVar.d()) {
                    TroopModifyBaseInfoFragment.this.ai();
                } else {
                    TroopModifyBaseInfoFragment.this.Hh();
                }
                qUISingleLineInputView = TroopModifyBaseInfoFragment.this.titleView;
                QUISingleLineInputView qUISingleLineInputView6 = null;
                if (qUISingleLineInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    qUISingleLineInputView = null;
                }
                if (hVar.c().hasSetNewTroopName) {
                    U1 = hVar.c().troopname;
                } else {
                    Nh = TroopModifyBaseInfoFragment.this.Nh();
                    U1 = Nh.U1();
                }
                qUISingleLineInputView.setContentText(U1);
                qUISingleLineInputView2 = TroopModifyBaseInfoFragment.this.titleView;
                if (qUISingleLineInputView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    qUISingleLineInputView2 = null;
                }
                qUISingleLineInputView3 = TroopModifyBaseInfoFragment.this.titleView;
                if (qUISingleLineInputView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    qUISingleLineInputView3 = null;
                }
                CharSequence d16 = qUISingleLineInputView3.d();
                qUISingleLineInputView2.setTextSelection(d16 != null ? d16.length() : 0);
                if (!hVar.c().hasSetNewTroopName) {
                    qUISingleLineInputView5 = TroopModifyBaseInfoFragment.this.titleView;
                    if (qUISingleLineInputView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    } else {
                        qUISingleLineInputView6 = qUISingleLineInputView5;
                    }
                    qUISingleLineInputView6.setPromptText(TroopModifyBaseInfoFragment.this.getString(R.string.f234957ac));
                } else {
                    qUISingleLineInputView4 = TroopModifyBaseInfoFragment.this.titleView;
                    if (qUISingleLineInputView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    } else {
                        qUISingleLineInputView6 = qUISingleLineInputView4;
                    }
                    qUISingleLineInputView6.setPromptText(TroopModifyBaseInfoFragment.this.getString(R.string.f234947ab));
                }
                TroopModifyBaseInfoFragment troopModifyBaseInfoFragment = TroopModifyBaseInfoFragment.this;
                String troopUin = hVar.c().getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin, "it.info.troopUin");
                troopModifyBaseInfoFragment.Vh(troopUin);
            }
        };
        X1.observe(this, new Observer() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopModifyBaseInfoFragment.Qh(Function1.this, obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopModifyBaseInfoFragment$initData$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopModifyBaseInfoFragment$initData$3(this, null), 3, null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("bundle_key_troop_uin", "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(BUNDLE_KEY_TROOP_UIN, \"\")");
            this.troopUin = string;
            Nh().Z1(Jh(), this.troopUin);
        }
    }

    private final void initNavBar() {
        setTitle(getString(R.string.f2324574l));
        setRightButtonText(getString(R.string.b9f), new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopModifyBaseInfoFragment.Rh(TroopModifyBaseInfoFragment.this, view);
            }
        });
        g gVar = g.f301198a;
        RelativeLayout titleRoot = this.titleRoot;
        Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
        TextView rightViewText = this.rightViewText;
        Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
        gVar.a(titleRoot, rightViewText);
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.e
    public void Z9(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        TroopInfo W1 = Nh().W1();
        if (W1 == null) {
            return;
        }
        bundle.putAll(BundleKt.bundleOf(TuplesKt.to("index", 0), TuplesKt.to("troop_uin", W1.getTroopUin()), TuplesKt.to(AppConstants.Key.TROOP_INFO_IS_MEMBER, Boolean.TRUE)));
        Intent intent = new Intent();
        intent.setClass(context, ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
        intent.putExtras(bundle);
        intent.addFlags(603979776);
        if (QLog.isColorLevel()) {
            QLog.i("TroopModifyBaseInfoFragment", 2, "gotoBigPic code=260 bundle=" + bundle);
        }
        startActivityForResult(intent, 260);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            g gVar = g.f301198a;
            View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
            Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
            gVar.b(activity, mContentView);
        }
        initNavBar();
        Sh();
        Oh();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f169150i01;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TroopAvatarController troopAvatarController;
        TroopInfo W1;
        String troopUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 257) {
            if (requestCode == 260 && (W1 = Nh().W1()) != null && (troopUin = W1.getTroopUin()) != null) {
                Vh(troopUin);
                return;
            }
            return;
        }
        if (resultCode == -1 && (troopAvatarController = this.troopAvatarController) != null) {
            troopAvatarController.I();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        Lh().destory();
        TroopAvatarController troopAvatarController = this.troopAvatarController;
        if (troopAvatarController != null) {
            troopAvatarController.C();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@NotNull Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = intent.getStringExtra(ITroopPhotoUtilsApi.KEY_CLIP_INFO);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        if (stringExtra.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopModifyBaseInfoFragment", 2, "doOnNewIntent clip=" + str + " path=" + stringExtra);
            }
            TroopAvatarController troopAvatarController = this.troopAvatarController;
            if (troopAvatarController != null) {
                troopAvatarController.G(stringExtra, str);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QUISingleLineInputView qUISingleLineInputView = this.titleView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.p();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        QUISingleLineInputView qUISingleLineInputView = this.titleView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopModifyBaseInfoFragment.Uh(TroopModifyBaseInfoFragment.this);
            }
        }, 300L);
    }
}

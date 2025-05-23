package com.tencent.mobileqq.setting.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.e;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\b&\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J&\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010J\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010D\u001a\u0004\bI\u0010F\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initUI", "initNavBar", "", "from", "rh", "", "color", "sh", "offset", "", "isDeviceSupportBlur", OcrConfig.CHINESE, "", c.f123400v, "yh", "needImmersive", "", "title", "setTitle", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onPostThemeChanged", "onBackEvent", "onDestroyView", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "vh", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "setQuiSecNavBar", "(Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;)V", "quiSecNavBar", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "D", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "wh", "()Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "setRecyclerView", "(Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;)V", "recyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "E", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "th", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "setAdapter", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)V", "adapter", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getSettingRootView", "()Landroid/view/View;", "setSettingRootView", "(Landroid/view/View;)V", "settingRootView", "G", "Lkotlin/Lazy;", "xh", "()I", "topPadding", "H", "uh", "maxAlphaOffset", "<init>", "()V", "I", "a", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseSettingFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUISecNavBar quiSecNavBar;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SettingOverScrollRecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View settingRootView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy topPadding;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy maxAlphaOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.setting.fragment.BaseSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/setting/fragment/BaseSettingFragment$b", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "", "offsetY", "", "onVerticalScroll", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements SettingOverScrollRecyclerView.d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f286510b;

        b(boolean z16) {
            this.f286510b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BaseSettingFragment.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView.d
        public void onVerticalScroll(int offsetY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BaseSettingFragment.this.zh(offsetY, this.f286510b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, offsetY);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseSettingFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.setting.fragment.BaseSettingFragment$topPadding$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseSettingFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Context requireContext = BaseSettingFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    return Integer.valueOf(e.b(requireContext));
                }
            });
            this.topPadding = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.setting.fragment.BaseSettingFragment$maxAlphaOffset$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseSettingFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    int xh5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    xh5 = BaseSettingFragment.this.xh();
                    return Integer.valueOf(xh5 / 2);
                }
            });
            this.maxAlphaOffset = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void initNavBar() {
        SettingOverScrollRecyclerView settingOverScrollRecyclerView;
        int i3;
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        if (isSettingPageNavNeedBlur) {
            settingOverScrollRecyclerView = this.recyclerView;
        } else {
            settingOverScrollRecyclerView = null;
        }
        if (QQTheme.isNowThemeDefaultNight()) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setBlur(isSettingPageNavNeedBlur, settingOverScrollRecyclerView, i3);
        }
        SettingOverScrollRecyclerView settingOverScrollRecyclerView2 = this.recyclerView;
        if (settingOverScrollRecyclerView2 != null) {
            if (isSettingPageNavNeedAlpha) {
                settingOverScrollRecyclerView2.setOnVerticalScrollListener(new b(isSettingPageNavNeedBlur));
            } else {
                settingOverScrollRecyclerView2.setOnVerticalScrollListener(null);
                yh(1.0f, isSettingPageNavNeedBlur);
            }
        }
    }

    private final void initUI(View rootView) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.jo9);
        this.quiSecNavBar = qUISecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_LEFT_BUTTON, "\u8fd4\u56de");
        }
        QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
        if (qUISecNavBar2 != null) {
            qUISecNavBar2.S(this);
        }
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 != null) {
            qUISecNavBar3.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.setting.fragment.BaseSettingFragment$initUI$1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes18.dex */
                public /* synthetic */ class a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f286511a;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34172);
                        $redirector_ = redirector;
                        if (redirector != null && redirector.hasPatch((short) 1)) {
                            redirector.redirect((short) 1);
                            return;
                        }
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f286511a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseSettingFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View v3, @NotNull BaseAction action) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) action);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(v3, "v");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f286511a[action.ordinal()] == 1) {
                        BaseSettingFragment.this.onBackEvent();
                    }
                }
            });
        }
        this.recyclerView = (SettingOverScrollRecyclerView) rootView.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, true, 3, null);
        this.adapter = qUIListItemAdapter;
        SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
        if (settingOverScrollRecyclerView != null) {
            settingOverScrollRecyclerView.setClipToPadding(false);
            settingOverScrollRecyclerView.setPadding(0, xh(), 0, 0);
            settingOverScrollRecyclerView.setAdapter(qUIListItemAdapter);
        }
        initNavBar();
        View findViewById = rootView.findViewById(R.id.f98235mj);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                layoutParams.height = xh();
                findViewById.setLayoutParams(layoutParams);
            }
            findViewById.setClickable(true);
        }
    }

    private final void rh(String from) {
        Drawable drawable;
        Integer orNull;
        View view = this.settingRootView;
        if (view != null) {
            drawable = view.getBackground();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof SkinnableBitmapDrawable)) {
            QLog.e("BaseSettingFragment", 1, "[checkBackground] from=" + from + ", not SkinnableBitmapDrawable.");
            return;
        }
        try {
            ColorStateList colorStateList = requireContext().getResources().getColorStateList(R.color.qui_common_bg_bottom_standard, null);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "requireContext().resourc\u2026   null\n                )");
            if (!(colorStateList instanceof SkinnableColorStateList)) {
                QLog.e("BaseSettingFragment", 1, "[checkBackground] from=" + from + ", not SkinnableColorStateList.");
            } else {
                int[] colors = ((SkinnableColorStateList) colorStateList).getColors();
                Intrinsics.checkNotNullExpressionValue(colors, "bgBottomStandardColorStateList.colors");
                orNull = ArraysKt___ArraysKt.getOrNull(colors, 0);
                if (orNull != null) {
                    QLog.i("BaseSettingFragment", 1, "[checkBackground] from=" + from + ", defaultColor=" + sh(orNull.intValue()));
                }
            }
        } catch (Exception e16) {
            QLog.e("BaseSettingFragment", 1, "[checkBackground] error : ", e16);
        }
    }

    private final String sh(int color) {
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(color & 16777215)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } catch (Exception e16) {
            QLog.e("BaseSettingFragment", 1, "colorToHexStr error : ", e16);
            return "";
        }
    }

    private final int uh() {
        return ((Number) this.maxAlphaOffset.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int xh() {
        return ((Number) this.topPadding.getValue()).intValue();
    }

    private final void yh(float alpha, boolean isDeviceSupportBlur) {
        if (isDeviceSupportBlur) {
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setTitleBlurAlpha(alpha);
                return;
            }
            return;
        }
        QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
        if (qUISecNavBar2 != null) {
            qUISecNavBar2.setTitleAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(int offset, boolean isDeviceSupportBlur) {
        float f16;
        if (offset <= 0) {
            f16 = 0.0f;
        } else if (offset < uh()) {
            f16 = (offset * 1.0f) / uh();
        } else {
            f16 = 1.0f;
        }
        yh(f16, isDeviceSupportBlur);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return false;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            rootView = (View) iPatchRedirector.redirect((short) 12, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            rootView = inflater.inflate(R.layout.h3p, container, false);
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            initUI(rootView);
            this.settingRootView = rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onDestroyView();
        SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
        if (settingOverScrollRecyclerView != null) {
            settingOverScrollRecyclerView.setOnVerticalScrollListener(null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        initNavBar();
        rh("onPostThemeChanged");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        rh(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
    }

    public final void setTitle(@NotNull CharSequence title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) title);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setCenterText(title);
        }
    }

    @Nullable
    public final QUIListItemAdapter th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.adapter;
    }

    @Nullable
    public final QUISecNavBar vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUISecNavBar) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.quiSecNavBar;
    }

    @Nullable
    public final SettingOverScrollRecyclerView wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SettingOverScrollRecyclerView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.recyclerView;
    }
}

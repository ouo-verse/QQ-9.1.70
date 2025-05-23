package i64;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.title.SlashTitleUIState;
import i64.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u00013B\u0011\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J6\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bH\u0002J6\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\tH\u0016J\"\u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010!H\u0016J \u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0016R\u0014\u0010)\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(\u00a8\u00064"}, d2 = {"Li64/d;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Li64/a;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleBannerState;", "state", "", "e1", "", "iconRes", "textRes", "i1", "", "titleIconUrl", "", "isShowRightText", "titleTextColor", "titleIconTintColor", "j1", "url", "textText", "k1", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleTipState;", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "isHalfMode", "accumulatedValue", "totalAvailableHint", "w0", "e", "Z", "mNeedRegisterHeightProviderCallback", "Lfn2/e;", "f", "Lfn2/e;", "mBinding", h.F, "reportImpl", "<init>", "(Z)V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends SlashDialogVB<a, SlashTitleUIState, w64.e<u54.c>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mNeedRegisterHeightProviderCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private fn2.e mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean reportImpl;

    public d() {
        this(false, 1, null);
    }

    private final void e1(SlashTitleUIState.TitleBannerState state) {
        String str;
        String str2;
        fn2.e eVar = null;
        switch (state.getTitleStyle()) {
            case 1:
                fn2.e eVar2 = this.mBinding;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar2 = null;
                }
                ImageView imageView = eVar2.f400119c;
                Resources resources = getMContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "mContext.resources");
                Drawable d16 = u64.c.d(resources, R.drawable.qui_time);
                if (d16 != null) {
                    d16.setColorFilter(new PorterDuffColorFilter(getMContext().getColor(R.color.qui_common_text_secondary_light), PorterDuff.Mode.SRC_IN));
                } else {
                    d16 = null;
                }
                imageView.setImageDrawable(d16);
                fn2.e eVar3 = this.mBinding;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar = eVar3;
                }
                eVar.f400120d.setText(n64.c.c(getMContext()));
                return;
            case 2:
                i1(R.drawable.qui_gallery, R.string.f223436g8);
                return;
            case 3:
                i1(R.drawable.qui_debug, R.string.f223456g_);
                return;
            case 4:
                l1(this, "https://static-res.qq.com/static-res/adelie/aio/aio_adelie_ai_search_gray_icon.png", R.string.f223446g9, false, 0, 0, 28, null);
                return;
            case 5:
                i1(R.drawable.qui_ai_write, R.string.f223466ga);
                return;
            case 6:
                if (state.getCustomTitleInfo() != null) {
                    String titleIcon = state.getCustomTitleInfo().getTitleIcon();
                    if (titleIcon == null) {
                        str = "";
                    } else {
                        str = titleIcon;
                    }
                    String titleText = state.getCustomTitleInfo().getTitleText();
                    if (titleText == null) {
                        str2 = "";
                    } else {
                        str2 = titleText;
                    }
                    k1(str, str2, false, getMContext().getColor(R.color.qui_common_text_primary), getMContext().getColor(R.color.qui_common_icon_primary));
                    return;
                }
                i1(R.drawable.qui_gallery, R.string.f223436g8);
                return;
            default:
                fn2.e eVar4 = this.mBinding;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar4 = null;
                }
                ImageView imageView2 = eVar4.f400119c;
                Drawable b16 = u64.c.b(String.valueOf(state.getRobotUin()));
                if (b16 == null) {
                    b16 = ResourcesCompat.getDrawable(getMContext().getResources(), R.drawable.guild_robot_default_avatar, null);
                }
                imageView2.setImageDrawable(b16);
                fn2.e eVar5 = this.mBinding;
                if (eVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar = eVar5;
                }
                eVar.f400120d.setText(state.getRobotName());
                return;
        }
    }

    private final void f1(SlashTitleUIState.TitleTipState state) {
        fn2.e eVar = null;
        if (state.getShowTip()) {
            fn2.e eVar2 = this.mBinding;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar = eVar2;
            }
            eVar.f400118b.setVisibility(0);
            eVar.f400120d.setVisibility(8);
            eVar.f400119c.setVisibility(8);
            return;
        }
        fn2.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar3;
        }
        eVar.f400118b.setVisibility(8);
        eVar.f400120d.setVisibility(0);
        eVar.f400119c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C10510a.f407318d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i1(int iconRes, int textRes) {
        fn2.e eVar = this.mBinding;
        fn2.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        ImageView imageView = eVar.f400119c;
        Resources resources = getMContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "mContext.resources");
        Drawable d16 = u64.c.d(resources, iconRes);
        if (d16 != null) {
            d16.setColorFilter(new PorterDuffColorFilter(getMContext().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN));
        } else {
            d16 = null;
        }
        imageView.setImageDrawable(d16);
        fn2.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.f400120d.setText(getMContext().getString(textRes));
        fn2.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar4;
        }
        eVar2.f400120d.setTextColor(getMContext().getColor(R.color.qui_common_text_primary));
    }

    private final void j1(String titleIconUrl, int textRes, boolean isShowRightText, int titleTextColor, int titleIconTintColor) {
        String string = getMContext().getString(textRes);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(textRes)");
        k1(titleIconUrl, string, isShowRightText, titleTextColor, titleIconTintColor);
    }

    private final void k1(String url, String textText, boolean isShowRightText, int titleTextColor, int titleIconTintColor) {
        boolean z16;
        if (url.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        fn2.e eVar = null;
        if (z16) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setColorFilter(new PorterDuffColorFilter(titleIconTintColor, PorterDuff.Mode.SRC_IN));
            fn2.e eVar2 = this.mBinding;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar2 = null;
            }
            eVar2.f400119c.setImageDrawable(drawable);
        }
        fn2.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.f400120d.setText(textText);
        fn2.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        eVar4.f400120d.setTextColor(titleTextColor);
        if (isShowRightText) {
            fn2.e eVar5 = this.mBinding;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar5 = null;
            }
            eVar5.f400122f.setText(getMContext().getString(R.string.f222596dy));
            Drawable drawable2 = getMContext().getDrawable(R.drawable.qui_refresh);
            if (drawable2 != null) {
                int dpToPx = ViewUtils.dpToPx(14.0f);
                drawable2.setBounds(0, 0, dpToPx, dpToPx);
                drawable2.setColorFilter(new PorterDuffColorFilter(getMContext().getColor(R.color.qui_common_icon_secondary), PorterDuff.Mode.SRC_IN));
            } else {
                drawable2 = null;
            }
            fn2.e eVar6 = this.mBinding;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar6 = null;
            }
            eVar6.f400122f.setCompoundDrawables(drawable2, null, null, null);
            fn2.e eVar7 = this.mBinding;
            if (eVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar7 = null;
            }
            eVar7.f400122f.setCompoundDrawablePadding(ViewUtils.dpToPx(2.0f));
            fn2.e eVar8 = this.mBinding;
            if (eVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar = eVar8;
            }
            eVar.f400122f.setOnClickListener(new View.OnClickListener() { // from class: i64.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.m1(d.this, view);
                }
            });
        }
        if (!this.reportImpl) {
            com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_change_the_buttons");
            this.reportImpl = true;
        }
    }

    static /* synthetic */ void l1(d dVar, String str, int i3, boolean z16, int i16, int i17, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i18 & 8) != 0) {
            i16 = dVar.getMContext().getColor(R.color.qui_common_text_secondary);
        }
        int i19 = i16;
        if ((i18 & 16) != 0) {
            i17 = dVar.getMContext().getColor(R.color.qui_common_icon_primary);
        }
        dVar.j1(str, i3, z17, i19, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.b.f407319d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_change_the_buttons");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, SlashTitleUIState, w64.e<u54.c>> createVM() {
        return new e(this.mNeedRegisterHeightProviderCallback);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull SlashTitleUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SlashTitleUIState.TitleBannerState) {
            e1((SlashTitleUIState.TitleBannerState) state);
        } else if (state instanceof SlashTitleUIState.TitleTipState) {
            f1((SlashTitleUIState.TitleTipState) state);
        } else if (state instanceof SlashTitleUIState.DialogDismiss) {
            this.reportImpl = false;
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        fn2.e g16 = fn2.e.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        RelativeLayout root = g16.getRoot();
        root.setBackgroundColor(createViewParams.a().getColor(R.color.qui_common_bg_middle_light));
        root.setOnClickListener(new View.OnClickListener() { // from class: i64.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.h1(d.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root.apply {\n  \u2026)\n            }\n        }");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.reportImpl = false;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return (int) y64.a.a(getMContext(), 44);
    }

    public /* synthetic */ d(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public d(boolean z16) {
        this.mNeedRegisterHeightProviderCallback = z16;
    }
}

package com.tencent.mobileqq.wink.editor.nextbtn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.MateActivityUIStyle;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.utils.ax;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.model.MediaClip;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000fH\u0014R*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00106R\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00106R\u0016\u0010L\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00106R\u0016\u0010N\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u00106R\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010?\u001a\u0004\bQ\u0010RR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010[\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u0011\u0010_\u001a\u00020\\8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010^\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "Lcom/tencent/mobileqq/wink/editor/d;", "", "la", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "captureMate", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateMate", "editorTemplateMate", "V9", "ga", "na", "ia", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "M9", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "N9", "", "display", "oa", "W9", "X9", "initAfterInflation", "view", "da", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "getNextClickListener", "()Lkotlin/jvm/functions/Function0;", "ha", "(Lkotlin/jvm/functions/Function0;)V", "nextClickListener", "E", "getSyncToQCircleNextClickListener", LocaleUtils.L_JAPANESE, "syncToQCircleNextClickListener", UserInfo.SEX_FEMALE, "Landroid/view/View;", "nextBtnFrame", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "G", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "nextBtn", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "nextBtnBg", "Landroid/widget/Button;", "I", "Landroid/widget/Button;", "syncToQCircleBtn", "Lcom/tencent/mobileqq/wink/editor/util/c;", "J", "Lcom/tencent/mobileqq/wink/editor/util/c;", "debouncer", "Lcom/tencent/mobileqq/wink/editor/template/x;", "K", "Lkotlin/Lazy;", "ba", "()Lcom/tencent/mobileqq/wink/editor/template/x;", "templateVM", "Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle;", "L", "Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle;", "uiStyle", "M", "activityType", "N", "yuhengActivityId", "P", "yuhengRuleId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "yuhengTaskId", "Lh93/a;", BdhLogUtil.LogTag.Tag_Req, "ca", "()Lh93/a;", "winkProfileTheme", ExifInterface.LATITUDE_SOUTH, "Z", "Y9", "()I", "nextBtnNormalDrawableRes", "aa", "()Z", "syncToQCircle", "Landroid/widget/TextView;", "Z9", "()Landroid/widget/TextView;", "nextButton", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class NextBtnPart extends com.tencent.mobileqq.wink.editor.d {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> nextClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> syncToQCircleNextClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private View nextBtnFrame;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIButton nextBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView nextBtnBg;

    /* renamed from: I, reason: from kotlin metadata */
    private Button syncToQCircleBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.util.c debouncer = new com.tencent.mobileqq.wink.editor.util.c(1000);

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy templateVM;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private MateActivityUIStyle uiStyle;

    /* renamed from: M, reason: from kotlin metadata */
    private int activityType;

    /* renamed from: N, reason: from kotlin metadata */
    private int yuhengActivityId;

    /* renamed from: P, reason: from kotlin metadata */
    private int yuhengRuleId;

    /* renamed from: Q, reason: from kotlin metadata */
    private int yuhengTaskId;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkProfileTheme;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean display;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f321305d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f321306e;

        a(View view, boolean z16) {
            this.f321305d = view;
            this.f321306e = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            int i3;
            View view = this.f321305d;
            if (this.f321306e) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    public NextBtnPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<x>() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart$templateVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x invoke() {
                return (x) NextBtnPart.this.getViewModel(x.class);
            }
        });
        this.templateVM = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<h93.a>() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart$winkProfileTheme$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h93.a invoke() {
                IWinkProfileThemeHelp iWinkProfileThemeHelp = (IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class);
                Context context = NextBtnPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return iWinkProfileThemeHelp.getWinkProfileTheme(context, false);
            }
        });
        this.winkProfileTheme = lazy2;
        this.display = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V9(AEMaterialMetaData captureMate, MetaMaterial templateMate, MetaMaterial editorTemplateMate) {
        String str;
        MateActivityUIStyle mateActivityUIStyle;
        MateActivityUIStyle mateActivityUIStyle2;
        String str2;
        String str3;
        Integer num;
        int i3;
        Integer num2;
        int i16;
        Integer num3;
        int i17;
        Integer num4;
        Integer V0;
        boolean isBlank;
        Drawable drawable;
        boolean z16;
        if (this.nextBtnBg == null) {
            return;
        }
        MateActivityUIStyle.Companion companion = MateActivityUIStyle.INSTANCE;
        Integer num5 = null;
        if (captureMate != null) {
            str = captureMate.activityUIStyleString;
        } else {
            str = null;
        }
        MateActivityUIStyle a16 = companion.a(str);
        if (templateMate != null) {
            mateActivityUIStyle = com.tencent.mobileqq.wink.editor.c.R(templateMate);
        } else {
            mateActivityUIStyle = null;
        }
        if (editorTemplateMate != null) {
            mateActivityUIStyle2 = com.tencent.mobileqq.wink.editor.c.R(editorTemplateMate);
        } else {
            mateActivityUIStyle2 = null;
        }
        if (mateActivityUIStyle2 == null) {
            if (a16 == null) {
                a16 = mateActivityUIStyle;
            }
        } else {
            a16 = mateActivityUIStyle2;
        }
        if (a16 != null) {
            str2 = a16.getEditNextBtnBg();
        } else {
            str2 = null;
        }
        if (a16 != null) {
            str3 = a16.getEditNextBtnText();
        } else {
            str3 = null;
        }
        boolean z17 = true;
        int i18 = 0;
        if (str2 != null) {
            QUIButton qUIButton = this.nextBtn;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton = null;
            }
            qUIButton.setBackgroundColor(0);
            ImageView imageView = this.nextBtnBg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtnBg");
                imageView = null;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int[] btnPlaceHolderColors = a16.getBtnPlaceHolderColors();
            if (btnPlaceHolderColors != null) {
                if (btnPlaceHolderColors.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, btnPlaceHolderColors);
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = ContextCompat.getDrawable(getContext(), Y9());
                    Unit unit = Unit.INSTANCE;
                    imageView.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
                }
            }
            drawable = ContextCompat.getDrawable(getContext(), Y9());
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = ContextCompat.getDrawable(getContext(), Y9());
            Unit unit2 = Unit.INSTANCE;
            imageView.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
        } else {
            QUIButton qUIButton2 = this.nextBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton2 = null;
            }
            qUIButton2.o();
            ImageView imageView2 = this.nextBtnBg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtnBg");
                imageView2 = null;
            }
            imageView2.setImageDrawable(null);
        }
        if (str3 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str3);
            if (!isBlank) {
                z17 = false;
            }
        }
        if (!z17) {
            QUIButton qUIButton3 = this.nextBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton3 = null;
            }
            qUIButton3.setText(str3);
        }
        this.uiStyle = a16;
        if (editorTemplateMate == null || (num = com.tencent.mobileqq.wink.editor.c.i(editorTemplateMate)) == null) {
            if (captureMate != null) {
                num = captureMate.activityType;
            } else {
                num = null;
            }
            if (num == null) {
                if (templateMate != null) {
                    num = com.tencent.mobileqq.wink.editor.c.i(templateMate);
                } else {
                    num = null;
                }
                if (num == null) {
                    i3 = 0;
                    this.activityType = i3;
                    if (editorTemplateMate != null || (num2 = com.tencent.mobileqq.wink.editor.c.U0(editorTemplateMate)) == null) {
                        if (captureMate == null) {
                            num2 = captureMate.yuhengRuleId;
                        } else {
                            num2 = null;
                        }
                        if (num2 == null) {
                            if (templateMate != null) {
                                num2 = com.tencent.mobileqq.wink.editor.c.U0(templateMate);
                            } else {
                                num2 = null;
                            }
                            if (num2 == null) {
                                i16 = 0;
                                this.yuhengRuleId = i16;
                                if (editorTemplateMate != null || (num3 = com.tencent.mobileqq.wink.editor.c.T0(editorTemplateMate)) == null) {
                                    if (captureMate != null) {
                                        num3 = captureMate.yuhengActivityId;
                                    } else {
                                        num3 = null;
                                    }
                                    if (num3 == null) {
                                        if (templateMate != null) {
                                            num3 = com.tencent.mobileqq.wink.editor.c.T0(templateMate);
                                        } else {
                                            num3 = null;
                                        }
                                        if (num3 == null) {
                                            i17 = 0;
                                            this.yuhengActivityId = i17;
                                            if (editorTemplateMate == null && (V0 = com.tencent.mobileqq.wink.editor.c.V0(editorTemplateMate)) != null) {
                                                i18 = V0.intValue();
                                            } else {
                                                if (captureMate == null) {
                                                    num4 = captureMate.yuhengTaskId;
                                                } else {
                                                    num4 = null;
                                                }
                                                if (num4 == null) {
                                                    i18 = num4.intValue();
                                                } else {
                                                    if (templateMate != null) {
                                                        num5 = com.tencent.mobileqq.wink.editor.c.V0(templateMate);
                                                    }
                                                    if (num5 != null) {
                                                        i18 = num5.intValue();
                                                    }
                                                }
                                            }
                                            this.yuhengTaskId = i18;
                                        }
                                    }
                                }
                                i17 = num3.intValue();
                                this.yuhengActivityId = i17;
                                if (editorTemplateMate == null) {
                                }
                                if (captureMate == null) {
                                }
                                if (num4 == null) {
                                }
                                this.yuhengTaskId = i18;
                            }
                        }
                    }
                    i16 = num2.intValue();
                    this.yuhengRuleId = i16;
                    if (editorTemplateMate != null) {
                    }
                    if (captureMate != null) {
                    }
                    if (num3 == null) {
                    }
                    i17 = num3.intValue();
                    this.yuhengActivityId = i17;
                    if (editorTemplateMate == null) {
                    }
                    if (captureMate == null) {
                    }
                    if (num4 == null) {
                    }
                    this.yuhengTaskId = i18;
                }
            }
        }
        i3 = num.intValue();
        this.activityType = i3;
        if (editorTemplateMate != null) {
        }
        if (captureMate == null) {
        }
        if (num2 == null) {
        }
        i16 = num2.intValue();
        this.yuhengRuleId = i16;
        if (editorTemplateMate != null) {
        }
        if (captureMate != null) {
        }
        if (num3 == null) {
        }
        i17 = num3.intValue();
        this.yuhengActivityId = i17;
        if (editorTemplateMate == null) {
        }
        if (captureMate == null) {
        }
        if (num4 == null) {
        }
        this.yuhengTaskId = i18;
    }

    private final int Y9() {
        if (ax.a()) {
            return R.drawable.m5o;
        }
        return R.drawable.qvideo_skin_qqwink_editor_next_btn_bg;
    }

    private final x ba() {
        Object value = this.templateVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-templateVM>(...)");
        return (x) value;
    }

    private final h93.a ca() {
        return (h93.a) this.winkProfileTheme.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(final NextBtnPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.debouncer.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart$initNextBtn$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NextBtnPart.this.ga();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        ia();
        na();
        Function0<Unit> function0 = this.nextClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void ia() {
        List<MediaClip> t16;
        dr H9 = H9();
        if (H9 != null) {
            WinkEditData h06 = H9.h0();
            boolean z16 = false;
            if (h06 != null && (t16 = com.tencent.mobileqq.wink.editor.draft.c.t(h06)) != null && t16.size() == 1) {
                z16 = true;
            }
            if (!z16) {
                HashMap<String, Object> params = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUB_CLIP_NUM, "not_one");
            } else if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video) {
                HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params2, "params");
                params2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUB_CLIP_NUM, "one_video");
            } else {
                HashMap<String, Object> params3 = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params3, "params");
                params3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUB_CLIP_NUM, "one_picture");
            }
        }
    }

    private final void la() {
        WinkNextBtnUIData winkNextBtnUIData;
        Intent intent = getActivity().getIntent();
        final AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) intent.getSerializableExtra(QQWinkConstants.CAPTURE_MATERIAL);
        final MetaMaterial metaMaterial = (MetaMaterial) intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        WinkEditUIData C9 = C9();
        if (C9 instanceof WinkNextBtnUIData) {
            winkNextBtnUIData = (WinkNextBtnUIData) C9;
        } else {
            winkNextBtnUIData = null;
        }
        if (winkNextBtnUIData != null) {
            winkNextBtnUIData.setCaptureMate(aEMaterialMetaData);
            winkNextBtnUIData.setTemplateMate(metaMaterial);
        }
        V9(aEMaterialMetaData, metaMaterial, null);
        LiveData<x.UpdateTemplateAction> P1 = ba().P1();
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        final Function1<x.UpdateTemplateAction, Unit> function1 = new Function1<x.UpdateTemplateAction, Unit>() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart$setUiForActivity$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(x.UpdateTemplateAction updateTemplateAction) {
                invoke2(updateTemplateAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(x.UpdateTemplateAction updateTemplateAction) {
                WinkEditUIData C92 = NextBtnPart.this.C9();
                WinkNextBtnUIData winkNextBtnUIData2 = C92 instanceof WinkNextBtnUIData ? (WinkNextBtnUIData) C92 : null;
                if (winkNextBtnUIData2 != null) {
                    winkNextBtnUIData2.setEditorTemplateMate(updateTemplateAction.getMetaMaterial());
                }
                NextBtnPart.this.V9(aEMaterialMetaData, metaMaterial, updateTemplateAction.getMetaMaterial());
            }
        };
        P1.observe((FragmentActivity) activity, new Observer() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NextBtnPart.ma(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void na() {
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            intent.putExtra(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE, this.activityType);
            intent.putExtra(QQWinkConstants.KEY_MATE_ACTIVITY_UI_STYLE, this.uiStyle);
            intent.putExtra(QQWinkConstants.KEY_MATE_YUHENG_ACTIVITY_ID, this.yuhengActivityId);
            intent.putExtra(QQWinkConstants.KEY_MATE_YUHENG_RULE_ID, this.yuhengRuleId);
            intent.putExtra(QQWinkConstants.KEY_MATE_YUHENG_TASK_ID, this.yuhengTaskId);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zqk;
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        super.M9();
        O9(new WinkNextBtnUIData(this));
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData uiData) {
        super.N9(uiData);
        if (uiData instanceof WinkNextBtnUIData) {
            WinkNextBtnUIData winkNextBtnUIData = (WinkNextBtnUIData) uiData;
            V9(winkNextBtnUIData.getCaptureMate(), winkNextBtnUIData.getTemplateMate(), winkNextBtnUIData.getEditorTemplateMate());
            O9(uiData);
        }
    }

    public final void W9() {
        this.debouncer.a();
    }

    @Nullable
    /* renamed from: X9 */
    public View getDailySendBtn() {
        return Z9();
    }

    @NotNull
    public final TextView Z9() {
        QUIButton qUIButton = this.nextBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
            return null;
        }
        return qUIButton;
    }

    public final boolean aa() {
        Button button = this.syncToQCircleBtn;
        if (button != null) {
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("syncToQCircleBtn");
                button = null;
            }
            return button.isSelected();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(@NotNull View view) {
        Intent intent;
        Intent intent2;
        String stringExtra;
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.zqj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.nextBtnFrame)");
        this.nextBtnFrame = findViewById;
        View findViewById2 = view.findViewById(R.id.zqi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.nextBtnBg)");
        this.nextBtnBg = (ImageView) findViewById2;
        View view2 = this.nextBtnFrame;
        QUIButton qUIButton = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtnFrame");
            view2 = null;
        }
        boolean z16 = false;
        view2.setVisibility(0);
        View findViewById3 = view.findViewById(R.id.zqg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.nextBtn)");
        this.nextBtn = (QUIButton) findViewById3;
        if (ca().c()) {
            QUIButton qUIButton2 = this.nextBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton2 = null;
            }
            qUIButton2.setThemeId(1002);
        }
        Z9().setEnabled(false);
        Activity activity = getActivity();
        if (activity != null && (intent2 = activity.getIntent()) != null && (stringExtra = intent2.getStringExtra(QQWinkConstants.EDITOR_NEXT_BUTTON_TEXT)) != null) {
            QUIButton qUIButton3 = this.nextBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton3 = null;
            }
            qUIButton3.setText(stringExtra);
        }
        if (G9().a2()) {
            QUIButton qUIButton4 = this.nextBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton4 = null;
            }
            qUIButton4.setText(R.string.f239987ny);
        }
        if (!Intrinsics.areEqual(G9().E2(), "0") && !Intrinsics.areEqual(G9().E2(), "3")) {
            QUIButton qUIButton5 = this.nextBtn;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton5 = null;
            }
            qUIButton5.setText(R.string.f239997nz);
        }
        Activity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null && intent.getBooleanExtra(QQWinkConstants.QZONE_EDIT, false)) {
            z16 = true;
        }
        if (z16) {
            QUIButton qUIButton6 = this.nextBtn;
            if (qUIButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
                qUIButton6 = null;
            }
            qUIButton6.setText(R.string.f216205xo);
        }
        QUIButton qUIButton7 = this.nextBtn;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
        } else {
            qUIButton = qUIButton7;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.nextbtn.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                NextBtnPart.ea(NextBtnPart.this, view3);
            }
        });
        la();
    }

    public final void ha(@Nullable Function0<Unit> function0) {
        this.nextClickListener = function0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        da(rootView);
    }

    public final void ja(@Nullable Function0<Unit> function0) {
        this.syncToQCircleNextClickListener = function0;
    }

    public final void oa(boolean display) {
        float f16;
        View partRootView = getPartRootView();
        if (partRootView == null || this.display == display) {
            return;
        }
        this.display = display;
        ViewPropertyAnimator duration = partRootView.animate().setListener(new a(partRootView, display)).setDuration(200L);
        if (display) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        duration.alpha(f16).start();
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
    }
}

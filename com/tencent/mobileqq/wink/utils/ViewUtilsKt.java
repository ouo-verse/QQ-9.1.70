package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a,\u0010\f\u001a\u00020\u0005\"\b\b\u0000\u0010\b*\u00020\u0007*\b\u0012\u0004\u0012\u00028\u00000\t2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n\u001a\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u001a8\u0010\u0019\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u001a\"\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u001aU\u0010&\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b&\u0010'\u001a\u0018\u0010+\u001a\u00020\u0005*\u00020(2\f\b\u0001\u0010*\u001a\u00020)\"\u00020\u001e\u001a\u0006\u0010-\u001a\u00020,\u00a8\u0006."}, d2 = {"Landroid/view/View;", "", "delayTime", "Landroid/view/View$OnClickListener;", "onClickListener", "", "e", "Landroid/widget/Adapter;", "T", "Landroid/widget/AdapterView;", "Landroid/widget/AdapterView$OnItemClickListener;", "onItemClick", "g", "Landroid/widget/ImageView;", "view", "", "imageUrl", "j", "staticThumbUrl", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "l", "dynamicThumbUrl", "k", "Landroid/content/Context;", "context", "", "positiveBtnResId", "negativeBtnResId", "messageResId", "Landroid/content/DialogInterface$OnClickListener;", "positiveClickListener", "negativeClickListener", ISchemeApi.KEY_PAGE_ID, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/content/Context;IILjava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;)V", "Landroidx/constraintlayout/widget/Group;", "", "ids", "i", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "d", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ViewUtilsKt {
    @NotNull
    public static final URLDrawable.URLDrawableOptions d() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026(Color.TRANSPARENT)\n    }");
        return obtain;
    }

    public static final void e(@NotNull final View view, final long j3, @NotNull final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.utils.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewUtilsKt.f(view, j3, onClickListener, view2);
            }
        });
    }

    public static final void f(final View this_setOnClickListenerWithTrigger, long j3, final View.OnClickListener onClickListener, View view) {
        z zVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_setOnClickListenerWithTrigger, "$this_setOnClickListenerWithTrigger");
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Object tag = this_setOnClickListenerWithTrigger.getTag(R.id.f100975ty);
        if (tag instanceof z) {
            zVar = (z) tag;
        } else {
            zVar = null;
        }
        if (zVar == null) {
            zVar = new z(j3);
            this_setOnClickListenerWithTrigger.setTag(R.id.f100975ty, zVar);
        }
        zVar.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.utils.ViewUtilsKt$setOnClickListenerWithTrigger$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                onClickListener.onClick(this_setOnClickListenerWithTrigger);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final <T extends Adapter> void g(@NotNull final AdapterView<T> adapterView, final long j3, @NotNull final AdapterView.OnItemClickListener onItemClick) {
        Intrinsics.checkNotNullParameter(adapterView, "<this>");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        adapterView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.wink.utils.af
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView2, View view, int i3, long j16) {
                ViewUtilsKt.h(adapterView, j3, onItemClick, adapterView2, view, i3, j16);
            }
        });
    }

    public static final void h(AdapterView this_setOnItemClickListenerWithTrigger, long j3, final AdapterView.OnItemClickListener onItemClick, final AdapterView adapterView, final View view, final int i3, final long j16) {
        z zVar;
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j16);
        Intrinsics.checkNotNullParameter(this_setOnItemClickListenerWithTrigger, "$this_setOnItemClickListenerWithTrigger");
        Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
        Object tag = this_setOnItemClickListenerWithTrigger.getTag(R.id.f100975ty);
        if (tag instanceof z) {
            zVar = (z) tag;
        } else {
            zVar = null;
        }
        if (zVar == null) {
            zVar = new z(j3);
            this_setOnItemClickListenerWithTrigger.setTag(R.id.f100975ty, zVar);
        }
        zVar.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.utils.ViewUtilsKt$setOnItemClickListenerWithTrigger$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                onItemClick.onItemClick(adapterView, view, i3, j16);
            }
        });
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j16);
    }

    public static final void i(@NotNull Group group, @IdRes @NotNull int... ids) {
        Intrinsics.checkNotNullParameter(group, "<this>");
        Intrinsics.checkNotNullParameter(ids, "ids");
        group.setReferencedIds(ids);
        group.setVisibility(group.getVisibility());
    }

    public static final void j(@Nullable ImageView imageView, @Nullable String str) {
        l(imageView, str, null, null, null);
    }

    public static final void k(@NotNull ImageView view, @Nullable String str, @Nullable Drawable drawable) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(view.getContext(), R.color.bdf);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            try {
                obtain.mPlayGifImage = true;
                URL url = new URL(str);
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                obtain.mUseAutoScaleParams = false;
                URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
                if (drawable2 != null) {
                    if (drawable2.getStatus() == 2 || drawable2.getStatus() == 3) {
                        drawable2.restartDownload();
                    }
                } else {
                    drawable2 = null;
                }
                drawable = drawable2;
            } catch (MalformedURLException e16) {
                String message = e16.getMessage();
                if (message != null) {
                    w53.b.c("DisplayUtil", message);
                }
                view.setImageDrawable(drawable);
                return;
            }
        }
        view.setImageDrawable(drawable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0063 A[Catch: MalformedURLException -> 0x007c, TryCatch #0 {MalformedURLException -> 0x007c, blocks: (B:50:0x004b, B:53:0x0056, B:59:0x0063, B:61:0x006c, B:62:0x0074, B:27:0x0080, B:33:0x008b, B:35:0x0094), top: B:49:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void l(@Nullable ImageView imageView, @Nullable String str, @Nullable MetaMaterial metaMaterial, @Nullable WinkEditorViewModel.EditMode editMode, @Nullable Drawable drawable) {
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean endsWith$default;
        URL url;
        URLDrawable fileDrawable;
        boolean startsWith$default;
        String str4;
        if (imageView != null) {
            URLDrawable uRLDrawable = null;
            if (str == null) {
                if (metaMaterial != null) {
                    str4 = com.tencent.mobileqq.wink.editor.c.y(metaMaterial);
                } else {
                    str4 = null;
                }
                if (str4 == null) {
                    return;
                }
            }
            if (drawable == null) {
                drawable = ContextCompat.getDrawable(imageView.getContext(), R.color.bdf);
            }
            if (metaMaterial != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.y(metaMaterial);
            } else {
                str2 = null;
            }
            if (editMode == WinkEditorViewModel.EditMode.Video && metaMaterial != null) {
                str3 = com.tencent.mobileqq.wink.editor.c.Y(metaMaterial);
            } else {
                str3 = null;
            }
            boolean z18 = true;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                if (str3 != null) {
                    try {
                        if (!Intrinsics.areEqual(str3, "none")) {
                            if (str2 != null && str2.length() != 0) {
                                z17 = false;
                                if (z17) {
                                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
                                    if (endsWith$default) {
                                        obtain.mPlayGifImage = true;
                                        url = new URL(str2);
                                    } else {
                                        obtain.mUseApngImage = true;
                                        url = new URL(str2);
                                    }
                                    obtain.mLoadingDrawable = drawable;
                                    obtain.mFailedDrawable = drawable;
                                    obtain.mUseAutoScaleParams = false;
                                    if (url == null) {
                                        fileDrawable = URLDrawable.getDrawable(url, obtain);
                                    } else {
                                        fileDrawable = URLDrawable.getFileDrawable(str, obtain);
                                    }
                                    if (fileDrawable != null) {
                                        if (fileDrawable.getStatus() == 2 || fileDrawable.getStatus() == 3) {
                                            fileDrawable.restartDownload();
                                        }
                                        uRLDrawable = fileDrawable;
                                    }
                                    drawable = uRLDrawable;
                                }
                            }
                            z17 = true;
                            if (z17) {
                            }
                        }
                    } catch (MalformedURLException e16) {
                        String message = e16.getMessage();
                        if (message != null) {
                            w53.b.c("DisplayUtil", message);
                        }
                        imageView.setImageDrawable(drawable);
                        return;
                    }
                }
                if (str != null && str.length() != 0) {
                    z18 = false;
                }
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
                if (startsWith$default) {
                    url = new URL(str);
                } else {
                    url = null;
                }
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                obtain.mUseAutoScaleParams = false;
                if (url == null) {
                }
                if (fileDrawable != null) {
                }
                drawable = uRLDrawable;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static final void m(@NotNull Context context, int i3, int i16, @Nullable Integer num, @NotNull DialogInterface.OnClickListener positiveClickListener, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable String str) {
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(positiveClickListener, "positiveClickListener");
        try {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
            if (num != null) {
                createCustomDialog.setMessage(num.intValue());
            }
            createCustomDialog.setPositiveButton(i3, positiveClickListener);
            createCustomDialog.setNegativeButton(i16, onClickListener);
            if (str != null) {
                Window window = createCustomDialog.getWindow();
                if (window != null) {
                    view = window.getDecorView();
                } else {
                    view = null;
                }
                VideoReport.setPageId(view, str);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
                VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
            }
            createCustomDialog.show();
        } catch (Exception e16) {
            w53.b.d("DisplayUtil", "showCancelDialog", e16);
        }
    }

    public static /* synthetic */ void n(Context context, int i3, int i16, Integer num, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str, int i17, Object obj) {
        Integer num2;
        String str2;
        if ((i17 & 2) != 0) {
            i3 = R.string.f239107lk;
        }
        int i18 = i3;
        if ((i17 & 4) != 0) {
            i16 = R.string.f239057lf;
        }
        int i19 = i16;
        if ((i17 & 8) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i17 & 32) != 0) {
            onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.utils.ad
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i26) {
                    ViewUtilsKt.o(dialogInterface, i26);
                }
            };
        }
        DialogInterface.OnClickListener onClickListener3 = onClickListener2;
        if ((i17 & 64) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        m(context, i18, i19, num2, onClickListener, onClickListener3, str2);
    }

    public static final void o(DialogInterface dialogInterface, int i3) {
    }
}

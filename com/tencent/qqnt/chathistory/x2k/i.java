package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.os.Trace;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qui.quiblurview.QQBlurView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010,\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\"\u00100\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010\u001d\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010\u001d\u001a\u0004\b1\u0010\u001f\"\u0004\b-\u0010!R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u00103\u001a\u0004\b4\u00105\"\u0004\b)\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/i;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "o", "(Landroid/view/View;)V", "_root", "Lcom/tencent/qui/quiblurview/QQBlurView;", "c", "Lcom/tencent/qui/quiblurview/QQBlurView;", "getVAioBottomBlur", "()Lcom/tencent/qui/quiblurview/QQBlurView;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qui/quiblurview/QQBlurView;)V", "vAioBottomBlur", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getEditDownloadBtn", "()Landroid/widget/ImageView;", "i", "(Landroid/widget/ImageView;)V", "editDownloadBtn", "getEditForwardBtn", "k", "editForwardBtn", "getEditFavBtn", "j", "editFavBtn", "g", "getEditSave2weiyunBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "editSave2weiyunBtn", tl.h.F, "getEditSave2GroupAlbumBtn", "l", "editSave2GroupAlbumBtn", "getEditDeleteBtn", "editDeleteBtn", "Landroid/widget/RelativeLayout;", "getActionBottomBar", "()Landroid/widget/RelativeLayout;", "(Landroid/widget/RelativeLayout;)V", "actionBottomBar", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class i implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public QQBlurView vAioBottomBlur;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView editDownloadBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView editForwardBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public ImageView editFavBtn;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public ImageView editSave2weiyunBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ImageView editSave2GroupAlbumBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ImageView editDeleteBtn;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout actionBottomBar;

    public i(@NotNull Context context, @Nullable Integer num) {
        RelativeLayout e16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            e16 = e(new ContextThemeWrapper(context, num.intValue()));
        } else {
            e16 = e(context);
        }
        o(e16);
    }

    @NotNull
    public final RelativeLayout e(@NotNull Context context) {
        int i3;
        int i16;
        int i17;
        ViewGroup.LayoutParams layoutParams;
        int i18;
        int i19;
        int i26;
        ViewGroup.LayoutParams layoutParams2;
        int i27;
        int i28;
        int i29;
        ViewGroup.LayoutParams layoutParams3;
        int i36;
        int i37;
        int i38;
        ViewGroup.LayoutParams layoutParams4;
        int i39;
        int i46;
        int i47;
        ViewGroup.LayoutParams layoutParams5;
        int i48;
        int i49;
        ViewGroup.LayoutParams layoutParams6;
        int i56;
        ViewGroup.LayoutParams layoutParams7;
        ViewGroup.LayoutParams layoutParams8;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            relativeLayout.getLayoutParams().width = l3;
        }
        relativeLayout.setBackground(AppCompatResources.getDrawable(relativeLayout.getContext(), R.drawable.qui_common_bg_nav_bottom_aio_bg));
        int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
        } else {
            relativeLayout.getLayoutParams().height = intValue;
        }
        com.tencent.aio.view_dsl.dsl.f.p(relativeLayout, com.tencent.aio.view_dsl.dsl.b.d());
        com.tencent.aio.view_dsl.dsl.f.c(relativeLayout, true);
        QQBlurView qQBlurView = new QQBlurView(relativeLayout.getContext());
        relativeLayout.addView(qQBlurView);
        int l16 = com.tencent.aio.view_dsl.dsl.b.l();
        if (qQBlurView.getLayoutParams() == null) {
            qQBlurView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
        } else {
            qQBlurView.getLayoutParams().width = l16;
        }
        int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
        if (qQBlurView.getLayoutParams() == null) {
            qQBlurView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue2));
        } else {
            qQBlurView.getLayoutParams().height = intValue2;
        }
        qQBlurView.setVisibility(0);
        n(qQBlurView);
        LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
        if (invoke != null) {
            linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
            } else {
                linearLayout.getLayoutParams().width = l17;
            }
            int p16 = com.tencent.aio.view_dsl.dsl.b.p();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
            } else {
                linearLayout.getLayoutParams().height = p16;
            }
            linearLayout.setOrientation(0);
            com.tencent.aio.view_dsl.dsl.f.o(linearLayout, true);
            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
            ImageView imageView = new ImageView(linearLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
            if (invoke2 != null) {
                imageView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                if (imageView.getLayoutParams() == null) {
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(p17, 0));
                } else {
                    imageView.getLayoutParams().width = p17;
                }
                imageView.setBackground(null);
                imageView.setId(R.id.brr);
                int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
                if (imageView.getLayoutParams() == null) {
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
                } else {
                    imageView.getLayoutParams().height = intValue3;
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setContentDescription(context.getString(R.string.b_f));
                float floatValue = ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(1.0d))).floatValue();
                ViewGroup.LayoutParams layoutParams9 = imageView.getLayoutParams();
                if (!(layoutParams9 instanceof LinearLayout.LayoutParams)) {
                    layoutParams9 = null;
                }
                LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) layoutParams9;
                if (layoutParams10 != null) {
                    ViewGroup.LayoutParams layoutParams11 = imageView.getLayoutParams();
                    if (!(layoutParams11 instanceof LinearLayout.LayoutParams)) {
                        layoutParams11 = null;
                    }
                    LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) layoutParams11;
                    if (layoutParams12 != null) {
                        i67 = layoutParams12.gravity;
                    } else {
                        i67 = -1;
                    }
                    layoutParams10.gravity = i67;
                    layoutParams10.weight = floatValue;
                    layoutParams = layoutParams10;
                } else {
                    ViewGroup.LayoutParams layoutParams13 = imageView.getLayoutParams();
                    if (layoutParams13 != null) {
                        i3 = layoutParams13.width;
                    } else {
                        i3 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams14 = imageView.getLayoutParams();
                    if (layoutParams14 != null) {
                        i16 = layoutParams14.height;
                    } else {
                        i16 = 0;
                    }
                    Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(objArr[0].getClass());
                    Object[] array = arrayList.toArray(new Class[0]);
                    if (array != null) {
                        Class[] clsArr = (Class[]) array;
                        Constructor it = LinearLayout.LayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        it.setAccessible(true);
                        Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) newInstance;
                        ViewGroup.LayoutParams layoutParams16 = imageView.getLayoutParams();
                        if (!(layoutParams16 instanceof LinearLayout.LayoutParams)) {
                            layoutParams16 = null;
                        }
                        LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) layoutParams16;
                        if (layoutParams17 != null) {
                            i17 = layoutParams17.gravity;
                        } else {
                            i17 = -1;
                        }
                        layoutParams15.gravity = i17;
                        layoutParams15.weight = floatValue;
                        layoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                imageView.setLayoutParams(layoutParams);
                imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), R.drawable.qui_share_light_selector));
                k(imageView);
                linearLayout.addView(imageView);
                Trace.endSection();
                Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                ImageView imageView2 = new ImageView(linearLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                if (invoke3 != null) {
                    imageView2.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                    if (imageView2.getLayoutParams() == null) {
                        imageView2.setLayoutParams(new ViewGroup.LayoutParams(p18, 0));
                    } else {
                        imageView2.getLayoutParams().width = p18;
                    }
                    imageView2.setBackground(null);
                    imageView2.setId(R.id.brq);
                    int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
                    if (imageView2.getLayoutParams() == null) {
                        imageView2.setLayoutParams(new ViewGroup.LayoutParams(0, intValue4));
                    } else {
                        imageView2.getLayoutParams().height = intValue4;
                    }
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView2.setContentDescription(context.getString(R.string.b_e));
                    float floatValue2 = ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(1.0d))).floatValue();
                    ViewGroup.LayoutParams layoutParams18 = imageView2.getLayoutParams();
                    if (!(layoutParams18 instanceof LinearLayout.LayoutParams)) {
                        layoutParams18 = null;
                    }
                    LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) layoutParams18;
                    if (layoutParams19 != null) {
                        ViewGroup.LayoutParams layoutParams20 = imageView2.getLayoutParams();
                        if (!(layoutParams20 instanceof LinearLayout.LayoutParams)) {
                            layoutParams20 = null;
                        }
                        LinearLayout.LayoutParams layoutParams21 = (LinearLayout.LayoutParams) layoutParams20;
                        if (layoutParams21 != null) {
                            i66 = layoutParams21.gravity;
                        } else {
                            i66 = -1;
                        }
                        layoutParams19.gravity = i66;
                        layoutParams19.weight = floatValue2;
                        layoutParams2 = layoutParams19;
                    } else {
                        ViewGroup.LayoutParams layoutParams22 = imageView2.getLayoutParams();
                        if (layoutParams22 != null) {
                            i18 = layoutParams22.width;
                        } else {
                            i18 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams23 = imageView2.getLayoutParams();
                        if (layoutParams23 != null) {
                            i19 = layoutParams23.height;
                        } else {
                            i19 = 0;
                        }
                        Object[] objArr2 = {new ViewGroup.LayoutParams(i18, i19)};
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(objArr2[0].getClass());
                        Object[] array2 = arrayList2.toArray(new Class[0]);
                        if (array2 != null) {
                            Class[] clsArr2 = (Class[]) array2;
                            Constructor it5 = LinearLayout.LayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            it5.setAccessible(true);
                            Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                            LinearLayout.LayoutParams layoutParams24 = (LinearLayout.LayoutParams) newInstance2;
                            ViewGroup.LayoutParams layoutParams25 = imageView2.getLayoutParams();
                            if (!(layoutParams25 instanceof LinearLayout.LayoutParams)) {
                                layoutParams25 = null;
                            }
                            LinearLayout.LayoutParams layoutParams26 = (LinearLayout.LayoutParams) layoutParams25;
                            if (layoutParams26 != null) {
                                i26 = layoutParams26.gravity;
                            } else {
                                i26 = -1;
                            }
                            layoutParams24.gravity = i26;
                            layoutParams24.weight = floatValue2;
                            layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    imageView2.setLayoutParams(layoutParams2);
                    imageView2.setImageDrawable(AppCompatResources.getDrawable(imageView2.getContext(), R.drawable.qui_download_light_selector));
                    i(imageView2);
                    linearLayout.addView(imageView2);
                    Trace.endSection();
                    Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                    ImageView imageView3 = new ImageView(linearLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                    if (invoke4 != null) {
                        imageView3.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (imageView3.getLayoutParams() == null) {
                            imageView3.setLayoutParams(new ViewGroup.LayoutParams(p19, 0));
                        } else {
                            imageView3.getLayoutParams().width = p19;
                        }
                        imageView3.setBackground(null);
                        imageView3.setId(R.id.upm);
                        int intValue5 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
                        if (imageView3.getLayoutParams() == null) {
                            imageView3.setLayoutParams(new ViewGroup.LayoutParams(0, intValue5));
                        } else {
                            imageView3.getLayoutParams().height = intValue5;
                        }
                        imageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        imageView3.setContentDescription(context.getString(R.string.f170937b60));
                        float floatValue3 = ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(1.0d))).floatValue();
                        ViewGroup.LayoutParams layoutParams27 = imageView3.getLayoutParams();
                        if (!(layoutParams27 instanceof LinearLayout.LayoutParams)) {
                            layoutParams27 = null;
                        }
                        LinearLayout.LayoutParams layoutParams28 = (LinearLayout.LayoutParams) layoutParams27;
                        if (layoutParams28 != null) {
                            ViewGroup.LayoutParams layoutParams29 = imageView3.getLayoutParams();
                            if (!(layoutParams29 instanceof LinearLayout.LayoutParams)) {
                                layoutParams29 = null;
                            }
                            LinearLayout.LayoutParams layoutParams30 = (LinearLayout.LayoutParams) layoutParams29;
                            if (layoutParams30 != null) {
                                i65 = layoutParams30.gravity;
                            } else {
                                i65 = -1;
                            }
                            layoutParams28.gravity = i65;
                            layoutParams28.weight = floatValue3;
                            layoutParams3 = layoutParams28;
                        } else {
                            ViewGroup.LayoutParams layoutParams31 = imageView3.getLayoutParams();
                            if (layoutParams31 != null) {
                                i27 = layoutParams31.width;
                            } else {
                                i27 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams32 = imageView3.getLayoutParams();
                            if (layoutParams32 != null) {
                                i28 = layoutParams32.height;
                            } else {
                                i28 = 0;
                            }
                            Object[] objArr3 = {new ViewGroup.LayoutParams(i27, i28)};
                            ArrayList arrayList3 = new ArrayList(1);
                            arrayList3.add(objArr3[0].getClass());
                            Object[] array3 = arrayList3.toArray(new Class[0]);
                            if (array3 != null) {
                                Class[] clsArr3 = (Class[]) array3;
                                Constructor it6 = LinearLayout.LayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr3, clsArr3.length));
                                Intrinsics.checkNotNullExpressionValue(it6, "it");
                                it6.setAccessible(true);
                                Object newInstance3 = it6.newInstance(Arrays.copyOf(objArr3, 1));
                                LinearLayout.LayoutParams layoutParams33 = (LinearLayout.LayoutParams) newInstance3;
                                ViewGroup.LayoutParams layoutParams34 = imageView3.getLayoutParams();
                                if (!(layoutParams34 instanceof LinearLayout.LayoutParams)) {
                                    layoutParams34 = null;
                                }
                                LinearLayout.LayoutParams layoutParams35 = (LinearLayout.LayoutParams) layoutParams34;
                                if (layoutParams35 != null) {
                                    i29 = layoutParams35.gravity;
                                } else {
                                    i29 = -1;
                                }
                                layoutParams33.gravity = i29;
                                layoutParams33.weight = floatValue3;
                                layoutParams3 = (ViewGroup.LayoutParams) newInstance3;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        imageView3.setLayoutParams(layoutParams3);
                        imageView3.setImageDrawable(AppCompatResources.getDrawable(imageView3.getContext(), R.drawable.qui_collection_light_selector));
                        j(imageView3);
                        linearLayout.addView(imageView3);
                        Trace.endSection();
                        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                        ImageView imageView4 = new ImageView(linearLayout.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                        if (invoke5 != null) {
                            imageView4.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (imageView4.getLayoutParams() == null) {
                                imageView4.setLayoutParams(new ViewGroup.LayoutParams(p26, 0));
                            } else {
                                imageView4.getLayoutParams().width = p26;
                            }
                            imageView4.setBackground(null);
                            imageView4.setId(R.id.brw);
                            int intValue6 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
                            if (imageView4.getLayoutParams() == null) {
                                imageView4.setLayoutParams(new ViewGroup.LayoutParams(0, intValue6));
                            } else {
                                imageView4.getLayoutParams().height = intValue6;
                            }
                            imageView4.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            imageView4.setContentDescription(context.getString(R.string.b_i));
                            float floatValue4 = ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(1.0d))).floatValue();
                            ViewGroup.LayoutParams layoutParams36 = imageView4.getLayoutParams();
                            if (!(layoutParams36 instanceof LinearLayout.LayoutParams)) {
                                layoutParams36 = null;
                            }
                            LinearLayout.LayoutParams layoutParams37 = (LinearLayout.LayoutParams) layoutParams36;
                            if (layoutParams37 != null) {
                                ViewGroup.LayoutParams layoutParams38 = imageView4.getLayoutParams();
                                if (!(layoutParams38 instanceof LinearLayout.LayoutParams)) {
                                    layoutParams38 = null;
                                }
                                LinearLayout.LayoutParams layoutParams39 = (LinearLayout.LayoutParams) layoutParams38;
                                if (layoutParams39 != null) {
                                    i59 = layoutParams39.gravity;
                                } else {
                                    i59 = -1;
                                }
                                layoutParams37.gravity = i59;
                                layoutParams37.weight = floatValue4;
                                layoutParams4 = layoutParams37;
                            } else {
                                ViewGroup.LayoutParams layoutParams40 = imageView4.getLayoutParams();
                                if (layoutParams40 != null) {
                                    i36 = layoutParams40.width;
                                } else {
                                    i36 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams41 = imageView4.getLayoutParams();
                                if (layoutParams41 != null) {
                                    i37 = layoutParams41.height;
                                } else {
                                    i37 = 0;
                                }
                                Object[] objArr4 = {new ViewGroup.LayoutParams(i36, i37)};
                                ArrayList arrayList4 = new ArrayList(1);
                                arrayList4.add(objArr4[0].getClass());
                                Object[] array4 = arrayList4.toArray(new Class[0]);
                                if (array4 != null) {
                                    Class[] clsArr4 = (Class[]) array4;
                                    Constructor it7 = LinearLayout.LayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr4, clsArr4.length));
                                    Intrinsics.checkNotNullExpressionValue(it7, "it");
                                    it7.setAccessible(true);
                                    Object newInstance4 = it7.newInstance(Arrays.copyOf(objArr4, 1));
                                    LinearLayout.LayoutParams layoutParams42 = (LinearLayout.LayoutParams) newInstance4;
                                    ViewGroup.LayoutParams layoutParams43 = imageView4.getLayoutParams();
                                    if (!(layoutParams43 instanceof LinearLayout.LayoutParams)) {
                                        layoutParams43 = null;
                                    }
                                    LinearLayout.LayoutParams layoutParams44 = (LinearLayout.LayoutParams) layoutParams43;
                                    if (layoutParams44 != null) {
                                        i38 = layoutParams44.gravity;
                                    } else {
                                        i38 = -1;
                                    }
                                    layoutParams42.gravity = i38;
                                    layoutParams42.weight = floatValue4;
                                    layoutParams4 = (ViewGroup.LayoutParams) newInstance4;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            imageView4.setLayoutParams(layoutParams4);
                            imageView4.setImageDrawable(AppCompatResources.getDrawable(imageView4.getContext(), R.drawable.qui_weiyun_light_selector));
                            m(imageView4);
                            linearLayout.addView(imageView4);
                            Trace.endSection();
                            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                            ImageView imageView5 = new ImageView(linearLayout.getContext());
                            Object invoke6 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                            if (invoke6 != null) {
                                imageView5.setLayoutParams((ViewGroup.LayoutParams) invoke6);
                                int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                                if (imageView5.getLayoutParams() == null) {
                                    imageView5.setLayoutParams(new ViewGroup.LayoutParams(p27, 0));
                                } else {
                                    imageView5.getLayoutParams().width = p27;
                                }
                                imageView5.setBackground(null);
                                imageView5.setId(R.id.upp);
                                int intValue7 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
                                if (imageView5.getLayoutParams() == null) {
                                    imageView5.setLayoutParams(new ViewGroup.LayoutParams(0, intValue7));
                                } else {
                                    imageView5.getLayoutParams().height = intValue7;
                                }
                                imageView5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView5.setContentDescription(context.getString(R.string.f13533016));
                                float floatValue5 = ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(1.0d))).floatValue();
                                ViewGroup.LayoutParams layoutParams45 = imageView5.getLayoutParams();
                                if (!(layoutParams45 instanceof LinearLayout.LayoutParams)) {
                                    layoutParams45 = null;
                                }
                                LinearLayout.LayoutParams layoutParams46 = (LinearLayout.LayoutParams) layoutParams45;
                                if (layoutParams46 != null) {
                                    ViewGroup.LayoutParams layoutParams47 = imageView5.getLayoutParams();
                                    if (!(layoutParams47 instanceof LinearLayout.LayoutParams)) {
                                        layoutParams47 = null;
                                    }
                                    LinearLayout.LayoutParams layoutParams48 = (LinearLayout.LayoutParams) layoutParams47;
                                    if (layoutParams48 != null) {
                                        i58 = layoutParams48.gravity;
                                    } else {
                                        i58 = -1;
                                    }
                                    layoutParams46.gravity = i58;
                                    layoutParams46.weight = floatValue5;
                                    layoutParams5 = layoutParams46;
                                } else {
                                    ViewGroup.LayoutParams layoutParams49 = imageView5.getLayoutParams();
                                    if (layoutParams49 != null) {
                                        i39 = layoutParams49.width;
                                    } else {
                                        i39 = 0;
                                    }
                                    ViewGroup.LayoutParams layoutParams50 = imageView5.getLayoutParams();
                                    if (layoutParams50 != null) {
                                        i46 = layoutParams50.height;
                                    } else {
                                        i46 = 0;
                                    }
                                    Object[] objArr5 = {new ViewGroup.LayoutParams(i39, i46)};
                                    ArrayList arrayList5 = new ArrayList(1);
                                    arrayList5.add(objArr5[0].getClass());
                                    Object[] array5 = arrayList5.toArray(new Class[0]);
                                    if (array5 != null) {
                                        Class[] clsArr5 = (Class[]) array5;
                                        Constructor it8 = LinearLayout.LayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr5, clsArr5.length));
                                        Intrinsics.checkNotNullExpressionValue(it8, "it");
                                        it8.setAccessible(true);
                                        Object newInstance5 = it8.newInstance(Arrays.copyOf(objArr5, 1));
                                        LinearLayout.LayoutParams layoutParams51 = (LinearLayout.LayoutParams) newInstance5;
                                        ViewGroup.LayoutParams layoutParams52 = imageView5.getLayoutParams();
                                        if (!(layoutParams52 instanceof LinearLayout.LayoutParams)) {
                                            layoutParams52 = null;
                                        }
                                        LinearLayout.LayoutParams layoutParams53 = (LinearLayout.LayoutParams) layoutParams52;
                                        if (layoutParams53 != null) {
                                            i47 = layoutParams53.gravity;
                                        } else {
                                            i47 = -1;
                                        }
                                        layoutParams51.gravity = i47;
                                        layoutParams51.weight = floatValue5;
                                        layoutParams5 = (ViewGroup.LayoutParams) newInstance5;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                }
                                imageView5.setLayoutParams(layoutParams5);
                                imageView5.setImageDrawable(AppCompatResources.getDrawable(imageView5.getContext(), R.drawable.jfx));
                                l(imageView5);
                                linearLayout.addView(imageView5);
                                Trace.endSection();
                                Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                                ImageView imageView6 = new ImageView(linearLayout.getContext());
                                Object invoke7 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                                if (invoke7 != null) {
                                    imageView6.setLayoutParams((ViewGroup.LayoutParams) invoke7);
                                    int p28 = com.tencent.aio.view_dsl.dsl.b.p();
                                    if (imageView6.getLayoutParams() == null) {
                                        imageView6.setLayoutParams(new ViewGroup.LayoutParams(p28, 0));
                                    } else {
                                        imageView6.getLayoutParams().width = p28;
                                    }
                                    imageView6.setBackground(null);
                                    imageView6.setId(R.id.brp);
                                    int intValue8 = ((Number) com.tencent.qqnt.chathistory.util.m.c(50)).intValue();
                                    if (imageView6.getLayoutParams() == null) {
                                        imageView6.setLayoutParams(new ViewGroup.LayoutParams(0, intValue8));
                                    } else {
                                        imageView6.getLayoutParams().height = intValue8;
                                    }
                                    imageView6.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                    imageView6.setContentDescription(context.getString(R.string.b_d));
                                    float floatValue6 = ((Number) com.tencent.aio.view_dsl.dsl.c.a(Double.valueOf(1.0d))).floatValue();
                                    ViewGroup.LayoutParams layoutParams54 = imageView6.getLayoutParams();
                                    if (!(layoutParams54 instanceof LinearLayout.LayoutParams)) {
                                        layoutParams54 = null;
                                    }
                                    LinearLayout.LayoutParams layoutParams55 = (LinearLayout.LayoutParams) layoutParams54;
                                    if (layoutParams55 != null) {
                                        ViewGroup.LayoutParams layoutParams56 = imageView6.getLayoutParams();
                                        if (!(layoutParams56 instanceof LinearLayout.LayoutParams)) {
                                            layoutParams8 = null;
                                        } else {
                                            layoutParams8 = layoutParams56;
                                        }
                                        LinearLayout.LayoutParams layoutParams57 = (LinearLayout.LayoutParams) layoutParams8;
                                        if (layoutParams57 != null) {
                                            i57 = layoutParams57.gravity;
                                        } else {
                                            i57 = -1;
                                        }
                                        layoutParams55.gravity = i57;
                                        layoutParams55.weight = floatValue6;
                                        layoutParams7 = layoutParams55;
                                    } else {
                                        ViewGroup.LayoutParams layoutParams58 = imageView6.getLayoutParams();
                                        if (layoutParams58 != null) {
                                            i48 = layoutParams58.width;
                                        } else {
                                            i48 = 0;
                                        }
                                        ViewGroup.LayoutParams layoutParams59 = imageView6.getLayoutParams();
                                        if (layoutParams59 != null) {
                                            i49 = layoutParams59.height;
                                        } else {
                                            i49 = 0;
                                        }
                                        Object[] objArr6 = {new ViewGroup.LayoutParams(i48, i49)};
                                        ArrayList arrayList6 = new ArrayList(1);
                                        arrayList6.add(objArr6[0].getClass());
                                        Object[] array6 = arrayList6.toArray(new Class[0]);
                                        if (array6 != null) {
                                            Class[] clsArr6 = (Class[]) array6;
                                            Constructor it9 = LinearLayout.LayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr6, clsArr6.length));
                                            Intrinsics.checkNotNullExpressionValue(it9, "it");
                                            it9.setAccessible(true);
                                            Object newInstance6 = it9.newInstance(Arrays.copyOf(objArr6, 1));
                                            LinearLayout.LayoutParams layoutParams60 = (LinearLayout.LayoutParams) newInstance6;
                                            ViewGroup.LayoutParams layoutParams61 = imageView6.getLayoutParams();
                                            if (!(layoutParams61 instanceof LinearLayout.LayoutParams)) {
                                                layoutParams6 = null;
                                            } else {
                                                layoutParams6 = layoutParams61;
                                            }
                                            LinearLayout.LayoutParams layoutParams62 = (LinearLayout.LayoutParams) layoutParams6;
                                            if (layoutParams62 != null) {
                                                i56 = layoutParams62.gravity;
                                            } else {
                                                i56 = -1;
                                            }
                                            layoutParams60.gravity = i56;
                                            layoutParams60.weight = floatValue6;
                                            layoutParams7 = (ViewGroup.LayoutParams) newInstance6;
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    imageView6.setLayoutParams(layoutParams7);
                                    imageView6.setImageDrawable(AppCompatResources.getDrawable(imageView6.getContext(), R.drawable.qui_delete_light_selector));
                                    h(imageView6);
                                    linearLayout.addView(imageView6);
                                    Trace.endSection();
                                    relativeLayout.addView(linearLayout);
                                    g(relativeLayout);
                                    return relativeLayout;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        View view = this._root;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_root");
        return null;
    }

    public final void g(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.actionBottomBar = relativeLayout;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.editDeleteBtn = imageView;
        }
    }

    public final void i(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.editDownloadBtn = imageView;
        }
    }

    public final void j(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.editFavBtn = imageView;
        }
    }

    public final void k(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.editForwardBtn = imageView;
        }
    }

    public final void l(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.editSave2GroupAlbumBtn = imageView;
        }
    }

    public final void m(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.editSave2weiyunBtn = imageView;
        }
    }

    public final void n(@NotNull QQBlurView qQBlurView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQBlurView);
        } else {
            Intrinsics.checkNotNullParameter(qQBlurView, "<set-?>");
            this.vAioBottomBlur = qQBlurView;
        }
    }

    public final void o(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ i(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

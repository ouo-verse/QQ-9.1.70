package com.tencent.mobileqq.aio.msglist.holder.component.file;

import android.content.Context;
import android.os.Trace;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b(\u00105\"\u0004\b6\u00107R\"\u0010?\u001a\u0002098\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b3\u0010<\"\u0004\b=\u0010>R\"\u0010D\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010@\u001a\u0004\b:\u0010A\"\u0004\bB\u0010CR\"\u0010G\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010@\u001a\u0004\bE\u0010A\"\u0004\bF\u0010C\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AioFileDefaultLayout;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/RelativeLayout;", "j", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "v", "(Landroid/view/View;)V", "_root", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "f", "()Landroid/widget/ImageView;", "o", "(Landroid/widget/ImageView;)V", "ivFileIcon", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "i", "()Landroid/widget/ProgressBar;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/widget/ProgressBar;)V", "pbLoading", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "u", "(Landroid/widget/TextView;)V", "tvTitle", "k", "t", "tvDesc", "Landroidx/constraintlayout/widget/Barrier;", "g", "Landroidx/constraintlayout/widget/Barrier;", "()Landroidx/constraintlayout/widget/Barrier;", DomainData.DOMAIN_NAME, "(Landroidx/constraintlayout/widget/Barrier;)V", "barrier", "Landroidx/constraintlayout/widget/ConstraintLayout;", tl.h.F, "Landroidx/constraintlayout/widget/ConstraintLayout;", "()Landroidx/constraintlayout/widget/ConstraintLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "msgFile", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "r", "(Landroid/widget/RelativeLayout;)V", "msgVideo", "getMsgContent", "p", RemoteMessageConst.MessageBody.MSG_CONTENT, "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/ViewGroup;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AioFileDefaultLayout implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ImageView ivFileIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ProgressBar pbLoading;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView tvDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Barrier barrier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ConstraintLayout msgFile;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout msgVideo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout msgContent;

    public AioFileDefaultLayout(@NotNull Context context, @Nullable Integer num, @Nullable ViewGroup viewGroup, boolean z16) {
        RelativeLayout j3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, num, viewGroup, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        if (num != null) {
            j3 = j(new ContextThemeWrapper(context, num.intValue()), viewGroup, z16);
        } else {
            j3 = j(context, viewGroup, z16);
        }
        v(j3);
    }

    @NotNull
    public final Barrier e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Barrier) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Barrier barrier = this.barrier;
        if (barrier != null) {
            return barrier;
        }
        Intrinsics.throwUninitializedPropertyAccessException("barrier");
        return null;
    }

    @NotNull
    public final ImageView f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ImageView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ImageView imageView = this.ivFileIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivFileIcon");
        return null;
    }

    @NotNull
    public final ConstraintLayout g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ConstraintLayout) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ConstraintLayout constraintLayout = this.msgFile;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("msgFile");
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: getRoot */
    public View getMRv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return m();
    }

    @NotNull
    public final RelativeLayout h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        RelativeLayout relativeLayout = this.msgVideo;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("msgVideo");
        return null;
    }

    @NotNull
    public final ProgressBar i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ProgressBar) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ProgressBar progressBar = this.pbLoading;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pbLoading");
        return null;
    }

    @NotNull
    public final RelativeLayout j(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        ViewGroup viewGroup;
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        int i17;
        int i18;
        ViewGroup.LayoutParams layoutParams2;
        List split$default;
        int collectionSizeOrDefault;
        int[] intArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 23, this, context, parent, Boolean.valueOf(attach));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (parent == null) {
            viewGroup = new FrameLayout(context);
        } else {
            viewGroup = parent;
        }
        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(viewGroup, new Object[0]);
        if (invoke != null) {
            relativeLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            relativeLayout.setId(R.id.zfv);
            int p16 = com.tencent.aio.view_dsl.dsl.b.p();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(p16, 0));
            } else {
                relativeLayout.getLayoutParams().width = p16;
            }
            int p17 = com.tencent.aio.view_dsl.dsl.b.p();
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p17));
            } else {
                relativeLayout.getLayoutParams().height = p17;
            }
            ConstraintLayout constraintLayout = new ConstraintLayout(relativeLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
            if (invoke2 != null) {
                constraintLayout.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                constraintLayout.setId(R.id.zfy);
                int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                if (constraintLayout.getLayoutParams() == null) {
                    constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(p18, 0));
                } else {
                    constraintLayout.getLayoutParams().width = p18;
                }
                int p19 = com.tencent.aio.view_dsl.dsl.b.p();
                if (constraintLayout.getLayoutParams() == null) {
                    constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p19));
                } else {
                    constraintLayout.getLayoutParams().height = p19;
                }
                constraintLayout.setBackground(AppCompatResources.getDrawable(constraintLayout.getContext(), R.drawable.j6w));
                constraintLayout.setPadding(ViewUtils.dpToPx(14.0f), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), ViewUtils.dpToPx(14.0f), constraintLayout.getPaddingBottom());
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), ViewUtils.dpToPx(6.0f));
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), ViewUtils.dpToPx(12.0f), constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
                Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                ImageView imageView = new ImageView(constraintLayout.getContext());
                Object invoke3 = LayoutBuilderKt.b().invoke(constraintLayout, new Object[0]);
                if (invoke3 != null) {
                    imageView.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                    imageView.setId(R.id.y36);
                    int dpToPx = ViewUtils.dpToPx(48.0f);
                    if (imageView.getLayoutParams() == null) {
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(dpToPx, 0));
                    } else {
                        imageView.getLayoutParams().width = dpToPx;
                    }
                    int dpToPx2 = ViewUtils.dpToPx(48.0f);
                    if (imageView.getLayoutParams() == null) {
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(0, dpToPx2));
                    } else {
                        imageView.getLayoutParams().height = dpToPx2;
                    }
                    imageView.setContentDescription("file icon");
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    com.tencent.aio.view_dsl.dsl.a.h(imageView, R.id.zfy);
                    i.c(imageView, R.id.zfy);
                    o(imageView);
                    constraintLayout.addView(imageView);
                    Trace.endSection();
                    i.b(constraintLayout, Integer.valueOf(android.R.attr.progressBarStyleHorizontal), false, new Function1<ProgressBar, Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AioFileDefaultLayout$getRootView$1$1$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AioFileDefaultLayout.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ProgressBar progressBar) {
                            invoke2(progressBar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull ProgressBar StyleProgressBar) {
                            ViewGroup.LayoutParams layoutParams3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) StyleProgressBar);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(StyleProgressBar, "$this$StyleProgressBar");
                            int l3 = com.tencent.aio.view_dsl.dsl.b.l();
                            if (StyleProgressBar.getLayoutParams() == null) {
                                StyleProgressBar.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
                            } else {
                                StyleProgressBar.getLayoutParams().width = l3;
                            }
                            int dpToPx3 = ViewUtils.dpToPx(2.0f);
                            if (StyleProgressBar.getLayoutParams() == null) {
                                StyleProgressBar.setLayoutParams(new ViewGroup.LayoutParams(0, dpToPx3));
                            } else {
                                StyleProgressBar.getLayoutParams().height = dpToPx3;
                            }
                            StyleProgressBar.setId(R.id.lz7);
                            com.tencent.aio.view_dsl.dsl.a.g(StyleProgressBar, R.id.t4q);
                            com.tencent.aio.view_dsl.dsl.a.f(StyleProgressBar, R.id.f167042k73);
                            int dpToPx4 = ViewUtils.dpToPx(6.0f);
                            ViewGroup.LayoutParams layoutParams4 = StyleProgressBar.getLayoutParams();
                            if (!(layoutParams4 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams4 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams4;
                            if (marginLayoutParams != null) {
                                marginLayoutParams.topMargin = dpToPx4;
                                layoutParams3 = marginLayoutParams;
                            } else {
                                ViewGroup.LayoutParams layoutParams5 = StyleProgressBar.getLayoutParams();
                                int i19 = layoutParams5 != null ? layoutParams5.width : 0;
                                ViewGroup.LayoutParams layoutParams6 = StyleProgressBar.getLayoutParams();
                                Object[] objArr = {new ViewGroup.LayoutParams(i19, layoutParams6 != null ? layoutParams6.height : 0)};
                                ArrayList arrayList = new ArrayList(1);
                                arrayList.add(objArr[0].getClass());
                                Object[] array = arrayList.toArray(new Class[0]);
                                if (array != null) {
                                    Class[] clsArr = (Class[]) array;
                                    Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                                    Intrinsics.checkNotNullExpressionValue(it, "it");
                                    it.setAccessible(true);
                                    Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                                    ((ViewGroup.MarginLayoutParams) newInstance).topMargin = dpToPx4;
                                    layoutParams3 = (ViewGroup.LayoutParams) newInstance;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            StyleProgressBar.setLayoutParams(layoutParams3);
                            StyleProgressBar.setVisibility(4);
                            StyleProgressBar.setMax(100);
                            com.tencent.aio.view_dsl.dsl.a.b(StyleProgressBar, R.id.y36);
                            com.tencent.aio.view_dsl.dsl.d.b(StyleProgressBar, R.drawable.f161605q8);
                            AioFileDefaultLayout.this.s(StyleProgressBar);
                        }
                    }, 2, null);
                    TextView textView = new TextView(constraintLayout.getContext());
                    Object invoke4 = LayoutBuilderKt.b().invoke(constraintLayout, new Object[0]);
                    if (invoke4 != null) {
                        textView.setLayoutParams((ViewGroup.LayoutParams) invoke4);
                        int p26 = com.tencent.aio.view_dsl.dsl.b.p();
                        if (textView.getLayoutParams() == null) {
                            textView.setLayoutParams(new ViewGroup.LayoutParams(0, p26));
                        } else {
                            textView.getLayoutParams().height = p26;
                        }
                        textView.setText("file name");
                        textView.setTextSize(0, ViewUtils.dpToPx(17.0f));
                        int dpToPx3 = ViewUtils.dpToPx(14.0f);
                        ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                        if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams3 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                        if (marginLayoutParams != null) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, dpToPx3);
                            layoutParams = marginLayoutParams;
                        } else {
                            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                            if (layoutParams4 != null) {
                                i3 = layoutParams4.width;
                            } else {
                                i3 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                            if (layoutParams5 != null) {
                                i16 = layoutParams5.height;
                            } else {
                                i16 = 0;
                            }
                            Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(objArr[0].getClass());
                            Object[] array = arrayList.toArray(new Class[0]);
                            if (array != null) {
                                Class[] clsArr = (Class[]) array;
                                Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                it.setAccessible(true);
                                Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance, dpToPx3);
                                layoutParams = (ViewGroup.LayoutParams) newInstance;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView.setLayoutParams(layoutParams);
                        com.tencent.aio.view_dsl.dsl.a.f(textView, 0);
                        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_bubble_guest_text_primary));
                        if (textView.getLayoutParams() == null) {
                            textView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                        } else {
                            textView.getLayoutParams().width = 0;
                        }
                        textView.setId(R.id.kbs);
                        com.tencent.aio.view_dsl.dsl.a.h(textView, R.id.zfy);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        textView.setMaxLines(((Number) com.tencent.aio.view_dsl.dsl.c.a(2)).intValue());
                        textView.setIncludeFontPadding(true);
                        textView.setLineSpacing(0.0f, ((Number) com.tencent.aio.view_dsl.dsl.c.a(1)).floatValue());
                        com.tencent.aio.view_dsl.dsl.a.c(textView, R.id.y36);
                        u(textView);
                        constraintLayout.addView(textView);
                        TextView textView2 = new TextView(constraintLayout.getContext());
                        Object invoke5 = LayoutBuilderKt.b().invoke(constraintLayout, new Object[0]);
                        if (invoke5 != null) {
                            textView2.setLayoutParams((ViewGroup.LayoutParams) invoke5);
                            if (textView2.getLayoutParams() == null) {
                                textView2.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                            } else {
                                textView2.getLayoutParams().width = 0;
                            }
                            textView2.setId(R.id.f167042k73);
                            int dpToPx4 = ViewUtils.dpToPx(18.0f);
                            if (textView2.getLayoutParams() == null) {
                                textView2.setLayoutParams(new ViewGroup.LayoutParams(0, dpToPx4));
                            } else {
                                textView2.getLayoutParams().height = dpToPx4;
                            }
                            textView2.setText("file size");
                            textView2.setTextSize(0, ViewUtils.dpToPx(12.0f));
                            textView2.setEllipsize(TextUtils.TruncateAt.END);
                            com.tencent.aio.view_dsl.dsl.a.g(textView2, R.id.kbs);
                            textView2.setSingleLine(true);
                            com.tencent.aio.view_dsl.dsl.a.f(textView2, R.id.kbs);
                            int dpToPx5 = ViewUtils.dpToPx(6.0f);
                            ViewGroup.LayoutParams layoutParams6 = textView2.getLayoutParams();
                            if (!(layoutParams6 instanceof ViewGroup.MarginLayoutParams)) {
                                layoutParams6 = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams6;
                            if (marginLayoutParams2 != null) {
                                marginLayoutParams2.topMargin = dpToPx5;
                                layoutParams2 = marginLayoutParams2;
                            } else {
                                ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
                                if (layoutParams7 != null) {
                                    i17 = layoutParams7.width;
                                } else {
                                    i17 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams8 = textView2.getLayoutParams();
                                if (layoutParams8 != null) {
                                    i18 = layoutParams8.height;
                                } else {
                                    i18 = 0;
                                }
                                Object[] objArr2 = {new ViewGroup.LayoutParams(i17, i18)};
                                ArrayList arrayList2 = new ArrayList(1);
                                arrayList2.add(objArr2[0].getClass());
                                Object[] array2 = arrayList2.toArray(new Class[0]);
                                if (array2 != null) {
                                    Class[] clsArr2 = (Class[]) array2;
                                    Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                                    it5.setAccessible(true);
                                    Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                                    ((ViewGroup.MarginLayoutParams) newInstance2).topMargin = dpToPx5;
                                    layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            textView2.setLayoutParams(layoutParams2);
                            textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.qui_common_bubble_guest_text_secondary));
                            com.tencent.aio.view_dsl.dsl.a.b(textView2, 0);
                            t(textView2);
                            constraintLayout.addView(textView2);
                            Barrier barrier = new Barrier(constraintLayout.getContext());
                            int p27 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (barrier.getLayoutParams() == null) {
                                barrier.setLayoutParams(new ViewGroup.LayoutParams(p27, 0));
                            } else {
                                barrier.getLayoutParams().width = p27;
                            }
                            barrier.setId(R.id.t4q);
                            barrier.setType(3);
                            int p28 = com.tencent.aio.view_dsl.dsl.b.p();
                            if (barrier.getLayoutParams() == null) {
                                barrier.setLayoutParams(new ViewGroup.LayoutParams(0, p28));
                            } else {
                                barrier.getLayoutParams().height = p28;
                            }
                            split$default = StringsKt__StringsKt.split$default((CharSequence) "iv_file_icon,tv_desc", new String[]{","}, false, 0, 6, (Object) null);
                            List list = split$default;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                            Iterator it6 = list.iterator();
                            while (it6.hasNext()) {
                                arrayList3.add(Integer.valueOf(com.tencent.aio.view_dsl.dsl.c.f((String) it6.next())));
                            }
                            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList3);
                            barrier.setReferencedIds(intArray);
                            n(barrier);
                            constraintLayout.addView(barrier);
                            q(constraintLayout);
                            relativeLayout.addView(constraintLayout);
                            Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
                            RelativeLayout relativeLayout2 = new RelativeLayout(relativeLayout.getContext());
                            Object invoke6 = LayoutBuilderKt.b().invoke(relativeLayout, new Object[0]);
                            if (invoke6 != null) {
                                relativeLayout2.setLayoutParams((ViewGroup.LayoutParams) invoke6);
                                int p29 = com.tencent.aio.view_dsl.dsl.b.p();
                                if (relativeLayout2.getLayoutParams() == null) {
                                    relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(p29, 0));
                                } else {
                                    relativeLayout2.getLayoutParams().width = p29;
                                }
                                relativeLayout2.setId(R.id.zgw);
                                int p36 = com.tencent.aio.view_dsl.dsl.b.p();
                                if (relativeLayout2.getLayoutParams() == null) {
                                    relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, p36));
                                } else {
                                    relativeLayout2.getLayoutParams().height = p36;
                                }
                                r(relativeLayout2);
                                relativeLayout.addView(relativeLayout2);
                                Trace.endSection();
                                p(relativeLayout);
                                if (attach) {
                                    viewGroup.addView(relativeLayout);
                                }
                                Trace.endSection();
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

    @NotNull
    public final TextView k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TextView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        TextView textView = this.tvDesc;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
        return null;
    }

    @NotNull
    public final TextView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        TextView textView = this.tvTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    @NotNull
    public final View m() {
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

    public final void n(@NotNull Barrier barrier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) barrier);
        } else {
            Intrinsics.checkNotNullParameter(barrier, "<set-?>");
            this.barrier = barrier;
        }
    }

    public final void o(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivFileIcon = imageView;
        }
    }

    public final void p(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.msgContent = relativeLayout;
        }
    }

    public final void q(@NotNull ConstraintLayout constraintLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) constraintLayout);
        } else {
            Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
            this.msgFile = constraintLayout;
        }
    }

    public final void r(@NotNull RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) relativeLayout);
        } else {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.msgVideo = relativeLayout;
        }
    }

    public final void s(@NotNull ProgressBar progressBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) progressBar);
        } else {
            Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
            this.pbLoading = progressBar;
        }
    }

    public final void t(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvDesc = textView;
        }
    }

    public final void u(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTitle = textView;
        }
    }

    public final void v(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ AioFileDefaultLayout(Context context, Integer num, ViewGroup viewGroup, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num, (i3 & 4) == 0 ? viewGroup : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, viewGroup, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}

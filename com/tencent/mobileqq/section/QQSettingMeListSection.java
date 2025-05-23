package com.tencent.mobileqq.section;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.ac;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.adapter.u;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.ex;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J*\u0010\u0012\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/section/QQSettingMeListSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/adapter/u;", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "bizBean", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "rightText", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "leftIcon", "Lcom/tencent/mobileqq/redtouch/RedTouchTextView;", h.F, "Lcom/tencent/mobileqq/redtouch/RedTouchTextView;", "title", "i", "Landroid/view/View;", "itemContainer", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QQSettingMeListSection extends Section<u> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView rightText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView leftIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RedTouchTextView title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View itemContainer;

    public QQSettingMeListSection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void q(final QQSettingMeBizBean bizBean) {
        boolean z16;
        Drawable drawable;
        Context context;
        CharSequence charSequence;
        RedTouchTextView redTouchTextView;
        float f16;
        Resources resources;
        int i3;
        CharSequence charSequence2;
        ac acVar = new ac();
        DisplayMetrics displayMetrics = null;
        final a aVar = (a) RFWIocAbilityProvider.g().getIocInterface(a.class, this.rootView, null);
        if (aVar != null && !aVar.V6()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null) {
                viewGroup.setBackground(DrawerUtils.f306948a.e());
            }
        } else {
            ViewGroup viewGroup2 = this.rootView;
            if (viewGroup2 != null) {
                if (viewGroup2 != null && (context = viewGroup2.getContext()) != null) {
                    drawable = context.getDrawable(R.drawable.f161885kx1);
                } else {
                    drawable = null;
                }
                viewGroup2.setBackground(drawable);
            }
        }
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 != null) {
            viewGroup3.setFocusable(true);
        }
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 != null) {
            viewGroup4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.section.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQSettingMeListSection.r(a.this, bizBean, view);
                }
            });
        }
        ImageView imageView = this.leftIcon;
        if (imageView != null) {
            DrawerUtils.n(imageView, bizBean);
        }
        Boolean bool = bizBean.L;
        Intrinsics.checkNotNullExpressionValue(bool, "bizBean.needIconColorFilter");
        if (bool.booleanValue()) {
            ViewGroup viewGroup5 = this.rootView;
            Intrinsics.checkNotNull(viewGroup5);
            int color = ContextCompat.getColor(viewGroup5.getContext(), R.color.qui_common_icon_primary);
            ImageView imageView2 = this.leftIcon;
            if (imageView2 != null) {
                imageView2.setColorFilter(color);
            }
        }
        RedTouchTextView redTouchTextView2 = this.title;
        if (redTouchTextView2 != null) {
            if (bizBean.r() != null) {
                charSequence2 = bizBean.r().f184991a;
            } else {
                charSequence2 = "";
            }
            redTouchTextView2.setText(charSequence2);
        }
        RedTouchTextView redTouchTextView3 = this.title;
        if (redTouchTextView3 != null) {
            redTouchTextView3.setUseRedTouchTextColorFromConfig(false);
        }
        RedTouchTextView redTouchTextView4 = this.title;
        if (redTouchTextView4 != null) {
            redTouchTextView4.setTextColor(ex.b(R.color.qui_common_text_primary));
        }
        QQSettingMeBizBean.b r16 = bizBean.r();
        if (r16 != null) {
            charSequence = r16.f184992b;
        } else {
            charSequence = null;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.rightText;
            if (textView != null) {
                textView.setText(bizBean.r().f184992b);
            }
            TextView textView2 = this.rightText;
            if (textView2 != null) {
                TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                String o16 = bizBean.o();
                Intrinsics.checkNotNullExpressionValue(o16, "bizBean.redDotId");
                if (companion.a(o16)) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                textView2.setVisibility(i3);
            }
        }
        AccessibilityUtil.c(this.rootView, bizBean.r().f184991a, Button.class.getName());
        acVar.h(this.rootView);
        acVar.f(this.title);
        bizBean.w(acVar);
        if (TianshuRedTouch.INSTANCE.j() && (redTouchTextView = this.title) != null) {
            if (redTouchTextView != null) {
                redTouchTextView.R = Boolean.TRUE;
            }
            if (redTouchTextView != null) {
                redTouchTextView.c();
            }
            View view = this.itemContainer;
            if (view != null) {
                view.setVisibility(0);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 19;
            ViewGroup viewGroup6 = this.rootView;
            if (viewGroup6 != null && (resources = viewGroup6.getResources()) != null) {
                displayMetrics = resources.getDisplayMetrics();
            }
            layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 10.0f, displayMetrics);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 19;
            ViewGroup viewGroup7 = this.rootView;
            Intrinsics.checkNotNull(viewGroup7);
            Context context2 = viewGroup7.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "rootView!!.context");
            TianshuRedTouch tianshuRedTouch = new TianshuRedTouch(context2, this.itemContainer);
            RedTouchTextView redTouchTextView5 = this.title;
            float f17 = 0.0f;
            if (redTouchTextView5 != null) {
                f16 = redTouchTextView5.getWidth();
            } else {
                f16 = 0.0f;
            }
            TianshuRedTouch s06 = tianshuRedTouch.s0(f16);
            RedTouchTextView redTouchTextView6 = this.title;
            if (redTouchTextView6 != null) {
                f17 = redTouchTextView6.getHeight();
            }
            TianshuRedTouch n06 = s06.i0(f17).h0(8388629).m0(layoutParams2).q().k0(layoutParams).p0(TianshuRedTouch.RedTouchAssembleType.ALL_REDTOUCH).l0(false).n0(bizBean.o());
            acVar.e(n06);
            final WeakReference weakReference = new WeakReference(this.rightText);
            final WeakReference weakReference2 = new WeakReference(bizBean);
            n06.setNotifyRedBadgeUpdate(new Function1<String, Unit>(weakReference2, weakReference) { // from class: com.tencent.mobileqq.section.QQSettingMeListSection$bindNormalBiz$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference<QQSettingMeBizBean> $weakBean;
                final /* synthetic */ WeakReference<TextView> $weakTextView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$weakBean = weakReference2;
                    this.$weakTextView = weakReference;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference2, (Object) weakReference);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
                
                    if (r0.equals(r4) == true) goto L16;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(@NotNull String path) {
                    boolean z17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(path, "path");
                    QQSettingMeBizBean qQSettingMeBizBean = this.$weakBean.get();
                    if (qQSettingMeBizBean != null && (r0 = qQSettingMeBizBean.o()) != null) {
                        z17 = true;
                    }
                    z17 = false;
                    if (z17) {
                        if (TianshuRedTouch.INSTANCE.a(path)) {
                            TextView textView3 = this.$weakTextView.get();
                            if (textView3 == null) {
                                return;
                            }
                            textView3.setVisibility(8);
                            return;
                        }
                        TextView textView4 = this.$weakTextView.get();
                        if (textView4 == null) {
                            return;
                        }
                        textView4.setVisibility(0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(a aVar, QQSettingMeBizBean bizBean, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(bizBean, "$bizBean");
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String n3 = bizBean.n();
            Intrinsics.checkNotNullExpressionValue(n3, "bizBean.pluginID");
            aVar.H(it, n3);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        TextView textView;
        RedTouchTextView redTouchTextView;
        URLImageView uRLImageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        Intrinsics.checkNotNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        this.rootView = viewGroup;
        FrameLayout frameLayout = null;
        if (viewGroup != null) {
            textView = (TextView) viewGroup.findViewById(R.id.umh);
        } else {
            textView = null;
        }
        this.rightText = textView;
        ViewGroup viewGroup2 = this.rootView;
        if (viewGroup2 != null) {
            redTouchTextView = (RedTouchTextView) viewGroup2.findViewById(R.id.umj);
        } else {
            redTouchTextView = null;
        }
        this.title = redTouchTextView;
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 != null) {
            uRLImageView = (URLImageView) viewGroup3.findViewById(R.id.umf);
        } else {
            uRLImageView = null;
        }
        this.leftIcon = uRLImageView;
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 != null) {
            frameLayout = (FrameLayout) viewGroup4.findViewById(R.id.ume);
        }
        this.itemContainer = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable u data, int position, @Nullable List<Object> payload) {
        QQSettingMeBizBean qQSettingMeBizBean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null) {
            qQSettingMeBizBean = data.a();
        } else {
            qQSettingMeBizBean = null;
        }
        if (qQSettingMeBizBean != null && this.rootView != null) {
            q(qQSettingMeBizBean);
            return;
        }
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}

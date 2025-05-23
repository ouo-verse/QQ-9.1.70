package com.tencent.mobileqq.aio.msglist.holder.component.prologue;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import com.tencent.aio.data.msglist.a;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.r;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/prologue/AIOPrologueContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/r;", "", "", "payloads", "", "I1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", "c1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "b1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mWelcomeTv", "Landroid/widget/LinearLayout;", "D", "Lkotlin/Lazy;", "H1", "()Landroid/widget/LinearLayout;", "mRootView", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPrologueContentComponent extends BaseContentComponent<r> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mWelcomeTv;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public AIOPrologueContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.prologue.AIOPrologueContentComponent$mRootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPrologueContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                ViewGroup.LayoutParams layoutParams;
                ViewGroup.LayoutParams layoutParams2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context2 = AIOPrologueContentComponent.this.getContext();
                AIOPrologueContentComponent aIOPrologueContentComponent = AIOPrologueContentComponent.this;
                LinearLayout linearLayout = new LinearLayout(context2);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                linearLayout.setPadding(l.b(32), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), l.b(32), linearLayout.getPaddingBottom());
                linearLayout.setPadding(linearLayout.getPaddingLeft(), l.b(12), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), l.b(12));
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                View view = new View(linearLayout.getContext());
                Object invoke = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                if (invoke != null) {
                    view.setLayoutParams((ViewGroup.LayoutParams) invoke);
                    view.setBackgroundResource(R.color.bf5);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, (int) l.a(0.5f));
                    layoutParams3.weight = 1.0f;
                    view.setLayoutParams(layoutParams3);
                    linearLayout.addView(view);
                    TextView textView = new TextView(linearLayout.getContext());
                    Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                    if (invoke2 != null) {
                        textView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                        textView.setTextSize(12.0f);
                        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_secondary));
                        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        textView.setText("\u6b22\u8fce\u8bed");
                        int b16 = l.b(8);
                        ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                        if (!(layoutParams4 instanceof ViewGroup.MarginLayoutParams)) {
                            layoutParams4 = null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams4;
                        if (marginLayoutParams != null) {
                            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, b16);
                            layoutParams = marginLayoutParams;
                        } else {
                            ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                            int i3 = layoutParams5 != null ? layoutParams5.width : 0;
                            ViewGroup.LayoutParams layoutParams6 = textView.getLayoutParams();
                            Object[] objArr = {new ViewGroup.LayoutParams(i3, layoutParams6 != null ? layoutParams6.height : 0)};
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(objArr[0].getClass());
                            Object[] array = arrayList.toArray(new Class[0]);
                            if (array != null) {
                                Class[] clsArr = (Class[]) array;
                                Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                it.setAccessible(true);
                                Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, b16);
                                layoutParams = (ViewGroup.LayoutParams) newInstance;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView.setLayoutParams(layoutParams);
                        int b17 = l.b(8);
                        ViewGroup.LayoutParams layoutParams7 = textView.getLayoutParams();
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) (!(layoutParams7 instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams7);
                        if (marginLayoutParams2 != null) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams2, b17);
                            layoutParams2 = marginLayoutParams2;
                        } else {
                            ViewGroup.LayoutParams layoutParams8 = textView.getLayoutParams();
                            int i16 = layoutParams8 != null ? layoutParams8.width : 0;
                            ViewGroup.LayoutParams layoutParams9 = textView.getLayoutParams();
                            Object[] objArr2 = {new ViewGroup.LayoutParams(i16, layoutParams9 != null ? layoutParams9.height : 0)};
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(objArr2[0].getClass());
                            Object[] array2 = arrayList2.toArray(new Class[0]);
                            if (array2 != null) {
                                Class[] clsArr2 = (Class[]) array2;
                                Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                it5.setAccessible(true);
                                Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance2, b17);
                                layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        textView.setLayoutParams(layoutParams2);
                        aIOPrologueContentComponent.mWelcomeTv = textView;
                        linearLayout.addView(textView);
                        View view2 = new View(linearLayout.getContext());
                        Object invoke3 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
                        if (invoke3 != null) {
                            view2.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                            view2.setBackgroundResource(R.color.bf5);
                            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, (int) l.a(0.5f));
                            layoutParams10.weight = 1.0f;
                            view2.setLayoutParams(layoutParams10);
                            linearLayout.addView(view2);
                            return linearLayout;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        });
        this.mRootView = lazy;
    }

    private final LinearLayout H1() {
        return (LinearLayout) this.mRootView.getValue();
    }

    private final boolean I1(List<Object> payloads) {
        return payloads.isEmpty();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!I1(payloads)) {
            return;
        }
        TextView textView = this.mWelcomeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTv");
            textView = null;
        }
        textView.setText(q1().i2());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return H1();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        List<d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}

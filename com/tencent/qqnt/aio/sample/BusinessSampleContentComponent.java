package com.tencent.qqnt.aio.sample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010!R\u001b\u0010(\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010!R\u001b\u0010+\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010!R\u0014\u0010.\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/sample/BusinessSampleContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/qqnt/aio/sample/a;", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "H1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "M1", "()Landroid/view/ViewGroup;", "contentView", BdhLogUtil.LogTag.Tag_Conn, "N1", "()Landroid/widget/TextView;", "txtView", "D", "L1", "()I", "bubblePaddingTop", "E", "I1", "bubblePaddingBottom", UserInfo.SEX_FEMALE, "J1", "bubblePaddingLeft", "G", "K1", "bubblePaddingRight", "H", "I", "bubbleMaxWidth", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BusinessSampleContentComponent extends BaseContentComponent<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingTop;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingBottom;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingLeft;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingRight;

    /* renamed from: H, reason: from kotlin metadata */
    private final int bubbleMaxWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public BusinessSampleContentComponent() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.qqnt.aio.sample.BusinessSampleContentComponent$contentView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BusinessSampleContentComponent.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new FrameLayout(BusinessSampleContentComponent.this.getMContext()) : (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.contentView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.qqnt.aio.sample.BusinessSampleContentComponent$txtView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BusinessSampleContentComponent.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TextView invoke() {
                    TextView H1;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    BusinessSampleContentComponent businessSampleContentComponent = BusinessSampleContentComponent.this;
                    H1 = businessSampleContentComponent.H1(businessSampleContentComponent.getMContext());
                    return H1;
                }
            });
            this.txtView = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(BusinessSampleContentComponent$bubblePaddingTop$2.INSTANCE);
            this.bubblePaddingTop = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(BusinessSampleContentComponent$bubblePaddingBottom$2.INSTANCE);
            this.bubblePaddingBottom = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(BusinessSampleContentComponent$bubblePaddingLeft$2.INSTANCE);
            this.bubblePaddingLeft = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(BusinessSampleContentComponent$bubblePaddingRight$2.INSTANCE);
            this.bubblePaddingRight = lazy6;
            this.bubbleMaxWidth = a.C7329a.f192417a.b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView H1(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setTextSize(2, 17.0f);
        textView.setId(R.id.sit);
        textView.setMaxWidth(this.bubbleMaxWidth);
        return textView;
    }

    private final int I1() {
        return ((Number) this.bubblePaddingBottom.getValue()).intValue();
    }

    private final int J1() {
        return ((Number) this.bubblePaddingLeft.getValue()).intValue();
    }

    private final int K1() {
        return ((Number) this.bubblePaddingRight.getValue()).intValue();
    }

    private final int L1() {
        return ((Number) this.bubblePaddingTop.getValue()).intValue();
    }

    private final ViewGroup M1() {
        return (ViewGroup) this.contentView.getValue();
    }

    private final TextView N1() {
        return (TextView) this.txtView.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        TextView N1 = N1();
        if (msgItem.isSelf()) {
            i3 = R.color.f158017al3;
        } else {
            i3 = R.color.black;
        }
        N1.setTextColor(N1.getContext().getResources().getColor(i3));
        if (msgItem.isSelf()) {
            i16 = R.drawable.skin_aio_user_bubble_nor_simple;
        } else {
            i16 = R.drawable.skin_aio_friend_bubble_nor_simple;
        }
        N1.setBackground(N1.getContext().getResources().getDrawable(i16));
        N1.setPadding(J1(), L1(), K1(), I1());
        N1.setText("\u4e1a\u52a1\u793a\u4f8b\u6c14\u6ce1");
        if (N1().getParent() == null) {
            M1().addView(N1());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return M1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        List<d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }
}

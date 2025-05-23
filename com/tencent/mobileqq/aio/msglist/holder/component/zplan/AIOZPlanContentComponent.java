package com.tencent.mobileqq.aio.msglist.holder.component.zplan;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ZPlanMsgItem;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.zplan.AIOZPlanContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.j;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.n;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J&\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/AIOZPlanContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponent;", "Lcom/tencent/mobileqq/aio/msg/ZPlanMsgItem;", "", "v2", "", "", "payloads", "", "z2", NowProxyConstants.AccountInfoKey.A2, "B2", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", ExifInterface.LATITUDE_SOUTH, "j1", "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/c;", "w2", "Landroid/graphics/drawable/Drawable;", "drawable", "backgroundMinWidth", "backgroundMinHeight", "i2", "L", "Landroid/view/View;", "textView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/AIOZPlanContentComponent$ZPlanSelectableLinearLayout;", "M", "Lkotlin/Lazy;", "x2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/AIOZPlanContentComponent$ZPlanSelectableLinearLayout;", "mContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "N", "y2", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mContentWithForeground", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "P", "a", "ZPlanSelectableLinearLayout", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOZPlanContentComponent extends BaseMixContentComponent<ZPlanMsgItem> {

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View textView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContentWithForeground;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/AIOZPlanContentComponent$ZPlanSelectableLinearLayout;", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/ZPlanMsgItem;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/aio/msg/ZPlanMsgItem;", "getZPlanMsgItem", "()Lcom/tencent/mobileqq/aio/msg/ZPlanMsgItem;", "setZPlanMsgItem", "(Lcom/tencent/mobileqq/aio/msg/ZPlanMsgItem;)V", "zPlanMsgItem", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ZPlanSelectableLinearLayout extends SelectableLinearLayout {

        /* renamed from: S, reason: from kotlin metadata */
        @Nullable
        private ZPlanMsgItem zPlanMsgItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZPlanSelectableLinearLayout(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.tencent.qqnt.aio.widget.SelectableLinearLayout, nv3.b
        @NotNull
        public CharSequence m() {
            ZPlanMsgItem zPlanMsgItem = this.zPlanMsgItem;
            if (zPlanMsgItem == null) {
                CharSequence m3 = super.m();
                Intrinsics.checkNotNullExpressionValue(m3, "super.getSelectContent()");
                return m3;
            }
            return com.tencent.mobileqq.aio.utils.d.n(zPlanMsgItem);
        }

        public final void setZPlanMsgItem(@Nullable ZPlanMsgItem zPlanMsgItem) {
            this.zPlanMsgItem = zPlanMsgItem;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOZPlanContentComponent(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanSelectableLinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.zplan.AIOZPlanContentComponent$mContent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOZPlanContentComponent.ZPlanSelectableLinearLayout invoke() {
                AIOZPlanContentComponent.ZPlanSelectableLinearLayout zPlanSelectableLinearLayout = new AIOZPlanContentComponent.ZPlanSelectableLinearLayout(context);
                zPlanSelectableLinearLayout.setOrientation(0);
                zPlanSelectableLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                return zPlanSelectableLinearLayout;
            }
        });
        this.mContent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new AIOZPlanContentComponent$mContentWithForeground$2(context, this));
        this.mContentWithForeground = lazy2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    private final void A2() {
        if (!((ZPlanMsgItem) q1()).E2() && ((ZPlanMsgItem) q1()).D2()) {
            ((IAIOZPlanShowMsgApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOZPlanShowMsgApi.class)).onPlayAction(q1());
            ((ZPlanMsgItem) q1()).I2();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B2() {
        View view;
        j jVar;
        AIOBubbleSkinInfo x06 = ((ZPlanMsgItem) q1()).x0();
        if (x06 == null || (view = this.textView) == null) {
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = x06.b();
        if (b16 instanceof j) {
            jVar = (j) b16;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            if (view.getPaddingLeft() != jVar.c() || view.getPaddingRight() != jVar.d() || view.getPaddingTop() != jVar.e() || view.getPaddingBottom() != jVar.b()) {
                view.setPadding(jVar.c(), jVar.e(), jVar.d(), jVar.b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ZPlanMsgItem u2(AIOZPlanContentComponent aIOZPlanContentComponent) {
        return (ZPlanMsgItem) aIOZPlanContentComponent.q1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v2() {
        AIOBubbleSkinInfo.c e16;
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ViewUtils.dip2px(15.0f);
        layoutParams.rightMargin = -ViewUtils.dip2px(13.0f);
        if (((ZPlanMsgItem) q1()).isSelf()) {
            layoutParams.leftMargin += ViewUtils.dip2px(2.0f);
            layoutParams.rightMargin -= ViewUtils.dip2px(1.5f);
        }
        Typeface a16 = d.a(getContext());
        if (a16 != null) {
            textView.setTypeface(a16);
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.ayp) * 1.3f);
            AIOBubbleSkinInfo x06 = ((ZPlanMsgItem) q1()).x0();
            if (x06 != null && (e16 = x06.e()) != null) {
                Integer a17 = e16.a();
                if (a17 != null) {
                    textView.setTextColor(a17.intValue());
                }
                ColorStateList b16 = e16.b();
                if (b16 != null) {
                    textView.setTextColor(b16);
                }
            }
            textView.setText("\ue900");
            textView.requestLayout();
            x2().addView(textView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanSelectableLinearLayout x2() {
        return (ZPlanSelectableLinearLayout) this.mContent.getValue();
    }

    private final ConstraintLayout y2() {
        return (ConstraintLayout) this.mContentWithForeground.getValue();
    }

    private final boolean z2(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        return x2().q();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (!z2(payloads)) {
            return;
        }
        if (x1()) {
            QLog.i("AIOZPlanContentComponent", 1, "[bind] same data, msgItem=" + msgItem);
            return;
        }
        if (((ZPlanMsgItem) q1()).o2().isEmpty()) {
            return;
        }
        if (c2().isEmpty()) {
            W1();
            this.textView = X1();
        }
        x2().removeAllViews();
        v2();
        Q1(q1(), x2(), 0, true, true);
        p2((o) q1());
        A2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        return y2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent
    public void i2(@NotNull Drawable drawable, int backgroundMinWidth, int backgroundMinHeight) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        AIOUtil.f194084a.F(x2(), drawable);
        B2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void j1() {
        if (x2().q()) {
            sendIntent(d.f.f192343d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem] */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        boolean z16;
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        boolean z17 = false;
        if (!v1()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new af(getMContext(), q1(), this), new h(getMContext(), q1(), this), new u(getMContext(), q1(), this));
            mutableListOf.add(new aj(getMContext(), q1(), this));
            if (((ZPlanMsgItem) q1()).getMsgRecord().chatType == 2 || ((ZPlanMsgItem) q1()).getMsgRecord().chatType == 1) {
                String b16 = m.f194167a.b(q1());
                if (b16.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && !Intrinsics.areEqual(b16, "0")) {
                    z17 = true;
                }
                if (z17) {
                    mutableListOf.add(new n(getMContext(), q1(), this));
                }
            }
            return mutableListOf;
        }
        i iVar = new i(getMContext(), q1());
        iVar.i(x2());
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new k(getMContext(), q1(), this, x2()), iVar});
        return listOf;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: w2, reason: merged with bridge method [inline-methods] */
    public c createVM() {
        return new c();
    }
}

package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0011\b\u0016\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103B\u001b\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\b\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b2\u00106J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H$J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateSpaceBaseMenuItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lij/e;", "Landroid/view/View;", "view", "", "id", "", "o0", "bean", "w0", "x0", "s0", "v0", "p0", com.tencent.luggage.wxa.c8.c.G, "n0", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "name", "f", "getState", "setState", "state", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "icon", "i", "Landroid/view/View;", "q0", "()Landroid/view/View;", "setIconBg", "(Landroid/view/View;)V", "iconBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r0", "setItemBg", "itemBg", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZIntimateSpaceBaseMenuItemView extends QZoneBaseWidgetView<ij.e> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView state;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView icon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View iconBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View itemBg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceBaseMenuItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void s0(final ij.e bean) {
        if (p0() == null) {
            QLog.e("QZIntimateSpaceBaseMenuItemView", 1, "get click area is null");
            return;
        }
        View p06 = p0();
        Intrinsics.checkNotNull(p06);
        p06.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZIntimateSpaceBaseMenuItemView.u0(QZIntimateSpaceBaseMenuItemView.this, bean, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(QZIntimateSpaceBaseMenuItemView this$0, ij.e bean, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        ho.i.q(this$0.getContext(), bean.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v0(ij.e bean) {
        String iconUrlDay;
        if (!TextUtils.isEmpty(bean.getIconSpecialUrl())) {
            iconUrlDay = bean.getIconSpecialUrl();
        } else if (com.qzone.reborn.util.k.f59549a.f()) {
            iconUrlDay = bean.getIconUrlNight();
        } else {
            iconUrlDay = bean.getIconUrlDay();
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(iconUrlDay).setTargetView(this.icon).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
    }

    private final void w0(ij.e bean) {
        TextView textView = this.name;
        if (textView == null) {
            return;
        }
        textView.setText(bean.getName());
    }

    private final void x0(ij.e bean) {
        TextView textView = this.state;
        if (textView == null) {
            return;
        }
        textView.setText(bean.getState());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(ij.e bean, int pos) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        w0(bean);
        x0(bean);
        s0(bean);
        v0(bean);
        o0(p0(), bean.getId());
    }

    protected abstract View p0();

    /* renamed from: q0, reason: from getter */
    public final View getIconBg() {
        return this.iconBg;
    }

    /* renamed from: r0, reason: from getter */
    public final View getItemBg() {
        return this.itemBg;
    }

    public final void setIcon(ImageView imageView) {
        this.icon = imageView;
    }

    public final void setIconBg(View view) {
        this.iconBg = view;
    }

    public final void setItemBg(View view) {
        this.itemBg = view;
    }

    public final void setName(TextView textView) {
        this.name = textView;
    }

    public final void setState(TextView textView) {
        this.state = textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceBaseMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void o0(View view, int id5) {
        Map<String, Object> mutableMapOf;
        if (view == null) {
            return;
        }
        fo.b bVar = new fo.b();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("function_entry_id", Integer.valueOf(id5)));
        bVar.l(mutableMapOf);
        fo.c.o(view, "em_qz_function_entry", bVar);
    }
}

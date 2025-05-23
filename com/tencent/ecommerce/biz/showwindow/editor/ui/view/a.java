package com.tencent.ecommerce.biz.showwindow.editor.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00017B-\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0,\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\b4\u00105J$\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0012R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/a;", "Landroid/widget/BaseAdapter;", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "selectIndex", "", "c", "getCount", "", "b", "", "getItemId", "d", "I", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedIndex", "", "e", "Z", "getSetDefaultFlag", "()Z", "setSetDefaultFlag", "(Z)V", "setDefaultFlag", "Landroid/view/LayoutInflater;", "f", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", h.F, "Landroid/content/Context;", "context", "i", "layoutResourceID", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "list", "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECSelectedIndexListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECSelectedIndexListener;", "selectedIndexListener", "<init>", "(Landroid/content/Context;ILjava/util/List;Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECSelectedIndexListener;)V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends BaseAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    private final ECSelectedIndexListener selectedIndexListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int selectedIndex = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean setDefaultFlag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater inflater;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int layoutResourceID;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<String> list;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f104478e;

        b(int i3) {
            this.f104478e = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.selectedIndexListener.onSelectedIndex(this.f104478e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(Context context, int i3, List<String> list, ECSelectedIndexListener eCSelectedIndexListener) {
        this.context = context;
        this.layoutResourceID = i3;
        this.list = list;
        this.selectedIndexListener = eCSelectedIndexListener;
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.inflater = (LayoutInflater) systemService;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final void c(int selectIndex) {
        this.selectedIndex = selectIndex;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getItem(int position) {
        if (position >= 0) {
            return this.list.get(position);
        }
        return "";
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = convertView != null ? convertView : this.inflater.inflate(this.layoutResourceID, (ViewGroup) null);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.nzh);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.o1q);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.o1r);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.o1p);
        frameLayout.setOnClickListener(new b(position));
        imageView3.setImageDrawable(ECSkin.INSTANCE.getDrawable("qecommerce_post_tag_cover"));
        if (this.selectedIndex == position) {
            imageView2.setImageResource(R.drawable.e6v);
        } else {
            imageView2.setImageResource(R.drawable.e5s);
        }
        if (position == 0 && !this.setDefaultFlag) {
            imageView3.setVisibility(0);
            this.setDefaultFlag = true;
        }
        int f16 = ECDeviceUtils.f104857e.f();
        int i3 = f16 / 3;
        ImageViewKt.b(imageView, this.list.get(position), i3, i3, 0, 8, null);
        cg0.a.b("ECProductCardCoverImgSelectAdapter", f16 + " / 3 " + f16 + " / 3");
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return inflate;
    }
}

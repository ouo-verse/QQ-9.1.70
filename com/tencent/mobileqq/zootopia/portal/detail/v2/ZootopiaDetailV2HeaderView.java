package com.tencent.mobileqq.zootopia.portal.detail.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.detail.am;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailV2HeaderView;
import com.tencent.mobileqq.zootopia.utils.l;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.view.ZootopiaMaskView;
import fi3.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.bk;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020#\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\"\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u0010:\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/v2/ZootopiaDetailV2HeaderView;", "Landroid/widget/LinearLayout;", "", "l", "", "desc", "", "v", "onlineTime", "j", "memberCount", "i", "visitorsCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/sqshow/zootopia/data/m;", "map", "g", "iconUrl", "k", "f", "e", "", "labels", h.F, "label", "Landroid/widget/TextView;", "r", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "u", "", Element.ELEMENT_NAME_DISTANCE, "w", "d", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "Landroidx/lifecycle/LifecycleOwner;", "I", "initBgImageHeight", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lfi3/v;", "Lfi3/v;", "binding", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "btnEnter", "Ln74/bk;", BdhLogUtil.LogTag.Tag_Conn, "Ln74/bk;", "t", "()Ln74/bk;", "guideView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailV2HeaderView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final bk guideView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private am vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner owner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int initBgImageHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final v binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaDownloadButton btnEnter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailV2HeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r5.isGameType() == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(ZootopiaMapDetail map) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z16;
        if (!map.K()) {
            am amVar = this.vm;
            if (amVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                amVar = null;
            }
            ZootopiaMapSimpleInfo mapItemInfo = amVar.getMapItemInfo();
            if (mapItemInfo != null) {
                z16 = true;
            }
            z16 = false;
            if (!z16) {
                ViewGroup.LayoutParams layoutParams2 = this.binding.f399412j.getLayoutParams();
                layoutParams = layoutParams2 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams2 : null;
                if (layoutParams != null) {
                    layoutParams.addRule(8, 0);
                    layoutParams.bottomMargin = ViewUtils.dpToPx(10.0f);
                    return;
                }
                return;
            }
        }
        this.binding.f399407e.setVisibility(8);
        this.binding.f399413k.setVisibility(8);
        this.binding.f399417o.setVisibility(8);
        ViewGroup.LayoutParams layoutParams3 = this.binding.f399412j.getLayoutParams();
        layoutParams = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams != null) {
            layoutParams.addRule(8, this.binding.f399404b.getId());
            layoutParams.bottomMargin = 0;
        }
    }

    private final void f(ZootopiaMapDetail map) {
        Object tag = this.binding.f399405c.getTag();
        String str = tag instanceof String ? (String) tag : null;
        boolean z16 = false;
        if (str != null && str.equals(map.getBackground())) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.binding.f399405c.setTag(map.getBackground());
        x(map);
    }

    private final void g(ZootopiaMapDetail map) {
        f(map);
        e(map);
        this.binding.f399415m.setText(map.getTitle());
        this.binding.f399416n.setText(map.getTypeText());
        ZootopiaMaskView zootopiaMaskView = this.binding.f399410h;
        Intrinsics.checkNotNullExpressionValue(zootopiaMaskView, "binding.maskMapInfo");
        ZootopiaMaskView.setMaskBackground$default(zootopiaMaskView, map.getBackColor(), false, 2, null);
        k(map.getTypeIcon());
        h(map.p());
    }

    private final void h(List<String> labels) {
        Object tag = this.binding.f399408f.getTag();
        List list = tag instanceof List ? (List) tag : null;
        boolean z16 = false;
        if (list != null && list.containsAll(labels)) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.binding.f399408f.setTag(labels);
        if (this.binding.f399408f.getChildCount() > 0) {
            this.binding.f399408f.removeAllViews();
        }
        for (String str : labels) {
            LinearLayout linearLayout = this.binding.f399408f;
            TextView r16 = r(str);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i.h(this), i.h(this));
            layoutParams.rightMargin = i.b(5);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(r16, layoutParams);
        }
    }

    private final void i(String memberCount) {
        this.binding.f399413k.setText(memberCount);
        if (this.binding.f399407e.getVisibility() != 0) {
            this.binding.f399407e.setVisibility(0);
        }
    }

    private final void j(String onlineTime) {
        if (TextUtils.isEmpty(onlineTime)) {
            this.binding.f399414l.setVisibility(4);
            return;
        }
        this.binding.f399414l.setText(onlineTime);
        if (this.binding.f399414l.getVisibility() != 0) {
            this.binding.f399414l.setVisibility(0);
        }
    }

    private final void k(String iconUrl) {
        if (TextUtils.isEmpty(iconUrl)) {
            return;
        }
        this.binding.f399406d.setImageDrawable(URLDrawable.getDrawable(iconUrl, URLDrawable.URLDrawableOptions.obtain()));
    }

    private final void l() {
        am amVar = this.vm;
        LifecycleOwner lifecycleOwner = null;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar = null;
        }
        ZootopiaMapSimpleInfo mapItemInfo = amVar.getMapItemInfo();
        if (mapItemInfo == null || mapItemInfo.getName() == null) {
            am amVar2 = this.vm;
            if (amVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                amVar2 = null;
            }
            ZootopiaMapDetail value = amVar2.R1().getValue();
            if (value != null) {
                value.getTitle();
            }
        }
        am amVar3 = this.vm;
        if (amVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar3 = null;
        }
        ZootopiaMapSimpleInfo mapItemInfo2 = amVar3.getMapItemInfo();
        if (mapItemInfo2 != null) {
            g(ZootopiaMapDetail.INSTANCE.a(mapItemInfo2));
        }
        am amVar4 = this.vm;
        if (amVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar4 = null;
        }
        MutableLiveData<ZootopiaMapDetail> R1 = amVar4.R1();
        LifecycleOwner lifecycleOwner2 = this.owner;
        if (lifecycleOwner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
            lifecycleOwner2 = null;
        }
        R1.observe(lifecycleOwner2, new Observer() { // from class: xc3.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailV2HeaderView.m(ZootopiaDetailV2HeaderView.this, (ZootopiaMapDetail) obj);
            }
        });
        am amVar5 = this.vm;
        if (amVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar5 = null;
        }
        LiveData<String> W1 = amVar5.W1();
        LifecycleOwner lifecycleOwner3 = this.owner;
        if (lifecycleOwner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
            lifecycleOwner3 = null;
        }
        W1.observe(lifecycleOwner3, new Observer() { // from class: xc3.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailV2HeaderView.n(ZootopiaDetailV2HeaderView.this, (String) obj);
            }
        });
        am amVar6 = this.vm;
        if (amVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar6 = null;
        }
        LiveData<String> X1 = amVar6.X1();
        LifecycleOwner lifecycleOwner4 = this.owner;
        if (lifecycleOwner4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
            lifecycleOwner4 = null;
        }
        X1.observe(lifecycleOwner4, new Observer() { // from class: xc3.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailV2HeaderView.o(ZootopiaDetailV2HeaderView.this, (String) obj);
            }
        });
        am amVar7 = this.vm;
        if (amVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar7 = null;
        }
        LiveData<String> Z1 = amVar7.Z1();
        LifecycleOwner lifecycleOwner5 = this.owner;
        if (lifecycleOwner5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
        } else {
            lifecycleOwner = lifecycleOwner5;
        }
        Z1.observe(lifecycleOwner, new Observer() { // from class: xc3.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailV2HeaderView.p(ZootopiaDetailV2HeaderView.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZootopiaDetailV2HeaderView this$0, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaMapDetail == null) {
            return;
        }
        this$0.g(zootopiaMapDetail);
        if (zootopiaMapDetail.getFromSimpleData()) {
            return;
        }
        this$0.binding.f399418p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ZootopiaDetailV2HeaderView this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        am amVar = this$0.vm;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar = null;
        }
        ZootopiaMapDetail value = amVar.R1().getValue();
        boolean z16 = false;
        if (value != null && value.getFromSimpleData()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (this$0.v(it)) {
            this$0.binding.f399407e.setVisibility(8);
        } else {
            this$0.i(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ZootopiaDetailV2HeaderView this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        am amVar = this$0.vm;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar = null;
        }
        ZootopiaMapDetail value = amVar.R1().getValue();
        boolean z16 = false;
        if (value != null && value.getFromSimpleData()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.j(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        if (r0.k() == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void p(ZootopiaDetailV2HeaderView this$0, String it) {
        boolean z16;
        RelativeLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        am amVar = this$0.vm;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar = null;
        }
        ZootopiaMapDetail value = amVar.R1().getValue();
        if (value != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!this$0.v(it)) {
            this$0.q(it);
            ViewGroup.LayoutParams layoutParams2 = this$0.binding.f399412j.getLayoutParams();
            layoutParams = layoutParams2 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams2 : null;
            if (layoutParams != null) {
                layoutParams.addRule(8, 0);
                layoutParams.bottomMargin = ViewUtils.dpToPx(10.0f);
                return;
            }
            return;
        }
        this$0.binding.f399417o.setVisibility(8);
        ViewGroup.LayoutParams layoutParams3 = this$0.binding.f399412j.getLayoutParams();
        layoutParams = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams != null) {
            layoutParams.addRule(8, this$0.binding.f399404b.getId());
            layoutParams.bottomMargin = 0;
        }
    }

    private final void q(String visitorsCount) {
        this.binding.f399417o.setText(visitorsCount);
        if (this.binding.f399417o.getVisibility() != 0) {
            this.binding.f399417o.setVisibility(0);
        }
    }

    private final TextView r(String label) {
        TextView textView = new TextView(getContext());
        textView.setText(label);
        i.i(textView, 12.0f);
        textView.setPadding(i.b(8), i.b(2), i.b(8), i.b(2));
        textView.setTextColor(-1);
        textView.setGravity(17);
        l.a(textView, i.b(10), q.a(R.color.f85479));
        return textView;
    }

    private final boolean v(String desc) {
        if (TextUtils.isEmpty(desc)) {
            return true;
        }
        am amVar = this.vm;
        am amVar2 = null;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar = null;
        }
        ZootopiaMapDetail value = amVar.R1().getValue();
        if (value != null && value.K()) {
            return true;
        }
        am amVar3 = this.vm;
        if (amVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            amVar2 = amVar3;
        }
        ZootopiaMapSimpleInfo mapItemInfo = amVar2.getMapItemInfo();
        return mapItemInfo != null && mapItemInfo.isGameType();
    }

    private final void x(ZootopiaMapDetail map) {
        if (TextUtils.isEmpty(map.getBackground())) {
            this.binding.f399405c.setDefaultBackground();
            return;
        }
        QLog.i("ZootopiaDetailHeaderViewV2", 1, "startPlayBackground " + map.getBgType());
        ZootopiaPlayerView zootopiaPlayerView = this.binding.f399405c;
        int bgType = map.getBgType();
        if (bgType == 1) {
            Intrinsics.checkNotNullExpressionValue(zootopiaPlayerView, "this");
            ZootopiaPlayerView.setApngBackgroundUrl$default(zootopiaPlayerView, map.getBackground(), 0, 0, false, null, 30, null);
            return;
        }
        if (bgType == 2) {
            Intrinsics.checkNotNullExpressionValue(zootopiaPlayerView, "this");
            ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView, map.getBackground(), 0, 0, null, 14, null);
        } else {
            if (bgType != 3) {
                zootopiaPlayerView.setDefaultBackground();
                return;
            }
            Intrinsics.checkNotNullExpressionValue(zootopiaPlayerView, "this");
            ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView, map.getBackground(), 0, 0, null, 14, null);
            zootopiaPlayerView.setVideoUrl(map.getVideoUrl());
            ZootopiaPlayerView.z(zootopiaPlayerView, false, false, 3, null);
        }
    }

    /* renamed from: s, reason: from getter */
    public final ZootopiaDownloadButton getBtnEnter() {
        return this.btnEnter;
    }

    /* renamed from: t, reason: from getter */
    public final bk getGuideView() {
        return this.guideView;
    }

    public final void u(ZootopiaSource source, LifecycleOwner owner, am vm5) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.source = source;
        this.vm = vm5;
        this.owner = owner;
        l();
        this.binding.f399405c.setOnClickListener(null);
    }

    public final void w(int distance) {
        if (this.initBgImageHeight <= 0) {
            this.initBgImageHeight = this.binding.f399405c.getHeight();
        }
        ZootopiaPlayerView zootopiaPlayerView = this.binding.f399405c;
        ViewGroup.LayoutParams layoutParams = zootopiaPlayerView.getLayoutParams();
        layoutParams.height = this.initBgImageHeight + distance;
        zootopiaPlayerView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailV2HeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaDetailV2HeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailV2HeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        v f16 = v.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        ZootopiaDownloadButton zootopiaDownloadButton = f16.f399404b;
        Intrinsics.checkNotNullExpressionValue(zootopiaDownloadButton, "binding.btnEnter");
        this.btnEnter = zootopiaDownloadButton;
        bk bkVar = f16.f399419q;
        Intrinsics.checkNotNull(bkVar, "null cannot be cast to non-null type com.tencent.sqshow.portal.impl.databinding.ZplanGuideTipsBottomViewBinding");
        this.guideView = bkVar;
        setOrientation(1);
    }
}

package com.tencent.mobileqq.zootopia.portal.detail;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
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
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailImageGallery;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaVersionUpdateInfo;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.view.ZootopiaMaskView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u0001:\u0001MB'\b\u0007\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020&\u00a2\u0006\u0004\bI\u0010JB;\b\u0016\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010;\u001a\u000209\u00a2\u0006\u0004\bI\u0010KJ1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0016\u0010!\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u001e\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010,\u001a\u00020\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u000e\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020&J\u0006\u00103\u001a\u00020\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u00106R\u0016\u00108\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010=R\u0017\u0010C\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010@\u001a\u0004\bA\u0010B\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailHeaderView;", "Landroid/widget/LinearLayout;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "", "progress", "", HippyTKDListViewAdapter.X, "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/portal/detail/am;Lcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;)V", "p", "", "desc", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onlineTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "memberCount", "l", "visitorsCount", "u", "Lcom/tencent/sqshow/zootopia/data/m;", "map", "j", "iconUrl", DomainData.DOMAIN_NAME, "i", "", "Lcom/tencent/sqshow/zootopia/data/l;", "comments", "e", tl.h.F, "Lcom/tencent/sqshow/zootopia/data/ab;", "versionUpdate", "o", "", "galleryType", "imageList", "g", "f", "labels", "k", "label", "Landroid/widget/TextView;", "v", "B", Element.ELEMENT_NAME_DISTANCE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "d", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "Landroidx/lifecycle/LifecycleOwner;", "I", "initBgImageHeight", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lfi3/r;", "Lfi3/r;", "binding", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "w", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "btnEnter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/portal/detail/am;Lcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailHeaderView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private am vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner owner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int initBgImageHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final fi3.r binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaDownloadButton btnEnter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B(ZootopiaMapDetail map) {
        if (TextUtils.isEmpty(map.getBackground())) {
            this.binding.f399335c.setDefaultBackground();
            return;
        }
        QLog.i("ZootopiaDetailHeaderView", 1, "startPlayBackground " + map.getBgType());
        ZootopiaPlayerView zootopiaPlayerView = this.binding.f399335c;
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

    private final void e(List<ZootopiaMapComment> comments) {
        if (comments.isEmpty()) {
            this.binding.f399349q.setVisibility(8);
        } else if (this.binding.f399349q.getVisibility() != 0) {
            this.binding.f399349q.setVisibility(0);
        }
    }

    private final void f(String desc) {
        this.binding.f399343k.setText(desc);
    }

    private final void g(int galleryType, List<String> imageList) {
        if (imageList.isEmpty()) {
            this.binding.f399350r.setVisibility(8);
            this.binding.f399351s.setVisibility(8);
            return;
        }
        if (this.binding.f399351s.getVisibility() != 0) {
            this.binding.f399350r.setVisibility(0);
            this.binding.f399351s.setVisibility(0);
        }
        this.binding.f399350r.L(galleryType);
        this.binding.f399350r.K(imageList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r5.isGameType() == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(ZootopiaMapDetail map) {
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
                ViewGroup.LayoutParams layoutParams2 = this.binding.f399342j.getLayoutParams();
                layoutParams = layoutParams2 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams2 : null;
                if (layoutParams != null) {
                    layoutParams.addRule(8, 0);
                    layoutParams.bottomMargin = ViewUtils.dpToPx(10.0f);
                    return;
                }
                return;
            }
        }
        this.binding.f399337e.setVisibility(8);
        this.binding.f399344l.setVisibility(8);
        this.binding.f399348p.setVisibility(8);
        ViewGroup.LayoutParams layoutParams3 = this.binding.f399342j.getLayoutParams();
        layoutParams = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams != null) {
            layoutParams.addRule(8, this.binding.f399334b.getId());
            layoutParams.bottomMargin = 0;
        }
    }

    private final void i(ZootopiaMapDetail map) {
        QLog.i("DemoTest", 1, "detail bindHeaderBg  " + map);
        Object tag = this.binding.f399335c.getTag();
        String str = tag instanceof String ? (String) tag : null;
        if (str != null && str.equals(map.getBackground())) {
            return;
        }
        this.binding.f399335c.setTag(map.getBackground());
        B(map);
    }

    private final void j(ZootopiaMapDetail map) {
        i(map);
        h(map);
        this.binding.f399346n.setText(map.getTitle());
        this.binding.f399347o.setText(map.getTypeText());
        ZootopiaMaskView zootopiaMaskView = this.binding.f399340h;
        Intrinsics.checkNotNullExpressionValue(zootopiaMaskView, "binding.maskMapInfo");
        ZootopiaMaskView.setMaskBackground$default(zootopiaMaskView, map.getBackColor(), false, 2, null);
        n(map.getTypeIcon());
        this.binding.f399334b.setDownloadSize(map);
        this.binding.f399334b.setStatusText(ButtonStatus.LOADED, map.getButtonText());
        k(map.p());
        f(map.getDescDetail());
        g(map.getGalleryType(), map.o());
        o(map.getVersionUpdate());
        e(map.g());
    }

    private final void k(List<String> labels) {
        Object tag = this.binding.f399338f.getTag();
        List list = tag instanceof List ? (List) tag : null;
        boolean z16 = false;
        if (list != null && list.containsAll(labels)) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.binding.f399338f.setTag(labels);
        if (this.binding.f399338f.getChildCount() > 0) {
            this.binding.f399338f.removeAllViews();
        }
        for (String str : labels) {
            LinearLayout linearLayout = this.binding.f399338f;
            TextView v3 = v(str);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.h(this), com.tencent.sqshow.zootopia.utils.i.h(this));
            layoutParams.rightMargin = com.tencent.sqshow.zootopia.utils.i.b(5);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(v3, layoutParams);
        }
    }

    private final void l(String memberCount) {
        this.binding.f399344l.setText(memberCount);
        if (this.binding.f399337e.getVisibility() != 0) {
            this.binding.f399337e.setVisibility(0);
        }
    }

    private final void m(String onlineTime) {
        if (TextUtils.isEmpty(onlineTime)) {
            this.binding.f399345m.setVisibility(4);
            return;
        }
        this.binding.f399345m.setText(onlineTime);
        if (this.binding.f399345m.getVisibility() != 0) {
            this.binding.f399345m.setVisibility(0);
        }
    }

    private final void n(String iconUrl) {
        if (TextUtils.isEmpty(iconUrl)) {
            return;
        }
        this.binding.f399336d.setImageDrawable(URLDrawable.getDrawable(iconUrl, URLDrawable.URLDrawableOptions.obtain()));
    }

    private final void p() {
        String str;
        am amVar = this.vm;
        LifecycleOwner lifecycleOwner = null;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar = null;
        }
        ZootopiaMapSimpleInfo mapItemInfo = amVar.getMapItemInfo();
        if (mapItemInfo == null || (str = mapItemInfo.getName()) == null) {
            am amVar2 = this.vm;
            if (amVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                amVar2 = null;
            }
            ZootopiaMapDetail value = amVar2.R1().getValue();
            if (value != null) {
                str = value.getTitle();
            } else {
                str = "";
            }
        }
        ZootopiaDetailImageGallery zootopiaDetailImageGallery = this.binding.f399350r;
        am amVar3 = this.vm;
        if (amVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar3 = null;
        }
        zootopiaDetailImageGallery.C(amVar3.T1(), str);
        this.binding.f399350r.H(this.source);
        am amVar4 = this.vm;
        if (amVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar4 = null;
        }
        ZootopiaMapSimpleInfo mapItemInfo2 = amVar4.getMapItemInfo();
        if (mapItemInfo2 != null) {
            j(ZootopiaMapDetail.INSTANCE.a(mapItemInfo2));
        }
        am amVar5 = this.vm;
        if (amVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar5 = null;
        }
        MutableLiveData<ZootopiaMapDetail> R1 = amVar5.R1();
        LifecycleOwner lifecycleOwner2 = this.owner;
        if (lifecycleOwner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
            lifecycleOwner2 = null;
        }
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailHeaderView.q(ZootopiaDetailHeaderView.this, (ZootopiaMapDetail) obj);
            }
        });
        am amVar6 = this.vm;
        if (amVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar6 = null;
        }
        LiveData<String> W1 = amVar6.W1();
        LifecycleOwner lifecycleOwner3 = this.owner;
        if (lifecycleOwner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
            lifecycleOwner3 = null;
        }
        W1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailHeaderView.r(ZootopiaDetailHeaderView.this, (String) obj);
            }
        });
        am amVar7 = this.vm;
        if (amVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar7 = null;
        }
        LiveData<String> X1 = amVar7.X1();
        LifecycleOwner lifecycleOwner4 = this.owner;
        if (lifecycleOwner4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
            lifecycleOwner4 = null;
        }
        X1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailHeaderView.s(ZootopiaDetailHeaderView.this, (String) obj);
            }
        });
        am amVar8 = this.vm;
        if (amVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar8 = null;
        }
        LiveData<String> Z1 = amVar8.Z1();
        LifecycleOwner lifecycleOwner5 = this.owner;
        if (lifecycleOwner5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("owner");
        } else {
            lifecycleOwner = lifecycleOwner5;
        }
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailHeaderView.t(ZootopiaDetailHeaderView.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ZootopiaDetailHeaderView this$0, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaMapDetail == null) {
            return;
        }
        this$0.binding.f399350r.C(zootopiaMapDetail.getId(), zootopiaMapDetail.getTitle());
        this$0.j(zootopiaMapDetail);
        if (zootopiaMapDetail.getFromSimpleData()) {
            return;
        }
        this$0.binding.f399352t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ZootopiaDetailHeaderView this$0, String it) {
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
        if (this$0.z(it)) {
            this$0.binding.f399337e.setVisibility(8);
        } else {
            this$0.l(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZootopiaDetailHeaderView this$0, String it) {
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
        this$0.m(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZootopiaDetailHeaderView this$0, String it) {
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
        if (this$0.z(it)) {
            return;
        }
        this$0.u(it);
    }

    private final void u(String visitorsCount) {
        this.binding.f399348p.setText(visitorsCount);
        if (this.binding.f399348p.getVisibility() != 0) {
            this.binding.f399348p.setVisibility(0);
        }
    }

    private final TextView v(String label) {
        TextView textView = new TextView(getContext());
        textView.setText(label);
        com.tencent.sqshow.zootopia.utils.i.i(textView, 12.0f);
        textView.setPadding(com.tencent.sqshow.zootopia.utils.i.b(8), com.tencent.sqshow.zootopia.utils.i.b(2), com.tencent.sqshow.zootopia.utils.i.b(8), com.tencent.sqshow.zootopia.utils.i.b(2));
        textView.setTextColor(-1);
        textView.setGravity(17);
        com.tencent.mobileqq.zootopia.utils.l.a(textView, com.tencent.sqshow.zootopia.utils.i.b(10), com.tencent.sqshow.zootopia.utils.q.a(R.color.f85479));
        return textView;
    }

    private final void x(LifecycleOwner owner, am vm5, ButtonStatus buttonStatus, Float progress) {
        this.vm = vm5;
        this.owner = owner;
        p();
        if (progress != null) {
            this.binding.f399334b.setProcess(progress.floatValue());
        }
        this.binding.f399334b.setStatus(buttonStatus);
        this.binding.f399343k.g(false);
    }

    private final boolean z(String desc) {
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

    public final void A(int distance) {
        if (this.initBgImageHeight <= 0) {
            this.initBgImageHeight = this.binding.f399335c.getHeight();
        }
        ZootopiaPlayerView zootopiaPlayerView = this.binding.f399335c;
        ViewGroup.LayoutParams layoutParams = zootopiaPlayerView.getLayoutParams();
        layoutParams.height = this.initBgImageHeight + distance;
        zootopiaPlayerView.setLayoutParams(layoutParams);
    }

    /* renamed from: w, reason: from getter */
    public final ZootopiaDownloadButton getBtnEnter() {
        return this.btnEnter;
    }

    public final boolean y() {
        return this.binding.f399334b.getGlobalVisibleRect(new Rect());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaDetailHeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void o(ZootopiaVersionUpdateInfo versionUpdate) {
        if (versionUpdate != null && versionUpdate.getUploadTime() != 0) {
            if (this.binding.f399354v.getVisibility() != 0) {
                this.binding.f399355w.setVisibility(0);
                this.binding.f399354v.setVisibility(0);
                this.binding.f399353u.setVisibility(0);
            }
            this.binding.f399355w.a(versionUpdate.getUserData());
            this.binding.f399353u.h(versionUpdate.c(), versionUpdate.getUploadTime());
            return;
        }
        this.binding.f399355w.setVisibility(8);
        this.binding.f399354v.setVisibility(8);
        this.binding.f399353u.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        fi3.r f16 = fi3.r.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        ZootopiaDownloadButton zootopiaDownloadButton = f16.f399334b;
        Intrinsics.checkNotNullExpressionValue(zootopiaDownloadButton, "binding.btnEnter");
        this.btnEnter = zootopiaDownloadButton;
        setOrientation(1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailHeaderView(Context context, LifecycleOwner owner, am vm5, ButtonStatus buttonStatus, Float f16, ZootopiaSource source) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        x(owner, vm5, buttonStatus, f16);
    }
}

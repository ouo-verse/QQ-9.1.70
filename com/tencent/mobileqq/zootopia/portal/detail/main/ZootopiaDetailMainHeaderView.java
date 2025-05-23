package com.tencent.mobileqq.zootopia.portal.detail.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.detail.am;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailImageGallery;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaVersionUpdateInfo;
import fi3.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0014\u00a2\u0006\u0004\b0\u00101B;\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b0\u00102J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0002J\u000e\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainHeaderView;", "Landroid/widget/RelativeLayout;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "", "progress", "", "i", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/portal/detail/am;Lcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;)V", "g", "Lcom/tencent/sqshow/zootopia/data/m;", "map", "e", "", "desc", "c", "", "galleryType", "", "imageList", "d", "Lcom/tencent/sqshow/zootopia/data/ab;", "versionUpdate", "f", "Lcom/tencent/sqshow/zootopia/data/l;", "comments", "b", "", "hasWaveBg", "j", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lfi3/x;", tl.h.F, "Lfi3/x;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/portal/detail/am;Lcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailMainHeaderView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private am vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner owner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final x binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailMainHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(List<ZootopiaMapComment> comments) {
        if (comments.isEmpty()) {
            this.binding.f399428c.setVisibility(8);
        } else {
            this.binding.f399428c.setVisibility(0);
        }
    }

    private final void c(String desc) {
        this.binding.f399427b.setText(desc);
    }

    private final void d(int galleryType, List<String> imageList) {
        if (imageList.isEmpty()) {
            this.binding.f399429d.setVisibility(8);
            this.binding.f399430e.setVisibility(8);
            return;
        }
        if (this.binding.f399430e.getVisibility() != 0) {
            this.binding.f399429d.setVisibility(0);
            this.binding.f399430e.setVisibility(0);
        }
        this.binding.f399429d.L(galleryType);
        this.binding.f399429d.K(imageList);
    }

    private final void e(ZootopiaMapDetail map) {
        c(map.getDescDetail());
        d(map.getGalleryType(), map.o());
        f(map.getVersionUpdate());
        b(map.g());
    }

    private final void g() {
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
        ZootopiaDetailImageGallery zootopiaDetailImageGallery = this.binding.f399429d;
        am amVar3 = this.vm;
        if (amVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar3 = null;
        }
        zootopiaDetailImageGallery.C(amVar3.T1(), str);
        this.binding.f399429d.H(this.source);
        am amVar4 = this.vm;
        if (amVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            amVar4 = null;
        }
        ZootopiaMapSimpleInfo mapItemInfo2 = amVar4.getMapItemInfo();
        if (mapItemInfo2 != null) {
            e(ZootopiaMapDetail.INSTANCE.a(mapItemInfo2));
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
        } else {
            lifecycleOwner = lifecycleOwner2;
        }
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.main.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailMainHeaderView.h(ZootopiaDetailMainHeaderView.this, (ZootopiaMapDetail) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZootopiaDetailMainHeaderView this$0, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaMapDetail == null) {
            return;
        }
        this$0.binding.f399429d.C(zootopiaMapDetail.getId(), zootopiaMapDetail.getTitle());
        this$0.e(zootopiaMapDetail);
    }

    private final void i(LifecycleOwner owner, am vm5, ButtonStatus buttonStatus, Float progress) {
        this.vm = vm5;
        this.owner = owner;
        g();
    }

    public final void j(boolean hasWaveBg) {
        this.binding.f399427b.g(hasWaveBg);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailMainHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaDetailMainHeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void f(ZootopiaVersionUpdateInfo versionUpdate) {
        if (versionUpdate != null && versionUpdate.getUploadTime() != 0) {
            if (this.binding.f399432g.getVisibility() != 0) {
                this.binding.f399433h.setVisibility(0);
                this.binding.f399432g.setVisibility(0);
                this.binding.f399431f.setVisibility(0);
            }
            this.binding.f399433h.a(versionUpdate.getUserData());
            this.binding.f399431f.h(versionUpdate.c(), versionUpdate.getUploadTime());
            return;
        }
        this.binding.f399433h.setVisibility(8);
        this.binding.f399432g.setVisibility(8);
        this.binding.f399431f.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailMainHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        x f16 = x.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailMainHeaderView(Context context, LifecycleOwner owner, am vm5, ButtonStatus buttonStatus, Float f16, ZootopiaSource source) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        i(owner, vm5, buttonStatus, f16);
    }
}

package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J#\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\t*\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\nJ \u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0002R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/location/ui/HeadSetView;", "Landroid/widget/LinearLayout;", "", "e", "b", "a", "g", "f", "Landroid/view/View;", "T", "", "id", "c", "(I)Landroid/view/View;", "d", tl.h.F, "Lcom/tencent/mobileqq/location/ui/k;", "controller", "Lcom/tencent/mobileqq/location/data/LocationRoom$b;", "roomKey", "", "fromPlusPanel", "setLocationController", "i", "Landroid/view/View;", "rootLayoutView", "Lcom/tencent/widget/HorizontalListView;", "Lcom/tencent/widget/HorizontalListView;", "listViewHeadSet", "Lcom/tencent/mobileqq/location/ui/headset/a;", "Lcom/tencent/mobileqq/location/ui/headset/a;", "headAdapter", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "cancelShare", "minShare", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "textSharingCount", "Lcom/tencent/mobileqq/location/ui/HeadSetViewModule;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/location/ui/HeadSetViewModule;", "headSetViewModule", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-location-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class HeadSetView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public HeadSetViewModule headSetViewModule;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View rootLayoutView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HorizontalListView listViewHeadSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.location.ui.headset.a headAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView cancelShare;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView minShare;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textSharingCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadSetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    private final void a() {
        int statusBarHeight;
        if (getContext() instanceof Activity) {
            ILiuHaiUtilsApi iLiuHaiUtilsApi = (ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class);
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            iLiuHaiUtilsApi.initLiuHaiProperty((Activity) context);
            View c16 = c(R.id.lxo);
            ViewGroup.LayoutParams layoutParams = c16.getLayoutParams();
            if (((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).isHasNotch()) {
                statusBarHeight = ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight();
            } else {
                statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            }
            layoutParams.height = statusBarHeight;
            c16.setLayoutParams(layoutParams);
            c16.setVisibility(0);
        }
    }

    private final void b() {
        View c16 = c(R.id.root);
        boolean f16 = az.f();
        if (f16) {
            c16.setBackgroundColor(Color.parseColor("#CC000000"));
        } else if (!f16) {
            c16.setBackgroundColor(Color.parseColor("#7F000000"));
        }
    }

    private final <T extends View> T c(int id5) {
        View view = this.rootLayoutView;
        if (view != null) {
            return (T) view.findViewById(id5);
        }
        return null;
    }

    private final void e() {
        this.headSetViewModule = new HeadSetViewModule(getContext());
    }

    private final void f() {
        com.tencent.mobileqq.location.ui.headset.a aVar = new com.tencent.mobileqq.location.ui.headset.a(getContext(), this.listViewHeadSet, this);
        this.headAdapter = aVar;
        HorizontalListView horizontalListView = this.listViewHeadSet;
        if (horizontalListView != null) {
            horizontalListView.setAdapter((ListAdapter) aVar);
        }
        HeadSetViewModule headSetViewModule = this.headSetViewModule;
        if (headSetViewModule != null) {
            headSetViewModule.k(this.headAdapter);
            headSetViewModule.m(this.textSharingCount);
        }
    }

    private final void g() {
        this.rootLayoutView = View.inflate(getContext(), R.layout.c8r, this);
        this.listViewHeadSet = (HorizontalListView) c(R.id.yjx);
        ImageView imageView = (ImageView) c(R.id.lc6);
        this.cancelShare = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this.headSetViewModule);
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Drawable drawable = imageView.getContext().getResources().getDrawable(R.drawable.qq_loc_cancel_share);
            Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026able.qq_loc_cancel_share)");
            imageView.setImageDrawable(a.a(context, drawable));
        }
        MapUtils.i(this.cancelShare, "\u9000\u51fa\u4f4d\u7f6e\u5171\u4eab");
        ImageView imageView2 = (ImageView) c(R.id.lsl);
        this.minShare = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.headSetViewModule);
            Context context2 = imageView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Drawable drawable2 = imageView2.getContext().getResources().getDrawable(R.drawable.qq_loc_min_share);
            Intrinsics.checkNotNullExpressionValue(drawable2, "context.resources.getDra\u2026rawable.qq_loc_min_share)");
            imageView2.setImageDrawable(a.a(context2, drawable2));
        }
        MapUtils.i(this.minShare, "\u6700\u5c0f\u5316\u4f4d\u7f6e\u5171\u4eab");
        this.textSharingCount = (TextView) c(R.id.f166973ma3);
        f();
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        e();
        g();
        a();
        b();
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        float width = c(R.id.f166072ec3).getWidth() - al.a(getContext(), 40.0f);
        float a16 = al.a(getContext(), 48.0f);
        double floor = Math.floor(width / a16);
        if (QLog.isColorLevel()) {
            QLog.d("HeadSetView", 2, "maxShownAvatarCount: invoked. ", " floor: " + floor + " avatarWidth: " + a16 + " listViewContainerWidth: " + width);
        }
        if (floor > 4.0d) {
            return 4;
        }
        return (int) floor;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.location.ui.headset.a aVar = this.headAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final void setLocationController(@Nullable k controller, @NotNull LocationRoom.b roomKey, boolean fromPlusPanel) {
        List<String> mutableListOf;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, controller, roomKey, Boolean.valueOf(fromPlusPanel));
            return;
        }
        Intrinsics.checkNotNullParameter(roomKey, "roomKey");
        com.tencent.mobileqq.location.ui.headset.a aVar = this.headAdapter;
        if (aVar != null) {
            aVar.e(controller);
        }
        HeadSetViewModule headSetViewModule = this.headSetViewModule;
        if (headSetViewModule != null) {
            headSetViewModule.l(roomKey);
        }
        if (!LocationShareLocationManager.h().f241318a.n(roomKey)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
            com.tencent.mobileqq.location.ui.headset.a aVar2 = this.headAdapter;
            if (aVar2 != null) {
                aVar2.c(mutableListOf);
            }
            if (fromPlusPanel && !com.tencent.mobileqq.location.util.b.d(roomKey.b(), roomKey.c())) {
                z16 = true;
            }
            TextView textView = this.textSharingCount;
            if (textView != null) {
                if (z16) {
                    str = "\u6b63\u5728\u53d1\u8d77...";
                } else {
                    str = "\u6b63\u5728\u52a0\u5165...";
                }
                textView.setText(str);
            }
        }
    }
}

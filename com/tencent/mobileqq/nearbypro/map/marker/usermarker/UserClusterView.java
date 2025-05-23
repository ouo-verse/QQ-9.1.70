package com.tencent.mobileqq.nearbypro.map.marker.usermarker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb2.d;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.f;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feedscheck.FeedCheckFragment;
import com.tencent.mobileqq.nearbypro.map.marker.usermarker.UserClusterView;
import com.tencent.mobileqq.nearbypro.part.a;
import com.tencent.mobileqq.nearbypro.utils.p;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.nearbypro.utils.t;
import com.tencent.mobileqq.nearbypro.utils.u;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import gb2.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b#\u0010$B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b#\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/marker/usermarker/UserClusterView;", "Landroid/widget/FrameLayout;", "Lbb2/d;", "Lgb2/c;", "", "c", "", "nick", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isSelf", "o", "k", "l", "url", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR, "clickedData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/view/MotionEvent;", "clickEvent", "j", "b", "markerItemData", DomainData.DOMAIN_NAME, h.F, "d", "Lgb2/c;", "curData", "e", "Lcom/tencent/mobileqq/nearbypro/part/a;", "Lxa2/h;", "f", "Lxa2/h;", "binding", "<init>", "(Lcom/tencent/mobileqq/nearbypro/part/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class UserClusterView extends FrameLayout implements d<c> {

    /* renamed from: i, reason: collision with root package name */
    private static int f253466i = com.tencent.mobileqq.nearbypro.utils.d.b(54);

    /* renamed from: m, reason: collision with root package name */
    private static int f253467m = 12;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c curData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a host;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private xa2.h binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserClusterView(@NotNull a host) {
        super(host.getContext());
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        c();
    }

    private final void c() {
        u uVar = u.f253961a;
        a aVar = this.host;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        xa2.h e16 = xa2.h.e(uVar.a(aVar, context, R.layout.fnl, this, "UserClusterView"));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(\n            this.h\u2026G\n            )\n        )");
        this.binding = e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(UserClusterView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        p pVar = p.f253956a;
        xa2.h hVar = this$0.binding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        ConstraintLayout constraintLayout = hVar.f447601e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.avatarLayout");
        pVar.c(constraintLayout);
    }

    private final void k() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        xa2.h hVar = this.binding;
        xa2.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        VideoReport.setElementId(hVar.f447599c, "em_nearby_avatar_icon");
        xa2.h hVar3 = this.binding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hVar2 = hVar3;
        }
        VideoReport.reportEvent("dt_clck", hVar2.f447599c, hashMap);
    }

    private final void l() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        xa2.h hVar = this.binding;
        xa2.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        VideoReport.setPageId(hVar.getRoot(), "pg_nearby_home_map");
        xa2.h hVar3 = this.binding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar3 = null;
        }
        VideoReport.setPageParams(hVar3.getRoot(), new PageParams(hashMap));
        xa2.h hVar4 = this.binding;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar4 = null;
        }
        VideoReport.setElementId(hVar4.f447599c, "em_nearby_avatar_icon");
        xa2.h hVar5 = this.binding;
        if (hVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hVar2 = hVar5;
        }
        VideoReport.reportEvent("dt_imp", hVar2.f447599c, hashMap);
    }

    private final void m(String nick) {
        int codePointCount = nick.codePointCount(0, nick.length());
        int i3 = f253467m;
        if (codePointCount > i3) {
            String substring = nick.substring(0, nick.offsetByCodePoints(0, i3));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            nick = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        xa2.h hVar = this.binding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        hVar.f447602f.setText(nick);
    }

    private final void o(boolean isSelf) {
        xa2.h hVar = this.binding;
        xa2.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        ImageView imageView = hVar.f447604h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.selfCircleImg");
        t.a(imageView, isSelf);
        xa2.h hVar3 = this.binding;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar3 = null;
        }
        LottieAnimationView lottieAnimationView = hVar3.f447598b;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.animationView");
        t.a(lottieAnimationView, isSelf);
        if (isSelf) {
            xa2.h hVar4 = this.binding;
            if (hVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hVar4 = null;
            }
            hVar4.f447598b.setAnimationFromUrl("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/qAHWmUYg.json");
            xa2.h hVar5 = this.binding;
            if (hVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                hVar2 = hVar5;
            }
            hVar2.f447598b.playAnimation();
        }
    }

    @Override // bb2.d
    public void f(@NotNull a aVar) {
        d.a.a(this, aVar);
    }

    @Override // bb2.d
    public void h() {
        d.a.b(this);
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("UserClusterView", "locateInCenter");
        }
        xa2.h hVar = this.binding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        hVar.f447601e.post(new Runnable() { // from class: ib2.a
            @Override // java.lang.Runnable
            public final void run() {
                UserClusterView.i(UserClusterView.this);
            }
        });
    }

    @Override // bb2.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull c clickedData, @NotNull a host, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(clickedData, "clickedData");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        d.a.c(this, clickedData, host, clickEvent);
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("UserClusterView", "onMarkerClick tid:" + clickedData.getData().f448325a + " nick:" + clickedData.getData().f448327c);
        }
        if (clickedData.getData().f448325a != s.a()) {
            FeedCheckFragment.Companion companion = FeedCheckFragment.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FeedCheckFragment.Companion.b(companion, context, host, clickedData.getData(), null, null, "0", 24, null);
        }
        k();
    }

    @Override // bb2.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull c markerItemData) {
        Intrinsics.checkNotNullParameter(markerItemData, "markerItemData");
        boolean areEqual = Intrinsics.areEqual(markerItemData, this.curData);
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("UserClusterView", "updateDate equal=" + areEqual);
        }
        if (!areEqual) {
            setAvatar(markerItemData.getData().f448328d);
            String str = markerItemData.getData().f448327c;
            Intrinsics.checkNotNullExpressionValue(str, "markerItemData.data.nick");
            m(str);
            o(ab2.a.f25767a.t(markerItemData.getData()));
            this.curData = markerItemData;
            l();
        }
    }

    public final void setAvatar(@Nullable String url) {
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("UserClusterView", "setAvatar url=" + url);
        }
        Option url2 = Option.obtain().setUrl(url);
        xa2.h hVar = this.binding;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hVar = null;
        }
        Option option = url2.setTargetView(hVar.f447599c).setRequestHeight(f253466i).setRequestWidth(f253466i).setNeedFilterUrl(false).setFailDrawable(BaseImageUtil.getDefaultFaceDrawable()).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable());
        f<Option, IPicLoadStateListener, IPicLoader> f16 = j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserClusterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }

    @Override // bb2.d
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UserClusterView d() {
        return this;
    }
}

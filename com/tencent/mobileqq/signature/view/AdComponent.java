package com.tencent.mobileqq.signature.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.signature.SignTextEditFragment;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u000312\u001fB\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0017\u0010\u001c\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010&R\"\u0010-\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010&\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/signature/view/AdComponent;", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "Landroid/view/View$OnClickListener;", "", "g", "", "isClick", "f", "Landroid/content/Context;", "context", "i", "", "url", "e", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "onGetAdvs", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Ljava/lang/String;", "getAdUrl", "()Ljava/lang/String;", "adUrl", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", h.F, "(Landroid/widget/ImageView;)V", "adView", "getAdId", "setAdId", "(Ljava/lang/String;)V", "adId", "getTraceInfo", "setTraceInfo", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "getReplaceAid", "setReplaceAid", "replaceAid", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "AdView", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class AdComponent implements TianShuGetAdvCallback, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String adUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView adView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String adId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String replaceAid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/signature/view/AdComponent$AdView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SuppressLint({"AppCompatCustomView"})
    /* loaded from: classes18.dex */
    public static final class AdView extends ImageView {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdView(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
                return;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0) {
                return;
            }
            setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredWidth() * (drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth())));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/signature/view/AdComponent$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "aid", "b", "e", "banner", "c", "f", QCircleLpReportDc05494.KEY_PLACE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String aid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String banner;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String place;

        public a() {
            this(null, null, null, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return;
            }
            iPatchRedirector.redirect((short) 16, (Object) this);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.aid;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.banner;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.place;
        }

        public final void d(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.aid = str;
            }
        }

        public final void e(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.banner = str;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.aid, aVar.aid) && Intrinsics.areEqual(this.banner, aVar.banner) && Intrinsics.areEqual(this.place, aVar.place)) {
                return true;
            }
            return false;
        }

        public final void f(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.place = str;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return (((this.aid.hashCode() * 31) + this.banner.hashCode()) * 31) + this.place.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "AdInfo(aid=" + this.aid + ", banner=" + this.banner + ", place=" + this.place + ")";
        }

        public a(@NotNull String aid, @NotNull String banner, @NotNull String place) {
            Intrinsics.checkNotNullParameter(aid, "aid");
            Intrinsics.checkNotNullParameter(banner, "banner");
            Intrinsics.checkNotNullParameter(place, "place");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aid, banner, place);
                return;
            }
            this.aid = aid;
            this.banner = banner;
            this.place = place;
        }

        public /* synthetic */ a(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/signature/view/AdComponent$b;", "", "", "DEFAULT_BANNER", "Ljava/lang/String;", "", "PISITION_ID", "I", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.signature.view.AdComponent$b, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AdComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.adUrl = VasToggle.AVATAR_STORE_AD_URL.getStringData("https://h5.vip.qq.com/p/pay/index?openType=webview&disableTitle=1&_wv=16781315&_wwv=13&sandbox=0&debug=0&aid=${aid}&type=!svip&months=3&proxywv=true&t=1650526539460");
        this.adId = "";
        this.traceInfo = "";
        this.replaceAid = "mvip.g.a.gq_editbutton";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdComponent this$0, a info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.e(info.b());
    }

    private final void e(String url) {
        IVasApngFactory.Companion companion = IVasApngFactory.INSTANCE;
        if (companion.getENABLE_CACHE_DRAWABLE()) {
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(url).l(VasDynamicDrawableCache.INSTANCE).a();
            b().setImageDrawable(a16);
            b().setScaleType(ImageView.ScaleType.FIT_CENTER);
            a16.c0(new Function1<d, Unit>() { // from class: com.tencent.mobileqq.signature.view.AdComponent$refreshAdView$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdComponent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                    invoke2(dVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull d it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        AdComponent.this.b().requestLayout();
                    }
                }
            });
            return;
        }
        IVasApngFactory api = companion.api();
        String name = AdComponent.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AdComponent::class.java.name");
        APNGDrawable apngDrawable = api.getApngDrawable(name, url);
        b().setImageDrawable(apngDrawable);
        b().setScaleType(ImageView.ScaleType.FIT_CENTER);
        apngDrawable.setLoadedListener(new Function1<IDynamicDrawable, Unit>() { // from class: com.tencent.mobileqq.signature.view.AdComponent$refreshAdView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IDynamicDrawable iDynamicDrawable) {
                invoke2(iDynamicDrawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IDynamicDrawable it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AdComponent.this.b().requestLayout();
                }
            }
        });
    }

    private final void f(boolean isClick) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = "DressVip";
        tianShuReportData.mPageId = "3001170";
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = this.adId;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        if (isClick) {
            tianShuReportData.mActionId = 102;
        } else {
            tianShuReportData.mActionId = 101;
        }
        tianShuReportData.mPositionId = "1061";
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = this.traceInfo;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    private final void g() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1061;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, this);
    }

    private final void i(Context context) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(this.adUrl, "${aid}", this.replaceAid, false, 4, (Object) null);
        Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", replace$default);
        intent.setData(Uri.parse(replace$default));
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        context.startActivity(intent);
        f(true);
    }

    @NotNull
    public final ImageView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ImageView imageView = this.adView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adView");
        return null;
    }

    public void d(@NotNull ViewGroup rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.f236306y);
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        h(new AdView(context));
        b().setMaxHeight((int) ((ScreenUtil.getInstantScreenWidth(rootView.getContext()) - ViewUtils.dpToPx(24.0f)) * 0.14336918f));
        viewGroup.addView(b(), -1, 0);
        e("https://tianquan.gtimg.cn/uncategorized/arno/sign_tianshu_banner_def.png");
        g();
        b().setOnClickListener(this);
        AccessibilityUtil.c(b(), "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u5c0a\u4eab\u4f53\u9a8c\uff0c\u7acb\u5373\u7eed\u8d39", Button.class.getName());
    }

    public final void h(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.adView = imageView;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            SignTextEditFragment.f288334u0 = true;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            i(context);
            com.tencent.mobileqq.signature.report.a.c().i(102);
            com.tencent.mobileqq.signature.report.a.c().h(102, this.adId);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
    public void onGetAdvs(boolean result, @Nullable TianShuAccess.GetAdsRsp getAdsRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(result), getAdsRsp);
            return;
        }
        if (getAdsRsp == null) {
            QLog.w(QPublicBaseFragment.TAG, 1, "rsp null");
            return;
        }
        TianShuAccess.AdItem adItem = getAdsRsp.mapAds.get().get(0).value.lst.get(0);
        final a aVar = new a(null, null, null, 7, null);
        List<TianShuAccess.MapEntry> argMap = adItem.argList.get();
        Intrinsics.checkNotNullExpressionValue(argMap, "argMap");
        int i3 = 0;
        for (Object obj : argMap) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TianShuAccess.MapEntry mapEntry = (TianShuAccess.MapEntry) obj;
            String str = mapEntry.key.get();
            String value = mapEntry.value.get();
            if (QLog.isColorLevel()) {
                QLog.w(QPublicBaseFragment.TAG, 1, "argList[" + i3 + "] : " + str + " " + value);
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1396342996) {
                    if (hashCode != 96572) {
                        if (hashCode == 106748167 && str.equals(QCircleLpReportDc05494.KEY_PLACE)) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            aVar.f(value);
                        }
                    } else if (str.equals("aid")) {
                        Intrinsics.checkNotNullExpressionValue(value, "value");
                        aVar.d(value);
                    }
                } else if (str.equals("banner")) {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    aVar.e(value);
                }
            }
            i3 = i16;
        }
        if (Intrinsics.areEqual(aVar.c(), "9")) {
            this.adId = String.valueOf(adItem.iAdId.get());
            String str2 = adItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str2, "traceinfo.get()");
            this.traceInfo = str2;
            this.replaceAid = aVar.a();
            b().post(new Runnable() { // from class: com.tencent.mobileqq.signature.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    AdComponent.c(AdComponent.this, aVar);
                }
            });
            f(false);
            com.tencent.mobileqq.signature.report.a.c().h(101, this.adId);
        }
    }
}

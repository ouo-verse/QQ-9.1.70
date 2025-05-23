package com.tencent.sqshow.zootopia.widget.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.player.PlayStatus;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.util.URLUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.libpag.PAGView;
import pu4.g;
import tc4.a;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001cB\u0011\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u00a2\u0006\u0004\b^\u0010_B\u001b\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u00a2\u0006\u0004\b^\u0010bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010$\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u001a\u0010,\u001a\u00020\t2\b\b\u0001\u0010+\u001a\u00020*2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\tH\u0016J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020*H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020*H\u0016J\u0012\u0010@\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010C\u001a\u00020\t2\u0006\u0010B\u001a\u00020AJ\u0012\u0010F\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\u000e\u0010H\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0005J\u0006\u0010I\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0005R\u0018\u0010M\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010LR\u0018\u0010O\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010PR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010SR\u0016\u0010U\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010'R\u0016\u0010V\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010WR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010XR\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010YR\u0016\u0010Z\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010XR\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010[\u00a8\u0006d"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "Landroid/widget/FrameLayout;", "Ltc4/a;", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", "f", "", "type", "", ReportConstant.COSTREPORT_PREFIX, "u", "w", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "filePath", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "Landroid/graphics/drawable/Drawable;", "k", UserInfo.SEX_FEMALE, "r", "B", "E", HippyTKDListViewAdapter.X, "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "t", "p", "y", BdhLogUtil.LogTag.Tag_Conn, "o", "i", "forceClear", "g", "J", "d", "I", "e", "H", "", "drawableResId", "b", "stop", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "value", "setRepeatCount", "j", "Lcom/tencent/sqshow/widget/pag/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/player/ZootopiaPlayerView;", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "l", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setScaleType", "dp", "setRadius", "defaultDrawable", "setDefaultDrawable", "Lcom/tencent/image/URLDrawableDownListener;", "urlDrawableDownListener", "setURLDrawableDownListener", "Lorg/libpag/PAGView$PAGViewListener;", "listener", "setPagListener", "useCache", "K", h.F, "adjustViewBounds", "setAdjustViewBounds", "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "imageView", "Lcom/tencent/sqshow/widget/pag/a;", "pagView", "Lcom/tencent/sqshow/zootopia/player/ZootopiaPlayerView;", "playerView", "Lpu4/g;", "Lorg/libpag/PAGView$PAGViewListener;", "pagListener", "radius", "state", "Landroid/widget/ImageView$ScaleType;", "Z", "Landroid/graphics/drawable/Drawable;", "useImageCache", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMediaView extends FrameLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private int state;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView.ScaleType scaleType;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean adjustViewBounds;

    /* renamed from: F, reason: from kotlin metadata */
    private Drawable defaultDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean useImageCache;

    /* renamed from: H, reason: from kotlin metadata */
    private URLDrawableDownListener urlDrawableDownListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.widget.pag.a pagView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaPlayerView playerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private g material;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PAGView.PAGViewListener pagListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int radius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMediaView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scaleType = ImageView.ScaleType.CENTER_CROP;
        this.defaultDrawable = q.b(R.drawable.gym);
        this.useImageCache = true;
    }

    private final void A(g material) {
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handlePlayMP4 error :: material.url is empty ");
            return;
        }
        if (this.playerView == null) {
            q(material);
        }
        ZootopiaPlayerView zootopiaPlayerView = this.playerView;
        if (zootopiaPlayerView != null) {
            ZootopiaPlayerView.z(zootopiaPlayerView, false, false, 3, null);
        }
    }

    private final void B(g material) {
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handlePlayPAG error :: material.url is empty ");
            return;
        }
        if (this.pagView == null) {
            r(material);
        }
        com.tencent.sqshow.widget.pag.a aVar = this.pagView;
        if (aVar != null) {
            aVar.a(material, this.pagListener);
        }
    }

    private final void C() {
        String str;
        ZootopiaPlayerView zootopiaPlayerView;
        g gVar = this.material;
        if (gVar == null || (str = gVar.f427434a) == null || (zootopiaPlayerView = this.playerView) == null) {
            return;
        }
        zootopiaPlayerView.A(str);
    }

    private final void D() {
        ZootopiaPlayerView zootopiaPlayerView = this.playerView;
        if (zootopiaPlayerView != null) {
            zootopiaPlayerView.B();
        }
    }

    private final void E() {
        com.tencent.sqshow.widget.pag.a aVar = this.pagView;
        if (aVar != null) {
            aVar.stop();
        }
    }

    private final void F() {
        if (this.pagView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZPlanPAGView zPlanPAGView = new ZPlanPAGView(context);
            zPlanPAGView.setRadius(this.radius);
            this.pagView = zPlanPAGView;
            addView(zPlanPAGView);
        }
    }

    private final void G() {
        if (this.playerView == null) {
            ZootopiaPlayerView zootopiaPlayerView = new ZootopiaPlayerView(getContext(), null, 0, 6, null);
            zootopiaPlayerView.setMediaLoadingDrawable(this.defaultDrawable);
            zootopiaPlayerView.setScaleType(this.scaleType);
            zootopiaPlayerView.setAdjustViewBounds(this.adjustViewBounds);
            this.playerView = zootopiaPlayerView;
            addView(zootopiaPlayerView);
        }
        ZootopiaPlayerView zootopiaPlayerView2 = this.playerView;
        if (zootopiaPlayerView2 != null) {
            zootopiaPlayerView2.setBackgroundRadius(i.b(this.radius));
        }
    }

    private final boolean f(g material) {
        if (this.state != 2 || !Intrinsics.areEqual(this.material, material)) {
            return true;
        }
        ZootopiaPlayerView zootopiaPlayerView = this.playerView;
        if ((zootopiaPlayerView != null ? zootopiaPlayerView.o() : null) != PlayStatus.PLAY_STATUS_PLAYING) {
            return true;
        }
        ZootopiaPlayerView zootopiaPlayerView2 = this.playerView;
        return !Intrinsics.areEqual(zootopiaPlayerView2 != null ? zootopiaPlayerView2.p() : null, material.f427434a);
    }

    private final void g(boolean forceClear) {
        g gVar = this.material;
        if (gVar != null) {
            if (forceClear || !(Intrinsics.areEqual(gVar.f427435b, "png") || Intrinsics.areEqual(gVar.f427435b, "gif") || Intrinsics.areEqual(gVar.f427435b, "jpg"))) {
                removeAllViews();
                this.pagView = null;
                this.playerView = null;
                QLog.i("ZPlanMediaView", 4, "clear :: url == " + gVar.f427434a);
            }
        }
    }

    private final void i(g material) {
        boolean endsWith$default;
        boolean endsWith$default2;
        boolean endsWith$default3;
        boolean endsWith$default4;
        boolean endsWith$default5;
        boolean endsWith$default6;
        boolean endsWith$default7;
        String str = material.f427435b;
        if (str == null || str.length() == 0) {
            QLog.e("ZPlanMediaView", 1, "found a invalid material , url is " + material.f427434a);
            String str2 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str2, "material.url");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, ".png", false, 2, null);
            if (endsWith$default) {
                material.f427435b = "png";
                return;
            }
            String str3 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str3, "material.url");
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str3, ".jpg", false, 2, null);
            if (endsWith$default2) {
                material.f427435b = "jpg";
                return;
            }
            String str4 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str4, "material.url");
            endsWith$default3 = StringsKt__StringsJVMKt.endsWith$default(str4, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
            if (endsWith$default3) {
                material.f427435b = "gif";
                return;
            }
            String str5 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str5, "material.url");
            endsWith$default4 = StringsKt__StringsJVMKt.endsWith$default(str5, ".pag", false, 2, null);
            if (endsWith$default4) {
                material.f427435b = "pag";
                return;
            }
            String str6 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str6, "material.url");
            endsWith$default5 = StringsKt__StringsJVMKt.endsWith$default(str6, ".apng", false, 2, null);
            if (endsWith$default5) {
                material.f427435b = "apng";
                return;
            }
            String str7 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str7, "material.url");
            endsWith$default6 = StringsKt__StringsJVMKt.endsWith$default(str7, ".mp4", false, 2, null);
            if (endsWith$default6) {
                material.f427435b = "mp4";
                return;
            }
            String str8 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str8, "material.url");
            endsWith$default7 = StringsKt__StringsJVMKt.endsWith$default(str8, ".mov", false, 2, null);
            if (endsWith$default7) {
                material.f427435b = FileUtils.FILE_TYPE_MOV;
            } else {
                material.f427435b = "png";
            }
        }
    }

    private final Drawable k(String filePath, URLDrawable.URLDrawableOptions options) {
        if (!this.useImageCache) {
            URLDrawable.removeMemoryCacheByUrl(filePath, options);
        }
        return URLDrawable.getFileDrawable(filePath, options);
    }

    private final void o(g material) {
        String str = material.f427436c;
        if (str != null) {
            G();
            ZootopiaPlayerView zootopiaPlayerView = this.playerView;
            if (zootopiaPlayerView != null) {
                zootopiaPlayerView.l();
            }
            ZootopiaPlayerView zootopiaPlayerView2 = this.playerView;
            if (zootopiaPlayerView2 != null) {
                ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView2, str, 0, 0, null, 14, null);
            }
        }
    }

    private final void p(g material) {
        ZootopiaPlayerView zootopiaPlayerView;
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handleAddAPNGView error :: material.url is empty ");
            return;
        }
        G();
        if (!TextUtils.isEmpty(material.f427436c) && (zootopiaPlayerView = this.playerView) != null) {
            ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView, material.f427436c, 0, 0, null, 14, null);
        }
        ZootopiaPlayerView zootopiaPlayerView2 = this.playerView;
        if (zootopiaPlayerView2 != null) {
            zootopiaPlayerView2.setBackgroundRadius(i.b(this.radius));
        }
        ZootopiaPlayerView zootopiaPlayerView3 = this.playerView;
        if (zootopiaPlayerView3 != null) {
            ZootopiaPlayerView.setApngBackgroundUrl$default(zootopiaPlayerView3, material.f427434a, 0, 0, true, null, 16, null);
        }
    }

    private final void q(g material) {
        ZootopiaPlayerView zootopiaPlayerView;
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handleAddMP4View error :: material.url is empty ");
            return;
        }
        G();
        g gVar = this.material;
        if (!Intrinsics.areEqual(gVar != null ? gVar.f427436c : null, material.f427436c) && (zootopiaPlayerView = this.playerView) != null) {
            ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView, material.f427436c, 0, 0, null, 14, null);
        }
        ZootopiaPlayerView zootopiaPlayerView2 = this.playerView;
        if (zootopiaPlayerView2 != null) {
            zootopiaPlayerView2.setBackgroundRadius(i.b(this.radius));
        }
        ZootopiaPlayerView zootopiaPlayerView3 = this.playerView;
        if (zootopiaPlayerView3 != null) {
            zootopiaPlayerView3.setVideoUrl(material.f427434a);
        }
    }

    private final void r(g material) {
        com.tencent.sqshow.widget.pag.a aVar;
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handleAddPAGView error :: material.url is empty ");
            return;
        }
        F();
        Drawable drawable = this.defaultDrawable;
        if (drawable == null || (aVar = this.pagView) == null) {
            return;
        }
        aVar.setLoadingDrawable(drawable);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    private final void s(String type, g material) {
        switch (type.hashCode()) {
            case 102340:
                if (type.equals("gif")) {
                    z(material);
                    return;
                }
                return;
            case 105441:
                if (!type.equals("jpg")) {
                    return;
                }
                z(material);
                return;
            case 108273:
                if (!type.equals("mp4")) {
                    return;
                }
                q(material);
                return;
            case 108308:
                if (!type.equals(FileUtils.FILE_TYPE_MOV)) {
                    return;
                }
                q(material);
                return;
            case 110742:
                if (type.equals("pag")) {
                    r(material);
                    return;
                }
                return;
            case 111145:
                if (!type.equals("png")) {
                    return;
                }
                z(material);
                return;
            case 3000872:
                if (type.equals("apng")) {
                    p(material);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void t(g material) {
        String str = material.f427436c;
        if (str != null) {
            G();
            ZootopiaPlayerView zootopiaPlayerView = this.playerView;
            if (zootopiaPlayerView != null) {
                ZootopiaPlayerView.setCoverUrl$default(zootopiaPlayerView, str, 0, 0, null, 14, null);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    private final void u(String type, g material) {
        switch (type.hashCode()) {
            case 102340:
                if (type.equals("gif")) {
                    z(material);
                    return;
                }
                return;
            case 105441:
                if (!type.equals("jpg")) {
                    return;
                }
                z(material);
                return;
            case 108273:
                if (!type.equals("mp4")) {
                    return;
                }
                A(material);
                return;
            case 108308:
                if (!type.equals(FileUtils.FILE_TYPE_MOV)) {
                    return;
                }
                A(material);
                return;
            case 110742:
                if (type.equals("pag")) {
                    B(material);
                    return;
                }
                return;
            case 111145:
                if (!type.equals("png")) {
                    return;
                }
                z(material);
                return;
            case 3000872:
                if (type.equals("apng")) {
                    y(material);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0016. Please report as an issue. */
    private final void v(g material) {
        String str = material.f427435b;
        Intrinsics.checkNotNullExpressionValue(str, "material.type");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case 102340:
                if (lowerCase.equals("gif")) {
                    z(material);
                    return;
                }
                return;
            case 105441:
                if (!lowerCase.equals("jpg")) {
                    return;
                }
                z(material);
                return;
            case 108273:
                if (!lowerCase.equals("mp4")) {
                    return;
                }
                t(material);
                return;
            case 108308:
                if (!lowerCase.equals(FileUtils.FILE_TYPE_MOV)) {
                    return;
                }
                t(material);
                return;
            case 110742:
                if (lowerCase.equals("pag")) {
                    x(material);
                    return;
                }
                return;
            case 111145:
                if (!lowerCase.equals("png")) {
                    return;
                }
                z(material);
                return;
            case 3000872:
                if (lowerCase.equals("apng")) {
                    o(material);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void w() {
        g gVar = this.material;
        if (gVar == null) {
            QLog.e("ZPlanMediaView", 1, "handleMediaStop error :: material is null , please do play first");
            return;
        }
        String str = gVar != null ? gVar.f427435b : null;
        if (str != null) {
            switch (str.hashCode()) {
                case 108273:
                    if (!str.equals("mp4")) {
                        return;
                    }
                    break;
                case 108308:
                    if (!str.equals(FileUtils.FILE_TYPE_MOV)) {
                        return;
                    }
                    break;
                case 110742:
                    if (str.equals("pag")) {
                        E();
                        return;
                    }
                    return;
                case 3000872:
                    if (str.equals("apng")) {
                        C();
                        return;
                    }
                    return;
                default:
                    return;
            }
            D();
        }
    }

    private final void x(g material) {
        F();
        com.tencent.sqshow.widget.pag.a aVar = this.pagView;
        if (aVar != null) {
            aVar.c(material);
        }
    }

    private final void y(g material) {
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handleAddAPNGView error :: material.url is empty ");
            return;
        }
        if (this.playerView == null) {
            p(material);
        }
        ApngImage.playByTag(material.f427434a.hashCode());
    }

    private final void z(g material) {
        if (this.imageView == null) {
            RoundCornerImageView roundCornerImageView = new RoundCornerImageView(getContext());
            roundCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            roundCornerImageView.setScaleType(this.scaleType);
            int i3 = this.radius;
            if (i3 > 0) {
                roundCornerImageView.setCorner(i.b(i3));
            }
            this.imageView = roundCornerImageView;
        }
        if (getChildCount() == 0) {
            addView(this.imageView);
        }
        Drawable drawable = this.defaultDrawable;
        if (drawable == null) {
            drawable = b.f306350a;
        }
        if (TextUtils.isEmpty(material.f427434a)) {
            QLog.e("ZPlanMediaView", 1, "handlePlayPNG error :: material.url is empty ");
            RoundCornerImageView roundCornerImageView2 = this.imageView;
            if (roundCornerImageView2 != null) {
                roundCornerImageView2.setImageDrawable(drawable);
                return;
            }
            return;
        }
        g gVar = this.material;
        if (Intrinsics.areEqual(gVar != null ? gVar.f427434a : null, material.f427434a) && this.useImageCache) {
            return;
        }
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        if (!this.useImageCache) {
            option.mUseMemoryCache = false;
        }
        option.mLoadingDrawable = drawable;
        option.mFailedDrawable = drawable;
        if (Intrinsics.areEqual(material.f427435b, "gif")) {
            QLog.d("ZPlanMediaView", 1, "handlePlayPNG :: set gif mode");
            option.mPlayGifImage = true;
        }
        if (URLUtil.isValidUrl(material.f427434a)) {
            RoundCornerImageView roundCornerImageView3 = this.imageView;
            if (roundCornerImageView3 != null) {
                String str = material.f427434a;
                Intrinsics.checkNotNullExpressionValue(str, "material.url");
                Intrinsics.checkNotNullExpressionValue(option, "option");
                CommonExKt.u(roundCornerImageView3, str, option, this.urlDrawableDownListener);
                return;
            }
            return;
        }
        RoundCornerImageView roundCornerImageView4 = this.imageView;
        if (roundCornerImageView4 != null) {
            String str2 = material.f427434a;
            Intrinsics.checkNotNullExpressionValue(str2, "material.url");
            Intrinsics.checkNotNullExpressionValue(option, "option");
            roundCornerImageView4.setImageDrawable(k(str2, option));
        }
    }

    public boolean H() {
        return this.state == 2;
    }

    public void I(g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        QLog.i("ZPlanMediaView", 4, "play :: type == " + material.f427435b + " url == " + material.f427434a);
        e(material);
    }

    public void J(g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        QLog.i("ZPlanMediaView", 4, "prepare :: type == " + material.f427435b + " url == " + material.f427434a);
        if (this.state == 1 && Intrinsics.areEqual(this.material, material)) {
            QLog.i("ZPlanMediaView", 4, "state is prepare already :: url == " + material.f427434a);
            return;
        }
        g(!Intrinsics.areEqual(this.material != null ? r0.f427435b : null, material.f427435b));
        v(material);
        this.material = material;
        this.state = 1;
    }

    public final void K(boolean useCache) {
        this.useImageCache = useCache;
    }

    @Override // tc4.a
    public void b(int drawableResId, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        g gVar = new g();
        gVar.f427435b = type;
        try {
            setDefaultDrawable(ContextCompat.getDrawable(getContext(), drawableResId));
        } catch (Resources.NotFoundException unused) {
        }
        e(gVar);
    }

    public void d(g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        QLog.i("ZPlanMediaView", 4, "addView :: type == " + material.f427435b + " url == " + material.f427434a);
        if (!f(material)) {
            QLog.i("ZPlanMediaView", 4, "state is playing already :: url == " + material.f427434a);
            return;
        }
        i(material);
        g gVar = this.material;
        if (!Intrinsics.areEqual(gVar != null ? gVar.f427435b : null, material.f427435b)) {
            g(true);
        }
        String str = material.f427435b;
        Intrinsics.checkNotNullExpressionValue(str, "material.type");
        s(str, material);
    }

    public void e(g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (!f(material)) {
            QLog.i("ZPlanMediaView", 4, "state is playing already :: url == " + material.f427434a);
            return;
        }
        i(material);
        g gVar = this.material;
        if (!Intrinsics.areEqual(gVar != null ? gVar.f427435b : null, material.f427435b)) {
            g(true);
        }
        String str = material.f427435b;
        Intrinsics.checkNotNullExpressionValue(str, "material.type");
        u(str, material);
        this.material = material;
        this.state = 2;
    }

    public final void h() {
        RoundCornerImageView roundCornerImageView = this.imageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setFilterPressEffect(true);
        }
    }

    /* renamed from: j, reason: from getter */
    public g getMaterial() {
        return this.material;
    }

    public RoundCornerImageView l() {
        g gVar = this.material;
        if (!Intrinsics.areEqual(gVar != null ? gVar.f427435b : null, "png")) {
            g gVar2 = this.material;
            if (!Intrinsics.areEqual(gVar2 != null ? gVar2.f427435b : null, "jpg")) {
                g gVar3 = this.material;
                if (!Intrinsics.areEqual(gVar3 != null ? gVar3.f427435b : null, "gif")) {
                    return null;
                }
            }
        }
        return this.imageView;
    }

    public com.tencent.sqshow.widget.pag.a m() {
        g gVar = this.material;
        if (Intrinsics.areEqual(gVar != null ? gVar.f427435b : null, "pag")) {
            return this.pagView;
        }
        return null;
    }

    public ZootopiaPlayerView n() {
        g gVar = this.material;
        String str = gVar != null ? gVar.f427435b : null;
        if (Intrinsics.areEqual(str, "mp4") ? true : Intrinsics.areEqual(str, FileUtils.FILE_TYPE_MOV)) {
            return this.playerView;
        }
        return null;
    }

    public final void setAdjustViewBounds(boolean adjustViewBounds) {
        RoundCornerImageView roundCornerImageView = this.imageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setAdjustViewBounds(adjustViewBounds);
        }
        this.adjustViewBounds = adjustViewBounds;
    }

    public void setDefaultDrawable(Drawable defaultDrawable) {
        this.defaultDrawable = defaultDrawable;
        ZootopiaPlayerView zootopiaPlayerView = this.playerView;
        if (zootopiaPlayerView != null) {
            zootopiaPlayerView.setMediaLoadingDrawable(defaultDrawable);
        }
    }

    public void setPagListener(PAGView.PAGViewListener listener) {
        this.pagListener = listener;
    }

    public void setProgress(double progress) {
        g gVar = this.material;
        QLog.i("ZPlanMediaView", 4, "setProgress-" + progress + " type == " + (gVar != null ? gVar.f427435b : null) + " url == " + (gVar != null ? gVar.f427434a : null));
        com.tencent.sqshow.widget.pag.a m3 = m();
        if (m3 != null) {
            m3.setProgress(progress);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // u74.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setRadius(int dp5) {
        RoundCornerImageView roundCornerImageView;
        ZootopiaPlayerView zootopiaPlayerView;
        com.tencent.sqshow.widget.pag.a aVar;
        RoundCornerImageView roundCornerImageView2;
        ZootopiaPlayerView zootopiaPlayerView2;
        this.radius = dp5;
        g gVar = this.material;
        String str = gVar != null ? gVar.f427435b : null;
        if (str != null) {
            switch (str.hashCode()) {
                case 102340:
                    if (str.equals("gif") && (roundCornerImageView = this.imageView) != null) {
                        roundCornerImageView.setCorner(i.b(this.radius));
                        return;
                    }
                    return;
                case 105441:
                    if (!str.equals("jpg")) {
                        return;
                    }
                    roundCornerImageView2 = this.imageView;
                    if (roundCornerImageView2 == null) {
                        roundCornerImageView2.setCorner(i.b(this.radius));
                        return;
                    }
                    return;
                case 108273:
                    if (!str.equals("mp4")) {
                        return;
                    }
                    zootopiaPlayerView = this.playerView;
                    if (zootopiaPlayerView == null) {
                        zootopiaPlayerView.setBackgroundRadius(i.b(this.radius));
                        return;
                    }
                    return;
                case 108308:
                    if (!str.equals(FileUtils.FILE_TYPE_MOV)) {
                        return;
                    }
                    zootopiaPlayerView = this.playerView;
                    if (zootopiaPlayerView == null) {
                    }
                    break;
                case 110742:
                    if (str.equals("pag") && (aVar = this.pagView) != null) {
                        aVar.setRadius(i.b(this.radius));
                        return;
                    }
                    return;
                case 111145:
                    if (!str.equals("png")) {
                        return;
                    }
                    roundCornerImageView2 = this.imageView;
                    if (roundCornerImageView2 == null) {
                    }
                    break;
                case 3000872:
                    if (str.equals("apng") && (zootopiaPlayerView2 = this.playerView) != null) {
                        zootopiaPlayerView2.setBackgroundRadius(i.b(this.radius));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setRepeatCount(int value) {
        com.tencent.sqshow.widget.pag.a m3 = m();
        if (m3 != null) {
            m3.setRepeatCount(value);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        RoundCornerImageView roundCornerImageView = this.imageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setScaleType(scaleType);
        }
        this.scaleType = scaleType;
    }

    public final void setURLDrawableDownListener(URLDrawableDownListener urlDrawableDownListener) {
        Intrinsics.checkNotNullParameter(urlDrawableDownListener, "urlDrawableDownListener");
        this.urlDrawableDownListener = urlDrawableDownListener;
    }

    public void stop() {
        g gVar = this.material;
        QLog.i("ZPlanMediaView", 4, "stop :: type == " + (gVar != null ? gVar.f427435b : null) + " url == " + (gVar != null ? gVar.f427434a : null));
        if (this.state == 0) {
            g gVar2 = this.material;
            QLog.i("ZPlanMediaView", 4, "state is stop already :: url == " + (gVar2 != null ? gVar2.f427434a : null));
            return;
        }
        w();
        this.state = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scaleType = ImageView.ScaleType.CENTER_CROP;
        this.defaultDrawable = q.b(R.drawable.gym);
        this.useImageCache = true;
    }
}

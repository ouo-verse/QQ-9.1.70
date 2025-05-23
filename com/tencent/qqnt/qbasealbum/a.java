package com.tencent.qqnt.qbasealbum;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.album.api.IAlbumApi;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerTabFragment;
import com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart;
import com.tencent.qqnt.qbasealbum.album.view.PickerMediaViewPagerPart;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.QBaseAlbumCustomize;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006JV\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u000e2\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u00120\u000eJ<\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u00120\u000eJ\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004J4\u0010%\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\b0!J \u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\bR$\u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00068\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R*\u00107\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u00104\"\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/a;", "", "Landroid/content/Context;", "context", "", "initUrlDrawable", "Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "params", "", h.F, "Lcom/tencent/qqnt/qbasealbum/model/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "pickerInitBean", "Ljava/lang/Class;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "pickerCustomize", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "previewCustomize", "Landroid/content/Intent;", "d", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "previewInitBean", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "hideSettingText", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "mediaFilter", "", "count", "Lkotlin/Function1;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "onResult", "k", "j", "i", "l", "a", "o", "<set-?>", "b", "Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "()Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "customize", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "c", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/ref/WeakReference;)V", "fromViewRef", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360732a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static QBaseAlbumCustomize customize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<ImageView> fromViewRef;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28975);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f360732a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Intent e(a aVar, Context context, Config config, PickerInitBean pickerInitBean, Class cls, Class cls2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            Config.Companion companion = Config.INSTANCE;
            config = new Config.a().a();
        }
        Config config2 = config;
        if ((i3 & 4) != 0) {
            PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
            pickerInitBean = new PickerInitBean.a().a();
        }
        PickerInitBean pickerInitBean2 = pickerInitBean;
        if ((i3 & 8) != 0) {
            cls = PickerCustomizationBase.class;
        }
        Class cls3 = cls;
        if ((i3 & 16) != 0) {
            cls2 = PreviewCustomizationBase.class;
        }
        return aVar.d(context, config2, pickerInitBean2, cls3, cls2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Intent g(a aVar, Context context, Config config, PreviewInitBean previewInitBean, Class cls, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            Config.Companion companion = Config.INSTANCE;
            config = new Config.a().a();
        }
        if ((i3 & 4) != 0) {
            PreviewInitBean.Companion companion2 = PreviewInitBean.INSTANCE;
            previewInitBean = new PreviewInitBean.a().a();
        }
        if ((i3 & 8) != 0) {
            cls = PreviewCustomizationBase.class;
        }
        return aVar.f(context, config, previewInitBean, cls);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            LocalMediaDataHub.INSTANCE.a().K();
        }
    }

    @NotNull
    public final QBaseAlbumCustomize b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QBaseAlbumCustomize) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QBaseAlbumCustomize qBaseAlbumCustomize = customize;
        if (qBaseAlbumCustomize != null) {
            return qBaseAlbumCustomize;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customize");
        return null;
    }

    @Nullable
    public final WeakReference<ImageView> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WeakReference) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return fromViewRef;
    }

    @NotNull
    public final Intent d(@NotNull Context context, @NotNull Config config, @NotNull PickerInitBean pickerInitBean, @NotNull Class<? extends PickerCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> pickerCustomize, @NotNull Class<? extends PreviewCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> previewCustomize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, this, context, config, pickerInitBean, pickerCustomize, previewCustomize);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pickerInitBean, "pickerInitBean");
        Intrinsics.checkNotNullParameter(pickerCustomize, "pickerCustomize");
        Intrinsics.checkNotNullParameter(previewCustomize, "previewCustomize");
        Intent b16 = QAlbumPickerFragment.INSTANCE.b(context, pickerInitBean);
        b16.putExtra("ARG_ALBUM_CONFIG", config);
        b16.putExtra("ARG_PICKER_CUSTOMIZE", pickerCustomize);
        b16.putExtra("ARG_PREVIEW_CUSTOMIZE", previewCustomize);
        b16.putExtra("IS_JUMP_TO_PREVIEW", false);
        return b16;
    }

    @NotNull
    public final Intent f(@NotNull Context context, @NotNull Config config, @NotNull PreviewInitBean previewInitBean, @NotNull Class<? extends PreviewCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> previewCustomize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, this, context, config, previewInitBean, previewCustomize);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(previewInitBean, "previewInitBean");
        Intrinsics.checkNotNullParameter(previewCustomize, "previewCustomize");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) WinkHomeActivity.class));
        intent.putExtra("ARG_ALBUM_CONFIG", config);
        intent.putExtra("ARG_PREVIEW_INIT_BEAN", previewInitBean);
        intent.putExtra("ARG_PREVIEW_CUSTOMIZE", previewCustomize);
        intent.putExtra("IS_JUMP_TO_PREVIEW", true);
        return intent;
    }

    public final void h(@NotNull Context context, boolean initUrlDrawable, @NotNull QBaseAlbumCustomize params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(initUrlDrawable), params);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.qbasealbum.inject.a.f361230a.b(context);
        customize = params;
        if (initUrlDrawable) {
            com.tencent.qqnt.qbasealbum.urldrawable.h.a(context);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            LocalMediaDataHub.INSTANCE.a().f0();
        }
    }

    @NotNull
    public final List<LocalMediaInfo> j(@NotNull MediaFilter mediaFilter, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) mediaFilter, count);
        }
        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
        return LocalMediaDataHub.INSTANCE.a().h0(count, mediaFilter);
    }

    public final void k(@NotNull MediaFilter mediaFilter, int count, @NotNull Function1<? super List<LocalMediaInfo>, Unit> onResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, mediaFilter, Integer.valueOf(count), onResult);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        LocalMediaDataHub.INSTANCE.a().g0(count, mediaFilter, onResult);
    }

    public final void l() {
        Part part;
        QAlbumPickerTabFragment D9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QAlbumBaseMainFragment<?> l3 = QAlbumPickerContext.f361201a.l();
        if (!(l3 instanceof QAlbumPickerFragment)) {
            return;
        }
        PartManager partManager = ((QAlbumPickerFragment) l3).getPartManager();
        Part part2 = null;
        if (partManager != null) {
            part = partManager.getPart(PickerMediaViewPagerPart.class.getName());
        } else {
            part = null;
        }
        if (!(part instanceof PickerMediaViewPagerPart) || (D9 = ((PickerMediaViewPagerPart) part).D9(0)) == null) {
            return;
        }
        PartManager partManager2 = D9.getPartManager();
        if (partManager2 != null) {
            part2 = partManager2.getPart(PickerMediaListPart.class.getName());
        }
        if (!(part2 instanceof PickerMediaListPart)) {
            return;
        }
        ((PickerMediaListPart) part2).refresh();
    }

    public final void m(@Nullable WeakReference<ImageView> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) weakReference);
        } else {
            fromViewRef = weakReference;
        }
    }

    public final void n(@NotNull Activity activity, boolean hideSettingText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, Boolean.valueOf(hideSettingText));
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ((IAlbumApi) QRoute.api(IAlbumApi.class)).startQAlbumModeFragment(activity, hideSettingText);
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            LocalMediaDataHub.INSTANCE.a().p0();
        }
    }
}
